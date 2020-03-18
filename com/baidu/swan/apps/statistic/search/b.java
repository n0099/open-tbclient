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
    public static a bVN;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.bVM) {
                    case START:
                        afh();
                        if (bVN != null) {
                            bVN.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (bVN != null) {
                            bVN.a(searchFlowEvent);
                        }
                        LO();
                        break;
                    case NORMAL:
                        if (bVN != null) {
                            bVN.a(searchFlowEvent);
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
                d(bVar.VR(), bVar.VM());
                if (bVN != null) {
                    bVN.setAppId(bVar.getAppId());
                    bVN.setSource(bVar.VM());
                }
            }
        }
    }

    public static synchronized void e(e eVar) {
        synchronized (b.class) {
            if (eVar != null) {
                d(eVar.VS(), eVar.VM());
                if (bVN != null) {
                    bVN.setAppId(eVar.getAppId());
                    bVN.setSource(eVar.VM());
                }
            }
        }
    }

    private static void afh() {
        if (bVN != null) {
            bVN.destroy();
            bVN = null;
        }
        bVN = new a("772");
    }

    private static void LO() {
        if (bVN != null) {
            bVN.send();
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
            if (bVN != null) {
                bVN.addExt(ETAG.KEY_SEARCH_ID, string == null ? "" : string);
                bVN.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
