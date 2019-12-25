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
public class i {
    private LocationClient cqV;
    private BDLocation cqX;
    private boolean cqY = false;
    private BaiduMap crx;
    private Marker cry;
    private BitmapDescriptor csZ;
    private b cta;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.crx = baiduMap;
    }

    private void aoM() {
        if (this.cqV == null) {
            this.cqV = new LocationClient(this.mContext.getApplicationContext());
            this.cqV.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cqV.setLocOption(locationClientOption);
            this.csZ = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cqY && this.cqV != null && this.cqV.isStarted()) {
            this.cqV.stop();
            this.cqY = false;
        }
    }

    private void aoN() {
        if (!this.cqY) {
            aoM();
            if (this.cqV != null && !this.cqV.isStarted()) {
                this.cqV.start();
                this.cqY = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation aoR() {
        return this.cqX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ey(boolean z) {
        if (z) {
            aoN();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.cta = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.stopLocation();
                return;
            }
            i.this.crx.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.cry != null) {
                i.this.cry.remove();
                i.this.cry = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.csZ);
            i.this.cry = (Marker) i.this.crx.addOverlay(icon);
            if (i.this.cqX == null) {
                i.this.crx.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.cta != null) {
                    i.this.cta.d(bDLocation);
                }
            }
            i.this.cqX = bDLocation;
        }
    }
}
