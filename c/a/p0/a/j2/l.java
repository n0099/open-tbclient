package c.a.p0.a.j2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.p.d.e0;
import c.a.p0.a.v2.q;
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
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7046a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f7047e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f7048f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7049g;

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
            this.f7047e = hashMap;
            this.f7048f = file;
            this.f7049g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0 t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (t = c.a.p0.a.c1.a.t()) == null) {
                return;
            }
            t.a(this.f7047e, this.f7048f, null, "error_js");
            if (l.f7046a) {
                String str = "extraData :" + this.f7047e.toString();
                String str2 = "filePath :" + this.f7049g;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(820913951, "Lc/a/p0/a/j2/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(820913951, "Lc/a/p0/a/j2/l;");
                return;
            }
        }
        f7046a = c.a.p0.a.k.f7077a;
    }

    public static void b(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, v8ExceptionInfo) == null) {
            if (v8ExceptionInfo == null) {
                boolean z = f7046a;
                return;
            }
            c(v8ExceptionInfo);
            d(v8ExceptionInfo);
        }
    }

    public static void c(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, v8ExceptionInfo) == null) {
            if (!c.a.p0.a.c1.a.Z().C()) {
                boolean z = f7046a;
                return;
            }
            c.a.p0.a.a2.e i2 = c.a.p0.a.a2.e.i();
            b.a N = i2 != null ? i2.N() : null;
            c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
            aVar.j(5L);
            aVar.h(37L);
            c.a.p0.a.j2.p.d dVar = new c.a.p0.a.j2.p.d();
            dVar.p(aVar);
            dVar.r(N);
            dVar.q(k.m(c.a.p0.a.a2.d.g().l()));
            dVar.m(c.a.p0.a.a2.e.V());
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
                if (f7046a) {
                    e2.printStackTrace();
                }
            }
            k.L(dVar);
        }
    }

    public static void d(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, v8ExceptionInfo) == null) {
            if (!c.a.p0.a.c1.a.Z().J()) {
                boolean z = f7046a;
            } else if (TextUtils.isEmpty(v8ExceptionInfo.filePath)) {
            } else {
                String str = v8ExceptionInfo.filePath;
                if (str.startsWith("script:")) {
                    boolean z2 = f7046a;
                    return;
                }
                SwanCoreVersion e2 = c.a.p0.a.m2.b.e(c.a.p0.a.a2.d.g().l());
                if (e2 == null || TextUtils.isEmpty(e2.swanCorePath)) {
                    return;
                }
                if (!str.startsWith(e2.swanCorePath)) {
                    boolean z3 = f7046a;
                    return;
                }
                File file = new File(str);
                if (file.exists()) {
                    HashMap hashMap = new HashMap();
                    c.a.p0.a.a2.e i2 = c.a.p0.a.a2.e.i();
                    if (!TextUtils.isEmpty(c.a.p0.a.a2.e.V())) {
                        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c.a.p0.a.a2.e.V());
                    }
                    if (i2 != null && !TextUtils.isEmpty(i2.Z())) {
                        hashMap.put("appVersion", i2.Z());
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
                    q.j(new a(hashMap, file, str), "error_js");
                }
            }
        }
    }
}
