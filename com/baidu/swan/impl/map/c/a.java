package com.baidu.swan.impl.map.c;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
import com.baidu.swan.apps.core.c.b;
import com.baidu.swan.apps.core.c.e;
import com.baidu.swan.impl.map.e.c;
import com.baidu.swan.impl.map.view.OpenLocationBottomMenu;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.menu.h;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.d;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a extends b implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String asO = "";
    private TextureMapView bgV;
    private BaiduMap bgW;
    private Marker bgX;
    private ImageView bgY;
    private TextView bgZ;
    private TextView bha;
    private GeoCoder bhb;
    private PopupWindow bhc;
    private OpenLocationBottomMenu bhd;
    private View bhe;
    private ImageView bhf;
    private c bhg;
    private BDLocation bhh;
    private boolean bhi;
    private String mAddress;
    private String mName;

    public static a z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.PL();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(d.h.ai_apps_map_show_location_fragment, viewGroup, false);
        M(inflate);
        aW(yf());
        setRightMenuVisibility(false);
        ap(inflate);
        aq(inflate);
        Qk();
        ar(inflate);
        dT(AppRuntime.getAppContext().getResources().getString(d.j.aiapps_map_open_location_title));
        if (yi()) {
            inflate = Q(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    private void ap(View view) {
        this.bgV = (TextureMapView) view.findViewById(d.g.bdMapView);
        this.bgW = this.bgV.getMap();
        this.bgW.getUiSettings().setRotateGesturesEnabled(false);
        this.bgV.showZoomControls(false);
        this.bgW.getUiSettings().setOverlookingGesturesEnabled(false);
        this.bgW.setOnMapLoadedCallback(this);
    }

    private void Qf() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.asO = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.bgW.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.bgW.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.bgX = (Marker) this.bgW.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(d.f.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
        }
    }

    public void Qg() {
        e uy = com.baidu.swan.apps.w.e.Ea().uy();
        if (uy != null) {
            uy.ea("navigateTo").A(e.aqO, e.aqQ).b(this).yZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xV() {
        if (this.aqc == null) {
            this.aqc = new h(getContext(), this.aqb, 12, new com.baidu.swan.apps.view.b.b());
            this.aqc.setMenuSource("swan");
            this.aqc.a(com.baidu.swan.apps.u.a.CA());
            new com.baidu.swan.apps.view.coverview.c.b(this.aqc, this).MS();
        }
    }

    @Override // com.baidu.swan.apps.core.c.b
    public void yu() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.asO);
        com.baidu.swan.apps.w.e.Ea().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
        xV();
        this.aqc.a(com.baidu.swan.apps.u.a.CR().Dq(), yr(), ys());
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        Qf();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.bgX && !TextUtils.isEmpty(this.mName)) {
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
            this.bgW.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aq(View view) {
        this.bhe = view;
        this.bgY = (ImageView) view.findViewById(d.g.location_icon_path);
        this.bgY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Qh();
            }
        });
        this.bgZ = (TextView) view.findViewById(d.g.location_text_position);
        this.bha = (TextView) view.findViewById(d.g.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bhb != null) {
            this.bhb.destroy();
        }
        OpenLocationBottomMenu.QU();
        if (this.bhg != null) {
            this.bhg.cC(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.bgV.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.bhb = GeoCoder.newInstance();
        this.bhb.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.bgZ.setText(d.j.unknown_location_info);
                    return;
                }
                String address = reverseGeoCodeResult.getAddress();
                String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                a aVar = a.this;
                if (address == null) {
                    address = a.this.getResources().getString(d.j.unknown_location_info);
                }
                aVar.mAddress = address;
                a.this.mName = sematicDescription != null ? sematicDescription : a.this.getResources().getString(d.j.unknown_location_info);
                a.this.bha.setText(a.this.mAddress);
                a.this.bgZ.setText(a.this.mName);
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.bhb.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh() {
        FragmentActivity Sw = Sw();
        if (Sw != null) {
            if (this.bhc == null || !this.bhc.isShowing()) {
                View inflate = View.inflate(Sw, d.h.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Qi();
                    }
                });
                this.bhd = (OpenLocationBottomMenu) inflate.findViewById(d.g.openlocation_popmenu);
                this.bhd.setFragment(this);
                this.bhc = new PopupWindow(Sw);
                this.bhc.setContentView(inflate);
                this.bhc.setWidth(-1);
                this.bhc.setHeight(-2);
                this.bhc.setBackgroundDrawable(new BitmapDrawable());
                this.bhc.setFocusable(true);
                this.bhc.setOutsideTouchable(true);
                this.bhc.setAnimationStyle(d.k.OpenLocationBottomMenuPopupStyle);
                this.bhc.showAtLocation(this.bhe, 80, 0, 0);
                this.bhc.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.ai(1.0f);
                    }
                });
                ai(0.3f);
            }
        }
    }

    public void Qi() {
        if (this.bhc != null && this.bhc.isShowing()) {
            this.bhc.dismiss();
        }
    }

    public BaiduMap Qj() {
        return this.bgW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(float f) {
        if (Sw() != null) {
            Window window = Sw().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void ar(View view) {
        this.bhf = (ImageView) view.findViewById(d.g.goMyPoint);
        this.bhf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bhg != null && a.this.bhg.PR() != null) {
                    BDLocation PR = a.this.bhg.PR();
                    a.this.bgW.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(PR.getLatitude(), PR.getLongitude())));
                }
            }
        });
    }

    private void Qk() {
        this.bhg = new c(com.baidu.swan.apps.w.e.Ea().DM(), this.bgW);
        this.bhg.cC(true);
        this.bhg.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.e.c.b
            public void d(BDLocation bDLocation) {
                a.this.bhh = bDLocation;
            }
        });
    }

    public BDLocation Ql() {
        return this.bhh;
    }

    public void cD(boolean z) {
        this.bhi = z;
    }

    public boolean Qm() {
        return this.bhi;
    }
}
