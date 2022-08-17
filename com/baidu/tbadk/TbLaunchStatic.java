package com.baidu.tbadk;

import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tieba.im.chat.GroupMsgImageActivity;
import com.baidu.tieba.im.message.ResponseAddGroupUserMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.wxapi.WXEntryActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aa7;
import com.repackage.ba7;
import com.repackage.r57;
import com.repackage.z97;
/* loaded from: classes3.dex */
public class TbLaunchStatic {
    public static /* synthetic */ Interceptable $ic = null;
    public static String Tag = "tag";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-377752183, "Lcom/baidu/tbadk/TbLaunchStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-377752183, "Lcom/baidu/tbadk/TbLaunchStatic;");
                return;
            }
        }
        initRegisterIntent();
        initRegisterTask();
    }

    public TbLaunchStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void initRegisterIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            TbadkApplication.getInst().RegisterIntent(GroupMsgImageActivityConfig.class, GroupMsgImageActivity.class);
            TbadkCoreApplication.getInst().RegisterOrUpdateIntent(WXEntryActivityConfig.class, WXEntryActivity.class);
        }
    }

    public static void initRegisterTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            r57.b(202004, ResponseDelSystemMessage.class, false);
            r57.b(103112, ResponseRemoveMembersMessage.class, false);
            r57.b(202001, ResponseCommitGroupMessage.class, false);
            r57.b(103111, ResponseAddGroupUserMessage.class, false);
            r57.b(103105, ResponseUpgradeMemberGroupMessage.class, false);
            r57.b(103008, ResponseUserPermissionMessage.class, false).f(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
            r57.b(103102, ResponseUpdateGroupMessage.class, false).f(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
            r57.b(103104, ResponseDismissGroupMessage.class, false);
            r57.a(2001142, z97.class);
            r57.a(2001145, ba7.class);
            r57.a(2001148, aa7.class);
        }
    }
}
