package com.baidu.swan.impl.map.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
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
import com.baidu.swan.apps.ao.ah;
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
    private static final List<String> erp = Arrays.asList("BaiduMap", "GaodeMap");
    private static a erx;
    private static boolean ery;
    private boolean erA;
    private String erB;
    private String erC;
    private Map<OpenLocationMenuItem.MenuItemType, c> erD;
    private OpenLocationMenuItem erq;
    private OpenLocationMenuItem ers;
    private LinearLayout.LayoutParams ert;
    private com.baidu.swan.impl.map.c.a eru;
    private LatLng erv;
    private OnGetRoutePlanResultListener erw;
    private LatLng erz;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.erA = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.erA = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void bbw() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!ery) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.erq = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.erq.a(this);
        addView(this.erq.baT());
        this.erD = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.erD.keySet()) {
            c cVar = this.erD.get(menuItemType);
            if (cVar.eC(this.mContext) || cVar.bbp()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.erA) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.baT().getLayoutParams()).topMargin = ah.P(7.0f);
                    this.erA = true;
                }
                addView(openLocationMenuItem.baT());
            }
        }
        this.ers = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.ers.a(this);
        this.ert = (LinearLayout.LayoutParams) this.ers.baT().getLayoutParams();
        this.ert.topMargin = ah.P(7.0f);
        addView(this.ers.baT());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(erp);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.eru != null) {
            List<String> baR = this.eru.baR();
            if (baR != null) {
                baR.remove("BaiduMap");
                arrayList.removeAll(baR);
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
        if (this.eru != null) {
            this.eru.baM();
        }
        OpenLocationMenuItem.MenuItemType baS = openLocationMenuItem.baS();
        switch (baS) {
            case OPENLOCATION_PATH:
                ery = !ery;
                if (!ery) {
                    bby();
                    return;
                } else if (erx == null) {
                    bbx();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.eru != null) {
                    a(this.eru.baN(), erx);
                    this.eru.iq(true);
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
                bbA();
                c cVar = this.erD.get(baS);
                if (cVar != null) {
                    cVar.b(this.mContext, this.erv, this.erz, this.erB, this.erC);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.eru = aVar;
        bbA();
        bbw();
    }

    private void bbx() {
        if (this.eru == null) {
            ery = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.eru.iq(false);
        final com.baidu.swan.impl.map.f.a bbu = com.baidu.swan.impl.map.f.a.bbu();
        this.erw = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                bbu.bbv();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.ery = false;
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
                BaiduMap baN = OpenLocationBottomMenu.this.eru.baN();
                if (baN == null) {
                    boolean unused2 = OpenLocationBottomMenu.ery = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.ery) {
                    a unused3 = OpenLocationBottomMenu.erx = new com.baidu.swan.impl.map.e.b(baN);
                    baN.setOnMarkerClickListener(OpenLocationBottomMenu.erx);
                    OpenLocationBottomMenu.erx.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.erx.bbr();
                    OpenLocationBottomMenu.erx.bbt();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.eru.iq(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.erv == null) {
            ery = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        bbu.a(this.erv, this.erz, this.erw);
    }

    private void bby() {
        if (this.eru != null && this.eru.baQ()) {
            if (erx != null) {
                erx.bbs();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void bbz() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        ery = false;
        erx = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.bbr();
            aVar.bbt();
        }
    }

    private void bbA() {
        if (this.eru != null) {
            if (this.erv == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation baP = this.eru.baP();
                if (baP != null) {
                    this.erv = new LatLng(baP.getLatitude(), baP.getLongitude());
                    String addrStr = baP.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(baP.getStreet()) ? "" : baP.getStreet();
                    }
                    this.erB = addrStr;
                } else {
                    return;
                }
            }
            if (this.erz == null) {
                Bundle arguments = this.eru.getArguments();
                this.erz = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.erC = string;
            }
        }
    }
}
