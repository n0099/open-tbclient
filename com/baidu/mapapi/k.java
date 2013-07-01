package com.baidu.mapapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements j {

    /* renamed from: a  reason: collision with root package name */
    private MKOfflineMapListener f558a;

    public k(MKOfflineMapListener mKOfflineMapListener) {
        this.f558a = mKOfflineMapListener;
    }

    @Override // com.baidu.mapapi.j
    public void a(MKEvent mKEvent) {
        if (this.f558a != null) {
            switch (mKEvent.f508a) {
                case 0:
                case 6:
                    this.f558a.onGetOfflineMapState(mKEvent.f508a, mKEvent.c);
                    return;
                case 4:
                    this.f558a.onGetOfflineMapState(mKEvent.f508a, 0);
                    return;
                default:
                    return;
            }
        }
    }
}
