package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes19.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap dAH;
    private List<OverlayOptions> dCZ;
    List<Overlay> dDa;

    public abstract List<OverlayOptions> aSq();

    public c(BaiduMap baiduMap) {
        this.dAH = null;
        this.dCZ = null;
        this.dDa = null;
        this.dAH = baiduMap;
        if (this.dCZ == null) {
            this.dCZ = new ArrayList();
        }
        if (this.dDa == null) {
            this.dDa = new ArrayList();
        }
    }

    public final void aSs() {
        if (this.dAH != null) {
            aSt();
            if (aSq() != null) {
                this.dCZ.addAll(aSq());
            }
            for (OverlayOptions overlayOptions : this.dCZ) {
                this.dDa.add(this.dAH.addOverlay(overlayOptions));
            }
        }
    }

    public final void aSt() {
        if (this.dAH != null) {
            for (Overlay overlay : this.dDa) {
                overlay.remove();
            }
            this.dCZ.clear();
            this.dDa.clear();
        }
    }

    public void aSu() {
        if (this.dAH != null && this.dDa.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.dDa) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.dAH.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
