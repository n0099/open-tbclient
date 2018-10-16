package com.baidu.searchbox.ng.ai.apps.event.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.event.JSEventDispatcher;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.LaunchAction;
import java.util.Map;
/* loaded from: classes2.dex */
public class AiAppsLifecycleMessage extends AiAppsCommonMessage {
    public static final String APP_ID_KEY = "appId";
    public static final String CLICK_ID_KEY = "clkid";
    public static final String CUID_KEY = "cuid";
    private static final String EVENT_EXTRA_DATA_KEY = "extraData";
    private static final String EVENT_NAME = "lifecycle";
    public static final String EVENT_TYPE_KEY = "lcType";
    public static final String MTJ_CUID_KEY = "mtjCuid";
    public static final String SCENE_KEY = "scene";
    public static final String TYPE_APP_BACK = "onBack";
    public static final String TYPE_APP_CLOSE = "onClose";
    public static final String TYPE_APP_HIDE = "onAppHide";
    public static final String TYPE_APP_SHOW = "onAppShow";
    public static final String TYPE_HIDE = "onHide";
    public static final String TYPE_ON_UNLOAD = "onUnload";
    public static final String TYPE_SHOW = "onShow";
    public static final String WEBVIEW_ID_KEY = "wvID";
    public String mType;

    public AiAppsLifecycleMessage(@Nullable Map<String, String> map) {
        super(EVENT_NAME, map);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage, com.baidu.searchbox.ng.ai.apps.event.message.AiAppsBaseMessage
    public String genSetDataStatement(String str) {
        Bundle bundle;
        StringBuilder sb = new StringBuilder();
        sb.append(JSEventDispatcher.genJSVarKeyValue(str, "cuid", AiAppsRuntime.getAiAppAccountRuntime().getCuid(AppRuntime.getAppContext())));
        sb.append(JSEventDispatcher.genJSVarKeyValue(str, MTJ_CUID_KEY, AiAppsRuntime.getAiAppAccountRuntime().getCuid(AppRuntime.getAppContext())));
        for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
            sb.append(JSEventDispatcher.genJSVarKeyValue(str, entry.getKey(), entry.getValue()));
        }
        if (TextUtils.equals(this.mType, TYPE_APP_SHOW) && AiApp.get() != null && (bundle = AiApp.get().getLaunchInfo().mExtraData) != null && TextUtils.equals(bundle.getString(LaunchAction.PARAM_NAVI_KEY), LaunchAction.AI_APPS_NAVI_BACK)) {
            String string = bundle.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                sb.append(JSEventDispatcher.genJSVarKeyValue(str, "extraData", string));
            }
        }
        return sb.toString();
    }
}
