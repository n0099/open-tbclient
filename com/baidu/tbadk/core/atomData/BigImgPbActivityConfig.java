package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BigImgPbActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BIGPB_URL;
    public static final String BIG_PB_TID = "big_pb_tid";
    public static final String BIG_PB_USER_NAME = "user_name=";
    public static final String JUHE_URL;
    public static final String MY_BOTTLE_URL;
    public static final String OPEN_COMMON = "open_common=";
    public static final String TYPE_RESOURCE = "type_resource";
    public static final int TYPE_RESOURCE_FOR_BIGPB = 1;
    public static final int TYPE_RESOURCE_FOR_JUHE = 2;
    public static final int TYPE_RESOURCE_FOR_MYBOTTLE = 3;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1297625426, "Lcom/baidu/tbadk/core/atomData/BigImgPbActivityConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1297625426, "Lcom/baidu/tbadk/core/atomData/BigImgPbActivityConfig;");
                return;
            }
        }
        JUHE_URL = TbConfig.TIEBA_ADDRESS + "n/drift-bottle/home";
        BIGPB_URL = TbConfig.TIEBA_ADDRESS + "n/drift-bottle/detail";
        MY_BOTTLE_URL = TbConfig.TIEBA_ADDRESS + "n/drift-bottle/personal-bottle";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigImgPbActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra(TYPE_RESOURCE, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigImgPbActivityConfig(Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra(TYPE_RESOURCE, 1);
        getIntent().putExtra(BIG_PB_TID, str);
    }
}
