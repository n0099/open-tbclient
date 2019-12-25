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
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.apps.core.d.b implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int csA = af.T(20.0f);
    private ImageView crG;
    private BaiduMap crx;
    private Marker cry;
    private RecyclerView csf;
    private FrameLayout csg;
    private FrameLayout csh;
    private FrameLayout csi;
    private View csj;
    private View csk;
    private TextView csl;
    private ImageView csm;
    private View csn;
    private GeoCoder cso;
    private TextureMapView csp;
    private BitmapDescriptor csq;
    private g csr;
    private List<g> css;
    private i cst;
    private b csu;
    private h csv;
    private boolean csw;
    private boolean csx;
    private InterfaceC0345a csy;
    private SelectedLocationInfo csz;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0345a {
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

    public void apk() {
        com.baidu.swan.apps.core.d.e DP = com.baidu.swan.apps.y.f.Uf().DP();
        if (DP != null) {
            DP.gJ("navigateTo").U(com.baidu.swan.apps.core.d.e.bjf, com.baidu.swan.apps.core.d.e.bjh).e(this).LN();
        }
    }

    public void a(InterfaceC0345a interfaceC0345a) {
        this.csy = interfaceC0345a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aoL();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        apu();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.css = new ArrayList(11);
        this.csf = (RecyclerView) view.findViewById(R.id.location_list);
        this.crG = (ImageView) view.findViewById(R.id.float_btn);
        this.csg = (FrameLayout) view.findViewById(R.id.float_container);
        this.csj = view.findViewById(R.id.cancel);
        this.csk = view.findViewById(R.id.search);
        this.csl = (TextView) view.findViewById(R.id.finish);
        this.csm = (ImageView) view.findViewById(R.id.center_ding);
        this.csh = (FrameLayout) view.findViewById(R.id.list_container);
        this.csi = (FrameLayout) view.findViewById(R.id.map_container);
        this.csn = view.findViewById(R.id.loading_progress);
        this.csp = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.crG.setOnClickListener(this);
        this.csl.setOnClickListener(this);
        this.csk.setOnClickListener(this);
        this.csj.setOnClickListener(this);
        this.cso = GeoCoder.newInstance();
        this.crx = this.csp.getMap();
        this.cso.setOnGetGeoCodeResultListener(this);
        this.crx.setOnMapLoadedCallback(this);
        this.crx.setOnMapStatusChangeListener(this);
        this.csf.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.y.f.Uf().TQ()));
        this.csu = new b(com.baidu.swan.apps.y.f.Uf().TQ(), this.csf, this, false);
        this.csf.setAdapter(this.csu);
        this.csf.addItemDecoration(new f(com.baidu.swan.apps.y.f.Uf().TQ(), true));
        this.csv = new h(this.csh, this.csi, this.csg);
        ((FlipperFrameLayout) this.csh).setViewFlipper(this.csv);
    }

    private void f(LatLng latLng) {
        this.cso.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void apu() {
        this.crx.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.crx.getUiSettings().setRotateGesturesEnabled(false);
        this.csp.showZoomControls(false);
        this.csp.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!apy()) {
            apo();
        }
    }

    private void apo() {
        this.cst = new i(com.baidu.swan.apps.y.f.Uf().TQ(), this.crx);
        this.cst.ey(true);
        this.cst.a(this);
        eA(true);
    }

    private void apv() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.csm, "translationY", 0.0f, -csA, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.csz != null) {
            poiInfo.name = this.csz.mName;
            poiInfo.location = new LatLng(this.csz.mLatitude, this.csz.mLongitude);
            poiInfo.address = this.csz.mAddress;
            this.csz = null;
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
        this.css.clear();
        this.css.add(gVar);
        this.css.addAll(g.ak(reverseGeoCodeResult.getPoiList()));
        this.csu.setData(this.css);
        this.csr = gVar;
        if (this.css.size() > 0) {
            eA(false);
        }
    }

    private void eA(boolean z) {
        if (z) {
            this.css.clear();
            this.csu.setData(this.css);
        }
        this.csn.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        eA(true);
        f(latLng);
        apw();
        if (z) {
            apv();
            if (this.csv.isFlipped()) {
                this.csv.eE(false);
            }
        }
        if (z2) {
            this.csf.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.cst != null && this.cst.aoR() != null) {
                BDLocation aoR = this.cst.aoR();
                LatLng latLng = new LatLng(aoR.getLatitude(), aoR.getLongitude());
                this.crx.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                apw();
                if (this.csx) {
                    a(latLng, true, true);
                    this.csx = false;
                }
                eB(true);
            }
        } else if (view.getId() == R.id.finish) {
            hR(16);
            apx();
        } else if (view.getId() == R.id.search) {
            b(this.csr);
        } else if (view.getId() == R.id.cancel) {
            hR(17);
            apx();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.csP != null && gVar.csP.location != null) {
            this.csr = gVar;
            this.crx.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.csP.location));
            apw();
            if (this.csq == null) {
                this.csq = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.csQ) {
                this.cry = (Marker) this.crx.addOverlay(new MarkerOptions().position(gVar.csP.location).zIndex(88).icon(this.csq));
            }
            if (!gVar.csQ) {
                eB(false);
            }
        }
    }

    private void apw() {
        if (this.cry != null) {
            this.cry.remove();
            this.cry = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.csf.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.csz = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.crx.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.csx = true;
                            a(latLng, false, true);
                            eB(false);
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
        if (this.csy != null) {
            switch (i) {
                case 16:
                    if (this.csr != null) {
                        PoiInfo poiInfo = this.csr.csP;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.csy.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.csy.onCancel();
                    return;
                case 18:
                    this.csy.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void apx() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.csy = null;
    }

    private void eB(boolean z) {
        if (this.crG != null) {
            this.crG.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.csP != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.csP.city);
            com.baidu.swan.impl.map.location.search.a V = com.baidu.swan.impl.map.location.search.a.V(bundle);
            V.a(this, 1);
            V.apk();
        }
    }

    private boolean apy() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.y.f.Uf().TQ().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.y.f.Uf().TQ(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                apo();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.csp.onResume();
        if (this.cst != null) {
            this.cst.ey(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.csp.onPause();
        if (this.cst != null) {
            this.cst.ey(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.csp.onDestroy();
        }
        this.cso.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean FX() {
        hR(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.crx.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.csw = i == 1;
        if (this.csw || this.csx) {
            z = true;
        }
        this.csx = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.csw) {
            a(mapStatus.target, true, true);
            eB(false);
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
    public boolean KJ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Gv() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void KI() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Gs() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void aa(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
