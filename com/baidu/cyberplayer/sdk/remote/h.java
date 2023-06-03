package com.baidu.cyberplayer.sdk.remote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.PlayerConfigManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.remote.d;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class h {
    public static volatile h b;
    public volatile d c;
    public String d;
    public int e;
    public int f;
    public Class<?> g;
    public volatile int a = 0;
    public final Object h = new Object();
    public ArrayList<WeakReference<b>> i = new ArrayList<>();
    public j j = null;
    public ServiceConnection k = new ServiceConnection() { // from class: com.baidu.cyberplayer.sdk.remote.h.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            CyberLog.e("RemotePlayer", "RemotePlayer service disconnected");
            h.this.c = null;
            synchronized (h.this) {
                h hVar = h.this;
                int i = 2;
                if (h.this.a != 2) {
                    i = -1;
                }
                hVar.a = i;
                com.baidu.cyberplayer.sdk.statistics.i.a().a("disc", System.currentTimeMillis());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CyberLog.i("RemotePlayer", "RemotePlayer service connected");
            h.this.c = d.a.a(iBinder);
            synchronized (h.this) {
                h.this.a = 1;
                com.baidu.cyberplayer.sdk.statistics.i.a().a("conn", System.currentTimeMillis());
            }
            try {
                h.this.c.asBinder().linkToDeath(h.this.l, 0);
                if (h.this.j != null) {
                    h.this.c.a(h.this.j);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
                h.this.c = null;
                synchronized (h.this) {
                    h.this.a = -1;
                    com.baidu.cyberplayer.sdk.statistics.i.a().a("link2deathFail", System.currentTimeMillis());
                }
            }
            h hVar = h.this;
            hVar.b(hVar.f);
        }
    };
    public IBinder.DeathRecipient l = new IBinder.DeathRecipient() { // from class: com.baidu.cyberplayer.sdk.remote.h.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CyberLog.i("RemotePlayer", "RemotePlayer service binder died");
            if (h.this.c != null) {
                h.this.c.asBinder().unlinkToDeath(h.this.l, 0);
                h.this.c = null;
                synchronized (h.this) {
                    h.this.a = -1;
                    com.baidu.cyberplayer.sdk.statistics.i.a().a("died", System.currentTimeMillis());
                    com.baidu.cyberplayer.sdk.statistics.i.a().b();
                }
            }
            synchronized (h.this.h) {
                Iterator it = h.this.i.iterator();
                while (it.hasNext()) {
                    b bVar = (b) ((WeakReference) it.next()).get();
                    if (bVar != null) {
                        bVar.a();
                    } else {
                        it.remove();
                    }
                }
                h.this.i.clear();
            }
            h hVar = h.this;
            hVar.a(hVar.g, h.this.d, h.this.f, CyberPlayerManager.getInstallOpts(), h.this.e);
        }
    };

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public static class a extends d.a implements CyberPlayerManager.OnPrefetchListener {
        public RemotePlayerService a;
        public RemoteCallbackList<com.baidu.cyberplayer.sdk.remote.a> b = new RemoteCallbackList<>();

        public a(RemotePlayerService remotePlayerService) {
            this.a = remotePlayerService;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public IBinder a(int i) {
            if (!CyberPlayerManager.isCoreLoaded(1)) {
                CyberLog.w("RemotePlayer", "RemotePlayer has not load kernel, create failed!");
                return null;
            }
            return new g(i, this.a);
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void b(int i) {
            RemotePlayerService remotePlayerService = this.a;
            if (remotePlayerService == null) {
                return;
            }
            try {
                remotePlayerService.remoteInstallNewType(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public IBinder a() {
            if (!CyberPlayerManager.isCoreLoaded(1)) {
                CyberLog.w("RemotePlayer", "RemoteExtractor has not load kernel, create failed!");
                return null;
            }
            return new com.baidu.cyberplayer.sdk.extractor.c(this.a);
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public long b() {
            return CyberPlayerManager.getVideoCacheSizeCanBeCleared();
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(com.baidu.cyberplayer.sdk.remote.a aVar) {
            com.baidu.cyberplayer.sdk.f.a(this);
            if (aVar != null) {
                this.b.register(aVar);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean b(String str) {
            PlayerConfigManager.getInstance().updatePlayerConfig(str);
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(String str, int i, long j, String str2, PrefetchOptions prefetchOptions) {
            com.baidu.cyberplayer.sdk.f.a(str, i, j, str2, prefetchOptions);
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions) {
            if (i == 1) {
                CyberLog.i(PrefetchEvent.MODULE, "RemotePlayer prefetch");
                com.baidu.cyberplayer.sdk.f.m();
                com.baidu.cyberplayer.sdk.f.n();
                CyberPlayerManager.prefetch(str, str2, str3, i2, i3, null, str4, i4, i5, i6, i7, prefetchOptions);
            } else if (i == 2) {
                CyberLog.i("RemotePlayer", "RemotePlayer preconnect");
                CyberPlayerManager.preconnect(str, str2, str3, i3, null, str4, i4, i5, i6, i7);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean a(String str) {
            return CyberPlayerManager.hasCacheFile(str);
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPrefetchListener
        public void onPrefetchStatusChanged(String str, boolean z, int i, String str2) {
            synchronized (this.b) {
                int beginBroadcast = this.b.beginBroadcast();
                CyberLog.i("RemotePlayer", "[PrefetchCallback]onPrefetchStatus num:" + beginBroadcast);
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        this.b.getBroadcastItem(i2).a(str, z, i, str2);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                this.b.finishBroadcast();
            }
        }
    }

    public static h a() {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = new h();
                }
            }
        }
        return b;
    }

    public synchronized int b() {
        return this.a;
    }

    public IBinder c() {
        if (this.c != null) {
            try {
                return this.c.a();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public long d() {
        if (this.c == null) {
            return -1L;
        }
        try {
            return this.c.b();
        } catch (RemoteException unused) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.c == null) {
            return;
        }
        try {
            if (CyberCfgManager.getInstance().getCfgBoolValue("remote_install_new_type", true)) {
                CyberLog.e("RemotePlayer", "RemoteBinder remoteInstallNewType: " + i);
                this.c.b(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(CyberPlayerManager.OnPrefetchListener onPrefetchListener) {
        boolean a2;
        if (this.c == null) {
            return false;
        }
        CyberLog.w("RemotePlayer", "[PrefetchCallback]setPrefetchListenertusChanged:" + onPrefetchListener);
        j jVar = this.j;
        if (jVar == null) {
            this.j = new j(onPrefetchListener);
            a2 = true;
        } else {
            a2 = jVar.a(onPrefetchListener);
        }
        if (a2) {
            try {
                this.c.a(this.j);
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public int a(String str) {
        if (this.c == null) {
            return -1;
        }
        try {
            return this.c.a(str) ? 1 : 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void b(b bVar) {
        synchronized (this.h) {
            Iterator<WeakReference<b>> it = this.i.iterator();
            while (it.hasNext()) {
                b bVar2 = it.next().get();
                if (bVar2 == null || bVar2.equals(bVar)) {
                    it.remove();
                }
            }
        }
    }

    public IBinder a(int i) {
        if (this.c != null) {
            try {
                return this.c.a(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean b(String str) {
        if (this.c == null) {
            return false;
        }
        try {
            this.c.b(str);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(b bVar) {
        synchronized (this.h) {
            this.i.add(new WeakReference<>(bVar));
        }
    }

    public void a(Class<?> cls, String str, int i, Map<String, String> map, int i2) {
        if (cls == null) {
            return;
        }
        CyberLog.i("RemotePlayer", "RemotePlayer connect service: " + i);
        this.g = cls;
        this.d = str;
        this.e = i2;
        this.f = i;
        boolean cfgBoolValue = CyberCfgManager.getInstance().getCfgBoolValue("zeus_init_refactor", true);
        Intent intent = new Intent(CyberPlayerManager.getApplicationContext(), this.g);
        intent.putExtra("clientID", this.d);
        intent.putExtra("installType", this.f);
        intent.putExtra("installOpts", (Serializable) map);
        intent.putExtra("isZeusLauncher", cfgBoolValue);
        intent.putExtra("pcdnType", this.e);
        boolean z = false;
        try {
            z = CyberPlayerManager.getApplicationContext().bindService(intent, this.k, 1);
            synchronized (this) {
                this.a = 2;
                com.baidu.cyberplayer.sdk.statistics.i.a().a("bind", System.currentTimeMillis());
            }
        } catch (Exception unused) {
            CyberLog.e("RemotePlayer", "Failed binding to service!");
        }
        if (!z) {
            CyberLog.i("RemotePlayer", "Failed binding to service! need retry!");
            synchronized (this) {
                this.a = -2;
                com.baidu.cyberplayer.sdk.statistics.i.a().a("bindFail", System.currentTimeMillis());
            }
        }
        b(this.f);
    }

    public void a(String str, int i, long j, String str2, PrefetchOptions prefetchOptions) {
        if (this.c == null) {
            return;
        }
        try {
            this.c.a(str, i, j, str2, prefetchOptions);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean a(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions, CyberPlayerManager.OnPrefetchListener onPrefetchListener) {
        if (this.c == null) {
            return false;
        }
        try {
            a(onPrefetchListener);
            this.c.a(str, str2, str3, i, i2, i3, str4, i4, i5, i6, i7, prefetchOptions);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
