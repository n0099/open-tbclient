package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class HotTopicActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_BANG = "5";
    public static final String FROM_OTHER_CARD = "1";
    public static final String FROM_PB = "2";
    public static final String FROM_SEARCH = "4";
    public static final String FROM_TOPIC_CARD = "3";
    public static final String HOT_TOPIC_SELECT_STRING = "hot_string";
    public static final String STAT_OBJ_LOCATE = "obj_locate";
    public static final String ST_TYPE = "hot_topic";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public HotTopicActivityConfig createNormalConfig(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            return createNormalConfig(str, str2, null, str3);
        }
        return (HotTopicActivityConfig) invokeLLL.objValue;
    }

    public HotTopicActivityConfig createNormalConfig(String str, String str2, @Nullable String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4)) == null) {
            return createNormalConfig(str, str2, str3, str4, HotTopicStat.Locate.UNDEFINED);
        }
        return (HotTopicActivityConfig) invokeLLLL.objValue;
    }

    public HotTopicActivityConfig createNormalConfig(String str, String str2, @Nullable String str3, String str4, @NonNull HotTopicStat.Locate locate) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, str4, locate)) == null) {
            Intent intent = getIntent();
            intent.putExtra("topic_id", str);
            intent.putExtra("topic_name", str2);
            intent.putExtra("is_video_topic", str3);
            if (StringUtils.isNull(str4)) {
                str4 = "1";
            }
            intent.putExtra("from", str4);
            intent.putExtra("obj_locate", String.valueOf(locate.getStatValue()));
            return this;
        }
        return (HotTopicActivityConfig) invokeLLLLL.objValue;
    }

    public void setExtra(long j, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, str2, Long.valueOf(j2)}) == null) {
            getIntent().putExtra(IntentConfig.TOPIC_FID, j);
            getIntent().putExtra(IntentConfig.TOPIC_FIRST_DIR, str);
            getIntent().putExtra(IntentConfig.TOPIC_SECOND_DIR, str2);
            getIntent().putExtra(IntentConfig.TOPIC_TID, j2);
        }
    }
}
