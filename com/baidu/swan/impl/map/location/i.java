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
    private BaiduMap dON;
    private Marker dOO;
    private LocationClient dOm;
    private BDLocation dOo;
    private boolean dOp = false;
    private BitmapDescriptor dQp;
    private b dQq;
    private Context mContext;

    /* loaded from: classes25.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.dON = baiduMap;
    }

    private void aUJ() {
        if (this.dOm == null) {
            this.dOm = new LocationClient(this.mContext.getApplicationContext());
            this.dOm.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dOm.setLocOption(locationClientOption);
            this.dQp = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dOp && this.dOm != null && this.dOm.isStarted()) {
            this.dOm.stop();
            this.dOp = false;
        }
    }

    private void aUK() {
        if (!this.dOp) {
            aUJ();
            if (this.dOm != null && !this.dOm.isStarted()) {
                this.dOm.start();
                this.dOp = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation aUO() {
        return this.dOo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hl(boolean z) {
        if (z) {
            aUK();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.dQq = bVar;
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
            i.this.dON.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.dOO != null) {
                i.this.dOO.remove();
                i.this.dOO = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.dQp);
            i.this.dOO = (Marker) i.this.dON.addOverlay(icon);
            if (i.this.dOo == null) {
                i.this.dON.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.dQq != null) {
                    i.this.dQq.e(bDLocation);
                }
            }
            i.this.dOo = bDLocation;
        }
    }
}
