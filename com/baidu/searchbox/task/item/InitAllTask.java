package com.baidu.searchbox.task.item;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d1.a0;
import c.a.q0.s.k;
import c.a.q0.s.q.z0;
import c.a.q0.t.j.c;
import c.a.q0.z0.a;
import c.a.r0.p3.d;
import c.a.r0.y3.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
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
import java.util.List;
/* loaded from: classes5.dex */
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
                c.a.e.e.i.a.l().o();
                if (PermissionUtil.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
                    c.a.e.e.i.a.l().h(false);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (PermissionUtil.checkLocationForGoogle(AppRuntime.getAppContext())) {
                c.a.e.e.i.a.l().h(false);
            }
            try {
                a0.b().e();
                if (isMainProcess(false)) {
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

    private boolean isMainProcess(boolean z) {
        InterceptResult invokeZ;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z)) == null) {
            Context appContext = AppRuntime.getAppContext();
            ActivityManager activityManager = (ActivityManager) appContext.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return z;
            }
            String packageName = appContext.getPackageName();
            String str = packageName + ":cdnTachometer";
            String str2 = packageName + ":daemon";
            String str3 = packageName + ":remote";
            String str4 = packageName + ":third";
            String str5 = packageName + ":xiaoying";
            String[] strArr = {str3, str, packageName + ":bdservice_v1", packageName + ":live", packageName + ":cdnTachometer", str2, str5, packageName + ":pluginInstaller", packageName + ":media", packageName + ":kmyas__"};
            String str6 = packageName + ":guardService";
            String str7 = packageName + ":warkup";
            String str8 = packageName + ":swan";
            String str9 = packageName + ":bdservice_v1";
            int myPid = Process.myPid();
            int i2 = 0;
            while (true) {
                if (i2 >= runningAppProcesses.size()) {
                    break;
                } else if (runningAppProcesses.get(i2).pid == myPid) {
                    String str10 = runningAppProcesses.get(i2).processName;
                    if (str10 == null) {
                        return z;
                    }
                    if (str10.equalsIgnoreCase(packageName)) {
                        Plugin.mProcessName = "mainProcess";
                        return true;
                    }
                    if (str10.contains(packageName)) {
                        Plugin.mProcessName = str10.replace(packageName, "");
                    }
                    if (str10.equalsIgnoreCase(str6) || str10.equalsIgnoreCase(str7) || str10.contains(str8)) {
                        return false;
                    }
                    for (int i3 = 0; i3 < 10; i3++) {
                        if (str10.equalsIgnoreCase(strArr[i3])) {
                            return false;
                        }
                    }
                } else {
                    i2++;
                }
            }
            return z;
        }
        return invokeZ.booleanValue;
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
            c a2 = c.a();
            a2.g(dVar.b() == 1);
            a2.h(dVar.c());
            a2.i(dVar.d() * 1000);
            if (dVar.a() != null) {
                a2.j(dVar.a());
            }
        }
    }
}
