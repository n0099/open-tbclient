package com.baidu.searchbox.ng.ai.apps.impl.map.location;

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
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class MyLocationAnchor {
    private static final int MY_LOCATION_MARKER_Z_INDEX = 66;
    private static final int SCAN_SPAN_MS = 1000;
    private BaiduMap mBaiduMap;
    private BitmapDescriptor mBitmap;
    private Context mContext;
    private BDLocation mCurrentLocation;
    private boolean mIsTriggerLocation = false;
    private OnLocationFirstDoneListener mListener;
    private LocationClient mLocationClient;
    private Marker mMarker;

    /* loaded from: classes4.dex */
    public interface OnLocationFirstDoneListener {
        void onFirstLocationDone(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MyLocationAnchor(Context context, BaiduMap baiduMap) {
        this.mContext = context;
        this.mBaiduMap = baiduMap;
    }

    private void initLocationIfNeed() {
        if (this.mLocationClient == null) {
            this.mLocationClient = new LocationClient(this.mContext.getApplicationContext());
            this.mLocationClient.registerLocationListener(new MyLocationListener());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.mLocationClient.setLocOption(locationClientOption);
            this.mBitmap = BitmapDescriptorFactory.fromResource(e.f.aiapps_location_my_point);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.mIsTriggerLocation && this.mLocationClient != null && this.mLocationClient.isStarted()) {
            this.mLocationClient.stop();
            this.mIsTriggerLocation = false;
        }
    }

    private void startLocation() {
        if (!this.mIsTriggerLocation) {
            initLocationIfNeed();
            if (this.mLocationClient != null && !this.mLocationClient.isStarted()) {
                this.mLocationClient.start();
                this.mIsTriggerLocation = true;
            }
        }
    }

    public boolean isLocationOn() {
        return this.mLocationClient != null && this.mLocationClient.isStarted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDLocation getCurrentLocation() {
        return this.mCurrentLocation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void triggerLocation(boolean z) {
        if (z) {
            startLocation();
        } else {
            stopLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnFirstLocationDoneListener(OnLocationFirstDoneListener onLocationFirstDoneListener) {
        this.mListener = onLocationFirstDoneListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class MyLocationListener extends BDAbstractLocationListener {
        MyLocationListener() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                MyLocationAnchor.this.stopLocation();
                return;
            }
            MyLocationAnchor.this.mBaiduMap.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (MyLocationAnchor.this.mMarker != null) {
                MyLocationAnchor.this.mMarker.remove();
                MyLocationAnchor.this.mMarker = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(MyLocationAnchor.this.mBitmap);
            MyLocationAnchor.this.mMarker = (Marker) MyLocationAnchor.this.mBaiduMap.addOverlay(icon);
            if (MyLocationAnchor.this.mCurrentLocation == null) {
                MyLocationAnchor.this.mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (MyLocationAnchor.this.mListener != null) {
                    MyLocationAnchor.this.mListener.onFirstLocationDone(bDLocation);
                }
            }
            MyLocationAnchor.this.mCurrentLocation = bDLocation;
        }
    }
}
