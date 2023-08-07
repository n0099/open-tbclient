package com.baidu.tbadk.core.growthFunnel;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.UniKVTestSwitch;
import com.baidu.tbadk.util.AppLaunchInfoFetcher;
import com.baidu.tieba.bi;
import com.baidu.tieba.o75;
import com.baidu.tieba.yo5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes4.dex */
public class GrowthFunnelHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GROWTH_FUNNEL_SP = "growth_funnel_sp";
    public static final String KEY_APP_LAUNCH_FUNNEL = "c14579";
    public static final String KEY_APP_ONCREATE = "c14483";
    public static final String KEY_APP_ONCREATE_END = "c14484";
    public static final String KEY_APP_START = "c14429";
    public static final String KEY_CLIENT_DAU = "c14430";
    public static final String KEY_DEBUG = "c14482";
    public static final String KEY_UBC_LAUNCH_FUNNEL = "5109";
    public static final int START_TYPE_CALL_SERVIE_OR_RECEIVER = 98;
    public static final int START_TYPE_DEFAULT = 99;
    public static final int START_TYPE_FOR_EXCEPTION = 100;
    public static final int START_TYPE_FOR_UNKNOW = 101;
    public static final int START_TYPE_HOST_START = 1;
    public static final int START_TYPE_SCHEME_PUSH = 0;
    public static SharedPreferences growthFunnelSp = null;
    public static boolean hotSplash = false;
    public static String realStartScheme = null;
    public static int realStartType = 99;
    public static int restartTimes = -1;
    public static String startScheme;
    public static int startType;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1843592149, "Lcom/baidu/tbadk/core/growthFunnel/GrowthFunnelHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1843592149, "Lcom/baidu/tbadk/core/growthFunnel/GrowthFunnelHelper;");
        }
    }

    public GrowthFunnelHelper() {
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

    public static void addAppOnCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            initGrowthFunnerSp(TbadkCoreApplication.getInst());
            initRestartTimes();
            int i = 1;
            if (restartTimes >= 1) {
                i = 2;
            }
            addLog(KEY_APP_ONCREATE, 0, i);
        }
    }

    public static int getRestartTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            initRestartTimes();
            return restartTimes;
        }
        return invokeV.intValue;
    }

    public static void initRestartTimes() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, null) == null) && restartTimes < 0) {
            restartTimes = SharedPrefHelper.getInstance().getInt("app_restart_times", 0);
        }
    }

    public static void updateRealAppStartInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, null) == null) {
            realStartScheme = startScheme;
            realStartType = startType;
            notifyFlutterStartType();
        }
    }

    public static void addAttachBaseContext(Context context) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            if (restartTimes < 0) {
                if (!UniKVTestSwitch.isTypeSp() && !UniKVTestSwitch.isTypeDoubleSp()) {
                    restartTimes = KVStorageFactory.getSharedPreferences("settings2", 0).getInt("app_restart_times", 0);
                } else {
                    restartTimes = TbadkCoreApplication.getInst().getSharedPreferences("settings2", 0).getInt("app_restart_times", 0);
                }
            }
            initGrowthFunnerSp(context);
            if (restartTimes < 1) {
                i = 1;
            } else {
                i = 2;
            }
            addLogWithLastTime(KEY_APP_START, 1, i);
        }
    }

    public static void logFirstPageRenderDone(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            StatisticItem addParam = new StatisticItem(KEY_APP_LAUNCH_FUNNEL).addParam("obj_locate", str).addParam("obj_type", o75.a().b());
            if (o75.a().d()) {
                i = 1;
            } else {
                i = 2;
            }
            StatisticItem addParam2 = addParam.addParam("obj_param1", i).addParam("obj_source", 8);
            if (o75.a().b() != 3) {
                addParam2.addParam(TiebaStatic.Params.OBJ_PARAM2, getRealStartScheme());
            }
            TiebaStatic.log(addParam2);
        }
    }

    public static void logFirstPageShow(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            StatisticItem addParam = new StatisticItem(KEY_APP_LAUNCH_FUNNEL).addParam("obj_locate", str).addParam("obj_type", o75.a().b());
            if (o75.a().d()) {
                i = 1;
            } else {
                i = 2;
            }
            StatisticItem addParam2 = addParam.addParam("obj_param1", i).addParam("obj_source", 7);
            if (o75.a().b() != 3) {
                addParam2.addParam(TiebaStatic.Params.OBJ_PARAM2, getRealStartScheme());
            }
            TiebaStatic.log(addParam2);
        }
    }

    public static void addDebugStatistic(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            initGrowthFunnerSp(TbadkCoreApplication.getInst());
            initRestartTimes();
            int i2 = 1;
            if (restartTimes >= 1) {
                i2 = 2;
            }
            addLog(KEY_DEBUG, i, i2);
        }
    }

    public static void initGrowthFunnerSp(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, context) == null) && growthFunnelSp == null) {
            growthFunnelSp = context.getSharedPreferences(GROWTH_FUNNEL_SP, 0);
        }
    }

    public static void addLog(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65541, null, str, i, i2) == null) {
            Set<String> stringSet = growthFunnelSp.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
            SharedPreferences.Editor edit = growthFunnelSp.edit();
            edit.putStringSet(str, stringSet);
            edit.commit();
        }
    }

    public static void addLogWithLastTime(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65542, null, str, i, i2) == null) {
            String str2 = str + "_lastTime";
            long j = growthFunnelSp.getLong(str2, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            Set<String> stringSet = growthFunnelSp.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d_%d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - j)));
            SharedPreferences.Editor edit = growthFunnelSp.edit();
            edit.putStringSet(str, stringSet);
            edit.putLong(str2, currentTimeMillis);
            edit.commit();
        }
    }

    @NonNull
    public static String getRealStartScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String str = "";
            if (realStartType == 99) {
                String c = yo5.c();
                if (bi.isEmpty(c)) {
                    return "";
                }
                return c;
            }
            if (!StringUtils.isNull(realStartScheme)) {
                str = realStartScheme;
            }
            return bi.getUrlEncode(str);
        }
        return (String) invokeV.objValue;
    }

    public static void logAppCreateEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            initRestartTimes();
            StatisticItem statisticItem = new StatisticItem(KEY_APP_ONCREATE_END);
            int i = 1;
            if (restartTimes >= 1) {
                i = 2;
            }
            TiebaStatic.log(statisticItem.addParam("obj_source", i).addParam(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis()));
        }
    }

    public static void logEnterLogoActivity() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            StatisticItem addParam = new StatisticItem(KEY_APP_LAUNCH_FUNNEL).addParam("obj_type", o75.a().b());
            if (o75.a().d()) {
                i = 1;
            } else {
                i = 2;
            }
            TiebaStatic.log(addParam.addParam("obj_param1", i).addParam("obj_source", 5));
        }
    }

    public static void logExitLogoActivity() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            StatisticItem addParam = new StatisticItem(KEY_APP_LAUNCH_FUNNEL).addParam("obj_type", o75.a().b());
            if (o75.a().d()) {
                i = 1;
            } else {
                i = 2;
            }
            TiebaStatic.log(addParam.addParam("obj_param1", i).addParam("obj_source", 6));
        }
    }

    public static void logRecall() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            initRestartTimes();
            initGrowthFunnerSp(TbadkCoreApplication.getInst());
            SharedPreferences.Editor edit = growthFunnelSp.edit();
            logRecall(KEY_APP_START, edit);
            logRecall(KEY_APP_ONCREATE, edit);
            logRecall(KEY_DEBUG, edit);
            growthFunnelSp = null;
        }
    }

    public static String getScheme(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, intent)) == null) {
            String dataString = intent.getDataString();
            if (dataString != null && dataString.startsWith(ExceptionHandlerImpl.KEY_CUSTOM)) {
                StringBuilder sb = new StringBuilder();
                sb.append(dataString);
                sb.append(".action.");
                sb.append(intent.getAction());
                if (intent.getCategories() != null) {
                    sb.append("categories.");
                    for (String str : intent.getCategories()) {
                        sb.append(str);
                        sb.append(".");
                    }
                }
                return sb.toString();
            }
            return dataString;
        }
        return (String) invokeL.objValue;
    }

    public static void updateAppStartInfoForActivity(Activity activity) {
        ActivityManager activityManager;
        ActivityManager.AppTask appTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65561, null, activity) == null) && activity != null && activity.getClass() != null && Build.VERSION.SDK_INT >= 23 && (activityManager = (ActivityManager) activity.getSystemService("activity")) != null && (appTask = (ActivityManager.AppTask) ListUtils.getItem(activityManager.getAppTasks(), 0)) != null && appTask.getTaskInfo() != null && appTask.getTaskInfo().baseActivity != null && activity.getClass().getName().equals(appTask.getTaskInfo().baseActivity.getClassName())) {
            String scheme = getScheme(appTask.getTaskInfo().baseIntent);
            updateAppStartInfo(scheme, bi.isEmpty(scheme));
            updateRealAppStartInfo();
        }
    }

    public static void logAppHotStart(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65549, null, j) == null) {
            initRestartTimes();
            int i = 2;
            StatisticItem addParam = new StatisticItem(KEY_APP_START).addParam("obj_type", 2);
            if (restartTimes < 1) {
                i = 1;
            }
            TiebaStatic.log(addParam.addParam("obj_source", i).addParam(TiebaStatic.Params.OBJ_PARAM2, j));
        }
    }

    public static void logDebugStatistic(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, null, i) == null) {
            initRestartTimes();
            StatisticItem addParam = new StatisticItem(KEY_DEBUG).addParam("obj_type", i);
            int i2 = 1;
            if (restartTimes >= 1) {
                i2 = 2;
            }
            TiebaStatic.log(addParam.addParam("obj_source", i2).addParam(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis()));
        }
    }

    public static void logClientDau(String str, boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, null, str, z) == null) {
            initRestartTimes();
            StatisticItem statisticItem = new StatisticItem(KEY_CLIENT_DAU);
            int i3 = 2;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            StatisticItem addParam = statisticItem.addParam("obj_type", i);
            if (restartTimes < 1) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            StatisticItem addParam2 = addParam.addParam("obj_source", i2);
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                i3 = 1;
            }
            TiebaStatic.log(addParam2.addParam("obj_param1", i3).addParam(TiebaStatic.Params.OBJ_PARAM2, str));
        }
    }

    public static void updateAppStartInfoByInfo(AppLaunchInfoFetcher.Type type, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65560, null, type, intent) != null) || realStartType < 99) {
            return;
        }
        if (type == AppLaunchInfoFetcher.Type.BROADCAST) {
            startType = 98;
            startScheme = "CallReceiver";
        } else if (type == AppLaunchInfoFetcher.Type.SERVICE) {
            startType = 98;
            startScheme = "CallService";
        } else if (type == AppLaunchInfoFetcher.Type.ACTIVITY) {
            if (intent != null) {
                String dataString = intent.getDataString();
                updateAppStartInfo(dataString, bi.isEmpty(dataString));
            } else {
                updateAppStartInfoForException("intent=null", 100);
            }
        } else {
            startType = 101;
            startScheme = "START_TYPE_FOR_UNKNOWN";
        }
        updateRealAppStartInfo();
    }

    public static void logRecall(String str, SharedPreferences.Editor editor) {
        Set<String> stringSet;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65557, null, str, editor) != null) || (stringSet = growthFunnelSp.getStringSet(str, null)) == null) {
            return;
        }
        for (String str2 : stringSet) {
            String[] split = str2.split("_");
            if (split != null) {
                if (split.length == 3) {
                    TiebaStatic.log(new StatisticItem(str).addParam("obj_type", split[0]).addParam("obj_source", split[1]).addParam(TiebaStatic.Params.OBJ_PARAM3, split[2]));
                } else if (split.length == 4) {
                    TiebaStatic.log(new StatisticItem(str).addParam("obj_type", split[0]).addParam("obj_source", split[1]).addParam(TiebaStatic.Params.OBJ_PARAM3, split[2]).addParam(TiebaStatic.Params.OBJ_PARAM4, split[3]));
                }
            }
        }
        editor.remove(str).apply();
    }

    public static void notifyFlutterStartType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("start_type", realStartType + "");
            hashMap.put("start_scheme", getRealStartScheme());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("uniqueKey", "kTBCUpdateLaunchTypeNotification");
            hashMap2.put("data", hashMap);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921542, hashMap2));
        }
    }

    public static void updateAppStartInfo(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65559, null, str, z) == null) {
            startScheme = str;
            startType = z ? 1 : 0;
        }
    }

    @Deprecated
    public static void updateAppStartInfoForException(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65562, null, str, i) == null) {
            int i2 = realStartType;
            if (i2 == 99 || i2 == 100) {
                startType = i;
                startScheme = str;
                updateRealAppStartInfo();
            }
        }
    }
}
