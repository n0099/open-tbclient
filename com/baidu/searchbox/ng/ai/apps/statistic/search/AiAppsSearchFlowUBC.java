package com.baidu.searchbox.ng.ai.apps.statistic.search;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchParams;
import com.baidu.searchbox.ng.ai.apps.statistic.search.SearchFlowEvent;
/* loaded from: classes2.dex */
public final class AiAppsSearchFlowUBC {
    public static final boolean DEBUG = false;
    public static final String EXTRA_SEARCH_DOM_CLICK_TIMESTAMP = "search_dom_click_timestamp";
    public static final String EXTRA_SEARCH_ID = "search_id";
    public static final String EXTRA_SEARCH_URL = "search_url";
    public static final String FE_DATA_ERRTYPE = "errorType";
    public static final String FE_DATA_TIMESTAMP = "timeStamp";
    public static final String ID_SEARCH_FLOW = "772";
    public static final String TAG = "AiAppsSearchFlowUBC";
    public static SearchFlow sSearchFlow;

    private AiAppsSearchFlowUBC() {
    }

    public static synchronized void addEvent(SearchFlowEvent searchFlowEvent) {
        synchronized (AiAppsSearchFlowUBC.class) {
            if (searchFlowEvent != null) {
                switch (searchFlowEvent.eventType) {
                    case START:
                        initFlow();
                        if (sSearchFlow != null) {
                            sSearchFlow.addEvent(searchFlowEvent);
                            break;
                        }
                        break;
                    case END:
                        if (sSearchFlow != null) {
                            sSearchFlow.addEvent(searchFlowEvent);
                        }
                        endFlow();
                        break;
                    case NORMAL:
                        if (sSearchFlow != null) {
                            sSearchFlow.addEvent(searchFlowEvent);
                            break;
                        }
                        break;
                }
            }
        }
    }

    public static synchronized void recordFromLaunch(AiAppsLaunchInfo aiAppsLaunchInfo) {
        synchronized (AiAppsSearchFlowUBC.class) {
            if (aiAppsLaunchInfo != null) {
                handleExtra(aiAppsLaunchInfo.mExtraData);
                if (sSearchFlow != null) {
                    sSearchFlow.setAppId(aiAppsLaunchInfo.mAppId);
                    sSearchFlow.setSource(aiAppsLaunchInfo.mLaunchFrom);
                }
            }
        }
    }

    public static synchronized void recordFromLaunch(AiAppsLaunchParams aiAppsLaunchParams) {
        synchronized (AiAppsSearchFlowUBC.class) {
            if (aiAppsLaunchParams != null) {
                handleExtra(aiAppsLaunchParams.mExtraData);
                if (sSearchFlow != null) {
                    sSearchFlow.setAppId(aiAppsLaunchParams.mAppId);
                    sSearchFlow.setSource(aiAppsLaunchParams.mFrom);
                }
            }
        }
    }

    public static synchronized void addExt(String str, String str2) {
        synchronized (AiAppsSearchFlowUBC.class) {
            if (!TextUtils.isEmpty(str) && sSearchFlow != null) {
                sSearchFlow.addExt(str, str2);
            }
        }
    }

    private static void initFlow() {
        if (sSearchFlow != null) {
            sSearchFlow.destroy();
            sSearchFlow = null;
        }
        sSearchFlow = new SearchFlow(ID_SEARCH_FLOW);
    }

    private static void endFlow() {
        if (sSearchFlow != null) {
            sSearchFlow.send();
            sSearchFlow = null;
        }
    }

    private static void handleExtra(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString(EXTRA_SEARCH_ID);
            if (!TextUtils.isEmpty(string)) {
                addEvent(new SearchFlowEvent(SearchFlowEvent.ID_DOM_CLICK, bundle.getLong(EXTRA_SEARCH_DOM_CLICK_TIMESTAMP), "", "", SearchFlowEvent.EventType.START));
                if (sSearchFlow != null) {
                    sSearchFlow.addExt("searchid", string);
                    sSearchFlow.addExt("url", bundle.getString(EXTRA_SEARCH_URL));
                }
            }
        }
    }
}
