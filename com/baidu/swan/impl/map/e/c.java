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
    BaiduMap edb;
    private List<OverlayOptions> efs;
    List<Overlay> eft;

    public abstract List<OverlayOptions> baf();

    public c(BaiduMap baiduMap) {
        this.edb = null;
        this.efs = null;
        this.eft = null;
        this.edb = baiduMap;
        if (this.efs == null) {
            this.efs = new ArrayList();
        }
        if (this.eft == null) {
            this.eft = new ArrayList();
        }
    }

    public final void bag() {
        if (this.edb != null) {
            bah();
            if (baf() != null) {
                this.efs.addAll(baf());
            }
            for (OverlayOptions overlayOptions : this.efs) {
                this.eft.add(this.edb.addOverlay(overlayOptions));
            }
        }
    }

    public final void bah() {
        if (this.edb != null) {
            for (Overlay overlay : this.eft) {
                overlay.remove();
            }
            this.efs.clear();
            this.eft.clear();
        }
    }

    public void bai() {
        if (this.edb != null && this.eft.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.eft) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.edb.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
