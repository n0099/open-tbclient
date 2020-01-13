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
/* loaded from: classes10.dex */
public class a extends b implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bnn = "";
    private TextureMapView crH;
    private BaiduMap crI;
    private Marker crJ;
    private ImageView crK;
    private TextView crL;
    private TextView crM;
    private GeoCoder crN;
    private PopupWindow crO;
    private OpenLocationBottomMenu crP;
    private View crQ;
    private ImageView crR;
    private c crS;
    private BDLocation crT;
    private boolean crU;
    private ArrayList<String> crV;
    private String mAddress;
    private String mName;

    public static a T(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.ape();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        ae(inflate);
        cj(Ls());
        setRightZoneVisibility(false);
        aF(inflate);
        aG(inflate);
        apH();
        aH(inflate);
        gE(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void aF(View view) {
        this.crH = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.crI = this.crH.getMap();
        this.crI.getUiSettings().setRotateGesturesEnabled(false);
        this.crH.showZoomControls(false);
        this.crI.getUiSettings().setOverlookingGesturesEnabled(false);
        this.crI.setOnMapLoadedCallback(this);
    }

    private void apC() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.bnn = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString(SlideActiviy.ADDRESS_PAGE_NAME);
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.crI.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.crI.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.crJ = (Marker) this.crI.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.crL != null) {
                this.crL.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.crM != null) {
                this.crM.setText(this.mAddress);
            }
            this.crV = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void apD() {
        e El = f.UC().El();
        if (El != null) {
            El.gM("navigateTo").Y(e.bjU, e.bjW).e(this).Mj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Lf() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Gt() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void GR() {
        if (this.bjm == null) {
            this.bjm = new h(getContext(), this.bjl, 12, com.baidu.swan.apps.w.a.RK(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bjm, this).VU();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void LB() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.bnn);
        f.UC().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Le() {
        GR();
        this.bjm.h(com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState(), Ly());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean GO() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        apC();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.crJ && !TextUtils.isEmpty(this.mName)) {
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
            this.crI.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aG(View view) {
        this.crQ = view;
        this.crK = (ImageView) view.findViewById(R.id.location_icon_path);
        this.crK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.apE();
            }
        });
        this.crL = (TextView) view.findViewById(R.id.location_text_position);
        this.crM = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.crN != null) {
            this.crN.destroy();
        }
        OpenLocationBottomMenu.aqs();
        if (this.crS != null) {
            this.crS.eD(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.crH.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.crN = GeoCoder.newInstance();
        this.crN.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.crL.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.crM != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.crM.setText(a.this.mAddress);
                }
                if (a.this.crL != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.crL.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + HanziToPinyin.Token.SEPARATOR + "mName" + a.this.mName);
            }
        });
        this.crN.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apE() {
        FragmentActivity ask = ask();
        if (ask != null) {
            if (this.crO == null || !this.crO.isShowing()) {
                View inflate = View.inflate(ask, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.apF();
                    }
                });
                this.crP = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.crP.setFragment(this);
                this.crO = new PopupWindow(ask);
                this.crO.setContentView(inflate);
                this.crO.setWidth(-1);
                this.crO.setHeight(-2);
                this.crO.setBackgroundDrawable(new BitmapDrawable());
                this.crO.setFocusable(true);
                this.crO.setOutsideTouchable(true);
                this.crO.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.crO.showAtLocation(this.crQ, 80, 0, 0);
                this.crO.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.ad(1.0f);
                    }
                });
                ad(0.3f);
            }
        }
    }

    public void apF() {
        if (this.crO != null && this.crO.isShowing()) {
            this.crO.dismiss();
        }
    }

    public BaiduMap apG() {
        return this.crI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(float f) {
        if (ask() != null) {
            Window window = ask().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aH(View view) {
        this.crR = (ImageView) view.findViewById(R.id.goMyPoint);
        this.crR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.crS != null && a.this.crS.apl() != null) {
                    BDLocation apl = a.this.crS.apl();
                    a.this.crI.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(apl.getLatitude(), apl.getLongitude())));
                }
            }
        });
    }

    private void apH() {
        this.crS = new c(f.UC().Un(), this.crI);
        this.crS.eD(true);
        this.crS.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void d(BDLocation bDLocation) {
                a.this.crT = bDLocation;
            }
        });
    }

    public BDLocation apI() {
        return this.crT;
    }

    public void eE(boolean z) {
        this.crU = z;
    }

    public boolean apJ() {
        return this.crU;
    }

    public List<String> apK() {
        return this.crV;
    }
}
