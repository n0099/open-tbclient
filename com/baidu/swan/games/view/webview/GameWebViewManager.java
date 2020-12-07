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
/* loaded from: classes25.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements g<NgWebView>, com.baidu.swan.games.view.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private FrameLayout bzj;
    private NetworkErrorView cUX;
    private View.OnClickListener ehP;
    private ImageView ehQ;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        bby();
        a(new GameWebViewClient());
        dT(context);
    }

    private void dT(Context context) {
        com.baidu.swan.apps.adaptation.a.b akx = d.aJQ().aJS().aiF().akx();
        if (akx != null) {
            akx.bR(context);
        }
    }

    private void initView() {
        this.bzj = new FrameLayout(this.cNu.getBaseContext());
        this.bzj.addView(alh(), -1, -1);
        bbv();
        bbw();
        bbx();
    }

    private void bbv() {
        if (this.ehQ == null) {
            this.ehQ = new ImageView(this.cNu.getBaseContext());
            Resources resources = this.cNu.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.ehQ.setLayoutParams(layoutParams);
            this.ehQ.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.ehQ.setImageResource(a.e.swangame_webview_close_button);
            this.ehQ.setClickable(true);
            this.ehQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.ehP != null) {
                        GameWebViewManager.this.ehP.onClick(view);
                    }
                }
            });
            this.bzj.addView(this.ehQ);
        }
    }

    private void bbw() {
        this.cUX = new NetworkErrorView(this.cNu.getBaseContext());
        this.cUX.setBackgroundColor(this.cNu.getResources().getColor(a.c.aiapps_white));
        alh().addView(this.cUX, -1, -1);
        this.cUX.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.cNu) && com.baidu.swan.apps.ag.a.b.sT(GameWebViewManager.this.alh().getUrl())) {
                    GameWebViewManager.this.alh().reload();
                    GameWebViewManager.this.cUX.setVisibility(8);
                }
            }
        };
        this.cUX.setOnClickListener(onClickListener);
        this.cUX.setReloadClickListener(onClickListener);
    }

    private void bbx() {
        this.mLoadingView = new ImageView(this.cNu.getBaseContext());
        int dimension = (int) this.cNu.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.bzj.addView(this.mLoadingView, layoutParams);
    }

    private void bby() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.ag.a.b.sT(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void apE() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void apD() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void apF() {
        alh().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.ag.a.b.sT(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String alj() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aUi() {
        alh().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aUj() {
        bbz();
        alh().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.ehP = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void alo() {
        com.baidu.swan.games.view.c.c(this.bzj, com.baidu.swan.apps.model.a.a.a.aEF());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean akY() {
        return this.bzj.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void alp() {
        alh().stopLoading();
        alh().clearView();
        com.baidu.swan.games.view.c.removeView(this.bzj);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void eG(boolean z) {
        if (this.ehQ != null) {
            if (z) {
                this.ehQ.setVisibility(0);
            } else {
                this.ehQ.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.cNu, a.C0379a.swangame_webview_loading);
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

    private void bbz() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes25.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cUX.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.ag.a.b.sT(str);
            if (!z && (com.baidu.swan.apps.ag.a.b.sX(str) || com.baidu.swan.apps.ag.a.b.sY(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e aJV = e.aJV();
                    if (aJV != null) {
                        aJV.aJO().startActivity(intent);
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
