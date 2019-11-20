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
    private String aNc = "";
    private TextureMapView bGg;
    private BaiduMap bGh;
    private Marker bGi;
    private ImageView bGj;
    private TextView bGk;
    private TextView bGl;
    private GeoCoder bGm;
    private PopupWindow bGn;
    private OpenLocationBottomMenu bGo;
    private View bGp;
    private ImageView bGq;
    private c bGr;
    private BDLocation bGs;
    private boolean bGt;
    private String mAddress;
    private String mName;

    public static a A(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.Zg();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        U(inflate);
        bv(EG());
        aD(inflate);
        aE(inflate);
        ZF();
        aF(inflate);
        eu(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (EJ()) {
            inflate = Y(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    private void aD(View view) {
        this.bGg = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.bGh = this.bGg.getMap();
        this.bGh.getUiSettings().setRotateGesturesEnabled(false);
        this.bGg.showZoomControls(false);
        this.bGh.getUiSettings().setOverlookingGesturesEnabled(false);
        this.bGh.setOnMapLoadedCallback(this);
    }

    private void ZA() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.aNc = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.bGh.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.bGh.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.bGi = (Marker) this.bGh.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
        }
    }

    public void ZB() {
        e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI != null) {
            AI.eC("navigateTo").F(e.aKT, e.aKV).c(this).FD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ew() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Co() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
        if (this.aKh == null) {
            this.aKh = new g(getContext(), this.aKg, 12, new com.baidu.swan.apps.view.b.b());
            this.aKh.setMenuSource("swan");
            this.aKh.a(com.baidu.swan.apps.u.a.Jn());
            new com.baidu.swan.apps.view.coverview.c.b(this.aKh, this).Vl();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void EV() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.aNc);
        com.baidu.swan.apps.w.e.LE().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ev() {
        Eu();
        this.aKh.a(com.baidu.swan.apps.u.a.JE().Kd(), ES(), ET());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CC() {
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        ZA();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.bGi && !TextUtils.isEmpty(this.mName)) {
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
            this.bGh.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aE(View view) {
        this.bGp = view;
        this.bGj = (ImageView) view.findViewById(R.id.location_icon_path);
        this.bGj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.ZC();
            }
        });
        this.bGk = (TextView) view.findViewById(R.id.location_text_position);
        this.bGl = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bGm != null) {
            this.bGm.destroy();
        }
        OpenLocationBottomMenu.aap();
        if (this.bGr != null) {
            this.bGr.dn(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.bGg.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.bGm = GeoCoder.newInstance();
        this.bGm.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.bGk.setText(R.string.unknown_location_info);
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
                a.this.bGl.setText(a.this.mAddress);
                a.this.bGk.setText(a.this.mName);
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + HanziToPinyin.Token.SEPARATOR + "mName" + a.this.mName);
            }
        });
        this.bGm.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZC() {
        FragmentActivity abT = abT();
        if (abT != null) {
            if (this.bGn == null || !this.bGn.isShowing()) {
                View inflate = View.inflate(abT, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ZD();
                    }
                });
                this.bGo = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.bGo.setFragment(this);
                this.bGn = new PopupWindow(abT);
                this.bGn.setContentView(inflate);
                this.bGn.setWidth(-1);
                this.bGn.setHeight(-2);
                this.bGn.setBackgroundDrawable(new BitmapDrawable());
                this.bGn.setFocusable(true);
                this.bGn.dw(true);
                this.bGn.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.bGn.a(this.bGp, 80, 0, 0);
                this.bGn.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.Z(1.0f);
                    }
                });
                Z(0.3f);
            }
        }
    }

    public void ZD() {
        if (this.bGn != null && this.bGn.isShowing()) {
            this.bGn.dismiss();
        }
    }

    public BaiduMap ZE() {
        return this.bGh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        if (abT() != null) {
            Window window = abT().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aF(View view) {
        this.bGq = (ImageView) view.findViewById(R.id.goMyPoint);
        this.bGq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bGr != null && a.this.bGr.Zm() != null) {
                    BDLocation Zm = a.this.bGr.Zm();
                    a.this.bGh.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(Zm.getLatitude(), Zm.getLongitude())));
                }
            }
        });
    }

    private void ZF() {
        this.bGr = new c(com.baidu.swan.apps.w.e.LE().Lq(), this.bGh);
        this.bGr.dn(true);
        this.bGr.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.e.c.b
            public void d(BDLocation bDLocation) {
                a.this.bGs = bDLocation;
            }
        });
    }

    public BDLocation ZG() {
        return this.bGs;
    }

    /* renamed from: do  reason: not valid java name */
    public void m20do(boolean z) {
        this.bGt = z;
    }

    public boolean ZH() {
        return this.bGt;
    }
}
