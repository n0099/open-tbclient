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
    private TextView ddJ;
    private LoadingProgressBar dhO;
    private TextView dhP;
    private e dhQ = null;
    private final com.baidu.swan.apps.ap.e.b<e> dhR = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
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
    private final com.baidu.swan.apps.ap.e.b<e> dhS = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
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
        com.baidu.swan.apps.env.b.c cVar = com.baidu.swan.apps.env.b.c.cpW;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.dhQ = cVar.mk(stringExtra);
        if (this.dhQ == null || this.dhQ.alL()) {
            finish();
            return;
        }
        this.dhQ.k(this.dhR);
        this.dhQ.j(this.dhS);
    }

    private void initViews() {
        this.dhO = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.ddJ = (TextView) findViewById(a.c.tv_progress);
        this.dhP = (TextView) findViewById(a.c.tv_hide);
        this.dhP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void aHR() {
        d.b alG = this.dhQ == null ? null : this.dhQ.alG();
        if (alG != null && alG.valid()) {
            int min = (int) ((Math.min(Math.max(alG.current, 0L), alG.cqg) / alG.cqg) * 100.0d);
            if (this.dhO != null && this.ddJ != null && min > 0) {
                this.dhO.setProgress(min);
                this.ddJ.setText(String.valueOf(min));
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.dhQ != null) {
            this.dhQ.l(this.dhS).m(this.dhR);
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
