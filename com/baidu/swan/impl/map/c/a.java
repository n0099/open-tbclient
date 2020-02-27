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
    private String brw = "";
    private TextureMapView cvJ;
    private BaiduMap cvK;
    private Marker cvL;
    private ImageView cvM;
    private TextView cvN;
    private TextView cvO;
    private GeoCoder cvP;
    private PopupWindow cvQ;
    private OpenLocationBottomMenu cvR;
    private View cvS;
    private ImageView cvT;
    private c cvU;
    private BDLocation cvV;
    private boolean cvW;
    private ArrayList<String> cvX;
    private String mAddress;
    private String mName;

    public static a T(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.ars();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        ae(inflate);
        cq(NG());
        setRightZoneVisibility(false);
        aF(inflate);
        aG(inflate);
        arU();
        aH(inflate);
        gT(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
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
        this.cvJ = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.cvK = this.cvJ.getMap();
        this.cvK.getUiSettings().setRotateGesturesEnabled(false);
        this.cvJ.showZoomControls(false);
        this.cvK.getUiSettings().setOverlookingGesturesEnabled(false);
        this.cvK.setOnMapLoadedCallback(this);
    }

    private void arP() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.brw = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString(SlideActiviy.ADDRESS_PAGE_NAME);
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.cvK.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.cvK.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.cvL = (Marker) this.cvK.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.cvN != null) {
                this.cvN.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.cvO != null) {
                this.cvO.setText(this.mAddress);
            }
            this.cvX = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void arQ() {
        e GA = f.WQ().GA();
        if (GA != null) {
            GA.hb("navigateTo").Y(e.boe, e.bog).e(this).Ox();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nu() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean II() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jg() {
        if (this.bnw == null) {
            this.bnw = new h(getContext(), this.bnv, 12, com.baidu.swan.apps.w.a.TY(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bnw, this).Yi();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void NP() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.brw);
        f.WQ().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nt() {
        Jg();
        this.bnw.i(com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState(), NM());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jd() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        arP();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.cvL && !TextUtils.isEmpty(this.mName)) {
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
            this.cvK.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aG(View view) {
        this.cvS = view;
        this.cvM = (ImageView) view.findViewById(R.id.location_icon_path);
        this.cvM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.arR();
            }
        });
        this.cvN = (TextView) view.findViewById(R.id.location_text_position);
        this.cvO = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cvP != null) {
            this.cvP.destroy();
        }
        OpenLocationBottomMenu.asG();
        if (this.cvU != null) {
            this.cvU.eK(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.cvJ.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.cvP = GeoCoder.newInstance();
        this.cvP.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.cvN.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.cvO != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.cvO.setText(a.this.mAddress);
                }
                if (a.this.cvN != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.cvN.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + HanziToPinyin.Token.SEPARATOR + "mName" + a.this.mName);
            }
        });
        this.cvP.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arR() {
        FragmentActivity auy = auy();
        if (auy != null) {
            if (this.cvQ == null || !this.cvQ.isShowing()) {
                View inflate = View.inflate(auy, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arS();
                    }
                });
                this.cvR = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.cvR.setFragment(this);
                this.cvQ = new PopupWindow(auy);
                this.cvQ.setContentView(inflate);
                this.cvQ.setWidth(-1);
                this.cvQ.setHeight(-2);
                this.cvQ.setBackgroundDrawable(new BitmapDrawable());
                this.cvQ.setFocusable(true);
                this.cvQ.setOutsideTouchable(true);
                this.cvQ.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.cvQ.showAtLocation(this.cvS, 80, 0, 0);
                this.cvQ.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.ac(1.0f);
                    }
                });
                ac(0.3f);
            }
        }
    }

    public void arS() {
        if (this.cvQ != null && this.cvQ.isShowing()) {
            this.cvQ.dismiss();
        }
    }

    public BaiduMap arT() {
        return this.cvK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(float f) {
        if (auy() != null) {
            Window window = auy().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aH(View view) {
        this.cvT = (ImageView) view.findViewById(R.id.goMyPoint);
        this.cvT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.cvU != null && a.this.cvU.ary() != null) {
                    BDLocation ary = a.this.cvU.ary();
                    a.this.cvK.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(ary.getLatitude(), ary.getLongitude())));
                }
            }
        });
    }

    private void arU() {
        this.cvU = new c(f.WQ().WB(), this.cvK);
        this.cvU.eK(true);
        this.cvU.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void d(BDLocation bDLocation) {
                a.this.cvV = bDLocation;
            }
        });
    }

    public BDLocation arV() {
        return this.cvV;
    }

    public void eL(boolean z) {
        this.cvW = z;
    }

    public boolean arW() {
        return this.cvW;
    }

    public List<String> arX() {
        return this.cvX;
    }
}
