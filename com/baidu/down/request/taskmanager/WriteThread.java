package com.baidu.down.request.taskmanager;

import android.content.ContentValues;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.down.common.DownDetail;
import com.baidu.down.common.TaskMsg;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.down.utils.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes15.dex */
public class WriteThread implements Runnable {
    private static final boolean DEBUG = false;
    public static final int MAX_DOWNLOAD_QUENE_COUNT = 1000;
    public static final int MAX_DOWNLOAD_WRITE_PROGRESS = 1500;
    private static final String TAG = "WriteThread";
    private BlockingQueue<ByteArrayInfo> mQueue = new ArrayBlockingQueue(1000);
    private HashMap<String, RandomAccessFile> mHashMap = new HashMap<>();
    private TaskMsg mTaskmsg = null;

    private void tryToCreateDownloadFile(AbstractTask abstractTask) throws Exception {
        if (this.mHashMap.get(abstractTask.getTaskKey()) == null) {
            abstractTask.mTaskSpeedStat.startWriteTimeMillis = SystemClock.elapsedRealtime();
            this.mHashMap.put(abstractTask.getTaskKey(), getRandomAccessFile(abstractTask));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6] */
    @Override // java.lang.Runnable
    public void run() {
        BinaryTaskMng binaryTaskMng;
        this.mTaskmsg = new TaskMsg();
        while (TaskFacade.getInstance(null) != null && (binaryTaskMng = TaskFacade.getInstance(null).getBinaryTaskMng()) != null) {
            ByteArrayInfo take = this.mQueue.take();
            AbstractTask taskByKey = binaryTaskMng.getTaskByKey(take.mkey);
            if (taskByKey == null || taskByKey.mStatus == 1006 || taskByKey.mStatus == 1004 || taskByKey.mStatus == 1008 || taskByKey.mStatus == 1005) {
                binaryTaskMng.getByteArrayInfoMng().recycle(take);
            } else {
                try {
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
                        if (wrirteToFile(take, taskByKey)) {
                            TaskFacade.getInstance(null).getBinaryTaskMng().getWriteThreadMng().closeDownloadFileStream(take.mkey);
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
                            long j = elapsedRealtime - taskByKey.mLastNotifyTime;
                            if ((j >= 500 || taskByKey.mLastNotifySpeed <= 0) && j > 0) {
                                this.mTaskmsg.transferedSpeed = ((this.mTaskmsg.transferedSize - taskByKey.mLastNotifyBytes) * 1000) / j;
                                if (this.mTaskmsg.transferedSpeed < 0) {
                                    this.mTaskmsg.transferedSpeed = 0L;
                                }
                                taskByKey.mLastNotifyBytes = this.mTaskmsg.transferedSize;
                                taskByKey.mLastNotifyTime = elapsedRealtime;
                                taskByKey.mLastNotifySpeed = this.mTaskmsg.transferedSpeed;
                            } else {
                                this.mTaskmsg.transferedSpeed = taskByKey.mLastNotifySpeed;
                            }
                            this.mTaskmsg.status = 1002;
                            binaryTaskMng.notifyUi(this.mTaskmsg);
                        }
                    } finally {
                        binaryTaskMng.getByteArrayInfoMng().recycle(take);
                    }
                } catch (Exception e) {
                    if (taskByKey.mStatus == 1004 || taskByKey.mStatus == 1006) {
                        binaryTaskMng.getByteArrayInfoMng().recycle(take);
                    } else {
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
                        if ((e instanceof IOException) || (e instanceof FileNotFoundException)) {
                            if (e.getMessage() == null || !e.getMessage().contains("No space left on device")) {
                                taskMsg3.failType = 3;
                            } else {
                                taskMsg3.failType = 2;
                            }
                        }
                        TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().cancelRequests(taskByKey.myContext, true, taskByKey.mTaskHandler);
                        TaskFacade.getInstance(null).getBinaryTaskMng().notifyUi(taskMsg3);
                        TaskFacade.getInstance(null).getBinaryTaskMng().notifyMngTaskStatus(taskByKey.mUri, taskByKey.mDownloadId);
                        if (taskByKey.needWriteDb) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("status", Integer.valueOf(taskByKey.mStatus));
                            contentValues.put(DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, Long.valueOf(taskByKey.mProgressInfo.getCurrentLength()));
                            TaskFacade.getInstance(null).getBinaryTaskMng().getDatabaseMng().update(contentValues, "_id=?", new String[]{String.valueOf(taskByKey.mDownloadId)});
                        }
                    }
                }
            }
        }
    }

    public void put(ByteArrayInfo byteArrayInfo) {
        try {
            this.mQueue.put(byteArrayInfo);
        } catch (InterruptedException e) {
        }
    }

    public int getQueueSize() {
        return this.mQueue.size();
    }

    private boolean wrirteToFile(ByteArrayInfo byteArrayInfo, AbstractTask abstractTask) throws IOException {
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

    private RandomAccessFile getRandomAccessFile(AbstractTask abstractTask) throws Exception {
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
        abstractTask.mFile = new File(abstractTask.mFilePath);
        abstractTask.mFilename = abstractTask.mFile.getName();
        return new RandomAccessFile(abstractTask.mFilePath, "rw");
    }

    public void closeOutputFile(String str) throws Exception {
        RandomAccessFile remove = this.mHashMap.remove(str);
        if (remove != null) {
            remove.close();
        }
    }
}
