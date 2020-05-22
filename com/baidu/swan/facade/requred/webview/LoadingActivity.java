package com.baidu.swan.facade.requred.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.s;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.facade.a;
/* loaded from: classes11.dex */
public class LoadingActivity extends Activity implements com.baidu.swan.apps.aq.e.b<i.a> {
    private static int cPt = 0;
    private TextView cMw;
    private LoadingProgressBar cPq;
    private TextView cPr;
    private LinearLayout cPs;
    private RelativeLayout mRootView;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = aj.releaseFixedOrientation(this);
        super.onCreate(bundle);
        aj.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.d.activity_loading);
        initViews();
        registerListener();
        hX(cPt);
        avN();
    }

    private void avN() {
        int safeGetIntExtra;
        Intent intent = getIntent();
        if (intent != null && (safeGetIntExtra = s.safeGetIntExtra(intent, "current", 0)) == 100) {
            hX(safeGetIntExtra);
            aj.c(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.finish();
                }
            }, 200L);
        }
    }

    private void initViews() {
        this.mRootView = (RelativeLayout) findViewById(a.c.rl_root);
        this.cPs = (LinearLayout) findViewById(a.c.ll_container);
        this.cPq = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.cMw = (TextView) findViewById(a.c.tv_progress);
        this.cPr = (TextView) findViewById(a.c.tv_hide);
        this.cPr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void hX(int i) {
        if (this.cPq != null && this.cMw != null && i > 0) {
            this.cPq.setProgress(i);
            this.cMw.setText(String.valueOf(i));
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        d.aoB().n(this);
    }

    private void unregisterListener() {
        d.aoB().o(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.aq.e.b
    /* renamed from: b */
    public void H(i.a aVar) {
        String str = aVar.id;
        if (TextUtils.equals(str, "loading_hide")) {
            finish();
        } else if (TextUtils.equals(str, "t7_loading")) {
            final long j = aVar.getLong("current");
            final long j2 = aVar.getLong("sum");
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    int i = (int) ((j / j2) * 100.0d);
                    int unused = LoadingActivity.cPt = i;
                    LoadingActivity.this.hX(i);
                }
            });
        }
    }
}
