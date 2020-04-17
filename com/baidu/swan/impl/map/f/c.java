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
    private BaiduMap cUT;
    private Marker cUU;
    private LocationClient cUs;
    private BDLocation cUu;
    private boolean cUv = false;
    private BitmapDescriptor cWv;
    private b cXp;
    private Context mContext;

    /* loaded from: classes12.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.cUT = baiduMap;
    }

    private void azJ() {
        if (this.cUs == null) {
            this.cUs = new LocationClient(this.mContext.getApplicationContext());
            this.cUs.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cUs.setLocOption(locationClientOption);
            this.cWv = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cUv && this.cUs != null && this.cUs.isStarted()) {
            this.cUs.stop();
            this.cUv = false;
        }
    }

    private void azK() {
        if (!this.cUv) {
            azJ();
            if (this.cUs != null && !this.cUs.isStarted()) {
                this.cUs.start();
                this.cUv = true;
            }
        }
    }

    public BDLocation azO() {
        return this.cUu;
    }

    public void fI(boolean z) {
        if (z) {
            azK();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.cXp = bVar;
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
            c.this.cUT.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.cUU != null) {
                c.this.cUU.remove();
                c.this.cUU = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.cWv).anchor(0.5f, 0.5f);
            c.this.cUU = (Marker) c.this.cUT.addOverlay(anchor);
            if (c.this.cUu == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.cXp != null) {
                    c.this.cXp.d(bDLocation);
                }
            }
            c.this.cUu = bDLocation;
        }
    }
}
