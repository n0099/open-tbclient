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
    private static a cXD;
    private static boolean cXE;
    private com.baidu.swan.impl.map.c.a cXA;
    private LatLng cXB;
    private OnGetRoutePlanResultListener cXC;
    private LatLng cXF;
    private boolean cXG;
    private String cXH;
    private String cXI;
    private Map<OpenLocationMenuItem.MenuItemType, c> cXJ;
    private OpenLocationMenuItem cXx;
    private OpenLocationMenuItem cXy;
    private LinearLayout.LayoutParams cXz;
    private Context mContext;
    protected static final boolean DEBUG = b.DEBUG;
    private static final List<String> cXw = Arrays.asList("BaiduMap", "GaodeMap");

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.cXG = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cXG = false;
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
        if (!cXE) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.cXx = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.cXx.a(this);
        addView(this.cXx.aAp());
        this.cXJ = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.cXJ.keySet()) {
            c cVar = this.cXJ.get(menuItemType);
            if (cVar.da(this.mContext) || cVar.aAK()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.cXG) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.aAp().getLayoutParams()).topMargin = af.C(7.0f);
                    this.cXG = true;
                }
                addView(openLocationMenuItem.aAp());
            }
        }
        this.cXy = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.cXy.a(this);
        this.cXz = (LinearLayout.LayoutParams) this.cXy.aAp().getLayoutParams();
        this.cXz.topMargin = af.C(7.0f);
        addView(this.cXy.aAp());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(cXw);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.cXA != null) {
            List<String> aAn = this.cXA.aAn();
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
        if (this.cXA != null) {
            this.cXA.aAi();
        }
        OpenLocationMenuItem.MenuItemType aAo = openLocationMenuItem.aAo();
        switch (aAo) {
            case OPENLOCATION_PATH:
                cXE = !cXE;
                if (!cXE) {
                    aAU();
                    return;
                } else if (cXD == null) {
                    aAT();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.cXA != null) {
                    a(this.cXA.aAj(), cXD);
                    this.cXA.fJ(true);
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
                c cVar = this.cXJ.get(aAo);
                if (cVar != null) {
                    cVar.b(this.mContext, this.cXB, this.cXF, this.cXH, this.cXI);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.cXA = aVar;
        aAW();
        aAS();
    }

    private void aAT() {
        if (this.cXA == null) {
            cXE = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.cXA.fJ(false);
        final com.baidu.swan.impl.map.f.a aAQ = com.baidu.swan.impl.map.f.a.aAQ();
        this.cXC = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                    boolean unused = OpenLocationBottomMenu.cXE = false;
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
                BaiduMap aAj = OpenLocationBottomMenu.this.cXA.aAj();
                if (aAj == null) {
                    boolean unused2 = OpenLocationBottomMenu.cXE = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.cXE) {
                    a unused3 = OpenLocationBottomMenu.cXD = new com.baidu.swan.impl.map.e.b(aAj);
                    aAj.setOnMarkerClickListener(OpenLocationBottomMenu.cXD);
                    OpenLocationBottomMenu.cXD.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.cXD.aAN();
                    OpenLocationBottomMenu.cXD.aAP();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.cXA.fJ(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.cXB == null) {
            cXE = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aAQ.a(this.cXB, this.cXF, this.cXC);
    }

    private void aAU() {
        if (this.cXA != null && this.cXA.aAm()) {
            if (cXD != null) {
                cXD.aAO();
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
        cXE = false;
        cXD = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aAN();
            aVar.aAP();
        }
    }

    private void aAW() {
        if (this.cXA != null) {
            if (this.cXB == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation aAl = this.cXA.aAl();
                if (aAl != null) {
                    this.cXB = new LatLng(aAl.getLatitude(), aAl.getLongitude());
                    String addrStr = aAl.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(aAl.getStreet()) ? "" : aAl.getStreet();
                    }
                    this.cXH = addrStr;
                } else {
                    return;
                }
            }
            if (this.cXF == null) {
                Bundle arguments = this.cXA.getArguments();
                this.cXF = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.cXI = string;
            }
        }
    }
}
