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
    BaiduMap bgW;
    private List<OverlayOptions> bjr;
    List<Overlay> bjs;

    public abstract List<OverlayOptions> QK();

    public c(BaiduMap baiduMap) {
        this.bgW = null;
        this.bjr = null;
        this.bjs = null;
        this.bgW = baiduMap;
        if (this.bjr == null) {
            this.bjr = new ArrayList();
        }
        if (this.bjs == null) {
            this.bjs = new ArrayList();
        }
    }

    public final void QM() {
        if (this.bgW != null) {
            QN();
            if (QK() != null) {
                this.bjr.addAll(QK());
            }
            for (OverlayOptions overlayOptions : this.bjr) {
                this.bjs.add(this.bgW.addOverlay(overlayOptions));
            }
        }
    }

    public final void QN() {
        if (this.bgW != null) {
            for (Overlay overlay : this.bjs) {
                overlay.remove();
            }
            this.bjr.clear();
            this.bjs.clear();
        }
    }

    public void QO() {
        if (this.bgW != null && this.bjs.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.bjs) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.bgW.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
