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
    BaiduMap dkL;
    private List<OverlayOptions> dnd;
    List<Overlay> dne;

    public abstract List<OverlayOptions> aFJ();

    public c(BaiduMap baiduMap) {
        this.dkL = null;
        this.dnd = null;
        this.dne = null;
        this.dkL = baiduMap;
        if (this.dnd == null) {
            this.dnd = new ArrayList();
        }
        if (this.dne == null) {
            this.dne = new ArrayList();
        }
    }

    public final void aFL() {
        if (this.dkL != null) {
            aFM();
            if (aFJ() != null) {
                this.dnd.addAll(aFJ());
            }
            for (OverlayOptions overlayOptions : this.dnd) {
                this.dne.add(this.dkL.addOverlay(overlayOptions));
            }
        }
    }

    public final void aFM() {
        if (this.dkL != null) {
            for (Overlay overlay : this.dne) {
                overlay.remove();
            }
            this.dnd.clear();
            this.dne.clear();
        }
    }

    public void aFN() {
        if (this.dkL != null && this.dne.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.dne) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.dkL.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
