package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.android.pushservice.a.a;
import com.baidu.android.pushservice.j.p;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PushService extends Service {
    private SDcardRemovedReceiver c;
    private boolean a = false;
    private Handler b = new Handler();
    private boolean d = false;
    private Runnable e = new Runnable() { // from class: com.baidu.android.pushservice.PushService.1
        @Override // java.lang.Runnable
        public void run() {
            PushService.this.stopSelf();
            g.b();
            if ((PushService.this.f > 0) && (PushService.this.getPackageName().equals(p.u(PushService.this.getApplicationContext())) ? false : true)) {
                PushService.this.onDestroy();
            }
        }
    };
    private int f = 0;
    private final a.AbstractBinderC0015a g = new a.AbstractBinderC0015a() { // from class: com.baidu.android.pushservice.PushService.2
        @Override // com.baidu.android.pushservice.a.a
        public int a(String str, int i) throws RemoteException {
            return 0;
        }

        @Override // com.baidu.android.pushservice.a.a
        public String a() throws RemoteException {
            return null;
        }

        @Override // com.baidu.android.pushservice.a.a
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // com.baidu.android.pushservice.a.a
        public String a(String str, int i, boolean z, int i2, int i3) throws RemoteException {
            return null;
        }

        @Override // com.baidu.android.pushservice.a.a
        public void a(String str, String str2, com.baidu.android.pushservice.a.b bVar) throws RemoteException {
            bVar.b(30602, PushService.this.a(str, (String) null));
        }

        @Override // com.baidu.android.pushservice.a.a
        public void a(String str, String str2, boolean z, com.baidu.android.pushservice.a.b bVar) throws RemoteException {
            bVar.a(30602, PushService.this.a(str, (String) null));
        }

        @Override // com.baidu.android.pushservice.a.a
        public void a(String str, String str2, boolean z, String str3, com.baidu.android.pushservice.a.b bVar) throws RemoteException {
            bVar.a(30602, PushService.this.a(str, str));
        }

        @Override // com.baidu.android.pushservice.a.a
        public boolean a(String str, String str2) throws RemoteException {
            return true;
        }

        @Override // com.baidu.android.pushservice.a.a
        public boolean a(String str, String str2, int i) throws RemoteException {
            return true;
        }

        @Override // com.baidu.android.pushservice.a.a
        public boolean a(String str, String str2, String str3, String str4) throws RemoteException {
            return true;
        }

        @Override // com.baidu.android.pushservice.a.a
        public boolean a(String str, boolean z) {
            return true;
        }

        @Override // com.baidu.android.pushservice.a.a
        public int b(String str) throws RemoteException {
            return 0;
        }

        @Override // com.baidu.android.pushservice.a.a
        public int b(String str, int i) throws RemoteException {
            return 0;
        }

        @Override // com.baidu.android.pushservice.a.a
        public String b() throws RemoteException {
            return null;
        }

        @Override // com.baidu.android.pushservice.a.a
        public void b(String str, String str2, com.baidu.android.pushservice.a.b bVar) throws RemoteException {
            bVar.c(30602, PushService.this.a(str, (String) null));
        }

        @Override // com.baidu.android.pushservice.a.a
        public boolean b(String str, String str2) throws RemoteException {
            return true;
        }

        @Override // com.baidu.android.pushservice.a.a
        public int c() throws RemoteException {
            com.baidu.android.pushservice.g.a.c("PushService", "getPushVersion " + ((int) a.a()));
            return a.a();
        }

        @Override // com.baidu.android.pushservice.a.a
        public int c(String str) throws RemoteException {
            return 0;
        }

        @Override // com.baidu.android.pushservice.a.a
        public int c(String str, int i) throws RemoteException {
            return 0;
        }

        @Override // com.baidu.android.pushservice.a.a
        public int d(String str) throws RemoteException {
            return 0;
        }

        @Override // com.baidu.android.pushservice.a.a
        public boolean e(String str) throws RemoteException {
            return true;
        }

        @Override // com.baidu.android.pushservice.a.a
        public String f(String str) throws RemoteException {
            return null;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", 30602);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("app_id", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("api_key", str2);
            }
            jSONObject.put(PushConstants.EXTRA_ERROR_CODE, "NOT SUPPORTED ANYMORE");
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("PushService", e);
        }
        return jSONObject.toString();
    }

    private void a(boolean z, boolean z2) {
        this.a = z;
        com.baidu.android.pushservice.g.b.a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
        if (z2) {
            this.e.run();
            return;
        }
        this.b.removeCallbacks(this.e);
        this.b.postDelayed(this.e, 3000L);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f++;
        com.baidu.android.pushservice.g.a.c("PushService", "onBind(" + this.f + "), intent=" + intent + " cur: " + getApplicationContext().getPackageName() + " initSuc: " + this.d);
        if (this.d) {
            return this.g;
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.baidu.android.pushservice.g.b.a("PushService", "onCreate from : " + getPackageName(), getApplicationContext());
        p.b("PushService onCreate from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
        this.d = g.a(this).a();
        if (!this.d) {
            a(true, false);
            return;
        }
        try {
            this.c = new SDcardRemovedReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
            intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
            registerReceiver(this.c, intentFilter);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("PushService", e);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.baidu.android.pushservice.d.c.b(getApplicationContext(), (String) null);
        com.baidu.android.pushservice.g.b.a("PushService", "onDestroy from : " + getPackageName(), getApplicationContext());
        p.b("PushService onDestroy from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
        try {
            unregisterReceiver(this.c);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.c("PushService", "sdcard receiver unregister failed");
        }
        g.b();
        if (this.a) {
            Process.killProcess(Process.myPid());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.g.b.c("PushService", "--- onStart by null intent!", getApplicationContext());
        } else {
            try {
                String uri = intent.toUri(0);
                com.baidu.android.pushservice.g.a.c("PushService", "-- onStartCommand -- " + uri);
                p.b("PushService onStartCommand from " + getPackageName() + " Intent " + uri + " at Time " + System.currentTimeMillis(), getApplicationContext());
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.a("PushService", e);
            }
        }
        this.b.removeCallbacks(this.e);
        if ("com.baidu.android.pushservice.action.CROSS_REQUEST".equals(intent.getAction())) {
            if (a.b() > 0) {
                intent.putExtra("bd.message.rate.BACK", System.currentTimeMillis());
            }
            com.baidu.android.pushservice.j.d.a(getApplicationContext(), intent);
        }
        try {
            this.d = g.a(this).a(intent);
            if (this.d) {
                return 1;
            }
            a(true, false);
            return 2;
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.a("PushService", e2);
            a(true, false);
            return 2;
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        this.f--;
        com.baidu.android.pushservice.g.a.c("PushService", "onUnbind(" + this.f + "), intent=" + intent);
        return super.onUnbind(intent);
    }
}
