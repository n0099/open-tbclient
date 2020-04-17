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
    BaiduMap cUT;
    private List<OverlayOptions> cXl;
    List<Overlay> cXm;

    public abstract List<OverlayOptions> aAL();

    public c(BaiduMap baiduMap) {
        this.cUT = null;
        this.cXl = null;
        this.cXm = null;
        this.cUT = baiduMap;
        if (this.cXl == null) {
            this.cXl = new ArrayList();
        }
        if (this.cXm == null) {
            this.cXm = new ArrayList();
        }
    }

    public final void aAN() {
        if (this.cUT != null) {
            aAO();
            if (aAL() != null) {
                this.cXl.addAll(aAL());
            }
            for (OverlayOptions overlayOptions : this.cXl) {
                this.cXm.add(this.cUT.addOverlay(overlayOptions));
            }
        }
    }

    public final void aAO() {
        if (this.cUT != null) {
            for (Overlay overlay : this.cXm) {
                overlay.remove();
            }
            this.cXl.clear();
            this.cXm.clear();
        }
    }

    public void aAP() {
        if (this.cUT != null && this.cXm.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.cXm) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.cUT.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
