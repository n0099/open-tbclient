package cn.jiguang.a.a.b;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b extends PhoneStateListener {
    final /* synthetic */ a kB;

    public b(a aVar) {
        this.kB = aVar;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        this.kB.h = signalStrength.getGsmSignalStrength();
        try {
            this.kB.f();
            this.kB.e();
            this.kB.d();
        } catch (Throwable th) {
            this.kB.e();
            this.kB.d();
        }
    }
}
