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
    private BaiduMap cvK;
    private Marker cvL;
    private LocationClient cvj;
    private BDLocation cvl;
    private boolean cvm = false;
    private BitmapDescriptor cxm;
    private b cxn;
    private Context mContext;

    /* loaded from: classes12.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.cvK = baiduMap;
    }

    private void art() {
        if (this.cvj == null) {
            this.cvj = new LocationClient(this.mContext.getApplicationContext());
            this.cvj.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cvj.setLocOption(locationClientOption);
            this.cxm = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cvm && this.cvj != null && this.cvj.isStarted()) {
            this.cvj.stop();
            this.cvm = false;
        }
    }

    private void aru() {
        if (!this.cvm) {
            art();
            if (this.cvj != null && !this.cvj.isStarted()) {
                this.cvj.start();
                this.cvm = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation ary() {
        return this.cvl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eK(boolean z) {
        if (z) {
            aru();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.cxn = bVar;
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
            i.this.cvK.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.cvL != null) {
                i.this.cvL.remove();
                i.this.cvL = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.cxm);
            i.this.cvL = (Marker) i.this.cvK.addOverlay(icon);
            if (i.this.cvl == null) {
                i.this.cvK.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.cxn != null) {
                    i.this.cxn.d(bDLocation);
                }
            }
            i.this.cvl = bDLocation;
        }
    }
}
