package com.baidu.swan.impl.map.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b;
import com.baidu.swan.impl.map.d.a;
import com.baidu.swan.impl.map.item.OpenLocationMenuItem;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.a {
    protected static final boolean DEBUG = b.DEBUG;
    private static a bpG;
    private static boolean bpH;
    private OpenLocationMenuItem bpA;
    private OpenLocationMenuItem bpB;
    private LinearLayout.LayoutParams bpC;
    private com.baidu.swan.impl.map.c.a bpD;
    private LatLng bpE;
    private OnGetRoutePlanResultListener bpF;
    private LatLng bpI;
    private boolean bpJ;
    private String bpK;
    private String bpL;
    private boolean bpM;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.bpJ = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bpJ = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        UD();
    }

    private void UD() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!bpH) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.bpA = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.bpA.a(this);
        addView(this.bpA.Ua());
        this.bpM = kh("com.baidu.BaiduMap");
        if (!this.bpM) {
        }
        OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_baidumap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP);
        openLocationMenuItem.a(this);
        if (!this.bpJ) {
            ((LinearLayout.LayoutParams) openLocationMenuItem.Ua().getLayoutParams()).topMargin = z.ad(7.0f);
            this.bpJ = true;
        }
        addView(openLocationMenuItem.Ua());
        if (kh("com.autonavi.minimap")) {
            OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_gaodemap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP);
            openLocationMenuItem2.a(this);
            if (!this.bpJ) {
                ((LinearLayout.LayoutParams) openLocationMenuItem2.Ua().getLayoutParams()).topMargin = z.ad(7.0f);
                this.bpJ = true;
            }
            addView(openLocationMenuItem2.Ua());
        }
        this.bpB = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.bpB.a(this);
        this.bpC = (LinearLayout.LayoutParams) this.bpB.Ua().getLayoutParams();
        this.bpC.topMargin = z.ad(7.0f);
        addView(this.bpB.Ua());
    }

    @Override // com.baidu.swan.impl.map.item.OpenLocationMenuItem.a
    public void b(OpenLocationMenuItem openLocationMenuItem) {
        if (this.bpD != null) {
            this.bpD.TU();
        }
        switch (openLocationMenuItem.TZ()) {
            case OPENLOCATION_PATH:
                bpH = !bpH;
                if (!bpH) {
                    UF();
                    return;
                } else if (bpG == null) {
                    UE();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.bpD != null) {
                    a(this.bpD.TV(), bpG);
                    this.bpD.cU(true);
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a cache path");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case OPENLOCATION_BAIDU_MAP:
                if (!this.bpM) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.baidu.BaiduMap"));
                    intent.addFlags(268435456);
                    this.mContext.startActivity(intent);
                    return;
                }
                UI();
                return;
            case OPENLOCATION_GAODE_MAP:
                UJ();
                return;
            default:
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.bpD = aVar;
    }

    private void UE() {
        if (this.bpD == null) {
            bpH = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.bpD.cU(false);
        UH();
        final com.baidu.swan.impl.map.e.a UB = com.baidu.swan.impl.map.e.a.UB();
        this.bpF = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetTransitRouteResult(TransitRouteResult transitRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult) {
                if (OpenLocationBottomMenu.DEBUG) {
                    Log.e("OpenLocationBottomMenu", "onGetDrivingRouteResult thread  " + Thread.currentThread().getName());
                }
                UB.UC();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.bpH = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        if (drivingRouteResult == null) {
                            Log.e("OpenLocationBottomMenu", "onGetDrivingRouteResult error, result is null ");
                            return;
                        } else {
                            Log.e("OpenLocationBottomMenu", "onGetDrivingRouteResult error, error code = " + drivingRouteResult.error);
                            return;
                        }
                    }
                    return;
                }
                BaiduMap TV = OpenLocationBottomMenu.this.bpD.TV();
                if (TV == null) {
                    boolean unused2 = OpenLocationBottomMenu.bpH = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.bpH) {
                    a unused3 = OpenLocationBottomMenu.bpG = new com.baidu.swan.impl.map.d.b(TV);
                    TV.setOnMarkerClickListener(OpenLocationBottomMenu.bpG);
                    OpenLocationBottomMenu.bpG.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.bpG.Uy();
                    OpenLocationBottomMenu.bpG.UA();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.bpD.cU(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.bpE == null) {
            bpH = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        UB.a(this.bpE, this.bpI, this.bpF);
    }

    private void UF() {
        if (this.bpD != null && this.bpD.TY()) {
            if (bpG != null) {
                bpG.Uz();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void UG() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        bpH = false;
        bpG = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.Uy();
            aVar.UA();
        }
    }

    private boolean kh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return this.mContext.getApplicationContext().getPackageManager().getApplicationInfo(str, 8192) != null;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.e("TAG", "[OpenLocationBottomMenu@isAppInstalled] e: " + e);
                return false;
            }
            return false;
        }
    }

    private void UH() {
        if (this.bpD != null) {
            if (this.bpE == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation TX = this.bpD.TX();
                if (TX != null) {
                    this.bpE = new LatLng(TX.getLatitude(), TX.getLongitude());
                    String addrStr = TX.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(TX.getStreet()) ? "" : TX.getStreet();
                    }
                    this.bpK = addrStr;
                } else {
                    return;
                }
            }
            if (this.bpI == null) {
                Bundle arguments = this.bpD.getArguments();
                this.bpI = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.bpL = string;
            }
        }
    }

    private void UI() {
        UH();
        Intent intent = new Intent();
        Uri.Builder buildUpon = Uri.parse("baidumap://map/direction?").buildUpon();
        buildUpon.appendQueryParameter("origin", "name:" + this.bpK + "|latlng:" + this.bpE.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bpE.longitude);
        buildUpon.appendQueryParameter("destination", "name:" + this.bpL + "|latlng:" + this.bpI.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bpI.longitude);
        buildUpon.appendQueryParameter("mode", "driving");
        buildUpon.appendQueryParameter("target", "1");
        buildUpon.appendQueryParameter("src", this.mContext.getPackageName());
        intent.setData(buildUpon.build());
        this.mContext.startActivity(intent);
    }

    private void UJ() {
        UH();
        Uri.Builder buildUpon = Uri.parse("androidamap://route?").buildUpon();
        buildUpon.appendQueryParameter("sourceApplication", this.mContext.getPackageName());
        buildUpon.appendQueryParameter("slat", String.valueOf(this.bpE.latitude));
        buildUpon.appendQueryParameter("slon", String.valueOf(this.bpE.longitude));
        buildUpon.appendQueryParameter("sname", this.bpK);
        buildUpon.appendQueryParameter("dlat", String.valueOf(this.bpI.latitude));
        buildUpon.appendQueryParameter("dlon", String.valueOf(this.bpI.longitude));
        buildUpon.appendQueryParameter("dname", this.bpL);
        buildUpon.appendQueryParameter("dev", "0");
        buildUpon.appendQueryParameter("t", "0");
        Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
        intent.setPackage("com.autonavi.minimap");
        this.mContext.startActivity(intent);
    }
}
