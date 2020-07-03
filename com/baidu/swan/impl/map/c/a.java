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
import com.baidu.swan.apps.w.f;
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
    private String cey = "";
    private TextureMapView dkK;
    private BaiduMap dkL;
    private Marker dkM;
    private ImageView dkN;
    private TextView dkO;
    private TextView dkP;
    private GeoCoder dkQ;
    private PopupWindow dkR;
    private OpenLocationBottomMenu dkS;
    private View dkT;
    private ImageView dkU;
    private c dkV;
    private BDLocation dkW;
    private boolean dkX;
    private ArrayList<String> dkY;
    private String mAddress;
    private String mName;

    public static a Z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.aEG();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        ae(inflate);
        dH(Zm());
        setRightZoneVisibility(false);
        aF(inflate);
        aG(inflate);
        aFi();
        aH(inflate);
        jq(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
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
        this.dkK = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.dkL = this.dkK.getMap();
        this.dkL.getUiSettings().setRotateGesturesEnabled(false);
        this.dkK.showZoomControls(false);
        this.dkL.getUiSettings().setOverlookingGesturesEnabled(false);
        this.dkL.setOnMapLoadedCallback(this);
    }

    private void aFd() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.cey = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.dkL.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.dkL.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.dkM = (Marker) this.dkL.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.dkO != null) {
                this.dkO.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.dkP != null) {
                this.dkP.setText(this.mAddress);
            }
            this.dkY = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void aFe() {
        e RN = f.ajb().RN();
        if (RN != null) {
            RN.jx("navigateTo").ag(e.caB, e.caD).f(this).aah();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean YW() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ui() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void UI() {
        if (this.bZP == null) {
            this.bZP = new h(getContext(), this.bZO, 12, com.baidu.swan.apps.u.a.agb(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.y.a(this.bZP, this).akM();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void Zy() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cey);
        f.ajb().a(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void YV() {
        UI();
        this.bZP.n(com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState(), Zv());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean UE() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        aFd();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.dkM && !TextUtils.isEmpty(this.mName)) {
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
            this.dkL.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aG(View view) {
        this.dkT = view;
        this.dkN = (ImageView) view.findViewById(R.id.location_icon_path);
        this.dkN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aFf();
            }
        });
        this.dkO = (TextView) view.findViewById(R.id.location_text_position);
        this.dkP = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dkQ != null) {
            this.dkQ.destroy();
        }
        OpenLocationBottomMenu.aFT();
        if (this.dkV != null) {
            this.dkV.fY(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.dkK.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.dkQ = GeoCoder.newInstance();
        this.dkQ.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.dkO.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.dkP != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.dkP.setText(a.this.mAddress);
                }
                if (a.this.dkO != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.dkO.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.dkQ.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFf() {
        FragmentActivity aIB = aIB();
        if (aIB != null) {
            if (this.dkR == null || !this.dkR.isShowing()) {
                View inflate = View.inflate(aIB, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aFg();
                    }
                });
                this.dkS = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.dkS.setFragment(this);
                this.dkR = new PopupWindow(aIB);
                this.dkR.setContentView(inflate);
                this.dkR.setWidth(-1);
                this.dkR.setHeight(-2);
                this.dkR.setBackgroundDrawable(new BitmapDrawable());
                this.dkR.setFocusable(true);
                this.dkR.setOutsideTouchable(true);
                this.dkR.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.dkR.showAtLocation(this.dkT, 80, 0, 0);
                this.dkR.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.N(1.0f);
                    }
                });
                N(0.3f);
            }
        }
    }

    public void aFg() {
        if (this.dkR != null && this.dkR.isShowing()) {
            this.dkR.dismiss();
        }
    }

    public BaiduMap aFh() {
        return this.dkL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(float f) {
        if (aIB() != null) {
            Window window = aIB().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void aH(View view) {
        this.dkU = (ImageView) view.findViewById(R.id.goMyPoint);
        this.dkU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dkV != null && a.this.dkV.aEM() != null) {
                    BDLocation aEM = a.this.dkV.aEM();
                    a.this.dkL.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(aEM.getLatitude(), aEM.getLongitude())));
                }
            }
        });
    }

    private void aFi() {
        this.dkV = new c(f.ajb().aiL(), this.dkL);
        this.dkV.fY(true);
        this.dkV.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void d(BDLocation bDLocation) {
                a.this.dkW = bDLocation;
            }
        });
    }

    public BDLocation aFj() {
        return this.dkW;
    }

    public void fZ(boolean z) {
        this.dkX = z;
    }

    public boolean aFk() {
        return this.dkX;
    }

    public List<String> aFl() {
        return this.dkY;
    }
}
