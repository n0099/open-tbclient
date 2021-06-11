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
import d.a.l0.a.a2.i;
import d.a.l0.a.n0.k.d;
import d.a.l0.a.n0.k.e;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q0;
/* loaded from: classes3.dex */
public class LoadingActivity extends Activity implements d.a.l0.a.v2.e1.b<i.a> {
    public static final String EVENT_ID_HIDE = "loading_hide";
    public static final String EXT_SO_LIB_NAME = "so_lib_name";
    public static final String LOTTIE_ANIM_FIRST_NAME = "aiapps_so_download_anim_first.json";
    public static final String LOTTIE_ANIM_SECOND_NAME = "aiapps_so_download_anim_second.json";
    public static final String LOTTIE_ASSETS_PATH = "images/";
    public static final int PROGRESS_MAX = 100;
    public static final int PROGRESS_MIN = 0;
    public LottieAnimationView mFirstLottieAnimationView;
    public ImageView mLogoView;
    public TextView mProgressView;
    public LottieAnimationView mSecondLottieAnimationView;
    public SwanAppActionBar mSwanAppActionBar;
    public e mUpdating = null;
    public boolean mFirstAnimIsLoaded = false;
    public final d.a.l0.a.v2.e1.b<e> mProgressCallback = new a();
    public final d.a.l0.a.v2.e1.b<e> mFinishCallback = new b();

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<e> {

        /* renamed from: com.baidu.swan.facade.requred.webview.LoadingActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0160a implements Runnable {
            public RunnableC0160a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LoadingActivity.this.updateUiProgress();
            }
        }

        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            q0.b0(new RunnableC0160a());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<e> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
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
            LoadingActivity.this.startSecondAnim();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoadingActivity.this.finish();
        }
    }

    private void init() {
        this.mProgressView.setText(getString(d.a.l0.e.e.aiapps_loading_text, new Object[]{0}));
        Intent intent = getIntent();
        Bitmap d2 = d.a.l0.e.o.b.b.b().d();
        if (d2 == null) {
            this.mLogoView.setImageResource(d.a.l0.e.b.aiapps_so_download_logo);
        } else {
            this.mLogoView.setImageBitmap(d2);
        }
        String stringExtra = intent == null ? "" : intent.getStringExtra(EXT_SO_LIB_NAME);
        e j = d.a.l0.a.n0.k.c.f47321d.j(TextUtils.isEmpty(stringExtra) ? "" : stringExtra);
        this.mUpdating = j;
        if (j != null && !j.n()) {
            this.mUpdating.v(this.mProgressCallback);
            this.mUpdating.u(this.mFinishCallback);
            updateUiProgress();
            return;
        }
        finish();
    }

    private void initActionBar() {
        SwanAppActionBar swanAppActionBar = (SwanAppActionBar) findViewById(d.a.l0.e.c.ai_apps_title_bar);
        this.mSwanAppActionBar = swanAppActionBar;
        swanAppActionBar.f(-16777216, false);
        this.mSwanAppActionBar.setRightExitOnClickListener(new d());
    }

    private void initViews() {
        this.mProgressView = (TextView) findViewById(d.a.l0.e.c.aiapps_so_download_progress);
        this.mLogoView = (ImageView) findViewById(d.a.l0.e.c.aiapps_so_download_logo);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(d.a.l0.e.c.aiapps_so_download_lottie);
        this.mFirstLottieAnimationView = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder(LOTTIE_ASSETS_PATH);
        this.mFirstLottieAnimationView.setAnimation(LOTTIE_ANIM_FIRST_NAME);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(d.a.l0.e.c.aiapps_so_download_lottie2);
        this.mSecondLottieAnimationView = lottieAnimationView2;
        lottieAnimationView2.setImageAssetsFolder(LOTTIE_ASSETS_PATH);
        this.mSecondLottieAnimationView.setAnimation(LOTTIE_ANIM_SECOND_NAME);
        this.mSecondLottieAnimationView.setRepeatCount(-1);
        this.mSecondLottieAnimationView.setVisibility(4);
        this.mFirstLottieAnimationView.addAnimatorListener(new c());
        this.mFirstLottieAnimationView.playAnimation();
    }

    private void registerListener() {
        d.a.l0.a.a2.d.g().v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSecondAnim() {
        if (this.mFirstAnimIsLoaded) {
            return;
        }
        this.mFirstLottieAnimationView.cancelAnimation();
        this.mFirstLottieAnimationView.setVisibility(4);
        this.mSecondLottieAnimationView.setVisibility(0);
        this.mSecondLottieAnimationView.playAnimation();
        this.mFirstAnimIsLoaded = true;
    }

    private void unregisterListener() {
        d.a.l0.a.a2.d.g().p(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int Z = q0.Z(this);
        super.onCreate(bundle);
        q0.g(this, Z);
        setContentView(d.a.l0.e.d.activity_loading);
        initViews();
        initActionBar();
        n0.a(this);
        registerListener();
        init();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.mFirstLottieAnimationView.removeAllAnimatorListeners();
        this.mFirstLottieAnimationView.cancelAnimation();
        this.mSecondLottieAnimationView.cancelAnimation();
        e eVar = this.mUpdating;
        if (eVar != null) {
            eVar.g(this.mFinishCallback);
            eVar.h(this.mProgressCallback);
        }
        unregisterListener();
        super.onDestroy();
    }

    public void updateUiProgress() {
        e eVar = this.mUpdating;
        d.b m = eVar == null ? null : eVar.m();
        if (m == null || !m.a()) {
            return;
        }
        int min = (int) ((Math.min(Math.max(m.f47331a, 0L), m.f47332b) / m.f47332b) * 100.0d);
        TextView textView = this.mProgressView;
        if (textView == null || min <= 0) {
            return;
        }
        textView.setText(getString(d.a.l0.e.e.aiapps_loading_text, new Object[]{Integer.valueOf(min)}));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.v2.e1.b
    public void onCallback(i.a aVar) {
        if (TextUtils.equals(aVar.f44431f, EVENT_ID_HIDE)) {
            finish();
        }
    }
}
