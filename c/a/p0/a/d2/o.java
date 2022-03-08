package c.a.p0.a.d2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f.d.e0;
import c.a.p0.a.v0.e.b;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f4931e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f4932f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4933g;

        public a(HashMap hashMap, File file, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hashMap, file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4931e = hashMap;
            this.f4932f = file;
            this.f4933g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0 u;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (u = c.a.p0.a.s0.a.u()) == null) {
                return;
            }
            u.a(this.f4931e, this.f4932f, null, "error_js");
            if (o.a) {
                String str = "extraData :" + this.f4931e.toString();
                String str2 = "filePath :" + this.f4933g;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(815372918, "Lc/a/p0/a/d2/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(815372918, "Lc/a/p0/a/d2/o;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
    }

    public static void b(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, v8ExceptionInfo) == null) {
            if (v8ExceptionInfo == null) {
                boolean z = a;
                return;
            }
            c(v8ExceptionInfo);
            d(v8ExceptionInfo);
        }
    }

    public static void c(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, v8ExceptionInfo) == null) {
            if (!c.a.p0.a.s0.a.g0().B()) {
                boolean z = a;
                return;
            }
            c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
            b.a X = L != null ? L.X() : null;
            c.a.p0.a.k2.a aVar = new c.a.p0.a.k2.a();
            aVar.k(5L);
            aVar.i(37L);
            c.a.p0.a.d2.s.d dVar = new c.a.p0.a.d2.s.d();
            dVar.p(aVar);
            dVar.r(X);
            dVar.q(n.n(c.a.p0.a.t1.d.J().l()));
            dVar.m(c.a.p0.a.t1.e.f0());
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg)) {
                    jSONObject.put("exceptionMsg", v8ExceptionInfo.exceptionMsg);
                }
                if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace)) {
                    jSONObject.put("exceptionTrace", v8ExceptionInfo.exceptionTrace);
                }
                if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionType)) {
                    jSONObject.put("exceptionType", v8ExceptionInfo.exceptionType);
                }
                dVar.e(jSONObject);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            n.R(dVar);
        }
    }

    public static void d(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, v8ExceptionInfo) == null) {
            if (!c.a.p0.a.s0.a.g0().H()) {
                boolean z = a;
            } else if (TextUtils.isEmpty(v8ExceptionInfo.filePath)) {
            } else {
                String str = v8ExceptionInfo.filePath;
                if (str.startsWith("script:")) {
                    boolean z2 = a;
                    return;
                }
                SwanCoreVersion e2 = c.a.p0.a.g2.b.e(c.a.p0.a.t1.d.J().l());
                if (e2 == null || TextUtils.isEmpty(e2.swanCorePath)) {
                    return;
                }
                if (!str.startsWith(e2.swanCorePath)) {
                    boolean z3 = a;
                    return;
                }
                File file = new File(str);
                if (file.exists()) {
                    HashMap hashMap = new HashMap();
                    c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
                    if (!TextUtils.isEmpty(c.a.p0.a.t1.e.f0())) {
                        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c.a.p0.a.t1.e.f0());
                    }
                    if (L != null && !TextUtils.isEmpty(L.j0())) {
                        hashMap.put("appVersion", L.j0());
                    }
                    if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg)) {
                        hashMap.put("exceptionMsg", v8ExceptionInfo.exceptionMsg);
                    }
                    if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace)) {
                        hashMap.put("exceptionTrace", v8ExceptionInfo.exceptionTrace);
                    }
                    if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionType)) {
                        hashMap.put("exceptionType", v8ExceptionInfo.exceptionType);
                    }
                    c.a.p0.a.p2.q.k(new a(hashMap, file, str), "error_js");
                }
            }
        }
    }
}
