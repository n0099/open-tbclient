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
    private static a bIL;
    private static boolean bIM;
    private OpenLocationMenuItem bIF;
    private OpenLocationMenuItem bIG;
    private LinearLayout.LayoutParams bIH;
    private com.baidu.swan.impl.map.c.a bII;
    private LatLng bIJ;
    private OnGetRoutePlanResultListener bIK;
    private LatLng bIN;
    private boolean bIO;
    private String bIP;
    private String bIQ;
    private boolean bIR;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.bIO = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bIO = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        aam();
    }

    private void aam() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!bIM) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.bIF = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.bIF.a(this);
        addView(this.bIF.ZJ());
        this.bIR = kS("com.baidu.BaiduMap");
        if (!this.bIR) {
        }
        OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_baidumap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP);
        openLocationMenuItem.a(this);
        if (!this.bIO) {
            ((LinearLayout.LayoutParams) openLocationMenuItem.ZJ().getLayoutParams()).topMargin = z.S(7.0f);
            this.bIO = true;
        }
        addView(openLocationMenuItem.ZJ());
        if (kS("com.autonavi.minimap")) {
            OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_gaodemap), OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP);
            openLocationMenuItem2.a(this);
            if (!this.bIO) {
                ((LinearLayout.LayoutParams) openLocationMenuItem2.ZJ().getLayoutParams()).topMargin = z.S(7.0f);
                this.bIO = true;
            }
            addView(openLocationMenuItem2.ZJ());
        }
        this.bIG = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.bIG.a(this);
        this.bIH = (LinearLayout.LayoutParams) this.bIG.ZJ().getLayoutParams();
        this.bIH.topMargin = z.S(7.0f);
        addView(this.bIG.ZJ());
    }

    @Override // com.baidu.swan.impl.map.item.OpenLocationMenuItem.a
    public void b(OpenLocationMenuItem openLocationMenuItem) {
        if (this.bII != null) {
            this.bII.ZD();
        }
        switch (openLocationMenuItem.ZI()) {
            case OPENLOCATION_PATH:
                bIM = !bIM;
                if (!bIM) {
                    aao();
                    return;
                } else if (bIL == null) {
                    aan();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.bII != null) {
                    a(this.bII.ZE(), bIL);
                    this.bII.m20do(true);
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a cache path");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case OPENLOCATION_BAIDU_MAP:
                if (!this.bIR) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.baidu.BaiduMap"));
                    intent.addFlags(268435456);
                    this.mContext.startActivity(intent);
                    return;
                }
                aar();
                return;
            case OPENLOCATION_GAODE_MAP:
                aas();
                return;
            default:
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.bII = aVar;
    }

    private void aan() {
        if (this.bII == null) {
            bIM = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.bII.m20do(false);
        aaq();
        final com.baidu.swan.impl.map.e.a aak = com.baidu.swan.impl.map.e.a.aak();
        this.bIK = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                aak.aal();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.bIM = false;
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
                BaiduMap ZE = OpenLocationBottomMenu.this.bII.ZE();
                if (ZE == null) {
                    boolean unused2 = OpenLocationBottomMenu.bIM = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.bIM) {
                    a unused3 = OpenLocationBottomMenu.bIL = new com.baidu.swan.impl.map.d.b(ZE);
                    ZE.setOnMarkerClickListener(OpenLocationBottomMenu.bIL);
                    OpenLocationBottomMenu.bIL.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.bIL.aah();
                    OpenLocationBottomMenu.bIL.aaj();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.bII.m20do(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.bIJ == null) {
            bIM = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aak.a(this.bIJ, this.bIN, this.bIK);
    }

    private void aao() {
        if (this.bII != null && this.bII.ZH()) {
            if (bIL != null) {
                bIL.aai();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void aap() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        bIM = false;
        bIL = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aah();
            aVar.aaj();
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

    private void aaq() {
        if (this.bII != null) {
            if (this.bIJ == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation ZG = this.bII.ZG();
                if (ZG != null) {
                    this.bIJ = new LatLng(ZG.getLatitude(), ZG.getLongitude());
                    String addrStr = ZG.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(ZG.getStreet()) ? "" : ZG.getStreet();
                    }
                    this.bIP = addrStr;
                } else {
                    return;
                }
            }
            if (this.bIN == null) {
                Bundle arguments = this.bII.getArguments();
                this.bIN = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.bIQ = string;
            }
        }
    }

    private void aar() {
        aaq();
        Intent intent = new Intent();
        Uri.Builder buildUpon = Uri.parse("baidumap://map/direction?").buildUpon();
        buildUpon.appendQueryParameter("origin", "name:" + this.bIP + "|latlng:" + this.bIJ.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bIJ.longitude);
        buildUpon.appendQueryParameter("destination", "name:" + this.bIQ + "|latlng:" + this.bIN.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bIN.longitude);
        buildUpon.appendQueryParameter("mode", "driving");
        buildUpon.appendQueryParameter("target", "1");
        buildUpon.appendQueryParameter("src", this.mContext.getPackageName());
        intent.setData(buildUpon.build());
        this.mContext.startActivity(intent);
    }

    private void aas() {
        aaq();
        Uri.Builder buildUpon = Uri.parse("androidamap://route?").buildUpon();
        buildUpon.appendQueryParameter("sourceApplication", this.mContext.getPackageName());
        buildUpon.appendQueryParameter("slat", String.valueOf(this.bIJ.latitude));
        buildUpon.appendQueryParameter("slon", String.valueOf(this.bIJ.longitude));
        buildUpon.appendQueryParameter("sname", this.bIP);
        buildUpon.appendQueryParameter("dlat", String.valueOf(this.bIN.latitude));
        buildUpon.appendQueryParameter("dlon", String.valueOf(this.bIN.longitude));
        buildUpon.appendQueryParameter("dname", this.bIQ);
        buildUpon.appendQueryParameter("dev", "0");
        buildUpon.appendQueryParameter("t", "0");
        Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
        intent.setPackage("com.autonavi.minimap");
        this.mContext.startActivity(intent);
    }
}
