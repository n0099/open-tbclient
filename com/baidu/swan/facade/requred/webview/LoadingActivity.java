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
/* loaded from: classes3.dex */
public class LoadingActivity extends Activity implements com.baidu.swan.apps.ao.e.b<i.a> {
    private TextView dRR;
    private LoadingProgressBar dVW;
    private TextView dVX;
    private e dVY = null;
    private final com.baidu.swan.apps.ao.e.b<e> dVZ = new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(e eVar) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.aQV();
                }
            });
        }
    };
    private final com.baidu.swan.apps.ao.e.b<e> dWa = new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
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
        com.baidu.swan.apps.env.b.c cVar = com.baidu.swan.apps.env.b.c.dac;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.dVY = cVar.ny(stringExtra);
        if (this.dVY == null || this.dVY.atZ()) {
            finish();
            return;
        }
        this.dVY.k(this.dVZ);
        this.dVY.j(this.dWa);
    }

    private void initViews() {
        this.dVW = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.dRR = (TextView) findViewById(a.c.tv_progress);
        this.dVX = (TextView) findViewById(a.c.tv_hide);
        this.dVX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void aQV() {
        d.b atU = this.dVY == null ? null : this.dVY.atU();
        if (atU != null && atU.valid()) {
            int min = (int) ((Math.min(Math.max(atU.current, 0L), atU.dam) / atU.dam) * 100.0d);
            if (this.dVW != null && this.dRR != null && min > 0) {
                this.dVW.setProgress(min);
                this.dRR.setText(String.valueOf(min));
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.dVY != null) {
            this.dVY.l(this.dWa).m(this.dVZ);
        }
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        com.baidu.swan.apps.runtime.d.aIG().v(this);
    }

    private void unregisterListener() {
        com.baidu.swan.apps.runtime.d.aIG().w(this);
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
