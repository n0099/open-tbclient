package com.baidu.location;

import android.os.Handler;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f486a;

    public v(t tVar) {
        this.f486a = tVar;
    }

    @Override // android.telephony.PhoneStateListener
    public void onCellLocationChanged(CellLocation cellLocation) {
        TelephonyManager telephonyManager;
        if (cellLocation == null) {
            return;
        }
        try {
            t tVar = this.f486a;
            telephonyManager = this.f486a.c;
            tVar.a(telephonyManager.getCellLocation());
        } catch (Exception e) {
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        u uVar;
        u uVar2;
        u uVar3;
        u uVar4;
        u uVar5;
        Handler handler;
        Handler handler2;
        u uVar6;
        uVar = this.f486a.d;
        if (uVar != null) {
            uVar2 = this.f486a.d;
            if (uVar2.g == 'g') {
                uVar6 = this.f486a.d;
                uVar6.f = signalStrength.getGsmSignalStrength();
            } else {
                uVar3 = this.f486a.d;
                if (uVar3.g == 'c') {
                    uVar4 = this.f486a.d;
                    uVar4.f = signalStrength.getCdmaDbm();
                }
            }
            StringBuilder append = new StringBuilder().append("===== cell singal strength changed : ");
            uVar5 = this.f486a.d;
            ap.a("cell strength", append.append(uVar5.f).toString());
            handler = this.f486a.h;
            if (handler != null) {
                handler2 = this.f486a.h;
                handler2.obtainMessage(31).sendToTarget();
            }
        }
    }
}
