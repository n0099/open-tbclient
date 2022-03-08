package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class GroupAddressLocateActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTENT_DATA_IS_HIDDEN_ADDRESS = "IntentDataIsHiddenAddress";
    public static final String INTENT_DATA_OLD_ADDRESS = "IntentDataOldAddress";
    public static final String INTENT_DATA_OLD_BUSINESS = "IntentDataOldBusiness";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAddressLocateActivityConfig(Context context, int i2, String str, String str2, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra(INTENT_DATA_OLD_ADDRESS, str);
        getIntent().putExtra(INTENT_DATA_OLD_BUSINESS, str2);
        getIntent().putExtra(INTENT_DATA_IS_HIDDEN_ADDRESS, z);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
