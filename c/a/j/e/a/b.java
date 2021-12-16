package c.a.j.e.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @JvmStatic
        public final c.a.j.e.a.i.a a(c.a.j.h.c.a.a<TaskBuoyViewData, TaskBuoyViewModel> aVar, c.a.j.e.a.i.b bVar, TaskInfo taskInfo) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, bVar, taskInfo)) == null) ? new c.a.j.e.a.i.a(aVar, bVar, taskInfo) : (c.a.j.e.a.i.a) invokeLLL.objValue;
        }

        @JvmStatic
        public final c.a.j.e.a.j.b b(c.a.j.h.c.a.a<TaskBuoyViewData, TaskBuoyViewModel> aVar, TaskBuoyViewModel taskBuoyViewModel, TaskInfo taskInfo) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, taskBuoyViewModel, taskInfo)) == null) ? new c.a.j.e.a.j.b(aVar, taskBuoyViewModel, taskInfo) : (c.a.j.e.a.j.b) invokeLLL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1335362204, "Lc/a/j/e/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1335362204, "Lc/a/j/e/a/b;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final c.a.j.e.a.i.a a(c.a.j.h.c.a.a<TaskBuoyViewData, TaskBuoyViewModel> aVar, c.a.j.e.a.i.b bVar, TaskInfo taskInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, aVar, bVar, taskInfo)) == null) ? a.a(aVar, bVar, taskInfo) : (c.a.j.e.a.i.a) invokeLLL.objValue;
    }

    @JvmStatic
    public static final c.a.j.e.a.j.b b(c.a.j.h.c.a.a<TaskBuoyViewData, TaskBuoyViewModel> aVar, TaskBuoyViewModel taskBuoyViewModel, TaskInfo taskInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, aVar, taskBuoyViewModel, taskInfo)) == null) ? a.b(aVar, taskBuoyViewModel, taskInfo) : (c.a.j.e.a.j.b) invokeLLL.objValue;
    }
}
