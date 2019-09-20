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
    BaiduMap bom;
    private List<OverlayOptions> bqF;
    List<Overlay> bqG;

    public abstract List<OverlayOptions> Vs();

    public c(BaiduMap baiduMap) {
        this.bom = null;
        this.bqF = null;
        this.bqG = null;
        this.bom = baiduMap;
        if (this.bqF == null) {
            this.bqF = new ArrayList();
        }
        if (this.bqG == null) {
            this.bqG = new ArrayList();
        }
    }

    public final void Vu() {
        if (this.bom != null) {
            Vv();
            if (Vs() != null) {
                this.bqF.addAll(Vs());
            }
            for (OverlayOptions overlayOptions : this.bqF) {
                this.bqG.add(this.bom.addOverlay(overlayOptions));
            }
        }
    }

    public final void Vv() {
        if (this.bom != null) {
            for (Overlay overlay : this.bqG) {
                overlay.remove();
            }
            this.bqF.clear();
            this.bqG.clear();
        }
    }

    public void Vw() {
        if (this.bom != null && this.bqG.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.bqG) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.bom.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
