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
    private String cGo = "";
    private TextureMapView dXj;
    private BaiduMap dXk;
    private Marker dXl;
    private ImageView dXm;
    private TextView dXn;
    private TextView dXo;
    private GeoCoder dXp;
    private PopupWindow dXq;
    private OpenLocationBottomMenu dXr;
    private View dXs;
    private ImageView dXt;
    private com.baidu.swan.impl.map.f.c dXu;
    private BDLocation dXv;
    private boolean dXw;
    private ArrayList<String> dXx;
    private String mAddress;
    private String mName;

    public static a Z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.aWC();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        an(inflate);
        eD(alP());
        setRightZoneVisibility(false);
        aQ(inflate);
        aR(inflate);
        aXe();
        aS(inflate);
        mF(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void aQ(View view) {
        this.dXj = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dXk = this.dXj.getMap();
        this.dXk.getUiSettings().setRotateGesturesEnabled(false);
        this.dXj.showZoomControls(false);
        this.dXk.getUiSettings().setOverlookingGesturesEnabled(false);
        this.dXk.setOnMapLoadedCallback(this);
    }

    private void aWZ() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.cGo = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.dXk.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.dXk.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.dXl = (Marker) this.dXk.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.dXn != null) {
                this.dXn.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.dXo != null) {
                this.dXo.setText(this.mAddress);
            }
            this.dXx = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void aXa() {
        f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm != null) {
            adm.mM("navigateTo").al(f.cEZ, f.cFb).f(this).amM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean alq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agI() {
        if (this.cEj == null) {
            this.cEj = new h(getContext(), this.cEi, 12, com.baidu.swan.apps.t.a.aue(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cEj, this).azd();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void alt() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cGo);
        com.baidu.swan.apps.v.f.axo().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alp() {
        agI();
        this.cEj.o(com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState(), alY());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean agC() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        aWZ();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.dXl && !TextUtils.isEmpty(this.mName)) {
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
            this.dXk.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aR(View view) {
        this.dXs = view;
        this.dXm = (ImageView) view.findViewById(R.id.location_icon_path);
        this.dXm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aXb();
            }
        });
        this.dXn = (TextView) view.findViewById(R.id.location_text_position);
        this.dXo = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dXp != null) {
            this.dXp.destroy();
        }
        OpenLocationBottomMenu.aXO();
        if (this.dXu != null) {
            this.dXu.hy(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.dXj.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.dXp = GeoCoder.newInstance();
        this.dXp.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.dXn.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.dXo != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.dXo.setText(a.this.mAddress);
                }
                if (a.this.dXn != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.dXn.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.dXp.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXb() {
        FragmentActivity bah = bah();
        if (bah != null) {
            if (this.dXq == null || !this.dXq.isShowing()) {
                View inflate = View.inflate(bah, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aXc();
                    }
                });
                this.dXr = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.dXr.setFragment(this);
                this.dXq = new PopupWindow(bah);
                this.dXq.setContentView(inflate);
                this.dXq.setWidth(-1);
                this.dXq.setHeight(-2);
                this.dXq.setBackgroundDrawable(new BitmapDrawable());
                this.dXq.setFocusable(true);
                this.dXq.setOutsideTouchable(true);
                this.dXq.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.dXq.showAtLocation(this.dXs, 80, 0, 0);
                this.dXq.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.W(1.0f);
                    }
                });
                W(0.3f);
            }
        }
    }

    public void aXc() {
        if (this.dXq != null && this.dXq.isShowing()) {
            this.dXq.dismiss();
        }
    }

    public BaiduMap aXd() {
        return this.dXk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(float f) {
        if (bah() != null) {
            Window window = bah().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aS(View view) {
        this.dXt = (ImageView) view.findViewById(R.id.goMyPoint);
        this.dXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dXu != null && a.this.dXu.aWI() != null) {
                    BDLocation aWI = a.this.dXu.aWI();
                    a.this.dXk.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(aWI.getLatitude(), aWI.getLongitude())));
                }
            }
        });
    }

    private void aXe() {
        this.dXu = new com.baidu.swan.impl.map.f.c(com.baidu.swan.apps.v.f.axo().awY(), this.dXk);
        this.dXu.hy(true);
        this.dXu.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void e(BDLocation bDLocation) {
                a.this.dXv = bDLocation;
            }
        });
    }

    public BDLocation aXf() {
        return this.dXv;
    }

    public void hz(boolean z) {
        this.dXw = z;
    }

    public boolean aXg() {
        return this.dXw;
    }

    public List<String> aXh() {
        return this.dXx;
    }
}
