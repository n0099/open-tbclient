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
    private TextView drV;
    private LoadingProgressBar dwb;
    private TextView dwc;
    private e dwd = null;
    private final com.baidu.swan.apps.ap.e.b<e> dwe = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(e eVar) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.aLk();
                }
            });
        }
    };
    private final com.baidu.swan.apps.ap.e.b<e> dwf = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
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
        com.baidu.swan.apps.env.b.c cVar = com.baidu.swan.apps.env.b.c.cEo;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.dwd = cVar.nq(stringExtra);
        if (this.dwd == null || this.dwd.apg()) {
            finish();
            return;
        }
        this.dwd.k(this.dwe);
        this.dwd.j(this.dwf);
    }

    private void initViews() {
        this.dwb = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.drV = (TextView) findViewById(a.c.tv_progress);
        this.dwc = (TextView) findViewById(a.c.tv_hide);
        this.dwc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void aLk() {
        d.b apb = this.dwd == null ? null : this.dwd.apb();
        if (apb != null && apb.valid()) {
            int min = (int) ((Math.min(Math.max(apb.current, 0L), apb.cEy) / apb.cEy) * 100.0d);
            if (this.dwb != null && this.drV != null && min > 0) {
                this.dwb.setProgress(min);
                this.drV.setText(String.valueOf(min));
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.dwd != null) {
            this.dwd.l(this.dwf).m(this.dwe);
        }
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        com.baidu.swan.apps.runtime.d.aCW().v(this);
    }

    private void unregisterListener() {
        com.baidu.swan.apps.runtime.d.aCW().w(this);
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
