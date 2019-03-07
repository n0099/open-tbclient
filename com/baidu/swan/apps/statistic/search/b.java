package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = c.DEBUG;
    public static a aSL;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.aSK) {
                    case START:
                        Kz();
                        if (aSL != null) {
                            aSL.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (aSL != null) {
                            aSL.a(searchFlowEvent);
                        }
                        KA();
                        break;
                    case NORMAL:
                        if (aSL != null) {
                            aSL.a(searchFlowEvent);
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
                d(bVar.axP, bVar.axF);
                if (aSL != null) {
                    aSL.setAppId(bVar.mAppId);
                    aSL.setSource(bVar.axF);
                }
            }
        }
    }

    public static synchronized void f(com.baidu.swan.apps.v.b.c cVar) {
        synchronized (b.class) {
            if (cVar != null) {
                d(cVar.DC(), cVar.mFrom);
                if (aSL != null) {
                    aSL.setAppId(cVar.mAppId);
                    aSL.setSource(cVar.mFrom);
                }
            }
        }
    }

    private static void Kz() {
        if (aSL != null) {
            aSL.destroy();
            aSL = null;
        }
        aSL = new a("772");
    }

    private static void KA() {
        if (aSL != null) {
            aSL.send();
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
            if (aSL != null) {
                aSL.aB("searchid", string == null ? "" : string);
                aSL.aB("url", bundle.getString("search_url"));
            }
        }
    }
}
