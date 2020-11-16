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
    private TextView dEF;
    private LoadingProgressBar dII;
    private TextView dIJ;
    private e dIK = null;
    private final com.baidu.swan.apps.ap.e.b<e> dIL = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(e eVar) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.aOW();
                }
            });
        }
    };
    private final com.baidu.swan.apps.ap.e.b<e> dIM = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
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
        com.baidu.swan.apps.env.b.c cVar = com.baidu.swan.apps.env.b.c.cQT;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.dIK = cVar.nR(stringExtra);
        if (this.dIK == null || this.dIK.asU()) {
            finish();
            return;
        }
        this.dIK.k(this.dIL);
        this.dIK.j(this.dIM);
    }

    private void initViews() {
        this.dII = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.dEF = (TextView) findViewById(a.c.tv_progress);
        this.dIJ = (TextView) findViewById(a.c.tv_hide);
        this.dIJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void aOW() {
        d.b asP = this.dIK == null ? null : this.dIK.asP();
        if (asP != null && asP.valid()) {
            int min = (int) ((Math.min(Math.max(asP.current, 0L), asP.cRd) / asP.cRd) * 100.0d);
            if (this.dII != null && this.dEF != null && min > 0) {
                this.dII.setProgress(min);
                this.dEF.setText(String.valueOf(min));
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.dIK != null) {
            this.dIK.l(this.dIM).m(this.dIL);
        }
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        com.baidu.swan.apps.runtime.d.aGI().v(this);
    }

    private void unregisterListener() {
        com.baidu.swan.apps.runtime.d.aGI().w(this);
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
