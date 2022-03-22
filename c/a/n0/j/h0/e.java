package c.a.n0.j.h0;

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
    public c.a.n0.a.b0.c a;

    /* renamed from: b  reason: collision with root package name */
    public c f8777b;

    public e(c.a.n0.a.b0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
        this.f8777b = new c();
    }

    @NonNull
    public c.a.n0.j.h0.f.d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f8777b.j();
            c.a.n0.a.k2.d.f5406h.update();
            return c.a.n0.j.h0.f.d.i(null);
        }
        return (c.a.n0.j.h0.f.d) invokeV.objValue;
    }

    @NonNull
    public c.a.n0.j.h0.f.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.f8777b.n();
            c.a.n0.j.h0.f.c cVar = new c.a.n0.j.h0.f.c();
            cVar.keys = n;
            cVar.currentSize = this.f8777b.m() / 1024;
            cVar.limitSize = this.f8777b.s() / 1024;
            cVar.errMsg = c.a.n0.j.h0.f.a.b("getStorageInfoSync");
            return cVar;
        }
        return (c.a.n0.j.h0.f.c) invokeV.objValue;
    }

    @NonNull
    public c.a.n0.j.h0.f.d c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return c.a.n0.j.h0.f.d.b("parameter error: the key cannot be null.");
            }
            String p = this.f8777b.p(str, null);
            Object D = p != null ? this.a.D(Base64.decode(p, 2), true) : null;
            if (D == null) {
                D = c.a.n0.j.h0.f.d.h();
            }
            return c.a.n0.j.h0.f.d.i(D);
        }
        return (c.a.n0.j.h0.f.d) invokeL.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) || jsSerializeValue == null) {
            return;
        }
        jsSerializeValue.release();
    }

    @NonNull
    public c.a.n0.j.h0.f.d e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return c.a.n0.j.h0.f.d.b("parameter error: the key cannot be null.");
            }
            this.f8777b.u(str);
            c.a.n0.a.k2.d.f5406h.update();
            return c.a.n0.j.h0.f.d.i(null);
        }
        return (c.a.n0.j.h0.f.d) invokeL.objValue;
    }

    @NonNull
    public c.a.n0.j.h0.f.d f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return c.a.n0.j.h0.f.d.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return c.a.n0.j.h0.f.d.i(null);
            } else {
                byte[] O = this.a.O(jsSerializeValue, true);
                d(jsSerializeValue);
                if (O == null) {
                    return c.a.n0.j.h0.f.d.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(O, 2);
                String p = this.f8777b.p(str, null);
                int length = str.getBytes().length;
                if (this.f8777b.s() - this.f8777b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                    return c.a.n0.j.h0.f.d.b("storage error: the storage space insufficient.");
                }
                boolean t = this.f8777b.t(str, encodeToString);
                c.a.n0.a.k2.d.f5406h.update();
                return t ? c.a.n0.j.h0.f.d.i(null) : c.a.n0.j.h0.f.d.b("storage error: the storage is invalid.");
            }
        }
        return (c.a.n0.j.h0.f.d) invokeLL.objValue;
    }
}
