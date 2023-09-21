package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PersonListActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FOLLOW = "follow";
    public static final String KEY_CALL_FROM = "key_call_from";
    public static final String KEY_FANS_NUMBER = "fans_number";
    public static final String KEY_PORTRAIT_URL = "key_portrait_url";
    public static final String LAST_PAGE_UNIQUE_ID = "last_page_unique_id";
    public static final String TOTLEFOLLOWNUM = "total_follow_num";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonListActivityConfig(Context context, boolean z, String str, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), str, Integer.valueOf(i)};
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
        getIntent().putExtra("follow", z);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra(IntentConfig.USER_SEX, i);
    }

    public void setFansNumber(int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (intent = getIntent()) != null) {
            intent.putExtra(KEY_FANS_NUMBER, i);
        }
    }

    public void setLastUniqueId(int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (intent = getIntent()) != null) {
            intent.putExtra("last_page_unique_id", i);
        }
    }

    public PersonListActivityConfig updateBjhUser(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (getIntent() != null) {
                getIntent().putExtra(IntentConfig.IS_BJH_USER, z);
            }
            return this;
        }
        return (PersonListActivityConfig) invokeZ.objValue;
    }

    public PersonListActivityConfig updateFollowNum(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, str)) == null) {
            if (getIntent() != null) {
                getIntent().putExtra(TOTLEFOLLOWNUM, i);
                getIntent().putExtra("portrait", str);
            }
            return this;
        }
        return (PersonListActivityConfig) invokeIL.objValue;
    }
}
