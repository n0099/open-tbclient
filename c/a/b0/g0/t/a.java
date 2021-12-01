package c.a.b0.g0.t;

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
import c.a.b0.g0.q.b;
import c.a.b0.g0.s.b;
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
    public WebView f1603b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.b0.g0.s.b f1604c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.b0.g0.q.c f1605d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.b0.g0.q.a f1606e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.b0.g0.k.a f1607f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1608g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f1609h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnLayoutChangeListener f1610i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1611j;

    /* renamed from: k  reason: collision with root package name */
    public final c.a.b0.g0.u.a f1612k;

    /* renamed from: c.a.b0.g0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0047a implements c.a.b0.g0.u.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0047a(a aVar) {
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

        @Override // c.a.b0.g0.u.a
        public void loadUrl(String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) || this.a.f1603b == null) {
                return;
            }
            this.a.f1603b.loadUrl(str, map);
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1613b;

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
            this.f1613b = aVar;
            this.a = webView;
        }

        @Override // c.a.b0.g0.q.b.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Rect rect = new Rect();
                this.a.getWindowVisibleDisplayFrame(rect);
                int i2 = this.f1613b.a.getResources().getDisplayMetrics().heightPixels - rect.bottom;
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
        public int f1614e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f1615f;

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
            this.f1615f = aVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int i10 = rect.bottom;
                int i11 = this.f1614e;
                if (i10 != i11 && i11 != 0) {
                    LinearLayout webRootView = this.f1615f.a.getWebRootView();
                    int i12 = this.f1614e - rect.bottom;
                    if (i12 > 200) {
                        this.f1615f.f1611j = true;
                        if (i4 == i8) {
                            webRootView.setPadding(webRootView.getPaddingLeft(), webRootView.getPaddingTop(), webRootView.getPaddingRight(), i12);
                            c.a.b0.g0.o.a.b(this.f1615f.f1612k, webRootView.getHeight() - i12, i12, webRootView.getHeight(), 0);
                            this.f1615f.f1603b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                        }
                    } else {
                        if (i4 == i8 && this.f1615f.f1611j) {
                            webRootView.setPadding(webRootView.getPaddingLeft(), webRootView.getPaddingTop(), webRootView.getPaddingRight(), 0);
                            c.a.b0.g0.o.a.b(this.f1615f.f1612k, webRootView.getHeight(), 0, webRootView.getHeight(), 0);
                            this.f1615f.f1603b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                        }
                        this.f1615f.f1611j = false;
                    }
                    this.f1614e = rect.bottom;
                    return;
                }
                this.f1614e = rect.bottom;
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
        this.f1606e = new c.a.b0.g0.q.a();
        this.f1608g = true;
        this.f1609h = null;
        this.f1612k = new C0047a(this);
        this.a = baseNativeBrowserContainer;
    }

    public void A() {
        c.a.b0.g0.q.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f1605d) == null) {
            return;
        }
        cVar.d();
    }

    public void B() {
        c.a.b0.g0.q.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f1605d) == null) {
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
            c.a.b0.g0.s.b bVar = this.f1604c;
            if (bVar == null || !bVar.a()) {
                return true;
            }
            return !c.a.b0.d.h.b.a(webView.getContext(), str2);
        }
        return invokeLLL.booleanValue;
    }

    public final void f() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a.getWebRootView() == null || this.f1609h == null || (viewTreeObserver = this.a.getWebRootView().getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.f1609h);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.getWebRootView() == null || this.f1610i == null) {
            return;
        }
        this.a.getWebRootView().removeOnLayoutChangeListener(this.f1610i);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f1605d = null;
            c.a.b0.g0.k.a aVar = this.f1607f;
            if (aVar != null) {
                aVar.d();
                this.f1607f = null;
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
            c.a.b0.g0.s.b bVar = this.f1604c;
            if (bVar == null) {
                return null;
            }
            return bVar.f1593g;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.b0.g0.s.b bVar = this.f1604c;
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
            this.f1604c = c.a.b0.g0.s.b.b(intent);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.f1607f == null) {
                this.f1607f = new c.a.b0.g0.k.a();
            }
            c.a.b0.g0.s.b bVar = this.f1604c;
            if (bVar != null) {
                this.f1607f.b(bVar.f1595i);
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
        if (this.f1604c != null) {
            JSONObject jSONObject = new JSONObject();
            c.a.b0.u.b.d(jSONObject, LegoListActivityConfig.AD_ID, this.f1604c.f1589c);
            c.a.b0.u.b.d(jSONObject, "lp_url", this.f1604c.a);
            c.a.b0.u.b.d(jSONObject, "log_ext", this.f1604c.f1592f);
            c.a.b0.u.b.d(jSONObject, Constant.KEY_BUSINESS, "native_ads");
            b.C0046b c0046b = this.f1604c.f1596j;
            if (c0046b != null) {
                c.a.b0.u.b.d(jSONObject, "key", c0046b.f1602e);
                c.a.b0.u.b.d(jSONObject, "url", this.f1604c.f1596j.a);
                c.a.b0.u.b.d(jSONObject, "close_v_dl", this.f1604c.f1596j.f1599b);
                c.a.b0.u.b.d(jSONObject, "app_icon", this.f1604c.f1596j.f1601d);
                c.a.b0.u.b.d(jSONObject, "app_name", this.f1604c.f1596j.f1600c);
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
            c.a.b0.g0.q.b bVar = new c.a.b0.g0.q.b(0);
            bVar.a(this.f1606e);
            bVar.b(new b(this, webView));
            this.a.addJavascriptInterface(bVar, "NadJsControl");
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.a.getWebRootView() == null) {
            return;
        }
        if (this.f1609h == null) {
            this.f1609h = new c.a.b0.g0.v.b(this.a.getWebRootView());
        }
        ViewTreeObserver viewTreeObserver = this.a.getWebRootView().getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.f1609h);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f1610i = new c(this);
            if (this.a.getWebRootView() != null) {
                this.a.getWebRootView().addOnLayoutChangeListener(this.f1610i);
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
        this.f1605d = new c.a.b0.g0.q.c();
    }

    public void t(Context context, ViewGroup viewGroup, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, context, viewGroup, webView) == null) {
            this.f1603b = webView;
            o();
            if (c.a.b0.g0.p.b.h()) {
                f();
                g();
            } else if (this.f1608g) {
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
        c.a.b0.g0.q.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.b0.g0.s.b bVar = this.f1604c;
            if (bVar != null && TextUtils.equals(bVar.f1594h, "1") && (cVar = this.f1605d) != null) {
                String a = this.f1606e.a();
                c.a.b0.g0.s.b bVar2 = this.f1604c;
                cVar.a(a, bVar2.f1592f, bVar2.a, this.a.getFrom(), 0L);
            }
            c.a.b0.g0.q.c cVar2 = this.f1605d;
            if (cVar2 != null) {
                cVar2.b();
            }
            c.a.b0.g0.p.b.b().release();
            h();
            f();
            g();
            if (this.f1610i != null) {
                this.a.getWebRootView().removeOnLayoutChangeListener(this.f1610i);
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
        c.a.b0.g0.q.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (cVar = this.f1605d) == null) {
            return;
        }
        cVar.c();
    }

    public void z(String str) {
        c.a.b0.g0.s.b bVar;
        b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || (bVar = this.f1604c) == null || (cVar = bVar.f1588b) == null || TextUtils.isEmpty(cVar.a)) {
            return;
        }
        this.a.loadJavaScript(this.f1604c.f1588b.a);
    }
}
