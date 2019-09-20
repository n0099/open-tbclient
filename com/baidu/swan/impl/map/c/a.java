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
    private String aud = "";
    private TextureMapView bol;
    private BaiduMap bom;
    private Marker bon;
    private ImageView boo;
    private TextView bop;
    private TextView boq;
    private GeoCoder bor;
    private PopupWindow bos;
    private OpenLocationBottomMenu bot;
    private View bou;
    private ImageView bov;
    private c bow;
    private BDLocation box;
    private boolean boy;
    private String mAddress;
    private String mName;

    public static a A(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        com.baidu.swan.impl.map.a.Ut();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.console.c.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        O(inflate);
        bd(zK());
        ax(inflate);
        ay(inflate);
        US();
        az(inflate);
        dM(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (zN()) {
            inflate = S(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    private void ax(View view) {
        this.bol = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.bom = this.bol.getMap();
        this.bom.getUiSettings().setRotateGesturesEnabled(false);
        this.bol.showZoomControls(false);
        this.bom.getUiSettings().setOverlookingGesturesEnabled(false);
        this.bom.setOnMapLoadedCallback(this);
    }

    private void UN() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.aud = arguments.getString("slaveId");
            double d = arguments.getDouble("latitude");
            double d2 = arguments.getDouble("longitude");
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString("address");
            LatLng latLng = new LatLng(d, d2);
            e(latLng);
            this.bom.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.bom.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.bon = (Marker) this.bom.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            com.baidu.swan.apps.console.c.i("map", "show marker");
        }
    }

    public void UO() {
        e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN != null) {
            vN.dU("navigateTo").B(e.arU, e.arW).c(this).AH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean zA() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xt() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zy() {
        if (this.arj == null) {
            this.arj = new g(getContext(), this.ari, 12, new com.baidu.swan.apps.view.b.b());
            this.arj.setMenuSource("swan");
            this.arj.a(com.baidu.swan.apps.u.a.Es());
            new com.baidu.swan.apps.view.coverview.c.b(this.arj, this).Qx();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void zZ() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.aud);
        com.baidu.swan.apps.w.e.GJ().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zz() {
        zy();
        this.arj.a(com.baidu.swan.apps.u.a.EJ().Fi(), zW(), zX());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xH() {
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
        UN();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.bon && !TextUtils.isEmpty(this.mName)) {
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
            this.bom.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void ay(View view) {
        this.bou = view;
        this.boo = (ImageView) view.findViewById(R.id.location_icon_path);
        this.boo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.UP();
            }
        });
        this.bop = (TextView) view.findViewById(R.id.location_text_position);
        this.boq = (TextView) view.findViewById(R.id.location_text_address);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bor != null) {
            this.bor.destroy();
        }
        OpenLocationBottomMenu.VC();
        if (this.bow != null) {
            this.bow.cW(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.bol.onDestroy();
        }
    }

    private void e(LatLng latLng) {
        this.bor = GeoCoder.newInstance();
        this.bor.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.swan.impl.map.c.a.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    a.this.bop.setText(R.string.unknown_location_info);
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
                a.this.boq.setText(a.this.mAddress);
                a.this.bop.setText(a.this.mName);
                com.baidu.swan.apps.console.c.i("map", "mAddress +" + a.this.mAddress + " mName" + a.this.mName);
            }
        });
        this.bor.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UP() {
        FragmentActivity Xg = Xg();
        if (Xg != null) {
            if (this.bos == null || !this.bos.isShowing()) {
                View inflate = View.inflate(Xg, R.layout.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.UQ();
                    }
                });
                this.bot = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
                this.bot.setFragment(this);
                this.bos = new PopupWindow(Xg);
                this.bos.setContentView(inflate);
                this.bos.setWidth(-1);
                this.bos.setHeight(-2);
                this.bos.setBackgroundDrawable(new BitmapDrawable());
                this.bos.setFocusable(true);
                this.bos.df(true);
                this.bos.setAnimationStyle(R.style.OpenLocationBottomMenuPopupStyle);
                this.bos.a(this.bou, 80, 0, 0);
                this.bos.a(new PopupWindow.a() { // from class: com.baidu.swan.impl.map.c.a.4
                    @Override // com.baidu.swan.menu.PopupWindow.a
                    public void onDismiss() {
                        a.this.ak(1.0f);
                    }
                });
                ak(0.3f);
            }
        }
    }

    public void UQ() {
        if (this.bos != null && this.bos.isShowing()) {
            this.bos.dismiss();
        }
    }

    public BaiduMap UR() {
        return this.bom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(float f) {
        if (Xg() != null) {
            Window window = Xg().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void az(View view) {
        this.bov = (ImageView) view.findViewById(R.id.goMyPoint);
        this.bov.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.c.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bow != null && a.this.bow.Uz() != null) {
                    BDLocation Uz = a.this.bow.Uz();
                    a.this.bom.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(Uz.getLatitude(), Uz.getLongitude())));
                }
            }
        });
    }

    private void US() {
        this.bow = new c(com.baidu.swan.apps.w.e.GJ().Gv(), this.bom);
        this.bow.cW(true);
        this.bow.a(new c.b() { // from class: com.baidu.swan.impl.map.c.a.6
            @Override // com.baidu.swan.impl.map.e.c.b
            public void d(BDLocation bDLocation) {
                a.this.box = bDLocation;
            }
        });
    }

    public BDLocation UT() {
        return this.box;
    }

    public void cX(boolean z) {
        this.boy = z;
    }

    public boolean UU() {
        return this.boy;
    }
}
