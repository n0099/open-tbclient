package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes19.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap dqF;
    private List<OverlayOptions> dsZ;
    List<Overlay> dta;

    public abstract List<OverlayOptions> aJA();

    public c(BaiduMap baiduMap) {
        this.dqF = null;
        this.dsZ = null;
        this.dta = null;
        this.dqF = baiduMap;
        if (this.dsZ == null) {
            this.dsZ = new ArrayList();
        }
        if (this.dta == null) {
            this.dta = new ArrayList();
        }
    }

    public final void aJC() {
        if (this.dqF != null) {
            aJD();
            if (aJA() != null) {
                this.dsZ.addAll(aJA());
            }
            for (OverlayOptions overlayOptions : this.dsZ) {
                this.dta.add(this.dqF.addOverlay(overlayOptions));
            }
        }
    }

    public final void aJD() {
        if (this.dqF != null) {
            for (Overlay overlay : this.dta) {
                overlay.remove();
            }
            this.dsZ.clear();
            this.dta.clear();
        }
    }

    public void aJE() {
        if (this.dqF != null && this.dta.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.dta) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.dqF.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
