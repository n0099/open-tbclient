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
/* loaded from: classes25.dex */
public class a extends c implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = b.DEBUG;
    private String cxS = "";
    private TextureMapView dOM;
    private BaiduMap dON;
    private Marker dOO;
    private ImageView dOP;
    private TextView dOQ;
    private TextView dOR;
    private GeoCoder dOS;
    private PopupWindow dOT;
    private OpenLocationBottomMenu dOU;
    private View dOV;
    private ImageView dOW;
    private com.baidu.swan.impl.map.f.c dOX;
    private BDLocation dOY;
    private boolean dOZ;
    private ArrayList<String> dPa;
    private String mAddress;
    private String mName;

    public static a Z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.aUI();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        al(inflate);
        eq(ajV());
        setRightZoneVisibility(false);
        aP(inflate);
        aQ(inflate);
        aVk();
        aR(inflate);
        mm(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void aP(View view) {
        this.dOM = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dON = this.dOM.getMap();
        this.dON.getUiSettings().setRotateGesturesEnabled(false);
        this.dOM.showZoomControls(false);
        this.dON.getUiSettings().setOverlookingGesturesEnabled(false);
        this.dON.setOnMapLoadedCallback(this);
    }

    private void aVf() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.cxS = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.dON.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.dON.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.dOO = (Marker) this.dON.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.dOQ != null) {
                this.dOQ.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.dOR != null) {
                this.dOR.setText(this.mAddress);
            }
            this.dPa = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void aVg() {
        f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs != null) {
            abs.mt("navigateTo").ak(f.cwD, f.cwF).f(this).akS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ajw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aeh() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aeO() {
        if (this.cvN == null) {
            this.cvN = new h(getContext(), this.cvM, 12, com.baidu.swan.apps.t.a.asj(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cvN, this).axj();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void ajz() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cxS);
        com.baidu.swan.apps.v.f.avu().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajv() {
        aeO();
        this.cvN.o(com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState(), ake());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aeI() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        aVf();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.dOO && !TextUtils.isEmpty(this.mName)) {
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
            this.dON.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aQ(View view) {
        this.dOV = view;
        this.dOP = (ImageView) view.findViewById(R.id.location_icon_path);
        this.dOP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aVh();
            }
        });
        this.dOQ = (TextView) view.findViewById(R.id.location_text_position);
        this.dOR = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dOS != null) {
            this.dOS.destroy();
        }
        OpenLocationBottomMenu.aVV();
        if (this.dOX != null) {
            this.dOX.hl(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.dOM.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.dOS = GeoCoder.newInstance();
        this.dOS.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.dOQ.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.dOR != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.dOR.setText(a.this.mAddress);
                }
                if (a.this.dOQ != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.dOQ.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.dOS.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVh() {
        FragmentActivity aYo = aYo();
        if (aYo != null) {
            if (this.dOT == null || !this.dOT.isShowing()) {
                View inflate = View.inflate(aYo, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aVi();
                    }
                });
                this.dOU = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.dOU.setFragment(this);
                this.dOT = new PopupWindow(aYo);
                this.dOT.setContentView(inflate);
                this.dOT.setWidth(-1);
                this.dOT.setHeight(-2);
                this.dOT.setBackgroundDrawable(new BitmapDrawable());
                this.dOT.setFocusable(true);
                this.dOT.setOutsideTouchable(true);
                this.dOT.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.dOT.showAtLocation(this.dOV, 80, 0, 0);
                this.dOT.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.U(1.0f);
                    }
                });
                U(0.3f);
            }
        }
    }

    public void aVi() {
        if (this.dOT != null && this.dOT.isShowing()) {
            this.dOT.dismiss();
        }
    }

    public BaiduMap aVj() {
        return this.dON;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(float f) {
        if (aYo() != null) {
            Window window = aYo().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aR(View view) {
        this.dOW = (ImageView) view.findViewById(R.id.goMyPoint);
        this.dOW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dOX != null && a.this.dOX.aUO() != null) {
                    BDLocation aUO = a.this.dOX.aUO();
                    a.this.dON.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(aUO.getLatitude(), aUO.getLongitude())));
                }
            }
        });
    }

    private void aVk() {
        this.dOX = new com.baidu.swan.impl.map.f.c(com.baidu.swan.apps.v.f.avu().ave(), this.dON);
        this.dOX.hl(true);
        this.dOX.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void e(BDLocation bDLocation) {
                a.this.dOY = bDLocation;
            }
        });
    }

    public BDLocation aVl() {
        return this.dOY;
    }

    public void hm(boolean z) {
        this.dOZ = z;
    }

    public boolean aVm() {
        return this.dOZ;
    }

    public List<String> aVn() {
        return this.dPa;
    }
}
