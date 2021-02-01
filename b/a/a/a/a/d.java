package b.a.a.a.a;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class d extends PhoneStateListener {
    private /* synthetic */ c Al;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Al = cVar;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCellLocationChanged(CellLocation cellLocation) {
        boolean b2;
        boolean z;
        super.onCellLocationChanged(cellLocation);
        if (cellLocation == null) {
            return;
        }
        try {
            b2 = this.Al.b(cellLocation);
            if (b2) {
                this.Al.Ah = cellLocation;
                c.e(this.Al);
            } else {
                new StringBuilder("onCellLocationChanged: illegal cell or same cell ").append(cellLocation);
            }
            z = this.Al.i;
            if (z) {
                return;
            }
            c.b(this.Al);
        } catch (Throwable th) {
        }
    }

    @Override // android.telephony.PhoneStateListener
    public final void onServiceStateChanged(ServiceState serviceState) {
        ServiceState serviceState2;
        super.onServiceStateChanged(serviceState);
        if (serviceState == null) {
            return;
        }
        serviceState2 = this.Al.Aj;
        if (serviceState2 == null || serviceState2.getState() != serviceState.getState()) {
            this.Al.Aj = serviceState;
            c.b(this.Al);
        }
    }

    @Override // android.telephony.PhoneStateListener
    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        SignalStrength signalStrength2;
        int i;
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength == null) {
            return;
        }
        try {
            signalStrength2 = this.Al.Ai;
            i = this.Al.e;
            if (signalStrength2 == null || c.a(i, signalStrength2, signalStrength)) {
                this.Al.Ai = signalStrength;
                c.e(this.Al);
            }
        } catch (Throwable th) {
        }
    }
}
