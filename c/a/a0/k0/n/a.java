package c.a.a0.k0.n;

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
import c.a.a0.j0.a;
import c.a.a0.k0.j.b;
import c.a.a0.k0.l.b;
import c.a.a0.k0.m.a.a;
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
    public WebView f1346b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.a0.k0.l.b f1347c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.a0.k0.j.c f1348d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.a0.k0.j.a f1349e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.a0.k0.d.a f1350f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1351g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f1352h;
    public View.OnLayoutChangeListener i;
    public boolean j;
    public final Object k;
    public long l;
    public int m;
    public final c.a.a0.k0.o.a n;

    /* renamed from: c.a.a0.k0.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0048a implements c.a.a0.k0.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0048a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.a0.k0.o.a
        public void loadUrl(String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) || this.a.f1346b == null) {
                return;
            }
            this.a.f1346b.loadUrl(str, map);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.a0.j0.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.a.X(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1353b;

        public c(a aVar, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1353b = aVar;
            this.a = webView;
        }

        @Override // c.a.a0.k0.j.b.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Rect rect = new Rect();
                this.a.getWindowVisibleDisplayFrame(rect);
                int i = this.f1353b.a.getResources().getDisplayMetrics().heightPixels - rect.bottom;
                if (i < 0) {
                    i = 0;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visibleHeight", this.a.getHeight() - i);
                    jSONObject.put("keyboardHeight", i);
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
    public class d implements a.InterfaceC0047a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1354b;

        /* renamed from: c.a.a0.k0.n.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0049a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public RunnableC0049a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.f1354b.f1346b.canGoBack()) {
                        this.a.f1354b.f1346b.goBack();
                    } else {
                        this.a.a.finish();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1354b = aVar;
            this.a = activity;
        }

        @Override // c.a.a0.k0.m.a.a.InterfaceC0047a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1354b.f1346b.post(new RunnableC0049a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1355b;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1355b = aVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int i9 = rect.bottom;
                int i10 = this.a;
                if (i9 != i10 && i10 != 0) {
                    LinearLayout G = this.f1355b.a.G();
                    int i11 = this.a - rect.bottom;
                    if (i11 > 200) {
                        this.f1355b.j = true;
                        if (i3 == i7) {
                            G.setPadding(G.getPaddingLeft(), G.getPaddingTop(), G.getPaddingRight(), i11);
                            c.a.a0.k0.h.a.b(this.f1355b.n, G.getHeight() - i11, i11, G.getHeight(), 0);
                            a aVar = this.f1355b;
                            aVar.E(aVar.f1346b, -1, -1);
                        }
                    } else {
                        if (i3 == i7 && this.f1355b.j) {
                            G.setPadding(G.getPaddingLeft(), G.getPaddingTop(), G.getPaddingRight(), 0);
                            c.a.a0.k0.h.a.b(this.f1355b.n, G.getHeight(), 0, G.getHeight(), 0);
                            a aVar2 = this.f1355b;
                            aVar2.E(aVar2.f1346b, -1, -1);
                        }
                        this.f1355b.j = false;
                    }
                    this.a = rect.bottom;
                    return;
                }
                this.a = rect.bottom;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1349e = new c.a.a0.k0.j.a();
        this.f1351g = true;
        this.f1352h = null;
        this.k = new Object();
        this.l = 0L;
        this.n = new C0048a(this);
        this.a = baseNativeBrowserContainer;
    }

    public void A(String str) {
        c.a.a0.k0.l.b bVar;
        b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f1347c) == null || (cVar = bVar.f1333b) == null || TextUtils.isEmpty(cVar.a)) {
            return;
        }
        this.a.X(this.f1347c.f1333b.a);
    }

    public void B() {
        c.a.a0.k0.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f1348d) == null) {
            return;
        }
        cVar.e();
    }

    public void C() {
        c.a.a0.k0.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.f1348d) == null) {
            return;
        }
        cVar.f();
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void E(@NonNull View view, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, view, i, i2) == null) {
            if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                view.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
            } else if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                view.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
            } else if (view.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                view.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
            } else if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                view.setLayoutParams(new ViewGroup.MarginLayoutParams(i, i2));
            } else if (view.getLayoutParams() instanceof ViewGroup.LayoutParams) {
                view.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            }
        }
    }

    public boolean F(@NonNull WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, str2)) == null) {
            G(webView, str2);
            c.a.a0.k0.l.b bVar = this.f1347c;
            if (bVar == null || !bVar.a()) {
                return true;
            }
            return !c.a.a0.g.h.b.a(webView.getContext(), str2);
        }
        return invokeLLL.booleanValue;
    }

    public final void G(@NonNull WebView webView, String str) {
        c.a.a0.k0.l.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, webView, str) == null) || TextUtils.isEmpty(str) || !str.startsWith("tel:") || webView.getContext() == null || (bVar = this.f1347c) == null || TextUtils.isEmpty(bVar.f1337f)) {
            return;
        }
        new c.a.a0.l0.v.a().m(webView.getContext(), this.f1347c.f1337f, InputType.TEL);
    }

    public final void f() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.a.G() == null || this.f1352h == null || (viewTreeObserver = this.a.G().getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.f1352h);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.G() == null || this.i == null) {
            return;
        }
        this.a.G().removeOnLayoutChangeListener(this.i);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f1348d = null;
            c.a.a0.k0.d.a aVar = this.f1350f;
            if (aVar != null) {
                aVar.d();
                this.f1350f = null;
            }
        }
    }

    @Nullable
    public final Intent i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.e() : (Intent) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c.a.a0.k0.l.b bVar = this.f1347c;
            if (bVar == null) {
                return null;
            }
            return bVar.f1338g;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.a0.k0.l.b bVar = this.f1347c;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.f1348d.g();
            if (i() != null) {
                String j = j();
                if (TextUtils.isEmpty(j)) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Referer", j);
                this.a.Z(hashMap);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            this.f1347c = c.a.a0.k0.l.b.b(intent);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.f1350f == null) {
                this.f1350f = new c.a.a0.k0.d.a();
            }
            c.a.a0.k0.l.b bVar = this.f1347c;
            if (bVar != null) {
                this.f1350f.b(bVar.i);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.a.E() == null) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.a.G().getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setVisibility(8);
        this.a.E().addView(relativeLayout, layoutParams);
        this.a.e0(relativeLayout);
        String str = null;
        if (this.f1347c != null) {
            JSONObject jSONObject = new JSONObject();
            c.a.a0.x.b.e(jSONObject, LegoListActivityConfig.AD_ID, this.f1347c.f1334c);
            c.a.a0.x.b.e(jSONObject, "lp_url", this.f1347c.a);
            c.a.a0.x.b.e(jSONObject, "log_ext", this.f1347c.f1337f);
            c.a.a0.x.b.e(jSONObject, Constant.KEY_BUSINESS, "native_ads");
            b.C0046b c0046b = this.f1347c.j;
            if (c0046b != null) {
                c.a.a0.x.b.e(jSONObject, "key", c0046b.f1345e);
                c.a.a0.x.b.e(jSONObject, "url", this.f1347c.j.a);
                c.a.a0.x.b.e(jSONObject, "close_v_dl", this.f1347c.j.f1342b);
                c.a.a0.x.b.e(jSONObject, "app_icon", this.f1347c.j.f1344d);
                c.a.a0.x.b.e(jSONObject, "app_name", this.f1347c.j.f1343c);
            }
            str = jSONObject.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.h0(str);
    }

    public void p(@NonNull Activity activity, @NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, activity, webView) == null) {
            c.a.a0.k0.j.b bVar = new c.a.a0.k0.j.b(0);
            bVar.a(this.f1349e);
            bVar.b(new c(this, webView));
            this.a.y(bVar, "NadJsControl");
            this.a.y(new c.a.a0.k0.m.a.a(new d(this, activity)), "go_back_js_interface_name");
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.a.G() == null) {
            return;
        }
        if (this.f1352h == null) {
            this.f1352h = new c.a.a0.k0.p.a(this.a.G());
        }
        ViewTreeObserver viewTreeObserver = this.a.G().getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.f1352h);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.i = new e(this);
            if (this.a.G() != null) {
                this.a.G().addOnLayoutChangeListener(this.i);
            }
        }
    }

    public final void s() {
        Intent i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (i = i()) == null) {
            return;
        }
        m(i);
        n();
        this.f1348d = new c.a.a0.k0.j.c();
        c.a.a0.k0.i.b.b().a(this.k, new b(this));
    }

    public void t(Context context, ViewGroup viewGroup, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, context, viewGroup, webView) == null) {
            this.f1346b = webView;
            o();
            if (c.a.a0.k0.i.b.h()) {
                f();
                g();
            } else if (this.f1351g) {
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            s();
        }
    }

    public void v() {
        c.a.a0.k0.j.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c.a.a0.k0.l.b bVar = this.f1347c;
            if (bVar != null && TextUtils.equals(bVar.f1339h, "1") && (cVar = this.f1348d) != null) {
                this.f1348d.b(this.f1349e.a(), cVar.a(this.f1347c.f1337f, this.l, this.m, false), this.f1347c.a, this.a.C(), 0L);
            }
            c.a.a0.k0.j.c cVar2 = this.f1348d;
            if (cVar2 != null) {
                cVar2.c();
            }
            c.a.a0.k0.i.b.b().release();
            h();
            f();
            g();
            if (this.i != null) {
                this.a.G().removeOnLayoutChangeListener(this.i);
            }
            c.a.a0.k.e.a().unregister(this.k);
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, str) == null) && this.l == 0) {
            this.l = System.currentTimeMillis();
        }
    }

    public void x(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, webView, str, bitmap) == null) {
        }
    }

    public void y() {
        c.a.a0.k0.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (cVar = this.f1348d) == null) {
            return;
        }
        cVar.d();
    }

    public void z(WebView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048603, this, webView, i, str, str2) == null) {
            if (!NetUtil.a(this.a.G().getContext())) {
                this.m = -1000;
            } else {
                this.m = i;
            }
        }
    }
}
