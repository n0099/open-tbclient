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
    private static final int bhZ = x.ad(20.0f);
    private BaiduMap bgW;
    private Marker bgX;
    private RecyclerView bhE;
    private FrameLayout bhF;
    private FrameLayout bhG;
    private FrameLayout bhH;
    private View bhI;
    private View bhJ;
    private TextView bhK;
    private ImageView bhL;
    private View bhM;
    private GeoCoder bhN;
    private TextureMapView bhO;
    private BitmapDescriptor bhP;
    private g bhQ;
    private List<g> bhR;
    private i bhS;
    private b bhT;
    private h bhU;
    private boolean bhV;
    private boolean bhW;
    private InterfaceC0207a bhX;
    private SelectedLocationInfo bhY;
    private ImageView bhf;

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
            uy.ea("navigateTo").A(com.baidu.swan.apps.core.c.e.aqO, com.baidu.swan.apps.core.c.e.aqQ).b(this).yZ();
        }
    }

    public void a(InterfaceC0207a interfaceC0207a) {
        this.bhX = interfaceC0207a;
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
        this.bhR = new ArrayList(11);
        this.bhE = (RecyclerView) view.findViewById(d.g.location_list);
        this.bhf = (ImageView) view.findViewById(d.g.float_btn);
        this.bhF = (FrameLayout) view.findViewById(d.g.float_container);
        this.bhI = view.findViewById(d.g.cancel);
        this.bhJ = view.findViewById(d.g.search);
        this.bhK = (TextView) view.findViewById(d.g.finish);
        this.bhL = (ImageView) view.findViewById(d.g.center_ding);
        this.bhG = (FrameLayout) view.findViewById(d.g.list_container);
        this.bhH = (FrameLayout) view.findViewById(d.g.map_container);
        this.bhM = view.findViewById(d.g.loading_progress);
        this.bhO = (TextureMapView) view.findViewById(d.g.bdMapView);
        this.bhf.setOnClickListener(this);
        this.bhK.setOnClickListener(this);
        this.bhJ.setOnClickListener(this);
        this.bhI.setOnClickListener(this);
        this.bhN = GeoCoder.newInstance();
        this.bgW = this.bhO.getMap();
        this.bhN.setOnGetGeoCodeResultListener(this);
        this.bgW.setOnMapLoadedCallback(this);
        this.bgW.setOnMapStatusChangeListener(this);
        this.bhE.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.w.e.Ea().DM()));
        this.bhT = new b(com.baidu.swan.apps.w.e.Ea().DM(), this.bhE, this, false);
        this.bhE.setAdapter(this.bhT);
        this.bhE.addItemDecoration(new f(com.baidu.swan.apps.w.e.Ea().DM(), true));
        this.bhU = new h(this.bhG, this.bhH, this.bhF);
        ((FlipperFrameLayout) this.bhG).setViewFlipper(this.bhU);
    }

    private void f(LatLng latLng) {
        this.bhN.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void Qp() {
        this.bgW.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.bgW.getUiSettings().setRotateGesturesEnabled(false);
        this.bhO.showZoomControls(false);
        this.bhO.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!Qt()) {
            Qk();
        }
    }

    private void Qk() {
        this.bhS = new i(com.baidu.swan.apps.w.e.Ea().DM(), this.bgW);
        this.bhS.cC(true);
        this.bhS.a(this);
        cE(true);
    }

    private void Qq() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bhL, "translationY", 0.0f, -bhZ, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.bhY != null) {
            poiInfo.name = this.bhY.mName;
            poiInfo.location = new LatLng(this.bhY.mLatitude, this.bhY.mLongitude);
            poiInfo.address = this.bhY.mAddress;
            this.bhY = null;
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
        this.bhR.clear();
        this.bhR.add(gVar);
        this.bhR.addAll(g.E(reverseGeoCodeResult.getPoiList()));
        this.bhT.setData(this.bhR);
        this.bhQ = gVar;
        if (this.bhR.size() > 0) {
            cE(false);
        }
    }

    private void cE(boolean z) {
        if (z) {
            this.bhR.clear();
            this.bhT.setData(this.bhR);
        }
        this.bhM.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        cE(true);
        f(latLng);
        Qr();
        if (z) {
            Qq();
            if (this.bhU.Qy()) {
                this.bhU.cJ(false);
            }
        }
        if (z2) {
            this.bhE.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.float_btn) {
            if (this.bhS != null && this.bhS.PR() != null) {
                BDLocation PR = this.bhS.PR();
                LatLng latLng = new LatLng(PR.getLatitude(), PR.getLongitude());
                this.bgW.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                Qr();
                if (this.bhW) {
                    a(latLng, true, true);
                    this.bhW = false;
                }
                cF(true);
            }
        } else if (view.getId() == d.g.finish) {
            eO(16);
            Qs();
        } else if (view.getId() == d.g.search) {
            b(this.bhQ);
        } else if (view.getId() == d.g.cancel) {
            eO(17);
            Qs();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.biq != null && gVar.biq.location != null) {
            this.bhQ = gVar;
            this.bgW.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.biq.location));
            Qr();
            if (this.bhP == null) {
                this.bhP = BitmapDescriptorFactory.fromResource(d.f.aiapps_location_selected);
            }
            if (!gVar.bir) {
                this.bgX = (Marker) this.bgW.addOverlay(new MarkerOptions().position(gVar.biq.location).zIndex(88).icon(this.bhP));
            }
            if (!gVar.bir) {
                cF(false);
            }
        }
    }

    private void Qr() {
        if (this.bgX != null) {
            this.bgX.remove();
            this.bgX = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.bhE.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.bhY = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.bgW.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.bhW = true;
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
        if (this.bhX != null) {
            switch (i) {
                case 16:
                    if (this.bhQ != null) {
                        PoiInfo poiInfo = this.bhQ.biq;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.bhX.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.bhX.onCancel();
                    return;
                case 18:
                    this.bhX.onError();
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
        this.bhX = null;
    }

    private void cF(boolean z) {
        if (this.bhf != null) {
            this.bhf.setImageResource(z ? d.f.aiapps_location_go_my_point_selected : d.f.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.biq != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.biq.city);
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
        this.bhO.onResume();
        if (this.bhS != null) {
            this.bhS.cC(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bhO.onPause();
        if (this.bhS != null) {
            this.bhS.cC(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.bhO.onDestroy();
        }
        this.bhN.destroy();
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vX() {
        eO(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.bgW.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.bhV = i == 1;
        if (this.bhV || this.bhW) {
            z = true;
        }
        this.bhW = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.bhV) {
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
