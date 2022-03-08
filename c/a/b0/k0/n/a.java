package c.a.b0.k0.n;

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
import c.a.b0.j0.a;
import c.a.b0.k0.j.b;
import c.a.b0.k0.l.b;
import c.a.b0.k0.m.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.webview.container.BaseNativeBrowserContainer;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.InputType;
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
    public WebView f1732b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.b0.k0.l.b f1733c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.b0.k0.j.c f1734d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.b0.k0.j.a f1735e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.b0.k0.d.a f1736f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1737g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f1738h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnLayoutChangeListener f1739i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1740j;
    public final Object k;
    public long l;
    public int m;
    public final c.a.b0.k0.o.a n;

    /* renamed from: c.a.b0.k0.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0063a implements c.a.b0.k0.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0063a(a aVar) {
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

        @Override // c.a.b0.k0.o.a
        public void loadUrl(String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) || this.a.f1732b == null) {
                return;
            }
            this.a.f1732b.loadUrl(str, map);
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

        @Override // c.a.b0.j0.a.b
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
        public final /* synthetic */ a f1741b;

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
            this.f1741b = aVar;
            this.a = webView;
        }

        @Override // c.a.b0.k0.j.b.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Rect rect = new Rect();
                this.a.getWindowVisibleDisplayFrame(rect);
                int i2 = this.f1741b.a.getResources().getDisplayMetrics().heightPixels - rect.bottom;
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
    public class d implements a.InterfaceC0062a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1742b;

        /* renamed from: c.a.b0.k0.n.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0064a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f1743e;

            public RunnableC0064a(d dVar) {
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
                this.f1743e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f1743e.f1742b.f1732b.canGoBack()) {
                        this.f1743e.f1742b.f1732b.goBack();
                    } else {
                        this.f1743e.a.finish();
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
            this.f1742b = aVar;
            this.a = activity;
        }

        @Override // c.a.b0.k0.m.a.a.InterfaceC0062a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1742b.f1732b.post(new RunnableC0064a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f1744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f1745f;

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
            this.f1745f = aVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int i10 = rect.bottom;
                int i11 = this.f1744e;
                if (i10 != i11 && i11 != 0) {
                    LinearLayout webRootView = this.f1745f.a.getWebRootView();
                    int i12 = this.f1744e - rect.bottom;
                    if (i12 > 200) {
                        this.f1745f.f1740j = true;
                        if (i4 == i8) {
                            webRootView.setPadding(webRootView.getPaddingLeft(), webRootView.getPaddingTop(), webRootView.getPaddingRight(), i12);
                            c.a.b0.k0.h.a.b(this.f1745f.n, webRootView.getHeight() - i12, i12, webRootView.getHeight(), 0);
                            a aVar = this.f1745f;
                            aVar.G(aVar.f1732b, -1, -1);
                        }
                    } else {
                        if (i4 == i8 && this.f1745f.f1740j) {
                            webRootView.setPadding(webRootView.getPaddingLeft(), webRootView.getPaddingTop(), webRootView.getPaddingRight(), 0);
                            c.a.b0.k0.h.a.b(this.f1745f.n, webRootView.getHeight(), 0, webRootView.getHeight(), 0);
                            a aVar2 = this.f1745f;
                            aVar2.G(aVar2.f1732b, -1, -1);
                        }
                        this.f1745f.f1740j = false;
                    }
                    this.f1744e = rect.bottom;
                    return;
                }
                this.f1744e = rect.bottom;
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
        this.f1735e = new c.a.b0.k0.j.a();
        this.f1737g = true;
        this.f1738h = null;
        this.k = new Object();
        this.l = 0L;
        this.n = new C0063a(this);
        this.a = baseNativeBrowserContainer;
    }

    public void A() {
        c.a.b0.k0.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f1734d) == null) {
            return;
        }
        cVar.d();
    }

    public void B(WebView webView, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2, str, str2) == null) {
            if (!NetUtil.a(this.a.getWebRootView().getContext())) {
                this.m = -1000;
            } else {
                this.m = i2;
            }
        }
    }

    public void C(String str) {
        c.a.b0.k0.l.b bVar;
        b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (bVar = this.f1733c) == null || (cVar = bVar.f1717b) == null || TextUtils.isEmpty(cVar.a)) {
            return;
        }
        this.a.loadJavaScript(this.f1733c.f1717b.a);
    }

    public void D() {
        c.a.b0.k0.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f1734d) == null) {
            return;
        }
        cVar.e();
    }

    public void E() {
        c.a.b0.k0.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f1734d) == null) {
            return;
        }
        cVar.f();
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
            I(webView, str2);
            c.a.b0.k0.l.b bVar = this.f1733c;
            if (bVar == null || !bVar.a()) {
                return true;
            }
            return !c.a.b0.f.h.b.a(webView.getContext(), str2);
        }
        return invokeLLL.booleanValue;
    }

    public final void I(@NonNull WebView webView, String str) {
        c.a.b0.k0.l.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str) == null) || TextUtils.isEmpty(str) || !str.startsWith("tel:") || webView.getContext() == null || (bVar = this.f1733c) == null || TextUtils.isEmpty(bVar.f1721f)) {
            return;
        }
        new c.a.b0.l0.t.a().m(webView.getContext(), this.f1733c.f1721f, InputType.TEL);
    }

    public final void f() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a.getWebRootView() == null || this.f1738h == null || (viewTreeObserver = this.a.getWebRootView().getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.f1738h);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.a.getWebRootView() == null || this.f1739i == null) {
            return;
        }
        this.a.getWebRootView().removeOnLayoutChangeListener(this.f1739i);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f1734d = null;
            c.a.b0.k0.d.a aVar = this.f1736f;
            if (aVar != null) {
                aVar.d();
                this.f1736f = null;
            }
        }
    }

    public c.a.b0.k0.j.c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1734d : (c.a.b0.k0.j.c) invokeV.objValue;
    }

    @Nullable
    public final Intent j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a.getIntent() : (Intent) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.b0.k0.l.b bVar = this.f1733c;
            if (bVar == null) {
                return null;
            }
            return bVar.f1722g;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c.a.b0.k0.l.b bVar = this.f1733c;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.f1734d.g();
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
        if (interceptable == null || interceptable.invokeL(1048593, this, intent) == null) {
            this.f1733c = c.a.b0.k0.l.b.b(intent);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.f1736f == null) {
                this.f1736f = new c.a.b0.k0.d.a();
            }
            c.a.b0.k0.l.b bVar = this.f1733c;
            if (bVar != null) {
                this.f1736f.b(bVar.f1724i);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.a.getRootView() == null) {
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
        if (this.f1733c != null) {
            JSONObject jSONObject = new JSONObject();
            c.a.b0.x.b.e(jSONObject, LegoListActivityConfig.AD_ID, this.f1733c.f1718c);
            c.a.b0.x.b.e(jSONObject, "lp_url", this.f1733c.a);
            c.a.b0.x.b.e(jSONObject, "log_ext", this.f1733c.f1721f);
            c.a.b0.x.b.e(jSONObject, Constant.KEY_BUSINESS, "native_ads");
            b.C0061b c0061b = this.f1733c.f1725j;
            if (c0061b != null) {
                c.a.b0.x.b.e(jSONObject, "key", c0061b.f1731e);
                c.a.b0.x.b.e(jSONObject, "url", this.f1733c.f1725j.a);
                c.a.b0.x.b.e(jSONObject, "close_v_dl", this.f1733c.f1725j.f1728b);
                c.a.b0.x.b.e(jSONObject, "app_icon", this.f1733c.f1725j.f1730d);
                c.a.b0.x.b.e(jSONObject, "app_name", this.f1733c.f1725j.f1729c);
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
        if (interceptable == null || interceptable.invokeLL(1048596, this, activity, webView) == null) {
            c.a.b0.k0.j.b bVar = new c.a.b0.k0.j.b(0);
            bVar.a(this.f1735e);
            bVar.b(new c(this, webView));
            this.a.addJavascriptInterface(bVar, "NadJsControl");
            this.a.addJavascriptInterface(new c.a.b0.k0.m.a.a(new d(this, activity)), "go_back_js_interface_name");
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.a.getWebRootView() == null) {
            return;
        }
        if (this.f1738h == null) {
            this.f1738h = new c.a.b0.k0.p.a(this.a.getWebRootView());
        }
        ViewTreeObserver viewTreeObserver = this.a.getWebRootView().getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.f1738h);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f1739i = new e(this);
            if (this.a.getWebRootView() != null) {
                this.a.getWebRootView().addOnLayoutChangeListener(this.f1739i);
            }
        }
    }

    public final void t() {
        Intent j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (j2 = j()) == null) {
            return;
        }
        n(j2);
        o();
        this.f1734d = new c.a.b0.k0.j.c();
        c.a.b0.k0.i.b.b().a(this.k, new b(this));
    }

    public void u(Context context, ViewGroup viewGroup, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048600, this, context, viewGroup, webView) == null) {
            this.f1732b = webView;
            p();
            if (c.a.b0.k0.i.b.h()) {
                f();
                g();
            } else if (this.f1737g) {
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
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            t();
        }
    }

    public void w() {
        c.a.b0.k0.j.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.a.b0.k0.l.b bVar = this.f1733c;
            if (bVar != null && TextUtils.equals(bVar.f1723h, "1") && (cVar = this.f1734d) != null) {
                this.f1734d.b(this.f1735e.a(), cVar.a(this.f1733c.f1721f, this.l, this.m, false), this.f1733c.a, this.a.getFrom(), 0L);
            }
            c.a.b0.k0.j.c cVar2 = this.f1734d;
            if (cVar2 != null) {
                cVar2.c();
            }
            c.a.b0.k0.i.b.b().release();
            h();
            f();
            g();
            if (this.f1739i != null) {
                this.a.getWebRootView().removeOnLayoutChangeListener(this.f1739i);
            }
            c.a.b0.k.e.a().unregister(this.k);
        }
    }

    public void x(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, intent) == null) || intent == null) {
            return;
        }
        t();
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, str) == null) && this.l == 0) {
            this.l = System.currentTimeMillis();
        }
    }

    public void z(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, webView, str, bitmap) == null) {
        }
    }
}
