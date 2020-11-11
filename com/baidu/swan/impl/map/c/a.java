package com.baidu.swan.impl.map.c;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.impl.map.f.c;
import com.baidu.swan.impl.map.view.OpenLocationBottomMenu;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.menu.h;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes25.dex */
public class a extends c implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = b.DEBUG;
    private String cMh = "";
    private TextureMapView eda;
    private BaiduMap edb;
    private Marker edc;
    private ImageView edd;
    private TextView ede;
    private TextView edf;
    private GeoCoder edg;
    private PopupWindow edh;
    private OpenLocationBottomMenu edi;
    private View edj;
    private ImageView edk;
    private com.baidu.swan.impl.map.f.c edl;
    private BDLocation edm;
    private boolean edn;
    private ArrayList<String> edo;
    private String mAddress;
    private String mName;

    public static a Z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.aZc();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        ar(inflate);
        eM(aop());
        setRightZoneVisibility(false);
        aU(inflate);
        aV(inflate);
        aZE();
        aW(inflate);
        mU(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void aU(View view) {
        this.eda = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.edb = this.eda.getMap();
        this.edb.getUiSettings().setRotateGesturesEnabled(false);
        this.eda.showZoomControls(false);
        this.edb.getUiSettings().setOverlookingGesturesEnabled(false);
        this.edb.setOnMapLoadedCallback(this);
    }

    private void aZz() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.cMh = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.edb.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.edb.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.edc = (Marker) this.edb.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.ede != null) {
                this.ede.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.edf != null) {
                this.edf.setText(this.mAddress);
            }
            this.edo = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void aZA() {
        f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM != null) {
            afM.nb("navigateTo").al(f.cKS, f.cKU).f(this).apn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean anQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiB() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aji() {
        if (this.cKc == null) {
            this.cKc = new h(getContext(), this.cKb, 12, com.baidu.swan.apps.t.a.awE(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cKc, this).aBD();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void anT() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cMh);
        com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anP() {
        aji();
        this.cKc.o(com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState(), aoy());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajc() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        aZz();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.edc && !TextUtils.isEmpty(this.mName)) {
            LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
            linearLayout.setOrientation(1);
            TextView textView = new TextView(AppRuntime.getAppContext());
            textView.setText(this.mName);
            textView.setTextSize(18.0f);
            TextView textView2 = new TextView(AppRuntime.getAppContext());
            textView2.setText(this.mAddress);
            textView2.setTextSize(15.0f);
            linearLayout.addView(textView);
            linearLayout.addView(textView2);
            this.edb.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aV(View view) {
        this.edj = view;
        this.edd = (ImageView) view.findViewById(R.id.location_icon_path);
        this.edd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aZB();
            }
        });
        this.ede = (TextView) view.findViewById(R.id.location_text_position);
        this.edf = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.edg != null) {
            this.edg.destroy();
        }
        OpenLocationBottomMenu.bao();
        if (this.edl != null) {
            this.edl.hH(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.eda.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.edg = GeoCoder.newInstance();
        this.edg.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.ede.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.edf != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.edf.setText(a.this.mAddress);
                }
                if (a.this.ede != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.ede.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.edg.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZB() {
        FragmentActivity bcH = bcH();
        if (bcH != null) {
            if (this.edh == null || !this.edh.isShowing()) {
                View inflate = View.inflate(bcH, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aZC();
                    }
                });
                this.edi = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.edi.setFragment(this);
                this.edh = new PopupWindow(bcH);
                this.edh.setContentView(inflate);
                this.edh.setWidth(-1);
                this.edh.setHeight(-2);
                this.edh.setBackgroundDrawable(new BitmapDrawable());
                this.edh.setFocusable(true);
                this.edh.setOutsideTouchable(true);
                this.edh.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.edh.showAtLocation(this.edj, 80, 0, 0);
                this.edh.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.Y(1.0f);
                    }
                });
                Y(0.3f);
            }
        }
    }

    public void aZC() {
        if (this.edh != null && this.edh.isShowing()) {
            this.edh.dismiss();
        }
    }

    public BaiduMap aZD() {
        return this.edb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(float f) {
        if (bcH() != null) {
            Window window = bcH().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aW(View view) {
        this.edk = (ImageView) view.findViewById(R.id.goMyPoint);
        this.edk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.edl != null && a.this.edl.aZi() != null) {
                    BDLocation aZi = a.this.edl.aZi();
                    a.this.edb.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(aZi.getLatitude(), aZi.getLongitude())));
                }
            }
        });
    }

    private void aZE() {
        this.edl = new com.baidu.swan.impl.map.f.c(com.baidu.swan.apps.v.f.azO().azy(), this.edb);
        this.edl.hH(true);
        this.edl.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void e(BDLocation bDLocation) {
                a.this.edm = bDLocation;
            }
        });
    }

    public BDLocation aZF() {
        return this.edm;
    }

    public void hI(boolean z) {
        this.edn = z;
    }

    public boolean aZG() {
        return this.edn;
    }

    public List<String> aZH() {
        return this.edo;
    }
}
