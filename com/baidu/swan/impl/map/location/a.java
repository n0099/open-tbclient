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
    private static final int esB = ah.O(20.0f);
    private ImageView erH;
    private BaiduMap ery;
    private Marker erz;
    private SelectedLocationInfo esA;
    private RecyclerView esg;
    private FrameLayout esh;
    private FrameLayout esi;
    private FrameLayout esj;
    private View esk;
    private View esl;
    private TextView esm;
    private ImageView esn;
    private View eso;
    private GeoCoder esp;
    private TextureMapView esq;
    private BitmapDescriptor esr;
    private c ess;
    private List<c> est;
    private e esu;
    private LocationDetailAdapter esv;
    private d esw;
    private boolean esx;
    private boolean esy;
    private InterfaceC0554a esz;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0554a {
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

    public void beq() {
        f ajs = com.baidu.swan.apps.v.f.aDG().ajs();
        if (ajs != null) {
            ajs.nv("navigateTo").ai(f.cUY, f.cVa).f(this).ate();
        }
    }

    public void a(InterfaceC0554a interfaceC0554a) {
        this.esz = interfaceC0554a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.bdS();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        beA();
        if (ase()) {
            inflate = az(inflate);
            im(-1);
        }
        return a(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.est = new ArrayList(11);
        this.esg = (RecyclerView) view.findViewById(R.id.location_list);
        this.erH = (ImageView) view.findViewById(R.id.float_btn);
        this.esh = (FrameLayout) view.findViewById(R.id.float_container);
        this.esk = view.findViewById(R.id.cancel);
        this.esl = view.findViewById(R.id.search);
        this.esm = (TextView) view.findViewById(R.id.finish);
        this.esn = (ImageView) view.findViewById(R.id.center_ding);
        this.esi = (FrameLayout) view.findViewById(R.id.list_container);
        this.esj = (FrameLayout) view.findViewById(R.id.map_container);
        this.eso = view.findViewById(R.id.loading_progress);
        this.esq = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.erH.setOnClickListener(this);
        this.esm.setOnClickListener(this);
        this.esl.setOnClickListener(this);
        this.esk.setOnClickListener(this);
        this.esp = GeoCoder.newInstance();
        this.ery = this.esq.getMap();
        this.esp.setOnGetGeoCodeResultListener(this);
        this.ery.setOnMapLoadedCallback(this);
        this.ery.setOnMapStatusChangeListener(this);
        this.esg.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.aDG().aDq()));
        this.esv = new LocationDetailAdapter(com.baidu.swan.apps.v.f.aDG().aDq(), this.esg, this, false);
        this.esg.setAdapter(this.esv);
        this.esg.addItemDecoration(new LocationItemDecoration(com.baidu.swan.apps.v.f.aDG().aDq(), true));
        this.esw = new d(this.esi, this.esj, this.esh);
        ((FlipperFrameLayout) this.esi).setViewFlipper(this.esw);
    }

    private void f(LatLng latLng) {
        this.esp.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void beA() {
        this.ery.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.ery.getUiSettings().setRotateGesturesEnabled(false);
        this.esq.showZoomControls(false);
        this.esq.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!beE()) {
            beu();
        }
    }

    private void beu() {
        this.esu = new e(com.baidu.swan.apps.v.f.aDG().aDq(), this.ery);
        this.esu.ir(true);
        this.esu.a(this);
        it(true);
    }

    private void beB() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.esn, "translationY", 0.0f, -esB, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.esA != null) {
            poiInfo.name = this.esA.mName;
            poiInfo.location = new LatLng(this.esA.mLatitude, this.esA.mLongitude);
            poiInfo.address = this.esA.mAddress;
            this.esA = null;
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
        this.est.clear();
        this.est.add(cVar);
        this.est.addAll(c.be(reverseGeoCodeResult.getPoiList()));
        this.esv.setData(this.est);
        this.ess = cVar;
        if (this.est.size() > 0) {
            it(false);
        }
    }

    private void it(boolean z) {
        if (z) {
            this.est.clear();
            this.esv.setData(this.est);
        }
        this.eso.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        it(true);
        f(latLng);
        beC();
        if (z) {
            beB();
            if (this.esw.beJ()) {
                this.esw.iy(false);
            }
        }
        if (z2) {
            this.esg.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.esu != null && this.esu.bdY() != null) {
                BDLocation bdY = this.esu.bdY();
                LatLng latLng = new LatLng(bdY.getLatitude(), bdY.getLongitude());
                this.ery.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                beC();
                if (this.esy) {
                    a(latLng, true, true);
                    this.esy = false;
                }
                iu(true);
            }
        } else if (view.getId() == R.id.finish) {
            mY(16);
            beD();
        } else if (view.getId() == R.id.search) {
            b(this.ess);
        } else if (view.getId() == R.id.cancel) {
            mY(17);
            beD();
        }
    }

    @Override // com.baidu.swan.impl.map.location.b
    public void a(c cVar) {
        if (cVar != null && cVar.esR != null && cVar.esR.location != null) {
            this.ess = cVar;
            this.ery.animateMapStatus(MapStatusUpdateFactory.newLatLng(cVar.esR.location));
            beC();
            if (this.esr == null) {
                this.esr = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!cVar.esS) {
                this.erz = (Marker) this.ery.addOverlay(new MarkerOptions().position(cVar.esR.location).zIndex(88).icon(this.esr));
            }
            if (!cVar.esS) {
                iu(false);
            }
        }
    }

    private void beC() {
        if (this.erz != null) {
            this.erz.remove();
            this.erz = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.esg.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(reverseGeoCodeResult);
                }
            }, 150L);
        }
    }

    @Override // com.baidu.swan.impl.map.location.e.b
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
                            this.esA = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.ery.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.esy = true;
                            a(latLng, false, true);
                            iu(false);
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

    private void mY(int i) {
        if (this.esz != null) {
            switch (i) {
                case 16:
                    if (this.ess != null) {
                        PoiInfo poiInfo = this.ess.esR;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.esz.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.esz.onCancel();
                    return;
                case 18:
                    this.esz.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void beD() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.esz = null;
    }

    private void iu(boolean z) {
        if (this.erH != null) {
            this.erH.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(c cVar) {
        if (cVar != null && cVar.esR != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", cVar.esR.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.beq();
        }
    }

    private boolean beE() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.v.f.aDG().aDq().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.v.f.aDG().aDq(), R.string.aiapps_location_permission_fail).aLS();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                beu();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.esq.onResume();
        if (this.esu != null) {
            this.esu.ir(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.esq.onPause();
        if (this.esu != null) {
            this.esu.ir(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.esq.onDestroy();
        }
        this.esp.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aml() {
        mY(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.ery.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.esx = i == 1;
        if (this.esx || this.esy) {
            z = true;
        }
        this.esy = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.esx) {
            a(mapStatus.target, true, true);
            iu(false);
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
    public boolean arC() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void amS() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void arB() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean amM() {
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
