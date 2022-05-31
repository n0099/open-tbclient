package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Build;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class EditNickNameActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARAM_TYPE = "param_type";
    public static final String PARAM_URL = "param_url";
    public static final int TYPE_MODIFY_NICKNAME = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditNickNameActivityConfig(Context context, int i, int i2, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), str};
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
        setRequestCode(i);
        getIntent().putExtra(PARAM_TYPE, i2);
        getIntent().putExtra(PARAM_URL, str);
        setIntentAction(IntentAction.ActivityForResult);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                return true;
            }
            UtilHelper.showToast(getContext(), getContext().getString(R.string.obfuscated_res_0x7f0f09fc));
            return false;
        }
        return invokeV.booleanValue;
    }
}
