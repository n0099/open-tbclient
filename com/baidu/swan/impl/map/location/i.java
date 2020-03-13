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
    private BaiduMap cvM;
    private Marker cvN;
    private LocationClient cvl;
    private BDLocation cvn;
    private boolean cvo = false;
    private BitmapDescriptor cxo;
    private b cxp;
    private Context mContext;

    /* loaded from: classes12.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.cvM = baiduMap;
    }

    private void arv() {
        if (this.cvl == null) {
            this.cvl = new LocationClient(this.mContext.getApplicationContext());
            this.cvl.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cvl.setLocOption(locationClientOption);
            this.cxo = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cvo && this.cvl != null && this.cvl.isStarted()) {
            this.cvl.stop();
            this.cvo = false;
        }
    }

    private void arw() {
        if (!this.cvo) {
            arv();
            if (this.cvl != null && !this.cvl.isStarted()) {
                this.cvl.start();
                this.cvo = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation arA() {
        return this.cvn;
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
        this.cxp = bVar;
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
            i.this.cvM.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.cvN != null) {
                i.this.cvN.remove();
                i.this.cvN = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.cxo);
            i.this.cvN = (Marker) i.this.cvM.addOverlay(icon);
            if (i.this.cvn == null) {
                i.this.cvM.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.cxp != null) {
                    i.this.cxp.d(bDLocation);
                }
            }
            i.this.cvn = bDLocation;
        }
    }
}
