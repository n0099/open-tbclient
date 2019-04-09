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
    private static a bjD;
    private static boolean bjE;
    private com.baidu.swan.impl.map.c.a bjA;
    private LatLng bjB;
    private OnGetRoutePlanResultListener bjC;
    private LatLng bjF;
    private boolean bjG;
    private String bjH;
    private String bjI;
    private boolean bjJ;
    private OpenLocationMenuItem bjx;
    private OpenLocationMenuItem bjy;
    private LinearLayout.LayoutParams bjz;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.bjG = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjG = false;
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
        if (!bjE) {
            string = this.mContext.getString(d.j.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(d.j.openlocation_bottommenu_hidepath);
        }
        this.bjx = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.bjx.a(this);
        addView(this.bjx.Qo());
        this.bjJ = ji("com.baidu.BaiduMap");
        if (!this.bjJ) {
        }
        OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, this.mContext.getString(d.j.openlocation_bottommenu_baidumap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP);
        openLocationMenuItem.a(this);
        if (!this.bjG) {
            ((LinearLayout.LayoutParams) openLocationMenuItem.Qo().getLayoutParams()).topMargin = x.ad(7.0f);
            this.bjG = true;
        }
        addView(openLocationMenuItem.Qo());
        if (ji("com.autonavi.minimap")) {
            OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.mContext, this.mContext.getString(d.j.openlocation_bottommenu_gaodemap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP);
            openLocationMenuItem2.a(this);
            if (!this.bjG) {
                ((LinearLayout.LayoutParams) openLocationMenuItem2.Qo().getLayoutParams()).topMargin = x.ad(7.0f);
                this.bjG = true;
            }
            addView(openLocationMenuItem2.Qo());
        }
        this.bjy = new OpenLocationMenuItem(this.mContext, this.mContext.getString(d.j.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.bjy.a(this);
        this.bjz = (LinearLayout.LayoutParams) this.bjy.Qo().getLayoutParams();
        this.bjz.topMargin = x.ad(7.0f);
        addView(this.bjy.Qo());
    }

    @Override // com.baidu.swan.impl.map.item.OpenLocationMenuItem.a
    public void b(OpenLocationMenuItem openLocationMenuItem) {
        if (this.bjA != null) {
            this.bjA.Qi();
        }
        switch (openLocationMenuItem.Qn()) {
            case OPENLOCATION_PATH:
                bjE = !bjE;
                if (!bjE) {
                    QT();
                    return;
                } else if (bjD == null) {
                    QS();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.bjA != null) {
                    a(this.bjA.Qj(), bjD);
                    this.bjA.cD(true);
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a cache path");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case OPENLOCATION_BAIDU_MAP:
                if (!this.bjJ) {
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
        this.bjA = aVar;
    }

    private void QS() {
        if (this.bjA == null) {
            bjE = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.bjA.cD(false);
        QV();
        final com.baidu.swan.impl.map.e.a QP = com.baidu.swan.impl.map.e.a.QP();
        this.bjC = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                    boolean unused = OpenLocationBottomMenu.bjE = false;
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
                BaiduMap Qj = OpenLocationBottomMenu.this.bjA.Qj();
                if (Qj == null) {
                    boolean unused2 = OpenLocationBottomMenu.bjE = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.bjE) {
                    a unused3 = OpenLocationBottomMenu.bjD = new com.baidu.swan.impl.map.d.b(Qj);
                    Qj.setOnMarkerClickListener(OpenLocationBottomMenu.bjD);
                    OpenLocationBottomMenu.bjD.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.bjD.QM();
                    OpenLocationBottomMenu.bjD.QO();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.bjA.cD(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.bjB == null) {
            bjE = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        QP.a(this.bjB, this.bjF, this.bjC);
    }

    private void QT() {
        if (this.bjA != null && this.bjA.Qm()) {
            if (bjD != null) {
                bjD.QN();
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
        bjE = false;
        bjD = null;
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
        if (this.bjA != null) {
            if (this.bjB == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation Ql = this.bjA.Ql();
                if (Ql != null) {
                    this.bjB = new LatLng(Ql.getLatitude(), Ql.getLongitude());
                    String addrStr = Ql.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(Ql.getStreet()) ? "" : Ql.getStreet();
                    }
                    this.bjH = addrStr;
                } else {
                    return;
                }
            }
            if (this.bjF == null) {
                Bundle arguments = this.bjA.getArguments();
                this.bjF = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.bjI = string;
            }
        }
    }

    private void QW() {
        QV();
        Intent intent = new Intent();
        Uri.Builder buildUpon = Uri.parse("baidumap://map/direction?").buildUpon();
        buildUpon.appendQueryParameter("origin", "name:" + this.bjH + "|latlng:" + this.bjB.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bjB.longitude);
        buildUpon.appendQueryParameter("destination", "name:" + this.bjI + "|latlng:" + this.bjF.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bjF.longitude);
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
        buildUpon.appendQueryParameter("slat", String.valueOf(this.bjB.latitude));
        buildUpon.appendQueryParameter("slon", String.valueOf(this.bjB.longitude));
        buildUpon.appendQueryParameter("sname", this.bjH);
        buildUpon.appendQueryParameter("dlat", String.valueOf(this.bjF.latitude));
        buildUpon.appendQueryParameter("dlon", String.valueOf(this.bjF.longitude));
        buildUpon.appendQueryParameter("dname", this.bjI);
        buildUpon.appendQueryParameter("dev", "0");
        buildUpon.appendQueryParameter("t", "0");
        Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
        intent.setPackage("com.autonavi.minimap");
        this.mContext.startActivity(intent);
    }
}
