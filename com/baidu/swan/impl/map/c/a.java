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
import com.baidu.swan.apps.core.c.b;
import com.baidu.swan.apps.core.c.e;
import com.baidu.swan.impl.map.e.c;
import com.baidu.swan.impl.map.view.OpenLocationBottomMenu;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.menu.h;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.d;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a extends b implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String asJ = "";
    private TextureMapView bgR;
    private BaiduMap bgS;
    private Marker bgT;
    private ImageView bgU;
    private TextView bgV;
    private TextView bgW;
    private GeoCoder bgX;
    private PopupWindow bgY;
    private OpenLocationBottomMenu bgZ;
    private View bha;
    private ImageView bhb;
    private c bhc;
    private BDLocation bhd;
    private boolean bhe;
    private String mAddress;
    private String mName;

    public static a z(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.PN();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(d.h.ai_apps_map_show_location_fragment, viewGroup, false);
        M(inflate);
        aW(yg());
        setRightMenuVisibility(false);
        ap(inflate);
        aq(inflate);
        Qm();
        ar(inflate);
        dR(AppRuntime.getAppContext().getResources().getString(d.j.aiapps_map_open_location_title));
        if (yj()) {
            inflate = Q(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    private void ap(View view) {
        this.bgR = (TextureMapView) view.findViewById(d.g.bdMapView);
        this.bgS = this.bgR.getMap();
        this.bgS.getUiSettings().setRotateGesturesEnabled(false);
        this.bgR.showZoomControls(false);
        this.bgS.getUiSettings().setOverlookingGesturesEnabled(false);
        this.bgS.setOnMapLoadedCallback(this);
    }

    private void Qh() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.asJ = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.bgS.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.bgS.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.bgT = (Marker) this.bgS.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(d.f.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
        }
    }

    public void Qi() {
        e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz != null) {
            uz.dY("navigateTo").A(e.aqJ, e.aqL).b(this).za();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xY() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vY() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
        if (this.apX == null) {
            this.apX = new h(getContext(), this.apW, 12, new com.baidu.swan.apps.view.b.b());
            this.apX.setMenuSource("swan");
            this.apX.a(com.baidu.swan.apps.u.a.CC());
            new com.baidu.swan.apps.view.coverview.c.b(this.apX, this).MU();
        }
    }

    @Override // com.baidu.swan.apps.core.c.b
    public void yv() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.asJ);
        com.baidu.swan.apps.w.e.Ec().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xX() {
        xW();
        this.apX.a(com.baidu.swan.apps.u.a.CT().Ds(), ys(), yt());
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        Qh();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.bgT && !TextUtils.isEmpty(this.mName)) {
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
            this.bgS.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void aq(View view) {
        this.bha = view;
        this.bgU = (ImageView) view.findViewById(d.g.location_icon_path);
        this.bgU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Qj();
            }
        });
        this.bgV = (TextView) view.findViewById(d.g.location_text_position);
        this.bgW = (TextView) view.findViewById(d.g.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bgX != null) {
            this.bgX.destroy();
        }
        OpenLocationBottomMenu.QW();
        if (this.bhc != null) {
            this.bhc.cC(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.bgR.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.bgX = GeoCoder.newInstance();
        this.bgX.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.bgV.setText(d.j.unknown_location_info);
                    return;
                }
                String address = reverseGeoCodeResult.getAddress();
                String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                a aVar = a.this;
                if (address == null) {
                    address = a.this.getResources().getString(d.j.unknown_location_info);
                }
                aVar.mAddress = address;
                a.this.mName = sematicDescription != null ? sematicDescription : a.this.getResources().getString(d.j.unknown_location_info);
                a.this.bgW.setText(a.this.mAddress);
                a.this.bgV.setText(a.this.mName);
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.bgX.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qj() {
        FragmentActivity Sy = Sy();
        if (Sy != null) {
            if (this.bgY == null || !this.bgY.isShowing()) {
                View inflate = View.inflate(Sy, d.h.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Qk();
                    }
                });
                this.bgZ = (OpenLocationBottomMenu) inflate.findViewById(d.g.openlocation_popmenu);
                this.bgZ.setFragment(this);
                this.bgY = new PopupWindow(Sy);
                this.bgY.setContentView(inflate);
                this.bgY.setWidth(-1);
                this.bgY.setHeight(-2);
                this.bgY.setBackgroundDrawable(new BitmapDrawable());
                this.bgY.setFocusable(true);
                this.bgY.setOutsideTouchable(true);
                this.bgY.setAnimationStyle(d.k.OpenLocationBottomMenuPopupStyle);
                this.bgY.showAtLocation(this.bha, 80, 0, 0);
                this.bgY.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.ai(1.0f);
                    }
                });
                ai(0.3f);
            }
        }
    }

    public void Qk() {
        if (this.bgY != null && this.bgY.isShowing()) {
            this.bgY.dismiss();
        }
    }

    public BaiduMap Ql() {
        return this.bgS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(float f) {
        if (Sy() != null) {
            Window window = Sy().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void ar(View view) {
        this.bhb = (ImageView) view.findViewById(d.g.goMyPoint);
        this.bhb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bhc != null && a.this.bhc.PT() != null) {
                    BDLocation PT = a.this.bhc.PT();
                    a.this.bgS.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(PT.getLatitude(), PT.getLongitude())));
                }
            }
        });
    }

    private void Qm() {
        this.bhc = new c(com.baidu.swan.apps.w.e.Ec().DO(), this.bgS);
        this.bhc.cC(true);
        this.bhc.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.e.c.b
            public void d(BDLocation bDLocation) {
                a.this.bhd = bDLocation;
            }
        });
    }

    public BDLocation Qn() {
        return this.bhd;
    }

    public void cD(boolean z) {
        this.bhe = z;
    }

    public boolean Qo() {
        return this.bhe;
    }
}
