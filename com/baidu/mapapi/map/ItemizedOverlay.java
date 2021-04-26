package com.baidu.mapapi.map;

import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class ItemizedOverlay extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public MapView f7164a;

    public ItemizedOverlay(Drawable drawable, MapView mapView) {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.marker;
        this.f7164a = mapView;
    }

    public void addItem(OverlayOptions overlayOptions) {
        if (overlayOptions == null || overlayOptions == null) {
            return;
        }
        this.f7164a.getMap().addOverlay(overlayOptions);
    }

    public void reAddAll() {
    }

    public void removeAll() {
        this.f7164a.getMap().clear();
    }
}
