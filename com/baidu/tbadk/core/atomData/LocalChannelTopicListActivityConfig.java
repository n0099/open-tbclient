package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class LocalChannelTopicListActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_IS_RESPONSE_FOR_TOPIC = "key_is_response_for_topic";
    public static final String KEY_RESPONSE_TOPIC = "key_response_topic";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalChannelTopicListActivityConfig(Context context) {
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

    public static LocalChannelTopicListActivityConfig forResult(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            LocalChannelTopicListActivityConfig localChannelTopicListActivityConfig = new LocalChannelTopicListActivityConfig(context);
            localChannelTopicListActivityConfig.getIntent().putExtra(KEY_IS_RESPONSE_FOR_TOPIC, true);
            localChannelTopicListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            localChannelTopicListActivityConfig.setRequestCode(i2);
            return localChannelTopicListActivityConfig;
        }
        return (LocalChannelTopicListActivityConfig) invokeLI.objValue;
    }
}
