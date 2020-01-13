package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.x.b.e;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes10.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a bRv;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.bRu) {
                    case START:
                        acO();
                        if (bRv != null) {
                            bRv.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (bRv != null) {
                            bRv.a(searchFlowEvent);
                        }
                        Ju();
                        break;
                    case NORMAL:
                        if (bRv != null) {
                            bRv.a(searchFlowEvent);
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
                d(bVar.Ty(), bVar.Tt());
                if (bRv != null) {
                    bRv.setAppId(bVar.getAppId());
                    bRv.setSource(bVar.Tt());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                d(eVar.Tz(), eVar.Tt());
                if (bRv != null) {
                    bRv.setAppId(eVar.getAppId());
                    bRv.setSource(eVar.Tt());
                }
            }
        }
    }

    private static void acO() {
        if (bRv != null) {
            bRv.destroy();
            bRv = null;
        }
        bRv = new a("772");
    }

    private static void Ju() {
        if (bRv != null) {
            bRv.send();
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
            if (bRv != null) {
                bRv.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                bRv.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
