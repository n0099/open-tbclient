package b.a.y0.e.f;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class d implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f29993a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29994b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29995c;

    /* renamed from: d  reason: collision with root package name */
    public String f29996d;

    /* renamed from: e  reason: collision with root package name */
    public String f29997e;

    /* renamed from: f  reason: collision with root package name */
    public String f29998f;

    /* renamed from: g  reason: collision with root package name */
    public int f29999g;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29999g = -200;
        if (context != null) {
            this.f29993a = context.getApplicationContext();
        }
    }

    @Override // b.a.y0.e.f.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f29999g = i2;
        }
    }

    @Override // b.a.y0.e.f.c
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f29998f = str;
        }
    }

    @Override // b.a.y0.e.f.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29994b : invokeV.booleanValue;
    }

    @Override // b.a.y0.e.f.c
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f29995c = z;
        }
    }

    @Override // b.a.y0.e.f.c
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f29997e = str;
        }
    }

    @Override // b.a.y0.e.f.c
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f29996d = str;
        }
    }

    @Override // b.a.y0.e.f.c
    public String getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29997e : (String) invokeV.objValue;
    }

    @Override // b.a.y0.e.f.c
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f29996d : (String) invokeV.objValue;
    }

    @Override // b.a.y0.e.f.c
    public int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29999g : invokeV.intValue;
    }

    @Override // b.a.y0.e.f.c
    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29998f : (String) invokeV.objValue;
    }

    @Override // b.a.y0.e.f.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f29995c : invokeV.booleanValue;
    }

    @Override // b.a.y0.e.f.c
    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f29994b = z;
        }
    }
}
