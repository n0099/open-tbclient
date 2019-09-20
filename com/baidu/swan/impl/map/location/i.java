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
    private LocationClient bnU;
    private BDLocation bnW;
    private boolean bnX = false;
    private BaiduMap bom;
    private Marker bon;
    private BitmapDescriptor bpO;
    private b bpP;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.bom = baiduMap;
    }

    private void Uu() {
        if (this.bnU == null) {
            this.bnU = new LocationClient(this.mContext.getApplicationContext());
            this.bnU.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bnU.setLocOption(locationClientOption);
            this.bpO = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic() {
        if (this.bnX && this.bnU != null && this.bnU.isStarted()) {
            this.bnU.stop();
            this.bnX = false;
        }
    }

    private void Uv() {
        if (!this.bnX) {
            Uu();
            if (this.bnU != null && !this.bnU.isStarted()) {
                this.bnU.start();
                this.bnX = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation Uz() {
        return this.bnW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cW(boolean z) {
        if (z) {
            Uv();
        } else {
            ic();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.bpP = bVar;
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
            i.this.bom.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.bon != null) {
                i.this.bon.remove();
                i.this.bon = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.bpO);
            i.this.bon = (Marker) i.this.bom.addOverlay(icon);
            if (i.this.bnW == null) {
                i.this.bom.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.bpP != null) {
                    i.this.bpP.d(bDLocation);
                }
            }
            i.this.bnW = bDLocation;
        }
    }
}
