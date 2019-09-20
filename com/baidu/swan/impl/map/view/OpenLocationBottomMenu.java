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
    private static a bqR;
    private static boolean bqS;
    private OpenLocationMenuItem bqL;
    private OpenLocationMenuItem bqM;
    private LinearLayout.LayoutParams bqN;
    private com.baidu.swan.impl.map.c.a bqO;
    private LatLng bqP;
    private OnGetRoutePlanResultListener bqQ;
    private LatLng bqT;
    private boolean bqU;
    private String bqV;
    private String bqW;
    private boolean bqX;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.bqU = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqU = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        Vz();
    }

    private void Vz() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!bqS) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.bqL = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.bqL.a(this);
        addView(this.bqL.UW());
        this.bqX = kq("com.baidu.BaiduMap");
        if (!this.bqX) {
        }
        OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_baidumap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP);
        openLocationMenuItem.a(this);
        if (!this.bqU) {
            ((LinearLayout.LayoutParams) openLocationMenuItem.UW().getLayoutParams()).topMargin = z.ad(7.0f);
            this.bqU = true;
        }
        addView(openLocationMenuItem.UW());
        if (kq("com.autonavi.minimap")) {
            OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_gaodemap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP);
            openLocationMenuItem2.a(this);
            if (!this.bqU) {
                ((LinearLayout.LayoutParams) openLocationMenuItem2.UW().getLayoutParams()).topMargin = z.ad(7.0f);
                this.bqU = true;
            }
            addView(openLocationMenuItem2.UW());
        }
        this.bqM = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.bqM.a(this);
        this.bqN = (LinearLayout.LayoutParams) this.bqM.UW().getLayoutParams();
        this.bqN.topMargin = z.ad(7.0f);
        addView(this.bqM.UW());
    }

    @Override // com.baidu.swan.impl.map.item.OpenLocationMenuItem.a
    public void b(OpenLocationMenuItem openLocationMenuItem) {
        if (this.bqO != null) {
            this.bqO.UQ();
        }
        switch (openLocationMenuItem.UV()) {
            case OPENLOCATION_PATH:
                bqS = !bqS;
                if (!bqS) {
                    VB();
                    return;
                } else if (bqR == null) {
                    VA();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.bqO != null) {
                    a(this.bqO.UR(), bqR);
                    this.bqO.cX(true);
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a cache path");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case OPENLOCATION_BAIDU_MAP:
                if (!this.bqX) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.baidu.BaiduMap"));
                    intent.addFlags(268435456);
                    this.mContext.startActivity(intent);
                    return;
                }
                VE();
                return;
            case OPENLOCATION_GAODE_MAP:
                VF();
                return;
            default:
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.bqO = aVar;
    }

    private void VA() {
        if (this.bqO == null) {
            bqS = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.bqO.cX(false);
        VD();
        final com.baidu.swan.impl.map.e.a Vx = com.baidu.swan.impl.map.e.a.Vx();
        this.bqQ = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                Vx.Vy();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.bqS = false;
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
                BaiduMap UR = OpenLocationBottomMenu.this.bqO.UR();
                if (UR == null) {
                    boolean unused2 = OpenLocationBottomMenu.bqS = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.bqS) {
                    a unused3 = OpenLocationBottomMenu.bqR = new com.baidu.swan.impl.map.d.b(UR);
                    UR.setOnMarkerClickListener(OpenLocationBottomMenu.bqR);
                    OpenLocationBottomMenu.bqR.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.bqR.Vu();
                    OpenLocationBottomMenu.bqR.Vw();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.bqO.cX(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.bqP == null) {
            bqS = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        Vx.a(this.bqP, this.bqT, this.bqQ);
    }

    private void VB() {
        if (this.bqO != null && this.bqO.UU()) {
            if (bqR != null) {
                bqR.Vv();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void VC() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        bqS = false;
        bqR = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.Vu();
            aVar.Vw();
        }
    }

    private boolean kq(String str) {
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

    private void VD() {
        if (this.bqO != null) {
            if (this.bqP == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation UT = this.bqO.UT();
                if (UT != null) {
                    this.bqP = new LatLng(UT.getLatitude(), UT.getLongitude());
                    String addrStr = UT.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(UT.getStreet()) ? "" : UT.getStreet();
                    }
                    this.bqV = addrStr;
                } else {
                    return;
                }
            }
            if (this.bqT == null) {
                Bundle arguments = this.bqO.getArguments();
                this.bqT = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.bqW = string;
            }
        }
    }

    private void VE() {
        VD();
        Intent intent = new Intent();
        Uri.Builder buildUpon = Uri.parse("baidumap://map/direction?").buildUpon();
        buildUpon.appendQueryParameter("origin", "name:" + this.bqV + "|latlng:" + this.bqP.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bqP.longitude);
        buildUpon.appendQueryParameter("destination", "name:" + this.bqW + "|latlng:" + this.bqT.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bqT.longitude);
        buildUpon.appendQueryParameter("mode", "driving");
        buildUpon.appendQueryParameter("target", "1");
        buildUpon.appendQueryParameter("src", this.mContext.getPackageName());
        intent.setData(buildUpon.build());
        this.mContext.startActivity(intent);
    }

    private void VF() {
        VD();
        Uri.Builder buildUpon = Uri.parse("androidamap://route?").buildUpon();
        buildUpon.appendQueryParameter("sourceApplication", this.mContext.getPackageName());
        buildUpon.appendQueryParameter("slat", String.valueOf(this.bqP.latitude));
        buildUpon.appendQueryParameter("slon", String.valueOf(this.bqP.longitude));
        buildUpon.appendQueryParameter("sname", this.bqV);
        buildUpon.appendQueryParameter("dlat", String.valueOf(this.bqT.latitude));
        buildUpon.appendQueryParameter("dlon", String.valueOf(this.bqT.longitude));
        buildUpon.appendQueryParameter("dname", this.bqW);
        buildUpon.appendQueryParameter("dev", "0");
        buildUpon.appendQueryParameter("t", "0");
        Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
        intent.setPackage("com.autonavi.minimap");
        this.mContext.startActivity(intent);
    }
}
