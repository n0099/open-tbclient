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
import com.sina.weibo.sdk.share.BaseActivity;
@SuppressLint({BaseActivity.TAG})
/* loaded from: classes3.dex */
public class InstallPluginDelegateActivity extends PluginDelegateActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public InstallPluginDelegateActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 31003;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity
    public void exit(int i, String str) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            Intent intent = new Intent();
            intent.putExtra(DelegateDef.EXTRA_DELEGATION_NAME, this.mDelegationName);
            intent.putExtra(DelegateDef.EXTRA_RESULT_CODE, i);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(DelegateDef.EXTRA_RESULT_DESC, str);
            }
            ActivityDelegation activityDelegation = this.mDelegation;
            if (activityDelegation != null && (bundle = activityDelegation.mResult) != null) {
                bundle.putInt("install_error", this.a);
                intent.putExtra(DelegateDef.EXTRA_RESULT, this.mDelegation.mResult);
            }
            setResult(-1, intent);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 1245421) {
                if (i2 == -1) {
                    this.a = 31021;
                } else if (i2 == 1) {
                    this.a = 31022;
                    if (intent != null) {
                        this.a = intent.getIntExtra("android.intent.extra.INSTALL_RESULT", 31022);
                    }
                }
            }
        }
    }
}
