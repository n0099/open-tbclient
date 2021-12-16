package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class GroupSettingActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTENT_DATA_GROUP_FLAG = "intent_data_group_flag";
    public static final String INTENT_DATA_GROUP_ID = "intent_data_group_id";
    public static final String INTENT_DATA_GROUP_NAME = "intent_data_group_name";
    public static final String INTENT_DATA_IS_GROUP_MASTER = "intent_data_is_group_master";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupSettingActivityConfig(Context context, int i2, String str, String str2, boolean z, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, str2, Boolean.valueOf(z), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra(INTENT_DATA_GROUP_NAME, str);
        getIntent().putExtra(INTENT_DATA_GROUP_ID, str2);
        getIntent().putExtra(INTENT_DATA_IS_GROUP_MASTER, z);
        getIntent().putExtra(INTENT_DATA_GROUP_FLAG, i3);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
