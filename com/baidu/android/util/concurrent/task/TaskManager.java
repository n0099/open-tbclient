package com.baidu.android.util.concurrent.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.task.Task;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class TaskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int MESSAGE_POST_EXECUTE = 1;
    public static final int MESSAGE_POST_PROGRESS = 2;
    public static final String TAG = "TaskManager";
    public static HashMap<String, TaskManager> sTaskManagers;
    public transient /* synthetic */ FieldHolder $fh;
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
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$util$concurrent$task$Task$RunningStatus;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1652299725, "Lcom/baidu/android/util/concurrent/task/TaskManager$5;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1652299725, "Lcom/baidu/android/util/concurrent/task/TaskManager$5;");
                    return;
                }
            }
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

    /* loaded from: classes3.dex */
    public interface IStateChangeListener {
        void onStateChanged(TaskManager taskManager, State state, State state2);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State FINISHED;
        public static final State NEW;
        public static final State PAUSED;
        public static final State READY;
        public static final State RUNNING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(580979959, "Lcom/baidu/android/util/concurrent/task/TaskManager$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(580979959, "Lcom/baidu/android/util/concurrent/task/TaskManager$State;");
                    return;
                }
            }
            NEW = new State("NEW", 0);
            RUNNING = new State(TornadoLiteRuntime.STATE_RUNNING, 1);
            PAUSED = new State("PAUSED", 2);
            FINISHED = new State("FINISHED", 3);
            State state = new State("READY", 4);
            READY = state;
            $VALUES = new State[]{NEW, RUNNING, PAUSED, FINISHED, state};
        }

        public State(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class TaskManagerState {
        public static final /* synthetic */ TaskManagerState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TaskManagerState CONTINUE;
        public static final TaskManagerState PAUSE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1789190405, "Lcom/baidu/android/util/concurrent/task/TaskManager$TaskManagerState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1789190405, "Lcom/baidu/android/util/concurrent/task/TaskManager$TaskManagerState;");
                    return;
                }
            }
            CONTINUE = new TaskManagerState("CONTINUE", 0);
            TaskManagerState taskManagerState = new TaskManagerState("PAUSE", 1);
            PAUSE = taskManagerState;
            $VALUES = new TaskManagerState[]{CONTINUE, taskManagerState};
        }

        public TaskManagerState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static TaskManagerState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TaskManagerState) Enum.valueOf(TaskManagerState.class, str) : (TaskManagerState) invokeL.objValue;
        }

        public static TaskManagerState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TaskManagerState[]) $VALUES.clone() : (TaskManagerState[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-935796508, "Lcom/baidu/android/util/concurrent/task/TaskManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-935796508, "Lcom/baidu/android/util/concurrent/task/TaskManager;");
                return;
            }
        }
        sTaskManagers = new HashMap<>();
    }

    public TaskManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTaskList = new LinkedList<>();
        this.mTaskOperation = new TaskOperation();
        this.mThreadWorker = null;
        this.mCurTask = null;
        this.mState = State.NEW;
        this.mName = null;
        this.mListener = null;
        this.mThreadHandler = null;
        this.mAutoQuit = true;
        this.mUIHandler = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.android.util.concurrent.task.TaskManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TaskManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i3 = message.what;
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return;
                        }
                        this.this$0.postProgress(message.obj);
                        return;
                    }
                    this.this$0.executeTask((Task) message.obj);
                    this.this$0.runNextTask();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mCurTask = null;
            if (this.mTaskList.isEmpty()) {
                return;
            }
            Task task = this.mTaskList.get(0);
            this.mCurTask = task;
            synchronized (this.mTaskList) {
                this.mTaskList.remove(0);
            }
            int i = AnonymousClass5.$SwitchMap$com$baidu$android$util$concurrent$task$Task$RunningStatus[task.getRunningStatus().ordinal()];
            if (i == 1) {
                executeTask(task);
                runNextTask();
            } else if (i != 2) {
            } else {
                this.mUIHandler.obtainMessage(1, task).sendToTarget();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTask(Task task) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, task) == null) || task == null) {
            return;
        }
        task.setStatus(Task.Status.RUNNING);
        printExecuteTaskState(task);
        try {
            this.mTaskOperation = task.onExecute(this.mTaskOperation);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        task.setStatus(Task.Status.FINISHED);
    }

    public static HashMap<String, TaskManager> getTaskManagers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? sTaskManagers : (HashMap) invokeV.objValue;
    }

    private boolean isRunNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
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
        return invokeV.booleanValue;
    }

    private void performStateChange(State state, State state2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, this, state, state2) == null) || this.mListener == null) {
            return;
        }
        this.mUIHandler.post(new Runnable(this, state, state2) { // from class: com.baidu.android.util.concurrent.task.TaskManager.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TaskManager this$0;
            public final /* synthetic */ State val$newState;
            public final /* synthetic */ State val$oldState;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, state, state2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$oldState = state;
                this.val$newState = state2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mListener.onStateChanged(this.this$0, this.val$oldState, this.val$newState);
                }
            }
        });
    }

    public static void popTaskManager(TaskManager taskManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, taskManager) == null) || taskManager == null) {
            return;
        }
        sTaskManagers.remove(taskManager.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postProgress(Object obj) {
        Task task;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, obj) == null) || (task = this.mCurTask) == null) {
            return;
        }
        task.onProgressUpdate(obj);
    }

    private void printTaskManagerState(State state, State state2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, state, state2) == null) {
        }
    }

    public static void pushTaskManager(TaskManager taskManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, null, taskManager) == null) || taskManager == null) {
            return;
        }
        String name = taskManager.getName();
        if (TextUtils.isEmpty(name)) {
            return;
        }
        sTaskManagers.put(name, taskManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runNextTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && isRunNext()) {
            execute();
        }
    }

    private void setState(State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, state) == null) {
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
    }

    private void startThread() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && this.mThreadWorker == null) {
            String taskManager = TextUtils.isEmpty(this.mName) ? toString() : this.mName;
            this.mThreadWorker = new ThreadWorker("TaskManager_Thread_" + taskManager);
            this.mThreadHandler = new Handler(this.mThreadWorker.getLooper());
            setState(State.READY);
        }
    }

    public void cancelCurrentTask() {
        Task task;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (task = this.mCurTask) == null) {
            return;
        }
        task.cancel();
    }

    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mTaskList.size() > 0) {
                startThread();
                setState(State.RUNNING);
                this.mThreadHandler.post(new Runnable(this) { // from class: com.baidu.android.util.concurrent.task.TaskManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TaskManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.doInBackground();
                        }
                    }
                });
            } else if (this.mAutoQuit) {
                quitLooper();
            } else {
                setState(State.READY);
            }
        }
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public State getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mState : (State) invokeV.objValue;
    }

    public TaskOperation getTaskOperation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTaskOperation : (TaskOperation) invokeV.objValue;
    }

    public boolean isFinished() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mState == State.FINISHED : invokeV.booleanValue;
    }

    public final void join() {
        ThreadWorker threadWorker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (threadWorker = this.mThreadWorker) == null) {
            return;
        }
        threadWorker.join();
    }

    public TaskManager next(Task task) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, task)) == null) {
            if (task != null) {
                synchronized (this.mTaskList) {
                    task.setTaskId(this.mTaskList.size() + 1);
                    this.mTaskList.add(task);
                }
                return this;
            }
            throw new NullPointerException("task is null");
        }
        return (TaskManager) invokeL.objValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.mThreadWorker == null) {
            return;
        }
        setState(State.PAUSED);
        this.mThreadWorker.pause();
    }

    public void postExecute(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, task) == null) {
            if (task != null) {
                if (Task.RunningStatus.UI_THREAD == task.getRunningStatus()) {
                    this.mUIHandler.post(new Runnable(this, task) { // from class: com.baidu.android.util.concurrent.task.TaskManager.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TaskManager this$0;
                        public final /* synthetic */ Task val$runTask;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, task};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$runTask = task;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.executeTask(this.val$runTask);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            throw new NullPointerException("Task can NOT be null.");
        }
    }

    public void printExecuteTaskState(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, task) == null) {
        }
    }

    public void publishProgress(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, obj) == null) {
            this.mUIHandler.obtainMessage(2, obj).sendToTarget();
        }
    }

    public void quitLooper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ThreadWorker threadWorker = this.mThreadWorker;
            if (threadWorker != null) {
                threadWorker.quit();
                this.mThreadWorker = null;
            }
            this.mThreadHandler = null;
            setState(State.FINISHED);
        }
    }

    public void removeTask(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, task) == null) {
            synchronized (this.mTaskList) {
                this.mTaskList.remove(task);
                if (this.mTaskList.isEmpty()) {
                    quitLooper();
                }
            }
        }
    }

    public void removeTasks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this.mTaskList) {
                if (this.mTaskList.size() > 0) {
                    this.mTaskList.clear();
                    quitLooper();
                }
            }
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.mThreadWorker == null) {
            return;
        }
        setState(State.RUNNING);
        this.mThreadWorker.restart();
    }

    public void setStateChangeListener(IStateChangeListener iStateChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iStateChangeListener) == null) {
            this.mListener = iStateChangeListener;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "Name = " + this.mName + GlideException.IndentedAppendable.INDENT + "State = " + this.mState + GlideException.IndentedAppendable.INDENT + super.toString();
        }
        return (String) invokeV.objValue;
    }

    public void execute(TaskOperation taskOperation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, taskOperation) == null) {
            if (taskOperation != null) {
                this.mTaskOperation = taskOperation;
            }
            execute();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskManager(String str) {
        this(str, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public TaskManager(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mTaskList = new LinkedList<>();
        this.mTaskOperation = new TaskOperation();
        this.mThreadWorker = null;
        this.mCurTask = null;
        this.mState = State.NEW;
        this.mName = null;
        this.mListener = null;
        this.mThreadHandler = null;
        this.mAutoQuit = true;
        this.mUIHandler = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.android.util.concurrent.task.TaskManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TaskManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr;
                    Object[] objArr2 = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i3 = message.what;
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return;
                        }
                        this.this$0.postProgress(message.obj);
                        return;
                    }
                    this.this$0.executeTask((Task) message.obj);
                    this.this$0.runNextTask();
                }
            }
        };
        this.mName = str;
        this.mAutoQuit = z;
    }
}
