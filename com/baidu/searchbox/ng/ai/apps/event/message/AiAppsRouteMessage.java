package com.baidu.searchbox.ng.ai.apps.event.message;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.event.JSEventDispatcher;
/* loaded from: classes2.dex */
public class AiAppsRouteMessage extends AiAppsBaseMessage {
    private static final String EVENT_NAME = "route";
    private static final String FROM_ID_KEY = "fromId";
    private static final String ROUTE_TYPE_KEY = "routeType";
    private static final String TO_ID_KEY = "toId";
    private static final String TO_PAGE_KEY = "toPage";
    public static final String TYPE_AD_LANDING = "adLanding";
    public static final String TYPE_INIT = "init";
    public static final String TYPE_NAVIGATE_BACK = "navigateBack";
    public static final String TYPE_NAVIGATE_TO = "navigateTo";
    public static final String TYPE_NONE = "";
    public static final String TYPE_RE_DIRECT_TO = "redirectTo";
    public static final String TYPE_RE_LAUNCH = "reLaunch";
    public static final String TYPE_SWITCH_TAB = "switchTab";
    public String mFromId;
    public String mRouteType;
    public String mToId;
    public String mToPage;

    public AiAppsRouteMessage() {
        this.mEventName = "route";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.event.message.AiAppsBaseMessage
    public String genSetDataStatement(String str) {
        String str2 = JSEventDispatcher.genJSVarKeyValue(str, FROM_ID_KEY, this.mFromId) + JSEventDispatcher.genJSVarKeyValue(str, TO_ID_KEY, this.mToId);
        if (!TextUtils.isEmpty(this.mRouteType)) {
            str2 = str2 + JSEventDispatcher.genJSVarKeyValue(str, ROUTE_TYPE_KEY, this.mRouteType);
        }
        if (!TextUtils.isEmpty(this.mToPage)) {
            return str2 + JSEventDispatcher.genJSVarKeyValue(str, TO_PAGE_KEY, this.mToPage);
        }
        return str2;
    }
}
