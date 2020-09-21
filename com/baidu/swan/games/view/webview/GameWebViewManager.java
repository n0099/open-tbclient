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
/* loaded from: classes3.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements g<NgWebView>, com.baidu.swan.games.view.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private NetworkErrorView cpk;
    private FrameLayout dCg;
    private View.OnClickListener dCh;
    private ImageView dCi;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        aRX();
        a(new GameWebViewClient());
        dh(context);
    }

    private void dh(Context context) {
        com.baidu.swan.apps.adaptation.a.b aaR = d.aAn().aAp().YZ().aaR();
        if (aaR != null) {
            aaR.bf(context);
        }
    }

    private void initView() {
        this.dCg = new FrameLayout(this.chB.getBaseContext());
        this.dCg.addView(abB(), -1, -1);
        aRU();
        aRV();
        aRW();
    }

    private void aRU() {
        if (this.dCi == null) {
            this.dCi = new ImageView(this.chB.getBaseContext());
            Resources resources = this.chB.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.dCi.setLayoutParams(layoutParams);
            this.dCi.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.dCi.setImageResource(a.e.swangame_webview_close_button);
            this.dCi.setClickable(true);
            this.dCi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.dCh != null) {
                        GameWebViewManager.this.dCh.onClick(view);
                    }
                }
            });
            this.dCg.addView(this.dCi);
        }
    }

    private void aRV() {
        this.cpk = new NetworkErrorView(this.chB.getBaseContext());
        this.cpk.setBackgroundColor(this.chB.getResources().getColor(a.c.aiapps_white));
        abB().addView(this.cpk, -1, -1);
        this.cpk.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.chB) && com.baidu.swan.apps.ag.a.b.qX(GameWebViewManager.this.abB().getUrl())) {
                    GameWebViewManager.this.abB().reload();
                    GameWebViewManager.this.cpk.setVisibility(8);
                }
            }
        };
        this.cpk.setOnClickListener(onClickListener);
        this.cpk.setReloadClickListener(onClickListener);
    }

    private void aRW() {
        this.mLoadingView = new ImageView(this.chB.getBaseContext());
        int dimension = (int) this.chB.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.dCg.addView(this.mLoadingView, layoutParams);
    }

    private void aRX() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.ag.a.b.qX(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afZ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afY() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aga() {
        abB().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.ag.a.b.qX(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String abD() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aKI() {
        abB().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aKJ() {
        aRY();
        abB().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void d(View.OnClickListener onClickListener) {
        this.dCh = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void abI() {
        com.baidu.swan.games.view.c.c(this.dCg, com.baidu.swan.apps.model.a.a.a.auZ());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean abs() {
        return this.dCg.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void abJ() {
        abB().stopLoading();
        abB().clearView();
        com.baidu.swan.games.view.c.removeView(this.dCg);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void dw(boolean z) {
        if (this.dCi != null) {
            if (z) {
                this.dCi.setVisibility(0);
            } else {
                this.dCi.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.chB, a.C0326a.swangame_webview_loading);
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

    private void aRY() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes3.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cpk.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.ag.a.b.qX(str);
            if (!z && (com.baidu.swan.apps.ag.a.b.rb(str) || com.baidu.swan.apps.ag.a.b.rc(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e aAs = e.aAs();
                    if (aAs != null) {
                        aAs.aAl().startActivity(intent);
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
