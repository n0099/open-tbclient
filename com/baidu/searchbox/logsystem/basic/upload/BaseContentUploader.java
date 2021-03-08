package com.baidu.searchbox.logsystem.basic.upload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.identity.LokiIdentityManager;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class BaseContentUploader {
    private static final String CONTENT_TYPE = "Content-type";
    private static final String CONTENT_TYPE_VALUE = "application/octet-stream";
    private static final String DEBUG_PARA = "debug";
    private static final String NB = "nb";
    private static final String NB_VALUE = "1";
    private static final String OFFLINE_UPLOAD_URL_PATH = "/ztbox?action=crash";
    private static final String OFFLINE_URL = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080";
    public static final String ONLINE_UPLOAD_URL_PATH = "/ztbox?action=crash";
    public static final String ONLINE_URL = "https://tcbox.baidu.com";
    protected static final String TAG_ERRNO = "error";
    protected static final int TAG_ERRNO_INVALID = -1;
    protected static final int TAG_ERRNO_NO_ERROR = 0;

    protected abstract ResponseEntity uploadDataRequestSync(@NonNull String str, @NonNull File file, @Nullable Map<String, String> map);

    private String getUploadUrl() {
        String str;
        if (AppConfig.isDebug()) {
            str = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=crash";
        } else {
            str = "https://tcbox.baidu.com/ztbox?action=crash";
        }
        String processUrl = LokiIdentityManager.getInstance().processUrl(str);
        if (AppConfig.isDebug() && !TextUtils.isEmpty(processUrl)) {
            return UrlUtil.addParam(processUrl, "debug", "1");
        }
        return processUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ResponseEntity uploadSync(@NonNull File file) {
        String uploadUrl = getUploadUrl();
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put(CONTENT_TYPE, "application/octet-stream");
        linkedHashMap.put(NB, "1");
        return uploadDataRequestSync(uploadUrl, file, linkedHashMap);
    }
}
