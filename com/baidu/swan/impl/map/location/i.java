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
    private BaiduMap bnO;
    private Marker bnP;
    private LocationClient bnw;
    private BDLocation bny;
    private boolean bnz = false;
    private BitmapDescriptor bpq;
    private b bpr;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.bnO = baiduMap;
    }

    private void Uq() {
        if (this.bnw == null) {
            this.bnw = new LocationClient(this.mContext.getApplicationContext());
            this.bnw.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bnw.setLocOption(locationClientOption);
            this.bpq = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic() {
        if (this.bnz && this.bnw != null && this.bnw.isStarted()) {
            this.bnw.stop();
            this.bnz = false;
        }
    }

    private void Ur() {
        if (!this.bnz) {
            Uq();
            if (this.bnw != null && !this.bnw.isStarted()) {
                this.bnw.start();
                this.bnz = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation Uv() {
        return this.bny;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cW(boolean z) {
        if (z) {
            Ur();
        } else {
            ic();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.bpr = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.ic();
                return;
            }
            i.this.bnO.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.bnP != null) {
                i.this.bnP.remove();
                i.this.bnP = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.bpq);
            i.this.bnP = (Marker) i.this.bnO.addOverlay(icon);
            if (i.this.bny == null) {
                i.this.bnO.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.bpr != null) {
                    i.this.bpr.d(bDLocation);
                }
            }
            i.this.bny = bDLocation;
        }
    }
}
