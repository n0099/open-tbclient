package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.data.StatisticInfoField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AbsMsgImageActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ASSIST_URL = "assist_url";
    public static final String CURRENT_URL = "current_url";
    public static final String FROM = "from";
    public static final String ID = "id";
    public static final String ID_UNIQUE = "uniqueid";
    public static final String IS_FROM_GROUP_CHAT = "from_group_chat";
    public static final int PAGE_TEXT_GEN_IMAGE = 1;
    public static final String PIC_PID = "pid";
    public static final String STATISTIC_INFO_FIELD = "statistic_info_field";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsMsgImageActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    public void isFromGroupChat(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(IS_FROM_GROUP_CHAT, z);
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && getIntent() != null) {
            getIntent().putExtra("from", i);
        }
    }

    public void setPid(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && getIntent() != null) {
            getIntent().putExtra("pid", str);
        }
    }

    public void setStatisticInfoFild(StatisticInfoField statisticInfoField) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, statisticInfoField) == null) && getIntent() != null) {
            getIntent().putExtra(STATISTIC_INFO_FIELD, statisticInfoField);
        }
    }
}
