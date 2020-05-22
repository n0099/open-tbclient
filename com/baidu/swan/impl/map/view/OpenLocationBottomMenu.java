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
import com.baidu.swan.apps.aq.ag;
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
    private static final List<String> diA = Arrays.asList("BaiduMap", "GaodeMap");
    private static a diH;
    private static boolean diI;
    private OpenLocationMenuItem diB;
    private OpenLocationMenuItem diC;
    private LinearLayout.LayoutParams diD;
    private com.baidu.swan.impl.map.c.a diE;
    private LatLng diF;
    private OnGetRoutePlanResultListener diG;
    private LatLng diJ;
    private boolean diK;
    private String diL;
    private String diM;
    private Map<OpenLocationMenuItem.MenuItemType, c> diN;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.diK = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.diK = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void aEK() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!diI) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.diB = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.diB.a(this);
        addView(this.diB.aEh());
        this.diN = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.diN.keySet()) {
            c cVar = this.diN.get(menuItemType);
            if (cVar.dp(this.mContext) || cVar.aEC()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.diK) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.aEh().getLayoutParams()).topMargin = ag.B(7.0f);
                    this.diK = true;
                }
                addView(openLocationMenuItem.aEh());
            }
        }
        this.diC = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.diC.a(this);
        this.diD = (LinearLayout.LayoutParams) this.diC.aEh().getLayoutParams();
        this.diD.topMargin = ag.B(7.0f);
        addView(this.diC.aEh());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(diA);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.diE != null) {
            List<String> aEf = this.diE.aEf();
            if (aEf != null) {
                aEf.remove("BaiduMap");
                arrayList.removeAll(aEf);
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
        if (this.diE != null) {
            this.diE.aEa();
        }
        OpenLocationMenuItem.MenuItemType aEg = openLocationMenuItem.aEg();
        switch (aEg) {
            case OPENLOCATION_PATH:
                diI = !diI;
                if (!diI) {
                    aEM();
                    return;
                } else if (diH == null) {
                    aEL();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.diE != null) {
                    a(this.diE.aEb(), diH);
                    this.diE.fU(true);
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
                aEO();
                c cVar = this.diN.get(aEg);
                if (cVar != null) {
                    cVar.b(this.mContext, this.diF, this.diJ, this.diL, this.diM);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.diE = aVar;
        aEO();
        aEK();
    }

    private void aEL() {
        if (this.diE == null) {
            diI = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.diE.fU(false);
        final com.baidu.swan.impl.map.f.a aEI = com.baidu.swan.impl.map.f.a.aEI();
        this.diG = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                aEI.aEJ();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.diI = false;
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
                BaiduMap aEb = OpenLocationBottomMenu.this.diE.aEb();
                if (aEb == null) {
                    boolean unused2 = OpenLocationBottomMenu.diI = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.diI) {
                    a unused3 = OpenLocationBottomMenu.diH = new com.baidu.swan.impl.map.e.b(aEb);
                    aEb.setOnMarkerClickListener(OpenLocationBottomMenu.diH);
                    OpenLocationBottomMenu.diH.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.diH.aEF();
                    OpenLocationBottomMenu.diH.aEH();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.diE.fU(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.diF == null) {
            diI = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aEI.a(this.diF, this.diJ, this.diG);
    }

    private void aEM() {
        if (this.diE != null && this.diE.aEe()) {
            if (diH != null) {
                diH.aEG();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void aEN() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        diI = false;
        diH = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aEF();
            aVar.aEH();
        }
    }

    private void aEO() {
        if (this.diE != null) {
            if (this.diF == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation aEd = this.diE.aEd();
                if (aEd != null) {
                    this.diF = new LatLng(aEd.getLatitude(), aEd.getLongitude());
                    String addrStr = aEd.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(aEd.getStreet()) ? "" : aEd.getStreet();
                    }
                    this.diL = addrStr;
                } else {
                    return;
                }
            }
            if (this.diJ == null) {
                Bundle arguments = this.diE.getArguments();
                this.diJ = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.diM = string;
            }
        }
    }
}
