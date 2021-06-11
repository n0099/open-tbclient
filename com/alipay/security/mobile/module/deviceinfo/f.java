package com.alipay.security.mobile.module.deviceinfo;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
/* loaded from: classes.dex */
public final class f extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f2082a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TelephonyManager f2083b;

    public f(e eVar, TelephonyManager telephonyManager) {
        this.f2082a = eVar;
        this.f2083b = telephonyManager;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength != null) {
            this.f2082a.a(signalStrength.getGsmSignalStrength());
        }
        this.f2083b.listen(this, 0);
    }
}
