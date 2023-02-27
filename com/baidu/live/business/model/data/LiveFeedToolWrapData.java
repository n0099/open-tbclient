package com.baidu.live.business.model.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFeedToolWrapData {
    public List<LiveFeedToolInfo> infos;

    public static LiveFeedToolWrapData parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LiveFeedToolWrapData liveFeedToolWrapData = new LiveFeedToolWrapData();
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            liveFeedToolWrapData.infos = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                LiveFeedToolInfo parse = LiveFeedToolInfo.parse(optJSONArray.optJSONObject(i));
                if (parse != null && parse.isValid()) {
                    liveFeedToolWrapData.infos.add(parse);
                }
            }
        }
        return liveFeedToolWrapData;
    }
}
