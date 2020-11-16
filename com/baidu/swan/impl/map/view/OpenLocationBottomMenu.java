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
/* loaded from: classes24.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.a {
    protected static final boolean DEBUG = b.DEBUG;
    private static final List<String> edR = Arrays.asList("BaiduMap", "GaodeMap");
    private static a edY;
    private static boolean edZ;
    private OpenLocationMenuItem edS;
    private OpenLocationMenuItem edT;
    private LinearLayout.LayoutParams edU;
    private com.baidu.swan.impl.map.c.a edV;
    private LatLng edW;
    private OnGetRoutePlanResultListener edX;
    private LatLng eea;
    private boolean eeb;
    private String eec;
    private String eed;
    private Map<OpenLocationMenuItem.MenuItemType, c> eee;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.eeb = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eeb = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void aZE() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!edZ) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.edS = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.edS.a(this);
        addView(this.edS.aZc());
        this.eee = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.eee.keySet()) {
            c cVar = this.eee.get(menuItemType);
            if (cVar.dF(this.mContext) || cVar.aZx()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.eeb) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.aZc().getLayoutParams()).topMargin = ah.M(7.0f);
                    this.eeb = true;
                }
                addView(openLocationMenuItem.aZc());
            }
        }
        this.edT = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.edT.a(this);
        this.edU = (LinearLayout.LayoutParams) this.edT.aZc().getLayoutParams();
        this.edU.topMargin = ah.M(7.0f);
        addView(this.edT.aZc());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(edR);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.edV != null) {
            List<String> aZa = this.edV.aZa();
            if (aZa != null) {
                aZa.remove("BaiduMap");
                arrayList.removeAll(aZa);
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
        if (this.edV != null) {
            this.edV.aYV();
        }
        OpenLocationMenuItem.MenuItemType aZb = openLocationMenuItem.aZb();
        switch (aZb) {
            case OPENLOCATION_PATH:
                edZ = !edZ;
                if (!edZ) {
                    aZG();
                    return;
                } else if (edY == null) {
                    aZF();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.edV != null) {
                    a(this.edV.aYW(), edY);
                    this.edV.hL(true);
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
                aZI();
                c cVar = this.eee.get(aZb);
                if (cVar != null) {
                    cVar.b(this.mContext, this.edW, this.eea, this.eec, this.eed);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.edV = aVar;
        aZI();
        aZE();
    }

    private void aZF() {
        if (this.edV == null) {
            edZ = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.edV.hL(false);
        final com.baidu.swan.impl.map.f.a aZC = com.baidu.swan.impl.map.f.a.aZC();
        this.edX = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                aZC.aZD();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.edZ = false;
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
                BaiduMap aYW = OpenLocationBottomMenu.this.edV.aYW();
                if (aYW == null) {
                    boolean unused2 = OpenLocationBottomMenu.edZ = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.edZ) {
                    a unused3 = OpenLocationBottomMenu.edY = new com.baidu.swan.impl.map.e.b(aYW);
                    aYW.setOnMarkerClickListener(OpenLocationBottomMenu.edY);
                    OpenLocationBottomMenu.edY.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.edY.aZz();
                    OpenLocationBottomMenu.edY.aZB();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.edV.hL(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.edW == null) {
            edZ = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aZC.a(this.edW, this.eea, this.edX);
    }

    private void aZG() {
        if (this.edV != null && this.edV.aYZ()) {
            if (edY != null) {
                edY.aZA();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void aZH() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        edZ = false;
        edY = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aZz();
            aVar.aZB();
        }
    }

    private void aZI() {
        if (this.edV != null) {
            if (this.edW == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation aYY = this.edV.aYY();
                if (aYY != null) {
                    this.edW = new LatLng(aYY.getLatitude(), aYY.getLongitude());
                    String addrStr = aYY.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(aYY.getStreet()) ? "" : aYY.getStreet();
                    }
                    this.eec = addrStr;
                } else {
                    return;
                }
            }
            if (this.eea == null) {
                Bundle arguments = this.edV.getArguments();
                this.eea = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.eed = string;
            }
        }
    }
}
