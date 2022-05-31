package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class FrsArActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AR_ID = "ar_id";
    public static final String AR_TYPE = "ar_type";
    public static final String NAME = "name";
    public static final String TITLE_SHARE = "share_title";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsArActivityConfig(Context context, String str, String str2, String str3, String str4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4};
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
        Intent intent = getIntent();
        intent.putExtra("name", str);
        intent.putExtra("ar_id", str2);
        intent.putExtra("ar_type", str3);
        intent.putExtra(TITLE_SHARE, str4);
        if (getContext() instanceof Activity) {
            return;
        }
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
    }
}
