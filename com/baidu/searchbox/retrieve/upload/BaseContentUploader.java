package com.baidu.searchbox.retrieve.upload;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class BaseContentUploader {
    public static final String ACTIVE_UPLOAD_URL_PATH = "/fetchlog/activeupload";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String DEBUG_PARA = "debug";
    public static final String ONLINE_URL = "https://mbd.baidu.com";
    public static final String TEST_URL = "http://10.26.139.34:8092";
    public static final String UPLOAD_URL_PATH = "/fetchlog/appupstream";

    public abstract void uploadDataRequestASync(String str, String str2, Map<String, String> map, ResponseCallback<JSONObject> responseCallback);

    public String getUploadUrl(String str) {
        String str2;
        String str3;
        if (TextUtils.equals(str, "1")) {
            str2 = ACTIVE_UPLOAD_URL_PATH;
        } else {
            str2 = UPLOAD_URL_PATH;
        }
        boolean isDebug = FetchTaskManager.getInstance().isDebug();
        if (DEBUG && isDebug) {
            str3 = TEST_URL + str2;
        } else {
            str3 = "https://mbd.baidu.com" + str2;
        }
        String appendParam = CommonUrlParamManager.getInstance().appendParam(str3, 1);
        if (DEBUG && !TextUtils.isEmpty(appendParam)) {
            return UrlUtil.addParam(appendParam, "debug", "1");
        }
        return appendParam;
    }
}
