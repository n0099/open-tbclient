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
import com.baidu.swan.apps.an.z;
import com.baidu.swan.impl.map.location.i;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.baidu.swan.apps.core.d.b implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, e, i.b {
    private static final int bpp = z.ad(20.0f);
    private RecyclerView boU;
    private FrameLayout boV;
    private FrameLayout boW;
    private FrameLayout boX;
    private View boY;
    private View boZ;
    private BaiduMap bom;
    private Marker bon;
    private ImageView bov;
    private TextView bpa;
    private ImageView bpb;
    private View bpc;
    private GeoCoder bpd;
    private TextureMapView bpe;
    private BitmapDescriptor bpf;
    private g bpg;
    private List<g> bph;
    private i bpi;
    private b bpj;
    private h bpk;
    private boolean bpl;
    private boolean bpm;
    private InterfaceC0232a bpn;
    private SelectedLocationInfo bpo;

    /* renamed from: com.baidu.swan.impl.map.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0232a {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    public static a B(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void UO() {
        com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN != null) {
            vN.dU("navigateTo").B(com.baidu.swan.apps.core.d.e.arU, com.baidu.swan.apps.core.d.e.arW).c(this).AH();
        }
    }

    public void a(InterfaceC0232a interfaceC0232a) {
        this.bpn = interfaceC0232a;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.Ut();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        UX();
        if (zN()) {
            inflate = S(inflate);
            ce(-1);
        }
        return a(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.bph = new ArrayList(11);
        this.boU = (RecyclerView) view.findViewById(R.id.location_list);
        this.bov = (ImageView) view.findViewById(R.id.float_btn);
        this.boV = (FrameLayout) view.findViewById(R.id.float_container);
        this.boY = view.findViewById(R.id.cancel);
        this.boZ = view.findViewById(R.id.search);
        this.bpa = (TextView) view.findViewById(R.id.finish);
        this.bpb = (ImageView) view.findViewById(R.id.center_ding);
        this.boW = (FrameLayout) view.findViewById(R.id.list_container);
        this.boX = (FrameLayout) view.findViewById(R.id.map_container);
        this.bpc = view.findViewById(R.id.loading_progress);
        this.bpe = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.bov.setOnClickListener(this);
        this.bpa.setOnClickListener(this);
        this.boZ.setOnClickListener(this);
        this.boY.setOnClickListener(this);
        this.bpd = GeoCoder.newInstance();
        this.bom = this.bpe.getMap();
        this.bpd.setOnGetGeoCodeResultListener(this);
        this.bom.setOnMapLoadedCallback(this);
        this.bom.setOnMapStatusChangeListener(this);
        this.boU.setLayoutManager(new LinearLayoutManager(com.baidu.swan.apps.w.e.GJ().Gv()));
        this.bpj = new b(com.baidu.swan.apps.w.e.GJ().Gv(), this.boU, this, false);
        this.boU.setAdapter(this.bpj);
        this.boU.addItemDecoration(new f(com.baidu.swan.apps.w.e.GJ().Gv(), true));
        this.bpk = new h(this.boW, this.boX, this.boV);
        ((FlipperFrameLayout) this.boW).setViewFlipper(this.bpk);
    }

    private void f(LatLng latLng) {
        this.bpd.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void UX() {
        this.bom.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.bom.getUiSettings().setRotateGesturesEnabled(false);
        this.bpe.showZoomControls(false);
        this.bpe.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!Vb()) {
            US();
        }
    }

    private void US() {
        this.bpi = new i(com.baidu.swan.apps.w.e.GJ().Gv(), this.bom);
        this.bpi.cW(true);
        this.bpi.a(this);
        cY(true);
    }

    private void UY() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bpb, "translationY", 0.0f, -bpp, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.bpo != null) {
            poiInfo.name = this.bpo.mName;
            poiInfo.location = new LatLng(this.bpo.mLatitude, this.bpo.mLongitude);
            poiInfo.address = this.bpo.mAddress;
            this.bpo = null;
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
        this.bph.clear();
        this.bph.add(gVar);
        this.bph.addAll(g.F(reverseGeoCodeResult.getPoiList()));
        this.bpj.setData(this.bph);
        this.bpg = gVar;
        if (this.bph.size() > 0) {
            cY(false);
        }
    }

    private void cY(boolean z) {
        if (z) {
            this.bph.clear();
            this.bpj.setData(this.bph);
        }
        this.bpc.setVisibility(z ? 0 : 8);
    }

    private void a(LatLng latLng, boolean z, boolean z2) {
        cY(true);
        f(latLng);
        UZ();
        if (z) {
            UY();
            if (this.bpk.Vg()) {
                this.bpk.dd(false);
            }
        }
        if (z2) {
            this.boU.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            if (this.bpi != null && this.bpi.Uz() != null) {
                BDLocation Uz = this.bpi.Uz();
                LatLng latLng = new LatLng(Uz.getLatitude(), Uz.getLongitude());
                this.bom.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                UZ();
                if (this.bpm) {
                    a(latLng, true, true);
                    this.bpm = false;
                }
                cZ(true);
            }
        } else if (view.getId() == R.id.finish) {
            fs(16);
            Va();
        } else if (view.getId() == R.id.search) {
            b(this.bpg);
        } else if (view.getId() == R.id.cancel) {
            fs(17);
            Va();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        if (gVar != null && gVar.bpE != null && gVar.bpE.location != null) {
            this.bpg = gVar;
            this.bom.animateMapStatus(MapStatusUpdateFactory.newLatLng(gVar.bpE.location));
            UZ();
            if (this.bpf == null) {
                this.bpf = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
            }
            if (!gVar.bpF) {
                this.bon = (Marker) this.bom.addOverlay(new MarkerOptions().position(gVar.bpE.location).zIndex(88).icon(this.bpf));
            }
            if (!gVar.bpF) {
                cZ(false);
            }
        }
    }

    private void UZ() {
        if (this.bon != null) {
            this.bon.remove();
            this.bon = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.boU.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.a.1
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
                    SelectedLocationInfo selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra("SelectedLocationInfo");
                    if (selectedLocationInfo != null) {
                        double d = selectedLocationInfo.mLatitude;
                        double d2 = selectedLocationInfo.mLongitude;
                        if (!Double.isNaN(d) && !Double.isNaN(d2)) {
                            this.bpo = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.bom.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.bpm = true;
                            a(latLng, false, true);
                            cZ(false);
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

    private void fs(int i) {
        if (this.bpn != null) {
            switch (i) {
                case 16:
                    if (this.bpg != null) {
                        PoiInfo poiInfo = this.bpg.bpE;
                        if (TextUtils.equals(poiInfo.name, "[位置]")) {
                            poiInfo.name = "";
                        }
                        this.bpn.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.bpn.onCancel();
                    return;
                case 18:
                    this.bpn.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void Va() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.bpn = null;
    }

    private void cZ(boolean z) {
        if (this.bov != null) {
            this.bov.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar.bpE != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", gVar.bpE.city);
            com.baidu.swan.impl.map.location.search.a C = com.baidu.swan.impl.map.location.search.a.C(bundle);
            C.a(this, 1);
            C.UO();
        }
    }

    private boolean Vb() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.swan.apps.w.e.GJ().Gv().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
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
                com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.w.e.GJ().Gv(), R.string.aiapps_location_permission_fail).LU();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                US();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bpe.onResume();
        if (this.bpi != null) {
            this.bpi.cW(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bpe.onPause();
        if (this.bpi != null) {
            this.bpi.cW(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.bpe.onDestroy();
        }
        this.bpd.destroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xt() {
        fs(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        f(this.bom.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.bpl = i == 1;
        if (this.bpl || this.bpm) {
            z = true;
        }
        this.bpm = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.bpl) {
            a(mapStatus.target, true, true);
            cZ(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean zA() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zy() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zz() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xH() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void O(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
