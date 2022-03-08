package c.a.p0.j.h0;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a.b0.c a;

    /* renamed from: b  reason: collision with root package name */
    public c f10496b;

    public e(c.a.p0.a.b0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
        this.f10496b = new c();
    }

    @NonNull
    public c.a.p0.j.h0.f.d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f10496b.j();
            c.a.p0.a.k2.d.f6429h.update();
            return c.a.p0.j.h0.f.d.i(null);
        }
        return (c.a.p0.j.h0.f.d) invokeV.objValue;
    }

    @NonNull
    public c.a.p0.j.h0.f.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.f10496b.n();
            c.a.p0.j.h0.f.c cVar = new c.a.p0.j.h0.f.c();
            cVar.keys = n;
            cVar.currentSize = this.f10496b.m() / 1024;
            cVar.limitSize = this.f10496b.s() / 1024;
            cVar.errMsg = c.a.p0.j.h0.f.a.b("getStorageInfoSync");
            return cVar;
        }
        return (c.a.p0.j.h0.f.c) invokeV.objValue;
    }

    @NonNull
    public c.a.p0.j.h0.f.d c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return c.a.p0.j.h0.f.d.b("parameter error: the key cannot be null.");
            }
            String p = this.f10496b.p(str, null);
            Object C = p != null ? this.a.C(Base64.decode(p, 2), true) : null;
            if (C == null) {
                C = c.a.p0.j.h0.f.d.h();
            }
            return c.a.p0.j.h0.f.d.i(C);
        }
        return (c.a.p0.j.h0.f.d) invokeL.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) || jsSerializeValue == null) {
            return;
        }
        jsSerializeValue.release();
    }

    @NonNull
    public c.a.p0.j.h0.f.d e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return c.a.p0.j.h0.f.d.b("parameter error: the key cannot be null.");
            }
            this.f10496b.u(str);
            c.a.p0.a.k2.d.f6429h.update();
            return c.a.p0.j.h0.f.d.i(null);
        }
        return (c.a.p0.j.h0.f.d) invokeL.objValue;
    }

    @NonNull
    public c.a.p0.j.h0.f.d f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return c.a.p0.j.h0.f.d.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return c.a.p0.j.h0.f.d.i(null);
            } else {
                byte[] N = this.a.N(jsSerializeValue, true);
                d(jsSerializeValue);
                if (N == null) {
                    return c.a.p0.j.h0.f.d.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(N, 2);
                String p = this.f10496b.p(str, null);
                int length = str.getBytes().length;
                if (this.f10496b.s() - this.f10496b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                    return c.a.p0.j.h0.f.d.b("storage error: the storage space insufficient.");
                }
                boolean t = this.f10496b.t(str, encodeToString);
                c.a.p0.a.k2.d.f6429h.update();
                return t ? c.a.p0.j.h0.f.d.i(null) : c.a.p0.j.h0.f.d.b("storage error: the storage is invalid.");
            }
        }
        return (c.a.p0.j.h0.f.d) invokeLL.objValue;
    }
}
