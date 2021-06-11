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

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4949a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile g f4950b;

    /* renamed from: c  reason: collision with root package name */
    public c f4951c;

    /* renamed from: d  reason: collision with root package name */
    public String f4952d;

    /* renamed from: e  reason: collision with root package name */
    public int f4953e;

    /* renamed from: f  reason: collision with root package name */
    public Class<?> f4954f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f4955g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<WeakReference<b>> f4956h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    public ServiceConnection f4957i = new ServiceConnection() { // from class: com.baidu.cyberplayer.sdk.remote.g.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CyberLog.i("RemotePlayer", "RemotePlayer service connected");
            g.this.f4951c = c.a.a(iBinder);
            try {
                g.this.f4951c.asBinder().linkToDeath(g.this.j, 0);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                g.this.f4951c = null;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            CyberLog.e("RemotePlayer", "RemotePlayer service disconnected");
            g.this.f4951c = null;
        }
    };
    public IBinder.DeathRecipient j = new IBinder.DeathRecipient() { // from class: com.baidu.cyberplayer.sdk.remote.g.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CyberLog.i("RemotePlayer", "RemotePlayer service binder died");
            if (g.this.f4951c != null) {
                g.this.f4951c.asBinder().unlinkToDeath(g.this.j, 0);
                g.this.f4951c = null;
            }
            synchronized (g.this.f4955g) {
                Iterator it = g.this.f4956h.iterator();
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
            gVar.a(gVar.f4954f, g.this.f4952d, g.this.f4953e, CyberPlayerManager.getInstallOpts());
        }
    };

    /* loaded from: classes2.dex */
    public static class a extends c.a {

        /* renamed from: a  reason: collision with root package name */
        public RemotePlayerService f4960a;

        public a(RemotePlayerService remotePlayerService) {
            this.f4960a = remotePlayerService;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public IBinder a() {
            if (CyberPlayerManager.isCoreLoaded(1)) {
                return new com.baidu.cyberplayer.sdk.extractor.c(this.f4960a);
            }
            CyberLog.w("RemotePlayer", "RemoteExtractor has not load kernel, create failed!");
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public IBinder a(int i2) {
            if (CyberPlayerManager.isCoreLoaded(1)) {
                return new f(i2, this.f4960a);
            }
            CyberLog.w("RemotePlayer", "RemotePlayer has not load kernel, create failed!");
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public void a(String str, String str2, String str3, int i2, int i3, int i4, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions) {
            RemotePlayerService remotePlayerService;
            if (i2 != 0) {
                if (i2 == 1) {
                    CyberLog.i("RemotePlayer", "RemotePlayer preconnect");
                    CyberPlayerManager.preconnect(str, str2, str3, i4, null, str4, i5, i6, i7, i8);
                    return;
                }
                return;
            }
            CyberLog.i("RemotePlayer", "RemotePlayer prefetch");
            if (!g.f4949a && (remotePlayerService = this.f4960a) != null) {
                long kernelNetHandle = remotePlayerService.getKernelNetHandle();
                if (kernelNetHandle != 0 && com.baidu.cyberplayer.sdk.d.c(kernelNetHandle) == 0) {
                    boolean unused = g.f4949a = true;
                }
            }
            CyberPlayerManager.prefetch(str, str2, str3, i3, i4, null, str4, i5, i6, i7, i8, prefetchOptions);
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
        if (f4950b == null) {
            f4950b = new g();
        }
        return f4950b;
    }

    public int a(String str) {
        c cVar = this.f4951c;
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
        c cVar = this.f4951c;
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
        synchronized (this.f4955g) {
            this.f4956h.add(new WeakReference<>(bVar));
        }
    }

    public void a(Class<?> cls, String str, int i2, Map<String, String> map) {
        if (cls == null) {
            return;
        }
        CyberLog.i("RemotePlayer", "RemotePlayer connect service");
        this.f4954f = cls;
        this.f4952d = str;
        this.f4953e = i2;
        Intent intent = new Intent(CyberPlayerManager.getApplicationContext(), this.f4954f);
        intent.putExtra("clientID", this.f4952d);
        intent.putExtra("installType", this.f4953e);
        intent.putExtra("installOpts", (Serializable) map);
        boolean z = false;
        try {
            z = CyberPlayerManager.getApplicationContext().bindService(intent, this.f4957i, 1);
        } catch (Exception unused) {
            CyberLog.e("RemotePlayer", "Failed binding to service!");
        }
        if (z) {
            return;
        }
        CyberLog.i("RemotePlayer", "Failed binding to service! need retry!");
    }

    public boolean a(String str, String str2, String str3, int i2, int i3, int i4, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions) {
        c cVar = this.f4951c;
        if (cVar == null) {
            return false;
        }
        try {
            cVar.a(str, str2, str3, i2, i3, i4, str4, i5, i6, i7, i8, prefetchOptions);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public IBinder b() {
        c cVar = this.f4951c;
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
        synchronized (this.f4955g) {
            Iterator<WeakReference<b>> it = this.f4956h.iterator();
            while (it.hasNext()) {
                b bVar2 = it.next().get();
                if (bVar2 == null || bVar2.equals(bVar)) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(String str) {
        c cVar = this.f4951c;
        if (cVar == null) {
            return false;
        }
        try {
            cVar.b(str);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
