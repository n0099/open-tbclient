package com.baidu.swan.facade.requred.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.facade.a;
/* loaded from: classes11.dex */
public class LoadingActivity extends Activity implements com.baidu.swan.apps.as.d.b<i.a> {
    private static int cfS = 0;
    private TextView cah;
    private LoadingProgressBar cfP;
    private TextView cfQ;
    private LinearLayout cfR;
    private RelativeLayout mRootView;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ai.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.d.activity_loading);
        initViews();
        registerListener();
        hz(cfS);
        ajS();
    }

    private void ajS() {
        int safeGetIntExtra;
        Intent intent = getIntent();
        if (intent != null && (safeGetIntExtra = r.safeGetIntExtra(intent, "current", 0)) == 100) {
            hz(safeGetIntExtra);
            ai.b(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadingActivity.this.finish();
                }
            }, 200L);
        }
    }

    private void initViews() {
        this.mRootView = (RelativeLayout) findViewById(a.c.rl_root);
        this.cfR = (LinearLayout) findViewById(a.c.ll_container);
        this.cfP = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.cah = (TextView) findViewById(a.c.tv_progress);
        this.cfQ = (TextView) findViewById(a.c.tv_hide);
        this.cfQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void hz(int i) {
        if (this.cfP != null && this.cah != null && i > 0) {
            this.cfP.setProgress(i);
            this.cah.setText(String.valueOf(i));
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        d.acA().e(this);
    }

    private void unregisterListener() {
        d.acA().f(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.as.d.b
    /* renamed from: a */
    public void D(i.a aVar) {
        String str = aVar.id;
        if (TextUtils.equals(str, "loading_hide")) {
            finish();
        } else if (TextUtils.equals(str, "t7_loading")) {
            final long j = aVar.getLong("current");
            final long j2 = aVar.getLong("sum");
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    int i = (int) ((j / j2) * 100.0d);
                    int unused = LoadingActivity.cfS = i;
                    LoadingActivity.this.hz(i);
                }
            });
        }
    }
}
