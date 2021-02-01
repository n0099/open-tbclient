package com.baidu.sofire;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.sofire.i.w;
/* loaded from: classes3.dex */
public class MyActivity extends Activity {
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            final Intent intent = getIntent();
            if ("teac".equals(intent.getAction())) {
                b.a();
                Intent intent2 = new Intent(intent);
                intent2.setAction("teac");
                intent2.setComponent(new ComponentName(getApplicationContext().getPackageName(), MyService.class.getCanonicalName()));
                startService(intent2);
            }
            if ("a".equals(intent.getStringExtra("t"))) {
                final Context applicationContext = getApplicationContext();
                w.a().a(new Runnable() { // from class: com.baidu.sofire.MyActivity.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            new StringBuilder().append(intent.toString());
                            b.a();
                            String stringExtra = intent.getStringExtra("c");
                            Intent intent3 = new Intent();
                            intent3.putExtra("t", "a");
                            intent3.putExtra("c", stringExtra);
                            a.a(applicationContext.getApplicationContext(), intent3);
                        } catch (Throwable th) {
                            com.baidu.sofire.i.e.a();
                        }
                    }
                });
            }
            super.onCreate(bundle);
            b.a();
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
        finish();
    }
}
