package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class UpdateGroupActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EDIT_TYPE = "edit_type";
    public static final String GROUP_TEXT = "group_text";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateGroupActivityConfig(Context context, int i2, long j2, int i3, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str};
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
        getIntent().putExtra("group_id", j2);
        getIntent().putExtra("edit_type", i3);
        getIntent().putExtra(GROUP_TEXT, str);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
