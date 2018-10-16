package com.baidu.searchbox.ng.ai.apps.core.aps.preload;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.b.a.b;
import com.baidu.b.a.e.a;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AiAppsPreDownload {
    private static final String KEY_APP_ID = "appid";
    private static final String KEY_EXT = "ext";
    private static final String KEY_FROM = "from";

    /* loaded from: classes2.dex */
    public interface DownloadCallback {
        public static final int DOWNLOAD_ERROR = 0;
        public static final int DOWNLOAD_INFO_GET_FAILED = 3;
        public static final int ON_CONFIGURATION_CHANGED = 1;
        public static final int ON_ITEM_FILTERED = 2;
        public static final int UNZIP_FAILED = 4;

        void aiAppIdInvalid();

        void preDownloadFailed(int i);

        void preDownloadSuccess();
    }

    public static void preDownloadAiAppByJsonString(String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject parseString = AiAppJSONUtils.parseString(str);
            String optString = parseString.optString("appid");
            if (!TextUtils.isEmpty(optString)) {
                preDownloadAiAppById(optString);
                preDownloadUBCStatistics(parseString.optString("from"), parseString.optString("ext"));
            }
        }
    }

    public static void preDownloadAiAppById(String str) {
        preDownloadAiApp(str, null);
    }

    public static void preDownloadAiApp(String str, DownloadCallback downloadCallback) {
        if (TextUtils.isEmpty(str) && downloadCallback != null) {
            downloadCallback.aiAppIdInvalid();
            return;
        }
        Context appContext = AppRuntime.getAppContext();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AiAppsPreDownloadAPSCallback(appContext, str, downloadCallback));
        b.init(appContext, ProcessUtils.isMainProcess());
        a.a(appContext, AiAppsRuntime.getConfigRuntime().getCookieManager(false, false));
        a.c(arrayList, true);
    }

    private static void preDownloadUBCStatistics(String str, String str2) {
    }
}
