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
    private FrameLayout bEq;
    private NetworkErrorView cYU;
    private View.OnClickListener epO;
    private ImageView epP;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        ban();
        a(new GameWebViewClient());
        ej(context);
    }

    private void ej(Context context) {
        com.baidu.swan.apps.adaptation.a.b aip = d.aIJ().aIL().agv().aip();
        if (aip != null) {
            aip.bV(context);
        }
    }

    private void initView() {
        this.bEq = new FrameLayout(this.cRr.getBaseContext());
        this.bEq.addView(aiZ(), -1, -1);
        bak();
        bal();
        bam();
    }

    private void bak() {
        if (this.epP == null) {
            this.epP = new ImageView(this.cRr.getBaseContext());
            Resources resources = this.cRr.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.epP.setLayoutParams(layoutParams);
            this.epP.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.epP.setImageResource(a.e.swangame_webview_close_button);
            this.epP.setClickable(true);
            this.epP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.epO != null) {
                        GameWebViewManager.this.epO.onClick(view);
                    }
                }
            });
            this.bEq.addView(this.epP);
        }
    }

    private void bal() {
        this.cYU = new NetworkErrorView(this.cRr.getBaseContext());
        this.cYU.setBackgroundColor(this.cRr.getResources().getColor(a.c.aiapps_white));
        aiZ().addView(this.cYU, -1, -1);
        this.cYU.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.cRr) && com.baidu.swan.apps.af.a.b.se(GameWebViewManager.this.aiZ().getUrl())) {
                    GameWebViewManager.this.aiZ().reload();
                    GameWebViewManager.this.cYU.setVisibility(8);
                }
            }
        };
        this.cYU.setOnClickListener(onClickListener);
        this.cYU.setReloadClickListener(onClickListener);
    }

    private void bam() {
        this.mLoadingView = new ImageView(this.cRr.getBaseContext());
        int dimension = (int) this.cRr.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.bEq.addView(this.mLoadingView, layoutParams);
    }

    private void ban() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.af.a.b.se(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anx() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anw() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void any() {
        aiZ().addJavascriptInterface(new GameWebViewJavascriptInterface(), GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.af.a.b.se(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String ajb() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aSY() {
        aiZ().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aSZ() {
        bao();
        aiZ().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void aTa() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.epO = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void ajg() {
        com.baidu.swan.games.view.c.c(this.bEq, com.baidu.swan.apps.model.a.a.a.aCF());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean aiQ() {
        return this.bEq.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void ajh() {
        aiZ().stopLoading();
        aiZ().clearView();
        com.baidu.swan.games.view.c.removeView(this.bEq);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void eN(boolean z) {
        if (this.epP != null) {
            if (z) {
                this.epP.setVisibility(0);
            } else {
                this.epP.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.cRr, a.C0358a.swangame_webview_loading);
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

    private void bao() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes8.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cYU.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.af.a.b.se(str);
            if (!z && (com.baidu.swan.apps.af.a.b.si(str) || com.baidu.swan.apps.af.a.b.sj(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e aIO = e.aIO();
                    if (aIO != null) {
                        aIO.aIH().startActivity(intent);
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
