package com.baidu.swan.impl.map.f;

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
public class c {
    private BaiduMap dON;
    private Marker dOO;
    private LocationClient dOm;
    private BDLocation dOo;
    private boolean dOp = false;
    private BitmapDescriptor dQp;
    private b dRj;
    private Context mContext;

    /* loaded from: classes25.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
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
            this.dQp = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
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

    public BDLocation aUO() {
        return this.dOo;
    }

    public void hl(boolean z) {
        if (z) {
            aUK();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.dRj = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.dON.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.dOO != null) {
                c.this.dOO.remove();
                c.this.dOO = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.dQp).anchor(0.5f, 0.5f);
            c.this.dOO = (Marker) c.this.dON.addOverlay(anchor);
            if (c.this.dOo == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.dRj != null) {
                    c.this.dRj.e(bDLocation);
                }
            }
            c.this.dOo = bDLocation;
        }
    }
}
