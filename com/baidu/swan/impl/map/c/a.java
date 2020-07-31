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
    private String cgh = "";
    private TextureMapView dqE;
    private BaiduMap dqF;
    private Marker dqG;
    private ImageView dqH;
    private TextView dqI;
    private TextView dqJ;
    private GeoCoder dqK;
    private PopupWindow dqL;
    private OpenLocationBottomMenu dqM;
    private View dqN;
    private ImageView dqO;
    private com.baidu.swan.impl.map.f.c dqP;
    private BDLocation dqQ;
    private boolean dqR;
    private ArrayList<String> dqS;
    private String mAddress;
    private String mName;

    public static a aa(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.aIx();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        ah(inflate);
        dL(aaq());
        setRightZoneVisibility(false);
        aK(inflate);
        aL(inflate);
        aIZ();
        aM(inflate);
        jH(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void aK(View view) {
        this.dqE = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dqF = this.dqE.getMap();
        this.dqF.getUiSettings().setRotateGesturesEnabled(false);
        this.dqE.showZoomControls(false);
        this.dqF.getUiSettings().setOverlookingGesturesEnabled(false);
        this.dqF.setOnMapLoadedCallback(this);
    }

    private void aIU() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.cgh = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.dqF.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.dqF.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.dqG = (Marker) this.dqF.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.dqI != null) {
                this.dqI.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.dqJ != null) {
                this.dqJ.setText(this.mAddress);
            }
            this.dqS = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void aIV() {
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null) {
            Sc.jO("navigateTo").ag(f.cci, f.cck).f(this).abl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ZR() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean UJ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void Vn() {
        if (this.cbu == null) {
            this.cbu = new h(getContext(), this.cbt, 12, com.baidu.swan.apps.t.a.ahn(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.x.a(this.cbu, this).amc();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void ZU() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cgh);
        com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ZQ() {
        Vn();
        this.cbu.n(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState(), aaz());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean Vi() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        aIU();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.dqG && !TextUtils.isEmpty(this.mName)) {
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
            this.dqF.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aL(View view) {
        this.dqN = view;
        this.dqH = (ImageView) view.findViewById(R.id.location_icon_path);
        this.dqH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aIW();
            }
        });
        this.dqI = (TextView) view.findViewById(R.id.location_text_position);
        this.dqJ = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dqK != null) {
            this.dqK.destroy();
        }
        OpenLocationBottomMenu.aJK();
        if (this.dqP != null) {
            this.dqP.gu(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.dqE.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.dqK = GeoCoder.newInstance();
        this.dqK.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.dqI.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.dqJ != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.dqJ.setText(a.this.mAddress);
                }
                if (a.this.dqI != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.dqI.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.dqK.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIW() {
        FragmentActivity aMt = aMt();
        if (aMt != null) {
            if (this.dqL == null || !this.dqL.isShowing()) {
                View inflate = View.inflate(aMt, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aIX();
                    }
                });
                this.dqM = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.dqM.setFragment(this);
                this.dqL = new PopupWindow(aMt);
                this.dqL.setContentView(inflate);
                this.dqL.setWidth(-1);
                this.dqL.setHeight(-2);
                this.dqL.setBackgroundDrawable(new BitmapDrawable());
                this.dqL.setFocusable(true);
                this.dqL.setOutsideTouchable(true);
                this.dqL.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.dqL.showAtLocation(this.dqN, 80, 0, 0);
                this.dqL.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.N(1.0f);
                    }
                });
                N(0.3f);
            }
        }
    }

    public void aIX() {
        if (this.dqL != null && this.dqL.isShowing()) {
            this.dqL.dismiss();
        }
    }

    public BaiduMap aIY() {
        return this.dqF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(float f) {
        if (aMt() != null) {
            Window window = aMt().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aM(View view) {
        this.dqO = (ImageView) view.findViewById(R.id.goMyPoint);
        this.dqO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dqP != null && a.this.dqP.aID() != null) {
                    BDLocation aID = a.this.dqP.aID();
                    a.this.dqF.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(aID.getLatitude(), aID.getLongitude())));
                }
            }
        });
    }

    private void aIZ() {
        this.dqP = new com.baidu.swan.impl.map.f.c(com.baidu.swan.apps.v.f.akr().akb(), this.dqF);
        this.dqP.gu(true);
        this.dqP.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void d(BDLocation bDLocation) {
                a.this.dqQ = bDLocation;
            }
        });
    }

    public BDLocation aJa() {
        return this.dqQ;
    }

    public void gv(boolean z) {
        this.dqR = z;
    }

    public boolean aJb() {
        return this.dqR;
    }

    public List<String> aJc() {
        return this.dqS;
    }
}
