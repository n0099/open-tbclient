package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public final class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.e f7154a;

    public UiSettings(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        this.f7154a = eVar;
    }

    public boolean isCompassEnabled() {
        return this.f7154a.r();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f7154a.z();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f7154a.y();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f7154a.w();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f7154a.x();
    }

    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f7154a.k(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f7154a.r(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f7154a.t(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f7154a.s(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f7154a.p(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f7154a.q(z);
    }
}
