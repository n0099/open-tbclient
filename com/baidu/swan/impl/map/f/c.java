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
/* loaded from: classes9.dex */
public class c {
    private LocationClient cqV;
    private BDLocation cqX;
    private boolean cqY = false;
    private BaiduMap crx;
    private Marker cry;
    private BitmapDescriptor csZ;
    private b ctU;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.crx = baiduMap;
    }

    private void aoM() {
        if (this.cqV == null) {
            this.cqV = new LocationClient(this.mContext.getApplicationContext());
            this.cqV.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cqV.setLocOption(locationClientOption);
            this.csZ = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cqY && this.cqV != null && this.cqV.isStarted()) {
            this.cqV.stop();
            this.cqY = false;
        }
    }

    private void aoN() {
        if (!this.cqY) {
            aoM();
            if (this.cqV != null && !this.cqV.isStarted()) {
                this.cqV.start();
                this.cqY = true;
            }
        }
    }

    public BDLocation aoR() {
        return this.cqX;
    }

    public void ey(boolean z) {
        if (z) {
            aoN();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.ctU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.crx.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.cry != null) {
                c.this.cry.remove();
                c.this.cry = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.csZ).anchor(0.5f, 0.5f);
            c.this.cry = (Marker) c.this.crx.addOverlay(anchor);
            if (c.this.cqX == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.ctU != null) {
                    c.this.ctU.d(bDLocation);
                }
            }
            c.this.cqX = bDLocation;
        }
    }
}
