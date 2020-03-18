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
    private String brK = "";
    private TextureMapView cvW;
    private BaiduMap cvX;
    private Marker cvY;
    private ImageView cvZ;
    private TextView cwa;
    private TextView cwb;
    private GeoCoder cwc;
    private PopupWindow cwd;
    private OpenLocationBottomMenu cwe;
    private View cwf;
    private ImageView cwg;
    private c cwh;
    private BDLocation cwi;
    private boolean cwj;
    private ArrayList<String> cwk;
    private String mAddress;
    private String mName;

    public static a T(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.arx();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        ae(inflate);
        cr(NL());
        setRightZoneVisibility(false);
        aF(inflate);
        aG(inflate);
        arZ();
        aH(inflate);
        gS(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
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
        this.cvW = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.cvX = this.cvW.getMap();
        this.cvX.getUiSettings().setRotateGesturesEnabled(false);
        this.cvW.showZoomControls(false);
        this.cvX.getUiSettings().setOverlookingGesturesEnabled(false);
        this.cvX.setOnMapLoadedCallback(this);
    }

    private void arU() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.brK = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString(SlideActiviy.ADDRESS_PAGE_NAME);
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.cvX.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.cvX.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.cvY = (Marker) this.cvX.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.cwa != null) {
                this.cwa.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.cwb != null) {
                this.cwb.setText(this.mAddress);
            }
            this.cwk = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void arV() {
        e GH = f.WV().GH();
        if (GH != null) {
            GH.ha("navigateTo").Y(e.bos, e.bou).e(this).OC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nz() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IN() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jl() {
        if (this.bnL == null) {
            this.bnL = new h(getContext(), this.bnK, 12, com.baidu.swan.apps.w.a.Ud(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bnL, this).Yn();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void NU() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.brK);
        f.WV().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ny() {
        Jl();
        this.bnL.i(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState(), NR());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ji() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        arU();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.cvY && !TextUtils.isEmpty(this.mName)) {
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
            this.cvX.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aG(View view) {
        this.cwf = view;
        this.cvZ = (ImageView) view.findViewById(R.id.location_icon_path);
        this.cvZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.arW();
            }
        });
        this.cwa = (TextView) view.findViewById(R.id.location_text_position);
        this.cwb = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cwc != null) {
            this.cwc.destroy();
        }
        OpenLocationBottomMenu.asL();
        if (this.cwh != null) {
            this.cwh.eL(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.cvW.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.cwc = GeoCoder.newInstance();
        this.cwc.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.cwa.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.cwb != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.cwb.setText(a.this.mAddress);
                }
                if (a.this.cwa != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.cwa.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + HanziToPinyin.Token.SEPARATOR + "mName" + a.this.mName);
            }
        });
        this.cwc.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arW() {
        FragmentActivity auD = auD();
        if (auD != null) {
            if (this.cwd == null || !this.cwd.isShowing()) {
                View inflate = View.inflate(auD, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arX();
                    }
                });
                this.cwe = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.cwe.setFragment(this);
                this.cwd = new PopupWindow(auD);
                this.cwd.setContentView(inflate);
                this.cwd.setWidth(-1);
                this.cwd.setHeight(-2);
                this.cwd.setBackgroundDrawable(new BitmapDrawable());
                this.cwd.setFocusable(true);
                this.cwd.setOutsideTouchable(true);
                this.cwd.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.cwd.showAtLocation(this.cwf, 80, 0, 0);
                this.cwd.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.ac(1.0f);
                    }
                });
                ac(0.3f);
            }
        }
    }

    public void arX() {
        if (this.cwd != null && this.cwd.isShowing()) {
            this.cwd.dismiss();
        }
    }

    public BaiduMap arY() {
        return this.cvX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(float f) {
        if (auD() != null) {
            Window window = auD().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aH(View view) {
        this.cwg = (ImageView) view.findViewById(R.id.goMyPoint);
        this.cwg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.cwh != null && a.this.cwh.arD() != null) {
                    BDLocation arD = a.this.cwh.arD();
                    a.this.cvX.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(arD.getLatitude(), arD.getLongitude())));
                }
            }
        });
    }

    private void arZ() {
        this.cwh = new c(f.WV().WG(), this.cvX);
        this.cwh.eL(true);
        this.cwh.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void d(BDLocation bDLocation) {
                a.this.cwi = bDLocation;
            }
        });
    }

    public BDLocation asa() {
        return this.cwi;
    }

    public void eM(boolean z) {
        this.cwj = z;
    }

    public boolean asb() {
        return this.cwj;
    }

    public List<String> asc() {
        return this.cwk;
    }
}
