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
    private FrameLayout bvK;
    private NetworkErrorView cPO;
    private View.OnClickListener ecw;
    private ImageView ecx;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        aZa();
        a(new GameWebViewClient());
        dn(context);
    }

    private void dn(Context context) {
        com.baidu.swan.apps.adaptation.a.b ahX = d.aHq().aHs().agf().ahX();
        if (ahX != null) {
            ahX.bl(context);
        }
    }

    private void initView() {
        this.bvK = new FrameLayout(this.cIk.getBaseContext());
        this.bvK.addView(aiH(), -1, -1);
        aYX();
        aYY();
        aYZ();
    }

    private void aYX() {
        if (this.ecx == null) {
            this.ecx = new ImageView(this.cIk.getBaseContext());
            Resources resources = this.cIk.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.ecx.setLayoutParams(layoutParams);
            this.ecx.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.ecx.setImageResource(a.e.swangame_webview_close_button);
            this.ecx.setClickable(true);
            this.ecx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.ecw != null) {
                        GameWebViewManager.this.ecw.onClick(view);
                    }
                }
            });
            this.bvK.addView(this.ecx);
        }
    }

    private void aYY() {
        this.cPO = new NetworkErrorView(this.cIk.getBaseContext());
        this.cPO.setBackgroundColor(this.cIk.getResources().getColor(a.c.aiapps_white));
        aiH().addView(this.cPO, -1, -1);
        this.cPO.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.cIk) && com.baidu.swan.apps.ag.a.b.sq(GameWebViewManager.this.aiH().getUrl())) {
                    GameWebViewManager.this.aiH().reload();
                    GameWebViewManager.this.cPO.setVisibility(8);
                }
            }
        };
        this.cPO.setOnClickListener(onClickListener);
        this.cPO.setReloadClickListener(onClickListener);
    }

    private void aYZ() {
        this.mLoadingView = new ImageView(this.cIk.getBaseContext());
        int dimension = (int) this.cIk.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.bvK.addView(this.mLoadingView, layoutParams);
    }

    private void aZa() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.ag.a.b.sq(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void ane() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void and() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anf() {
        aiH().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.ag.a.b.sq(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiJ() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aRL() {
        aiH().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aRM() {
        aZb();
        aiH().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void e(View.OnClickListener onClickListener) {
        this.ecw = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void aiO() {
        com.baidu.swan.games.view.c.c(this.bvK, com.baidu.swan.apps.model.a.a.a.aCe());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean aiy() {
        return this.bvK.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void aiP() {
        aiH().stopLoading();
        aiH().clearView();
        com.baidu.swan.games.view.c.removeView(this.bvK);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void eo(boolean z) {
        if (this.ecx != null) {
            if (z) {
                this.ecx.setVisibility(0);
            } else {
                this.ecx.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.cIk, a.C0369a.swangame_webview_loading);
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

    private void aZb() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes10.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cPO.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.ag.a.b.sq(str);
            if (!z && (com.baidu.swan.apps.ag.a.b.sv(str) || com.baidu.swan.apps.ag.a.b.sw(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e aHv = e.aHv();
                    if (aHv != null) {
                        aHv.aHo().startActivity(intent);
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
