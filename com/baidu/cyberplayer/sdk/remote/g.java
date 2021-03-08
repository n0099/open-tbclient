package com.baidu.cyberplayer.sdk.remote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.c;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f1449a;
    private c b;
    private String c;
    private int d;
    private Class<?> e;
    private final Object f = new Object();
    private ArrayList<WeakReference<b>> g = new ArrayList<>();
    private ServiceConnection h = new ServiceConnection() { // from class: com.baidu.cyberplayer.sdk.remote.g.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CyberLog.i("RemotePlayer", "RemotePlayer service connected");
            g.this.b = c.a.a(iBinder);
            try {
                g.this.b.asBinder().linkToDeath(g.this.i, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
                g.this.b = null;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            CyberLog.e("RemotePlayer", "RemotePlayer service disconnected");
            g.this.b = null;
        }
    };
    private IBinder.DeathRecipient i = new IBinder.DeathRecipient() { // from class: com.baidu.cyberplayer.sdk.remote.g.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CyberLog.i("RemotePlayer", "RemotePlayer service binder died");
            if (g.this.b != null) {
                g.this.b.asBinder().unlinkToDeath(g.this.i, 0);
                g.this.b = null;
            }
            synchronized (g.this.f) {
                Iterator it = g.this.g.iterator();
                while (it.hasNext()) {
                    b bVar = (b) ((WeakReference) it.next()).get();
                    if (bVar != null) {
                        bVar.a();
                    } else {
                        it.remove();
                    }
                }
            }
            g.this.a(g.this.e, g.this.c, g.this.d, CyberPlayerManager.getInstallOpts());
        }
    };

    /* loaded from: classes4.dex */
    public static class a extends c.a {

        /* renamed from: a  reason: collision with root package name */
        RemotePlayerService f1452a;

        public a(RemotePlayerService remotePlayerService) {
            this.f1452a = remotePlayerService;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public IBinder a() {
            if (CyberPlayerManager.isCoreLoaded(1)) {
                return new com.baidu.cyberplayer.sdk.extractor.c(this.f1452a);
            }
            CyberLog.w("RemotePlayer", "RemoteExtractor has not load kernel, create failed!");
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public IBinder a(int i) {
            if (CyberPlayerManager.isCoreLoaded(1)) {
                return new f(i, this.f1452a);
            }
            CyberLog.w("RemotePlayer", "RemotePlayer has not load kernel, create failed!");
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public void a(String str, String str2, String str3, int i, int i2, int i3) {
            if (i == 0) {
                CyberLog.i("RemotePlayer", "RemotePlayer prefetch");
                CyberPlayerManager.prefetch(str, str2, str3, i2, i3, (CyberPlayerManager.HttpDNS) null);
            } else if (i == 1) {
                CyberLog.i("RemotePlayer", "RemotePlayer preconnect");
                CyberPlayerManager.preconnect(str, str2, str3, i3, null);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public boolean a(String str) {
            return CyberPlayerManager.hasCacheFile(str);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    private g() {
    }

    public static g a() {
        if (f1449a == null) {
            f1449a = new g();
        }
        return f1449a;
    }

    public int a(String str) {
        if (this.b == null) {
            return -1;
        }
        try {
            return this.b.a(str) ? 1 : 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public IBinder a(int i) {
        if (this.b != null) {
            try {
                return this.b.a(i);
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void a(b bVar) {
        synchronized (this.f) {
            this.g.add(new WeakReference<>(bVar));
        }
    }

    public void a(Class<?> cls, String str, int i, Map<String, String> map) {
        if (cls == null) {
            return;
        }
        CyberLog.i("RemotePlayer", "RemotePlayer connect service");
        this.e = cls;
        this.c = str;
        this.d = i;
        Intent intent = new Intent(CyberPlayerManager.getApplicationContext(), this.e);
        intent.putExtra("clientID", this.c);
        intent.putExtra("installType", this.d);
        intent.putExtra("installOpts", (Serializable) map);
        boolean z = false;
        try {
            z = CyberPlayerManager.getApplicationContext().bindService(intent, this.h, 1);
        } catch (Exception e) {
            CyberLog.e("RemotePlayer", "Failed binding to service!");
        }
        if (z) {
            return;
        }
        CyberLog.i("RemotePlayer", "Failed binding to service! need retry!");
    }

    public boolean a(String str, String str2, String str3, int i, int i2, int i3) {
        if (this.b == null) {
            return false;
        }
        try {
            this.b.a(str, str2, str3, i, i2, i3);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public IBinder b() {
        if (this.b != null) {
            try {
                return this.b.a();
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void b(b bVar) {
        synchronized (this.f) {
            Iterator<WeakReference<b>> it = this.g.iterator();
            while (it.hasNext()) {
                b bVar2 = it.next().get();
                if (bVar2 == null || bVar2.equals(bVar)) {
                    it.remove();
                }
            }
        }
    }
}
