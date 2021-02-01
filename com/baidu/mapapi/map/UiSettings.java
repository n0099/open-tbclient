package com.baidu.mapapi.map;
/* loaded from: classes4.dex */
public final class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.e f2778a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UiSettings(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        this.f2778a = eVar;
    }

    public boolean isCompassEnabled() {
        return this.f2778a.r();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f2778a.z();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f2778a.y();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f2778a.w();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f2778a.x();
    }

    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f2778a.j(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f2778a.q(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f2778a.s(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f2778a.r(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f2778a.o(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f2778a.p(z);
    }
}
