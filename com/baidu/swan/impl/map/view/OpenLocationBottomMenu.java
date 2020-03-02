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
    private static final List<String> cyi = Arrays.asList("BaiduMap", "GaodeMap");
    private static a cyp;
    private static boolean cyq;
    private OpenLocationMenuItem cyj;
    private OpenLocationMenuItem cyk;
    private LinearLayout.LayoutParams cyl;
    private com.baidu.swan.impl.map.c.a cym;
    private LatLng cyn;
    private OnGetRoutePlanResultListener cyo;
    private LatLng cyr;
    private boolean cys;
    private String cyt;
    private String cyu;
    private Map<OpenLocationMenuItem.MenuItemType, c> cyv;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.cys = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cys = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void asF() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!cyq) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.cyj = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.cyj.a(this);
        addView(this.cyj.asb());
        this.cyv = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.cyv.keySet()) {
            c cVar = this.cyv.get(menuItemType);
            if (cVar.dz(this.mContext) || cVar.asx()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.cys) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.asb().getLayoutParams()).topMargin = af.S(7.0f);
                    this.cys = true;
                }
                addView(openLocationMenuItem.asb());
            }
        }
        this.cyk = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.cyk.a(this);
        this.cyl = (LinearLayout.LayoutParams) this.cyk.asb().getLayoutParams();
        this.cyl.topMargin = af.S(7.0f);
        addView(this.cyk.asb());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(cyi);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.cym != null) {
            List<String> arZ = this.cym.arZ();
            if (arZ != null) {
                arZ.remove("BaiduMap");
                arrayList.removeAll(arZ);
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
        if (this.cym != null) {
            this.cym.arU();
        }
        OpenLocationMenuItem.MenuItemType asa = openLocationMenuItem.asa();
        switch (asa) {
            case OPENLOCATION_PATH:
                cyq = !cyq;
                if (!cyq) {
                    asH();
                    return;
                } else if (cyp == null) {
                    asG();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.cym != null) {
                    a(this.cym.arV(), cyp);
                    this.cym.eL(true);
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
                asJ();
                c cVar = this.cyv.get(asa);
                if (cVar != null) {
                    cVar.b(this.mContext, this.cyn, this.cyr, this.cyt, this.cyu);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.cym = aVar;
        asJ();
        asF();
    }

    private void asG() {
        if (this.cym == null) {
            cyq = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.cym.eL(false);
        final com.baidu.swan.impl.map.f.a asD = com.baidu.swan.impl.map.f.a.asD();
        this.cyo = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                asD.asE();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.cyq = false;
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
                BaiduMap arV = OpenLocationBottomMenu.this.cym.arV();
                if (arV == null) {
                    boolean unused2 = OpenLocationBottomMenu.cyq = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.cyq) {
                    a unused3 = OpenLocationBottomMenu.cyp = new com.baidu.swan.impl.map.e.b(arV);
                    arV.setOnMarkerClickListener(OpenLocationBottomMenu.cyp);
                    OpenLocationBottomMenu.cyp.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.cyp.asA();
                    OpenLocationBottomMenu.cyp.asC();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.cym.eL(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.cyn == null) {
            cyq = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        asD.a(this.cyn, this.cyr, this.cyo);
    }

    private void asH() {
        if (this.cym != null && this.cym.arY()) {
            if (cyp != null) {
                cyp.asB();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void asI() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        cyq = false;
        cyp = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.asA();
            aVar.asC();
        }
    }

    private void asJ() {
        if (this.cym != null) {
            if (this.cyn == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation arX = this.cym.arX();
                if (arX != null) {
                    this.cyn = new LatLng(arX.getLatitude(), arX.getLongitude());
                    String addrStr = arX.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(arX.getStreet()) ? "" : arX.getStreet();
                    }
                    this.cyt = addrStr;
                } else {
                    return;
                }
            }
            if (this.cyr == null) {
                Bundle arguments = this.cym.getArguments();
                this.cyr = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.cyu = string;
            }
        }
    }
}
