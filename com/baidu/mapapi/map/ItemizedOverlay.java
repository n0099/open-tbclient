package com.baidu.mapapi.map;

import android.graphics.drawable.Drawable;
/* loaded from: classes6.dex */
public class ItemizedOverlay extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    MapView f2723a;

    public ItemizedOverlay(Drawable drawable, MapView mapView) {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.marker;
        this.f2723a = mapView;
    }

    public void addItem(OverlayOptions overlayOptions) {
        if (overlayOptions == null || overlayOptions == null) {
            return;
        }
        this.f2723a.getMap().addOverlay(overlayOptions);
    }

    public void reAddAll() {
    }

    public void removeAll() {
        this.f2723a.getMap().clear();
    }
}
