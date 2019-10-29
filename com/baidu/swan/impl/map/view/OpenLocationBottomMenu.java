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
    private static a bJC;
    private static boolean bJD;
    private LatLng bJA;
    private OnGetRoutePlanResultListener bJB;
    private LatLng bJE;
    private boolean bJF;
    private String bJG;
    private String bJH;
    private boolean bJI;
    private OpenLocationMenuItem bJw;
    private OpenLocationMenuItem bJx;
    private LinearLayout.LayoutParams bJy;
    private com.baidu.swan.impl.map.c.a bJz;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.bJF = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJF = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        aao();
    }

    private void aao() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!bJD) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.bJw = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.bJw.a(this);
        addView(this.bJw.ZL());
        this.bJI = kS("com.baidu.BaiduMap");
        if (!this.bJI) {
        }
        OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_baidumap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP);
        openLocationMenuItem.a(this);
        if (!this.bJF) {
            ((LinearLayout.LayoutParams) openLocationMenuItem.ZL().getLayoutParams()).topMargin = z.S(7.0f);
            this.bJF = true;
        }
        addView(openLocationMenuItem.ZL());
        if (kS("com.autonavi.minimap")) {
            OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_gaodemap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP);
            openLocationMenuItem2.a(this);
            if (!this.bJF) {
                ((LinearLayout.LayoutParams) openLocationMenuItem2.ZL().getLayoutParams()).topMargin = z.S(7.0f);
                this.bJF = true;
            }
            addView(openLocationMenuItem2.ZL());
        }
        this.bJx = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.bJx.a(this);
        this.bJy = (LinearLayout.LayoutParams) this.bJx.ZL().getLayoutParams();
        this.bJy.topMargin = z.S(7.0f);
        addView(this.bJx.ZL());
    }

    @Override // com.baidu.swan.impl.map.item.OpenLocationMenuItem.a
    public void b(OpenLocationMenuItem openLocationMenuItem) {
        if (this.bJz != null) {
            this.bJz.ZF();
        }
        switch (openLocationMenuItem.ZK()) {
            case OPENLOCATION_PATH:
                bJD = !bJD;
                if (!bJD) {
                    aaq();
                    return;
                } else if (bJC == null) {
                    aap();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.bJz != null) {
                    a(this.bJz.ZG(), bJC);
                    this.bJz.m20do(true);
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a cache path");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case OPENLOCATION_BAIDU_MAP:
                if (!this.bJI) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.baidu.BaiduMap"));
                    intent.addFlags(268435456);
                    this.mContext.startActivity(intent);
                    return;
                }
                aat();
                return;
            case OPENLOCATION_GAODE_MAP:
                aau();
                return;
            default:
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.bJz = aVar;
    }

    private void aap() {
        if (this.bJz == null) {
            bJD = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.bJz.m20do(false);
        aas();
        final com.baidu.swan.impl.map.e.a aam = com.baidu.swan.impl.map.e.a.aam();
        this.bJB = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                aam.aan();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.bJD = false;
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
                BaiduMap ZG = OpenLocationBottomMenu.this.bJz.ZG();
                if (ZG == null) {
                    boolean unused2 = OpenLocationBottomMenu.bJD = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.bJD) {
                    a unused3 = OpenLocationBottomMenu.bJC = new com.baidu.swan.impl.map.d.b(ZG);
                    ZG.setOnMarkerClickListener(OpenLocationBottomMenu.bJC);
                    OpenLocationBottomMenu.bJC.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.bJC.aaj();
                    OpenLocationBottomMenu.bJC.aal();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.bJz.m20do(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.bJA == null) {
            bJD = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aam.a(this.bJA, this.bJE, this.bJB);
    }

    private void aaq() {
        if (this.bJz != null && this.bJz.ZJ()) {
            if (bJC != null) {
                bJC.aak();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void aar() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        bJD = false;
        bJC = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aaj();
            aVar.aal();
        }
    }

    private boolean kS(String str) {
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

    private void aas() {
        if (this.bJz != null) {
            if (this.bJA == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation ZI = this.bJz.ZI();
                if (ZI != null) {
                    this.bJA = new LatLng(ZI.getLatitude(), ZI.getLongitude());
                    String addrStr = ZI.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(ZI.getStreet()) ? "" : ZI.getStreet();
                    }
                    this.bJG = addrStr;
                } else {
                    return;
                }
            }
            if (this.bJE == null) {
                Bundle arguments = this.bJz.getArguments();
                this.bJE = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.bJH = string;
            }
        }
    }

    private void aat() {
        aas();
        Intent intent = new Intent();
        Uri.Builder buildUpon = Uri.parse("baidumap://map/direction?").buildUpon();
        buildUpon.appendQueryParameter("origin", "name:" + this.bJG + "|latlng:" + this.bJA.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bJA.longitude);
        buildUpon.appendQueryParameter("destination", "name:" + this.bJH + "|latlng:" + this.bJE.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bJE.longitude);
        buildUpon.appendQueryParameter("mode", "driving");
        buildUpon.appendQueryParameter("target", "1");
        buildUpon.appendQueryParameter("src", this.mContext.getPackageName());
        intent.setData(buildUpon.build());
        this.mContext.startActivity(intent);
    }

    private void aau() {
        aas();
        Uri.Builder buildUpon = Uri.parse("androidamap://route?").buildUpon();
        buildUpon.appendQueryParameter("sourceApplication", this.mContext.getPackageName());
        buildUpon.appendQueryParameter("slat", String.valueOf(this.bJA.latitude));
        buildUpon.appendQueryParameter("slon", String.valueOf(this.bJA.longitude));
        buildUpon.appendQueryParameter("sname", this.bJG);
        buildUpon.appendQueryParameter("dlat", String.valueOf(this.bJE.latitude));
        buildUpon.appendQueryParameter("dlon", String.valueOf(this.bJE.longitude));
        buildUpon.appendQueryParameter("dname", this.bJH);
        buildUpon.appendQueryParameter("dev", "0");
        buildUpon.appendQueryParameter("t", "0");
        Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
        intent.setPackage("com.autonavi.minimap");
        this.mContext.startActivity(intent);
    }
}
