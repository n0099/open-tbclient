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
import com.baidu.tieba.ae4;
import com.baidu.tieba.fb3;
import com.baidu.tieba.fq3;
import com.baidu.tieba.gb3;
import com.baidu.tieba.m13;
import com.baidu.tieba.qr1;
import com.baidu.tieba.qx1;
import com.baidu.tieba.su1;
import com.baidu.tieba.xb3;
/* loaded from: classes4.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements qx1<NgWebView>, fq3 {
    public static final boolean B = qr1.a;
    public ImageView A;
    public FrameLayout w;
    public View.OnClickListener x;
    public NetworkErrorView y;
    public ImageView z;

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void J0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void N0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void O0(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.ox1
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
            GameWebViewManager.this.h1();
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
            boolean z = !xb3.h(str);
            if (!z && (xb3.e(str) || xb3.f(str))) {
                try {
                    Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
                    gb3 b0 = gb3.b0();
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
            if (!SwanAppNetworkUtils.i(GameWebViewManager.this.a) || !xb3.h(GameWebViewManager.this.r().getUrl())) {
                return;
            }
            GameWebViewManager.this.r().reload();
            GameWebViewManager.this.y.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.qx1
    public void G() {
        ae4.a(this.w, m13.a());
        ae4.c(this);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void K0() {
        r().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.tieba.qx1
    public boolean c() {
        if (this.w.getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.fq3
    public void d() {
        m1();
        r().onPause();
    }

    public final void g1() {
        X0(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.B) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !xb3.h(str);
            }
        });
    }

    public final void h1() {
        if (this.z.getVisibility() == 0) {
            this.z.clearAnimation();
            this.z.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.fq3
    public void k() {
        r().onResume();
    }

    public final void l1() {
        FrameLayout frameLayout = new FrameLayout(this.a.getBaseContext());
        this.w = frameLayout;
        frameLayout.addView(r(), -1, -1);
        i1();
        j1();
        k1();
    }

    public final void m1() {
        P0("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    public final void n1() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f01017c);
        this.z.setVisibility(0);
        this.z.startAnimation(loadAnimation);
    }

    @Override // com.baidu.tieba.fq3
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.tieba.qx1
    public void removeFromParent() {
        r().stopLoading();
        r().clearView();
        ae4.d(this.w);
        ae4.e(this);
    }

    public GameWebViewManager(Context context) {
        super(context);
        l1();
        g1();
        W0(new GameWebViewClient(this, null));
        o1(context);
    }

    @Override // com.baidu.tieba.qx1
    public void f(boolean z) {
        ImageView imageView = this.A;
        if (imageView != null) {
            if (z) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.qx1
    public void h(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.ox1
    public void loadUrl(String str) {
        if (B) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (!xb3.h(str)) {
            return;
        }
        n1();
        super.loadUrl(str);
    }

    public final void o1(Context context) {
        su1 a2 = fb3.K().x().a().a();
        if (a2 != null) {
            a2.a(context);
        }
    }

    public final void i1() {
        if (this.A != null) {
            return;
        }
        this.A = new ImageView(this.a.getBaseContext());
        Resources resources = this.a.getResources();
        int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0708c0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.topMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0708c1);
        layoutParams.leftMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0708bf);
        this.A.setLayoutParams(layoutParams);
        this.A.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A.setImageResource(R.drawable.obfuscated_res_0x7f0814e3);
        this.A.setClickable(true);
        this.A.setOnClickListener(new a());
        this.w.addView(this.A);
    }

    public final void j1() {
        NetworkErrorView networkErrorView = new NetworkErrorView(this.a.getBaseContext());
        this.y = networkErrorView;
        networkErrorView.setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060432));
        r().addView(this.y, -1, -1);
        this.y.setVisibility(8);
        b bVar = new b();
        this.y.setOnClickListener(bVar);
        this.y.setReloadClickListener(bVar);
    }

    public final void k1() {
        this.z = new ImageView(this.a.getBaseContext());
        int dimension = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0708c2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.z.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.z.setImageResource(R.drawable.obfuscated_res_0x7f0814e4);
        this.w.addView(this.z, layoutParams);
    }
}
