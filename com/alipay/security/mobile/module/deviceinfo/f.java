package com.alipay.security.mobile.module.deviceinfo;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
/* loaded from: classes.dex */
public final class f extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f2069a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TelephonyManager f2070b;

    public f(e eVar, TelephonyManager telephonyManager) {
        this.f2069a = eVar;
        this.f2070b = telephonyManager;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength != null) {
            this.f2069a.a(signalStrength.getGsmSignalStrength());
        }
        this.f2070b.listen(this, 0);
    }
}
