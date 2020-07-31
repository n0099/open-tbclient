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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.impl.map.location.i;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes19.dex */
public class a extends com.baidu.swan.apps.core.d.c implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int drJ = ai.D(20.0f);
    private BaiduMap dqF;
    private Marker dqG;
    private ImageView dqO;
    private g drA;
    private List<g> drB;
    private i drC;
    private b drD;
    private h drE;
    private boolean drF;
    private boolean drG;
    private InterfaceC0467a drH;
    private SelectedLocationInfo drI;
    private RecyclerView drn;
    private FrameLayout dro;
    private FrameLayout drp;
    private FrameLayout drq;
    private View drr;
    private View drt;
    private TextView dru;
    private ImageView drv;
    private View drw;
    private GeoCoder drx;
    private TextureMapView dry;
    private BitmapDescriptor drz;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC0467a {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aIV() {
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null) {
            Sc.jO("navigateTo").ag(com.baidu.swan.apps.core.d.f.cci, com.baidu.swan.apps.core.d.f.cck).f(this).abl();
        }
    }

    public void a(InterfaceC0467a interfaceC0467a) {
        this.drH = interfaceC0467a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aIx();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        aJf();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.drB = new ArrayList(11);
        this.drn = (RecyclerView) view.findViewById(R.id.location_list);
        this.dqO = (ImageView) view.findViewById(R.id.float_btn);
        this.dro = (FrameLayout) view.findViewById(R.id.float_container);
        this.drr = view.findViewById(R.id.cancel);
        this.drt = view.findViewById(R.id.search);
        this.dru = (TextView) view.findViewById(R.id.finish);
        this.drv = (ImageView) view.findViewById(R.id.center_ding);
        this.drp = (FrameLayout) view.findViewById(R.id.list_container);
        this.drq = (FrameLayout) view.findViewById(R.id.map_container);
        this.drw = view.findViewById(R.id.loading_progress);
        this.dry = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dqO.setOnClickListener(this);
        this.dru.setOnClickListener(this);
        this.drt.setOnClickListener(this);
        this.drr.setOnClickListener(this);
        this.drx = GeoCoder.newInstance();
        this.dqF = this.dry.getMap();
        this.drx.setOnGetGeoCodeResultListener(this);
        this.dqF.setOnMapLoadedCallback(this);
        this.dqF.setOnMapStatusChangeListener(this);
        this.drn.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.akr().akb()));
        this.drD = new b(com.baidu.swan.apps.v.f.akr().akb(), this.drn, this, false);
        this.drn.setAdapter(this.drD);
        this.drn.addItemDecoration(new f(com.baidu.swan.apps.v.f.akr().akb(), true));
        this.drE = new h(this.drp, this.drq, this.dro);
        ((FlipperFrameLayout) this.drp).setViewFlipper(this.drE);
    }

    private void f(LatLng latLng) {
        this.drx.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void aJf() {
        this.dqF.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.dqF.getUiSettings().setRotateGesturesEnabled(false);
        this.dry.showZoomControls(false);
        this.dry.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!aJj()) {
            aIZ();
        }
    }

    private void aIZ() {
        this.drC = new i(com.baidu.swan.apps.v.f.akr().akb(), this.dqF);
        this.drC.gu(true);
        this.drC.a(this);
        gw(true);
    }

    private void aJg() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.drv, "translationY", 0.0f, -drJ, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.drI != null) {
            poiInfo.name = this.drI.mName;
            poiInfo.location = new LatLng(this.drI.mLatitude, this.drI.mLongitude);
            poiInfo.address = this.drI.mAddress;
            this.drI = null;
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
        this.drB.clear();
        this.drB.add(gVar);
        this.drB.addAll(g.av(reverseGeoCodeResult.getPoiList()));
        this.drD.setData(this.drB);
        this.drA = gVar;
        if (this.drB.size() > 0) {
            gw(false);
        }
    }

    private void gw(boolean z) {
        if (z) {
            this.drB.clear();
            this.drD.setData(this.drB);
        }
        this.drw.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        gw(true);
        f(latLng);
        aJh();
        if (z) {
            aJg();
            if (this.drE.isFlipped()) {
                this.drE.gA(false);
            }
        }
        if (z2) {
            this.drn.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.drC != null && this.drC.aID() != null) {
                BDLocation aID = this.drC.aID();
                LatLng latLng = new LatLng(aID.getLatitude(), aID.getLongitude());
                this.dqF.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                aJh();
                if (this.drG) {
                    a(latLng, true, true);
                    this.drG = false;
                }
                gx(true);
            }
        } else if (view.getId() == R.id.finish) {
            jk(16);
            aJi();
        } else if (view.getId() == R.id.search) {
            b(this.drA);
        } else if (view.getId() == R.id.cancel) {
            jk(17);
            aJi();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.drY != null && gVar.drY.location != null) {
            this.drA = gVar;
            this.dqF.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.drY.location));
            aJh();
            if (this.drz == null) {
                this.drz = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.drZ) {
                this.dqG = (Marker) this.dqF.addOverlay(new MarkerOptions().position(gVar.drY.location).zIndex(88).icon(this.drz));
            }
            if (!gVar.drZ) {
                gx(false);
            }
        }
    }

    private void aJh() {
        if (this.dqG != null) {
            this.dqG.remove();
            this.dqG = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.drn.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.drI = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.dqF.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.drG = true;
                            a(latLng, false, true);
                            gx(false);
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

    private void jk(int i) {
        if (this.drH != null) {
            switch (i) {
                case 16:
                    if (this.drA != null) {
                        PoiInfo poiInfo = this.drA.drY;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.drH.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.drH.onCancel();
                    return;
                case 18:
                    this.drH.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void aJi() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.drH = null;
    }

    private void gx(boolean z) {
        if (this.dqO != null) {
            this.dqO.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.drY != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.drY.city);
            com.baidu.swan.impl.map.location.search.a ac = com.baidu.swan.impl.map.location.search.a.ac(bundle);
            ac.a(this, 1);
            ac.aIV();
        }
    }

    private boolean aJj() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.v.f.akr().akb().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.v.f.akr().akb(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                aIZ();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.dry.onResume();
        if (this.drC != null) {
            this.drC.gu(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dry.onPause();
        if (this.drC != null) {
            this.drC.gu(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.dry.onDestroy();
        }
        this.drx.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean UJ() {
        jk(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.dqF.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.drF = i == 1;
        if (this.drF || this.drG) {
            z = true;
        }
        this.drG = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.drF) {
            a(mapStatus.target, true, true);
            gx(false);
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
    public boolean ZR() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void Vn() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ZQ() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean Vi() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ah(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
