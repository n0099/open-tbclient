package com.baidu.swan.impl.map.e;

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
/* loaded from: classes5.dex */
public class c {
    private LocationClient bGG;
    private BDLocation bGI;
    private boolean bGJ = false;
    private BaiduMap bGY;
    private Marker bGZ;
    private BitmapDescriptor bIA;
    private b bJu;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.bGY = baiduMap;
    }

    private void Zj() {
        if (this.bGG == null) {
            this.bGG = new LocationClient(this.mContext.getApplicationContext());
            this.bGG.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bGG.setLocOption(locationClientOption);
            this.bIA = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.bGJ && this.bGG != null && this.bGG.isStarted()) {
            this.bGG.stop();
            this.bGJ = false;
        }
    }

    private void Zk() {
        if (!this.bGJ) {
            Zj();
            if (this.bGG != null && !this.bGG.isStarted()) {
                this.bGG.start();
                this.bGJ = true;
            }
        }
    }

    public BDLocation Zo() {
        return this.bGI;
    }

    public void dn(boolean z) {
        if (z) {
            Zk();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.bJu = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.bGY.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.bGZ != null) {
                c.this.bGZ.remove();
                c.this.bGZ = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.bIA).anchor(0.5f, 0.5f);
            c.this.bGZ = (Marker) c.this.bGY.addOverlay(anchor);
            if (c.this.bGI == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.bJu != null) {
                    c.this.bJu.d(bDLocation);
                }
            }
            c.this.bGI = bDLocation;
        }
    }
}
