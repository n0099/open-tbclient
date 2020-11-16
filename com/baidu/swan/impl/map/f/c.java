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
/* loaded from: classes24.dex */
public class c {
    private LocationClient eaS;
    private BDLocation eaU;
    private boolean eaV = false;
    private BaiduMap ebt;
    private Marker ebu;
    private BitmapDescriptor ecW;
    private b edP;
    private Context mContext;

    /* loaded from: classes24.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.ebt = baiduMap;
    }

    private void aYw() {
        if (this.eaS == null) {
            this.eaS = new LocationClient(this.mContext.getApplicationContext());
            this.eaS.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.eaS.setLocOption(locationClientOption);
            this.ecW = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.eaV && this.eaS != null && this.eaS.isStarted()) {
            this.eaS.stop();
            this.eaV = false;
        }
    }

    private void aYx() {
        if (!this.eaV) {
            aYw();
            if (this.eaS != null && !this.eaS.isStarted()) {
                this.eaS.start();
                this.eaV = true;
            }
        }
    }

    public BDLocation aYB() {
        return this.eaU;
    }

    public void hK(boolean z) {
        if (z) {
            aYx();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.edP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.ebt.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.ebu != null) {
                c.this.ebu.remove();
                c.this.ebu = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.ecW).anchor(0.5f, 0.5f);
            c.this.ebu = (Marker) c.this.ebt.addOverlay(anchor);
            if (c.this.eaU == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.edP != null) {
                    c.this.edP.e(bDLocation);
                }
            }
            c.this.eaU = bDLocation;
        }
    }
}
