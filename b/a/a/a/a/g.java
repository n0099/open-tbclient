package b.a.a.a.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public final class g extends ag {
    TelephonyManager An;
    volatile z Ao;
    ServiceState Ap;
    @SuppressLint({"NewApi"})
    PhoneStateListener Aq;
    boolean f;
    Handler g;
    private List i;
    private long j;

    public g(w wVar, y yVar) {
        super(wVar, yVar);
        this.An = null;
        this.Ao = null;
        this.Ap = null;
        this.f = false;
        this.j = 0L;
        this.g = null;
        this.Aq = new h(this);
        this.An = this.Bk.e;
    }

    private void a(int i) {
        try {
            if (this.An != null) {
                this.An.listen(this.Aq, i);
            }
        } catch (Throwable th) {
            new StringBuilder("listenCellState: failed! flags=").append(i).append(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar) {
        if (gVar.f1054b) {
            gVar.f = true;
            c.a(gVar.Ap, gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar, List list) {
        if (list.size() <= 0) {
            return;
        }
        z zVar = null;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            z zVar2 = (z) it.next();
            arrayList.add(zVar2.a());
            if (gVar.i == null || gVar.i.contains(zVar2.a())) {
                zVar2 = zVar;
            }
            zVar = zVar2;
        }
        gVar.i = arrayList;
        if (zVar != null) {
            gVar.Ao = zVar;
            if (!gVar.f1054b || gVar.Ao == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - gVar.j > 2000) {
                gVar.j = currentTimeMillis;
                gVar.b(2);
            }
        }
    }

    private void b(int i) {
        if (this.g != null) {
            this.g.obtainMessage(i).sendToTarget();
        }
    }

    @Override // b.a.a.a.a.ah
    public final void b(Handler handler) {
        this.g = new i(this, handler.getLooper(), (byte) 0);
        if (this.i == null) {
            this.i = new ArrayList();
        }
        this.i.clear();
        this.j = 0L;
        b(1);
        this.f = false;
        a(1025);
    }

    @Override // b.a.a.a.a.ah
    public final void c() {
        a(0);
        if (this.g != null) {
            this.g.removeCallbacksAndMessages(null);
            this.g = null;
        }
        this.Ap = null;
    }

    @Override // b.a.a.a.a.ah
    public final String d() {
        return "NewCellPro";
    }
}
