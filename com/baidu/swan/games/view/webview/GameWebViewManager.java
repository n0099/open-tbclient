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
/* loaded from: classes9.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements g<NgWebView>, com.baidu.swan.games.view.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private FrameLayout bCQ;
    private NetworkErrorView cXu;
    private View.OnClickListener eon;
    private ImageView eoo;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        bak();
        a(new GameWebViewClient());
        ek(context);
    }

    private void ek(Context context) {
        com.baidu.swan.apps.adaptation.a.b aim = d.aIG().aII().ags().aim();
        if (aim != null) {
            aim.bW(context);
        }
    }

    private void initView() {
        this.bCQ = new FrameLayout(this.cPR.getBaseContext());
        this.bCQ.addView(aiW(), -1, -1);
        bah();
        bai();
        baj();
    }

    private void bah() {
        if (this.eoo == null) {
            this.eoo = new ImageView(this.cPR.getBaseContext());
            Resources resources = this.cPR.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.eoo.setLayoutParams(layoutParams);
            this.eoo.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.eoo.setImageResource(a.e.swangame_webview_close_button);
            this.eoo.setClickable(true);
            this.eoo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.eon != null) {
                        GameWebViewManager.this.eon.onClick(view);
                    }
                }
            });
            this.bCQ.addView(this.eoo);
        }
    }

    private void bai() {
        this.cXu = new NetworkErrorView(this.cPR.getBaseContext());
        this.cXu.setBackgroundColor(this.cPR.getResources().getColor(a.c.aiapps_white));
        aiW().addView(this.cXu, -1, -1);
        this.cXu.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.cPR) && com.baidu.swan.apps.af.a.b.rX(GameWebViewManager.this.aiW().getUrl())) {
                    GameWebViewManager.this.aiW().reload();
                    GameWebViewManager.this.cXu.setVisibility(8);
                }
            }
        };
        this.cXu.setOnClickListener(onClickListener);
        this.cXu.setReloadClickListener(onClickListener);
    }

    private void baj() {
        this.mLoadingView = new ImageView(this.cPR.getBaseContext());
        int dimension = (int) this.cPR.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.bCQ.addView(this.mLoadingView, layoutParams);
    }

    private void bak() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.af.a.b.rX(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anu() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void ant() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anv() {
        aiW().addJavascriptInterface(new GameWebViewJavascriptInterface(), GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.af.a.b.rX(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiY() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aSV() {
        aiW().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aSW() {
        bal();
        aiW().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void aSX() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.eon = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void ajd() {
        com.baidu.swan.games.view.c.c(this.bCQ, com.baidu.swan.apps.model.a.a.a.aCC());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean aiN() {
        return this.bCQ.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void aje() {
        aiW().stopLoading();
        aiW().clearView();
        com.baidu.swan.games.view.c.removeView(this.bCQ);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void eN(boolean z) {
        if (this.eoo != null) {
            if (z) {
                this.eoo.setVisibility(0);
            } else {
                this.eoo.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.cPR, a.C0352a.swangame_webview_loading);
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

    private void bal() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes9.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cXu.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.af.a.b.rX(str);
            if (!z && (com.baidu.swan.apps.af.a.b.sb(str) || com.baidu.swan.apps.af.a.b.sc(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e aIL = e.aIL();
                    if (aIL != null) {
                        aIL.aIE().startActivity(intent);
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
