package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.u.c.e;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes7.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a dyQ;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.dyP) {
                    case START:
                        aJQ();
                        if (dyQ != null) {
                            dyQ.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (dyQ != null) {
                            dyQ.a(searchFlowEvent);
                        }
                        alh();
                        break;
                    case NORMAL:
                        if (dyQ != null) {
                            dyQ.a(searchFlowEvent);
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
                f(bVar.aya(), bVar.axV());
                if (dyQ != null) {
                    dyQ.setAppId(bVar.getAppId());
                    dyQ.setSource(bVar.axV());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                f(eVar.ayb(), eVar.axV());
                if (dyQ != null) {
                    dyQ.setAppId(eVar.getAppId());
                    dyQ.setSource(eVar.axV());
                }
            }
        }
    }

    private static void aJQ() {
        if (dyQ != null) {
            dyQ.destroy();
            dyQ = null;
        }
        dyQ = new a("772");
    }

    private static void alh() {
        if (dyQ != null) {
            dyQ.send();
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
            if (dyQ != null) {
                dyQ.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                dyQ.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
