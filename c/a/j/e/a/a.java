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
    public final c.a.j.h.c.a.d f3089b;

    /* renamed from: c.a.j.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0160a implements c.a.j.h.c.a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public C0160a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            TaskBuoyViewData k;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (taskBuoyViewModel = this.a.a) == null || (c2 = taskBuoyViewModel.c()) == null || (taskBuoyViewModel2 = this.a.a) == null || (a = taskBuoyViewModel2.a()) == null || (k = a.k()) == null) {
                return;
            }
            g.a.b(k.getUiConfig().h(), c2, k.getTaskStatus());
        }

        @Override // c.a.j.h.c.a.d
        public void b() {
            TaskBuoyViewModel taskBuoyViewModel;
            TaskInfo c2;
            TaskBuoyViewModel taskBuoyViewModel2;
            c.a.j.h.c.c.c.a<TaskBuoyViewData> a;
            TaskBuoyViewData k;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (taskBuoyViewModel = this.a.a) == null || (c2 = taskBuoyViewModel.c()) == null || (taskBuoyViewModel2 = this.a.a) == null || (a = taskBuoyViewModel2.a()) == null || (k = a.k()) == null) {
                return;
            }
            g.a.a(k.getUiConfig().h(), c2, k.getTaskStatus());
        }
    }

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
                return;
            }
        }
        this.f3089b = new C0160a(this);
    }

    public c.a.j.h.c.a.d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3089b : (c.a.j.h.c.a.d) invokeV.objValue;
    }

    @CallSuper
    public void d(TaskBuoyViewModel taskBuoyViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskBuoyViewModel) == null) {
            this.a = taskBuoyViewModel;
        }
    }
}
