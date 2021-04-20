package com.alipay.security.mobile.module.deviceinfo;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
/* loaded from: classes.dex */
public final class f extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f2108a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TelephonyManager f2109b;

    public f(e eVar, TelephonyManager telephonyManager) {
        this.f2108a = eVar;
        this.f2109b = telephonyManager;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength != null) {
            this.f2108a.a(signalStrength.getGsmSignalStrength());
        }
        this.f2109b.listen(this, 0);
    }
}
