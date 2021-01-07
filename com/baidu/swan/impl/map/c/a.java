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
import com.baidu.swan.menu.g;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends c implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = b.DEBUG;
    private String cWn = "";
    private ImageView erA;
    private TextView erB;
    private TextView erC;
    private GeoCoder erD;
    private PopupWindow erE;
    private OpenLocationBottomMenu erF;
    private View erG;
    private ImageView erH;
    private com.baidu.swan.impl.map.f.c erI;
    private BDLocation erJ;
    private boolean erK;
    private ArrayList<String> erL;
    private TextureMapView erx;
    private BaiduMap ery;
    private Marker erz;
    private String mAddress;
    private String mName;

    public static a Z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.bdT();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        av(inflate);
        fn(asc());
        setRightZoneVisibility(false);
        bf(inflate);
        bg(inflate);
        bev();
        bh(inflate);
        no(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (asf()) {
            inflate = az(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void bf(View view) {
        this.erx = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.ery = this.erx.getMap();
        this.ery.getUiSettings().setRotateGesturesEnabled(false);
        this.erx.showZoomControls(false);
        this.ery.getUiSettings().setOverlookingGesturesEnabled(false);
        this.ery.setOnMapLoadedCallback(this);
    }

    private void beq() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.cWn = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.ery.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.ery.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.erz = (Marker) this.ery.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.erB != null) {
                this.erB.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.erC != null) {
                this.erC.setText(this.mAddress);
            }
            this.erL = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void ber() {
        f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt != null) {
            ajt.nv("navigateTo").ai(f.cUY, f.cVa).f(this).atf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean arD() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean amm() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void amT() {
        if (this.cUg == null) {
            this.cUg = new g(getContext(), this.cUf, 12, com.baidu.swan.apps.t.a.aAw(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cUg, this).aFy();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void arG() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cWn);
        com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void arC() {
        amT();
        this.cUg.n(com.baidu.swan.apps.t.a.aAO().alE(), asr());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean amN() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        beq();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.erz && !TextUtils.isEmpty(this.mName)) {
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
            this.ery.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void bg(View view) {
        this.erG = view;
        this.erA = (ImageView) view.findViewById(R.id.location_icon_path);
        this.erA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bes();
            }
        });
        this.erB = (TextView) view.findViewById(R.id.location_text_position);
        this.erC = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.erD != null) {
            this.erD.destroy();
        }
        OpenLocationBottomMenu.bfg();
        if (this.erI != null) {
            this.erI.ir(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.erx.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.erD = GeoCoder.newInstance();
        this.erD.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.erB.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.erC != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.erC.setText(a.this.mAddress);
                }
                if (a.this.erB != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.erB.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.erD.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bes() {
        FragmentActivity bhB = bhB();
        if (bhB != null) {
            if (this.erE == null || !this.erE.isShowing()) {
                View inflate = View.inflate(bhB, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bet();
                    }
                });
                this.erF = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.erF.setFragment(this);
                this.erE = new PopupWindow(bhB);
                this.erE.setContentView(inflate);
                this.erE.setWidth(-1);
                this.erE.setHeight(-2);
                this.erE.setBackgroundDrawable(new BitmapDrawable());
                this.erE.setFocusable(true);
                this.erE.eh(true);
                this.erE.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.erE.showAtLocation(this.erG, 80, 0, 0);
                this.erE.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.Z(1.0f);
                    }
                });
                Z(0.3f);
            }
        }
    }

    public void bet() {
        if (this.erE != null && this.erE.isShowing()) {
            this.erE.dismiss();
        }
    }

    public BaiduMap beu() {
        return this.ery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        if (bhB() != null) {
            Window window = bhB().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void bh(View view) {
        this.erH = (ImageView) view.findViewById(R.id.goMyPoint);
        this.erH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.erI != null && a.this.erI.bdZ() != null) {
                    BDLocation bdZ = a.this.erI.bdZ();
                    a.this.ery.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bdZ.getLatitude(), bdZ.getLongitude())));
                }
            }
        });
    }

    private void bev() {
        this.erI = new com.baidu.swan.impl.map.f.c(com.baidu.swan.apps.v.f.aDH().aDr(), this.ery);
        this.erI.ir(true);
        this.erI.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void e(BDLocation bDLocation) {
                a.this.erJ = bDLocation;
            }
        });
    }

    public BDLocation bew() {
        return this.erJ;
    }

    public void is(boolean z) {
        this.erK = z;
    }

    public boolean bex() {
        return this.erK;
    }

    public List<String> bey() {
        return this.erL;
    }
}
