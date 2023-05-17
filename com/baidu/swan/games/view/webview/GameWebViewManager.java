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
import com.baidu.searchbox.IntentConstants;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
import com.baidu.tieba.R;
import com.baidu.tieba.ac4;
import com.baidu.tieba.f93;
import com.baidu.tieba.fo3;
import com.baidu.tieba.g93;
import com.baidu.tieba.mz2;
import com.baidu.tieba.qp1;
import com.baidu.tieba.qv1;
import com.baidu.tieba.ss1;
import com.baidu.tieba.x93;
/* loaded from: classes4.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements qv1<NgWebView>, fo3 {
    public static final boolean B = qp1.a;
    public ImageView A;
    public FrameLayout w;
    public View.OnClickListener x;
    public NetworkErrorView y;
    public ImageView z;

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void P0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Q0(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.ov1
    public String a() {
        return "SwanGameWebView";
    }

    /* loaded from: classes4.dex */
    public class GameWebViewClient extends BdSailorWebViewClient {
        public GameWebViewClient() {
        }

        public /* synthetic */ GameWebViewClient(GameWebViewManager gameWebViewManager, a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            GameWebViewManager.this.j1();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (i == -10) {
                return;
            }
            GameWebViewManager.this.y.setVisibility(0);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (GameWebViewManager.B) {
                Log.d("SwanGameWebViewManager", "shouldOverrideUrlLoading url: " + str);
            }
            boolean z = !x93.h(str);
            if (!z && (x93.e(str) || x93.f(str))) {
                try {
                    Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
                    g93 b0 = g93.b0();
                    if (b0 != null) {
                        b0.w().startActivity(intent);
                        return true;
                    }
                } catch (Exception e) {
                    if (GameWebViewManager.B) {
                        e.printStackTrace();
                    }
                }
            }
            return z;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (GameWebViewManager.this.x != null) {
                GameWebViewManager.this.x.onClick(view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!SwanAppNetworkUtils.i(GameWebViewManager.this.a) || !x93.h(GameWebViewManager.this.r().getUrl())) {
                return;
            }
            GameWebViewManager.this.r().reload();
            GameWebViewManager.this.y.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.qv1
    public void H() {
        ac4.a(this.w, mz2.a());
        ac4.c(this);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void M0() {
        r().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.tieba.qv1
    public boolean c() {
        if (this.w.getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.fo3
    public void e() {
        o1();
        r().onPause();
    }

    public final void i1() {
        Z0(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.B) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !x93.h(str);
            }
        });
    }

    public final void j1() {
        if (this.z.getVisibility() == 0) {
            this.z.clearAnimation();
            this.z.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.fo3
    public void l() {
        r().onResume();
    }

    public final void n1() {
        FrameLayout frameLayout = new FrameLayout(this.a.getBaseContext());
        this.w = frameLayout;
        frameLayout.addView(r(), -1, -1);
        k1();
        l1();
        m1();
    }

    public final void o1() {
        R0("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    @Override // com.baidu.tieba.fo3
    public void onViewDestroy() {
        destroy();
    }

    public final void p1() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010173);
        this.z.setVisibility(0);
        this.z.startAnimation(loadAnimation);
    }

    @Override // com.baidu.tieba.qv1
    public void removeFromParent() {
        r().stopLoading();
        r().clearView();
        ac4.d(this.w);
        ac4.e(this);
    }

    public GameWebViewManager(Context context) {
        super(context);
        n1();
        i1();
        Y0(new GameWebViewClient(this, null));
        q1(context);
    }

    @Override // com.baidu.tieba.qv1
    public void g(boolean z) {
        ImageView imageView = this.A;
        if (imageView != null) {
            if (z) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.qv1
    public void i(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.ov1
    public void loadUrl(String str) {
        if (B) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (!x93.h(str)) {
            return;
        }
        p1();
        super.loadUrl(str);
    }

    public final void q1(Context context) {
        ss1 a2 = f93.K().x().a().a();
        if (a2 != null) {
            a2.a(context);
        }
    }

    public final void k1() {
        if (this.A != null) {
            return;
        }
        this.A = new ImageView(this.a.getBaseContext());
        Resources resources = this.a.getResources();
        int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070891);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.topMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070892);
        layoutParams.leftMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070890);
        this.A.setLayoutParams(layoutParams);
        this.A.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A.setImageResource(R.drawable.obfuscated_res_0x7f08142a);
        this.A.setClickable(true);
        this.A.setOnClickListener(new a());
        this.w.addView(this.A);
    }

    public final void l1() {
        NetworkErrorView networkErrorView = new NetworkErrorView(this.a.getBaseContext());
        this.y = networkErrorView;
        networkErrorView.setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060425));
        r().addView(this.y, -1, -1);
        this.y.setVisibility(8);
        b bVar = new b();
        this.y.setOnClickListener(bVar);
        this.y.setReloadClickListener(bVar);
    }

    public final void m1() {
        this.z = new ImageView(this.a.getBaseContext());
        int dimension = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070893);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.z.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.z.setImageResource(R.drawable.obfuscated_res_0x7f08142b);
        this.w.addView(this.z, layoutParams);
    }
}
