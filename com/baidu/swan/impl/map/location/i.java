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
/* loaded from: classes25.dex */
public class i {
    private LocationClient dWJ;
    private BDLocation dWL;
    private boolean dWM = false;
    private BaiduMap dXk;
    private Marker dXl;
    private BitmapDescriptor dYM;
    private b dYN;
    private Context mContext;

    /* loaded from: classes25.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.dXk = baiduMap;
    }

    private void aWD() {
        if (this.dWJ == null) {
            this.dWJ = new LocationClient(this.mContext.getApplicationContext());
            this.dWJ.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dWJ.setLocOption(locationClientOption);
            this.dYM = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dWM && this.dWJ != null && this.dWJ.isStarted()) {
            this.dWJ.stop();
            this.dWM = false;
        }
    }

    private void aWE() {
        if (!this.dWM) {
            aWD();
            if (this.dWJ != null && !this.dWJ.isStarted()) {
                this.dWJ.start();
                this.dWM = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation aWI() {
        return this.dWL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hy(boolean z) {
        if (z) {
            aWE();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.dYN = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.stopLocation();
                return;
            }
            i.this.dXk.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.dXl != null) {
                i.this.dXl.remove();
                i.this.dXl = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.dYM);
            i.this.dXl = (Marker) i.this.dXk.addOverlay(icon);
            if (i.this.dWL == null) {
                i.this.dXk.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.dYN != null) {
                    i.this.dYN.e(bDLocation);
                }
            }
            i.this.dWL = bDLocation;
        }
    }
}
