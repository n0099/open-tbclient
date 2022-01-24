package c.a.r0.a.g1.j.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f6396b;

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
        this.a = -2;
        this.f6396b = -2;
    }

    @Override // c.a.r0.a.g1.j.f.b
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    @Override // c.a.r0.a.g1.j.f.b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.g1.j.f.b
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f6396b == -2) {
                c.a.r0.a.c1.a.g0().getSwitch("swan_webview_pause_control", 3);
                this.f6396b = 3;
            }
            return (this.f6396b & 2) == 2;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.g1.j.f.b
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f6396b == -2) {
                c.a.r0.a.c1.a.g0().getSwitch("swan_webview_pause_control", 3);
                this.f6396b = 3;
            }
            return (this.f6396b & 1) == 1;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.g1.j.f.b
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == -2) {
                c.a.r0.a.c1.a.g0().getSwitch("swan_webview_backstage_optimize", -1);
                this.a = -1;
            }
            return this.a > -1;
        }
        return invokeV.booleanValue;
    }
}
