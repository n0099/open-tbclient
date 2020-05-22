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
    private NetworkErrorView can;
    private FrameLayout dft;
    private View.OnClickListener dfu;
    private ImageView dfv;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        aDy();
        a(new GameWebViewClient());
        cW(context);
    }

    private void cW(Context context) {
        com.baidu.swan.apps.adaptation.a.b SA = d.aoB().aoD().QY().SA();
        if (SA != null) {
            SA.aZ(context);
        }
    }

    private void initView() {
        this.dft = new FrameLayout(this.bTB.getBaseContext());
        this.dft.addView(Th(), -1, -1);
        aDv();
        aDw();
        aDx();
    }

    private void aDv() {
        if (this.dfv == null) {
            this.dfv = new ImageView(this.bTB.getBaseContext());
            Resources resources = this.bTB.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.dfv.setLayoutParams(layoutParams);
            this.dfv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.dfv.setImageResource(a.e.swangame_webview_close_button);
            this.dfv.setClickable(true);
            this.dfv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.dfu != null) {
                        GameWebViewManager.this.dfu.onClick(view);
                    }
                }
            });
            this.dft.addView(this.dfv);
        }
    }

    private void aDw() {
        this.can = new NetworkErrorView(this.bTB.getBaseContext());
        this.can.setBackgroundColor(this.bTB.getResources().getColor(a.c.aiapps_white));
        Th().addView(this.can, -1, -1);
        this.can.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.bTB) && com.baidu.swan.apps.ah.a.b.nQ(GameWebViewManager.this.Th().getUrl())) {
                    GameWebViewManager.this.Th().reload();
                    GameWebViewManager.this.can.setVisibility(8);
                }
            }
        };
        this.can.setOnClickListener(onClickListener);
        this.can.setReloadClickListener(onClickListener);
    }

    private void aDx() {
        this.mLoadingView = new ImageView(this.bTB.getBaseContext());
        int dimension = (int) this.bTB.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.dft.addView(this.mLoadingView, layoutParams);
    }

    private void aDy() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.ah.a.b.nQ(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Xk() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Xj() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Xl() {
        Th().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.ah.a.b.nQ(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String Tj() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void awL() {
        Th().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void awM() {
        aDz();
        Th().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void d(View.OnClickListener onClickListener) {
        this.dfu = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void Tm() {
        com.baidu.swan.games.view.c.c(this.dft, com.baidu.swan.apps.model.a.a.a.ajX());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean SZ() {
        return this.dft.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void Tn() {
        Th().stopLoading();
        Th().clearView();
        com.baidu.swan.games.view.c.av(this.dft);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void dh(boolean z) {
        if (this.dfv != null) {
            if (z) {
                this.dfv.setVisibility(0);
            } else {
                this.dfv.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bTB, a.C0281a.swangame_webview_loading);
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

    private void aDz() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes11.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.can.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.ah.a.b.nQ(str);
            if (!z && (com.baidu.swan.apps.ah.a.b.nU(str) || com.baidu.swan.apps.ah.a.b.nV(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e aoG = e.aoG();
                    if (aoG != null) {
                        aoG.aoz().startActivity(intent);
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
