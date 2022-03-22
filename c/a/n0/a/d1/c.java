package c.a.n0.a.d1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f.d.e0;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.n0.a.d1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0241a implements e0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File[] a;

            public C0241a(a aVar, File[] fileArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, fileArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fileArr;
            }

            @Override // c.a.n0.a.f.d.e0.a
            public void onResult(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && str.contains("success")) {
                    for (File file : this.a) {
                        c.a.n0.w.d.L(file);
                    }
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bitmap p = n0.p();
                e0 u = c.a.n0.a.s0.a.u();
                c.a.n0.a.c2.a.d().b();
                File[] c2 = c.a.n0.a.c2.a.d().f().c();
                File b2 = c.a.n0.a.s0.a.i().b(AppRuntime.getAppContext(), c.a.n0.a.t1.e.f0());
                if (c2 != null) {
                    int length = c2.length;
                    fileArr = (File[]) Arrays.copyOf(c2, length + 1);
                    fileArr[length] = b2;
                } else {
                    fileArr = new File[]{b2};
                }
                if (u != null) {
                    u.d(p, null, fileArr, new C0241a(this, fileArr));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1208369765, "Lc/a/n0/a/d1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1208369765, "Lc/a/n0/a/d1/c;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static void a() {
        c.a.n0.a.x.g.g V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (V = c.a.n0.a.w0.f.U().V()) == null || V.m() == null) {
            return;
        }
        q.k(new a(), "feedback error page");
    }

    public static Rect b(Bitmap bitmap, c.a.n0.a.x.g.f fVar, View view) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bitmap, fVar, view)) == null) {
            if (bitmap == null || fVar == null || view == null) {
                return null;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
            int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
            SwanAppActionBar I1 = fVar.I1();
            if (I1 == null) {
                return null;
            }
            int[] iArr2 = new int[2];
            I1.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + I1.getHeight() + 1);
            c.a.n0.a.f.e.b m3 = fVar.m3();
            if (m3 != null) {
                c.a.n0.a.f.e.e m = m3.m();
                if (m instanceof SwanAppWebViewWidget) {
                    if (a) {
                        Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                    }
                    int P1 = ((SwanAppWebViewWidget) m).P1();
                    if (a) {
                        Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + P1);
                    }
                    if (P1 > 0) {
                        iArr[1] = iArr[1] + P1 + 1;
                    }
                    if (a) {
                        Log.d("MonitorUtils", "getCheckRect: webview widget newY=" + iArr[1]);
                    }
                }
            }
            return new Rect(iArr[0], iArr[1], min, min2);
        }
        return (Rect) invokeLLL.objValue;
    }

    public static String c(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bitmap)) == null) {
            if (bitmap == null) {
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        }
        return (String) invokeL.objValue;
    }

    public static int d(c.a.n0.a.x.g.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar)) == null) {
            if (fVar != null) {
                c.a.n0.a.t1.n.g E1 = fVar.E1();
                if (E1 != null) {
                    return E1.f6382e;
                }
                FrameLayout v3 = fVar.v3();
                if (v3 != null) {
                    Drawable background = v3.getBackground();
                    if (background instanceof ColorDrawable) {
                        return ((ColorDrawable) background).getColor();
                    }
                    return -1;
                }
                return -1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (c.a.n0.a.t1.e.L() != null) {
                    jSONObject.put("name", c.a.n0.a.t1.e.L().Y());
                } else {
                    jSONObject.put("name", RomUtils.UNKNOWN);
                }
                jSONObject.put(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, c.a.n0.a.s0.a.o().z(AppRuntime.getAppContext()));
                jSONObject.put("net", SwanAppNetworkUtils.e());
                jSONObject.put("swaninfo", c.a.n0.a.g2.b.e(c.a.n0.a.t1.d.J().l()).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static c.a.n0.a.x.g.f f() {
        InterceptResult invokeV;
        c.a.n0.a.x.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            SwanAppActivity activity = c.a.n0.a.w0.f.U().getActivity();
            if (activity == null || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null) {
                return null;
            }
            c.a.n0.a.x.g.d m = swanAppFragmentManager.m();
            if (m instanceof c.a.n0.a.x.g.f) {
                return (c.a.n0.a.x.g.f) m;
            }
            return null;
        }
        return (c.a.n0.a.x.g.f) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        c.a.n0.a.s1.b.c.a floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            SwanAppActivity activity = c.a.n0.a.w0.f.U().getActivity();
            if (activity == null || (floatLayer = activity.getFloatLayer()) == null || !(floatLayer.d() instanceof FrameLayout)) {
                return false;
            }
            return ((FrameLayout) floatLayer.d()).getChildAt(0) instanceof LoadingView;
        }
        return invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? c.a.n0.a.w0.f.U().getActivity().getFloatLayer().f() : invokeV.booleanValue;
    }

    public static void i(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65545, null, z, str) == null) {
            String f0 = c.a.n0.a.t1.e.f0();
            Context activity = c.a.n0.a.w0.f.U().getActivity();
            if (activity == null) {
                activity = AppRuntime.getAppContext();
            }
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            if (f0.lastIndexOf("_dev") > 0 || f0.lastIndexOf("_trial") > 0) {
                c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(activity, R.string.obfuscated_res_0x7f0f01cf);
                f2.l(5);
                f2.q(3);
                f2.G();
            }
            if (z) {
                c.a.n0.a.x.i.h.f fVar = new c.a.n0.a.x.i.h.f();
                fVar.e(SceneType.SCENE_WHITE_SCREEN_L1);
                fVar.d(str);
            }
        }
    }
}
