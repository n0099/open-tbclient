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
    private NetworkErrorView cgO;
    private FrameLayout dpZ;
    private View.OnClickListener dqa;
    private ImageView dqb;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        aIv();
        a(new GameWebViewClient());
        dc(context);
    }

    private void dc(Context context) {
        com.baidu.swan.apps.adaptation.a.b Ug = d.arr().art().Sv().Ug();
        if (Ug != null) {
            Ug.bb(context);
        }
    }

    private void initView() {
        this.dpZ = new FrameLayout(this.bZD.getBaseContext());
        this.dpZ.addView(UP(), -1, -1);
        aIs();
        aIt();
        aIu();
    }

    private void aIs() {
        if (this.dqb == null) {
            this.dqb = new ImageView(this.bZD.getBaseContext());
            Resources resources = this.bZD.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.dqb.setLayoutParams(layoutParams);
            this.dqb.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.dqb.setImageResource(a.e.swangame_webview_close_button);
            this.dqb.setClickable(true);
            this.dqb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.dqa != null) {
                        GameWebViewManager.this.dqa.onClick(view);
                    }
                }
            });
            this.dpZ.addView(this.dqb);
        }
    }

    private void aIt() {
        this.cgO = new NetworkErrorView(this.bZD.getBaseContext());
        this.cgO.setBackgroundColor(this.bZD.getResources().getColor(a.c.aiapps_white));
        UP().addView(this.cgO, -1, -1);
        this.cgO.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.bZD) && com.baidu.swan.apps.ah.a.b.oG(GameWebViewManager.this.UP().getUrl())) {
                    GameWebViewManager.this.UP().reload();
                    GameWebViewManager.this.cgO.setVisibility(8);
                }
            }
        };
        this.cgO.setOnClickListener(onClickListener);
        this.cgO.setReloadClickListener(onClickListener);
    }

    private void aIu() {
        this.mLoadingView = new ImageView(this.bZD.getBaseContext());
        int dimension = (int) this.bZD.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.dpZ.addView(this.mLoadingView, layoutParams);
    }

    private void aIv() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.ah.a.b.oG(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Zg() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Zf() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Zh() {
        UP().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.ah.a.b.oG(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String UR() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aBh() {
        UP().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aBi() {
        aIw();
        UP().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void d(View.OnClickListener onClickListener) {
        this.dqa = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void UU() {
        com.baidu.swan.games.view.c.c(this.dpZ, com.baidu.swan.apps.model.a.a.a.amu());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean UG() {
        return this.dpZ.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void UV() {
        UP().stopLoading();
        UP().clearView();
        com.baidu.swan.games.view.c.ay(this.dpZ);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void dp(boolean z) {
        if (this.dqb != null) {
            if (z) {
                this.dqb.setVisibility(0);
            } else {
                this.dqb.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bZD, a.C0290a.swangame_webview_loading);
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

    private void aIw() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes7.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cgO.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.ah.a.b.oG(str);
            if (!z && (com.baidu.swan.apps.ah.a.b.oK(str) || com.baidu.swan.apps.ah.a.b.oL(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e arw = e.arw();
                    if (arw != null) {
                        arw.arp().startActivity(intent);
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
