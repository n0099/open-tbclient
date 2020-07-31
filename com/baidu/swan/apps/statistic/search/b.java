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
    public static a cOP;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.cOO) {
                    case START:
                        auC();
                        if (cOP != null) {
                            cOP.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (cOP != null) {
                            cOP.a(searchFlowEvent);
                        }
                        XU();
                        break;
                    case NORMAL:
                        if (cOP != null) {
                            cOP.a(searchFlowEvent);
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
                e(bVar.ajl(), bVar.ajg());
                if (cOP != null) {
                    cOP.setAppId(bVar.getAppId());
                    cOP.setSource(bVar.ajg());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                e(eVar.ajm(), eVar.ajg());
                if (cOP != null) {
                    cOP.setAppId(eVar.getAppId());
                    cOP.setSource(eVar.ajg());
                }
            }
        }
    }

    private static void auC() {
        if (cOP != null) {
            cOP.destroy();
            cOP = null;
        }
        cOP = new a("772");
    }

    private static void XU() {
        if (cOP != null) {
            cOP.send();
        }
    }

    private static void e(Bundle bundle, String str) {
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
            if (cOP != null) {
                cOP.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                cOP.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
