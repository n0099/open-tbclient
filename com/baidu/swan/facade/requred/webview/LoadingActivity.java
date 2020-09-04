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
/* loaded from: classes20.dex */
public class LoadingActivity extends Activity implements com.baidu.swan.apps.ap.e.b<i.a> {
    private TextView ddN;
    private LoadingProgressBar dhS;
    private TextView dhT;
    private e dhU = null;
    private final com.baidu.swan.apps.ap.e.b<e> dhV = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void I(e eVar) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.aHR();
                }
            });
        }
    };
    private final com.baidu.swan.apps.ap.e.b<e> dhW = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void I(e eVar) {
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
        com.baidu.swan.apps.env.b.c cVar = com.baidu.swan.apps.env.b.c.cqa;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.dhU = cVar.ml(stringExtra);
        if (this.dhU == null || this.dhU.alL()) {
            finish();
            return;
        }
        this.dhU.k(this.dhV);
        this.dhU.j(this.dhW);
    }

    private void initViews() {
        this.dhS = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.ddN = (TextView) findViewById(a.c.tv_progress);
        this.dhT = (TextView) findViewById(a.c.tv_hide);
        this.dhT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void aHR() {
        d.b alG = this.dhU == null ? null : this.dhU.alG();
        if (alG != null && alG.valid()) {
            int min = (int) ((Math.min(Math.max(alG.current, 0L), alG.cqk) / alG.cqk) * 100.0d);
            if (this.dhS != null && this.ddN != null && min > 0) {
                this.dhS.setProgress(min);
                this.ddN.setText(String.valueOf(min));
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.dhU != null) {
            this.dhU.l(this.dhW).m(this.dhV);
        }
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        com.baidu.swan.apps.runtime.d.azE().v(this);
    }

    private void unregisterListener() {
        com.baidu.swan.apps.runtime.d.azE().w(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: b */
    public void I(i.a aVar) {
        if (TextUtils.equals(aVar.id, "loading_hide")) {
            finish();
        }
    }
}
