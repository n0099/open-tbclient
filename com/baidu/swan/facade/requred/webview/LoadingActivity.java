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
import com.baidu.tieba.ih2;
import com.baidu.tieba.jh2;
import com.baidu.tieba.kh2;
import com.baidu.tieba.kl3;
import com.baidu.tieba.mm3;
import com.baidu.tieba.nl3;
import com.baidu.tieba.ou3;
import com.baidu.tieba.s73;
import com.baidu.tieba.x73;
/* loaded from: classes3.dex */
public class LoadingActivity extends Activity implements mm3<x73.a> {
    public SwanAppActionBar a;
    public LottieAnimationView b;
    public LottieAnimationView c;
    public ImageView d;
    public TextView e;
    public kh2 f = null;
    public boolean g = false;
    public final mm3<kh2> h = new a();
    public final mm3<kh2> i = new b();

    /* loaded from: classes3.dex */
    public class a implements mm3<kh2> {

        /* renamed from: com.baidu.swan.facade.requred.webview.LoadingActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0191a implements Runnable {
            public RunnableC0191a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LoadingActivity.this.j();
            }
        }

        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(kh2 kh2Var) {
            nl3.e0(new RunnableC0191a());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements mm3<kh2> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(kh2 kh2Var) {
            LoadingActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            LoadingActivity.this.h();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            LoadingActivity.this.finish();
        }
    }

    public final void d() {
        SwanAppActionBar swanAppActionBar = (SwanAppActionBar) findViewById(R.id.obfuscated_res_0x7f090185);
        this.a = swanAppActionBar;
        swanAppActionBar.f(-16777216, false);
        this.a.setRightExitOnClickListener(new d());
    }

    public final void g() {
        s73.K().u(this);
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
        s73.K().o(this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.b.removeAllAnimatorListeners();
        this.b.cancelAnimation();
        this.c.cancelAnimation();
        kh2 kh2Var = this.f;
        if (kh2Var != null) {
            kh2Var.g(this.i);
            kh2Var.h(this.h);
        }
        i();
        super.onDestroy();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mm3
    /* renamed from: f */
    public void a(x73.a aVar) {
        if (TextUtils.equals(aVar.b, "loading_hide")) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = nl3.c0(this);
        super.onCreate(bundle);
        nl3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d0043);
        e();
        d();
        kl3.a(this);
        g();
        c();
    }

    public final void c() {
        String stringExtra;
        this.e.setText(getString(R.string.obfuscated_res_0x7f0f019f, new Object[]{0}));
        Intent intent = getIntent();
        Bitmap d2 = ou3.b().d();
        if (d2 == null) {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f0801c1);
        } else {
            this.d.setImageBitmap(d2);
        }
        String str = "";
        if (intent == null) {
            stringExtra = "";
        } else {
            stringExtra = intent.getStringExtra("so_lib_name");
        }
        ih2 ih2Var = ih2.d;
        if (!TextUtils.isEmpty(stringExtra)) {
            str = stringExtra;
        }
        kh2 j = ih2Var.j(str);
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
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0901af);
        this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0901ac);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901ad);
        this.b = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder("swan-loading/images/");
        this.b.setAnimation("swan-loading/aiapps_so_download_anim_first.json");
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901ae);
        this.c = lottieAnimationView2;
        lottieAnimationView2.setImageAssetsFolder("swan-loading/images/");
        this.c.setAnimation("swan-loading/aiapps_so_download_anim_second.json");
        this.c.setRepeatCount(-1);
        this.c.setVisibility(4);
        this.b.addAnimatorListener(new c());
        this.b.playAnimation();
    }

    public void j() {
        jh2.b m;
        kh2 kh2Var = this.f;
        if (kh2Var == null) {
            m = null;
        } else {
            m = kh2Var.m();
        }
        if (m != null && m.a()) {
            int min = (int) ((Math.min(Math.max(m.a, 0L), m.b) / m.b) * 100.0d);
            TextView textView = this.e;
            if (textView != null && min > 0) {
                textView.setText(getString(R.string.obfuscated_res_0x7f0f019f, new Object[]{Integer.valueOf(min)}));
            }
        }
    }
}
