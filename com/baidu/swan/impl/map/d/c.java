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
    BaiduMap bgV;
    private List<OverlayOptions> bjq;
    List<Overlay> bjr;

    public abstract List<OverlayOptions> QK();

    public c(BaiduMap baiduMap) {
        this.bgV = null;
        this.bjq = null;
        this.bjr = null;
        this.bgV = baiduMap;
        if (this.bjq == null) {
            this.bjq = new ArrayList();
        }
        if (this.bjr == null) {
            this.bjr = new ArrayList();
        }
    }

    public final void QM() {
        if (this.bgV != null) {
            QN();
            if (QK() != null) {
                this.bjq.addAll(QK());
            }
            for (OverlayOptions overlayOptions : this.bjq) {
                this.bjr.add(this.bgV.addOverlay(overlayOptions));
            }
        }
    }

    public final void QN() {
        if (this.bgV != null) {
            for (Overlay overlay : this.bjr) {
                overlay.remove();
            }
            this.bjq.clear();
            this.bjr.clear();
        }
    }

    public void QO() {
        if (this.bgV != null && this.bjr.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.bjr) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.bgV.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
