package com.baidu.down.request.taskmanager;

import android.content.ContentValues;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.common.DownDetail;
import com.baidu.down.common.TaskMsg;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes4.dex */
public class WriteThread implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int MAX_DOWNLOAD_QUENE_COUNT = 1000;
    public static final int MAX_DOWNLOAD_WRITE_PROGRESS = 1500;
    public static final String TAG = "WriteThread";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, RandomAccessFile> mHashMap;
    public BlockingQueue<ByteArrayInfo> mQueue;
    public TaskMsg mTaskmsg;

    public WriteThread() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mQueue = new ArrayBlockingQueue(1000);
        this.mHashMap = new HashMap<>();
        this.mTaskmsg = null;
    }

    private RandomAccessFile getRandomAccessFile(AbstractTask abstractTask) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, abstractTask)) == null) {
            File file = new File(abstractTask.mFileDir);
            if (!file.exists()) {
                file.mkdir();
            }
            if (TextUtils.isEmpty(abstractTask.mFilePath)) {
                if (abstractTask.mKeepNameAndPath) {
                    abstractTask.mFilePath = abstractTask.mFileDir + File.separator + abstractTask.mFilename;
                } else {
                    abstractTask.mFilePath = Utils.chooseUniqueFilename(abstractTask.mFileDir + File.separator + Utils.chooseFilename(abstractTask.mUri, abstractTask.mFilename, abstractTask.mMimetype), Utils.chooseExtension(abstractTask.mUri, abstractTask.mFilename, abstractTask.mMimetype));
                }
                if (abstractTask.needWriteDb) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("data", abstractTask.mFilePath);
                    TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().update(contentValues, "_id=?", new String[]{String.valueOf(abstractTask.mDownloadId)});
                }
            }
            File file2 = new File(abstractTask.mFilePath);
            abstractTask.mFile = file2;
            abstractTask.mFilename = file2.getName();
            return new RandomAccessFile(abstractTask.mFilePath, "rw");
        }
        return (RandomAccessFile) invokeL.objValue;
    }

    private void tryToCreateDownloadFile(AbstractTask abstractTask) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, abstractTask) == null) && this.mHashMap.get(abstractTask.getTaskKey()) == null) {
            abstractTask.mTaskSpeedStat.startWriteTimeMillis = SystemClock.elapsedRealtime();
            this.mHashMap.put(abstractTask.getTaskKey(), getRandomAccessFile(abstractTask));
        }
    }

    private boolean wrirteToFile(ByteArrayInfo byteArrayInfo, AbstractTask abstractTask) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, byteArrayInfo, abstractTask)) == null) {
            if (byteArrayInfo.mByteArrayLength > 0) {
                RandomAccessFile randomAccessFile = this.mHashMap.get(byteArrayInfo.mkey);
                if (randomAccessFile == null) {
                    return false;
                }
                randomAccessFile.seek(byteArrayInfo.mFilePos);
                randomAccessFile.write(byteArrayInfo.mByteArray, 0, byteArrayInfo.mByteArrayLength);
                abstractTask.mProgressInfo.updateProgress(byteArrayInfo.mFilePos, byteArrayInfo.mByteArrayLength);
                if (abstractTask.needWriteDb && System.currentTimeMillis() - abstractTask.mWriteFileLastTime > 1500) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, Long.valueOf(abstractTask.mProgressInfo.getCurrentLength()));
                    TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().update(contentValues, "_id=?", new String[]{String.valueOf(abstractTask.mDownloadId)});
                    abstractTask.mWriteFileLastTime = System.currentTimeMillis();
                }
                return abstractTask.mTaskHandler.mSupportRange && abstractTask.mProgressInfo.getCurrentLength() >= abstractTask.mTotalLength;
            } else if (abstractTask.mTotalLength == Long.MAX_VALUE) {
                abstractTask.mTotalLength = byteArrayInfo.mFilePos;
                return true;
            } else {
                abstractTask.mProgressInfo.checkSegEnd(byteArrayInfo.mFilePos);
                return !abstractTask.mTaskHandler.mSupportRange;
            }
        }
        return invokeLL.booleanValue;
    }

    public void closeOutputFile(String str) throws Exception {
        RandomAccessFile remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (remove = this.mHashMap.remove(str)) == null) {
            return;
        }
        remove.close();
    }

    public int getQueueSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mQueue.size() : invokeV.intValue;
    }

    public void put(ByteArrayInfo byteArrayInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteArrayInfo) == null) {
            try {
                this.mQueue.put(byteArrayInfo);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(11:41|42|43|(1:45)|94|52|53|54|55|57|58)(1:100)|(9:48|(1:50)|51|52|53|54|55|57|58)|54|55|57|58) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x021c, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x02b6, code lost:
        if ((r0 instanceof java.io.FileNotFoundException) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02cd, code lost:
        r3.failType = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0308, code lost:
        r0 = new android.content.ContentValues();
        r0.put("status", java.lang.Integer.valueOf(r5.mStatus));
        r0.put(com.baidu.down.request.db.DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, java.lang.Long.valueOf(r5.mProgressInfo.getCurrentLength()));
        com.baidu.down.request.taskmanager.TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().update(r0, "_id=?", new java.lang.String[]{java.lang.String.valueOf(r5.mDownloadId)});
     */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0349 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02b4 A[Catch: all -> 0x0346, TryCatch #5 {all -> 0x0346, blocks: (B:60:0x0217, B:66:0x0220, B:68:0x0226, B:71:0x022e, B:73:0x02b4, B:83:0x02d5, B:85:0x0308, B:77:0x02bb, B:79:0x02c1, B:81:0x02cd, B:82:0x02d1), top: B:108:0x0217 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0308 A[Catch: all -> 0x0346, TRY_LEAVE, TryCatch #5 {all -> 0x0346, blocks: (B:60:0x0217, B:66:0x0220, B:68:0x0226, B:71:0x022e, B:73:0x02b4, B:83:0x02d5, B:85:0x0308, B:77:0x02bb, B:79:0x02c1, B:81:0x02cd, B:82:0x02d1), top: B:108:0x0217 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        BinaryTaskMng binaryTaskMng;
        BinaryTaskMng binaryTaskMng2;
        ByteArrayInfo byteArrayInfo;
        BinaryTaskMng binaryTaskMng3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mTaskmsg = new TaskMsg();
            while (TaskFacade.getInstance(null) != null && (binaryTaskMng = TaskFacade.getInstance(null).getBinaryTaskMng()) != null) {
                try {
                    byteArrayInfo = this.mQueue.take();
                    try {
                        AbstractTask taskByKey = binaryTaskMng.getTaskByKey(byteArrayInfo.mkey);
                        if (taskByKey != null && taskByKey.mStatus != 1006 && taskByKey.mStatus != 1004 && taskByKey.mStatus != 1008 && taskByKey.mStatus != 1005) {
                            try {
                                tryToCreateDownloadFile(taskByKey);
                                if (taskByKey.mBNotifyStart) {
                                    taskByKey.mBNotifyStart = false;
                                    TaskMsg taskMsg = new TaskMsg();
                                    taskMsg._id = taskByKey.mDownloadId;
                                    taskMsg.uKey = taskByKey.mUri + taskByKey.mDownloadId;
                                    taskMsg.filePath = taskByKey.mFilePath;
                                    taskMsg.fileSize = taskByKey.mTotalLength;
                                    taskMsg.status = 1001;
                                    taskMsg.etag = taskByKey.mETag;
                                    taskMsg.supportRange = taskByKey.mTaskHandler.mSupportRange;
                                    if (taskByKey.mProgressInfo.getCurrentLength() > 0) {
                                        taskMsg.strRedownload = taskByKey.mStrRedownload;
                                    }
                                    DownDetail downDetail = new DownDetail();
                                    downDetail.domainNameAndIpInfo = taskByKey.mTaskHandler.getDomainNameAndIpInfo();
                                    taskMsg.downDetail = downDetail;
                                    TaskFacade.getInstance(null).getBinaryTaskMng().notifyUi(taskMsg);
                                }
                            } catch (Exception e2) {
                                e = e2;
                                binaryTaskMng2 = binaryTaskMng;
                            }
                            if (wrirteToFile(byteArrayInfo, taskByKey)) {
                                TaskFacade.getInstance(null).getBinaryTaskMng().getWriteThreadMng().closeDownloadFileStream(byteArrayInfo.mkey);
                                TaskMsg taskMsg2 = new TaskMsg();
                                taskByKey.mStatus = 1008;
                                taskMsg2._id = taskByKey.mDownloadId;
                                taskMsg2.uKey = taskByKey.mUri + taskByKey.mDownloadId;
                                taskMsg2.status = 1008;
                                taskMsg2.fileSize = taskByKey.mTotalLength;
                                taskMsg2.progressMap = taskByKey.mProgressInfo.toString();
                                taskMsg2.transferedSpeed = (taskMsg2.fileSize * 1000) / (SystemClock.elapsedRealtime() - taskByKey.mStartTime);
                                DownDetail downDetail2 = new DownDetail();
                                downDetail2.domainNameAndIpInfo = taskByKey.mTaskHandler.getDomainNameAndIpInfo();
                                downDetail2.retryStrategyInfo = HttpRetryStatistic.buidTaskRetryStatistic(taskByKey.mHttpRetryStrategyHandler.getDownDetail(), taskByKey.mHttpRetryStrategyHandler.getDownFlowMode(), taskByKey.mHttpRetryStrategyHandler.getDownFlowCostTime(), taskByKey.mHttpRetryStrategyHandler.getRetryExceptionName(), taskByKey.mHttpRetryStrategyHandler.getRequestId());
                                downDetail2.retryType = taskByKey.mHttpRetryStrategyHandler.getRetryType();
                                downDetail2.retryException = taskByKey.mHttpRetryStrategyHandler.getRetryExceptionName();
                                taskMsg2.downDetail = downDetail2;
                                binaryTaskMng.notifyUi(taskMsg2);
                                binaryTaskMng.notifyMngTaskStatus(taskByKey.mUri, taskByKey.mDownloadId);
                                binaryTaskMng.getHttpClient().cancelRequests(taskByKey.myContext, true, null);
                            } else if (taskByKey.mStatus != 1004 && taskByKey.mStatus != 1006) {
                                this.mTaskmsg._id = taskByKey.mDownloadId;
                                this.mTaskmsg.uKey = taskByKey.mUri + taskByKey.mDownloadId;
                                this.mTaskmsg.filePath = taskByKey.mFilePath;
                                this.mTaskmsg.fileSize = taskByKey.mTotalLength;
                                this.mTaskmsg.transferedSize = taskByKey.mProgressInfo.getCurrentLength();
                                this.mTaskmsg.progressMap = taskByKey.mProgressInfo.toString();
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                long j2 = elapsedRealtime - taskByKey.mLastNotifyTime;
                                try {
                                    if (j2 < 500) {
                                        binaryTaskMng3 = binaryTaskMng;
                                        try {
                                            if (taskByKey.mLastNotifySpeed <= 0) {
                                            }
                                            this.mTaskmsg.transferedSpeed = taskByKey.mLastNotifySpeed;
                                            this.mTaskmsg.status = 1002;
                                            this.mTaskmsg.url = taskByKey.getDefaultUrl();
                                            binaryTaskMng2 = binaryTaskMng3;
                                            binaryTaskMng2.notifyUi(this.mTaskmsg);
                                        } catch (Exception e3) {
                                            e = e3;
                                            binaryTaskMng2 = binaryTaskMng3;
                                            if (taskByKey.mStatus != 1004) {
                                                taskByKey.mStatus = 1005;
                                                TaskMsg taskMsg3 = new TaskMsg();
                                                taskMsg3._id = taskByKey.mDownloadId;
                                                taskMsg3.uKey = taskByKey.mUri + taskByKey.mDownloadId;
                                                taskMsg3.filePath = taskByKey.mFilePath;
                                                taskMsg3.fileSize = taskByKey.mTotalLength;
                                                taskMsg3.transferedSize = taskByKey.mProgressInfo.getCurrentLength();
                                                taskMsg3.errorStr = e.toString();
                                                taskMsg3.status = 1005;
                                                DownDetail downDetail3 = new DownDetail();
                                                downDetail3.domainNameAndIpInfo = taskByKey.mTaskHandler.getDomainNameAndIpInfo();
                                                downDetail3.retryStrategyInfo = HttpRetryStatistic.buidTaskRetryStatistic(taskByKey.mHttpRetryStrategyHandler.getDownDetail(), taskByKey.mHttpRetryStrategyHandler.getDownFlowMode(), taskByKey.mHttpRetryStrategyHandler.getDownFlowCostTime(), taskByKey.mHttpRetryStrategyHandler.getRetryExceptionName(), taskByKey.mHttpRetryStrategyHandler.getRequestId());
                                                downDetail3.retryType = taskByKey.mHttpRetryStrategyHandler.getRetryType();
                                                downDetail3.retryException = taskByKey.mHttpRetryStrategyHandler.getRetryExceptionName();
                                                taskMsg3.downDetail = downDetail3;
                                                taskByKey.setTaskmsg(taskMsg3);
                                                if (!(e instanceof IOException)) {
                                                }
                                                if (e.getMessage() != null) {
                                                }
                                                taskMsg3.failType = 3;
                                                TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().cancelRequests(taskByKey.myContext, true, taskByKey.mTaskHandler);
                                                TaskFacade.getInstance(null).getBinaryTaskMng().notifyUi(taskMsg3);
                                                TaskFacade.getInstance(null).getBinaryTaskMng().notifyMngTaskStatus(taskByKey.mUri, taskByKey.mDownloadId);
                                                if (taskByKey.needWriteDb) {
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            binaryTaskMng2 = binaryTaskMng3;
                                            try {
                                                th.printStackTrace();
                                                return;
                                            } finally {
                                                binaryTaskMng2.getByteArrayInfoMng().recycle(byteArrayInfo);
                                            }
                                        }
                                    } else {
                                        binaryTaskMng3 = binaryTaskMng;
                                    }
                                    if (j2 > 0) {
                                        this.mTaskmsg.transferedSpeed = ((this.mTaskmsg.transferedSize - taskByKey.mLastNotifyBytes) * 1000) / j2;
                                        if (this.mTaskmsg.transferedSpeed < 0) {
                                            this.mTaskmsg.transferedSpeed = 0L;
                                        }
                                        taskByKey.mLastNotifyBytes = this.mTaskmsg.transferedSize;
                                        taskByKey.mLastNotifyTime = elapsedRealtime;
                                        taskByKey.mLastNotifySpeed = this.mTaskmsg.transferedSpeed;
                                        this.mTaskmsg.status = 1002;
                                        this.mTaskmsg.url = taskByKey.getDefaultUrl();
                                        binaryTaskMng2 = binaryTaskMng3;
                                        binaryTaskMng2.notifyUi(this.mTaskmsg);
                                    }
                                    binaryTaskMng2.notifyUi(this.mTaskmsg);
                                } catch (Throwable th2) {
                                    th = th2;
                                    th.printStackTrace();
                                    return;
                                }
                                this.mTaskmsg.transferedSpeed = taskByKey.mLastNotifySpeed;
                                this.mTaskmsg.status = 1002;
                                this.mTaskmsg.url = taskByKey.getDefaultUrl();
                                binaryTaskMng2 = binaryTaskMng3;
                            }
                        }
                        binaryTaskMng2 = binaryTaskMng;
                    } catch (Throwable th3) {
                        th = th3;
                        binaryTaskMng2 = binaryTaskMng;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    binaryTaskMng2 = binaryTaskMng;
                    byteArrayInfo = null;
                }
            }
        }
    }
}
