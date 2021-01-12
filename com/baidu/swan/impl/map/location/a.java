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
    private static final int enN = ah.O(20.0f);
    private BaiduMap emI;
    private Marker emJ;
    private ImageView emR;
    private View enA;
    private GeoCoder enB;
    private TextureMapView enC;
    private BitmapDescriptor enD;
    private c enE;
    private List<c> enF;
    private e enG;
    private LocationDetailAdapter enH;
    private d enI;
    private boolean enJ;
    private boolean enK;
    private InterfaceC0537a enL;
    private SelectedLocationInfo enM;
    private RecyclerView enr;
    private FrameLayout ens;
    private FrameLayout ent;
    private FrameLayout enu;
    private View enw;
    private View enx;
    private TextView eny;
    private ImageView enz;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0537a {
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

    public void bax() {
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null) {
            afz.mk("navigateTo").ai(f.cQm, f.cQo).f(this).apk();
        }
    }

    public void a(InterfaceC0537a interfaceC0537a) {
        this.enL = interfaceC0537a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aZZ();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        baH();
        if (aok()) {
            inflate = az(inflate);
            gG(-1);
        }
        return a(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.enF = new ArrayList(11);
        this.enr = (RecyclerView) view.findViewById(R.id.location_list);
        this.emR = (ImageView) view.findViewById(R.id.float_btn);
        this.ens = (FrameLayout) view.findViewById(R.id.float_container);
        this.enw = view.findViewById(R.id.cancel);
        this.enx = view.findViewById(R.id.search);
        this.eny = (TextView) view.findViewById(R.id.finish);
        this.enz = (ImageView) view.findViewById(R.id.center_ding);
        this.ent = (FrameLayout) view.findViewById(R.id.list_container);
        this.enu = (FrameLayout) view.findViewById(R.id.map_container);
        this.enA = view.findViewById(R.id.loading_progress);
        this.enC = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.emR.setOnClickListener(this);
        this.eny.setOnClickListener(this);
        this.enx.setOnClickListener(this);
        this.enw.setOnClickListener(this);
        this.enB = GeoCoder.newInstance();
        this.emI = this.enC.getMap();
        this.enB.setOnGetGeoCodeResultListener(this);
        this.emI.setOnMapLoadedCallback(this);
        this.emI.setOnMapStatusChangeListener(this);
        this.enr.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.azN().azx()));
        this.enH = new LocationDetailAdapter(com.baidu.swan.apps.v.f.azN().azx(), this.enr, this, false);
        this.enr.setAdapter(this.enH);
        this.enr.addItemDecoration(new LocationItemDecoration(com.baidu.swan.apps.v.f.azN().azx(), true));
        this.enI = new d(this.ent, this.enu, this.ens);
        ((FlipperFrameLayout) this.ent).setViewFlipper(this.enI);
    }

    private void f(LatLng latLng) {
        this.enB.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void baH() {
        this.emI.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.emI.getUiSettings().setRotateGesturesEnabled(false);
        this.enC.showZoomControls(false);
        this.enC.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!baL()) {
            baB();
        }
    }

    private void baB() {
        this.enG = new e(com.baidu.swan.apps.v.f.azN().azx(), this.emI);
        this.enG.in(true);
        this.enG.a(this);
        ip(true);
    }

    private void baI() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.enz, "translationY", 0.0f, -enN, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.enM != null) {
            poiInfo.name = this.enM.mName;
            poiInfo.location = new LatLng(this.enM.mLatitude, this.enM.mLongitude);
            poiInfo.address = this.enM.mAddress;
            this.enM = null;
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
        this.enF.clear();
        this.enF.add(cVar);
        this.enF.addAll(c.be(reverseGeoCodeResult.getPoiList()));
        this.enH.setData(this.enF);
        this.enE = cVar;
        if (this.enF.size() > 0) {
            ip(false);
        }
    }

    private void ip(boolean z) {
        if (z) {
            this.enF.clear();
            this.enH.setData(this.enF);
        }
        this.enA.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        ip(true);
        f(latLng);
        baJ();
        if (z) {
            baI();
            if (this.enI.baQ()) {
                this.enI.iu(false);
            }
        }
        if (z2) {
            this.enr.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.enG != null && this.enG.baf() != null) {
                BDLocation baf = this.enG.baf();
                LatLng latLng = new LatLng(baf.getLatitude(), baf.getLongitude());
                this.emI.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                baJ();
                if (this.enK) {
                    a(latLng, true, true);
                    this.enK = false;
                }
                iq(true);
            }
        } else if (view.getId() == R.id.finish) {
            ls(16);
            baK();
        } else if (view.getId() == R.id.search) {
            b(this.enE);
        } else if (view.getId() == R.id.cancel) {
            ls(17);
            baK();
        }
    }

    @Override // com.baidu.swan.impl.map.location.b
    public void a(c cVar) {
        if (cVar != null && cVar.eod != null && cVar.eod.location != null) {
            this.enE = cVar;
            this.emI.animateMapStatus(MapStatusUpdateFactory.newLatLng(cVar.eod.location));
            baJ();
            if (this.enD == null) {
                this.enD = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!cVar.eoe) {
                this.emJ = (Marker) this.emI.addOverlay(new MarkerOptions().position(cVar.eod.location).zIndex(88).icon(this.enD));
            }
            if (!cVar.eoe) {
                iq(false);
            }
        }
    }

    private void baJ() {
        if (this.emJ != null) {
            this.emJ.remove();
            this.emJ = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.enr.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.enM = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.emI.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.enK = true;
                            a(latLng, false, true);
                            iq(false);
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

    private void ls(int i) {
        if (this.enL != null) {
            switch (i) {
                case 16:
                    if (this.enE != null) {
                        PoiInfo poiInfo = this.enE.eod;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.enL.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.enL.onCancel();
                    return;
                case 18:
                    this.enL.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void baK() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.enL = null;
    }

    private void iq(boolean z) {
        if (this.emR != null) {
            this.emR.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(c cVar) {
        if (cVar != null && cVar.eod != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", cVar.eod.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.bax();
        }
    }

    private boolean baL() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.v.f.azN().azx().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.v.f.azN().azx(), R.string.aiapps_location_permission_fail).aHZ();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                baB();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.enC.onResume();
        if (this.enG != null) {
            this.enG.in(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.enC.onPause();
        if (this.enG != null) {
            this.enG.in(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.enC.onDestroy();
        }
        this.enB.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ais() {
        ls(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.emI.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.enJ = i == 1;
        if (this.enJ || this.enK) {
            z = true;
        }
        this.enK = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.enJ) {
            a(mapStatus.target, true, true);
            iq(false);
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
    public boolean anI() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiZ() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anH() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiT() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void av(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
