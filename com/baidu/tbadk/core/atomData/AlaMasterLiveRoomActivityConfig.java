package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class AlaMasterLiveRoomActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CREATE_MASTER_LIVE_TYPE = "create_master_live_type";
    public static final int CREATE_MASTER_LIVE_TYPE_FROM_CRASH_REOPEN = 2;
    public static final int CREATE_MASTER_LIVE_TYPE_NORMAL = 1;
    public static final String LIVE_FORUM_ID = "live_forum_id";
    public static final String LIVE_FORUM_NAME = "live_forum_name";
    public static final String LIVE_INFO = "live_info_core";
    public static final String SPECIAL_FORIM_TYPE = "special_forum_type";
    public static final String USER_ID = "user_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaMasterLiveRoomActivityConfig(Context context, Serializable serializable) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, serializable};
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
        getIntent().putExtra("live_info_core", serializable);
        getIntent().putExtra(CREATE_MASTER_LIVE_TYPE, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaMasterLiveRoomActivityConfig(Context context, String str, String str2, String str3, String str4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("live_forum_name", str);
        getIntent().putExtra("live_forum_id", str2);
        getIntent().putExtra("user_id", str3);
        getIntent().putExtra(CREATE_MASTER_LIVE_TYPE, 1);
        getIntent().putExtra(SPECIAL_FORIM_TYPE, str4);
    }
}
