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
/* loaded from: classes19.dex */
public class i {
    private BaiduMap dAH;
    private Marker dAI;
    private LocationClient dAg;
    private BDLocation dAi;
    private boolean dAj = false;
    private BitmapDescriptor dCj;
    private b dCk;
    private Context mContext;

    /* loaded from: classes19.dex */
    public interface b {
        void e(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, BaiduMap baiduMap) {
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
            this.dCj = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation aRt() {
        return this.dAi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gQ(boolean z) {
        if (z) {
            aRp();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.dCk = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                i.this.stopLocation();
                return;
            }
            i.this.dAH.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (i.this.dAI != null) {
                i.this.dAI.remove();
                i.this.dAI = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(i.this.dCj);
            i.this.dAI = (Marker) i.this.dAH.addOverlay(icon);
            if (i.this.dAi == null) {
                i.this.dAH.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (i.this.dCk != null) {
                    i.this.dCk.e(bDLocation);
                }
            }
            i.this.dAi = bDLocation;
        }
    }
}
