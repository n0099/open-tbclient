package c.a.p0.a.n1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.p.d.e0;
import c.a.p0.a.z2.n0;
import c.a.p0.a.z2.q;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.view.SwanAppActionBar;
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

        /* renamed from: c.a.p0.a.n1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0383a implements e0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File[] a;

            public C0383a(a aVar, File[] fileArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, fileArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fileArr;
            }

            @Override // c.a.p0.a.p.d.e0.a
            public void onResult(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && str.contains("success")) {
                    for (File file : this.a) {
                        c.a.p0.w.d.L(file);
                    }
                }
            }
        }

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

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bitmap p = n0.p();
                e0 u = c.a.p0.a.c1.a.u();
                c.a.p0.a.m2.a.d().b();
                File[] c2 = c.a.p0.a.m2.a.d().f().c();
                File b2 = c.a.p0.a.c1.a.i().b(AppRuntime.getAppContext(), c.a.p0.a.d2.e.f0());
                if (c2 != null) {
                    int length = c2.length;
                    fileArr = (File[]) Arrays.copyOf(c2, length + 1);
                    fileArr[length] = b2;
                } else {
                    fileArr = new File[]{b2};
                }
                if (u != null) {
                    u.d(p, null, fileArr, new C0383a(this, fileArr));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(824577965, "Lc/a/p0/a/n1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(824577965, "Lc/a/p0/a/n1/c;");
                return;
            }
        }
        a = k.a;
    }

    public static void a() {
        c.a.p0.a.h0.g.g V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (V = c.a.p0.a.g1.f.U().V()) == null || V.m() == null) {
            return;
        }
        q.k(new a(), "feedback error page");
    }

    public static Rect b(Bitmap bitmap, c.a.p0.a.h0.g.f fVar, View view) {
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
            SwanAppActionBar L1 = fVar.L1();
            if (L1 == null) {
                return null;
            }
            int[] iArr2 = new int[2];
            L1.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + L1.getHeight() + 1);
            c.a.p0.a.p.e.b p3 = fVar.p3();
            if (p3 != null) {
                c.a.p0.a.p.e.e l = p3.l();
                if (l instanceof SwanAppWebViewWidget) {
                    boolean z = a;
                    int O1 = ((SwanAppWebViewWidget) l).O1();
                    if (a) {
                        String str = "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + O1;
                    }
                    if (O1 > 0) {
                        iArr[1] = iArr[1] + O1 + 1;
                    }
                    if (a) {
                        String str2 = "getCheckRect: webview widget newY=" + iArr[1];
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

    public static int d(c.a.p0.a.h0.g.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar)) == null) {
            if (fVar != null) {
                c.a.p0.a.d2.n.g H1 = fVar.H1();
                if (H1 != null) {
                    return H1.f4658e;
                }
                FrameLayout y3 = fVar.y3();
                if (y3 != null) {
                    Drawable background = y3.getBackground();
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
                if (c.a.p0.a.d2.e.L() != null) {
                    jSONObject.put("name", c.a.p0.a.d2.e.L().Y());
                } else {
                    jSONObject.put("name", RomUtils.UNKNOWN);
                }
                jSONObject.put(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, c.a.p0.a.c1.a.o().z(AppRuntime.getAppContext()));
                jSONObject.put("net", SwanAppNetworkUtils.e());
                jSONObject.put("swaninfo", c.a.p0.a.q2.b.e(c.a.p0.a.d2.d.J().l()).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static c.a.p0.a.h0.g.f f() {
        InterceptResult invokeV;
        c.a.p0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            SwanAppActivity activity = c.a.p0.a.g1.f.U().getActivity();
            if (activity == null || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null) {
                return null;
            }
            c.a.p0.a.h0.g.d m = swanAppFragmentManager.m();
            if (m instanceof c.a.p0.a.h0.g.f) {
                return (c.a.p0.a.h0.g.f) m;
            }
            return null;
        }
        return (c.a.p0.a.h0.g.f) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        c.a.p0.a.c2.b.c.a floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            SwanAppActivity activity = c.a.p0.a.g1.f.U().getActivity();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? c.a.p0.a.g1.f.U().getActivity().getFloatLayer().f() : invokeV.booleanValue;
    }

    public static void i(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65545, null, z, str) == null) {
            String f0 = c.a.p0.a.d2.e.f0();
            Context activity = c.a.p0.a.g1.f.U().getActivity();
            if (activity == null) {
                activity = AppRuntime.getAppContext();
            }
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            if (f0.lastIndexOf("_dev") > 0 || f0.lastIndexOf("_trial") > 0) {
                c.a.p0.a.c2.b.f.e f2 = c.a.p0.a.c2.b.f.e.f(activity, c.a.p0.a.h.aiapps_swan_app_error_page_hint);
                f2.l(5);
                f2.q(3);
                f2.G();
            }
            if (z) {
                c.a.p0.a.h0.i.h.f fVar = new c.a.p0.a.h0.i.h.f();
                fVar.e(SceneType.SCENE_WHITE_SCREEN_L1);
                fVar.d(str);
            }
        }
    }
}
