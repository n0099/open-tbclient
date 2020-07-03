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
/* loaded from: classes12.dex */
public class c {
    private BaiduMap dkL;
    private Marker dkM;
    private LocationClient dkk;
    private BDLocation dkm;
    private boolean dkn = false;
    private BitmapDescriptor dmn;
    private b dnh;
    private Context mContext;

    /* loaded from: classes12.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.dkL = baiduMap;
    }

    private void aEH() {
        if (this.dkk == null) {
            this.dkk = new LocationClient(this.mContext.getApplicationContext());
            this.dkk.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dkk.setLocOption(locationClientOption);
            this.dmn = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dkn && this.dkk != null && this.dkk.isStarted()) {
            this.dkk.stop();
            this.dkn = false;
        }
    }

    private void aEI() {
        if (!this.dkn) {
            aEH();
            if (this.dkk != null && !this.dkk.isStarted()) {
                this.dkk.start();
                this.dkn = true;
            }
        }
    }

    public BDLocation aEM() {
        return this.dkm;
    }

    public void fY(boolean z) {
        if (z) {
            aEI();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.dnh = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.dkL.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.dkM != null) {
                c.this.dkM.remove();
                c.this.dkM = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.dmn).anchor(0.5f, 0.5f);
            c.this.dkM = (Marker) c.this.dkL.addOverlay(anchor);
            if (c.this.dkm == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.dnh != null) {
                    c.this.dnh.d(bDLocation);
                }
            }
            c.this.dkm = bDLocation;
        }
    }
}
