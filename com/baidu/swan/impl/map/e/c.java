package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap cUY;
    private List<OverlayOptions> cXq;
    List<Overlay> cXr;

    public abstract List<OverlayOptions> aAL();

    public c(BaiduMap baiduMap) {
        this.cUY = null;
        this.cXq = null;
        this.cXr = null;
        this.cUY = baiduMap;
        if (this.cXq == null) {
            this.cXq = new ArrayList();
        }
        if (this.cXr == null) {
            this.cXr = new ArrayList();
        }
    }

    public final void aAN() {
        if (this.cUY != null) {
            aAO();
            if (aAL() != null) {
                this.cXq.addAll(aAL());
            }
            for (OverlayOptions overlayOptions : this.cXq) {
                this.cXr.add(this.cUY.addOverlay(overlayOptions));
            }
        }
    }

    public final void aAO() {
        if (this.cUY != null) {
            for (Overlay overlay : this.cXr) {
                overlay.remove();
            }
            this.cXq.clear();
            this.cXr.clear();
        }
    }

    public void aAP() {
        if (this.cUY != null && this.cXr.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.cXr) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.cUY.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
