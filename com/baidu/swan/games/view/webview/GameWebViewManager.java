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
    private NetworkErrorView bsq;
    private FrameLayout cvq;
    private View.OnClickListener cvr;
    private ImageView cvs;
    private ImageView cvt;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        arv();
        a(new GameWebViewClient());
        dg(context);
    }

    private void dg(Context context) {
        com.baidu.swan.apps.adaptation.a.b HW = d.acF().acH().Ha().HW();
        if (HW != null) {
            HW.bn(context);
        }
    }

    private void initView() {
        this.cvq = new FrameLayout(this.mContext);
        this.cvq.addView(IS(), -1, -1);
        ars();
        art();
        aru();
    }

    private void ars() {
        if (this.cvt == null) {
            this.cvt = new ImageView(this.mContext);
            Resources resources = this.mContext.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.cvt.setLayoutParams(layoutParams);
            this.cvt.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.cvt.setImageResource(a.e.swangame_webview_close_button);
            this.cvt.setClickable(true);
            this.cvt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.cvr != null) {
                        GameWebViewManager.this.cvr.onClick(view);
                    }
                }
            });
            this.cvq.addView(this.cvt);
        }
    }

    private void art() {
        this.bsq = new NetworkErrorView(this.mContext);
        this.bsq.setBackgroundColor(this.mContext.getResources().getColor(a.c.aiapps_white));
        IS().addView(this.bsq, -1, -1);
        this.bsq.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.mContext) && com.baidu.swan.apps.aj.a.b.lg(GameWebViewManager.this.IS().getUrl())) {
                    GameWebViewManager.this.IS().reload();
                    GameWebViewManager.this.bsq.setVisibility(8);
                }
            }
        };
        this.bsq.setOnClickListener(onClickListener);
        this.bsq.setReloadClickListener(onClickListener);
    }

    private void aru() {
        this.cvs = new ImageView(this.mContext);
        int dimension = (int) this.mContext.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.cvs.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.cvs.setImageResource(a.e.swangame_webview_loading);
        this.cvq.addView(this.cvs, layoutParams);
    }

    private void arv() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.aj.a.b.lg(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MS() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(Context context, SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MR() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MT() {
        IS().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.aj.a.b.lg(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String IU() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void akR() {
        IS().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void akS() {
        arw();
        IS().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void d(View.OnClickListener onClickListener) {
        this.cvr = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void IX() {
        com.baidu.swan.games.view.c.c(this.cvq, com.baidu.swan.apps.model.a.a.a.Yz());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean IK() {
        return this.cvq.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void IY() {
        IS().stopLoading();
        IS().clearView();
        com.baidu.swan.games.view.c.au(this.cvq);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void bY(boolean z) {
        if (this.cvt != null) {
            if (z) {
                this.cvt.setVisibility(0);
            } else {
                this.cvt.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0197a.swangame_webview_loading);
        this.cvs.setVisibility(0);
        this.cvs.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.cvs.getVisibility() == 0) {
            this.cvs.clearAnimation();
            this.cvs.setVisibility(8);
        }
    }

    private void arw() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes11.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.bsq.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.aj.a.b.lg(str);
            if (!z && (com.baidu.swan.apps.aj.a.b.lk(str) || com.baidu.swan.apps.aj.a.b.ll(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e acJ = e.acJ();
                    if (acJ != null) {
                        acJ.acE().startActivity(intent);
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
