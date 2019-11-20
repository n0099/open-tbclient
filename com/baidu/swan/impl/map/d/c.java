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
    BaiduMap bGh;
    List<Overlay> bIA;
    private List<OverlayOptions> bIz;

    public abstract List<OverlayOptions> aaf();

    public c(BaiduMap baiduMap) {
        this.bGh = null;
        this.bIz = null;
        this.bIA = null;
        this.bGh = baiduMap;
        if (this.bIz == null) {
            this.bIz = new ArrayList();
        }
        if (this.bIA == null) {
            this.bIA = new ArrayList();
        }
    }

    public final void aah() {
        if (this.bGh != null) {
            aai();
            if (aaf() != null) {
                this.bIz.addAll(aaf());
            }
            for (OverlayOptions overlayOptions : this.bIz) {
                this.bIA.add(this.bGh.addOverlay(overlayOptions));
            }
        }
    }

    public final void aai() {
        if (this.bGh != null) {
            for (Overlay overlay : this.bIA) {
                overlay.remove();
            }
            this.bIz.clear();
            this.bIA.clear();
        }
    }

    public void aaj() {
        if (this.bGh != null && this.bIA.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.bIA) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.bGh.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
