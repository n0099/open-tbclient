package com.baidu.sapi2.social;

import android.os.Bundle;
import android.widget.RelativeLayout;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SocialLoginBase extends BaseActivity implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public static WXInvokeCallback t;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout rootView;

    public SocialLoginBase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static WXInvokeCallback getWXinvokeCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? t : (WXInvokeCallback) invokeV.objValue;
    }

    public static void setWXLoginCallback(WXInvokeCallback wXInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, wXInvokeCallback) == null) {
            t = wXInvokeCallback;
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setContentView(R.layout.obfuscated_res_0x7f0d04eb);
            } catch (Throwable unused) {
            }
            this.rootView = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091b4c);
        }
    }
}
