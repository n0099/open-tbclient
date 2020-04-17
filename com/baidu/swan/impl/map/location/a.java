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
/* loaded from: classes12.dex */
public class a extends com.baidu.swan.apps.core.d.b implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int cVW = af.C(20.0f);
    private BaiduMap cUT;
    private Marker cUU;
    private RecyclerView cVB;
    private FrameLayout cVC;
    private FrameLayout cVD;
    private FrameLayout cVE;
    private View cVF;
    private View cVG;
    private TextView cVH;
    private ImageView cVI;
    private View cVJ;
    private GeoCoder cVK;
    private TextureMapView cVL;
    private BitmapDescriptor cVM;
    private g cVN;
    private List<g> cVO;
    private i cVP;
    private b cVQ;
    private h cVR;
    private boolean cVS;
    private boolean cVT;
    private InterfaceC0387a cVU;
    private SelectedLocationInfo cVV;
    private ImageView cVc;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0387a {
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

    public void aAg() {
        com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        if (Ou != null) {
            Ou.io("navigateTo").ab(com.baidu.swan.apps.core.d.e.bMz, com.baidu.swan.apps.core.d.e.bMB).e(this).Wq();
        }
    }

    public void a(InterfaceC0387a interfaceC0387a) {
        this.cVU = interfaceC0387a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.azI();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        aAq();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.cVO = new ArrayList(11);
        this.cVB = (RecyclerView) view.findViewById(R.id.location_list);
        this.cVc = (ImageView) view.findViewById(R.id.float_btn);
        this.cVC = (FrameLayout) view.findViewById(R.id.float_container);
        this.cVF = view.findViewById(R.id.cancel);
        this.cVG = view.findViewById(R.id.search);
        this.cVH = (TextView) view.findViewById(R.id.finish);
        this.cVI = (ImageView) view.findViewById(R.id.center_ding);
        this.cVD = (FrameLayout) view.findViewById(R.id.list_container);
        this.cVE = (FrameLayout) view.findViewById(R.id.map_container);
        this.cVJ = view.findViewById(R.id.loading_progress);
        this.cVL = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.cVc.setOnClickListener(this);
        this.cVH.setOnClickListener(this);
        this.cVG.setOnClickListener(this);
        this.cVF.setOnClickListener(this);
        this.cVK = GeoCoder.newInstance();
        this.cUT = this.cVL.getMap();
        this.cVK.setOnGetGeoCodeResultListener(this);
        this.cUT.setOnMapLoadedCallback(this);
        this.cUT.setOnMapStatusChangeListener(this);
        this.cVB.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.y.f.aeK().aev()));
        this.cVQ = new b(com.baidu.swan.apps.y.f.aeK().aev(), this.cVB, this, false);
        this.cVB.setAdapter(this.cVQ);
        this.cVB.addItemDecoration(new f(com.baidu.swan.apps.y.f.aeK().aev(), true));
        this.cVR = new h(this.cVD, this.cVE, this.cVC);
        ((FlipperFrameLayout) this.cVD).setViewFlipper(this.cVR);
    }

    private void f(LatLng latLng) {
        this.cVK.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void aAq() {
        this.cUT.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.cUT.getUiSettings().setRotateGesturesEnabled(false);
        this.cVL.showZoomControls(false);
        this.cVL.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!aAu()) {
            aAk();
        }
    }

    private void aAk() {
        this.cVP = new i(com.baidu.swan.apps.y.f.aeK().aev(), this.cUT);
        this.cVP.fI(true);
        this.cVP.a(this);
        fK(true);
    }

    private void aAr() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cVI, "translationY", 0.0f, -cVW, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.cVV != null) {
            poiInfo.name = this.cVV.mName;
            poiInfo.location = new LatLng(this.cVV.mLatitude, this.cVV.mLongitude);
            poiInfo.address = this.cVV.mAddress;
            this.cVV = null;
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
        this.cVO.clear();
        this.cVO.add(gVar);
        this.cVO.addAll(g.as(reverseGeoCodeResult.getPoiList()));
        this.cVQ.setData(this.cVO);
        this.cVN = gVar;
        if (this.cVO.size() > 0) {
            fK(false);
        }
    }

    private void fK(boolean z) {
        if (z) {
            this.cVO.clear();
            this.cVQ.setData(this.cVO);
        }
        this.cVJ.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        fK(true);
        f(latLng);
        aAs();
        if (z) {
            aAr();
            if (this.cVR.isFlipped()) {
                this.cVR.fO(false);
            }
        }
        if (z2) {
            this.cVB.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.cVP != null && this.cVP.azO() != null) {
                BDLocation azO = this.cVP.azO();
                LatLng latLng = new LatLng(azO.getLatitude(), azO.getLongitude());
                this.cUT.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                aAs();
                if (this.cVT) {
                    a(latLng, true, true);
                    this.cVT = false;
                }
                fL(true);
            }
        } else if (view.getId() == R.id.finish) {
            ip(16);
            aAt();
        } else if (view.getId() == R.id.search) {
            b(this.cVN);
        } else if (view.getId() == R.id.cancel) {
            ip(17);
            aAt();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.cWl != null && gVar.cWl.location != null) {
            this.cVN = gVar;
            this.cUT.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.cWl.location));
            aAs();
            if (this.cVM == null) {
                this.cVM = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.cWm) {
                this.cUU = (Marker) this.cUT.addOverlay(new MarkerOptions().position(gVar.cWl.location).zIndex(88).icon(this.cVM));
            }
            if (!gVar.cWm) {
                fL(false);
            }
        }
    }

    private void aAs() {
        if (this.cUU != null) {
            this.cUU.remove();
            this.cUU = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.cVB.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.cVV = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.cUT.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.cVT = true;
                            a(latLng, false, true);
                            fL(false);
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

    private void ip(int i) {
        if (this.cVU != null) {
            switch (i) {
                case 16:
                    if (this.cVN != null) {
                        PoiInfo poiInfo = this.cVN.cWl;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.cVU.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.cVU.onCancel();
                    return;
                case 18:
                    this.cVU.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void aAt() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.cVU = null;
    }

    private void fL(boolean z) {
        if (this.cVc != null) {
            this.cVc.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.cWl != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.cWl.city);
            com.baidu.swan.impl.map.location.search.a V = com.baidu.swan.impl.map.location.search.a.V(bundle);
            V.a(this, 1);
            V.aAg();
        }
    }

    private boolean aAu() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.y.f.aeK().aev().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.y.f.aeK().aev(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                aAk();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cVL.onResume();
        if (this.cVP != null) {
            this.cVP.fI(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cVL.onPause();
        if (this.cVP != null) {
            this.cVP.fI(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.cVL.onDestroy();
        }
        this.cVK.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qz() {
        ip(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.cUT.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.cVS = i == 1;
        if (this.cVS || this.cVT) {
            z = true;
        }
        this.cVT = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.cVS) {
            a(mapStatus.target, true, true);
            fL(false);
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
    public boolean Vm() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void QX() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vl() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QU() {
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
