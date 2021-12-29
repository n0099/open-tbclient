package c.a.b0.a;

import android.content.Context;
import android.opengl.EGLContext;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.a.h.g;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static c f1516b = null;

    /* renamed from: c  reason: collision with root package name */
    public static c.a.b0.a.g.b f1517c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Context f1518d = null;

    /* renamed from: e  reason: collision with root package name */
    public static byte[] f1519e = null;

    /* renamed from: f  reason: collision with root package name */
    public static JSONObject f1520f = null;

    /* renamed from: g  reason: collision with root package name */
    public static JSONObject f1521g = null;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f1522h = true;

    /* renamed from: i  reason: collision with root package name */
    public static String f1523i = "live";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface a {
        void onProgress(int i2, int i3);

        void onResult(boolean z, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1950499902, "Lc/a/b0/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1950499902, "Lc/a/b0/a/b;");
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            String str2 = "ar->" + str;
        }
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f1519e : (byte[]) invokeV.objValue;
    }

    public static c.a.b0.a.g.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f1517c : (c.a.b0.a.g.b) invokeV.objValue;
    }

    public static DefaultParams d(EGLContext eGLContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, eGLContext)) == null) {
            String g2 = c.g();
            if (m()) {
                a("getDuMixDefaultParams EGLContext: " + eGLContext + ", modelPath: " + g2);
            }
            DefaultParams defaultParams = new DefaultParams();
            defaultParams.setFaceAlgoModelPath(g2);
            JSONObject jSONObject = f1520f;
            if (jSONObject != null && jSONObject.length() > 0) {
                defaultParams.setGradingConfig(f1520f);
            }
            if (eGLContext != null) {
                defaultParams.setUseTextureIO(true);
                defaultParams.setShareContext(eGLContext);
            }
            JSONObject jSONObject2 = f1520f;
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                defaultParams.setGradingConfig(f1520f);
                if (m()) {
                    a("getDuMixDefaultParams  " + f1520f.toString());
                }
            }
            return defaultParams;
        }
        return (DefaultParams) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f1523i : (String) invokeV.objValue;
    }

    public static synchronized c.a.b0.a.f.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            synchronized (b.class) {
                if (f1521g == null || f1521g.length() <= 0) {
                    return null;
                }
                return c.a.b0.a.f.b.b(f1521g);
            }
        }
        return (c.a.b0.a.f.b) invokeV.objValue;
    }

    public static c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f1516b : (c) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f1518d : (Context) invokeV.objValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a.b0.a.a.a0() : invokeV.intValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.a.b0.a.a.b0() : (String) invokeV.objValue;
    }

    public static void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            k(context, "10000", "2288883fb087c4a37fbaf12bce65916e", "");
        }
    }

    public static void k(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, context, str, str2, str3) == null) {
            l(context, str, str2, str3, null);
        }
    }

    @Deprecated
    public static void l(Context context, String str, String str2, String str3, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65549, null, context, str, str2, str3, cVar) == null) {
            if (m()) {
                a("sdk init with appId:" + str + ", apikey:" + str2 + ", secretKey:" + str3);
            }
            f1518d = context.getApplicationContext();
            DuMixARConfig.setAppId(str);
            DuMixARConfig.setAPIKey(str2);
            DuMixARConfig.setSecretKey(str3);
            c.a.b0.a.h.d.d().i(f1518d);
            s(cVar);
        }
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? a : invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? g.e().h() : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f1522h : invokeV.booleanValue;
    }

    public static void p(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, aVar) == null) {
            g.e().k(aVar);
        }
    }

    public static void q(c.a.b0.a.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, bVar) == null) {
            f1517c = bVar;
        }
    }

    public static void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            f1523i = str;
        }
    }

    public static void s(c cVar) {
        File f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, cVar) == null) {
            f1516b = cVar;
            if (cVar != null || (f2 = g.e().f()) == null) {
                return;
            }
            f1516b = new c(f2.getAbsolutePath());
        }
    }

    public static void t(File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, null, file) == null) || file == null) {
            return;
        }
        c cVar = f1516b;
        if (cVar == null) {
            cVar = new c(file.getAbsolutePath());
        }
        s(cVar);
    }

    public static void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, null, z) == null) {
            f1522h = z;
            t(g.e().f());
        }
    }
}
