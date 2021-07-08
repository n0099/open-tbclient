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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.common.DownConstants;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.StatisticInfo;
import com.baidu.down.common.TaskManagerConfiguration;
import com.baidu.down.common.TaskMsg;
import com.baidu.down.common.TaskObserverInterface;
import com.baidu.down.common.intercepter.IIntercepter;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
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
    public static boolean mAllowRequestConfig;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, AbstractTask> mAllTaskMap;
    public ByteArrayInfoMng mByteArrayInfoMng;
    public AsyncHttpClient mClient;
    public BroadcastReceiver mConnectivityReceiver;
    public Context mContext;
    public List<AbstractTask> mCurTaskList;
    public DatabaseMng mDbmng;
    public DownConfig mDownConfig;
    public Handler mHandler;
    public HttpDNSCacheInfo mHttpDNSCacheInfo;
    public CopyOnWriteArrayList mInfoTypeList;
    public Looper mLooper;
    public int mMaxThread;
    public List<TaskObserverInterface> mObserverList;
    public PatternConfig mPatternConfig;
    public Map<Long, StatisticInfo> mStatsticMap;
    public PriorityQueue<AbstractTask> mTaskPriorityQueue;
    public HandlerThread mThr;
    public PowerManager.WakeLock mWakelock;
    public WriteThreadMng mWriteThreadMng;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1328423903, "Lcom/baidu/down/request/taskmanager/BinaryTaskMng;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1328423903, "Lcom/baidu/down/request/taskmanager/BinaryTaskMng;");
        }
    }

    public BinaryTaskMng(Context context, TaskManagerConfiguration taskManagerConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, taskManagerConfiguration};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMaxThread = 3;
        long[] jArr = null;
        this.mThr = null;
        this.mWakelock = null;
        this.mHttpDNSCacheInfo = null;
        this.mDownConfig = new DownConfig();
        this.mContext = context;
        this.mPatternConfig = new PatternConfig();
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
                BroadcastReceiver broadcastReceiver = new BroadcastReceiver(this) { // from class: com.baidu.down.request.taskmanager.BinaryTaskMng.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BinaryTaskMng this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                            newInitContext2.initArgs = r2;
                            Object[] objArr2 = {this};
                            interceptable2.invokeUnInit(65536, newInitContext2);
                            int i4 = newInitContext2.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext2.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext2);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                            if (this.this$0.mHandler != null) {
                                this.this$0.mHandler.removeMessages(2);
                                this.this$0.mHandler.sendMessageDelayed(this.this$0.mHandler.obtainMessage(2), TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                            }
                            if (this.this$0.mDownConfig == null || !this.this$0.mDownConfig.mDomainNameToIpEnable) {
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
        com.baidu.down.common.intercepter.InterceptResult process;
        com.baidu.down.common.intercepter.InterceptResult process2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
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
    }

    private void initHttpDns(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            if (str != null && (split = str.split("-")) != null) {
                HttpDns.getInstance().setPreResolveHosts(split);
            }
            HttpDns.getInstance().setExpiredIPAvailable(false);
        }
    }

    private boolean isMatchInfoType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, str)) == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.mInfoTypeList;
            return (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty() || TextUtils.isEmpty(str) || !this.mInfoTypeList.contains(str)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    private void notifySpeedIdle(AbstractTask abstractTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, abstractTask) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
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
    }

    private void resumeDownload(String str, FileMsg fileMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, this, str, fileMsg) == null) {
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
    }

    public static void setAllowRequestConfig(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            mAllowRequestConfig = z;
        }
    }

    private void startTaskMng() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            HandlerThread handlerThread = new HandlerThread("DownloadLooperThread", 10);
            this.mThr = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this, this.mThr.getLooper()) { // from class: com.baidu.down.request.taskmanager.BinaryTaskMng.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BinaryTaskMng this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        try {
                            if (message.what == 0) {
                                this.this$0.priorityRunning();
                            } else if (message.what == 1) {
                                if (this.this$0.mCurTaskList.size() == 0 && this.this$0.mTaskPriorityQueue.size() == 0) {
                                    this.this$0.mByteArrayInfoMng.recycleByteArray();
                                }
                            } else if (message.what == 2) {
                                ConnectManager.NetWorkType netWorkType = this.this$0.mClient.getNetWorkType();
                                this.this$0.mClient.switchProxy();
                                ConnectManager.NetWorkType netWorkType2 = this.this$0.mClient.getNetWorkType();
                                if (netWorkType == ConnectManager.NetWorkType.TYPE_UNKNOWN && netWorkType2 != ConnectManager.NetWorkType.TYPE_UNKNOWN && this.this$0.mCurTaskList.size() > 0) {
                                    this.this$0.mHandler.removeMessages(5);
                                    this.this$0.mHandler.sendEmptyMessageDelayed(5, 2000L);
                                } else if (netWorkType2 == ConnectManager.NetWorkType.TYPE_UNKNOWN) {
                                    this.this$0.mHandler.removeMessages(5);
                                }
                                this.this$0.mHttpDNSCacheInfo = null;
                                this.this$0.handleAPNChangeIntercept();
                            } else if (message.what == 3) {
                                AbstractTask abstractTask = (AbstractTask) message.obj;
                                if (abstractTask.mStatus != 1009) {
                                    return;
                                }
                                this.this$0.mTaskPriorityQueue.offer(abstractTask);
                                this.this$0.priorityRunning();
                            } else if (message.what == 4) {
                                for (AbstractTask abstractTask2 : this.this$0.mAllTaskMap.values()) {
                                    if (abstractTask2.mStatus != 1009) {
                                        abstractTask2.mStatus = 1009;
                                        this.this$0.mTaskPriorityQueue.add(abstractTask2);
                                    }
                                }
                                this.this$0.priorityRunning();
                            } else if (message.what == 5) {
                                for (AbstractTask abstractTask3 : this.this$0.mCurTaskList) {
                                    this.this$0.mClient.interruptRetryWaiting(abstractTask3.myContext);
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
                }
            };
        }
    }

    public void addObserver(TaskObserverInterface taskObserverInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, taskObserverInterface) == null) {
            synchronized (this.mObserverList) {
                if (!this.mObserverList.contains(taskObserverInterface)) {
                    this.mObserverList.add(taskObserverInterface);
                }
            }
        }
    }

    public void addStatsticMap(Long l, StatisticInfo statisticInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l, statisticInfo) == null) {
            this.mStatsticMap.put(l, statisticInfo);
        }
    }

    public long findTaskCurrentLength(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) {
            if (j > 0) {
                str = str + j;
            }
            AbstractTask abstractTask = this.mAllTaskMap.get(str);
            if (abstractTask != null) {
                return abstractTask.mProgressInfo.getCurrentLength();
            }
            return 0L;
        }
        return invokeLJ.longValue;
    }

    public String findTaskFilename(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j)) == null) {
            if (j > 0) {
                str = str + j;
            }
            AbstractTask abstractTask = this.mAllTaskMap.get(str);
            return abstractTask != null ? abstractTask.mFilename : "";
        }
        return (String) invokeLJ.objValue;
    }

    public String findTaskFilepath(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, str, j)) == null) {
            if (j > 0) {
                str = str + j;
            }
            AbstractTask abstractTask = this.mAllTaskMap.get(str);
            return abstractTask != null ? abstractTask.mFileDir : "";
        }
        return (String) invokeLJ.objValue;
    }

    public String findTaskMimetype(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, str, j)) == null) {
            if (j > 0) {
                str = str + j;
            }
            AbstractTask abstractTask = this.mAllTaskMap.get(str);
            return abstractTask != null ? abstractTask.mMimetype : "";
        }
        return (String) invokeLJ.objValue;
    }

    public int findTaskStatus(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
            if (j > 0) {
                str = str + j;
            }
            AbstractTask abstractTask = this.mAllTaskMap.get(str);
            if (abstractTask != null) {
                return abstractTask.mStatus;
            }
            return -1;
        }
        return invokeLJ.intValue;
    }

    public long findTaskTotalLength(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j)) == null) {
            if (j > 0) {
                str = str + j;
            }
            AbstractTask abstractTask = this.mAllTaskMap.get(str);
            if (abstractTask != null) {
                return abstractTask.mTotalLength;
            }
            return 0L;
        }
        return invokeLJ.longValue;
    }

    public ByteArrayInfoMng getByteArrayInfoMng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mByteArrayInfoMng : (ByteArrayInfoMng) invokeV.objValue;
    }

    public int getCurrentVacant() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mMaxThread - this.mCurTaskList.size() : invokeV.intValue;
    }

    public DatabaseMng getDatabaseMng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mDbmng == null) {
                this.mDbmng = new DatabaseMng(this.mContext);
            }
            return this.mDbmng;
        }
        return (DatabaseMng) invokeV.objValue;
    }

    public DownConfig getDownConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mDownConfig : (DownConfig) invokeV.objValue;
    }

    public String getDownThreadStat(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048588, this, str, j)) == null) {
            if (j > 0) {
                str = str + j;
            }
            return this.mAllTaskMap.get(str) == null ? "" : SpeedStatData.buildSpeedStat(this.mContext, this.mAllTaskMap.get(str).mTaskSpeedStat, null);
        }
        return (String) invokeLJ.objValue;
    }

    public AsyncHttpClient getHttpClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mClient : (AsyncHttpClient) invokeV.objValue;
    }

    public synchronized HttpDNSCacheInfo getHttpDNSCacheInfo() {
        InterceptResult invokeV;
        HttpDNSCacheInfo httpDNSCacheInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                httpDNSCacheInfo = this.mHttpDNSCacheInfo;
            }
            return httpDNSCacheInfo;
        }
        return (HttpDNSCacheInfo) invokeV.objValue;
    }

    public int getMaxDownloadThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mMaxThread : invokeV.intValue;
    }

    public PatternConfig getPatternConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mPatternConfig : (PatternConfig) invokeV.objValue;
    }

    public StatisticInfo getStatsticInfo(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j)) == null) {
            Map<Long, StatisticInfo> map = this.mStatsticMap;
            if (map != null) {
                return map.get(Long.valueOf(j));
            }
            return null;
        }
        return (StatisticInfo) invokeJ.objValue;
    }

    public AbstractTask getTaskByKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (str == null) {
                return null;
            }
            return this.mAllTaskMap.get(str);
        }
        return (AbstractTask) invokeL.objValue;
    }

    public WriteThreadMng getWriteThreadMng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mWriteThreadMng : (WriteThreadMng) invokeV.objValue;
    }

    public void notifyMngTaskStatus(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048596, this, str, j) == null) {
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
                this.mHandler.sendEmptyMessageDelayed(1, 30000L);
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
    }

    public void notifyUi(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, obj) == null) {
            for (TaskObserverInterface taskObserverInterface : this.mObserverList) {
                try {
                    taskObserverInterface.onUpdate(obj);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void notifyUiMessageType(String str, long j, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2), obj}) == null) {
            for (TaskObserverInterface taskObserverInterface : this.mObserverList) {
                taskObserverInterface.onDownloadMsgType(str, j, i2, obj);
            }
        }
    }

    public void pauseAllTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            for (AbstractTask abstractTask : this.mAllTaskMap.values()) {
                abstractTask.pause();
            }
        }
    }

    public void pauseDownload(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, str, j) == null) {
            if (j > 0) {
                str = str + j;
            }
            AbstractTask abstractTask = this.mAllTaskMap.get(str);
            if (abstractTask != null) {
                abstractTask.pause();
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.mLooper.quit();
            this.mThr.interrupt();
            BroadcastReceiver broadcastReceiver = this.mConnectivityReceiver;
            if (broadcastReceiver != null) {
                this.mContext.unregisterReceiver(broadcastReceiver);
                this.mConnectivityReceiver = null;
            }
        }
    }

    public void removeObserver(TaskObserverInterface taskObserverInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, taskObserverInterface) == null) {
            synchronized (this.mObserverList) {
                this.mObserverList.remove(taskObserverInterface);
            }
        }
    }

    public void resumeTaskFromDB() {
        DatabaseMng databaseMng;
        Cursor query;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (databaseMng = this.mDbmng) == null || (query = databaseMng.getDownLoad().query(this.mDbmng.getSQLiteDatabase(), null, null, null, null, null, null)) == null || !query.moveToFirst()) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.mHandler.sendEmptyMessage(4);
        }
    }

    public void sendMessage(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048605, this, i2, obj) == null) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.obj = obj;
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public synchronized void setHttpDNSCacheInfo(HttpDNSCacheInfo httpDNSCacheInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, httpDNSCacheInfo) == null) {
            synchronized (this) {
                this.mHttpDNSCacheInfo = httpDNSCacheInfo;
            }
        }
    }

    public void setInfoTypeList(Context context) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, context) == null) {
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
    }

    public void setMaxDownloadThread(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048608, this, i2) == null) || this.mMaxThread == i2) {
            return;
        }
        this.mMaxThread = i2;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(0);
            this.mHandler.sendEmptyMessage(0);
        }
    }

    public long startDownload(FileMsg fileMsg) {
        InterceptResult invokeL;
        AbstractTask binaryReqTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, fileMsg)) == null) {
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
        return invokeL.longValue;
    }

    public void stopAllTask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            for (AbstractTask abstractTask : this.mAllTaskMap.values()) {
                abstractTask.stop(z);
            }
        }
    }

    public void stopDownload(String str, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            if (j > 0) {
                str = str + j;
            }
            AbstractTask abstractTask = this.mAllTaskMap.get(str);
            if (abstractTask != null) {
                abstractTask.stop(z);
            }
            new Thread(new Runnable(this, j) { // from class: com.baidu.down.request.taskmanager.BinaryTaskMng.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BinaryTaskMng this$0;
                public final /* synthetic */ long val$_id;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$_id = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TaskMsg taskMsg = new TaskMsg();
                        taskMsg._id = this.val$_id;
                        taskMsg.status = 1004;
                        this.this$0.notifyUi(taskMsg);
                    }
                }
            }).start();
        }
    }

    public void taskPriorityQueueOffer(AbstractTask abstractTask) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, abstractTask) == null) || (i2 = abstractTask.mStatus) == 1002 || i2 == 1009 || i2 == 1001) {
            return;
        }
        abstractTask.mStatus = 1009;
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.obj = abstractTask;
        this.mHandler.sendMessageAtFrontOfQueue(obtainMessage);
    }

    public void updateTaskPrioirty(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
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
}
