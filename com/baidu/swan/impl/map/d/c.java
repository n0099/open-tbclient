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
    BaiduMap bnO;
    private List<OverlayOptions> bqh;
    List<Overlay> bqi;

    public abstract List<OverlayOptions> Vo();

    public c(BaiduMap baiduMap) {
        this.bnO = null;
        this.bqh = null;
        this.bqi = null;
        this.bnO = baiduMap;
        if (this.bqh == null) {
            this.bqh = new ArrayList();
        }
        if (this.bqi == null) {
            this.bqi = new ArrayList();
        }
    }

    public final void Vq() {
        if (this.bnO != null) {
            Vr();
            if (Vo() != null) {
                this.bqh.addAll(Vo());
            }
            for (OverlayOptions overlayOptions : this.bqh) {
                this.bqi.add(this.bnO.addOverlay(overlayOptions));
            }
        }
    }

    public final void Vr() {
        if (this.bnO != null) {
            for (Overlay overlay : this.bqi) {
                overlay.remove();
            }
            this.bqh.clear();
            this.bqi.clear();
        }
    }

    public void Vs() {
        if (this.bnO != null && this.bqi.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.bqi) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.bnO.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
