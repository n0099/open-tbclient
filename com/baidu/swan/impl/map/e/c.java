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
    BaiduMap cvM;
    private List<OverlayOptions> cyd;
    List<Overlay> cye;

    public abstract List<OverlayOptions> asy();

    public c(BaiduMap baiduMap) {
        this.cvM = null;
        this.cyd = null;
        this.cye = null;
        this.cvM = baiduMap;
        if (this.cyd == null) {
            this.cyd = new ArrayList();
        }
        if (this.cye == null) {
            this.cye = new ArrayList();
        }
    }

    public final void asA() {
        if (this.cvM != null) {
            asB();
            if (asy() != null) {
                this.cyd.addAll(asy());
            }
            for (OverlayOptions overlayOptions : this.cyd) {
                this.cye.add(this.cvM.addOverlay(overlayOptions));
            }
        }
    }

    public final void asB() {
        if (this.cvM != null) {
            for (Overlay overlay : this.cye) {
                overlay.remove();
            }
            this.cyd.clear();
            this.cye.clear();
        }
    }

    public void asC() {
        if (this.cvM != null && this.cye.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.cye) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.cvM.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
