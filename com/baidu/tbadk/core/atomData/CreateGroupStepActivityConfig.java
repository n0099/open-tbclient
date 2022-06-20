package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CreateGroupStepActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FORUMID = "forumid";
    public static final String GROUP_TYPE = "group_type";
    public static final int GROUP_TYPE_COMMON = 3;
    public static final int GROUP_TYPE_MSG = 1;
    public static final int GROUP_TYPE_OFFICIAL = 4;
    public static final int GROUP_TYPE_OPERA = 5;
    public static final int GROUP_TYPE_PRIVATE = 2;
    public static final String INTENT_SOURCE_FROM = "Intent_Source_From";
    public static final String NUM_CREATE_GROUP_NORMAL = "num_create_group_normal";
    public static final String NUM_CREATE_GROUP_OFFICAL = "num_create_group_offical";
    public static final String NUM_CREATE_GROUP_PERSONAL = "num_create_group_private";
    public static final int SOURCE_FROM_BAR = 1013;
    public static final int SOURCE_FROM_MY = 1012;
    public static final int SOURCE_FROM_NEAR = 1011;
    public static final int SOURCE_FROM_OTHER = 1014;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGroupStepActivityConfig(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intent intent = getIntent();
        intent.putExtra("group_type", i);
        intent.putExtra("forumid", i2);
        intent.putExtra(INTENT_SOURCE_FROM, i3);
        intent.putExtra("num_create_group_normal", i4);
        intent.putExtra("num_create_group_private", i6);
        intent.putExtra("num_create_group_offical", i5);
    }
}
