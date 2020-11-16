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
/* loaded from: classes7.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements g<NgWebView>, com.baidu.swan.games.view.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private FrameLayout btY;
    private NetworkErrorView cOe;
    private View.OnClickListener eaO;
    private ImageView eaP;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        aYt();
        a(new GameWebViewClient());
        dn(context);
    }

    private void dn(Context context) {
        com.baidu.swan.apps.adaptation.a.b ahp = d.aGI().aGK().afx().ahp();
        if (ahp != null) {
            ahp.bl(context);
        }
    }

    private void initView() {
        this.btY = new FrameLayout(this.cGA.getBaseContext());
        this.btY.addView(ahZ(), -1, -1);
        aYq();
        aYr();
        aYs();
    }

    private void aYq() {
        if (this.eaP == null) {
            this.eaP = new ImageView(this.cGA.getBaseContext());
            Resources resources = this.cGA.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.eaP.setLayoutParams(layoutParams);
            this.eaP.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.eaP.setImageResource(a.e.swangame_webview_close_button);
            this.eaP.setClickable(true);
            this.eaP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.eaO != null) {
                        GameWebViewManager.this.eaO.onClick(view);
                    }
                }
            });
            this.btY.addView(this.eaP);
        }
    }

    private void aYr() {
        this.cOe = new NetworkErrorView(this.cGA.getBaseContext());
        this.cOe.setBackgroundColor(this.cGA.getResources().getColor(a.c.aiapps_white));
        ahZ().addView(this.cOe, -1, -1);
        this.cOe.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.cGA) && com.baidu.swan.apps.ag.a.b.sl(GameWebViewManager.this.ahZ().getUrl())) {
                    GameWebViewManager.this.ahZ().reload();
                    GameWebViewManager.this.cOe.setVisibility(8);
                }
            }
        };
        this.cOe.setOnClickListener(onClickListener);
        this.cOe.setReloadClickListener(onClickListener);
    }

    private void aYs() {
        this.mLoadingView = new ImageView(this.cGA.getBaseContext());
        int dimension = (int) this.cGA.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.btY.addView(this.mLoadingView, layoutParams);
    }

    private void aYt() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.ag.a.b.sl(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void amw() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void amv() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void amx() {
        ahZ().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.ag.a.b.sl(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aib() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aRd() {
        ahZ().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aRe() {
        aYu();
        ahZ().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void e(View.OnClickListener onClickListener) {
        this.eaO = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void aig() {
        com.baidu.swan.games.view.c.c(this.btY, com.baidu.swan.apps.model.a.a.a.aBw());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean ahQ() {
        return this.btY.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void aih() {
        ahZ().stopLoading();
        ahZ().clearView();
        com.baidu.swan.games.view.c.removeView(this.btY);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void er(boolean z) {
        if (this.eaP != null) {
            if (z) {
                this.eaP.setVisibility(0);
            } else {
                this.eaP.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.cGA, a.C0367a.swangame_webview_loading);
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

    private void aYu() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes7.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cOe.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.ag.a.b.sl(str);
            if (!z && (com.baidu.swan.apps.ag.a.b.sp(str) || com.baidu.swan.apps.ag.a.b.sq(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e aGN = e.aGN();
                    if (aGN != null) {
                        aGN.aGG().startActivity(intent);
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
