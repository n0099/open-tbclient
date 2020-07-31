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
/* loaded from: classes19.dex */
public class i {
    private BaiduMap dqF;
    private Marker dqG;
    private LocationClient dqe;
    private BDLocation dqg;
    private boolean dqh = false;
    private BitmapDescriptor dsi;
    private b dsj;
    private Context mContext;

    /* loaded from: classes19.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
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
            this.dsi = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation aID() {
        return this.dqg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gu(boolean z) {
        if (z) {
            aIz();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.dsj = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.stopLocation();
                return;
            }
            i.this.dqF.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.dqG != null) {
                i.this.dqG.remove();
                i.this.dqG = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.dsi);
            i.this.dqG = (Marker) i.this.dqF.addOverlay(icon);
            if (i.this.dqg == null) {
                i.this.dqF.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.dsj != null) {
                    i.this.dsj.d(bDLocation);
                }
            }
            i.this.dqg = bDLocation;
        }
    }
}
