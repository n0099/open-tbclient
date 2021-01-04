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
    private TextView dUx;
    private LoadingProgressBar dYC;
    private TextView dYD;
    private e dYE = null;
    private final com.baidu.swan.apps.ao.e.b<e> dYF = new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(e eVar) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.aUv();
                }
            });
        }
    };
    private final com.baidu.swan.apps.ao.e.b<e> dYG = new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
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
        com.baidu.swan.apps.env.b.c cVar = com.baidu.swan.apps.env.b.c.dcH;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.dYE = cVar.ot(stringExtra);
        if (this.dYE == null || this.dYE.axu()) {
            finish();
            return;
        }
        this.dYE.k(this.dYF);
        this.dYE.j(this.dYG);
    }

    private void initViews() {
        this.dYC = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.dUx = (TextView) findViewById(a.c.tv_progress);
        this.dYD = (TextView) findViewById(a.c.tv_hide);
        this.dYD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void aUv() {
        d.b axp = this.dYE == null ? null : this.dYE.axp();
        if (axp != null && axp.valid()) {
            int min = (int) ((Math.min(Math.max(axp.current, 0L), axp.dcR) / axp.dcR) * 100.0d);
            if (this.dYC != null && this.dUx != null && min > 0) {
                this.dYC.setProgress(min);
                this.dUx.setText(String.valueOf(min));
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.dYE != null) {
            this.dYE.l(this.dYG).m(this.dYF);
        }
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        com.baidu.swan.apps.runtime.d.aMg().v(this);
    }

    private void unregisterListener() {
        com.baidu.swan.apps.runtime.d.aMg().w(this);
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
