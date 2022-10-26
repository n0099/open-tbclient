package com.baidu.ala.notify;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlaLiveGetUserNotifyResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList dataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveGetUserNotifyResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ArrayList getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.dataList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (optJSONArray = optJSONObject.optJSONArray("notify_list")) != null) {
                this.dataList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    if (optJSONArray.optJSONObject(i2) != null) {
                        AlaLiveUserNotifyData alaLiveUserNotifyData = new AlaLiveUserNotifyData();
                        alaLiveUserNotifyData.parseJson(optJSONArray.optJSONObject(i2));
                        this.dataList.add(alaLiveUserNotifyData);
                    }
                }
            }
        }
    }
}
