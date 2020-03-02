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
/* loaded from: classes12.dex */
public class c {
    private BaiduMap cvL;
    private Marker cvM;
    private LocationClient cvk;
    private BDLocation cvm;
    private boolean cvn = false;
    private BitmapDescriptor cxn;
    private b cyg;
    private Context mContext;

    /* loaded from: classes12.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.cvL = baiduMap;
    }

    private void arv() {
        if (this.cvk == null) {
            this.cvk = new LocationClient(this.mContext.getApplicationContext());
            this.cvk.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cvk.setLocOption(locationClientOption);
            this.cxn = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cvn && this.cvk != null && this.cvk.isStarted()) {
            this.cvk.stop();
            this.cvn = false;
        }
    }

    private void arw() {
        if (!this.cvn) {
            arv();
            if (this.cvk != null && !this.cvk.isStarted()) {
                this.cvk.start();
                this.cvn = true;
            }
        }
    }

    public BDLocation arA() {
        return this.cvm;
    }

    public void eK(boolean z) {
        if (z) {
            arw();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.cyg = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.cvL.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.cvM != null) {
                c.this.cvM.remove();
                c.this.cvM = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.cxn).anchor(0.5f, 0.5f);
            c.this.cvM = (Marker) c.this.cvL.addOverlay(anchor);
            if (c.this.cvm == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.cyg != null) {
                    c.this.cyg.d(bDLocation);
                }
            }
            c.this.cvm = bDLocation;
        }
    }
}
