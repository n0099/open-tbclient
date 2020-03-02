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
    private static final int cwO = af.S(20.0f);
    private BaiduMap cvL;
    private Marker cvM;
    private ImageView cvU;
    private ImageView cwA;
    private View cwB;
    private GeoCoder cwC;
    private TextureMapView cwD;
    private BitmapDescriptor cwE;
    private g cwF;
    private List<g> cwG;
    private i cwH;
    private b cwI;
    private h cwJ;
    private boolean cwK;
    private boolean cwL;
    private InterfaceC0357a cwM;
    private SelectedLocationInfo cwN;
    private RecyclerView cwt;
    private FrameLayout cwu;
    private FrameLayout cwv;
    private FrameLayout cww;
    private View cwx;
    private View cwy;
    private TextView cwz;

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
            GC.hb("navigateTo").Y(com.baidu.swan.apps.core.d.e.bof, com.baidu.swan.apps.core.d.e.boh).e(this).Oz();
        }
    }

    public void a(InterfaceC0357a interfaceC0357a) {
        this.cwM = interfaceC0357a;
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
        this.cwG = new ArrayList(11);
        this.cwt = (RecyclerView) view.findViewById(R.id.location_list);
        this.cvU = (ImageView) view.findViewById(R.id.float_btn);
        this.cwu = (FrameLayout) view.findViewById(R.id.float_container);
        this.cwx = view.findViewById(R.id.cancel);
        this.cwy = view.findViewById(R.id.search);
        this.cwz = (TextView) view.findViewById(R.id.finish);
        this.cwA = (ImageView) view.findViewById(R.id.center_ding);
        this.cwv = (FrameLayout) view.findViewById(R.id.list_container);
        this.cww = (FrameLayout) view.findViewById(R.id.map_container);
        this.cwB = view.findViewById(R.id.loading_progress);
        this.cwD = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.cvU.setOnClickListener(this);
        this.cwz.setOnClickListener(this);
        this.cwy.setOnClickListener(this);
        this.cwx.setOnClickListener(this);
        this.cwC = GeoCoder.newInstance();
        this.cvL = this.cwD.getMap();
        this.cwC.setOnGetGeoCodeResultListener(this);
        this.cvL.setOnMapLoadedCallback(this);
        this.cvL.setOnMapStatusChangeListener(this);
        this.cwt.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.y.f.WS().WD()));
        this.cwI = new b(com.baidu.swan.apps.y.f.WS().WD(), this.cwt, this, false);
        this.cwt.setAdapter(this.cwI);
        this.cwt.addItemDecoration(new f(com.baidu.swan.apps.y.f.WS().WD(), true));
        this.cwJ = new h(this.cwv, this.cww, this.cwu);
        ((FlipperFrameLayout) this.cwv).setViewFlipper(this.cwJ);
    }

    private void f(LatLng latLng) {
        this.cwC.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void asc() {
        this.cvL.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.cvL.getUiSettings().setRotateGesturesEnabled(false);
        this.cwD.showZoomControls(false);
        this.cwD.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!asg()) {
            arW();
        }
    }

    private void arW() {
        this.cwH = new i(com.baidu.swan.apps.y.f.WS().WD(), this.cvL);
        this.cwH.eK(true);
        this.cwH.a(this);
        eM(true);
    }

    private void asd() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cwA, "translationY", 0.0f, -cwO, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.cwN != null) {
            poiInfo.name = this.cwN.mName;
            poiInfo.location = new LatLng(this.cwN.mLatitude, this.cwN.mLongitude);
            poiInfo.address = this.cwN.mAddress;
            this.cwN = null;
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
        this.cwG.clear();
        this.cwG.add(gVar);
        this.cwG.addAll(g.aj(reverseGeoCodeResult.getPoiList()));
        this.cwI.setData(this.cwG);
        this.cwF = gVar;
        if (this.cwG.size() > 0) {
            eM(false);
        }
    }

    private void eM(boolean z) {
        if (z) {
            this.cwG.clear();
            this.cwI.setData(this.cwG);
        }
        this.cwB.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        eM(true);
        f(latLng);
        ase();
        if (z) {
            asd();
            if (this.cwJ.isFlipped()) {
                this.cwJ.eQ(false);
            }
        }
        if (z2) {
            this.cwt.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.cwH != null && this.cwH.arA() != null) {
                BDLocation arA = this.cwH.arA();
                LatLng latLng = new LatLng(arA.getLatitude(), arA.getLongitude());
                this.cvL.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                ase();
                if (this.cwL) {
                    a(latLng, true, true);
                    this.cwL = false;
                }
                eN(true);
            }
        } else if (view.getId() == R.id.finish) {
            ii(16);
            asf();
        } else if (view.getId() == R.id.search) {
            b(this.cwF);
        } else if (view.getId() == R.id.cancel) {
            ii(17);
            asf();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.cxd != null && gVar.cxd.location != null) {
            this.cwF = gVar;
            this.cvL.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.cxd.location));
            ase();
            if (this.cwE == null) {
                this.cwE = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.cxe) {
                this.cvM = (Marker) this.cvL.addOverlay(new MarkerOptions().position(gVar.cxd.location).zIndex(88).icon(this.cwE));
            }
            if (!gVar.cxe) {
                eN(false);
            }
        }
    }

    private void ase() {
        if (this.cvM != null) {
            this.cvM.remove();
            this.cvM = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.cwt.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.cwN = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.cvL.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.cwL = true;
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
        if (this.cwM != null) {
            switch (i) {
                case 16:
                    if (this.cwF != null) {
                        PoiInfo poiInfo = this.cwF.cxd;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.cwM.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.cwM.onCancel();
                    return;
                case 18:
                    this.cwM.onError();
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
        this.cwM = null;
    }

    private void eN(boolean z) {
        if (this.cvU != null) {
            this.cvU.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.cxd != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.cxd.city);
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
        this.cwD.onResume();
        if (this.cwH != null) {
            this.cwH.eK(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cwD.onPause();
        if (this.cwH != null) {
            this.cwH.eK(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.cwD.onDestroy();
        }
        this.cwC.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IK() {
        ii(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.cvL.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.cwK = i == 1;
        if (this.cwK || this.cwL) {
            z = true;
        }
        this.cwL = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.cwK) {
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
