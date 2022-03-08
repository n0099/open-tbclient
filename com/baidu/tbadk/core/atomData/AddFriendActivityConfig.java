package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AddFriendActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_MESSAGE = "default_message";
    public static final String FROM = "from";
    public static final String IS_USER_CLIENT_LOWER = "is_user_client_lower";
    public static final String MSG = "msg";
    public static final String TYPE_CONCERN_HEAD = "corcern_head";
    public static final String TYPE_FAVOR_LIST = "favor_list";
    public static final String TYPE_FOCUS = "focus";
    public static final String TYPE_FRS_HEAD = "frs_head";
    public static final String TYPE_HOME_HEAD = "home_head";
    public static final String TYPE_IM_GROUP = "imgroup";
    public static final String TYPE_NEW_FRD = "new_frd";
    public static final String TYPE_PB_FLOOR = "pb_floor";
    public static final String TYPE_PB_HEAD = "pb_head";
    public static final String TYPE_REPLY_ME = "reply_pg";
    public static final String TYPE_SEARCH = "search";
    public static final String TYPE_STRANGER_CHAT = "stranger_chat";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddFriendActivityConfig(Context context, String str, String str2, String str3, String str4, boolean z, String str5) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4, Boolean.valueOf(z), str5};
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
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("name_show", str2);
        getIntent().putExtra("portrait", str3);
        getIntent().putExtra("from", str4);
        getIntent().putExtra(IS_USER_CLIENT_LOWER, z);
        getIntent().putExtra("st_type", str5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddFriendActivityConfig(Context context, String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4, Boolean.valueOf(z), str5, str6};
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
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("name_show", str2);
        getIntent().putExtra("portrait", str3);
        getIntent().putExtra("from", str4);
        getIntent().putExtra(IS_USER_CLIENT_LOWER, z);
        getIntent().putExtra("st_type", str5);
        getIntent().putExtra(DEFAULT_MESSAGE, str6);
    }
}
