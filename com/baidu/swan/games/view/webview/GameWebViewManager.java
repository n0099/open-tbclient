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
    private FrameLayout bDW;
    private NetworkErrorView cZT;
    private View.OnClickListener eqS;
    private ImageView eqT;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        bdR();
        a(new GameWebViewClient());
        em(context);
    }

    private void em(Context context) {
        com.baidu.swan.apps.adaptation.a.b alI = d.aMh().aMj().ajO().alI();
        if (alI != null) {
            alI.bY(context);
        }
    }

    private void initView() {
        this.bDW = new FrameLayout(this.cSp.getBaseContext());
        this.bDW.addView(ams(), -1, -1);
        bdO();
        bdP();
        bdQ();
    }

    private void bdO() {
        if (this.eqT == null) {
            this.eqT = new ImageView(this.cSp.getBaseContext());
            Resources resources = this.cSp.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.eqT.setLayoutParams(layoutParams);
            this.eqT.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.eqT.setImageResource(a.e.swangame_webview_close_button);
            this.eqT.setClickable(true);
            this.eqT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.eqS != null) {
                        GameWebViewManager.this.eqS.onClick(view);
                    }
                }
            });
            this.bDW.addView(this.eqT);
        }
    }

    private void bdP() {
        this.cZT = new NetworkErrorView(this.cSp.getBaseContext());
        this.cZT.setBackgroundColor(this.cSp.getResources().getColor(a.c.aiapps_white));
        ams().addView(this.cZT, -1, -1);
        this.cZT.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.cSp) && com.baidu.swan.apps.af.a.b.sQ(GameWebViewManager.this.ams().getUrl())) {
                    GameWebViewManager.this.ams().reload();
                    GameWebViewManager.this.cZT.setVisibility(8);
                }
            }
        };
        this.cZT.setOnClickListener(onClickListener);
        this.cZT.setReloadClickListener(onClickListener);
    }

    private void bdQ() {
        this.mLoadingView = new ImageView(this.cSp.getBaseContext());
        int dimension = (int) this.cSp.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.bDW.addView(this.mLoadingView, layoutParams);
    }

    private void bdR() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.af.a.b.sQ(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aqR() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aqQ() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aqS() {
        ams().addJavascriptInterface(new GameWebViewJavascriptInterface(), GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.af.a.b.sQ(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String amu() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aWD() {
        ams().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aWE() {
        bdS();
        ams().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void aWF() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.eqS = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void amz() {
        com.baidu.swan.games.view.c.c(this.bDW, com.baidu.swan.apps.model.a.a.a.aFZ());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean amj() {
        return this.bDW.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void amA() {
        ams().stopLoading();
        ams().clearView();
        com.baidu.swan.games.view.c.removeView(this.bDW);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void eP(boolean z) {
        if (this.eqT != null) {
            if (z) {
                this.eqT.setVisibility(0);
            } else {
                this.eqT.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.cSp, a.C0372a.swangame_webview_loading);
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

    private void bdS() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes9.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cZT.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.af.a.b.sQ(str);
            if (!z && (com.baidu.swan.apps.af.a.b.sU(str) || com.baidu.swan.apps.af.a.b.sV(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e aMm = e.aMm();
                    if (aMm != null) {
                        aMm.aMf().startActivity(intent);
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
