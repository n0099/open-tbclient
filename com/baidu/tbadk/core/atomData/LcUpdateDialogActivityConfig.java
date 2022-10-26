package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class LcUpdateDialogActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_LC_UPDATE_APKMD5RSA = "key_lc_update_apkmd5rsa";
    public static final String KEY_LC_UPDATE_DATA = "key_lc_update_data";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LcUpdateDialogActivityConfig(Context context, ClientUpdateInfo clientUpdateInfo, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, clientUpdateInfo, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intent intent = getIntent();
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra(KEY_LC_UPDATE_DATA, clientUpdateInfo);
        intent.putExtra(KEY_LC_UPDATE_APKMD5RSA, str);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                return true;
            }
            UtilHelper.showToast(getContext(), getContext().getString(R.string.obfuscated_res_0x7f0f0a15));
            return false;
        }
        return invokeV.booleanValue;
    }
}
