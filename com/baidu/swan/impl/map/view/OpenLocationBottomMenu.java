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
    private static final List<String> ekS = Arrays.asList("BaiduMap", "GaodeMap");
    private static a ekZ;
    private static boolean ela;
    private OpenLocationMenuItem ekT;
    private OpenLocationMenuItem ekU;
    private LinearLayout.LayoutParams ekV;
    private com.baidu.swan.impl.map.c.a ekW;
    private LatLng ekX;
    private OnGetRoutePlanResultListener ekY;
    private LatLng elb;
    private boolean elc;
    private String eld;
    private String ele;
    private Map<OpenLocationMenuItem.MenuItemType, c> elf;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.elc = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.elc = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void bcJ() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!ela) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.ekT = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.ekT.a(this);
        addView(this.ekT.bch());
        this.elf = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.elf.keySet()) {
            c cVar = this.elf.get(menuItemType);
            if (cVar.el(this.mContext) || cVar.bcC()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.elc) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.bch().getLayoutParams()).topMargin = ah.M(7.0f);
                    this.elc = true;
                }
                addView(openLocationMenuItem.bch());
            }
        }
        this.ekU = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.ekU.a(this);
        this.ekV = (LinearLayout.LayoutParams) this.ekU.bch().getLayoutParams();
        this.ekV.topMargin = ah.M(7.0f);
        addView(this.ekU.bch());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(ekS);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.ekW != null) {
            List<String> bcf = this.ekW.bcf();
            if (bcf != null) {
                bcf.remove("BaiduMap");
                arrayList.removeAll(bcf);
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
        if (this.ekW != null) {
            this.ekW.bca();
        }
        OpenLocationMenuItem.MenuItemType bcg = openLocationMenuItem.bcg();
        switch (bcg) {
            case OPENLOCATION_PATH:
                ela = !ela;
                if (!ela) {
                    bcL();
                    return;
                } else if (ekZ == null) {
                    bcK();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.ekW != null) {
                    a(this.ekW.bcb(), ekZ);
                    this.ekW.ia(true);
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
                bcN();
                c cVar = this.elf.get(bcg);
                if (cVar != null) {
                    cVar.b(this.mContext, this.ekX, this.elb, this.eld, this.ele);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.ekW = aVar;
        bcN();
        bcJ();
    }

    private void bcK() {
        if (this.ekW == null) {
            ela = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.ekW.ia(false);
        final com.baidu.swan.impl.map.f.a bcH = com.baidu.swan.impl.map.f.a.bcH();
        this.ekY = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                bcH.bcI();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.ela = false;
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
                BaiduMap bcb = OpenLocationBottomMenu.this.ekW.bcb();
                if (bcb == null) {
                    boolean unused2 = OpenLocationBottomMenu.ela = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.ela) {
                    a unused3 = OpenLocationBottomMenu.ekZ = new com.baidu.swan.impl.map.e.b(bcb);
                    bcb.setOnMarkerClickListener(OpenLocationBottomMenu.ekZ);
                    OpenLocationBottomMenu.ekZ.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.ekZ.bcE();
                    OpenLocationBottomMenu.ekZ.bcG();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.ekW.ia(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.ekX == null) {
            ela = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        bcH.a(this.ekX, this.elb, this.ekY);
    }

    private void bcL() {
        if (this.ekW != null && this.ekW.bce()) {
            if (ekZ != null) {
                ekZ.bcF();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void bcM() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        ela = false;
        ekZ = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.bcE();
            aVar.bcG();
        }
    }

    private void bcN() {
        if (this.ekW != null) {
            if (this.ekX == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation bcd = this.ekW.bcd();
                if (bcd != null) {
                    this.ekX = new LatLng(bcd.getLatitude(), bcd.getLongitude());
                    String addrStr = bcd.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(bcd.getStreet()) ? "" : bcd.getStreet();
                    }
                    this.eld = addrStr;
                } else {
                    return;
                }
            }
            if (this.elb == null) {
                Bundle arguments = this.ekW.getArguments();
                this.elb = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.ele = string;
            }
        }
    }
}
