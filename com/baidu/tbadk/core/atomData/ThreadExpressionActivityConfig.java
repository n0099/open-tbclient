package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ThreadExpressionActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IS_HOST = "is_host";
    public static final String IS_LIKED = "is_liked";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadExpressionActivityConfig(Context context, String str, boolean z, int i, boolean z2, String str2, String str3, long j) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2), str2, str3, Long.valueOf(j)};
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
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("thread_id", str);
        getIntent().putExtra(IS_HOST, z);
        getIntent().putExtra(IS_LIKED, z2);
        getIntent().putExtra("portrait", str3);
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra("forum_id", j);
    }
}
