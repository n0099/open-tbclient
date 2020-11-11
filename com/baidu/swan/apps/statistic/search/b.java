package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.u.c.e;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes10.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a dAx;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.dAw) {
                    case START:
                        aKy();
                        if (dAx != null) {
                            dAx.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (dAx != null) {
                            dAx.a(searchFlowEvent);
                        }
                        alP();
                        break;
                    case NORMAL:
                        if (dAx != null) {
                            dAx.a(searchFlowEvent);
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
                f(bVar.ayI(), bVar.ayD());
                if (dAx != null) {
                    dAx.setAppId(bVar.getAppId());
                    dAx.setSource(bVar.ayD());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                f(eVar.ayJ(), eVar.ayD());
                if (dAx != null) {
                    dAx.setAppId(eVar.getAppId());
                    dAx.setSource(eVar.ayD());
                }
            }
        }
    }

    private static void aKy() {
        if (dAx != null) {
            dAx.destroy();
            dAx = null;
        }
        dAx = new a("772");
    }

    private static void alP() {
        if (dAx != null) {
            dAx.send();
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
            if (dAx != null) {
                dAx.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                dAx.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
