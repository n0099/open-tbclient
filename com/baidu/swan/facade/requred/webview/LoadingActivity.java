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
/* loaded from: classes3.dex */
public class LoadingActivity extends Activity implements com.baidu.swan.apps.ap.e.b<i.a> {
    private TextView dfO;
    private LoadingProgressBar djV;
    private TextView djW;
    private e djX = null;
    private final com.baidu.swan.apps.ap.e.b<e> djY = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void J(e eVar) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.aIB();
                }
            });
        }
    };
    private final com.baidu.swan.apps.ap.e.b<e> djZ = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void J(e eVar) {
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
        com.baidu.swan.apps.env.b.c cVar = com.baidu.swan.apps.env.b.c.csd;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.djX = cVar.mE(stringExtra);
        if (this.djX == null || this.djX.amv()) {
            finish();
            return;
        }
        this.djX.k(this.djY);
        this.djX.j(this.djZ);
    }

    private void initViews() {
        this.djV = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.dfO = (TextView) findViewById(a.c.tv_progress);
        this.djW = (TextView) findViewById(a.c.tv_hide);
        this.djW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void aIB() {
        d.b amq = this.djX == null ? null : this.djX.amq();
        if (amq != null && amq.valid()) {
            int min = (int) ((Math.min(Math.max(amq.current, 0L), amq.csn) / amq.csn) * 100.0d);
            if (this.djV != null && this.dfO != null && min > 0) {
                this.djV.setProgress(min);
                this.dfO.setText(String.valueOf(min));
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.djX != null) {
            this.djX.l(this.djZ).m(this.djY);
        }
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        com.baidu.swan.apps.runtime.d.aAn().v(this);
    }

    private void unregisterListener() {
        com.baidu.swan.apps.runtime.d.aAn().w(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: b */
    public void J(i.a aVar) {
        if (TextUtils.equals(aVar.id, "loading_hide")) {
            finish();
        }
    }
}
