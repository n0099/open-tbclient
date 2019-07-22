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
    private String atF = "";
    private TextureMapView bnN;
    private BaiduMap bnO;
    private Marker bnP;
    private ImageView bnQ;
    private TextView bnR;
    private TextView bnS;
    private GeoCoder bnT;
    private PopupWindow bnU;
    private OpenLocationBottomMenu bnV;
    private View bnW;
    private ImageView bnX;
    private c bnY;
    private BDLocation bnZ;
    private boolean boa;
    private String mAddress;
    private String mName;

    public static a A(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.Up();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        O(inflate);
        bd(zG());
        ax(inflate);
        ay(inflate);
        UO();
        az(inflate);
        dK(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (zJ()) {
            inflate = S(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    private void ax(View view) {
        this.bnN = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.bnO = this.bnN.getMap();
        this.bnO.getUiSettings().setRotateGesturesEnabled(false);
        this.bnN.showZoomControls(false);
        this.bnO.getUiSettings().setOverlookingGesturesEnabled(false);
        this.bnO.setOnMapLoadedCallback(this);
    }

    private void UJ() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.atF = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.bnO.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.bnO.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.bnP = (Marker) this.bnO.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
        }
    }

    public void UK() {
        e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ != null) {
            vJ.dS("navigateTo").B(e.arw, e.ary).c(this).AD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean zw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xp() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zu() {
        if (this.aqL == null) {
            this.aqL = new g(getContext(), this.aqK, 12, new com.baidu.swan.apps.view.b.b());
            this.aqL.setMenuSource("swan");
            this.aqL.a(com.baidu.swan.apps.u.a.Eo());
            new com.baidu.swan.apps.view.coverview.c.b(this.aqL, this).Qt();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void zV() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.atF);
        com.baidu.swan.apps.w.e.GF().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zv() {
        zu();
        this.aqL.a(com.baidu.swan.apps.u.a.EF().Fe(), zS(), zT());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xD() {
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        UJ();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.bnP && !TextUtils.isEmpty(this.mName)) {
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
            this.bnO.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void ay(View view) {
        this.bnW = view;
        this.bnQ = (ImageView) view.findViewById(R.id.location_icon_path);
        this.bnQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.UL();
            }
        });
        this.bnR = (TextView) view.findViewById(R.id.location_text_position);
        this.bnS = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bnT != null) {
            this.bnT.destroy();
        }
        OpenLocationBottomMenu.Vy();
        if (this.bnY != null) {
            this.bnY.cW(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.bnN.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.bnT = GeoCoder.newInstance();
        this.bnT.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.bnR.setText(R.string.unknown_location_info);
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
                a.this.bnS.setText(a.this.mAddress);
                a.this.bnR.setText(a.this.mName);
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.bnT.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UL() {
        FragmentActivity Xc = Xc();
        if (Xc != null) {
            if (this.bnU == null || !this.bnU.isShowing()) {
                View inflate = View.inflate(Xc, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.UM();
                    }
                });
                this.bnV = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.bnV.setFragment(this);
                this.bnU = new PopupWindow(Xc);
                this.bnU.setContentView(inflate);
                this.bnU.setWidth(-1);
                this.bnU.setHeight(-2);
                this.bnU.setBackgroundDrawable(new BitmapDrawable());
                this.bnU.setFocusable(true);
                this.bnU.df(true);
                this.bnU.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.bnU.a(this.bnW, 80, 0, 0);
                this.bnU.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.ak(1.0f);
                    }
                });
                ak(0.3f);
            }
        }
    }

    public void UM() {
        if (this.bnU != null && this.bnU.isShowing()) {
            this.bnU.dismiss();
        }
    }

    public BaiduMap UN() {
        return this.bnO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(float f) {
        if (Xc() != null) {
            Window window = Xc().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void az(View view) {
        this.bnX = (ImageView) view.findViewById(R.id.goMyPoint);
        this.bnX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bnY != null && a.this.bnY.Uv() != null) {
                    BDLocation Uv = a.this.bnY.Uv();
                    a.this.bnO.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(Uv.getLatitude(), Uv.getLongitude())));
                }
            }
        });
    }

    private void UO() {
        this.bnY = new c(com.baidu.swan.apps.w.e.GF().Gr(), this.bnO);
        this.bnY.cW(true);
        this.bnY.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.e.c.b
            public void d(BDLocation bDLocation) {
                a.this.bnZ = bDLocation;
            }
        });
    }

    public BDLocation UP() {
        return this.bnZ;
    }

    public void cX(boolean z) {
        this.boa = z;
    }

    public boolean UQ() {
        return this.boa;
    }
}
