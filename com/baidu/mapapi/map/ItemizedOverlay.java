package com.baidu.mapapi.map;

import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class ItemizedOverlay extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public MapView f6922a;

    public ItemizedOverlay(Drawable drawable, MapView mapView) {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.marker;
        this.f6922a = mapView;
    }

    public void addItem(OverlayOptions overlayOptions) {
        if (overlayOptions == null || overlayOptions == null) {
            return;
        }
        this.f6922a.getMap().addOverlay(overlayOptions);
    }

    public void reAddAll() {
    }

    public void removeAll() {
        this.f6922a.getMap().clear();
    }
}
