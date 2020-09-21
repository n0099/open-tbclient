package com.baidu.mapapi.map;
/* loaded from: classes3.dex */
public final class UiSettings {
    private com.baidu.mapsdkplatform.comapi.map.d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UiSettings(com.baidu.mapsdkplatform.comapi.map.d dVar) {
        this.a = dVar;
    }

    public boolean isCompassEnabled() {
        return this.a.q();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.a.x();
    }

    public boolean isRotateGesturesEnabled() {
        return this.a.w();
    }

    public boolean isScrollGesturesEnabled() {
        return this.a.u();
    }

    public boolean isZoomGesturesEnabled() {
        return this.a.v();
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
        this.a.k(z);
    }

    public void setDoubleClickZoomEnabled(boolean z) {
        this.a.s(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.a.u(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.a.w(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.a.v(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.a.q(z);
    }

    public void setTwoTouchClickZoomEnabled(boolean z) {
        this.a.t(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.a.r(z);
    }
}
