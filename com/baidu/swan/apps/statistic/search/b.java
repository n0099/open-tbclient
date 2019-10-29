package com.baidu.swan.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.b.c;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static a bpR;

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (DEBUG) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
            } else {
                switch (searchFlowEvent.bpQ) {
                    case START:
                        SH();
                        if (bpR != null) {
                            bpR.a(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (bpR != null) {
                            bpR.a(searchFlowEvent);
                        }
                        SI();
                        break;
                    case NORMAL:
                        if (bpR != null) {
                            bpR.a(searchFlowEvent);
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

    public static synchronized void w(com.baidu.swan.apps.v.b.b bVar) {
        synchronized (b.class) {
            if (bVar != null) {
                c(bVar.KI(), bVar.KE());
                if (bpR != null) {
                    bpR.setAppId(bVar.getAppId());
                    bpR.setSource(bVar.KE());
                }
            }
        }
    }

    public static synchronized void f(c cVar) {
        synchronized (b.class) {
            if (cVar != null) {
                c(cVar.Ks(), cVar.mFrom);
                if (bpR != null) {
                    bpR.setAppId(cVar.mAppId);
                    bpR.setSource(cVar.mFrom);
                }
            }
        }
    }

    private static void SH() {
        if (bpR != null) {
            bpR.destroy();
            bpR = null;
        }
        bpR = new a("772");
    }

    private static void SI() {
        if (bpR != null) {
            bpR.send();
        }
    }

    private static void c(Bundle bundle, String str) {
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
            if (bpR != null) {
                bpR.addExt("searchid", string == null ? "" : string);
                bpR.addExt("url", bundle.getString("search_url"));
            }
        }
    }
}
