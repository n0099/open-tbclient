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
    BaiduMap dfZ;
    private List<OverlayOptions> diu;
    List<Overlay> div;

    public abstract List<OverlayOptions> aED();

    public c(BaiduMap baiduMap) {
        this.dfZ = null;
        this.diu = null;
        this.div = null;
        this.dfZ = baiduMap;
        if (this.diu == null) {
            this.diu = new ArrayList();
        }
        if (this.div == null) {
            this.div = new ArrayList();
        }
    }

    public final void aEF() {
        if (this.dfZ != null) {
            aEG();
            if (aED() != null) {
                this.diu.addAll(aED());
            }
            for (OverlayOptions overlayOptions : this.diu) {
                this.div.add(this.dfZ.addOverlay(overlayOptions));
            }
        }
    }

    public final void aEG() {
        if (this.dfZ != null) {
            for (Overlay overlay : this.div) {
                overlay.remove();
            }
            this.diu.clear();
            this.div.clear();
        }
    }

    public void aEH() {
        if (this.dfZ != null && this.div.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.div) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.dfZ.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
