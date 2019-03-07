package cn.jiguang.a.a.b;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b extends PhoneStateListener {
    final /* synthetic */ a kD;

    public b(a aVar) {
        this.kD = aVar;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        this.kD.h = signalStrength.getGsmSignalStrength();
        try {
            this.kD.f();
            this.kD.e();
            this.kD.d();
        } catch (Throwable th) {
            this.kD.e();
            this.kD.d();
        }
    }
}
