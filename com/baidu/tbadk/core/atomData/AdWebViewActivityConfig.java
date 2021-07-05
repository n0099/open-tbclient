package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AdWebViewActivityConfig extends WebViewActivityConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdWebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, Bundle bundle) {
        super(context, str, str2, z, z2, z3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (bundle != null) {
            getIntent().putExtras(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.atomData.WebViewActivityConfig
    public String addTiebaParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? str : (String) invokeL.objValue;
    }
}
