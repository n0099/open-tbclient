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
/* loaded from: classes19.dex */
public class c {
    private BaiduMap dqF;
    private Marker dqG;
    private LocationClient dqe;
    private BDLocation dqg;
    private boolean dqh = false;
    private BitmapDescriptor dsi;
    private b dtd;
    private Context mContext;

    /* loaded from: classes19.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.dqF = baiduMap;
    }

    private void aIy() {
        if (this.dqe == null) {
            this.dqe = new LocationClient(this.mContext.getApplicationContext());
            this.dqe.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dqe.setLocOption(locationClientOption);
            this.dsi = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dqh && this.dqe != null && this.dqe.isStarted()) {
            this.dqe.stop();
            this.dqh = false;
        }
    }

    private void aIz() {
        if (!this.dqh) {
            aIy();
            if (this.dqe != null && !this.dqe.isStarted()) {
                this.dqe.start();
                this.dqh = true;
            }
        }
    }

    public BDLocation aID() {
        return this.dqg;
    }

    public void gu(boolean z) {
        if (z) {
            aIz();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.dtd = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.dqF.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.dqG != null) {
                c.this.dqG.remove();
                c.this.dqG = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.dsi).anchor(0.5f, 0.5f);
            c.this.dqG = (Marker) c.this.dqF.addOverlay(anchor);
            if (c.this.dqg == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.dtd != null) {
                    c.this.dtd.d(bDLocation);
                }
            }
            c.this.dqg = bDLocation;
        }
    }
}
