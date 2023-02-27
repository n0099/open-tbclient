package com.baidu.live.feed.search.model.data;

import androidx.annotation.NonNull;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveSearchSuggestionsBean {
    public boolean hasmore = false;
    public LiveErrorInfo liveErrorInfo;
    public List<LiveSearchResultInfo> mSearchResultList;
    public String question;
    public List<LiveSearchSuggestion> suggestionList;

    public void parse(@NonNull JSONObject jSONObject) {
        LiveErrorInfo liveErrorInfo = new LiveErrorInfo();
        this.liveErrorInfo = liveErrorInfo;
        liveErrorInfo.loadFromJSON(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.question = optJSONObject.optString("q");
            JSONArray optJSONArray = optJSONObject.optJSONArray("g");
            if (optJSONArray != null) {
                this.suggestionList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        LiveSearchSuggestion liveSearchSuggestion = new LiveSearchSuggestion();
                        liveSearchSuggestion.parseJSONObj(optJSONObject2);
                        this.suggestionList.add(liveSearchSuggestion);
                    }
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("online_user");
            if (optJSONArray2 != null) {
                this.mSearchResultList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject3 != null) {
                        LiveSearchResultInfo liveSearchResultInfo = new LiveSearchResultInfo();
                        liveSearchResultInfo.parseJSONObj(optJSONObject3);
                        this.mSearchResultList.add(liveSearchResultInfo);
                    }
                }
            }
        }
    }
}
