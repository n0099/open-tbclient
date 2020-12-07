package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.u.c.e;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes25.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a dFP;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.dFO) {
                    case START:
                        aMX();
                        if (dFP != null) {
                            dFP.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (dFP != null) {
                            dFP.a(searchFlowEvent);
                        }
                        aop();
                        break;
                    case NORMAL:
                        if (dFP != null) {
                            dFP.a(searchFlowEvent);
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
                f(bVar.aBj(), bVar.aBe());
                if (dFP != null) {
                    dFP.setAppId(bVar.getAppId());
                    dFP.setSource(bVar.aBe());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                f(eVar.aBk(), eVar.aBe());
                if (dFP != null) {
                    dFP.setAppId(eVar.getAppId());
                    dFP.setSource(eVar.aBe());
                }
            }
        }
    }

    private static void aMX() {
        if (dFP != null) {
            dFP.destroy();
            dFP = null;
        }
        dFP = new a("772");
    }

    private static void aop() {
        if (dFP != null) {
            dFP.send();
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
            if (dFP != null) {
                dFP.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                dFP.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
