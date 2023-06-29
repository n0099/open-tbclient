package com.baidu.swan.facade.requred.webview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.R;
import com.baidu.tieba.bc3;
import com.baidu.tieba.gc3;
import com.baidu.tieba.rl2;
import com.baidu.tieba.sl2;
import com.baidu.tieba.tl2;
import com.baidu.tieba.tp3;
import com.baidu.tieba.vq3;
import com.baidu.tieba.wp3;
import com.baidu.tieba.xy3;
/* loaded from: classes4.dex */
public class LoadingActivity extends Activity implements vq3<gc3.a> {
    public SwanAppActionBar a;
    public LottieAnimationView b;
    public LottieAnimationView c;
    public ImageView d;
    public TextView e;
    public tl2 f = null;
    public boolean g = false;
    public final vq3<tl2> h = new a();
    public final vq3<tl2> i = new b();

    /* loaded from: classes4.dex */
    public class a implements vq3<tl2> {

        /* renamed from: com.baidu.swan.facade.requred.webview.LoadingActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0217a implements Runnable {
            public RunnableC0217a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LoadingActivity.this.j();
            }
        }

        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(tl2 tl2Var) {
            wp3.e0(new RunnableC0217a());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements vq3<tl2> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(tl2 tl2Var) {
            LoadingActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            LoadingActivity.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            LoadingActivity.this.finish();
        }
    }

    public final void d() {
        SwanAppActionBar swanAppActionBar = (SwanAppActionBar) findViewById(R.id.obfuscated_res_0x7f09018f);
        this.a = swanAppActionBar;
        swanAppActionBar.f(-16777216, false);
        this.a.setRightExitOnClickListener(new d());
    }

    public final void g() {
        bc3.K().u(this);
    }

    public final void h() {
        if (this.g) {
            return;
        }
        this.b.cancelAnimation();
        this.b.setVisibility(4);
        this.c.setVisibility(0);
        this.c.playAnimation();
        this.g = true;
    }

    public final void i() {
        bc3.K().o(this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.b.removeAllAnimatorListeners();
        this.b.cancelAnimation();
        this.c.cancelAnimation();
        tl2 tl2Var = this.f;
        if (tl2Var != null) {
            tl2Var.g(this.i);
            tl2Var.h(this.h);
        }
        i();
        super.onDestroy();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vq3
    /* renamed from: f */
    public void a(gc3.a aVar) {
        if (TextUtils.equals(aVar.b, "loading_hide")) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = wp3.c0(this);
        super.onCreate(bundle);
        wp3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d0045);
        e();
        d();
        tp3.a(this);
        g();
        c();
    }

    public final void c() {
        String stringExtra;
        this.e.setText(getString(R.string.obfuscated_res_0x7f0f01c9, new Object[]{0}));
        Intent intent = getIntent();
        Bitmap d2 = xy3.b().d();
        if (d2 == null) {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f0801da);
        } else {
            this.d.setImageBitmap(d2);
        }
        String str = "";
        if (intent == null) {
            stringExtra = "";
        } else {
            stringExtra = intent.getStringExtra("so_lib_name");
        }
        rl2 rl2Var = rl2.d;
        if (!TextUtils.isEmpty(stringExtra)) {
            str = stringExtra;
        }
        tl2 j = rl2Var.j(str);
        this.f = j;
        if (j != null && !j.n()) {
            this.f.v(this.h);
            this.f.u(this.i);
            j();
            return;
        }
        finish();
    }

    public final void e() {
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0901ba);
        this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0901b7);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901b8);
        this.b = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder("swan-loading/images/");
        this.b.setAnimation("swan-loading/aiapps_so_download_anim_first.json");
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901b9);
        this.c = lottieAnimationView2;
        lottieAnimationView2.setImageAssetsFolder("swan-loading/images/");
        this.c.setAnimation("swan-loading/aiapps_so_download_anim_second.json");
        this.c.setRepeatCount(-1);
        this.c.setVisibility(4);
        this.b.addAnimatorListener(new c());
        this.b.playAnimation();
    }

    public void j() {
        sl2.b m;
        tl2 tl2Var = this.f;
        if (tl2Var == null) {
            m = null;
        } else {
            m = tl2Var.m();
        }
        if (m != null && m.a()) {
            int min = (int) ((Math.min(Math.max(m.a, 0L), m.b) / m.b) * 100.0d);
            TextView textView = this.e;
            if (textView != null && min > 0) {
                textView.setText(getString(R.string.obfuscated_res_0x7f0f01c9, new Object[]{Integer.valueOf(min)}));
            }
        }
    }
}
