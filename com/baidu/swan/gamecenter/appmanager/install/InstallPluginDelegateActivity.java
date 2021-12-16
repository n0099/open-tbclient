package com.baidu.swan.gamecenter.appmanager.install;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateDef;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"BaseActivity"})
/* loaded from: classes11.dex */
public class InstallPluginDelegateActivity extends PluginDelegateActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INSTALL_ERROR_CODE = "install_error";
    public static final int INSTALL_REQUEST_CODE = 1245421;
    public transient /* synthetic */ FieldHolder $fh;
    public int mErrorCode;

    public InstallPluginDelegateActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mErrorCode = 31003;
    }

    @Override // com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity
    public void exit(int i2, String str) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            Intent intent = new Intent();
            intent.putExtra(DelegateDef.EXTRA_DELEGATION_NAME, this.mDelegationName);
            intent.putExtra(DelegateDef.EXTRA_RESULT_CODE, i2);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(DelegateDef.EXTRA_RESULT_DESC, str);
            }
            ActivityDelegation activityDelegation = this.mDelegation;
            if (activityDelegation != null && (bundle = activityDelegation.mResult) != null) {
                bundle.putInt(INSTALL_ERROR_CODE, this.mErrorCode);
                intent.putExtra(DelegateDef.EXTRA_RESULT, this.mDelegation.mResult);
            }
            setResult(-1, intent);
            finish();
        }
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mErrorCode : invokeV.intValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 1245421) {
                if (i3 == -1) {
                    this.mErrorCode = 31021;
                } else if (i3 == 1) {
                    this.mErrorCode = 31022;
                    if (intent != null) {
                        this.mErrorCode = intent.getIntExtra("android.intent.extra.INSTALL_RESULT", 31022);
                    }
                }
            }
        }
    }
}
