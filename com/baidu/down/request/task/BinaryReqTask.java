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
import com.baidu.down.request.taskmanager.BinaryTaskMng;
import com.baidu.down.request.taskmanager.ByteArrayInfo;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.down.retry.HttpRetryStrategyHandler;
import com.baidu.down.statistic.TaskSpeedStat;
import com.baidu.down.utils.Constants;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.URLRegUtils;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.kwai.video.player.KsMediaMeta;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BinaryReqTask extends AbstractTask {
    public static final boolean DEBUG = false;
    public static final String TAG = "BinaryReqTask";

    /* loaded from: classes.dex */
    public class BinaryTaskHandler extends BinaryHttpResponseHandler {
        public BinaryTaskHandler() {
        }

        @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
        public void onDownload(ByteArrayInfo byteArrayInfo) {
            BinaryReqTask binaryReqTask = BinaryReqTask.this;
            int i = binaryReqTask.mStatus;
            if (i != 1006 && i != 1004 && i != 1009) {
                byteArrayInfo.mkey = binaryReqTask.getTaskKey();
                TaskFacade.getInstance(null).getBinaryTaskMng().getWriteThreadMng().loadBalanceToWrite(byteArrayInfo);
                return;
            }
            TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().recycle(byteArrayInfo);
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
            long j2;
            BinaryReqTask binaryReqTask = BinaryReqTask.this;
            if (binaryReqTask.mLengthRec) {
                return;
            }
            binaryReqTask.mLengthRec = true;
            binaryReqTask.mBNotifyStart = true;
            binaryReqTask.mTotalLength = j;
            binaryReqTask.mETag = str;
            binaryReqTask.mStatus = 1001;
            if (!this.mSupportRange) {
                binaryReqTask.mProgressInfo = new ProgressInfo();
            }
            if (BinaryReqTask.this.mProgressInfo.getSegmentCount() > 0) {
                return;
            }
            BinaryReqTask binaryReqTask2 = BinaryReqTask.this;
            if (binaryReqTask2.mNeedMuti && this.mSupportRange) {
                if (binaryReqTask2.mTotalLength > AbstractTask.minSegLen && !this.mTrunked) {
                    BinaryReqTask binaryReqTask3 = BinaryReqTask.this;
                    if (binaryReqTask3.mTotalLength < DownPrefUtils.getLong(binaryReqTask2.mContext, DownPrefUtils.PREF_CONFIG_TEST_SPEED_THRESHOLD, Constants.TEST_SPEED_THRESHOLD_DEFAULT) * 1024) {
                        BinaryHttpResponseHandler binaryHttpResponseHandler = binaryReqTask3.mTaskHandler;
                        if (binaryHttpResponseHandler instanceof MultiSrcBinaryTaskHandler) {
                            ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).setNeedMultiSrc(false);
                            ((MultiSrcBinaryTaskHandler) BinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dbtype = 1;
                        }
                    }
                    BinaryHttpResponseHandler binaryHttpResponseHandler2 = BinaryReqTask.this.mTaskHandler;
                    if ((binaryHttpResponseHandler2 instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler2).isNeedMultiSrc() && ((MultiSrcBinaryTaskHandler) BinaryReqTask.this.mTaskHandler).isNeedTestSpeed()) {
                        BinaryReqTask.this.mTaskHandler.setTestSpeedStage(1);
                    }
                    BinaryReqTask.this.mProgressInfo.addSegment(0L, AbstractTask.minSegLen);
                    BinaryReqTask binaryReqTask4 = BinaryReqTask.this;
                    long j3 = binaryReqTask4.mTotalLength;
                    long j4 = AbstractTask.minSegLen;
                    long j5 = (j3 - j4) / binaryReqTask4.mMaxThread;
                    if (j5 >= j4) {
                        j4 = j5;
                    }
                    int i = AbstractTask.bufferSize;
                    long j6 = (((j4 + i) - 1) / i) * i;
                    ConnectManager.NetWorkType netWorkType = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getNetWorkType();
                    long j7 = AbstractTask.minSegLen;
                    while (true) {
                        long j8 = BinaryReqTask.this.mTotalLength;
                        if (j7 >= j8) {
                            break;
                        }
                        long j9 = j7 + j6;
                        if (j9 <= j8) {
                            j8 = j9;
                        }
                        BinaryReqTask.this.mProgressInfo.addSegment(j7, j8);
                        if (netWorkType != ConnectManager.NetWorkType.TYPE_2G) {
                            BinaryHttpResponseHandler binaryHttpResponseHandler3 = BinaryReqTask.this.mTaskHandler;
                            if ((binaryHttpResponseHandler3 instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler3).isNeedMultiSrc()) {
                                if (((MultiSrcBinaryTaskHandler) BinaryReqTask.this.mTaskHandler).isNeedTestSpeed()) {
                                    j2 = j8;
                                    BinaryReqTask.this.startSegment(j7, j2, 1);
                                } else {
                                    j2 = j8;
                                    BinaryReqTask.this.startSegment(j7, j2, 2);
                                }
                            } else {
                                j2 = j8;
                                BinaryReqTask.this.startSegment(j7, j2, 0);
                            }
                        } else {
                            j2 = j8;
                        }
                        j7 = j2;
                    }
                } else {
                    BinaryReqTask binaryReqTask5 = BinaryReqTask.this;
                    binaryReqTask5.mProgressInfo.addSegment(0L, binaryReqTask5.mTotalLength);
                    BinaryHttpResponseHandler binaryHttpResponseHandler4 = BinaryReqTask.this.mTaskHandler;
                    if ((binaryHttpResponseHandler4 instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler4).isNeedMultiSrc()) {
                        ((MultiSrcBinaryTaskHandler) BinaryReqTask.this.mTaskHandler).updateStatCstatus(5);
                    }
                }
            } else {
                BinaryReqTask binaryReqTask6 = BinaryReqTask.this;
                binaryReqTask6.mProgressInfo.addSegment(0L, binaryReqTask6.mTotalLength);
            }
            if (BinaryReqTask.this.needWriteDb) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(BinaryReqTask.this.mStatus));
                if (BinaryReqTask.this.mTotalLength <= 0) {
                    contentValues.put("total_bytes", Long.valueOf(j));
                }
                TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().update(contentValues, "_id=?", new String[]{String.valueOf(BinaryReqTask.this.mDownloadId)});
            }
        }

        @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
        public void onPaused(int i) {
            int i2 = BinaryReqTask.this.mStatus;
            if (i2 == 1003 || i2 == 1008) {
                return;
            }
            if (i2 == 1006) {
                TaskFacade.getInstance(null).getBinaryTaskMng().getWriteThreadMng().closeDownloadFileStream(BinaryReqTask.this.getTaskKey());
            }
            if (BinaryReqTask.this.needWriteDb) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(BinaryReqTask.this.mStatus));
                contentValues.put(DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, Long.valueOf(BinaryReqTask.this.mProgressInfo.getCurrentLength()));
                TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().update(contentValues, "_id=?", new String[]{String.valueOf(BinaryReqTask.this.mDownloadId)});
            }
        }

        @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
        public void onStart() {
        }

        @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
        public void onSuccess(byte[] bArr, long j) {
            BinaryReqTask binaryReqTask = BinaryReqTask.this;
            if (!binaryReqTask.mNeedMuti || binaryReqTask.mThreadCount <= 1) {
                BinaryReqTask binaryReqTask2 = BinaryReqTask.this;
                if (binaryReqTask2.mThreadCount == 1 && j > 0) {
                    binaryReqTask2.mThreadCount = 0;
                    for (ProgressInfo.Segment segment : binaryReqTask2.mProgressInfo.getSegments()) {
                        long j2 = segment.current;
                        long j3 = segment.end;
                        if (j2 != j3 && (segment.begin >= j || j3 < j)) {
                            BinaryReqTask.this.startSegment(segment.current, segment.end, 0);
                            return;
                        }
                    }
                    return;
                }
                BinaryReqTask.this.mStatus = 1003;
                TaskMsg taskMsg = new TaskMsg();
                BinaryReqTask binaryReqTask3 = BinaryReqTask.this;
                taskMsg._id = binaryReqTask3.mDownloadId;
                taskMsg.uKey = binaryReqTask3.getTaskKey();
                BinaryReqTask binaryReqTask4 = BinaryReqTask.this;
                taskMsg.filePath = binaryReqTask4.mFilePath;
                long j4 = binaryReqTask4.mTotalLength;
                taskMsg.fileSize = j4;
                taskMsg.transferedSize = j4;
                TaskMsg taskMsg2 = binaryReqTask4.mTaskmsg;
                if (taskMsg2 != null) {
                    taskMsg.transferedSpeed = (taskMsg2.transferedSize * 1000) / (System.currentTimeMillis() - BinaryReqTask.this.mStartTime);
                }
                taskMsg.status = 1003;
                TaskFacade.getInstance(null).getBinaryTaskMng().notifyUi(taskMsg);
                BinaryTaskMng binaryTaskMng = TaskFacade.getInstance(null).getBinaryTaskMng();
                BinaryReqTask binaryReqTask5 = BinaryReqTask.this;
                binaryTaskMng.notifyMngTaskStatus(binaryReqTask5.mUri, binaryReqTask5.mDownloadId);
            }
        }
    }

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
        boolean booleanValue = fileMsg.mNeedMuti.booleanValue();
        this.mNeedMuti = booleanValue;
        this.mKeepNameAndPath = fileMsg.mKeepNameAndPath;
        int i = fileMsg.mMaxThread;
        this.mMaxThread = i;
        if (booleanValue && i < 2) {
            this.mNeedMuti = false;
        }
        int max = Math.max(Math.min(DownPrefUtils.getInt(context, DownPrefUtils.PREF_CONFIG_TEST_SPEED_IP_NUM, 2), this.mMaxThread), 1);
        this.mMaxTestIpCount = max;
        if (max < 1) {
            this.mMaxTestIpCount = 1;
        }
        this.mTotalLength = fileMsg.mTotalSize;
        this.mSid = fileMsg.mSid;
        this.mDownInfoParams = fileMsg.mDownInfoParams;
        this.mDownloadType = fileMsg.mDownloadType;
        this.mFromParam = fileMsg.mFromParam;
        this.mTj = fileMsg.mTj;
        String str = fileMsg.mSize;
        this.mSize = str;
        this.mSizeB = sizeSToL(str);
        if (this.mNeedMuti) {
            if (fileMsg.mCurFilePos > 0 && TextUtils.isEmpty(fileMsg.mProgressStr)) {
                ProgressInfo progressInfo = new ProgressInfo();
                this.mProgressInfo = progressInfo;
                progressInfo.addSegment(0L, fileMsg.mTotalSize);
                this.mProgressInfo.updateProgress(0L, fileMsg.mCurFilePos);
            } else {
                this.mProgressInfo = new ProgressInfo(fileMsg.mProgressStr);
                if (TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getNetWorkType() != ConnectManager.NetWorkType.TYPE_2G && (this instanceof MultiSrcBinaryReqTask)) {
                    this.mProgressInfo.balanceSegment(this.mMaxThread, AbstractTask.minSegLen);
                }
            }
        } else {
            ProgressInfo progressInfo2 = new ProgressInfo(fileMsg.mProgressStr);
            this.mProgressInfo = progressInfo2;
            if (fileMsg.mCurFilePos > 0 && progressInfo2.getSegmentCount() == 0) {
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
        BinaryTaskHandler binaryTaskHandler = new BinaryTaskHandler();
        this.mTaskHandler = binaryTaskHandler;
        binaryTaskHandler.setCurTask(this);
        this.mHttpRetryStrategyHandler = new HttpRetryStrategyHandler(this.mContext, this);
        TaskSpeedStat taskSpeedStat = new TaskSpeedStat();
        this.mTaskSpeedStat = taskSpeedStat;
        taskSpeedStat.did = fileMsg.mId;
        taskSpeedStat.docid = "";
        HashMap<String, String> hashMap = new HashMap<>();
        this.mHeaders = hashMap;
        hashMap.putAll(fileMsg.mHeaders);
    }

    private long sizeSToL(String str) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("m")) {
            String[] split = lowerCase.replace("m", "").split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            if (split != null && split.length > 0) {
                j = Long.parseLong(split[0]) * 1024 * 1024;
            }
            if (split == null || split.length <= 1 || TextUtils.isEmpty(split[1].substring(0, 1))) {
                return j;
            }
            long parseLong = Long.parseLong(split[1].substring(0, 1));
            Long.signum(parseLong);
            return j + (parseLong * 1024);
        } else if (lowerCase.contains("g")) {
            return KsMediaMeta.AV_CH_STEREO_RIGHT;
        } else {
            return 0L;
        }
    }

    private void updateFromDatabase() {
        Cursor query = TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().query(null, "_id=?", new String[]{String.valueOf(this.mDownloadId)}, null, null, null);
        if (query == null) {
            return;
        }
        query.moveToFirst();
        if (TextUtils.isEmpty(query.getString(query.getColumnIndex("data")))) {
            query.close();
            return;
        }
        this.mTaskType = query.getInt(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE));
        this.mStatus = query.getInt(query.getColumnIndex("status"));
        this.mUri = query.getString(query.getColumnIndex("uri"));
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
            this.mTotalLength = query.getLong(query.getColumnIndex("total_bytes"));
        }
        query.close();
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public String getDefaultUrl() {
        return this.mUri;
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
    public void pause() {
        if (this.mStatus == 1006) {
            return;
        }
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
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public void start() {
        this.mStartTime = SystemClock.elapsedRealtime();
        if (this.mStatus == 1001) {
            return;
        }
        this.mLengthRec = false;
        long j = this.mTotalLength;
        if (j != 0 && j == this.mProgressInfo.getCurrentLength() && !TextUtils.isEmpty(this.mFilePath) && new File(this.mFilePath).exists()) {
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
            long j2 = DownPrefUtils.getLong(this.mContext, DownPrefUtils.PREF_CONFIG_TEST_SPEED_THRESHOLD, Constants.TEST_SPEED_THRESHOLD_DEFAULT) * 1024;
            this.mThreadCount = 0;
            ConnectManager.NetWorkType netWorkType = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getNetWorkType();
            if (this.mProgressInfo.getSegmentCount() > 0) {
                if (this.mTotalLength - this.mProgressInfo.getCurrentLength() < j2) {
                    BinaryHttpResponseHandler binaryHttpResponseHandler = this.mTaskHandler;
                    if (binaryHttpResponseHandler instanceof MultiSrcBinaryTaskHandler) {
                        ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).setNeedMultiSrc(false);
                        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.dbtype = 1;
                    }
                }
                BinaryHttpResponseHandler binaryHttpResponseHandler2 = this.mTaskHandler;
                if ((binaryHttpResponseHandler2 instanceof MultiSrcBinaryTaskHandler) && netWorkType != ConnectManager.NetWorkType.TYPE_2G && ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler2).isNeedMultiSrc() && this.mProgressInfo.leftSegmentIsNeedMultiSrc(this.mMaxThread, AbstractTask.minSegLen)) {
                    MultiSrcBinaryTaskHandler multiSrcBinaryTaskHandler = (MultiSrcBinaryTaskHandler) this.mTaskHandler;
                    if (multiSrcBinaryTaskHandler.isNeedTestSpeed()) {
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
                        long j3 = segment2.current;
                        long j4 = segment2.end;
                        if (j3 < j4) {
                            startSegment(j3, j4, 0);
                            if (netWorkType == ConnectManager.NetWorkType.TYPE_2G) {
                                break;
                            }
                        }
                    }
                }
            } else {
                if (this.mSizeB < j2) {
                    BinaryHttpResponseHandler binaryHttpResponseHandler3 = this.mTaskHandler;
                    if (binaryHttpResponseHandler3 instanceof MultiSrcBinaryTaskHandler) {
                        ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler3).setNeedMultiSrc(false);
                        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.dbtype = 1;
                    }
                }
                BinaryHttpResponseHandler binaryHttpResponseHandler4 = this.mTaskHandler;
                if ((binaryHttpResponseHandler4 instanceof MultiSrcBinaryTaskHandler) && netWorkType != ConnectManager.NetWorkType.TYPE_2G && ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler4).isNeedMultiSrc()) {
                    if (((MultiSrcBinaryTaskHandler) this.mTaskHandler).isNeedTestSpeed()) {
                        startSegment(0L, AbstractTask.minSegLen, 1);
                    } else {
                        startSegment(0L, AbstractTask.minSegLen, 2);
                    }
                } else {
                    startSegment(0L, AbstractTask.minSegLen, 0);
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

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0048, code lost:
        if (r19 <= r5) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startSegment(long j, long j2, int i) {
        long j3;
        String noMeasuredUrl;
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.mHeaders);
        if (!TextUtils.isEmpty(this.mETag)) {
            hashMap.put(Util.IF_MATCH, this.mETag);
        }
        if (j2 > 0) {
            if (TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().isWap()) {
                j3 = (j + 307200) - 1;
            }
            j3 = j2;
            hashMap.put("Range", "bytes=" + j + "-" + (j3 - 1));
        } else {
            if (TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().isWap()) {
                hashMap.put("Range", "bytes=" + j + "-" + ((j + 307200) - 1));
            } else {
                hashMap.put("Range", "bytes=" + j + "-");
            }
            j3 = j2;
        }
        this.mTaskHandler.setRunning();
        BinaryHttpResponseHandler binaryHttpResponseHandler = this.mTaskHandler;
        if ((binaryHttpResponseHandler instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).isNeedMultiSrc() && i != 0 && !TextUtils.isEmpty(this.mHost)) {
            hashMap.put("Host", this.mHost);
        }
        MultiSrcRequestParams multiSrcRequestParams = new MultiSrcRequestParams();
        multiSrcRequestParams.mSegBeginPos = j;
        multiSrcRequestParams.mSegEndPos = j3;
        if (i == 2) {
            TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().get(this.myContext, getFastestUrl(), hashMap, null, this.mTaskHandler, multiSrcRequestParams);
        } else if (i == 1) {
            if (this.mTaskHandler.getTestSpeedStage() == 0) {
                noMeasuredUrl = getNoMeasuredUrl(false);
            } else {
                noMeasuredUrl = getNoMeasuredUrl(true);
            }
            String str = noMeasuredUrl;
            if (str != null) {
                TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().get(this.myContext, str, hashMap, null, this.mTaskHandler, multiSrcRequestParams);
            }
        } else {
            TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().get(this.myContext, getDefaultUrl(), hashMap, null, this.mTaskHandler, multiSrcRequestParams);
        }
        this.mThreadCount++;
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public void stop(boolean z) {
        if (this.mStatus == 1004) {
            return;
        }
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
