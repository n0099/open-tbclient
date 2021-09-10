package c.p.a.e.b.n;

import android.net.http.Headers;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.l.f;
import c.p.a.e.b.o.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f35375a;

    /* renamed from: b  reason: collision with root package name */
    public final i f35376b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35377c;

    /* renamed from: d  reason: collision with root package name */
    public long f35378d;

    /* renamed from: e  reason: collision with root package name */
    public long f35379e;

    public b(String str, i iVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35375a = str;
        this.f35377c = iVar.b();
        this.f35376b = iVar;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f.q0(this.f35377c) : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f.H(this.f35377c, this.f35376b.a(Util.ACCEPT_RANGES)) : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35376b.a(Util.ETAG) : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35376b.a("Content-Type") : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f.Y(this.f35376b, "Content-Range") : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String Y = f.Y(this.f35376b, Headers.LAST_MODIFIED);
            return TextUtils.isEmpty(Y) ? f.Y(this.f35376b, "Last-Modified") : Y;
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f.Y(this.f35376b, "Cache-Control") : (String) invokeV.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f35378d <= 0) {
                this.f35378d = f.d(this.f35376b);
            }
            return this.f35378d;
        }
        return invokeV.longValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (c.p.a.e.b.l.a.a(8)) {
                return f.u0(this.f35376b);
            }
            return f.f0(h());
        }
        return invokeV.booleanValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f35379e <= 0) {
                if (!i()) {
                    String e2 = e();
                    if (!TextUtils.isEmpty(e2)) {
                        this.f35379e = f.V(e2);
                    }
                } else {
                    this.f35379e = -1L;
                }
            }
            return this.f35379e;
        }
        return invokeV.longValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? f.W0(g()) : invokeV.longValue;
    }
}
