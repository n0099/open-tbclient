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
    private boolean cUA = false;
    private BaiduMap cUY;
    private Marker cUZ;
    private LocationClient cUx;
    private BDLocation cUz;
    private BitmapDescriptor cWA;
    private b cXu;
    private Context mContext;

    /* loaded from: classes12.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.cUY = baiduMap;
    }

    private void azJ() {
        if (this.cUx == null) {
            this.cUx = new LocationClient(this.mContext.getApplicationContext());
            this.cUx.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cUx.setLocOption(locationClientOption);
            this.cWA = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cUA && this.cUx != null && this.cUx.isStarted()) {
            this.cUx.stop();
            this.cUA = false;
        }
    }

    private void azK() {
        if (!this.cUA) {
            azJ();
            if (this.cUx != null && !this.cUx.isStarted()) {
                this.cUx.start();
                this.cUA = true;
            }
        }
    }

    public BDLocation azO() {
        return this.cUz;
    }

    public void fI(boolean z) {
        if (z) {
            azK();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.cXu = bVar;
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
            c.this.cUY.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.cUZ != null) {
                c.this.cUZ.remove();
                c.this.cUZ = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.cWA).anchor(0.5f, 0.5f);
            c.this.cUZ = (Marker) c.this.cUY.addOverlay(anchor);
            if (c.this.cUz == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.cXu != null) {
                    c.this.cXu.d(bDLocation);
                }
            }
            c.this.cUz = bDLocation;
        }
    }
}
