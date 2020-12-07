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
    BaiduMap eiu;
    private List<OverlayOptions> ekM;
    List<Overlay> ekN;

    public abstract List<OverlayOptions> bcD();

    public c(BaiduMap baiduMap) {
        this.eiu = null;
        this.ekM = null;
        this.ekN = null;
        this.eiu = baiduMap;
        if (this.ekM == null) {
            this.ekM = new ArrayList();
        }
        if (this.ekN == null) {
            this.ekN = new ArrayList();
        }
    }

    public final void bcE() {
        if (this.eiu != null) {
            bcF();
            if (bcD() != null) {
                this.ekM.addAll(bcD());
            }
            for (OverlayOptions overlayOptions : this.ekM) {
                this.ekN.add(this.eiu.addOverlay(overlayOptions));
            }
        }
    }

    public final void bcF() {
        if (this.eiu != null) {
            for (Overlay overlay : this.ekN) {
                overlay.remove();
            }
            this.ekM.clear();
            this.ekN.clear();
        }
    }

    public void bcG() {
        if (this.eiu != null && this.ekN.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.ekN) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.eiu.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
