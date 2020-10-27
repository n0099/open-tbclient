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
    private TextView dAu;
    private e dEA = null;
    private final com.baidu.swan.apps.ap.e.b<e> dEB = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(e eVar) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.aNe();
                }
            });
        }
    };
    private final com.baidu.swan.apps.ap.e.b<e> dEC = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(e eVar) {
            LoadingActivity.this.finish();
        }
    };
    private LoadingProgressBar dEy;
    private TextView dEz;

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
        com.baidu.swan.apps.env.b.c cVar = com.baidu.swan.apps.env.b.c.cMK;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.dEA = cVar.nJ(stringExtra);
        if (this.dEA == null || this.dEA.arb()) {
            finish();
            return;
        }
        this.dEA.k(this.dEB);
        this.dEA.j(this.dEC);
    }

    private void initViews() {
        this.dEy = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.dAu = (TextView) findViewById(a.c.tv_progress);
        this.dEz = (TextView) findViewById(a.c.tv_hide);
        this.dEz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void aNe() {
        d.b aqW = this.dEA == null ? null : this.dEA.aqW();
        if (aqW != null && aqW.valid()) {
            int min = (int) ((Math.min(Math.max(aqW.current, 0L), aqW.cMU) / aqW.cMU) * 100.0d);
            if (this.dEy != null && this.dAu != null && min > 0) {
                this.dEy.setProgress(min);
                this.dAu.setText(String.valueOf(min));
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.dEA != null) {
            this.dEA.l(this.dEC).m(this.dEB);
        }
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        com.baidu.swan.apps.runtime.d.aEQ().v(this);
    }

    private void unregisterListener() {
        com.baidu.swan.apps.runtime.d.aEQ().w(this);
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
