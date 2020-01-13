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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.impl.map.location.i;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.apps.core.d.b implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int csL = af.S(20.0f);
    private BaiduMap crI;
    private Marker crJ;
    private ImageView crR;
    private TextureMapView csA;
    private BitmapDescriptor csB;
    private g csC;
    private List<g> csD;
    private i csE;
    private b csF;
    private h csG;
    private boolean csH;
    private boolean csI;
    private InterfaceC0347a csJ;
    private SelectedLocationInfo csK;
    private RecyclerView csq;
    private FrameLayout csr;
    private FrameLayout css;
    private FrameLayout cst;
    private View csu;
    private View csv;
    private TextView csw;
    private ImageView csx;
    private View csy;
    private GeoCoder csz;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0347a {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    public static a U(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void apD() {
        com.baidu.swan.apps.core.d.e El = com.baidu.swan.apps.y.f.UC().El();
        if (El != null) {
            El.gM("navigateTo").Y(com.baidu.swan.apps.core.d.e.bjU, com.baidu.swan.apps.core.d.e.bjW).e(this).Mj();
        }
    }

    public void a(InterfaceC0347a interfaceC0347a) {
        this.csJ = interfaceC0347a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.ape();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        apN();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.csD = new ArrayList(11);
        this.csq = (RecyclerView) view.findViewById(R.id.location_list);
        this.crR = (ImageView) view.findViewById(R.id.float_btn);
        this.csr = (FrameLayout) view.findViewById(R.id.float_container);
        this.csu = view.findViewById(R.id.cancel);
        this.csv = view.findViewById(R.id.search);
        this.csw = (TextView) view.findViewById(R.id.finish);
        this.csx = (ImageView) view.findViewById(R.id.center_ding);
        this.css = (FrameLayout) view.findViewById(R.id.list_container);
        this.cst = (FrameLayout) view.findViewById(R.id.map_container);
        this.csy = view.findViewById(R.id.loading_progress);
        this.csA = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.crR.setOnClickListener(this);
        this.csw.setOnClickListener(this);
        this.csv.setOnClickListener(this);
        this.csu.setOnClickListener(this);
        this.csz = GeoCoder.newInstance();
        this.crI = this.csA.getMap();
        this.csz.setOnGetGeoCodeResultListener(this);
        this.crI.setOnMapLoadedCallback(this);
        this.crI.setOnMapStatusChangeListener(this);
        this.csq.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.y.f.UC().Un()));
        this.csF = new b(com.baidu.swan.apps.y.f.UC().Un(), this.csq, this, false);
        this.csq.setAdapter(this.csF);
        this.csq.addItemDecoration(new f(com.baidu.swan.apps.y.f.UC().Un(), true));
        this.csG = new h(this.css, this.cst, this.csr);
        ((FlipperFrameLayout) this.css).setViewFlipper(this.csG);
    }

    private void f(LatLng latLng) {
        this.csz.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void apN() {
        this.crI.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.crI.getUiSettings().setRotateGesturesEnabled(false);
        this.csA.showZoomControls(false);
        this.csA.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!apR()) {
            apH();
        }
    }

    private void apH() {
        this.csE = new i(com.baidu.swan.apps.y.f.UC().Un(), this.crI);
        this.csE.eD(true);
        this.csE.a(this);
        eF(true);
    }

    private void apO() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.csx, "translationY", 0.0f, -csL, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.csK != null) {
            poiInfo.name = this.csK.mName;
            poiInfo.location = new LatLng(this.csK.mLatitude, this.csK.mLongitude);
            poiInfo.address = this.csK.mAddress;
            this.csK = null;
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
        this.csD.clear();
        this.csD.add(gVar);
        this.csD.addAll(g.aj(reverseGeoCodeResult.getPoiList()));
        this.csF.setData(this.csD);
        this.csC = gVar;
        if (this.csD.size() > 0) {
            eF(false);
        }
    }

    private void eF(boolean z) {
        if (z) {
            this.csD.clear();
            this.csF.setData(this.csD);
        }
        this.csy.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        eF(true);
        f(latLng);
        apP();
        if (z) {
            apO();
            if (this.csG.isFlipped()) {
                this.csG.eJ(false);
            }
        }
        if (z2) {
            this.csq.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.csE != null && this.csE.apl() != null) {
                BDLocation apl = this.csE.apl();
                LatLng latLng = new LatLng(apl.getLatitude(), apl.getLongitude());
                this.crI.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                apP();
                if (this.csI) {
                    a(latLng, true, true);
                    this.csI = false;
                }
                eG(true);
            }
        } else if (view.getId() == R.id.finish) {
            hR(16);
            apQ();
        } else if (view.getId() == R.id.search) {
            b(this.csC);
        } else if (view.getId() == R.id.cancel) {
            hR(17);
            apQ();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.cta != null && gVar.cta.location != null) {
            this.csC = gVar;
            this.crI.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.cta.location));
            apP();
            if (this.csB == null) {
                this.csB = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.ctb) {
                this.crJ = (Marker) this.crI.addOverlay(new MarkerOptions().position(gVar.cta.location).zIndex(88).icon(this.csB));
            }
            if (!gVar.ctb) {
                eG(false);
            }
        }
    }

    private void apP() {
        if (this.crJ != null) {
            this.crJ.remove();
            this.crJ = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.csq.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                    SelectedLocationInfo selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra(SelectedLocationInfo.LOCATION_KEY);
                    if (selectedLocationInfo != null) {
                        double d = selectedLocationInfo.mLatitude;
                        double d2 = selectedLocationInfo.mLongitude;
                        if (!Double.isNaN(d) && !Double.isNaN(d2)) {
                            this.csK = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.crI.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.csI = true;
                            a(latLng, false, true);
                            eG(false);
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

    private void hR(int i) {
        if (this.csJ != null) {
            switch (i) {
                case 16:
                    if (this.csC != null) {
                        PoiInfo poiInfo = this.csC.cta;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.csJ.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.csJ.onCancel();
                    return;
                case 18:
                    this.csJ.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void apQ() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.csJ = null;
    }

    private void eG(boolean z) {
        if (this.crR != null) {
            this.crR.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.cta != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.cta.city);
            com.baidu.swan.impl.map.location.search.a V = com.baidu.swan.impl.map.location.search.a.V(bundle);
            V.a(this, 1);
            V.apD();
        }
    }

    private boolean apR() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.y.f.UC().Un().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.y.f.UC().Un(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                apH();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.csA.onResume();
        if (this.csE != null) {
            this.csE.eD(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.csA.onPause();
        if (this.csE != null) {
            this.csE.eD(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.csA.onDestroy();
        }
        this.csz.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Gt() {
        hR(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.crI.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.csH = i == 1;
        if (this.csH || this.csI) {
            z = true;
        }
        this.csI = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.csH) {
            a(mapStatus.target, true, true);
            eG(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Lf() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void GR() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Le() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean GO() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
