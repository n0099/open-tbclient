package com.baidu.mapapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements j {
    private MKMapViewListener a;

    public i(MKMapViewListener mKMapViewListener) {
        this.a = mKMapViewListener;
    }

    @Override // com.baidu.mapapi.j
    public void a(MKEvent mKEvent) {
        if (this.a != null) {
            switch (mKEvent.a) {
                case 14:
                    this.a.onMapMoveFinish();
                    return;
                default:
                    return;
            }
        }
    }
}
