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
    private static final List<String> cyh = Arrays.asList("BaiduMap", "GaodeMap");
    private static a cyo;
    private static boolean cyp;
    private OpenLocationMenuItem cyi;
    private OpenLocationMenuItem cyj;
    private LinearLayout.LayoutParams cyk;
    private com.baidu.swan.impl.map.c.a cyl;
    private LatLng cym;
    private OnGetRoutePlanResultListener cyn;
    private LatLng cyq;
    private boolean cyr;
    private String cys;
    private String cyt;
    private Map<OpenLocationMenuItem.MenuItemType, c> cyu;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.cyr = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyr = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void asD() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!cyp) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.cyi = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.cyi.a(this);
        addView(this.cyi.arZ());
        this.cyu = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.cyu.keySet()) {
            c cVar = this.cyu.get(menuItemType);
            if (cVar.dz(this.mContext) || cVar.asv()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.cyr) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.arZ().getLayoutParams()).topMargin = af.S(7.0f);
                    this.cyr = true;
                }
                addView(openLocationMenuItem.arZ());
            }
        }
        this.cyj = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.cyj.a(this);
        this.cyk = (LinearLayout.LayoutParams) this.cyj.arZ().getLayoutParams();
        this.cyk.topMargin = af.S(7.0f);
        addView(this.cyj.arZ());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(cyh);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.cyl != null) {
            List<String> arX = this.cyl.arX();
            if (arX != null) {
                arX.remove("BaiduMap");
                arrayList.removeAll(arX);
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
        if (this.cyl != null) {
            this.cyl.arS();
        }
        OpenLocationMenuItem.MenuItemType arY = openLocationMenuItem.arY();
        switch (arY) {
            case OPENLOCATION_PATH:
                cyp = !cyp;
                if (!cyp) {
                    asF();
                    return;
                } else if (cyo == null) {
                    asE();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.cyl != null) {
                    a(this.cyl.arT(), cyo);
                    this.cyl.eL(true);
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
                asH();
                c cVar = this.cyu.get(arY);
                if (cVar != null) {
                    cVar.b(this.mContext, this.cym, this.cyq, this.cys, this.cyt);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.cyl = aVar;
        asH();
        asD();
    }

    private void asE() {
        if (this.cyl == null) {
            cyp = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.cyl.eL(false);
        final com.baidu.swan.impl.map.f.a asB = com.baidu.swan.impl.map.f.a.asB();
        this.cyn = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                asB.asC();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.cyp = false;
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
                BaiduMap arT = OpenLocationBottomMenu.this.cyl.arT();
                if (arT == null) {
                    boolean unused2 = OpenLocationBottomMenu.cyp = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.cyp) {
                    a unused3 = OpenLocationBottomMenu.cyo = new com.baidu.swan.impl.map.e.b(arT);
                    arT.setOnMarkerClickListener(OpenLocationBottomMenu.cyo);
                    OpenLocationBottomMenu.cyo.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.cyo.asy();
                    OpenLocationBottomMenu.cyo.asA();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.cyl.eL(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.cym == null) {
            cyp = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        asB.a(this.cym, this.cyq, this.cyn);
    }

    private void asF() {
        if (this.cyl != null && this.cyl.arW()) {
            if (cyo != null) {
                cyo.asz();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void asG() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        cyp = false;
        cyo = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.asy();
            aVar.asA();
        }
    }

    private void asH() {
        if (this.cyl != null) {
            if (this.cym == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation arV = this.cyl.arV();
                if (arV != null) {
                    this.cym = new LatLng(arV.getLatitude(), arV.getLongitude());
                    String addrStr = arV.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(arV.getStreet()) ? "" : arV.getStreet();
                    }
                    this.cys = addrStr;
                } else {
                    return;
                }
            }
            if (this.cyq == null) {
                Bundle arguments = this.cyl.getArguments();
                this.cyq = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.cyt = string;
            }
        }
    }
}
