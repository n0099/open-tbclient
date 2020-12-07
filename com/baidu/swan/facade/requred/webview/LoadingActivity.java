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
/* loaded from: classes8.dex */
public class LoadingActivity extends Activity implements com.baidu.swan.apps.ap.e.b<i.a> {
    private TextView dLD;
    private LoadingProgressBar dPG;
    private TextView dPH;
    private e dPI = null;
    private final com.baidu.swan.apps.ap.e.b<e> dPJ = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(e eVar) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.aSb();
                }
            });
        }
    };
    private final com.baidu.swan.apps.ap.e.b<e> dPK = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
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
        com.baidu.swan.apps.env.b.c cVar = com.baidu.swan.apps.env.b.c.cXM;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.dPI = cVar.oA(stringExtra);
        if (this.dPI == null || this.dPI.awc()) {
            finish();
            return;
        }
        this.dPI.k(this.dPJ);
        this.dPI.j(this.dPK);
    }

    private void initViews() {
        this.dPG = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.dLD = (TextView) findViewById(a.c.tv_progress);
        this.dPH = (TextView) findViewById(a.c.tv_hide);
        this.dPH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void aSb() {
        d.b avX = this.dPI == null ? null : this.dPI.avX();
        if (avX != null && avX.valid()) {
            int min = (int) ((Math.min(Math.max(avX.current, 0L), avX.cXW) / avX.cXW) * 100.0d);
            if (this.dPG != null && this.dLD != null && min > 0) {
                this.dPG.setProgress(min);
                this.dLD.setText(String.valueOf(min));
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.dPI != null) {
            this.dPI.l(this.dPK).m(this.dPJ);
        }
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        com.baidu.swan.apps.runtime.d.aJQ().v(this);
    }

    private void unregisterListener() {
        com.baidu.swan.apps.runtime.d.aJQ().w(this);
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
