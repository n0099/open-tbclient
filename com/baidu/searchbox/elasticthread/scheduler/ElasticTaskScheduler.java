package com.baidu.searchbox.elasticthread.scheduler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.queue.QueueManager;
import com.baidu.searchbox.elasticthread.statistic.RealTimeStatusPrinter;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
/* loaded from: classes17.dex */
public class ElasticTaskScheduler {
    private static final boolean DEBUG = false;
    private static final int MSG_DREDGE_CONCURRENT = 3;
    private static final int MSG_INSERT_CONCURRENT_TASK = 1;
    private static final int MSG_INSERT_SERIAL_TASK = 4;
    private static final int MSG_REAL_TIME_STATUS_PRINT = 9;
    private static final int MSG_RECORD_DATA_BEGIN = 7;
    private static final int MSG_RECORD_DATA_END = 8;
    private static final int MSG_SCHEDULE_CONCURRENT = 2;
    private static final int MSG_SCHEDULE_SERIAL = 5;
    private static final int MSG_SERIAL_DREDGE = 6;
    private static final String TAG = "ElasticTaskScheduler";
    private static volatile ElasticTaskScheduler sInstance = null;
    private ArteryManager mArteryManager;
    private DredgeManager mDredgeManager;
    private QueueManager mQueueManager;
    private Handler mSchedulerHandler;
    private HandlerThread mSchedulerThread;
    private SerialManager mSerialManager;
    private StatisticRecorder mStatisticRecorder;

    public static ElasticTaskScheduler getInstance() {
        if (sInstance == null) {
            synchronized (ElasticTaskScheduler.class) {
                if (sInstance == null) {
                    sInstance = new ElasticTaskScheduler();
                }
            }
        }
        return sInstance;
    }

    private ElasticTaskScheduler() {
        synchronized (ElasticConfig.getElasticConfigMutex()) {
            initElasticThread();
        }
    }

