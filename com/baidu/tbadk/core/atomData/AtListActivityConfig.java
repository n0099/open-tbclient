package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AtListActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AT_SELECT_UID_DATA = "at_select_uid_data";
    public static final String CALL_AT_LIST_OPTIONAL = "at_list_optional";
    public static final String CALL_AT_LIST_SOURCE = "at_list_source";
    public static final String GROUP_BOT_SKILL = "group_bot_skill";
    public static final String GROUP_CHAT_FORUM_ID = "group_chat_forum_id";
    public static final String GROUP_CHAT_FORUM_NAME = "group_chat_forum_name";
    public static final String GROUP_CHAT_PAGE = "group_chat_page";
    public static final String GROUP_CHAT_ROOM_ID = "group_chat_room_id";
    public static final String IS_FOR_BJH = "is_for_bjh";
    public static final String IS_FOR_CHAT = "is_for_chat";
    public static final String IS_FOR_GROUP_CHAT = "is_for_group_chat";
    public static final String IS_SHOW_BOT_INFO = "is_show_bot_info";
    public static final String USER_ROLE = "user_role";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtListActivityConfig(Context context, int i, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z)};
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
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra(IntentConfig.IS_NEED_MULTIPLE, z);
        if (i == 12011) {
            getIntent().putExtra("keyboard", false);
        }
        if (TbadkApplication.getInst().getCurrentActivity() != null && TbadkApplication.getInst().getCurrentActivity().getWindow() != null) {
            wi.z(TbadkApplication.getInst(), TbadkApplication.getInst().getCurrentActivity().getWindow().getDecorView());
        }
    }

    public void setCallAtListOptional(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            getIntent().putExtra(CALL_AT_LIST_OPTIONAL, z);
        }
    }

    public void setCallAtListSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            getIntent().putExtra(CALL_AT_LIST_SOURCE, str);
        }
    }

    public void setChatroomId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            getIntent().putExtra(GROUP_CHAT_ROOM_ID, String.valueOf(j));
        }
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            getIntent().putExtra(GROUP_CHAT_FORUM_ID, String.valueOf(j));
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            getIntent().putExtra(GROUP_CHAT_FORUM_NAME, str);
        }
    }

    public void setFromFid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            getIntent().putExtra("forum_id", str);
        }
    }

    public void setFromTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            getIntent().putExtra("thread_id", str);
        }
    }

    public void setIsForBjh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            getIntent().putExtra(IS_FOR_BJH, z);
        }
    }

    public void setIsForChat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            getIntent().putExtra(IS_FOR_CHAT, z);
        }
    }

    public void setIsForGroupChat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            getIntent().putExtra(IS_FOR_GROUP_CHAT, z);
        }
    }

    public void setIsShowBotInfo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            getIntent().putExtra(IS_SHOW_BOT_INFO, z);
        }
    }

    public void setSelectedAtList(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, arrayList) == null) {
            getIntent().putParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA, arrayList);
        }
    }

    public void setSelectedAtUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            getIntent().putExtra(AT_SELECT_UID_DATA, str);
        }
    }

    public void setUserRole(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            getIntent().putExtra(USER_ROLE, i);
        }
    }
}
