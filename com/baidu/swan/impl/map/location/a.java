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
    private static final int boe = z.ad(20.0f);
    private RecyclerView bnJ;
    private FrameLayout bnK;
    private FrameLayout bnL;
    private FrameLayout bnM;
    private View bnN;
    private View bnO;
    private TextView bnP;
    private ImageView bnQ;
    private View bnR;
    private GeoCoder bnS;
    private TextureMapView bnT;
    private BitmapDescriptor bnU;
    private g bnV;
    private List<g> bnW;
    private i bnX;
    private b bnY;
    private h bnZ;
    private BaiduMap bnb;
    private Marker bnc;
    private ImageView bnk;
    private boolean boa;
    private boolean bob;
    private InterfaceC0221a boc;
    private SelectedLocationInfo bod;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0221a {
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

    public void TS() {
        com.baidu.swan.apps.core.d.e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi != null) {
            vi.dN("navigateTo").y(com.baidu.swan.apps.core.d.e.aqT, com.baidu.swan.apps.core.d.e.aqV).c(this).zW();
        }
    }

    public void a(InterfaceC0221a interfaceC0221a) {
        this.boc = interfaceC0221a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.Tx();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        Ub();
        if (zc()) {
            inflate = Q(inflate);
            cd(-1);
        }
        return a(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.bnW = new ArrayList(11);
        this.bnJ = (RecyclerView) view.findViewById(R.id.location_list);
        this.bnk = (ImageView) view.findViewById(R.id.float_btn);
        this.bnK = (FrameLayout) view.findViewById(R.id.float_container);
        this.bnN = view.findViewById(R.id.cancel);
        this.bnO = view.findViewById(R.id.search);
        this.bnP = (TextView) view.findViewById(R.id.finish);
        this.bnQ = (ImageView) view.findViewById(R.id.center_ding);
        this.bnL = (FrameLayout) view.findViewById(R.id.list_container);
        this.bnM = (FrameLayout) view.findViewById(R.id.map_container);
        this.bnR = view.findViewById(R.id.loading_progress);
        this.bnT = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.bnk.setOnClickListener(this);
        this.bnP.setOnClickListener(this);
        this.bnO.setOnClickListener(this);
        this.bnN.setOnClickListener(this);
        this.bnS = GeoCoder.newInstance();
        this.bnb = this.bnT.getMap();
        this.bnS.setOnGetGeoCodeResultListener(this);
        this.bnb.setOnMapLoadedCallback(this);
        this.bnb.setOnMapStatusChangeListener(this);
        this.bnJ.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.w.e.FV().FH()));
        this.bnY = new b(com.baidu.swan.apps.w.e.FV().FH(), this.bnJ, this, false);
        this.bnJ.setAdapter(this.bnY);
        this.bnJ.addItemDecoration(new f(com.baidu.swan.apps.w.e.FV().FH(), true));
        this.bnZ = new h(this.bnL, this.bnM, this.bnK);
        ((FlipperFrameLayout) this.bnL).setViewFlipper(this.bnZ);
    }

    private void f(LatLng latLng) {
        this.bnS.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void Ub() {
        this.bnb.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.bnb.getUiSettings().setRotateGesturesEnabled(false);
        this.bnT.showZoomControls(false);
        this.bnT.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!Uf()) {
            TW();
        }
    }

    private void TW() {
        this.bnX = new i(com.baidu.swan.apps.w.e.FV().FH(), this.bnb);
        this.bnX.cT(true);
        this.bnX.a(this);
        cV(true);
    }

    private void Uc() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bnQ, "translationY", 0.0f, -boe, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.bod != null) {
            poiInfo.name = this.bod.mName;
            poiInfo.location = new LatLng(this.bod.mLatitude, this.bod.mLongitude);
            poiInfo.address = this.bod.mAddress;
            this.bod = null;
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
        this.bnW.clear();
        this.bnW.add(gVar);
        this.bnW.addAll(g.F(reverseGeoCodeResult.getPoiList()));
        this.bnY.setData(this.bnW);
        this.bnV = gVar;
        if (this.bnW.size() > 0) {
            cV(false);
        }
    }

    private void cV(boolean z) {
        if (z) {
            this.bnW.clear();
            this.bnY.setData(this.bnW);
        }
        this.bnR.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        cV(true);
        f(latLng);
        Ud();
        if (z) {
            Uc();
            if (this.bnZ.Uk()) {
                this.bnZ.da(false);
            }
        }
        if (z2) {
            this.bnJ.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.bnX != null && this.bnX.TD() != null) {
                BDLocation TD = this.bnX.TD();
                LatLng latLng = new LatLng(TD.getLatitude(), TD.getLongitude());
                this.bnb.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                Ud();
                if (this.bob) {
                    a(latLng, true, true);
                    this.bob = false;
                }
                cW(true);
            }
        } else if (view.getId() == R.id.finish) {
            fn(16);
            Ue();
        } else if (view.getId() == R.id.search) {
            b(this.bnV);
        } else if (view.getId() == R.id.cancel) {
            fn(17);
            Ue();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.bot != null && gVar.bot.location != null) {
            this.bnV = gVar;
            this.bnb.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.bot.location));
            Ud();
            if (this.bnU == null) {
                this.bnU = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.bou) {
                this.bnc = (Marker) this.bnb.addOverlay(new MarkerOptions().position(gVar.bot.location).zIndex(88).icon(this.bnU));
            }
            if (!gVar.bou) {
                cW(false);
            }
        }
    }

    private void Ud() {
        if (this.bnc != null) {
            this.bnc.remove();
            this.bnc = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.bnJ.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.bod = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.bnb.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.bob = true;
                            a(latLng, false, true);
                            cW(false);
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

    private void fn(int i) {
        if (this.boc != null) {
            switch (i) {
                case 16:
                    if (this.bnV != null) {
                        PoiInfo poiInfo = this.bnV.bot;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.boc.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.boc.onCancel();
                    return;
                case 18:
                    this.boc.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void Ue() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.boc = null;
    }

    private void cW(boolean z) {
        if (this.bnk != null) {
            this.bnk.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.bot != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.bot.city);
            com.baidu.swan.impl.map.location.search.a C = com.baidu.swan.impl.map.location.search.a.C(bundle);
            C.a(this, 1);
            C.TS();
        }
    }

    private boolean Uf() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.w.e.FV().FH().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.w.e.FV().FH(), R.string.aiapps_location_permission_fail).Ld();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                TW();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bnT.onResume();
        if (this.bnX != null) {
            this.bnX.cT(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bnT.onPause();
        if (this.bnX != null) {
            this.bnX.cT(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.bnT.onDestroy();
        }
        this.bnS.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean wO() {
        fn(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.bnb.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.boa = i == 1;
        if (this.boa || this.bob) {
            z = true;
        }
        this.bob = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.boa) {
            a(mapStatus.target, true, true);
            cW(false);
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
    public boolean yP() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yN() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yO() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void M(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
