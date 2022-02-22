package c.a.j.e.a;

import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TaskStatus a;

    /* renamed from: b  reason: collision with root package name */
    public final c f3985b;

    /* renamed from: c  reason: collision with root package name */
    public final TaskProcessData f3986c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3987d;

    public f(TaskStatus taskStatus, c cVar, TaskProcessData taskProcessData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskStatus, cVar, taskProcessData, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = taskStatus;
        this.f3985b = cVar;
        this.f3986c = taskProcessData;
        this.f3987d = str;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "taskStatus:" + this.a + "\n uiConfig:" + this.f3985b + "\n totalProcess:" + this.f3986c + "\n extra:" + this.f3987d;
        }
        return (String) invokeV.objValue;
    }
}
