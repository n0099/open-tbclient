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
/* loaded from: classes9.dex */
public class c {
    private BaiduMap eoS;
    private Marker eoT;
    private LocationClient eor;
    private BDLocation eot;
    private boolean eou = false;
    private BitmapDescriptor equ;
    private b ern;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
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
            this.equ = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
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

    public BDLocation bas() {
        return this.eot;
    }

    public void ip(boolean z) {
        if (z) {
            bao();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.ern = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.eoS.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.eoT != null) {
                c.this.eoT.remove();
                c.this.eoT = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.equ).anchor(0.5f, 0.5f);
            c.this.eoT = (Marker) c.this.eoS.addOverlay(anchor);
            if (c.this.eot == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.ern != null) {
                    c.this.ern.d(bDLocation);
                }
            }
            c.this.eot = bDLocation;
        }
    }
}
