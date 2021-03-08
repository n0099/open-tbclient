package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.u.c.e;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes8.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a dNm;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.dNl) {
                    case START:
                        aLQ();
                        if (dNm != null) {
                            dNm.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (dNm != null) {
                            dNm.a(searchFlowEvent);
                        }
                        amj();
                        break;
                    case NORMAL:
                        if (dNm != null) {
                            dNm.a(searchFlowEvent);
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
                f(bVar.azi(), bVar.azd());
                if (dNm != null) {
                    dNm.setAppId(bVar.getAppId());
                    dNm.setSource(bVar.azd());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                f(eVar.azj(), eVar.azd());
                if (dNm != null) {
                    dNm.setAppId(eVar.getAppId());
                    dNm.setSource(eVar.azd());
                }
            }
        }
    }

    private static void aLQ() {
        if (dNm != null) {
            dNm.destroy();
            dNm = null;
        }
        dNm = new a("772");
    }

    private static void amj() {
        if (dNm != null) {
            dNm.send();
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
            if (dNm != null) {
                dNm.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                dNm.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
