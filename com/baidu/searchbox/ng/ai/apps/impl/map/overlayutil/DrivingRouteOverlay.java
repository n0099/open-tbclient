package com.baidu.searchbox.ng.ai.apps.impl.map.overlayutil;

import android.graphics.Color;
import android.os.Bundle;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class DrivingRouteOverlay extends OverlayManager {
    protected static final boolean DEBUG = false;
    private static final int LINE_COLOR_DEFAULT = Color.argb(178, 0, 78, 255);
    private boolean focus;
    private DrivingRouteLine mRouteLine;

    public DrivingRouteOverlay(BaiduMap baiduMap) {
        super(baiduMap);
        this.mRouteLine = null;
        this.focus = false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.overlayutil.OverlayManager
    public final List<OverlayOptions> getOverlayOptions() {
        if (this.mRouteLine == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<DrivingRouteLine.DrivingStep> allStep = this.mRouteLine.getAllStep();
        if (allStep != null && allStep.size() > 0) {
            for (DrivingRouteLine.DrivingStep drivingStep : allStep) {
                Bundle bundle = new Bundle();
                bundle.putInt("index", allStep.indexOf(drivingStep));
                if (drivingStep.getEntrance() != null) {
                    arrayList.add(new MarkerOptions().position(drivingStep.getEntrance().getLocation()).anchor(0.5f, 0.5f).zIndex(10).rotate(360 - drivingStep.getDirection()).extraInfo(bundle).icon(BitmapDescriptorFactory.fromResource(e.f.aiapps_icon_line_node)));
                }
                if (allStep.indexOf(drivingStep) == allStep.size() - 1 && drivingStep.getExit() != null) {
                    arrayList.add(new MarkerOptions().position(drivingStep.getExit().getLocation()).anchor(0.5f, 0.5f).zIndex(10).icon(BitmapDescriptorFactory.fromResource(e.f.aiapps_icon_line_node)));
                }
            }
        }
        if (allStep != null && allStep.size() > 0) {
            int size = allStep.size();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                List<LatLng> wayPoints = allStep.get(i2).getWayPoints();
                if (i2 == size - 1) {
                    arrayList2.addAll(wayPoints);
                } else {
                    arrayList2.addAll(wayPoints.subList(0, wayPoints.size() - 1));
                }
                i += wayPoints.size() - 1;
                int[] trafficList = allStep.get(i2).getTrafficList();
                if (trafficList != null && trafficList.length > 0) {
                    for (int i3 : trafficList) {
                        arrayList3.add(Integer.valueOf(i3));
                    }
                }
            }
            boolean z = arrayList3 != null && arrayList3.size() > 0;
            PolylineOptions zIndex = new PolylineOptions().points(arrayList2).textureIndex(arrayList3).width(14).dottedLine(z).focus(true).color(getLineColor() != 0 ? getLineColor() : LINE_COLOR_DEFAULT).zIndex(0);
            if (z) {
                zIndex.customTextureList(getCustomTextureList());
            }
            arrayList.add(zIndex);
        }
        return arrayList;
    }

    public void setData(DrivingRouteLine drivingRouteLine) {
        this.mRouteLine = drivingRouteLine;
    }

    public BitmapDescriptor getStartMarker() {
        return null;
    }

    public int getLineColor() {
        return 0;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_blue_arrow.png"));
        arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_green_arrow.png"));
        arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_yellow_arrow.png"));
        arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_red_arrow.png"));
        arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_nofocus.png"));
        return arrayList;
    }

    public BitmapDescriptor getTerminalMarker() {
        return null;
    }

    public boolean onRouteNodeClick(int i) {
        if (this.mRouteLine.getAllStep() == null || this.mRouteLine.getAllStep().get(i) != null) {
        }
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public final boolean onMarkerClick(Marker marker) {
        for (Overlay overlay : this.mOverlayList) {
            if ((overlay instanceof Marker) && overlay.equals(marker) && marker.getExtraInfo() != null) {
                onRouteNodeClick(marker.getExtraInfo().getInt("index"));
            }
        }
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnPolylineClickListener
    public boolean onPolylineClick(Polyline polyline) {
        boolean z;
        Iterator<Overlay> it = this.mOverlayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Overlay next = it.next();
            if ((next instanceof Polyline) && next.equals(polyline)) {
                z = true;
                break;
            }
        }
        setFocus(z);
        return true;
    }

    public void setFocus(boolean z) {
        this.focus = z;
        for (Overlay overlay : this.mOverlayList) {
            if (overlay instanceof Polyline) {
                ((Polyline) overlay).setFocus(z);
                return;
            }
        }
    }
}
