package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class HotTopicActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_BANG = "5";
    public static final String FROM_OTHER_CARD = "1";
    public static final String FROM_PB = "2";
    public static final String FROM_SEARCH = "4";
    public static final String FROM_TOPIC_CARD = "3";
    public static final String HOT_TOPIC_SELECT_STRING = "hot_string";
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            Intent intent = getIntent();
            intent.putExtra("topic_id", str);
            intent.putExtra(IntentConfig.TOPIC_NAME, str2);
            if (StringUtils.isNull(str3)) {
                str3 = "1";
            }
            intent.putExtra("from", str3);
            return this;
        }
        return (HotTopicActivityConfig) invokeLLL.objValue;
    }

    public void setExtra(long j2, String str, String str2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, str2, Long.valueOf(j3)}) == null) {
            getIntent().putExtra(IntentConfig.TOPIC_FID, j2);
            getIntent().putExtra(IntentConfig.TOPIC_FIRST_DIR, str);
            getIntent().putExtra(IntentConfig.TOPIC_SECOND_DIR, str2);
            getIntent().putExtra(IntentConfig.TOPIC_TID, j3);
        }
    }
}
