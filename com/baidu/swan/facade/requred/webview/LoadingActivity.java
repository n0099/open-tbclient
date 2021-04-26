package com.baidu.swan.facade.requred.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import d.a.h0.a.i2.k0;
import d.a.h0.a.j0.i.d;
import d.a.h0.a.j0.i.e;
import d.a.h0.a.r1.d;
import d.a.h0.a.r1.i;
/* loaded from: classes3.dex */
public class LoadingActivity extends Activity implements d.a.h0.a.i2.u0.b<i.a> {
    public static final String EVENT_ID_HIDE = "loading_hide";
    public static final String EXT_SO_LIB_NAME = "so_lib_name";
    public TextView mHideButton;
    public LoadingProgressBar mLoadingProgressBar;
    public TextView mProgressView;
    public e mUpdating = null;
    public final d.a.h0.a.i2.u0.b<e> mProgressCallback = new a();
    public final d.a.h0.a.i2.u0.b<e> mFinishCallback = new b();

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<e> {

        /* renamed from: com.baidu.swan.facade.requred.webview.LoadingActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0172a implements Runnable {
            public RunnableC0172a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LoadingActivity.this.updateUiProgress();
            }
        }

        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            k0.X(new RunnableC0172a());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<e> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            LoadingActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoadingActivity.this.finish();
        }
    }

    private void init() {
        Intent intent = getIntent();
        String stringExtra = intent == null ? "" : intent.getStringExtra(EXT_SO_LIB_NAME);
        e i2 = d.a.h0.a.j0.i.c.f42874d.i(TextUtils.isEmpty(stringExtra) ? "" : stringExtra);
        this.mUpdating = i2;
        if (i2 != null && !i2.n()) {
            this.mUpdating.v(this.mProgressCallback);
            this.mUpdating.u(this.mFinishCallback);
            return;
        }
        finish();
    }

    private void initViews() {
        this.mLoadingProgressBar = (LoadingProgressBar) findViewById(d.a.h0.d.c.pb_loading_progressbar);
        this.mProgressView = (TextView) findViewById(d.a.h0.d.c.tv_progress);
        TextView textView = (TextView) findViewById(d.a.h0.d.c.tv_hide);
        this.mHideButton = textView;
        textView.setOnClickListener(new c());
    }

    private void registerListener() {
        d.e().t(this);
    }

    private void unregisterListener() {
        d.e().n(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int V = k0.V(this);
        super.onCreate(bundle);
        k0.h(this, V);
        setContentView(d.a.h0.d.d.activity_loading);
        initViews();
        registerListener();
        init();
    }

    @Override // android.app.Activity
    public void onDestroy() {
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
        int min = (int) ((Math.min(Math.max(m.f42884a, 0L), m.f42885b) / m.f42885b) * 100.0d);
        LoadingProgressBar loadingProgressBar = this.mLoadingProgressBar;
        if (loadingProgressBar == null || this.mProgressView == null || min <= 0) {
            return;
        }
        loadingProgressBar.setProgress(min);
        this.mProgressView.setText(String.valueOf(min));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.i2.u0.b
    public void onCallback(i.a aVar) {
        if (TextUtils.equals(aVar.f43829g, EVENT_ID_HIDE)) {
            finish();
        }
    }
}
