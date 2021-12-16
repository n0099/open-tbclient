package c.a.c0.g0.t;

import android.content.Context;
import android.content.Intent;
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
import c.a.c0.g0.q.b;
import c.a.c0.g0.s.b;
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
    public WebView f1621b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.c0.g0.s.b f1622c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.c0.g0.q.c f1623d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.c0.g0.q.a f1624e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.c0.g0.k.a f1625f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1626g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f1627h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnLayoutChangeListener f1628i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1629j;

    /* renamed from: k  reason: collision with root package name */
    public final c.a.c0.g0.u.a f1630k;

    /* renamed from: c.a.c0.g0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0049a implements c.a.c0.g0.u.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0049a(a aVar) {
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

        @Override // c.a.c0.g0.u.a
        public void loadUrl(String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) || this.a.f1621b == null) {
                return;
            }
            this.a.f1621b.loadUrl(str, map);
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1631b;

        public b(a aVar, WebView webView) {
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
            this.f1631b = aVar;
            this.a = webView;
        }

        @Override // c.a.c0.g0.q.b.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Rect rect = new Rect();
                this.a.getWindowVisibleDisplayFrame(rect);
                int i2 = this.f1631b.a.getResources().getDisplayMetrics().heightPixels - rect.bottom;
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
    public class c implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f1632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f1633f;

        public c(a aVar) {
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
            this.f1633f = aVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int i10 = rect.bottom;
                int i11 = this.f1632e;
                if (i10 != i11 && i11 != 0) {
                    LinearLayout webRootView = this.f1633f.a.getWebRootView();
                    int i12 = this.f1632e - rect.bottom;
                    if (i12 > 200) {
                        this.f1633f.f1629j = true;
                        if (i4 == i8) {
                            webRootView.setPadding(webRootView.getPaddingLeft(), webRootView.getPaddingTop(), webRootView.getPaddingRight(), i12);
                            c.a.c0.g0.o.a.b(this.f1633f.f1630k, webRootView.getHeight() - i12, i12, webRootView.getHeight(), 0);
                            this.f1633f.f1621b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                        }
                    } else {
                        if (i4 == i8 && this.f1633f.f1629j) {
                            webRootView.setPadding(webRootView.getPaddingLeft(), webRootView.getPaddingTop(), webRootView.getPaddingRight(), 0);
                            c.a.c0.g0.o.a.b(this.f1633f.f1630k, webRootView.getHeight(), 0, webRootView.getHeight(), 0);
                            this.f1633f.f1621b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                        }
                        this.f1633f.f1629j = false;
                    }
                    this.f1632e = rect.bottom;
                    return;
                }
                this.f1632e = rect.bottom;
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
        this.f1624e = new c.a.c0.g0.q.a();
        this.f1626g = true;
        this.f1627h = null;
        this.f1630k = new C0049a(this);
        this.a = baseNativeBrowserContainer;
    }

    public void A() {
        c.a.c0.g0.q.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f1623d) == null) {
            return;
        }
        cVar.d();
    }

    public void B() {
        c.a.c0.g0.q.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f1623d) == null) {
            return;
        }
        cVar.e();
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public boolean D(@NonNull WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, webView, str, str2)) == null) {
            c.a.c0.g0.s.b bVar = this.f1622c;
            if (bVar == null || !bVar.a()) {
                return true;
            }
            return !c.a.c0.d.h.b.a(webView.getContext(), str2);
        }
        return invokeLLL.booleanValue;
    }

    public final void f() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a.getWebRootView() == null || this.f1627h == null || (viewTreeObserver = this.a.getWebRootView().getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.f1627h);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.getWebRootView() == null || this.f1628i == null) {
            return;
        }
        this.a.getWebRootView().removeOnLayoutChangeListener(this.f1628i);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f1623d = null;
            c.a.c0.g0.k.a aVar = this.f1625f;
            if (aVar != null) {
                aVar.d();
                this.f1625f = null;
            }
        }
    }

    @Nullable
    public final Intent i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.getIntent() : (Intent) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.c0.g0.s.b bVar = this.f1622c;
            if (bVar == null) {
                return null;
            }
            return bVar.f1611g;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.c0.g0.s.b bVar = this.f1622c;
            if (bVar == null) {
                return null;
            }
            return bVar.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (i() != null) {
                String j2 = j();
                if (TextUtils.isEmpty(j2)) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Referer", j2);
                this.a.loadUrl(hashMap);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
            this.f1622c = c.a.c0.g0.s.b.b(intent);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.f1625f == null) {
                this.f1625f = new c.a.c0.g0.k.a();
            }
            c.a.c0.g0.s.b bVar = this.f1622c;
            if (bVar != null) {
                this.f1625f.b(bVar.f1613i);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.a.getRootView() == null) {
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
        if (this.f1622c != null) {
            JSONObject jSONObject = new JSONObject();
            c.a.c0.u.b.d(jSONObject, LegoListActivityConfig.AD_ID, this.f1622c.f1607c);
            c.a.c0.u.b.d(jSONObject, "lp_url", this.f1622c.a);
            c.a.c0.u.b.d(jSONObject, "log_ext", this.f1622c.f1610f);
            c.a.c0.u.b.d(jSONObject, Constant.KEY_BUSINESS, "native_ads");
            b.C0048b c0048b = this.f1622c.f1614j;
            if (c0048b != null) {
                c.a.c0.u.b.d(jSONObject, "key", c0048b.f1620e);
                c.a.c0.u.b.d(jSONObject, "url", this.f1622c.f1614j.a);
                c.a.c0.u.b.d(jSONObject, "close_v_dl", this.f1622c.f1614j.f1617b);
                c.a.c0.u.b.d(jSONObject, "app_icon", this.f1622c.f1614j.f1619d);
                c.a.c0.u.b.d(jSONObject, "app_name", this.f1622c.f1614j.f1618c);
            }
            str = jSONObject.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.setmAdParams(str);
    }

    public void p(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, webView) == null) {
            c.a.c0.g0.q.b bVar = new c.a.c0.g0.q.b(0);
            bVar.a(this.f1624e);
            bVar.b(new b(this, webView));
            this.a.addJavascriptInterface(bVar, "NadJsControl");
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.a.getWebRootView() == null) {
            return;
        }
        if (this.f1627h == null) {
            this.f1627h = new c.a.c0.g0.v.b(this.a.getWebRootView());
        }
        ViewTreeObserver viewTreeObserver = this.a.getWebRootView().getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.f1627h);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f1628i = new c(this);
            if (this.a.getWebRootView() != null) {
                this.a.getWebRootView().addOnLayoutChangeListener(this.f1628i);
            }
        }
    }

    public final void s() {
        Intent i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (i2 = i()) == null) {
            return;
        }
        m(i2);
        n();
        this.f1623d = new c.a.c0.g0.q.c();
    }

    public void t(Context context, ViewGroup viewGroup, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, context, viewGroup, webView) == null) {
            this.f1621b = webView;
            o();
            if (c.a.c0.g0.p.b.h()) {
                f();
                g();
            } else if (this.f1626g) {
                f();
                r();
            } else {
                q();
                g();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            s();
        }
    }

    public void v() {
        c.a.c0.g0.q.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.c0.g0.s.b bVar = this.f1622c;
            if (bVar != null && TextUtils.equals(bVar.f1612h, "1") && (cVar = this.f1623d) != null) {
                String a = this.f1624e.a();
                c.a.c0.g0.s.b bVar2 = this.f1622c;
                cVar.a(a, bVar2.f1610f, bVar2.a, this.a.getFrom(), 0L);
            }
            c.a.c0.g0.q.c cVar2 = this.f1623d;
            if (cVar2 != null) {
                cVar2.b();
            }
            c.a.c0.g0.p.b.b().release();
            h();
            f();
            g();
            if (this.f1628i != null) {
                this.a.getWebRootView().removeOnLayoutChangeListener(this.f1628i);
            }
        }
    }

    public void w(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, intent) == null) || intent == null) {
            return;
        }
        s();
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
        }
    }

    public void y() {
        c.a.c0.g0.q.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (cVar = this.f1623d) == null) {
            return;
        }
        cVar.c();
    }

    public void z(String str) {
        c.a.c0.g0.s.b bVar;
        b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || (bVar = this.f1622c) == null || (cVar = bVar.f1606b) == null || TextUtils.isEmpty(cVar.a)) {
            return;
        }
        this.a.loadJavaScript(this.f1622c.f1606b.a);
    }
}
