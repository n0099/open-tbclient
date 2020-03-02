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
    private NetworkErrorView bsd;
    private FrameLayout cve;
    private View.OnClickListener cvf;
    private ImageView cvg;
    private ImageView cvh;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        ars();
        a(new GameWebViewClient());
        dh(context);
    }

    private void dh(Context context) {
        com.baidu.swan.apps.adaptation.a.b HT = d.acC().acE().GV().HT();
        if (HT != null) {
            HT.bo(context);
        }
    }

    private void initView() {
        this.cve = new FrameLayout(this.mContext);
        this.cve.addView(IP(), -1, -1);
        arp();
        arq();
        arr();
    }

    private void arp() {
        if (this.cvh == null) {
            this.cvh = new ImageView(this.mContext);
            Resources resources = this.mContext.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.cvh.setLayoutParams(layoutParams);
            this.cvh.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.cvh.setImageResource(a.e.swangame_webview_close_button);
            this.cvh.setClickable(true);
            this.cvh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.cvf != null) {
                        GameWebViewManager.this.cvf.onClick(view);
                    }
                }
            });
            this.cve.addView(this.cvh);
        }
    }

    private void arq() {
        this.bsd = new NetworkErrorView(this.mContext);
        this.bsd.setBackgroundColor(this.mContext.getResources().getColor(a.c.aiapps_white));
        IP().addView(this.bsd, -1, -1);
        this.bsd.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.mContext) && com.baidu.swan.apps.aj.a.b.lh(GameWebViewManager.this.IP().getUrl())) {
                    GameWebViewManager.this.IP().reload();
                    GameWebViewManager.this.bsd.setVisibility(8);
                }
            }
        };
        this.bsd.setOnClickListener(onClickListener);
        this.bsd.setReloadClickListener(onClickListener);
    }

    private void arr() {
        this.cvg = new ImageView(this.mContext);
        int dimension = (int) this.mContext.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.cvg.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.cvg.setImageResource(a.e.swangame_webview_loading);
        this.cve.addView(this.cvg, layoutParams);
    }

    private void ars() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.aj.a.b.lh(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MP() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(Context context, SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MO() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MQ() {
        IP().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.aj.a.b.lh(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String IR() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void akO() {
        IP().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void akP() {
        art();
        IP().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void d(View.OnClickListener onClickListener) {
        this.cvf = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void IU() {
        com.baidu.swan.games.view.c.c(this.cve, com.baidu.swan.apps.model.a.a.a.Yw());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean IH() {
        return this.cve.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void IV() {
        IP().stopLoading();
        IP().clearView();
        com.baidu.swan.games.view.c.au(this.cve);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void bX(boolean z) {
        if (this.cvh != null) {
            if (z) {
                this.cvh.setVisibility(0);
            } else {
                this.cvh.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0197a.swangame_webview_loading);
        this.cvg.setVisibility(0);
        this.cvg.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.cvg.getVisibility() == 0) {
            this.cvg.clearAnimation();
            this.cvg.setVisibility(8);
        }
    }

    private void art() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes11.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.bsd.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.aj.a.b.lh(str);
            if (!z && (com.baidu.swan.apps.aj.a.b.ll(str) || com.baidu.swan.apps.aj.a.b.lm(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e acG = e.acG();
                    if (acG != null) {
                        acG.acB().startActivity(intent);
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
