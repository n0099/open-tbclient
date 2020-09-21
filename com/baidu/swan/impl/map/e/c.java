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
    BaiduMap dCM;
    private List<OverlayOptions> dFe;
    List<Overlay> dFf;

    public abstract List<OverlayOptions> aTc();

    public c(BaiduMap baiduMap) {
        this.dCM = null;
        this.dFe = null;
        this.dFf = null;
        this.dCM = baiduMap;
        if (this.dFe == null) {
            this.dFe = new ArrayList();
        }
        if (this.dFf == null) {
            this.dFf = new ArrayList();
        }
    }

    public final void aTe() {
        if (this.dCM != null) {
            aTf();
            if (aTc() != null) {
                this.dFe.addAll(aTc());
            }
            for (OverlayOptions overlayOptions : this.dFe) {
                this.dFf.add(this.dCM.addOverlay(overlayOptions));
            }
        }
    }

    public final void aTf() {
        if (this.dCM != null) {
            for (Overlay overlay : this.dFf) {
                overlay.remove();
            }
            this.dFe.clear();
            this.dFf.clear();
        }
    }

    public void aTg() {
        if (this.dCM != null && this.dFf.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.dFf) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.dCM.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
