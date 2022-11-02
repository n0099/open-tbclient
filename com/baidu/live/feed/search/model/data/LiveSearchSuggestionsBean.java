package com.baidu.live.feed.search.model.data;

import androidx.annotation.NonNull;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveSearchSuggestionsBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasmore;
    public LiveErrorInfo liveErrorInfo;
    public List<LiveSearchResultInfo> mSearchResultList;
    public String question;
    public List<LiveSearchSuggestion> suggestionList;

    public LiveSearchSuggestionsBean() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hasmore = false;
    }

    public void parse(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
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
}
