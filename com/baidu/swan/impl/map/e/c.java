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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class c {
    private LocationClient bgA;
    private BDLocation bgC;
    private boolean bgD = false;
    private BaiduMap bgS;
    private Marker bgT;
    private BitmapDescriptor biw;
    private b bjr;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.bgS = baiduMap;
    }

    private void PO() {
        if (this.bgA == null) {
            this.bgA = new LocationClient(this.mContext.getApplicationContext());
            this.bgA.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bgA.setLocOption(locationClientOption);
            this.biw = BitmapDescriptorFactory.fromResource(d.f.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        if (this.bgD && this.bgA != null && this.bgA.isStarted()) {
            this.bgA.stop();
            this.bgD = false;
        }
    }

    private void PP() {
        if (!this.bgD) {
            PO();
            if (this.bgA != null && !this.bgA.isStarted()) {
                this.bgA.start();
                this.bgD = true;
            }
        }
    }

    public BDLocation PT() {
        return this.bgC;
    }

    public void cC(boolean z) {
        if (z) {
            PP();
        } else {
            ja();
        }
    }

    public void a(b bVar) {
        this.bjr = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.ja();
                return;
            }
            c.this.bgS.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.bgT != null) {
                c.this.bgT.remove();
                c.this.bgT = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.biw).anchor(0.5f, 0.5f);
            c.this.bgT = (Marker) c.this.bgS.addOverlay(anchor);
            if (c.this.bgC == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.bjr != null) {
                    c.this.bjr.d(bDLocation);
                }
            }
            c.this.bgC = bDLocation;
        }
    }
}
