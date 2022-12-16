package com.baidu.android.imsdk.chatmessage.messages;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AdvisoryImageMsg extends ImageMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AdvisoryImageMsg";
    public transient /* synthetic */ FieldHolder $fh;

    public AdvisoryImageMsg() {
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

    @Override // com.baidu.android.imsdk.chatmessage.messages.ImageMsg
    public String getImgContent(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String imgContent = super.getImgContent(str);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject = new JSONObject(imgContent);
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    AdvisoryMsgBusinessExtra.putAdvisoryExtra(jSONObject3, this.advisoryMsgBusinessExtra);
                    jSONObject.put("business_ext", jSONObject3.toString());
                } catch (JSONException e) {
                    e = e;
                    jSONObject2 = jSONObject;
                    LogUtils.e(TAG, "getImgContent", e);
                    jSONObject = jSONObject2;
                    return jSONObject.toString();
                }
            } catch (JSONException e2) {
                e = e2;
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void setBusinessExtInfo(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            if (this.advisoryMsgBusinessExtra == null) {
                this.advisoryMsgBusinessExtra = new AdvisoryMsgBusinessExtra();
            }
            this.advisoryMsgBusinessExtra.setRounds(i);
            this.advisoryMsgBusinessExtra.setAid(str);
        }
    }
}
