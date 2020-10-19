package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap dON;
    private List<OverlayOptions> dRf;
    List<Overlay> dRg;

    public abstract List<OverlayOptions> aVL();

    public c(BaiduMap baiduMap) {
        this.dON = null;
        this.dRf = null;
        this.dRg = null;
        this.dON = baiduMap;
        if (this.dRf == null) {
            this.dRf = new ArrayList();
        }
        if (this.dRg == null) {
            this.dRg = new ArrayList();
        }
    }

    public final void aVN() {
        if (this.dON != null) {
            aVO();
            if (aVL() != null) {
                this.dRf.addAll(aVL());
            }
            for (OverlayOptions overlayOptions : this.dRf) {
                this.dRg.add(this.dON.addOverlay(overlayOptions));
            }
        }
    }

    public final void aVO() {
        if (this.dON != null) {
            for (Overlay overlay : this.dRg) {
                overlay.remove();
            }
            this.dRf.clear();
            this.dRg.clear();
        }
    }

    public void aVP() {
        if (this.dON != null && this.dRg.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.dRg) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.dON.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
