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
import com.baidu.tieba.am1;
import com.baidu.tieba.as1;
import com.baidu.tieba.cp1;
import com.baidu.tieba.g63;
import com.baidu.tieba.j84;
import com.baidu.tieba.o53;
import com.baidu.tieba.ok3;
import com.baidu.tieba.p53;
import com.baidu.tieba.vv2;
/* loaded from: classes4.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements as1<NgWebView>, ok3 {
    public static final boolean B = am1.a;
    public ImageView A;
    public FrameLayout w;
    public View.OnClickListener x;
    public NetworkErrorView y;
    public ImageView z;

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void I0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void M0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void N0(SwanAppWebViewManager swanAppWebViewManager) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.yr1
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
            GameWebViewManager.this.g1();
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
            boolean z = !g63.h(str);
            if (!z && (g63.e(str) || g63.f(str))) {
                try {
                    Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
                    p53 c0 = p53.c0();
                    if (c0 != null) {
                        c0.w().startActivity(intent);
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
            if (!SwanAppNetworkUtils.i(GameWebViewManager.this.a) || !g63.h(GameWebViewManager.this.getWebView().getUrl())) {
                return;
            }
            GameWebViewManager.this.getWebView().reload();
            GameWebViewManager.this.y.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.as1
    public void F() {
        j84.a(this.w, vv2.a());
        j84.c(this);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void J0() {
        getWebView().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.tieba.as1
    public boolean c() {
        if (this.w.getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.ok3
    public void d() {
        l1();
        getWebView().onPause();
    }

    public final void f1() {
        W0(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.B) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !g63.h(str);
            }
        });
    }

    public final void g1() {
        if (this.z.getVisibility() == 0) {
            this.z.clearAnimation();
            this.z.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ok3
    public void k() {
        getWebView().onResume();
    }

    public final void k1() {
        FrameLayout frameLayout = new FrameLayout(this.a.getBaseContext());
        this.w = frameLayout;
        frameLayout.addView(getWebView(), -1, -1);
        h1();
        i1();
        j1();
    }

    public final void l1() {
        O0("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    public final void m1() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f01017b);
        this.z.setVisibility(0);
        this.z.startAnimation(loadAnimation);
    }

    @Override // com.baidu.tieba.ok3
    public void onViewDestroy() {
        destroy();
    }

    @Override // com.baidu.tieba.as1
    public void removeFromParent() {
        getWebView().stopLoading();
        getWebView().clearView();
        j84.d(this.w);
        j84.e(this);
    }

    public GameWebViewManager(Context context) {
        super(context);
        k1();
        f1();
        V0(new GameWebViewClient(this, null));
        n1(context);
    }

    @Override // com.baidu.tieba.as1
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

    @Override // com.baidu.tieba.as1
    public void h(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.yr1
    public void loadUrl(String str) {
        if (B) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (!g63.h(str)) {
            return;
        }
        m1();
        super.loadUrl(str);
    }

    public final void n1(Context context) {
        cp1 a2 = o53.K().x().a().a();
        if (a2 != null) {
            a2.a(context);
        }
    }

    public final void h1() {
        if (this.A != null) {
            return;
        }
        this.A = new ImageView(this.a.getBaseContext());
        Resources resources = this.a.getResources();
        int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0708bb);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.topMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0708bc);
        layoutParams.leftMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0708ba);
        this.A.setLayoutParams(layoutParams);
        this.A.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A.setImageResource(R.drawable.obfuscated_res_0x7f0814e0);
        this.A.setClickable(true);
        this.A.setOnClickListener(new a());
        this.w.addView(this.A);
    }

    public final void i1() {
        NetworkErrorView networkErrorView = new NetworkErrorView(this.a.getBaseContext());
        this.y = networkErrorView;
        networkErrorView.setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060432));
        getWebView().addView(this.y, -1, -1);
        this.y.setVisibility(8);
        b bVar = new b();
        this.y.setOnClickListener(bVar);
        this.y.setReloadClickListener(bVar);
    }

    public final void j1() {
        this.z = new ImageView(this.a.getBaseContext());
        int dimension = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0708bd);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.z.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.z.setImageResource(R.drawable.obfuscated_res_0x7f0814e1);
        this.w.addView(this.z, layoutParams);
    }
}
