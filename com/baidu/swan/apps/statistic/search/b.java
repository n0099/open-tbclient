package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.b.c;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a aWp;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.aWo) {
                    case START:
                        NN();
                        if (aWp != null) {
                            aWp.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (aWp != null) {
                            aWp.a(searchFlowEvent);
                        }
                        NO();
                        break;
                    case NORMAL:
                        if (aWp != null) {
                            aWp.a(searchFlowEvent);
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
                c(bVar.FK(), bVar.FG());
                if (aWp != null) {
                    aWp.setAppId(bVar.getAppId());
                    aWp.setSource(bVar.FG());
                }
            }
        }
    }

    public static synchronized void f(c cVar) {
        synchronized (b.class) {
            if (cVar != null) {
                c(cVar.Fu(), cVar.mFrom);
                if (aWp != null) {
                    aWp.setAppId(cVar.mAppId);
                    aWp.setSource(cVar.mFrom);
                }
            }
        }
    }

    private static void NN() {
        if (aWp != null) {
            aWp.destroy();
            aWp = null;
        }
        aWp = new a("772");
    }

    private static void NO() {
        if (aWp != null) {
            aWp.send();
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
            if (aWp != null) {
                aWp.aD("searchid", string == null ? "" : string);
                aWp.aD("url", bundle.getString("search_url"));
            }
        }
    }
}
