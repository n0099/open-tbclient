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
    private String cRq = "";
    private PopupWindow eiA;
    private OpenLocationBottomMenu eiB;
    private View eiC;
    private ImageView eiD;
    private com.baidu.swan.impl.map.f.c eiE;
    private BDLocation eiF;
    private boolean eiG;
    private ArrayList<String> eiH;
    private TextureMapView eit;
    private BaiduMap eiu;
    private Marker eiv;
    private ImageView eiw;
    private TextView eix;
    private TextView eiy;
    private GeoCoder eiz;
    private String mAddress;
    private String mName;

    public static a Z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.bbA();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        at(inflate);
        fe(aqP());
        setRightZoneVisibility(false);
        aW(inflate);
        aX(inflate);
        bcc();
        aY(inflate);
        nv(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void aW(View view) {
        this.eit = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.eiu = this.eit.getMap();
        this.eiu.getUiSettings().setRotateGesturesEnabled(false);
        this.eit.showZoomControls(false);
        this.eiu.getUiSettings().setOverlookingGesturesEnabled(false);
        this.eiu.setOnMapLoadedCallback(this);
    }

    private void bbX() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.cRq = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.eiu.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.eiu.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.eiv = (Marker) this.eiu.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.eix != null) {
                this.eix.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.eiy != null) {
                this.eiy.setText(this.mAddress);
            }
            this.eiH = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void bbY() {
        f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim != null) {
            aim.nC("navigateTo").an(f.cQb, f.cQd).f(this).arM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aqq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean alb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alI() {
        if (this.cPl == null) {
            this.cPl = new h(getContext(), this.cPk, 12, com.baidu.swan.apps.t.a.aze(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cPl, this).aEe();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aqt() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cRq);
        com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aqp() {
        alI();
        this.cPl.o(com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState(), aqY());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean alC() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        bbX();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.eiv && !TextUtils.isEmpty(this.mName)) {
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
            this.eiu.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aX(View view) {
        this.eiC = view;
        this.eiw = (ImageView) view.findViewById(R.id.location_icon_path);
        this.eiw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bbZ();
            }
        });
        this.eix = (TextView) view.findViewById(R.id.location_text_position);
        this.eiy = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eiz != null) {
            this.eiz.destroy();
        }
        OpenLocationBottomMenu.bcM();
        if (this.eiE != null) {
            this.eiE.hZ(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.eit.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.eiz = GeoCoder.newInstance();
        this.eiz.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.eix.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.eiy != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.eiy.setText(a.this.mAddress);
                }
                if (a.this.eix != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.eix.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.eiz.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbZ() {
        FragmentActivity bff = bff();
        if (bff != null) {
            if (this.eiA == null || !this.eiA.isShowing()) {
                View inflate = View.inflate(bff, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bca();
                    }
                });
                this.eiB = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.eiB.setFragment(this);
                this.eiA = new PopupWindow(bff);
                this.eiA.setContentView(inflate);
                this.eiA.setWidth(-1);
                this.eiA.setHeight(-2);
                this.eiA.setBackgroundDrawable(new BitmapDrawable());
                this.eiA.setFocusable(true);
                this.eiA.setOutsideTouchable(true);
                this.eiA.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.eiA.showAtLocation(this.eiC, 80, 0, 0);
                this.eiA.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.X(1.0f);
                    }
                });
                X(0.3f);
            }
        }
    }

    public void bca() {
        if (this.eiA != null && this.eiA.isShowing()) {
            this.eiA.dismiss();
        }
    }

    public BaiduMap bcb() {
        return this.eiu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(float f) {
        if (bff() != null) {
            Window window = bff().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aY(View view) {
        this.eiD = (ImageView) view.findViewById(R.id.goMyPoint);
        this.eiD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eiE != null && a.this.eiE.bbG() != null) {
                    BDLocation bbG = a.this.eiE.bbG();
                    a.this.eiu.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bbG.getLatitude(), bbG.getLongitude())));
                }
            }
        });
    }

    private void bcc() {
        this.eiE = new com.baidu.swan.impl.map.f.c(com.baidu.swan.apps.v.f.aCp().aBZ(), this.eiu);
        this.eiE.hZ(true);
        this.eiE.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void e(BDLocation bDLocation) {
                a.this.eiF = bDLocation;
            }
        });
    }

    public BDLocation bcd() {
        return this.eiF;
    }

    public void ia(boolean z) {
        this.eiG = z;
    }

    public boolean bce() {
        return this.eiG;
    }

    public List<String> bcf() {
        return this.eiH;
    }
}
