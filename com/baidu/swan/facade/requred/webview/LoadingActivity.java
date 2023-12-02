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
import com.baidu.tieba.ag2;
import com.baidu.tieba.bg2;
import com.baidu.tieba.bk3;
import com.baidu.tieba.dl3;
import com.baidu.tieba.ek3;
import com.baidu.tieba.ft3;
import com.baidu.tieba.j63;
import com.baidu.tieba.o63;
import com.baidu.tieba.zf2;
/* loaded from: classes4.dex */
public class LoadingActivity extends Activity implements dl3<o63.a> {
    public SwanAppActionBar a;
    public LottieAnimationView b;
    public LottieAnimationView c;
    public ImageView d;
    public TextView e;
    public bg2 f = null;
    public boolean g = false;
    public final dl3<bg2> h = new a();
    public final dl3<bg2> i = new b();

    /* loaded from: classes4.dex */
    public class a implements dl3<bg2> {

        /* renamed from: com.baidu.swan.facade.requred.webview.LoadingActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0209a implements Runnable {
            public RunnableC0209a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LoadingActivity.this.j();
            }
        }

        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(bg2 bg2Var) {
            ek3.e0(new RunnableC0209a());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements dl3<bg2> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(bg2 bg2Var) {
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
        SwanAppActionBar swanAppActionBar = (SwanAppActionBar) findViewById(R.id.obfuscated_res_0x7f0901a2);
        this.a = swanAppActionBar;
        swanAppActionBar.f(-16777216, false);
        this.a.setRightExitOnClickListener(new d());
    }

    public final void g() {
        j63.K().u(this);
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
        j63.K().o(this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.b.removeAllAnimatorListeners();
        this.b.cancelAnimation();
        this.c.cancelAnimation();
        bg2 bg2Var = this.f;
        if (bg2Var != null) {
            bg2Var.g(this.i);
            bg2Var.h(this.h);
        }
        i();
        super.onDestroy();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dl3
    /* renamed from: f */
    public void a(o63.a aVar) {
        if (TextUtils.equals(aVar.b, "loading_hide")) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = ek3.c0(this);
        super.onCreate(bundle);
        ek3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d0047);
        e();
        d();
        bk3.a(this);
        g();
        c();
    }

    public final void c() {
        String stringExtra;
        this.e.setText(getString(R.string.obfuscated_res_0x7f0f01d4, new Object[]{0}));
        Intent intent = getIntent();
        Bitmap d2 = ft3.b().d();
        if (d2 == null) {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f0801e0);
        } else {
            this.d.setImageBitmap(d2);
        }
        String str = "";
        if (intent == null) {
            stringExtra = "";
        } else {
            stringExtra = intent.getStringExtra("so_lib_name");
        }
        zf2 zf2Var = zf2.d;
        if (!TextUtils.isEmpty(stringExtra)) {
            str = stringExtra;
        }
        bg2 j = zf2Var.j(str);
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
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0901e0);
        this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0901dd);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901de);
        this.b = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder("swan-loading/images/");
        this.b.setAnimation("swan-loading/aiapps_so_download_anim_first.json");
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901df);
        this.c = lottieAnimationView2;
        lottieAnimationView2.setImageAssetsFolder("swan-loading/images/");
        this.c.setAnimation("swan-loading/aiapps_so_download_anim_second.json");
        this.c.setRepeatCount(-1);
        this.c.setVisibility(4);
        this.b.addAnimatorListener(new c());
        this.b.playAnimation();
    }

    public void j() {
        ag2.b m;
        bg2 bg2Var = this.f;
        if (bg2Var == null) {
            m = null;
        } else {
            m = bg2Var.m();
        }
        if (m != null && m.a()) {
            int min = (int) ((Math.min(Math.max(m.a, 0L), m.b) / m.b) * 100.0d);
            TextView textView = this.e;
            if (textView != null && min > 0) {
                textView.setText(getString(R.string.obfuscated_res_0x7f0f01d4, new Object[]{Integer.valueOf(min)}));
            }
        }
    }
}
