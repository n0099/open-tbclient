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
    private static a bqt;
    private static boolean bqu;
    private OpenLocationMenuItem bqn;
    private OpenLocationMenuItem bqo;
    private LinearLayout.LayoutParams bqp;
    private com.baidu.swan.impl.map.c.a bqq;
    private LatLng bqr;
    private OnGetRoutePlanResultListener bqs;
    private LatLng bqv;
    private boolean bqw;
    private String bqx;
    private String bqy;
    private boolean bqz;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.bqw = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqw = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        Vv();
    }

    private void Vv() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!bqu) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.bqn = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.bqn.a(this);
        addView(this.bqn.US());
        this.bqz = ko("com.baidu.BaiduMap");
        if (!this.bqz) {
        }
        OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_baidumap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP);
        openLocationMenuItem.a(this);
        if (!this.bqw) {
            ((LinearLayout.LayoutParams) openLocationMenuItem.US().getLayoutParams()).topMargin = z.ad(7.0f);
            this.bqw = true;
        }
        addView(openLocationMenuItem.US());
        if (ko("com.autonavi.minimap")) {
            OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_gaodemap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP);
            openLocationMenuItem2.a(this);
            if (!this.bqw) {
                ((LinearLayout.LayoutParams) openLocationMenuItem2.US().getLayoutParams()).topMargin = z.ad(7.0f);
                this.bqw = true;
            }
            addView(openLocationMenuItem2.US());
        }
        this.bqo = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.bqo.a(this);
        this.bqp = (LinearLayout.LayoutParams) this.bqo.US().getLayoutParams();
        this.bqp.topMargin = z.ad(7.0f);
        addView(this.bqo.US());
    }

    @Override // com.baidu.swan.impl.map.item.OpenLocationMenuItem.a
    public void b(OpenLocationMenuItem openLocationMenuItem) {
        if (this.bqq != null) {
            this.bqq.UM();
        }
        switch (openLocationMenuItem.UR()) {
            case OPENLOCATION_PATH:
                bqu = !bqu;
                if (!bqu) {
                    Vx();
                    return;
                } else if (bqt == null) {
                    Vw();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.bqq != null) {
                    a(this.bqq.UN(), bqt);
                    this.bqq.cX(true);
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a cache path");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case OPENLOCATION_BAIDU_MAP:
                if (!this.bqz) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.baidu.BaiduMap"));
                    intent.addFlags(268435456);
                    this.mContext.startActivity(intent);
                    return;
                }
                VA();
                return;
            case OPENLOCATION_GAODE_MAP:
                VB();
                return;
            default:
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.bqq = aVar;
    }

    private void Vw() {
        if (this.bqq == null) {
            bqu = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.bqq.cX(false);
        Vz();
        final com.baidu.swan.impl.map.e.a Vt = com.baidu.swan.impl.map.e.a.Vt();
        this.bqs = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                Vt.Vu();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.bqu = false;
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
                BaiduMap UN = OpenLocationBottomMenu.this.bqq.UN();
                if (UN == null) {
                    boolean unused2 = OpenLocationBottomMenu.bqu = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.bqu) {
                    a unused3 = OpenLocationBottomMenu.bqt = new com.baidu.swan.impl.map.d.b(UN);
                    UN.setOnMarkerClickListener(OpenLocationBottomMenu.bqt);
                    OpenLocationBottomMenu.bqt.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.bqt.Vq();
                    OpenLocationBottomMenu.bqt.Vs();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.bqq.cX(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.bqr == null) {
            bqu = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        Vt.a(this.bqr, this.bqv, this.bqs);
    }

    private void Vx() {
        if (this.bqq != null && this.bqq.UQ()) {
            if (bqt != null) {
                bqt.Vr();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void Vy() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        bqu = false;
        bqt = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.Vq();
            aVar.Vs();
        }
    }

    private boolean ko(String str) {
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

    private void Vz() {
        if (this.bqq != null) {
            if (this.bqr == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation UP = this.bqq.UP();
                if (UP != null) {
                    this.bqr = new LatLng(UP.getLatitude(), UP.getLongitude());
                    String addrStr = UP.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(UP.getStreet()) ? "" : UP.getStreet();
                    }
                    this.bqx = addrStr;
                } else {
                    return;
                }
            }
            if (this.bqv == null) {
                Bundle arguments = this.bqq.getArguments();
                this.bqv = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.bqy = string;
            }
        }
    }

    private void VA() {
        Vz();
        Intent intent = new Intent();
        Uri.Builder buildUpon = Uri.parse("baidumap://map/direction?").buildUpon();
        buildUpon.appendQueryParameter("origin", "name:" + this.bqx + "|latlng:" + this.bqr.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bqr.longitude);
        buildUpon.appendQueryParameter("destination", "name:" + this.bqy + "|latlng:" + this.bqv.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bqv.longitude);
        buildUpon.appendQueryParameter("mode", "driving");
        buildUpon.appendQueryParameter("target", "1");
        buildUpon.appendQueryParameter("src", this.mContext.getPackageName());
        intent.setData(buildUpon.build());
        this.mContext.startActivity(intent);
    }

    private void VB() {
        Vz();
        Uri.Builder buildUpon = Uri.parse("androidamap://route?").buildUpon();
        buildUpon.appendQueryParameter("sourceApplication", this.mContext.getPackageName());
        buildUpon.appendQueryParameter("slat", String.valueOf(this.bqr.latitude));
        buildUpon.appendQueryParameter("slon", String.valueOf(this.bqr.longitude));
        buildUpon.appendQueryParameter("sname", this.bqx);
        buildUpon.appendQueryParameter("dlat", String.valueOf(this.bqv.latitude));
        buildUpon.appendQueryParameter("dlon", String.valueOf(this.bqv.longitude));
        buildUpon.appendQueryParameter("dname", this.bqy);
        buildUpon.appendQueryParameter("dev", "0");
        buildUpon.appendQueryParameter("t", "0");
        Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
        intent.setPackage("com.autonavi.minimap");
        this.mContext.startActivity(intent);
    }
}
