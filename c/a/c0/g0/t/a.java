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
    public WebView f2048b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.c0.g0.s.b f2049c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.c0.g0.q.c f2050d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.c0.g0.q.a f2051e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.c0.g0.k.a f2052f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2053g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f2054h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnLayoutChangeListener f2055i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2056j;

    /* renamed from: k  reason: collision with root package name */
    public final c.a.c0.g0.u.a f2057k;

    /* renamed from: c.a.c0.g0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0070a implements c.a.c0.g0.u.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0070a(a aVar) {
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
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) || this.a.f2048b == null) {
                return;
            }
            this.a.f2048b.loadUrl(str, map);
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f2058b;

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
            this.f2058b = aVar;
            this.a = webView;
        }

        @Override // c.a.c0.g0.q.b.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Rect rect = new Rect();
                this.a.getWindowVisibleDisplayFrame(rect);
                int i2 = this.f2058b.a.getResources().getDisplayMetrics().heightPixels - rect.bottom;
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
        public int f2059e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f2060f;

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
            this.f2060f = aVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int i10 = rect.bottom;
                int i11 = this.f2059e;
                if (i10 != i11 && i11 != 0) {
                    LinearLayout webRootView = this.f2060f.a.getWebRootView();
                    int i12 = this.f2059e - rect.bottom;
                    if (i12 > 200) {
                        this.f2060f.f2056j = true;
                        if (i4 == i8) {
                            webRootView.setPadding(webRootView.getPaddingLeft(), webRootView.getPaddingTop(), webRootView.getPaddingRight(), i12);
                            c.a.c0.g0.o.a.b(this.f2060f.f2057k, webRootView.getHeight() - i12, i12, webRootView.getHeight(), 0);
                            this.f2060f.f2048b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                        }
                    } else {
                        if (i4 == i8 && this.f2060f.f2056j) {
                            webRootView.setPadding(webRootView.getPaddingLeft(), webRootView.getPaddingTop(), webRootView.getPaddingRight(), 0);
                            c.a.c0.g0.o.a.b(this.f2060f.f2057k, webRootView.getHeight(), 0, webRootView.getHeight(), 0);
                            this.f2060f.f2048b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                        }
                        this.f2060f.f2056j = false;
                    }
                    this.f2059e = rect.bottom;
                    return;
                }
                this.f2059e = rect.bottom;
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
        this.f2051e = new c.a.c0.g0.q.a();
        this.f2053g = true;
        this.f2054h = null;
        this.f2057k = new C0070a(this);
        this.a = baseNativeBrowserContainer;
    }

    public void A() {
        c.a.c0.g0.q.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f2050d) == null) {
            return;
        }
        cVar.d();
    }

    public void B() {
        c.a.c0.g0.q.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f2050d) == null) {
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
            c.a.c0.g0.s.b bVar = this.f2049c;
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a.getWebRootView() == null || this.f2054h == null || (viewTreeObserver = this.a.getWebRootView().getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.f2054h);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.getWebRootView() == null || this.f2055i == null) {
            return;
        }
        this.a.getWebRootView().removeOnLayoutChangeListener(this.f2055i);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f2050d = null;
            c.a.c0.g0.k.a aVar = this.f2052f;
            if (aVar != null) {
                aVar.d();
                this.f2052f = null;
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
            c.a.c0.g0.s.b bVar = this.f2049c;
            if (bVar == null) {
                return null;
            }
            return bVar.f2038g;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.c0.g0.s.b bVar = this.f2049c;
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
            this.f2049c = c.a.c0.g0.s.b.b(intent);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.f2052f == null) {
                this.f2052f = new c.a.c0.g0.k.a();
            }
            c.a.c0.g0.s.b bVar = this.f2049c;
            if (bVar != null) {
                this.f2052f.b(bVar.f2040i);
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
        if (this.f2049c != null) {
            JSONObject jSONObject = new JSONObject();
            c.a.c0.u.b.d(jSONObject, LegoListActivityConfig.AD_ID, this.f2049c.f2034c);
            c.a.c0.u.b.d(jSONObject, "lp_url", this.f2049c.a);
            c.a.c0.u.b.d(jSONObject, "log_ext", this.f2049c.f2037f);
            c.a.c0.u.b.d(jSONObject, Constant.KEY_BUSINESS, "native_ads");
            b.C0069b c0069b = this.f2049c.f2041j;
            if (c0069b != null) {
                c.a.c0.u.b.d(jSONObject, "key", c0069b.f2047e);
                c.a.c0.u.b.d(jSONObject, "url", this.f2049c.f2041j.a);
                c.a.c0.u.b.d(jSONObject, "close_v_dl", this.f2049c.f2041j.f2044b);
                c.a.c0.u.b.d(jSONObject, "app_icon", this.f2049c.f2041j.f2046d);
                c.a.c0.u.b.d(jSONObject, "app_name", this.f2049c.f2041j.f2045c);
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
            bVar.a(this.f2051e);
            bVar.b(new b(this, webView));
            this.a.addJavascriptInterface(bVar, "NadJsControl");
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.a.getWebRootView() == null) {
            return;
        }
        if (this.f2054h == null) {
            this.f2054h = new c.a.c0.g0.v.b(this.a.getWebRootView());
        }
        ViewTreeObserver viewTreeObserver = this.a.getWebRootView().getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.f2054h);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f2055i = new c(this);
            if (this.a.getWebRootView() != null) {
                this.a.getWebRootView().addOnLayoutChangeListener(this.f2055i);
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
        this.f2050d = new c.a.c0.g0.q.c();
    }

    public void t(Context context, ViewGroup viewGroup, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, context, viewGroup, webView) == null) {
            this.f2048b = webView;
            o();
            if (c.a.c0.g0.p.b.h()) {
                f();
                g();
            } else if (this.f2053g) {
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
            c.a.c0.g0.s.b bVar = this.f2049c;
            if (bVar != null && TextUtils.equals(bVar.f2039h, "1") && (cVar = this.f2050d) != null) {
                String a = this.f2051e.a();
                c.a.c0.g0.s.b bVar2 = this.f2049c;
                cVar.a(a, bVar2.f2037f, bVar2.a, this.a.getFrom(), 0L);
            }
            c.a.c0.g0.q.c cVar2 = this.f2050d;
            if (cVar2 != null) {
                cVar2.b();
            }
            c.a.c0.g0.p.b.b().release();
            h();
            f();
            g();
            if (this.f2055i != null) {
                this.a.getWebRootView().removeOnLayoutChangeListener(this.f2055i);
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
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (cVar = this.f2050d) == null) {
            return;
        }
        cVar.c();
    }

    public void z(String str) {
        c.a.c0.g0.s.b bVar;
        b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || (bVar = this.f2049c) == null || (cVar = bVar.f2033b) == null || TextUtils.isEmpty(cVar.a)) {
            return;
        }
        this.a.loadJavaScript(this.f2049c.f2033b.a);
    }
}
