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
/* loaded from: classes25.dex */
public class c {
    private LocationClient ecA;
    private BDLocation ecC;
    private boolean ecD = false;
    private BaiduMap edb;
    private Marker edc;
    private BitmapDescriptor eeD;
    private b efw;
    private Context mContext;

    /* loaded from: classes25.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.edb = baiduMap;
    }

    private void aZd() {
        if (this.ecA == null) {
            this.ecA = new LocationClient(this.mContext.getApplicationContext());
            this.ecA.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.ecA.setLocOption(locationClientOption);
            this.eeD = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.ecD && this.ecA != null && this.ecA.isStarted()) {
            this.ecA.stop();
            this.ecD = false;
        }
    }

    private void aZe() {
        if (!this.ecD) {
            aZd();
            if (this.ecA != null && !this.ecA.isStarted()) {
                this.ecA.start();
                this.ecD = true;
            }
        }
    }

    public BDLocation aZi() {
        return this.ecC;
    }

    public void hH(boolean z) {
        if (z) {
            aZe();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.efw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.edb.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.edc != null) {
                c.this.edc.remove();
                c.this.edc = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.eeD).anchor(0.5f, 0.5f);
            c.this.edc = (Marker) c.this.edb.addOverlay(anchor);
            if (c.this.ecC == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.efw != null) {
                    c.this.efw.e(bDLocation);
                }
            }
            c.this.ecC = bDLocation;
        }
    }
}
