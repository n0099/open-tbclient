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
    private LocationClient ehT;
    private BDLocation ehV;
    private boolean ehW = false;
    private BaiduMap eiu;
    private Marker eiv;
    private BitmapDescriptor ejX;
    private b ejY;
    private Context mContext;

    /* loaded from: classes25.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.eiu = baiduMap;
    }

    private void bbB() {
        if (this.ehT == null) {
            this.ehT = new LocationClient(this.mContext.getApplicationContext());
            this.ehT.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.ehT.setLocOption(locationClientOption);
            this.ejX = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.ehW && this.ehT != null && this.ehT.isStarted()) {
            this.ehT.stop();
            this.ehW = false;
        }
    }

    private void bbC() {
        if (!this.ehW) {
            bbB();
            if (this.ehT != null && !this.ehT.isStarted()) {
                this.ehT.start();
                this.ehW = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation bbG() {
        return this.ehV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hZ(boolean z) {
        if (z) {
            bbC();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.ejY = bVar;
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
            i.this.eiu.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.eiv != null) {
                i.this.eiv.remove();
                i.this.eiv = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.ejX);
            i.this.eiv = (Marker) i.this.eiu.addOverlay(icon);
            if (i.this.ehV == null) {
                i.this.eiu.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.ejY != null) {
                    i.this.ejY.e(bDLocation);
                }
            }
            i.this.ehV = bDLocation;
        }
    }
}
