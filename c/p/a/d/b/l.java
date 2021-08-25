package c.p.a.d.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.p.a.a.a.c.o;
import c.p.a.a.a.c.p;
import c.p.a.a.a.c.q;
import c.p.a.a.a.c.s;
import c.p.a.a.a.c.u;
import c.p.a.e.a.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final JSONObject f34611a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f34612b;

    /* renamed from: c  reason: collision with root package name */
    public static c.p.a.a.a.c.f f34613c;

    /* renamed from: d  reason: collision with root package name */
    public static c.p.a.a.a.c.c f34614d;

    /* renamed from: e  reason: collision with root package name */
    public static c.p.a.a.a.c.k f34615e;

    /* renamed from: f  reason: collision with root package name */
    public static c.p.a.a.a.c.g f34616f;

    /* renamed from: g  reason: collision with root package name */
    public static c.p.a.a.a.c.h f34617g;

    /* renamed from: h  reason: collision with root package name */
    public static c.p.a.a.a.c.i f34618h;

    /* renamed from: i  reason: collision with root package name */
    public static c.p.a.a.a.c.b f34619i;

    /* renamed from: j  reason: collision with root package name */
    public static d.j f34620j;
    public static c.p.a.a.a.c.d k;
    public static c.p.a.a.a.c.e l;
    public static o m;
    public static c.p.a.a.a.c.j n;
    public static u o;
    public static c.p.a.a.a.c.m p;
    public static c.p.a.a.a.c.l q;
    public static p r;
    public static c.p.a.a.a.e.a s;
    public static q t;
    public static s u;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements c.p.a.a.a.c.c {
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

        @Override // c.p.a.a.a.c.c
        public void a(@Nullable Context context, @NonNull c.p.a.a.a.d.d dVar, @Nullable c.p.a.a.a.d.b bVar, @Nullable c.p.a.a.a.d.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, dVar, bVar, cVar) == null) {
            }
        }

        @Override // c.p.a.a.a.c.c
        public void b(@Nullable Context context, @NonNull c.p.a.a.a.d.d dVar, @Nullable c.p.a.a.a.d.b bVar, @Nullable c.p.a.a.a.d.c cVar, String str, @NonNull String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, dVar, bVar, cVar, str, str2}) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements d.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // c.p.a.e.a.d.j
        public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.p.a.a.a.c.p
        public void a(String str, int i2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, jSONObject) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements c.p.a.a.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        @Override // c.p.a.a.a.e.a
        public void a(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // c.p.a.a.a.c.s
        public void a(@Nullable Context context, @NonNull c.p.a.a.a.d.d dVar, @Nullable c.p.a.a.a.d.b bVar, @Nullable c.p.a.a.a.d.c cVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, dVar, bVar, cVar, str, Integer.valueOf(i2)}) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-146363252, "Lc/p/a/d/b/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-146363252, "Lc/p/a/d/b/l;");
                return;
            }
        }
        f34611a = new JSONObject();
    }

    public static c.p.a.a.a.c.d A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? k : (c.p.a.a.a.c.d) invokeV.objValue;
    }

    public static c.p.a.a.a.c.e B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? l : (c.p.a.a.a.c.e) invokeV.objValue;
    }

    public static c.p.a.a.a.c.j C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? n : (c.p.a.a.a.c.j) invokeV.objValue;
    }

    @NonNull
    public static q D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? t : (q) invokeV.objValue;
    }

    public static u E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? o : (u) invokeV.objValue;
    }

    @NonNull
    public static c.p.a.a.a.e.a F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (s == null) {
                s = new d();
            }
            return s;
        }
        return (c.p.a.a.a.e.a) invokeV.objValue;
    }

    @NonNull
    public static s G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (u == null) {
                u = new e();
            }
            return u;
        }
        return (s) invokeV.objValue;
    }

    public static String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                int i2 = a().getApplicationInfo().targetSdkVersion;
                if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                    return a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
                }
                return Environment.getExternalStorageDirectory().getPath() + File.separator + v().optString("default_save_dir_name", "ByteDownload");
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? (f34613c == null || f34616f == null || f34618h == null || f34619i == null || t == null) ? false : true : invokeV.booleanValue;
    }

    public static Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            Context context = f34612b;
            if (context != null) {
                return context;
            }
            throw new IllegalArgumentException("Context is null");
        }
        return (Context) invokeV.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            if (context != null && context.getApplicationContext() != null) {
                f34612b = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context is null");
        }
    }

    public static void c(@NonNull c.p.a.a.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, bVar) == null) {
            f34619i = bVar;
        }
    }

    public static void d(@NonNull c.p.a.a.a.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, fVar) == null) {
            f34613c = fVar;
        }
    }

    public static void e(@NonNull c.p.a.a.a.c.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, gVar) == null) {
            f34616f = gVar;
        }
    }

    public static void f(@NonNull c.p.a.a.a.c.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, hVar) == null) {
            f34617g = hVar;
        }
    }

    public static void g(@NonNull c.p.a.a.a.c.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, iVar) == null) {
            f34618h = iVar;
        }
    }

    public static void h(@NonNull c.p.a.a.a.c.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, kVar) == null) {
            f34615e = kVar;
        }
    }

    public static void i(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, qVar) == null) {
            t = qVar;
        }
    }

    public static void j(c.p.a.a.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, aVar) == null) {
            s = aVar;
        }
    }

    public static void k(@NonNull c.p.a.a.a.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, aVar) == null) {
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            c.p.a.e.a.e.G().s(str);
        }
    }

    public static c.p.a.a.a.c.f m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? f34613c : (c.p.a.a.a.c.f) invokeV.objValue;
    }

    public static void n(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, context) == null) || f34612b != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        f34612b = context.getApplicationContext();
    }

    @NonNull
    public static c.p.a.a.a.c.c o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            if (f34614d == null) {
                f34614d = new a();
            }
            return f34614d;
        }
        return (c.p.a.a.a.c.c) invokeV.objValue;
    }

    @NonNull
    public static c.p.a.a.a.c.k p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            if (f34615e == null) {
                f34615e = new c.p.a.a.a.a.a();
            }
            return f34615e;
        }
        return (c.p.a.a.a.c.k) invokeV.objValue;
    }

    public static c.p.a.a.a.c.g q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? f34616f : (c.p.a.a.a.c.g) invokeV.objValue;
    }

    @NonNull
    public static c.p.a.a.a.c.h r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            if (f34617g == null) {
                f34617g = new c.p.a.a.a.a.b();
            }
            return f34617g;
        }
        return (c.p.a.a.a.c.h) invokeV.objValue;
    }

    public static d.j s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            if (f34620j == null) {
                f34620j = new b();
            }
            return f34620j;
        }
        return (d.j) invokeV.objValue;
    }

    public static o t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? m : (o) invokeV.objValue;
    }

    @NonNull
    public static p u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            if (r == null) {
                r = new c();
            }
            return r;
        }
        return (p) invokeV.objValue;
    }

    @NonNull
    public static JSONObject v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            c.p.a.a.a.c.i iVar = f34618h;
            if (iVar != null && iVar.a() != null) {
                return f34618h.a();
            }
            return f34611a;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static c.p.a.a.a.c.l w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? q : (c.p.a.a.a.c.l) invokeV.objValue;
    }

    @Nullable
    public static c.p.a.a.a.c.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? f34619i : (c.p.a.a.a.c.b) invokeV.objValue;
    }

    @Nullable
    public static c.p.a.a.a.c.m y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? p : (c.p.a.a.a.c.m) invokeV.objValue;
    }

    public static String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? "1.7.0" : (String) invokeV.objValue;
    }
}
