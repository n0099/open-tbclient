package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.b.c;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a aSM;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.aSL) {
                    case START:
                        Kz();
                        if (aSM != null) {
                            aSM.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (aSM != null) {
                            aSM.a(searchFlowEvent);
                        }
                        KA();
                        break;
                    case NORMAL:
                        if (aSM != null) {
                            aSM.a(searchFlowEvent);
                            break;
                        }
                        break;
                }
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Add SearchFlowEvent: " + searchFlowEvent.toString());
                }
            }
        }
    }

    public static synchronized void u(com.baidu.swan.apps.v.b.b bVar) {
        synchronized (b.class) {
            if (bVar != null) {
                d(bVar.axQ, bVar.axG);
                if (aSM != null) {
                    aSM.setAppId(bVar.mAppId);
                    aSM.setSource(bVar.axG);
                }
            }
        }
    }

    public static synchronized void f(c cVar) {
        synchronized (b.class) {
            if (cVar != null) {
                d(cVar.DC(), cVar.mFrom);
                if (aSM != null) {
                    aSM.setAppId(cVar.mAppId);
                    aSM.setSource(cVar.mFrom);
                }
            }
        }
    }

    private static void Kz() {
        if (aSM != null) {
            aSM.destroy();
            aSM = null;
        }
        aSM = new a("772");
    }

    private static void KA() {
        if (aSM != null) {
            aSM.send();
        }
    }

    private static void d(Bundle bundle, String str) {
        if (bundle != null) {
            String string = bundle.getString("search_id");
            if (TextUtils.isEmpty(string) && !TextUtils.equals("1002", str)) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "search id is null, and source is not 1002");
                    return;
                }
                return;
            }
            a(new SearchFlowEvent("dom_click", bundle.getLong("search_dom_click_timestamp"), "", "", SearchFlowEvent.EventType.START));
            if (aSM != null) {
                aSM.aB("searchid", string == null ? "" : string);
                aSM.aB("url", bundle.getString("search_url"));
            }
        }
    }
}
