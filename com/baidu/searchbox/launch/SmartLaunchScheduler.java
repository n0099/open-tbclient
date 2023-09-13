package com.baidu.searchbox.launch;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class SmartLaunchScheduler {
    public static final String ADJUST_SCHEDULE_TAG = "adjustSchedule";
    public static final int DEFAULT_RECOVERY_SCHEDULE_DELAY_TIME = 30000;
    public static final String TAG = "SmartLaunchManager";
    public static SmartLaunchScheduler instance;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static ScheduleStrategy strategy = null;
    public static boolean mIsScheduleInterrupted = false;
    public static String mInterruptingBusiness = null;
    public static String mInterruptedAndAdjustedStrategyBusiness = null;
    public static boolean mIsScheduleEnd = false;
    public static boolean sIsIdleScheduling = false;
    public static boolean sIsAllowSchedule = false;
    public LinkedList<SmartLaunchTask> mIdleQueue = new LinkedList<>();
    public List<SmartLaunchTask> mRegisterTaskList = new ArrayList();
    public Handler mMainHandler = null;
    public int idleTaskCount = 0;
    public int idleDelayTaskCount = 0;

    private void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
    }

    public SmartLaunchScheduler() {
        init();
    }

    public static SmartLaunchScheduler getInstance() {
        if (instance == null) {
            instance = new SmartLaunchScheduler();
            strategy = new ScheduleStrategy();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        Handler handler = this.mMainHandler;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.mMainHandler = handler2;
        return handler2;
    }

    public List<SmartLaunchTask> getRegisteredPersonalLaunchTasks() {
        return this.mRegisterTaskList;
    }

    public boolean isScheduleEnd() {
        return mIsScheduleEnd;
    }

    public boolean isScheduleInterrupted() {
        return mIsScheduleInterrupted;
    }

    public static /* synthetic */ int access$212(SmartLaunchScheduler smartLaunchScheduler, int i) {
        int i2 = smartLaunchScheduler.idleDelayTaskCount + i;
        smartLaunchScheduler.idleDelayTaskCount = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedule(SmartLaunchTask smartLaunchTask, int i) {
        if (smartLaunchTask != null && !smartLaunchTask.isExecuted()) {
            if (i == 1) {
                this.mIdleQueue.add(0, smartLaunchTask);
            }
            List<SmartLaunchTask> dependency = smartLaunchTask.getDependency();
            if (dependency != null && dependency.size() > 0) {
                for (int i2 = 0; i2 < dependency.size(); i2++) {
                    SmartLaunchTask smartLaunchTask2 = dependency.get(i2);
                    smartLaunchTask2.setScore(smartLaunchTask.getScore());
                    schedule(smartLaunchTask2, i);
                }
            }
            if (i == 0) {
                if (!smartLaunchTask.isExecuted()) {
                    smartLaunchTask.run();
                }
                if (DEBUG) {
                    Log.d("SmartLaunchManager", "task execute : " + smartLaunchTask.getId());
                }
            } else if (i == 1) {
                smartLaunchTask.removeAllDependency();
            }
            if (!this.mRegisterTaskList.contains(smartLaunchTask)) {
                this.mRegisterTaskList.add(smartLaunchTask);
            }
        }
    }

    public void register(final SmartLaunchTask smartLaunchTask) {
        if (smartLaunchTask == null) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            getMainHandler().post(new Runnable() { // from class: com.baidu.searchbox.launch.SmartLaunchScheduler.1
                @Override // java.lang.Runnable
                public void run() {
                    SmartLaunchScheduler.this.register(smartLaunchTask);
                }
            });
        } else if (smartLaunchTask.isMainThreadIdleTask()) {
            if (DEBUG) {
                Log.d("SmartLaunchManager", "add " + smartLaunchTask.getId() + " task to idle task queue");
            }
            this.mIdleQueue.add(smartLaunchTask);
            this.idleTaskCount++;
            if (!sIsIdleScheduling && sIsAllowSchedule) {
                scheduleIdleTask();
            }
        } else {
            int scheduleStrategy = strategy.getScheduleStrategy(smartLaunchTask);
            if (scheduleStrategy == 0) {
                if (DEBUG) {
                    Log.d("SmartLaunchManager", "add " + smartLaunchTask.getId() + " task to fast task queue");
                }
                schedule(smartLaunchTask, 0);
            } else if (scheduleStrategy == 1) {
                if (DEBUG) {
                    Log.d("SmartLaunchManager", "add " + smartLaunchTask.getId() + " task to idle task queue");
                }
                this.mIdleQueue.add(smartLaunchTask);
                this.idleTaskCount++;
                if (!sIsIdleScheduling && sIsAllowSchedule) {
                    scheduleIdleTask();
                }
            } else if (DEBUG) {
                Log.d("SmartLaunchManager", "do not support strategy: " + scheduleStrategy);
                return;
            } else {
                return;
            }
            if (!this.mRegisterTaskList.contains(smartLaunchTask)) {
                this.mRegisterTaskList.add(smartLaunchTask);
            }
        }
    }

    public void scheduleIdleTask() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return;
        }
        sIsAllowSchedule = true;
        if (this.mIdleQueue.size() > 0) {
            Collections.sort(this.mIdleQueue);
            if (DEBUG) {
                Log.d("SmartLaunchManager", "idle task begin to execute");
            }
            sIsIdleScheduling = true;
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.searchbox.launch.SmartLaunchScheduler.2
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    if (SmartLaunchScheduler.DEBUG) {
                        Log.d("SmartLaunchManager", "queueIdle");
                    }
                    SmartLaunchTask smartLaunchTask = (SmartLaunchTask) SmartLaunchScheduler.this.mIdleQueue.poll();
                    if (SmartLaunchStats.getIdleTaskStartTime() == -1) {
                        SmartLaunchStats.setIdleTaskStartTime(System.currentTimeMillis());
                    }
                    if (smartLaunchTask != null) {
                        if (!smartLaunchTask.isExecuted()) {
                            Handler mainHandler = SmartLaunchScheduler.this.getMainHandler();
                            if (mainHandler != null) {
                                mainHandler.removeCallbacks(smartLaunchTask);
                                if (smartLaunchTask.getDependency() == null || smartLaunchTask.getDependency().size() <= 0) {
                                    mainHandler.post(smartLaunchTask);
                                } else {
                                    SmartLaunchScheduler.this.schedule(smartLaunchTask, 1);
                                    mainHandler.post((Runnable) SmartLaunchScheduler.this.mIdleQueue.poll());
                                }
                                if (SmartLaunchScheduler.mIsScheduleInterrupted) {
                                    return false;
                                }
                                return true;
                            }
                        } else {
                            SmartLaunchScheduler.access$212(SmartLaunchScheduler.this, 1);
                            if (SmartLaunchScheduler.mIsScheduleInterrupted) {
                                return false;
                            }
                            return true;
                        }
                    }
                    SmartLaunchStats.setIdleTaskEndTime(System.currentTimeMillis());
                    boolean unused = SmartLaunchScheduler.mIsScheduleEnd = true;
                    boolean unused2 = SmartLaunchScheduler.sIsIdleScheduling = false;
                    SmartLaunchScheduler.this.mRegisterTaskList.clear();
                    if (SmartLaunchScheduler.DEBUG) {
                        Log.d("SmartLaunchManager", "all idle tasks end");
                    }
                    SmartLaunchScheduler.this.release();
                    return false;
                }
            });
            return;
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.searchbox.launch.SmartLaunchScheduler.3
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                if (SmartLaunchStats.getIdleTaskStartTime() == -1) {
                    SmartLaunchStats.setIdleTaskStartTime(System.currentTimeMillis());
                }
                SmartLaunchStats.setIdleTaskEndTime(System.currentTimeMillis());
                return false;
            }
        });
    }
}
