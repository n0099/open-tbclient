package com.baidu.cyberplayer.sdk.remote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.b;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static volatile f a;
    private com.baidu.cyberplayer.sdk.remote.b b;
    private String c;
    private int d;
    private Class<?> e;
    private final Object f = new Object();
    private ArrayList<WeakReference<b>> g = new ArrayList<>();
    private ServiceConnection h = new ServiceConnection() { // from class: com.baidu.cyberplayer.sdk.remote.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CyberLog.i("RemotePlayer", "RemotePlayer service connected");
            f.this.b = b.a.a(iBinder);
            try {
                f.this.b.asBinder().linkToDeath(f.this.i, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
                f.this.b = null;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            CyberLog.e("RemotePlayer", "RemotePlayer service disconnected");
            f.this.b = null;
        }
    };
    private IBinder.DeathRecipient i = new IBinder.DeathRecipient() { // from class: com.baidu.cyberplayer.sdk.remote.f.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CyberLog.i("RemotePlayer", "RemotePlayer service binder died");
            if (f.this.b != null) {
                f.this.b.asBinder().unlinkToDeath(f.this.i, 0);
                f.this.b = null;
            }
            synchronized (f.this.f) {
                Iterator it = f.this.g.iterator();
                while (it.hasNext()) {
                    b bVar = (b) ((WeakReference) it.next()).get();
                    if (bVar != null) {
                        bVar.a();
                    } else {
                        it.remove();
                    }
                }
            }
            f.this.a(f.this.e, f.this.c, f.this.d, CyberPlayerManager.getInstallOpts());
        }
    };

    /* loaded from: classes.dex */
    public static class a extends b.a {
        RemotePlayerService a;

        public a(RemotePlayerService remotePlayerService) {
            this.a = remotePlayerService;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.b
        public IBinder a(int i) {
            CyberLog.i("RemotePlayer", "RemotePlayer create");
            return new e(i, this.a);
        }

        @Override // com.baidu.cyberplayer.sdk.remote.b
        public void a(String str, String str2, String str3, int i, int i2) {
            if (i == 0) {
                CyberLog.i("RemotePlayer", "RemotePlayer prefetch");
                CyberPlayerManager.prefetch(str, str2, str3, i2, null);
            } else if (i == 1) {
                CyberLog.i("RemotePlayer", "RemotePlayer preconnect");
                CyberPlayerManager.preconnect(str, str2, str3, i2, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    private f() {
    }

    public static f a() {
        if (a == null) {
            a = new f();
        }
        return a;
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
        CyberPlayerManager.getApplicationContext().bindService(intent, this.h, 1);
    }

    public boolean a(String str, String str2, String str3, int i, int i2) {
        if (this.b == null) {
            return false;
        }
        try {
            this.b.a(str, str2, str3, i, i2);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
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
