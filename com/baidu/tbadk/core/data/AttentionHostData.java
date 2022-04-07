package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AttentionHostData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2696089215466586871L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isAttention;
    public boolean isGod;
    public int likeStatus;
    public String portrait;
    public String uid;

    public AttentionHostData() {
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

    public void parserWithJsonString(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.isAttention = jSONObject.optBoolean("is_attention", false);
            this.uid = jSONObject.optString("uid");
            this.portrait = jSONObject.optString("portrait");
            this.likeStatus = jSONObject.optInt("like_status", 0);
            this.isGod = jSONObject.optBoolean("is_god", false);
        } catch (Throwable unused) {
        }
    }

    public void parserWithMetaData(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData) == null) || metaData == null) {
            return;
        }
        this.isAttention = metaData.hadConcerned();
        this.uid = metaData.getUserId();
        this.portrait = metaData.getPortrait();
        this.likeStatus = metaData.getLikeStatus();
        this.isGod = metaData.isGod();
    }

    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("is_attention", this.isAttention);
                jSONObject.put("uid", this.uid);
                jSONObject.put("portrait", this.portrait);
                jSONObject.put("like_status", this.likeStatus);
                jSONObject.put("is_god", this.isGod);
                return jSONObject.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
