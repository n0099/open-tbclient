package com.baidu.swan.games.view.webview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
import d.b.g0.a.c;
import d.b.g0.a.d;
import d.b.g0.a.k;
import d.b.g0.a.p.d.f;
import d.b.g0.a.r1.e;
/* loaded from: classes3.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements f<NgWebView>, d.b.g0.g.k0.a {
    public static final boolean F = k.f45443a;
    public FrameLayout A;
    public View.OnClickListener B;
    public NetworkErrorView C;
    public ImageView D;
    public ImageView E;

    /* loaded from: classes3.dex */
    public class GameWebViewClient extends BdSailorWebViewClient {
        public GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            GameWebViewManager.this.d1();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i == -10) {
                return;
            }
            GameWebViewManager.this.C.setVisibility(0);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (GameWebViewManager.F) {
                Log.d("SwanGameWebViewManager", "shouldOverrideUrlLoading url: " + str);
            }
            boolean z = !d.b.g0.a.s1.a.b.h(str);
            if (!z && (d.b.g0.a.s1.a.b.e(str) || d.b.g0.a.s1.a.b.f(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e O = e.O();
                    if (O != null) {
                        O.n().startActivity(intent);
                        return true;
                    }
                } catch (Exception e2) {
                    if (GameWebViewManager.F) {
                        e2.printStackTrace();
                    }
                }
            }
            return z;
        }

        public /* synthetic */ GameWebViewClient(GameWebViewManager gameWebViewManager, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameWebViewManager.this.B != null) {
                GameWebViewManager.this.B.onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanAppNetworkUtils.h(GameWebViewManager.this.f11814e) && d.b.g0.a.s1.a.b.h(GameWebViewManager.this.F().getUrl())) {
                GameWebViewManager.this.F().reload();
                GameWebViewManager.this.C.setVisibility(8);
            }
        }
    }

    public GameWebViewManager(Context context) {
        super(context);
        h1();
        c1();
        S0(new GameWebViewClient(this, null));
        k1(context);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void F0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void G0() {
        F().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void J0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void K0(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // d.b.g0.a.p.d.f
    public boolean a() {
        return this.A.getParent() != null;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public String c() {
        return "SwanGameWebView";
    }

    public final void c1() {
        T0(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.F) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !d.b.g0.a.s1.a.b.h(str);
            }
        });
    }

    public final void d1() {
        if (this.D.getVisibility() == 0) {
            this.D.clearAnimation();
            this.D.setVisibility(8);
        }
    }

    public final void e1() {
        if (this.E != null) {
            return;
        }
        this.E = new ImageView(this.f11814e.getBaseContext());
        Resources resources = this.f11814e.getResources();
        int dimension = (int) resources.getDimension(d.swangame_webview_button_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.topMargin = (int) resources.getDimension(d.swangame_webview_button_top_margin);
        layoutParams.leftMargin = (int) resources.getDimension(d.swangame_webview_button_left_margin);
        this.E.setLayoutParams(layoutParams);
        this.E.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.E.setImageResource(d.b.g0.a.e.swangame_webview_close_button);
        this.E.setClickable(true);
        this.E.setOnClickListener(new a());
        this.A.addView(this.E);
    }

    @Override // d.b.g0.g.k0.a
    public void f() {
        i1();
        F().onPause();
    }

    public final void f1() {
        NetworkErrorView networkErrorView = new NetworkErrorView(this.f11814e.getBaseContext());
        this.C = networkErrorView;
        networkErrorView.setBackgroundColor(this.f11814e.getResources().getColor(c.aiapps_white));
        F().addView(this.C, -1, -1);
        this.C.setVisibility(8);
        b bVar = new b();
        this.C.setOnClickListener(bVar);
        this.C.setReloadClickListener(bVar);
    }

    public final void g1() {
        this.D = new ImageView(this.f11814e.getBaseContext());
        int dimension = (int) this.f11814e.getResources().getDimension(d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.D.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.D.setImageResource(d.b.g0.a.e.swangame_webview_loading);
        this.A.addView(this.D, layoutParams);
    }

    @Override // d.b.g0.a.p.d.f
    public void h(boolean z) {
        ImageView imageView = this.E;
        if (imageView != null) {
            if (z) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public final void h1() {
        FrameLayout frameLayout = new FrameLayout(this.f11814e.getBaseContext());
        this.A = frameLayout;
        frameLayout.addView(F(), -1, -1);
        e1();
        f1();
        g1();
    }

    @Override // d.b.g0.a.p.d.f
    public void i(View.OnClickListener onClickListener) {
        this.B = onClickListener;
    }

    public final void i1() {
        L0("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    public final void j1() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11814e, d.b.g0.a.a.swangame_webview_loading);
        this.D.setVisibility(0);
        this.D.startAnimation(loadAnimation);
    }

    @Override // d.b.g0.g.k0.a
    public void k() {
        destroy();
    }

    public final void k1(Context context) {
        d.b.g0.a.p.c.b b2 = d.b.g0.a.r1.d.e().o().a().b();
        if (b2 != null) {
            b2.a(context);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void loadUrl(String str) {
        if (F) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (d.b.g0.a.s1.a.b.h(str)) {
            j1();
            super.loadUrl(str);
        }
    }

    @Override // d.b.g0.g.k0.a
    public void q() {
        F().onResume();
    }

    @Override // d.b.g0.a.p.d.f
    public void r() {
        d.b.g0.g.k0.c.a(this.A, d.b.g0.a.e1.d.a.a.b());
        d.b.g0.g.k0.c.c(this);
    }

    @Override // d.b.g0.a.p.d.f
    public void removeFromParent() {
        F().stopLoading();
        F().clearView();
        d.b.g0.g.k0.c.d(this.A);
        d.b.g0.g.k0.c.e(this);
    }
}
