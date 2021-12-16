package c.a.j.e.a;

import androidx.annotation.CallSuper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a extends c.a.j.h.c.a.a<TaskBuoyViewData, TaskBuoyViewModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TaskBuoyViewModel a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.j.h.c.a.d f3448b;

    /* renamed from: c.a.j.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0131a implements c.a.j.h.c.a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public C0131a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.j.h.c.a.d
        public void a() {
            TaskBuoyViewModel taskBuoyViewModel;
            TaskInfo c2;
            TaskBuoyViewModel taskBuoyViewModel2;
            c.a.j.h.c.c.c.a<TaskBuoyViewData> a;
            TaskBuoyViewData k2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (taskBuoyViewModel = this.a.a) == null || (c2 = taskBuoyViewModel.c()) == null || (taskBuoyViewModel2 = this.a.a) == null || (a = taskBuoyViewModel2.a()) == null || (k2 = a.k()) == null) {
                return;
            }
            g.a.b(k2.getUiConfig().h(), c2, k2.getTaskStatus());
        }

        @Override // c.a.j.h.c.a.d
        public void b() {
            TaskBuoyViewModel taskBuoyViewModel;
            TaskInfo c2;
            TaskBuoyViewModel taskBuoyViewModel2;
            c.a.j.h.c.c.c.a<TaskBuoyViewData> a;
            TaskBuoyViewData k2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (taskBuoyViewModel = this.a.a) == null || (c2 = taskBuoyViewModel.c()) == null || (taskBuoyViewModel2 = this.a.a) == null || (a = taskBuoyViewModel2.a()) == null || (k2 = a.k()) == null) {
                return;
            }
            g.a.a(k2.getUiConfig().h(), c2, k2.getTaskStatus());
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3448b = new C0131a(this);
    }

    public c.a.j.h.c.a.d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3448b : (c.a.j.h.c.a.d) invokeV.objValue;
    }

    @CallSuper
    public void d(TaskBuoyViewModel taskBuoyViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskBuoyViewModel) == null) {
            this.a = taskBuoyViewModel;
        }
    }
}
