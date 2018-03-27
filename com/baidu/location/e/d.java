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
    private static volatile d aCT;
    private static Context c;
    private final File aCU;
    private final k aCV;
    private final e aCW;
    private final m aCX;
    private final h aCY;
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
        this.aCU = file;
        this.aCW = new e(this);
        this.aCV = new k(this.aCW.uR());
        this.aCY = new h(this, this.aCW.uR());
        this.aCX = new m(this, this.aCW.uR(), this.aCY.n());
    }

    public static void a(Context context) {
        if (c == null) {
            c = context;
            com.baidu.location.h.c.vn().a(c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri cb(String str) {
        return Uri.parse(String.format("content://%s/", str));
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
                com.baidu.location.c.f.uH().a("offlineLocation Timeout Exception!");
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
        this.aCY.g();
    }

    private boolean r() {
        ProviderInfo providerInfo;
        String packageName = c.getPackageName();
        ProviderInfo resolveContentProvider = c.getPackageManager().resolveContentProvider(b, 0);
        if (resolveContentProvider == null) {
            String[] uV = this.aCY.uV();
            providerInfo = resolveContentProvider;
            for (int i = 0; i < uV.length && (providerInfo = c.getPackageManager().resolveContentProvider(uV[i], 0)) == null; i++) {
            }
        } else {
            providerInfo = resolveContentProvider;
        }
        return providerInfo == null || packageName.equals(providerInfo.packageName);
    }

    public static d uL() {
        if (aCT == null) {
            synchronized (d.class) {
                if (aCT == null) {
                    if (c == null) {
                        a(com.baidu.location.f.getServiceContext());
                    }
                    aCT = new d();
                }
            }
        }
        aCT.q();
        return aCT;
    }

    public long a(String str) {
        return this.aCY.a(str);
    }

    public BDLocation a(com.baidu.location.f.a aVar, com.baidu.location.f.i iVar, BDLocation bDLocation, b bVar, a aVar2) {
        String d;
        int i;
        if (bVar == b.IS_MIX_MODE) {
            i = this.aCY.a();
            d = com.baidu.location.h.c.vn().d() + "&mixMode=1";
        } else {
            d = com.baidu.location.h.c.vn().d();
            i = 0;
        }
        String[] a2 = j.a(aVar, iVar, bDLocation, d, (aVar2 == a.NEED_TO_LOG).booleanValue(), i);
        BDLocation bDLocation2 = null;
        if (a2.length <= 0 || (bDLocation2 = n(a2)) == null || bDLocation2.getLocType() != 67) {
        }
        return bDLocation2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File c() {
        return this.aCU;
    }

    public boolean d() {
        return this.aCY.h();
    }

    public boolean e() {
        return this.aCY.i();
    }

    public boolean f() {
        return this.aCY.j();
    }

    public boolean g() {
        return this.aCY.k();
    }

    public boolean h() {
        return this.aCY.m();
    }

    public void i() {
        this.aCV.a();
    }

    public void m() {
        if (r()) {
            this.aCW.b();
        }
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
            return this.aCY.b();
        }
        if (cVar == c.NETWORK_WIFI) {
            return this.aCY.c();
        }
        if (cVar == c.NETWORK_2G) {
            return this.aCY.uS();
        }
        if (cVar == c.NETWORK_3G) {
            return this.aCY.uT();
        }
        if (cVar == c.NETWORK_4G) {
            return this.aCY.uU();
        }
        return 0.0d;
    }

    public Context uM() {
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k uN() {
        return this.aCV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m uO() {
        return this.aCX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h uP() {
        return this.aCY;
    }
}
