package com.baidu.mapapi.map;
/* loaded from: classes3.dex */
public final class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.d f2891a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UiSettings(com.baidu.mapsdkplatform.comapi.map.d dVar) {
        this.f2891a = dVar;
    }

    public boolean isCompassEnabled() {
        return this.f2891a.q();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f2891a.x();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f2891a.w();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f2891a.u();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f2891a.v();
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
        this.f2891a.k(z);
    }

    public void setDoubleClickZoomEnabled(boolean z) {
        this.f2891a.s(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f2891a.u(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f2891a.w(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f2891a.v(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f2891a.q(z);
    }

    public void setTwoTouchClickZoomEnabled(boolean z) {
        this.f2891a.t(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f2891a.r(z);
    }
}
