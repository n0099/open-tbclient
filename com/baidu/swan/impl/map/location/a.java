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
import com.baidu.swan.apps.an.x;
import com.baidu.swan.impl.map.location.i;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.baidu.swan.apps.core.c.b implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int bhY = x.ad(20.0f);
    private BaiduMap bgV;
    private Marker bgW;
    private RecyclerView bhD;
    private FrameLayout bhE;
    private FrameLayout bhF;
    private FrameLayout bhG;
    private View bhH;
    private View bhI;
    private TextView bhJ;
    private ImageView bhK;
    private View bhL;
    private GeoCoder bhM;
    private TextureMapView bhN;
    private BitmapDescriptor bhO;
    private g bhP;
    private List<g> bhQ;
    private i bhR;
    private b bhS;
    private h bhT;
    private boolean bhU;
    private boolean bhV;
    private InterfaceC0207a bhW;
    private SelectedLocationInfo bhX;
    private ImageView bhe;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0207a {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    public static a A(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void Qg() {
        com.baidu.swan.apps.core.c.e uy = com.baidu.swan.apps.w.e.Ea().uy();
        if (uy != null) {
            uy.ea("navigateTo").A(com.baidu.swan.apps.core.c.e.aqN, com.baidu.swan.apps.core.c.e.aqP).b(this).yZ();
        }
    }

    public void a(InterfaceC0207a interfaceC0207a) {
        this.bhW = interfaceC0207a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.PL();
        View inflate = layoutInflater.inflate(d.h.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        Qp();
        if (yi()) {
            inflate = Q(inflate);
            cd(-1);
        }
        return a(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.bhQ = new ArrayList(11);
        this.bhD = (RecyclerView) view.findViewById(d.g.location_list);
        this.bhe = (ImageView) view.findViewById(d.g.float_btn);
        this.bhE = (FrameLayout) view.findViewById(d.g.float_container);
        this.bhH = view.findViewById(d.g.cancel);
        this.bhI = view.findViewById(d.g.search);
        this.bhJ = (TextView) view.findViewById(d.g.finish);
        this.bhK = (ImageView) view.findViewById(d.g.center_ding);
        this.bhF = (FrameLayout) view.findViewById(d.g.list_container);
        this.bhG = (FrameLayout) view.findViewById(d.g.map_container);
        this.bhL = view.findViewById(d.g.loading_progress);
        this.bhN = (TextureMapView) view.findViewById(d.g.bdMapView);
        this.bhe.setOnClickListener(this);
        this.bhJ.setOnClickListener(this);
        this.bhI.setOnClickListener(this);
        this.bhH.setOnClickListener(this);
        this.bhM = GeoCoder.newInstance();
        this.bgV = this.bhN.getMap();
        this.bhM.setOnGetGeoCodeResultListener(this);
        this.bgV.setOnMapLoadedCallback(this);
        this.bgV.setOnMapStatusChangeListener(this);
        this.bhD.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.w.e.Ea().DM()));
        this.bhS = new b(com.baidu.swan.apps.w.e.Ea().DM(), this.bhD, this, false);
        this.bhD.setAdapter(this.bhS);
        this.bhD.addItemDecoration(new f(com.baidu.swan.apps.w.e.Ea().DM(), true));
        this.bhT = new h(this.bhF, this.bhG, this.bhE);
        ((FlipperFrameLayout) this.bhF).setViewFlipper(this.bhT);
    }

    private void f(LatLng latLng) {
        this.bhM.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void Qp() {
        this.bgV.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.bgV.getUiSettings().setRotateGesturesEnabled(false);
        this.bhN.showZoomControls(false);
        this.bhN.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!Qt()) {
            Qk();
        }
    }

    private void Qk() {
        this.bhR = new i(com.baidu.swan.apps.w.e.Ea().DM(), this.bgV);
        this.bhR.cC(true);
        this.bhR.a(this);
        cE(true);
    }

    private void Qq() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bhK, "translationY", 0.0f, -bhY, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.bhX != null) {
            poiInfo.name = this.bhX.mName;
            poiInfo.location = new LatLng(this.bhX.mLatitude, this.bhX.mLongitude);
            poiInfo.address = this.bhX.mAddress;
            this.bhX = null;
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
        this.bhQ.clear();
        this.bhQ.add(gVar);
        this.bhQ.addAll(g.E(reverseGeoCodeResult.getPoiList()));
        this.bhS.setData(this.bhQ);
        this.bhP = gVar;
        if (this.bhQ.size() > 0) {
            cE(false);
        }
    }

    private void cE(boolean z) {
        if (z) {
            this.bhQ.clear();
            this.bhS.setData(this.bhQ);
        }
        this.bhL.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        cE(true);
        f(latLng);
        Qr();
        if (z) {
            Qq();
            if (this.bhT.Qy()) {
                this.bhT.cJ(false);
            }
        }
        if (z2) {
            this.bhD.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.float_btn) {
            if (this.bhR != null && this.bhR.PR() != null) {
                BDLocation PR = this.bhR.PR();
                LatLng latLng = new LatLng(PR.getLatitude(), PR.getLongitude());
                this.bgV.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                Qr();
                if (this.bhV) {
                    a(latLng, true, true);
                    this.bhV = false;
                }
                cF(true);
            }
        } else if (view.getId() == d.g.finish) {
            eO(16);
            Qs();
        } else if (view.getId() == d.g.search) {
            b(this.bhP);
        } else if (view.getId() == d.g.cancel) {
            eO(17);
            Qs();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.bip != null && gVar.bip.location != null) {
            this.bhP = gVar;
            this.bgV.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.bip.location));
            Qr();
            if (this.bhO == null) {
                this.bhO = BitmapDescriptorFactory.fromResource(d.f.aiapps_location_selected);
            }
            if (!gVar.biq) {
                this.bgW = (Marker) this.bgV.addOverlay(new MarkerOptions().position(gVar.bip.location).zIndex(88).icon(this.bhO));
            }
            if (!gVar.biq) {
                cF(false);
            }
        }
    }

    private void Qr() {
        if (this.bgW != null) {
            this.bgW.remove();
            this.bgW = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.bhD.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.bhX = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.bgV.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.bhV = true;
                            a(latLng, false, true);
                            cF(false);
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

    private void eO(int i) {
        if (this.bhW != null) {
            switch (i) {
                case 16:
                    if (this.bhP != null) {
                        PoiInfo poiInfo = this.bhP.bip;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.bhW.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.bhW.onCancel();
                    return;
                case 18:
                    this.bhW.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void Qs() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.bhW = null;
    }

    private void cF(boolean z) {
        if (this.bhe != null) {
            this.bhe.setImageResource(z ? d.f.aiapps_location_go_my_point_selected : d.f.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.bip != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.bip.city);
            com.baidu.swan.impl.map.location.search.a B = com.baidu.swan.impl.map.location.search.a.B(bundle);
            B.a(this, 1);
            B.Qg();
        }
    }

    private boolean Qt() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.w.e.Ea().DM().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.l(com.baidu.swan.apps.w.e.Ea().DM(), d.j.aiapps_location_permission_fail).II();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                Qk();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bhN.onResume();
        if (this.bhR != null) {
            this.bhR.cC(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bhN.onPause();
        if (this.bhR != null) {
            this.bhR.cC(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.bhN.onDestroy();
        }
        this.bhM.destroy();
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vX() {
        eO(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.bgV.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.bhU = i == 1;
        if (this.bhU || this.bhV) {
            z = true;
        }
        this.bhV = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.bhU) {
            a(mapStatus.target, true, true);
            cF(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xV() {
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
