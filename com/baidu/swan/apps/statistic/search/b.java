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
    public static a bVC;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.bVB) {
                    case START:
                        afe();
                        if (bVC != null) {
                            bVC.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (bVC != null) {
                            bVC.a(searchFlowEvent);
                        }
                        LL();
                        break;
                    case NORMAL:
                        if (bVC != null) {
                            bVC.a(searchFlowEvent);
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
                if (bVC != null) {
                    bVC.setAppId(bVar.getAppId());
                    bVC.setSource(bVar.VJ());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                d(eVar.VP(), eVar.VJ());
                if (bVC != null) {
                    bVC.setAppId(eVar.getAppId());
                    bVC.setSource(eVar.VJ());
                }
            }
        }
    }

    private static void afe() {
        if (bVC != null) {
            bVC.destroy();
            bVC = null;
        }
        bVC = new a("772");
    }

    private static void LL() {
        if (bVC != null) {
            bVC.send();
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
            if (bVC != null) {
                bVC.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                bVC.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
