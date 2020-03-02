package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.x.b.e;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes11.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a bVB;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.bVA) {
                    case START:
                        afe();
                        if (bVB != null) {
                            bVB.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (bVB != null) {
                            bVB.a(searchFlowEvent);
                        }
                        LL();
                        break;
                    case NORMAL:
                        if (bVB != null) {
                            bVB.a(searchFlowEvent);
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
                d(bVar.VO(), bVar.VJ());
                if (bVB != null) {
                    bVB.setAppId(bVar.getAppId());
                    bVB.setSource(bVar.VJ());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                d(eVar.VP(), eVar.VJ());
                if (bVB != null) {
                    bVB.setAppId(eVar.getAppId());
                    bVB.setSource(eVar.VJ());
                }
            }
        }
    }

    private static void afe() {
        if (bVB != null) {
            bVB.destroy();
            bVB = null;
        }
        bVB = new a("772");
    }

    private static void LL() {
        if (bVB != null) {
            bVB.send();
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
            if (bVB != null) {
                bVB.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                bVB.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
