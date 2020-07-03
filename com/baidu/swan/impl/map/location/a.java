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
    private static final int dlO = ag.D(20.0f);
    private BaiduMap dkL;
    private Marker dkM;
    private ImageView dkU;
    private ImageView dlA;
    private View dlB;
    private GeoCoder dlC;
    private TextureMapView dlD;
    private BitmapDescriptor dlE;
    private g dlF;
    private List<g> dlG;
    private i dlH;
    private b dlI;
    private h dlJ;
    private boolean dlK;
    private boolean dlL;
    private InterfaceC0455a dlM;
    private SelectedLocationInfo dlN;
    private RecyclerView dlt;
    private FrameLayout dlu;
    private FrameLayout dlv;
    private FrameLayout dlw;
    private View dlx;
    private View dly;
    private TextView dlz;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0455a {
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

    public void aFe() {
        com.baidu.swan.apps.core.d.e RN = com.baidu.swan.apps.w.f.ajb().RN();
        if (RN != null) {
            RN.jx("navigateTo").ag(com.baidu.swan.apps.core.d.e.caB, com.baidu.swan.apps.core.d.e.caD).f(this).aah();
        }
    }

    public void a(InterfaceC0455a interfaceC0455a) {
        this.dlM = interfaceC0455a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aEG();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        aFo();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.dlG = new ArrayList(11);
        this.dlt = (RecyclerView) view.findViewById(R.id.location_list);
        this.dkU = (ImageView) view.findViewById(R.id.float_btn);
        this.dlu = (FrameLayout) view.findViewById(R.id.float_container);
        this.dlx = view.findViewById(R.id.cancel);
        this.dly = view.findViewById(R.id.search);
        this.dlz = (TextView) view.findViewById(R.id.finish);
        this.dlA = (ImageView) view.findViewById(R.id.center_ding);
        this.dlv = (FrameLayout) view.findViewById(R.id.list_container);
        this.dlw = (FrameLayout) view.findViewById(R.id.map_container);
        this.dlB = view.findViewById(R.id.loading_progress);
        this.dlD = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dkU.setOnClickListener(this);
        this.dlz.setOnClickListener(this);
        this.dly.setOnClickListener(this);
        this.dlx.setOnClickListener(this);
        this.dlC = GeoCoder.newInstance();
        this.dkL = this.dlD.getMap();
        this.dlC.setOnGetGeoCodeResultListener(this);
        this.dkL.setOnMapLoadedCallback(this);
        this.dkL.setOnMapStatusChangeListener(this);
        this.dlt.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.w.f.ajb().aiL()));
        this.dlI = new b(com.baidu.swan.apps.w.f.ajb().aiL(), this.dlt, this, false);
        this.dlt.setAdapter(this.dlI);
        this.dlt.addItemDecoration(new f(com.baidu.swan.apps.w.f.ajb().aiL(), true));
        this.dlJ = new h(this.dlv, this.dlw, this.dlu);
        ((FlipperFrameLayout) this.dlv).setViewFlipper(this.dlJ);
    }

    private void f(LatLng latLng) {
        this.dlC.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void aFo() {
        this.dkL.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.dkL.getUiSettings().setRotateGesturesEnabled(false);
        this.dlD.showZoomControls(false);
        this.dlD.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!aFs()) {
            aFi();
        }
    }

    private void aFi() {
        this.dlH = new i(com.baidu.swan.apps.w.f.ajb().aiL(), this.dkL);
        this.dlH.fY(true);
        this.dlH.a(this);
        ga(true);
    }

    private void aFp() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dlA, "translationY", 0.0f, -dlO, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.dlN != null) {
            poiInfo.name = this.dlN.mName;
            poiInfo.location = new LatLng(this.dlN.mLatitude, this.dlN.mLongitude);
            poiInfo.address = this.dlN.mAddress;
            this.dlN = null;
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
        this.dlG.clear();
        this.dlG.add(gVar);
        this.dlG.addAll(g.ar(reverseGeoCodeResult.getPoiList()));
        this.dlI.setData(this.dlG);
        this.dlF = gVar;
        if (this.dlG.size() > 0) {
            ga(false);
        }
    }

    private void ga(boolean z) {
        if (z) {
            this.dlG.clear();
            this.dlI.setData(this.dlG);
        }
        this.dlB.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        ga(true);
        f(latLng);
        aFq();
        if (z) {
            aFp();
            if (this.dlJ.isFlipped()) {
                this.dlJ.ge(false);
            }
        }
        if (z2) {
            this.dlt.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.dlH != null && this.dlH.aEM() != null) {
                BDLocation aEM = this.dlH.aEM();
                LatLng latLng = new LatLng(aEM.getLatitude(), aEM.getLongitude());
                this.dkL.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                aFq();
                if (this.dlL) {
                    a(latLng, true, true);
                    this.dlL = false;
                }
                gb(true);
            }
        } else if (view.getId() == R.id.finish) {
            iT(16);
            aFr();
        } else if (view.getId() == R.id.search) {
            b(this.dlF);
        } else if (view.getId() == R.id.cancel) {
            iT(17);
            aFr();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.dmd != null && gVar.dmd.location != null) {
            this.dlF = gVar;
            this.dkL.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.dmd.location));
            aFq();
            if (this.dlE == null) {
                this.dlE = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.dme) {
                this.dkM = (Marker) this.dkL.addOverlay(new MarkerOptions().position(gVar.dmd.location).zIndex(88).icon(this.dlE));
            }
            if (!gVar.dme) {
                gb(false);
            }
        }
    }

    private void aFq() {
        if (this.dkM != null) {
            this.dkM.remove();
            this.dkM = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.dlt.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.dlN = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.dkL.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.dlL = true;
                            a(latLng, false, true);
                            gb(false);
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

    private void iT(int i) {
        if (this.dlM != null) {
            switch (i) {
                case 16:
                    if (this.dlF != null) {
                        PoiInfo poiInfo = this.dlF.dmd;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.dlM.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.dlM.onCancel();
                    return;
                case 18:
                    this.dlM.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void aFr() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.dlM = null;
    }

    private void gb(boolean z) {
        if (this.dkU != null) {
            this.dkU.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.dmd != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.dmd.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.aFe();
        }
    }

    private boolean aFs() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.w.f.ajb().aiL().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.w.f.ajb().aiL(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                aFi();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.dlD.onResume();
        if (this.dlH != null) {
            this.dlH.fY(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dlD.onPause();
        if (this.dlH != null) {
            this.dlH.fY(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.dlD.onDestroy();
        }
        this.dlC.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ui() {
        iT(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.dkL.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.dlK = i == 1;
        if (this.dlK || this.dlL) {
            z = true;
        }
        this.dlL = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.dlK) {
            a(mapStatus.target, true, true);
            gb(false);
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
    public boolean YW() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void UI() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void YV() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean UE() {
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
