package com.baidu.cyberplayer.sdk.remote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.l;
import com.baidu.cyberplayer.sdk.remote.c;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class g {
    public static volatile g a;
    public c b;
    public String c;
    public int d;
    public Class<?> e;
    public final Object f = new Object();
    public ArrayList<WeakReference<b>> g = new ArrayList<>();
    public ServiceConnection h = new ServiceConnection() { // from class: com.baidu.cyberplayer.sdk.remote.g.1
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
    public IBinder.DeathRecipient i = new IBinder.DeathRecipient() { // from class: com.baidu.cyberplayer.sdk.remote.g.2
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
            g gVar = g.this;
            gVar.a(gVar.e, g.this.c, g.this.d, CyberPlayerManager.getInstallOpts());
        }
    };

    /* loaded from: classes2.dex */
    public static class a extends c.a {
        public RemotePlayerService a;
        public CyberPlayerManager.GetNetHandleListener b;

        public a(RemotePlayerService remotePlayerService) {
            this.b = null;
            this.a = remotePlayerService;
            CyberPlayerManager.GetNetHandleListener getNetHandleListener = new CyberPlayerManager.GetNetHandleListener() { // from class: com.baidu.cyberplayer.sdk.remote.g.a.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.GetNetHandleListener
                public Long getKerNetHandle() {
                    RemotePlayerService remotePlayerService2 = a.this.a;
                    if (remotePlayerService2 != null) {
                        return Long.valueOf(remotePlayerService2.getPCDNNetHandle());
                    }
                    return 0L;
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.GetNetHandleListener
                public Long getPcdnNetHandle() {
                    RemotePlayerService remotePlayerService2 = a.this.a;
                    if (remotePlayerService2 != null) {
                        return Long.valueOf(remotePlayerService2.getKernelNetHandle());
                    }
                    return 0L;
                }
            };
            this.b = getNetHandleListener;
            if (getNetHandleListener != null) {
                CyberPlayerManager.setNetHandleListener(getNetHandleListener);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public IBinder a() {
            if (CyberPlayerManager.isCoreLoaded(1)) {
                return new com.baidu.cyberplayer.sdk.extractor.c(this.a);
            }
            CyberLog.w("RemotePlayer", "RemoteExtractor has not load kernel, create failed!");
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public IBinder a(int i) {
            if (CyberPlayerManager.isCoreLoaded(1)) {
                return new f(i, this.a);
            }
            CyberLog.w("RemotePlayer", "RemotePlayer has not load kernel, create failed!");
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public void a(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions) {
            if (i == 1) {
                CyberLog.i("RemotePlayer", "RemotePlayer prefetch");
                com.baidu.cyberplayer.sdk.d.l();
                com.baidu.cyberplayer.sdk.d.m();
                CyberPlayerManager.prefetch(str, str2, str3, i2, i3, null, str4, i4, i5, i6, i7, prefetchOptions);
            } else if (i == 2) {
                CyberLog.i("RemotePlayer", "RemotePlayer preconnect");
                CyberPlayerManager.preconnect(str, str2, str3, i3, null, str4, i4, i5, i6, i7);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public boolean a(String str) {
            return CyberPlayerManager.hasCacheFile(str);
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public boolean b(String str) {
            l.a().a(str);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    public static g a() {
        if (a == null) {
            a = new g();
        }
        return a;
    }

    public int a(String str) {
        c cVar = this.b;
        if (cVar == null) {
            return -1;
        }
        try {
            return cVar.a(str) ? 1 : 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public IBinder a(int i) {
        c cVar = this.b;
        if (cVar != null) {
            try {
                return cVar.a(i);
            } catch (RemoteException e) {
                e.printStackTrace();
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
        } catch (Exception unused) {
            CyberLog.e("RemotePlayer", "Failed binding to service!");
        }
        if (z) {
            return;
        }
        CyberLog.i("RemotePlayer", "Failed binding to service! need retry!");
    }

    public boolean a(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions) {
        c cVar = this.b;
        if (cVar == null) {
            return false;
        }
        try {
            cVar.a(str, str2, str3, i, i2, i3, str4, i4, i5, i6, i7, prefetchOptions);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public IBinder b() {
        c cVar = this.b;
        if (cVar != null) {
            try {
                return cVar.a();
            } catch (RemoteException e) {
                e.printStackTrace();
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

    public boolean b(String str) {
        c cVar = this.b;
        if (cVar == null) {
            return false;
        }
        try {
            cVar.b(str);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
