package com.baidu.searchbox.v8engine.bean;

import com.baidu.searchbox.v8engine.NotProguard;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@NotProguard
/* loaded from: classes6.dex */
public class PerformanceJsonBean {
    public static final String KEY_GAP = "gap";
    public static final String KEY_ID = "id";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String TAG = "PerformanceJsonBean";
    private List<PerformanceJsonObject> mPerformanceJsonObjectList = new ArrayList();

    public List<PerformanceJsonObject> getPerformanceJsonObjectList() {
        return this.mPerformanceJsonObjectList == null ? new ArrayList() : this.mPerformanceJsonObjectList;
    }

    /* loaded from: classes6.dex */
    public static class PerformanceJsonObject {
        public String name;
        public long time;

        public PerformanceJsonObject(String str, long j) {
            this.name = str;
            this.time = j;
        }
    }

    public void put(String str) {
        put(str, System.currentTimeMillis());
    }

    public void put(String str, long j) {
        this.mPerformanceJsonObjectList.add(new PerformanceJsonObject(str, j));
    }

    public void put(PerformanceJsonBean performanceJsonBean) {
        this.mPerformanceJsonObjectList.addAll(performanceJsonBean.getPerformanceJsonObjectList());
    }

    public PerformanceJsonObject get(String str) {
        for (PerformanceJsonObject performanceJsonObject : this.mPerformanceJsonObjectList) {
            if (performanceJsonObject.name.equals(str)) {
                return performanceJsonObject;
            }
        }
        return null;
    }

    public String toString() {
        return toJSONArray().toString();
    }

    public void clear() {
        this.mPerformanceJsonObjectList.clear();
    }

    private long checkNull(Long l) {
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public JSONArray toJSONArray() {
        JSONArray jSONArray = new JSONArray();
        try {
            for (PerformanceJsonObject performanceJsonObject : this.mPerformanceJsonObjectList) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", performanceJsonObject.name);
                jSONObject.put("timestamp", performanceJsonObject.time);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        clear();
        return jSONArray;
    }
}
