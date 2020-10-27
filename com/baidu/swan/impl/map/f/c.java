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
    private LocationClient dWJ;
    private BDLocation dWL;
    private boolean dWM = false;
    private BaiduMap dXk;
    private Marker dXl;
    private BitmapDescriptor dYM;
    private b dZF;
    private Context mContext;

    /* loaded from: classes25.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.dXk = baiduMap;
    }

    private void aWD() {
        if (this.dWJ == null) {
            this.dWJ = new LocationClient(this.mContext.getApplicationContext());
            this.dWJ.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dWJ.setLocOption(locationClientOption);
            this.dYM = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dWM && this.dWJ != null && this.dWJ.isStarted()) {
            this.dWJ.stop();
            this.dWM = false;
        }
    }

    private void aWE() {
        if (!this.dWM) {
            aWD();
            if (this.dWJ != null && !this.dWJ.isStarted()) {
                this.dWJ.start();
                this.dWM = true;
            }
        }
    }

    public BDLocation aWI() {
        return this.dWL;
    }

    public void hy(boolean z) {
        if (z) {
            aWE();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.dZF = bVar;
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
            c.this.dXk.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.dXl != null) {
                c.this.dXl.remove();
                c.this.dXl = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.dYM).anchor(0.5f, 0.5f);
            c.this.dXl = (Marker) c.this.dXk.addOverlay(anchor);
            if (c.this.dWL == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.dZF != null) {
                    c.this.dZF.e(bDLocation);
                }
            }
            c.this.dWL = bDLocation;
        }
    }
}
