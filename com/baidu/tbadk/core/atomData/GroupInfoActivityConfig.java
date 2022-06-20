package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class GroupInfoActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_FROM = "activity_from";
    public static final String DEFAULT_INVITE_MSG = "default_invite_msg";
    public static final int FROM_FORUM_GROUP_HOT = 5;
    public static final int FROM_FORUM_GROUP_OFFICIAL = 6;
    public static final int FROM_FORUM_GROUP_RECOMMEND = 4;
    public static final int FROM_GROUP_TALK = 3;
    public static final int FROM_INVITE_TALK = 7;
    public static final int FROM_OTHER = 0;
    public static final int FROM_USER_GROUP = 1;
    public static final String GROUP_ID = "group_id";
    public static final String INVITE_USER_ID = "inviter_user_id";
    public static final int JOIN_BUTTON_DISABLE_MAX_DURATION = 60000;
    public static final String JOIN_TYPE = "join_type";
    public static final String REQUEST_CODE = "requestCode";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInfoActivityConfig(Context context, long j, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i)};
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
        getIntent().putExtra("group_id", j);
        getIntent().putExtra(ACTION_FROM, i);
        if (context instanceof Activity) {
            return;
        }
        getIntent().addFlags(LaunchTaskConstants.OTHER_PROCESS);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInfoActivityConfig(Context context, long j, int i, String str, long j2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i), str, Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra("group_id", j);
        getIntent().putExtra(ACTION_FROM, i);
        getIntent().putExtra(DEFAULT_INVITE_MSG, str);
        getIntent().putExtra(INVITE_USER_ID, j2);
        getIntent().putExtra(JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_INVITE);
        if (context instanceof Activity) {
            return;
        }
        getIntent().addFlags(LaunchTaskConstants.OTHER_PROCESS);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInfoActivityConfig(int i, Activity activity, long j, int i2) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), activity, Long.valueOf(j), Integer.valueOf(i2)};
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
        getIntent().putExtra(REQUEST_CODE, i);
        getIntent().putExtra("group_id", j);
        getIntent().putExtra(ACTION_FROM, i2);
        if (activity instanceof Activity) {
            return;
        }
        getIntent().addFlags(LaunchTaskConstants.OTHER_PROCESS);
    }
}
