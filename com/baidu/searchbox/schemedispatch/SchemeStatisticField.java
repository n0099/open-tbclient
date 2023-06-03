package com.baidu.searchbox.schemedispatch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class SchemeStatisticField {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "SchemeStatisticField";
    public Map<String, String> collector = new HashMap();

    public SchemeStatisticField addField(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.collector.put(str, str2);
            return this;
        }
        if (DEBUG) {
            Log.d(TAG, "add field failed  key =" + str + " and value =" + str2 + "can't be empty please check");
        }
        return this;
    }

    public void apply(HashMap hashMap) {
        if (hashMap != null && this.collector.size() >= 1) {
            for (Map.Entry<String, String> entry : this.collector.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public SchemeStatisticField removeFieldByKey(String str) {
        this.collector.remove(str);
        return this;
    }
}
