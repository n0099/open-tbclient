package c.a.q0.a.s1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.d2.d;
import c.a.q0.a.h0.g.f;
import c.a.q0.a.h0.g.g;
import c.a.q0.a.k;
import c.a.q0.a.p.d.u0;
import c.a.q0.a.p.d.v0;
import c.a.q0.a.z2.g1.c;
import c.a.q0.a.z2.g1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.page.model.SwanAppPageInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements v0, u0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f8228b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f8229c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f8230d;
    public transient /* synthetic */ FieldHolder $fh;
    public c<SwanAppPageInfo> a;

    /* renamed from: c.a.q0.a.s1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0493a implements e<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        public C0493a(a aVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.e
        /* renamed from: b */
        public Boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? Boolean.valueOf(TextUtils.isEmpty(this.a.optString(str))) : (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements e<String, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;

        public b(a aVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object] */
        @Override // c.a.q0.a.z2.g1.e
        /* renamed from: b */
        public T a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.a : invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(632682003, "Lc/a/q0/a/s1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(632682003, "Lc/a/q0/a/s1/a;");
                return;
            }
        }
        boolean z = k.a;
        f8229c = c.a.q0.a.c1.a.n().a();
        f8230d = f8229c + "_";
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f8228b == null) {
                synchronized (a.class) {
                    if (f8228b == null) {
                        f8228b = new a();
                    }
                }
            }
            return f8228b;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.q0.a.p.d.u0
    public void a(String str, c.a.q0.a.m1.c cVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, cVar, context) == null) {
            if (cVar != null && d.J().D()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "history");
                    jSONObject.put("url", cVar.i());
                    jSONObject.put("pageId", str);
                    c(jSONObject, cVar);
                    return;
                } catch (JSONException e2) {
                    c.a.q0.a.e0.d.o("SwanAppPageInfoHelper", "onFragmentOpened: ret by catch:" + e2 + " trace:\n" + Log.getStackTraceString(e2));
                    return;
                }
            }
            c.a.q0.a.e0.d.o("SwanAppPageInfoHelper", "onFragmentOpened: ret by pageParam is null or !hasAppOccupied");
        }
    }

    @Override // c.a.q0.a.p.d.v0
    public void b(c.a.q0.a.d2.e eVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, jSONObject) == null) {
            c(jSONObject, null);
        }
    }

    public final void c(@NonNull JSONObject jSONObject, @Nullable c.a.q0.a.m1.c cVar) {
        String i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, cVar) == null) {
            String optString = jSONObject.optString("type");
            if (!d(optString)) {
                c.a.q0.a.e0.d.o("SwanAppPageInfoHelper", "addPageHistory: ret by check type:" + optString);
                return;
            }
            f g2 = g();
            if (g2 == null) {
                c.a.q0.a.e0.d.o("SwanAppPageInfoHelper", "addPageHistory: ret by null fragment");
                return;
            }
            c.a.q0.a.m1.c O1 = g2.O1();
            if (O1 == null) {
                c.a.q0.a.e0.d.o("SwanAppPageInfoHelper", "addPageHistory: ret by null param");
                return;
            }
            if (cVar == null) {
                cVar = O1;
            }
            try {
                i2 = cVar.i();
                str = "";
                if (TextUtils.isEmpty(i2)) {
                    i2 = "";
                }
                l(jSONObject, "url", i2);
                String optString2 = jSONObject.optString("url");
                if (!TextUtils.isEmpty(optString2)) {
                    str = optString2;
                }
            } catch (JSONException e2) {
                c.a.q0.a.e0.d.o("SwanAppPageInfoHelper", "addPageHistory: ret by catch:" + e2 + " trace:\n" + Log.getStackTraceString(e2));
            }
            if (!str.startsWith(i2)) {
                c.a.q0.a.e0.d.o("SwanAppPageInfoHelper", "addPageHistory: ret by isNotSamePage\n    fragmentUrl = " + i2 + "\n        dataUrl = " + str);
                return;
            }
            if (optString.startsWith(f8230d)) {
                optString = optString.substring(f8230d.length());
            }
            jSONObject.put("type", optString);
            l(jSONObject, "pageId", g2.f0);
            l(jSONObject, "scheme", f8229c + "://swan/" + d.J().getAppId() + "/" + str);
            c.a.q0.a.f1.e.b f2 = f();
            if (f2 != null) {
                l(jSONObject, "appName", f2.K());
                l(jSONObject, "iconUrl", f2.Q());
                l(jSONObject, "appDesc", f2.e1());
            }
            h(jSONObject);
        }
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? !TextUtils.isEmpty(str) && ("history".equals(str) || str.startsWith(f8230d)) : invokeL.booleanValue;
    }

    public final c.a.q0.a.f1.e.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
            if (a0 == null || a0.V() == null) {
                return null;
            }
            return a0.V();
        }
        return (c.a.q0.a.f1.e.b) invokeV.objValue;
    }

    public final f g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            g V = c.a.q0.a.g1.f.U().V();
            if (V == null) {
                return null;
            }
            return V.o();
        }
        return (f) invokeV.objValue;
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            if (!SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
                i(new SwanAppPageInfo(jSONObject));
                return;
            }
            m();
            Bundle bundle = new Bundle();
            bundle.putString("page_info", jSONObject.toString());
            c.a.q0.a.y1.c.a.e().h(new c.a.q0.a.y1.c.c(24, bundle));
        }
    }

    public void i(SwanAppPageInfo swanAppPageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppPageInfo) == null) {
            c.a.q0.a.e0.d.i("SwanAppPageInfoHelper", "notifyCallBackLocally: data = " + swanAppPageInfo);
            c<SwanAppPageInfo> cVar = this.a;
            if (cVar != null) {
                cVar.onCallback(swanAppPageInfo);
            }
        }
    }

    public final <T> JSONObject j(JSONObject jSONObject, String str, e<String, T> eVar, e<String, Boolean> eVar2) throws JSONException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, str, eVar, eVar2)) == null) {
            if (eVar2.a(str).booleanValue()) {
                jSONObject.put(str, eVar.a(str));
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public final <T> JSONObject k(JSONObject jSONObject, String str, T t, e<String, Boolean> eVar) throws JSONException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, jSONObject, str, t, eVar)) == null) {
            j(jSONObject, str, new b(this, t), eVar);
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public final JSONObject l(JSONObject jSONObject, String str, String str2) throws JSONException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, jSONObject, str, str2)) == null) {
            k(jSONObject, str, str2, new C0493a(this, jSONObject));
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.a == null) {
            return;
        }
        this.a = null;
    }
}
