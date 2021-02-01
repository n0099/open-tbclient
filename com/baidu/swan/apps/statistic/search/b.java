package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.u.c.e;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes9.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a dLL;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.dLK) {
                    case START:
                        aLN();
                        if (dLL != null) {
                            dLL.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (dLL != null) {
                            dLL.a(searchFlowEvent);
                        }
                        amg();
                        break;
                    case NORMAL:
                        if (dLL != null) {
                            dLL.a(searchFlowEvent);
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
                f(bVar.azf(), bVar.aza());
                if (dLL != null) {
                    dLL.setAppId(bVar.getAppId());
                    dLL.setSource(bVar.aza());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                f(eVar.azg(), eVar.aza());
                if (dLL != null) {
                    dLL.setAppId(eVar.getAppId());
                    dLL.setSource(eVar.aza());
                }
            }
        }
    }

    private static void aLN() {
        if (dLL != null) {
            dLL.destroy();
            dLL = null;
        }
        dLL = new a("772");
    }

    private static void amg() {
        if (dLL != null) {
            dLL.send();
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
            if (dLL != null) {
                dLL.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                dLL.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
