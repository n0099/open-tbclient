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
    private String cKx = "";
    private OpenLocationBottomMenu ebA;
    private View ebB;
    private ImageView ebC;
    private com.baidu.swan.impl.map.f.c ebD;
    private BDLocation ebE;
    private boolean ebF;
    private ArrayList<String> ebG;
    private TextureMapView ebs;
    private BaiduMap ebt;
    private Marker ebu;
    private ImageView ebv;
    private TextView ebw;
    private TextView ebx;
    private GeoCoder eby;
    private PopupWindow ebz;
    private String mAddress;
    private String mName;

    public static a Z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.aYv();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        ar(inflate);
        eP(anH());
        setRightZoneVisibility(false);
        aU(inflate);
        aV(inflate);
        aYX();
        aW(inflate);
        mO(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
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
        this.ebs = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.ebt = this.ebs.getMap();
        this.ebt.getUiSettings().setRotateGesturesEnabled(false);
        this.ebs.showZoomControls(false);
        this.ebt.getUiSettings().setOverlookingGesturesEnabled(false);
        this.ebt.setOnMapLoadedCallback(this);
    }

    private void aYS() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.cKx = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.ebt.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.ebt.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.ebu = (Marker) this.ebt.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.ebw != null) {
                this.ebw.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.ebx != null) {
                this.ebx.setText(this.mAddress);
            }
            this.ebG = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void aYT() {
        f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe != null) {
            afe.mV("navigateTo").al(f.cJi, f.cJk).f(this).aoE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ani() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ahT() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiA() {
        if (this.cIs == null) {
            this.cIs = new h(getContext(), this.cIr, 12, com.baidu.swan.apps.t.a.avW(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cIs, this).aAV();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void anl() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cKx);
        com.baidu.swan.apps.v.f.azg().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anh() {
        aiA();
        this.cIs.o(com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState(), anQ());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiu() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        aYS();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.ebu && !TextUtils.isEmpty(this.mName)) {
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
            this.ebt.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aV(View view) {
        this.ebB = view;
        this.ebv = (ImageView) view.findViewById(R.id.location_icon_path);
        this.ebv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aYU();
            }
        });
        this.ebw = (TextView) view.findViewById(R.id.location_text_position);
        this.ebx = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eby != null) {
            this.eby.destroy();
        }
        OpenLocationBottomMenu.aZH();
        if (this.ebD != null) {
            this.ebD.hK(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.ebs.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.eby = GeoCoder.newInstance();
        this.eby.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.ebw.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.ebx != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.ebx.setText(a.this.mAddress);
                }
                if (a.this.ebw != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.ebw.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.eby.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYU() {
        FragmentActivity bca = bca();
        if (bca != null) {
            if (this.ebz == null || !this.ebz.isShowing()) {
                View inflate = View.inflate(bca, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aYV();
                    }
                });
                this.ebA = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.ebA.setFragment(this);
                this.ebz = new PopupWindow(bca);
                this.ebz.setContentView(inflate);
                this.ebz.setWidth(-1);
                this.ebz.setHeight(-2);
                this.ebz.setBackgroundDrawable(new BitmapDrawable());
                this.ebz.setFocusable(true);
                this.ebz.setOutsideTouchable(true);
                this.ebz.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.ebz.showAtLocation(this.ebB, 80, 0, 0);
                this.ebz.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.X(1.0f);
                    }
                });
                X(0.3f);
            }
        }
    }

    public void aYV() {
        if (this.ebz != null && this.ebz.isShowing()) {
            this.ebz.dismiss();
        }
    }

    public BaiduMap aYW() {
        return this.ebt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(float f) {
        if (bca() != null) {
            Window window = bca().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aW(View view) {
        this.ebC = (ImageView) view.findViewById(R.id.goMyPoint);
        this.ebC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.ebD != null && a.this.ebD.aYB() != null) {
                    BDLocation aYB = a.this.ebD.aYB();
                    a.this.ebt.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(aYB.getLatitude(), aYB.getLongitude())));
                }
            }
        });
    }

    private void aYX() {
        this.ebD = new com.baidu.swan.impl.map.f.c(com.baidu.swan.apps.v.f.azg().ayQ(), this.ebt);
        this.ebD.hK(true);
        this.ebD.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void e(BDLocation bDLocation) {
                a.this.ebE = bDLocation;
            }
        });
    }

    public BDLocation aYY() {
        return this.ebE;
    }

    public void hL(boolean z) {
        this.ebF = z;
    }

    public boolean aYZ() {
        return this.ebF;
    }

    public List<String> aZa() {
        return this.ebG;
    }
}
