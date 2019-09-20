package com.baidu.sofire;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.mobstat.Config;
import com.baidu.sofire.b.v;
/* loaded from: classes2.dex */
public class MyActivity extends Activity {
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            final Intent intent = getIntent();
            if (Config.APP_VERSION_CODE.equals(intent.getStringExtra("t"))) {
                final Context applicationContext = getApplicationContext();
                v.a().a(new Runnable() { // from class: com.baidu.sofire.MyActivity.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            new StringBuilder().append(intent.toString());
                            b.a();
                            String stringExtra = intent.getStringExtra("c");
                            Intent intent2 = new Intent();
                            intent2.putExtra("t", Config.APP_VERSION_CODE);
                            intent2.putExtra("c", stringExtra);
                            a.a(applicationContext.getApplicationContext(), intent2);
                        } catch (Throwable th) {
                            com.baidu.sofire.b.e.a();
                        }
                    }
                });
            }
            if (com.baidu.sofire.core.g.a() == null) {
                b.a();
                super.onCreate(bundle);
                finish();
                return;
            }
            super.onCreate(bundle);
            b.a();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
    }
}
