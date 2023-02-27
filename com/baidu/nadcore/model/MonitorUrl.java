package com.baidu.nadcore.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class MonitorUrl implements Serializable {
    public final String clickUrl;
    public final String showUrl;

    public MonitorUrl(String str, String str2) {
        this.showUrl = str;
        this.clickUrl = str2;
    }

    @NonNull
    public static List<MonitorUrl> fromJson(@Nullable JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new MonitorUrl(optJSONObject.optString("show_url"), optJSONObject.optString("show_url")));
            }
        }
        return arrayList;
    }
}
