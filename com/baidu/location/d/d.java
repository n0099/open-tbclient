package com.baidu.location.d;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.baidu.location.BDLocation;
import com.baidu.location.d.e;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public final class d {
    private static volatile d afn;
    private static Context c;
    private final f afo;
    private final com.baidu.location.d.b afp;
    private final g afq;
    private final com.baidu.location.d.c afr;
    private final File e;
    public static final String a = com.baidu.location.g.a.a;
    static final String b = "http://ofloc.map.baidu.com/offline_loc";

    /* loaded from: classes6.dex */
    public enum a {
        NEED_TO_LOG,
        NO_NEED_TO_LOG
    }

    /* loaded from: classes6.dex */
    public enum b {
        IS_MIX_MODE,
        IS_NOT_MIX_MODE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum c {
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
        this.e = file;
        this.afp = new com.baidu.location.d.b(this);
        this.afo = new f(this.afp.tE());
        this.afr = new com.baidu.location.d.c(this, this.afp.tE());
        this.afq = new g(this, this.afp.tE(), this.afr.n());
    }

    public static void a(Context context) {
        if (c == null) {
            c = context;
            com.baidu.location.g.b.tZ().a(c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri dd(String str) {
        return Uri.parse(String.format("content://%s/", str));
    }

    private BDLocation o(final String[] strArr) {
        new BDLocation();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        FutureTask futureTask = (FutureTask) newSingleThreadExecutor.submit(new Callable<BDLocation>() { // from class: com.baidu.location.d.d.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
            /* JADX WARN: Removed duplicated region for block: B:94:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
            @Override // java.util.concurrent.Callable
            /* renamed from: tN */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public BDLocation call() {
                Cursor cursor;
                BDLocation bDLocation;
                Cursor cursor2;
                Cursor cursor3 = null;
                r6 = null;
                r6 = null;
                BDLocation bDLocation2 = null;
                Cursor cursor4 = null;
                BDLocation bDLocation3 = new BDLocation();
                if (strArr.length <= 0) {
                    return bDLocation3;
                }
                ProviderInfo providerInfo = null;
                for (String str : d.this.afr.tH()) {
                    try {
                        providerInfo = d.c.getPackageManager().resolveContentProvider(str, 0);
                    } catch (Exception e) {
                        providerInfo = null;
                    }
                    if (providerInfo != null) {
                        break;
                    }
                }
                if (providerInfo != null) {
                    try {
                        cursor = d.c.getContentResolver().query(d.dd(providerInfo.authority), strArr, null, null, null);
                        try {
                            bDLocation2 = e.i(cursor);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e2) {
                                }
                            }
                        } catch (Exception e3) {
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e4) {
                                }
                            }
                            bDLocation = bDLocation2;
                            return bDLocation != null ? bDLocation : bDLocation;
                        } catch (Throwable th) {
                            cursor3 = cursor;
                            th = th;
                            if (cursor3 != null) {
                                try {
                                    cursor3.close();
                                } catch (Exception e5) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    bDLocation = bDLocation2;
                } else {
                    try {
                        cursor2 = d.this.afp.a(new e.a(strArr));
                    } catch (Exception e7) {
                        cursor2 = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    try {
                        BDLocation i = e.i(cursor2);
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                                bDLocation = i;
                            } catch (Exception e8) {
                                bDLocation = i;
                            }
                        } else {
                            bDLocation = i;
                        }
                    } catch (Exception e9) {
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                                bDLocation = null;
                            } catch (Exception e10) {
                                bDLocation = null;
                            }
                        } else {
                            bDLocation = null;
                        }
                        if (bDLocation != null) {
                        }
                    } catch (Throwable th4) {
                        cursor4 = cursor2;
                        th = th4;
                        if (cursor4 != null) {
                            try {
                                cursor4.close();
                            } catch (Exception e11) {
                            }
                        }
                        throw th;
                    }
                }
                if (bDLocation != null && bDLocation.getLocType() != 67) {
                    bDLocation.setLocType(66);
                    return bDLocation;
                }
            }
        });
        try {
            try {
                try {
                    BDLocation bDLocation = (BDLocation) futureTask.get(SystemScreenshotManager.DELAY_TIME, TimeUnit.MILLISECONDS);
                    newSingleThreadExecutor.shutdown();
                    return bDLocation;
                } catch (ExecutionException e) {
                    futureTask.cancel(true);
                    newSingleThreadExecutor.shutdown();
                    return null;
                }
            } catch (InterruptedException e2) {
                futureTask.cancel(true);
                newSingleThreadExecutor.shutdown();
                return null;
            } catch (TimeoutException e3) {
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
        this.afr.g();
    }

    private boolean r() {
        ProviderInfo providerInfo;
        String packageName = c.getPackageName();
        if (0 == 0) {
            providerInfo = null;
            for (String str : this.afr.tH()) {
                try {
                    providerInfo = c.getPackageManager().resolveContentProvider(str, 0);
                } catch (Exception e) {
                    providerInfo = null;
                }
                if (providerInfo != null) {
                    break;
                }
            }
        } else {
            providerInfo = null;
        }
        return providerInfo == null || packageName.equals(providerInfo.packageName);
    }

    public static d tI() {
        if (afn == null) {
            synchronized (d.class) {
                if (afn == null) {
                    if (c == null) {
                        a(com.baidu.location.f.getServiceContext());
                    }
                    afn = new d();
                }
            }
        }
        afn.q();
        return afn;
    }

    public long a(String str) {
        return this.afr.a(str);
    }

    public BDLocation a(com.baidu.location.e.a aVar, com.baidu.location.e.e eVar, BDLocation bDLocation, b bVar, a aVar2) {
        String d;
        int i;
        if (bVar == b.IS_MIX_MODE) {
            i = this.afr.a();
            d = com.baidu.location.g.b.tZ().d() + "&mixMode=1";
        } else {
            d = com.baidu.location.g.b.tZ().d();
            i = 0;
        }
        String[] a2 = e.a(aVar, eVar, bDLocation, d, (aVar2 == a.NEED_TO_LOG).booleanValue(), i);
        BDLocation bDLocation2 = null;
        if (a2.length <= 0 || (bDLocation2 = o(a2)) == null || bDLocation2.getLocType() != 67) {
        }
        return bDLocation2;
    }

    public Context b() {
        return c;
    }

    public boolean b(String str) {
        return this.afr.b(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File c() {
        return this.e;
    }

    public boolean d() {
        return this.afr.h();
    }

    public boolean e() {
        return this.afr.i();
    }

    public boolean f() {
        return this.afr.j();
    }

    public boolean g() {
        return this.afr.k();
    }

    public boolean h() {
        return this.afr.m();
    }

    public void i() {
        this.afo.a();
    }

    public void m() {
        if (r()) {
            this.afp.b();
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
            return this.afr.b();
        }
        if (cVar == c.NETWORK_WIFI) {
            return this.afr.c();
        }
        if (cVar == c.NETWORK_2G) {
            return this.afr.bN();
        }
        if (cVar == c.NETWORK_3G) {
            return this.afr.tF();
        }
        if (cVar == c.NETWORK_4G) {
            return this.afr.tG();
        }
        return 0.0d;
    }

    public Cursor p(String[] strArr) {
        return this.afp.a(new e.a(strArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f tJ() {
        return this.afo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g tK() {
        return this.afq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.location.d.c tL() {
        return this.afr;
    }
}
