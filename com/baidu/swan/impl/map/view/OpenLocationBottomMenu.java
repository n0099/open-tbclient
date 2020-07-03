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
    private static final List<String> dnj = Arrays.asList("BaiduMap", "GaodeMap");
    private static a dnq;
    private static boolean dnr;
    private OpenLocationMenuItem dnk;
    private OpenLocationMenuItem dnl;
    private LinearLayout.LayoutParams dnm;
    private com.baidu.swan.impl.map.c.a dnn;
    private LatLng dno;
    private OnGetRoutePlanResultListener dnp;
    private LatLng dnt;
    private boolean dnu;
    private String dnv;
    private String dnw;
    private Map<OpenLocationMenuItem.MenuItemType, c> dnx;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.dnu = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dnu = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void aFQ() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!dnr) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.dnk = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.dnk.a(this);
        addView(this.dnk.aFn());
        this.dnx = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.dnx.keySet()) {
            c cVar = this.dnx.get(menuItemType);
            if (cVar.dq(this.mContext) || cVar.aFI()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.dnu) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.aFn().getLayoutParams()).topMargin = ag.D(7.0f);
                    this.dnu = true;
                }
                addView(openLocationMenuItem.aFn());
            }
        }
        this.dnl = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.dnl.a(this);
        this.dnm = (LinearLayout.LayoutParams) this.dnl.aFn().getLayoutParams();
        this.dnm.topMargin = ag.D(7.0f);
        addView(this.dnl.aFn());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(dnj);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.dnn != null) {
            List<String> aFl = this.dnn.aFl();
            if (aFl != null) {
                aFl.remove("BaiduMap");
                arrayList.removeAll(aFl);
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
        if (this.dnn != null) {
            this.dnn.aFg();
        }
        OpenLocationMenuItem.MenuItemType aFm = openLocationMenuItem.aFm();
        switch (aFm) {
            case OPENLOCATION_PATH:
                dnr = !dnr;
                if (!dnr) {
                    aFS();
                    return;
                } else if (dnq == null) {
                    aFR();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.dnn != null) {
                    a(this.dnn.aFh(), dnq);
                    this.dnn.fZ(true);
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
                aFU();
                c cVar = this.dnx.get(aFm);
                if (cVar != null) {
                    cVar.b(this.mContext, this.dno, this.dnt, this.dnv, this.dnw);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.dnn = aVar;
        aFU();
        aFQ();
    }

    private void aFR() {
        if (this.dnn == null) {
            dnr = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.dnn.fZ(false);
        final com.baidu.swan.impl.map.f.a aFO = com.baidu.swan.impl.map.f.a.aFO();
        this.dnp = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                aFO.aFP();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.dnr = false;
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
                BaiduMap aFh = OpenLocationBottomMenu.this.dnn.aFh();
                if (aFh == null) {
                    boolean unused2 = OpenLocationBottomMenu.dnr = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.dnr) {
                    a unused3 = OpenLocationBottomMenu.dnq = new com.baidu.swan.impl.map.e.b(aFh);
                    aFh.setOnMarkerClickListener(OpenLocationBottomMenu.dnq);
                    OpenLocationBottomMenu.dnq.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.dnq.aFL();
                    OpenLocationBottomMenu.dnq.aFN();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.dnn.fZ(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.dno == null) {
            dnr = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aFO.a(this.dno, this.dnt, this.dnp);
    }

    private void aFS() {
        if (this.dnn != null && this.dnn.aFk()) {
            if (dnq != null) {
                dnq.aFM();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void aFT() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        dnr = false;
        dnq = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aFL();
            aVar.aFN();
        }
    }

    private void aFU() {
        if (this.dnn != null) {
            if (this.dno == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation aFj = this.dnn.aFj();
                if (aFj != null) {
                    this.dno = new LatLng(aFj.getLatitude(), aFj.getLongitude());
                    String addrStr = aFj.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(aFj.getStreet()) ? "" : aFj.getStreet();
                    }
                    this.dnv = addrStr;
                } else {
                    return;
                }
            }
            if (this.dnt == null) {
                Bundle arguments = this.dnn.getArguments();
                this.dnt = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.dnw = string;
            }
        }
    }
}
