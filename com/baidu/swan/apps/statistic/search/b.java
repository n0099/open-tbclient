package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.b.e;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes11.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a cLu;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.cLt) {
                    case START:
                        asB();
                        if (cLu != null) {
                            cLu.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (cLu != null) {
                            cLu.a(searchFlowEvent);
                        }
                        Xo();
                        break;
                    case NORMAL:
                        if (cLu != null) {
                            cLu.a(searchFlowEvent);
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

    public static synchronized void q(com.baidu.swan.apps.v.b.b bVar) {
        synchronized (b.class) {
            if (bVar != null) {
                e(bVar.ahV(), bVar.ahQ());
                if (cLu != null) {
                    cLu.setAppId(bVar.getAppId());
                    cLu.setSource(bVar.ahQ());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                e(eVar.ahW(), eVar.ahQ());
                if (cLu != null) {
                    cLu.setAppId(eVar.getAppId());
                    cLu.setSource(eVar.ahQ());
                }
            }
        }
    }

    private static void asB() {
        if (cLu != null) {
            cLu.destroy();
            cLu = null;
        }
        cLu = new a("772");
    }

    private static void Xo() {
        if (cLu != null) {
            cLu.send();
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
            if (cLu != null) {
                cLu.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                cLu.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
