package c.a.o0.a.d2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import c.a.o0.a.d2.e;
import c.a.o0.a.g1.f;
import c.a.o0.a.k;
import c.a.o0.a.v2.q;
import c.a.o0.a.v2.u;
import c.a.o0.a.v2.w;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5126a;

    /* renamed from: b  reason: collision with root package name */
    public static c f5127b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.a.d2.c
        public void a(e.C0146e c0146e) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0146e) == null) {
                d.e(c0146e);
                if (!c.a.o0.a.d2.a.c()) {
                    d.i(c0146e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.o0.a.v2.e1.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.C0146e f5128e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f5129e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5129e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap decodeFile;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (c.a.o0.a.v2.d.a()) {
                        decodeFile = u.e(this.f5129e.f5128e.f5149b);
                    } else {
                        decodeFile = BitmapFactory.decodeFile(this.f5129e.f5128e.f5148a);
                    }
                    File k = u.k("screenshot.jpg");
                    if (decodeFile != null) {
                        u.o(decodeFile, k.getAbsolutePath(), 20);
                    }
                    String h2 = f.V().I().h(k.getAbsolutePath());
                    if (!k.exists()) {
                        h2 = "";
                    }
                    d.f(h2);
                    if (d.f5126a) {
                        String str = "saveScreenshot:" + TextUtils.isEmpty(h2) + ",path:" + k.getAbsolutePath();
                    }
                }
            }
        }

        public b(e.C0146e c0146e) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0146e};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5128e = c0146e;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (!bool.booleanValue()) {
                    d.f("");
                } else {
                    q.j(new a(this), "dispatchCaptureScreenEvent");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1011886082, "Lc/a/o0/a/d2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1011886082, "Lc/a/o0/a/d2/d;");
                return;
            }
        }
        f5126a = k.f7049a;
    }

    public static void e(e.C0146e c0146e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, c0146e) == null) {
            c.a.o0.a.d2.a.b(new b(c0146e));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                w.f(jSONObject, "imagePath", str);
            }
            hashMap.put("data", jSONObject.toString());
            f.V().v(new c.a.o0.a.o0.d.b("onUserCaptureScreen", hashMap));
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            e.s(c.a.o0.a.c1.a.b());
            boolean z = f5126a;
            if (f5127b == null) {
                f5127b = new a();
            }
            e.r(f5127b);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            c.a.o0.a.d2.a.d();
        }
    }

    public static void i(e.C0146e c0146e) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, c0146e) == null) || (activity = f.V().getActivity()) == null) {
            return;
        }
        c.a.o0.a.c1.a.Y().b(activity, c0146e.f5148a, c0146e.f5149b);
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            boolean z = f5126a;
            c cVar = f5127b;
            if (cVar != null) {
                e.u(cVar);
                f5127b = null;
            }
        }
    }
}
