package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap crI;
    private List<OverlayOptions> cub;
    List<Overlay> cuc;

    public abstract List<OverlayOptions> aqi();

    public c(BaiduMap baiduMap) {
        this.crI = null;
        this.cub = null;
        this.cuc = null;
        this.crI = baiduMap;
        if (this.cub == null) {
            this.cub = new ArrayList();
        }
        if (this.cuc == null) {
            this.cuc = new ArrayList();
        }
    }

    public final void aqk() {
        if (this.crI != null) {
            aql();
            if (aqi() != null) {
                this.cub.addAll(aqi());
            }
            for (OverlayOptions overlayOptions : this.cub) {
                this.cuc.add(this.crI.addOverlay(overlayOptions));
            }
        }
    }

    public final void aql() {
        if (this.crI != null) {
            for (Overlay overlay : this.cuc) {
                overlay.remove();
            }
            this.cub.clear();
            this.cuc.clear();
        }
    }

    public void aqm() {
        if (this.crI != null && this.cuc.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.cuc) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.crI.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
