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
    private NetworkErrorView cnd;
    private FrameLayout dAb;
    private View.OnClickListener dAc;
    private ImageView dAd;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        aRl();
        a(new GameWebViewClient());
        di(context);
    }

    private void di(Context context) {
        com.baidu.swan.apps.adaptation.a.b aai = d.azE().azG().Yq().aai();
        if (aai != null) {
            aai.bg(context);
        }
    }

    private void initView() {
        this.dAb = new FrameLayout(this.cfw.getBaseContext());
        this.dAb.addView(aaS(), -1, -1);
        aRi();
        aRj();
        aRk();
    }

    private void aRi() {
        if (this.dAd == null) {
            this.dAd = new ImageView(this.cfw.getBaseContext());
            Resources resources = this.cfw.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.dAd.setLayoutParams(layoutParams);
            this.dAd.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.dAd.setImageResource(a.e.swangame_webview_close_button);
            this.dAd.setClickable(true);
            this.dAd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.dAc != null) {
                        GameWebViewManager.this.dAc.onClick(view);
                    }
                }
            });
            this.dAb.addView(this.dAd);
        }
    }

    private void aRj() {
        this.cnd = new NetworkErrorView(this.cfw.getBaseContext());
        this.cnd.setBackgroundColor(this.cfw.getResources().getColor(a.c.aiapps_white));
        aaS().addView(this.cnd, -1, -1);
        this.cnd.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.cfw) && com.baidu.swan.apps.ag.a.b.qD(GameWebViewManager.this.aaS().getUrl())) {
                    GameWebViewManager.this.aaS().reload();
                    GameWebViewManager.this.cnd.setVisibility(8);
                }
            }
        };
        this.cnd.setOnClickListener(onClickListener);
        this.cnd.setReloadClickListener(onClickListener);
    }

    private void aRk() {
        this.mLoadingView = new ImageView(this.cfw.getBaseContext());
        int dimension = (int) this.cfw.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.dAb.addView(this.mLoadingView, layoutParams);
    }

    private void aRl() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.ag.a.b.qD(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afp() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afo() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afq() {
        aaS().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.ag.a.b.qD(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aaU() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aJX() {
        aaS().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aJY() {
        aRm();
        aaS().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void d(View.OnClickListener onClickListener) {
        this.dAc = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void aaZ() {
        com.baidu.swan.games.view.c.c(this.dAb, com.baidu.swan.apps.model.a.a.a.auq());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean aaJ() {
        return this.dAb.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void aba() {
        aaS().stopLoading();
        aaS().clearView();
        com.baidu.swan.games.view.c.removeView(this.dAb);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void dx(boolean z) {
        if (this.dAd != null) {
            if (z) {
                this.dAd.setVisibility(0);
            } else {
                this.dAd.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.cfw, a.C0331a.swangame_webview_loading);
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

    private void aRm() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes8.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cnd.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.ag.a.b.qD(str);
            if (!z && (com.baidu.swan.apps.ag.a.b.qH(str) || com.baidu.swan.apps.ag.a.b.qI(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e azJ = e.azJ();
                    if (azJ != null) {
                        azJ.azC().startActivity(intent);
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
