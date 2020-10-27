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
/* loaded from: classes25.dex */
public class a extends com.baidu.swan.apps.core.d.c implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int dYn = ah.L(20.0f);
    private RecyclerView dXS;
    private FrameLayout dXT;
    private FrameLayout dXU;
    private FrameLayout dXV;
    private View dXW;
    private View dXX;
    private TextView dXY;
    private ImageView dXZ;
    private BaiduMap dXk;
    private Marker dXl;
    private ImageView dXt;
    private View dYa;
    private GeoCoder dYb;
    private TextureMapView dYc;
    private BitmapDescriptor dYd;
    private g dYe;
    private List<g> dYf;
    private i dYg;
    private b dYh;
    private h dYi;
    private boolean dYj;
    private boolean dYk;
    private InterfaceC0541a dYl;
    private SelectedLocationInfo dYm;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0541a {
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

    public void aXa() {
        com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm != null) {
            adm.mM("navigateTo").al(com.baidu.swan.apps.core.d.f.cEZ, com.baidu.swan.apps.core.d.f.cFb).f(this).amM();
        }
    }

    public void a(InterfaceC0541a interfaceC0541a) {
        this.dYl = interfaceC0541a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aWC();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        aXk();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.dYf = new ArrayList(11);
        this.dXS = (RecyclerView) view.findViewById(R.id.location_list);
        this.dXt = (ImageView) view.findViewById(R.id.float_btn);
        this.dXT = (FrameLayout) view.findViewById(R.id.float_container);
        this.dXW = view.findViewById(R.id.cancel);
        this.dXX = view.findViewById(R.id.search);
        this.dXY = (TextView) view.findViewById(R.id.finish);
        this.dXZ = (ImageView) view.findViewById(R.id.center_ding);
        this.dXU = (FrameLayout) view.findViewById(R.id.list_container);
        this.dXV = (FrameLayout) view.findViewById(R.id.map_container);
        this.dYa = view.findViewById(R.id.loading_progress);
        this.dYc = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dXt.setOnClickListener(this);
        this.dXY.setOnClickListener(this);
        this.dXX.setOnClickListener(this);
        this.dXW.setOnClickListener(this);
        this.dYb = GeoCoder.newInstance();
        this.dXk = this.dYc.getMap();
        this.dYb.setOnGetGeoCodeResultListener(this);
        this.dXk.setOnMapLoadedCallback(this);
        this.dXk.setOnMapStatusChangeListener(this);
        this.dXS.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.axo().awY()));
        this.dYh = new b(com.baidu.swan.apps.v.f.axo().awY(), this.dXS, this, false);
        this.dXS.setAdapter(this.dYh);
        this.dXS.addItemDecoration(new f(com.baidu.swan.apps.v.f.axo().awY(), true));
        this.dYi = new h(this.dXU, this.dXV, this.dXT);
        ((FlipperFrameLayout) this.dXU).setViewFlipper(this.dYi);
    }

    private void f(LatLng latLng) {
        this.dYb.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void aXk() {
        this.dXk.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.dXk.getUiSettings().setRotateGesturesEnabled(false);
        this.dYc.showZoomControls(false);
        this.dYc.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!aXo()) {
            aXe();
        }
    }

    private void aXe() {
        this.dYg = new i(com.baidu.swan.apps.v.f.axo().awY(), this.dXk);
        this.dYg.hy(true);
        this.dYg.a(this);
        hA(true);
    }

    private void aXl() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dXZ, "translationY", 0.0f, -dYn, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.dYm != null) {
            poiInfo.name = this.dYm.mName;
            poiInfo.location = new LatLng(this.dYm.mLatitude, this.dYm.mLongitude);
            poiInfo.address = this.dYm.mAddress;
            this.dYm = null;
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
        this.dYf.clear();
        this.dYf.add(gVar);
        this.dYf.addAll(g.aN(reverseGeoCodeResult.getPoiList()));
        this.dYh.setData(this.dYf);
        this.dYe = gVar;
        if (this.dYf.size() > 0) {
            hA(false);
        }
    }

    private void hA(boolean z) {
        if (z) {
            this.dYf.clear();
            this.dYh.setData(this.dYf);
        }
        this.dYa.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        hA(true);
        f(latLng);
        aXm();
        if (z) {
            aXl();
            if (this.dYi.isFlipped()) {
                this.dYi.hE(false);
            }
        }
        if (z2) {
            this.dXS.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.dYg != null && this.dYg.aWI() != null) {
                BDLocation aWI = this.dYg.aWI();
                LatLng latLng = new LatLng(aWI.getLatitude(), aWI.getLongitude());
                this.dXk.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                aXm();
                if (this.dYk) {
                    a(latLng, true, true);
                    this.dYk = false;
                }
                hB(true);
            }
        } else if (view.getId() == R.id.finish) {
            mm(16);
            aXn();
        } else if (view.getId() == R.id.search) {
            b(this.dYe);
        } else if (view.getId() == R.id.cancel) {
            mm(17);
            aXn();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.dYC != null && gVar.dYC.location != null) {
            this.dYe = gVar;
            this.dXk.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.dYC.location));
            aXm();
            if (this.dYd == null) {
                this.dYd = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.dYD) {
                this.dXl = (Marker) this.dXk.addOverlay(new MarkerOptions().position(gVar.dYC.location).zIndex(88).icon(this.dYd));
            }
            if (!gVar.dYD) {
                hB(false);
            }
        }
    }

    private void aXm() {
        if (this.dXl != null) {
            this.dXl.remove();
            this.dXl = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.dXS.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.dYm = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.dXk.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.dYk = true;
                            a(latLng, false, true);
                            hB(false);
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

    private void mm(int i) {
        if (this.dYl != null) {
            switch (i) {
                case 16:
                    if (this.dYe != null) {
                        PoiInfo poiInfo = this.dYe.dYC;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.dYl.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.dYl.onCancel();
                    return;
                case 18:
                    this.dYl.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void aXn() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.dYl = null;
    }

    private void hB(boolean z) {
        if (this.dXt != null) {
            this.dXt.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.dYC != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.dYC.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.aXa();
        }
    }

    private boolean aXo() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.v.f.axo().awY().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.v.f.axo().awY(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                aXe();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.dYc.onResume();
        if (this.dYg != null) {
            this.dYg.hy(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dYc.onPause();
        if (this.dYg != null) {
            this.dYg.hy(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.dYc.onDestroy();
        }
        this.dYb.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        mm(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.dXk.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.dYj = i == 1;
        if (this.dYj || this.dYk) {
            z = true;
        }
        this.dYk = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.dYj) {
            a(mapStatus.target, true, true);
            hB(false);
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
    public boolean alq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agI() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alp() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean agC() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void an(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
