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
/* loaded from: classes24.dex */
public class i {
    private BaiduMap dCM;
    private Marker dCN;
    private LocationClient dCl;
    private BDLocation dCn;
    private boolean dCo = false;
    private BitmapDescriptor dEo;
    private b dEp;
    private Context mContext;

    /* loaded from: classes24.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.dCM = baiduMap;
    }

    private void aSa() {
        if (this.dCl == null) {
            this.dCl = new LocationClient(this.mContext.getApplicationContext());
            this.dCl.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dCl.setLocOption(locationClientOption);
            this.dEo = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dCo && this.dCl != null && this.dCl.isStarted()) {
            this.dCl.stop();
            this.dCo = false;
        }
    }

    private void aSb() {
        if (!this.dCo) {
            aSa();
            if (this.dCl != null && !this.dCl.isStarted()) {
                this.dCl.start();
                this.dCo = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation aSf() {
        return this.dCn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gP(boolean z) {
        if (z) {
            aSb();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.dEp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.stopLocation();
                return;
            }
            i.this.dCM.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.dCN != null) {
                i.this.dCN.remove();
                i.this.dCN = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.dEo);
            i.this.dCN = (Marker) i.this.dCM.addOverlay(icon);
            if (i.this.dCn == null) {
                i.this.dCM.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.dEp != null) {
                    i.this.dEp.e(bDLocation);
                }
            }
            i.this.dCn = bDLocation;
        }
    }
}
