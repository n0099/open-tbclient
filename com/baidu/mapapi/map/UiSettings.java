package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public final class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.e f7338a;

    public UiSettings(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        this.f7338a = eVar;
    }

    public boolean isCompassEnabled() {
        return this.f7338a.r();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f7338a.z();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f7338a.y();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f7338a.w();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f7338a.x();
    }

    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f7338a.j(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f7338a.q(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f7338a.s(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f7338a.r(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f7338a.o(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f7338a.p(z);
    }
}
