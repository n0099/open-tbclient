package com.baidu.location;
/* loaded from: classes2.dex */
public abstract class BDAbstractLocationListener {
    public void onConnectHotSpotMessage(String str, int i2) {
    }

    public void onLocDiagnosticMessage(int i2, int i3, String str) {
    }

    public abstract void onReceiveLocation(BDLocation bDLocation);
}