    private void initElasticThread() {
        ElasticConfig.updateConfig();
        ElasticConfig.setElasticThreadInitiated(true);
        this.mArteryManager = new ArteryManager();
        this.mDredgeManager = new DredgeManager();
        this.mQueueManager = new QueueManager();
        this.mSerialManager = new SerialManager();
        this.mStatisticRecorder = new StatisticRecorder();
        this.mSchedulerThread = new HandlerThread("ElasticSchedulerThread");
        this.mSchedulerThread.start();
        this.mSchedulerThread.setPriority(10);
        this.mSchedulerHandler = new Handler(this.mSchedulerThread.getLooper()) { // from class: com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        if (message.obj instanceof TaskMsgInfo) {
                            TaskMsgInfo taskMsgInfo = (TaskMsgInfo) message.obj;
                            ElasticTaskScheduler.this.mQueueManager.insertTask(taskMsgInfo.runnable, taskMsgInfo.taskName, taskMsgInfo.priority);
                        }
                        ElasticTaskScheduler.this.scheduleConcurrentTasks();
                        return;
                    case 2:
                        ElasticTaskScheduler.this.scheduleConcurrentTasks();
                        return;
                    case 3:
                        if (ElasticTaskScheduler.this.mDredgeManager.adjustDredgeStrategy() > 0) {
                            ElasticTaskScheduler.this.scheduleConcurrentTasks();
                            return;
                        }
                        return;
                    case 4:
                        if (message.obj instanceof TaskMsgInfo) {
                            TaskMsgInfo taskMsgInfo2 = (TaskMsgInfo) message.obj;
                            ElasticTaskScheduler.this.mSerialManager.insertTask(taskMsgInfo2.runnable, taskMsgInfo2.taskName, taskMsgInfo2.priority);
                            ElasticTaskScheduler.this.scheduleNextSerialTask();
                            return;
                        }
                        return;
                    case 5:
                        ElasticTaskScheduler.this.scheduleNextSerialTask();
                        return;
                    case 6:
                        ElasticTaskScheduler.this.mSerialManager.checkBlockAndDredge();
                        return;
                    case 7:
                        ElasticTaskScheduler.this.beginRecord();
                        return;
                    case 8:
                        ElasticTaskScheduler.this.endRecord();
                        return;
                    case 9:
                        RealTimeStatusPrinter.getInstance().printRealTimeData();
                        ElasticTaskScheduler.this.postPrintRealTimeData(ElasticConfig.REAL_TIME_PRINTER_INTERVAL);
                        return;
                    default:
                        return;
                }
            }
        };
        postPrintRealTimeData(ElasticConfig.REAL_TIME_PRINTER_INTERVAL);
    }

    public void postSerialTask(Runnable runnable, String str, int i) {
        postSerialTaskDelay(runnable, str, i, 0L);
    }

    public void postSerialTaskDelay(Runnable runnable, String str, int i, long j) {
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = new TaskMsgInfo(runnable, str, i);
        this.mSchedulerHandler.sendMessageDelayed(obtain, j);
    }

    public void postSerialSchedule() {
        postSerialScheduleDelay(0L);
    }

    public void postSerialScheduleDelay(long j) {
        Message obtain = Message.obtain();
        obtain.what = 5;
        this.mSchedulerHandler.sendMessageDelayed(obtain, j);
    }

    public void postSerialDredge() {
        postSerialDredgeDelay(0L);
    }

    public void postSerialDredgeDelay(long j) {
        Message obtain = Message.obtain();
        obtain.what = 6;
        this.mSchedulerHandler.sendMessageDelayed(obtain, j);
    }

    public void postConcurrentTask(Runnable runnable, String str, int i) {
        postConcurrentTaskDelay(runnable, str, i, 0L);
    }

    public void postConcurrentTaskDelay(Runnable runnable, String str, int i, long j) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = new TaskMsgInfo(runnable, str, i);
        this.mSchedulerHandler.sendMessageDelayed(obtain, j);
    }

    public void postConcurrentSchedule() {
        postConcurrentScheduleDelay(0L);
    }

    public void postConcurrentScheduleDelay(long j) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        this.mSchedulerHandler.sendMessageDelayed(obtain, j);
    }

    public void postConcurrentDredge() {
        postConcurrentDredgeDelay(0L);
    }

    public void postConcurrentDredgeDelay(long j) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.mSchedulerHandler.sendMessageDelayed(obtain, j);
    }

    public void postBeginRecord() {
        Message obtain = Message.obtain();
        obtain.what = 7;
        this.mSchedulerHandler.sendMessage(obtain);
    }

    public void postEndRecord() {
        Message obtain = Message.obtain();
        obtain.what = 8;
        this.mSchedulerHandler.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postPrintRealTimeData(long j) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class TaskMsgInfo {
        public int priority;
        public Runnable runnable;
        public String taskName;

        public TaskMsgInfo(Runnable runnable, String str, int i) {
            this.runnable = runnable;
            this.taskName = str;
            this.priority = i;
        }
    }

    private boolean scheduleNextConcurrentTask() {
        ElasticTask next = this.mQueueManager.getNext();
        if (next == null) {
            return false;
        }
        if (this.mArteryManager.execute(next)) {
            this.mQueueManager.removeTask(next);
            return true;
        } else if (this.mDredgeManager.execute(next)) {
            this.mQueueManager.removeTask(next);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int scheduleConcurrentTasks() {
        int i = 0;
        while (scheduleNextConcurrentTask()) {
            i++;
        }
        postConcurrentDredge();
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean scheduleNextSerialTask() {
        return this.mSerialManager.scheduleNextTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginRecord() {
        if (!ElasticConfig.elasticExecutorDisabled()) {
            if (this.mStatisticRecorder.getRecordStatus() == Recordable.RecordStatus.RECORDING) {
                Log.w(TAG, "BeginRecord is called inside a record life cycle. The data in last record life cycle would be cleared and a new record life cycle would begin based on the time of this call");
            }
            this.mStatisticRecorder.onRecordBegin();
            this.mArteryManager.onRecordBegin();
            this.mDredgeManager.onRecordBegin();
            this.mQueueManager.onRecordBegin();
            this.mSerialManager.onRecordBegin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endRecord() {
        if (!ElasticConfig.elasticExecutorDisabled()) {
            if (this.mStatisticRecorder.getRecordStatus() != Recordable.RecordStatus.RECORDING) {
                Log.w(TAG, "EndRecord is called outside of a record life cycle. This call will do noting.Please call BeginRecord first.");
                return;
            }
            this.mStatisticRecorder.onRecordEnd();
            this.mArteryManager.onRecordEnd();
            this.mDredgeManager.onRecordEnd();
            this.mQueueManager.onRecordEnd();
            this.mSerialManager.onRecordEnd();
            if (this.mStatisticRecorder.getRecordElapseTime() > 30000) {
                this.mStatisticRecorder.uploadData();
            }
        }
    }

    public QueueManager getQueueManager() {
        return this.mQueueManager;
    }

    public ArteryManager getArteryManager() {
        return this.mArteryManager;
    }

    public DredgeManager getDredgeManager() {
        return this.mDredgeManager;
    }

    public SerialManager getSerialManager() {
        return this.mSerialManager;
    }
}
