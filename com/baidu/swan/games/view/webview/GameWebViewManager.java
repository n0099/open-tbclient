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
    public static final boolean F = k.f45050a;
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
            GameWebViewManager.this.c1();
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
            if (SwanAppNetworkUtils.h(GameWebViewManager.this.f12152e) && d.b.g0.a.s1.a.b.h(GameWebViewManager.this.getWebView().getUrl())) {
                GameWebViewManager.this.getWebView().reload();
                GameWebViewManager.this.C.setVisibility(8);
            }
        }
    }

    public GameWebViewManager(Context context) {
        super(context);
        g1();
        b1();
        R0(new GameWebViewClient(this, null));
        j1(context);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void E0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void F0() {
        getWebView().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void I0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void J0(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // d.b.g0.a.p.d.f
    public boolean a() {
        return this.A.getParent() != null;
    }

    public final void b1() {
        S0(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.F) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !d.b.g0.a.s1.a.b.h(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public String c() {
        return "SwanGameWebView";
    }

    public final void c1() {
        if (this.D.getVisibility() == 0) {
            this.D.clearAnimation();
            this.D.setVisibility(8);
        }
    }

    public final void d1() {
        if (this.E != null) {
            return;
        }
        this.E = new ImageView(this.f12152e.getBaseContext());
        Resources resources = this.f12152e.getResources();
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

    public final void e1() {
        NetworkErrorView networkErrorView = new NetworkErrorView(this.f12152e.getBaseContext());
        this.C = networkErrorView;
        networkErrorView.setBackgroundColor(this.f12152e.getResources().getColor(c.aiapps_white));
        getWebView().addView(this.C, -1, -1);
        this.C.setVisibility(8);
        b bVar = new b();
        this.C.setOnClickListener(bVar);
        this.C.setReloadClickListener(bVar);
    }

    @Override // d.b.g0.g.k0.a
    public void f() {
        h1();
        getWebView().onPause();
    }

    public final void f1() {
        this.D = new ImageView(this.f12152e.getBaseContext());
        int dimension = (int) this.f12152e.getResources().getDimension(d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.D.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.D.setImageResource(d.b.g0.a.e.swangame_webview_loading);
        this.A.addView(this.D, layoutParams);
    }

    public final void g1() {
        FrameLayout frameLayout = new FrameLayout(this.f12152e.getBaseContext());
        this.A = frameLayout;
        frameLayout.addView(getWebView(), -1, -1);
        d1();
        e1();
        f1();
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
        K0("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    @Override // d.b.g0.a.p.d.f
    public void i(View.OnClickListener onClickListener) {
        this.B = onClickListener;
    }

    public final void i1() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f12152e, d.b.g0.a.a.swangame_webview_loading);
        this.D.setVisibility(0);
        this.D.startAnimation(loadAnimation);
    }

    public final void j1(Context context) {
        d.b.g0.a.p.c.b b2 = d.b.g0.a.r1.d.e().o().a().b();
        if (b2 != null) {
            b2.a(context);
        }
    }

    @Override // d.b.g0.g.k0.a
    public void k() {
        destroy();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void loadUrl(String str) {
        if (F) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (d.b.g0.a.s1.a.b.h(str)) {
            i1();
            super.loadUrl(str);
        }
    }

    @Override // d.b.g0.g.k0.a
    public void q() {
        getWebView().onResume();
    }

    @Override // d.b.g0.a.p.d.f
    public void r() {
        d.b.g0.g.k0.c.a(this.A, d.b.g0.a.e1.d.a.a.b());
        d.b.g0.g.k0.c.c(this);
    }

    @Override // d.b.g0.a.p.d.f
    public void removeFromParent() {
        getWebView().stopLoading();
        getWebView().clearView();
        d.b.g0.g.k0.c.d(this.A);
        d.b.g0.g.k0.c.e(this);
    }
}
