package com.baidu.searchbox.ng.ai.apps.network;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.facebook.common.internal.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaseRequestAction extends AiAppAction {
    public static final String CANCEL_TAG = "cancelTag";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final int FULL_PROGRESS = 100;
    public static final String HEADER_REFERER = "Referer";
    private static final String HTTP_REFERER_DEF = "https://smartapp.baidu.com/%s/%s/page-frame.html";
    public static final long INIT_TIME = 0;
    public static final String MESSAGE_ILLEGAL_AIAPP = "aiApp is null";
    public static final String MESSAGE_ILLEGAL_APPID = "illegal appId";
    public static final String MESSAGE_ILLEGAL_PARAMS = "illegal params";
    public static final String MESSAGE_ILLEGAL_REQUEST = "illegal request";
    public static final String MESSAGE_ILLEGAL_RESULTCALLBACK = "illegal resultCallback";
    public static final String PARAMS_CALLBACK_PROGRESS = "onProgressUpdate";
    public static final String PARAMS_CALLBACK_RESULT = "cb";
    public static final String PARAMS_PROGRESS = "progress";
    public static final String PARAMS_STATUSCODE = "statusCode";
    public static final String PARAMS_TOTALBYTESEXPECTEDTOSEND = "totalBytesExpectedToSend";
    public static final String PARAMS_TOTALBYTESEXPECTEDTOWRITE = "totalBytesExpectedToWrite";
    public static final String PARAMS_TOTALBYTESSENT = "totalBytesSent";
    public static final String PARAMS_TOTALBYTESWRITTEN = "totalBytesWritten";
    public static final long SIZE_10MB = 10485760;
    public static final long SIZE_25MB = 26214400;
    public static final String SPLITE = "_";
    public static final String TEMP_FILE_PATH = "tempFilePath";
    protected ConcurrentHashMap<String, Long> mHashMap;
    protected static final Set<String> ILLEGAL_HOSTS = h.J(NetworkDef.LOCALHOST, NetworkDef.IP_LOOPBACK);
    public static final Set<String> ILLEGAL_HEADERS = h.J("REFERER", "USER-AGENT");

    public BaseRequestAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher, String str) {
        super(unitedSchemeAiAppDispatcher, str);
        this.mHashMap = new ConcurrentHashMap<>();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    public final long getCurrentTimeFromMap(String str) {
        long j;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            j = this.mHashMap.get(str).longValue();
        } catch (Exception e) {
            j = 0;
        }
        return j;
    }

    public final void releaseMap(String str) {
        if (this.mHashMap != null && !TextUtils.isEmpty(str)) {
            this.mHashMap.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static HttpUrl parseUrl(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if ((AiApp.get() == null ? null : AiApp.get().getActivity()) == null) {
            if (checkUrl(parse)) {
                return parse;
            }
            return null;
        } else if (checkUrl(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    protected static boolean checkUrl(@Nullable HttpUrl httpUrl) {
        return (httpUrl == null || HttpUrl.defaultPort(httpUrl.scheme()) != httpUrl.port() || ILLEGAL_HOSTS.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    protected static HashMap<String, String> formHeaders(@Nullable JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() < 1) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && !ILLEGAL_HEADERS.contains(next.toUpperCase())) {
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(optString)) {
                    hashMap.put(next, optString);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static HashMap<String, String> formHeaders(@Nullable JSONObject jSONObject, boolean z) {
        HashMap<String, String> formHeaders = formHeaders(jSONObject);
        if (z) {
            if (formHeaders == null) {
                formHeaders = new HashMap<>();
            }
            formHeaders.put(HEADER_REFERER, getFixedHttpReferer());
        }
        return formHeaders;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String buildRequestCancelTag(String str) {
        return str + SPLITE + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject getCancelTag(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("cancelTag", str);
            }
        } catch (JSONException e) {
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    public static String getFixedHttpReferer() {
        AiApp aiApp = AiApp.get();
        return aiApp != null ? String.format(HTTP_REFERER_DEF, aiApp.getAppKey(), aiApp.getHttpRefererVersion()) : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static JSONObject toJo(Headers headers) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (headers == null) {
            return jSONObject;
        }
        for (String str : headers.names()) {
            if (!TextUtils.isEmpty(str)) {
                List<String> values = headers.values(str);
                StringBuilder sb = new StringBuilder();
                int size = values.size();
                for (int i = 0; i < size; i++) {
                    sb.append(values.get(i));
                    if (i == size - 1) {
                        break;
                    }
                    sb.append(",");
                }
                jSONObject.put(str, sb.toString());
            }
        }
        return jSONObject;
    }
}
