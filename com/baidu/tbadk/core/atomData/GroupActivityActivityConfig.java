package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class GroupActivityActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVITY_ID = "activity_id";
    public static final String FROM = "from";
    public static final int FROM_GROUP_CHAT = 2;
    public static final int FROM_GROUP_INFO = 0;
    public static final int FROM_GROUP_UPDATE = 1;
    public static final String GROUP_ID = "group_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupActivityActivityConfig(Context context, int i2, long j2, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra("activity_id", i2);
        getIntent().putExtra("group_id", j2);
        getIntent().putExtra("from", i3);
        if (context instanceof Activity) {
            return;
        }
        getIntent().addFlags(268435456);
    }
}
