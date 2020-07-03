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
    private NetworkErrorView cfd;
    private FrameLayout dkf;
    private View.OnClickListener dkg;
    private ImageView dkh;
    private ImageView mLoadingView;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        aEE();
        a(new GameWebViewClient());
        cX(context);
    }

    private void cX(Context context) {
        com.baidu.swan.apps.adaptation.a.b TG = d.apI().apK().Se().TG();
        if (TG != null) {
            TG.ba(context);
        }
    }

    private void initView() {
        this.dkf = new FrameLayout(this.bYp.getBaseContext());
        this.dkf.addView(Un(), -1, -1);
        aEB();
        aEC();
        aED();
    }

    private void aEB() {
        if (this.dkh == null) {
            this.dkh = new ImageView(this.bYp.getBaseContext());
            Resources resources = this.bYp.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.dkh.setLayoutParams(layoutParams);
            this.dkh.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.dkh.setImageResource(a.e.swangame_webview_close_button);
            this.dkh.setClickable(true);
            this.dkh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.dkg != null) {
                        GameWebViewManager.this.dkg.onClick(view);
                    }
                }
            });
            this.dkf.addView(this.dkh);
        }
    }

    private void aEC() {
        this.cfd = new NetworkErrorView(this.bYp.getBaseContext());
        this.cfd.setBackgroundColor(this.bYp.getResources().getColor(a.c.aiapps_white));
        Un().addView(this.cfd, -1, -1);
        this.cfd.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.bYp) && com.baidu.swan.apps.ah.a.b.nY(GameWebViewManager.this.Un().getUrl())) {
                    GameWebViewManager.this.Un().reload();
                    GameWebViewManager.this.cfd.setVisibility(8);
                }
            }
        };
        this.cfd.setOnClickListener(onClickListener);
        this.cfd.setReloadClickListener(onClickListener);
    }

    private void aED() {
        this.mLoadingView = new ImageView(this.bYp.getBaseContext());
        int dimension = (int) this.bYp.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.mLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mLoadingView.setImageResource(a.e.swangame_webview_loading);
        this.dkf.addView(this.mLoadingView, layoutParams);
    }

    private void aEE() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.ah.a.b.nY(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Yq() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Yp() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Yr() {
        Un().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.ah.a.b.nY(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String Up() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void axR() {
        Un().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void axS() {
        aEF();
        Un().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void d(View.OnClickListener onClickListener) {
        this.dkg = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void Us() {
        com.baidu.swan.games.view.c.c(this.dkf, com.baidu.swan.apps.model.a.a.a.ald());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean Uf() {
        return this.dkf.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void Ut() {
        Un().stopLoading();
        Un().clearView();
        com.baidu.swan.games.view.c.av(this.dkf);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void dm(boolean z) {
        if (this.dkh != null) {
            if (z) {
                this.dkh.setVisibility(0);
            } else {
                this.dkh.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bYp, a.C0287a.swangame_webview_loading);
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

    private void aEF() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes11.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.cfd.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.ah.a.b.nY(str);
            if (!z && (com.baidu.swan.apps.ah.a.b.oc(str) || com.baidu.swan.apps.ah.a.b.od(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e apN = e.apN();
                    if (apN != null) {
                        apN.apG().startActivity(intent);
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
