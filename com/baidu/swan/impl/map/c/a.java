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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
import com.baidu.sapi2.activity.SlideActiviy;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.d.b;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.impl.map.f.c;
import com.baidu.swan.impl.map.view.OpenLocationBottomMenu;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.menu.h;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends b implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bmz = "";
    private TextView crA;
    private TextView crB;
    private GeoCoder crC;
    private PopupWindow crD;
    private OpenLocationBottomMenu crE;
    private View crF;
    private ImageView crG;
    private c crH;
    private BDLocation crI;
    private boolean crJ;
    private ArrayList<String> crK;
    private TextureMapView crw;
    private BaiduMap crx;
    private Marker cry;
    private ImageView crz;
    private String mAddress;
    private String mName;

    public static a T(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.aoL();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        aa(inflate);
        ce(KW());
        setRightZoneVisibility(false);
        aB(inflate);
        aC(inflate);
        apo();
        aD(inflate);
        gB(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void aB(View view) {
        this.crw = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.crx = this.crw.getMap();
        this.crx.getUiSettings().setRotateGesturesEnabled(false);
        this.crw.showZoomControls(false);
        this.crx.getUiSettings().setOverlookingGesturesEnabled(false);
        this.crx.setOnMapLoadedCallback(this);
    }

    private void apj() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.bmz = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString(SlideActiviy.ADDRESS_PAGE_NAME);
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.crx.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.crx.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.cry = (Marker) this.crx.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.crA != null) {
                this.crA.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.crB != null) {
                this.crB.setText(this.mAddress);
            }
            this.crK = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void apk() {
        e DP = f.Uf().DP();
        if (DP != null) {
            DP.gJ("navigateTo").U(e.bjf, e.bjh).e(this).LN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean KJ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean FX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Gv() {
        if (this.bix == null) {
            this.bix = new h(getContext(), this.biw, 12, com.baidu.swan.apps.w.a.Ro(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bix, this).Vx();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void Lf() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.bmz);
        f.Uf().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void KI() {
        Gv();
        this.bix.g(com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState(), Lc());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Gs() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        apj();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.cry && !TextUtils.isEmpty(this.mName)) {
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
            this.crx.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aC(View view) {
        this.crF = view;
        this.crz = (ImageView) view.findViewById(R.id.location_icon_path);
        this.crz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.apl();
            }
        });
        this.crA = (TextView) view.findViewById(R.id.location_text_position);
        this.crB = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.crC != null) {
            this.crC.destroy();
        }
        OpenLocationBottomMenu.apZ();
        if (this.crH != null) {
            this.crH.ey(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.crw.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.crC = GeoCoder.newInstance();
        this.crC.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.crA.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.crB != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.crB.setText(a.this.mAddress);
                }
                if (a.this.crA != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.crA.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + HanziToPinyin.Token.SEPARATOR + "mName" + a.this.mName);
            }
        });
        this.crC.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apl() {
        FragmentActivity arR = arR();
        if (arR != null) {
            if (this.crD == null || !this.crD.isShowing()) {
                View inflate = View.inflate(arR, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.apm();
                    }
                });
                this.crE = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.crE.setFragment(this);
                this.crD = new PopupWindow(arR);
                this.crD.setContentView(inflate);
                this.crD.setWidth(-1);
                this.crD.setHeight(-2);
                this.crD.setBackgroundDrawable(new BitmapDrawable());
                this.crD.setFocusable(true);
                this.crD.setOutsideTouchable(true);
                this.crD.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.crD.showAtLocation(this.crF, 80, 0, 0);
                this.crD.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.ae(1.0f);
                    }
                });
                ae(0.3f);
            }
        }
    }

    public void apm() {
        if (this.crD != null && this.crD.isShowing()) {
            this.crD.dismiss();
        }
    }

    public BaiduMap apn() {
        return this.crx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(float f) {
        if (arR() != null) {
            Window window = arR().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aD(View view) {
        this.crG = (ImageView) view.findViewById(R.id.goMyPoint);
        this.crG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.crH != null && a.this.crH.aoR() != null) {
                    BDLocation aoR = a.this.crH.aoR();
                    a.this.crx.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(aoR.getLatitude(), aoR.getLongitude())));
                }
            }
        });
    }

    private void apo() {
        this.crH = new c(f.Uf().TQ(), this.crx);
        this.crH.ey(true);
        this.crH.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void d(BDLocation bDLocation) {
                a.this.crI = bDLocation;
            }
        });
    }

    public BDLocation app() {
        return this.crI;
    }

    public void ez(boolean z) {
        this.crJ = z;
    }

    public boolean apq() {
        return this.crJ;
    }

    public List<String> apr() {
        return this.crK;
    }
}
