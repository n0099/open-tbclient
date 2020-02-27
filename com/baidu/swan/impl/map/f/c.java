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
    private BaiduMap cvK;
    private Marker cvL;
    private LocationClient cvj;
    private BDLocation cvl;
    private boolean cvm = false;
    private BitmapDescriptor cxm;
    private b cyf;
    private Context mContext;

    /* loaded from: classes12.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.cvK = baiduMap;
    }

    private void art() {
        if (this.cvj == null) {
            this.cvj = new LocationClient(this.mContext.getApplicationContext());
            this.cvj.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cvj.setLocOption(locationClientOption);
            this.cxm = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cvm && this.cvj != null && this.cvj.isStarted()) {
            this.cvj.stop();
            this.cvm = false;
        }
    }

    private void aru() {
        if (!this.cvm) {
            art();
            if (this.cvj != null && !this.cvj.isStarted()) {
                this.cvj.start();
                this.cvm = true;
            }
        }
    }

    public BDLocation ary() {
        return this.cvl;
    }

    public void eK(boolean z) {
        if (z) {
            aru();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.cyf = bVar;
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
            c.this.cvK.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.cvL != null) {
                c.this.cvL.remove();
                c.this.cvL = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.cxm).anchor(0.5f, 0.5f);
            c.this.cvL = (Marker) c.this.cvK.addOverlay(anchor);
            if (c.this.cvl == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.cyf != null) {
                    c.this.cyf.d(bDLocation);
                }
            }
            c.this.cvl = bDLocation;
        }
    }
}
