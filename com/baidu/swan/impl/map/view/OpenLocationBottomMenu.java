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
    private static final List<String> dFk = Arrays.asList("BaiduMap", "GaodeMap");
    private static a dFr;
    private static boolean dFs;
    private OpenLocationMenuItem dFl;
    private OpenLocationMenuItem dFm;
    private LinearLayout.LayoutParams dFn;
    private com.baidu.swan.impl.map.c.a dFo;
    private LatLng dFp;
    private OnGetRoutePlanResultListener dFq;
    private LatLng dFt;
    private boolean dFu;
    private String dFv;
    private String dFw;
    private Map<OpenLocationMenuItem.MenuItemType, c> dFx;
    private Context mContext;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.dFu = false;
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dFu = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    private void aTj() {
        String string;
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!dFs) {
            string = this.mContext.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(R.string.openlocation_bottommenu_hidepath);
        }
        this.dFl = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.dFl.a(this);
        addView(this.dFl.aSG());
        this.dFx = getMapApps();
        for (OpenLocationMenuItem.MenuItemType menuItemType : this.dFx.keySet()) {
            c cVar = this.dFx.get(menuItemType);
            if (cVar.dz(this.mContext) || cVar.aTb()) {
                OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.mContext, cVar.getName(), menuItemType);
                openLocationMenuItem.a(this);
                if (!this.dFu) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem.aSG().getLayoutParams()).topMargin = ah.H(7.0f);
                    this.dFu = true;
                }
                addView(openLocationMenuItem.aSG());
            }
        }
        this.dFm = new OpenLocationMenuItem(this.mContext, this.mContext.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.dFm.a(this);
        this.dFn = (LinearLayout.LayoutParams) this.dFm.aSG().getLayoutParams();
        this.dFn.topMargin = ah.H(7.0f);
        addView(this.dFm.aSG());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        boolean z;
        ArrayList<String> arrayList = new ArrayList(dFk);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.dFo != null) {
            List<String> aSE = this.dFo.aSE();
            if (aSE != null) {
                aSE.remove("BaiduMap");
                arrayList.removeAll(aSE);
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
        if (this.dFo != null) {
            this.dFo.aSz();
        }
        OpenLocationMenuItem.MenuItemType aSF = openLocationMenuItem.aSF();
        switch (aSF) {
            case OPENLOCATION_PATH:
                dFs = !dFs;
                if (!dFs) {
                    aTl();
                    return;
                } else if (dFr == null) {
                    aTk();
                    if (DEBUG) {
                        Log.e("OpenLocationBottomMenu", "use a new path");
                        return;
                    }
                    return;
                } else if (this.dFo != null) {
                    a(this.dFo.aSA(), dFr);
                    this.dFo.gQ(true);
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
                aTn();
                c cVar = this.dFx.get(aSF);
                if (cVar != null) {
                    cVar.b(this.mContext, this.dFp, this.dFt, this.dFv, this.dFw);
                    return;
                }
                return;
        }
    }

    public void setFragment(com.baidu.swan.impl.map.c.a aVar) {
        this.dFo = aVar;
        aTn();
        aTj();
    }

    private void aTk() {
        if (this.dFo == null) {
            dFs = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        this.dFo.gQ(false);
        final com.baidu.swan.impl.map.f.a aTh = com.baidu.swan.impl.map.f.a.aTh();
        this.dFq = new OnGetRoutePlanResultListener() { // from class: com.baidu.swan.impl.map.view.OpenLocationBottomMenu.1
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
                aTh.aTi();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.dFs = false;
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
                BaiduMap aSA = OpenLocationBottomMenu.this.dFo.aSA();
                if (aSA == null) {
                    boolean unused2 = OpenLocationBottomMenu.dFs = false;
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.dFs) {
                    a unused3 = OpenLocationBottomMenu.dFr = new com.baidu.swan.impl.map.e.b(aSA);
                    aSA.setOnMarkerClickListener(OpenLocationBottomMenu.dFr);
                    OpenLocationBottomMenu.dFr.a(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.dFr.aTe();
                    OpenLocationBottomMenu.dFr.aTg();
                    if (OpenLocationBottomMenu.DEBUG) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    OpenLocationBottomMenu.this.dFo.gQ(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.dFp == null) {
            dFs = false;
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        aTh.a(this.dFp, this.dFt, this.dFq);
    }

    private void aTl() {
        if (this.dFo != null && this.dFo.aSD()) {
            if (dFr != null) {
                dFr.aTf();
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (DEBUG) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public static void aTm() {
        if (DEBUG) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        dFs = false;
        dFr = null;
    }

    private void a(BaiduMap baiduMap, a aVar) {
        if (baiduMap != null && aVar != null) {
            baiduMap.setOnMarkerClickListener(aVar);
            aVar.aTe();
            aVar.aTg();
        }
    }

    private void aTn() {
        if (this.dFo != null) {
            if (this.dFp == null) {
                if (DEBUG) {
                    Log.e("OpenLocationBottomMenu", "getStartPosi again");
                }
                BDLocation aSC = this.dFo.aSC();
                if (aSC != null) {
                    this.dFp = new LatLng(aSC.getLatitude(), aSC.getLongitude());
                    String addrStr = aSC.getAddrStr();
                    if (TextUtils.isEmpty(addrStr)) {
                        addrStr = TextUtils.isEmpty(aSC.getStreet()) ? "" : aSC.getStreet();
                    }
                    this.dFv = addrStr;
                } else {
                    return;
                }
            }
            if (this.dFt == null) {
                Bundle arguments = this.dFo.getArguments();
                this.dFt = new LatLng(arguments.getDouble("latitude"), arguments.getDouble("longitude"));
                String string = arguments.getString("name");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                this.dFw = string;
            }
        }
    }
}
