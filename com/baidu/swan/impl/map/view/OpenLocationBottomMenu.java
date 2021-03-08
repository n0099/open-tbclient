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
    private static final List<String> esR = Arrays.asList("BaiduMap", "GaodeMap");
    private static a esY;
    private static boolean esZ;
    private OpenLocationMenuItem esS;
    private OpenLocationMenuItem esT;
    private LinearLayout.LayoutParams esU;
    private com.baidu.swan.impl.map.c.a esV;
    private LatLng esW;
    private OnGetRoutePlanResultListener esX;
    private LatLng eta;
    private boolean etb;
    private String etd;
    private String ete;
    private Map<OpenLocationMenuItem.MenuItemType, c> etf;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.etb = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etb = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void bby() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!esZ) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.esS = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.esS.a(this);
        addView(this.esS.baW());
        this.etf = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.etf.keySet()) {
            c cVar = this.etf.get(menuItemType);
            if (cVar.eB(this.mContext) || cVar.bbr()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.etb) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.baW().getLayoutParams()).topMargin = ah.T(7.0f);
                    this.etb = true;
                }
                addView(openLocationMenuItem.baW());
            }
        }
        this.esT = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.esT.a(this);
        this.esU = (LinearLayout.LayoutParams) this.esT.baW().getLayoutParams();
        this.esU.topMargin = ah.T(7.0f);
        addView(this.esT.baW());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(esR);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.esV != null) {
            List<String> baU = this.esV.baU();
            if (baU != null) {
                baU.remove("BaiduMap");
                arrayList.removeAll(baU);
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
        if (this.esV != null) {
            this.esV.baP();
        }
        OpenLocationMenuItem.MenuItemType baV = openLocationMenuItem.baV();
        switch (baV) {
            case OPENLOCATION_PATH:
                esZ = !esZ;
                if (!esZ) {
                    bbA();
                    return;
                } else if (esY == null) {
                    bbz();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.esV != null) {
                    a(this.esV.baQ(), esY);
                    this.esV.iq(true);
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
                bbC();
                c cVar = this.etf.get(baV);
                if (cVar != null) {
                    cVar.b(this.mContext, this.esW, this.eta, this.etd, this.ete);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.esV = aVar;
        bbC();
        bby();
    }

    private void bbz() {
        if (this.esV == null) {
            esZ = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.esV.iq(false);
        final com.baidu.swan.impl.map.f.a bbw = com.baidu.swan.impl.map.f.a.bbw();
        this.esX = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                bbw.bbx();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.esZ = false;
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
                BaiduMap baQ = OpenLocationBottomMenu.this.esV.baQ();
                if (baQ == null) {
                    boolean unused2 = OpenLocationBottomMenu.esZ = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.esZ) {
                    a unused3 = OpenLocationBottomMenu.esY = new com.baidu.swan.impl.map.e.b(baQ);
                    baQ.setOnMarkerClickListener(OpenLocationBottomMenu.esY);
                    OpenLocationBottomMenu.esY.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.esY.bbt();
                    OpenLocationBottomMenu.esY.bbv();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.esV.iq(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.esW == null) {
            esZ = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        bbw.a(this.esW, this.eta, this.esX);
    }

    private void bbA() {
        if (this.esV != null && this.esV.baT()) {
            if (esY != null) {
                esY.bbu();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void bbB() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        esZ = false;
        esY = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.bbt();
            aVar.bbv();
        }
    }

    private void bbC() {
        if (this.esV != null) {
            if (this.esW == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation baS = this.esV.baS();
                if (baS != null) {
                    this.esW = new LatLng(baS.getLatitude(), baS.getLongitude());
                    String addrStr = baS.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(baS.getStreet()) ? "" : baS.getStreet();
                    }
                    this.etd = addrStr;
                } else {
                    return;
                }
            }
            if (this.eta == null) {
                Bundle arguments = this.esV.getArguments();
                this.eta = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.ete = string;
            }
        }
    }
}
