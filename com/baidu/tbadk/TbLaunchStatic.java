package com.baidu.tbadk;

import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.e0.b;
import b.a.r0.l1.c;
import b.a.r0.l1.v.a.d;
import b.a.r0.l1.v.a.e;
import b.a.r0.l1.v.a.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
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
/* loaded from: classes8.dex */
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
        initRegisterListeners();
    }

    public TbLaunchStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static void initRegisterListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.TbLaunchStatic.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        long l = b.j().l("clear_redundance_files_time", 0L);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - l > 86400000) {
                            PluginPackageManager.O().C();
                            b.j().w("clear_redundance_files_time", currentTimeMillis);
                        }
                    }
                }
            });
        }
    }

    public static void initRegisterTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            c.b(202004, ResponseDelSystemMessage.class, false);
            c.b(103112, ResponseRemoveMembersMessage.class, false);
            c.b(202001, ResponseCommitGroupMessage.class, false);
            c.b(103111, ResponseAddGroupUserMessage.class, false);
            c.b(103105, ResponseUpgradeMemberGroupMessage.class, false);
            c.b(103008, ResponseUserPermissionMessage.class, false).f(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
            c.b(103102, ResponseUpdateGroupMessage.class, false).f(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
            c.b(103104, ResponseDismissGroupMessage.class, false);
            c.a(2001142, d.class);
            c.a(2001145, f.class);
            c.a(2001148, e.class);
        }
    }
}
