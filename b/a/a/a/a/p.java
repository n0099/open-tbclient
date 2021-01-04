package b.a.a.a.a;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.IMConnection;
import com.kwad.sdk.collector.AppStatusRules;
import com.tencent.map.geoloclite.tsa.TencentLiteLocationListener;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class p implements y, Runnable {
    private static SparseArray Au;
    private final w AA;
    private x AB;
    private c AC;
    private g AE;
    private j AF;
    private f AG;
    private ai AH;
    private u AI;
    private aa AJ;
    private af AK;
    private z AM;
    private af AN;
    private ad AP;
    private ad AQ;
    public volatile TencentLiteLocationListener Aw;
    private t Ax;
    private s Ay;
    private HandlerThread Az;
    private volatile int i;
    private long v;
    private List s = null;
    private Location AO = null;
    private long x = 5000;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f1070b = new byte[0];
    private int z = 404;
    private BroadcastReceiver Av = new r(this);

    static {
        SparseArray sparseArray = new SparseArray();
        Au = sparseArray;
        sparseArray.put(0, "OK");
        Au.put(1, "ERROR_NETWORK");
        Au.put(2, "ERROR_NO_CELL&WIFI");
        Au.put(404, "ERROR_SERVER_NOT_LOCATION");
    }

    public p(w wVar) {
        this.i = 0;
        this.AC = null;
        this.AE = null;
        this.AF = null;
        this.AG = null;
        this.AH = null;
        this.i = 0;
        this.AA = wVar;
        this.AB = this.AA.AX;
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.AI = new u(this.AA);
        this.AG = this.AA.c() ? new f(this.AA, this) : null;
        this.AF = this.AA.b() ? new j(this.AA, this) : null;
        if (Build.VERSION.SDK_INT >= 18) {
            this.AC = null;
            this.AE = this.AA.a() ? new g(this.AA, this) : null;
        } else {
            this.AE = null;
            this.AC = this.AA.a() ? new c(this.AA, this) : null;
        }
        try {
            this.AH = new ai(this.AA);
        } catch (Throwable th) {
            this.AH = null;
        }
        if (f(this.AG, this.AF, this.AC, this.AE)) {
            this.i = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ad adVar) {
        boolean z = false;
        if (adVar == null) {
            return;
        }
        if (d()) {
            boolean z2 = this.z != 0 && i == 0;
            this.z = i;
            this.AQ = adVar;
            if (this.Aw != null) {
                e();
            }
            if (z2) {
                a(this.Ax, 1002, null, 0L);
                return;
            }
        }
        if (this.z != 0 && i == 0) {
            z = true;
        }
        if (this.z == 0 && this.AQ != null && this.AQ.getProvider().equals("network") && i == 0 && adVar != null && adVar.getProvider().equals("gps")) {
            z = true;
        }
        if (this.z == 0 && this.AQ != null && this.AQ.getProvider().equals("gps") && i == 0 && adVar != null && adVar.getProvider().equals("network")) {
            z = true;
        }
        this.z = i;
        this.AQ = adVar;
        if (this.Aw != null) {
            if (z || this.x == 0) {
                a(this.Ax, 1002, null, 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Handler handler, int i, Bundle bundle, long j) {
        if (handler == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage(i);
        obtainMessage.setData(bundle);
        if (j == 0) {
            obtainMessage.sendToTarget();
            return;
        }
        handler.removeMessages(i);
        handler.sendMessageDelayed(obtainMessage, j);
    }

    private static void a(ah ahVar) {
        if (ahVar == null || !ahVar.f1054b) {
            return;
        }
        try {
            ahVar.b();
        } catch (Throwable th) {
            new StringBuilder("shutdown ").append(ahVar.d()).append(" failed!");
        }
    }

    private static void a(ah ahVar, Handler handler) {
        if (ahVar == null || ahVar.f1054b) {
            return;
        }
        try {
            ahVar.a(handler);
        } catch (Throwable th) {
            new StringBuilder("starup ").append(ahVar.d()).append(" failed!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return this.z == 404;
    }

    private void e() {
        if (this.x > 0) {
            a(this.Ax, 1001, null, this.x);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        if (this.AG != null) {
            if (this.AG.f()) {
                if (System.currentTimeMillis() - this.AG.c < 30000) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean f(Object... objArr) {
        for (Object obj : objArr) {
            if (obj != null) {
                return false;
            }
        }
        return true;
    }

    private void g() {
        if (this.AJ == null || this.AH == null) {
            return;
        }
        if (this.s == null || this.s.size() == 0) {
            this.s = c.b(this.AA.e);
        }
        if (this.s == null || this.s.size() == 0) {
            return;
        }
        this.AH.a(this.AJ, null, this.s);
        this.AO = new Location(this.AJ.f1049b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ab h(p pVar) {
        z zVar;
        af afVar = pVar.AK;
        aa aaVar = pVar.AJ;
        z zVar2 = pVar.AM;
        aa aaVar2 = (aaVar == null || pVar.f()) ? aaVar : null;
        if (zVar2 == null) {
            w wVar = pVar.AA;
            z a2 = z.a(wVar.e, c.F(wVar.f1081a), null);
            zVar = c.a(a2) ? a2 : null;
        } else {
            zVar = zVar2;
        }
        if (afVar != null) {
            if (!(System.currentTimeMillis() - afVar.c < AppStatusRules.DEFAULT_GRANULARITY)) {
                afVar = null;
            }
        }
        if (f(aaVar2, afVar, zVar)) {
            return null;
        }
        return new ab(afVar, zVar, aaVar2);
    }

    public final int a(long j, TencentLiteLocationListener tencentLiteLocationListener, Looper looper) {
        if (this.i != 0) {
            return this.i;
        }
        b();
        this.z = 404;
        this.AQ = null;
        synchronized (this.f1070b) {
            this.Aw = tencentLiteLocationListener;
        }
        if (this.AB != null && x.g().equals(this.AB.f())) {
            this.AB.a();
        }
        this.x = j;
        this.AB.e = Math.max(this.x, 8000L);
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (this.Ax == null) {
            this.Ax = new t(this, looper);
        } else {
            this.Ax.removeCallbacksAndMessages(null);
            if (this.Ax.getLooper() != looper) {
                this.Ax = new t(this, looper);
            }
        }
        a();
        try {
            if (this.Az == null || !this.Az.isAlive()) {
                this.Az = new HandlerThread("loc_mgr_impl");
                this.Az.start();
                Looper looper2 = this.Az != null ? this.Az.getLooper() : null;
                if (looper2 != null) {
                    this.Ay = new s(this, looper2);
                    this.Ay.post(this);
                }
            }
        } catch (Throwable th) {
        }
        return 0;
    }

    public final void a() {
        c.c = false;
        a(this.AG);
        a(this.AC);
        a(this.AE);
        a(this.AF);
        a(this.AH);
        al.hO().c();
        try {
            this.AA.f1081a.unregisterReceiver(this.Av);
        } catch (Throwable th) {
        }
        if (this.AI != null) {
            this.AI.a();
        }
        if (this.Az == null || !this.Az.isAlive()) {
            return;
        }
        if (this.Ay != null) {
            this.Ay.removeCallbacksAndMessages(null);
            this.Ay = null;
        }
        this.Az.quit();
        this.Az = null;
    }

    @Override // b.a.a.a.a.y
    public final void a(int i, int i2) {
        String str = "";
        String str2 = "";
        switch (i) {
            case 1:
                str = "wifi";
                switch (i2) {
                    case 0:
                        str2 = "wifi disabled";
                        break;
                    case 1:
                        str2 = "wifi enabled";
                        break;
                    case 2:
                    case 3:
                    case 4:
                    default:
                        str2 = "unknown";
                        break;
                    case 5:
                        str2 = "location service switch is off";
                        break;
                }
                if (i2 != 5 && j.d) {
                    str2 = "location permission denied";
                    i2 = 2;
                    break;
                }
                break;
            case 2:
                str = TencentLiteLocationListener.CELL;
                str2 = i2 == 1 ? "cell enabled" : i2 == 0 ? "cell disabled" : "unknown";
                if (c.c) {
                    str2 = "location permission denied";
                    i2 = 2;
                    break;
                }
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putInt("status", i2);
        bundle.putString("desc", str2);
        a(this.Ax, 1003, bundle, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
        if ((b.a.a.a.a.af.a(r9.f1053b, r8.AN.f1053b) ? false : true) == false) goto L47;
     */
    @Override // b.a.a.a.a.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(ac acVar) {
        if (acVar != null) {
            try {
                if (acVar instanceof aa) {
                    aa aaVar = (aa) acVar;
                    if (aaVar != null && aaVar.f1049b != aa.f1048a) {
                        this.AJ = aaVar;
                        ad adVar = this.AP;
                        ae aeVar = new ae();
                        aeVar.Bh = adVar;
                        aeVar.c = "gps";
                        ad hM = aeVar.g(new Location(aaVar.f1049b)).hM();
                        hM.a(aaVar.f1049b);
                        a(0, hM);
                    }
                    a(this.AH, this.Ay);
                    if (this.AO == null || (this.AJ != null && this.AJ.f1049b.distanceTo(this.AO) >= 50.0f)) {
                        g();
                    }
                } else if (acVar instanceof af) {
                    af afVar = (af) acVar;
                    if (this.AK != null && afVar != af.Bl && this.v != -1 && this.AN != null) {
                    }
                    a(this.Ay, 2002, null, 0L);
                    this.AK = afVar;
                    if (this.AJ == null || this.AK == null || this.AH == null) {
                        return;
                    }
                    this.AH.a(this.AJ, this.AK, this.s);
                } else if (acVar instanceof z) {
                    z zVar = (z) acVar;
                    boolean z = this.AM == null || !this.AM.a().equals(zVar.a());
                    this.AM = zVar;
                    this.s = c.b(this.AA.e);
                    int i = this.AF != null ? this.AF.e() ? 0 : 1 : 1;
                    if (i != 0) {
                        this.AK = null;
                    }
                    List b2 = this.AA.b() ? j.b(this.AA.AY) : Collections.EMPTY_LIST;
                    b2.size();
                    if (i == 1 || b2.size() == 0 || (this.v > 0 && System.currentTimeMillis() - this.v > this.x)) {
                        a(this.Ay, 2002, null, 0L);
                    }
                    if (z) {
                        g();
                    }
                    new StringBuilder("cell change run prepare json,because status:").append(i).append(",mLastWF:").append(this.v).append(",current:").append(System.currentTimeMillis());
                }
            } catch (Throwable th) {
            }
        }
    }

    public final void b() {
        this.AJ = null;
        this.AM = null;
        this.AK = null;
        this.AN = null;
        this.v = 0L;
        ab.f1050a = 0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.Ay;
        if (sVar != null) {
            if (this.AI != null) {
                u uVar = this.AI;
                if (!uVar.f1077a) {
                    uVar.f1077a = true;
                    uVar.f1078b.clear();
                    uVar.d = sVar;
                    uVar.AU.c.execute(uVar);
                    uVar.e = SystemClock.elapsedRealtime();
                }
            }
            a(this.AF, sVar);
            a(this.AC, sVar);
            a(this.AE, sVar);
            a(this.AG, sVar);
            sVar.postDelayed(new q(this, sVar), IMConnection.RETRY_DELAY_TIMES);
            if (this.AF != null) {
                this.AF.c = this.AB.e;
            }
            try {
                this.AA.f1081a.registerReceiver(this.Av, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, sVar);
            } catch (Throwable th) {
            }
        }
    }
}
