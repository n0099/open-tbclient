package c.a.a0.a;

import android.content.Context;
import android.opengl.EGLContext;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.a.h.g;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1638a = false;

    /* renamed from: b  reason: collision with root package name */
    public static c f1639b = null;

    /* renamed from: c  reason: collision with root package name */
    public static c.a.a0.a.g.b f1640c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Context f1641d = null;

    /* renamed from: e  reason: collision with root package name */
    public static byte[] f1642e = null;

    /* renamed from: f  reason: collision with root package name */
    public static JSONObject f1643f = null;

    /* renamed from: g  reason: collision with root package name */
    public static JSONObject f1644g = null;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f1645h = true;

    /* renamed from: i  reason: collision with root package name */
    public static String f1646i = "live";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface a {
        void onProgress(int i2, int i3);

        void onResult(boolean z, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1456963713, "Lc/a/a0/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1456963713, "Lc/a/a0/a/b;");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f1642e : (byte[]) invokeV.objValue;
    }

    public static Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f1641d : (Context) invokeV.objValue;
    }

    public static c.a.a0.a.g.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f1640c : (c.a.a0.a.g.b) invokeV.objValue;
    }

    public static DefaultParams e(EGLContext eGLContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, eGLContext)) == null) {
            String g2 = c.g();
            if (n()) {
                a("getDuMixDefaultParams EGLContext: " + eGLContext + ", modelPath: " + g2);
            }
            DefaultParams defaultParams = new DefaultParams();
            defaultParams.setFaceAlgoModelPath(g2);
            JSONObject jSONObject = f1643f;
            if (jSONObject != null && jSONObject.length() > 0) {
                defaultParams.setGradingConfig(f1643f);
            }
            if (eGLContext != null) {
                defaultParams.setUseTextureIO(true);
                defaultParams.setShareContext(eGLContext);
            }
            JSONObject jSONObject2 = f1643f;
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                defaultParams.setGradingConfig(f1643f);
                if (n()) {
                    a("getDuMixDefaultParams  " + f1643f.toString());
                }
            }
            return defaultParams;
        }
        return (DefaultParams) invokeL.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f1646i : (String) invokeV.objValue;
    }

    public static synchronized c.a.a0.a.f.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (b.class) {
                if (f1644g == null || f1644g.length() <= 0) {
                    return null;
                }
                return c.a.a0.a.f.b.b(f1644g);
            }
        }
        return (c.a.a0.a.f.b) invokeV.objValue;
    }

    public static c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f1639b : (c) invokeV.objValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a.a0.a.a.a0() : invokeV.intValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.a.a0.a.a.b0() : (String) invokeV.objValue;
    }

    public static void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            l(context, "10000", "2288883fb087c4a37fbaf12bce65916e", "");
        }
    }

    public static void l(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, context, str, str2, str3) == null) {
            m(context, str, str2, str3, null);
        }
    }

    @Deprecated
    public static void m(Context context, String str, String str2, String str3, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65549, null, context, str, str2, str3, cVar) == null) {
            if (n()) {
                a("sdk init with appId:" + str + ", apikey:" + str2 + ", secretKey:" + str3);
            }
            f1641d = context.getApplicationContext();
            DuMixARConfig.setAppId(str);
            DuMixARConfig.setAPIKey(str2);
            DuMixARConfig.setSecretKey(str3);
            c.a.a0.a.h.d.d().i(f1641d);
            t(cVar);
        }
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? f1638a : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? g.e().h() : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f1645h : invokeV.booleanValue;
    }

    public static void q(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, aVar) == null) {
            g.e().k(aVar);
        }
    }

    public static void r(c.a.a0.a.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, bVar) == null) {
            f1640c = bVar;
        }
    }

    public static void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            f1646i = str;
        }
    }

    public static void t(c cVar) {
        File f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, cVar) == null) {
            f1639b = cVar;
            if (cVar != null || (f2 = g.e().f()) == null) {
                return;
            }
            f1639b = new c(f2.getAbsolutePath());
        }
    }

    public static void u(File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, null, file) == null) || file == null) {
            return;
        }
        c cVar = f1639b;
        if (cVar == null) {
            cVar = new c(file.getAbsolutePath());
        }
        t(cVar);
    }

    public static void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, null, z) == null) {
            f1645h = z;
            u(g.e().f());
        }
    }
}
