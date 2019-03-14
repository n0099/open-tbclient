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
    private LocationClient bgA;
    private BDLocation bgC;
    private boolean bgD = false;
    private BaiduMap bgS;
    private Marker bgT;
    private BitmapDescriptor biw;
    private b bix;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
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
            this.biw = BitmapDescriptorFactory.fromResource(d.f.aiapps_location_my_point);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation PT() {
        return this.bgC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cC(boolean z) {
        if (z) {
            PP();
        } else {
            ja();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.bix = bVar;
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
            i.this.bgS.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.bgT != null) {
                i.this.bgT.remove();
                i.this.bgT = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.biw);
            i.this.bgT = (Marker) i.this.bgS.addOverlay(icon);
            if (i.this.bgC == null) {
                i.this.bgS.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.bix != null) {
                    i.this.bix.d(bDLocation);
                }
            }
            i.this.bgC = bDLocation;
        }
    }
}
