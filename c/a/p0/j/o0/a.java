package c.a.p0.j.o0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.g1.c;
import c.a.p0.a.t1.e;
import c.a.p0.a.x1.c.f;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.j.o0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0726a implements c<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.o.b.a f10609e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10610f;

        public C0726a(c.a.p0.a.o.b.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10609e = aVar;
            this.f10610f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar == null || fVar.f9100d || fVar.f9106j != 1) {
                    a.c(this.f10609e, "system deny");
                } else {
                    a.e(this.f10609e, this.f10610f);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(223070170, "Lc/a/p0/j/o0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(223070170, "Lc/a/p0/j/o0/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
    }

    public static void c(c.a.p0.a.o.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, aVar, str) == null) {
            c.a.p0.j.d.c.b bVar = new c.a.p0.j.d.c.b();
            bVar.errMsg = str;
            c.a.p0.j.n0.c.call(aVar, false, bVar);
        }
    }

    public static void d(JsObject jsObject) {
        c.a.p0.a.o.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jsObject) == null) || (F = c.a.p0.a.o.b.a.F(jsObject)) == null) {
            return;
        }
        e a0 = e.a0();
        if (a0 == null) {
            c(F, "internal error");
            return;
        }
        String C = F.C("domain", "baidu.com");
        if (a) {
            String str = "getUUAPInfo-domain: " + C;
        }
        a0.d0().e("mapp_uuap_info", new C0726a(F, C));
    }

    public static void e(c.a.p0.a.o.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, aVar, str) == null) {
            b bVar = new b();
            String cookie = CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                Map<String, String> f2 = f(cookie);
                bVar.uuap_p_token = f2.get("UUAP_P_TOKEN");
                bVar.uuap_p_token_offline = f2.get("UUAP_P_TOKEN_OFFLINE");
                bVar.uuap_s_token = f2.get("UUAP_S_TOKEN");
            }
            c.a.p0.j.n0.c.call(aVar, true, bVar);
        }
    }

    @NonNull
    public static Map<String, String> f(@NonNull String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(";")) {
                if (str2 != null && str2.contains("=")) {
                    int indexOf = str2.indexOf("=");
                    hashMap.put(str2.substring(0, indexOf).trim().toUpperCase(Locale.US), str2.substring(indexOf + 1));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
