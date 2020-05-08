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
    private static final int cWb = af.C(20.0f);
    private BaiduMap cUY;
    private Marker cUZ;
    private RecyclerView cVG;
    private FrameLayout cVH;
    private FrameLayout cVI;
    private FrameLayout cVJ;
    private View cVK;
    private View cVL;
    private TextView cVM;
    private ImageView cVN;
    private View cVO;
    private GeoCoder cVP;
    private TextureMapView cVQ;
    private BitmapDescriptor cVR;
    private g cVS;
    private List<g> cVT;
    private i cVU;
    private b cVV;
    private h cVW;
    private boolean cVX;
    private boolean cVY;
    private InterfaceC0408a cVZ;
    private ImageView cVh;
    private SelectedLocationInfo cWa;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0408a {
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
        com.baidu.swan.apps.core.d.e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
        if (Ot != null) {
            Ot.io("navigateTo").ab(com.baidu.swan.apps.core.d.e.bME, com.baidu.swan.apps.core.d.e.bMG).e(this).Wp();
        }
    }

    public void a(InterfaceC0408a interfaceC0408a) {
        this.cVZ = interfaceC0408a;
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
        this.cVT = new ArrayList(11);
        this.cVG = (RecyclerView) view.findViewById(R.id.location_list);
        this.cVh = (ImageView) view.findViewById(R.id.float_btn);
        this.cVH = (FrameLayout) view.findViewById(R.id.float_container);
        this.cVK = view.findViewById(R.id.cancel);
        this.cVL = view.findViewById(R.id.search);
        this.cVM = (TextView) view.findViewById(R.id.finish);
        this.cVN = (ImageView) view.findViewById(R.id.center_ding);
        this.cVI = (FrameLayout) view.findViewById(R.id.list_container);
        this.cVJ = (FrameLayout) view.findViewById(R.id.map_container);
        this.cVO = view.findViewById(R.id.loading_progress);
        this.cVQ = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.cVh.setOnClickListener(this);
        this.cVM.setOnClickListener(this);
        this.cVL.setOnClickListener(this);
        this.cVK.setOnClickListener(this);
        this.cVP = GeoCoder.newInstance();
        this.cUY = this.cVQ.getMap();
        this.cVP.setOnGetGeoCodeResultListener(this);
        this.cUY.setOnMapLoadedCallback(this);
        this.cUY.setOnMapStatusChangeListener(this);
        this.cVG.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.y.f.aeJ().aeu()));
        this.cVV = new b(com.baidu.swan.apps.y.f.aeJ().aeu(), this.cVG, this, false);
        this.cVG.setAdapter(this.cVV);
        this.cVG.addItemDecoration(new f(com.baidu.swan.apps.y.f.aeJ().aeu(), true));
        this.cVW = new h(this.cVI, this.cVJ, this.cVH);
        ((FlipperFrameLayout) this.cVI).setViewFlipper(this.cVW);
    }

    private void f(LatLng latLng) {
        this.cVP.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void aAq() {
        this.cUY.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.cUY.getUiSettings().setRotateGesturesEnabled(false);
        this.cVQ.showZoomControls(false);
        this.cVQ.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!aAu()) {
            aAk();
        }
    }

    private void aAk() {
        this.cVU = new i(com.baidu.swan.apps.y.f.aeJ().aeu(), this.cUY);
        this.cVU.fI(true);
        this.cVU.a(this);
        fK(true);
    }

    private void aAr() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cVN, "translationY", 0.0f, -cWb, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.cWa != null) {
            poiInfo.name = this.cWa.mName;
            poiInfo.location = new LatLng(this.cWa.mLatitude, this.cWa.mLongitude);
            poiInfo.address = this.cWa.mAddress;
            this.cWa = null;
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
        this.cVT.clear();
        this.cVT.add(gVar);
        this.cVT.addAll(g.as(reverseGeoCodeResult.getPoiList()));
        this.cVV.setData(this.cVT);
        this.cVS = gVar;
        if (this.cVT.size() > 0) {
            fK(false);
        }
    }

    private void fK(boolean z) {
        if (z) {
            this.cVT.clear();
            this.cVV.setData(this.cVT);
        }
        this.cVO.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        fK(true);
        f(latLng);
        aAs();
        if (z) {
            aAr();
            if (this.cVW.isFlipped()) {
                this.cVW.fO(false);
            }
        }
        if (z2) {
            this.cVG.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.cVU != null && this.cVU.azO() != null) {
                BDLocation azO = this.cVU.azO();
                LatLng latLng = new LatLng(azO.getLatitude(), azO.getLongitude());
                this.cUY.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                aAs();
                if (this.cVY) {
                    a(latLng, true, true);
                    this.cVY = false;
                }
                fL(true);
            }
        } else if (view.getId() == R.id.finish) {
            ip(16);
            aAt();
        } else if (view.getId() == R.id.search) {
            b(this.cVS);
        } else if (view.getId() == R.id.cancel) {
            ip(17);
            aAt();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.cWq != null && gVar.cWq.location != null) {
            this.cVS = gVar;
            this.cUY.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.cWq.location));
            aAs();
            if (this.cVR == null) {
                this.cVR = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.cWr) {
                this.cUZ = (Marker) this.cUY.addOverlay(new MarkerOptions().position(gVar.cWq.location).zIndex(88).icon(this.cVR));
            }
            if (!gVar.cWr) {
                fL(false);
            }
        }
    }

    private void aAs() {
        if (this.cUZ != null) {
            this.cUZ.remove();
            this.cUZ = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.cVG.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.cWa = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.cUY.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.cVY = true;
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
        if (this.cVZ != null) {
            switch (i) {
                case 16:
                    if (this.cVS != null) {
                        PoiInfo poiInfo = this.cVS.cWq;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.cVZ.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.cVZ.onCancel();
                    return;
                case 18:
                    this.cVZ.onError();
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
        this.cVZ = null;
    }

    private void fL(boolean z) {
        if (this.cVh != null) {
            this.cVh.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.cWq != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.cWq.city);
            com.baidu.swan.impl.map.location.search.a V = com.baidu.swan.impl.map.location.search.a.V(bundle);
            V.a(this, 1);
            V.aAg();
        }
    }

    private boolean aAu() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.y.f.aeJ().aeu().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.y.f.aeJ().aeu(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                aAk();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cVQ.onResume();
        if (this.cVU != null) {
            this.cVU.fI(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cVQ.onPause();
        if (this.cVU != null) {
            this.cVU.fI(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.cVQ.onDestroy();
        }
        this.cVP.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qy() {
        ip(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.cUY.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.cVX = i == 1;
        if (this.cVX || this.cVY) {
            z = true;
        }
        this.cVY = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.cVX) {
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
    public boolean Vl() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void QW() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vk() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QT() {
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
