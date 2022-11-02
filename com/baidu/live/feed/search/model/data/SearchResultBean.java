package com.baidu.live.feed.search.model.data;

import androidx.annotation.NonNull;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SearchResultBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasmore;
    public LiveErrorInfo liveErrorInfo;
    public ArrayList<LiveRoomEntity> recommendList;
    public String refreshIndex;
    public String refreshType;
    public ArrayList<LiveSearchResultInfo> searchResultList;
    public ArrayList<LiveRoomEntity> searchResultVideoList;
    public String sessionId;
    public String subtab;
    public String tab;

    public SearchResultBean() {
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

    @NonNull
    public void parse(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            LiveErrorInfo liveErrorInfo = new LiveErrorInfo();
            this.liveErrorInfo = liveErrorInfo;
            liveErrorInfo.loadFromJSON(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("anchor_info");
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("live_info");
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("recommend_info");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray = optJSONObject2.optJSONArray("anchor_list");
                    this.searchResultList = new ArrayList<>();
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                            if (optJSONObject5 != null) {
                                LiveSearchResultInfo liveSearchResultInfo = new LiveSearchResultInfo();
                                liveSearchResultInfo.parseJSONObj(optJSONObject5);
                                this.searchResultList.add(liveSearchResultInfo);
                            }
                        }
                    }
                }
                if (optJSONObject3 != null) {
                    boolean z = true;
                    if (optJSONObject3.optInt("has_more") != 1) {
                        z = false;
                    }
                    this.hasmore = z;
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("live_list");
                    this.searchResultVideoList = new ArrayList<>();
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            JSONObject optJSONObject6 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject6 != null) {
                                LiveRoomEntity liveRoomEntity = new LiveRoomEntity();
                                liveRoomEntity.parseSearchJson(optJSONObject6);
                                this.searchResultVideoList.add(liveRoomEntity);
                            }
                        }
                    }
                }
                if (optJSONObject4 != null) {
                    this.sessionId = optJSONObject4.optString("session_id");
                    this.refreshType = optJSONObject4.optString("refresh_type");
                    this.refreshIndex = optJSONObject4.optString("refresh_index");
                    this.tab = optJSONObject4.optString("tab");
                    this.subtab = optJSONObject4.optString("subtab");
                    JSONArray optJSONArray3 = optJSONObject4.optJSONArray("items");
                    this.recommendList = new ArrayList<>();
                    if (optJSONArray3 != null) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            JSONObject optJSONObject7 = optJSONArray3.optJSONObject(i3);
                            if (optJSONObject7 != null) {
                                LiveRoomEntity liveRoomEntity2 = new LiveRoomEntity();
                                liveRoomEntity2.parseSearchJson(optJSONObject7);
                                this.recommendList.add(liveRoomEntity2);
                            }
                        }
                    }
                }
            }
        }
    }
}
