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
/* loaded from: classes10.dex */
public class LoadingActivity extends Activity implements com.baidu.swan.apps.as.d.b<i.a> {
    private static int cbN = 0;
    private TextView bWd;
    private LoadingProgressBar cbK;
    private TextView cbL;
    private LinearLayout cbM;
    private RelativeLayout mRootView;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ai.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.d.activity_loading);
        initViews();
        registerListener();
        hi(cbN);
        ahE();
    }

    private void ahE() {
        int safeGetIntExtra;
        Intent intent = getIntent();
        if (intent != null && (safeGetIntExtra = r.safeGetIntExtra(intent, "current", 0)) == 100) {
            hi(safeGetIntExtra);
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
        this.cbM = (LinearLayout) findViewById(a.c.ll_container);
        this.cbK = (LoadingProgressBar) findViewById(a.c.pb_loading_progressbar);
        this.bWd = (TextView) findViewById(a.c.tv_progress);
        this.cbL = (TextView) findViewById(a.c.tv_hide);
        this.cbL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.LoadingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadingActivity.this.finish();
            }
        });
    }

    void hi(int i) {
        if (this.cbK != null && this.bWd != null && i > 0) {
            this.cbK.setProgress(i);
            this.bWd.setText(String.valueOf(i));
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        unregisterListener();
        super.onDestroy();
    }

    private void registerListener() {
        d.aam().e(this);
    }

    private void unregisterListener() {
        d.aam().f(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.as.d.b
    /* renamed from: a */
    public void B(i.a aVar) {
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
                    int unused = LoadingActivity.cbN = i;
                    LoadingActivity.this.hi(i);
                }
            });
        }
    }
}
