package com.baidu.mapapi.map;

import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class ItemizedOverlay extends Overlay {
    MapView a;

    public ItemizedOverlay(Drawable drawable, MapView mapView) {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.marker;
        this.a = mapView;
    }

    public void addItem(OverlayOptions overlayOptions) {
        if (overlayOptions == null || overlayOptions == null) {
            return;
        }
        this.a.getMap().addOverlay(overlayOptions);
    }

    public void reAddAll() {
    }

    public void removeAll() {
        this.a.getMap().clear();
    }
}
