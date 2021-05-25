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
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.a.p.e.f;
import d.a.l0.a.w2.c;
import d.a.l0.f.d;
/* loaded from: classes3.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements f<NgWebView>, c {
    public static final boolean F = k.f43199a;
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
            GameWebViewManager.this.j1();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            if (i2 == -10) {
                return;
            }
            GameWebViewManager.this.C.setVisibility(0);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (GameWebViewManager.F) {
                Log.d("SwanGameWebViewManager", "shouldOverrideUrlLoading url: " + str);
            }
            boolean z = !d.a.l0.a.b2.a.b.h(str);
            if (!z && (d.a.l0.a.b2.a.b.e(str) || d.a.l0.a.b2.a.b.f(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e Q = e.Q();
                    if (Q != null) {
                        Q.x().startActivity(intent);
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
            if (SwanAppNetworkUtils.i(GameWebViewManager.this.f10703e) && d.a.l0.a.b2.a.b.h(GameWebViewManager.this.u().getUrl())) {
                GameWebViewManager.this.u().reload();
                GameWebViewManager.this.C.setVisibility(8);
            }
        }
    }

    public GameWebViewManager(Context context) {
        super(context);
        n1();
        i1();
        Y0(new GameWebViewClient(this, null));
        q1(context);
    }

    @Override // d.a.l0.a.p.e.f
    public void J() {
        d.a.l0.h.o0.b.a(this.A, d.a.l0.a.l1.e.a.a.b());
        d.a.l0.h.o0.b.c(this);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void M0() {
        u().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void P0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Q0(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public String b() {
        return "SwanGameWebView";
    }

    @Override // d.a.l0.a.p.e.f
    public boolean d() {
        return this.A.getParent() != null;
    }

    @Override // d.a.l0.a.w2.c
    public void f() {
        o1();
        u().onPause();
    }

    @Override // d.a.l0.a.p.e.f
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

    public final void i1() {
        Z0(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.F) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !d.a.l0.a.b2.a.b.h(str);
            }
        });
    }

    @Override // d.a.l0.a.p.e.f
    public void j(View.OnClickListener onClickListener) {
        this.B = onClickListener;
    }

    public final void j1() {
        if (this.D.getVisibility() == 0) {
            this.D.clearAnimation();
            this.D.setVisibility(8);
        }
    }

    @Override // d.a.l0.a.w2.c
    public void k() {
        destroy();
    }

    public final void k1() {
        if (this.E != null) {
            return;
        }
        this.E = new ImageView(this.f10703e.getBaseContext());
        Resources resources = this.f10703e.getResources();
        int dimension = (int) resources.getDimension(d.a.l0.f.c.swangame_webview_button_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.topMargin = (int) resources.getDimension(d.a.l0.f.c.swangame_webview_button_top_margin);
        layoutParams.leftMargin = (int) resources.getDimension(d.a.l0.f.c.swangame_webview_button_left_margin);
        this.E.setLayoutParams(layoutParams);
        this.E.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.E.setImageResource(d.swangame_webview_close_button);
        this.E.setClickable(true);
        this.E.setOnClickListener(new a());
        this.A.addView(this.E);
    }

    public final void l1() {
        NetworkErrorView networkErrorView = new NetworkErrorView(this.f10703e.getBaseContext());
        this.C = networkErrorView;
        networkErrorView.setBackgroundColor(this.f10703e.getResources().getColor(d.a.l0.f.b.aiapps_game_white));
        u().addView(this.C, -1, -1);
        this.C.setVisibility(8);
        b bVar = new b();
        this.C.setOnClickListener(bVar);
        this.C.setReloadClickListener(bVar);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public void loadUrl(String str) {
        if (F) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (d.a.l0.a.b2.a.b.h(str)) {
            p1();
            super.loadUrl(str);
        }
    }

    public final void m1() {
        this.D = new ImageView(this.f10703e.getBaseContext());
        int dimension = (int) this.f10703e.getResources().getDimension(d.a.l0.f.c.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.D.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.D.setImageResource(d.swangame_webview_loading);
        this.A.addView(this.D, layoutParams);
    }

    @Override // d.a.l0.a.w2.c
    public void n() {
        u().onResume();
    }

    public final void n1() {
        FrameLayout frameLayout = new FrameLayout(this.f10703e.getBaseContext());
        this.A = frameLayout;
        frameLayout.addView(u(), -1, -1);
        k1();
        l1();
        m1();
    }

    public final void o1() {
        R0("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    public final void p1() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f10703e, d.a.l0.f.a.swangame_webview_loading);
        this.D.setVisibility(0);
        this.D.startAnimation(loadAnimation);
    }

    public final void q1(Context context) {
        d.a.l0.a.p.d.b a2 = d.a.l0.a.a2.d.g().y().a().a();
        if (a2 != null) {
            a2.a(context);
        }
    }

    @Override // d.a.l0.a.p.e.f
    public void removeFromParent() {
        u().stopLoading();
        u().clearView();
        d.a.l0.h.o0.b.d(this.A);
        d.a.l0.h.o0.b.e(this);
    }
}
