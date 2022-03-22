package c.a.d.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.taskmanager.IdleTaskRegister;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f2028c;
    public transient /* synthetic */ FieldHolder $fh;
    public final IdleTaskRegister a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2029b;

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
        this.a = new IdleTaskRegister();
        this.f2029b = false;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f2028c == null) {
                f2028c = new a();
            }
            return f2028c;
        }
        return (a) invokeV.objValue;
    }

    public void a(String str, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, runnable) == null) {
            if (!this.f2029b) {
                this.a.registerIdleTask(str, runnable);
            } else {
                runnable.run();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f2029b = true;
            this.a.scheduleIdleTask(true);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f2029b = true;
            this.a.scheduleIdleTask(false);
        }
    }
}
