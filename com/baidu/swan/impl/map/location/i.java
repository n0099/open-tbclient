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
/* loaded from: classes10.dex */
public class i {
    private BaiduMap crI;
    private Marker crJ;
    private LocationClient crh;
    private BDLocation crj;
    private boolean crk = false;
    private BitmapDescriptor ctk;
    private b ctl;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.crI = baiduMap;
    }

    private void apf() {
        if (this.crh == null) {
            this.crh = new LocationClient(this.mContext.getApplicationContext());
            this.crh.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.crh.setLocOption(locationClientOption);
            this.ctk = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.crk && this.crh != null && this.crh.isStarted()) {
            this.crh.stop();
            this.crk = false;
        }
    }

    private void apg() {
        if (!this.crk) {
            apf();
            if (this.crh != null && !this.crh.isStarted()) {
                this.crh.start();
                this.crk = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation apl() {
        return this.crj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eD(boolean z) {
        if (z) {
            apg();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.ctl = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.stopLocation();
                return;
            }
            i.this.crI.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.crJ != null) {
                i.this.crJ.remove();
                i.this.crJ = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.ctk);
            i.this.crJ = (Marker) i.this.crI.addOverlay(icon);
            if (i.this.crj == null) {
                i.this.crI.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.ctl != null) {
                    i.this.ctl.d(bDLocation);
                }
            }
            i.this.crj = bDLocation;
        }
    }
}
