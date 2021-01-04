package b.a.a.a.a;

import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h extends PhoneStateListener {
    private /* synthetic */ g Ar;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.Ar = gVar;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCellInfoChanged(List list) {
        z a2;
        super.onCellInfoChanged(list);
        if (list != null) {
            try {
                if (list.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        CellInfo cellInfo = (CellInfo) it.next();
                        if (cellInfo.isRegistered() && (a2 = z.a(this.Ar.Bm.e, cellInfo)) != null) {
                            if (a2.f1085b >= 0 && a2.c >= 0 && a2.f1085b != 535 && a2.c != 535) {
                                arrayList.add(a2);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        g.a(this.Ar, arrayList);
                        return;
                    }
                }
            } catch (Throwable th) {
                return;
            }
        }
        CellLocation F = c.F(this.Ar.Bm.f1081a);
        if (F != null) {
            ArrayList arrayList2 = new ArrayList();
            z a3 = z.a(this.Ar.Bm.e, F, null);
            if (a3 != null) {
                arrayList2.add(a3);
            }
            g.a(this.Ar, arrayList2);
        } else if (this.Ar.Ao != null) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(this.Ar.Ao);
            g.a(this.Ar, arrayList3);
        }
        if (this.Ar.f) {
            return;
        }
        g.a(this.Ar);
    }

    @Override // android.telephony.PhoneStateListener
    public final void onServiceStateChanged(ServiceState serviceState) {
        super.onServiceStateChanged(serviceState);
        if (serviceState == null) {
            return;
        }
        try {
            ServiceState serviceState2 = this.Ar.Ap;
            if (serviceState2 == null || serviceState2.getState() != serviceState.getState()) {
                this.Ar.Ap = serviceState;
                g.a(this.Ar);
            }
        } catch (Throwable th) {
        }
    }
}
