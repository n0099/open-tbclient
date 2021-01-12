package com.baidu.swan.facade.requred.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.env.b.d;
import com.baidu.swan.apps.env.b.e;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.facade.a;
/* loaded from: classes6.dex */
public class LoadingActivity extends Activity implements com.baidu.swan.apps.ao.e.b<i.a> {
    private TextView dPL;
    private LoadingProgressBar dTQ;
    private TextView dTR;
    private e dTS = null;
    private final com.baidu.swan.apps.ao.e.b<e> dTT = new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(e eVar) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.aQC();
                }
            });
        }
    };
    private final com.baidu.swan.apps.ao.e.b<e> dTU = new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(e eVar) {
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
        com.baidu.swan.apps.env.b.c cVar = com.baidu.swan.apps.env.b.c.cXS;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.dTS = cVar.ng(stringExtra);
        if (this.dTS == null || this.dTS.atB()) {
            finish();
            return;
        }
        this.dTS.k(this.dTT);
        this.dTS.j(this.dTU);
    }

    private void initViews() {
        this.dTQ = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.dPL = (TextView) findViewById(a.c.tv_progress);
        this.dTR = (TextView) findViewById(a.c.tv_hide);
        this.dTR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void aQC() {
        d.b atw = this.dTS == null ? null : this.dTS.atw();
        if (atw != null && atw.valid()) {
            int min = (int) ((Math.min(Math.max(atw.current, 0L), atw.cYc) / atw.cYc) * 100.0d);
            if (this.dTQ != null && this.dPL != null && min > 0) {
                this.dTQ.setProgress(min);
                this.dPL.setText(String.valueOf(min));
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.dTS != null) {
            this.dTS.l(this.dTU).m(this.dTT);
        }
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        com.baidu.swan.apps.runtime.d.aIn().v(this);
    }

    private void unregisterListener() {
        com.baidu.swan.apps.runtime.d.aIn().w(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: b */
    public void L(i.a aVar) {
        if (TextUtils.equals(aVar.id, "loading_hide")) {
            finish();
        }
    }
}
