package com.baidu.searchbox.retrieve.upload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.wja;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ContentUtils {
    public static final boolean DEBUG = AppConfig.isDebug();

    public static JSONObject createActiveReqContent(@NonNull ActiveUpObj activeUpObj) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", activeUpObj.getType());
                jSONObject2.put(UploadConstant.DATA_ID, activeUpObj.getDataId());
                jSONObject2.put("space", activeUpObj.getSpace().toString());
                jSONObject2.put(UploadConstant.FILEMETA, activeUpObj.getFileMeta());
                jSONObject2.put("fileid", activeUpObj.getFileID());
                jSONObject2.put("timestamp", String.valueOf(System.currentTimeMillis() / TimeUnit.SECONDS.toMillis(1L)));
                jSONObject2.put(UploadConstant.FILE_TYPE, activeUpObj.getFileType());
                jSONObject2.put("sign", createSign(jSONObject2, "acupload"));
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                if (DEBUG) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    public static JSONObject createFetchReqContent(@NonNull FetchTaskObj fetchTaskObj) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e = e;
        }
        try {
            jSONObject.put("type", fetchTaskObj.getType());
            jSONObject.put("value", fetchTaskObj.getValue());
            jSONObject.put("jobid", fetchTaskObj.getJobID());
            jSONObject.put("version", fetchTaskObj.getVersion());
            if (!TextUtils.isEmpty(fetchTaskObj.getStatus())) {
                jSONObject.put("status", fetchTaskObj.getStatus());
            }
            if (!TextUtils.isEmpty(fetchTaskObj.getOrigin())) {
                jSONObject.put("origin", fetchTaskObj.getOrigin());
            }
            if (!TextUtils.isEmpty(fetchTaskObj.getFileMeta())) {
                jSONObject.put(UploadConstant.FILEMETA, fetchTaskObj.getFileMeta());
            }
            if (!TextUtils.isEmpty(fetchTaskObj.getFileID())) {
                jSONObject.put("fileid", fetchTaskObj.getFileID());
            }
            jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis() / TimeUnit.SECONDS.toMillis(1L)));
            jSONObject.put("sign", createSign(jSONObject, "fetchlog"));
            return jSONObject;
        } catch (JSONException e2) {
            e = e2;
            jSONObject2 = jSONObject;
            if (DEBUG) {
                e.printStackTrace();
            }
            return jSONObject2;
        }
    }

    public static FetchResult createResult(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new FetchResult(jSONObject.optString("jobid"), jSONObject.optString("valid"));
    }

    public static String createSign(JSONObject jSONObject, String str) {
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
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: com.baidu.searchbox.retrieve.upload.ContentUtils.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                    return entry.getKey().compareTo(entry2.getKey());
                }
            });
            for (Map.Entry entry : arrayList) {
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append((String) entry.getValue());
            }
            stringBuffer.append(str);
            return wja.c(stringBuffer.toString().getBytes(), false);
        }
        return "";
    }
}
