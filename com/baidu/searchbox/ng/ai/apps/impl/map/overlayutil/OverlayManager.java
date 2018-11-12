package com.baidu.searchbox.ng.ai.apps.impl.map.overlayutil;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class OverlayManager implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    BaiduMap mBaiduMap;
    List<Overlay> mOverlayList;
    private List<OverlayOptions> mOverlayOptionList;

    public abstract List<OverlayOptions> getOverlayOptions();

    public OverlayManager(BaiduMap baiduMap) {
        this.mBaiduMap = null;
        this.mOverlayOptionList = null;
        this.mOverlayList = null;
        this.mBaiduMap = baiduMap;
        if (this.mOverlayOptionList == null) {
            this.mOverlayOptionList = new ArrayList();
        }
        if (this.mOverlayList == null) {
            this.mOverlayList = new ArrayList();
        }
    }

    public final void addToMap() {
        if (this.mBaiduMap != null) {
            removeFromMap();
            if (getOverlayOptions() != null) {
                this.mOverlayOptionList.addAll(getOverlayOptions());
            }
            for (OverlayOptions overlayOptions : this.mOverlayOptionList) {
                this.mOverlayList.add(this.mBaiduMap.addOverlay(overlayOptions));
            }
        }
    }

    public final void removeFromMap() {
        if (this.mBaiduMap != null) {
            for (Overlay overlay : this.mOverlayList) {
                overlay.remove();
            }
            this.mOverlayOptionList.clear();
            this.mOverlayList.clear();
        }
    }

    public void zoomToSpan() {
        if (this.mBaiduMap != null && this.mOverlayList.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.mOverlayList) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
