package com.baidu.ala.notify;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLiveUserNotifyData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GUARDIAN_DUE = 1;
    public static final int GUARDIAN_GRAB = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String create_time;
    public AlaNotifyContent notifyContent;
    public int notify_type;
    public String user_id;

    /* renamed from: com.baidu.ala.notify.AlaLiveUserNotifyData$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class AlaNotifyContent {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String anchor_id;
        public String anchor_portrait;
        public String text;

        public AlaNotifyContent() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ AlaNotifyContent(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public AlaLiveUserNotifyData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getAnchorPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AlaNotifyContent alaNotifyContent = this.notifyContent;
            return alaNotifyContent != null ? alaNotifyContent.anchor_portrait : "";
        }
        return (String) invokeV.objValue;
    }

    public String getMessageContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AlaNotifyContent alaNotifyContent = this.notifyContent;
            return alaNotifyContent != null ? alaNotifyContent.text : "";
        }
        return (String) invokeV.objValue;
    }

    public boolean isSuperGuardian() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.notify_type;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.user_id = jSONObject.optString("user_id");
        this.create_time = jSONObject.optString("create_time");
        this.notify_type = jSONObject.optInt("notify_type");
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        if (optJSONObject != null) {
            AlaNotifyContent alaNotifyContent = new AlaNotifyContent(null);
            this.notifyContent = alaNotifyContent;
            alaNotifyContent.text = optJSONObject.optString("text");
            this.notifyContent.anchor_id = optJSONObject.optString("anchor_id");
            this.notifyContent.anchor_portrait = optJSONObject.optString("anchor_portrait");
        }
    }
}
