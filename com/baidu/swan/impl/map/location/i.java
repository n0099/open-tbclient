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
/* loaded from: classes12.dex */
public class i {
    private BaiduMap dkL;
    private Marker dkM;
    private LocationClient dkk;
    private BDLocation dkm;
    private boolean dkn = false;
    private BitmapDescriptor dmn;
    private b dmo;
    private Context mContext;

    /* loaded from: classes12.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
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
            this.dmn = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation aEM() {
        return this.dkm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fY(boolean z) {
        if (z) {
            aEI();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.dmo = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.stopLocation();
                return;
            }
            i.this.dkL.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.dkM != null) {
                i.this.dkM.remove();
                i.this.dkM = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.dmn);
            i.this.dkM = (Marker) i.this.dkL.addOverlay(icon);
            if (i.this.dkm == null) {
                i.this.dkL.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.dmo != null) {
                    i.this.dmo.d(bDLocation);
                }
            }
            i.this.dkm = bDLocation;
        }
    }
}
