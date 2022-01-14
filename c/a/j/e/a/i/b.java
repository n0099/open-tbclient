package c.a.j.e.a.i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends TaskBuoyViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public int f3831g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.j.e.c.b f3832h;

    /* renamed from: i  reason: collision with root package name */
    public final long f3833i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.j.e.c.a f3834j;

    /* loaded from: classes.dex */
    public static final class a implements c.a.j.e.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.j.e.c.a
        public void a(long j2, long j3) {
            c.a.j.e.c.a h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (h2 = this.a.h()) == null) {
                return;
            }
            h2.a(j2, j3);
        }

        @Override // c.a.j.e.c.a
        public void onCancel() {
            c.a.j.e.c.a h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (h2 = this.a.h()) == null) {
                return;
            }
            h2.onCancel();
        }

        @Override // c.a.j.e.c.a
        public void onFinish() {
            c.a.j.e.c.a h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (h2 = this.a.h()) == null) {
                return;
            }
            h2.onFinish();
        }

        @Override // c.a.j.e.c.a
        public void onPause() {
            c.a.j.e.c.a h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (h2 = this.a.h()) == null) {
                return;
            }
            h2.onPause();
        }

        @Override // c.a.j.e.c.a
        public void onResume() {
            c.a.j.e.c.a h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (h2 = this.a.h()) == null) {
                return;
            }
            h2.onResume();
        }

        @Override // c.a.j.e.c.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.a.k()) {
                    c.a.j.e.c.a h2 = this.a.h();
                    if (h2 != null) {
                        h2.onResume();
                        return;
                    }
                    return;
                }
                c.a.j.e.c.a h3 = this.a.h();
                if (h3 != null) {
                    h3.onStart();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-911943358, "Lc/a/j/e/a/i/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-911943358, "Lc/a/j/e/a/i/b;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TaskInfo taskInfo) {
        super(taskInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TaskInfo) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3831g = 8;
        this.f3833i = taskInfo.getTaskRule().getStay();
    }

    public final c.a.j.e.c.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3834j : (c.a.j.e.c.a) invokeV.objValue;
    }

    public final long i() {
        InterceptResult invokeV;
        TaskStatus taskStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TaskState m = BDPTask.m.m(c().getActionId());
            TaskProcess process = (m == null || (taskStatus = m.getTaskStatus()) == null) ? null : taskStatus.getProcess();
            long stayDurTimeMs = this.f3833i - (process != null ? process.getStayDurTimeMs() : 0L);
            if (stayDurTimeMs < 0) {
                return 0L;
            }
            return stayDurTimeMs;
        }
        return invokeV.longValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f3831g & 4) == 4 : invokeV.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f3831g & 2) == 2 : invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.f3831g & 1) == 1 : invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && l()) {
            this.f3831g |= 4;
            c.a.j.e.c.b bVar = this.f3832h;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && j()) {
            this.f3831g |= 2;
            r();
        }
    }

    public final void o(c.a.j.e.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f3834j = aVar;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f3831g = 1;
            r();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f3831g = 8;
            c.a.j.e.c.b bVar = this.f3832h;
            if (bVar != null) {
                bVar.h();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.j.e.c.b bVar = this.f3832h;
            if (bVar != null) {
                bVar.j();
            }
            c.a.j.e.c.b bVar2 = new c.a.j.e.c.b(i(), 200L, new a(this));
            this.f3832h = bVar2;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
    }
}
