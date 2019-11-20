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
    private static final int bHk = z.S(20.0f);
    private RecyclerView bGP;
    private FrameLayout bGQ;
    private FrameLayout bGR;
    private FrameLayout bGS;
    private View bGT;
    private View bGU;
    private TextView bGV;
    private ImageView bGW;
    private View bGX;
    private GeoCoder bGY;
    private TextureMapView bGZ;
    private BaiduMap bGh;
    private Marker bGi;
    private ImageView bGq;
    private BitmapDescriptor bHa;
    private g bHb;
    private List<g> bHc;
    private i bHd;
    private b bHe;
    private h bHf;
    private boolean bHg;
    private boolean bHh;
    private InterfaceC0264a bHi;
    private SelectedLocationInfo bHj;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0264a {
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

    public void ZB() {
        com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI != null) {
            AI.eC("navigateTo").F(com.baidu.swan.apps.core.d.e.aKT, com.baidu.swan.apps.core.d.e.aKV).c(this).FD();
        }
    }

    public void a(InterfaceC0264a interfaceC0264a) {
        this.bHi = interfaceC0264a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.Zg();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        ZK();
        if (EJ()) {
            inflate = Y(inflate);
            da(-1);
        }
        return a(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.bHc = new ArrayList(11);
        this.bGP = (RecyclerView) view.findViewById(R.id.location_list);
        this.bGq = (ImageView) view.findViewById(R.id.float_btn);
        this.bGQ = (FrameLayout) view.findViewById(R.id.float_container);
        this.bGT = view.findViewById(R.id.cancel);
        this.bGU = view.findViewById(R.id.search);
        this.bGV = (TextView) view.findViewById(R.id.finish);
        this.bGW = (ImageView) view.findViewById(R.id.center_ding);
        this.bGR = (FrameLayout) view.findViewById(R.id.list_container);
        this.bGS = (FrameLayout) view.findViewById(R.id.map_container);
        this.bGX = view.findViewById(R.id.loading_progress);
        this.bGZ = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.bGq.setOnClickListener(this);
        this.bGV.setOnClickListener(this);
        this.bGU.setOnClickListener(this);
        this.bGT.setOnClickListener(this);
        this.bGY = GeoCoder.newInstance();
        this.bGh = this.bGZ.getMap();
        this.bGY.setOnGetGeoCodeResultListener(this);
        this.bGh.setOnMapLoadedCallback(this);
        this.bGh.setOnMapStatusChangeListener(this);
        this.bGP.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.w.e.LE().Lq()));
        this.bHe = new b(com.baidu.swan.apps.w.e.LE().Lq(), this.bGP, this, false);
        this.bGP.setAdapter(this.bHe);
        this.bGP.addItemDecoration(new f(com.baidu.swan.apps.w.e.LE().Lq(), true));
        this.bHf = new h(this.bGR, this.bGS, this.bGQ);
        ((FlipperFrameLayout) this.bGR).setViewFlipper(this.bHf);
    }

    private void f(LatLng latLng) {
        this.bGY.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void ZK() {
        this.bGh.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.bGh.getUiSettings().setRotateGesturesEnabled(false);
        this.bGZ.showZoomControls(false);
        this.bGZ.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!ZO()) {
            ZF();
        }
    }

    private void ZF() {
        this.bHd = new i(com.baidu.swan.apps.w.e.LE().Lq(), this.bGh);
        this.bHd.dn(true);
        this.bHd.a(this);
        dp(true);
    }

    private void ZL() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bGW, "translationY", 0.0f, -bHk, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.bHj != null) {
            poiInfo.name = this.bHj.mName;
            poiInfo.location = new LatLng(this.bHj.mLatitude, this.bHj.mLongitude);
            poiInfo.address = this.bHj.mAddress;
            this.bHj = null;
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
        this.bHc.clear();
        this.bHc.add(gVar);
        this.bHc.addAll(g.ae(reverseGeoCodeResult.getPoiList()));
        this.bHe.setData(this.bHc);
        this.bHb = gVar;
        if (this.bHc.size() > 0) {
            dp(false);
        }
    }

    private void dp(boolean z) {
        if (z) {
            this.bHc.clear();
            this.bHe.setData(this.bHc);
        }
        this.bGX.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        dp(true);
        f(latLng);
        ZM();
        if (z) {
            ZL();
            if (this.bHf.ZT()) {
                this.bHf.du(false);
            }
        }
        if (z2) {
            this.bGP.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.bHd != null && this.bHd.Zm() != null) {
                BDLocation Zm = this.bHd.Zm();
                LatLng latLng = new LatLng(Zm.getLatitude(), Zm.getLongitude());
                this.bGh.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                ZM();
                if (this.bHh) {
                    a(latLng, true, true);
                    this.bHh = false;
                }
                dq(true);
            }
        } else if (view.getId() == R.id.finish) {
            gm(16);
            ZN();
        } else if (view.getId() == R.id.search) {
            b(this.bHb);
        } else if (view.getId() == R.id.cancel) {
            gm(17);
            ZN();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.bHz != null && gVar.bHz.location != null) {
            this.bHb = gVar;
            this.bGh.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.bHz.location));
            ZM();
            if (this.bHa == null) {
                this.bHa = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.bHA) {
                this.bGi = (Marker) this.bGh.addOverlay(new MarkerOptions().position(gVar.bHz.location).zIndex(88).icon(this.bHa));
            }
            if (!gVar.bHA) {
                dq(false);
            }
        }
    }

    private void ZM() {
        if (this.bGi != null) {
            this.bGi.remove();
            this.bGi = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.bGP.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.bHj = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.bGh.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.bHh = true;
                            a(latLng, false, true);
                            dq(false);
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

    private void gm(int i) {
        if (this.bHi != null) {
            switch (i) {
                case 16:
                    if (this.bHb != null) {
                        PoiInfo poiInfo = this.bHb.bHz;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.bHi.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.bHi.onCancel();
                    return;
                case 18:
                    this.bHi.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void ZN() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.bHi = null;
    }

    private void dq(boolean z) {
        if (this.bGq != null) {
            this.bGq.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.bHz != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.bHz.city);
            com.baidu.swan.impl.map.location.search.a C = com.baidu.swan.impl.map.location.search.a.C(bundle);
            C.a(this, 1);
            C.ZB();
        }
    }

    private boolean ZO() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.w.e.LE().Lq().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.i(com.baidu.swan.apps.w.e.LE().Lq(), R.string.aiapps_location_permission_fail).QO();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                ZF();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bGZ.onResume();
        if (this.bHd != null) {
            this.bHd.dn(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bGZ.onPause();
        if (this.bHd != null) {
            this.bHd.dn(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.bGZ.onDestroy();
        }
        this.bGY.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Co() {
        gm(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.bGh.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.bHg = i == 1;
        if (this.bHg || this.bHh) {
            z = true;
        }
        this.bHh = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.bHg) {
            a(mapStatus.target, true, true);
            dq(false);
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
    public boolean Ew() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ev() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CC() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void U(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
