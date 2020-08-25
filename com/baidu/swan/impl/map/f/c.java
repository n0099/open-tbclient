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
/* loaded from: classes19.dex */
public class c {
    private BaiduMap dAH;
    private Marker dAI;
    private LocationClient dAg;
    private BDLocation dAi;
    private boolean dAj = false;
    private BitmapDescriptor dCj;
    private b dDd;
    private Context mContext;

    /* loaded from: classes19.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.dAH = baiduMap;
    }

    private void aRo() {
        if (this.dAg == null) {
            this.dAg = new LocationClient(this.mContext.getApplicationContext());
            this.dAg.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dAg.setLocOption(locationClientOption);
            this.dCj = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dAj && this.dAg != null && this.dAg.isStarted()) {
            this.dAg.stop();
            this.dAj = false;
        }
    }

    private void aRp() {
        if (!this.dAj) {
            aRo();
            if (this.dAg != null && !this.dAg.isStarted()) {
                this.dAg.start();
                this.dAj = true;
            }
        }
    }

    public BDLocation aRt() {
        return this.dAi;
    }

    public void gQ(boolean z) {
        if (z) {
            aRp();
        } else {
            stopLocation();
        }
    }

    public void a(b bVar) {
        this.dDd = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.stopLocation();
                return;
            }
            c.this.dAH.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.dAI != null) {
                c.this.dAI.remove();
                c.this.dAI = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.dCj).anchor(0.5f, 0.5f);
            c.this.dAI = (Marker) c.this.dAH.addOverlay(anchor);
            if (c.this.dAi == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.dDd != null) {
                    c.this.dDd.e(bDLocation);
                }
            }
            c.this.dAi = bDLocation;
        }
    }
}
