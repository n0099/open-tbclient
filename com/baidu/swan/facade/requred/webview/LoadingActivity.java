package com.baidu.swan.facade.requred.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.u;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.facade.a;
/* loaded from: classes4.dex */
public class LoadingActivity extends Activity implements com.baidu.swan.apps.aq.e.b<i.a> {
    private static int cYG = 0;
    private TextView cUH;
    private LoadingProgressBar cYD;
    private TextView cYE;
    private LinearLayout cYF;
    private RelativeLayout mRootView;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = al.releaseFixedOrientation(this);
        super.onCreate(bundle);
        al.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.d.activity_loading);
        initViews();
        registerListener();
        iy(cYG);
        azH();
    }

    private void azH() {
        int safeGetIntExtra;
        Intent intent = getIntent();
        if (intent != null && (safeGetIntExtra = u.safeGetIntExtra(intent, "current", 0)) == 100) {
            iy(safeGetIntExtra);
            al.c(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.finish();
                }
            }, 200L);
        }
    }

    private void initViews() {
        this.mRootView = (RelativeLayout) findViewById(a.c.rl_root);
        this.cYF = (LinearLayout) findViewById(a.c.ll_container);
        this.cYD = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.cUH = (TextView) findViewById(a.c.tv_progress);
        this.cYE = (TextView) findViewById(a.c.tv_hide);
        this.cYE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void iy(int i) {
        if (this.cYD != null && this.cUH != null && i > 0) {
            this.cYD.setProgress(i);
            this.cUH.setText(String.valueOf(i));
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        d.arr().o(this);
    }

    private void unregisterListener() {
        d.arr().p(this);
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
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    int i = (int) ((j / j2) * 100.0d);
                    int unused = LoadingActivity.cYG = i;
                    LoadingActivity.this.iy(i);
                }
            });
        }
    }
}
