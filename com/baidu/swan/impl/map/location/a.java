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
import android.view.MotionEvent;
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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.impl.map.location.i;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a extends com.baidu.swan.apps.core.d.c implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int ecw = ah.M(20.0f);
    private ImageView ebC;
    private BaiduMap ebt;
    private Marker ebu;
    private RecyclerView ecb;
    private FrameLayout ecc;
    private FrameLayout ecd;
    private FrameLayout ece;
    private View ecf;
    private View ecg;
    private TextView ech;
    private ImageView eci;
    private View ecj;
    private GeoCoder eck;
    private TextureMapView ecl;
    private BitmapDescriptor ecm;
    private g ecn;
    private List<g> eco;
    private i ecp;
    private b ecq;
    private h ecr;
    private boolean ecs;
    private boolean ect;
    private InterfaceC0551a ecu;
    private SelectedLocationInfo ecv;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC0551a {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    public static a aa(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aYT() {
        com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe != null) {
            afe.mV("navigateTo").al(com.baidu.swan.apps.core.d.f.cJi, com.baidu.swan.apps.core.d.f.cJk).f(this).aoE();
        }
    }

    public void a(InterfaceC0551a interfaceC0551a) {
        this.ecu = interfaceC0551a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aYv();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        aZd();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.eco = new ArrayList(11);
        this.ecb = (RecyclerView) view.findViewById(R.id.location_list);
        this.ebC = (ImageView) view.findViewById(R.id.float_btn);
        this.ecc = (FrameLayout) view.findViewById(R.id.float_container);
        this.ecf = view.findViewById(R.id.cancel);
        this.ecg = view.findViewById(R.id.search);
        this.ech = (TextView) view.findViewById(R.id.finish);
        this.eci = (ImageView) view.findViewById(R.id.center_ding);
        this.ecd = (FrameLayout) view.findViewById(R.id.list_container);
        this.ece = (FrameLayout) view.findViewById(R.id.map_container);
        this.ecj = view.findViewById(R.id.loading_progress);
        this.ecl = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.ebC.setOnClickListener(this);
        this.ech.setOnClickListener(this);
        this.ecg.setOnClickListener(this);
        this.ecf.setOnClickListener(this);
        this.eck = GeoCoder.newInstance();
        this.ebt = this.ecl.getMap();
        this.eck.setOnGetGeoCodeResultListener(this);
        this.ebt.setOnMapLoadedCallback(this);
        this.ebt.setOnMapStatusChangeListener(this);
        this.ecb.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.azg().ayQ()));
        this.ecq = new b(com.baidu.swan.apps.v.f.azg().ayQ(), this.ecb, this, false);
        this.ecb.setAdapter(this.ecq);
        this.ecb.addItemDecoration(new f(com.baidu.swan.apps.v.f.azg().ayQ(), true));
        this.ecr = new h(this.ecd, this.ece, this.ecc);
        ((FlipperFrameLayout) this.ecd).setViewFlipper(this.ecr);
    }

    private void f(LatLng latLng) {
        this.eck.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void aZd() {
        this.ebt.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.ebt.getUiSettings().setRotateGesturesEnabled(false);
        this.ecl.showZoomControls(false);
        this.ecl.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!aZh()) {
            aYX();
        }
    }

    private void aYX() {
        this.ecp = new i(com.baidu.swan.apps.v.f.azg().ayQ(), this.ebt);
        this.ecp.hK(true);
        this.ecp.a(this);
        hM(true);
    }

    private void aZe() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eci, "translationY", 0.0f, -ecw, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.ecv != null) {
            poiInfo.name = this.ecv.mName;
            poiInfo.location = new LatLng(this.ecv.mLatitude, this.ecv.mLongitude);
            poiInfo.address = this.ecv.mAddress;
            this.ecv = null;
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
        this.eco.clear();
        this.eco.add(gVar);
        this.eco.addAll(g.aU(reverseGeoCodeResult.getPoiList()));
        this.ecq.setData(this.eco);
        this.ecn = gVar;
        if (this.eco.size() > 0) {
            hM(false);
        }
    }

    private void hM(boolean z) {
        if (z) {
            this.eco.clear();
            this.ecq.setData(this.eco);
        }
        this.ecj.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        hM(true);
        f(latLng);
        aZf();
        if (z) {
            aZe();
            if (this.ecr.isFlipped()) {
                this.ecr.hQ(false);
            }
        }
        if (z2) {
            this.ecb.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.ecp != null && this.ecp.aYB() != null) {
                BDLocation aYB = this.ecp.aYB();
                LatLng latLng = new LatLng(aYB.getLatitude(), aYB.getLongitude());
                this.ebt.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                aZf();
                if (this.ect) {
                    a(latLng, true, true);
                    this.ect = false;
                }
                hN(true);
            }
        } else if (view.getId() == R.id.finish) {
            ms(16);
            aZg();
        } else if (view.getId() == R.id.search) {
            b(this.ecn);
        } else if (view.getId() == R.id.cancel) {
            ms(17);
            aZg();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.ecM != null && gVar.ecM.location != null) {
            this.ecn = gVar;
            this.ebt.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.ecM.location));
            aZf();
            if (this.ecm == null) {
                this.ecm = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.ecN) {
                this.ebu = (Marker) this.ebt.addOverlay(new MarkerOptions().position(gVar.ecM.location).zIndex(88).icon(this.ecm));
            }
            if (!gVar.ecN) {
                hN(false);
            }
        }
    }

    private void aZf() {
        if (this.ebu != null) {
            this.ebu.remove();
            this.ebu = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.ecb.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(reverseGeoCodeResult);
                }
            }, 150L);
        }
    }

    @Override // com.baidu.swan.impl.map.location.i.b
    public void e(BDLocation bDLocation) {
        f(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            switch (i) {
                case 1:
                    SelectedLocationInfo selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra(SelectedLocationInfo.LOCATION_KEY);
                    if (selectedLocationInfo != null) {
                        double d = selectedLocationInfo.mLatitude;
                        double d2 = selectedLocationInfo.mLongitude;
                        if (!Double.isNaN(d) && !Double.isNaN(d2)) {
                            this.ecv = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.ebt.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.ect = true;
                            a(latLng, false, true);
                            hN(false);
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

    private void ms(int i) {
        if (this.ecu != null) {
            switch (i) {
                case 16:
                    if (this.ecn != null) {
                        PoiInfo poiInfo = this.ecn.ecM;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.ecu.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.ecu.onCancel();
                    return;
                case 18:
                    this.ecu.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void aZg() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.ecu = null;
    }

    private void hN(boolean z) {
        if (this.ebC != null) {
            this.ebC.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.ecM != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.ecM.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.aYT();
        }
    }

    private boolean aZh() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.v.f.azg().ayQ().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.v.f.azg().ayQ(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                aYX();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.ecl.onResume();
        if (this.ecp != null) {
            this.ecp.hK(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ecl.onPause();
        if (this.ecp != null) {
            this.ecp.hK(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.ecl.onDestroy();
        }
        this.eck.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ahT() {
        ms(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.ebt.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.ecs = i == 1;
        if (this.ecs || this.ect) {
            z = true;
        }
        this.ect = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.ecs) {
            a(mapStatus.target, true, true);
            hN(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ani() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiA() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anh() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiu() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ar(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
