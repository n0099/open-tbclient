package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class InterviewLiveActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ANTI = "interviewlive_anti";
    public static final String KEY_FORUM_ID = "forum_id";
    public static final String KEY_FORUM_NAME = "forum_name";
    public static final String KEY_IS_GOOD = "is_good";
    public static final String KEY_IS_TOP = "is_top";
    public static final String KEY_TASK_ID = "task_id";
    public static final String KEY_THREAD_ID = "thread_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterviewLiveActivityConfig(Context context) {
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

    public InterviewLiveActivityConfig createNormalCfg(String str, String str2, String str3, String str4, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("task_id", str2);
            intent.putExtra("forum_id", str3);
            intent.putExtra("forum_name", str4);
            intent.putExtra("is_top", i2);
            intent.putExtra("is_good", i3);
            return this;
        }
        return (InterviewLiveActivityConfig) invokeCommon.objValue;
    }
}
