package cn.jiguang.a.a.b;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b extends PhoneStateListener {
    final /* synthetic */ a jU;

    public b(a aVar) {
        this.jU = aVar;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        this.jU.h = signalStrength.getGsmSignalStrength();
        try {
            this.jU.f();
            this.jU.e();
            this.jU.d();
        } catch (Throwable th) {
            this.jU.e();
            this.jU.d();
        }
    }
}
