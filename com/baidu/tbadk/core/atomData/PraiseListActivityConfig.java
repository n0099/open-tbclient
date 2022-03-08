package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PraiseListActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IS_AUTHOR = "is_author";
    public static final int TYPE_GRAFFITI_PRAISE_LIST = 1;
    public static final int TYPE_NORMAL_PRAISE_LIST = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PraiseListActivityConfig(Context context, String str, String str2, String str3, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, Boolean.valueOf(z)};
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
        getIntent().putExtra("thread_id", str);
        getIntent().putExtra("post_id", str2);
        getIntent().putExtra(IntentConfig.POST_DESC, str3);
        getIntent().putExtra(IntentConfig.IS_FROM_PB, z);
    }

    public void setIsAuthor(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(IS_AUTHOR, z);
    }

    public void setIsGraffitiPraiseList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(IntentConfig.LIST_TYPE, 1);
    }
}
