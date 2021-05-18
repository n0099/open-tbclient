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
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.down.common.DownConstants;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.StatisticInfo;
import com.baidu.down.common.TaskManagerConfiguration;
import com.baidu.down.common.TaskMsg;
import com.baidu.down.common.TaskObserverInterface;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.down.common.intercepter.InterceptResult;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.down.loopj.android.http.ConnectManager;
import com.baidu.down.loopj.android.request.handler.HttpDns;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.down.request.task.BinaryReqTask;
import com.baidu.down.request.task.MultiSrcBinaryReqTask;
import com.baidu.down.statistic.SpeedStatData;
import com.baidu.down.statistic.TaskSpeedStat;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.PatternConfig;
import com.baidu.down.utils.URLRegUtils;
import com.baidu.down.utils.network.NetWorkDetector;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class BinaryTaskMng {
    public static final boolean DEBUG = false;
    public static final String TAG = "BinaryTaskMng";
    public static final int TASK_ADD_ALLTASK_2_Q = 4;
    public static final int TASK_ADD_TASK_2_Q = 3;
    public static final int TASK_CHECK_APN_CHG = 2;
    public static final int TASK_CHECK_MEMORY = 1;
    public static final int TASK_CHECK_MSG = 0;
    public static final int TASK_CHECK_NET_DELATY = 2500;
    public static final int TASK_CHECK_TIME = 5000;
    public static final int TASK_CHECK_TIME_MOMORY = 30000;
    public static final int TASK_INTERRUPT_RETRY_WAITING = 5;
    public static final int THREAD_REQUEST_ADD_MSG = 6;
    public static final int THREAD_REQUEST_CANCEL_MSG = 7;
    public static final int THREAD_REQUEST_UPDATE_MSG = 8;
    public static boolean mAllowRequestConfig = false;
    public ConcurrentHashMap<String, AbstractTask> mAllTaskMap;
    public ByteArrayInfoMng mByteArrayInfoMng;
    public AsyncHttpClient mClient;
    public BroadcastReceiver mConnectivityReceiver;
    public Context mContext;
    public List<AbstractTask> mCurTaskList;
    public DatabaseMng mDbmng;
    public Handler mHandler;
    public CopyOnWriteArrayList mInfoTypeList;
    public Looper mLooper;
    public int mMaxThread;
    public List<TaskObserverInterface> mObserverList;
    public Map<Long, StatisticInfo> mStatsticMap;
    public PriorityQueue<AbstractTask> mTaskPriorityQueue;
    public WriteThreadMng mWriteThreadMng;
    public HandlerThread mThr = null;
    public PowerManager.WakeLock mWakelock = null;
    public HttpDNSCacheInfo mHttpDNSCacheInfo = null;
    public DownConfig mDownConfig = new DownConfig();
    public PatternConfig mPatternConfig = new PatternConfig();

    public BinaryTaskMng(Context context, TaskManagerConfiguration taskManagerConfiguration) {
        this.mMaxThread = 3;
        long[] jArr = null;
        this.mContext = context;
        if (taskManagerConfiguration != null) {
            ByteArrayInfoMng.mMaxByteSize = taskManagerConfiguration.getMaxBufferCount();
            int bufferSize = taskManagerConfiguration.getBufferSize();
            AbstractTask.bufferSize = bufferSize;
            AbstractTask.minSegLen = bufferSize * 32;
            this.mMaxThread = taskManagerConfiguration.getMaxTaskCount();
            long[] retryIntervals = taskManagerConfiguration.getRetryIntervals();
            NetWorkDetector.getInstance().sNeedDetect = taskManagerConfiguration.isRetryNetDetect();
            this.mDownConfig.mTrafficStatsTag = taskManagerConfiguration.getTrafficStatsTag();
            this.mDownConfig.mDomainNameToIpEnable = taskManagerConfiguration.geDomainNameToIpEnable();
            this.mDownConfig.mHttpRetryStrategyEnable = taskManagerConfiguration.getHttpRetryStrategyEnable();
            this.mDownConfig.mDownSpeedStatEnable = taskManagerConfiguration.getDownSpeedStatEnable();
            this.mDownConfig.mConfigSpeedStat = SpeedStatData.parseSpeedConfig(this.mContext, null);
            URLRegUtils.setURLReg(taskManagerConfiguration.getURLRetryHostReg(), taskManagerConfiguration.getDomainNameToIpReg());
            jArr = retryIntervals;
        }
        jArr = jArr == null ? DownConstants.DF_RETRY_INTERVALS : jArr;
        DownConfig downConfig = this.mDownConfig;
        if (downConfig != null && taskManagerConfiguration != null && downConfig.mDomainNameToIpEnable) {
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
                BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.down.request.taskmanager.BinaryTaskMng.2
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                            if (BinaryTaskMng.this.mHandler != null) {
                                BinaryTaskMng.this.mHandler.removeMessages(2);
                                BinaryTaskMng.this.mHandler.sendMessageDelayed(BinaryTaskMng.this.mHandler.obtainMessage(2), TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                            }
                            if (BinaryTaskMng.this.mDownConfig == null || !BinaryTaskMng.this.mDownConfig.mDomainNameToIpEnable) {
                                return;
                            }
                            HttpDns.getInstance().resetCacheIps();
                        }
                    }
                };
                this.mConnectivityReceiver = broadcastReceiver;
                context.registerReceiver(broadcastReceiver, intentFilter);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAPNChangeIntercept() {
        Map<String, IIntercepter<?>> map;
        InterceptResult process;
        InterceptResult process2;
        List<AbstractTask> list = this.mCurTaskList;
        if (list != null && list.size() > 0) {
            for (AbstractTask abstractTask : this.mCurTaskList) {
                Map<String, IIntercepter<?>> map2 = abstractTask.mIntercepters;
                if (map2 != null && map2.containsKey("network") && (process2 = abstractTask.mIntercepters.get("network").process(abstractTask.mContext, abstractTask.getTaskKey(), abstractTask.mDownloadId, null)) != null && process2.retCode == 1) {
                    abstractTask.pause();
                }
            }
        }
        if (this.mTaskPriorityQueue.size() <= 0) {
            return;
        }
        int size = this.mTaskPriorityQueue.size();
        AbstractTask[] abstractTaskArr = new AbstractTask[size];
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                AbstractTask abstractTask2 = abstractTaskArr[i2];
                if (abstractTask2 != null && (map = abstractTask2.mIntercepters) != null && map.containsKey("network") && (process = abstractTask2.mIntercepters.get("network").process(abstractTask2.mContext, abstractTask2.getTaskKey(), abstractTask2.mDownloadId, null)) != null && process.retCode == 1) {
                    abstractTask2.pause();
                }
            }
        }
    }

    private void initHttpDns(String str) {
        String[] split;
        if (str != null && (split = str.split("-")) != null) {
            HttpDns.getInstance().setPreResolveHosts(split);
        }
        HttpDns.getInstance().setExpiredIPAvailable(false);
    }

    private boolean isMatchInfoType(String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.mInfoTypeList;
        return (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty() || TextUtils.isEmpty(str) || !this.mInfoTypeList.contains(str)) ? false : true;
    }

    private void notifySpeedIdle(AbstractTask abstractTask) {
        abstractTask.mLastNotifySpeed = 0L;
        TaskMsg taskMsg = new TaskMsg();
        taskMsg.status = 1002;
        taskMsg._id = abstractTask.mDownloadId;
        taskMsg.url = abstractTask.getDefaultUrl();
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
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        AbstractTask abstractTask;
        int i7;
        Iterator<AbstractTask> it = this.mCurTaskList.iterator();
        while (true) {
            i2 = 1006;
            i3 = 1008;
            i4 = 1003;
            i5 = 1005;
            if (!it.hasNext()) {
                break;
            }
            AbstractTask next = it.next();
            int i8 = next.mStatus;
            if (i8 == 1004 || i8 == 1005 || i8 == 1003 || i8 == 1008 || i8 == 1006) {
                it.remove();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i9 = next.mStatus;
            if (i9 == 1001 || i9 == 1002) {
                if (next.mLastNotifySpeed != 0 && elapsedRealtime - next.mLastNotifyTime > 2000) {
                    notifySpeedIdle(next);
                }
            }
        }
        while (this.mTaskPriorityQueue.size() > 0) {
            if (this.mCurTaskList.size() < this.mMaxThread) {
                AbstractTask abstractTask2 = this.mAllTaskMap.get(this.mTaskPriorityQueue.poll().getTaskKey());
                if (abstractTask2 != null && (i6 = abstractTask2.mStatus) != 1004 && i6 != i5 && i6 != i4 && i6 != i3 && i6 != i2 && !this.mCurTaskList.contains(abstractTask2)) {
                    this.mCurTaskList.add(abstractTask2);
                    abstractTask2.start();
                }
            } else {
                AbstractTask peek = this.mTaskPriorityQueue.peek();
                long j = peek.mLastNotifyBytes;
                if (j > 0) {
                    long j2 = peek.mTotalLength;
                    if (j2 > 0) {
                        long j3 = peek.mLastNotifySpeed;
                        if (j3 > 0 && (j2 - j) / j3 <= 3) {
                            peek.setPriority(peek.getPriority() + 1);
                        }
                    }
                }
                Iterator<AbstractTask> it2 = this.mCurTaskList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        abstractTask = null;
                        break;
                    }
                    AbstractTask next2 = it2.next();
                    long j4 = next2.mLastNotifyBytes;
                    Iterator<AbstractTask> it3 = it2;
                    if (j4 > 0) {
                        long j5 = next2.mTotalLength;
                        if (j5 > 0) {
                            long j6 = next2.mLastNotifySpeed;
                            if (j6 > 0 && (j5 - j4) / j6 <= 3) {
                                it2 = it3;
                            }
                        }
                    }
                    if (peek.getPriority() > next2.getPriority()) {
                        abstractTask = next2;
                        break;
                    }
                    it2 = it3;
                }
                if (abstractTask == null) {
                    break;
                }
                this.mTaskPriorityQueue.remove(peek);
                AbstractTask abstractTask3 = this.mAllTaskMap.get(peek.getTaskKey());
                if (abstractTask3 == null || (i7 = abstractTask3.mStatus) == 1004) {
                    i4 = 1003;
                } else {
                    i4 = 1003;
                    if (i7 != 1005) {
                        if (i7 != 1003) {
                            if (i7 != 1008 && i7 != 1006 && !this.mCurTaskList.contains(abstractTask3)) {
                                abstractTask.pend();
                                this.mCurTaskList.remove(abstractTask);
                                this.mTaskPriorityQueue.add(abstractTask);
                                this.mCurTaskList.add(abstractTask3);
                                abstractTask3.start();
                            }
                            i2 = 1006;
                            i3 = 1008;
                            i5 = 1005;
                        }
                        i2 = 1006;
                        i3 = 1008;
                        i5 = 1005;
                    }
                }
                i2 = 1006;
                i3 = 1008;
                i5 = 1005;
            }
        }
        if (this.mTaskPriorityQueue.size() <= 0 && this.mCurTaskList.size() <= 0) {
            PowerManager.WakeLock wakeLock = this.mWakelock;
            if (wakeLock == null || !wakeLock.isHeld()) {
                return;
            }
            this.mWakelock.release();
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(0, 5000L);
        if (this.mWakelock == null) {
            PowerManager.WakeLock newWakeLock = ((PowerManager) this.mContext.getSystemService("power")).newWakeLock(1, "Async-Downloader");
            this.mWakelock = newWakeLock;
            newWakeLock.acquire();
        }
        PowerManager.WakeLock wakeLock2 = this.mWakelock;
        if (wakeLock2 == null || wakeLock2.isHeld()) {
            return;
        }
        this.mWakelock.acquire();
    }

    private void resumeDownload(String str, FileMsg fileMsg) {
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        abstractTask.setPriority(fileMsg.mPriority);
        taskPriorityQueueOffer(abstractTask);
        abstractTask.mRealUrl = fileMsg.mRealUrl;
        abstractTask.mIntercepters = fileMsg.mIntercepters;
        if (abstractTask.mFileDir.equals(fileMsg.mSavePath)) {
            return;
        }
        abstractTask.mFileDir = fileMsg.mSavePath;
        abstractTask.mFilePath = null;
    }

    public static void setAllowRequestConfig(boolean z) {
        mAllowRequestConfig = z;
    }

    private void startTaskMng() {
        HandlerThread handlerThread = new HandlerThread("DownloadLooperThread", 10);
        this.mThr = handlerThread;
        handlerThread.start();
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
                        if (abstractTask.mStatus != 1009) {
                            return;
                        }
                        BinaryTaskMng.this.mTaskPriorityQueue.offer(abstractTask);
                        BinaryTaskMng.this.priorityRunning();
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
                } catch (Exception unused) {
                }
            }
        };
    }

    public void addObserver(TaskObserverInterface taskObserverInterface) {
        synchronized (this.mObserverList) {
            if (!this.mObserverList.contains(taskObserverInterface)) {
                this.mObserverList.add(taskObserverInterface);
            }
        }
    }

    public void addStatsticMap(Long l, StatisticInfo statisticInfo) {
        this.mStatsticMap.put(l, statisticInfo);
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
        return abstractTask != null ? abstractTask.mFilename : "";
    }

    public String findTaskFilepath(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        return abstractTask != null ? abstractTask.mFileDir : "";
    }

    public String findTaskMimetype(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        return abstractTask != null ? abstractTask.mMimetype : "";
    }

    public int findTaskStatus(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        if (abstractTask != null) {
            return abstractTask.mStatus;
        }
        return -1;
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

    public ByteArrayInfoMng getByteArrayInfoMng() {
        return this.mByteArrayInfoMng;
    }

    public int getCurrentVacant() {
        return this.mMaxThread - this.mCurTaskList.size();
    }

    public DatabaseMng getDatabaseMng() {
        if (this.mDbmng == null) {
            this.mDbmng = new DatabaseMng(this.mContext);
        }
        return this.mDbmng;
    }

    public DownConfig getDownConfig() {
        return this.mDownConfig;
    }

    public String getDownThreadStat(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        return this.mAllTaskMap.get(str) == null ? "" : SpeedStatData.buildSpeedStat(this.mContext, this.mAllTaskMap.get(str).mTaskSpeedStat, null);
    }

    public AsyncHttpClient getHttpClient() {
        return this.mClient;
    }

    public synchronized HttpDNSCacheInfo getHttpDNSCacheInfo() {
        return this.mHttpDNSCacheInfo;
    }

    public int getMaxDownloadThread() {
        return this.mMaxThread;
    }

    public PatternConfig getPatternConfig() {
        return this.mPatternConfig;
    }

    public StatisticInfo getStatsticInfo(long j) {
        Map<Long, StatisticInfo> map = this.mStatsticMap;
        if (map != null) {
            return map.get(Long.valueOf(j));
        }
        return null;
    }

    public AbstractTask getTaskByKey(String str) {
        if (str == null) {
            return null;
        }
        return this.mAllTaskMap.get(str);
    }

    public WriteThreadMng getWriteThreadMng() {
        return this.mWriteThreadMng;
    }

    public void notifyMngTaskStatus(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        AbstractTask abstractTask = this.mAllTaskMap.get(str);
        if (abstractTask == null) {
            return;
        }
        int i2 = abstractTask.mStatus;
        if (i2 == 1004 || i2 == 1008) {
            synchronized (this.mAllTaskMap) {
                this.mAllTaskMap.remove(str);
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
        }
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessage(0);
        int i3 = abstractTask.mStatus;
        if (i3 == 1004 || i3 == 1005 || i3 == 1006 || i3 == 1008) {
            TaskSpeedStat taskSpeedStat = abstractTask.mTaskSpeedStat;
            if (taskSpeedStat.speedStatEnable) {
                taskSpeedStat.status = abstractTask.mStatus;
                TaskNetRequestMng.sendSpeedStat(this.mContext, taskSpeedStat, this.mDownConfig.mConfigSpeedStat, false);
            } else if (SpeedStatData.acquireSpeedStatConfig(this.mContext, this.mDownConfig)) {
                TaskNetRequestMng.sendSpeedStat(this.mContext, null, this.mDownConfig.mConfigSpeedStat, true);
            }
        }
        if (abstractTask instanceof MultiSrcBinaryReqTask) {
            ((MultiSrcBinaryReqTask) abstractTask).notifyTaskStatus(abstractTask.mStatus);
        }
    }

    public void notifyUi(Object obj) {
        for (TaskObserverInterface taskObserverInterface : this.mObserverList) {
            try {
                taskObserverInterface.onUpdate(obj);
            } catch (Exception unused) {
            }
        }
    }

    public void notifyUiMessageType(String str, long j, int i2, Object obj) {
        for (TaskObserverInterface taskObserverInterface : this.mObserverList) {
            taskObserverInterface.onDownloadMsgType(str, j, i2, obj);
        }
    }

    public void pauseAllTask() {
        for (AbstractTask abstractTask : this.mAllTaskMap.values()) {
            abstractTask.pause();
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

    public void release() {
        this.mLooper.quit();
        this.mThr.interrupt();
        BroadcastReceiver broadcastReceiver = this.mConnectivityReceiver;
        if (broadcastReceiver != null) {
            this.mContext.unregisterReceiver(broadcastReceiver);
            this.mConnectivityReceiver = null;
        }
    }

    public void removeObserver(TaskObserverInterface taskObserverInterface) {
        synchronized (this.mObserverList) {
            this.mObserverList.remove(taskObserverInterface);
        }
    }

    public void resumeTaskFromDB() {
        Cursor query;
        DatabaseMng databaseMng = this.mDbmng;
        if (databaseMng == null || (query = databaseMng.getDownLoad().query(this.mDbmng.getSQLiteDatabase(), null, null, null, null, null, null)) == null || !query.moveToFirst()) {
            return;
        }
        do {
            int i2 = query.getInt(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE));
            int i3 = query.getInt(query.getColumnIndex("status"));
            String string = query.getString(query.getColumnIndex("uri"));
            String string2 = query.getString(query.getColumnIndex("path"));
            String string3 = query.getString(query.getColumnIndex("name"));
            String string4 = query.getString(query.getColumnIndex("mimetype"));
            String string5 = query.getString(query.getColumnIndex("etag"));
            long j = query.getLong(query.getColumnIndex("_id"));
            BinaryReqTask binaryReqTask = null;
            if (i2 == 1 && i3 != 1003) {
                binaryReqTask = new BinaryReqTask(this.mContext, new FileMsg(string, j, string2, string3, string4, Boolean.FALSE, string5));
            }
            if (binaryReqTask != null) {
                ConcurrentHashMap<String, AbstractTask> concurrentHashMap = this.mAllTaskMap;
                concurrentHashMap.put(string + j, binaryReqTask);
                taskPriorityQueueOffer(binaryReqTask);
            }
        } while (query.moveToNext());
    }

    public void runAllTask() {
        this.mHandler.sendEmptyMessage(4);
    }

    public void sendMessage(int i2, Object obj) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = i2;
        obtainMessage.obj = obj;
        this.mHandler.sendMessage(obtainMessage);
    }

    public synchronized void setHttpDNSCacheInfo(HttpDNSCacheInfo httpDNSCacheInfo) {
        this.mHttpDNSCacheInfo = httpDNSCacheInfo;
    }

    public void setInfoTypeList(Context context) {
        String[] split;
        String string = DownPrefUtils.getString(context, DownPrefUtils.PREF_CONFI_IS_INFO_TYPE, "");
        CopyOnWriteArrayList copyOnWriteArrayList = this.mInfoTypeList;
        if (copyOnWriteArrayList == null) {
            this.mInfoTypeList = new CopyOnWriteArrayList();
        } else {
            copyOnWriteArrayList.clear();
        }
        if (TextUtils.isEmpty(string) || (split = string.intern().replace(" ", "").toLowerCase().split(",")) == null || split.length <= 0) {
            return;
        }
        for (int i2 = 0; i2 < split.length; i2++) {
            if (!TextUtils.isEmpty(split[i2])) {
                this.mInfoTypeList.add(split[i2]);
            }
        }
    }

    public void setMaxDownloadThread(int i2) {
        if (this.mMaxThread != i2) {
            this.mMaxThread = i2;
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(0);
                this.mHandler.sendEmptyMessage(0);
            }
        }
    }

    public long startDownload(FileMsg fileMsg) {
        AbstractTask binaryReqTask;
        SystemClock.elapsedRealtime();
        long j = fileMsg.mId;
        String str = fileMsg.mUrl;
        if (j > -1) {
            str = str + fileMsg.mId;
        }
        if (this.mAllTaskMap.containsKey(str)) {
            resumeDownload(str, fileMsg);
        } else {
            if (this.mClient.getNetWorkType() != ConnectManager.NetWorkType.TYPE_2G) {
                if (this.mPatternConfig.patternType != 1) {
                    binaryReqTask = new BinaryReqTask(this.mContext, fileMsg);
                } else if (fileMsg.mPattern == 1 && isMatchInfoType(fileMsg.mDownloadType)) {
                    binaryReqTask = new MultiSrcBinaryReqTask(this.mContext, fileMsg);
                } else {
                    binaryReqTask = new BinaryReqTask(this.mContext, fileMsg);
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
            long j2 = binaryReqTask.mDownloadId;
            binaryReqTask.setPriority(fileMsg.mPriority);
            synchronized (this.mAllTaskMap) {
                if (this.mAllTaskMap.containsKey(str)) {
                    resumeDownload(str, fileMsg);
                } else {
                    this.mAllTaskMap.put(str, binaryReqTask);
                    taskPriorityQueueOffer(binaryReqTask);
                }
            }
            j = j2;
        }
        this.mByteArrayInfoMng.initByteArray(ByteArrayInfoMng.mMaxByteSize);
        return j;
    }

    public void stopAllTask(boolean z) {
        for (AbstractTask abstractTask : this.mAllTaskMap.values()) {
            abstractTask.stop(z);
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

    public void taskPriorityQueueOffer(AbstractTask abstractTask) {
        int i2 = abstractTask.mStatus;
        if (i2 == 1002 || i2 == 1009 || i2 == 1001) {
            return;
        }
        abstractTask.mStatus = 1009;
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.obj = abstractTask;
        this.mHandler.sendMessageAtFrontOfQueue(obtainMessage);
    }

    public void updateTaskPrioirty(long j, int i2) {
        Iterator<AbstractTask> it = this.mAllTaskMap.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractTask next = it.next();
            if (next.mDownloadId == j) {
                next.setPriority(i2);
                break;
            }
        }
        Iterator<AbstractTask> it2 = this.mCurTaskList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            AbstractTask next2 = it2.next();
            if (next2.mDownloadId == j) {
                next2.setPriority(i2);
                break;
            }
        }
        Iterator<AbstractTask> it3 = this.mTaskPriorityQueue.iterator();
        while (it3.hasNext()) {
            AbstractTask next3 = it3.next();
            if (next3.mDownloadId == j) {
                next3.setPriority(i2);
                return;
            }
        }
    }
}
