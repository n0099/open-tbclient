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
    private static a efF;
    private static boolean efG;
    private OpenLocationMenuItem efA;
    private LinearLayout.LayoutParams efB;
    private com.baidu.swan.impl.map.c.a efC;
    private LatLng efD;
    private OnGetRoutePlanResultListener efE;
    private LatLng efH;
    private boolean efI;
    private String efJ;
    private String efK;
    private Map<OpenLocationMenuItem.MenuItemType, c> efL;
    private OpenLocationMenuItem efz;
    private Context mContext;
    protected static final boolean DEBUG = b.DEBUG;
    private static final List<String> efy = Arrays.asList("BaiduMap", "GaodeMap");

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.efI = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efI = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void bal() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!efG) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.efz = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.efz.a(this);
        addView(this.efz.aZJ());
        this.efL = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.efL.keySet()) {
            c cVar = this.efL.get(menuItemType);
            if (cVar.dF(this.mContext) || cVar.bae()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.efI) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.aZJ().getLayoutParams()).topMargin = ah.N(7.0f);
                    this.efI = true;
                }
                addView(openLocationMenuItem.aZJ());
            }
        }
        this.efA = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.efA.a(this);
        this.efB = (LinearLayout.LayoutParams) this.efA.aZJ().getLayoutParams();
        this.efB.topMargin = ah.N(7.0f);
        addView(this.efA.aZJ());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(efy);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.efC != null) {
            List<String> aZH = this.efC.aZH();
            if (aZH != null) {
                aZH.remove("BaiduMap");
                arrayList.removeAll(aZH);
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
        if (this.efC != null) {
            this.efC.aZC();
        }
        OpenLocationMenuItem.MenuItemType aZI = openLocationMenuItem.aZI();
        switch (aZI) {
            case OPENLOCATION_PATH:
                efG = !efG;
                if (!efG) {
                    ban();
                    return;
                } else if (efF == null) {
                    bam();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.efC != null) {
                    a(this.efC.aZD(), efF);
                    this.efC.hI(true);
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
                bap();
                c cVar = this.efL.get(aZI);
                if (cVar != null) {
                    cVar.b(this.mContext, this.efD, this.efH, this.efJ, this.efK);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.efC = aVar;
        bap();
        bal();
    }

    private void bam() {
        if (this.efC == null) {
            efG = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.efC.hI(false);
        final com.baidu.swan.impl.map.f.a baj = com.baidu.swan.impl.map.f.a.baj();
        this.efE = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                baj.bak();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.efG = false;
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
                BaiduMap aZD = OpenLocationBottomMenu.this.efC.aZD();
                if (aZD == null) {
                    boolean unused2 = OpenLocationBottomMenu.efG = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.efG) {
                    a unused3 = OpenLocationBottomMenu.efF = new com.baidu.swan.impl.map.e.b(aZD);
                    aZD.setOnMarkerClickListener(OpenLocationBottomMenu.efF);
                    OpenLocationBottomMenu.efF.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.efF.bag();
                    OpenLocationBottomMenu.efF.bai();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.efC.hI(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.efD == null) {
            efG = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        baj.a(this.efD, this.efH, this.efE);
    }

    private void ban() {
        if (this.efC != null && this.efC.aZG()) {
            if (efF != null) {
                efF.bah();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void bao() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        efG = false;
        efF = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.bag();
            aVar.bai();
        }
    }

    private void bap() {
        if (this.efC != null) {
            if (this.efD == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation aZF = this.efC.aZF();
                if (aZF != null) {
                    this.efD = new LatLng(aZF.getLatitude(), aZF.getLongitude());
                    String addrStr = aZF.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(aZF.getStreet()) ? "" : aZF.getStreet();
                    }
                    this.efJ = addrStr;
                } else {
                    return;
                }
            }
            if (this.efH == null) {
                Bundle arguments = this.efC.getArguments();
                this.efH = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.efK = string;
            }
        }
    }
}
