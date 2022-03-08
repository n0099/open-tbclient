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
/* loaded from: classes3.dex */
public class AlaLiveGetUserNotifyResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<AlaLiveUserNotifyData> dataList;
    public int notify_count;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveGetUserNotifyResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return;
            }
            this.notify_count = optJSONObject.optInt("notify_count");
            JSONArray optJSONArray = optJSONObject.optJSONArray("notify_list");
            if (optJSONArray != null) {
                this.dataList = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    if (optJSONArray.optJSONObject(i3) != null) {
                        AlaLiveUserNotifyData alaLiveUserNotifyData = new AlaLiveUserNotifyData();
                        alaLiveUserNotifyData.parseJson(optJSONArray.optJSONObject(i3));
                        this.dataList.add(alaLiveUserNotifyData);
                    }
                }
            }
        }
    }

    public ArrayList<AlaLiveUserNotifyData> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dataList : (ArrayList) invokeV.objValue;
    }

    public int getNofifyCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.notify_count : invokeV.intValue;
    }
}
