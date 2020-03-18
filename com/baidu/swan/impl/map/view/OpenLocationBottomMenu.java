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
    private static a cyB;
    private static boolean cyC;
    private OnGetRoutePlanResultListener cyA;
    private LatLng cyD;
    private boolean cyE;
    private String cyF;
    private String cyG;
    private Map<OpenLocationMenuItem.MenuItemType, c> cyH;
    private OpenLocationMenuItem cyv;
    private OpenLocationMenuItem cyw;
    private LinearLayout.LayoutParams cyx;
    private com.baidu.swan.impl.map.c.a cyy;
    private LatLng cyz;
    private Context mContext;
    protected static final boolean DEBUG = b.DEBUG;
    private static final List<String> cyu = Arrays.asList("BaiduMap", "GaodeMap");

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.cyE = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyE = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void asI() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!cyC) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.cyv = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.cyv.a(this);
        addView(this.cyv.ase());
        this.cyH = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.cyH.keySet()) {
            c cVar = this.cyH.get(menuItemType);
            if (cVar.dy(this.mContext) || cVar.asA()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.cyE) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.ase().getLayoutParams()).topMargin = af.S(7.0f);
                    this.cyE = true;
                }
                addView(openLocationMenuItem.ase());
            }
        }
        this.cyw = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.cyw.a(this);
        this.cyx = (LinearLayout.LayoutParams) this.cyw.ase().getLayoutParams();
        this.cyx.topMargin = af.S(7.0f);
        addView(this.cyw.ase());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(cyu);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.cyy != null) {
            List<String> asc = this.cyy.asc();
            if (asc != null) {
                asc.remove("BaiduMap");
                arrayList.removeAll(asc);
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
        if (this.cyy != null) {
            this.cyy.arX();
        }
        OpenLocationMenuItem.MenuItemType asd = openLocationMenuItem.asd();
        switch (asd) {
            case OPENLOCATION_PATH:
                cyC = !cyC;
                if (!cyC) {
                    asK();
                    return;
                } else if (cyB == null) {
                    asJ();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.cyy != null) {
                    a(this.cyy.arY(), cyB);
                    this.cyy.eM(true);
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
                asM();
                c cVar = this.cyH.get(asd);
                if (cVar != null) {
                    cVar.b(this.mContext, this.cyz, this.cyD, this.cyF, this.cyG);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.cyy = aVar;
        asM();
        asI();
    }

    private void asJ() {
        if (this.cyy == null) {
            cyC = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.cyy.eM(false);
        final com.baidu.swan.impl.map.f.a asG = com.baidu.swan.impl.map.f.a.asG();
        this.cyA = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                asG.asH();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.cyC = false;
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
                BaiduMap arY = OpenLocationBottomMenu.this.cyy.arY();
                if (arY == null) {
                    boolean unused2 = OpenLocationBottomMenu.cyC = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.cyC) {
                    a unused3 = OpenLocationBottomMenu.cyB = new com.baidu.swan.impl.map.e.b(arY);
                    arY.setOnMarkerClickListener(OpenLocationBottomMenu.cyB);
                    OpenLocationBottomMenu.cyB.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.cyB.asD();
                    OpenLocationBottomMenu.cyB.asF();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.cyy.eM(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.cyz == null) {
            cyC = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        asG.a(this.cyz, this.cyD, this.cyA);
    }

    private void asK() {
        if (this.cyy != null && this.cyy.asb()) {
            if (cyB != null) {
                cyB.asE();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void asL() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        cyC = false;
        cyB = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.asD();
            aVar.asF();
        }
    }

    private void asM() {
        if (this.cyy != null) {
            if (this.cyz == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation asa = this.cyy.asa();
                if (asa != null) {
                    this.cyz = new LatLng(asa.getLatitude(), asa.getLongitude());
                    String addrStr = asa.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(asa.getStreet()) ? "" : asa.getStreet();
                    }
                    this.cyF = addrStr;
                } else {
                    return;
                }
            }
            if (this.cyD == null) {
                Bundle arguments = this.cyy.getArguments();
                this.cyD = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.cyG = string;
            }
        }
    }
}
