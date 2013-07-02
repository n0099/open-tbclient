package com.baidu.mapapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements j {
    private MKGeneralListener a;

    public g(MKGeneralListener mKGeneralListener) {
        this.a = mKGeneralListener;
    }

    @Override // com.baidu.mapapi.j
    public void a(MKEvent mKEvent) {
        switch (mKEvent.a) {
            case 7:
                this.a.onGetNetworkState(mKEvent.b);
                return;
            case 8:
            default:
                return;
            case 9:
                this.a.onGetPermissionState(mKEvent.b);
                return;
        }
    }
}
