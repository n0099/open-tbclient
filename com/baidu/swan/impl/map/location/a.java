package com.baidu.swan.impl.map.location;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.impl.map.location.i;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.baidu.swan.apps.core.d.b implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int bIb = z.S(20.0f);
    private BaiduMap bGY;
    private Marker bGZ;
    private RecyclerView bHG;
    private FrameLayout bHH;
    private FrameLayout bHI;
    private FrameLayout bHJ;
    private View bHK;
    private View bHL;
    private TextView bHM;
    private ImageView bHN;
    private View bHO;
    private GeoCoder bHP;
    private TextureMapView bHQ;
    private BitmapDescriptor bHR;
    private g bHS;
    private List<g> bHT;
    private i bHU;
    private b bHV;
    private h bHW;
    private boolean bHX;
    private boolean bHY;
    private InterfaceC0264a bHZ;
    private ImageView bHh;
    private SelectedLocationInfo bIa;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0264a {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    public static a B(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void ZD() {
        com.baidu.swan.apps.core.d.e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH != null) {
            AH.eC("navigateTo").H(com.baidu.swan.apps.core.d.e.aLl, com.baidu.swan.apps.core.d.e.aLn).c(this).FC();
        }
    }

    public void a(InterfaceC0264a interfaceC0264a) {
        this.bHZ = interfaceC0264a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.Zi();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        ZM();
        if (EI()) {
            inflate = Y(inflate);
            da(-1);
        }
        return a(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.bHT = new ArrayList(11);
        this.bHG = (RecyclerView) view.findViewById(R.id.location_list);
        this.bHh = (ImageView) view.findViewById(R.id.float_btn);
        this.bHH = (FrameLayout) view.findViewById(R.id.float_container);
        this.bHK = view.findViewById(R.id.cancel);
        this.bHL = view.findViewById(R.id.search);
        this.bHM = (TextView) view.findViewById(R.id.finish);
        this.bHN = (ImageView) view.findViewById(R.id.center_ding);
        this.bHI = (FrameLayout) view.findViewById(R.id.list_container);
        this.bHJ = (FrameLayout) view.findViewById(R.id.map_container);
        this.bHO = view.findViewById(R.id.loading_progress);
        this.bHQ = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.bHh.setOnClickListener(this);
        this.bHM.setOnClickListener(this);
        this.bHL.setOnClickListener(this);
        this.bHK.setOnClickListener(this);
        this.bHP = GeoCoder.newInstance();
        this.bGY = this.bHQ.getMap();
        this.bHP.setOnGetGeoCodeResultListener(this);
        this.bGY.setOnMapLoadedCallback(this);
        this.bGY.setOnMapStatusChangeListener(this);
        this.bHG.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.w.e.LD().Lp()));
        this.bHV = new b(com.baidu.swan.apps.w.e.LD().Lp(), this.bHG, this, false);
        this.bHG.setAdapter(this.bHV);
        this.bHG.addItemDecoration(new f(com.baidu.swan.apps.w.e.LD().Lp(), true));
        this.bHW = new h(this.bHI, this.bHJ, this.bHH);
        ((FlipperFrameLayout) this.bHI).setViewFlipper(this.bHW);
    }

    private void f(LatLng latLng) {
        this.bHP.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void ZM() {
        this.bGY.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.bGY.getUiSettings().setRotateGesturesEnabled(false);
        this.bHQ.showZoomControls(false);
        this.bHQ.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!ZQ()) {
            ZH();
        }
    }

    private void ZH() {
        this.bHU = new i(com.baidu.swan.apps.w.e.LD().Lp(), this.bGY);
        this.bHU.dn(true);
        this.bHU.a(this);
        dp(true);
    }

    private void ZN() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bHN, "translationY", 0.0f, -bIb, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.bIa != null) {
            poiInfo.name = this.bIa.mName;
            poiInfo.location = new LatLng(this.bIa.mLatitude, this.bIa.mLongitude);
            poiInfo.address = this.bIa.mAddress;
            this.bIa = null;
            z = false;
        } else {
            String address = reverseGeoCodeResult.getAddress();
            String sematicDescription = reverseGeoCodeResult.getSematicDescription();
            if (TextUtils.isEmpty(address)) {
                address = "[位置]";
            }
            poiInfo.name = address;
            poiInfo.location = reverseGeoCodeResult.getLocation();
            poiInfo.address = sematicDescription;
            ReverseGeoCodeResult.AddressComponent addressDetail = reverseGeoCodeResult.getAddressDetail();
            if (addressDetail != null) {
                poiInfo.city = addressDetail.city;
            }
            z = true;
        }
        g gVar = new g(poiInfo, true, z);
        this.bHT.clear();
        this.bHT.add(gVar);
        this.bHT.addAll(g.ae(reverseGeoCodeResult.getPoiList()));
        this.bHV.setData(this.bHT);
        this.bHS = gVar;
        if (this.bHT.size() > 0) {
            dp(false);
        }
    }

    private void dp(boolean z) {
        if (z) {
            this.bHT.clear();
            this.bHV.setData(this.bHT);
        }
        this.bHO.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        dp(true);
        f(latLng);
        ZO();
        if (z) {
            ZN();
            if (this.bHW.ZV()) {
                this.bHW.du(false);
            }
        }
        if (z2) {
            this.bHG.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.bHU != null && this.bHU.Zo() != null) {
                BDLocation Zo = this.bHU.Zo();
                LatLng latLng = new LatLng(Zo.getLatitude(), Zo.getLongitude());
                this.bGY.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                ZO();
                if (this.bHY) {
                    a(latLng, true, true);
                    this.bHY = false;
                }
                dq(true);
            }
        } else if (view.getId() == R.id.finish) {
            gn(16);
            ZP();
        } else if (view.getId() == R.id.search) {
            b(this.bHS);
        } else if (view.getId() == R.id.cancel) {
            gn(17);
            ZP();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.bIq != null && gVar.bIq.location != null) {
            this.bHS = gVar;
            this.bGY.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.bIq.location));
            ZO();
            if (this.bHR == null) {
                this.bHR = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.bIr) {
                this.bGZ = (Marker) this.bGY.addOverlay(new MarkerOptions().position(gVar.bIq.location).zIndex(88).icon(this.bHR));
            }
            if (!gVar.bIr) {
                dq(false);
            }
        }
    }

    private void ZO() {
        if (this.bGZ != null) {
            this.bGZ.remove();
            this.bGZ = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.bHG.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(reverseGeoCodeResult);
                }
            }, 150L);
        }
    }

    @Override // com.baidu.swan.impl.map.location.i.b
    public void d(BDLocation bDLocation) {
        f(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            switch (i) {
                case 1:
                    SelectedLocationInfo selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra("SelectedLocationInfo");
                    if (selectedLocationInfo != null) {
                        double d = selectedLocationInfo.mLatitude;
                        double d2 = selectedLocationInfo.mLongitude;
                        if (!Double.isNaN(d) && !Double.isNaN(d2)) {
                            this.bIa = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.bGY.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.bHY = true;
                            a(latLng, false, true);
                            dq(false);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void gn(int i) {
        if (this.bHZ != null) {
            switch (i) {
                case 16:
                    if (this.bHS != null) {
                        PoiInfo poiInfo = this.bHS.bIq;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.bHZ.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.bHZ.onCancel();
                    return;
                case 18:
                    this.bHZ.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void ZP() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.bHZ = null;
    }

    private void dq(boolean z) {
        if (this.bHh != null) {
            this.bHh.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.bIq != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.bIq.city);
            com.baidu.swan.impl.map.location.search.a C = com.baidu.swan.impl.map.location.search.a.C(bundle);
            C.a(this, 1);
            C.ZD();
        }
    }

    private boolean ZQ() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.w.e.LD().Lp().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (arrayList.size() > 0) {
                requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 0);
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 3001) {
            if (iArr.length > 0 && iArr[0] == -1) {
                com.baidu.swan.apps.res.widget.b.d.i(com.baidu.swan.apps.w.e.LD().Lp(), R.string.aiapps_location_permission_fail).QN();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                ZH();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bHQ.onResume();
        if (this.bHU != null) {
            this.bHU.dn(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bHQ.onPause();
        if (this.bHU != null) {
            this.bHU.dn(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.bHQ.onDestroy();
        }
        this.bHP.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Cn() {
        gn(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.bGY.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.bHX = i == 1;
        if (this.bHX || this.bHY) {
            z = true;
        }
        this.bHY = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.bHX) {
            a(mapStatus.target, true, true);
            dq(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ev() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Et() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CB() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void U(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
