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
import com.baidu.swan.apps.core.d.b;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.impl.map.f.c;
import com.baidu.swan.impl.map.view.OpenLocationBottomMenu;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.menu.h;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes12.dex */
public class a extends b implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bZI = "";
    private TextureMapView dfY;
    private BaiduMap dfZ;
    private Marker dga;
    private ImageView dgb;
    private TextView dgc;
    private TextView dgd;
    private GeoCoder dge;
    private PopupWindow dgf;
    private OpenLocationBottomMenu dgg;
    private View dgh;
    private ImageView dgi;
    private c dgj;
    private BDLocation dgk;
    private boolean dgl;
    private ArrayList<String> dgm;
    private String mAddress;
    private String mName;

    public static a Z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.aDA();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        ae(inflate);
        dC(Yg());
        setRightZoneVisibility(false);
        aF(inflate);
        aG(inflate);
        aEc();
        aH(inflate);
        ji(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
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
        this.dfY = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dfZ = this.dfY.getMap();
        this.dfZ.getUiSettings().setRotateGesturesEnabled(false);
        this.dfY.showZoomControls(false);
        this.dfZ.getUiSettings().setOverlookingGesturesEnabled(false);
        this.dfZ.setOnMapLoadedCallback(this);
    }

    private void aDX() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.bZI = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.dfZ.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.dfZ.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.dga = (Marker) this.dfZ.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.dgc != null) {
                this.dgc.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.dgd != null) {
                this.dgd.setText(this.mAddress);
            }
            this.dgm = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void aDY() {
        e QH = f.ahV().QH();
        if (QH != null) {
            QH.jp("navigateTo").ae(e.bVN, e.bVP).f(this).Zb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean XQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Tc() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void TC() {
        if (this.bVb == null) {
            this.bVb = new h(getContext(), this.bVa, 12, com.baidu.swan.apps.u.a.aeV(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.y.a(this.bVb, this).ajG();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void Ys() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.bZI);
        f.ahV().a(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void XP() {
        TC();
        this.bVb.n(com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState(), Yp());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ty() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        aDX();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.dga && !TextUtils.isEmpty(this.mName)) {
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
            this.dfZ.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aG(View view) {
        this.dgh = view;
        this.dgb = (ImageView) view.findViewById(R.id.location_icon_path);
        this.dgb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aDZ();
            }
        });
        this.dgc = (TextView) view.findViewById(R.id.location_text_position);
        this.dgd = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dge != null) {
            this.dge.destroy();
        }
        OpenLocationBottomMenu.aEN();
        if (this.dgj != null) {
            this.dgj.fT(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.dfY.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.dge = GeoCoder.newInstance();
        this.dge.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.dgc.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.dgd != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.dgd.setText(a.this.mAddress);
                }
                if (a.this.dgc != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.dgc.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.dge.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDZ() {
        FragmentActivity aHv = aHv();
        if (aHv != null) {
            if (this.dgf == null || !this.dgf.isShowing()) {
                View inflate = View.inflate(aHv, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aEa();
                    }
                });
                this.dgg = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.dgg.setFragment(this);
                this.dgf = new PopupWindow(aHv);
                this.dgf.setContentView(inflate);
                this.dgf.setWidth(-1);
                this.dgf.setHeight(-2);
                this.dgf.setBackgroundDrawable(new BitmapDrawable());
                this.dgf.setFocusable(true);
                this.dgf.setOutsideTouchable(true);
                this.dgf.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.dgf.showAtLocation(this.dgh, 80, 0, 0);
                this.dgf.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.L(1.0f);
                    }
                });
                L(0.3f);
            }
        }
    }

    public void aEa() {
        if (this.dgf != null && this.dgf.isShowing()) {
            this.dgf.dismiss();
        }
    }

    public BaiduMap aEb() {
        return this.dfZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(float f) {
        if (aHv() != null) {
            Window window = aHv().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aH(View view) {
        this.dgi = (ImageView) view.findViewById(R.id.goMyPoint);
        this.dgi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dgj != null && a.this.dgj.aDG() != null) {
                    BDLocation aDG = a.this.dgj.aDG();
                    a.this.dfZ.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(aDG.getLatitude(), aDG.getLongitude())));
                }
            }
        });
    }

    private void aEc() {
        this.dgj = new c(f.ahV().ahF(), this.dfZ);
        this.dgj.fT(true);
        this.dgj.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void d(BDLocation bDLocation) {
                a.this.dgk = bDLocation;
            }
        });
    }

    public BDLocation aEd() {
        return this.dgk;
    }

    public void fU(boolean z) {
        this.dgl = z;
    }

    public boolean aEe() {
        return this.dgl;
    }

    public List<String> aEf() {
        return this.dgm;
    }
}
