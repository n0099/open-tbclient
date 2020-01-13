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
/* loaded from: classes10.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.a {
    protected static final boolean DEBUG = b.DEBUG;
    private static final List<String> cuh = Arrays.asList("BaiduMap", "GaodeMap");
    private static a cuo;
    private static boolean cup;
    private OpenLocationMenuItem cui;
    private OpenLocationMenuItem cuj;
    private LinearLayout.LayoutParams cuk;
    private com.baidu.swan.impl.map.c.a cul;
    private LatLng cum;
    private OnGetRoutePlanResultListener cun;
    private LatLng cuq;
    private boolean cus;
    private String cuu;
    private String cuv;
    private Map<OpenLocationMenuItem.MenuItemType, c> cuw;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.cus = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cus = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void aqp() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!cup) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.cui = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.cui.a(this);
        addView(this.cui.apM());
        this.cuw = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.cuw.keySet()) {
            c cVar = this.cuw.get(menuItemType);
            if (cVar.dv(this.mContext) || cVar.aqh()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.cus) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.apM().getLayoutParams()).topMargin = af.S(7.0f);
                    this.cus = true;
                }
                addView(openLocationMenuItem.apM());
            }
        }
        this.cuj = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.cuj.a(this);
        this.cuk = (LinearLayout.LayoutParams) this.cuj.apM().getLayoutParams();
        this.cuk.topMargin = af.S(7.0f);
        addView(this.cuj.apM());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(cuh);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.cul != null) {
            List<String> apK = this.cul.apK();
            if (apK != null) {
                apK.remove("BaiduMap");
                arrayList.removeAll(apK);
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
        if (this.cul != null) {
            this.cul.apF();
        }
        OpenLocationMenuItem.MenuItemType apL = openLocationMenuItem.apL();
        switch (apL) {
            case OPENLOCATION_PATH:
                cup = !cup;
                if (!cup) {
                    aqr();
                    return;
                } else if (cuo == null) {
                    aqq();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.cul != null) {
                    a(this.cul.apG(), cuo);
                    this.cul.eE(true);
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
                aqt();
                c cVar = this.cuw.get(apL);
                if (cVar != null) {
                    cVar.b(this.mContext, this.cum, this.cuq, this.cuu, this.cuv);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.cul = aVar;
        aqt();
        aqp();
    }

    private void aqq() {
        if (this.cul == null) {
            cup = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.cul.eE(false);
        final com.baidu.swan.impl.map.f.a aqn = com.baidu.swan.impl.map.f.a.aqn();
        this.cun = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                aqn.aqo();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.cup = false;
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
                BaiduMap apG = OpenLocationBottomMenu.this.cul.apG();
                if (apG == null) {
                    boolean unused2 = OpenLocationBottomMenu.cup = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.cup) {
                    a unused3 = OpenLocationBottomMenu.cuo = new com.baidu.swan.impl.map.e.b(apG);
                    apG.setOnMarkerClickListener(OpenLocationBottomMenu.cuo);
                    OpenLocationBottomMenu.cuo.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.cuo.aqk();
                    OpenLocationBottomMenu.cuo.aqm();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.cul.eE(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.cum == null) {
            cup = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aqn.a(this.cum, this.cuq, this.cun);
    }

    private void aqr() {
        if (this.cul != null && this.cul.apJ()) {
            if (cuo != null) {
                cuo.aql();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void aqs() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        cup = false;
        cuo = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aqk();
            aVar.aqm();
        }
    }

    private void aqt() {
        if (this.cul != null) {
            if (this.cum == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation apI = this.cul.apI();
                if (apI != null) {
                    this.cum = new LatLng(apI.getLatitude(), apI.getLongitude());
                    String addrStr = apI.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(apI.getStreet()) ? "" : apI.getStreet();
                    }
                    this.cuu = addrStr;
                } else {
                    return;
                }
            }
            if (this.cuq == null) {
                Bundle arguments = this.cul.getArguments();
                this.cuq = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.cuv = string;
            }
        }
    }
}
