package com.baidu.live.feed.search.model.data;

import android.text.TextUtils;
import com.baidu.live.business.model.data.LiveRoomEntity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveSearchHotRankData {
    public static List<LiveRoomEntity> parse(String str) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(str).optJSONObject("data");
            if (optJSONObject2 != null && optJSONObject2.optInt("switch") == 1 && (optJSONObject = optJSONObject2.optJSONObject("hot_rank")) != null && (optJSONArray = optJSONObject.optJSONArray("merge")) != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    LiveRoomEntity liveRoomEntity = new LiveRoomEntity();
                    liveRoomEntity.parserJson(optJSONArray.optJSONObject(i));
                    arrayList.add(liveRoomEntity);
                }
                return arrayList;
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
