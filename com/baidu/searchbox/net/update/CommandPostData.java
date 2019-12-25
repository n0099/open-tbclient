package com.baidu.searchbox.net.update;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class CommandPostData {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "CommandPostData";
    private JSONObject data;
    private JSONObject pubData;
    private JSONObject version;

    public CommandPostData(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (DEBUG && (jSONObject == null || jSONObject2 == null)) {
            throw new RuntimeException("version and data can not be null, it is impossible");
        }
        this.version = jSONObject == null ? new JSONObject() : jSONObject;
        this.data = jSONObject2 == null ? new JSONObject() : jSONObject2;
        this.pubData = jSONObject3;
    }

    public JSONObject getVersion() {
        return this.version;
    }

    public JSONObject getData() {
        return this.data;
    }

    public JSONObject getPubData() {
        return this.pubData;
    }

    CommandPostData getSubPostData(String str) throws JSONException {
        SubPostDataKey subPostDataKey = getSubPostDataKey(str);
        JSONObject jSONObject = this.version;
        JSONObject jSONObject2 = this.data;
        JSONObject optJSONObject = jSONObject.optJSONObject(subPostDataKey.versionKey);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            jSONObject.put(subPostDataKey.versionKey, optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject2.optJSONObject(subPostDataKey.dataKey);
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
            jSONObject2.put(subPostDataKey.dataKey, optJSONObject2);
        }
        return new CommandPostData(optJSONObject, optJSONObject2, this.pubData);
    }

    void removeEmptySubPostData(String str, CommandPostData commandPostData) throws JSONException {
        SubPostDataKey subPostDataKey = getSubPostDataKey(str);
        JSONObject jSONObject = this.version;
        JSONObject jSONObject2 = this.data;
        JSONObject version = commandPostData.getVersion();
        JSONObject data = commandPostData.getData();
        if (version.length() <= 0) {
            jSONObject.put(subPostDataKey.versionKey, (Object) null);
        }
        if (data.length() <= 0) {
            jSONObject2.put(subPostDataKey.dataKey, (Object) null);
        }
    }

    public void cleanEmptyData() {
        cleanEmptyData(this.version);
        cleanEmptyData(this.data);
    }

    private void cleanEmptyData(JSONObject jSONObject) {
        LinkedList<String> linkedList = new LinkedList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null && optJSONObject.length() == 0) {
                linkedList.add(next);
            }
        }
        for (String str : linkedList) {
            jSONObject.remove(str);
        }
    }

    private SubPostDataKey getSubPostDataKey(String str) {
        SubPostDataKey subPostDataKey = new SubPostDataKey();
        subPostDataKey.versionKey = getKey(str, null, "_v");
        subPostDataKey.dataKey = getKey(str, null, null);
        return subPostDataKey;
    }

    private static String getKey(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str2 + str + str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static final class SubPostDataKey {
        String dataKey;
        String versionKey;

        private SubPostDataKey() {
        }
    }
}
