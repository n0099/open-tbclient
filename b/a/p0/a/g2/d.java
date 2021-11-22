package b.a.p0.a.g2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import b.a.p0.a.g1.f;
import b.a.p0.a.g2.e;
import b.a.p0.a.k;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.u;
import b.a.p0.a.z2.w;
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
    public static final boolean f5316a;

    /* renamed from: b  reason: collision with root package name */
    public static c f5317b;
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

        @Override // b.a.p0.a.g2.c
        public void a(e.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                d.e(dVar);
                if (!b.a.p0.a.g2.a.c()) {
                    d.i(dVar);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements b.a.p0.a.z2.g1.c<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.d f5318e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f5319e;

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
                this.f5319e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap decodeFile;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (b.a.p0.a.z2.d.a()) {
                        decodeFile = u.e(this.f5319e.f5318e.f5338b);
                    } else {
                        decodeFile = BitmapFactory.decodeFile(this.f5319e.f5318e.f5337a);
                    }
                    File k = u.k("screenshot.jpg");
                    if (decodeFile != null) {
                        u.o(decodeFile, k.getAbsolutePath(), 20);
                    }
                    String h2 = f.U().G().h(k.getAbsolutePath());
                    if (!k.exists()) {
                        h2 = "";
                    }
                    d.f(h2);
                    if (d.f5316a) {
                        String str = "saveScreenshot:" + TextUtils.isEmpty(h2) + ",path:" + k.getAbsolutePath();
                    }
                }
            }
        }

        public b(e.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5318e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (!bool.booleanValue()) {
                    d.f("");
                } else {
                    q.k(new a(this), "dispatchCaptureScreenEvent");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1323701765, "Lb/a/p0/a/g2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1323701765, "Lb/a/p0/a/g2/d;");
                return;
            }
        }
        f5316a = k.f6863a;
    }

    public static void e(e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dVar) == null) {
            b.a.p0.a.g2.a.b(new b(dVar));
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
            f.U().u(new b.a.p0.a.o0.d.c("onUserCaptureScreen", hashMap));
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            e.s(b.a.p0.a.c1.a.c());
            boolean z = f5316a;
            if (f5317b == null) {
                f5317b = new a();
            }
            e.r(f5317b);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            b.a.p0.a.g2.a.d();
        }
    }

    public static void i(e.d dVar) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || (activity = f.U().getActivity()) == null) {
            return;
        }
        b.a.p0.a.c1.a.f0().b(activity, dVar.f5337a, dVar.f5338b);
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            boolean z = f5316a;
            c cVar = f5317b;
            if (cVar != null) {
                e.u(cVar);
                f5317b = null;
            }
        }
    }
}
