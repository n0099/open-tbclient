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
    public final c f3098b;

    /* renamed from: c  reason: collision with root package name */
    public final TaskProcessData f3099c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3100d;

    public f(TaskStatus taskStatus, c cVar, TaskProcessData taskProcessData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskStatus, cVar, taskProcessData, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = taskStatus;
        this.f3098b = cVar;
        this.f3099c = taskProcessData;
        this.f3100d = str;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "taskStatus:" + this.a + "\n uiConfig:" + this.f3098b + "\n totalProcess:" + this.f3099c + "\n extra:" + this.f3100d;
        }
        return (String) invokeV.objValue;
    }
}
