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
/* loaded from: classes19.dex */
public class a extends c implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = b.DEBUG;
    private String cjv = "";
    private TextureMapView dAG;
    private BaiduMap dAH;
    private Marker dAI;
    private ImageView dAJ;
    private TextView dAK;
    private TextView dAL;
    private GeoCoder dAM;
    private PopupWindow dAN;
    private OpenLocationBottomMenu dAO;
    private View dAP;
    private ImageView dAQ;
    private com.baidu.swan.impl.map.f.c dAR;
    private BDLocation dAS;
    private boolean dAT;
    private ArrayList<String> dAU;
    private String mAddress;
    private String mName;

    public static a Z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.aRn();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        ai(inflate);
        dV(agA());
        setRightZoneVisibility(false);
        aM(inflate);
        aN(inflate);
        aRP();
        aO(inflate);
        lg(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void aM(View view) {
        this.dAG = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dAH = this.dAG.getMap();
        this.dAH.getUiSettings().setRotateGesturesEnabled(false);
        this.dAG.showZoomControls(false);
        this.dAH.getUiSettings().setOverlookingGesturesEnabled(false);
        this.dAH.setOnMapLoadedCallback(this);
    }

    private void aRK() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.cjv = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.dAH.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.dAH.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.dAI = (Marker) this.dAH.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.dAK != null) {
                this.dAK.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.dAL != null) {
                this.dAL.setText(this.mAddress);
            }
            this.dAU = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void aRL() {
        f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX != null) {
            XX.ln("navigateTo").al(f.cig, f.cii).f(this).ahx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void abt() {
        if (this.chp == null) {
            this.chp = new h(getContext(), this.cho, 12, com.baidu.swan.apps.t.a.aoN(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.chp, this).atP();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void age() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cjv);
        com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aga() {
        abt();
        this.chp.n(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState(), agJ());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abn() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        aRK();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.dAI && !TextUtils.isEmpty(this.mName)) {
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
            this.dAH.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aN(View view) {
        this.dAP = view;
        this.dAJ = (ImageView) view.findViewById(R.id.location_icon_path);
        this.dAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aRM();
            }
        });
        this.dAK = (TextView) view.findViewById(R.id.location_text_position);
        this.dAL = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dAM != null) {
            this.dAM.destroy();
        }
        OpenLocationBottomMenu.aSA();
        if (this.dAR != null) {
            this.dAR.gQ(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.dAG.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.dAM = GeoCoder.newInstance();
        this.dAM.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.dAK.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.dAL != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.dAL.setText(a.this.mAddress);
                }
                if (a.this.dAK != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.dAK.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.dAM.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRM() {
        FragmentActivity aUT = aUT();
        if (aUT != null) {
            if (this.dAN == null || !this.dAN.isShowing()) {
                View inflate = View.inflate(aUT, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aRN();
                    }
                });
                this.dAO = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.dAO.setFragment(this);
                this.dAN = new PopupWindow(aUT);
                this.dAN.setContentView(inflate);
                this.dAN.setWidth(-1);
                this.dAN.setHeight(-2);
                this.dAN.setBackgroundDrawable(new BitmapDrawable());
                this.dAN.setFocusable(true);
                this.dAN.setOutsideTouchable(true);
                this.dAN.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.dAN.showAtLocation(this.dAP, 80, 0, 0);
                this.dAN.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.S(1.0f);
                    }
                });
                S(0.3f);
            }
        }
    }

    public void aRN() {
        if (this.dAN != null && this.dAN.isShowing()) {
            this.dAN.dismiss();
        }
    }

    public BaiduMap aRO() {
        return this.dAH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(float f) {
        if (aUT() != null) {
            Window window = aUT().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aO(View view) {
        this.dAQ = (ImageView) view.findViewById(R.id.goMyPoint);
        this.dAQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dAR != null && a.this.dAR.aRt() != null) {
                    BDLocation aRt = a.this.dAR.aRt();
                    a.this.dAH.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(aRt.getLatitude(), aRt.getLongitude())));
                }
            }
        });
    }

    private void aRP() {
        this.dAR = new com.baidu.swan.impl.map.f.c(com.baidu.swan.apps.v.f.arY().arI(), this.dAH);
        this.dAR.gQ(true);
        this.dAR.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void e(BDLocation bDLocation) {
                a.this.dAS = bDLocation;
            }
        });
    }

    public BDLocation aRQ() {
        return this.dAS;
    }

    public void gR(boolean z) {
        this.dAT = z;
    }

    public boolean aRR() {
        return this.dAT;
    }

    public List<String> aRS() {
        return this.dAU;
    }
}
