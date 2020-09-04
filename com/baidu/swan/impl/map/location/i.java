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
/* loaded from: classes19.dex */
public class i {
    private BaiduMap dAL;
    private Marker dAM;
    private LocationClient dAk;
    private BDLocation dAm;
    private boolean dAn = false;
    private BitmapDescriptor dCn;
    private b dCo;
    private Context mContext;

    /* loaded from: classes19.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.dAL = baiduMap;
    }

    private void aRo() {
        if (this.dAk == null) {
            this.dAk = new LocationClient(this.mContext.getApplicationContext());
            this.dAk.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dAk.setLocOption(locationClientOption);
            this.dCn = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dAn && this.dAk != null && this.dAk.isStarted()) {
            this.dAk.stop();
            this.dAn = false;
        }
    }

    private void aRp() {
        if (!this.dAn) {
            aRo();
            if (this.dAk != null && !this.dAk.isStarted()) {
                this.dAk.start();
                this.dAn = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation aRt() {
        return this.dAm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gR(boolean z) {
        if (z) {
            aRp();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.dCo = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.stopLocation();
                return;
            }
            i.this.dAL.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.dAM != null) {
                i.this.dAM.remove();
                i.this.dAM = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.dCn);
            i.this.dAM = (Marker) i.this.dAL.addOverlay(icon);
            if (i.this.dAm == null) {
                i.this.dAL.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.dCo != null) {
                    i.this.dCo.e(bDLocation);
                }
            }
            i.this.dAm = bDLocation;
        }
    }
}
