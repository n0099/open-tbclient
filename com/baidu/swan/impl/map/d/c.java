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
    BaiduMap bnb;
    private List<OverlayOptions> bpu;
    List<Overlay> bpv;

    public abstract List<OverlayOptions> Uw();

    public c(BaiduMap baiduMap) {
        this.bnb = null;
        this.bpu = null;
        this.bpv = null;
        this.bnb = baiduMap;
        if (this.bpu == null) {
            this.bpu = new ArrayList();
        }
        if (this.bpv == null) {
            this.bpv = new ArrayList();
        }
    }

    public final void Uy() {
        if (this.bnb != null) {
            Uz();
            if (Uw() != null) {
                this.bpu.addAll(Uw());
            }
            for (OverlayOptions overlayOptions : this.bpu) {
                this.bpv.add(this.bnb.addOverlay(overlayOptions));
            }
        }
    }

    public final void Uz() {
        if (this.bnb != null) {
            for (Overlay overlay : this.bpv) {
                overlay.remove();
            }
            this.bpu.clear();
            this.bpv.clear();
        }
    }

    public void UA() {
        if (this.bnb != null && this.bpv.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.bpv) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.bnb.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
