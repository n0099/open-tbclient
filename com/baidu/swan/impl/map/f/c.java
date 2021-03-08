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
/* loaded from: classes8.dex */
public class c {
    private LocationClient epS;
    private BDLocation epU;
    private boolean epV = false;
    private BaiduMap eqt;
    private Marker equ;
    private BitmapDescriptor erW;
    private b esP;
    private Context mContext;

    /* loaded from: classes8.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.eqt = baiduMap;
    }

    private void baq() {
        if (this.epS == null) {
            this.epS = new LocationClient(this.mContext.getApplicationContext());
            this.epS.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.epS.setLocOption(locationClientOption);
            this.erW = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.epV && this.epS != null && this.epS.isStarted()) {
            this.epS.stop();
            this.epV = false;
        }
    }

    private void bar() {
        if (!this.epV) {
            baq();
            if (this.epS != null && !this.epS.isStarted()) {
                this.epS.start();
                this.epV = true;
            }
        }
    }

    public BDLocation bav() {
        return this.epU;
    }

    public void ip(boolean z) {
        if (z) {
            bar();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.esP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.eqt.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.equ != null) {
                c.this.equ.remove();
                c.this.equ = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.erW).anchor(0.5f, 0.5f);
            c.this.equ = (Marker) c.this.eqt.addOverlay(anchor);
            if (c.this.epU == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.esP != null) {
                    c.this.esP.d(bDLocation);
                }
            }
            c.this.epU = bDLocation;
        }
    }
}
