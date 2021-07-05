package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class OneKeyLoginActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneKeyLoginActivityConfig(Context context, @NonNull String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
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
        getIntent().putExtra(LoginDialogActivityConfig.SHARE_MODEL_JSON_STRING, str);
        setRequestCode(25059);
        setIntentAction(IntentAction.ActivityForResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneKeyLoginActivityConfig(Context context, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM, str);
        getIntent().putExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_OPERATOR, str2);
        getIntent().putExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_SIGN, str3);
        setRequestCode(25059);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
