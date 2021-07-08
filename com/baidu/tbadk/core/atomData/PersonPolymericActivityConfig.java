package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PersonPolymericActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IS_BIGV = "is_bigv";
    public static final String IS_SHOW_THREAD_TOP = "is_show_thread_top";
    public static final String IS_USER_SELF = "is_user_self";
    public static final String RESOURCE_TYPE = "resouce_type";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPolymericActivityConfig(Context context) {
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

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean asynStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public PersonPolymericActivityConfig createNormalConfig(long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Intent intent = getIntent();
            intent.putExtra("user_id", j);
            intent.putExtra(IS_USER_SELF, z);
            intent.putExtra(IS_BIGV, z2);
            return this;
        }
        return (PersonPolymericActivityConfig) invokeCommon.objValue;
    }

    public void setSourceNid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            getIntent().putExtra("nid", str);
        }
    }

    public void setSourceTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            getIntent().putExtra("thread_id", str);
        }
    }

    public void setUri(Uri uri) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, uri) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(IntentConfig.KEY_URI, uri);
    }

    public PersonPolymericActivityConfig createNormalConfig(long j, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            Intent intent = getIntent();
            intent.putExtra("user_id", j);
            intent.putExtra(IS_USER_SELF, z);
            intent.putExtra(IS_BIGV, z2);
            intent.putExtra(IS_SHOW_THREAD_TOP, z3);
            return this;
        }
        return (PersonPolymericActivityConfig) invokeCommon.objValue;
    }
}
