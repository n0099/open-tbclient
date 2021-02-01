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
/* loaded from: classes9.dex */
public class e {
    private BaiduMap eoS;
    private Marker eoT;
    private LocationClient eor;
    private BDLocation eot;
    private boolean eou = false;
    private BitmapDescriptor equ;
    private b eqv;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.eoS = baiduMap;
    }

    private void ban() {
        if (this.eor == null) {
            this.eor = new LocationClient(this.mContext.getApplicationContext());
            this.eor.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.eor.setLocOption(locationClientOption);
            this.equ = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.eou && this.eor != null && this.eor.isStarted()) {
            this.eor.stop();
            this.eou = false;
        }
    }

    private void bao() {
        if (!this.eou) {
            ban();
            if (this.eor != null && !this.eor.isStarted()) {
                this.eor.start();
                this.eou = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation bas() {
        return this.eot;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ip(boolean z) {
        if (z) {
            bao();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.eqv = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                e.this.stopLocation();
                return;
            }
            e.this.eoS.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (e.this.eoT != null) {
                e.this.eoT.remove();
                e.this.eoT = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(e.this.equ);
            e.this.eoT = (Marker) e.this.eoS.addOverlay(icon);
            if (e.this.eot == null) {
                e.this.eoS.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (e.this.eqv != null) {
                    e.this.eqv.d(bDLocation);
                }
            }
            e.this.eot = bDLocation;
        }
    }
}
