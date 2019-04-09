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
    private LocationClient bgE;
    private BDLocation bgG;
    private boolean bgH = false;
    private BaiduMap bgW;
    private Marker bgX;
    private BitmapDescriptor biA;
    private b bjv;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.bgW = baiduMap;
    }

    private void PM() {
        if (this.bgE == null) {
            this.bgE = new LocationClient(this.mContext.getApplicationContext());
            this.bgE.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bgE.setLocOption(locationClientOption);
            this.biA = BitmapDescriptorFactory.fromResource(d.f.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        if (this.bgH && this.bgE != null && this.bgE.isStarted()) {
            this.bgE.stop();
            this.bgH = false;
        }
    }

    private void PN() {
        if (!this.bgH) {
            PM();
            if (this.bgE != null && !this.bgE.isStarted()) {
                this.bgE.start();
                this.bgH = true;
            }
        }
    }

    public BDLocation PR() {
        return this.bgG;
    }

    public void cC(boolean z) {
        if (z) {
            PN();
        } else {
            ja();
        }
    }

    public void a(b bVar) {
        this.bjv = bVar;
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
            c.this.bgW.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.bgX != null) {
                c.this.bgX.remove();
                c.this.bgX = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.biA).anchor(0.5f, 0.5f);
            c.this.bgX = (Marker) c.this.bgW.addOverlay(anchor);
            if (c.this.bgG == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.bjv != null) {
                    c.this.bjv.d(bDLocation);
                }
            }
            c.this.bgG = bDLocation;
        }
    }
}
