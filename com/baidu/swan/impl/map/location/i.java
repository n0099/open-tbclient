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
    private LocationClient bmJ;
    private BDLocation bmL;
    private boolean bmM = false;
    private BaiduMap bnb;
    private Marker bnc;
    private BitmapDescriptor boD;
    private b boE;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.bnb = baiduMap;
    }

    private void Ty() {
        if (this.bmJ == null) {
            this.bmJ = new LocationClient(this.mContext.getApplicationContext());
            this.bmJ.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bmJ.setLocOption(locationClientOption);
            this.boD = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hS() {
        if (this.bmM && this.bmJ != null && this.bmJ.isStarted()) {
            this.bmJ.stop();
            this.bmM = false;
        }
    }

    private void Tz() {
        if (!this.bmM) {
            Ty();
            if (this.bmJ != null && !this.bmJ.isStarted()) {
                this.bmJ.start();
                this.bmM = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation TD() {
        return this.bmL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cT(boolean z) {
        if (z) {
            Tz();
        } else {
            hS();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.boE = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.hS();
                return;
            }
            i.this.bnb.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.bnc != null) {
                i.this.bnc.remove();
                i.this.bnc = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.boD);
            i.this.bnc = (Marker) i.this.bnb.addOverlay(icon);
            if (i.this.bmL == null) {
                i.this.bnb.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.boE != null) {
                    i.this.boE.d(bDLocation);
                }
            }
            i.this.bmL = bDLocation;
        }
    }
}
