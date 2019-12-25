package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.x.b.e;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes9.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a bQL;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.bQK) {
                    case START:
                        acr();
                        if (bQL != null) {
                            bQL.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (bQL != null) {
                            bQL.a(searchFlowEvent);
                        }
                        IY();
                        break;
                    case NORMAL:
                        if (bQL != null) {
                            bQL.a(searchFlowEvent);
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

    public static synchronized void o(com.baidu.swan.apps.x.b.b bVar) {
        synchronized (b.class) {
            if (bVar != null) {
                d(bVar.Tb(), bVar.SW());
                if (bQL != null) {
                    bQL.setAppId(bVar.getAppId());
                    bQL.setSource(bVar.SW());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                d(eVar.Tc(), eVar.SW());
                if (bQL != null) {
                    bQL.setAppId(eVar.getAppId());
                    bQL.setSource(eVar.SW());
                }
            }
        }
    }

    private static void acr() {
        if (bQL != null) {
            bQL.destroy();
            bQL = null;
        }
        bQL = new a("772");
    }

    private static void IY() {
        if (bQL != null) {
            bQL.send();
        }
    }

    private static void d(Bundle bundle, String str) {
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
            if (bQL != null) {
                bQL.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                bQL.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
