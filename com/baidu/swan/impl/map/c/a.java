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
    private String aNu = "";
    private TextureMapView bGX;
    private BaiduMap bGY;
    private Marker bGZ;
    private ImageView bHa;
    private TextView bHb;
    private TextView bHc;
    private GeoCoder bHd;
    private PopupWindow bHe;
    private OpenLocationBottomMenu bHf;
    private View bHg;
    private ImageView bHh;
    private c bHi;
    private BDLocation bHj;
    private boolean bHk;
    private String mAddress;
    private String mName;

    public static a A(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.Zi();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        U(inflate);
        bv(EF());
        aD(inflate);
        aE(inflate);
        ZH();
        aF(inflate);
        eu(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (EI()) {
            inflate = Y(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    private void aD(View view) {
        this.bGX = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.bGY = this.bGX.getMap();
        this.bGY.getUiSettings().setRotateGesturesEnabled(false);
        this.bGX.showZoomControls(false);
        this.bGY.getUiSettings().setOverlookingGesturesEnabled(false);
        this.bGY.setOnMapLoadedCallback(this);
    }

    private void ZC() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.aNu = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.bGY.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.bGY.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.bGZ = (Marker) this.bGY.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
        }
    }

    public void ZD() {
        e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH != null) {
            AH.eC("navigateTo").H(e.aLl, e.aLn).c(this).FC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ev() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Cn() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Et() {
        if (this.aKz == null) {
            this.aKz = new g(getContext(), this.aKy, 12, new com.baidu.swan.apps.view.b.b());
            this.aKz.setMenuSource("swan");
            this.aKz.a(com.baidu.swan.apps.u.a.Jm());
            new com.baidu.swan.apps.view.coverview.c.b(this.aKz, this).Vn();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void EU() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.aNu);
        com.baidu.swan.apps.w.e.LD().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
        Et();
        this.aKz.a(com.baidu.swan.apps.u.a.JD().Kc(), ER(), ES());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CB() {
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        ZC();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.bGZ && !TextUtils.isEmpty(this.mName)) {
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
            this.bGY.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aE(View view) {
        this.bHg = view;
        this.bHa = (ImageView) view.findViewById(R.id.location_icon_path);
        this.bHa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.ZE();
            }
        });
        this.bHb = (TextView) view.findViewById(R.id.location_text_position);
        this.bHc = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bHd != null) {
            this.bHd.destroy();
        }
        OpenLocationBottomMenu.aar();
        if (this.bHi != null) {
            this.bHi.dn(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.bGX.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.bHd = GeoCoder.newInstance();
        this.bHd.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.bHb.setText(R.string.unknown_location_info);
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
                a.this.bHc.setText(a.this.mAddress);
                a.this.bHb.setText(a.this.mName);
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + HanziToPinyin.Token.SEPARATOR + "mName" + a.this.mName);
            }
        });
        this.bHd.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZE() {
        FragmentActivity abV = abV();
        if (abV != null) {
            if (this.bHe == null || !this.bHe.isShowing()) {
                View inflate = View.inflate(abV, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ZF();
                    }
                });
                this.bHf = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.bHf.setFragment(this);
                this.bHe = new PopupWindow(abV);
                this.bHe.setContentView(inflate);
                this.bHe.setWidth(-1);
                this.bHe.setHeight(-2);
                this.bHe.setBackgroundDrawable(new BitmapDrawable());
                this.bHe.setFocusable(true);
                this.bHe.dw(true);
                this.bHe.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.bHe.a(this.bHg, 80, 0, 0);
                this.bHe.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.Z(1.0f);
                    }
                });
                Z(0.3f);
            }
        }
    }

    public void ZF() {
        if (this.bHe != null && this.bHe.isShowing()) {
            this.bHe.dismiss();
        }
    }

    public BaiduMap ZG() {
        return this.bGY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        if (abV() != null) {
            Window window = abV().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aF(View view) {
        this.bHh = (ImageView) view.findViewById(R.id.goMyPoint);
        this.bHh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bHi != null && a.this.bHi.Zo() != null) {
                    BDLocation Zo = a.this.bHi.Zo();
                    a.this.bGY.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(Zo.getLatitude(), Zo.getLongitude())));
                }
            }
        });
    }

    private void ZH() {
        this.bHi = new c(com.baidu.swan.apps.w.e.LD().Lp(), this.bGY);
        this.bHi.dn(true);
        this.bHi.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.e.c.b
            public void d(BDLocation bDLocation) {
                a.this.bHj = bDLocation;
            }
        });
    }

    public BDLocation ZI() {
        return this.bHj;
    }

    /* renamed from: do  reason: not valid java name */
    public void m20do(boolean z) {
        this.bHk = z;
    }

    public boolean ZJ() {
        return this.bHk;
    }
}
