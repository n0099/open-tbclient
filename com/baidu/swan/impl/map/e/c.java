package com.baidu.swan.impl.map.e;

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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class c {
    private LocationClient bgD;
    private BDLocation bgF;
    private boolean bgG = false;
    private BaiduMap bgV;
    private Marker bgW;
    private BitmapDescriptor biz;
    private b bju;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.bgV = baiduMap;
    }

    private void PM() {
        if (this.bgD == null) {
            this.bgD = new LocationClient(this.mContext.getApplicationContext());
            this.bgD.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bgD.setLocOption(locationClientOption);
            this.biz = BitmapDescriptorFactory.fromResource(d.f.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        if (this.bgG && this.bgD != null && this.bgD.isStarted()) {
            this.bgD.stop();
            this.bgG = false;
        }
    }

    private void PN() {
        if (!this.bgG) {
            PM();
            if (this.bgD != null && !this.bgD.isStarted()) {
                this.bgD.start();
                this.bgG = true;
            }
        }
    }

    public BDLocation PR() {
        return this.bgF;
    }

    public void cC(boolean z) {
        if (z) {
            PN();
        } else {
            ja();
        }
    }

    public void a(b bVar) {
        this.bju = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.ja();
                return;
            }
            c.this.bgV.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.bgW != null) {
                c.this.bgW.remove();
                c.this.bgW = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.biz).anchor(0.5f, 0.5f);
            c.this.bgW = (Marker) c.this.bgV.addOverlay(anchor);
            if (c.this.bgF == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.bju != null) {
                    c.this.bju.d(bDLocation);
                }
            }
            c.this.bgF = bDLocation;
        }
    }
}
