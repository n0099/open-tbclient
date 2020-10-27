package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap dXk;
    private List<OverlayOptions> dZB;
    List<Overlay> dZC;

    public abstract List<OverlayOptions> aXF();

    public c(BaiduMap baiduMap) {
        this.dXk = null;
        this.dZB = null;
        this.dZC = null;
        this.dXk = baiduMap;
        if (this.dZB == null) {
            this.dZB = new ArrayList();
        }
        if (this.dZC == null) {
            this.dZC = new ArrayList();
        }
    }

    public final void aXG() {
        if (this.dXk != null) {
            aXH();
            if (aXF() != null) {
                this.dZB.addAll(aXF());
            }
            for (OverlayOptions overlayOptions : this.dZB) {
                this.dZC.add(this.dXk.addOverlay(overlayOptions));
            }
        }
    }

    public final void aXH() {
        if (this.dXk != null) {
            for (Overlay overlay : this.dZC) {
                overlay.remove();
            }
            this.dZB.clear();
            this.dZC.clear();
        }
    }

    public void aXI() {
        if (this.dXk != null && this.dZC.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.dZC) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.dXk.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
