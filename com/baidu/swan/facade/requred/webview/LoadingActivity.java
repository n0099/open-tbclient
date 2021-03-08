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
    private TextView dTs;
    private LoadingProgressBar dXx;
    private TextView dXy;
    private e dXz = null;
    private final com.baidu.swan.apps.ao.e.b<e> dXA = new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void N(e eVar) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.aQY();
                }
            });
        }
    };
    private final com.baidu.swan.apps.ao.e.b<e> dXB = new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void N(e eVar) {
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
        com.baidu.swan.apps.env.b.c cVar = com.baidu.swan.apps.env.b.c.dbF;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.dXz = cVar.nF(stringExtra);
        if (this.dXz == null || this.dXz.auc()) {
            finish();
            return;
        }
        this.dXz.k(this.dXA);
        this.dXz.j(this.dXB);
    }

    private void initViews() {
        this.dXx = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.dTs = (TextView) findViewById(a.c.tv_progress);
        this.dXy = (TextView) findViewById(a.c.tv_hide);
        this.dXy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void aQY() {
        d.b atX = this.dXz == null ? null : this.dXz.atX();
        if (atX != null && atX.valid()) {
            int min = (int) ((Math.min(Math.max(atX.current, 0L), atX.dbP) / atX.dbP) * 100.0d);
            if (this.dXx != null && this.dTs != null && min > 0) {
                this.dXx.setProgress(min);
                this.dTs.setText(String.valueOf(min));
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.dXz != null) {
            this.dXz.l(this.dXB).m(this.dXA);
        }
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        com.baidu.swan.apps.runtime.d.aIJ().v(this);
    }

    private void unregisterListener() {
        com.baidu.swan.apps.runtime.d.aIJ().w(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: b */
    public void N(i.a aVar) {
        if (TextUtils.equals(aVar.id, "loading_hide")) {
            finish();
        }
    }
}
