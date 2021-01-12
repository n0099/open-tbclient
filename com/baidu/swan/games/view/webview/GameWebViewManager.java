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
/* loaded from: classes8.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements g<NgWebView>, com.baidu.swan.games.view.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private FrameLayout bzk;
    private NetworkErrorView cVh;
    private View.OnClickListener emd;
    private ImageView eme;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        aZX();
        a(new GameWebViewClient());
        el(context);
    }

    private void el(Context context) {
        com.baidu.swan.apps.adaptation.a.b ahO = d.aIn().aIp().afU().ahO();
        if (ahO != null) {
            ahO.bX(context);
        }
    }

    private void initView() {
        this.bzk = new FrameLayout(this.cND.getBaseContext());
        this.bzk.addView(aiy(), -1, -1);
        aZU();
        aZV();
        aZW();
    }

    private void aZU() {
        if (this.eme == null) {
            this.eme = new ImageView(this.cND.getBaseContext());
            Resources resources = this.cND.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.eme.setLayoutParams(layoutParams);
            this.eme.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.eme.setImageResource(a.e.swangame_webview_close_button);
            this.eme.setClickable(true);
            this.eme.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.emd != null) {
                        GameWebViewManager.this.emd.onClick(view);
                    }
                }
            });
            this.bzk.addView(this.eme);
        }
    }

    private void aZV() {
        this.cVh = new NetworkErrorView(this.cND.getBaseContext());
        this.cVh.setBackgroundColor(this.cND.getResources().getColor(a.c.aiapps_white));
        aiy().addView(this.cVh, -1, -1);
        this.cVh.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.cND) && com.baidu.swan.apps.af.a.b.rE(GameWebViewManager.this.aiy().getUrl())) {
                    GameWebViewManager.this.aiy().reload();
                    GameWebViewManager.this.cVh.setVisibility(8);
                }
            }
        };
        this.cVh.setOnClickListener(onClickListener);
        this.cVh.setReloadClickListener(onClickListener);
    }

    private void aZW() {
        this.mLoadingView = new ImageView(this.cND.getBaseContext());
        int dimension = (int) this.cND.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.bzk.addView(this.mLoadingView, layoutParams);
    }

    private void aZX() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.af.a.b.rE(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void amW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void amV() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void amX() {
        aiy().addJavascriptInterface(new GameWebViewJavascriptInterface(), GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.af.a.b.rE(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiA() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aSJ() {
        aiy().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aSK() {
        aZY();
        aiy().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void aSL() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.emd = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void aiF() {
        com.baidu.swan.games.view.c.c(this.bzk, com.baidu.swan.apps.model.a.a.a.aCf());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean aip() {
        return this.bzk.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void aiG() {
        aiy().stopLoading();
        aiy().clearView();
        com.baidu.swan.games.view.c.removeView(this.bzk);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void eL(boolean z) {
        if (this.eme != null) {
            if (z) {
                this.eme.setVisibility(0);
            } else {
                this.eme.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.cND, a.C0355a.swangame_webview_loading);
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

    private void aZY() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes8.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cVh.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.af.a.b.rE(str);
            if (!z && (com.baidu.swan.apps.af.a.b.rI(str) || com.baidu.swan.apps.af.a.b.rJ(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e aIs = e.aIs();
                    if (aIs != null) {
                        aIs.aIl().startActivity(intent);
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
