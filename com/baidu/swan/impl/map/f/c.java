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
/* loaded from: classes24.dex */
public class c {
    private BaiduMap dCM;
    private Marker dCN;
    private LocationClient dCl;
    private BDLocation dCn;
    private boolean dCo = false;
    private BitmapDescriptor dEo;
    private b dFi;
    private Context mContext;

    /* loaded from: classes24.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.dCM = baiduMap;
    }

    private void aSa() {
        if (this.dCl == null) {
            this.dCl = new LocationClient(this.mContext.getApplicationContext());
            this.dCl.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dCl.setLocOption(locationClientOption);
            this.dEo = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dCo && this.dCl != null && this.dCl.isStarted()) {
            this.dCl.stop();
            this.dCo = false;
        }
    }

    private void aSb() {
        if (!this.dCo) {
            aSa();
            if (this.dCl != null && !this.dCl.isStarted()) {
                this.dCl.start();
                this.dCo = true;
            }
        }
    }

    public BDLocation aSf() {
        return this.dCn;
    }

    public void gP(boolean z) {
        if (z) {
            aSb();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.dFi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.dCM.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.dCN != null) {
                c.this.dCN.remove();
                c.this.dCN = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.dEo).anchor(0.5f, 0.5f);
            c.this.dCN = (Marker) c.this.dCM.addOverlay(anchor);
            if (c.this.dCn == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.dFi != null) {
                    c.this.dFi.e(bDLocation);
                }
            }
            c.this.dCn = bDLocation;
        }
    }
}
