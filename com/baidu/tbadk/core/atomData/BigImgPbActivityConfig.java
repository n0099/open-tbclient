package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BigImgPbActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BIGPB_URL = "https://tieba.baidu.com/n/drift-bottle/detail";
    public static final String BIG_PB_TID = "big_pb_tid";
    public static final String BIG_PB_USER_NAME = "user_name=";
    public static final String JUHE_URL = "https://tieba.baidu.com/n/drift-bottle/home";
    public static final String MY_BOTTLE_URL = "https://tieba.baidu.com/n/drift-bottle/personal-bottle";
    public static final String OPEN_COMMON = "open_common=";
    public static final String TYPE_RESOURCE = "type_resource";
    public static final int TYPE_RESOURCE_FOR_BIGPB = 1;
    public static final int TYPE_RESOURCE_FOR_JUHE = 2;
    public static final int TYPE_RESOURCE_FOR_MYBOTTLE = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigImgPbActivityConfig(Context context) {
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
        getIntent().putExtra(TYPE_RESOURCE, 1);
        getIntent().putExtra(BIG_PB_TID, str);
    }
}
