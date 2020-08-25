package com.baidu.android.util.concurrent.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.util.concurrent.task.Task;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class TaskManager {
    private static final boolean DEBUG = false;
    private static final int MESSAGE_POST_EXECUTE = 1;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final String TAG = "TaskManager";
    private static HashMap<String, TaskManager> sTaskManagers = new HashMap<>();
    private boolean mAutoQuit;
    private Task mCurTask;
    private IStateChangeListener mListener;
    private String mName;
    private State mState;
    private LinkedList<Task> mTaskList;
    private TaskOperation mTaskOperation;
    private Handler mThreadHandler;
    private ThreadWorker mThreadWorker;
    private Handler mUIHandler;

    /* loaded from: classes8.dex */
    public interface IStateChangeListener {
        void onStateChanged(TaskManager taskManager, State state, State state2);
    }

    /* loaded from: classes8.dex */
    public enum State {
        NEW,
        RUNNING,
        PAUSED,
        FINISHED,
        READY
    }

    /* loaded from: classes8.dex */
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
                switch (message.what) {
                    case 1:
                        TaskManager.this.executeTask((Task) message.obj);
                        TaskManager.this.runNextTask();
                        return;
                    case 2:
                        TaskManager.this.postProgress(message.obj);
                        return;
                    default:
                        return;
                }
            }
        };
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
                switch (message.what) {
                    case 1:
                        TaskManager.this.executeTask((Task) message.obj);
                        TaskManager.this.runNextTask();
                        return;
                    case 2:
                        TaskManager.this.postProgress(message.obj);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mName = str;
        this.mAutoQuit = z;
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

    public void execute(TaskOperation taskOperation) {
        if (taskOperation != null) {
            this.mTaskOperation = taskOperation;
        }
        execute();
    }

    public void postExecute(final Task task) {
        if (task == null) {
            throw new NullPointerException("Task can NOT be null.");
        }
        if (Task.RunningStatus.UI_THREAD == task.getRunningStatus()) {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.android.util.concurrent.task.TaskManager.3
                @Override // java.lang.Runnable
                public void run() {
                    TaskManager.this.executeTask(task);
                }
            });
        }
    }

    public void publishProgress(Object obj) {
        this.mUIHandler.obtainMessage(2, obj).sendToTarget();
    }

    public void cancelCurrentTask() {
        if (this.mCurTask != null) {
            this.mCurTask.cancel();
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

    public void removeTask(Task task) {
        synchronized (this.mTaskList) {
            this.mTaskList.remove(task);
            if (this.mTaskList.isEmpty()) {
                quitLooper();
            }
        }
    }

    public void setStateChangeListener(IStateChangeListener iStateChangeListener) {
        this.mListener = iStateChangeListener;
    }

    public TaskOperation getTaskOperation() {
        return this.mTaskOperation;
    }

    public String getName() {
        return this.mName;
    }

    public void pause() {
        if (this.mThreadWorker != null) {
            setState(State.PAUSED);
            this.mThreadWorker.pause();
        }
    }

    public void resume() {
        if (this.mThreadWorker != null) {
            setState(State.RUNNING);
            this.mThreadWorker.restart();
        }
    }

    public void quitLooper() {
        if (this.mThreadWorker != null) {
            this.mThreadWorker.quit();
            this.mThreadWorker = null;
        }
        this.mThreadHandler = null;
        setState(State.FINISHED);
    }

    public final void join() {
        if (this.mThreadWorker != null) {
            this.mThreadWorker.join();
        }
    }

    public State getState() {
        return this.mState;
    }

    public boolean isFinished() {
        return this.mState == State.FINISHED;
    }

    public static HashMap<String, TaskManager> getTaskManagers() {
        return sTaskManagers;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name = ").append(this.mName).append("  ");
        sb.append("State = ").append(this.mState).append("  ");
        sb.append(super.toString());
        return sb.toString();
    }

    protected void printExecuteTaskState(Task task) {
    }

    private void setState(State state) {
        State state2 = this.mState;
        this.mState = state;
        if (this.mState == State.FINISHED) {
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
            this.mThreadWorker = new ThreadWorker("TaskManager_Thread_" + (TextUtils.isEmpty(this.mName) ? toString() : this.mName));
            this.mThreadHandler = new Handler(this.mThreadWorker.getLooper());
            setState(State.READY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInBackground() {
        this.mCurTask = null;
        if (!this.mTaskList.isEmpty()) {
            Task task = this.mTaskList.get(0);
            this.mCurTask = task;
            synchronized (this.mTaskList) {
                this.mTaskList.remove(0);
            }
            switch (task.getRunningStatus()) {
                case WORK_THREAD:
                    executeTask(task);
                    runNextTask();
                    return;
                case UI_THREAD:
                    this.mUIHandler.obtainMessage(1, task).sendToTarget();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runNextTask() {
        if (isRunNext()) {
            execute();
        }
    }

    private boolean isRunNext() {
        boolean z;
        boolean z2;
        if (this.mTaskOperation != null) {
            z = this.mTaskOperation.getTaskManagerStatus() == TaskManagerState.CONTINUE;
        } else {
            z = true;
        }
        if (this.mTaskList != null) {
            z2 = this.mTaskList.size() > 0;
        } else {
            z2 = false;
        }
        if (!z2) {
            if (this.mAutoQuit) {
                quitLooper();
            } else {
                setState(State.READY);
            }
        }
        return z && z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTask(Task task) {
        if (task != null) {
            task.setStatus(Task.Status.RUNNING);
            printExecuteTaskState(task);
            try {
                this.mTaskOperation = task.onExecute(this.mTaskOperation);
            } catch (Exception e) {
                e.printStackTrace();
            }
            task.setStatus(Task.Status.FINISHED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postProgress(Object obj) {
        if (this.mCurTask != null) {
            this.mCurTask.onProgressUpdate(obj);
        }
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

    private void printTaskManagerState(State state, State state2) {
    }

    private static void pushTaskManager(TaskManager taskManager) {
        if (taskManager != null) {
            String name = taskManager.getName();
            if (!TextUtils.isEmpty(name)) {
                sTaskManagers.put(name, taskManager);
            }
        }
    }

    private static void popTaskManager(TaskManager taskManager) {
        if (taskManager != null) {
            sTaskManagers.remove(taskManager.getName());
        }
    }
}
