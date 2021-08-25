package com.baidu.searchbox.task.item;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.plugin.Plugin;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.launch.stats.AppCreateSpeedStats;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class InitSapiTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitSapiTask() {
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

    private boolean isMainProcess(boolean z, Context context) {
        InterceptResult invokeZL;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65537, this, z, context)) == null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return z;
            }
            String packageName = context.getPackageName();
            String str = packageName + ":remote";
            String str2 = packageName + ":third";
            String str3 = packageName + ":xiaoying";
            String[] strArr = {str, packageName + ":cdnTachometer", packageName + ":bdservice_v1", packageName + ":live", packageName + ":cdnTachometer", packageName + ":daemon", str3, packageName + ":pluginInstaller", packageName + ":media", packageName + ":kmyas__"};
            String str4 = packageName + ":guardService";
            String str5 = packageName + ":warkup";
            String str6 = packageName + ":swan";
            String str7 = packageName + ":bdservice_v1";
            int myPid = Process.myPid();
            int i2 = 0;
            while (true) {
                if (i2 >= runningAppProcesses.size()) {
                    break;
                } else if (runningAppProcesses.get(i2).pid == myPid) {
                    String str8 = runningAppProcesses.get(i2).processName;
                    if (str8 == null) {
                        return z;
                    }
                    if (str8.equalsIgnoreCase(packageName)) {
                        Plugin.mProcessName = "mainProcess";
                        return true;
                    }
                    if (str8.contains(packageName)) {
                        Plugin.mProcessName = str8.replace(packageName, "");
                    }
                    if (str8.equalsIgnoreCase(str4) || str8.equalsIgnoreCase(str5) || str8.contains(str6)) {
                        return false;
                    }
                    for (int i3 = 0; i3 < 10; i3++) {
                        if (str8.equalsIgnoreCase(strArr[i3])) {
                            return false;
                        }
                    }
                } else {
                    i2++;
                }
            }
            return z;
        }
        return invokeZL.booleanValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            initSapi();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? AppCreateSpeedStats.INIT_SAPI : (String) invokeV.objValue;
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

    public void initSapi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Context appContext = AppRuntime.getAppContext();
            if (isMainProcess(true, appContext)) {
                MessageManager.getInstance().runTask(2921328, null, appContext);
            }
        }
    }
}
