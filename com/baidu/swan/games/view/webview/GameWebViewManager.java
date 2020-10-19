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
    private NetworkErrorView cBz;
    private FrameLayout dOh;
    private View.OnClickListener dOi;
    private ImageView dOj;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        aUG();
        a(new GameWebViewClient());
        dn(context);
    }

    private void dn(Context context) {
        com.baidu.swan.apps.adaptation.a.b adD = d.aCW().aCY().abL().adD();
        if (adD != null) {
            adD.bl(context);
        }
    }

    private void initView() {
        this.dOh = new FrameLayout(this.ctT.getBaseContext());
        this.dOh.addView(aen(), -1, -1);
        aUD();
        aUE();
        aUF();
    }

    private void aUD() {
        if (this.dOj == null) {
            this.dOj = new ImageView(this.ctT.getBaseContext());
            Resources resources = this.ctT.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.dOj.setLayoutParams(layoutParams);
            this.dOj.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.dOj.setImageResource(a.e.swangame_webview_close_button);
            this.dOj.setClickable(true);
            this.dOj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.dOi != null) {
                        GameWebViewManager.this.dOi.onClick(view);
                    }
                }
            });
            this.dOh.addView(this.dOj);
        }
    }

    private void aUE() {
        this.cBz = new NetworkErrorView(this.ctT.getBaseContext());
        this.cBz.setBackgroundColor(this.ctT.getResources().getColor(a.c.aiapps_white));
        aen().addView(this.cBz, -1, -1);
        this.cBz.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.ctT) && com.baidu.swan.apps.ag.a.b.rJ(GameWebViewManager.this.aen().getUrl())) {
                    GameWebViewManager.this.aen().reload();
                    GameWebViewManager.this.cBz.setVisibility(8);
                }
            }
        };
        this.cBz.setOnClickListener(onClickListener);
        this.cBz.setReloadClickListener(onClickListener);
    }

    private void aUF() {
        this.mLoadingView = new ImageView(this.ctT.getBaseContext());
        int dimension = (int) this.ctT.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.dOh.addView(this.mLoadingView, layoutParams);
    }

    private void aUG() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.ag.a.b.rJ(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aiK() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aiJ() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aiL() {
        aen().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.ag.a.b.rJ(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aep() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aNr() {
        aen().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aNs() {
        aUH();
        aen().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void d(View.OnClickListener onClickListener) {
        this.dOi = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void aeu() {
        com.baidu.swan.games.view.c.c(this.dOh, com.baidu.swan.apps.model.a.a.a.axK());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean aee() {
        return this.dOh.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void aev() {
        aen().stopLoading();
        aen().clearView();
        com.baidu.swan.games.view.c.removeView(this.dOh);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void dS(boolean z) {
        if (this.dOj != null) {
            if (z) {
                this.dOj.setVisibility(0);
            } else {
                this.dOj.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ctT, a.C0343a.swangame_webview_loading);
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.mLoadingView.getVisibility() == 0) {
            this.mLoadingView.clearAnimation();
            this.mLoadingView.setVisibility(8);
        }
    }

    private void aUH() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes10.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cBz.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.ag.a.b.rJ(str);
            if (!z && (com.baidu.swan.apps.ag.a.b.rN(str) || com.baidu.swan.apps.ag.a.b.rO(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e aDb = e.aDb();
                    if (aDb != null) {
                        aDb.aCU().startActivity(intent);
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
