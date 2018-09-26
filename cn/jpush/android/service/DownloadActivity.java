package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes3.dex */
public class DownloadActivity extends Activity {
    private static final String TAG = "DownloadActivity";

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            cn.jiguang.d.f.a.a(getApplicationContext(), getIntent());
        } catch (Throwable th) {
        }
        finish();
    }

    @Override // android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            cn.jiguang.d.f.a.a(getApplicationContext(), intent);
        } catch (Throwable th) {
        }
        finish();
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
    }
}
