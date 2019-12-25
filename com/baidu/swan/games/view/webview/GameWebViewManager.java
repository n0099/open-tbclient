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
    private NetworkErrorView bnf;
    private FrameLayout cqP;
    private View.OnClickListener cqQ;
    private ImageView cqR;
    private ImageView cqS;

    public GameWebViewManager(Context context) {
        super(context);
        initView();
        aoJ();
        a(new GameWebViewClient());
        dd(context);
    }

    private void dd(Context context) {
        com.baidu.swan.apps.adaptation.a.b Fg = d.ZP().ZR().Ei().Fg();
        if (Fg != null) {
            Fg.bk(context);
        }
    }

    private void initView() {
        this.cqP = new FrameLayout(this.mContext);
        this.cqP.addView(Gc(), -1, -1);
        aoG();
        aoH();
        aoI();
    }

    private void aoG() {
        if (this.cqS == null) {
            this.cqS = new ImageView(this.mContext);
            Resources resources = this.mContext.getResources();
            int dimension = (int) resources.getDimension(a.d.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(a.d.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(a.d.swangame_webview_button_left_margin);
            this.cqS.setLayoutParams(layoutParams);
            this.cqS.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.cqS.setImageResource(a.e.swangame_webview_close_button);
            this.cqS.setClickable(true);
            this.cqS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameWebViewManager.this.cqQ != null) {
                        GameWebViewManager.this.cqQ.onClick(view);
                    }
                }
            });
            this.cqP.addView(this.cqS);
        }
    }

    private void aoH() {
        this.bnf = new NetworkErrorView(this.mContext);
        this.bnf.setBackgroundColor(this.mContext.getResources().getColor(a.c.aiapps_white));
        Gc().addView(this.bnf, -1, -1);
        this.bnf.setVisibility(8);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppNetworkUtils.isNetworkConnected(GameWebViewManager.this.mContext) && com.baidu.swan.apps.aj.a.b.kP(GameWebViewManager.this.Gc().getUrl())) {
                    GameWebViewManager.this.Gc().reload();
                    GameWebViewManager.this.bnf.setVisibility(8);
                }
            }
        };
        this.bnf.setOnClickListener(onClickListener);
        this.bnf.setReloadClickListener(onClickListener);
    }

    private void aoI() {
        this.cqR = new ImageView(this.mContext);
        int dimension = (int) this.mContext.getResources().getDimension(a.d.swangame_webview_loading_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.cqR.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.cqR.setImageResource(a.e.swangame_webview_loading);
        this.cqP.addView(this.cqR, layoutParams);
    }

    private void aoJ() {
        a(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.DEBUG) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !com.baidu.swan.apps.aj.a.b.kP(str);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Kc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(Context context, SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Kb() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Kd() {
        Gc().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (DEBUG) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (com.baidu.swan.apps.aj.a.b.kP(str)) {
            showLoadingView();
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String Ge() {
        return "SwanGameWebView";
    }

    @Override // com.baidu.swan.games.view.a
    public void aif() {
        Gc().onResume();
    }

    @Override // com.baidu.swan.games.view.a
    public void aig() {
        aoK();
        Gc().onPause();
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void d(View.OnClickListener onClickListener) {
        this.cqQ = onClickListener;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void Gh() {
        com.baidu.swan.games.view.c.c(this.cqP, com.baidu.swan.apps.model.a.a.a.VJ());
        com.baidu.swan.games.view.c.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public boolean FU() {
        return this.cqP.getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void Gi() {
        Gc().stopLoading();
        Gc().clearView();
        com.baidu.swan.games.view.c.aq(this.cqP);
        com.baidu.swan.games.view.c.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.g
    public void bK(boolean z) {
        if (this.cqS != null) {
            if (z) {
                this.cqS.setVisibility(0);
            } else {
                this.cqS.setVisibility(8);
            }
        }
    }

    private void showLoadingView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0185a.swangame_webview_loading);
        this.cqR.setVisibility(0);
        this.cqR.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.cqR.getVisibility() == 0) {
            this.cqR.clearAnimation();
            this.cqR.setVisibility(8);
        }
    }

    private void aoK() {
        loadJavaScript("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    /* loaded from: classes9.dex */
    private class GameWebViewClient extends BdSailorWebViewClient {
        private GameWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i != -10) {
                GameWebViewManager.this.bnf.setVisibility(0);
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
            boolean z = !com.baidu.swan.apps.aj.a.b.kP(str);
            if (!z && (com.baidu.swan.apps.aj.a.b.kT(str) || com.baidu.swan.apps.aj.a.b.kU(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    e ZT = e.ZT();
                    if (ZT != null) {
                        ZT.ZO().startActivity(intent);
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
