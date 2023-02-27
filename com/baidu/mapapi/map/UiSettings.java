package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public final class UiSettings {
    public com.baidu.mapsdkplatform.comapi.map.d a;

    public UiSettings(com.baidu.mapsdkplatform.comapi.map.d dVar) {
        this.a = dVar;
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
        this.a.n(z);
    }

    public void setDoubleClickZoomEnabled(boolean z) {
        this.a.v(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.a.x(z);
    }

    public void setFlingEnable(boolean z) {
        this.a.y(z);
    }

    public void setInertialAnimation(boolean z) {
        this.a.u(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.a.A(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.a.z(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.a.s(z);
    }

    public void setTwoTouchClickZoomEnabled(boolean z) {
        this.a.w(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.a.t(z);
    }

    public boolean isCompassEnabled() {
        return this.a.t();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.a.z();
    }

    public boolean isRotateGesturesEnabled() {
        return this.a.y();
    }

    public boolean isScrollGesturesEnabled() {
        return this.a.w();
    }

    public boolean isZoomGesturesEnabled() {
        return this.a.x();
    }
}
