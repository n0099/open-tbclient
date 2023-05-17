package com.baidu.spswitch.emotion.net;

import com.baidu.searchbox.config.HostConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class EmotionUrlConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EMO_ID_LIST_TAG = "emotion_id_list_tag";
    public static final String EMO_LIST_TAG = "emotion_emo_list_tag";
    public transient /* synthetic */ FieldHolder $fh;

    public EmotionUrlConfig() {
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

    public static String getEmoIdList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return String.format("%s/icomment/v1/emoticon/list", HostConfig.getSearchboxHostForHttps());
        }
        return (String) invokeV.objValue;
    }

    public static String getEmoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return String.format("%s/icomment/v1/emoticon/emolist", HostConfig.getSearchboxHostForHttps());
        }
        return (String) invokeV.objValue;
    }
}
