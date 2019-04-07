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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class i {
    private LocationClient bgD;
    private BDLocation bgF;
    private boolean bgG = false;
    private BaiduMap bgV;
    private Marker bgW;
    private b biA;
    private BitmapDescriptor biz;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.bgV = baiduMap;
    }

    private void PM() {
        if (this.bgD == null) {
            this.bgD = new LocationClient(this.mContext.getApplicationContext());
            this.bgD.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bgD.setLocOption(locationClientOption);
            this.biz = BitmapDescriptorFactory.fromResource(d.f.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        if (this.bgG && this.bgD != null && this.bgD.isStarted()) {
            this.bgD.stop();
            this.bgG = false;
        }
    }

    private void PN() {
        if (!this.bgG) {
            PM();
            if (this.bgD != null && !this.bgD.isStarted()) {
                this.bgD.start();
                this.bgG = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation PR() {
        return this.bgF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cC(boolean z) {
        if (z) {
            PN();
        } else {
            ja();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.biA = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.ja();
                return;
            }
            i.this.bgV.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.bgW != null) {
                i.this.bgW.remove();
                i.this.bgW = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.biz);
            i.this.bgW = (Marker) i.this.bgV.addOverlay(icon);
            if (i.this.bgF == null) {
                i.this.bgV.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.biA != null) {
                    i.this.biA.d(bDLocation);
                }
            }
            i.this.bgF = bDLocation;
        }
    }
}
