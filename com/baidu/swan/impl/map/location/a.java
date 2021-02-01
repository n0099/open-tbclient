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
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.apps.core.d.c implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, b, e.b {
    private static final int epU = ah.P(20.0f);
    private BaiduMap eoS;
    private Marker eoT;
    private RecyclerView epA;
    private FrameLayout epB;
    private FrameLayout epC;
    private FrameLayout epD;
    private View epE;
    private View epF;
    private TextView epG;
    private ImageView epH;
    private GeoCoder epI;
    private TextureMapView epJ;
    private BitmapDescriptor epK;
    private c epL;
    private List<c> epM;
    private e epN;
    private LocationDetailAdapter epO;
    private d epP;
    private boolean epQ;
    private boolean epR;
    private InterfaceC0534a epS;
    private SelectedLocationInfo epT;
    private ImageView epb;
    private View mLoadingView;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0534a {
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

    public void baK() {
        f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX != null) {
            afX.mC("navigateTo").af(f.cSz, f.cSB).f(this).apI();
        }
    }

    public void a(InterfaceC0534a interfaceC0534a) {
        this.epS = interfaceC0534a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.bam();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        baU();
        if (aoI()) {
            inflate = av(inflate);
            gJ(-1);
        }
        return a(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.epM = new ArrayList(11);
        this.epA = (RecyclerView) view.findViewById(R.id.location_list);
        this.epb = (ImageView) view.findViewById(R.id.float_btn);
        this.epB = (FrameLayout) view.findViewById(R.id.float_container);
        this.epE = view.findViewById(R.id.cancel);
        this.epF = view.findViewById(R.id.search);
        this.epG = (TextView) view.findViewById(R.id.finish);
        this.epH = (ImageView) view.findViewById(R.id.center_ding);
        this.epC = (FrameLayout) view.findViewById(R.id.list_container);
        this.epD = (FrameLayout) view.findViewById(R.id.map_container);
        this.mLoadingView = view.findViewById(R.id.loading_progress);
        this.epJ = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.epb.setOnClickListener(this);
        this.epG.setOnClickListener(this);
        this.epF.setOnClickListener(this);
        this.epE.setOnClickListener(this);
        this.epI = GeoCoder.newInstance();
        this.eoS = this.epJ.getMap();
        this.epI.setOnGetGeoCodeResultListener(this);
        this.eoS.setOnMapLoadedCallback(this);
        this.eoS.setOnMapStatusChangeListener(this);
        this.epA.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.aAl().azV()));
        this.epO = new LocationDetailAdapter(com.baidu.swan.apps.v.f.aAl().azV(), this.epA, this, false);
        this.epA.setAdapter(this.epO);
        this.epA.addItemDecoration(new LocationItemDecoration(com.baidu.swan.apps.v.f.aAl().azV(), true));
        this.epP = new d(this.epC, this.epD, this.epB);
        ((FlipperFrameLayout) this.epC).setViewFlipper(this.epP);
    }

    private void f(LatLng latLng) {
        this.epI.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void baU() {
        this.eoS.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.eoS.getUiSettings().setRotateGesturesEnabled(false);
        this.epJ.showZoomControls(false);
        this.epJ.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!baY()) {
            baO();
        }
    }

    private void baO() {
        this.epN = new e(com.baidu.swan.apps.v.f.aAl().azV(), this.eoS);
        this.epN.ip(true);
        this.epN.a(this);
        ir(true);
    }

    private void baV() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.epH, "translationY", 0.0f, -epU, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.epT != null) {
            poiInfo.name = this.epT.mName;
            poiInfo.location = new LatLng(this.epT.mLatitude, this.epT.mLongitude);
            poiInfo.address = this.epT.mAddress;
            this.epT = null;
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
        this.epM.clear();
        this.epM.add(cVar);
        this.epM.addAll(c.aZ(reverseGeoCodeResult.getPoiList()));
        this.epO.setData(this.epM);
        this.epL = cVar;
        if (this.epM.size() > 0) {
            ir(false);
        }
    }

    private void ir(boolean z) {
        if (z) {
            this.epM.clear();
            this.epO.setData(this.epM);
        }
        this.mLoadingView.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        ir(true);
        f(latLng);
        baW();
        if (z) {
            baV();
            if (this.epP.bbd()) {
                this.epP.iw(false);
            }
        }
        if (z2) {
            this.epA.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.epN != null && this.epN.bas() != null) {
                BDLocation bas = this.epN.bas();
                LatLng latLng = new LatLng(bas.getLatitude(), bas.getLongitude());
                this.eoS.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                baW();
                if (this.epR) {
                    a(latLng, true, true);
                    this.epR = false;
                }
                is(true);
            }
        } else if (view.getId() == R.id.finish) {
            lv(16);
            baX();
        } else if (view.getId() == R.id.search) {
            b(this.epL);
        } else if (view.getId() == R.id.cancel) {
            lv(17);
            baX();
        }
    }

    @Override // com.baidu.swan.impl.map.location.b
    public void a(c cVar) {
        if (cVar != null && cVar.eqk != null && cVar.eqk.location != null) {
            this.epL = cVar;
            this.eoS.animateMapStatus(MapStatusUpdateFactory.newLatLng(cVar.eqk.location));
            baW();
            if (this.epK == null) {
                this.epK = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!cVar.eql) {
                this.eoT = (Marker) this.eoS.addOverlay(new MarkerOptions().position(cVar.eqk.location).zIndex(88).icon(this.epK));
            }
            if (!cVar.eql) {
                is(false);
            }
        }
    }

    private void baW() {
        if (this.eoT != null) {
            this.eoT.remove();
            this.eoT = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.epA.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.epT = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.eoS.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.epR = true;
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

    private void lv(int i) {
        if (this.epS != null) {
            switch (i) {
                case 16:
                    if (this.epL != null) {
                        PoiInfo poiInfo = this.epL.eqk;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.epS.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.epS.onCancel();
                    return;
                case 18:
                    this.epS.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void baX() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.epS = null;
    }

    private void is(boolean z) {
        if (this.epb != null) {
            this.epb.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(c cVar) {
        if (cVar != null && cVar.eqk != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", cVar.eqk.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.baK();
        }
    }

    private boolean baY() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.v.f.aAl().azV().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.v.f.aAl().azV(), R.string.aiapps_location_permission_fail).aIs();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                baO();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.epJ.onResume();
        if (this.epN != null) {
            this.epN.ip(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.epJ.onPause();
        if (this.epN != null) {
            this.epN.ip(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.epJ.onDestroy();
        }
        this.epI.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiQ() {
        lv(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.eoS.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.epQ = i == 1;
        if (this.epQ || this.epR) {
            z = true;
        }
        this.epR = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.epQ) {
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
    public boolean aog() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajx() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aof() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajr() {
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
