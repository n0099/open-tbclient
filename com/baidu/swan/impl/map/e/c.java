package com.baidu.swan.impl.map.e;

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
public class c {
    private LocationClient bFP;
    private BDLocation bFR;
    private boolean bFS = false;
    private BaiduMap bGh;
    private Marker bGi;
    private BitmapDescriptor bHJ;
    private b bID;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
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
            this.bHJ = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
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

    public BDLocation Zm() {
        return this.bFR;
    }

    public void dn(boolean z) {
        if (z) {
            Zi();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.bID = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.bGh.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.bGi != null) {
                c.this.bGi.remove();
                c.this.bGi = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.bHJ).anchor(0.5f, 0.5f);
            c.this.bGi = (Marker) c.this.bGh.addOverlay(anchor);
            if (c.this.bFR == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.bID != null) {
                    c.this.bID.d(bDLocation);
                }
            }
            c.this.bFR = bDLocation;
        }
    }
}
