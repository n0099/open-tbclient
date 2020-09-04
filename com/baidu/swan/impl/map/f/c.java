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
/* loaded from: classes19.dex */
public class c {
    private BaiduMap dAL;
    private Marker dAM;
    private LocationClient dAk;
    private BDLocation dAm;
    private boolean dAn = false;
    private BitmapDescriptor dCn;
    private b dDh;
    private Context mContext;

    /* loaded from: classes19.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.dAL = baiduMap;
    }

    private void aRo() {
        if (this.dAk == null) {
            this.dAk = new LocationClient(this.mContext.getApplicationContext());
            this.dAk.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dAk.setLocOption(locationClientOption);
            this.dCn = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dAn && this.dAk != null && this.dAk.isStarted()) {
            this.dAk.stop();
            this.dAn = false;
        }
    }

    private void aRp() {
        if (!this.dAn) {
            aRo();
            if (this.dAk != null && !this.dAk.isStarted()) {
                this.dAk.start();
                this.dAn = true;
            }
        }
    }

    public BDLocation aRt() {
        return this.dAm;
    }

    public void gR(boolean z) {
        if (z) {
            aRp();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.dDh = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.dAL.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.dAM != null) {
                c.this.dAM.remove();
                c.this.dAM = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.dCn).anchor(0.5f, 0.5f);
            c.this.dAM = (Marker) c.this.dAL.addOverlay(anchor);
            if (c.this.dAm == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.dDh != null) {
                    c.this.dDh.e(bDLocation);
                }
            }
            c.this.dAm = bDLocation;
        }
    }
}
