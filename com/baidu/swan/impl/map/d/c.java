package com.baidu.swan.impl.map.d;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap bGY;
    private List<OverlayOptions> bJq;
    List<Overlay> bJr;

    public abstract List<OverlayOptions> aah();

    public c(BaiduMap baiduMap) {
        this.bGY = null;
        this.bJq = null;
        this.bJr = null;
        this.bGY = baiduMap;
        if (this.bJq == null) {
            this.bJq = new ArrayList();
        }
        if (this.bJr == null) {
            this.bJr = new ArrayList();
        }
    }

    public final void aaj() {
        if (this.bGY != null) {
            aak();
            if (aah() != null) {
                this.bJq.addAll(aah());
            }
            for (OverlayOptions overlayOptions : this.bJq) {
                this.bJr.add(this.bGY.addOverlay(overlayOptions));
            }
        }
    }

    public final void aak() {
        if (this.bGY != null) {
            for (Overlay overlay : this.bJr) {
                overlay.remove();
            }
            this.bJq.clear();
            this.bJr.clear();
        }
    }

    public void aal() {
        if (this.bGY != null && this.bJr.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.bJr) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.bGY.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
