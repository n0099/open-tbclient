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
    private BaiduMap cvX;
    private Marker cvY;
    private LocationClient cvw;
    private BDLocation cvy;
    private boolean cvz = false;
    private b cxA;
    private BitmapDescriptor cxz;
    private Context mContext;

    /* loaded from: classes12.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.cvX = baiduMap;
    }

    private void ary() {
        if (this.cvw == null) {
            this.cvw = new LocationClient(this.mContext.getApplicationContext());
            this.cvw.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cvw.setLocOption(locationClientOption);
            this.cxz = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cvz && this.cvw != null && this.cvw.isStarted()) {
            this.cvw.stop();
            this.cvz = false;
        }
    }

    private void arz() {
        if (!this.cvz) {
            ary();
            if (this.cvw != null && !this.cvw.isStarted()) {
                this.cvw.start();
                this.cvz = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation arD() {
        return this.cvy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eL(boolean z) {
        if (z) {
            arz();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.cxA = bVar;
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
            i.this.cvX.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.cvY != null) {
                i.this.cvY.remove();
                i.this.cvY = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.cxz);
            i.this.cvY = (Marker) i.this.cvX.addOverlay(icon);
            if (i.this.cvy == null) {
                i.this.cvX.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.cxA != null) {
                    i.this.cxA.d(bDLocation);
                }
            }
            i.this.cvy = bDLocation;
        }
    }
}
