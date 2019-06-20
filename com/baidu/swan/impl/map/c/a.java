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
import com.baidu.swan.apps.core.d.b;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.impl.map.e.c;
import com.baidu.swan.impl.map.view.OpenLocationBottomMenu;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.menu.g;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a extends b implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String atc = "";
    private TextureMapView bna;
    private BaiduMap bnb;
    private Marker bnc;
    private ImageView bnd;
    private TextView bne;
    private TextView bnf;
    private GeoCoder bng;
    private PopupWindow bnh;
    private OpenLocationBottomMenu bni;
    private View bnj;
    private ImageView bnk;
    private c bnl;
    private BDLocation bnm;
    private boolean bnn;
    private String mAddress;
    private String mName;

    public static a A(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.Tx();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        M(inflate);
        ba(yZ());
        av(inflate);
        aw(inflate);
        TW();
        ax(inflate);
        dF(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (zc()) {
            inflate = Q(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    private void av(View view) {
        this.bna = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.bnb = this.bna.getMap();
        this.bnb.getUiSettings().setRotateGesturesEnabled(false);
        this.bna.showZoomControls(false);
        this.bnb.getUiSettings().setOverlookingGesturesEnabled(false);
        this.bnb.setOnMapLoadedCallback(this);
    }

    private void TR() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.atc = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.bnb.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.bnb.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.bnc = (Marker) this.bnb.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
        }
    }

    public void TS() {
        e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi != null) {
            vi.dN("navigateTo").y(e.aqT, e.aqV).c(this).zW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean yP() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean wO() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yN() {
        if (this.aqi == null) {
            this.aqi = new g(getContext(), this.aqh, 12, new com.baidu.swan.apps.view.b.b());
            this.aqi.setMenuSource("swan");
            this.aqi.a(com.baidu.swan.apps.u.a.DF());
            new com.baidu.swan.apps.view.coverview.c.b(this.aqi, this).PB();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void zo() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.atc);
        com.baidu.swan.apps.w.e.FV().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yO() {
        yN();
        this.aqi.a(com.baidu.swan.apps.u.a.DW().Ev(), zl(), zm());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xc() {
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        TR();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.bnc && !TextUtils.isEmpty(this.mName)) {
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
            this.bnb.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aw(View view) {
        this.bnj = view;
        this.bnd = (ImageView) view.findViewById(R.id.location_icon_path);
        this.bnd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.TT();
            }
        });
        this.bne = (TextView) view.findViewById(R.id.location_text_position);
        this.bnf = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bng != null) {
            this.bng.destroy();
        }
        OpenLocationBottomMenu.UG();
        if (this.bnl != null) {
            this.bnl.cT(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.bna.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.bng = GeoCoder.newInstance();
        this.bng.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.bne.setText(R.string.unknown_location_info);
                    return;
                }
                String address = reverseGeoCodeResult.getAddress();
                String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                a aVar = a.this;
                if (address == null) {
                    address = a.this.getResources().getString(R.string.unknown_location_info);
                }
                aVar.mAddress = address;
                a.this.mName = sematicDescription != null ? sematicDescription : a.this.getResources().getString(R.string.unknown_location_info);
                a.this.bnf.setText(a.this.mAddress);
                a.this.bne.setText(a.this.mName);
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.bng.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TT() {
        FragmentActivity Wi = Wi();
        if (Wi != null) {
            if (this.bnh == null || !this.bnh.isShowing()) {
                View inflate = View.inflate(Wi, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.TU();
                    }
                });
                this.bni = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.bni.setFragment(this);
                this.bnh = new PopupWindow(Wi);
                this.bnh.setContentView(inflate);
                this.bnh.setWidth(-1);
                this.bnh.setHeight(-2);
                this.bnh.setBackgroundDrawable(new BitmapDrawable());
                this.bnh.setFocusable(true);
                this.bnh.setOutsideTouchable(true);
                this.bnh.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.bnh.showAtLocation(this.bnj, 80, 0, 0);
                this.bnh.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.ak(1.0f);
                    }
                });
                ak(0.3f);
            }
        }
    }

    public void TU() {
        if (this.bnh != null && this.bnh.isShowing()) {
            this.bnh.dismiss();
        }
    }

    public BaiduMap TV() {
        return this.bnb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(float f) {
        if (Wi() != null) {
            Window window = Wi().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void ax(View view) {
        this.bnk = (ImageView) view.findViewById(R.id.goMyPoint);
        this.bnk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bnl != null && a.this.bnl.TD() != null) {
                    BDLocation TD = a.this.bnl.TD();
                    a.this.bnb.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(TD.getLatitude(), TD.getLongitude())));
                }
            }
        });
    }

    private void TW() {
        this.bnl = new c(com.baidu.swan.apps.w.e.FV().FH(), this.bnb);
        this.bnl.cT(true);
        this.bnl.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.e.c.b
            public void d(BDLocation bDLocation) {
                a.this.bnm = bDLocation;
            }
        });
    }

    public BDLocation TX() {
        return this.bnm;
    }

    public void cU(boolean z) {
        this.bnn = z;
    }

    public boolean TY() {
        return this.bnn;
    }
}
