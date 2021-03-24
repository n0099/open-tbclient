package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public final class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.e f7048a;

    public UiSettings(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        this.f7048a = eVar;
    }

    public boolean isCompassEnabled() {
        return this.f7048a.r();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f7048a.z();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f7048a.y();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f7048a.w();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f7048a.x();
    }

    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f7048a.j(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f7048a.q(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f7048a.s(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f7048a.r(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f7048a.o(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f7048a.p(z);
    }
}
