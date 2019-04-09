package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.b.c;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a aSQ;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.aSP) {
                    case START:
                        Kx();
                        if (aSQ != null) {
                            aSQ.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (aSQ != null) {
                            aSQ.a(searchFlowEvent);
                        }
                        Ky();
                        break;
                    case NORMAL:
                        if (aSQ != null) {
                            aSQ.a(searchFlowEvent);
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
                d(bVar.axU, bVar.axK);
                if (aSQ != null) {
                    aSQ.setAppId(bVar.mAppId);
                    aSQ.setSource(bVar.axK);
                }
            }
        }
    }

    public static synchronized void f(c cVar) {
        synchronized (b.class) {
            if (cVar != null) {
                d(cVar.DA(), cVar.mFrom);
                if (aSQ != null) {
                    aSQ.setAppId(cVar.mAppId);
                    aSQ.setSource(cVar.mFrom);
                }
            }
        }
    }

    private static void Kx() {
        if (aSQ != null) {
            aSQ.destroy();
            aSQ = null;
        }
        aSQ = new a("772");
    }

    private static void Ky() {
        if (aSQ != null) {
            aSQ.send();
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
            if (aSQ != null) {
                aSQ.aB("searchid", string == null ? "" : string);
                aSQ.aB("url", bundle.getString("search_url"));
            }
        }
    }
}
