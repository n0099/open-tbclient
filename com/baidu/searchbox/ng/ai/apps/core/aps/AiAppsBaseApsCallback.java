package com.baidu.searchbox.ng.ai.apps.core.aps;

import com.baidu.b.a.b.a.a.a;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class AiAppsBaseApsCallback extends a {
    public static final String MINI_PROGRAM_APS_CHANNEL_ID = "21";
    protected static final String MINI_PROGRAM_APS_CHANNEL_NAME = "swan";
    protected static final String MINI_PROGRAM_APS_PARAM_SWAN_VER = "swan_version";

    public AiAppsBaseApsCallback(String str) {
        super("21", "swan", str);
    }

    @Override // com.baidu.b.a.b.a.a
    public Map<String, String> getUrlParams() {
        return null;
    }

    @Override // com.baidu.b.a.b.a.a
    public Map<String, String> getHeaderParams() {
        return null;
    }

    @Override // com.baidu.b.a.b.a.a
    public Map<String, String> getCommonParams() {
        return null;
    }

    @Override // com.baidu.b.a.b.a.a
    public Map<String, String> getExtParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(MINI_PROGRAM_APS_PARAM_SWAN_VER, AiAppsSwanCoreManager.getSwanCoreVersionString());
        return hashMap;
    }

    @Override // com.baidu.b.a.b.a.a
    public String getDownloadPath() {
        return LaunchAiApps.getAiAppsZipFolder() + File.separator;
    }

    @Override // com.baidu.b.a.b.a.a
    public int getDownloadOptions() {
        return 0;
    }
}
