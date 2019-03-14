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
    BaiduMap bgS;
    private List<OverlayOptions> bjn;
    List<Overlay> bjo;

    public abstract List<OverlayOptions> QM();

    public c(BaiduMap baiduMap) {
        this.bgS = null;
        this.bjn = null;
        this.bjo = null;
        this.bgS = baiduMap;
        if (this.bjn == null) {
            this.bjn = new ArrayList();
        }
        if (this.bjo == null) {
            this.bjo = new ArrayList();
        }
    }

    public final void QO() {
        if (this.bgS != null) {
            QP();
            if (QM() != null) {
                this.bjn.addAll(QM());
            }
            for (OverlayOptions overlayOptions : this.bjn) {
                this.bjo.add(this.bgS.addOverlay(overlayOptions));
            }
        }
    }

    public final void QP() {
        if (this.bgS != null) {
            for (Overlay overlay : this.bjo) {
                overlay.remove();
            }
            this.bjn.clear();
            this.bjo.clear();
        }
    }

    public void QQ() {
        if (this.bgS != null && this.bjo.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.bjo) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.bgS.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
