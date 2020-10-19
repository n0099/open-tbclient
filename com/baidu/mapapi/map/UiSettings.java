package com.baidu.mapapi.map;
/* loaded from: classes7.dex */
public final class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.d f2050a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UiSettings(com.baidu.mapsdkplatform.comapi.map.d dVar) {
        this.f2050a = dVar;
    }

    public boolean isCompassEnabled() {
        return this.f2050a.q();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f2050a.x();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f2050a.w();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f2050a.u();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f2050a.v();
    }

    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setDoubleClickZoomEnabled(z);
        setTwoTouchClickZoomEnabled(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f2050a.k(z);
    }

    public void setDoubleClickZoomEnabled(boolean z) {
        this.f2050a.s(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f2050a.u(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f2050a.w(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f2050a.v(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f2050a.q(z);
    }

    public void setTwoTouchClickZoomEnabled(boolean z) {
        this.f2050a.t(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f2050a.r(z);
    }
}
