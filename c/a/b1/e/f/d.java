package c.a.b1.e.f;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class d implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1731b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1732c;

    /* renamed from: d  reason: collision with root package name */
    public String f1733d;

    /* renamed from: e  reason: collision with root package name */
    public String f1734e;

    /* renamed from: f  reason: collision with root package name */
    public String f1735f;

    /* renamed from: g  reason: collision with root package name */
    public int f1736g;

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
        this.f1736g = DeepLinkCode.ERROR_LINK_NOT_MATCH;
        if (context != null) {
            this.a = context.getApplicationContext();
        }
    }

    @Override // c.a.b1.e.f.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f1736g = i2;
        }
    }

    @Override // c.a.b1.e.f.c
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f1735f = str;
        }
    }

    @Override // c.a.b1.e.f.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1731b : invokeV.booleanValue;
    }

    @Override // c.a.b1.e.f.c
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f1732c = z;
        }
    }

    @Override // c.a.b1.e.f.c
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f1734e = str;
        }
    }

    @Override // c.a.b1.e.f.c
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f1733d = str;
        }
    }

    @Override // c.a.b1.e.f.c
    public String getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1734e : (String) invokeV.objValue;
    }

    @Override // c.a.b1.e.f.c
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1733d : (String) invokeV.objValue;
    }

    @Override // c.a.b1.e.f.c
    public int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1736g : invokeV.intValue;
    }

    @Override // c.a.b1.e.f.c
    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f1735f : (String) invokeV.objValue;
    }

    @Override // c.a.b1.e.f.c
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f1731b = z;
        }
    }

    @Override // c.a.b1.e.f.c
    public boolean isSupport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f1732c : invokeV.booleanValue;
    }
}
