package com.baidu.location;
/* loaded from: classes20.dex */
public abstract class BDAbstractLocationListener {
    public void onConnectHotSpotMessage(String str, int i) {
    }

    public void onLocDiagnosticMessage(int i, int i2, String str) {
    }

    public abstract void onReceiveLocation(BDLocation bDLocation);

    public void onReceiveVdrLocation(BDLocation bDLocation) {
    }
}
