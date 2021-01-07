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
/* loaded from: classes9.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.a {
    protected static final boolean DEBUG = b.DEBUG;
    private static final List<String> etX = Arrays.asList("BaiduMap", "GaodeMap");
    private static a eue;
    private static boolean euf;
    private OpenLocationMenuItem etY;
    private OpenLocationMenuItem etZ;
    private LinearLayout.LayoutParams eua;
    private com.baidu.swan.impl.map.c.a eub;
    private LatLng euc;
    private OnGetRoutePlanResultListener eud;
    private LatLng eug;
    private boolean euh;
    private String eui;
    private String euj;
    private Map<OpenLocationMenuItem.MenuItemType, c> euk;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.euh = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.euh = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void bfd() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!euf) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.etY = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.etY.a(this);
        addView(this.etY.beA());
        this.euk = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.euk.keySet()) {
            c cVar = this.euk.get(menuItemType);
            if (cVar.eE(this.mContext) || cVar.beW()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.euh) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.beA().getLayoutParams()).topMargin = ah.O(7.0f);
                    this.euh = true;
                }
                addView(openLocationMenuItem.beA());
            }
        }
        this.etZ = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.etZ.a(this);
        this.eua = (LinearLayout.LayoutParams) this.etZ.beA().getLayoutParams();
        this.eua.topMargin = ah.O(7.0f);
        addView(this.etZ.beA());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(etX);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.eub != null) {
            List<String> bey = this.eub.bey();
            if (bey != null) {
                bey.remove("BaiduMap");
                arrayList.removeAll(bey);
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
        if (this.eub != null) {
            this.eub.bet();
        }
        OpenLocationMenuItem.MenuItemType bez = openLocationMenuItem.bez();
        switch (bez) {
            case OPENLOCATION_PATH:
                euf = !euf;
                if (!euf) {
                    bff();
                    return;
                } else if (eue == null) {
                    bfe();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.eub != null) {
                    a(this.eub.beu(), eue);
                    this.eub.is(true);
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
                bfh();
                c cVar = this.euk.get(bez);
                if (cVar != null) {
                    cVar.b(this.mContext, this.euc, this.eug, this.eui, this.euj);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.eub = aVar;
        bfh();
        bfd();
    }

    private void bfe() {
        if (this.eub == null) {
            euf = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.eub.is(false);
        final com.baidu.swan.impl.map.f.a bfb = com.baidu.swan.impl.map.f.a.bfb();
        this.eud = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                bfb.bfc();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.euf = false;
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
                BaiduMap beu = OpenLocationBottomMenu.this.eub.beu();
                if (beu == null) {
                    boolean unused2 = OpenLocationBottomMenu.euf = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.euf) {
                    a unused3 = OpenLocationBottomMenu.eue = new com.baidu.swan.impl.map.e.b(beu);
                    beu.setOnMarkerClickListener(OpenLocationBottomMenu.eue);
                    OpenLocationBottomMenu.eue.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.eue.beY();
                    OpenLocationBottomMenu.eue.bfa();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.eub.is(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.euc == null) {
            euf = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        bfb.a(this.euc, this.eug, this.eud);
    }

    private void bff() {
        if (this.eub != null && this.eub.bex()) {
            if (eue != null) {
                eue.beZ();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void bfg() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        euf = false;
        eue = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.beY();
            aVar.bfa();
        }
    }

    private void bfh() {
        if (this.eub != null) {
            if (this.euc == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation bew = this.eub.bew();
                if (bew != null) {
                    this.euc = new LatLng(bew.getLatitude(), bew.getLongitude());
                    String addrStr = bew.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(bew.getStreet()) ? "" : bew.getStreet();
                    }
                    this.eui = addrStr;
                } else {
                    return;
                }
            }
            if (this.eug == null) {
                Bundle arguments = this.eub.getArguments();
                this.eug = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.euj = string;
            }
        }
    }
}
