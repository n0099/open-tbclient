package com.baidu.mapapi.map;

import android.graphics.drawable.Drawable;
/* loaded from: classes7.dex */
public class ItemizedOverlay extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    MapView f2014a;

    public ItemizedOverlay(Drawable drawable, MapView mapView) {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.marker;
        this.f2014a = mapView;
    }

    public void addItem(OverlayOptions overlayOptions) {
        if (overlayOptions == null || overlayOptions == null) {
            return;
        }
        this.f2014a.getMap().addOverlay(overlayOptions);
    }

    public void reAddAll() {
    }

    public void removeAll() {
        this.f2014a.getMap().clear();
    }
}
