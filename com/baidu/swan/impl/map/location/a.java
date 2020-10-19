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
    private static final int dPQ = ah.J(20.0f);
    private BaiduMap dON;
    private Marker dOO;
    private ImageView dOW;
    private View dPA;
    private TextView dPB;
    private ImageView dPC;
    private View dPD;
    private GeoCoder dPE;
    private TextureMapView dPF;
    private BitmapDescriptor dPG;
    private g dPH;
    private List<g> dPI;
    private i dPJ;
    private b dPK;
    private h dPL;
    private boolean dPM;
    private boolean dPN;
    private InterfaceC0527a dPO;
    private SelectedLocationInfo dPP;
    private RecyclerView dPv;
    private FrameLayout dPw;
    private FrameLayout dPx;
    private FrameLayout dPy;
    private View dPz;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0527a {
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

    public void aVg() {
        com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs != null) {
            abs.mt("navigateTo").ak(com.baidu.swan.apps.core.d.f.cwD, com.baidu.swan.apps.core.d.f.cwF).f(this).akS();
        }
    }

    public void a(InterfaceC0527a interfaceC0527a) {
        this.dPO = interfaceC0527a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aUI();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        aVq();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.dPI = new ArrayList(11);
        this.dPv = (RecyclerView) view.findViewById(R.id.location_list);
        this.dOW = (ImageView) view.findViewById(R.id.float_btn);
        this.dPw = (FrameLayout) view.findViewById(R.id.float_container);
        this.dPz = view.findViewById(R.id.cancel);
        this.dPA = view.findViewById(R.id.search);
        this.dPB = (TextView) view.findViewById(R.id.finish);
        this.dPC = (ImageView) view.findViewById(R.id.center_ding);
        this.dPx = (FrameLayout) view.findViewById(R.id.list_container);
        this.dPy = (FrameLayout) view.findViewById(R.id.map_container);
        this.dPD = view.findViewById(R.id.loading_progress);
        this.dPF = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dOW.setOnClickListener(this);
        this.dPB.setOnClickListener(this);
        this.dPA.setOnClickListener(this);
        this.dPz.setOnClickListener(this);
        this.dPE = GeoCoder.newInstance();
        this.dON = this.dPF.getMap();
        this.dPE.setOnGetGeoCodeResultListener(this);
        this.dON.setOnMapLoadedCallback(this);
        this.dON.setOnMapStatusChangeListener(this);
        this.dPv.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.avu().ave()));
        this.dPK = new b(com.baidu.swan.apps.v.f.avu().ave(), this.dPv, this, false);
        this.dPv.setAdapter(this.dPK);
        this.dPv.addItemDecoration(new f(com.baidu.swan.apps.v.f.avu().ave(), true));
        this.dPL = new h(this.dPx, this.dPy, this.dPw);
        ((FlipperFrameLayout) this.dPx).setViewFlipper(this.dPL);
    }

    private void f(LatLng latLng) {
        this.dPE.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void aVq() {
        this.dON.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.dON.getUiSettings().setRotateGesturesEnabled(false);
        this.dPF.showZoomControls(false);
        this.dPF.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!aVu()) {
            aVk();
        }
    }

    private void aVk() {
        this.dPJ = new i(com.baidu.swan.apps.v.f.avu().ave(), this.dON);
        this.dPJ.hl(true);
        this.dPJ.a(this);
        hn(true);
    }

    private void aVr() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dPC, "translationY", 0.0f, -dPQ, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.dPP != null) {
            poiInfo.name = this.dPP.mName;
            poiInfo.location = new LatLng(this.dPP.mLatitude, this.dPP.mLongitude);
            poiInfo.address = this.dPP.mAddress;
            this.dPP = null;
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
        this.dPI.clear();
        this.dPI.add(gVar);
        this.dPI.addAll(g.aD(reverseGeoCodeResult.getPoiList()));
        this.dPK.setData(this.dPI);
        this.dPH = gVar;
        if (this.dPI.size() > 0) {
            hn(false);
        }
    }

    private void hn(boolean z) {
        if (z) {
            this.dPI.clear();
            this.dPK.setData(this.dPI);
        }
        this.dPD.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        hn(true);
        f(latLng);
        aVs();
        if (z) {
            aVr();
            if (this.dPL.isFlipped()) {
                this.dPL.hr(false);
            }
        }
        if (z2) {
            this.dPv.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.dPJ != null && this.dPJ.aUO() != null) {
                BDLocation aUO = this.dPJ.aUO();
                LatLng latLng = new LatLng(aUO.getLatitude(), aUO.getLongitude());
                this.dON.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                aVs();
                if (this.dPN) {
                    a(latLng, true, true);
                    this.dPN = false;
                }
                ho(true);
            }
        } else if (view.getId() == R.id.finish) {
            mb(16);
            aVt();
        } else if (view.getId() == R.id.search) {
            b(this.dPH);
        } else if (view.getId() == R.id.cancel) {
            mb(17);
            aVt();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.dQf != null && gVar.dQf.location != null) {
            this.dPH = gVar;
            this.dON.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.dQf.location));
            aVs();
            if (this.dPG == null) {
                this.dPG = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.dQg) {
                this.dOO = (Marker) this.dON.addOverlay(new MarkerOptions().position(gVar.dQf.location).zIndex(88).icon(this.dPG));
            }
            if (!gVar.dQg) {
                ho(false);
            }
        }
    }

    private void aVs() {
        if (this.dOO != null) {
            this.dOO.remove();
            this.dOO = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.dPv.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.dPP = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.dON.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.dPN = true;
                            a(latLng, false, true);
                            ho(false);
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

    private void mb(int i) {
        if (this.dPO != null) {
            switch (i) {
                case 16:
                    if (this.dPH != null) {
                        PoiInfo poiInfo = this.dPH.dQf;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.dPO.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.dPO.onCancel();
                    return;
                case 18:
                    this.dPO.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void aVt() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.dPO = null;
    }

    private void ho(boolean z) {
        if (this.dOW != null) {
            this.dOW.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.dQf != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.dQf.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.aVg();
        }
    }

    private boolean aVu() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.v.f.avu().ave().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.v.f.avu().ave(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                aVk();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.dPF.onResume();
        if (this.dPJ != null) {
            this.dPJ.hl(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dPF.onPause();
        if (this.dPJ != null) {
            this.dPJ.hl(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.dPF.onDestroy();
        }
        this.dPE.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aeh() {
        mb(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.dON.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.dPM = i == 1;
        if (this.dPM || this.dPN) {
            z = true;
        }
        this.dPN = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.dPM) {
            a(mapStatus.target, true, true);
            ho(false);
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
    public boolean ajw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aeO() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajv() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aeI() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void al(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
