package com.baidu.rtc.signalling.play;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.signalling.mode.IJsonSignalling;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.Logging;
/* loaded from: classes5.dex */
public class RemoteSdpRequest implements IJsonSignalling {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RemoteSdpRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public final String sdp;
    public final String streamUrl;
    public final long transactionId;

    public RemoteSdpRequest(String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j2), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sdp = str;
        this.transactionId = j2;
        this.streamUrl = str2;
    }

    @Override // com.baidu.rtc.signalling.mode.IJsonSignalling
    public JSONObject asJSONObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sdktag", "BRTC.HTTP.PULL.SDK");
                jSONObject.put("sdp", this.sdp);
                jSONObject.put("transaction", String.valueOf(this.transactionId));
                jSONObject.put("streamurl", this.streamUrl);
            } catch (JSONException e2) {
                Logging.e("RemoteSdpRequest", "Caught error while play request as json" + e2.getMessage());
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.rtc.signalling.mode.IJsonSignalling
    public String toJSONString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? asJSONObject().toString() : (String) invokeV.objValue;
    }
}
