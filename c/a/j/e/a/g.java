package c.a.j.e.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.guide.TaskGuideData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public static final g a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1335362359, "Lc/a/j/e/a/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1335362359, "Lc/a/j/e/a/g;");
                return;
            }
        }
        a = new g();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void a(int i2, TaskInfo taskInfo, TaskStatus taskStatus) {
        c.a.j.j.i.a f2;
        c.a.j.j.e.a.a d2;
        c.a.j.j.e.a.a d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, taskInfo, taskStatus) == null) {
            c.a.j.j.d.a v = BDPTask.m.v();
            if (v != null && (d3 = v.d()) != null) {
                d3.b(taskInfo.getSingleKey(), c.a.j.g.f.b.f3954c.a());
            }
            c.a.j.j.d.a v2 = BDPTask.m.v();
            if (v2 != null && (d2 = v2.d()) != null) {
                d2.a(taskInfo.getSingleKey());
            }
            String str = TaskGuideData.Companion.c(i2) ? "y_task_diyicon" : "y_task_icon";
            String c2 = c.a.j.j.i.b.a.c(taskStatus);
            c.a.j.j.d.a v3 = BDPTask.m.v();
            if (v3 == null || (f2 = v3.f()) == null) {
                return;
            }
            f2.a(str, "icon_clk", c.a.j.j.i.b.a.a(taskInfo.getId(), taskInfo.getActTaskId(), c2));
        }
    }

    public final void b(int i2, TaskInfo taskInfo, TaskStatus taskStatus) {
        c.a.j.j.i.a f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, taskInfo, taskStatus) == null) {
            String str = TaskGuideData.Companion.c(i2) ? "y_task_diyicon" : "y_task_icon";
            String c2 = c.a.j.j.i.b.a.c(taskStatus);
            c.a.j.j.d.a v = BDPTask.m.v();
            if (v == null || (f2 = v.f()) == null) {
                return;
            }
            f2.a(str, "close_clk", c.a.j.j.i.b.a.a(taskInfo.getId(), taskInfo.getActTaskId(), c2));
        }
    }
}
