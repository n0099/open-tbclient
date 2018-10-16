package com.baidu.searchbox.ng.ai.apps.model;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUrlUtils;
/* loaded from: classes2.dex */
public final class AiAppsPageParam {
    public String mBaseUrl;
    public String mPage;
    public String mParams;

    public static AiAppsPageParam createObject(String str, String str2) {
        AiAppsPageParam aiAppsPageParam = new AiAppsPageParam();
        aiAppsPageParam.mPage = AiAppsUrlUtils.delAllParamsFromUrl(str);
        aiAppsPageParam.mParams = AiAppsUrlUtils.getParams(str);
        aiAppsPageParam.mBaseUrl = str2;
        return aiAppsPageParam;
    }

    public static String buildPageWithParams(AiAppsPageParam aiAppsPageParam) {
        if (aiAppsPageParam == null) {
            return null;
        }
        if (TextUtils.isEmpty(aiAppsPageParam.mParams)) {
            return aiAppsPageParam.mPage;
        }
        return aiAppsPageParam.mPage + "?" + aiAppsPageParam.mParams;
    }

    public String toString() {
        return "AiAppsPageParam{mPage='" + this.mPage + "', mParams='" + this.mParams + "', mBaseUrl='" + this.mBaseUrl + "'}";
    }
}
