package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AlaPersonCenterActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IS_SELF = "is_self";
    public static final String KEY_SEX = "key_sex";
    public static final String KEY_USER_NAME = "user_name";
    public static final String PORTRAIT_URL = "key_protrait";
    public static final String USER_ID = "user_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaPersonCenterActivityConfig(Context context, String str, String str2, String str3, int i2, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, Integer.valueOf(i2), Boolean.valueOf(z)};
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
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra(PORTRAIT_URL, str3);
        getIntent().putExtra(IS_SELF, z);
    }
}
