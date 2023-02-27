package com.baidu.searchbox.crius.parser;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SyncInfo {
    public String action;
    public ArrayList<Filter> filters;
    public String valueCriusMap;
    public String valuePath;

    /* loaded from: classes2.dex */
    public static class Filter {
        public String filterPath;
        public String filterValue;

        public int hashCode() {
            return Objects.hash(this.filterPath, this.filterValue);
        }

        public boolean isValid() {
            if (!TextUtils.isEmpty(this.filterPath) && !TextUtils.isEmpty(this.filterValue)) {
                return true;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Filter.class != obj.getClass()) {
                return false;
            }
            Filter filter = (Filter) obj;
            if (Objects.equals(this.filterPath, filter.filterPath) && Objects.equals(this.filterValue, filter.filterValue)) {
                return true;
            }
            return false;
        }

        public void parse(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.filterPath = jSONObject.optString("filter_path");
            this.filterValue = jSONObject.optString("filter_value");
        }
    }

    public int hashCode() {
        return Objects.hash(this.action, this.valuePath, this.valueCriusMap, this.filters);
    }

    public boolean isDataValid() {
        if (!TextUtils.isEmpty(this.action) && !TextUtils.isEmpty(this.valuePath)) {
            return true;
        }
        return false;
    }

    @Nullable
    public static SyncInfo parse(@Nullable JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        SyncInfo syncInfo = new SyncInfo();
        syncInfo.action = jSONObject.optString("action");
        syncInfo.valuePath = jSONObject.optString("value_path");
        syncInfo.valueCriusMap = jSONObject.optString("value_crius_map");
        if (jSONObject.has("filters") && (optJSONArray = jSONObject.optJSONArray("filters")) != null && optJSONArray.length() > 0) {
            syncInfo.filters = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                Filter filter = new Filter();
                try {
                    filter.parse((JSONObject) optJSONArray.get(i));
                    syncInfo.filters.add(filter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return syncInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SyncInfo.class != obj.getClass()) {
            return false;
        }
        SyncInfo syncInfo = (SyncInfo) obj;
        if (this.action.equals(syncInfo.action) && this.valuePath.equals(syncInfo.valuePath) && Objects.equals(this.valueCriusMap, syncInfo.valueCriusMap) && Objects.equals(this.filters, syncInfo.filters)) {
            return true;
        }
        return false;
    }
}
