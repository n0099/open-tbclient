package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CreateGroupActivityActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GROUP_ACTIVITY_AREA = "area";
    public static final String GROUP_ACTIVITY_CONTENT = "content";
    public static final String GROUP_ACTIVITY_GID = "gid";
    public static final String GROUP_ACTIVITY_ID = "aid";
    public static final String GROUP_ACTIVITY_ISEDIT = "isedit";
    public static final String GROUP_ACTIVITY_NAME = "name";
    public static final String GROUP_ACTIVITY_TIME = "time";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGroupActivityActivityConfig(Context context, long j2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("gid", j2);
        getIntent().putExtra(GROUP_ACTIVITY_ISEDIT, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGroupActivityActivityConfig(Activity activity, long j2, GroupActivityData groupActivityData, int i2) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Long.valueOf(j2), groupActivityData, Integer.valueOf(i2)};
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
        getIntent().putExtra("gid", j2);
        getIntent().putExtra(GROUP_ACTIVITY_ISEDIT, true);
        getIntent().putExtra("aid", groupActivityData.getActivityId());
        getIntent().putExtra("name", groupActivityData.getgActivityTitle());
        getIntent().putExtra("time", groupActivityData.getgActivityTime());
        getIntent().putExtra(GROUP_ACTIVITY_AREA, groupActivityData.getgActivityArea());
        getIntent().putExtra("content", groupActivityData.getgActivityContent());
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
