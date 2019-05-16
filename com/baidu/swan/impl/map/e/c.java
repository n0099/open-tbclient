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
    private LocationClient bmJ;
    private BDLocation bmL;
    private boolean bmM = false;
    private BaiduMap bnb;
    private Marker bnc;
    private BitmapDescriptor boD;
    private b bpy;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void d(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
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
            this.boD = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
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

    public BDLocation TD() {
        return this.bmL;
    }

    public void cT(boolean z) {
        if (z) {
            Tz();
        } else {
            hS();
        }
    }

    public void a(b bVar) {
        this.bpy = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends BDAbstractLocationListener {
        a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.hS();
                return;
            }
            c.this.bnb.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.bnc != null) {
                c.this.bnc.remove();
                c.this.bnc = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.boD).anchor(0.5f, 0.5f);
            c.this.bnc = (Marker) c.this.bnb.addOverlay(anchor);
            if (c.this.bmL == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.bpy != null) {
                    c.this.bpy.d(bDLocation);
                }
            }
            c.this.bmL = bDLocation;
        }
    }
}
