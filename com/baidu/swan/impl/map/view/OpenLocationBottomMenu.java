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
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.impl.map.d.a;
import com.baidu.swan.impl.map.item.OpenLocationMenuItem;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.a {
    protected static final boolean DEBUG = b.DEBUG;
    private static a bjC;
    private static boolean bjD;
    private LatLng bjA;
    private OnGetRoutePlanResultListener bjB;
    private LatLng bjE;
    private boolean bjF;
    private String bjG;
    private String bjH;
    private boolean bjI;
    private OpenLocationMenuItem bjw;
    private OpenLocationMenuItem bjx;
    private LinearLayout.LayoutParams bjy;
    private com.baidu.swan.impl.map.c.a bjz;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.bjF = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjF = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        QR();
    }

    private void QR() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!bjD) {
            string = this.mContext.getString(d.j.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(d.j.openlocation_bottommenu_hidepath);
        }
        this.bjw = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.bjw.a(this);
        addView(this.bjw.Qo());
        this.bjI = ji("com.baidu.BaiduMap");
        if (!this.bjI) {
        }
        OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, this.mContext.getString(d.j.openlocation_bottommenu_baidumap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP);
        openLocationMenuItem.a(this);
        if (!this.bjF) {
            ((LinearLayout.LayoutParams) openLocationMenuItem.Qo().getLayoutParams()).topMargin = x.ad(7.0f);
            this.bjF = true;
        }
        addView(openLocationMenuItem.Qo());
        if (ji("com.autonavi.minimap")) {
            OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.mContext, this.mContext.getString(d.j.openlocation_bottommenu_gaodemap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP);
            openLocationMenuItem2.a(this);
            if (!this.bjF) {
                ((LinearLayout.LayoutParams) openLocationMenuItem2.Qo().getLayoutParams()).topMargin = x.ad(7.0f);
                this.bjF = true;
            }
            addView(openLocationMenuItem2.Qo());
        }
        this.bjx = new OpenLocationMenuItem(this.mContext, this.mContext.getString(d.j.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.bjx.a(this);
        this.bjy = (LinearLayout.LayoutParams) this.bjx.Qo().getLayoutParams();
        this.bjy.topMargin = x.ad(7.0f);
        addView(this.bjx.Qo());
    }

    @Override // com.baidu.swan.impl.map.item.OpenLocationMenuItem.a
    public void b(OpenLocationMenuItem openLocationMenuItem) {
        if (this.bjz != null) {
            this.bjz.Qi();
        }
        switch (openLocationMenuItem.Qn()) {
            case OPENLOCATION_PATH:
                bjD = !bjD;
                if (!bjD) {
                    QT();
                    return;
                } else if (bjC == null) {
                    QS();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.bjz != null) {
                    a(this.bjz.Qj(), bjC);
                    this.bjz.cD(true);
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a cache path");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case OPENLOCATION_BAIDU_MAP:
                if (!this.bjI) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.baidu.BaiduMap"));
                    intent.addFlags(268435456);
                    this.mContext.startActivity(intent);
                    return;
                }
                QW();
                return;
            case OPENLOCATION_GAODE_MAP:
                QX();
                return;
            default:
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.bjz = aVar;
    }

    private void QS() {
        if (this.bjz == null) {
            bjD = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.bjz.cD(false);
        QV();
        final com.baidu.swan.impl.map.e.a QP = com.baidu.swan.impl.map.e.a.QP();
        this.bjB = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                QP.QQ();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.bjD = false;
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
                BaiduMap Qj = OpenLocationBottomMenu.this.bjz.Qj();
                if (Qj == null) {
                    boolean unused2 = OpenLocationBottomMenu.bjD = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.bjD) {
                    a unused3 = OpenLocationBottomMenu.bjC = new com.baidu.swan.impl.map.d.b(Qj);
                    Qj.setOnMarkerClickListener(OpenLocationBottomMenu.bjC);
                    OpenLocationBottomMenu.bjC.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.bjC.QM();
                    OpenLocationBottomMenu.bjC.QO();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.bjz.cD(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.bjA == null) {
            bjD = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        QP.a(this.bjA, this.bjE, this.bjB);
    }

    private void QT() {
        if (this.bjz != null && this.bjz.Qm()) {
            if (bjC != null) {
                bjC.QN();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void QU() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        bjD = false;
        bjC = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.QM();
            aVar.QO();
        }
    }

    private boolean ji(String str) {
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

    private void QV() {
        if (this.bjz != null) {
            if (this.bjA == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation Ql = this.bjz.Ql();
                if (Ql != null) {
                    this.bjA = new LatLng(Ql.getLatitude(), Ql.getLongitude());
                    String addrStr = Ql.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(Ql.getStreet()) ? "" : Ql.getStreet();
                    }
                    this.bjG = addrStr;
                } else {
                    return;
                }
            }
            if (this.bjE == null) {
                Bundle arguments = this.bjz.getArguments();
                this.bjE = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.bjH = string;
            }
        }
    }

    private void QW() {
        QV();
        Intent intent = new Intent();
        Uri.Builder buildUpon = Uri.parse("baidumap://map/direction?").buildUpon();
        buildUpon.appendQueryParameter("origin", "name:" + this.bjG + "|latlng:" + this.bjA.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bjA.longitude);
        buildUpon.appendQueryParameter("destination", "name:" + this.bjH + "|latlng:" + this.bjE.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bjE.longitude);
        buildUpon.appendQueryParameter("mode", "driving");
        buildUpon.appendQueryParameter("target", "1");
        buildUpon.appendQueryParameter("src", this.mContext.getPackageName());
        intent.setData(buildUpon.build());
        this.mContext.startActivity(intent);
    }

    private void QX() {
        QV();
        Uri.Builder buildUpon = Uri.parse("androidamap://route?").buildUpon();
        buildUpon.appendQueryParameter("sourceApplication", this.mContext.getPackageName());
        buildUpon.appendQueryParameter("slat", String.valueOf(this.bjA.latitude));
        buildUpon.appendQueryParameter("slon", String.valueOf(this.bjA.longitude));
        buildUpon.appendQueryParameter("sname", this.bjG);
        buildUpon.appendQueryParameter("dlat", String.valueOf(this.bjE.latitude));
        buildUpon.appendQueryParameter("dlon", String.valueOf(this.bjE.longitude));
        buildUpon.appendQueryParameter("dname", this.bjH);
        buildUpon.appendQueryParameter("dev", "0");
        buildUpon.appendQueryParameter("t", "0");
        Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
        intent.setPackage("com.autonavi.minimap");
        this.mContext.startActivity(intent);
    }
}
