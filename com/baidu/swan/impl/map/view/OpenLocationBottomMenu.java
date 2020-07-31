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
import com.baidu.swan.apps.aq.ai;
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
    private static final List<String> dtf = Arrays.asList("BaiduMap", "GaodeMap");
    private static a dtm;
    private static boolean dtn;
    private OpenLocationMenuItem dtg;
    private OpenLocationMenuItem dth;
    private LinearLayout.LayoutParams dti;
    private com.baidu.swan.impl.map.c.a dtj;
    private LatLng dtk;
    private OnGetRoutePlanResultListener dtl;
    private LatLng dto;
    private boolean dtp;
    private String dtq;
    private String dtr;
    private Map<OpenLocationMenuItem.MenuItemType, c> dtt;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.dtp = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dtp = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void aJH() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!dtn) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.dtg = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.dtg.a(this);
        addView(this.dtg.aJe());
        this.dtt = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.dtt.keySet()) {
            c cVar = this.dtt.get(menuItemType);
            if (cVar.du(this.mContext) || cVar.aJz()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.dtp) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.aJe().getLayoutParams()).topMargin = ai.D(7.0f);
                    this.dtp = true;
                }
                addView(openLocationMenuItem.aJe());
            }
        }
        this.dth = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.dth.a(this);
        this.dti = (LinearLayout.LayoutParams) this.dth.aJe().getLayoutParams();
        this.dti.topMargin = ai.D(7.0f);
        addView(this.dth.aJe());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(dtf);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.dtj != null) {
            List<String> aJc = this.dtj.aJc();
            if (aJc != null) {
                aJc.remove("BaiduMap");
                arrayList.removeAll(aJc);
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
        if (this.dtj != null) {
            this.dtj.aIX();
        }
        OpenLocationMenuItem.MenuItemType aJd = openLocationMenuItem.aJd();
        switch (aJd) {
            case OPENLOCATION_PATH:
                dtn = !dtn;
                if (!dtn) {
                    aJJ();
                    return;
                } else if (dtm == null) {
                    aJI();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.dtj != null) {
                    a(this.dtj.aIY(), dtm);
                    this.dtj.gv(true);
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
                aJL();
                c cVar = this.dtt.get(aJd);
                if (cVar != null) {
                    cVar.b(this.mContext, this.dtk, this.dto, this.dtq, this.dtr);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.dtj = aVar;
        aJL();
        aJH();
    }

    private void aJI() {
        if (this.dtj == null) {
            dtn = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.dtj.gv(false);
        final com.baidu.swan.impl.map.f.a aJF = com.baidu.swan.impl.map.f.a.aJF();
        this.dtl = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                aJF.aJG();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.dtn = false;
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
                BaiduMap aIY = OpenLocationBottomMenu.this.dtj.aIY();
                if (aIY == null) {
                    boolean unused2 = OpenLocationBottomMenu.dtn = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.dtn) {
                    a unused3 = OpenLocationBottomMenu.dtm = new com.baidu.swan.impl.map.e.b(aIY);
                    aIY.setOnMarkerClickListener(OpenLocationBottomMenu.dtm);
                    OpenLocationBottomMenu.dtm.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.dtm.aJC();
                    OpenLocationBottomMenu.dtm.aJE();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.dtj.gv(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.dtk == null) {
            dtn = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aJF.a(this.dtk, this.dto, this.dtl);
    }

    private void aJJ() {
        if (this.dtj != null && this.dtj.aJb()) {
            if (dtm != null) {
                dtm.aJD();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void aJK() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        dtn = false;
        dtm = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aJC();
            aVar.aJE();
        }
    }

    private void aJL() {
        if (this.dtj != null) {
            if (this.dtk == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation aJa = this.dtj.aJa();
                if (aJa != null) {
                    this.dtk = new LatLng(aJa.getLatitude(), aJa.getLongitude());
                    String addrStr = aJa.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(aJa.getStreet()) ? "" : aJa.getStreet();
                    }
                    this.dtq = addrStr;
                } else {
                    return;
                }
            }
            if (this.dto == null) {
                Bundle arguments = this.dtj.getArguments();
                this.dto = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.dtr = string;
            }
        }
    }
}
