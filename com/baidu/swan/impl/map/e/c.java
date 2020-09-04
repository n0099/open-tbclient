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
    BaiduMap dAL;
    private List<OverlayOptions> dDd;
    List<Overlay> dDe;

    public abstract List<OverlayOptions> aSq();

    public c(BaiduMap baiduMap) {
        this.dAL = null;
        this.dDd = null;
        this.dDe = null;
        this.dAL = baiduMap;
        if (this.dDd == null) {
            this.dDd = new ArrayList();
        }
        if (this.dDe == null) {
            this.dDe = new ArrayList();
        }
    }

    public final void aSs() {
        if (this.dAL != null) {
            aSt();
            if (aSq() != null) {
                this.dDd.addAll(aSq());
            }
            for (OverlayOptions overlayOptions : this.dDd) {
                this.dDe.add(this.dAL.addOverlay(overlayOptions));
            }
        }
    }

    public final void aSt() {
        if (this.dAL != null) {
            for (Overlay overlay : this.dDe) {
                overlay.remove();
            }
            this.dDd.clear();
            this.dDe.clear();
        }
    }

    public void aSu() {
        if (this.dAL != null && this.dDe.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.dDe) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.dAL.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
