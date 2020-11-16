package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap ebt;
    private List<OverlayOptions> edL;
    List<Overlay> edM;

    public abstract List<OverlayOptions> aZy();

    public c(BaiduMap baiduMap) {
        this.ebt = null;
        this.edL = null;
        this.edM = null;
        this.ebt = baiduMap;
        if (this.edL == null) {
            this.edL = new ArrayList();
        }
        if (this.edM == null) {
            this.edM = new ArrayList();
        }
    }

    public final void aZz() {
        if (this.ebt != null) {
            aZA();
            if (aZy() != null) {
                this.edL.addAll(aZy());
            }
            for (OverlayOptions overlayOptions : this.edL) {
                this.edM.add(this.ebt.addOverlay(overlayOptions));
            }
        }
    }

    public final void aZA() {
        if (this.ebt != null) {
            for (Overlay overlay : this.edM) {
                overlay.remove();
            }
            this.edL.clear();
            this.edM.clear();
        }
    }

    public void aZB() {
        if (this.ebt != null && this.edM.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.edM) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.ebt.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
