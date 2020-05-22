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
    private BDLocation dfA;
    private boolean dfB = false;
    private BaiduMap dfZ;
    private LocationClient dfy;
    private Marker dga;
    private BitmapDescriptor dhB;
    private b diy;
    private Context mContext;

    /* loaded from: classes12.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.dfZ = baiduMap;
    }

    private void aDB() {
        if (this.dfy == null) {
            this.dfy = new LocationClient(this.mContext.getApplicationContext());
            this.dfy.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dfy.setLocOption(locationClientOption);
            this.dhB = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dfB && this.dfy != null && this.dfy.isStarted()) {
            this.dfy.stop();
            this.dfB = false;
        }
    }

    private void aDC() {
        if (!this.dfB) {
            aDB();
            if (this.dfy != null && !this.dfy.isStarted()) {
                this.dfy.start();
                this.dfB = true;
            }
        }
    }

    public BDLocation aDG() {
        return this.dfA;
    }

    public void fT(boolean z) {
        if (z) {
            aDC();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.diy = bVar;
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
            c.this.dfZ.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.dga != null) {
                c.this.dga.remove();
                c.this.dga = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.dhB).anchor(0.5f, 0.5f);
            c.this.dga = (Marker) c.this.dfZ.addOverlay(anchor);
            if (c.this.dfA == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.diy != null) {
                    c.this.diy.d(bDLocation);
                }
            }
            c.this.dfA = bDLocation;
        }
    }
}
