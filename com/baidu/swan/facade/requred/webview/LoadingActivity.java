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
import com.baidu.tieba.b83;
import com.baidu.tieba.mh2;
import com.baidu.tieba.nh2;
import com.baidu.tieba.oh2;
import com.baidu.tieba.ol3;
import com.baidu.tieba.qm3;
import com.baidu.tieba.rl3;
import com.baidu.tieba.su3;
import com.baidu.tieba.w73;
/* loaded from: classes3.dex */
public class LoadingActivity extends Activity implements qm3<b83.a> {
    public SwanAppActionBar a;
    public LottieAnimationView b;
    public LottieAnimationView c;
    public ImageView d;
    public TextView e;
    public oh2 f = null;
    public boolean g = false;
    public final qm3<oh2> h = new a();
    public final qm3<oh2> i = new b();

    /* loaded from: classes3.dex */
    public class a implements qm3<oh2> {

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
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(oh2 oh2Var) {
            rl3.e0(new RunnableC0191a());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements qm3<oh2> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(oh2 oh2Var) {
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
        SwanAppActionBar swanAppActionBar = (SwanAppActionBar) findViewById(R.id.obfuscated_res_0x7f090182);
        this.a = swanAppActionBar;
        swanAppActionBar.f(-16777216, false);
        this.a.setRightExitOnClickListener(new d());
    }

    public final void g() {
        w73.K().u(this);
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
        w73.K().o(this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.b.removeAllAnimatorListeners();
        this.b.cancelAnimation();
        this.c.cancelAnimation();
        oh2 oh2Var = this.f;
        if (oh2Var != null) {
            oh2Var.g(this.i);
            oh2Var.h(this.h);
        }
        i();
        super.onDestroy();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qm3
    /* renamed from: f */
    public void a(b83.a aVar) {
        if (TextUtils.equals(aVar.b, "loading_hide")) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = rl3.c0(this);
        super.onCreate(bundle);
        rl3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d0043);
        e();
        d();
        ol3.a(this);
        g();
        c();
    }

    public final void c() {
        String stringExtra;
        this.e.setText(getString(R.string.obfuscated_res_0x7f0f019d, new Object[]{0}));
        Intent intent = getIntent();
        Bitmap d2 = su3.b().d();
        if (d2 == null) {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f0801c2);
        } else {
            this.d.setImageBitmap(d2);
        }
        String str = "";
        if (intent == null) {
            stringExtra = "";
        } else {
            stringExtra = intent.getStringExtra("so_lib_name");
        }
        mh2 mh2Var = mh2.d;
        if (!TextUtils.isEmpty(stringExtra)) {
            str = stringExtra;
        }
        oh2 j = mh2Var.j(str);
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
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0901ac);
        this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0901a9);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901aa);
        this.b = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder("swan-loading/images/");
        this.b.setAnimation("swan-loading/aiapps_so_download_anim_first.json");
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901ab);
        this.c = lottieAnimationView2;
        lottieAnimationView2.setImageAssetsFolder("swan-loading/images/");
        this.c.setAnimation("swan-loading/aiapps_so_download_anim_second.json");
        this.c.setRepeatCount(-1);
        this.c.setVisibility(4);
        this.b.addAnimatorListener(new c());
        this.b.playAnimation();
    }

    public void j() {
        nh2.b m;
        oh2 oh2Var = this.f;
        if (oh2Var == null) {
            m = null;
        } else {
            m = oh2Var.m();
        }
        if (m != null && m.a()) {
            int min = (int) ((Math.min(Math.max(m.a, 0L), m.b) / m.b) * 100.0d);
            TextView textView = this.e;
            if (textView != null && min > 0) {
                textView.setText(getString(R.string.obfuscated_res_0x7f0f019d, new Object[]{Integer.valueOf(min)}));
            }
        }
    }
}
