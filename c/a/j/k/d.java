package c.a.j.k;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final a f3251d;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.baidu.bdtask.strategy.impl.lifecycle.b a;

    /* renamed from: b  reason: collision with root package name */
    public final com.baidu.bdtask.strategy.impl.lifecycle.c f3252b;

    /* renamed from: c  reason: collision with root package name */
    public final com.baidu.bdtask.framework.redux.d<com.baidu.bdtask.ctrl.b, c.a.j.f.d> f3253c;

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

        public final d a(com.baidu.bdtask.framework.redux.d<com.baidu.bdtask.ctrl.b, c.a.j.f.d> dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? new d(dVar, null) : (d) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1357089306, "Lc/a/j/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1357089306, "Lc/a/j/k/d;");
                return;
            }
        }
        f3251d = new a(null);
    }

    public d(com.baidu.bdtask.framework.redux.d<com.baidu.bdtask.ctrl.b, c.a.j.f.d> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3253c = dVar;
        this.a = new com.baidu.bdtask.strategy.impl.lifecycle.b(dVar);
        this.f3252b = new com.baidu.bdtask.strategy.impl.lifecycle.c(this.f3253c);
    }

    public void a(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subTaskState) == null) {
            if (f(subTaskState).isPassiveTask()) {
                this.f3252b.h(subTaskState);
            } else if (f(subTaskState).isInitiActiveTask()) {
                this.a.h(subTaskState);
            }
        }
    }

    public void b(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subTaskState) == null) {
            if (f(subTaskState).isPassiveTask()) {
                this.f3252b.i(subTaskState);
            } else if (f(subTaskState).isInitiActiveTask()) {
                this.a.i(subTaskState);
            }
        }
    }

    public void c(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, subTaskState) == null) {
            if (f(subTaskState).isPassiveTask()) {
                this.f3252b.j(subTaskState);
            } else if (f(subTaskState).isInitiActiveTask()) {
                this.a.j(subTaskState);
            }
        }
    }

    public void d(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, subTaskState) == null) {
            if (f(subTaskState).isPassiveTask()) {
                this.f3252b.k(subTaskState);
            } else if (f(subTaskState).isInitiActiveTask()) {
                this.a.k(subTaskState);
            }
        }
    }

    public void e(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, subTaskState) == null) {
            if (f(subTaskState).isPassiveTask()) {
                this.f3252b.l(subTaskState);
            } else if (f(subTaskState).isInitiActiveTask()) {
                this.a.l(subTaskState);
            }
        }
    }

    public final TaskInfo f(SubTaskState subTaskState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, subTaskState)) == null) ? subTaskState.getTaskInfo() : (TaskInfo) invokeL.objValue;
    }

    public /* synthetic */ d(com.baidu.bdtask.framework.redux.d dVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar);
    }
}
