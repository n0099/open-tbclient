package com.baidu.live.feed.search.model.data;

import android.text.TextUtils;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveSearchHotRankData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LiveSearchHotRankData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static List<LiveRoomEntity> parse(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject optJSONObject2 = new JSONObject(str).optJSONObject("data");
                if (optJSONObject2 != null && optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1 && (optJSONObject = optJSONObject2.optJSONObject("hot_rank")) != null && (optJSONArray = optJSONObject.optJSONArray("merge")) != null && optJSONArray.length() > 0) {
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
        return (List) invokeL.objValue;
    }
}
