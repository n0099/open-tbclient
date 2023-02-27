package com.baidu.bdtask.ctrl;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.tieba.tr;
import com.baidu.tieba.yp;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u0007¢\u0006\u0004\bF\u0010\u0005J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001aJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001d\u0010\u001aJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010\u0017J\u0017\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b \u0010\u0017J\u0017\u0010!\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b!\u0010\u0017J!\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010%J4\u0010+\u001a\u0004\u0018\u00010\u00182#\b\u0002\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020)0&¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u000eH\u0016¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J'\u00106\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u000eH\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b:\u0010\tJ\u0017\u0010<\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u000eH\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00032\b\u0010>\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b?\u0010=J\u001f\u0010A\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010#¢\u0006\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/baidu/bdtask/ctrl/BDPTaskState;", "Lcom/baidu/tieba/yp;", "Lcom/baidu/tieba/tr;", "", "cleanAllCallbacks", "()V", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "clear", "(Lcom/baidu/bdtask/model/info/TaskInfo;)V", "clearProcess", "copy", "()Lcom/baidu/bdtask/ctrl/BDPTaskState;", "", "", "actionIds", "", "", "Lcom/baidu/bdtask/TaskState;", "findAllTaskStateByActionIds", "([Ljava/lang/String;)Ljava/util/Map;", "actionId", "findCurActiveTaskInfoByActionId", "(Ljava/lang/String;)Lcom/baidu/bdtask/model/info/TaskInfo;", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "findCurActiveTaskStateByActionId", "(Ljava/lang/String;)Lcom/baidu/bdtask/ctrl/SubTaskState;", "findPassiveTaskStateByActionId", "singleKey", "findSubTaskStateBySingleKey", TaskInfo.keyActTaskId, "findTaskInfoByActTaskId", "findTaskInfoByActionId", "findTaskInfoBySingleKey", "", "Lcom/baidu/bdtask/callbacks/TaskCallback;", "getCallback", "(Lcom/baidu/bdtask/model/info/TaskInfo;)Ljava/util/Set;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "filter", "getCurActiveTaskState", "(Lkotlin/Function1;)Lcom/baidu/bdtask/ctrl/SubTaskState;", "getSerializeData", "()Ljava/lang/String;", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", TaskStatus.key, "onChanged", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;)V", "", "errorCode", "errorMsg", "onError", "(Lcom/baidu/bdtask/model/info/TaskInfo;ILjava/lang/String;)V", "peekNextAvailableTask", "()Lcom/baidu/bdtask/ctrl/SubTaskState;", "removeSubTaskByTaskInfo", "serializeData", "restoreFromSerializeData", "(Ljava/lang/String;)V", "taskTreeData", "restoreTaskStateTree", WebChromeClient.KEY_ARG_CALLBACK, "setTaskInfo", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/callbacks/TaskCallback;)V", "Lcom/baidu/bdtask/ctrl/model/TaskStateQueue;", "taskInfoQueue", "Lcom/baidu/bdtask/ctrl/model/TaskStateQueue;", "<init>", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class b implements yp, tr<b> {
    public static /* synthetic */ Interceptable $ic;
    public static final ReentrantLock b;
    public static final a c;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.bdtask.ctrl.model.a a;

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final ReentrantLock a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.b;
            }
            return (ReentrantLock) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1522386819, "Lcom/baidu/bdtask/ctrl/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1522386819, "Lcom/baidu/bdtask/ctrl/b;");
                return;
            }
        }
        c = new a(null);
        b = new ReentrantLock(true);
    }

    public b() {
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
        this.a = new com.baidu.bdtask.ctrl.model.a();
    }

    public final SubTaskState j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a.k();
        }
        return (SubTaskState) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a.q();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.bdtask.ctrl.b */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ SubTaskState c(b bVar, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = BDPTaskState$getCurActiveTaskState$1.INSTANCE;
        }
        return bVar.d(function1);
    }

    @Override // com.baidu.tieba.yp
    public void a(TaskInfo taskInfo, TaskStatus taskStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, taskInfo, taskStatus) == null) {
            ReentrantLock a2 = c.a();
            a2.lock();
            try {
                TaskInfo deepCopy = taskInfo.deepCopy();
                TaskStatus deepCopy2 = taskStatus.deepCopy();
                Set<yp> n = n(taskInfo);
                if (n != null) {
                    for (yp ypVar : n) {
                        if (ypVar != null) {
                            ypVar.a(deepCopy, deepCopy2);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } finally {
                a2.unlock();
            }
        }
    }

    @Override // com.baidu.tieba.yp
    public void b(TaskInfo taskInfo, int i, String str) {
        TaskInfo taskInfo2;
        yp ypVar;
        TaskInfo taskInfo3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo, i, str) == null) {
            ReentrantLock a2 = c.a();
            a2.lock();
            try {
                try {
                    TaskInfo f = f(taskInfo.getSingleKey());
                    if (f != null) {
                        taskInfo2 = f.deepCopy();
                    } else {
                        taskInfo2 = null;
                    }
                    Set<yp> n = n(taskInfo);
                    if (n != null) {
                        for (yp ypVar2 : n) {
                            if (ypVar2 != null) {
                                if (taskInfo2 != null) {
                                    ypVar = ypVar2;
                                    taskInfo3 = r3.copy((r24 & 1) != 0 ? r3.id : null, (r24 & 2) != 0 ? r3.actionId : null, (r24 & 4) != 0 ? r3.type : 0, (r24 & 8) != 0 ? r3.token : null, (r24 & 16) != 0 ? r3.behavior : 0, (r24 & 32) != 0 ? r3.actTaskId : null, (r24 & 64) != 0 ? r3.fingerprint : null, (r24 & 128) != 0 ? r3.taskRule : null, (r24 & 256) != 0 ? r3.taskGuide : null, (r24 & 512) != 0 ? r3.taskMeter : null, (r24 & 1024) != 0 ? taskInfo2.response : null);
                                    if (taskInfo3 != null) {
                                        ypVar.b(taskInfo3, i, str);
                                    }
                                } else {
                                    ypVar = ypVar2;
                                }
                                taskInfo3 = taskInfo;
                                ypVar.b(taskInfo3, i, str);
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    a2.unlock();
                } catch (Throwable th) {
                    th = th;
                    a2.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final SubTaskState d(Function1<? super TaskInfo, Boolean> function1) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, function1)) == null) {
            SubTaskState a2 = this.a.a();
            if (a2 == null || !function1.invoke(a2.getTaskInfo()).booleanValue()) {
                return null;
            }
            return a2;
        }
        return (SubTaskState) invokeL.objValue;
    }

    public final TaskInfo f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            SubTaskState k = k(str);
            if (k != null) {
                return k.getTaskInfo();
            }
            return null;
        }
        return (TaskInfo) invokeL.objValue;
    }

    public final void h(TaskInfo taskInfo) {
        SubTaskState k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, taskInfo) == null) && (k = k(taskInfo.getSingleKey())) != null) {
            k.clear();
        }
    }

    public final SubTaskState k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (str == null) {
                return null;
            }
            return this.a.c(str);
        }
        return (SubTaskState) invokeL.objValue;
    }

    public final void l(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, taskInfo) == null) {
            this.a.j(taskInfo);
        }
    }

    public final Set<yp> n(TaskInfo taskInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, taskInfo)) == null) {
            SubTaskState c2 = this.a.c(taskInfo.getSingleKey());
            if (c2 != null) {
                return c2.getCallbacks();
            }
            return null;
        }
        return (Set) invokeL.objValue;
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || str == null) {
            return;
        }
        this.a.r(str);
    }

    public final TaskInfo p(final String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            SubTaskState d = d(new Function1<TaskInfo, Boolean>(str) { // from class: com.baidu.bdtask.ctrl.BDPTaskState$findCurActiveTaskInfoByActionId$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ String $actionId;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str};
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
                    this.$actionId = str;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(TaskInfo taskInfo) {
                    return Boolean.valueOf(invoke2(taskInfo));
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2(TaskInfo taskInfo) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo)) == null) {
                        return Intrinsics.areEqual(taskInfo.getActionId(), this.$actionId);
                    }
                    return invokeL2.booleanValue;
                }
            });
            if (d != null) {
                return d.getTaskInfo();
            }
            return null;
        }
        return (TaskInfo) invokeL.objValue;
    }

    public final SubTaskState q(final String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            return d(new Function1<TaskInfo, Boolean>(str) { // from class: com.baidu.bdtask.ctrl.BDPTaskState$findCurActiveTaskStateByActionId$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ String $actionId;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str};
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
                    this.$actionId = str;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(TaskInfo taskInfo) {
                    return Boolean.valueOf(invoke2(taskInfo));
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2(TaskInfo taskInfo) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo)) == null) {
                        return Intrinsics.areEqual(taskInfo.getActionId(), this.$actionId);
                    }
                    return invokeL2.booleanValue;
                }
            });
        }
        return (SubTaskState) invokeL.objValue;
    }

    public final TaskInfo s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            SubTaskState l = this.a.l(str);
            if (l != null) {
                return l.getTaskInfo();
            }
            return null;
        }
        return (TaskInfo) invokeL.objValue;
    }

    public final SubTaskState t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            return this.a.l(str);
        }
        return (SubTaskState) invokeL.objValue;
    }

    public final TaskInfo u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            SubTaskState p = this.a.p(str);
            if (p != null) {
                return p.getTaskInfo();
            }
            return null;
        }
        return (TaskInfo) invokeL.objValue;
    }

    public b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ReentrantLock a2 = c.a();
            a2.lock();
            try {
                com.baidu.bdtask.ctrl.model.a aVar = this.a;
                b bVar = new b();
                bVar.a = new com.baidu.bdtask.ctrl.model.a(aVar);
                return bVar;
            } finally {
                a2.unlock();
            }
        }
        return (b) invokeV.objValue;
    }

    public final Map<String, List<TaskState>> g(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) {
            ReentrantLock a2 = c.a();
            a2.lock();
            try {
                HashMap hashMap = new HashMap();
                for (SubTaskState subTaskState : this.a.f((String[]) Arrays.copyOf(strArr, strArr.length))) {
                    if (subTaskState != null) {
                        TaskInfo taskInfo = subTaskState.getTaskInfo();
                        TaskStatus taskStatus = subTaskState.getTaskStatus();
                        if (!hashMap.containsKey(taskInfo.getActionId())) {
                            hashMap.put(taskInfo.getActionId(), new ArrayList());
                        }
                        ArrayList arrayList = (ArrayList) hashMap.get(taskInfo.getActionId());
                        if (arrayList != null) {
                            arrayList.add(new TaskState(taskInfo, taskStatus));
                        }
                    }
                }
                return hashMap;
            } finally {
                a2.unlock();
            }
        }
        return (Map) invokeL.objValue;
    }

    public final void i(TaskInfo taskInfo, yp ypVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, taskInfo, ypVar) == null) {
            ReentrantLock a2 = c.a();
            a2.lock();
            try {
                this.a.i(new SubTaskState(taskInfo, new TaskStatus(0, 0, null, 0, 0L, null, TaskProcess.Companion.a(taskInfo.getTaskRule()), 63, null), ypVar));
                Unit unit = Unit.INSTANCE;
            } finally {
                a2.unlock();
            }
        }
    }
}
