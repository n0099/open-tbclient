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
/* loaded from: classes9.dex */
public class e {
    private LocationClient eqW;
    private BDLocation eqY;
    private boolean eqZ = false;
    private BaiduMap ery;
    private Marker erz;
    private BitmapDescriptor etb;
    private b etd;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.ery = baiduMap;
    }

    private void bdT() {
        if (this.eqW == null) {
            this.eqW = new LocationClient(this.mContext.getApplicationContext());
            this.eqW.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.eqW.setLocOption(locationClientOption);
            this.etb = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.eqZ && this.eqW != null && this.eqW.isStarted()) {
            this.eqW.stop();
            this.eqZ = false;
        }
    }

    private void bdU() {
        if (!this.eqZ) {
            bdT();
            if (this.eqW != null && !this.eqW.isStarted()) {
                this.eqW.start();
                this.eqZ = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation bdY() {
        return this.eqY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ir(boolean z) {
        if (z) {
            bdU();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.etd = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                e.this.stopLocation();
                return;
            }
            e.this.ery.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (e.this.erz != null) {
                e.this.erz.remove();
                e.this.erz = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(e.this.etb);
            e.this.erz = (Marker) e.this.ery.addOverlay(icon);
            if (e.this.eqY == null) {
                e.this.ery.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (e.this.etd != null) {
                    e.this.etd.e(bDLocation);
                }
            }
            e.this.eqY = bDLocation;
        }
    }
}
