package com.baidu.mapapi.map;
/* loaded from: classes6.dex */
public final class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.e f2780a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UiSettings(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        this.f2780a = eVar;
    }

    public boolean isCompassEnabled() {
        return this.f2780a.r();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f2780a.z();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f2780a.y();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f2780a.w();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f2780a.x();
    }

    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f2780a.j(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f2780a.q(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f2780a.s(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f2780a.r(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f2780a.o(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f2780a.p(z);
    }
}
