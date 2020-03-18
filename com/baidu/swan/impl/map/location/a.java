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
    private static final int cxa = af.S(20.0f);
    private BaiduMap cvX;
    private Marker cvY;
    private RecyclerView cwF;
    private FrameLayout cwG;
    private FrameLayout cwH;
    private FrameLayout cwI;
    private View cwJ;
    private View cwK;
    private TextView cwL;
    private ImageView cwM;
    private View cwN;
    private GeoCoder cwO;
    private TextureMapView cwP;
    private BitmapDescriptor cwQ;
    private g cwR;
    private List<g> cwS;
    private i cwT;
    private b cwU;
    private h cwV;
    private boolean cwW;
    private boolean cwX;
    private InterfaceC0357a cwY;
    private SelectedLocationInfo cwZ;
    private ImageView cwg;

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

    public void arV() {
        com.baidu.swan.apps.core.d.e GH = com.baidu.swan.apps.y.f.WV().GH();
        if (GH != null) {
            GH.ha("navigateTo").Y(com.baidu.swan.apps.core.d.e.bos, com.baidu.swan.apps.core.d.e.bou).e(this).OC();
        }
    }

    public void a(InterfaceC0357a interfaceC0357a) {
        this.cwY = interfaceC0357a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.arx();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        asf();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.cwS = new ArrayList(11);
        this.cwF = (RecyclerView) view.findViewById(R.id.location_list);
        this.cwg = (ImageView) view.findViewById(R.id.float_btn);
        this.cwG = (FrameLayout) view.findViewById(R.id.float_container);
        this.cwJ = view.findViewById(R.id.cancel);
        this.cwK = view.findViewById(R.id.search);
        this.cwL = (TextView) view.findViewById(R.id.finish);
        this.cwM = (ImageView) view.findViewById(R.id.center_ding);
        this.cwH = (FrameLayout) view.findViewById(R.id.list_container);
        this.cwI = (FrameLayout) view.findViewById(R.id.map_container);
        this.cwN = view.findViewById(R.id.loading_progress);
        this.cwP = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.cwg.setOnClickListener(this);
        this.cwL.setOnClickListener(this);
        this.cwK.setOnClickListener(this);
        this.cwJ.setOnClickListener(this);
        this.cwO = GeoCoder.newInstance();
        this.cvX = this.cwP.getMap();
        this.cwO.setOnGetGeoCodeResultListener(this);
        this.cvX.setOnMapLoadedCallback(this);
        this.cvX.setOnMapStatusChangeListener(this);
        this.cwF.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.y.f.WV().WG()));
        this.cwU = new b(com.baidu.swan.apps.y.f.WV().WG(), this.cwF, this, false);
        this.cwF.setAdapter(this.cwU);
        this.cwF.addItemDecoration(new f(com.baidu.swan.apps.y.f.WV().WG(), true));
        this.cwV = new h(this.cwH, this.cwI, this.cwG);
        ((FlipperFrameLayout) this.cwH).setViewFlipper(this.cwV);
    }

    private void f(LatLng latLng) {
        this.cwO.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void asf() {
        this.cvX.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.cvX.getUiSettings().setRotateGesturesEnabled(false);
        this.cwP.showZoomControls(false);
        this.cwP.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!asj()) {
            arZ();
        }
    }

    private void arZ() {
        this.cwT = new i(com.baidu.swan.apps.y.f.WV().WG(), this.cvX);
        this.cwT.eL(true);
        this.cwT.a(this);
        eN(true);
    }

    private void asg() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cwM, "translationY", 0.0f, -cxa, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.cwZ != null) {
            poiInfo.name = this.cwZ.mName;
            poiInfo.location = new LatLng(this.cwZ.mLatitude, this.cwZ.mLongitude);
            poiInfo.address = this.cwZ.mAddress;
            this.cwZ = null;
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
        this.cwS.clear();
        this.cwS.add(gVar);
        this.cwS.addAll(g.aj(reverseGeoCodeResult.getPoiList()));
        this.cwU.setData(this.cwS);
        this.cwR = gVar;
        if (this.cwS.size() > 0) {
            eN(false);
        }
    }

    private void eN(boolean z) {
        if (z) {
            this.cwS.clear();
            this.cwU.setData(this.cwS);
        }
        this.cwN.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        eN(true);
        f(latLng);
        ash();
        if (z) {
            asg();
            if (this.cwV.isFlipped()) {
                this.cwV.eR(false);
            }
        }
        if (z2) {
            this.cwF.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.cwT != null && this.cwT.arD() != null) {
                BDLocation arD = this.cwT.arD();
                LatLng latLng = new LatLng(arD.getLatitude(), arD.getLongitude());
                this.cvX.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                ash();
                if (this.cwX) {
                    a(latLng, true, true);
                    this.cwX = false;
                }
                eO(true);
            }
        } else if (view.getId() == R.id.finish) {
            ii(16);
            asi();
        } else if (view.getId() == R.id.search) {
            b(this.cwR);
        } else if (view.getId() == R.id.cancel) {
            ii(17);
            asi();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.cxp != null && gVar.cxp.location != null) {
            this.cwR = gVar;
            this.cvX.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.cxp.location));
            ash();
            if (this.cwQ == null) {
                this.cwQ = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.cxq) {
                this.cvY = (Marker) this.cvX.addOverlay(new MarkerOptions().position(gVar.cxp.location).zIndex(88).icon(this.cwQ));
            }
            if (!gVar.cxq) {
                eO(false);
            }
        }
    }

    private void ash() {
        if (this.cvY != null) {
            this.cvY.remove();
            this.cvY = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.cwF.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.cwZ = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.cvX.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.cwX = true;
                            a(latLng, false, true);
                            eO(false);
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
        if (this.cwY != null) {
            switch (i) {
                case 16:
                    if (this.cwR != null) {
                        PoiInfo poiInfo = this.cwR.cxp;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.cwY.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.cwY.onCancel();
                    return;
                case 18:
                    this.cwY.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void asi() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.cwY = null;
    }

    private void eO(boolean z) {
        if (this.cwg != null) {
            this.cwg.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.cxp != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.cxp.city);
            com.baidu.swan.impl.map.location.search.a V = com.baidu.swan.impl.map.location.search.a.V(bundle);
            V.a(this, 1);
            V.arV();
        }
    }

    private boolean asj() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.y.f.WV().WG().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.y.f.WV().WG(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                arZ();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cwP.onResume();
        if (this.cwT != null) {
            this.cwT.eL(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cwP.onPause();
        if (this.cwT != null) {
            this.cwT.eL(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.cwP.onDestroy();
        }
        this.cwO.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IN() {
        ii(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.cvX.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.cwW = i == 1;
        if (this.cwW || this.cwX) {
            z = true;
        }
        this.cwX = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.cwW) {
            a(mapStatus.target, true, true);
            eO(false);
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
    public boolean Nz() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jl() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ny() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ji() {
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
