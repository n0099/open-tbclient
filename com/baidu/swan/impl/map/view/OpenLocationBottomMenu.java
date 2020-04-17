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
/* loaded from: classes12.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.a {
    protected static final boolean DEBUG = b.DEBUG;
    private static final List<String> cXr = Arrays.asList("BaiduMap", "GaodeMap");
    private static a cXy;
    private static boolean cXz;
    private LatLng cXA;
    private boolean cXB;
    private String cXC;
    private String cXD;
    private Map<OpenLocationMenuItem.MenuItemType, c> cXE;
    private OpenLocationMenuItem cXs;
    private OpenLocationMenuItem cXt;
    private LinearLayout.LayoutParams cXu;
    private com.baidu.swan.impl.map.c.a cXv;
    private LatLng cXw;
    private OnGetRoutePlanResultListener cXx;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.cXB = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cXB = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void aAS() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!cXz) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.cXs = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.cXs.a(this);
        addView(this.cXs.aAp());
        this.cXE = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.cXE.keySet()) {
            c cVar = this.cXE.get(menuItemType);
            if (cVar.dm(this.mContext) || cVar.aAK()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.cXB) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.aAp().getLayoutParams()).topMargin = af.C(7.0f);
                    this.cXB = true;
                }
                addView(openLocationMenuItem.aAp());
            }
        }
        this.cXt = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.cXt.a(this);
        this.cXu = (LinearLayout.LayoutParams) this.cXt.aAp().getLayoutParams();
        this.cXu.topMargin = af.C(7.0f);
        addView(this.cXt.aAp());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(cXr);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.cXv != null) {
            List<String> aAn = this.cXv.aAn();
            if (aAn != null) {
                aAn.remove("BaiduMap");
                arrayList.removeAll(aAn);
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
        if (this.cXv != null) {
            this.cXv.aAi();
        }
        OpenLocationMenuItem.MenuItemType aAo = openLocationMenuItem.aAo();
        switch (aAo) {
            case OPENLOCATION_PATH:
                cXz = !cXz;
                if (!cXz) {
                    aAU();
                    return;
                } else if (cXy == null) {
                    aAT();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.cXv != null) {
                    a(this.cXv.aAj(), cXy);
                    this.cXv.fJ(true);
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
                aAW();
                c cVar = this.cXE.get(aAo);
                if (cVar != null) {
                    cVar.b(this.mContext, this.cXw, this.cXA, this.cXC, this.cXD);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.cXv = aVar;
        aAW();
        aAS();
    }

    private void aAT() {
        if (this.cXv == null) {
            cXz = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.cXv.fJ(false);
        final com.baidu.swan.impl.map.f.a aAQ = com.baidu.swan.impl.map.f.a.aAQ();
        this.cXx = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                aAQ.aAR();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.cXz = false;
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
                BaiduMap aAj = OpenLocationBottomMenu.this.cXv.aAj();
                if (aAj == null) {
                    boolean unused2 = OpenLocationBottomMenu.cXz = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.cXz) {
                    a unused3 = OpenLocationBottomMenu.cXy = new com.baidu.swan.impl.map.e.b(aAj);
                    aAj.setOnMarkerClickListener(OpenLocationBottomMenu.cXy);
                    OpenLocationBottomMenu.cXy.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.cXy.aAN();
                    OpenLocationBottomMenu.cXy.aAP();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.cXv.fJ(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.cXw == null) {
            cXz = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aAQ.a(this.cXw, this.cXA, this.cXx);
    }

    private void aAU() {
        if (this.cXv != null && this.cXv.aAm()) {
            if (cXy != null) {
                cXy.aAO();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void aAV() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        cXz = false;
        cXy = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aAN();
            aVar.aAP();
        }
    }

    private void aAW() {
        if (this.cXv != null) {
            if (this.cXw == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation aAl = this.cXv.aAl();
                if (aAl != null) {
                    this.cXw = new LatLng(aAl.getLatitude(), aAl.getLongitude());
                    String addrStr = aAl.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(aAl.getStreet()) ? "" : aAl.getStreet();
                    }
                    this.cXC = addrStr;
                } else {
                    return;
                }
            }
            if (this.cXA == null) {
                Bundle arguments = this.cXv.getArguments();
                this.cXA = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.cXD = string;
            }
        }
    }
}
