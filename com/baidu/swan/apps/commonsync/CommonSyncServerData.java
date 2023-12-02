package com.baidu.swan.apps.commonsync;

import androidx.annotation.Nullable;
import com.baidu.searchbox.NoProGuard;
import com.baidu.tieba.k32;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommonSyncServerData implements Serializable, NoProGuard {
    public int count = 0;
    public List<MetaItemInfo> metaItems;

    /* loaded from: classes4.dex */
    public static class MetaItemInfo implements NoProGuard {
        public String appKey;
        public String appName;
        public long createTime;
        public String icon;
        public int payProtected;
        public String scheme;
        public int subCategory;
    }

    @Nullable
    public static CommonSyncServerData parseFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CommonSyncServerData commonSyncServerData = new CommonSyncServerData();
        commonSyncServerData.count = jSONObject.optInt("count", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("rows");
        if (optJSONArray == null) {
            return null;
        }
        int length = optJSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                MetaItemInfo metaItemInfo = new MetaItemInfo();
                try {
                    metaItemInfo.createTime = optJSONObject.getLong("CreateTime");
                    metaItemInfo.scheme = optJSONObject.getString("Scheme");
                    metaItemInfo.icon = optJSONObject.getString("Icon");
                    metaItemInfo.appName = optJSONObject.getString("AppName");
                    metaItemInfo.subCategory = optJSONObject.getInt("SubCategory");
                    metaItemInfo.appKey = optJSONObject.getString("AppKey");
                    metaItemInfo.payProtected = optJSONObject.getInt("PayProtected");
                } catch (JSONException e) {
                    k32.l("CommonSyncServerData", "parse item failed:" + optJSONObject.toString(), e);
                    metaItemInfo = null;
                }
                if (metaItemInfo != null) {
                    arrayList.add(metaItemInfo);
                }
            }
        }
        commonSyncServerData.metaItems = arrayList;
        return commonSyncServerData;
    }
}
