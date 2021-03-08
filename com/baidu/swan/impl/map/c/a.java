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
import com.baidu.swan.menu.g;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends c implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = b.DEBUG;
    private String cVo = "";
    private OpenLocationBottomMenu eqA;
    private View eqB;
    private ImageView eqC;
    private com.baidu.swan.impl.map.f.c eqD;
    private BDLocation eqE;
    private boolean eqF;
    private ArrayList<String> eqG;
    private TextureMapView eqs;
    private BaiduMap eqt;
    private Marker equ;
    private ImageView eqv;
    private TextView eqw;
    private TextView eqx;
    private GeoCoder eqy;
    private PopupWindow eqz;
    private String mAddress;
    private String mName;

    public static a Z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.bap();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        aq(inflate);
        fl(aoI());
        setRightZoneVisibility(false);
        bb(inflate);
        bc(inflate);
        baR();
        bd(inflate);
        mC(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (aoL()) {
            inflate = av(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    private void bb(View view) {
        this.eqs = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.eqt = this.eqs.getMap();
        this.eqt.getUiSettings().setRotateGesturesEnabled(false);
        this.eqs.showZoomControls(false);
        this.eqt.getUiSettings().setOverlookingGesturesEnabled(false);
        this.eqt.setOnMapLoadedCallback(this);
    }

    private void baM() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.cVo = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.eqt.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.eqt.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.equ = (Marker) this.eqt.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
            if (!TextUtils.isEmpty(this.mName) && this.eqw != null) {
                this.eqw.setText(this.mName);
            }
            if (!TextUtils.isEmpty(this.mAddress) && this.eqx != null) {
                this.eqx.setText(this.mAddress);
            }
            this.eqG = arguments.getStringArrayList("ignoredApps");
        }
    }

    public void baN() {
        f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga != null) {
            aga.mJ("navigateTo").af(f.cTZ, f.cUb).f(this).apL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aoj() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiT() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajA() {
        if (this.cTi == null) {
            this.cTi = new g(getContext(), this.cTh, 12, com.baidu.swan.apps.t.a.axd(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cTi, this).aCe();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aom() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cVo);
        com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aoi() {
        ajA();
        this.cTi.n(com.baidu.swan.apps.t.a.axv().ail(), aoW());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aju() {
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        baM();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.equ && !TextUtils.isEmpty(this.mName)) {
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
            this.eqt.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void bc(View view) {
        this.eqB = view;
        this.eqv = (ImageView) view.findViewById(R.id.location_icon_path);
        this.eqv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.baO();
            }
        });
        this.eqw = (TextView) view.findViewById(R.id.location_text_position);
        this.eqx = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eqy != null) {
            this.eqy.destroy();
        }
        OpenLocationBottomMenu.bbB();
        if (this.eqD != null) {
            this.eqD.ip(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.eqs.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.eqy = GeoCoder.newInstance();
        this.eqy.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.eqw.setText(R.string.unknown_location_info);
                    return;
                }
                if (a.this.eqx != null && TextUtils.isEmpty(a.this.mAddress)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = a.this;
                    if (address == null) {
                        address = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar.mAddress = address;
                    a.this.eqx.setText(a.this.mAddress);
                }
                if (a.this.eqw != null && TextUtils.isEmpty(a.this.mName)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = a.this;
                    if (sematicDescription == null) {
                        sematicDescription = a.this.getResources().getString(R.string.unknown_location_info);
                    }
                    aVar2.mName = sematicDescription;
                    a.this.eqw.setText(a.this.mName);
                }
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.eqy.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baO() {
        FragmentActivity bdW = bdW();
        if (bdW != null) {
            if (this.eqz == null || !this.eqz.isShowing()) {
                View inflate = View.inflate(bdW, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.baP();
                    }
                });
                this.eqA = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.eqA.setFragment(this);
                this.eqz = new PopupWindow(bdW);
                this.eqz.setContentView(inflate);
                this.eqz.setWidth(-1);
                this.eqz.setHeight(-2);
                this.eqz.setBackgroundDrawable(new BitmapDrawable());
                this.eqz.setFocusable(true);
                this.eqz.en(true);
                this.eqz.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.eqz.showAtLocation(this.eqB, 80, 0, 0);
                this.eqz.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.ae(1.0f);
                    }
                });
                ae(0.3f);
            }
        }
    }

    public void baP() {
        if (this.eqz != null && this.eqz.isShowing()) {
            this.eqz.dismiss();
        }
    }

    public BaiduMap baQ() {
        return this.eqt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(float f) {
        if (bdW() != null) {
            Window window = bdW().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void bd(View view) {
        this.eqC = (ImageView) view.findViewById(R.id.goMyPoint);
        this.eqC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eqD != null && a.this.eqD.bav() != null) {
                    BDLocation bav = a.this.eqD.bav();
                    a.this.eqt.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bav.getLatitude(), bav.getLongitude())));
                }
            }
        });
    }

    private void baR() {
        this.eqD = new com.baidu.swan.impl.map.f.c(com.baidu.swan.apps.v.f.aAo().azY(), this.eqt);
        this.eqD.ip(true);
        this.eqD.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.f.c.b
            public void d(BDLocation bDLocation) {
                a.this.eqE = bDLocation;
            }
        });
    }

    public BDLocation baS() {
        return this.eqE;
    }

    public void iq(boolean z) {
        this.eqF = z;
    }

    public boolean baT() {
        return this.eqF;
    }

    public List<String> baU() {
        return this.eqG;
    }
}
