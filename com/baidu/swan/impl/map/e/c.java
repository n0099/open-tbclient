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
    BaiduMap eoS;
    private List<OverlayOptions> erj;
    List<Overlay> erk;

    public abstract List<OverlayOptions> bbq();

    public c(BaiduMap baiduMap) {
        this.eoS = null;
        this.erj = null;
        this.erk = null;
        this.eoS = baiduMap;
        if (this.erj == null) {
            this.erj = new ArrayList();
        }
        if (this.erk == null) {
            this.erk = new ArrayList();
        }
    }

    public final void bbr() {
        if (this.eoS != null) {
            bbs();
            if (bbq() != null) {
                this.erj.addAll(bbq());
            }
            for (OverlayOptions overlayOptions : this.erj) {
                this.erk.add(this.eoS.addOverlay(overlayOptions));
            }
        }
    }

    public final void bbs() {
        if (this.eoS != null) {
            for (Overlay overlay : this.erk) {
                overlay.remove();
            }
            this.erj.clear();
            this.erk.clear();
        }
    }

    public void bbt() {
        if (this.eoS != null && this.erk.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.erk) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.eoS.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
