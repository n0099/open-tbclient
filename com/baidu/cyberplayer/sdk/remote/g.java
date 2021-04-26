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
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f5182a;

    /* renamed from: b  reason: collision with root package name */
    public c f5183b;

    /* renamed from: c  reason: collision with root package name */
    public String f5184c;

    /* renamed from: d  reason: collision with root package name */
    public int f5185d;

    /* renamed from: e  reason: collision with root package name */
    public Class<?> f5186e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f5187f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<WeakReference<b>> f5188g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public ServiceConnection f5189h = new ServiceConnection() { // from class: com.baidu.cyberplayer.sdk.remote.g.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CyberLog.i("RemotePlayer", "RemotePlayer service connected");
            g.this.f5183b = c.a.a(iBinder);
            try {
                g.this.f5183b.asBinder().linkToDeath(g.this.f5190i, 0);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                g.this.f5183b = null;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            CyberLog.e("RemotePlayer", "RemotePlayer service disconnected");
            g.this.f5183b = null;
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public IBinder.DeathRecipient f5190i = new IBinder.DeathRecipient() { // from class: com.baidu.cyberplayer.sdk.remote.g.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CyberLog.i("RemotePlayer", "RemotePlayer service binder died");
            if (g.this.f5183b != null) {
                g.this.f5183b.asBinder().unlinkToDeath(g.this.f5190i, 0);
                g.this.f5183b = null;
            }
            synchronized (g.this.f5187f) {
                Iterator it = g.this.f5188g.iterator();
                while (it.hasNext()) {
                    b bVar = (b) ((WeakReference) it.next()).get();
                    if (bVar != null) {
                        bVar.a();
                    } else {
                        it.remove();
                    }
                }
            }
            g gVar = g.this;
            gVar.a(gVar.f5186e, g.this.f5184c, g.this.f5185d, CyberPlayerManager.getInstallOpts());
        }
    };

    /* loaded from: classes2.dex */
    public static class a extends c.a {

        /* renamed from: a  reason: collision with root package name */
        public RemotePlayerService f5193a;

        public a(RemotePlayerService remotePlayerService) {
            this.f5193a = remotePlayerService;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public IBinder a() {
            if (CyberPlayerManager.isCoreLoaded(1)) {
                return new com.baidu.cyberplayer.sdk.extractor.c(this.f5193a);
            }
            CyberLog.w("RemotePlayer", "RemoteExtractor has not load kernel, create failed!");
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public IBinder a(int i2) {
            if (CyberPlayerManager.isCoreLoaded(1)) {
                return new f(i2, this.f5193a);
            }
            CyberLog.w("RemotePlayer", "RemotePlayer has not load kernel, create failed!");
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public void a(String str, String str2, String str3, int i2, int i3, int i4) {
            if (i2 == 0) {
                CyberLog.i("RemotePlayer", "RemotePlayer prefetch");
                CyberPlayerManager.prefetch(str, str2, str3, i3, i4, (CyberPlayerManager.HttpDNS) null);
            } else if (i2 == 1) {
                CyberLog.i("RemotePlayer", "RemotePlayer preconnect");
                CyberPlayerManager.preconnect(str, str2, str3, i4, null);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public boolean a(String str) {
            return CyberPlayerManager.hasCacheFile(str);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    public static g a() {
        if (f5182a == null) {
            f5182a = new g();
        }
        return f5182a;
    }

    public int a(String str) {
        c cVar = this.f5183b;
        if (cVar == null) {
            return -1;
        }
        try {
            return cVar.a(str) ? 1 : 0;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public IBinder a(int i2) {
        c cVar = this.f5183b;
        if (cVar != null) {
            try {
                return cVar.a(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public void a(b bVar) {
        synchronized (this.f5187f) {
            this.f5188g.add(new WeakReference<>(bVar));
        }
    }

    public void a(Class<?> cls, String str, int i2, Map<String, String> map) {
        if (cls == null) {
            return;
        }
        CyberLog.i("RemotePlayer", "RemotePlayer connect service");
        this.f5186e = cls;
        this.f5184c = str;
        this.f5185d = i2;
        Intent intent = new Intent(CyberPlayerManager.getApplicationContext(), this.f5186e);
        intent.putExtra("clientID", this.f5184c);
        intent.putExtra("installType", this.f5185d);
        intent.putExtra("installOpts", (Serializable) map);
        boolean z = false;
        try {
            z = CyberPlayerManager.getApplicationContext().bindService(intent, this.f5189h, 1);
        } catch (Exception unused) {
            CyberLog.e("RemotePlayer", "Failed binding to service!");
        }
        if (z) {
            return;
        }
        CyberLog.i("RemotePlayer", "Failed binding to service! need retry!");
    }

    public boolean a(String str, String str2, String str3, int i2, int i3, int i4) {
        c cVar = this.f5183b;
        if (cVar == null) {
            return false;
        }
        try {
            cVar.a(str, str2, str3, i2, i3, i4);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public IBinder b() {
        c cVar = this.f5183b;
        if (cVar != null) {
            try {
                return cVar.a();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public void b(b bVar) {
        synchronized (this.f5187f) {
            Iterator<WeakReference<b>> it = this.f5188g.iterator();
            while (it.hasNext()) {
                b bVar2 = it.next().get();
                if (bVar2 == null || bVar2.equals(bVar)) {
                    it.remove();
                }
            }
        }
    }
}
