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
/* loaded from: classes25.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.a {
    protected static final boolean DEBUG = b.DEBUG;
    private static final List<String> dRl = Arrays.asList("BaiduMap", "GaodeMap");
    private static a dRs;
    private static boolean dRt;
    private OpenLocationMenuItem dRm;
    private OpenLocationMenuItem dRn;
    private LinearLayout.LayoutParams dRo;
    private com.baidu.swan.impl.map.c.a dRp;
    private LatLng dRq;
    private OnGetRoutePlanResultListener dRr;
    private LatLng dRu;
    private boolean dRv;
    private String dRw;
    private String dRx;
    private Map<OpenLocationMenuItem.MenuItemType, c> dRy;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.dRv = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRv = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void aVS() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!dRt) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.dRm = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.dRm.a(this);
        addView(this.dRm.aVp());
        this.dRy = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.dRy.keySet()) {
            c cVar = this.dRy.get(menuItemType);
            if (cVar.dF(this.mContext) || cVar.aVK()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.dRv) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.aVp().getLayoutParams()).topMargin = ah.J(7.0f);
                    this.dRv = true;
                }
                addView(openLocationMenuItem.aVp());
            }
        }
        this.dRn = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.dRn.a(this);
        this.dRo = (LinearLayout.LayoutParams) this.dRn.aVp().getLayoutParams();
        this.dRo.topMargin = ah.J(7.0f);
        addView(this.dRn.aVp());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(dRl);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.dRp != null) {
            List<String> aVn = this.dRp.aVn();
            if (aVn != null) {
                aVn.remove("BaiduMap");
                arrayList.removeAll(aVn);
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
        if (this.dRp != null) {
            this.dRp.aVi();
        }
        OpenLocationMenuItem.MenuItemType aVo = openLocationMenuItem.aVo();
        switch (aVo) {
            case OPENLOCATION_PATH:
                dRt = !dRt;
                if (!dRt) {
                    aVU();
                    return;
                } else if (dRs == null) {
                    aVT();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.dRp != null) {
                    a(this.dRp.aVj(), dRs);
                    this.dRp.hm(true);
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
                aVW();
                c cVar = this.dRy.get(aVo);
                if (cVar != null) {
                    cVar.b(this.mContext, this.dRq, this.dRu, this.dRw, this.dRx);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.dRp = aVar;
        aVW();
        aVS();
    }

    private void aVT() {
        if (this.dRp == null) {
            dRt = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.dRp.hm(false);
        final com.baidu.swan.impl.map.f.a aVQ = com.baidu.swan.impl.map.f.a.aVQ();
        this.dRr = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                aVQ.aVR();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.dRt = false;
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
                BaiduMap aVj = OpenLocationBottomMenu.this.dRp.aVj();
                if (aVj == null) {
                    boolean unused2 = OpenLocationBottomMenu.dRt = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.dRt) {
                    a unused3 = OpenLocationBottomMenu.dRs = new com.baidu.swan.impl.map.e.b(aVj);
                    aVj.setOnMarkerClickListener(OpenLocationBottomMenu.dRs);
                    OpenLocationBottomMenu.dRs.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.dRs.aVN();
                    OpenLocationBottomMenu.dRs.aVP();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.dRp.hm(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.dRq == null) {
            dRt = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aVQ.a(this.dRq, this.dRu, this.dRr);
    }

    private void aVU() {
        if (this.dRp != null && this.dRp.aVm()) {
            if (dRs != null) {
                dRs.aVO();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void aVV() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        dRt = false;
        dRs = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aVN();
            aVar.aVP();
        }
    }

    private void aVW() {
        if (this.dRp != null) {
            if (this.dRq == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation aVl = this.dRp.aVl();
                if (aVl != null) {
                    this.dRq = new LatLng(aVl.getLatitude(), aVl.getLongitude());
                    String addrStr = aVl.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(aVl.getStreet()) ? "" : aVl.getStreet();
                    }
                    this.dRw = addrStr;
                } else {
                    return;
                }
            }
            if (this.dRu == null) {
                Bundle arguments = this.dRp.getArguments();
                this.dRu = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.dRx = string;
            }
        }
    }
}
