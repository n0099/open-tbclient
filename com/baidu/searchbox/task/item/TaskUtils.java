package com.baidu.searchbox.task.item;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.baidu.adp.plugin.Plugin;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class TaskUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TaskUtils() {
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

    public static boolean isMainProcess(boolean z, Context context) {
        InterceptResult invokeZL;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65537, null, z, context)) == null) {
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
}
