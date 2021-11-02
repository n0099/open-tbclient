package b.a.p0.a.m1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h;
import b.a.p0.a.h0.i.g;
import b.a.p0.a.h0.i.i;
import b.a.p0.a.k;
import b.a.p0.a.p.d.e0;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6652a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f6653b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6654a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6655b;

        public a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6654a = str;
            this.f6655b = str2;
        }

        @Override // b.a.p0.a.h0.i.g.a
        public void a(@NonNull b.a.p0.a.h0.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                b.a.p0.a.h0.i.f.c(this.f6654a, gVar);
                boolean b0 = b.a.p0.a.h0.u.g.M().b0();
                long o = b.a.p0.a.c1.a.Z().o();
                if (o >= 6000 || b0) {
                    i.r(gVar);
                }
                i.i(b.a.p0.a.h0.i.c.c(this.f6655b, gVar, o, b0));
                i.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public class a implements e0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File[] f6656a;

            public a(b bVar, File[] fileArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, fileArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6656a = fileArr;
            }

            @Override // b.a.p0.a.p.d.e0.a
            public void onResult(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && str.contains("success")) {
                    for (File file : this.f6656a) {
                        b.a.p0.t.d.K(file);
                    }
                }
            }
        }

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

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bitmap p = n0.p();
                e0 t = b.a.p0.a.c1.a.t();
                b.a.p0.a.i2.a.d().b();
                File[] c2 = b.a.p0.a.i2.a.d().f().c();
                File b2 = b.a.p0.a.c1.a.h().b(AppRuntime.getAppContext(), b.a.p0.a.a2.e.U());
                if (c2 != null) {
                    int length = c2.length;
                    fileArr = (File[]) Arrays.copyOf(c2, length + 1);
                    fileArr[length] = b2;
                } else {
                    fileArr = new File[]{b2};
                }
                if (t != null) {
                    t.d(p, null, fileArr, new a(this, fileArr));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1329213069, "Lb/a/p0/a/m1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1329213069, "Lb/a/p0/a/m1/c;");
                return;
            }
        }
        f6652a = k.f6397a;
        b.a.p0.a.c1.a.Z().getSwitch("swan_white_screent_webview_progress_bar_switch", false);
        f6653b = false;
    }

    public static void a() {
        b.a.p0.a.h0.g.g U;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (U = b.a.p0.a.g1.f.T().U()) == null || U.m() == null) {
            return;
        }
        q.j(new b(), "feedback error page");
    }

    public static Rect b(Bitmap bitmap, b.a.p0.a.h0.g.f fVar, View view) {
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
            SwanAppActionBar B1 = fVar.B1();
            if (B1 == null) {
                return null;
            }
            int[] iArr2 = new int[2];
            B1.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + B1.getHeight() + 1);
            if (f6653b) {
                boolean z = f6652a;
                b.a.p0.a.p.e.b V2 = fVar.V2();
                if (V2 != null) {
                    b.a.p0.a.p.e.e k = V2.k();
                    if (k instanceof SwanAppWebViewWidget) {
                        boolean z2 = f6652a;
                        int H1 = ((SwanAppWebViewWidget) k).H1();
                        if (f6652a) {
                            String str = "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + H1;
                        }
                        if (H1 > 0) {
                            iArr[1] = iArr[1] + H1 + 1;
                        }
                        if (f6652a) {
                            String str2 = "getCheckRect: webview widget newY=" + iArr[1];
                        }
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

    public static int d(b.a.p0.a.h0.g.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar)) == null) {
            if (fVar != null) {
                b.a.p0.a.a2.n.g x1 = fVar.x1();
                if (x1 != null) {
                    return x1.f4008e;
                }
                FrameLayout e3 = fVar.e3();
                if (e3 != null) {
                    Drawable background = e3.getBackground();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (b.a.p0.a.a2.e.i() != null) {
                    jSONObject.put("name", b.a.p0.a.a2.e.i().N());
                } else {
                    jSONObject.put("name", RomUtils.UNKNOWN);
                }
                jSONObject.put(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, b.a.p0.a.c1.a.n().x(AppRuntime.getAppContext()));
                jSONObject.put("net", SwanAppNetworkUtils.e());
                jSONObject.put("swaninfo", b.a.p0.a.m2.b.e(b.a.p0.a.a2.d.g().l()).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static b.a.p0.a.h0.g.f f() {
        InterceptResult invokeV;
        b.a.p0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            SwanAppActivity activity = b.a.p0.a.g1.f.T().getActivity();
            if (activity == null || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null) {
                return null;
            }
            b.a.p0.a.h0.g.d m = swanAppFragmentManager.m();
            if (m instanceof b.a.p0.a.h0.g.f) {
                return (b.a.p0.a.h0.g.f) m;
            }
            return null;
        }
        return (b.a.p0.a.h0.g.f) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        b.a.p0.a.z1.b.c.a floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            SwanAppActivity activity = b.a.p0.a.g1.f.T().getActivity();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? b.a.p0.a.g1.f.T().getActivity().getFloatLayer().e() : invokeV.booleanValue;
    }

    public static void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            String U = b.a.p0.a.a2.e.U();
            Context activity = b.a.p0.a.g1.f.T().getActivity();
            if (activity == null) {
                activity = AppRuntime.getAppContext();
            }
            if (TextUtils.isEmpty(U)) {
                return;
            }
            if (U.lastIndexOf("_dev") > 0 || U.lastIndexOf("_trial") > 0) {
                b.a.p0.a.z1.b.f.e f2 = b.a.p0.a.z1.b.f.e.f(activity, h.aiapps_swan_app_error_page_hint);
                f2.l(5);
                f2.p(3);
                f2.F();
            }
            if (z) {
                j("whiteScreen_L1", "检测到纯白屏；");
            }
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            i.d(new a(str, str2));
        }
    }
}
