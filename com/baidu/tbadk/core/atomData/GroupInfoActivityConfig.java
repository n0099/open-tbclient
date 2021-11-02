package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
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
    public GroupInfoActivityConfig(Context context, long j, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("group_id", j);
        getIntent().putExtra(ACTION_FROM, i2);
        if (context instanceof Activity) {
            return;
        }
        getIntent().addFlags(268435456);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInfoActivityConfig(Context context, long j, int i2, String str, long j2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i2), str, Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra("group_id", j);
        getIntent().putExtra(ACTION_FROM, i2);
        getIntent().putExtra(DEFAULT_INVITE_MSG, str);
        getIntent().putExtra(INVITE_USER_ID, j2);
        getIntent().putExtra(JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_INVITE);
        if (context instanceof Activity) {
            return;
        }
        getIntent().addFlags(268435456);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInfoActivityConfig(int i2, Activity activity, long j, int i3) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), activity, Long.valueOf(j), Integer.valueOf(i3)};
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
        getIntent().putExtra("requestCode", i2);
        getIntent().putExtra("group_id", j);
        getIntent().putExtra(ACTION_FROM, i3);
        if (activity instanceof Activity) {
            return;
        }
        getIntent().addFlags(268435456);
    }
}
