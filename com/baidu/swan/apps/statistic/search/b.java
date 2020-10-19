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
    public static a dmd;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.dmc) {
                    case START:
                        aGe();
                        if (dmd != null) {
                            dmd.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (dmd != null) {
                            dmd.a(searchFlowEvent);
                        }
                        ahv();
                        break;
                    case NORMAL:
                        if (dmd != null) {
                            dmd.a(searchFlowEvent);
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
                f(bVar.auo(), bVar.auj());
                if (dmd != null) {
                    dmd.setAppId(bVar.getAppId());
                    dmd.setSource(bVar.auj());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                f(eVar.aup(), eVar.auj());
                if (dmd != null) {
                    dmd.setAppId(eVar.getAppId());
                    dmd.setSource(eVar.auj());
                }
            }
        }
    }

    private static void aGe() {
        if (dmd != null) {
            dmd.destroy();
            dmd = null;
        }
        dmd = new a("772");
    }

    private static void ahv() {
        if (dmd != null) {
            dmd.send();
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
            if (dmd != null) {
                dmd.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                dmd.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
