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
    private static boolean bjA;
    private static a bjz;
    private LatLng bjB;
    private boolean bjC;
    private String bjD;
    private String bjE;
    private boolean bjF;
    private OpenLocationMenuItem bjt;
    private OpenLocationMenuItem bju;
    private LinearLayout.LayoutParams bjv;
    private com.baidu.swan.impl.map.c.a bjw;
    private LatLng bjx;
    private OnGetRoutePlanResultListener bjy;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.bjC = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjC = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        QT();
    }

    private void QT() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!bjA) {
            string = this.mContext.getString(d.j.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(d.j.openlocation_bottommenu_hidepath);
        }
        this.bjt = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.bjt.a(this);
        addView(this.bjt.Qq());
        this.bjF = jh("com.baidu.BaiduMap");
        if (!this.bjF) {
        }
        OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, this.mContext.getString(d.j.openlocation_bottommenu_baidumap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP);
        openLocationMenuItem.a(this);
        if (!this.bjC) {
            ((LinearLayout.LayoutParams) openLocationMenuItem.Qq().getLayoutParams()).topMargin = x.ad(7.0f);
            this.bjC = true;
        }
        addView(openLocationMenuItem.Qq());
        if (jh("com.autonavi.minimap")) {
            OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.mContext, this.mContext.getString(d.j.openlocation_bottommenu_gaodemap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP);
            openLocationMenuItem2.a(this);
            if (!this.bjC) {
                ((LinearLayout.LayoutParams) openLocationMenuItem2.Qq().getLayoutParams()).topMargin = x.ad(7.0f);
                this.bjC = true;
            }
            addView(openLocationMenuItem2.Qq());
        }
        this.bju = new OpenLocationMenuItem(this.mContext, this.mContext.getString(d.j.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.bju.a(this);
        this.bjv = (LinearLayout.LayoutParams) this.bju.Qq().getLayoutParams();
        this.bjv.topMargin = x.ad(7.0f);
        addView(this.bju.Qq());
    }

    @Override // com.baidu.swan.impl.map.item.OpenLocationMenuItem.a
    public void b(OpenLocationMenuItem openLocationMenuItem) {
        if (this.bjw != null) {
            this.bjw.Qk();
        }
        switch (openLocationMenuItem.Qp()) {
            case OPENLOCATION_PATH:
                bjA = !bjA;
                if (!bjA) {
                    QV();
                    return;
                } else if (bjz == null) {
                    QU();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.bjw != null) {
                    a(this.bjw.Ql(), bjz);
                    this.bjw.cD(true);
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a cache path");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case OPENLOCATION_BAIDU_MAP:
                if (!this.bjF) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.baidu.BaiduMap"));
                    intent.addFlags(268435456);
                    this.mContext.startActivity(intent);
                    return;
                }
                QY();
                return;
            case OPENLOCATION_GAODE_MAP:
                QZ();
                return;
            default:
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.bjw = aVar;
    }

    private void QU() {
        if (this.bjw == null) {
            bjA = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.bjw.cD(false);
        QX();
        final com.baidu.swan.impl.map.e.a QR = com.baidu.swan.impl.map.e.a.QR();
        this.bjy = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                QR.QS();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.bjA = false;
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
                BaiduMap Ql = OpenLocationBottomMenu.this.bjw.Ql();
                if (Ql == null) {
                    boolean unused2 = OpenLocationBottomMenu.bjA = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.bjA) {
                    a unused3 = OpenLocationBottomMenu.bjz = new com.baidu.swan.impl.map.d.b(Ql);
                    Ql.setOnMarkerClickListener(OpenLocationBottomMenu.bjz);
                    OpenLocationBottomMenu.bjz.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.bjz.QO();
                    OpenLocationBottomMenu.bjz.QQ();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.bjw.cD(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.bjx == null) {
            bjA = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        QR.a(this.bjx, this.bjB, this.bjy);
    }

    private void QV() {
        if (this.bjw != null && this.bjw.Qo()) {
            if (bjz != null) {
                bjz.QP();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void QW() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        bjA = false;
        bjz = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.QO();
            aVar.QQ();
        }
    }

    private boolean jh(String str) {
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

    private void QX() {
        if (this.bjw != null) {
            if (this.bjx == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation Qn = this.bjw.Qn();
                if (Qn != null) {
                    this.bjx = new LatLng(Qn.getLatitude(), Qn.getLongitude());
                    String addrStr = Qn.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(Qn.getStreet()) ? "" : Qn.getStreet();
                    }
                    this.bjD = addrStr;
                } else {
                    return;
                }
            }
            if (this.bjB == null) {
                Bundle arguments = this.bjw.getArguments();
                this.bjB = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.bjE = string;
            }
        }
    }

    private void QY() {
        QX();
        Intent intent = new Intent();
        Uri.Builder buildUpon = Uri.parse("baidumap://map/direction?").buildUpon();
        buildUpon.appendQueryParameter("origin", "name:" + this.bjD + "|latlng:" + this.bjx.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bjx.longitude);
        buildUpon.appendQueryParameter("destination", "name:" + this.bjE + "|latlng:" + this.bjB.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bjB.longitude);
        buildUpon.appendQueryParameter("mode", "driving");
        buildUpon.appendQueryParameter("target", "1");
        buildUpon.appendQueryParameter("src", this.mContext.getPackageName());
        intent.setData(buildUpon.build());
        this.mContext.startActivity(intent);
    }

    private void QZ() {
        QX();
        Uri.Builder buildUpon = Uri.parse("androidamap://route?").buildUpon();
        buildUpon.appendQueryParameter("sourceApplication", this.mContext.getPackageName());
        buildUpon.appendQueryParameter("slat", String.valueOf(this.bjx.latitude));
        buildUpon.appendQueryParameter("slon", String.valueOf(this.bjx.longitude));
        buildUpon.appendQueryParameter("sname", this.bjD);
        buildUpon.appendQueryParameter("dlat", String.valueOf(this.bjB.latitude));
        buildUpon.appendQueryParameter("dlon", String.valueOf(this.bjB.longitude));
        buildUpon.appendQueryParameter("dname", this.bjE);
        buildUpon.appendQueryParameter("dev", "0");
        buildUpon.appendQueryParameter("t", "0");
        Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
        intent.setPackage("com.autonavi.minimap");
        this.mContext.startActivity(intent);
    }
}
