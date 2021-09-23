package c.a.p0.c.a.k;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.c.a.g;
import c.a.p0.c.a.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f10376a;

    /* renamed from: b  reason: collision with root package name */
    public int f10377b;

    /* renamed from: c  reason: collision with root package name */
    public String f10378c;

    public c() {
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
        this.f10376a = false;
        this.f10377b = 0;
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f10377b = 0;
            c.a.p0.c.a.d.b().a(str, this);
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10378c : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f10376a : invokeV.booleanValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f10378c = str;
        }
    }

    public abstract void e(IOException iOException);

    public abstract void f(int i2);

    public final String g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            String str = new String(bArr);
            if (c.a.p0.c.a.a.f10319a) {
                String str2 = "processResponseData encodeResponseData=" + str;
            }
            if (this.f10376a) {
                f c2 = c.a.p0.c.a.e.f().c(g.l().m(), bArr);
                if (c2 != null) {
                    if (!TextUtils.isEmpty(c2.a())) {
                        str = c2.a();
                    }
                    this.f10377b = c2.b().intValue();
                } else {
                    this.f10377b = -1;
                }
                g.l().m().s(this.f10377b);
                if (this.f10377b == -1) {
                    c.a.p0.c.a.d.b().f(false);
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public abstract void h(byte[] bArr);

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f10376a = z;
        }
    }
}
