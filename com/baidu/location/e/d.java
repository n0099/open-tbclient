package com.baidu.location.e;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.baidu.location.BDLocation;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class d {
    private static volatile d MK;
    private static Context c;
    private final File MM;
    private final k MN;
    private final e MO;
    private final m MP;
    private final h MQ;
    static final String b = "com.baidu.lbs.offlinelocationprovider";
    static final String a = "http://loc.map.baidu.com/offline_loc";

    /* loaded from: classes.dex */
    public enum a {
        NEED_TO_LOG,
        NO_NEED_TO_LOG
    }

    /* loaded from: classes.dex */
    public enum b {
        IS_MIX_MODE,
        IS_NOT_MIX_MODE
    }

    /* loaded from: classes.dex */
    private enum c {
        NETWORK_UNKNOWN,
        NETWORK_WIFI,
        NETWORK_2G,
        NETWORK_3G,
        NETWORK_4G
    }

    private d() {
        File file;
        try {
            file = new File(c.getFilesDir(), "ofld");
            try {
                if (!file.exists()) {
                    file.mkdir();
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            file = null;
        }
        this.MM = file;
        this.MO = new e(this);
        this.MN = new k(this.MO.mB());
        this.MQ = new h(this, this.MO.mB());
        this.MP = new m(this, this.MO.mB(), this.MQ.n());
    }

    public static void a(Context context) {
        if (c == null) {
            c = context;
            com.baidu.location.h.c.mX().a(c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri bN(String str) {
        return Uri.parse(String.format("content://%s/", str));
    }

    public static d mv() {
        if (MK == null) {
            synchronized (d.class) {
                if (MK == null) {
                    if (c == null) {
                        a(com.baidu.location.f.getServiceContext());
                    }
                    MK = new d();
                }
            }
        }
        MK.q();
        return MK;
    }

    private BDLocation n(String[] strArr) {
        new BDLocation();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        FutureTask futureTask = (FutureTask) newSingleThreadExecutor.submit(new i(this, strArr));
        try {
            try {
                BDLocation bDLocation = (BDLocation) futureTask.get(2000L, TimeUnit.MILLISECONDS);
                newSingleThreadExecutor.shutdown();
                return bDLocation;
            } catch (InterruptedException e) {
                futureTask.cancel(true);
                newSingleThreadExecutor.shutdown();
                return null;
            } catch (ExecutionException e2) {
                futureTask.cancel(true);
                newSingleThreadExecutor.shutdown();
                return null;
            } catch (TimeoutException e3) {
                com.baidu.location.c.f.mr().a("offlineLocation Timeout Exception!");
                futureTask.cancel(true);
                newSingleThreadExecutor.shutdown();
                return null;
            }
        } catch (Throwable th) {
            newSingleThreadExecutor.shutdown();
            throw th;
        }
    }

    private void q() {
        this.MQ.g();
    }

    private boolean r() {
        ProviderInfo providerInfo;
        String packageName = c.getPackageName();
        ProviderInfo resolveContentProvider = c.getPackageManager().resolveContentProvider(b, 0);
        if (resolveContentProvider == null) {
            String[] mF = this.MQ.mF();
            providerInfo = resolveContentProvider;
            for (int i = 0; i < mF.length && (providerInfo = c.getPackageManager().resolveContentProvider(mF[i], 0)) == null; i++) {
            }
        } else {
            providerInfo = resolveContentProvider;
        }
        return providerInfo == null || packageName.equals(providerInfo.packageName);
    }

    public BDLocation a(com.baidu.location.f.a aVar, com.baidu.location.f.i iVar, BDLocation bDLocation, b bVar, a aVar2) {
        String d;
        int i;
        if (bVar == b.IS_MIX_MODE) {
            i = this.MQ.a();
            d = com.baidu.location.h.c.mX().d() + "&mixMode=1";
        } else {
            d = com.baidu.location.h.c.mX().d();
            i = 0;
        }
        String[] a2 = j.a(aVar, iVar, bDLocation, d, (aVar2 == a.NEED_TO_LOG).booleanValue(), i);
        BDLocation bDLocation2 = null;
        if (a2.length <= 0 || (bDLocation2 = n(a2)) == null || bDLocation2.getLocType() != 67) {
        }
        return bDLocation2;
    }

    public long bO(String str) {
        return this.MQ.bO(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File c() {
        return this.MM;
    }

    public boolean d() {
        return this.MQ.h();
    }

    public boolean e() {
        return this.MQ.i();
    }

    public boolean f() {
        return this.MQ.j();
    }

    public boolean g() {
        return this.MQ.k();
    }

    public boolean h() {
        return this.MQ.m();
    }

    public void i() {
        this.MN.a();
    }

    public void m() {
        if (r()) {
            this.MO.b();
        }
    }

    public Context mw() {
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k mx() {
        return this.MN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m my() {
        return this.MP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h mz() {
        return this.MQ;
    }

    public void n() {
    }

    public double o() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) c.getSystemService("connectivity")).getActiveNetworkInfo();
        c cVar = c.NETWORK_UNKNOWN;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                cVar = c.NETWORK_WIFI;
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11) {
                    cVar = c.NETWORK_2G;
                } else if (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) {
                    cVar = c.NETWORK_3G;
                } else if (subtype == 13) {
                    cVar = c.NETWORK_4G;
                }
            }
        }
        if (cVar == c.NETWORK_UNKNOWN) {
            return this.MQ.b();
        }
        if (cVar == c.NETWORK_WIFI) {
            return this.MQ.c();
        }
        if (cVar == c.NETWORK_2G) {
            return this.MQ.mC();
        }
        if (cVar == c.NETWORK_3G) {
            return this.MQ.mD();
        }
        if (cVar == c.NETWORK_4G) {
            return this.MQ.mE();
        }
        return 0.0d;
    }
}
