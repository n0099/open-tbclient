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
import com.baidu.swan.apps.an.z;
import com.baidu.swan.impl.map.location.i;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.baidu.swan.apps.core.d.b implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int boR = z.ad(20.0f);
    private BaiduMap bnO;
    private Marker bnP;
    private ImageView bnX;
    private View boA;
    private View boB;
    private TextView boC;
    private ImageView boD;
    private View boE;
    private GeoCoder boF;
    private TextureMapView boG;
    private BitmapDescriptor boH;
    private g boI;
    private List<g> boJ;
    private i boK;
    private b boL;
    private h boM;
    private boolean boN;
    private boolean boO;
    private InterfaceC0223a boP;
    private SelectedLocationInfo boQ;
    private RecyclerView bow;
    private FrameLayout box;
    private FrameLayout boy;
    private FrameLayout boz;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0223a {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    public static a B(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void UK() {
        com.baidu.swan.apps.core.d.e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ != null) {
            vJ.dS("navigateTo").B(com.baidu.swan.apps.core.d.e.arw, com.baidu.swan.apps.core.d.e.ary).c(this).AD();
        }
    }

    public void a(InterfaceC0223a interfaceC0223a) {
        this.boP = interfaceC0223a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.Up();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        UT();
        if (zJ()) {
            inflate = S(inflate);
            cd(-1);
        }
        return a(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.boJ = new ArrayList(11);
        this.bow = (RecyclerView) view.findViewById(R.id.location_list);
        this.bnX = (ImageView) view.findViewById(R.id.float_btn);
        this.box = (FrameLayout) view.findViewById(R.id.float_container);
        this.boA = view.findViewById(R.id.cancel);
        this.boB = view.findViewById(R.id.search);
        this.boC = (TextView) view.findViewById(R.id.finish);
        this.boD = (ImageView) view.findViewById(R.id.center_ding);
        this.boy = (FrameLayout) view.findViewById(R.id.list_container);
        this.boz = (FrameLayout) view.findViewById(R.id.map_container);
        this.boE = view.findViewById(R.id.loading_progress);
        this.boG = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.bnX.setOnClickListener(this);
        this.boC.setOnClickListener(this);
        this.boB.setOnClickListener(this);
        this.boA.setOnClickListener(this);
        this.boF = GeoCoder.newInstance();
        this.bnO = this.boG.getMap();
        this.boF.setOnGetGeoCodeResultListener(this);
        this.bnO.setOnMapLoadedCallback(this);
        this.bnO.setOnMapStatusChangeListener(this);
        this.bow.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.w.e.GF().Gr()));
        this.boL = new b(com.baidu.swan.apps.w.e.GF().Gr(), this.bow, this, false);
        this.bow.setAdapter(this.boL);
        this.bow.addItemDecoration(new f(com.baidu.swan.apps.w.e.GF().Gr(), true));
        this.boM = new h(this.boy, this.boz, this.box);
        ((FlipperFrameLayout) this.boy).setViewFlipper(this.boM);
    }

    private void f(LatLng latLng) {
        this.boF.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void UT() {
        this.bnO.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.bnO.getUiSettings().setRotateGesturesEnabled(false);
        this.boG.showZoomControls(false);
        this.boG.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!UX()) {
            UO();
        }
    }

    private void UO() {
        this.boK = new i(com.baidu.swan.apps.w.e.GF().Gr(), this.bnO);
        this.boK.cW(true);
        this.boK.a(this);
        cY(true);
    }

    private void UU() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.boD, "translationY", 0.0f, -boR, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.boQ != null) {
            poiInfo.name = this.boQ.mName;
            poiInfo.location = new LatLng(this.boQ.mLatitude, this.boQ.mLongitude);
            poiInfo.address = this.boQ.mAddress;
            this.boQ = null;
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
        this.boJ.clear();
        this.boJ.add(gVar);
        this.boJ.addAll(g.F(reverseGeoCodeResult.getPoiList()));
        this.boL.setData(this.boJ);
        this.boI = gVar;
        if (this.boJ.size() > 0) {
            cY(false);
        }
    }

    private void cY(boolean z) {
        if (z) {
            this.boJ.clear();
            this.boL.setData(this.boJ);
        }
        this.boE.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        cY(true);
        f(latLng);
        UV();
        if (z) {
            UU();
            if (this.boM.Vc()) {
                this.boM.dd(false);
            }
        }
        if (z2) {
            this.bow.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.boK != null && this.boK.Uv() != null) {
                BDLocation Uv = this.boK.Uv();
                LatLng latLng = new LatLng(Uv.getLatitude(), Uv.getLongitude());
                this.bnO.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                UV();
                if (this.boO) {
                    a(latLng, true, true);
                    this.boO = false;
                }
                cZ(true);
            }
        } else if (view.getId() == R.id.finish) {
            fr(16);
            UW();
        } else if (view.getId() == R.id.search) {
            b(this.boI);
        } else if (view.getId() == R.id.cancel) {
            fr(17);
            UW();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.bpg != null && gVar.bpg.location != null) {
            this.boI = gVar;
            this.bnO.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.bpg.location));
            UV();
            if (this.boH == null) {
                this.boH = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.bph) {
                this.bnP = (Marker) this.bnO.addOverlay(new MarkerOptions().position(gVar.bpg.location).zIndex(88).icon(this.boH));
            }
            if (!gVar.bph) {
                cZ(false);
            }
        }
    }

    private void UV() {
        if (this.bnP != null) {
            this.bnP.remove();
            this.bnP = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.bow.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.boQ = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.bnO.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.boO = true;
                            a(latLng, false, true);
                            cZ(false);
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

    private void fr(int i) {
        if (this.boP != null) {
            switch (i) {
                case 16:
                    if (this.boI != null) {
                        PoiInfo poiInfo = this.boI.bpg;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.boP.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.boP.onCancel();
                    return;
                case 18:
                    this.boP.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void UW() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.boP = null;
    }

    private void cZ(boolean z) {
        if (this.bnX != null) {
            this.bnX.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.bpg != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.bpg.city);
            com.baidu.swan.impl.map.location.search.a C = com.baidu.swan.impl.map.location.search.a.C(bundle);
            C.a(this, 1);
            C.UK();
        }
    }

    private boolean UX() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.w.e.GF().Gr().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.w.e.GF().Gr(), R.string.aiapps_location_permission_fail).LQ();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                UO();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.boG.onResume();
        if (this.boK != null) {
            this.boK.cW(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.boG.onPause();
        if (this.boK != null) {
            this.boK.cW(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.boG.onDestroy();
        }
        this.boF.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xp() {
        fr(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.bnO.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.boN = i == 1;
        if (this.boN || this.boO) {
            z = true;
        }
        this.boO = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.boN) {
            a(mapStatus.target, true, true);
            cZ(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean zw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zu() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zv() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xD() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void O(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
