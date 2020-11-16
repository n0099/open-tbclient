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
/* loaded from: classes24.dex */
public class i {
    private LocationClient eaS;
    private BDLocation eaU;
    private boolean eaV = false;
    private BaiduMap ebt;
    private Marker ebu;
    private BitmapDescriptor ecW;
    private b ecX;
    private Context mContext;

    /* loaded from: classes24.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
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
            this.ecW = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation aYB() {
        return this.eaU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hK(boolean z) {
        if (z) {
            aYx();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.ecX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.stopLocation();
                return;
            }
            i.this.ebt.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.ebu != null) {
                i.this.ebu.remove();
                i.this.ebu = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.ecW);
            i.this.ebu = (Marker) i.this.ebt.addOverlay(icon);
            if (i.this.eaU == null) {
                i.this.ebt.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.ecX != null) {
                    i.this.ecX.e(bDLocation);
                }
            }
            i.this.eaU = bDLocation;
        }
    }
}
