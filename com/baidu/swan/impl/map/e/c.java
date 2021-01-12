package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap emI;
    private List<OverlayOptions> epd;
    List<Overlay> epe;

    public abstract List<OverlayOptions> bbd();

    public c(BaiduMap baiduMap) {
        this.emI = null;
        this.epd = null;
        this.epe = null;
        this.emI = baiduMap;
        if (this.epd == null) {
            this.epd = new ArrayList();
        }
        if (this.epe == null) {
            this.epe = new ArrayList();
        }
    }

    public final void bbe() {
        if (this.emI != null) {
            bbf();
            if (bbd() != null) {
                this.epd.addAll(bbd());
            }
            for (OverlayOptions overlayOptions : this.epd) {
                this.epe.add(this.emI.addOverlay(overlayOptions));
            }
        }
    }

    public final void bbf() {
        if (this.emI != null) {
            for (Overlay overlay : this.epe) {
                overlay.remove();
            }
            this.epd.clear();
            this.epe.clear();
        }
    }

    public void bbg() {
        if (this.emI != null && this.epe.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.epe) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.emI.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
