package com.baidu.swan.impl.map.f;

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
public class c {
    private BaiduMap emI;
    private Marker emJ;
    private LocationClient emh;
    private BDLocation emj;
    private boolean emk = false;
    private BitmapDescriptor eoo;
    private b eph;
    private Context mContext;

    /* loaded from: classes8.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
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
            this.eoo = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
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

    public BDLocation baf() {
        return this.emj;
    }

    public void in(boolean z) {
        if (z) {
            bab();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.eph = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.emI.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.emJ != null) {
                c.this.emJ.remove();
                c.this.emJ = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.eoo).anchor(0.5f, 0.5f);
            c.this.emJ = (Marker) c.this.emI.addOverlay(anchor);
            if (c.this.emj == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.eph != null) {
                    c.this.eph.d(bDLocation);
                }
            }
            c.this.emj = bDLocation;
        }
    }
}
