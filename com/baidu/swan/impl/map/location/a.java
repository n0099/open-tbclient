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
/* loaded from: classes25.dex */
public class a extends com.baidu.swan.apps.core.d.c implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int eee = ah.N(20.0f);
    private RecyclerView edJ;
    private FrameLayout edK;
    private FrameLayout edL;
    private FrameLayout edM;
    private View edN;
    private View edO;
    private TextView edP;
    private ImageView edQ;
    private View edR;
    private GeoCoder edS;
    private TextureMapView edT;
    private BitmapDescriptor edU;
    private g edV;
    private List<g> edW;
    private i edX;
    private b edY;
    private h edZ;
    private BaiduMap edb;
    private Marker edc;
    private ImageView edk;
    private boolean eea;
    private boolean eeb;
    private InterfaceC0553a eec;
    private SelectedLocationInfo eed;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0553a {
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

    public void aZA() {
        com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM != null) {
            afM.nb("navigateTo").al(com.baidu.swan.apps.core.d.f.cKS, com.baidu.swan.apps.core.d.f.cKU).f(this).apn();
        }
    }

    public void a(InterfaceC0553a interfaceC0553a) {
        this.eec = interfaceC0553a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aZc();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        aZK();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.edW = new ArrayList(11);
        this.edJ = (RecyclerView) view.findViewById(R.id.location_list);
        this.edk = (ImageView) view.findViewById(R.id.float_btn);
        this.edK = (FrameLayout) view.findViewById(R.id.float_container);
        this.edN = view.findViewById(R.id.cancel);
        this.edO = view.findViewById(R.id.search);
        this.edP = (TextView) view.findViewById(R.id.finish);
        this.edQ = (ImageView) view.findViewById(R.id.center_ding);
        this.edL = (FrameLayout) view.findViewById(R.id.list_container);
        this.edM = (FrameLayout) view.findViewById(R.id.map_container);
        this.edR = view.findViewById(R.id.loading_progress);
        this.edT = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.edk.setOnClickListener(this);
        this.edP.setOnClickListener(this);
        this.edO.setOnClickListener(this);
        this.edN.setOnClickListener(this);
        this.edS = GeoCoder.newInstance();
        this.edb = this.edT.getMap();
        this.edS.setOnGetGeoCodeResultListener(this);
        this.edb.setOnMapLoadedCallback(this);
        this.edb.setOnMapStatusChangeListener(this);
        this.edJ.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.azO().azy()));
        this.edY = new b(com.baidu.swan.apps.v.f.azO().azy(), this.edJ, this, false);
        this.edJ.setAdapter(this.edY);
        this.edJ.addItemDecoration(new f(com.baidu.swan.apps.v.f.azO().azy(), true));
        this.edZ = new h(this.edL, this.edM, this.edK);
        ((FlipperFrameLayout) this.edL).setViewFlipper(this.edZ);
    }

    private void f(LatLng latLng) {
        this.edS.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void aZK() {
        this.edb.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.edb.getUiSettings().setRotateGesturesEnabled(false);
        this.edT.showZoomControls(false);
        this.edT.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!aZO()) {
            aZE();
        }
    }

    private void aZE() {
        this.edX = new i(com.baidu.swan.apps.v.f.azO().azy(), this.edb);
        this.edX.hH(true);
        this.edX.a(this);
        hJ(true);
    }

    private void aZL() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.edQ, "translationY", 0.0f, -eee, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.eed != null) {
            poiInfo.name = this.eed.mName;
            poiInfo.location = new LatLng(this.eed.mLatitude, this.eed.mLongitude);
            poiInfo.address = this.eed.mAddress;
            this.eed = null;
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
        this.edW.clear();
        this.edW.add(gVar);
        this.edW.addAll(g.aU(reverseGeoCodeResult.getPoiList()));
        this.edY.setData(this.edW);
        this.edV = gVar;
        if (this.edW.size() > 0) {
            hJ(false);
        }
    }

    private void hJ(boolean z) {
        if (z) {
            this.edW.clear();
            this.edY.setData(this.edW);
        }
        this.edR.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        hJ(true);
        f(latLng);
        aZM();
        if (z) {
            aZL();
            if (this.edZ.isFlipped()) {
                this.edZ.hN(false);
            }
        }
        if (z2) {
            this.edJ.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.edX != null && this.edX.aZi() != null) {
                BDLocation aZi = this.edX.aZi();
                LatLng latLng = new LatLng(aZi.getLatitude(), aZi.getLongitude());
                this.edb.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                aZM();
                if (this.eeb) {
                    a(latLng, true, true);
                    this.eeb = false;
                }
                hK(true);
            }
        } else if (view.getId() == R.id.finish) {
            mw(16);
            aZN();
        } else if (view.getId() == R.id.search) {
            b(this.edV);
        } else if (view.getId() == R.id.cancel) {
            mw(17);
            aZN();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.eet != null && gVar.eet.location != null) {
            this.edV = gVar;
            this.edb.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.eet.location));
            aZM();
            if (this.edU == null) {
                this.edU = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.eeu) {
                this.edc = (Marker) this.edb.addOverlay(new MarkerOptions().position(gVar.eet.location).zIndex(88).icon(this.edU));
            }
            if (!gVar.eeu) {
                hK(false);
            }
        }
    }

    private void aZM() {
        if (this.edc != null) {
            this.edc.remove();
            this.edc = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.edJ.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.eed = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.edb.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.eeb = true;
                            a(latLng, false, true);
                            hK(false);
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

    private void mw(int i) {
        if (this.eec != null) {
            switch (i) {
                case 16:
                    if (this.edV != null) {
                        PoiInfo poiInfo = this.edV.eet;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.eec.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.eec.onCancel();
                    return;
                case 18:
                    this.eec.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void aZN() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.eec = null;
    }

    private void hK(boolean z) {
        if (this.edk != null) {
            this.edk.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.eet != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.eet.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.aZA();
        }
    }

    private boolean aZO() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.v.f.azO().azy().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.v.f.azO().azy(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                aZE();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.edT.onResume();
        if (this.edX != null) {
            this.edX.hH(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.edT.onPause();
        if (this.edX != null) {
            this.edX.hH(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.edT.onDestroy();
        }
        this.edS.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiB() {
        mw(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.edb.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.eea = i == 1;
        if (this.eea || this.eeb) {
            z = true;
        }
        this.eeb = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.eea) {
            a(mapStatus.target, true, true);
            hK(false);
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
    public boolean anQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aji() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anP() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajc() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ar(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
