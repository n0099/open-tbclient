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
/* loaded from: classes24.dex */
public class a extends com.baidu.swan.apps.core.d.c implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int dDP = ah.H(20.0f);
    private BaiduMap dCM;
    private Marker dCN;
    private ImageView dCV;
    private TextView dDA;
    private ImageView dDB;
    private View dDC;
    private GeoCoder dDD;
    private TextureMapView dDE;
    private BitmapDescriptor dDF;
    private g dDG;
    private List<g> dDH;
    private i dDI;
    private b dDJ;
    private h dDK;
    private boolean dDL;
    private boolean dDM;
    private InterfaceC0510a dDN;
    private SelectedLocationInfo dDO;
    private RecyclerView dDu;
    private FrameLayout dDv;
    private FrameLayout dDw;
    private FrameLayout dDx;
    private View dDy;
    private View dDz;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC0510a {
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

    public void aSx() {
        com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG != null) {
            YG.lH("navigateTo").al(com.baidu.swan.apps.core.d.f.ckl, com.baidu.swan.apps.core.d.f.ckn).f(this).aih();
        }
    }

    public void a(InterfaceC0510a interfaceC0510a) {
        this.dDN = interfaceC0510a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aRZ();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        aSH();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.dDH = new ArrayList(11);
        this.dDu = (RecyclerView) view.findViewById(R.id.location_list);
        this.dCV = (ImageView) view.findViewById(R.id.float_btn);
        this.dDv = (FrameLayout) view.findViewById(R.id.float_container);
        this.dDy = view.findViewById(R.id.cancel);
        this.dDz = view.findViewById(R.id.search);
        this.dDA = (TextView) view.findViewById(R.id.finish);
        this.dDB = (ImageView) view.findViewById(R.id.center_ding);
        this.dDw = (FrameLayout) view.findViewById(R.id.list_container);
        this.dDx = (FrameLayout) view.findViewById(R.id.map_container);
        this.dDC = view.findViewById(R.id.loading_progress);
        this.dDE = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dCV.setOnClickListener(this);
        this.dDA.setOnClickListener(this);
        this.dDz.setOnClickListener(this);
        this.dDy.setOnClickListener(this);
        this.dDD = GeoCoder.newInstance();
        this.dCM = this.dDE.getMap();
        this.dDD.setOnGetGeoCodeResultListener(this);
        this.dCM.setOnMapLoadedCallback(this);
        this.dCM.setOnMapStatusChangeListener(this);
        this.dDu.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.asJ().ast()));
        this.dDJ = new b(com.baidu.swan.apps.v.f.asJ().ast(), this.dDu, this, false);
        this.dDu.setAdapter(this.dDJ);
        this.dDu.addItemDecoration(new f(com.baidu.swan.apps.v.f.asJ().ast(), true));
        this.dDK = new h(this.dDw, this.dDx, this.dDv);
        ((FlipperFrameLayout) this.dDw).setViewFlipper(this.dDK);
    }

    private void f(LatLng latLng) {
        this.dDD.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void aSH() {
        this.dCM.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.dCM.getUiSettings().setRotateGesturesEnabled(false);
        this.dDE.showZoomControls(false);
        this.dDE.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!aSL()) {
            aSB();
        }
    }

    private void aSB() {
        this.dDI = new i(com.baidu.swan.apps.v.f.asJ().ast(), this.dCM);
        this.dDI.gP(true);
        this.dDI.a(this);
        gR(true);
    }

    private void aSI() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dDB, "translationY", 0.0f, -dDP, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.dDO != null) {
            poiInfo.name = this.dDO.mName;
            poiInfo.location = new LatLng(this.dDO.mLatitude, this.dDO.mLongitude);
            poiInfo.address = this.dDO.mAddress;
            this.dDO = null;
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
        this.dDH.clear();
        this.dDH.add(gVar);
        this.dDH.addAll(g.aA(reverseGeoCodeResult.getPoiList()));
        this.dDJ.setData(this.dDH);
        this.dDG = gVar;
        if (this.dDH.size() > 0) {
            gR(false);
        }
    }

    private void gR(boolean z) {
        if (z) {
            this.dDH.clear();
            this.dDJ.setData(this.dDH);
        }
        this.dDC.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        gR(true);
        f(latLng);
        aSJ();
        if (z) {
            aSI();
            if (this.dDK.isFlipped()) {
                this.dDK.gV(false);
            }
        }
        if (z2) {
            this.dDu.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.dDI != null && this.dDI.aSf() != null) {
                BDLocation aSf = this.dDI.aSf();
                LatLng latLng = new LatLng(aSf.getLatitude(), aSf.getLongitude());
                this.dCM.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                aSJ();
                if (this.dDM) {
                    a(latLng, true, true);
                    this.dDM = false;
                }
                gS(true);
            }
        } else if (view.getId() == R.id.finish) {
            lE(16);
            aSK();
        } else if (view.getId() == R.id.search) {
            b(this.dDG);
        } else if (view.getId() == R.id.cancel) {
            lE(17);
            aSK();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.dEe != null && gVar.dEe.location != null) {
            this.dDG = gVar;
            this.dCM.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.dEe.location));
            aSJ();
            if (this.dDF == null) {
                this.dDF = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.dEf) {
                this.dCN = (Marker) this.dCM.addOverlay(new MarkerOptions().position(gVar.dEe.location).zIndex(88).icon(this.dDF));
            }
            if (!gVar.dEf) {
                gS(false);
            }
        }
    }

    private void aSJ() {
        if (this.dCN != null) {
            this.dCN.remove();
            this.dCN = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.dDu.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.dDO = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.dCM.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.dDM = true;
                            a(latLng, false, true);
                            gS(false);
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

    private void lE(int i) {
        if (this.dDN != null) {
            switch (i) {
                case 16:
                    if (this.dDG != null) {
                        PoiInfo poiInfo = this.dDG.dEe;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.dDN.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.dDN.onCancel();
                    return;
                case 18:
                    this.dDN.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void aSK() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.dDN = null;
    }

    private void gS(boolean z) {
        if (this.dCV != null) {
            this.dCV.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.dEe != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.dEe.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.aSx();
        }
    }

    private boolean aSL() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.v.f.asJ().ast().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.v.f.asJ().ast(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                aSB();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.dDE.onResume();
        if (this.dDI != null) {
            this.dDI.gP(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dDE.onPause();
        if (this.dDI != null) {
            this.dDI.gP(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.dDE.onDestroy();
        }
        this.dDD.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean abv() {
        lE(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.dCM.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.dDL = i == 1;
        if (this.dDL || this.dDM) {
            z = true;
        }
        this.dDM = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.dDL) {
            a(mapStatus.target, true, true);
            gS(false);
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
    public boolean agL() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void acc() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agK() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abW() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ak(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
