package com.baidu.bdtask.ctrl;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.ctrl.model.TaskStatusRuntime;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.ar;
import com.baidu.tieba.nq;
import com.baidu.tieba.up;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010I\u001a\u00020H\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bP\u0010QJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\bJ\u0017\u0010\u001d\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u0006J\u0017\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0004¢\u0006\u0004\b \u0010\bJ\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J)\u0010,\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010$¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u00106R\u001e\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R$\u0010>\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u00101R\u0019\u0010I\u001a\u00020H8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR$\u0010O\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010N0M078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u00109¨\u0006R"}, d2 = {"Lcom/baidu/bdtask/ctrl/SubTaskState;", "Lcom/baidu/bdtask/model/ITaskModelData;", "Lcom/baidu/bdtask/callbacks/TaskCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "addCallback", "(Lcom/baidu/bdtask/callbacks/TaskCallback;)V", "addExitOnce", "()V", "cleanAllCallbacks", "cleanDuplicateId", "clear", "clearProcess", "clearProcessTags", "deepCopy", "()Lcom/baidu/bdtask/ctrl/SubTaskState;", "", "getCallbacks", "()Ljava/util/Set;", "Lcom/baidu/bdtask/ctrl/model/TaskStatusRuntime;", "getCurStatusRuntime", "()Lcom/baidu/bdtask/ctrl/model/TaskStatusRuntime;", "", "isForceCleaned", "()Z", "isGotMaxNoClickTimes", "isInWeakCallbacks", "(Lcom/baidu/bdtask/callbacks/TaskCallback;)Z", "processRuleDataMaxValueFix", "removeCallback", "reset2Running", "(Z)V", "resetExit", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "", "extraUnRegisterMsg", "updateExtraUnRegisterMsg", "(Ljava/lang/String;)V", "", "status", "statusCode", CommonTbJsBridge.FILE_DOWNLOAD_STATUS_MSG, "updateStatus", "(ILjava/lang/Integer;Ljava/lang/String;)Lcom/baidu/bdtask/ctrl/SubTaskState;", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "updateTaskInfoByMerge", "(Lcom/baidu/bdtask/model/info/TaskInfo;)V", "Lcom/baidu/bdtask/model/response/TaskResponseData;", "responseData", "updateTaskInfoWithResponse", "(Lcom/baidu/bdtask/model/response/TaskResponseData;)V", "Lcom/baidu/bdtask/callbacks/TaskCallback;", "", "callbacks", "Ljava/util/Set;", "Ljava/util/concurrent/locks/ReentrantLock;", "fairLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;", "interceptor", "Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;", "getInterceptor", "()Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;", "setInterceptor", "(Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "Lcom/baidu/bdtask/model/info/TaskInfo;", "getTaskInfo", "()Lcom/baidu/bdtask/model/info/TaskInfo;", "setTaskInfo", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", TaskStatus.key, "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "getTaskStatus", "()Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/bdtask/ctrl/WeakTaskCallback;", "weakCallbacks", "<init>", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;Lcom/baidu/bdtask/callbacks/TaskCallback;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class SubTaskState implements ITaskModelData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile up callback;
    public Set<up> callbacks;
    public final ReentrantLock fairLock;
    public ar interceptor;
    public TaskInfo taskInfo;
    public final TaskStatus taskStatus;
    public Set<WeakReference<nq>> weakCallbacks;

    public SubTaskState(TaskInfo taskInfo, TaskStatus taskStatus, up upVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskInfo, taskStatus, upVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.taskInfo = taskInfo;
        this.taskStatus = taskStatus;
        this.callback = upVar;
        this.callbacks = new HashSet();
        this.weakCallbacks = new HashSet();
        this.fairLock = new ReentrantLock(true);
        if (this.callback != null) {
            if (this.callback instanceof nq) {
                up upVar2 = this.callback;
                if (upVar2 != null && !isInWeakCallbacks(upVar2)) {
                    Set<WeakReference<nq>> set = this.weakCallbacks;
                    up upVar3 = this.callback;
                    set.add(new WeakReference<>((nq) (upVar3 instanceof nq ? upVar3 : null)));
                    return;
                }
                return;
            }
            this.callbacks.add(this.callback);
        }
    }

    public /* synthetic */ SubTaskState(TaskInfo taskInfo, TaskStatus taskStatus, up upVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(taskInfo, taskStatus, (i & 4) != 0 ? null : upVar);
    }

    public final void reset2Running(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.taskStatus.reset2Running(z);
        }
    }

    public final void setInterceptor(ar arVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, arVar) == null) {
            this.interceptor = arVar;
        }
    }

    public final void setTaskInfo(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, taskInfo) == null) {
            this.taskInfo = taskInfo;
        }
    }

    public final void updateExtraUnRegisterMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.taskStatus.getTaskStatusRuntime().setExtraUnRegisterMsg(str);
        }
    }

    public final void updateTaskInfoWithResponse(TaskResponseData taskResponseData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, taskResponseData) == null) && taskResponseData != null && !taskResponseData.isEmpty()) {
            this.taskInfo.setResponse(taskResponseData);
        }
    }

    private final boolean isInWeakCallbacks(up upVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, upVar)) == null) {
            for (WeakReference<nq> weakReference : this.weakCallbacks) {
                if (Intrinsics.areEqual(weakReference.get(), upVar)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void addCallback(up upVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, upVar) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            if (upVar != null) {
                try {
                    if (upVar instanceof nq) {
                        if (!isInWeakCallbacks(upVar)) {
                            Set<WeakReference<nq>> set = this.weakCallbacks;
                            if (!(upVar instanceof nq)) {
                                upVar = null;
                            }
                            set.add(new WeakReference<>((nq) upVar));
                        }
                    } else {
                        this.callbacks.add(upVar);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void updateTaskInfoByMerge(final TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, taskInfo) == null) && taskInfo != null && !taskInfo.isEmpty()) {
            final TaskInfo deepCopy = taskInfo.deepCopy();
            TaskInfo deepCopy2 = taskInfo.deepCopy();
            deepCopy2.setResponse(deepCopy.getResponse());
            this.taskInfo = deepCopy2;
            DebugTrace.a.c(new Function0<String>(deepCopy) { // from class: com.baidu.bdtask.ctrl.SubTaskState$updateTaskInfoByMerge$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskInfo $old;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {deepCopy};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$old = deepCopy;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "old taskinfo:" + this.$old.toJson();
                    }
                    return (String) invokeV.objValue;
                }
            });
            DebugTrace.a.c(new Function0<String>(taskInfo) { // from class: com.baidu.bdtask.ctrl.SubTaskState$updateTaskInfoByMerge$3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskInfo $taskInfo;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {taskInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$taskInfo = taskInfo;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "new taskinfo:" + this.$taskInfo.toJson();
                    }
                    return (String) invokeV.objValue;
                }
            });
        }
    }

    public static /* synthetic */ void reset2Running$default(SubTaskState subTaskState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        subTaskState.reset2Running(z);
    }

    public final void addExitOnce() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.taskInfo.isPassiveTask()) {
            this.taskStatus.getProcess().addNoClickTimes();
        }
    }

    public final void cleanDuplicateId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.taskStatus.cleanDuplicateId();
        }
    }

    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                this.taskStatus.clear();
                this.callbacks.clear();
                this.weakCallbacks.clear();
                this.interceptor = null;
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void clearProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.taskStatus.clearProcess();
            this.taskInfo.getResponse().getProcessData().resetDone();
        }
    }

    public final void clearProcessTags() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.taskStatus.getProcess().clearTags();
        }
    }

    public final TaskStatusRuntime getCurStatusRuntime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.taskStatus.getTaskStatusRuntime();
        }
        return (TaskStatusRuntime) invokeV.objValue;
    }

    public final ar getInterceptor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.interceptor;
        }
        return (ar) invokeV.objValue;
    }

    public final TaskInfo getTaskInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.taskInfo;
        }
        return (TaskInfo) invokeV.objValue;
    }

    public final TaskStatus getTaskStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.taskStatus;
        }
        return (TaskStatus) invokeV.objValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return ITaskModelData.a.a(this);
        }
        return invokeV.booleanValue;
    }

    public final boolean isForceCleaned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!this.taskInfo.isForceCleaned() && !this.taskStatus.isOffLined()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean isGotMaxNoClickTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.taskInfo.isPassiveTask()) {
                return this.taskStatus.getProcess().isGotMaxNoClickTimes();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void resetExit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.taskInfo.isPassiveTask()) {
            this.taskStatus.getProcess().cleanNoClickTimes();
        }
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return new TaskState(this.taskInfo, this.taskStatus).toJson();
        }
        return (JSONObject) invokeV.objValue;
    }

    public final void cleanAllCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                DebugTrace.a.c(new Function0<String>(this) { // from class: com.baidu.bdtask.ctrl.SubTaskState$cleanAllCallbacks$$inlined$withLock$lambda$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SubTaskState this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Set set;
                        Set set2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("clean ");
                            sb.append(this.this$0.getTaskInfo().getActionId());
                            sb.append(" callbacks:");
                            set = this.this$0.callbacks;
                            sb.append(set.size());
                            sb.append(" weakCallbacks:");
                            set2 = this.this$0.weakCallbacks;
                            sb.append(set2.size());
                            return sb.toString();
                        }
                        return (String) invokeV.objValue;
                    }
                });
                this.callbacks.clear();
                this.weakCallbacks.clear();
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.bdtask.model.ITaskModelData
    public SubTaskState deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                SubTaskState subTaskState = new SubTaskState(this.taskInfo.deepCopy(), this.taskStatus.deepCopy(), null);
                subTaskState.callbacks = this.callbacks;
                subTaskState.weakCallbacks = this.weakCallbacks;
                subTaskState.interceptor = this.interceptor;
                return subTaskState;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (SubTaskState) invokeV.objValue;
    }

    public final Set<up> getCallbacks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            try {
                HashSet hashSet = new HashSet();
                hashSet.addAll(this.callbacks);
                Iterator<WeakReference<nq>> it = this.weakCallbacks.iterator();
                while (it.hasNext()) {
                    WeakReference<nq> next = it.next();
                    if (next.get() != null) {
                        hashSet.add(next.get());
                    } else {
                        it.remove();
                    }
                }
                return hashSet;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (Set) invokeV.objValue;
    }

    public final void processRuleDataMaxValueFix() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.taskInfo.isClickAction()) {
                this.taskInfo.getTaskRule().updateMaxStay(Integer.MAX_VALUE);
                this.taskStatus.getProcess().setMaxStayTimeMS(this.taskInfo.getTaskRule().getStay());
            }
            if (this.taskInfo.isVisitAction()) {
                this.taskInfo.getTaskRule().updateMaxRepeat(Integer.MAX_VALUE);
                this.taskStatus.getProcess().setMaxRepeatTimes(this.taskInfo.getTaskRule().getRepeat());
            }
        }
    }

    public final void removeCallback(up upVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, upVar) == null) {
            ReentrantLock reentrantLock = this.fairLock;
            reentrantLock.lock();
            if (upVar == null) {
                return;
            }
            try {
                this.callbacks.remove(upVar);
                Iterator<WeakReference<nq>> it = this.weakCallbacks.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next().get(), upVar)) {
                        it.remove();
                    }
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final SubTaskState updateStatus(int i, Integer num, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048601, this, i, num, str)) == null) {
            TaskStatus taskStatus = this.taskStatus;
            taskStatus.setCurStatus(i);
            if (num != null) {
                int intValue = num.intValue();
                taskStatus.setCurStatusCode(intValue);
                if (intValue != 0) {
                    taskStatus.getTaskStatusRuntime().setHasFailed(true);
                }
            }
            if (str != null) {
                taskStatus.setCurStatusCodeMsg(str);
            }
            return this;
        }
        return (SubTaskState) invokeILL.objValue;
    }
}
