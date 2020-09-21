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
/* loaded from: classes24.dex */
public class a extends c implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = b.DEBUG;
    private String clA = "";
    private TextureMapView dCL;
    private BaiduMap dCM;
    private Marker dCN;
    private ImageView dCO;
    private TextView dCP;
    private TextView dCQ;
    private GeoCoder dCR;
    private PopupWindow dCS;
    private OpenLocationBottomMenu dCT;
    private View dCU;
    private ImageView dCV;
    private com.baidu.swan.impl.map.f.c dCW;
    private BDLocation dCX;
    private boolean dCY;
    private ArrayList<String> dCZ;
    private String mAddress;
    private String mName;

    public static a Z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.aRZ();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        ak(inflate);
        dU(ahk());
        setRightZoneVisibility(false);
        aO(inflate);
        aP(inflate);
        aSB();
        aQ(inflate);
        lA(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void aO(View view) {
        this.dCL = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dCM = this.dCL.getMap();
        this.dCM.getUiSettings().setRotateGesturesEnabled(false);
        this.dCL.showZoomControls(false);
        this.dCM.getUiSettings().setOverlookingGesturesEnabled(false);
        this.dCM.setOnMapLoadedCallback(this);
    }

    private void aSw() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.clA = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.dCM.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.dCM.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.dCN = (Marker) this.dCM.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.dCP != null) {
                this.dCP.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.dCQ != null) {
                this.dCQ.setText(this.mAddress);
            }
            this.dCZ = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void aSx() {
        f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG != null) {
            YG.lH("navigateTo").al(f.ckl, f.ckn).f(this).aih();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean agL() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean abv() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void acc() {
        if (this.cjv == null) {
            this.cjv = new h(getContext(), this.cju, 12, com.baidu.swan.apps.t.a.apy(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cjv, this).auy();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void agO() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.clA);
        com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agK() {
        acc();
        this.cjv.n(com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState(), aht());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abW() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        aSw();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.dCN && !TextUtils.isEmpty(this.mName)) {
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
            this.dCM.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aP(View view) {
        this.dCU = view;
        this.dCO = (ImageView) view.findViewById(R.id.location_icon_path);
        this.dCO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aSy();
            }
        });
        this.dCP = (TextView) view.findViewById(R.id.location_text_position);
        this.dCQ = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dCR != null) {
            this.dCR.destroy();
        }
        OpenLocationBottomMenu.aTm();
        if (this.dCW != null) {
            this.dCW.gP(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.dCL.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.dCR = GeoCoder.newInstance();
        this.dCR.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.dCP.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.dCQ != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.dCQ.setText(a.this.mAddress);
                }
                if (a.this.dCP != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.dCP.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.dCR.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSy() {
        FragmentActivity aVF = aVF();
        if (aVF != null) {
            if (this.dCS == null || !this.dCS.isShowing()) {
                View inflate = View.inflate(aVF, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aSz();
                    }
                });
                this.dCT = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.dCT.setFragment(this);
                this.dCS = new PopupWindow(aVF);
                this.dCS.setContentView(inflate);
                this.dCS.setWidth(-1);
                this.dCS.setHeight(-2);
                this.dCS.setBackgroundDrawable(new BitmapDrawable());
                this.dCS.setFocusable(true);
                this.dCS.setOutsideTouchable(true);
                this.dCS.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.dCS.showAtLocation(this.dCU, 80, 0, 0);
                this.dCS.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.S(1.0f);
                    }
                });
                S(0.3f);
            }
        }
    }

    public void aSz() {
        if (this.dCS != null && this.dCS.isShowing()) {
            this.dCS.dismiss();
        }
    }

    public BaiduMap aSA() {
        return this.dCM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(float f) {
        if (aVF() != null) {
            Window window = aVF().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aQ(View view) {
        this.dCV = (ImageView) view.findViewById(R.id.goMyPoint);
        this.dCV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dCW != null && a.this.dCW.aSf() != null) {
                    BDLocation aSf = a.this.dCW.aSf();
                    a.this.dCM.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(aSf.getLatitude(), aSf.getLongitude())));
                }
            }
        });
    }

    private void aSB() {
        this.dCW = new com.baidu.swan.impl.map.f.c(com.baidu.swan.apps.v.f.asJ().ast(), this.dCM);
        this.dCW.gP(true);
        this.dCW.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void e(BDLocation bDLocation) {
                a.this.dCX = bDLocation;
            }
        });
    }

    public BDLocation aSC() {
        return this.dCX;
    }

    public void gQ(boolean z) {
        this.dCY = z;
    }

    public boolean aSD() {
        return this.dCY;
    }

    public List<String> aSE() {
        return this.dCZ;
    }
}
