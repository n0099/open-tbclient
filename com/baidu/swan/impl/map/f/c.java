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
/* loaded from: classes10.dex */
public class c {
    private BaiduMap crI;
    private Marker crJ;
    private LocationClient crh;
    private BDLocation crj;
    private boolean crk = false;
    private BitmapDescriptor ctk;
    private b cuf;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.crI = baiduMap;
    }

    private void apf() {
        if (this.crh == null) {
            this.crh = new LocationClient(this.mContext.getApplicationContext());
            this.crh.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.crh.setLocOption(locationClientOption);
            this.ctk = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.crk && this.crh != null && this.crh.isStarted()) {
            this.crh.stop();
            this.crk = false;
        }
    }

    private void apg() {
        if (!this.crk) {
            apf();
            if (this.crh != null && !this.crh.isStarted()) {
                this.crh.start();
                this.crk = true;
            }
        }
    }

    public BDLocation apl() {
        return this.crj;
    }

    public void eD(boolean z) {
        if (z) {
            apg();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.cuf = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.crI.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.crJ != null) {
                c.this.crJ.remove();
                c.this.crJ = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.ctk).anchor(0.5f, 0.5f);
            c.this.crJ = (Marker) c.this.crI.addOverlay(anchor);
            if (c.this.crj == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.cuf != null) {
                    c.this.cuf.d(bDLocation);
                }
            }
            c.this.crj = bDLocation;
        }
    }
}
