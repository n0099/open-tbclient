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
    public static a duF;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.duE) {
                    case START:
                        aHY();
                        if (duF != null) {
                            duF.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (duF != null) {
                            duF.a(searchFlowEvent);
                        }
                        ajp();
                        break;
                    case NORMAL:
                        if (duF != null) {
                            duF.a(searchFlowEvent);
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
                f(bVar.awi(), bVar.awd());
                if (duF != null) {
                    duF.setAppId(bVar.getAppId());
                    duF.setSource(bVar.awd());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                f(eVar.awj(), eVar.awd());
                if (duF != null) {
                    duF.setAppId(eVar.getAppId());
                    duF.setSource(eVar.awd());
                }
            }
        }
    }

    private static void aHY() {
        if (duF != null) {
            duF.destroy();
            duF = null;
        }
        duF = new a("772");
    }

    private static void ajp() {
        if (duF != null) {
            duF.send();
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
            if (duF != null) {
                duF.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                duF.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
