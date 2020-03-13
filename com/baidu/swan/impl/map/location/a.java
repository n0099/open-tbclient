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
    private static final int cwP = af.S(20.0f);
    private BaiduMap cvM;
    private Marker cvN;
    private ImageView cvV;
    private TextView cwA;
    private ImageView cwB;
    private View cwC;
    private GeoCoder cwD;
    private TextureMapView cwE;
    private BitmapDescriptor cwF;
    private g cwG;
    private List<g> cwH;
    private i cwI;
    private b cwJ;
    private h cwK;
    private boolean cwL;
    private boolean cwM;
    private InterfaceC0357a cwN;
    private SelectedLocationInfo cwO;
    private RecyclerView cwu;
    private FrameLayout cwv;
    private FrameLayout cww;
    private FrameLayout cwx;
    private View cwy;
    private View cwz;

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

    public void arS() {
        com.baidu.swan.apps.core.d.e GC = com.baidu.swan.apps.y.f.WS().GC();
        if (GC != null) {
            GC.hb("navigateTo").Y(com.baidu.swan.apps.core.d.e.bog, com.baidu.swan.apps.core.d.e.boi).e(this).Oz();
        }
    }

    public void a(InterfaceC0357a interfaceC0357a) {
        this.cwN = interfaceC0357a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aru();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        asc();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.cwH = new ArrayList(11);
        this.cwu = (RecyclerView) view.findViewById(R.id.location_list);
        this.cvV = (ImageView) view.findViewById(R.id.float_btn);
        this.cwv = (FrameLayout) view.findViewById(R.id.float_container);
        this.cwy = view.findViewById(R.id.cancel);
        this.cwz = view.findViewById(R.id.search);
        this.cwA = (TextView) view.findViewById(R.id.finish);
        this.cwB = (ImageView) view.findViewById(R.id.center_ding);
        this.cww = (FrameLayout) view.findViewById(R.id.list_container);
        this.cwx = (FrameLayout) view.findViewById(R.id.map_container);
        this.cwC = view.findViewById(R.id.loading_progress);
        this.cwE = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.cvV.setOnClickListener(this);
        this.cwA.setOnClickListener(this);
        this.cwz.setOnClickListener(this);
        this.cwy.setOnClickListener(this);
        this.cwD = GeoCoder.newInstance();
        this.cvM = this.cwE.getMap();
        this.cwD.setOnGetGeoCodeResultListener(this);
        this.cvM.setOnMapLoadedCallback(this);
        this.cvM.setOnMapStatusChangeListener(this);
        this.cwu.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.y.f.WS().WD()));
        this.cwJ = new b(com.baidu.swan.apps.y.f.WS().WD(), this.cwu, this, false);
        this.cwu.setAdapter(this.cwJ);
        this.cwu.addItemDecoration(new f(com.baidu.swan.apps.y.f.WS().WD(), true));
        this.cwK = new h(this.cww, this.cwx, this.cwv);
        ((FlipperFrameLayout) this.cww).setViewFlipper(this.cwK);
    }

    private void f(LatLng latLng) {
        this.cwD.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void asc() {
        this.cvM.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.cvM.getUiSettings().setRotateGesturesEnabled(false);
        this.cwE.showZoomControls(false);
        this.cwE.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!asg()) {
            arW();
        }
    }

    private void arW() {
        this.cwI = new i(com.baidu.swan.apps.y.f.WS().WD(), this.cvM);
        this.cwI.eK(true);
        this.cwI.a(this);
        eM(true);
    }

    private void asd() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cwB, "translationY", 0.0f, -cwP, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.cwO != null) {
            poiInfo.name = this.cwO.mName;
            poiInfo.location = new LatLng(this.cwO.mLatitude, this.cwO.mLongitude);
            poiInfo.address = this.cwO.mAddress;
            this.cwO = null;
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
        this.cwH.clear();
        this.cwH.add(gVar);
        this.cwH.addAll(g.aj(reverseGeoCodeResult.getPoiList()));
        this.cwJ.setData(this.cwH);
        this.cwG = gVar;
        if (this.cwH.size() > 0) {
            eM(false);
        }
    }

    private void eM(boolean z) {
        if (z) {
            this.cwH.clear();
            this.cwJ.setData(this.cwH);
        }
        this.cwC.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        eM(true);
        f(latLng);
        ase();
        if (z) {
            asd();
            if (this.cwK.isFlipped()) {
                this.cwK.eQ(false);
            }
        }
        if (z2) {
            this.cwu.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.cwI != null && this.cwI.arA() != null) {
                BDLocation arA = this.cwI.arA();
                LatLng latLng = new LatLng(arA.getLatitude(), arA.getLongitude());
                this.cvM.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                ase();
                if (this.cwM) {
                    a(latLng, true, true);
                    this.cwM = false;
                }
                eN(true);
            }
        } else if (view.getId() == R.id.finish) {
            ii(16);
            asf();
        } else if (view.getId() == R.id.search) {
            b(this.cwG);
        } else if (view.getId() == R.id.cancel) {
            ii(17);
            asf();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.cxe != null && gVar.cxe.location != null) {
            this.cwG = gVar;
            this.cvM.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.cxe.location));
            ase();
            if (this.cwF == null) {
                this.cwF = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.cxf) {
                this.cvN = (Marker) this.cvM.addOverlay(new MarkerOptions().position(gVar.cxe.location).zIndex(88).icon(this.cwF));
            }
            if (!gVar.cxf) {
                eN(false);
            }
        }
    }

    private void ase() {
        if (this.cvN != null) {
            this.cvN.remove();
            this.cvN = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.cwu.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.cwO = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.cvM.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.cwM = true;
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
        if (this.cwN != null) {
            switch (i) {
                case 16:
                    if (this.cwG != null) {
                        PoiInfo poiInfo = this.cwG.cxe;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.cwN.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.cwN.onCancel();
                    return;
                case 18:
                    this.cwN.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void asf() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.cwN = null;
    }

    private void eN(boolean z) {
        if (this.cvV != null) {
            this.cvV.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.cxe != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.cxe.city);
            com.baidu.swan.impl.map.location.search.a V = com.baidu.swan.impl.map.location.search.a.V(bundle);
            V.a(this, 1);
            V.arS();
        }
    }

    private boolean asg() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.y.f.WS().WD().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.y.f.WS().WD(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                arW();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cwE.onResume();
        if (this.cwI != null) {
            this.cwI.eK(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cwE.onPause();
        if (this.cwI != null) {
            this.cwI.eK(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.cwE.onDestroy();
        }
        this.cwD.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IK() {
        ii(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.cvM.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.cwL = i == 1;
        if (this.cwL || this.cwM) {
            z = true;
        }
        this.cwM = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.cwL) {
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
    public boolean Nw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ji() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nv() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jf() {
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
