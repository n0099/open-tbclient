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
    private LocationClient bFP;
    private BDLocation bFR;
    private boolean bFS = false;
    private BaiduMap bGh;
    private Marker bGi;
    private BitmapDescriptor bHJ;
    private b bHK;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.bGh = baiduMap;
    }

    private void Zh() {
        if (this.bFP == null) {
            this.bFP = new LocationClient(this.mContext.getApplicationContext());
            this.bFP.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bFP.setLocOption(locationClientOption);
            this.bHJ = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.bFS && this.bFP != null && this.bFP.isStarted()) {
            this.bFP.stop();
            this.bFS = false;
        }
    }

    private void Zi() {
        if (!this.bFS) {
            Zh();
            if (this.bFP != null && !this.bFP.isStarted()) {
                this.bFP.start();
                this.bFS = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation Zm() {
        return this.bFR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dn(boolean z) {
        if (z) {
            Zi();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.bHK = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.stopLocation();
                return;
            }
            i.this.bGh.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.bGi != null) {
                i.this.bGi.remove();
                i.this.bGi = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.bHJ);
            i.this.bGi = (Marker) i.this.bGh.addOverlay(icon);
            if (i.this.bFR == null) {
                i.this.bGh.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.bHK != null) {
                    i.this.bHK.d(bDLocation);
                }
            }
            i.this.bFR = bDLocation;
        }
    }
}
