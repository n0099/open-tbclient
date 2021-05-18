package com.baidu.android.util.concurrent.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.util.concurrent.task.Task;
import com.bumptech.glide.load.engine.GlideException;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class TaskManager {
    public static final boolean DEBUG = false;
    public static final int MESSAGE_POST_EXECUTE = 1;
    public static final int MESSAGE_POST_PROGRESS = 2;
    public static final String TAG = "TaskManager";
    public static HashMap<String, TaskManager> sTaskManagers = new HashMap<>();
    public boolean mAutoQuit;
    public Task mCurTask;
    public IStateChangeListener mListener;
    public String mName;
    public State mState;
    public LinkedList<Task> mTaskList;
    public TaskOperation mTaskOperation;
    public Handler mThreadHandler;
    public ThreadWorker mThreadWorker;
    public Handler mUIHandler;

    /* renamed from: com.baidu.android.util.concurrent.task.TaskManager$5  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$util$concurrent$task$Task$RunningStatus;

        static {
            int[] iArr = new int[Task.RunningStatus.values().length];
            $SwitchMap$com$baidu$android$util$concurrent$task$Task$RunningStatus = iArr;
            try {
                iArr[Task.RunningStatus.WORK_THREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$util$concurrent$task$Task$RunningStatus[Task.RunningStatus.UI_THREAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface IStateChangeListener {
        void onStateChanged(TaskManager taskManager, State state, State state2);
    }

    /* loaded from: classes.dex */
    public enum State {
        NEW,
        RUNNING,
        PAUSED,
        FINISHED,
        READY
    }

    /* loaded from: classes.dex */
    public enum TaskManagerState {
        CONTINUE,
        PAUSE
    }

    public TaskManager() {
        this.mTaskList = new LinkedList<>();
        this.mTaskOperation = new TaskOperation();
        this.mThreadWorker = null;
        this.mCurTask = null;
        this.mState = State.NEW;
        this.mName = null;
        this.mListener = null;
        this.mThreadHandler = null;
        this.mAutoQuit = true;
        this.mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.android.util.concurrent.task.TaskManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 != 2) {
                        return;
                    }
                    TaskManager.this.postProgress(message.obj);
                    return;
                }
                TaskManager.this.executeTask((Task) message.obj);
                TaskManager.this.runNextTask();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInBackground() {
        this.mCurTask = null;
        if (this.mTaskList.isEmpty()) {
            return;
        }
        Task task = this.mTaskList.get(0);
        this.mCurTask = task;
        synchronized (this.mTaskList) {
            this.mTaskList.remove(0);
        }
        int i2 = AnonymousClass5.$SwitchMap$com$baidu$android$util$concurrent$task$Task$RunningStatus[task.getRunningStatus().ordinal()];
        if (i2 == 1) {
            executeTask(task);
            runNextTask();
        } else if (i2 != 2) {
        } else {
            this.mUIHandler.obtainMessage(1, task).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTask(Task task) {
        if (task != null) {
            task.setStatus(Task.Status.RUNNING);
            printExecuteTaskState(task);
            try {
                this.mTaskOperation = task.onExecute(this.mTaskOperation);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            task.setStatus(Task.Status.FINISHED);
        }
    }

    public static HashMap<String, TaskManager> getTaskManagers() {
        return sTaskManagers;
    }

    private boolean isRunNext() {
        TaskOperation taskOperation = this.mTaskOperation;
        boolean z = taskOperation == null || taskOperation.getTaskManagerStatus() == TaskManagerState.CONTINUE;
        LinkedList<Task> linkedList = this.mTaskList;
        boolean z2 = linkedList != null && linkedList.size() > 0;
        if (!z2) {
            if (this.mAutoQuit) {
                quitLooper();
            } else {
                setState(State.READY);
            }
        }
        return z && z2;
    }

    private void performStateChange(final State state, final State state2) {
        if (this.mListener != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.android.util.concurrent.task.TaskManager.4
                @Override // java.lang.Runnable
                public void run() {
                    TaskManager.this.mListener.onStateChanged(TaskManager.this, state, state2);
                }
            });
        }
    }

    public static void popTaskManager(TaskManager taskManager) {
        if (taskManager != null) {
            sTaskManagers.remove(taskManager.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postProgress(Object obj) {
        Task task = this.mCurTask;
        if (task != null) {
            task.onProgressUpdate(obj);
        }
    }

    private void printTaskManagerState(State state, State state2) {
    }

    public static void pushTaskManager(TaskManager taskManager) {
        if (taskManager != null) {
            String name = taskManager.getName();
            if (TextUtils.isEmpty(name)) {
                return;
            }
            sTaskManagers.put(name, taskManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runNextTask() {
        if (isRunNext()) {
            execute();
        }
    }

    private void setState(State state) {
        State state2 = this.mState;
        this.mState = state;
        if (state == State.FINISHED) {
            popTaskManager(this);
        } else {
            pushTaskManager(this);
        }
        if (state2 != state) {
            printTaskManagerState(state2, state);
            performStateChange(state2, state);
        }
    }

    private void startThread() {
        if (this.mThreadWorker == null) {
            String taskManager = TextUtils.isEmpty(this.mName) ? toString() : this.mName;
            this.mThreadWorker = new ThreadWorker("TaskManager_Thread_" + taskManager);
            this.mThreadHandler = new Handler(this.mThreadWorker.getLooper());
            setState(State.READY);
        }
    }

    public void cancelCurrentTask() {
        Task task = this.mCurTask;
        if (task != null) {
            task.cancel();
        }
    }

    public void execute() {
        if (this.mTaskList.size() > 0) {
            startThread();
            setState(State.RUNNING);
            this.mThreadHandler.post(new Runnable() { // from class: com.baidu.android.util.concurrent.task.TaskManager.2
                @Override // java.lang.Runnable
                public void run() {
                    TaskManager.this.doInBackground();
                }
            });
        } else if (this.mAutoQuit) {
            quitLooper();
        } else {
            setState(State.READY);
        }
    }

    public String getName() {
        return this.mName;
    }

    public State getState() {
        return this.mState;
    }

    public TaskOperation getTaskOperation() {
        return this.mTaskOperation;
    }

    public boolean isFinished() {
        return this.mState == State.FINISHED;
    }

    public final void join() {
        ThreadWorker threadWorker = this.mThreadWorker;
        if (threadWorker != null) {
            threadWorker.join();
        }
    }

    public TaskManager next(Task task) {
        if (task != null) {
            synchronized (this.mTaskList) {
                task.setTaskId(this.mTaskList.size() + 1);
                this.mTaskList.add(task);
            }
            return this;
        }
        throw new NullPointerException("task is null");
    }

    public void pause() {
        if (this.mThreadWorker != null) {
            setState(State.PAUSED);
            this.mThreadWorker.pause();
        }
    }

    public void postExecute(final Task task) {
        if (task != null) {
            if (Task.RunningStatus.UI_THREAD == task.getRunningStatus()) {
                this.mUIHandler.post(new Runnable() { // from class: com.baidu.android.util.concurrent.task.TaskManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        TaskManager.this.executeTask(task);
                    }
                });
                return;
            }
            return;
        }
        throw new NullPointerException("Task can NOT be null.");
    }

    public void printExecuteTaskState(Task task) {
    }

    public void publishProgress(Object obj) {
        this.mUIHandler.obtainMessage(2, obj).sendToTarget();
    }

    public void quitLooper() {
        ThreadWorker threadWorker = this.mThreadWorker;
        if (threadWorker != null) {
            threadWorker.quit();
            this.mThreadWorker = null;
        }
        this.mThreadHandler = null;
        setState(State.FINISHED);
    }

    public void removeTask(Task task) {
        synchronized (this.mTaskList) {
            this.mTaskList.remove(task);
            if (this.mTaskList.isEmpty()) {
                quitLooper();
            }
        }
    }

    public void removeTasks() {
        synchronized (this.mTaskList) {
            if (this.mTaskList.size() > 0) {
                this.mTaskList.clear();
                quitLooper();
            }
        }
    }

    public void resume() {
        if (this.mThreadWorker != null) {
            setState(State.RUNNING);
            this.mThreadWorker.restart();
        }
    }

    public void setStateChangeListener(IStateChangeListener iStateChangeListener) {
        this.mListener = iStateChangeListener;
    }

    public String toString() {
        return "Name = " + this.mName + GlideException.IndentedAppendable.INDENT + "State = " + this.mState + GlideException.IndentedAppendable.INDENT + super.toString();
    }

    public void execute(TaskOperation taskOperation) {
        if (taskOperation != null) {
            this.mTaskOperation = taskOperation;
        }
        execute();
    }

    public TaskManager(String str) {
        this(str, true);
    }

    public TaskManager(String str, boolean z) {
        this.mTaskList = new LinkedList<>();
        this.mTaskOperation = new TaskOperation();
        this.mThreadWorker = null;
        this.mCurTask = null;
        this.mState = State.NEW;
        this.mName = null;
        this.mListener = null;
        this.mThreadHandler = null;
        this.mAutoQuit = true;
        this.mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.android.util.concurrent.task.TaskManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 != 2) {
                        return;
                    }
                    TaskManager.this.postProgress(message.obj);
                    return;
                }
                TaskManager.this.executeTask((Task) message.obj);
                TaskManager.this.runNextTask();
            }
        };
        this.mName = str;
        this.mAutoQuit = z;
    }
}
