package com.baidu.mapapi.map;

import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class ItemizedOverlay extends Overlay {
    public MapView a;

    public void reAddAll() {
    }

    public ItemizedOverlay(Drawable drawable, MapView mapView) {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.c;
        this.a = mapView;
    }

    public void addItem(OverlayOptions overlayOptions) {
        if (overlayOptions != null && overlayOptions != null) {
            this.a.getMap().addOverlay(overlayOptions);
        }
    }

    public void removeAll() {
        this.a.getMap().clear();
    }
}
