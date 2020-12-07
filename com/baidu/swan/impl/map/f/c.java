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
    private LocationClient ehT;
    private BDLocation ehV;
    private boolean ehW = false;
    private BaiduMap eiu;
    private Marker eiv;
    private BitmapDescriptor ejX;
    private b ekQ;
    private Context mContext;

    /* loaded from: classes25.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.eiu = baiduMap;
    }

    private void bbB() {
        if (this.ehT == null) {
            this.ehT = new LocationClient(this.mContext.getApplicationContext());
            this.ehT.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.ehT.setLocOption(locationClientOption);
            this.ejX = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.ehW && this.ehT != null && this.ehT.isStarted()) {
            this.ehT.stop();
            this.ehW = false;
        }
    }

    private void bbC() {
        if (!this.ehW) {
            bbB();
            if (this.ehT != null && !this.ehT.isStarted()) {
                this.ehT.start();
                this.ehW = true;
            }
        }
    }

    public BDLocation bbG() {
        return this.ehV;
    }

    public void hZ(boolean z) {
        if (z) {
            bbC();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.ekQ = bVar;
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
            c.this.eiu.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.eiv != null) {
                c.this.eiv.remove();
                c.this.eiv = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.ejX).anchor(0.5f, 0.5f);
            c.this.eiv = (Marker) c.this.eiu.addOverlay(anchor);
            if (c.this.ehV == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.ekQ != null) {
                    c.this.ekQ.e(bDLocation);
                }
            }
            c.this.ehV = bDLocation;
        }
    }
}
