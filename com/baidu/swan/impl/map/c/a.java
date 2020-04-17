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
import com.baidu.sapi2.activity.SlideActiviy;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.d.b;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.y.f;
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
    private String bPR = "";
    private TextureMapView cUS;
    private BaiduMap cUT;
    private Marker cUU;
    private ImageView cUV;
    private TextView cUW;
    private TextView cUX;
    private GeoCoder cUY;
    private PopupWindow cUZ;
    private OpenLocationBottomMenu cVa;
    private View cVb;
    private ImageView cVc;
    private c cVd;
    private BDLocation cVe;
    private boolean cVf;
    private ArrayList<String> cVg;
    private String mAddress;
    private String mName;

    public static a T(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.azI();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        ae(inflate);
        dn(Vz());
        setRightZoneVisibility(false);
        aG(inflate);
        aH(inflate);
        aAk();
        aI(inflate);
        ig(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void aG(View view) {
        this.cUS = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.cUT = this.cUS.getMap();
        this.cUT.getUiSettings().setRotateGesturesEnabled(false);
        this.cUS.showZoomControls(false);
        this.cUT.getUiSettings().setOverlookingGesturesEnabled(false);
        this.cUT.setOnMapLoadedCallback(this);
    }

    private void aAf() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.bPR = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString(SlideActiviy.ADDRESS_PAGE_NAME);
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.cUT.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.cUT.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.cUU = (Marker) this.cUT.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.cUW != null) {
                this.cUW.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.cUX != null) {
                this.cUX.setText(this.mAddress);
            }
            this.cVg = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void aAg() {
        e Ou = f.aeK().Ou();
        if (Ou != null) {
            Ou.io("navigateTo").ab(e.bMz, e.bMB).e(this).Wq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Vm() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qz() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void QX() {
        if (this.bLS == null) {
            this.bLS = new h(getContext(), this.bLR, 12, com.baidu.swan.apps.w.a.abS(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bLS, this).agt();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void VI() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.bPR);
        f.aeK().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vl() {
        QX();
        this.bLS.j(com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState(), VF());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QU() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        aAf();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.cUU && !TextUtils.isEmpty(this.mName)) {
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
            this.cUT.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aH(View view) {
        this.cVb = view;
        this.cUV = (ImageView) view.findViewById(R.id.location_icon_path);
        this.cUV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aAh();
            }
        });
        this.cUW = (TextView) view.findViewById(R.id.location_text_position);
        this.cUX = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cUY != null) {
            this.cUY.destroy();
        }
        OpenLocationBottomMenu.aAV();
        if (this.cVd != null) {
            this.cVd.fI(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.cUS.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.cUY = GeoCoder.newInstance();
        this.cUY.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.cUW.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.cUX != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.cUX.setText(a.this.mAddress);
                }
                if (a.this.cUW != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.cUW.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.cUY.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAh() {
        FragmentActivity aCO = aCO();
        if (aCO != null) {
            if (this.cUZ == null || !this.cUZ.isShowing()) {
                View inflate = View.inflate(aCO, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aAi();
                    }
                });
                this.cVa = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.cVa.setFragment(this);
                this.cUZ = new PopupWindow(aCO);
                this.cUZ.setContentView(inflate);
                this.cUZ.setWidth(-1);
                this.cUZ.setHeight(-2);
                this.cUZ.setBackgroundDrawable(new BitmapDrawable());
                this.cUZ.setFocusable(true);
                this.cUZ.setOutsideTouchable(true);
                this.cUZ.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.cUZ.showAtLocation(this.cVb, 80, 0, 0);
                this.cUZ.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.M(1.0f);
                    }
                });
                M(0.3f);
            }
        }
    }

    public void aAi() {
        if (this.cUZ != null && this.cUZ.isShowing()) {
            this.cUZ.dismiss();
        }
    }

    public BaiduMap aAj() {
        return this.cUT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(float f) {
        if (aCO() != null) {
            Window window = aCO().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aI(View view) {
        this.cVc = (ImageView) view.findViewById(R.id.goMyPoint);
        this.cVc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.cVd != null && a.this.cVd.azO() != null) {
                    BDLocation azO = a.this.cVd.azO();
                    a.this.cUT.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(azO.getLatitude(), azO.getLongitude())));
                }
            }
        });
    }

    private void aAk() {
        this.cVd = new c(f.aeK().aev(), this.cUT);
        this.cVd.fI(true);
        this.cVd.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void d(BDLocation bDLocation) {
                a.this.cVe = bDLocation;
            }
        });
    }

    public BDLocation aAl() {
        return this.cVe;
    }

    public void fJ(boolean z) {
        this.cVf = z;
    }

    public boolean aAm() {
        return this.cVf;
    }

    public List<String> aAn() {
        return this.cVg;
    }
}
