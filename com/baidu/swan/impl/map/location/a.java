package com.baidu.swan.impl.map.location;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.impl.map.location.e;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.core.d.c implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, b, e.b {
    private static final int erw = ah.T(20.0f);
    private ImageView eqC;
    private BaiduMap eqt;
    private Marker equ;
    private RecyclerView erb;
    private FrameLayout erc;
    private FrameLayout erd;
    private FrameLayout ere;
    private View erf;
    private View erg;
    private TextView erh;
    private ImageView eri;
    private GeoCoder erj;
    private TextureMapView erk;
    private BitmapDescriptor erl;
    private c erm;
    private List<c> ern;
    private e ero;
    private LocationDetailAdapter erp;
    private d erq;
    private boolean ers;
    private boolean ert;
    private InterfaceC0540a eru;
    private SelectedLocationInfo erv;
    private View mLoadingView;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0540a {
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

    public void baN() {
        f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga != null) {
            aga.mJ("navigateTo").af(f.cTZ, f.cUb).f(this).apL();
        }
    }

    public void a(InterfaceC0540a interfaceC0540a) {
        this.eru = interfaceC0540a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.bap();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        baX();
        if (aoL()) {
            inflate = av(inflate);
            gK(-1);
        }
        return a(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.ern = new ArrayList(11);
        this.erb = (RecyclerView) view.findViewById(R.id.location_list);
        this.eqC = (ImageView) view.findViewById(R.id.float_btn);
        this.erc = (FrameLayout) view.findViewById(R.id.float_container);
        this.erf = view.findViewById(R.id.cancel);
        this.erg = view.findViewById(R.id.search);
        this.erh = (TextView) view.findViewById(R.id.finish);
        this.eri = (ImageView) view.findViewById(R.id.center_ding);
        this.erd = (FrameLayout) view.findViewById(R.id.list_container);
        this.ere = (FrameLayout) view.findViewById(R.id.map_container);
        this.mLoadingView = view.findViewById(R.id.loading_progress);
        this.erk = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.eqC.setOnClickListener(this);
        this.erh.setOnClickListener(this);
        this.erg.setOnClickListener(this);
        this.erf.setOnClickListener(this);
        this.erj = GeoCoder.newInstance();
        this.eqt = this.erk.getMap();
        this.erj.setOnGetGeoCodeResultListener(this);
        this.eqt.setOnMapLoadedCallback(this);
        this.eqt.setOnMapStatusChangeListener(this);
        this.erb.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.aAo().azY()));
        this.erp = new LocationDetailAdapter(com.baidu.swan.apps.v.f.aAo().azY(), this.erb, this, false);
        this.erb.setAdapter(this.erp);
        this.erb.addItemDecoration(new LocationItemDecoration(com.baidu.swan.apps.v.f.aAo().azY(), true));
        this.erq = new d(this.erd, this.ere, this.erc);
        ((FlipperFrameLayout) this.erd).setViewFlipper(this.erq);
    }

    private void f(LatLng latLng) {
        this.erj.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void baX() {
        this.eqt.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.eqt.getUiSettings().setRotateGesturesEnabled(false);
        this.erk.showZoomControls(false);
        this.erk.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!bbb()) {
            baR();
        }
    }

    private void baR() {
        this.ero = new e(com.baidu.swan.apps.v.f.aAo().azY(), this.eqt);
        this.ero.ip(true);
        this.ero.a(this);
        ir(true);
    }

    private void baY() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eri, "translationY", 0.0f, -erw, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.erv != null) {
            poiInfo.name = this.erv.mName;
            poiInfo.location = new LatLng(this.erv.mLatitude, this.erv.mLongitude);
            poiInfo.address = this.erv.mAddress;
            this.erv = null;
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
        c cVar = new c(poiInfo, true, z);
        this.ern.clear();
        this.ern.add(cVar);
        this.ern.addAll(c.aZ(reverseGeoCodeResult.getPoiList()));
        this.erp.setData(this.ern);
        this.erm = cVar;
        if (this.ern.size() > 0) {
            ir(false);
        }
    }

    private void ir(boolean z) {
        if (z) {
            this.ern.clear();
            this.erp.setData(this.ern);
        }
        this.mLoadingView.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        ir(true);
        f(latLng);
        baZ();
        if (z) {
            baY();
            if (this.erq.isFlipped()) {
                this.erq.iw(false);
            }
        }
        if (z2) {
            this.erb.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.ero != null && this.ero.bav() != null) {
                BDLocation bav = this.ero.bav();
                LatLng latLng = new LatLng(bav.getLatitude(), bav.getLongitude());
                this.eqt.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                baZ();
                if (this.ert) {
                    a(latLng, true, true);
                    this.ert = false;
                }
                is(true);
            }
        } else if (view.getId() == R.id.finish) {
            lw(16);
            bba();
        } else if (view.getId() == R.id.search) {
            b(this.erm);
        } else if (view.getId() == R.id.cancel) {
            lw(17);
            bba();
        }
    }

    @Override // com.baidu.swan.impl.map.location.b
    public void a(c cVar) {
        if (cVar != null && cVar.erM != null && cVar.erM.location != null) {
            this.erm = cVar;
            this.eqt.animateMapStatus(MapStatusUpdateFactory.newLatLng(cVar.erM.location));
            baZ();
            if (this.erl == null) {
                this.erl = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!cVar.erN) {
                this.equ = (Marker) this.eqt.addOverlay(new MarkerOptions().position(cVar.erM.location).zIndex(88).icon(this.erl));
            }
            if (!cVar.erN) {
                is(false);
            }
        }
    }

    private void baZ() {
        if (this.equ != null) {
            this.equ.remove();
            this.equ = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.erb.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(reverseGeoCodeResult);
                }
            }, 150L);
        }
    }

    @Override // com.baidu.swan.impl.map.location.e.b
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
                            this.erv = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.eqt.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.ert = true;
                            a(latLng, false, true);
                            is(false);
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

    private void lw(int i) {
        if (this.eru != null) {
            switch (i) {
                case 16:
                    if (this.erm != null) {
                        PoiInfo poiInfo = this.erm.erM;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.eru.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.eru.onCancel();
                    return;
                case 18:
                    this.eru.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void bba() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.eru = null;
    }

    private void is(boolean z) {
        if (this.eqC != null) {
            this.eqC.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(c cVar) {
        if (cVar != null && cVar.erM != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", cVar.erM.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.baN();
        }
    }

    private boolean bbb() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.v.f.aAo().azY().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.v.f.aAo().azY(), R.string.aiapps_location_permission_fail).aIv();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                baR();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.erk.onResume();
        if (this.ero != null) {
            this.ero.ip(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.erk.onPause();
        if (this.ero != null) {
            this.ero.ip(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.erk.onDestroy();
        }
        this.erj.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiT() {
        lw(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.eqt.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.ers = i == 1;
        if (this.ers || this.ert) {
            z = true;
        }
        this.ert = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.ers) {
            a(mapStatus.target, true, true);
            is(false);
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
    public boolean aoj() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajA() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aoi() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aju() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void aq(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
