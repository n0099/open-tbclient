package com.baidu.swan.impl.map.location;

import android.content.Context;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class e {
    private BaiduMap emI;
    private Marker emJ;
    private LocationClient emh;
    private BDLocation emj;
    private boolean emk = false;
    private BitmapDescriptor eoo;
    private b eop;
    private Context mContext;

    /* loaded from: classes8.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.emI = baiduMap;
    }

    private void baa() {
        if (this.emh == null) {
            this.emh = new LocationClient(this.mContext.getApplicationContext());
            this.emh.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.emh.setLocOption(locationClientOption);
            this.eoo = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.emk && this.emh != null && this.emh.isStarted()) {
            this.emh.stop();
            this.emk = false;
        }
    }

    private void bab() {
        if (!this.emk) {
            baa();
            if (this.emh != null && !this.emh.isStarted()) {
                this.emh.start();
                this.emk = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation baf() {
        return this.emj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void in(boolean z) {
        if (z) {
            bab();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.eop = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                e.this.stopLocation();
                return;
            }
            e.this.emI.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (e.this.emJ != null) {
                e.this.emJ.remove();
                e.this.emJ = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(e.this.eoo);
            e.this.emJ = (Marker) e.this.emI.addOverlay(icon);
            if (e.this.emj == null) {
                e.this.emI.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (e.this.eop != null) {
                    e.this.eop.d(bDLocation);
                }
            }
            e.this.emj = bDLocation;
        }
    }
}
