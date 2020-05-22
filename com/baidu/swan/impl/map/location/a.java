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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.impl.map.location.i;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class a extends com.baidu.swan.apps.core.d.b implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int dhc = ag.B(20.0f);
    private BaiduMap dfZ;
    private RecyclerView dgH;
    private FrameLayout dgI;
    private FrameLayout dgJ;
    private FrameLayout dgK;
    private View dgL;
    private View dgM;
    private TextView dgN;
    private ImageView dgO;
    private View dgP;
    private GeoCoder dgQ;
    private TextureMapView dgR;
    private BitmapDescriptor dgS;
    private g dgT;
    private List<g> dgU;
    private i dgV;
    private b dgW;
    private h dgX;
    private boolean dgY;
    private boolean dgZ;
    private Marker dga;
    private ImageView dgi;
    private InterfaceC0449a dha;
    private SelectedLocationInfo dhb;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0449a {
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

    public void aDY() {
        com.baidu.swan.apps.core.d.e QH = com.baidu.swan.apps.w.f.ahV().QH();
        if (QH != null) {
            QH.jp("navigateTo").ae(com.baidu.swan.apps.core.d.e.bVN, com.baidu.swan.apps.core.d.e.bVP).f(this).Zb();
        }
    }

    public void a(InterfaceC0449a interfaceC0449a) {
        this.dha = interfaceC0449a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aDA();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        aEi();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.dgU = new ArrayList(11);
        this.dgH = (RecyclerView) view.findViewById(R.id.location_list);
        this.dgi = (ImageView) view.findViewById(R.id.float_btn);
        this.dgI = (FrameLayout) view.findViewById(R.id.float_container);
        this.dgL = view.findViewById(R.id.cancel);
        this.dgM = view.findViewById(R.id.search);
        this.dgN = (TextView) view.findViewById(R.id.finish);
        this.dgO = (ImageView) view.findViewById(R.id.center_ding);
        this.dgJ = (FrameLayout) view.findViewById(R.id.list_container);
        this.dgK = (FrameLayout) view.findViewById(R.id.map_container);
        this.dgP = view.findViewById(R.id.loading_progress);
        this.dgR = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dgi.setOnClickListener(this);
        this.dgN.setOnClickListener(this);
        this.dgM.setOnClickListener(this);
        this.dgL.setOnClickListener(this);
        this.dgQ = GeoCoder.newInstance();
        this.dfZ = this.dgR.getMap();
        this.dgQ.setOnGetGeoCodeResultListener(this);
        this.dfZ.setOnMapLoadedCallback(this);
        this.dfZ.setOnMapStatusChangeListener(this);
        this.dgH.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.w.f.ahV().ahF()));
        this.dgW = new b(com.baidu.swan.apps.w.f.ahV().ahF(), this.dgH, this, false);
        this.dgH.setAdapter(this.dgW);
        this.dgH.addItemDecoration(new f(com.baidu.swan.apps.w.f.ahV().ahF(), true));
        this.dgX = new h(this.dgJ, this.dgK, this.dgI);
        ((FlipperFrameLayout) this.dgJ).setViewFlipper(this.dgX);
    }

    private void f(LatLng latLng) {
        this.dgQ.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void aEi() {
        this.dfZ.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.dfZ.getUiSettings().setRotateGesturesEnabled(false);
        this.dgR.showZoomControls(false);
        this.dgR.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!aEm()) {
            aEc();
        }
    }

    private void aEc() {
        this.dgV = new i(com.baidu.swan.apps.w.f.ahV().ahF(), this.dfZ);
        this.dgV.fT(true);
        this.dgV.a(this);
        fV(true);
    }

    private void aEj() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dgO, "translationY", 0.0f, -dhc, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.dhb != null) {
            poiInfo.name = this.dhb.mName;
            poiInfo.location = new LatLng(this.dhb.mLatitude, this.dhb.mLongitude);
            poiInfo.address = this.dhb.mAddress;
            this.dhb = null;
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
        this.dgU.clear();
        this.dgU.add(gVar);
        this.dgU.addAll(g.an(reverseGeoCodeResult.getPoiList()));
        this.dgW.setData(this.dgU);
        this.dgT = gVar;
        if (this.dgU.size() > 0) {
            fV(false);
        }
    }

    private void fV(boolean z) {
        if (z) {
            this.dgU.clear();
            this.dgW.setData(this.dgU);
        }
        this.dgP.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        fV(true);
        f(latLng);
        aEk();
        if (z) {
            aEj();
            if (this.dgX.isFlipped()) {
                this.dgX.fZ(false);
            }
        }
        if (z2) {
            this.dgH.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.dgV != null && this.dgV.aDG() != null) {
                BDLocation aDG = this.dgV.aDG();
                LatLng latLng = new LatLng(aDG.getLatitude(), aDG.getLongitude());
                this.dfZ.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                aEk();
                if (this.dgZ) {
                    a(latLng, true, true);
                    this.dgZ = false;
                }
                fW(true);
            }
        } else if (view.getId() == R.id.finish) {
            iG(16);
            aEl();
        } else if (view.getId() == R.id.search) {
            b(this.dgT);
        } else if (view.getId() == R.id.cancel) {
            iG(17);
            aEl();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.dhr != null && gVar.dhr.location != null) {
            this.dgT = gVar;
            this.dfZ.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.dhr.location));
            aEk();
            if (this.dgS == null) {
                this.dgS = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.dhs) {
                this.dga = (Marker) this.dfZ.addOverlay(new MarkerOptions().position(gVar.dhr.location).zIndex(88).icon(this.dgS));
            }
            if (!gVar.dhs) {
                fW(false);
            }
        }
    }

    private void aEk() {
        if (this.dga != null) {
            this.dga.remove();
            this.dga = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.dgH.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.dhb = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.dfZ.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.dgZ = true;
                            a(latLng, false, true);
                            fW(false);
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

    private void iG(int i) {
        if (this.dha != null) {
            switch (i) {
                case 16:
                    if (this.dgT != null) {
                        PoiInfo poiInfo = this.dgT.dhr;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.dha.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.dha.onCancel();
                    return;
                case 18:
                    this.dha.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void aEl() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.dha = null;
    }

    private void fW(boolean z) {
        if (this.dgi != null) {
            this.dgi.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.dhr != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.dhr.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.aDY();
        }
    }

    private boolean aEm() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.w.f.ahV().ahF().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.w.f.ahV().ahF(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                aEc();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.dgR.onResume();
        if (this.dgV != null) {
            this.dgV.fT(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dgR.onPause();
        if (this.dgV != null) {
            this.dgV.fT(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.dgR.onDestroy();
        }
        this.dgQ.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Tc() {
        iG(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.dfZ.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.dgY = i == 1;
        if (this.dgY || this.dgZ) {
            z = true;
        }
        this.dgZ = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.dgY) {
            a(mapStatus.target, true, true);
            fW(false);
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
    public boolean XQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void TC() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void XP() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ty() {
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
