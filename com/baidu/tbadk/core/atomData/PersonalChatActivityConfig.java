package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes11.dex */
public class PersonalChatActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IS_FRIEND = 1;
    public static final int IS_NOT_FRIEND = 0;
    public static final String KEY_FROM_REPORT_SELECT = "key_from_report_select";
    public static final String KEY_HAS_SELECT_MSG_LIST = "key_has_select_msg_list";
    public static final String KEY_IS_FOLLOW = "key_is_follow";
    public static final String KEY_IS_FRIEND = "key_is_friend";
    public static final String KEY_LEAVE_MSG = "key_leave_msg";
    public static final String KEY_REPLY_CONTENT = "key_reply_content";
    public static final String KEY_SELECT_MSG_LIST_FINISH = "key_select_msg_list_finish";
    public static final String KEY_SHARE_MSG = "key_share_msg";
    public static final String KEY_USER_ID = "key_user_id";
    public static final String KEY_USER_NAME = "key_user_name";
    public static final String KEY_USER_PORTAIT = "key_user_portait";
    public transient /* synthetic */ FieldHolder $fh;
    public UserData mUserData;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PersonalChatActivityConfig(Context context, long j2, String str, String str2, int i2) {
        this(context, j2, "", str, str2, 0, 0, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Long) objArr2[1]).longValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue(), ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public UserData getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mUserData : (UserData) invokeV.objValue;
    }

    public void setFollowStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            getIntent().putExtra(KEY_IS_FOLLOW, i2);
        }
    }

    public void setIsReportSelect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            getIntent().putExtra(KEY_FROM_REPORT_SELECT, z);
        }
    }

    public void setSelectList(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            getIntent().putExtra(KEY_HAS_SELECT_MSG_LIST, (Serializable) map);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PersonalChatActivityConfig(Context context, long j2, String str, String str2, String str3, int i2) {
        this(context, j2, str, str2, str3, i2, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), str, str2, str3, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Long) objArr2[1]).longValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setFollowStatus(1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PersonalChatActivityConfig(Context context, long j2, String str, String str2, String str3, int i2, String str4, String str5) {
        this(context, j2, str, str2, str3, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r5;
            Object[] objArr = {context, Long.valueOf(j2), str, str2, str3, Integer.valueOf(i2), str4, str5};
            interceptable.invokeUnInit(65542, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Long) objArr2[1]).longValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        Intent intent = getIntent();
        intent.putExtra(KEY_LEAVE_MSG, str4);
        intent.putExtra(KEY_SHARE_MSG, str5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PersonalChatActivityConfig(Context context, long j2, String str, String str2, String str3, int i2, int i3) {
        this(context, j2, str, str2, str3, i2, i3, "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Long) objArr2[1]).longValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue(), (String) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PersonalChatActivityConfig(Context context, long j2, String str, String str2, String str3, int i2, int i3, int i4) {
        this(context, j2, str, str2, str3, i2, i3, "", i4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Long.valueOf(j2), str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Long) objArr2[1]).longValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue(), (String) objArr2[7], ((Integer) objArr2[8]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalChatActivityConfig(Context context, long j2, String str, String str2, String str3, int i2, int i3, String str4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), str4};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mUserData = null;
        UserData userData = new UserData(j2, str, str3, i2);
        userData.setName_show(str2);
        this.mUserData = userData;
        Intent intent = getIntent();
        intent.putExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("chat_mode", 1);
        intent.putExtra("user", userData);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra(KEY_IS_FRIEND, i3);
        if (StringUtils.isNull(str4)) {
            return;
        }
        intent.putExtra(KEY_REPLY_CONTENT, str4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalChatActivityConfig(Context context, long j2, String str, String str2, String str3, int i2, int i3, String str4, int i4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), str4, Integer.valueOf(i4)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.mUserData = null;
        UserData userData = new UserData(j2, str, str3, i2);
        userData.setName_show(str2);
        userData.setUserType(i4);
        this.mUserData = userData;
        Intent intent = getIntent();
        intent.putExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("chat_mode", 1);
        intent.putExtra("user", userData);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra(KEY_IS_FRIEND, i3);
        if (StringUtils.isNull(str4)) {
            return;
        }
        intent.putExtra(KEY_REPLY_CONTENT, str4);
    }
}
