package com.baidu.down.request.task;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.URLRegUtils;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class BinaryReqTask extends AbstractTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "BinaryReqTask";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class BinaryTaskHandler extends BinaryHttpResponseHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BinaryReqTask this$0;

        public BinaryTaskHandler(BinaryReqTask binaryReqTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {binaryReqTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = binaryReqTask;
        }

        @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
        public void handleRedirectUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.this$0.mRealUrl = str;
            }
        }

        @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
        public void onDownload(ByteArrayInfo byteArrayInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteArrayInfo) == null) {
                BinaryReqTask binaryReqTask = this.this$0;
                int i2 = binaryReqTask.mStatus;
                if (i2 != 1006 && i2 != 1004 && i2 != 1009) {
                    byteArrayInfo.mkey = binaryReqTask.getTaskKey();
                    TaskFacade.getInstance(null).getBinaryTaskMng().getWriteThreadMng().loadBalanceToWrite(byteArrayInfo);
                    return;
                }
                TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().recycle(byteArrayInfo);
            }
        }

        @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
        public synchronized void onFailure(Throwable th, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, th, i2) == null) {
                synchronized (this) {
                    if (this.this$0.mStatus != 1006 && this.this$0.mStatus != 1004 && this.this$0.mStatus != 1005) {
                        this.this$0.mStatus = 1005;
                        TaskMsg taskMsg = new TaskMsg();
                        taskMsg._id = this.this$0.mDownloadId;
                        taskMsg.uKey = this.this$0.getTaskKey();
                        taskMsg.filePath = this.this$0.mFilePath;
                        taskMsg.fileSize = getFileLength();
                        taskMsg.transferedSize = this.this$0.mProgressInfo.getCurrentLength();
                        taskMsg.errorStr = th.toString();
                        taskMsg.status = 1005;
                        taskMsg.failType = i2;
                        DownDetail downDetail = new DownDetail();
                        downDetail.domainNameAndIpInfo = this.this$0.mTaskHandler.getDomainNameAndIpInfo();
                        downDetail.retryStrategyInfo = HttpRetryStatistic.buidTaskRetryStatistic(this.this$0.mHttpRetryStrategyHandler.getDownDetail(), this.this$0.mHttpRetryStrategyHandler.getDownFlowMode(), this.this$0.mHttpRetryStrategyHandler.getDownFlowCostTime(), this.this$0.mHttpRetryStrategyHandler.getRetryExceptionName(), this.this$0.mHttpRetryStrategyHandler.getRequestId());
                        downDetail.retryType = this.this$0.mHttpRetryStrategyHandler.getRetryType();
                        downDetail.retryException = this.this$0.mHttpRetryStrategyHandler.getRetryExceptionName();
                        taskMsg.downDetail = downDetail;
                        TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().cancelRequests(this.this$0.myContext, true, this.this$0.mTaskHandler);
                        TaskFacade.getInstance(null).getBinaryTaskMng().getWriteThreadMng().closeDownloadFileStream(taskMsg.uKey);
                        TaskFacade.getInstance(null).getBinaryTaskMng().notifyUi(taskMsg);
                        TaskFacade.getInstance(null).getBinaryTaskMng().notifyMngTaskStatus(this.this$0.mUri, this.this$0.mDownloadId);
                        if (this.this$0.needWriteDb) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("status", Integer.valueOf(this.this$0.mStatus));
                            contentValues.put(DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, Long.valueOf(this.this$0.mProgressInfo.getCurrentLength()));
                            TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().update(contentValues, "_id=?", new String[]{String.valueOf(this.this$0.mDownloadId)});
                        }
                    }
                }
            }
        }

        @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
        public void onFileLengthRec(long j2, String str) {
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048579, this, j2, str) == null) {
                BinaryReqTask binaryReqTask = this.this$0;
                if (binaryReqTask.mLengthRec) {
                    return;
                }
                binaryReqTask.mLengthRec = true;
                binaryReqTask.mBNotifyStart = true;
                binaryReqTask.mTotalLength = j2;
                binaryReqTask.mETag = str;
                binaryReqTask.mStatus = 1001;
                if (!this.mSupportRange) {
                    binaryReqTask.mProgressInfo = new ProgressInfo();
                }
                if (this.this$0.mProgressInfo.getSegmentCount() > 0) {
                    return;
                }
                BinaryReqTask binaryReqTask2 = this.this$0;
                if (binaryReqTask2.mNeedMuti && this.mSupportRange) {
                    if (binaryReqTask2.mTotalLength > AbstractTask.minSegLen && !this.mTrunked) {
                        BinaryReqTask binaryReqTask3 = this.this$0;
                        if (binaryReqTask3.mTotalLength < DownPrefUtils.getLong(binaryReqTask2.mContext, DownPrefUtils.PREF_CONFIG_TEST_SPEED_THRESHOLD, com.baidu.down.utils.Constants.TEST_SPEED_THRESHOLD_DEFAULT) * 1024) {
                            BinaryHttpResponseHandler binaryHttpResponseHandler = binaryReqTask3.mTaskHandler;
                            if (binaryHttpResponseHandler instanceof MultiSrcBinaryTaskHandler) {
                                ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).setNeedMultiSrc(false);
                                ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).mMultiSrcStatData.dbtype = 1;
                            }
                        }
                        BinaryHttpResponseHandler binaryHttpResponseHandler2 = this.this$0.mTaskHandler;
                        if ((binaryHttpResponseHandler2 instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler2).isNeedMultiSrc() && ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).isNeedTestSpeed()) {
                            this.this$0.mTaskHandler.setTestSpeedStage(1);
                        }
                        this.this$0.mProgressInfo.addSegment(0L, AbstractTask.minSegLen);
                        BinaryReqTask binaryReqTask4 = this.this$0;
                        long j4 = binaryReqTask4.mTotalLength;
                        long j5 = AbstractTask.minSegLen;
                        long j6 = (j4 - j5) / binaryReqTask4.mMaxThread;
                        if (j6 >= j5) {
                            j5 = j6;
                        }
                        int i2 = AbstractTask.bufferSize;
                        long j7 = (((j5 + i2) - 1) / i2) * i2;
                        ConnectManager.NetWorkType netWorkType = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getNetWorkType();
                        long j8 = AbstractTask.minSegLen;
                        while (true) {
                            long j9 = this.this$0.mTotalLength;
                            if (j8 >= j9) {
                                break;
                            }
                            long j10 = j8 + j7;
                            if (j10 <= j9) {
                                j9 = j10;
                            }
                            this.this$0.mProgressInfo.addSegment(j8, j9);
                            if (netWorkType != ConnectManager.NetWorkType.TYPE_2G) {
                                BinaryHttpResponseHandler binaryHttpResponseHandler3 = this.this$0.mTaskHandler;
                                if ((binaryHttpResponseHandler3 instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler3).isNeedMultiSrc()) {
                                    if (((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).isNeedTestSpeed()) {
                                        j3 = j9;
                                        this.this$0.startSegment(j8, j3, 1);
                                    } else {
                                        j3 = j9;
                                        this.this$0.startSegment(j8, j3, 2);
                                    }
                                } else {
                                    j3 = j9;
                                    this.this$0.startSegment(j8, j3, 0);
                                }
                            } else {
                                j3 = j9;
                            }
                            j8 = j3;
                        }
                    } else {
                        BinaryReqTask binaryReqTask5 = this.this$0;
                        binaryReqTask5.mProgressInfo.addSegment(0L, binaryReqTask5.mTotalLength);
                        BinaryHttpResponseHandler binaryHttpResponseHandler4 = this.this$0.mTaskHandler;
                        if ((binaryHttpResponseHandler4 instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler4).isNeedMultiSrc()) {
                            ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).updateStatCstatus(5);
                        }
                    }
                } else {
                    BinaryReqTask binaryReqTask6 = this.this$0;
                    binaryReqTask6.mProgressInfo.addSegment(0L, binaryReqTask6.mTotalLength);
                }
                if (this.this$0.needWriteDb) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("status", Integer.valueOf(this.this$0.mStatus));
                    if (this.this$0.mTotalLength <= 0) {
                        contentValues.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, Long.valueOf(j2));
                    }
                    TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().update(contentValues, "_id=?", new String[]{String.valueOf(this.this$0.mDownloadId)});
                }
            }
        }

        @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
        public void onPaused(int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (i3 = this.this$0.mStatus) == 1003 || i3 == 1008) {
                return;
            }
            if (i3 == 1006) {
                TaskFacade.getInstance(null).getBinaryTaskMng().getWriteThreadMng().closeDownloadFileStream(this.this$0.getTaskKey());
            }
            if (this.this$0.needWriteDb) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(this.this$0.mStatus));
                contentValues.put(DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, Long.valueOf(this.this$0.mProgressInfo.getCurrentLength()));
                TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().update(contentValues, "_id=?", new String[]{String.valueOf(this.this$0.mDownloadId)});
            }
        }

        @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
        public void onSuccess(byte[] bArr, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048582, this, bArr, j2) == null) {
                BinaryReqTask binaryReqTask = this.this$0;
                if (!binaryReqTask.mNeedMuti || binaryReqTask.mThreadCount <= 1) {
                    BinaryReqTask binaryReqTask2 = this.this$0;
                    if (binaryReqTask2.mThreadCount == 1 && j2 > 0) {
                        binaryReqTask2.mThreadCount = 0;
                        for (ProgressInfo.Segment segment : binaryReqTask2.mProgressInfo.getSegments()) {
                            long j3 = segment.current;
                            long j4 = segment.end;
                            if (j3 != j4 && (segment.begin >= j2 || j4 < j2)) {
                                this.this$0.startSegment(segment.current, segment.end, 0);
                                return;
                            }
                        }
                        return;
                    }
                    this.this$0.mStatus = 1003;
                    TaskMsg taskMsg = new TaskMsg();
                    BinaryReqTask binaryReqTask3 = this.this$0;
                    taskMsg._id = binaryReqTask3.mDownloadId;
                    taskMsg.uKey = binaryReqTask3.getTaskKey();
                    BinaryReqTask binaryReqTask4 = this.this$0;
                    taskMsg.filePath = binaryReqTask4.mFilePath;
                    long j5 = binaryReqTask4.mTotalLength;
                    taskMsg.fileSize = j5;
                    taskMsg.transferedSize = j5;
                    TaskMsg taskMsg2 = binaryReqTask4.mTaskmsg;
                    if (taskMsg2 != null) {
                        taskMsg.transferedSpeed = (taskMsg2.transferedSize * 1000) / (System.currentTimeMillis() - this.this$0.mStartTime);
                    }
                    taskMsg.status = 1003;
                    TaskFacade.getInstance(null).getBinaryTaskMng().notifyUi(taskMsg);
                    BinaryTaskMng binaryTaskMng = TaskFacade.getInstance(null).getBinaryTaskMng();
                    BinaryReqTask binaryReqTask5 = this.this$0;
                    binaryTaskMng.notifyMngTaskStatus(binaryReqTask5.mUri, binaryReqTask5.mDownloadId);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinaryReqTask(Context context, FileMsg fileMsg) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fileMsg};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        this.mRealUrl = fileMsg.mRealUrl;
        int i4 = fileMsg.mMaxThread;
        this.mMaxThread = i4;
        if (booleanValue && i4 < 2) {
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
        BinaryTaskHandler binaryTaskHandler = new BinaryTaskHandler(this);
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            long j2 = 0;
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            String lowerCase = str.toLowerCase();
            if (!lowerCase.contains("m")) {
                return lowerCase.contains("g") ? 1073741824L : 0L;
            }
            String[] split = lowerCase.replace("m", "").split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            if (split != null && split.length > 0) {
                j2 = Long.parseLong(split[0]) * 1024 * 1024;
            }
            if (split == null || split.length <= 1 || TextUtils.isEmpty(split[1].substring(0, 1))) {
                return j2;
            }
            long parseLong = Long.parseLong(split[1].substring(0, 1));
            Long.signum(parseLong);
            return j2 + (parseLong * 1024);
        }
        return invokeL.longValue;
    }

    private void updateFromDatabase() {
        Cursor query;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (query = TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().query(null, "_id=?", new String[]{String.valueOf(this.mDownloadId)}, null, null, null)) == null) {
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
        long j2 = query.getLong(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES));
        this.mProgressInfo = new ProgressInfo();
        if (new File(this.mFilePath).exists()) {
            this.mProgressInfo.addSegment(0L, this.mTotalLength);
            this.mProgressInfo.updateProgress(0L, j2);
            this.mTotalLength = query.getLong(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES));
        }
        query.close();
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public String getDefaultUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.mRealUrl)) {
                return this.mRealUrl;
            }
            return this.mUri;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public String getFastestUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getDefaultUrl() : (String) invokeV.objValue;
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public String getNoMeasuredUrl(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) ? getDefaultUrl() : (String) invokeZ.objValue;
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.mStatus == 1006) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mStartTime = SystemClock.elapsedRealtime();
            if (this.mStatus == 1001) {
                return;
            }
            this.mLengthRec = false;
            long j2 = this.mTotalLength;
            if (j2 != 0 && j2 == this.mProgressInfo.getCurrentLength() && !TextUtils.isEmpty(this.mFilePath) && new File(this.mFilePath).exists()) {
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
                long j3 = DownPrefUtils.getLong(this.mContext, DownPrefUtils.PREF_CONFIG_TEST_SPEED_THRESHOLD, com.baidu.down.utils.Constants.TEST_SPEED_THRESHOLD_DEFAULT) * 1024;
                this.mThreadCount = 0;
                ConnectManager.NetWorkType netWorkType = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getNetWorkType();
                if (this.mProgressInfo.getSegmentCount() > 0) {
                    if (this.mTotalLength - this.mProgressInfo.getCurrentLength() < j3) {
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
                            long j4 = segment2.current;
                            long j5 = segment2.end;
                            if (j4 < j5) {
                                startSegment(j4, j5, 0);
                                if (netWorkType == ConnectManager.NetWorkType.TYPE_2G) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    if (this.mSizeB < j3) {
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
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
        if (r19 <= r5) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startSegment(long j2, long j3, int i2) {
        long j4;
        String noMeasuredUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.mHeaders);
            if (!TextUtils.isEmpty(this.mETag)) {
                hashMap.put(Util.IF_MATCH, this.mETag);
            }
            if (j3 > 0) {
                if (TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().isWap()) {
                    j4 = (j2 + 307200) - 1;
                }
                j4 = j3;
                hashMap.put("Range", "bytes=" + j2 + "-" + (j4 - 1));
            } else {
                if (TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().isWap()) {
                    hashMap.put("Range", "bytes=" + j2 + "-" + ((j2 + 307200) - 1));
                } else {
                    hashMap.put("Range", "bytes=" + j2 + "-");
                }
                j4 = j3;
            }
            this.mTaskHandler.setRunning();
            BinaryHttpResponseHandler binaryHttpResponseHandler = this.mTaskHandler;
            if ((binaryHttpResponseHandler instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).isNeedMultiSrc() && i2 != 0 && !TextUtils.isEmpty(this.mHost)) {
                hashMap.put("Host", this.mHost);
            }
            MultiSrcRequestParams multiSrcRequestParams = new MultiSrcRequestParams();
            multiSrcRequestParams.mSegBeginPos = j2;
            multiSrcRequestParams.mSegEndPos = j4;
            if (i2 == 2) {
                TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().get(this.myContext, getFastestUrl(), hashMap, null, this.mTaskHandler, multiSrcRequestParams);
            } else if (i2 == 1) {
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
    }

    @Override // com.baidu.down.request.task.AbstractTask
    public void stop(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.mStatus == 1004) {
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
