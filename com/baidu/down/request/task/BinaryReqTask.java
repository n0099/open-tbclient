package com.baidu.down.request.task;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.down.common.DownDetail;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.TaskMsg;
import com.baidu.down.loopj.android.http.BinaryHttpResponseHandler;
import com.baidu.down.loopj.android.http.ConnectManager;
import com.baidu.down.loopj.android.http.MultiSrcBinaryTaskHandler;
import com.baidu.down.loopj.android.http.MultiSrcRequestParams;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.down.request.taskmanager.ByteArrayInfo;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.down.retry.HttpRetryStrategyHandler;
import com.baidu.down.statistic.TaskSpeedStat;
import com.baidu.down.utils.Constants;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.URLRegUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidubce.http.Headers;
import java.io.File;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes6.dex */
public class BinaryReqTask extends AbstractTask {
    private static final boolean DEBUG = false;
    private static final String TAG = "BinaryReqTask";

    public BinaryReqTask(Context context, FileMsg fileMsg) {
        super(1);
        this.mContext = context;
        this.myContext = new ContextWrapper(context);
        this.mUri = fileMsg.mUrl;
        this.mFileDir = fileMsg.mSavePath;
        this.mFilename = fileMsg.mFileName;
        this.mMimetype = fileMsg.mMimetype;
        this.mETag = fileMsg.mETag;
        this.needWriteDb = fileMsg.mNeedWriteDb;
        this.mNeedMuti = fileMsg.mNeedMuti.booleanValue();
        this.mKeepNameAndPath = fileMsg.mKeepNameAndPath;
        this.mMaxThread = fileMsg.mMaxThread;
        if (this.mNeedMuti && this.mMaxThread < 2) {
            this.mNeedMuti = false;
        }
        this.mMaxTestIpCount = Math.max(Math.min(DownPrefUtils.getInt(context, DownPrefUtils.PREF_CONFIG_TEST_SPEED_IP_NUM, 2), this.mMaxThread), 1);
        if (this.mMaxTestIpCount < 1) {
            this.mMaxTestIpCount = 1;
        }
        this.mTotalLength = fileMsg.mTotalSize;
        this.mSid = fileMsg.mSid;
        this.mDownInfoParams = fileMsg.mDownInfoParams;
        this.mDownloadType = fileMsg.mDownloadType;
        this.mFromParam = fileMsg.mFromParam;
        this.mTj = fileMsg.mTj;
        this.mSize = fileMsg.mSize;
        this.mSizeB = sizeSToL(fileMsg.mSize);
        if (this.mNeedMuti) {
            if (fileMsg.mCurFilePos > 0 && TextUtils.isEmpty(fileMsg.mProgressStr)) {
                this.mProgressInfo = new ProgressInfo();
                this.mProgressInfo.addSegment(0L, fileMsg.mTotalSize);
                this.mProgressInfo.updateProgress(0L, fileMsg.mCurFilePos);
            } else {
                this.mProgressInfo = new ProgressInfo(fileMsg.mProgressStr);
                if (TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getNetWorkType() != ConnectManager.NetWorkType.TYPE_2G && (this instanceof MultiSrcBinaryReqTask)) {
                    this.mProgressInfo.balanceSegment(this.mMaxThread, minSegLen);
                }
            }
        } else {
            this.mProgressInfo = new ProgressInfo(fileMsg.mProgressStr);
            if (fileMsg.mCurFilePos > 0 && this.mProgressInfo.getSegmentCount() == 0) {
                this.mProgressInfo.addSegment(0L, fileMsg.mTotalSize);
                this.mProgressInfo.updateProgress(0L, fileMsg.mCurFilePos);
            }
        }
        if (this.mProgressInfo.getCurrentLength() > 0) {
            this.mFilePath = this.mFileDir + File.separator + this.mFilename;
            this.mCurLength = this.mProgressInfo.getCurrentLength();
        } else {
            this.mCurLength = 0L;
        }
        if (fileMsg.mNeedWriteDb && fileMsg.mId < 0) {
            this.mDownloadId = TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().insertToDatabase(this.mUri, this.mFilename, this.mFileDir, 1);
        } else {
            this.mDownloadId = fileMsg.mId;
        }
        if (this.needWriteDb) {
            updateFromDatabase();
        }
        this.mTaskHandler = new BinaryTaskHandler();
        this.mTaskHandler.setCurTask(this);
        this.mHttpRetryStrategyHandler = new HttpRetryStrategyHandler(this.mContext, this);
        this.mTaskSpeedStat = new TaskSpeedStat();
        this.mTaskSpeedStat.did = fileMsg.mId;
        this.mTaskSpeedStat.docid = "";
        this.mHeaders = new HashMap<>();
        this.mHeaders.putAll(fileMsg.mHeaders);
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public void start() {
        this.mStartTime = SystemClock.elapsedRealtime();
        if (this.mStatus != 1001) {
            this.mLengthRec = false;
            if (this.mTotalLength != 0 && this.mTotalLength == this.mProgressInfo.getCurrentLength() && !TextUtils.isEmpty(this.mFilePath) && new File(this.mFilePath).exists()) {
                this.mStatus = 1008;
                TaskMsg taskMsg = new TaskMsg();
                taskMsg._id = this.mDownloadId;
                taskMsg.uKey = this.mUri + this.mDownloadId;
                taskMsg.status = 1008;
                TaskFacade.getInstance(null).getBinaryTaskMng().notifyUi(taskMsg);
                TaskFacade.getInstance(null).getBinaryTaskMng().notifyMngTaskStatus(this.mUri, this.mDownloadId);
                return;
            }
            if (this.mProgressInfo.getCurrentLength() > 0 && !TextUtils.isEmpty(this.mFilePath) && !new File(this.mFilePath).exists()) {
                this.mProgressInfo = new ProgressInfo();
                this.mStrRedownload = "file deleted and redownload";
            }
            this.mLastNotifyTime = SystemClock.elapsedRealtime();
            this.mLastNotifyBytes = this.mProgressInfo.getCurrentLength();
            this.mLastNotifySpeed = 0L;
            this.mStatus = 1001;
            this.mTaskHandler.cleanDomainNameAndIpInfo();
            this.mTaskSpeedStat.initThreadSpeedStat(TaskFacade.getInstance(null).getBinaryTaskMng().getDownConfig().speedStatEnable() && URLRegUtils.matchRetryHostReg(this.mUri));
            if (this.mNeedMuti) {
                long j = DownPrefUtils.getLong(this.mContext, DownPrefUtils.PREF_CONFIG_TEST_SPEED_THRESHOLD, Constants.TEST_SPEED_THRESHOLD_DEFAULT) * 1024;
                this.mThreadCount = 0;
                ConnectManager.NetWorkType netWorkType = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getNetWorkType();
                if (this.mProgressInfo.getSegmentCount() > 0) {
                    if (this.mTotalLength - this.mProgressInfo.getCurrentLength() < j && (this.mTaskHandler instanceof MultiSrcBinaryTaskHandler)) {
                        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setNeedMultiSrc(false);
                        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.dbtype = 1;
                    }
                    if ((this.mTaskHandler instanceof MultiSrcBinaryTaskHandler) && netWorkType != ConnectManager.NetWorkType.TYPE_2G && ((MultiSrcBinaryTaskHandler) this.mTaskHandler).isNeedMultiSrc() && this.mProgressInfo.leftSegmentIsNeedMultiSrc(this.mMaxThread, minSegLen)) {
                        MultiSrcBinaryTaskHandler multiSrcBinaryTaskHandler = (MultiSrcBinaryTaskHandler) this.mTaskHandler;
                        if (multiSrcBinaryTaskHandler.isNeedTestSpeed()) {
                            BinaryHttpResponseHandler binaryHttpResponseHandler = this.mTaskHandler;
                            multiSrcBinaryTaskHandler.setTestSpeedStage(1);
                        }
                        for (ProgressInfo.Segment segment : this.mProgressInfo.getSegments()) {
                            if (segment.current < segment.end) {
                                if (multiSrcBinaryTaskHandler.isNeedTestSpeed()) {
                                    startSegment(segment.current, segment.end, 1);
                                } else {
                                    startSegment(segment.current, segment.end, 2);
                                }
                            }
                        }
                    } else {
                        for (ProgressInfo.Segment segment2 : this.mProgressInfo.getSegments()) {
                            if (segment2.current < segment2.end) {
                                startSegment(segment2.current, segment2.end, 0);
                                if (netWorkType == ConnectManager.NetWorkType.TYPE_2G) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    if (this.mSizeB < j && (this.mTaskHandler instanceof MultiSrcBinaryTaskHandler)) {
                        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setNeedMultiSrc(false);
                        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.dbtype = 1;
                    }
                    if ((this.mTaskHandler instanceof MultiSrcBinaryTaskHandler) && netWorkType != ConnectManager.NetWorkType.TYPE_2G && ((MultiSrcBinaryTaskHandler) this.mTaskHandler).isNeedMultiSrc()) {
                        if (((MultiSrcBinaryTaskHandler) this.mTaskHandler).isNeedTestSpeed()) {
                            startSegment(0L, minSegLen, 1);
                        } else {
                            startSegment(0L, minSegLen, 2);
                        }
                    } else {
                        startSegment(0L, minSegLen, 0);
                    }
                }
            } else {
                startSegment(this.mProgressInfo.getCurrentLength(), -1L, 0);
            }
            TaskMsg taskMsg2 = new TaskMsg();
            taskMsg2._id = this.mDownloadId;
            taskMsg2.uKey = getTaskKey();
            taskMsg2.transferedSize = this.mProgressInfo.getCurrentLength();
            taskMsg2.fileSize = this.mTaskHandler.getFileLength();
            taskMsg2.status = 1000;
            TaskFacade.getInstance(null).getBinaryTaskMng().notifyUi(taskMsg2);
        }
    }

    public void startSegment(long j, long j2, int i) {
        String noMeasuredUrl;
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.mHeaders);
        if (!TextUtils.isEmpty(this.mETag)) {
            hashMap.put("If-Match", this.mETag);
        }
        if (j2 > 0) {
            if (TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().isWap() && j2 > (j + BdStatsConstant.MAX_WRITTING_FILE_SIZE_AFTER_RENAME_FAILED) - 1) {
                j2 = (j + BdStatsConstant.MAX_WRITTING_FILE_SIZE_AFTER_RENAME_FAILED) - 1;
            }
            hashMap.put(Headers.RANGE, "bytes=" + j + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + (j2 - 1));
        } else if (TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().isWap()) {
            hashMap.put(Headers.RANGE, "bytes=" + j + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((BdStatsConstant.MAX_WRITTING_FILE_SIZE_AFTER_RENAME_FAILED + j) - 1));
        } else {
            hashMap.put(Headers.RANGE, "bytes=" + j + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.mTaskHandler.setRunning();
        if ((this.mTaskHandler instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) this.mTaskHandler).isNeedMultiSrc() && i != 0 && !TextUtils.isEmpty(this.mHost)) {
            hashMap.put("Host", this.mHost);
        }
        MultiSrcRequestParams multiSrcRequestParams = new MultiSrcRequestParams();
        multiSrcRequestParams.mSegBeginPos = j;
        multiSrcRequestParams.mSegEndPos = j2;
        if (i == 2) {
            TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().get(this.myContext, getFastestUrl(), hashMap, null, this.mTaskHandler, multiSrcRequestParams);
        } else if (i == 1) {
            if (this.mTaskHandler.getTestSpeedStage() == 0) {
                noMeasuredUrl = getNoMeasuredUrl(false);
            } else {
                noMeasuredUrl = getNoMeasuredUrl(true);
            }
            if (noMeasuredUrl != null) {
                TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().get(this.myContext, noMeasuredUrl, hashMap, null, this.mTaskHandler, multiSrcRequestParams);
            }
        } else {
            TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().get(this.myContext, getDefaultUrl(), hashMap, null, this.mTaskHandler, multiSrcRequestParams);
        }
        this.mThreadCount++;
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public void pause() {
        if (this.mStatus != 1006) {
            this.mStatus = 1006;
            TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().cancelRequests(this.myContext, true, this.mTaskHandler);
            TaskFacade.getInstance(null).getBinaryTaskMng().notifyMngTaskStatus(this.mUri, this.mDownloadId);
            TaskMsg taskMsg = new TaskMsg();
            taskMsg._id = this.mDownloadId;
            taskMsg.uKey = getTaskKey();
            taskMsg.filePath = this.mFilePath;
            taskMsg.transferedSize = this.mProgressInfo.getCurrentLength();
            taskMsg.fileSize = this.mTaskHandler.getFileLength();
            taskMsg.status = 1006;
            TaskFacade.getInstance(null).getBinaryTaskMng().notifyUi(taskMsg);
        }
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public void stop(boolean z) {
        if (this.mStatus != 1004) {
            this.mStatus = 1004;
            TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().cancelRequests(this.myContext, true, this.mTaskHandler);
            TaskFacade.getInstance(null).getBinaryTaskMng().notifyMngTaskStatus(this.mUri, this.mDownloadId);
            TaskFacade.getInstance(null).getBinaryTaskMng().getWriteThreadMng().closeDownloadFileStream(getTaskKey());
            if (z) {
                if (this.mFile == null) {
                    this.mFile = new File(this.mFilePath);
                }
                if (this.mFile.exists()) {
                    this.mFile.delete();
                }
            }
            if (this.needWriteDb) {
                TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().delete("_id=?", new String[]{String.valueOf(this.mDownloadId)});
            }
        }
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public void pend() {
        this.mStatus = 1009;
        TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().cancelRequests(this.myContext, true, this.mTaskHandler);
        TaskFacade.getInstance(null).getBinaryTaskMng().notifyMngTaskStatus(this.mUri, this.mDownloadId);
        TaskFacade.getInstance(null).getBinaryTaskMng().getWriteThreadMng().closeDownloadFileStream(getTaskKey());
        TaskMsg taskMsg = new TaskMsg();
        taskMsg._id = this.mDownloadId;
        taskMsg.uKey = getTaskKey();
        taskMsg.status = 1009;
        TaskFacade.getInstance(null).getBinaryTaskMng().notifyUi(taskMsg);
        if (this.needWriteDb) {
        }
    }

    private void updateFromDatabase() {
        Cursor query = TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().query(null, "_id=?", new String[]{String.valueOf(this.mDownloadId)}, null, null, null);
        if (query != null) {
            query.moveToFirst();
            if (TextUtils.isEmpty(query.getString(query.getColumnIndex("data")))) {
                query.close();
                return;
            }
            this.mTaskType = query.getInt(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE));
            this.mStatus = query.getInt(query.getColumnIndex("status"));
            this.mUri = query.getString(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_URI));
            this.mFilename = query.getString(query.getColumnIndex("name"));
            this.mFileDir = query.getString(query.getColumnIndex("path"));
            this.mFilePath = query.getString(query.getColumnIndex("data"));
            this.mMimetype = query.getString(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_MIME_TYPE));
            this.mETag = query.getString(query.getColumnIndex("etag"));
            long j = query.getLong(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES));
            this.mProgressInfo = new ProgressInfo();
            if (new File(this.mFilePath).exists()) {
                this.mProgressInfo.addSegment(0L, this.mTotalLength);
                this.mProgressInfo.updateProgress(0L, j);
                this.mTotalLength = query.getLong(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES));
            }
            query.close();
        }
    }

    /* loaded from: classes6.dex */
    public class BinaryTaskHandler extends BinaryHttpResponseHandler {
        public BinaryTaskHandler() {
        }

        @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
        public void onStart() {
        }

        @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
        public void onSuccess(byte[] bArr, long j) {
            if (!BinaryReqTask.this.mNeedMuti || BinaryReqTask.this.mThreadCount <= 1) {
                if (BinaryReqTask.this.mThreadCount == 1 && j > 0) {
                    BinaryReqTask.this.mThreadCount = 0;
                    for (ProgressInfo.Segment segment : BinaryReqTask.this.mProgressInfo.getSegments()) {
                        if (segment.current != segment.end && (segment.begin >= j || segment.end < j)) {
                            BinaryReqTask.this.startSegment(segment.current, segment.end, 0);
                            return;
                        }
                    }
                    return;
                }
                BinaryReqTask.this.mStatus = 1003;
                TaskMsg taskMsg = new TaskMsg();
                taskMsg._id = BinaryReqTask.this.mDownloadId;
                taskMsg.uKey = BinaryReqTask.this.getTaskKey();
                taskMsg.filePath = BinaryReqTask.this.mFilePath;
                taskMsg.fileSize = BinaryReqTask.this.mTotalLength;
                taskMsg.transferedSize = BinaryReqTask.this.mTotalLength;
                if (BinaryReqTask.this.mTaskmsg != null) {
                    taskMsg.transferedSpeed = (BinaryReqTask.this.mTaskmsg.transferedSize * 1000) / (System.currentTimeMillis() - BinaryReqTask.this.mStartTime);
                }
                taskMsg.status = 1003;
                TaskFacade.getInstance(null).getBinaryTaskMng().notifyUi(taskMsg);
                TaskFacade.getInstance(null).getBinaryTaskMng().notifyMngTaskStatus(BinaryReqTask.this.mUri, BinaryReqTask.this.mDownloadId);
            }
        }

        @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
        public synchronized void onFailure(Throwable th, int i) {
            if (BinaryReqTask.this.mStatus != 1006 && BinaryReqTask.this.mStatus != 1004 && BinaryReqTask.this.mStatus != 1005) {
                BinaryReqTask.this.mStatus = 1005;
                TaskMsg taskMsg = new TaskMsg();
                taskMsg._id = BinaryReqTask.this.mDownloadId;
                taskMsg.uKey = BinaryReqTask.this.getTaskKey();
                taskMsg.filePath = BinaryReqTask.this.mFilePath;
                taskMsg.fileSize = getFileLength();
                taskMsg.transferedSize = BinaryReqTask.this.mProgressInfo.getCurrentLength();
                taskMsg.errorStr = th.toString();
                taskMsg.status = 1005;
                taskMsg.failType = i;
                DownDetail downDetail = new DownDetail();
                downDetail.domainNameAndIpInfo = BinaryReqTask.this.mTaskHandler.getDomainNameAndIpInfo();
                downDetail.retryStrategyInfo = HttpRetryStatistic.buidTaskRetryStatistic(BinaryReqTask.this.mHttpRetryStrategyHandler.getDownDetail(), BinaryReqTask.this.mHttpRetryStrategyHandler.getDownFlowMode(), BinaryReqTask.this.mHttpRetryStrategyHandler.getDownFlowCostTime(), BinaryReqTask.this.mHttpRetryStrategyHandler.getRetryExceptionName(), BinaryReqTask.this.mHttpRetryStrategyHandler.getRequestId());
                downDetail.retryType = BinaryReqTask.this.mHttpRetryStrategyHandler.getRetryType();
                downDetail.retryException = BinaryReqTask.this.mHttpRetryStrategyHandler.getRetryExceptionName();
                taskMsg.downDetail = downDetail;
                TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().cancelRequests(BinaryReqTask.this.myContext, true, BinaryReqTask.this.mTaskHandler);
                TaskFacade.getInstance(null).getBinaryTaskMng().getWriteThreadMng().closeDownloadFileStream(taskMsg.uKey);
                TaskFacade.getInstance(null).getBinaryTaskMng().notifyUi(taskMsg);
                TaskFacade.getInstance(null).getBinaryTaskMng().notifyMngTaskStatus(BinaryReqTask.this.mUri, BinaryReqTask.this.mDownloadId);
                if (BinaryReqTask.this.needWriteDb) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("status", Integer.valueOf(BinaryReqTask.this.mStatus));
                    contentValues.put(DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, Long.valueOf(BinaryReqTask.this.mProgressInfo.getCurrentLength()));
                    TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().update(contentValues, "_id=?", new String[]{String.valueOf(BinaryReqTask.this.mDownloadId)});
                }
            }
        }

        @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
        public void onFileLengthRec(long j, String str) {
            if (!BinaryReqTask.this.mLengthRec) {
                BinaryReqTask.this.mLengthRec = true;
                BinaryReqTask.this.mBNotifyStart = true;
                BinaryReqTask.this.mTotalLength = j;
                BinaryReqTask.this.mETag = str;
                BinaryReqTask.this.mStatus = 1001;
                if (!this.mSupportRange) {
                    BinaryReqTask.this.mProgressInfo = new ProgressInfo();
                }
                if (BinaryReqTask.this.mProgressInfo.getSegmentCount() <= 0) {
                    if (BinaryReqTask.this.mNeedMuti && this.mSupportRange) {
                        if (BinaryReqTask.this.mTotalLength <= AbstractTask.minSegLen || this.mTrunked) {
                            BinaryReqTask.this.mProgressInfo.addSegment(0L, BinaryReqTask.this.mTotalLength);
                            if ((BinaryReqTask.this.mTaskHandler instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) BinaryReqTask.this.mTaskHandler).isNeedMultiSrc()) {
                                ((MultiSrcBinaryTaskHandler) BinaryReqTask.this.mTaskHandler).updateStatCstatus(5);
                            }
                        } else {
                            if (BinaryReqTask.this.mTotalLength < DownPrefUtils.getLong(BinaryReqTask.this.mContext, DownPrefUtils.PREF_CONFIG_TEST_SPEED_THRESHOLD, Constants.TEST_SPEED_THRESHOLD_DEFAULT) * 1024 && (BinaryReqTask.this.mTaskHandler instanceof MultiSrcBinaryTaskHandler)) {
                                ((MultiSrcBinaryTaskHandler) BinaryReqTask.this.mTaskHandler).setNeedMultiSrc(false);
                                ((MultiSrcBinaryTaskHandler) BinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dbtype = 1;
                            }
                            if ((BinaryReqTask.this.mTaskHandler instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) BinaryReqTask.this.mTaskHandler).isNeedMultiSrc() && ((MultiSrcBinaryTaskHandler) BinaryReqTask.this.mTaskHandler).isNeedTestSpeed()) {
                                BinaryReqTask.this.mTaskHandler.setTestSpeedStage(1);
                            }
                            BinaryReqTask.this.mProgressInfo.addSegment(0L, AbstractTask.minSegLen);
                            long j2 = (BinaryReqTask.this.mTotalLength - AbstractTask.minSegLen) / BinaryReqTask.this.mMaxThread;
                            if (j2 < AbstractTask.minSegLen) {
                                j2 = AbstractTask.minSegLen;
                            }
                            long j3 = (((j2 + AbstractTask.bufferSize) - 1) / AbstractTask.bufferSize) * AbstractTask.bufferSize;
                            ConnectManager.NetWorkType netWorkType = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getNetWorkType();
                            long j4 = AbstractTask.minSegLen;
                            while (j4 < BinaryReqTask.this.mTotalLength) {
                                long j5 = j4 + j3;
                                if (j5 > BinaryReqTask.this.mTotalLength) {
                                    j5 = BinaryReqTask.this.mTotalLength;
                                }
                                BinaryReqTask.this.mProgressInfo.addSegment(j4, j5);
                                if (netWorkType != ConnectManager.NetWorkType.TYPE_2G) {
                                    if ((BinaryReqTask.this.mTaskHandler instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) BinaryReqTask.this.mTaskHandler).isNeedMultiSrc()) {
                                        if (((MultiSrcBinaryTaskHandler) BinaryReqTask.this.mTaskHandler).isNeedTestSpeed()) {
                                            BinaryReqTask.this.startSegment(j4, j5, 1);
                                        } else {
                                            BinaryReqTask.this.startSegment(j4, j5, 2);
                                        }
                                    } else {
                                        BinaryReqTask.this.startSegment(j4, j5, 0);
                                    }
                                }
                                j4 = j5;
                            }
                        }
                    } else {
                        BinaryReqTask.this.mProgressInfo.addSegment(0L, BinaryReqTask.this.mTotalLength);
                    }
                    if (BinaryReqTask.this.needWriteDb) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("status", Integer.valueOf(BinaryReqTask.this.mStatus));
                        if (BinaryReqTask.this.mTotalLength <= 0) {
                            contentValues.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, Long.valueOf(j));
                        }
                        TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().update(contentValues, "_id=?", new String[]{String.valueOf(BinaryReqTask.this.mDownloadId)});
                    }
                }
            }
        }

        @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
        public void onDownload(ByteArrayInfo byteArrayInfo) {
            if (BinaryReqTask.this.mStatus == 1006 || BinaryReqTask.this.mStatus == 1004 || BinaryReqTask.this.mStatus == 1009) {
                TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().recycle(byteArrayInfo);
                return;
            }
            byteArrayInfo.mkey = BinaryReqTask.this.getTaskKey();
            TaskFacade.getInstance(null).getBinaryTaskMng().getWriteThreadMng().loadBalanceToWrite(byteArrayInfo);
        }

        @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
        public void onPaused(int i) {
            if (BinaryReqTask.this.mStatus != 1003 && BinaryReqTask.this.mStatus != 1008) {
                if (BinaryReqTask.this.mStatus == 1006) {
                    TaskFacade.getInstance(null).getBinaryTaskMng().getWriteThreadMng().closeDownloadFileStream(BinaryReqTask.this.getTaskKey());
                }
                if (BinaryReqTask.this.needWriteDb) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("status", Integer.valueOf(BinaryReqTask.this.mStatus));
                    contentValues.put(DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, Long.valueOf(BinaryReqTask.this.mProgressInfo.getCurrentLength()));
                    TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().update(contentValues, "_id=?", new String[]{String.valueOf(BinaryReqTask.this.mDownloadId)});
                }
            }
        }
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public String getFastestUrl() {
        return getDefaultUrl();
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public String getNoMeasuredUrl(boolean z) {
        return getDefaultUrl();
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public String getDefaultUrl() {
        return this.mUri;
    }

    private long sizeSToL(String str) {
        long j = 0;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains("m")) {
                String[] split = lowerCase.replace("m", "").split("\\.");
                if (split != null && split.length > 0) {
                    j = Long.parseLong(split[0]) * 1024 * 1024;
                }
                if (split != null && split.length > 1 && !TextUtils.isEmpty(split[1].substring(0, 1))) {
                    return j + (Long.parseLong(split[1].substring(0, 1)) * 1024);
                }
                return j;
            } else if (!lowerCase.contains("g")) {
                return 0L;
            } else {
                return IjkMediaMeta.AV_CH_STEREO_RIGHT;
            }
        } catch (Exception e) {
            return 0L;
        }
    }
}
