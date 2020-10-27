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
    private NetworkErrorView cJV;
    private FrameLayout dWE;
    private View.OnClickListener dWF;
    private ImageView dWG;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        aWA();
        a(new GameWebViewClient());
        dn(context);
    }

    private void dn(Context context) {
        com.baidu.swan.apps.adaptation.a.b afx = d.aEQ().aES().adF().afx();
        if (afx != null) {
            afx.bl(context);
        }
    }

    private void initView() {
        this.dWE = new FrameLayout(this.cCr.getBaseContext());
        this.dWE.addView(agh(), -1, -1);
        aWx();
        aWy();
        aWz();
    }

    private void aWx() {
        if (this.dWG == null) {
            this.dWG = new ImageView(this.cCr.getBaseContext());
            Resources resources = this.cCr.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.dWG.setLayoutParams(layoutParams);
            this.dWG.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.dWG.setImageResource(a.e.swangame_webview_close_button);
            this.dWG.setClickable(true);
            this.dWG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.dWF != null) {
                        GameWebViewManager.this.dWF.onClick(view);
                    }
                }
            });
            this.dWE.addView(this.dWG);
        }
    }

    private void aWy() {
        this.cJV = new NetworkErrorView(this.cCr.getBaseContext());
        this.cJV.setBackgroundColor(this.cCr.getResources().getColor(a.c.aiapps_white));
        agh().addView(this.cJV, -1, -1);
        this.cJV.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.cCr) && com.baidu.swan.apps.ag.a.b.sc(GameWebViewManager.this.agh().getUrl())) {
                    GameWebViewManager.this.agh().reload();
                    GameWebViewManager.this.cJV.setVisibility(8);
                }
            }
        };
        this.cJV.setOnClickListener(onClickListener);
        this.cJV.setReloadClickListener(onClickListener);
    }

    private void aWz() {
        this.mLoadingView = new ImageView(this.cCr.getBaseContext());
        int dimension = (int) this.cCr.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.dWE.addView(this.mLoadingView, layoutParams);
    }

    private void aWA() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.ag.a.b.sc(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void akE() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void akD() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void akF() {
        agh().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.ag.a.b.sc(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String agj() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aPl() {
        agh().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aPm() {
        aWB();
        agh().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void d(View.OnClickListener onClickListener) {
        this.dWF = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void ago() {
        com.baidu.swan.games.view.c.c(this.dWE, com.baidu.swan.apps.model.a.a.a.azE());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean afY() {
        return this.dWE.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void agp() {
        agh().stopLoading();
        agh().clearView();
        com.baidu.swan.games.view.c.removeView(this.dWE);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void ef(boolean z) {
        if (this.dWG != null) {
            if (z) {
                this.dWG.setVisibility(0);
            } else {
                this.dWG.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.cCr, a.C0357a.swangame_webview_loading);
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

    private void aWB() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes10.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cJV.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.ag.a.b.sc(str);
            if (!z && (com.baidu.swan.apps.ag.a.b.sg(str) || com.baidu.swan.apps.ag.a.b.sh(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e aEV = e.aEV();
                    if (aEV != null) {
                        aEV.aEO().startActivity(intent);
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
