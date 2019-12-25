package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap crx;
    private List<OverlayOptions> ctQ;
    List<Overlay> ctR;

    public abstract List<OverlayOptions> apP();

    public c(BaiduMap baiduMap) {
        this.crx = null;
        this.ctQ = null;
        this.ctR = null;
        this.crx = baiduMap;
        if (this.ctQ == null) {
            this.ctQ = new ArrayList();
        }
        if (this.ctR == null) {
            this.ctR = new ArrayList();
        }
    }

    public final void apR() {
        if (this.crx != null) {
            apS();
            if (apP() != null) {
                this.ctQ.addAll(apP());
            }
            for (OverlayOptions overlayOptions : this.ctQ) {
                this.ctR.add(this.crx.addOverlay(overlayOptions));
            }
        }
    }

    public final void apS() {
        if (this.crx != null) {
            for (Overlay overlay : this.ctR) {
                overlay.remove();
            }
            this.ctQ.clear();
            this.ctR.clear();
        }
    }

    public void apT() {
        if (this.crx != null && this.ctR.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.ctR) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.crx.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
