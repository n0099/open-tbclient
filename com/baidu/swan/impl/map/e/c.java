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
    BaiduMap cvK;
    private List<OverlayOptions> cyb;
    List<Overlay> cyc;

    public abstract List<OverlayOptions> asw();

    public c(BaiduMap baiduMap) {
        this.cvK = null;
        this.cyb = null;
        this.cyc = null;
        this.cvK = baiduMap;
        if (this.cyb == null) {
            this.cyb = new ArrayList();
        }
        if (this.cyc == null) {
            this.cyc = new ArrayList();
        }
    }

    public final void asy() {
        if (this.cvK != null) {
            asz();
            if (asw() != null) {
                this.cyb.addAll(asw());
            }
            for (OverlayOptions overlayOptions : this.cyb) {
                this.cyc.add(this.cvK.addOverlay(overlayOptions));
            }
        }
    }

    public final void asz() {
        if (this.cvK != null) {
            for (Overlay overlay : this.cyc) {
                overlay.remove();
            }
            this.cyb.clear();
            this.cyc.clear();
        }
    }

    public void asA() {
        if (this.cvK != null && this.cyc.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.cyc) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.cvK.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
