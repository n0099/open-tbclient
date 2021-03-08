package com.baidu.mapapi.map;
/* loaded from: classes4.dex */
public final class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.e f2055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UiSettings(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        this.f2055a = eVar;
    }

    public boolean isCompassEnabled() {
        return this.f2055a.r();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f2055a.z();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f2055a.y();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f2055a.w();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f2055a.x();
    }

    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f2055a.j(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f2055a.q(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f2055a.s(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f2055a.r(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f2055a.o(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f2055a.p(z);
    }
}
