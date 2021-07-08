package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ForbidActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MANAGER_USER_ID = "bar_manager_user_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForbidActivityConfig(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4, str5, str6, str7, str8};
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
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("thread_id", str3);
        getIntent().putExtra(MANAGER_USER_ID, str4);
        getIntent().putExtra("user_name", str5);
        getIntent().putExtra("post_id", str7);
        getIntent().putExtra("name_show", str6);
        getIntent().putExtra("portrait", str8);
    }
}
