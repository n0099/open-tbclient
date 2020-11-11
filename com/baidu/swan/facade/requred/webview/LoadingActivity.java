package com.baidu.swan.facade.requred.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.env.b.d;
import com.baidu.swan.apps.env.b.e;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.facade.a;
/* loaded from: classes16.dex */
public class LoadingActivity extends Activity implements com.baidu.swan.apps.ap.e.b<i.a> {
    private TextView dGm;
    private LoadingProgressBar dKq;
    private TextView dKr;
    private e dKs = null;
    private final com.baidu.swan.apps.ap.e.b<e> dKt = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(e eVar) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.aPE();
                }
            });
        }
    };
    private final com.baidu.swan.apps.ap.e.b<e> dKu = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(e eVar) {
            LoadingActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.d.activity_loading);
        initViews();
        registerListener();
        init();
    }

    private void init() {
        Intent intent = getIntent();
        String stringExtra = intent == null ? "" : intent.getStringExtra("so_lib_name");
        com.baidu.swan.apps.env.b.c cVar = com.baidu.swan.apps.env.b.c.cSD;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.dKs = cVar.nX(stringExtra);
        if (this.dKs == null || this.dKs.atC()) {
            finish();
            return;
        }
        this.dKs.k(this.dKt);
        this.dKs.j(this.dKu);
    }

    private void initViews() {
        this.dKq = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.dGm = (TextView) findViewById(a.c.tv_progress);
        this.dKr = (TextView) findViewById(a.c.tv_hide);
        this.dKr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void aPE() {
        d.b atx = this.dKs == null ? null : this.dKs.atx();
        if (atx != null && atx.valid()) {
            int min = (int) ((Math.min(Math.max(atx.current, 0L), atx.cSN) / atx.cSN) * 100.0d);
            if (this.dKq != null && this.dGm != null && min > 0) {
                this.dKq.setProgress(min);
                this.dGm.setText(String.valueOf(min));
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.dKs != null) {
            this.dKs.l(this.dKu).m(this.dKt);
        }
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        com.baidu.swan.apps.runtime.d.aHq().v(this);
    }

    private void unregisterListener() {
        com.baidu.swan.apps.runtime.d.aHq().w(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: b */
    public void M(i.a aVar) {
        if (TextUtils.equals(aVar.id, "loading_hide")) {
            finish();
        }
    }
}
