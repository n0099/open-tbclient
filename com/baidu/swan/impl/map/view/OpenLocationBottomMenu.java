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
import com.baidu.swan.apps.ap.ah;
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
/* loaded from: classes25.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.a {
    protected static final boolean DEBUG = b.DEBUG;
    private static final List<String> dZH = Arrays.asList("BaiduMap", "GaodeMap");
    private static a dZO;
    private static boolean dZP;
    private OpenLocationMenuItem dZI;
    private OpenLocationMenuItem dZJ;
    private LinearLayout.LayoutParams dZK;
    private com.baidu.swan.impl.map.c.a dZL;
    private LatLng dZM;
    private OnGetRoutePlanResultListener dZN;
    private LatLng dZQ;
    private boolean dZR;
    private String dZS;
    private String dZT;
    private Map<OpenLocationMenuItem.MenuItemType, c> dZU;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.dZR = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dZR = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void aXL() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!dZP) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.dZI = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.dZI.a(this);
        addView(this.dZI.aXj());
        this.dZU = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.dZU.keySet()) {
            c cVar = this.dZU.get(menuItemType);
            if (cVar.dF(this.mContext) || cVar.aXE()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.dZR) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.aXj().getLayoutParams()).topMargin = ah.L(7.0f);
                    this.dZR = true;
                }
                addView(openLocationMenuItem.aXj());
            }
        }
        this.dZJ = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.dZJ.a(this);
        this.dZK = (LinearLayout.LayoutParams) this.dZJ.aXj().getLayoutParams();
        this.dZK.topMargin = ah.L(7.0f);
        addView(this.dZJ.aXj());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(dZH);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.dZL != null) {
            List<String> aXh = this.dZL.aXh();
            if (aXh != null) {
                aXh.remove("BaiduMap");
                arrayList.removeAll(aXh);
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
        if (this.dZL != null) {
            this.dZL.aXc();
        }
        OpenLocationMenuItem.MenuItemType aXi = openLocationMenuItem.aXi();
        switch (aXi) {
            case OPENLOCATION_PATH:
                dZP = !dZP;
                if (!dZP) {
                    aXN();
                    return;
                } else if (dZO == null) {
                    aXM();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.dZL != null) {
                    a(this.dZL.aXd(), dZO);
                    this.dZL.hz(true);
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
                aXP();
                c cVar = this.dZU.get(aXi);
                if (cVar != null) {
                    cVar.b(this.mContext, this.dZM, this.dZQ, this.dZS, this.dZT);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.dZL = aVar;
        aXP();
        aXL();
    }

    private void aXM() {
        if (this.dZL == null) {
            dZP = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.dZL.hz(false);
        final com.baidu.swan.impl.map.f.a aXJ = com.baidu.swan.impl.map.f.a.aXJ();
        this.dZN = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                aXJ.aXK();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.dZP = false;
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
                BaiduMap aXd = OpenLocationBottomMenu.this.dZL.aXd();
                if (aXd == null) {
                    boolean unused2 = OpenLocationBottomMenu.dZP = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.dZP) {
                    a unused3 = OpenLocationBottomMenu.dZO = new com.baidu.swan.impl.map.e.b(aXd);
                    aXd.setOnMarkerClickListener(OpenLocationBottomMenu.dZO);
                    OpenLocationBottomMenu.dZO.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.dZO.aXG();
                    OpenLocationBottomMenu.dZO.aXI();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.dZL.hz(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.dZM == null) {
            dZP = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aXJ.a(this.dZM, this.dZQ, this.dZN);
    }

    private void aXN() {
        if (this.dZL != null && this.dZL.aXg()) {
            if (dZO != null) {
                dZO.aXH();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void aXO() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        dZP = false;
        dZO = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aXG();
            aVar.aXI();
        }
    }

    private void aXP() {
        if (this.dZL != null) {
            if (this.dZM == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation aXf = this.dZL.aXf();
                if (aXf != null) {
                    this.dZM = new LatLng(aXf.getLatitude(), aXf.getLongitude());
                    String addrStr = aXf.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(aXf.getStreet()) ? "" : aXf.getStreet();
                    }
                    this.dZS = addrStr;
                } else {
                    return;
                }
            }
            if (this.dZQ == null) {
                Bundle arguments = this.dZL.getArguments();
                this.dZQ = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.dZT = string;
            }
        }
    }
}
