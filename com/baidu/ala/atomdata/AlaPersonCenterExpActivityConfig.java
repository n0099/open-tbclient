package com.baidu.ala.atomdata;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AlaPersonCenterExpActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CURRENT_EXP = "current_exp";
    public static final String CURRENT_LEVEL = "current_level";
    public static final String CURRENT_MAX_EXP = "current_max_exp";
    public static final String IS_HOST = "isHost";
    public static final String NEXT_LEVEL = "next_level";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaPersonCenterExpActivityConfig(Context context, long j, int i, long j2, int i2, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra(CURRENT_EXP, j);
        getIntent().putExtra("current_level", i);
        getIntent().putExtra(CURRENT_MAX_EXP, j2);
        getIntent().putExtra(NEXT_LEVEL, i2);
        getIntent().putExtra(IS_HOST, z);
    }
}
