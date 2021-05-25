package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public final class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.e f7054a;

    public UiSettings(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        this.f7054a = eVar;
    }

    public boolean isCompassEnabled() {
        return this.f7054a.r();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f7054a.z();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f7054a.y();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f7054a.w();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f7054a.x();
    }

    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f7054a.k(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f7054a.r(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f7054a.t(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f7054a.s(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f7054a.p(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f7054a.q(z);
    }
}
