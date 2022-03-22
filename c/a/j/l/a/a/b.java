package c.a.j.l.a.a;

import android.view.View;
import androidx.annotation.CallSuper;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    @Override // c.a.j.l.a.a.c
    @CallSuper
    public void a(View view, TaskInfo taskInfo, TaskBuoyViewData taskBuoyViewData) {
        c.a.j.h.b.h.a b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, view, taskInfo, taskBuoyViewData) == null) && taskBuoyViewData.getTaskStatus().isFinished()) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            c.a.j.j.d.a v = BDPTask.m.v();
            if (v == null || (b2 = v.b()) == null) {
                return;
            }
            b2.a(taskBuoyViewData.getScheme(), 3);
        }
    }
}
