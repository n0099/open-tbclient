package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class GroupChatActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTO_SEND_EXTRA_MSG = "auto_send_extra_msg";
    public static final String AUTO_SEND_TEXT_MSG = "auto_send_text_msg";
    public static final String GROUP_AUTHOR_ID = "group_author_id";
    public static final String GROUP_ID = "group_id";
    public static final String GROUP_NAME = "group_name";
    public static final String GROUP_OBJ_TP = "ObjTp";
    public transient /* synthetic */ FieldHolder $fh;
    public GroupData mGroupData;
    public String mObjTp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupChatActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mGroupData = null;
        this.mObjTp = null;
    }

    public GroupData getGroupData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mGroupData : (GroupData) invokeV.objValue;
    }

    public String getObjTp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mObjTp : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GroupData groupData = getGroupData();
            return (groupData == null || groupData.getGroupId() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupChatActivityConfig(Activity activity, long j, String str, long j2, String str2) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Long.valueOf(j), str, Long.valueOf(j2), str2};
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
        this.mGroupData = null;
        this.mObjTp = null;
        GroupData groupData = new GroupData();
        groupData.setGroupId(j);
        groupData.setName(str);
        groupData.setAuthorId(j2);
        this.mGroupData = groupData;
        this.mObjTp = str2;
        Intent intent = getIntent();
        intent.putExtra(GROUP_AUTHOR_ID, String.valueOf(groupData.getAuthorId()));
        intent.putExtra(GROUP_OBJ_TP, str2);
        intent.putExtra(TbEnum.ParamKey.CHAT_MODE, 0);
        intent.putExtra("group", groupData);
        intent.putExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupChatActivityConfig(Activity activity, long j, String str, long j2, String str2, String str3, String str4) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Long.valueOf(j), str, Long.valueOf(j2), str2, str3, str4};
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
        this.mGroupData = null;
        this.mObjTp = null;
        GroupData groupData = new GroupData();
        groupData.setGroupId(j);
        groupData.setName(str);
        groupData.setAuthorId(j2);
        this.mGroupData = groupData;
        this.mObjTp = str2;
        Intent intent = getIntent();
        intent.putExtra(GROUP_AUTHOR_ID, String.valueOf(groupData.getAuthorId()));
        intent.putExtra(GROUP_OBJ_TP, str2);
        intent.putExtra(TbEnum.ParamKey.CHAT_MODE, 0);
        intent.putExtra("group", groupData);
        intent.putExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        if (str3 != null) {
            intent.putExtra(AUTO_SEND_TEXT_MSG, str3);
        }
        if (str4 != null) {
            intent.putExtra(AUTO_SEND_EXTRA_MSG, str4);
        }
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }
}
