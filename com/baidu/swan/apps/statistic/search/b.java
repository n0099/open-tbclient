package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.b.c;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a aVF;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.aVE) {
                    case START:
                        MY();
                        if (aVF != null) {
                            aVF.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (aVF != null) {
                            aVF.a(searchFlowEvent);
                        }
                        MZ();
                        break;
                    case NORMAL:
                        if (aVF != null) {
                            aVF.a(searchFlowEvent);
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
                c(bVar.Fa(), bVar.EW());
                if (aVF != null) {
                    aVF.setAppId(bVar.getAppId());
                    aVF.setSource(bVar.EW());
                }
            }
        }
    }

    public static synchronized void f(c cVar) {
        synchronized (b.class) {
            if (cVar != null) {
                c(cVar.EK(), cVar.mFrom);
                if (aVF != null) {
                    aVF.setAppId(cVar.mAppId);
                    aVF.setSource(cVar.mFrom);
                }
            }
        }
    }

    private static void MY() {
        if (aVF != null) {
            aVF.destroy();
            aVF = null;
        }
        aVF = new a("772");
    }

    private static void MZ() {
        if (aVF != null) {
            aVF.send();
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
            if (aVF != null) {
                aVF.aD("searchid", string == null ? "" : string);
                aVF.aD("url", bundle.getString("search_url"));
            }
        }
    }
}
