package com.baidu.down.request.taskmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.down.common.DownConstants;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.StatisticInfo;
import com.baidu.down.common.TaskManagerConfiguration;
import com.baidu.down.common.TaskMsg;
import com.baidu.down.common.TaskObserverInterface;
import com.baidu.down.common.intercepter.InterceptResult;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.down.loopj.android.http.ConnectManager;
import com.baidu.down.loopj.android.request.handler.HttpDns;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.down.request.task.BinaryReqTask;
import com.baidu.down.request.task.MultiSrcBinaryReqTask;
import com.baidu.down.statistic.SpeedStatData;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.PatternConfig;
import com.baidu.down.utils.URLRegUtils;
import com.baidu.down.utils.network.NetWorkDetector;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class BinaryTaskMng {
    private static final boolean DEBUG = false;
    private static final String TAG = "BinaryTaskMng";
    private static final int TASK_ADD_ALLTASK_2_Q = 4;
    private static final int TASK_ADD_TASK_2_Q = 3;
    private static final int TASK_CHECK_APN_CHG = 2;
    private static final int TASK_CHECK_MEMORY = 1;
    private static final int TASK_CHECK_MSG = 0;
    private static final int TASK_CHECK_NET_DELATY = 2500;
    private static final int TASK_CHECK_TIME = 5000;
    private static final int TASK_CHECK_TIME_MOMORY = 30000;
    private static final int TASK_INTERRUPT_RETRY_WAITING = 5;
    public static final int THREAD_REQUEST_ADD_MSG = 6;
    public static final int THREAD_REQUEST_CANCEL_MSG = 7;
    public static final int THREAD_REQUEST_UPDATE_MSG = 8;
    public static boolean mAllowRequestConfig = false;
    private ConcurrentHashMap<String, AbstractTask> mAllTaskMap;
    private ByteArrayInfoMng mByteArrayInfoMng;
    private AsyncHttpClient mClient;
    private BroadcastReceiver mConnectivityReceiver;
    Context mContext;
    private List<AbstractTask> mCurTaskList;
    private DatabaseMng mDbmng;
    private Handler mHandler;
    private CopyOnWriteArrayList mInfoTypeList;
    private Looper mLooper;
    private int mMaxThread;
    private List<TaskObserverInterface> mObserverList;
    private Map<Long, StatisticInfo> mStatsticMap;
    private PriorityQueue<AbstractTask> mTaskPriorityQueue;
    private WriteThreadMng mWriteThreadMng;
    HandlerThread mThr = null;
    private PowerManager.WakeLock mWakelock = null;
    private HttpDNSCacheInfo mHttpDNSCacheInfo = null;
    private DownConfig mDownConfig = new DownConfig();
    private PatternConfig mPatternConfig = new PatternConfig();

    private void startTaskMng() {
        this.mThr = new HandlerThread("DownloadLooperThread", 10);
        this.mThr.start();
        this.mHandler = new Handler(this.mThr.getLooper()) { // from class: com.baidu.down.request.taskmanager.BinaryTaskMng.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    if (message.what == 0) {
                        BinaryTaskMng.this.priorityRunning();
                    } else if (message.what == 1) {
                        if (BinaryTaskMng.this.mCurTaskList.size() == 0 && BinaryTaskMng.this.mTaskPriorityQueue.size() == 0) {
                            BinaryTaskMng.this.mByteArrayInfoMng.recycleByteArray();
                        }
                    } else if (message.what == 2) {
                        ConnectManager.NetWorkType netWorkType = BinaryTaskMng.this.mClient.getNetWorkType();
                        BinaryTaskMng.this.mClient.switchProxy();
                        ConnectManager.NetWorkType netWorkType2 = BinaryTaskMng.this.mClient.getNetWorkType();
                        if (netWorkType == ConnectManager.NetWorkType.TYPE_UNKNOWN && netWorkType2 != ConnectManager.NetWorkType.TYPE_UNKNOWN && BinaryTaskMng.this.mCurTaskList.size() > 0) {
                            BinaryTaskMng.this.mHandler.removeMessages(5);
                            BinaryTaskMng.this.mHandler.sendEmptyMessageDelayed(5, 2000L);
                        } else if (netWorkType2 == ConnectManager.NetWorkType.TYPE_UNKNOWN) {
                            BinaryTaskMng.this.mHandler.removeMessages(5);
                        }
                        BinaryTaskMng.this.mHttpDNSCacheInfo = null;
                        BinaryTaskMng.this.handleAPNChangeIntercept();
                    } else if (message.what == 3) {
                        AbstractTask abstractTask = (AbstractTask) message.obj;
                        if (abstractTask.mStatus == 1009) {
                            BinaryTaskMng.this.mTaskPriorityQueue.offer(abstractTask);
                            BinaryTaskMng.this.priorityRunning();
                        }
                    } else if (message.what == 4) {
                        for (AbstractTask abstractTask2 : BinaryTaskMng.this.mAllTaskMap.values()) {
                            if (abstractTask2.mStatus != 1009) {
                                abstractTask2.mStatus = 1009;
                                BinaryTaskMng.this.mTaskPriorityQueue.add(abstractTask2);
                            }
                        }
                        BinaryTaskMng.this.priorityRunning();
                    } else if (message.what == 5) {
                        for (AbstractTask abstractTask3 : BinaryTaskMng.this.mCurTaskList) {
                            BinaryTaskMng.this.mClient.interruptRetryWaiting(abstractTask3.myContext);
                        }
                    } else if (message.what == 6) {
                        ((MultiSrcTaskMsg) message.obj).addAsyncRequest();
                    } else if (message.what == 7) {
                        ((MultiSrcTaskMsg) message.obj).cancelAsyncRequest();
                    } else if (message.what == 8) {
                        ((MultiSrcTaskMsg) message.obj).updateAsyncRequestData();
                    }
                } catch (Exception e) {
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAPNChangeIntercept() {
        AbstractTask[] abstractTaskArr;
        InterceptResult process;
        InterceptResult process2;
        if (this.mCurTaskList != null && this.mCurTaskList.size() > 0) {
            for (AbstractTask abstractTask : this.mCurTaskList) {
                if (abstractTask.mIntercepters != null && abstractTask.mIntercepters.containsKey("network") && (process2 = abstractTask.mIntercepters.get("network").process(abstractTask.mContext, abstractTask.getTaskKey(), abstractTask.mDownloadId, null)) != null && process2.retCode == 1) {
                    abstractTask.pause();
                }
            }
        }
        if (this.mTaskPriorityQueue.size() > 0 && (abstractTaskArr = new AbstractTask[this.mTaskPriorityQueue.size()]) != null && abstractTaskArr.length > 0) {
            for (AbstractTask abstractTask2 : abstractTaskArr) {
                if (abstractTask2 != null && abstractTask2.mIntercepters != null && abstractTask2.mIntercepters.containsKey("network") && (process = abstractTask2.mIntercepters.get("network").process(abstractTask2.mContext, abstractTask2.getTaskKey(), abstractTask2.mDownloadId, null)) != null && process.retCode == 1) {
                    abstractTask2.pause();
                }
            }
        }
    }

    public void release() {
        this.mLooper.quit();
        this.mThr.interrupt();
        if (this.mConnectivityReceiver != null) {
            this.mContext.unregisterReceiver(this.mConnectivityReceiver);
            this.mConnectivityReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinaryTaskMng(Context context, TaskManagerConfiguration taskManagerConfiguration) {
        long[] jArr;
        this.mMaxThread = 3;
        this.mContext = context;
        if (taskManagerConfiguration != null) {
            ByteArrayInfoMng.mMaxByteSize = taskManagerConfiguration.getMaxBufferCount();
            AbstractTask.bufferSize = taskManagerConfiguration.getBufferSize();
            AbstractTask.minSegLen = AbstractTask.bufferSize * 32;
            this.mMaxThread = taskManagerConfiguration.getMaxTaskCount();
            jArr = taskManagerConfiguration.getRetryIntervals();
            NetWorkDetector.getInstance().sNeedDetect = taskManagerConfiguration.isRetryNetDetect();
            this.mDownConfig.mTrafficStatsTag = taskManagerConfiguration.getTrafficStatsTag();
            this.mDownConfig.mDomainNameToIpEnable = taskManagerConfiguration.geDomainNameToIpEnable();
            this.mDownConfig.mHttpRetryStrategyEnable = taskManagerConfiguration.getHttpRetryStrategyEnable();
            this.mDownConfig.mDownSpeedStatEnable = taskManagerConfiguration.getDownSpeedStatEnable();
            this.mDownConfig.mConfigSpeedStat = SpeedStatData.parseSpeedConfig(this.mContext, null);
            URLRegUtils.setURLReg(taskManagerConfiguration.getURLRetryHostReg(), taskManagerConfiguration.getDomainNameToIpReg());
        } else {
            jArr = null;
        }
        jArr = jArr == null ? DownConstants.DF_RETRY_INTERVALS : jArr;
        if (this.mDownConfig != null && taskManagerConfiguration != null && this.mDownConfig.mDomainNameToIpEnable) {
            initHttpDns(taskManagerConfiguration.getPreResolveDominName());
            DownPrefUtils.setString(this.mContext, DownPrefUtils.PREF_CONFI_HOST_TYPE, DownPrefUtils.HOST_TYPE_IP);
        }
        this.mAllTaskMap = new ConcurrentHashMap<>();
        this.mTaskPriorityQueue = new PriorityQueue<>();
        this.mCurTaskList = new ArrayList();
        this.mObserverList = new CopyOnWriteArrayList();
        this.mStatsticMap = new HashMap();
        setInfoTypeList(this.mContext);
        this.mByteArrayInfoMng = new ByteArrayInfoMng();
        this.mWriteThreadMng = new WriteThreadMng(3);
        this.mClient = new AsyncHttpClient(this.mContext, jArr);
        startTaskMng();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            if (this.mConnectivityReceiver != null) {
                context.registerReceiver(this.mConnectivityReceiver, intentFilter);
            } else {
                this.mConnectivityReceiver = new BroadcastReceiver() { // from class: com.baidu.down.request.taskmanager.BinaryTaskMng.2
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                            if (BinaryTaskMng.this.mHandler != null) {
                                BinaryTaskMng.this.mHandler.removeMessages(2);
                                BinaryTaskMng.this.mHandler.sendMessageDelayed(BinaryTaskMng.this.mHandler.obtainMessage(2), 2500L);
                            }
                            if (BinaryTaskMng.this.mDownConfig != null && BinaryTaskMng.this.mDownConfig.mDomainNameToIpEnable) {
                                HttpDns.getInstance().resetCacheIps();
                            }
                        }
                    }
                };
                context.registerReceiver(this.mConnectivityReceiver, intentFilter);
            }
        } catch (Exception e) {
        }
    }

    public AbstractTask getTaskByKey(String str) {
        if (str == null) {
            return null;
        }
        return this.mAllTaskMap.get(str);
    }

    public AsyncHttpClient getHttpClient() {
        return this.mClient;
    }

    public void setMaxDownloadThread(int i) {
        if (this.mMaxThread != i) {
            this.mMaxThread = i;
            if (this.mHandler != null) {
                this.mHandler.removeMessages(0);
                this.mHandler.sendEmptyMessage(0);
            }
        }
    }

    public void setMaxDownloadBufferCount(int i) {
    }

    public void setDownloadBufferSize(int i) {
    }

    public int getCurrentVacant() {
        return this.mMaxThread - this.mCurTaskList.size();
    }

    public int getMaxDownloadThread() {
        return this.mMaxThread;
    }

    public DatabaseMng getDatabaseMng() {
        if (this.mDbmng == null) {
            this.mDbmng = new DatabaseMng(this.mContext);
        }
        return this.mDbmng;
    }

    public ByteArrayInfoMng getByteArrayInfoMng() {
        return this.mByteArrayInfoMng;
    }

    public WriteThreadMng getWriteThreadMng() {
        return this.mWriteThreadMng;
    }

    public void resumeTaskFromDB() {
        Cursor query;
        if (this.mDbmng != null && (query = this.mDbmng.getDownLoad().query(this.mDbmng.getSQLiteDatabase(), null, null, null, null, null, null)) != null && query.moveToFirst()) {
            do {
                int i = query.getInt(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE));
                int i2 = query.getInt(query.getColumnIndex("status"));
                String string = query.getString(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_URI));
                String string2 = query.getString(query.getColumnIndex("path"));
                String string3 = query.getString(query.getColumnIndex("name"));
                String string4 = query.getString(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_MIME_TYPE));
                String string5 = query.getString(query.getColumnIndex("etag"));
                long j = query.getLong(query.getColumnIndex(IMConstants.MSG_ROW_ID));
                BinaryReqTask binaryReqTask = (i != 1 || i2 == 1003) ? null : new BinaryReqTask(this.mContext, new FileMsg(string, j, string2, string3, string4, false, string5));
                if (binaryReqTask != null) {
                    this.mAllTaskMap.put(string + j, binaryReqTask);
                    taskPriorityQueueOffer(binaryReqTask);
                }
            } while (query.moveToNext());
        }
    }

    public void addObserver(TaskObserverInterface taskObserverInterface) {
        synchronized (this.mObserverList) {
            if (!this.mObserverList.contains(taskObserverInterface)) {
                this.mObserverList.add(taskObserverInterface);
            }
        }
    }

    public void removeObserver(TaskObserverInterface taskObserverInterface) {
        synchronized (this.mObserverList) {
            this.mObserverList.remove(taskObserverInterface);
        }
    }

    public void taskPriorityQueueOffer(AbstractTask abstractTask) {
        if (abstractTask.mStatus != 1002 && abstractTask.mStatus != 1009 && abstractTask.mStatus != 1001) {
            abstractTask.mStatus = 1009;
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.obj = abstractTask;
            this.mHandler.sendMessageAtFrontOfQueue(obtainMessage);
        }
    }

    public long startDownload(FileMsg fileMsg) {
        AbstractTask binaryReqTask;
        long j;
        SystemClock.elapsedRealtime();
        long j2 = fileMsg.mId;
        String str = fileMsg.mUrl;
        if (fileMsg.mId > -1) {
            str = str + fileMsg.mId;
        }
        if (this.mAllTaskMap.containsKey(str)) {
            resumeDownload(str, fileMsg);
            j = j2;
        } else {
            if (this.mClient.getNetWorkType() != ConnectManager.NetWorkType.TYPE_2G) {
                switch (this.mPatternConfig.patternType) {
                    case 1:
                        if (fileMsg.mPattern == 1 && isMatchInfoType(fileMsg.mDownloadType)) {
                            binaryReqTask = new MultiSrcBinaryReqTask(this.mContext, fileMsg);
                            break;
                        } else {
                            binaryReqTask = new BinaryReqTask(this.mContext, fileMsg);
                            break;
                        }
                        break;
                    default:
                        binaryReqTask = new BinaryReqTask(this.mContext, fileMsg);
                        break;
                }
            } else {
                binaryReqTask = new BinaryReqTask(this.mContext, fileMsg);
            }
            binaryReqTask.mIntercepters = fileMsg.mIntercepters;
            if (fileMsg.mNeedWriteDb && fileMsg.mId < 0) {
                if (this.mDbmng == null) {
                    this.mDbmng = new DatabaseMng(this.mContext);
                }
                binaryReqTask.mDownloadId = this.mDbmng.insertToDatabase(binaryReqTask.mUri, binaryReqTask.mFilename, binaryReqTask.mFileDir, 1);
                str = str + binaryReqTask.mDownloadId;
            }
            long j3 = binaryReqTask.mDownloadId;
            binaryReqTask.setPriority(fileMsg.mPriority);
            synchronized (this.mAllTaskMap) {
                if (this.mAllTaskMap.containsKey(str)) {
                    resumeDownload(str, fileMsg);
                } else {
                    this.mAllTaskMap.put(str, binaryReqTask);
                    taskPriorityQueueOffer(binaryReqTask);
                }
            }
            j = j3;
        }
        this.mByteArrayInfoMng.initByteArray(ByteArrayInfoMng.mMaxByteSize);
        return j;
    }

    private void resumeDownload(String str, FileMsg fileMsg) {
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        abstractTask.setPriority(fileMsg.mPriority);
        taskPriorityQueueOffer(abstractTask);
        abstractTask.mIntercepters = fileMsg.mIntercepters;
        if (!abstractTask.mFileDir.equals(fileMsg.mSavePath)) {
            abstractTask.mFileDir = fileMsg.mSavePath;
            abstractTask.mFilePath = null;
        }
    }

    public void pauseDownload(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        if (abstractTask != null) {
            abstractTask.pause();
        }
    }

    public void stopDownload(String str, final long j, boolean z) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        if (abstractTask != null) {
            abstractTask.stop(z);
        }
        new Thread(new Runnable() { // from class: com.baidu.down.request.taskmanager.BinaryTaskMng.3
            @Override // java.lang.Runnable
            public void run() {
                TaskMsg taskMsg = new TaskMsg();
                taskMsg._id = j;
                taskMsg.status = 1004;
                BinaryTaskMng.this.notifyUi(taskMsg);
            }
        }).start();
    }

    public void stopAllTask(boolean z) {
        for (AbstractTask abstractTask : this.mAllTaskMap.values()) {
            abstractTask.stop(z);
        }
    }

    public void pauseAllTask() {
        for (AbstractTask abstractTask : this.mAllTaskMap.values()) {
            abstractTask.pause();
        }
    }

    public void runAllTask() {
        this.mHandler.sendEmptyMessage(4);
    }

    private void notifySpeedIdle(AbstractTask abstractTask) {
        abstractTask.mLastNotifySpeed = 0L;
        TaskMsg taskMsg = new TaskMsg();
        taskMsg.status = 1002;
        taskMsg._id = abstractTask.mDownloadId;
        taskMsg.uKey = abstractTask.mUri + abstractTask.mDownloadId;
        taskMsg.filePath = abstractTask.mFilePath;
        taskMsg.fileSize = abstractTask.mTotalLength;
        taskMsg.transferedSize = abstractTask.mProgressInfo.getCurrentLength();
        taskMsg.progressMap = abstractTask.mProgressInfo.toString();
        taskMsg.transferedSpeed = 0L;
        notifyUi(taskMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void priorityRunning() {
        AbstractTask abstractTask;
        Iterator<AbstractTask> it = this.mCurTaskList.iterator();
        while (it.hasNext()) {
            AbstractTask next = it.next();
            if (next.mStatus == 1004 || next.mStatus == 1005 || next.mStatus == 1003 || next.mStatus == 1008 || next.mStatus == 1006) {
                it.remove();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (next.mStatus == 1001 || next.mStatus == 1002) {
                if (next.mLastNotifySpeed != 0 && elapsedRealtime - next.mLastNotifyTime > 2000) {
                    notifySpeedIdle(next);
                }
            }
        }
        while (this.mTaskPriorityQueue.size() > 0) {
            if (this.mCurTaskList.size() < this.mMaxThread) {
                AbstractTask abstractTask2 = this.mAllTaskMap.get(this.mTaskPriorityQueue.poll().getTaskKey());
                if (abstractTask2 != null && abstractTask2.mStatus != 1004 && abstractTask2.mStatus != 1005 && abstractTask2.mStatus != 1003 && abstractTask2.mStatus != 1008 && abstractTask2.mStatus != 1006 && !this.mCurTaskList.contains(abstractTask2)) {
                    this.mCurTaskList.add(abstractTask2);
                    abstractTask2.start();
                }
            } else {
                AbstractTask peek = this.mTaskPriorityQueue.peek();
                if (peek.mLastNotifyBytes > 0 && peek.mTotalLength > 0 && peek.mLastNotifySpeed > 0 && (peek.mTotalLength - peek.mLastNotifyBytes) / peek.mLastNotifySpeed <= 3) {
                    peek.setPriority(peek.getPriority() + 1);
                }
                Iterator<AbstractTask> it2 = this.mCurTaskList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        abstractTask = null;
                        break;
                    }
                    abstractTask = it2.next();
                    if (abstractTask.mLastNotifyBytes <= 0 || abstractTask.mTotalLength <= 0 || abstractTask.mLastNotifySpeed <= 0 || (abstractTask.mTotalLength - abstractTask.mLastNotifyBytes) / abstractTask.mLastNotifySpeed > 3) {
                        if (peek.getPriority() > abstractTask.getPriority()) {
                            break;
                        }
                    }
                }
                if (abstractTask == null) {
                    break;
                }
                this.mTaskPriorityQueue.remove(peek);
                AbstractTask abstractTask3 = this.mAllTaskMap.get(peek.getTaskKey());
                if (abstractTask3 != null && abstractTask3.mStatus != 1004 && abstractTask3.mStatus != 1005 && abstractTask3.mStatus != 1003 && abstractTask3.mStatus != 1008 && abstractTask3.mStatus != 1006 && !this.mCurTaskList.contains(abstractTask3)) {
                    abstractTask.pend();
                    this.mCurTaskList.remove(abstractTask);
                    this.mTaskPriorityQueue.add(abstractTask);
                    this.mCurTaskList.add(abstractTask3);
                    abstractTask3.start();
                }
            }
        }
        if (this.mTaskPriorityQueue.size() > 0 || this.mCurTaskList.size() > 0) {
            this.mHandler.sendEmptyMessageDelayed(0, 5000L);
            if (this.mWakelock == null) {
                this.mWakelock = ((PowerManager) this.mContext.getSystemService("power")).newWakeLock(1, "Async-Downloader");
                this.mWakelock.acquire();
            }
            if (this.mWakelock != null && !this.mWakelock.isHeld()) {
                this.mWakelock.acquire();
            }
        } else if (this.mWakelock != null && this.mWakelock.isHeld()) {
            this.mWakelock.release();
        }
    }

    public int findTaskStatus(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        if (abstractTask == null) {
            return -1;
        }
        return abstractTask.mStatus;
    }

    public long findTaskTotalLength(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        if (abstractTask != null) {
            return abstractTask.mTotalLength;
        }
        return 0L;
    }

    public long findTaskCurrentLength(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        if (abstractTask != null) {
            return abstractTask.mProgressInfo.getCurrentLength();
        }
        return 0L;
    }

    public String findTaskFilename(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        if (abstractTask == null) {
            return "";
        }
        return abstractTask.mFilename;
    }

    public String findTaskFilepath(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        if (abstractTask == null) {
            return "";
        }
        return abstractTask.mFileDir;
    }

    public String findTaskMimetype(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        if (abstractTask == null) {
            return "";
        }
        return abstractTask.mMimetype;
    }

    public void notifyUi(Object obj) {
        for (TaskObserverInterface taskObserverInterface : this.mObserverList) {
            taskObserverInterface.onUpdate(obj);
        }
    }

    public void notifyUiMessageType(String str, long j, int i, Object obj) {
        for (TaskObserverInterface taskObserverInterface : this.mObserverList) {
            taskObserverInterface.onDownloadMsgType(str, j, i, obj);
        }
    }

    public void notifyMngTaskStatus(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        if (abstractTask != null) {
            if (abstractTask.mStatus == 1004 || abstractTask.mStatus == 1008) {
                synchronized (this.mAllTaskMap) {
                    this.mAllTaskMap.remove(str);
                }
                this.mHandler.removeMessages(1);
                this.mHandler.sendEmptyMessageDelayed(1, 30000L);
            }
            this.mHandler.removeMessages(0);
            this.mHandler.sendEmptyMessage(0);
            if (abstractTask.mStatus == 1004 || abstractTask.mStatus == 1005 || abstractTask.mStatus == 1006 || abstractTask.mStatus == 1008) {
                if (abstractTask.mTaskSpeedStat.speedStatEnable) {
                    abstractTask.mTaskSpeedStat.status = abstractTask.mStatus;
                    TaskNetRequestMng.sendSpeedStat(this.mContext, abstractTask.mTaskSpeedStat, this.mDownConfig.mConfigSpeedStat, false);
                } else if (SpeedStatData.acquireSpeedStatConfig(this.mContext, this.mDownConfig)) {
                    TaskNetRequestMng.sendSpeedStat(this.mContext, null, this.mDownConfig.mConfigSpeedStat, true);
                }
            }
            if (abstractTask instanceof MultiSrcBinaryReqTask) {
                ((MultiSrcBinaryReqTask) abstractTask).notifyTaskStatus(abstractTask.mStatus);
            }
        }
    }

    public void sendMessage(int i, Object obj) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = obj;
        this.mHandler.sendMessage(obtainMessage);
    }

    public synchronized HttpDNSCacheInfo getHttpDNSCacheInfo() {
        return this.mHttpDNSCacheInfo;
    }

    public synchronized void setHttpDNSCacheInfo(HttpDNSCacheInfo httpDNSCacheInfo) {
        this.mHttpDNSCacheInfo = httpDNSCacheInfo;
    }

    public PatternConfig getPatternConfig() {
        return this.mPatternConfig;
    }

    public StatisticInfo getStatsticInfo(long j) {
        if (this.mStatsticMap != null) {
            return this.mStatsticMap.get(Long.valueOf(j));
        }
        return null;
    }

    public void addStatsticMap(Long l, StatisticInfo statisticInfo) {
        this.mStatsticMap.put(l, statisticInfo);
    }

    public void setInfoTypeList(Context context) {
        String[] split;
        String string = DownPrefUtils.getString(context, DownPrefUtils.PREF_CONFI_IS_INFO_TYPE, "");
        if (this.mInfoTypeList == null) {
            this.mInfoTypeList = new CopyOnWriteArrayList();
        } else {
            this.mInfoTypeList.clear();
        }
        if (!TextUtils.isEmpty(string) && (split = string.intern().replace(HanziToPinyin.Token.SEPARATOR, "").toLowerCase().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length > 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    this.mInfoTypeList.add(split[i]);
                }
            }
        }
    }

    private boolean isMatchInfoType(String str) {
        return (this.mInfoTypeList == null || this.mInfoTypeList.isEmpty() || TextUtils.isEmpty(str) || !this.mInfoTypeList.contains(str)) ? false : true;
    }

    public static void setAllowRequestConfig(boolean z) {
        mAllowRequestConfig = z;
    }

    public DownConfig getDownConfig() {
        return this.mDownConfig;
    }

    public String getDownThreadStat(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        if (this.mAllTaskMap.get(str) == null) {
            return "";
        }
        return SpeedStatData.buildSpeedStat(this.mContext, this.mAllTaskMap.get(str).mTaskSpeedStat, null);
    }

    private void initHttpDns(String str) {
        String[] split;
        if (str != null && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null) {
            HttpDns.getInstance().setPreResolveHosts(split);
        }
        HttpDns.getInstance().setExpiredIPAvailable(false);
    }
}
