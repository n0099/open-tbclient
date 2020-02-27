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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.impl.map.location.i;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class a extends com.baidu.swan.apps.core.d.b implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int cwN = af.S(20.0f);
    private BaiduMap cvK;
    private Marker cvL;
    private ImageView cvT;
    private View cwA;
    private GeoCoder cwB;
    private TextureMapView cwC;
    private BitmapDescriptor cwD;
    private g cwE;
    private List<g> cwF;
    private i cwG;
    private b cwH;
    private h cwI;
    private boolean cwJ;
    private boolean cwK;
    private InterfaceC0357a cwL;
    private SelectedLocationInfo cwM;
    private RecyclerView cws;
    private FrameLayout cwt;
    private FrameLayout cwu;
    private FrameLayout cwv;
    private View cww;
    private View cwx;
    private TextView cwy;
    private ImageView cwz;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0357a {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    public static a U(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void arQ() {
        com.baidu.swan.apps.core.d.e GA = com.baidu.swan.apps.y.f.WQ().GA();
        if (GA != null) {
            GA.hb("navigateTo").Y(com.baidu.swan.apps.core.d.e.boe, com.baidu.swan.apps.core.d.e.bog).e(this).Ox();
        }
    }

    public void a(InterfaceC0357a interfaceC0357a) {
        this.cwL = interfaceC0357a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.ars();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        asa();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.cwF = new ArrayList(11);
        this.cws = (RecyclerView) view.findViewById(R.id.location_list);
        this.cvT = (ImageView) view.findViewById(R.id.float_btn);
        this.cwt = (FrameLayout) view.findViewById(R.id.float_container);
        this.cww = view.findViewById(R.id.cancel);
        this.cwx = view.findViewById(R.id.search);
        this.cwy = (TextView) view.findViewById(R.id.finish);
        this.cwz = (ImageView) view.findViewById(R.id.center_ding);
        this.cwu = (FrameLayout) view.findViewById(R.id.list_container);
        this.cwv = (FrameLayout) view.findViewById(R.id.map_container);
        this.cwA = view.findViewById(R.id.loading_progress);
        this.cwC = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.cvT.setOnClickListener(this);
        this.cwy.setOnClickListener(this);
        this.cwx.setOnClickListener(this);
        this.cww.setOnClickListener(this);
        this.cwB = GeoCoder.newInstance();
        this.cvK = this.cwC.getMap();
        this.cwB.setOnGetGeoCodeResultListener(this);
        this.cvK.setOnMapLoadedCallback(this);
        this.cvK.setOnMapStatusChangeListener(this);
        this.cws.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.y.f.WQ().WB()));
        this.cwH = new b(com.baidu.swan.apps.y.f.WQ().WB(), this.cws, this, false);
        this.cws.setAdapter(this.cwH);
        this.cws.addItemDecoration(new f(com.baidu.swan.apps.y.f.WQ().WB(), true));
        this.cwI = new h(this.cwu, this.cwv, this.cwt);
        ((FlipperFrameLayout) this.cwu).setViewFlipper(this.cwI);
    }

    private void f(LatLng latLng) {
        this.cwB.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void asa() {
        this.cvK.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.cvK.getUiSettings().setRotateGesturesEnabled(false);
        this.cwC.showZoomControls(false);
        this.cwC.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!ase()) {
            arU();
        }
    }

    private void arU() {
        this.cwG = new i(com.baidu.swan.apps.y.f.WQ().WB(), this.cvK);
        this.cwG.eK(true);
        this.cwG.a(this);
        eM(true);
    }

    private void asb() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cwz, "translationY", 0.0f, -cwN, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.cwM != null) {
            poiInfo.name = this.cwM.mName;
            poiInfo.location = new LatLng(this.cwM.mLatitude, this.cwM.mLongitude);
            poiInfo.address = this.cwM.mAddress;
            this.cwM = null;
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
        this.cwF.clear();
        this.cwF.add(gVar);
        this.cwF.addAll(g.aj(reverseGeoCodeResult.getPoiList()));
        this.cwH.setData(this.cwF);
        this.cwE = gVar;
        if (this.cwF.size() > 0) {
            eM(false);
        }
    }

    private void eM(boolean z) {
        if (z) {
            this.cwF.clear();
            this.cwH.setData(this.cwF);
        }
        this.cwA.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        eM(true);
        f(latLng);
        asc();
        if (z) {
            asb();
            if (this.cwI.isFlipped()) {
                this.cwI.eQ(false);
            }
        }
        if (z2) {
            this.cws.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.cwG != null && this.cwG.ary() != null) {
                BDLocation ary = this.cwG.ary();
                LatLng latLng = new LatLng(ary.getLatitude(), ary.getLongitude());
                this.cvK.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                asc();
                if (this.cwK) {
                    a(latLng, true, true);
                    this.cwK = false;
                }
                eN(true);
            }
        } else if (view.getId() == R.id.finish) {
            ii(16);
            asd();
        } else if (view.getId() == R.id.search) {
            b(this.cwE);
        } else if (view.getId() == R.id.cancel) {
            ii(17);
            asd();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.cxc != null && gVar.cxc.location != null) {
            this.cwE = gVar;
            this.cvK.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.cxc.location));
            asc();
            if (this.cwD == null) {
                this.cwD = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.cxd) {
                this.cvL = (Marker) this.cvK.addOverlay(new MarkerOptions().position(gVar.cxc.location).zIndex(88).icon(this.cwD));
            }
            if (!gVar.cxd) {
                eN(false);
            }
        }
    }

    private void asc() {
        if (this.cvL != null) {
            this.cvL.remove();
            this.cvL = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.cws.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.cwM = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.cvK.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.cwK = true;
                            a(latLng, false, true);
                            eN(false);
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

    private void ii(int i) {
        if (this.cwL != null) {
            switch (i) {
                case 16:
                    if (this.cwE != null) {
                        PoiInfo poiInfo = this.cwE.cxc;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.cwL.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.cwL.onCancel();
                    return;
                case 18:
                    this.cwL.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void asd() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.cwL = null;
    }

    private void eN(boolean z) {
        if (this.cvT != null) {
            this.cvT.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.cxc != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.cxc.city);
            com.baidu.swan.impl.map.location.search.a V = com.baidu.swan.impl.map.location.search.a.V(bundle);
            V.a(this, 1);
            V.arQ();
        }
    }

    private boolean ase() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.y.f.WQ().WB().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.y.f.WQ().WB(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                arU();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cwC.onResume();
        if (this.cwG != null) {
            this.cwG.eK(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cwC.onPause();
        if (this.cwG != null) {
            this.cwG.eK(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.cwC.onDestroy();
        }
        this.cwB.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean II() {
        ii(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.cvK.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.cwJ = i == 1;
        if (this.cwJ || this.cwK) {
            z = true;
        }
        this.cwK = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.cwJ) {
            a(mapStatus.target, true, true);
            eN(false);
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
    public boolean Nu() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jg() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nt() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jd() {
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
