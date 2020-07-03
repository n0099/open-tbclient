package com.baidu.crashpad;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import com.baidu.crashpad.b;
import java.io.File;
/* loaded from: classes11.dex */
public final class DumperService extends Service implements b.c {
    private int a;
    private long b;
    private String c;
    private String d;
    private b e;
    private boolean f = true;
    private String g = "";

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Cannot bind to DumperService.");
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    @Override // com.baidu.crashpad.b.c
    public final void onFinished(String str, int i, String str2) {
        Context applicationContext = getApplicationContext();
        Object obj = null;
        if (this.d != null && !this.d.isEmpty() && !this.d.equals("0")) {
            try {
                obj = Class.forName(this.d).newInstance();
            } catch (Throwable th) {
                com.a.a.a.a.a.a.a.a(th);
            }
        }
        String str3 = (!this.f || i != 3 || this.e == null || b.c(str) == 6) ? str2 : "Failed to encrypt file.";
        if (obj != null) {
            ((CrashCallback) obj).onCrash(applicationContext, this.c, this.a, this.b, str, i, str3);
        }
        stopSelf();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        boolean z;
        if (intent == null) {
            stopSelf();
        }
        String stringExtra = intent.getStringExtra("LOG_TYPE");
        String stringExtra2 = intent.getStringExtra("CRASH_FILE");
        boolean booleanExtra = intent.getBooleanExtra("HTTPS", true);
        this.a = intent.getIntExtra("CRASH_SIGNAL", -1);
        this.b = intent.getLongExtra("CRASH_TIME", -1L);
        this.d = intent.getStringExtra("CRASH_CALLBACK");
        this.f = intent.getBooleanExtra("CRASHLOGENCRYPT", true);
        this.g = intent.getStringExtra("ENCRYPTKEY");
        this.e = new b(stringExtra, booleanExtra);
        if (this.e != null) {
            b.b(this.g);
            b.b(this.f);
        }
        ZwDebugExtra.init(this);
        this.c = this.c == null ? "0" : this.c;
        Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            z = false;
        } else {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        }
        if (!z) {
            onFinished(stringExtra2, 3, "doUpload Failed, Network is not connected.");
            return 3;
        } else if (!booleanExtra) {
            onFinished(stringExtra2, 3, "doUpload Failed, HTTP is never supported!");
            stopSelf();
            return 0;
        } else {
            if (this.e != null) {
                b bVar = this.e;
                if (b.a && stringExtra2 != null && !stringExtra2.isEmpty() && new File(stringExtra2).exists()) {
                    Thread thread = new Thread(new b.RunnableC0104b(stringExtra2, bVar.c, bVar.b, bVar.d, this));
                    thread.setName("T7@ZeusLogFile1");
                    thread.start();
                }
            } else {
                onFinished(stringExtra2, 3, "doUpload Failed, logUploader is null.");
            }
            return 3;
        }
    }
}
