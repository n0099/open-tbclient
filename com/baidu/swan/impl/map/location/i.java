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
/* loaded from: classes12.dex */
public class i {
    private BaiduMap cvL;
    private Marker cvM;
    private LocationClient cvk;
    private BDLocation cvm;
    private boolean cvn = false;
    private BitmapDescriptor cxn;
    private b cxo;
    private Context mContext;

    /* loaded from: classes12.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.cvL = baiduMap;
    }

    private void arv() {
        if (this.cvk == null) {
            this.cvk = new LocationClient(this.mContext.getApplicationContext());
            this.cvk.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cvk.setLocOption(locationClientOption);
            this.cxn = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cvn && this.cvk != null && this.cvk.isStarted()) {
            this.cvk.stop();
            this.cvn = false;
        }
    }

    private void arw() {
        if (!this.cvn) {
            arv();
            if (this.cvk != null && !this.cvk.isStarted()) {
                this.cvk.start();
                this.cvn = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation arA() {
        return this.cvm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eK(boolean z) {
        if (z) {
            arw();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.cxo = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.stopLocation();
                return;
            }
            i.this.cvL.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.cvM != null) {
                i.this.cvM.remove();
                i.this.cvM = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.cxn);
            i.this.cvM = (Marker) i.this.cvL.addOverlay(icon);
            if (i.this.cvm == null) {
                i.this.cvL.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.cxo != null) {
                    i.this.cxo.d(bDLocation);
                }
            }
            i.this.cvm = bDLocation;
        }
    }
}
