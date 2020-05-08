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
    public static a cuL;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.cuK) {
                    case START:
                        anl();
                        if (cuL != null) {
                            cuL.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (cuL != null) {
                            cuL.a(searchFlowEvent);
                        }
                        TB();
                        break;
                    case NORMAL:
                        if (cuL != null) {
                            cuL.a(searchFlowEvent);
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
                d(bVar.adF(), bVar.adA());
                if (cuL != null) {
                    cuL.setAppId(bVar.getAppId());
                    cuL.setSource(bVar.adA());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                d(eVar.adG(), eVar.adA());
                if (cuL != null) {
                    cuL.setAppId(eVar.getAppId());
                    cuL.setSource(eVar.adA());
                }
            }
        }
    }

    private static void anl() {
        if (cuL != null) {
            cuL.destroy();
            cuL = null;
        }
        cuL = new a("772");
    }

    private static void TB() {
        if (cuL != null) {
            cuL.send();
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
            if (cuL != null) {
                cuL.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                cuL.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
