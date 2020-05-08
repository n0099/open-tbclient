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
    private String bPW = "";
    private TextureMapView cUX;
    private BaiduMap cUY;
    private Marker cUZ;
    private ImageView cVa;
    private TextView cVb;
    private TextView cVc;
    private GeoCoder cVd;
    private PopupWindow cVe;
    private OpenLocationBottomMenu cVf;
    private View cVg;
    private ImageView cVh;
    private c cVi;
    private BDLocation cVj;
    private boolean cVk;
    private ArrayList<String> cVl;
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
        dn(Vy());
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
        this.cUX = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.cUY = this.cUX.getMap();
        this.cUY.getUiSettings().setRotateGesturesEnabled(false);
        this.cUX.showZoomControls(false);
        this.cUY.getUiSettings().setOverlookingGesturesEnabled(false);
        this.cUY.setOnMapLoadedCallback(this);
    }

    private void aAf() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.bPW = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.cUY.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.cUY.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.cUZ = (Marker) this.cUY.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.cVb != null) {
                this.cVb.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.cVc != null) {
                this.cVc.setText(this.mAddress);
            }
            this.cVl = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void aAg() {
        e Ot = f.aeJ().Ot();
        if (Ot != null) {
            Ot.io("navigateTo").ab(e.bME, e.bMG).e(this).Wp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Vl() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qy() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void QW() {
        if (this.bLX == null) {
            this.bLX = new h(getContext(), this.bLW, 12, com.baidu.swan.apps.w.a.abR(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bLX, this).ags();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void VH() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.bPW);
        f.aeJ().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vk() {
        QW();
        this.bLX.j(com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState(), VE());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QT() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        aAf();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.cUZ && !TextUtils.isEmpty(this.mName)) {
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
            this.cUY.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aH(View view) {
        this.cVg = view;
        this.cVa = (ImageView) view.findViewById(R.id.location_icon_path);
        this.cVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aAh();
            }
        });
        this.cVb = (TextView) view.findViewById(R.id.location_text_position);
        this.cVc = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cVd != null) {
            this.cVd.destroy();
        }
        OpenLocationBottomMenu.aAV();
        if (this.cVi != null) {
            this.cVi.fI(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.cUX.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.cVd = GeoCoder.newInstance();
        this.cVd.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.cVb.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.cVc != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.cVc.setText(a.this.mAddress);
                }
                if (a.this.cVb != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.cVb.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.cVd.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAh() {
        FragmentActivity aCO = aCO();
        if (aCO != null) {
            if (this.cVe == null || !this.cVe.isShowing()) {
                View inflate = View.inflate(aCO, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aAi();
                    }
                });
                this.cVf = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.cVf.setFragment(this);
                this.cVe = new PopupWindow(aCO);
                this.cVe.setContentView(inflate);
                this.cVe.setWidth(-1);
                this.cVe.setHeight(-2);
                this.cVe.setBackgroundDrawable(new BitmapDrawable());
                this.cVe.setFocusable(true);
                this.cVe.setOutsideTouchable(true);
                this.cVe.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.cVe.showAtLocation(this.cVg, 80, 0, 0);
                this.cVe.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
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
        if (this.cVe != null && this.cVe.isShowing()) {
            this.cVe.dismiss();
        }
    }

    public BaiduMap aAj() {
        return this.cUY;
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
        this.cVh = (ImageView) view.findViewById(R.id.goMyPoint);
        this.cVh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.cVi != null && a.this.cVi.azO() != null) {
                    BDLocation azO = a.this.cVi.azO();
                    a.this.cUY.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(azO.getLatitude(), azO.getLongitude())));
                }
            }
        });
    }

    private void aAk() {
        this.cVi = new c(f.aeJ().aeu(), this.cUY);
        this.cVi.fI(true);
        this.cVi.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void d(BDLocation bDLocation) {
                a.this.cVj = bDLocation;
            }
        });
    }

    public BDLocation aAl() {
        return this.cVj;
    }

    public void fJ(boolean z) {
        this.cVk = z;
    }

    public boolean aAm() {
        return this.cVk;
    }

    public List<String> aAn() {
        return this.cVl;
    }
}
