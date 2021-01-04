package com.baidu.searchbox.aperf.bosuploader;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.security.MD5Util;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ContentUtil {
    private static final String KEY_LOCAL_EXPIRED_AT = "localExpireAt";
    private static final String REQ_KEY_REQ = "req";
    private static final String REQ_KEY_SIGN = "sign";
    private static final String REQ_KEY_TIMESTAMP = "timestamp";
    private static final String REQ_KEY_TYPE = "type";
    private static final String RESULT_KEY_AK = "ak";
    private static final String RESULT_KEY_BUCKET = "bucket";
    private static final String RESULT_KEY_ENDPOINT = "endpoint";
    private static final String RESULT_KEY_EXPIRE = "expire";
    private static final String RESULT_KEY_EXPIRED_AT = "expireAt";
    private static final String RESULT_KEY_SK = "sk";
    private static final String RESULT_KEY_TOKEN = "token";
    private static final String TAG_DATA = "data";
    private static final String TAG_ERRNO = "errno";
    private static final String TAG_ERRNO_INVALID = "-1";
    private static final String TAG_ERRNO_NO_ERROR = "0";
    private static final String TOKEN = "gettoken";

    public static String createRequest(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            jSONObject2.put("type", str);
            jSONObject2.put("timestamp", valueOf);
            jSONObject2.put("sign", createSign(jSONObject2));
            jSONObject.put(REQ_KEY_REQ, jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static STSInfo createSTSFromResponse(String str) {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!"0".equals(jSONObject.optString("errno", "-1")) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return null;
            }
            optJSONObject.put(KEY_LOCAL_EXPIRED_AT, (optJSONObject.optLong(RESULT_KEY_EXPIRE) * 1000) + System.currentTimeMillis());
            return createSTSInfo(optJSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static STSInfo createSTSInfo(String str) {
        try {
            return createSTSInfo(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static STSInfo createSTSInfo(@NonNull JSONObject jSONObject) {
        STSInfo sTSInfo = new STSInfo(jSONObject.optString(RESULT_KEY_AK), jSONObject.optString(RESULT_KEY_SK), jSONObject.optString("token"), jSONObject.optLong(KEY_LOCAL_EXPIRED_AT), jSONObject.optString(RESULT_KEY_EXPIRE), jSONObject.optString(RESULT_KEY_BUCKET), jSONObject.optString(RESULT_KEY_ENDPOINT));
        sTSInfo.setOrigin(jSONObject.toString());
        return sTSInfo;
    }

    public static boolean checkStsValid(STSInfo sTSInfo) {
        if (sTSInfo != null && !TextUtils.isEmpty(sTSInfo.ak) && !TextUtils.isEmpty(sTSInfo.sk) && !TextUtils.isEmpty(sTSInfo.token) && !TextUtils.isEmpty(sTSInfo.expired) && !TextUtils.isEmpty(sTSInfo.bucket) && !TextUtils.isEmpty(sTSInfo.endpoint)) {
            try {
                if (sTSInfo.expiredAt >= System.currentTimeMillis()) {
                    return true;
                }
            } catch (NumberFormatException e) {
            }
        }
        return false;
    }

    private static String createSign(JSONObject jSONObject) {
        if (jSONObject != null) {
            StringBuffer stringBuffer = new StringBuffer();
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    String string = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(string)) {
                        hashMap.put(next, string);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: com.baidu.searchbox.aperf.bosuploader.ContentUtil.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                    return entry.getKey().compareTo(entry2.getKey());
                }
            });
            for (Map.Entry entry : arrayList) {
                stringBuffer.append((String) entry.getKey()).append("=").append((String) entry.getValue());
            }
            stringBuffer.append(TOKEN);
            try {
                return MD5Util.toMd5(stringBuffer.toString().getBytes("UTF-8"), false);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }
}
