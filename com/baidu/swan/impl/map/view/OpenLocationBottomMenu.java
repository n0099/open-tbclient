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
/* loaded from: classes19.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.a {
    protected static final boolean DEBUG = b.DEBUG;
    private static final List<String> dDf = Arrays.asList("BaiduMap", "GaodeMap");
    private static a dDm;
    private static boolean dDn;
    private OpenLocationMenuItem dDg;
    private OpenLocationMenuItem dDh;
    private LinearLayout.LayoutParams dDi;
    private com.baidu.swan.impl.map.c.a dDj;
    private LatLng dDk;
    private OnGetRoutePlanResultListener dDl;
    private LatLng dDo;
    private boolean dDp;
    private String dDq;
    private String dDr;
    private Map<OpenLocationMenuItem.MenuItemType, c> dDs;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.dDp = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dDp = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void aSx() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!dDn) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.dDg = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.dDg.a(this);
        addView(this.dDg.aRU());
        this.dDs = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.dDs.keySet()) {
            c cVar = this.dDs.get(menuItemType);
            if (cVar.dA(this.mContext) || cVar.aSp()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.dDp) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.aRU().getLayoutParams()).topMargin = ah.H(7.0f);
                    this.dDp = true;
                }
                addView(openLocationMenuItem.aRU());
            }
        }
        this.dDh = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.dDh.a(this);
        this.dDi = (LinearLayout.LayoutParams) this.dDh.aRU().getLayoutParams();
        this.dDi.topMargin = ah.H(7.0f);
        addView(this.dDh.aRU());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(dDf);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.dDj != null) {
            List<String> aRS = this.dDj.aRS();
            if (aRS != null) {
                aRS.remove("BaiduMap");
                arrayList.removeAll(aRS);
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
        if (this.dDj != null) {
            this.dDj.aRN();
        }
        OpenLocationMenuItem.MenuItemType aRT = openLocationMenuItem.aRT();
        switch (aRT) {
            case OPENLOCATION_PATH:
                dDn = !dDn;
                if (!dDn) {
                    aSz();
                    return;
                } else if (dDm == null) {
                    aSy();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.dDj != null) {
                    a(this.dDj.aRO(), dDm);
                    this.dDj.gR(true);
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
                aSB();
                c cVar = this.dDs.get(aRT);
                if (cVar != null) {
                    cVar.b(this.mContext, this.dDk, this.dDo, this.dDq, this.dDr);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.dDj = aVar;
        aSB();
        aSx();
    }

    private void aSy() {
        if (this.dDj == null) {
            dDn = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.dDj.gR(false);
        final com.baidu.swan.impl.map.f.a aSv = com.baidu.swan.impl.map.f.a.aSv();
        this.dDl = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                aSv.aSw();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.dDn = false;
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
                BaiduMap aRO = OpenLocationBottomMenu.this.dDj.aRO();
                if (aRO == null) {
                    boolean unused2 = OpenLocationBottomMenu.dDn = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.dDn) {
                    a unused3 = OpenLocationBottomMenu.dDm = new com.baidu.swan.impl.map.e.b(aRO);
                    aRO.setOnMarkerClickListener(OpenLocationBottomMenu.dDm);
                    OpenLocationBottomMenu.dDm.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.dDm.aSs();
                    OpenLocationBottomMenu.dDm.aSu();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.dDj.gR(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.dDk == null) {
            dDn = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aSv.a(this.dDk, this.dDo, this.dDl);
    }

    private void aSz() {
        if (this.dDj != null && this.dDj.aRR()) {
            if (dDm != null) {
                dDm.aSt();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void aSA() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        dDn = false;
        dDm = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aSs();
            aVar.aSu();
        }
    }

    private void aSB() {
        if (this.dDj != null) {
            if (this.dDk == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation aRQ = this.dDj.aRQ();
                if (aRQ != null) {
                    this.dDk = new LatLng(aRQ.getLatitude(), aRQ.getLongitude());
                    String addrStr = aRQ.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(aRQ.getStreet()) ? "" : aRQ.getStreet();
                    }
                    this.dDq = addrStr;
                } else {
                    return;
                }
            }
            if (this.dDo == null) {
                Bundle arguments = this.dDj.getArguments();
                this.dDo = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.dDr = string;
            }
        }
    }
}
