package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public final class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.e f7084a;

    public UiSettings(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        this.f7084a = eVar;
    }

    public boolean isCompassEnabled() {
        return this.f7084a.r();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f7084a.z();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f7084a.y();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f7084a.w();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f7084a.x();
    }

    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f7084a.j(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f7084a.q(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f7084a.s(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f7084a.r(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f7084a.o(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f7084a.p(z);
    }
}
