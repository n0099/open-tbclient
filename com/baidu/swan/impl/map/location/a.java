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
    private static final int dBK = ah.H(20.0f);
    private BaiduMap dAH;
    private Marker dAI;
    private ImageView dAQ;
    private BitmapDescriptor dBA;
    private g dBB;
    private List<g> dBC;
    private i dBD;
    private b dBE;
    private h dBF;
    private boolean dBG;
    private boolean dBH;
    private InterfaceC0515a dBI;
    private SelectedLocationInfo dBJ;
    private RecyclerView dBp;
    private FrameLayout dBq;
    private FrameLayout dBr;
    private FrameLayout dBs;
    private View dBt;
    private View dBu;
    private TextView dBv;
    private ImageView dBw;
    private View dBx;
    private GeoCoder dBy;
    private TextureMapView dBz;

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
            XX.ln("navigateTo").al(com.baidu.swan.apps.core.d.f.cig, com.baidu.swan.apps.core.d.f.cii).f(this).ahx();
        }
    }

    public void a(InterfaceC0515a interfaceC0515a) {
        this.dBI = interfaceC0515a;
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
        this.dBC = new ArrayList(11);
        this.dBp = (RecyclerView) view.findViewById(R.id.location_list);
        this.dAQ = (ImageView) view.findViewById(R.id.float_btn);
        this.dBq = (FrameLayout) view.findViewById(R.id.float_container);
        this.dBt = view.findViewById(R.id.cancel);
        this.dBu = view.findViewById(R.id.search);
        this.dBv = (TextView) view.findViewById(R.id.finish);
        this.dBw = (ImageView) view.findViewById(R.id.center_ding);
        this.dBr = (FrameLayout) view.findViewById(R.id.list_container);
        this.dBs = (FrameLayout) view.findViewById(R.id.map_container);
        this.dBx = view.findViewById(R.id.loading_progress);
        this.dBz = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dAQ.setOnClickListener(this);
        this.dBv.setOnClickListener(this);
        this.dBu.setOnClickListener(this);
        this.dBt.setOnClickListener(this);
        this.dBy = GeoCoder.newInstance();
        this.dAH = this.dBz.getMap();
        this.dBy.setOnGetGeoCodeResultListener(this);
        this.dAH.setOnMapLoadedCallback(this);
        this.dAH.setOnMapStatusChangeListener(this);
        this.dBp.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.arY().arI()));
        this.dBE = new b(com.baidu.swan.apps.v.f.arY().arI(), this.dBp, this, false);
        this.dBp.setAdapter(this.dBE);
        this.dBp.addItemDecoration(new f(com.baidu.swan.apps.v.f.arY().arI(), true));
        this.dBF = new h(this.dBr, this.dBs, this.dBq);
        ((FlipperFrameLayout) this.dBr).setViewFlipper(this.dBF);
    }

    private void f(LatLng latLng) {
        this.dBy.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void aRV() {
        this.dAH.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.dAH.getUiSettings().setRotateGesturesEnabled(false);
        this.dBz.showZoomControls(false);
        this.dBz.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!aRZ()) {
            aRP();
        }
    }

    private void aRP() {
        this.dBD = new i(com.baidu.swan.apps.v.f.arY().arI(), this.dAH);
        this.dBD.gQ(true);
        this.dBD.a(this);
        gS(true);
    }

    private void aRW() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dBw, "translationY", 0.0f, -dBK, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.dBJ != null) {
            poiInfo.name = this.dBJ.mName;
            poiInfo.location = new LatLng(this.dBJ.mLatitude, this.dBJ.mLongitude);
            poiInfo.address = this.dBJ.mAddress;
            this.dBJ = null;
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
        this.dBC.clear();
        this.dBC.add(gVar);
        this.dBC.addAll(g.aw(reverseGeoCodeResult.getPoiList()));
        this.dBE.setData(this.dBC);
        this.dBB = gVar;
        if (this.dBC.size() > 0) {
            gS(false);
        }
    }

    private void gS(boolean z) {
        if (z) {
            this.dBC.clear();
            this.dBE.setData(this.dBC);
        }
        this.dBx.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        gS(true);
        f(latLng);
        aRX();
        if (z) {
            aRW();
            if (this.dBF.isFlipped()) {
                this.dBF.gW(false);
            }
        }
        if (z2) {
            this.dBp.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.dBD != null && this.dBD.aRt() != null) {
                BDLocation aRt = this.dBD.aRt();
                LatLng latLng = new LatLng(aRt.getLatitude(), aRt.getLongitude());
                this.dAH.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                aRX();
                if (this.dBH) {
                    a(latLng, true, true);
                    this.dBH = false;
                }
                gT(true);
            }
        } else if (view.getId() == R.id.finish) {
            lt(16);
            aRY();
        } else if (view.getId() == R.id.search) {
            b(this.dBB);
        } else if (view.getId() == R.id.cancel) {
            lt(17);
            aRY();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.dBZ != null && gVar.dBZ.location != null) {
            this.dBB = gVar;
            this.dAH.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.dBZ.location));
            aRX();
            if (this.dBA == null) {
                this.dBA = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.dCa) {
                this.dAI = (Marker) this.dAH.addOverlay(new MarkerOptions().position(gVar.dBZ.location).zIndex(88).icon(this.dBA));
            }
            if (!gVar.dCa) {
                gT(false);
            }
        }
    }

    private void aRX() {
        if (this.dAI != null) {
            this.dAI.remove();
            this.dAI = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.dBp.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.dBJ = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.dAH.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.dBH = true;
                            a(latLng, false, true);
                            gT(false);
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
        if (this.dBI != null) {
            switch (i) {
                case 16:
                    if (this.dBB != null) {
                        PoiInfo poiInfo = this.dBB.dBZ;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.dBI.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.dBI.onCancel();
                    return;
                case 18:
                    this.dBI.onError();
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
        this.dBI = null;
    }

    private void gT(boolean z) {
        if (this.dAQ != null) {
            this.dAQ.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.dBZ != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.dBZ.city);
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
        this.dBz.onResume();
        if (this.dBD != null) {
            this.dBD.gQ(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dBz.onPause();
        if (this.dBD != null) {
            this.dBD.gQ(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.dBz.onDestroy();
        }
        this.dBy.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        lt(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.dAH.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.dBG = i == 1;
        if (this.dBG || this.dBH) {
            z = true;
        }
        this.dBH = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.dBG) {
            a(mapStatus.target, true, true);
            gT(false);
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
