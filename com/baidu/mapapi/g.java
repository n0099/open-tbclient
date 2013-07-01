package com.baidu.mapapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements j {

    /* renamed from: a  reason: collision with root package name */
    private MKGeneralListener f555a;

    public g(MKGeneralListener mKGeneralListener) {
        this.f555a = mKGeneralListener;
    }

    @Override // com.baidu.mapapi.j
    public void a(MKEvent mKEvent) {
        switch (mKEvent.f508a) {
            case 7:
                this.f555a.onGetNetworkState(mKEvent.b);
                return;
            case 8:
            default:
                return;
            case 9:
                this.f555a.onGetPermissionState(mKEvent.b);
                return;
        }
    }
}
