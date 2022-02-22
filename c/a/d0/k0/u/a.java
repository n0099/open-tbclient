package c.a.d0.k0.u;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.j0.a;
import c.a.d0.k0.q.b;
import c.a.d0.k0.s.b;
import c.a.d0.k0.t.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.container.BaseNativeBrowserContainer;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public BaseNativeBrowserContainer a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f2917b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d0.k0.s.b f2918c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.d0.k0.q.c f2919d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.d0.k0.q.a f2920e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d0.k0.k.a f2921f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2922g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f2923h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnLayoutChangeListener f2924i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2925j;
    public final Object k;
    public final c.a.d0.k0.v.a l;

    /* renamed from: c.a.d0.k0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0104a implements c.a.d0.k0.v.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0104a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.d0.k0.v.a
        public void loadUrl(String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) || this.a.f2917b == null) {
                return;
            }
            this.a.f2917b.loadUrl(str, map);
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.d0.j0.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.a.loadJavaScript(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f2926b;

        public c(a aVar, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2926b = aVar;
            this.a = webView;
        }

        @Override // c.a.d0.k0.q.b.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Rect rect = new Rect();
                this.a.getWindowVisibleDisplayFrame(rect);
                int i2 = this.f2926b.a.getResources().getDisplayMetrics().heightPixels - rect.bottom;
                if (i2 < 0) {
                    i2 = 0;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visibleHeight", this.a.getHeight() - i2);
                    jSONObject.put("keyboardHeight", i2);
                    jSONObject.put("webviewHeight", this.a.getHeight());
                    jSONObject.put("videoHeight", 0);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jSONObject.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.InterfaceC0103a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f2927b;

        /* renamed from: c.a.d0.k0.u.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0105a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f2928e;

            public RunnableC0105a(d dVar) {
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
                this.f2928e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f2928e.f2927b.f2917b.canGoBack()) {
                        this.f2928e.f2927b.f2917b.goBack();
                    } else {
                        this.f2928e.a.finish();
                    }
                }
            }
        }

        public d(a aVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2927b = aVar;
            this.a = activity;
        }

        @Override // c.a.d0.k0.t.a.a.InterfaceC0103a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2927b.f2917b.post(new RunnableC0105a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f2929e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f2930f;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2930f = aVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int i10 = rect.bottom;
                int i11 = this.f2929e;
                if (i10 != i11 && i11 != 0) {
                    LinearLayout webRootView = this.f2930f.a.getWebRootView();
                    int i12 = this.f2929e - rect.bottom;
                    if (i12 > 200) {
                        this.f2930f.f2925j = true;
                        if (i4 == i8) {
                            webRootView.setPadding(webRootView.getPaddingLeft(), webRootView.getPaddingTop(), webRootView.getPaddingRight(), i12);
                            c.a.d0.k0.o.a.b(this.f2930f.l, webRootView.getHeight() - i12, i12, webRootView.getHeight(), 0);
                            a aVar = this.f2930f;
                            aVar.G(aVar.f2917b, -1, -1);
                        }
                    } else {
                        if (i4 == i8 && this.f2930f.f2925j) {
                            webRootView.setPadding(webRootView.getPaddingLeft(), webRootView.getPaddingTop(), webRootView.getPaddingRight(), 0);
                            c.a.d0.k0.o.a.b(this.f2930f.l, webRootView.getHeight(), 0, webRootView.getHeight(), 0);
                            a aVar2 = this.f2930f;
                            aVar2.G(aVar2.f2917b, -1, -1);
                        }
                        this.f2930f.f2925j = false;
                    }
                    this.f2929e = rect.bottom;
                    return;
                }
                this.f2929e = rect.bottom;
            }
        }
    }

    public a(@NonNull BaseNativeBrowserContainer baseNativeBrowserContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseNativeBrowserContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2920e = new c.a.d0.k0.q.a();
        this.f2922g = true;
        this.f2923h = null;
        this.k = new Object();
        this.l = new C0104a(this);
        this.a = baseNativeBrowserContainer;
    }

    public void A() {
        c.a.d0.k0.q.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f2919d) == null) {
            return;
        }
        cVar.c();
    }

    public void B(WebView webView, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2, str, str2) == null) {
        }
    }

    public void C(String str) {
        c.a.d0.k0.s.b bVar;
        b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (bVar = this.f2918c) == null || (cVar = bVar.f2902b) == null || TextUtils.isEmpty(cVar.a)) {
            return;
        }
        this.a.loadJavaScript(this.f2918c.f2902b.a);
    }

    public void D() {
        c.a.d0.k0.q.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f2919d) == null) {
            return;
        }
        cVar.d();
    }

    public void E() {
        c.a.d0.k0.q.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f2919d) == null) {
            return;
        }
        cVar.e();
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void G(@NonNull View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, view, i2, i3) == null) {
            if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                view.setLayoutParams(new FrameLayout.LayoutParams(i2, i3));
            } else if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                view.setLayoutParams(new LinearLayout.LayoutParams(i2, i3));
            } else if (view.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                view.setLayoutParams(new RelativeLayout.LayoutParams(i2, i3));
            } else if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                view.setLayoutParams(new ViewGroup.MarginLayoutParams(i2, i3));
            } else if (view.getLayoutParams() instanceof ViewGroup.LayoutParams) {
                view.setLayoutParams(new ViewGroup.LayoutParams(i2, i3));
            }
        }
    }

    public boolean H(@NonNull WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, webView, str, str2)) == null) {
            c.a.d0.k0.s.b bVar = this.f2918c;
            if (bVar == null || !bVar.a()) {
                return true;
            }
            return !c.a.d0.f.i.b.a(webView.getContext(), str2);
        }
        return invokeLLL.booleanValue;
    }

    public final void f() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.getWebRootView() == null || this.f2923h == null || (viewTreeObserver = this.a.getWebRootView().getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.f2923h);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a.getWebRootView() == null || this.f2924i == null) {
            return;
        }
        this.a.getWebRootView().removeOnLayoutChangeListener(this.f2924i);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f2919d = null;
            c.a.d0.k0.k.a aVar = this.f2921f;
            if (aVar != null) {
                aVar.d();
                this.f2921f = null;
            }
        }
    }

    public c.a.d0.k0.q.c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f2919d : (c.a.d0.k0.q.c) invokeV.objValue;
    }

    @Nullable
    public final Intent j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.getIntent() : (Intent) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.d0.k0.s.b bVar = this.f2918c;
            if (bVar == null) {
                return null;
            }
            return bVar.f2907g;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.d0.k0.s.b bVar = this.f2918c;
            if (bVar == null) {
                return null;
            }
            return bVar.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (j() != null) {
                String k = k();
                if (TextUtils.isEmpty(k)) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Referer", k);
                this.a.loadUrl(hashMap);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void n(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, intent) == null) {
            this.f2918c = c.a.d0.k0.s.b.b(intent);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f2921f == null) {
                this.f2921f = new c.a.d0.k0.k.a();
            }
            c.a.d0.k0.s.b bVar = this.f2918c;
            if (bVar != null) {
                this.f2921f.b(bVar.f2909i);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.a.getRootView() == null) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.a.getWebRootView().getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setVisibility(8);
        this.a.getRootView().addView(relativeLayout, layoutParams);
        this.a.setDownLoadView(relativeLayout);
        String str = null;
        if (this.f2918c != null) {
            JSONObject jSONObject = new JSONObject();
            c.a.d0.x.b.e(jSONObject, LegoListActivityConfig.AD_ID, this.f2918c.f2903c);
            c.a.d0.x.b.e(jSONObject, "lp_url", this.f2918c.a);
            c.a.d0.x.b.e(jSONObject, "log_ext", this.f2918c.f2906f);
            c.a.d0.x.b.e(jSONObject, Constant.KEY_BUSINESS, "native_ads");
            b.C0102b c0102b = this.f2918c.f2910j;
            if (c0102b != null) {
                c.a.d0.x.b.e(jSONObject, "key", c0102b.f2916e);
                c.a.d0.x.b.e(jSONObject, "url", this.f2918c.f2910j.a);
                c.a.d0.x.b.e(jSONObject, "close_v_dl", this.f2918c.f2910j.f2913b);
                c.a.d0.x.b.e(jSONObject, "app_icon", this.f2918c.f2910j.f2915d);
                c.a.d0.x.b.e(jSONObject, "app_name", this.f2918c.f2910j.f2914c);
            }
            str = jSONObject.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.setmAdParams(str);
    }

    public void q(@NonNull Activity activity, @NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, activity, webView) == null) {
            c.a.d0.k0.q.b bVar = new c.a.d0.k0.q.b(0);
            bVar.a(this.f2920e);
            bVar.b(new c(this, webView));
            this.a.addJavascriptInterface(bVar, "NadJsControl");
            this.a.addJavascriptInterface(new c.a.d0.k0.t.a.a(new d(this, activity)), "go_back_js_interface_name");
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.a.getWebRootView() == null) {
            return;
        }
        if (this.f2923h == null) {
            this.f2923h = new c.a.d0.k0.w.a(this.a.getWebRootView());
        }
        ViewTreeObserver viewTreeObserver = this.a.getWebRootView().getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.f2923h);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f2924i = new e(this);
            if (this.a.getWebRootView() != null) {
                this.a.getWebRootView().addOnLayoutChangeListener(this.f2924i);
            }
        }
    }

    public final void t() {
        Intent j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (j2 = j()) == null) {
            return;
        }
        n(j2);
        o();
        this.f2919d = new c.a.d0.k0.q.c();
        c.a.d0.k0.p.b.b().a(this.k, new b(this));
    }

    public void u(Context context, ViewGroup viewGroup, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, context, viewGroup, webView) == null) {
            this.f2917b = webView;
            p();
            if (c.a.d0.k0.p.b.h()) {
                f();
                g();
            } else if (this.f2922g) {
                f();
                s();
            } else {
                r();
                g();
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            t();
        }
    }

    public void w() {
        c.a.d0.k0.q.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            c.a.d0.k0.s.b bVar = this.f2918c;
            if (bVar != null && TextUtils.equals(bVar.f2908h, "1") && (cVar = this.f2919d) != null) {
                String a = this.f2920e.a();
                c.a.d0.k0.s.b bVar2 = this.f2918c;
                cVar.a(a, bVar2.f2906f, bVar2.a, this.a.getFrom(), 0L);
            }
            c.a.d0.k0.q.c cVar2 = this.f2919d;
            if (cVar2 != null) {
                cVar2.b();
            }
            c.a.d0.k0.p.b.b().release();
            h();
            f();
            g();
            if (this.f2924i != null) {
                this.a.getWebRootView().removeOnLayoutChangeListener(this.f2924i);
            }
            c.a.d0.k.e.a().unregister(this.k);
        }
    }

    public void x(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, intent) == null) || intent == null) {
            return;
        }
        t();
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
        }
    }

    public void z(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, webView, str, bitmap) == null) {
        }
    }
}
