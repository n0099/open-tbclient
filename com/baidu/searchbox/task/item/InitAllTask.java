package com.baidu.searchbox.task.item;

import android.content.Context;
import android.text.TextUtils;
import c.a.q0.d1.a0;
import c.a.q0.s.k;
import c.a.q0.s.q.z0;
import c.a.q0.t.j.c;
import c.a.q0.z0.a;
import c.a.r0.h4.h;
import c.a.r0.y3.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class InitAllTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitAllTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void dealYYNotification() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            a aVar = new a(2012100, new CustomMessageTask.CustomRunnable<z0>(this) { // from class: com.baidu.searchbox.task.item.InitAllTask.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitAllTask this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<z0> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        UtilHelper.showYYNotification(AppRuntime.getAppContext(), customMessage.getData(), 13);
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            aVar.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(aVar);
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            try {
                c.a.d.f.i.a.n().q();
                if (PermissionUtil.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
                    c.a.d.f.i.a.n().j(false);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (PermissionUtil.checkLocationForGoogle(AppRuntime.getAppContext())) {
                c.a.d.f.i.a.n().j(false);
            }
            try {
                a0.b().e();
                if (TbadkCoreApplication.getInst().isMainProcess(false, AppRuntime.getAppContext())) {
                    c.a.q0.g.a.d().f();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            loadLcsSwitchStratgy();
            TbadkCoreApplication.initSdcardDatabaseCallback();
            initAppSettings();
            Context appContext = AppRuntime.getAppContext();
            ViewHelper.initSkinDataOnStartup(appContext);
            TbConfig.initBigImageWidth(appContext);
            TbConfig.initFriendPhotoConfig(appContext);
            d.a();
            h.d();
            dealYYNotification();
        }
    }

    private void initAppSettings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            k.c().f();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            init();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "initAllTask" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    public void loadLcsSwitchStratgy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
            if (TextUtils.isEmpty(loadString)) {
                return;
            }
            c.a.q0.t.e.d dVar = new c.a.q0.t.e.d();
            dVar.e(loadString);
            c a = c.a();
            a.g(dVar.b() == 1);
            a.h(dVar.c());
            a.i(dVar.d() * 1000);
            if (dVar.a() != null) {
                a.j(dVar.a());
            }
        }
    }
}
