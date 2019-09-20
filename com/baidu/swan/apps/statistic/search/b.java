package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.b.c;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a aWN;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.aWM) {
                    case START:
                        NR();
                        if (aWN != null) {
                            aWN.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (aWN != null) {
                            aWN.a(searchFlowEvent);
                        }
                        NS();
                        break;
                    case NORMAL:
                        if (aWN != null) {
                            aWN.a(searchFlowEvent);
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

    public static synchronized void w(com.baidu.swan.apps.v.b.b bVar) {
        synchronized (b.class) {
            if (bVar != null) {
                c(bVar.FO(), bVar.FK());
                if (aWN != null) {
                    aWN.setAppId(bVar.getAppId());
                    aWN.setSource(bVar.FK());
                }
            }
        }
    }

    public static synchronized void f(c cVar) {
        synchronized (b.class) {
            if (cVar != null) {
                c(cVar.Fy(), cVar.mFrom);
                if (aWN != null) {
                    aWN.setAppId(cVar.mAppId);
                    aWN.setSource(cVar.mFrom);
                }
            }
        }
    }

    private static void NR() {
        if (aWN != null) {
            aWN.destroy();
            aWN = null;
        }
        aWN = new a("772");
    }

    private static void NS() {
        if (aWN != null) {
            aWN.send();
        }
    }

    private static void c(Bundle bundle, String str) {
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
            if (aWN != null) {
                aWN.aD("searchid", string == null ? "" : string);
                aWN.aD("url", bundle.getString("search_url"));
            }
        }
    }
}
