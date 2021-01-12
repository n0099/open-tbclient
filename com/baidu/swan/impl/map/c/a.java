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
/* loaded from: classes8.dex */
public class a extends c implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = b.DEBUG;
    private String cRB = "";
    private TextureMapView emH;
    private BaiduMap emI;
    private Marker emJ;
    private ImageView emK;
    private TextView emL;
    private TextView emM;
    private GeoCoder emN;
    private PopupWindow emO;
    private OpenLocationBottomMenu emP;
    private View emQ;
    private ImageView emR;
    private com.baidu.swan.impl.map.f.c emS;
    private BDLocation emT;
    private boolean emU;
    private ArrayList<String> emV;
    private String mAddress;
    private String mName;

    public static a Z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.aZZ();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        av(inflate);
        fj(aoh());
        setRightZoneVisibility(false);
        bf(inflate);
        bg(inflate);
        baB();
        bh(inflate);
        md(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (aok()) {
            inflate = az(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void bf(View view) {
        this.emH = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.emI = this.emH.getMap();
        this.emI.getUiSettings().setRotateGesturesEnabled(false);
        this.emH.showZoomControls(false);
        this.emI.getUiSettings().setOverlookingGesturesEnabled(false);
        this.emI.setOnMapLoadedCallback(this);
    }

    private void baw() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.cRB = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.emI.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.emI.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.emJ = (Marker) this.emI.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.emL != null) {
                this.emL.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.emM != null) {
                this.emM.setText(this.mAddress);
            }
            this.emV = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void bax() {
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null) {
            afz.mk("navigateTo").ai(f.cQm, f.cQo).f(this).apk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean anI() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ais() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiZ() {
        if (this.cPu == null) {
            this.cPu = new g(getContext(), this.cPt, 12, com.baidu.swan.apps.t.a.awC(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cPu, this).aBE();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void anL() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cRB);
        com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anH() {
        aiZ();
        this.cPu.n(com.baidu.swan.apps.t.a.awU().ahK(), aov());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiT() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        baw();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.emJ && !TextUtils.isEmpty(this.mName)) {
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
            this.emI.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void bg(View view) {
        this.emQ = view;
        this.emK = (ImageView) view.findViewById(R.id.location_icon_path);
        this.emK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bay();
            }
        });
        this.emL = (TextView) view.findViewById(R.id.location_text_position);
        this.emM = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.emN != null) {
            this.emN.destroy();
        }
        OpenLocationBottomMenu.bbm();
        if (this.emS != null) {
            this.emS.in(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.emH.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.emN = GeoCoder.newInstance();
        this.emN.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.emL.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.emM != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.emM.setText(a.this.mAddress);
                }
                if (a.this.emL != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.emL.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.emN.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bay() {
        FragmentActivity bdH = bdH();
        if (bdH != null) {
            if (this.emO == null || !this.emO.isShowing()) {
                View inflate = View.inflate(bdH, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.baz();
                    }
                });
                this.emP = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.emP.setFragment(this);
                this.emO = new PopupWindow(bdH);
                this.emO.setContentView(inflate);
                this.emO.setWidth(-1);
                this.emO.setHeight(-2);
                this.emO.setBackgroundDrawable(new BitmapDrawable());
                this.emO.setFocusable(true);
                this.emO.ed(true);
                this.emO.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.emO.showAtLocation(this.emQ, 80, 0, 0);
                this.emO.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.Z(1.0f);
                    }
                });
                Z(0.3f);
            }
        }
    }

    public void baz() {
        if (this.emO != null && this.emO.isShowing()) {
            this.emO.dismiss();
        }
    }

    public BaiduMap baA() {
        return this.emI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        if (bdH() != null) {
            Window window = bdH().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void bh(View view) {
        this.emR = (ImageView) view.findViewById(R.id.goMyPoint);
        this.emR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.emS != null && a.this.emS.baf() != null) {
                    BDLocation baf = a.this.emS.baf();
                    a.this.emI.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(baf.getLatitude(), baf.getLongitude())));
                }
            }
        });
    }

    private void baB() {
        this.emS = new com.baidu.swan.impl.map.f.c(com.baidu.swan.apps.v.f.azN().azx(), this.emI);
        this.emS.in(true);
        this.emS.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void d(BDLocation bDLocation) {
                a.this.emT = bDLocation;
            }
        });
    }

    public BDLocation baC() {
        return this.emT;
    }

    public void io(boolean z) {
        this.emU = z;
    }

    public boolean baD() {
        return this.emU;
    }

    public List<String> baE() {
        return this.emV;
    }
}
