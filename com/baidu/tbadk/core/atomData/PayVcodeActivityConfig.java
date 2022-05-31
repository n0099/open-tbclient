package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PayVcodeActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String VCODE_MD5 = "vcodeMd5";
    public static final String VCODE_RESULT = "vcode_result";
    public static final String VCODE_URL = "vcodeUrl";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayVcodeActivityConfig(Context context, String str, String str2, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Integer.valueOf(i)};
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
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        getIntent().putExtra(VCODE_MD5, str);
        getIntent().putExtra(VCODE_URL, str2);
    }
}
