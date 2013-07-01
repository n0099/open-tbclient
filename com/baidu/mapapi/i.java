package com.baidu.mapapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements j {

    /* renamed from: a  reason: collision with root package name */
    private MKMapViewListener f557a;

    public i(MKMapViewListener mKMapViewListener) {
        this.f557a = mKMapViewListener;
    }

    @Override // com.baidu.mapapi.j
    public void a(MKEvent mKEvent) {
        if (this.f557a != null) {
            switch (mKEvent.f508a) {
                case 14:
                    this.f557a.onMapMoveFinish();
                    return;
                default:
                    return;
            }
        }
    }
}
