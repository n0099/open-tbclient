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
    private static final int bhV = x.ad(20.0f);
    private BaiduMap bgS;
    private Marker bgT;
    private RecyclerView bhA;
    private FrameLayout bhB;
    private FrameLayout bhC;
    private FrameLayout bhD;
    private View bhE;
    private View bhF;
    private TextView bhG;
    private ImageView bhH;
    private View bhI;
    private GeoCoder bhJ;
    private TextureMapView bhK;
    private BitmapDescriptor bhL;
    private g bhM;
    private List<g> bhN;
    private i bhO;
    private b bhP;
    private h bhQ;
    private boolean bhR;
    private boolean bhS;
    private InterfaceC0207a bhT;
    private SelectedLocationInfo bhU;
    private ImageView bhb;

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

    public void Qi() {
        com.baidu.swan.apps.core.c.e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz != null) {
            uz.dY("navigateTo").A(com.baidu.swan.apps.core.c.e.aqJ, com.baidu.swan.apps.core.c.e.aqL).b(this).za();
        }
    }

    public void a(InterfaceC0207a interfaceC0207a) {
        this.bhT = interfaceC0207a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.PN();
        View inflate = layoutInflater.inflate(d.h.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        Qr();
        if (yj()) {
            inflate = Q(inflate);
            ce(-1);
        }
        return a(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.bhN = new ArrayList(11);
        this.bhA = (RecyclerView) view.findViewById(d.g.location_list);
        this.bhb = (ImageView) view.findViewById(d.g.float_btn);
        this.bhB = (FrameLayout) view.findViewById(d.g.float_container);
        this.bhE = view.findViewById(d.g.cancel);
        this.bhF = view.findViewById(d.g.search);
        this.bhG = (TextView) view.findViewById(d.g.finish);
        this.bhH = (ImageView) view.findViewById(d.g.center_ding);
        this.bhC = (FrameLayout) view.findViewById(d.g.list_container);
        this.bhD = (FrameLayout) view.findViewById(d.g.map_container);
        this.bhI = view.findViewById(d.g.loading_progress);
        this.bhK = (TextureMapView) view.findViewById(d.g.bdMapView);
        this.bhb.setOnClickListener(this);
        this.bhG.setOnClickListener(this);
        this.bhF.setOnClickListener(this);
        this.bhE.setOnClickListener(this);
        this.bhJ = GeoCoder.newInstance();
        this.bgS = this.bhK.getMap();
        this.bhJ.setOnGetGeoCodeResultListener(this);
        this.bgS.setOnMapLoadedCallback(this);
        this.bgS.setOnMapStatusChangeListener(this);
        this.bhA.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.w.e.Ec().DO()));
        this.bhP = new b(com.baidu.swan.apps.w.e.Ec().DO(), this.bhA, this, false);
        this.bhA.setAdapter(this.bhP);
        this.bhA.addItemDecoration(new f(com.baidu.swan.apps.w.e.Ec().DO(), true));
        this.bhQ = new h(this.bhC, this.bhD, this.bhB);
        ((FlipperFrameLayout) this.bhC).setViewFlipper(this.bhQ);
    }

    private void f(LatLng latLng) {
        this.bhJ.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void Qr() {
        this.bgS.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.bgS.getUiSettings().setRotateGesturesEnabled(false);
        this.bhK.showZoomControls(false);
        this.bhK.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!Qv()) {
            Qm();
        }
    }

    private void Qm() {
        this.bhO = new i(com.baidu.swan.apps.w.e.Ec().DO(), this.bgS);
        this.bhO.cC(true);
        this.bhO.a(this);
        cE(true);
    }

    private void Qs() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bhH, "translationY", 0.0f, -bhV, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.bhU != null) {
            poiInfo.name = this.bhU.mName;
            poiInfo.location = new LatLng(this.bhU.mLatitude, this.bhU.mLongitude);
            poiInfo.address = this.bhU.mAddress;
            this.bhU = null;
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
        this.bhN.clear();
        this.bhN.add(gVar);
        this.bhN.addAll(g.E(reverseGeoCodeResult.getPoiList()));
        this.bhP.setData(this.bhN);
        this.bhM = gVar;
        if (this.bhN.size() > 0) {
            cE(false);
        }
    }

    private void cE(boolean z) {
        if (z) {
            this.bhN.clear();
            this.bhP.setData(this.bhN);
        }
        this.bhI.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        cE(true);
        f(latLng);
        Qt();
        if (z) {
            Qs();
            if (this.bhQ.QA()) {
                this.bhQ.cJ(false);
            }
        }
        if (z2) {
            this.bhA.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.float_btn) {
            if (this.bhO != null && this.bhO.PT() != null) {
                BDLocation PT = this.bhO.PT();
                LatLng latLng = new LatLng(PT.getLatitude(), PT.getLongitude());
                this.bgS.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                Qt();
                if (this.bhS) {
                    a(latLng, true, true);
                    this.bhS = false;
                }
                cF(true);
            }
        } else if (view.getId() == d.g.finish) {
            eP(16);
            Qu();
        } else if (view.getId() == d.g.search) {
            b(this.bhM);
        } else if (view.getId() == d.g.cancel) {
            eP(17);
            Qu();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.bim != null && gVar.bim.location != null) {
            this.bhM = gVar;
            this.bgS.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.bim.location));
            Qt();
            if (this.bhL == null) {
                this.bhL = BitmapDescriptorFactory.fromResource(d.f.aiapps_location_selected);
            }
            if (!gVar.bin) {
                this.bgT = (Marker) this.bgS.addOverlay(new MarkerOptions().position(gVar.bim.location).zIndex(88).icon(this.bhL));
            }
            if (!gVar.bin) {
                cF(false);
            }
        }
    }

    private void Qt() {
        if (this.bgT != null) {
            this.bgT.remove();
            this.bgT = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.bhA.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.bhU = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.bgS.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.bhS = true;
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

    private void eP(int i) {
        if (this.bhT != null) {
            switch (i) {
                case 16:
                    if (this.bhM != null) {
                        PoiInfo poiInfo = this.bhM.bim;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.bhT.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.bhT.onCancel();
                    return;
                case 18:
                    this.bhT.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void Qu() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.bhT = null;
    }

    private void cF(boolean z) {
        if (this.bhb != null) {
            this.bhb.setImageResource(z ? d.f.aiapps_location_go_my_point_selected : d.f.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.bim != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.bim.city);
            com.baidu.swan.impl.map.location.search.a B = com.baidu.swan.impl.map.location.search.a.B(bundle);
            B.a(this, 1);
            B.Qi();
        }
    }

    private boolean Qv() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.w.e.Ec().DO().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.l(com.baidu.swan.apps.w.e.Ec().DO(), d.j.aiapps_location_permission_fail).IK();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                Qm();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bhK.onResume();
        if (this.bhO != null) {
            this.bhO.cC(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bhK.onPause();
        if (this.bhO != null) {
            this.bhO.cC(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.bhK.onDestroy();
        }
        this.bhJ.destroy();
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vY() {
        eP(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.bgS.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.bhR = i == 1;
        if (this.bhR || this.bhS) {
            z = true;
        }
        this.bhS = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.bhR) {
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
    public boolean xY() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xX() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
