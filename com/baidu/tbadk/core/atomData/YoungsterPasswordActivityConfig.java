package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class YoungsterPasswordActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_YOUNGSTER_PASSWORD_FROM = "key_youngster_password_from";
    public static final String KEY_YOUNGSTER_PASSWORD_INPUT = "key_youngster_password_input";
    public static final String KEY_YOUNGSTER_PASSWORD_PAGE_TYPE = "key_youngster_password_page_type";
    public static final int YOUNGSTER_PASSWORD_FROM_FRS = 1;
    public static final int YOUNGSTER_PASSWORD_FROM_HOMEPAGE = 3;
    public static final int YOUNGSTER_PASSWORD_FROM_SETTING = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YoungsterPasswordActivityConfig(Context context) {
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

    public void setKeyYoungsterPasswordFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            getIntent().putExtra(KEY_YOUNGSTER_PASSWORD_FROM, i2);
        }
    }

    public void setKeyYoungsterPasswordInput(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            getIntent().putExtra(KEY_YOUNGSTER_PASSWORD_INPUT, str);
        }
    }

    public void setYoungsterPasswordPageType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            getIntent().putExtra(KEY_YOUNGSTER_PASSWORD_PAGE_TYPE, i2);
        }
    }
}
