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
    BaiduMap cvX;
    private List<OverlayOptions> cyo;
    List<Overlay> cyp;

    public abstract List<OverlayOptions> asB();

    public c(BaiduMap baiduMap) {
        this.cvX = null;
        this.cyo = null;
        this.cyp = null;
        this.cvX = baiduMap;
        if (this.cyo == null) {
            this.cyo = new ArrayList();
        }
        if (this.cyp == null) {
            this.cyp = new ArrayList();
        }
    }

    public final void asD() {
        if (this.cvX != null) {
            asE();
            if (asB() != null) {
                this.cyo.addAll(asB());
            }
            for (OverlayOptions overlayOptions : this.cyo) {
                this.cyp.add(this.cvX.addOverlay(overlayOptions));
            }
        }
    }

    public final void asE() {
        if (this.cvX != null) {
            for (Overlay overlay : this.cyp) {
                overlay.remove();
            }
            this.cyo.clear();
            this.cyp.clear();
        }
    }

    public void asF() {
        if (this.cvX != null && this.cyp.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.cyp) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.cvX.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
