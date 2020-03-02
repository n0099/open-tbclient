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
    BaiduMap cvL;
    private List<OverlayOptions> cyc;
    List<Overlay> cyd;

    public abstract List<OverlayOptions> asy();

    public c(BaiduMap baiduMap) {
        this.cvL = null;
        this.cyc = null;
        this.cyd = null;
        this.cvL = baiduMap;
        if (this.cyc == null) {
            this.cyc = new ArrayList();
        }
        if (this.cyd == null) {
            this.cyd = new ArrayList();
        }
    }

    public final void asA() {
        if (this.cvL != null) {
            asB();
            if (asy() != null) {
                this.cyc.addAll(asy());
            }
            for (OverlayOptions overlayOptions : this.cyc) {
                this.cyd.add(this.cvL.addOverlay(overlayOptions));
            }
        }
    }

    public final void asB() {
        if (this.cvL != null) {
            for (Overlay overlay : this.cyd) {
                overlay.remove();
            }
            this.cyc.clear();
            this.cyd.clear();
        }
    }

    public void asC() {
        if (this.cvL != null && this.cyd.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.cyd) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.cvL.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
