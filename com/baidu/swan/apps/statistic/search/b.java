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
    public static a cGK;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.cGJ) {
                    case START:
                        aru();
                        if (cGK != null) {
                            cGK.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (cGK != null) {
                            cGK.a(searchFlowEvent);
                        }
                        Wi();
                        break;
                    case NORMAL:
                        if (cGK != null) {
                            cGK.a(searchFlowEvent);
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
                e(bVar.agP(), bVar.agK());
                if (cGK != null) {
                    cGK.setAppId(bVar.getAppId());
                    cGK.setSource(bVar.agK());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                e(eVar.agQ(), eVar.agK());
                if (cGK != null) {
                    cGK.setAppId(eVar.getAppId());
                    cGK.setSource(eVar.agK());
                }
            }
        }
    }

    private static void aru() {
        if (cGK != null) {
            cGK.destroy();
            cGK = null;
        }
        cGK = new a("772");
    }

    private static void Wi() {
        if (cGK != null) {
            cGK.send();
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
            if (cGK != null) {
                cGK.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                cGK.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
