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
/* loaded from: classes19.dex */
public class a extends com.baidu.swan.apps.core.d.c implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int dBO = ah.H(20.0f);
    private BaiduMap dAL;
    private Marker dAM;
    private ImageView dAU;
    private ImageView dBA;
    private View dBB;
    private GeoCoder dBC;
    private TextureMapView dBD;
    private BitmapDescriptor dBE;
    private g dBF;
    private List<g> dBG;
    private i dBH;
    private b dBI;
    private h dBJ;
    private boolean dBK;
    private boolean dBL;
    private InterfaceC0515a dBM;
    private SelectedLocationInfo dBN;
    private RecyclerView dBt;
    private FrameLayout dBu;
    private FrameLayout dBv;
    private FrameLayout dBw;
    private View dBx;
    private View dBy;
    private TextView dBz;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC0515a {
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

    public void aRL() {
        com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX != null) {
            XX.lo("navigateTo").al(com.baidu.swan.apps.core.d.f.cik, com.baidu.swan.apps.core.d.f.cim).f(this).ahx();
        }
    }

    public void a(InterfaceC0515a interfaceC0515a) {
        this.dBM = interfaceC0515a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aRn();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        aRV();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.dBG = new ArrayList(11);
        this.dBt = (RecyclerView) view.findViewById(R.id.location_list);
        this.dAU = (ImageView) view.findViewById(R.id.float_btn);
        this.dBu = (FrameLayout) view.findViewById(R.id.float_container);
        this.dBx = view.findViewById(R.id.cancel);
        this.dBy = view.findViewById(R.id.search);
        this.dBz = (TextView) view.findViewById(R.id.finish);
        this.dBA = (ImageView) view.findViewById(R.id.center_ding);
        this.dBv = (FrameLayout) view.findViewById(R.id.list_container);
        this.dBw = (FrameLayout) view.findViewById(R.id.map_container);
        this.dBB = view.findViewById(R.id.loading_progress);
        this.dBD = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dAU.setOnClickListener(this);
        this.dBz.setOnClickListener(this);
        this.dBy.setOnClickListener(this);
        this.dBx.setOnClickListener(this);
        this.dBC = GeoCoder.newInstance();
        this.dAL = this.dBD.getMap();
        this.dBC.setOnGetGeoCodeResultListener(this);
        this.dAL.setOnMapLoadedCallback(this);
        this.dAL.setOnMapStatusChangeListener(this);
        this.dBt.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.arY().arI()));
        this.dBI = new b(com.baidu.swan.apps.v.f.arY().arI(), this.dBt, this, false);
        this.dBt.setAdapter(this.dBI);
        this.dBt.addItemDecoration(new f(com.baidu.swan.apps.v.f.arY().arI(), true));
        this.dBJ = new h(this.dBv, this.dBw, this.dBu);
        ((FlipperFrameLayout) this.dBv).setViewFlipper(this.dBJ);
    }

    private void f(LatLng latLng) {
        this.dBC.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void aRV() {
        this.dAL.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.dAL.getUiSettings().setRotateGesturesEnabled(false);
        this.dBD.showZoomControls(false);
        this.dBD.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!aRZ()) {
            aRP();
        }
    }

    private void aRP() {
        this.dBH = new i(com.baidu.swan.apps.v.f.arY().arI(), this.dAL);
        this.dBH.gR(true);
        this.dBH.a(this);
        gT(true);
    }

    private void aRW() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dBA, "translationY", 0.0f, -dBO, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.dBN != null) {
            poiInfo.name = this.dBN.mName;
            poiInfo.location = new LatLng(this.dBN.mLatitude, this.dBN.mLongitude);
            poiInfo.address = this.dBN.mAddress;
            this.dBN = null;
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
        this.dBG.clear();
        this.dBG.add(gVar);
        this.dBG.addAll(g.aw(reverseGeoCodeResult.getPoiList()));
        this.dBI.setData(this.dBG);
        this.dBF = gVar;
        if (this.dBG.size() > 0) {
            gT(false);
        }
    }

    private void gT(boolean z) {
        if (z) {
            this.dBG.clear();
            this.dBI.setData(this.dBG);
        }
        this.dBB.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        gT(true);
        f(latLng);
        aRX();
        if (z) {
            aRW();
            if (this.dBJ.isFlipped()) {
                this.dBJ.gX(false);
            }
        }
        if (z2) {
            this.dBt.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.dBH != null && this.dBH.aRt() != null) {
                BDLocation aRt = this.dBH.aRt();
                LatLng latLng = new LatLng(aRt.getLatitude(), aRt.getLongitude());
                this.dAL.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                aRX();
                if (this.dBL) {
                    a(latLng, true, true);
                    this.dBL = false;
                }
                gU(true);
            }
        } else if (view.getId() == R.id.finish) {
            lt(16);
            aRY();
        } else if (view.getId() == R.id.search) {
            b(this.dBF);
        } else if (view.getId() == R.id.cancel) {
            lt(17);
            aRY();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.dCd != null && gVar.dCd.location != null) {
            this.dBF = gVar;
            this.dAL.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.dCd.location));
            aRX();
            if (this.dBE == null) {
                this.dBE = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.dCe) {
                this.dAM = (Marker) this.dAL.addOverlay(new MarkerOptions().position(gVar.dCd.location).zIndex(88).icon(this.dBE));
            }
            if (!gVar.dCe) {
                gU(false);
            }
        }
    }

    private void aRX() {
        if (this.dAM != null) {
            this.dAM.remove();
            this.dAM = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.dBt.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.dBN = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.dAL.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.dBL = true;
                            a(latLng, false, true);
                            gU(false);
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

    private void lt(int i) {
        if (this.dBM != null) {
            switch (i) {
                case 16:
                    if (this.dBF != null) {
                        PoiInfo poiInfo = this.dBF.dCd;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.dBM.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.dBM.onCancel();
                    return;
                case 18:
                    this.dBM.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void aRY() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.dBM = null;
    }

    private void gU(boolean z) {
        if (this.dAU != null) {
            this.dAU.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.dCd != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.dCd.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.aRL();
        }
    }

    private boolean aRZ() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.v.f.arY().arI().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.v.f.arY().arI(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                aRP();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.dBD.onResume();
        if (this.dBH != null) {
            this.dBH.gR(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dBD.onPause();
        if (this.dBH != null) {
            this.dBH.gR(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.dBD.onDestroy();
        }
        this.dBC.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        lt(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.dAL.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.dBK = i == 1;
        if (this.dBK || this.dBL) {
            z = true;
        }
        this.dBL = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.dBK) {
            a(mapStatus.target, true, true);
            gU(false);
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
    public boolean agb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void abt() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aga() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abn() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ai(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
