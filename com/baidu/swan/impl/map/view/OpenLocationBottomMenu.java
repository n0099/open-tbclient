package com.baidu.swan.impl.map.view;

import android.content.Context;
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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.b;
import com.baidu.swan.impl.map.d.c;
import com.baidu.swan.impl.map.e.a;
import com.baidu.swan.impl.map.item.OpenLocationMenuItem;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.a {
    protected static final boolean DEBUG = b.DEBUG;
    private static final List<String> ctW = Arrays.asList("BaiduMap", "GaodeMap");
    private static a cud;
    private static boolean cue;
    private OpenLocationMenuItem ctX;
    private OpenLocationMenuItem ctY;
    private LinearLayout.LayoutParams ctZ;
    private com.baidu.swan.impl.map.c.a cua;
    private LatLng cub;
    private OnGetRoutePlanResultListener cuc;
    private LatLng cuf;
    private boolean cug;
    private String cuh;
    private String cui;
    private Map<OpenLocationMenuItem.MenuItemType, c> cuj;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.cug = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cug = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void apW() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!cue) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.ctX = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.ctX.a(this);
        addView(this.ctX.apt());
        this.cuj = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.cuj.keySet()) {
            c cVar = this.cuj.get(menuItemType);
            if (cVar.dv(this.mContext) || cVar.apO()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.cug) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.apt().getLayoutParams()).topMargin = af.T(7.0f);
                    this.cug = true;
                }
                addView(openLocationMenuItem.apt());
            }
        }
        this.ctY = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.ctY.a(this);
        this.ctZ = (LinearLayout.LayoutParams) this.ctY.apt().getLayoutParams();
        this.ctZ.topMargin = af.T(7.0f);
        addView(this.ctY.apt());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(ctW);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.cua != null) {
            List<String> apr = this.cua.apr();
            if (apr != null) {
                apr.remove("BaiduMap");
                arrayList.removeAll(apr);
            }
            for (String str : arrayList) {
                switch (str.hashCode()) {
                    case -1943115423:
                        if (str.equals("BaiduMap")) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case -1647700090:
                        if (str.equals("GaodeMap")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP, new com.baidu.swan.impl.map.d.a(this.mContext));
                        break;
                    case true:
                        linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP, new com.baidu.swan.impl.map.d.b(this.mContext));
                        break;
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.baidu.swan.impl.map.item.OpenLocationMenuItem.a
    public void b(OpenLocationMenuItem openLocationMenuItem) {
        if (this.cua != null) {
            this.cua.apm();
        }
        OpenLocationMenuItem.MenuItemType aps = openLocationMenuItem.aps();
        switch (aps) {
            case OPENLOCATION_PATH:
                cue = !cue;
                if (!cue) {
                    apY();
                    return;
                } else if (cud == null) {
                    apX();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.cua != null) {
                    a(this.cua.apn(), cud);
                    this.cua.ez(true);
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a cache path");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case OPENLOCATION_CANCEL:
                return;
            default:
                aqa();
                c cVar = this.cuj.get(aps);
                if (cVar != null) {
                    cVar.b(this.mContext, this.cub, this.cuf, this.cuh, this.cui);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.cua = aVar;
        aqa();
        apW();
    }

    private void apX() {
        if (this.cua == null) {
            cue = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.cua.ez(false);
        final com.baidu.swan.impl.map.f.a apU = com.baidu.swan.impl.map.f.a.apU();
        this.cuc = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                apU.apV();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.cue = false;
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
                BaiduMap apn = OpenLocationBottomMenu.this.cua.apn();
                if (apn == null) {
                    boolean unused2 = OpenLocationBottomMenu.cue = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.cue) {
                    a unused3 = OpenLocationBottomMenu.cud = new com.baidu.swan.impl.map.e.b(apn);
                    apn.setOnMarkerClickListener(OpenLocationBottomMenu.cud);
                    OpenLocationBottomMenu.cud.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.cud.apR();
                    OpenLocationBottomMenu.cud.apT();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.cua.ez(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.cub == null) {
            cue = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        apU.a(this.cub, this.cuf, this.cuc);
    }

    private void apY() {
        if (this.cua != null && this.cua.apq()) {
            if (cud != null) {
                cud.apS();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void apZ() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        cue = false;
        cud = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.apR();
            aVar.apT();
        }
    }

    private void aqa() {
        if (this.cua != null) {
            if (this.cub == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation app = this.cua.app();
                if (app != null) {
                    this.cub = new LatLng(app.getLatitude(), app.getLongitude());
                    String addrStr = app.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(app.getStreet()) ? "" : app.getStreet();
                    }
                    this.cuh = addrStr;
                } else {
                    return;
                }
            }
            if (this.cuf == null) {
                Bundle arguments = this.cua.getArguments();
                this.cuf = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.cui = string;
            }
        }
    }
}
