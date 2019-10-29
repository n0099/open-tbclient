package com.baidu.swan.impl.map.location;

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
public class i {
    private LocationClient bGG;
    private BDLocation bGI;
    private boolean bGJ = false;
    private BaiduMap bGY;
    private Marker bGZ;
    private BitmapDescriptor bIA;
    private b bIB;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
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
            this.bIA = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation Zo() {
        return this.bGI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dn(boolean z) {
        if (z) {
            Zk();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.bIB = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.stopLocation();
                return;
            }
            i.this.bGY.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.bGZ != null) {
                i.this.bGZ.remove();
                i.this.bGZ = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.bIA);
            i.this.bGZ = (Marker) i.this.bGY.addOverlay(icon);
            if (i.this.bGI == null) {
                i.this.bGY.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.bIB != null) {
                    i.this.bIB.d(bDLocation);
                }
            }
            i.this.bGI = bDLocation;
        }
    }
}
