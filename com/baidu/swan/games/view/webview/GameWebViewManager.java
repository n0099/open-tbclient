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
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
import com.baidu.tieba.R;
import com.baidu.tieba.dy2;
import com.baidu.tieba.ho1;
import com.baidu.tieba.hu1;
import com.baidu.tieba.jr1;
import com.baidu.tieba.o83;
import com.baidu.tieba.ra4;
import com.baidu.tieba.w73;
import com.baidu.tieba.wm3;
import com.baidu.tieba.x73;
/* loaded from: classes3.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements hu1<NgWebView>, wm3 {
    public static final boolean B = ho1.a;
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

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.fu1
    public String a() {
        return "SwanGameWebView";
    }

    /* loaded from: classes3.dex */
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
            boolean z = !o83.h(str);
            if (!z && (o83.e(str) || o83.f(str))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    x73 b0 = x73.b0();
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!SwanAppNetworkUtils.i(GameWebViewManager.this.a) || !o83.h(GameWebViewManager.this.s().getUrl())) {
                return;
            }
            GameWebViewManager.this.s().reload();
            GameWebViewManager.this.y.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.hu1
    public void H() {
        ra4.a(this.w, dy2.a());
        ra4.c(this);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void M0() {
        s().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
    }

    @Override // com.baidu.tieba.hu1
    public boolean c() {
        if (this.w.getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.wm3
    public void f() {
        o1();
        s().onPause();
    }

    public final void i1() {
        Z0(new BdSailorWebViewClientExt() { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
            @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
            public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                if (GameWebViewManager.B) {
                    Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                }
                return !o83.h(str);
            }
        });
    }

    public final void j1() {
        if (this.z.getVisibility() == 0) {
            this.z.clearAnimation();
            this.z.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.wm3
    public void l() {
        s().onResume();
    }

    public final void n1() {
        FrameLayout frameLayout = new FrameLayout(this.a.getBaseContext());
        this.w = frameLayout;
        frameLayout.addView(s(), -1, -1);
        k1();
        l1();
        m1();
    }

    public final void o1() {
        R0("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
    }

    @Override // com.baidu.tieba.wm3
    public void onViewDestroy() {
        destroy();
    }

    public final void p1() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010150);
        this.z.setVisibility(0);
        this.z.startAnimation(loadAnimation);
    }

    @Override // com.baidu.tieba.hu1
    public void removeFromParent() {
        s().stopLoading();
        s().clearView();
        ra4.d(this.w);
        ra4.e(this);
    }

    public GameWebViewManager(Context context) {
        super(context);
        n1();
        i1();
        Y0(new GameWebViewClient(this, null));
        q1(context);
    }

    @Override // com.baidu.tieba.hu1
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

    @Override // com.baidu.tieba.hu1
    public void i(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.fu1
    public void loadUrl(String str) {
        if (B) {
            Log.i("SwanGameWebViewManager", "loadUrl:" + str);
        }
        if (!o83.h(str)) {
            return;
        }
        p1();
        super.loadUrl(str);
    }

    public final void q1(Context context) {
        jr1 a2 = w73.K().x().a().a();
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
        int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f07073f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.topMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070740);
        layoutParams.leftMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f07073e);
        this.A.setLayoutParams(layoutParams);
        this.A.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A.setImageResource(R.drawable.obfuscated_res_0x7f0812bb);
        this.A.setClickable(true);
        this.A.setOnClickListener(new a());
        this.w.addView(this.A);
    }

    public final void l1() {
        NetworkErrorView networkErrorView = new NetworkErrorView(this.a.getBaseContext());
        this.y = networkErrorView;
        networkErrorView.setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060311));
        s().addView(this.y, -1, -1);
        this.y.setVisibility(8);
        b bVar = new b();
        this.y.setOnClickListener(bVar);
        this.y.setReloadClickListener(bVar);
    }

    public final void m1() {
        this.z = new ImageView(this.a.getBaseContext());
        int dimension = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070741);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        this.z.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.z.setImageResource(R.drawable.obfuscated_res_0x7f0812bc);
        this.w.addView(this.z, layoutParams);
    }
}
