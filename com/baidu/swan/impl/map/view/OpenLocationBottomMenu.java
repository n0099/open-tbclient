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
/* loaded from: classes8.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.a {
    protected static final boolean DEBUG = b.DEBUG;
    private static final List<String> epj = Arrays.asList("BaiduMap", "GaodeMap");
    private static a epq;
    private static boolean epr;
    private OpenLocationMenuItem epk;
    private OpenLocationMenuItem epl;
    private LinearLayout.LayoutParams epm;
    private com.baidu.swan.impl.map.c.a epn;
    private LatLng epo;
    private OnGetRoutePlanResultListener epp;
    private LatLng eps;
    private boolean ept;
    private String epu;
    private String epv;
    private Map<OpenLocationMenuItem.MenuItemType, c> epw;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.ept = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ept = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void bbj() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!epr) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.epk = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.epk.a(this);
        addView(this.epk.baG());
        this.epw = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.epw.keySet()) {
            c cVar = this.epw.get(menuItemType);
            if (cVar.eD(this.mContext) || cVar.bbc()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.ept) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.baG().getLayoutParams()).topMargin = ah.O(7.0f);
                    this.ept = true;
                }
                addView(openLocationMenuItem.baG());
            }
        }
        this.epl = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.epl.a(this);
        this.epm = (LinearLayout.LayoutParams) this.epl.baG().getLayoutParams();
        this.epm.topMargin = ah.O(7.0f);
        addView(this.epl.baG());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(epj);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.epn != null) {
            List<String> baE = this.epn.baE();
            if (baE != null) {
                baE.remove("BaiduMap");
                arrayList.removeAll(baE);
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
        if (this.epn != null) {
            this.epn.baz();
        }
        OpenLocationMenuItem.MenuItemType baF = openLocationMenuItem.baF();
        switch (baF) {
            case OPENLOCATION_PATH:
                epr = !epr;
                if (!epr) {
                    bbl();
                    return;
                } else if (epq == null) {
                    bbk();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.epn != null) {
                    a(this.epn.baA(), epq);
                    this.epn.io(true);
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
                bbn();
                c cVar = this.epw.get(baF);
                if (cVar != null) {
                    cVar.b(this.mContext, this.epo, this.eps, this.epu, this.epv);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.epn = aVar;
        bbn();
        bbj();
    }

    private void bbk() {
        if (this.epn == null) {
            epr = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.epn.io(false);
        final com.baidu.swan.impl.map.f.a bbh = com.baidu.swan.impl.map.f.a.bbh();
        this.epp = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                bbh.bbi();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.epr = false;
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
                BaiduMap baA = OpenLocationBottomMenu.this.epn.baA();
                if (baA == null) {
                    boolean unused2 = OpenLocationBottomMenu.epr = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.epr) {
                    a unused3 = OpenLocationBottomMenu.epq = new com.baidu.swan.impl.map.e.b(baA);
                    baA.setOnMarkerClickListener(OpenLocationBottomMenu.epq);
                    OpenLocationBottomMenu.epq.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.epq.bbe();
                    OpenLocationBottomMenu.epq.bbg();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.epn.io(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.epo == null) {
            epr = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        bbh.a(this.epo, this.eps, this.epp);
    }

    private void bbl() {
        if (this.epn != null && this.epn.baD()) {
            if (epq != null) {
                epq.bbf();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void bbm() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        epr = false;
        epq = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.bbe();
            aVar.bbg();
        }
    }

    private void bbn() {
        if (this.epn != null) {
            if (this.epo == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation baC = this.epn.baC();
                if (baC != null) {
                    this.epo = new LatLng(baC.getLatitude(), baC.getLongitude());
                    String addrStr = baC.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(baC.getStreet()) ? "" : baC.getStreet();
                    }
                    this.epu = addrStr;
                } else {
                    return;
                }
            }
            if (this.eps == null) {
                Bundle arguments = this.epn.getArguments();
                this.eps = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.epv = string;
            }
        }
    }
}
