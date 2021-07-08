package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AlaCharmCardActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHARM_VALUE = "charm_value";
    public static final String FLOWER_VALUE = "flower_value";
    public static final String GROUP_ID = "group_id";
    public static final String LIVE_ID = "live_id";
    public static final String LIVE_OWNER_FLAG = "live_owner_flag";
    public static final String LIVE_OWNER_UID = "live_owner_uid";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaCharmCardActivityConfig(Context context, String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4, str5, Boolean.valueOf(z), str6};
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
        getIntent().putExtra("user_name", str);
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra(CHARM_VALUE, str3);
        getIntent().putExtra("group_id", str4);
        getIntent().putExtra("live_id", str5);
        getIntent().putExtra(LIVE_OWNER_FLAG, z);
        getIntent().putExtra(LIVE_OWNER_UID, str6);
        setRequestCode(25015);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
