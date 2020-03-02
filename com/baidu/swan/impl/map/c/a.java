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
    private String brx = "";
    private TextureMapView cvK;
    private BaiduMap cvL;
    private Marker cvM;
    private ImageView cvN;
    private TextView cvO;
    private TextView cvP;
    private GeoCoder cvQ;
    private PopupWindow cvR;
    private OpenLocationBottomMenu cvS;
    private View cvT;
    private ImageView cvU;
    private c cvV;
    private BDLocation cvW;
    private boolean cvX;
    private ArrayList<String> cvY;
    private String mAddress;
    private String mName;

    public static a T(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.aru();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        ae(inflate);
        cq(NI());
        setRightZoneVisibility(false);
        aF(inflate);
        aG(inflate);
        arW();
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
        this.cvK = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.cvL = this.cvK.getMap();
        this.cvL.getUiSettings().setRotateGesturesEnabled(false);
        this.cvK.showZoomControls(false);
        this.cvL.getUiSettings().setOverlookingGesturesEnabled(false);
        this.cvL.setOnMapLoadedCallback(this);
    }

    private void arR() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.brx = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString(SlideActiviy.ADDRESS_PAGE_NAME);
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.cvL.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.cvL.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.cvM = (Marker) this.cvL.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.cvO != null) {
                this.cvO.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.cvP != null) {
                this.cvP.setText(this.mAddress);
            }
            this.cvY = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void arS() {
        e GC = f.WS().GC();
        if (GC != null) {
            GC.hb("navigateTo").Y(e.bof, e.boh).e(this).Oz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IK() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ji() {
        if (this.bnx == null) {
            this.bnx = new h(getContext(), this.bnw, 12, com.baidu.swan.apps.w.a.Ua(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bnx, this).Yk();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void NR() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.brx);
        f.WS().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nv() {
        Ji();
        this.bnx.i(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState(), NO());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jf() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        arR();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.cvM && !TextUtils.isEmpty(this.mName)) {
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
            this.cvL.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aG(View view) {
        this.cvT = view;
        this.cvN = (ImageView) view.findViewById(R.id.location_icon_path);
        this.cvN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.arT();
            }
        });
        this.cvO = (TextView) view.findViewById(R.id.location_text_position);
        this.cvP = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cvQ != null) {
            this.cvQ.destroy();
        }
        OpenLocationBottomMenu.asI();
        if (this.cvV != null) {
            this.cvV.eK(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.cvK.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.cvQ = GeoCoder.newInstance();
        this.cvQ.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.cvO.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.cvP != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.cvP.setText(a.this.mAddress);
                }
                if (a.this.cvO != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.cvO.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + HanziToPinyin.Token.SEPARATOR + "mName" + a.this.mName);
            }
        });
        this.cvQ.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arT() {
        FragmentActivity auA = auA();
        if (auA != null) {
            if (this.cvR == null || !this.cvR.isShowing()) {
                View inflate = View.inflate(auA, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arU();
                    }
                });
                this.cvS = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.cvS.setFragment(this);
                this.cvR = new PopupWindow(auA);
                this.cvR.setContentView(inflate);
                this.cvR.setWidth(-1);
                this.cvR.setHeight(-2);
                this.cvR.setBackgroundDrawable(new BitmapDrawable());
                this.cvR.setFocusable(true);
                this.cvR.setOutsideTouchable(true);
                this.cvR.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.cvR.showAtLocation(this.cvT, 80, 0, 0);
                this.cvR.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.ac(1.0f);
                    }
                });
                ac(0.3f);
            }
        }
    }

    public void arU() {
        if (this.cvR != null && this.cvR.isShowing()) {
            this.cvR.dismiss();
        }
    }

    public BaiduMap arV() {
        return this.cvL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(float f) {
        if (auA() != null) {
            Window window = auA().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aH(View view) {
        this.cvU = (ImageView) view.findViewById(R.id.goMyPoint);
        this.cvU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.cvV != null && a.this.cvV.arA() != null) {
                    BDLocation arA = a.this.cvV.arA();
                    a.this.cvL.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(arA.getLatitude(), arA.getLongitude())));
                }
            }
        });
    }

    private void arW() {
        this.cvV = new c(f.WS().WD(), this.cvL);
        this.cvV.eK(true);
        this.cvV.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void d(BDLocation bDLocation) {
                a.this.cvW = bDLocation;
            }
        });
    }

    public BDLocation arX() {
        return this.cvW;
    }

    public void eL(boolean z) {
        this.cvX = z;
    }

    public boolean arY() {
        return this.cvX;
    }

    public List<String> arZ() {
        return this.cvY;
    }
}
