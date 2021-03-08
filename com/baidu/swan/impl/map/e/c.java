package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap eqt;
    private List<OverlayOptions> esL;
    List<Overlay> esM;

    public abstract List<OverlayOptions> bbs();

    public c(BaiduMap baiduMap) {
        this.eqt = null;
        this.esL = null;
        this.esM = null;
        this.eqt = baiduMap;
        if (this.esL == null) {
            this.esL = new ArrayList();
        }
        if (this.esM == null) {
            this.esM = new ArrayList();
        }
    }

    public final void bbt() {
        if (this.eqt != null) {
            bbu();
            if (bbs() != null) {
                this.esL.addAll(bbs());
            }
            for (OverlayOptions overlayOptions : this.esL) {
                this.esM.add(this.eqt.addOverlay(overlayOptions));
            }
        }
    }

    public final void bbu() {
        if (this.eqt != null) {
            for (Overlay overlay : this.esM) {
                overlay.remove();
            }
            this.esL.clear();
            this.esM.clear();
        }
    }

    public void bbv() {
        if (this.eqt != null && this.esM.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.esM) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.eqt.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
