package com.baidu.live.business.model.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFeedToolWrapData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List infos;

    public LiveFeedToolWrapData() {
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

    public static LiveFeedToolWrapData parse(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
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
        return (LiveFeedToolWrapData) invokeL.objValue;
    }
}
