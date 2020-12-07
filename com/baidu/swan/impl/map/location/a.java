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
    private static final int ejx = ah.M(20.0f);
    private ImageView eiD;
    private BaiduMap eiu;
    private Marker eiv;
    private RecyclerView ejc;
    private FrameLayout ejd;
    private FrameLayout eje;
    private FrameLayout ejf;
    private View ejg;
    private View ejh;
    private TextView eji;
    private ImageView ejj;
    private View ejk;
    private GeoCoder ejl;
    private TextureMapView ejm;
    private BitmapDescriptor ejn;
    private g ejo;
    private List<g> ejp;
    private i ejq;
    private b ejr;
    private h ejs;
    private boolean ejt;
    private boolean eju;
    private InterfaceC0563a ejv;
    private SelectedLocationInfo ejw;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0563a {
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

    public void bbY() {
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim != null) {
            aim.nC("navigateTo").an(com.baidu.swan.apps.core.d.f.cQb, com.baidu.swan.apps.core.d.f.cQd).f(this).arM();
        }
    }

    public void a(InterfaceC0563a interfaceC0563a) {
        this.ejv = interfaceC0563a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.bbA();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        bci();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.ejp = new ArrayList(11);
        this.ejc = (RecyclerView) view.findViewById(R.id.location_list);
        this.eiD = (ImageView) view.findViewById(R.id.float_btn);
        this.ejd = (FrameLayout) view.findViewById(R.id.float_container);
        this.ejg = view.findViewById(R.id.cancel);
        this.ejh = view.findViewById(R.id.search);
        this.eji = (TextView) view.findViewById(R.id.finish);
        this.ejj = (ImageView) view.findViewById(R.id.center_ding);
        this.eje = (FrameLayout) view.findViewById(R.id.list_container);
        this.ejf = (FrameLayout) view.findViewById(R.id.map_container);
        this.ejk = view.findViewById(R.id.loading_progress);
        this.ejm = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.eiD.setOnClickListener(this);
        this.eji.setOnClickListener(this);
        this.ejh.setOnClickListener(this);
        this.ejg.setOnClickListener(this);
        this.ejl = GeoCoder.newInstance();
        this.eiu = this.ejm.getMap();
        this.ejl.setOnGetGeoCodeResultListener(this);
        this.eiu.setOnMapLoadedCallback(this);
        this.eiu.setOnMapStatusChangeListener(this);
        this.ejc.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.v.f.aCp().aBZ()));
        this.ejr = new b(com.baidu.swan.apps.v.f.aCp().aBZ(), this.ejc, this, false);
        this.ejc.setAdapter(this.ejr);
        this.ejc.addItemDecoration(new f(com.baidu.swan.apps.v.f.aCp().aBZ(), true));
        this.ejs = new h(this.eje, this.ejf, this.ejd);
        ((FlipperFrameLayout) this.eje).setViewFlipper(this.ejs);
    }

    private void f(LatLng latLng) {
        this.ejl.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void bci() {
        this.eiu.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.eiu.getUiSettings().setRotateGesturesEnabled(false);
        this.ejm.showZoomControls(false);
        this.ejm.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!bcm()) {
            bcc();
        }
    }

    private void bcc() {
        this.ejq = new i(com.baidu.swan.apps.v.f.aCp().aBZ(), this.eiu);
        this.ejq.hZ(true);
        this.ejq.a(this);
        ib(true);
    }

    private void bcj() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ejj, "translationY", 0.0f, -ejx, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.ejw != null) {
            poiInfo.name = this.ejw.mName;
            poiInfo.location = new LatLng(this.ejw.mLatitude, this.ejw.mLongitude);
            poiInfo.address = this.ejw.mAddress;
            this.ejw = null;
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
        this.ejp.clear();
        this.ejp.add(gVar);
        this.ejp.addAll(g.aX(reverseGeoCodeResult.getPoiList()));
        this.ejr.setData(this.ejp);
        this.ejo = gVar;
        if (this.ejp.size() > 0) {
            ib(false);
        }
    }

    private void ib(boolean z) {
        if (z) {
            this.ejp.clear();
            this.ejr.setData(this.ejp);
        }
        this.ejk.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        ib(true);
        f(latLng);
        bck();
        if (z) {
            bcj();
            if (this.ejs.isFlipped()) {
                this.ejs.m34if(false);
            }
        }
        if (z2) {
            this.ejc.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.ejq != null && this.ejq.bbG() != null) {
                BDLocation bbG = this.ejq.bbG();
                LatLng latLng = new LatLng(bbG.getLatitude(), bbG.getLongitude());
                this.eiu.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                bck();
                if (this.eju) {
                    a(latLng, true, true);
                    this.eju = false;
                }
                ic(true);
            }
        } else if (view.getId() == R.id.finish) {
            mQ(16);
            bcl();
        } else if (view.getId() == R.id.search) {
            b(this.ejo);
        } else if (view.getId() == R.id.cancel) {
            mQ(17);
            bcl();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.ejN != null && gVar.ejN.location != null) {
            this.ejo = gVar;
            this.eiu.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.ejN.location));
            bck();
            if (this.ejn == null) {
                this.ejn = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.ejO) {
                this.eiv = (Marker) this.eiu.addOverlay(new MarkerOptions().position(gVar.ejN.location).zIndex(88).icon(this.ejn));
            }
            if (!gVar.ejO) {
                ic(false);
            }
        }
    }

    private void bck() {
        if (this.eiv != null) {
            this.eiv.remove();
            this.eiv = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.ejc.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                            this.ejw = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.eiu.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.eju = true;
                            a(latLng, false, true);
                            ic(false);
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

    private void mQ(int i) {
        if (this.ejv != null) {
            switch (i) {
                case 16:
                    if (this.ejo != null) {
                        PoiInfo poiInfo = this.ejo.ejN;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.ejv.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.ejv.onCancel();
                    return;
                case 18:
                    this.ejv.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void bcl() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.ejv = null;
    }

    private void ic(boolean z) {
        if (this.eiD != null) {
            this.eiD.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.ejN != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.ejN.city);
            com.baidu.swan.impl.map.location.search.a ab = com.baidu.swan.impl.map.location.search.a.ab(bundle);
            ab.a(this, 1);
            ab.bbY();
        }
    }

    private boolean bcm() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.v.f.aCp().aBZ().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.t(com.baidu.swan.apps.v.f.aCp().aBZ(), R.string.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                bcc();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.ejm.onResume();
        if (this.ejq != null) {
            this.ejq.hZ(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ejm.onPause();
        if (this.ejq != null) {
            this.ejq.hZ(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.ejm.onDestroy();
        }
        this.ejl.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean alb() {
        mQ(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.eiu.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.ejt = i == 1;
        if (this.ejt || this.eju) {
            z = true;
        }
        this.eju = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.ejt) {
            a(mapStatus.target, true, true);
            ic(false);
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
    public boolean aqq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alI() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aqp() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean alC() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void at(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
