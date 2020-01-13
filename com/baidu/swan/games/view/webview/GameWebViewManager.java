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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.g;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements g<NgWebView>, com.baidu.swan.games.view.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private NetworkErrorView bnT;
    private FrameLayout cra;
    private View.OnClickListener crb;
    private ImageView crd;
    private ImageView cre;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        apc();
        a(new GameWebViewClient());
        dd(context);
    }

    private void dd(Context context) {
        com.baidu.swan.apps.adaptation.a.b FC = d.aam().aao().EE().FC();
        if (FC != null) {
            FC.bk(context);
        }
    }

    private void initView() {
        this.cra = new FrameLayout(this.mContext);
        this.cra.addView(Gy(), -1, -1);
        aoZ();
        apa();
        apb();
    }

    private void aoZ() {
        if (this.cre == null) {
            this.cre = new ImageView(this.mContext);
            Resources resources = this.mContext.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.cre.setLayoutParams(layoutParams);
            this.cre.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.cre.setImageResource(a.e.swangame_webview_close_button);
            this.cre.setClickable(true);
            this.cre.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.crb != null) {
                        GameWebViewManager.this.crb.onClick(view);
                    }
                }
            });
            this.cra.addView(this.cre);
        }
    }

    private void apa() {
        this.bnT = new NetworkErrorView(this.mContext);
        this.bnT.setBackgroundColor(this.mContext.getResources().getColor(a.c.aiapps_white));
        Gy().addView(this.bnT, -1, -1);
        this.bnT.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.mContext) && com.baidu.swan.apps.aj.a.b.kS(GameWebViewManager.this.Gy().getUrl())) {
                    GameWebViewManager.this.Gy().reload();
                    GameWebViewManager.this.bnT.setVisibility(8);
                }
            }
        };
        this.bnT.setOnClickListener(onClickListener);
        this.bnT.setReloadClickListener(onClickListener);
    }

    private void apb() {
        this.crd = new ImageView(this.mContext);
        int dimension = (int) this.mContext.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.crd.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.crd.setImageResource(a.e.swangame_webview_loading);
        this.cra.addView(this.crd, layoutParams);
    }

    private void apc() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.aj.a.b.kS(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Ky() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(Context context, SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Kx() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Kz() {
        Gy().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.aj.a.b.kS(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String GA() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aiy() {
        Gy().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aiz() {
        apd();
        Gy().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void d(View.OnClickListener onClickListener) {
        this.crb = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void GD() {
        com.baidu.swan.games.view.c.c(this.cra, com.baidu.swan.apps.model.a.a.a.Wg());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean Gq() {
        return this.cra.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void GE() {
        Gy().stopLoading();
        Gy().clearView();
        com.baidu.swan.games.view.c.au(this.cra);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void bP(boolean z) {
        if (this.cre != null) {
            if (z) {
                this.cre.setVisibility(0);
            } else {
                this.cre.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0187a.swangame_webview_loading);
        this.crd.setVisibility(0);
        this.crd.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.crd.getVisibility() == 0) {
            this.crd.clearAnimation();
            this.crd.setVisibility(8);
        }
    }

    private void apd() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes10.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.bnT.setVisibility(0);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            GameWebViewManager.this.hideLoadingView();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (GameWebViewManager.DEBUG) {
                Log.d("SwanGameWebViewManager", "shouldOverrideUrlLoading url: " + str);
            }
            boolean z = !com.baidu.swan.apps.aj.a.b.kS(str);
            if (!z && (com.baidu.swan.apps.aj.a.b.kW(str) || com.baidu.swan.apps.aj.a.b.kX(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e aaq = e.aaq();
                    if (aaq != null) {
                        aaq.aal().startActivity(intent);
                        return true;
                    }
                } catch (Exception e) {
                    if (GameWebViewManager.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            return z;
        }
    }
}
