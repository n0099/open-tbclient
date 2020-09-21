package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.u.c.e;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes3.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a cZT;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.cZS) {
                    case START:
                        aDv();
                        if (cZT != null) {
                            cZT.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (cZT != null) {
                            cZT.a(searchFlowEvent);
                        }
                        aeK();
                        break;
                    case NORMAL:
                        if (cZT != null) {
                            cZT.a(searchFlowEvent);
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

    public static synchronized void p(com.baidu.swan.apps.u.c.b bVar) {
        synchronized (b.class) {
            if (bVar != null) {
                f(bVar.arC(), bVar.arx());
                if (cZT != null) {
                    cZT.setAppId(bVar.getAppId());
                    cZT.setSource(bVar.arx());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                f(eVar.arD(), eVar.arx());
                if (cZT != null) {
                    cZT.setAppId(eVar.getAppId());
                    cZT.setSource(eVar.arx());
                }
            }
        }
    }

    private static void aDv() {
        if (cZT != null) {
            cZT.destroy();
            cZT = null;
        }
        cZT = new a("772");
    }

    private static void aeK() {
        if (cZT != null) {
            cZT.send();
        }
    }

    private static void f(Bundle bundle, String str) {
        if (bundle != null) {
            String string = bundle.getString("search_id");
            if (TextUtils.isEmpty(string) && !TextUtils.equals(PayHelper.STATUS_FAIL, str)) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "search id is null, and source is not 1002");
                    return;
                }
                return;
            }
            a(new SearchFlowEvent("dom_click", bundle.getLong("search_dom_click_timestamp"), "", "", SearchFlowEvent.EventType.START));
            if (cZT != null) {
                cZT.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                cZT.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
