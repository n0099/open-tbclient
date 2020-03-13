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
    private BaiduMap cvM;
    private Marker cvN;
    private LocationClient cvl;
    private BDLocation cvn;
    private boolean cvo = false;
    private BitmapDescriptor cxo;
    private b cyh;
    private Context mContext;

    /* loaded from: classes12.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.cvM = baiduMap;
    }

    private void arv() {
        if (this.cvl == null) {
            this.cvl = new LocationClient(this.mContext.getApplicationContext());
            this.cvl.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cvl.setLocOption(locationClientOption);
            this.cxo = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cvo && this.cvl != null && this.cvl.isStarted()) {
            this.cvl.stop();
            this.cvo = false;
        }
    }

    private void arw() {
        if (!this.cvo) {
            arv();
            if (this.cvl != null && !this.cvl.isStarted()) {
                this.cvl.start();
                this.cvo = true;
            }
        }
    }

    public BDLocation arA() {
        return this.cvn;
    }

    public void eK(boolean z) {
        if (z) {
            arw();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.cyh = bVar;
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
            c.this.cvM.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.cvN != null) {
                c.this.cvN.remove();
                c.this.cvN = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.cxo).anchor(0.5f, 0.5f);
            c.this.cvN = (Marker) c.this.cvM.addOverlay(anchor);
            if (c.this.cvn == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.cyh != null) {
                    c.this.cyh.d(bDLocation);
                }
            }
            c.this.cvn = bDLocation;
        }
    }
}
