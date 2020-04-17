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
/* loaded from: classes11.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements g<NgWebView>, com.baidu.swan.games.view.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private NetworkErrorView bQw;
    private FrameLayout cUm;
    private View.OnClickListener cUn;
    private ImageView cUo;
    private ImageView cUp;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        azG();
        a(new GameWebViewClient());
        cU(context);
    }

    private void cU(Context context) {
        com.baidu.swan.apps.adaptation.a.b PI = d.akK().akM().ON().PI();
        if (PI != null) {
            PI.bb(context);
        }
    }

    private void initView() {
        this.cUm = new FrameLayout(this.mContext);
        this.cUm.addView(QE(), -1, -1);
        azD();
        azE();
        azF();
    }

    private void azD() {
        if (this.cUp == null) {
            this.cUp = new ImageView(this.mContext);
            Resources resources = this.mContext.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.cUp.setLayoutParams(layoutParams);
            this.cUp.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.cUp.setImageResource(a.e.swangame_webview_close_button);
            this.cUp.setClickable(true);
            this.cUp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.cUn != null) {
                        GameWebViewManager.this.cUn.onClick(view);
                    }
                }
            });
            this.cUm.addView(this.cUp);
        }
    }

    private void azE() {
        this.bQw = new NetworkErrorView(this.mContext);
        this.bQw.setBackgroundColor(this.mContext.getResources().getColor(a.c.aiapps_white));
        QE().addView(this.bQw, -1, -1);
        this.bQw.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.mContext) && com.baidu.swan.apps.aj.a.b.mt(GameWebViewManager.this.QE().getUrl())) {
                    GameWebViewManager.this.QE().reload();
                    GameWebViewManager.this.bQw.setVisibility(8);
                }
            }
        };
        this.bQw.setOnClickListener(onClickListener);
        this.bQw.setReloadClickListener(onClickListener);
    }

    private void azF() {
        this.cUo = new ImageView(this.mContext);
        int dimension = (int) this.mContext.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.cUo.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.cUo.setImageResource(a.e.swangame_webview_loading);
        this.cUm.addView(this.cUo, layoutParams);
    }

    private void azG() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.aj.a.b.mt(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void UF() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(Context context, SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void UE() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void UG() {
        QE().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.aj.a.b.mt(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String QG() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void ate() {
        QE().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void atf() {
        azH();
        QE().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void d(View.OnClickListener onClickListener) {
        this.cUn = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void QJ() {
        com.baidu.swan.games.view.c.c(this.cUm, com.baidu.swan.apps.model.a.a.a.agF());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean Qw() {
        return this.cUm.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void QK() {
        QE().stopLoading();
        QE().clearView();
        com.baidu.swan.games.view.c.av(this.cUm);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void cU(boolean z) {
        if (this.cUp != null) {
            if (z) {
                this.cUp.setVisibility(0);
            } else {
                this.cUp.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0227a.swangame_webview_loading);
        this.cUo.setVisibility(0);
        this.cUo.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.cUo.getVisibility() == 0) {
            this.cUo.clearAnimation();
            this.cUo.setVisibility(8);
        }
    }

    private void azH() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes11.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.bQw.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.aj.a.b.mt(str);
            if (!z && (com.baidu.swan.apps.aj.a.b.mx(str) || com.baidu.swan.apps.aj.a.b.my(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e akO = e.akO();
                    if (akO != null) {
                        akO.akJ().startActivity(intent);
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
