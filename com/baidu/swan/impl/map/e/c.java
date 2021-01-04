package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap ery;
    private List<OverlayOptions> etR;
    List<Overlay> etS;

    public abstract List<OverlayOptions> beW();

    public c(BaiduMap baiduMap) {
        this.ery = null;
        this.etR = null;
        this.etS = null;
        this.ery = baiduMap;
        if (this.etR == null) {
            this.etR = new ArrayList();
        }
        if (this.etS == null) {
            this.etS = new ArrayList();
        }
    }

    public final void beX() {
        if (this.ery != null) {
            beY();
            if (beW() != null) {
                this.etR.addAll(beW());
            }
            for (OverlayOptions overlayOptions : this.etR) {
                this.etS.add(this.ery.addOverlay(overlayOptions));
            }
        }
    }

    public final void beY() {
        if (this.ery != null) {
            for (Overlay overlay : this.etS) {
                overlay.remove();
            }
            this.etR.clear();
            this.etS.clear();
        }
    }

    public void beZ() {
        if (this.ery != null && this.etS.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.etS) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.ery.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
