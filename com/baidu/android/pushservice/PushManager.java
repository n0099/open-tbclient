package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.pushservice.frequency.GetFrequencyListener;
import com.baidu.android.pushservice.frequency.GetNoDisturbListener;
import com.baidu.android.pushservice.frequency.UploadDataListener;
import com.baidu.android.pushservice.httpapi.TokenBindListener;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.i.m;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"WorldReadableFiles"})
/* loaded from: classes.dex */
public class PushManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PushManager";
    public transient /* synthetic */ FieldHolder $fh;

    public PushManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void bindPush(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) || m.i(context)) {
            return;
        }
        e.a(context, 0, str, true);
    }

    public static void clearIconBadge(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            com.baidu.android.pushservice.e.c.a().a(context);
        }
    }

    public static void closeNoDisturb(Context context, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, context, uploadDataListener) == null) && e.a(context, uploadDataListener)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("do_not_disturb", com.baidu.android.pushservice.frequency.b.a().a(-1, -1));
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void createNotificationChannel(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2) == null) && m.B(context)) {
            com.baidu.android.pushservice.i.h.a(context, str, str2);
        }
    }

    public static void delTags(Context context, List<String> list) {
        Intent c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, context, list) == null) || list == null || list.size() == 0 || (c = e.c(context)) == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        String str = PreferencesUtil.LEFT_MOUNT;
        while (it.hasNext()) {
            str = ((str + "\"") + it.next()) + "\",";
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        c.putExtra("method", "method_del_tags");
        c.putExtra("tags", str + PreferencesUtil.RIGHT_MOUNT);
        com.baidu.android.pushservice.f.a.a(TAG, "a delTags intent send", context.getApplicationContext());
        e.b(context, c);
    }

    public static void deleteNotificationChannel(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) && m.B(context)) {
            com.baidu.android.pushservice.i.h.a(context, str);
        }
    }

    public static void disableAlarm(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, context) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        context.sendBroadcast(e.b(context));
    }

    public static void enableHuaweiProxy(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, context, z) == null) {
            PushSettings.c = z ? 1 : 0;
            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", z ? 1 : 0);
        }
    }

    public static void enableMeizuProxy(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        e.e = str;
        com.baidu.android.pushservice.i.i.a(context, "BD_MEIZU_PROXY_APPID_KEY", str);
        e.f = str2;
        com.baidu.android.pushservice.i.i.a(context, "BD_MEIZU_PROXY_APPKEY_KEY", str2);
        PushSettings.d = z ? 1 : 0;
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", z ? 1 : 0);
    }

    public static void enableOppoProxy(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        e.g = str;
        com.baidu.android.pushservice.i.i.a(context, "BD_OPPO_PROXY_APPKEY_KEY", str);
        e.h = str2;
        com.baidu.android.pushservice.i.i.a(context, "BD_OPPO_PROXY_APPSECRET_KEY", str2);
        PushSettings.e = z ? 1 : 0;
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", z ? 1 : 0);
    }

    public static void enableVivoProxy(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, context, z) == null) {
            PushSettings.f = z ? 1 : 0;
            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.vi_proxy_mode", z ? 1 : 0);
        }
    }

    public static void enableXiaomiProxy(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) {
            if (!TextUtils.isEmpty(str)) {
                e.c = str;
                com.baidu.android.pushservice.i.i.a(context, "BD_PROXY_APPID_KEY", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                e.d = str2;
                com.baidu.android.pushservice.i.i.a(context, "BD_PROXY_APPKEY_KEY", str2);
            }
            PushSettings.b = z ? 1 : 0;
            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", z ? 1 : 0);
        }
    }

    public static int getBindType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (m.i(context)) {
                if (com.baidu.android.pushservice.b.d.m(context)) {
                    return 2;
                }
                if (com.baidu.android.pushservice.b.d.l(context)) {
                    return 3;
                }
                if (com.baidu.android.pushservice.b.d.k(context)) {
                    return 4;
                }
                if (com.baidu.android.pushservice.b.d.n(context)) {
                    return 5;
                }
                return com.baidu.android.pushservice.b.d.o(context) ? 6 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void getNoDisturbOnline(Context context, GetNoDisturbListener getNoDisturbListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, context, getNoDisturbListener) == null) || getNoDisturbListener == null) {
            return;
        }
        if (context == null) {
            getNoDisturbListener.onResult(IMConstants.ERROR_GROUP_DISBAND, 0, 0);
        } else {
            com.baidu.android.pushservice.frequency.b.a().a(context, "do_not_disturb", getNoDisturbListener);
        }
    }

    public static void getPushFrequency(Context context, GetFrequencyListener getFrequencyListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, context, getFrequencyListener) == null) || getFrequencyListener == null || context == null) {
            return;
        }
        com.baidu.android.pushservice.frequency.b.a().a(context, PushConstants.EXTRA_PUSH_FREQ, getFrequencyListener);
    }

    public static void insertPassThroughMessageClick(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65552, null, context, str, str2) == null) || e.n(context) || str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.f.a.a(TAG, "PassThroughMessageClick  : " + packageName, context.getApplicationContext());
            intent.putExtra("app_id", str2);
            intent.putExtra("msg_id", str);
            intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.CLICK");
            intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
            context.startService(intent);
        } catch (Exception e) {
            com.baidu.android.pushservice.f.a.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static boolean isPushEnabled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (e.n(context)) {
                return false;
            }
            return !m.b(context.getApplicationContext());
        }
        return invokeL.booleanValue;
    }

    public static void listTags(Context context) {
        Intent c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, context) == null) || (c = e.c(context)) == null) {
            return;
        }
        c.putExtra("method", "method_listtags");
        com.baidu.android.pushservice.f.a.a(TAG, "a listTags intent send", context.getApplicationContext());
        e.b(context, c);
    }

    public static void reStartWork(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, context) == null) {
            e.a(0);
            if (m.i(context) && isPushEnabled(context)) {
                new Handler(context.getMainLooper()).postDelayed(new Runnable(context) { // from class: com.baidu.android.pushservice.PushManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = context;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            l.a(this.a, (Intent) null, 0);
                        }
                    }
                }, com.baidu.android.pushservice.b.d.h() * 1000);
            }
        }
    }

    public static void requestOppoNotification(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, context) == null) && m.p(context) && com.baidu.android.pushservice.b.d.q(context)) {
            m.a();
        }
    }

    public static void resumeWork(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, null, context) == null) || e.n(context)) {
            return;
        }
        a.a(context, true);
        m.a(context, true, true);
        e.c(context, 0);
        l.a(context, 0);
    }

    public static void resumeWork(Context context, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65558, null, context, i) == null) || e.n(context)) {
            return;
        }
        a.a(context, true);
        e.d(context, i);
        l.a(context, i);
    }

    public static void sendPushMsgAck(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65559, null, context, str, i) == null) {
            m.a(context, str, i);
        }
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65560, null, context, pushNotificationBuilder) == null) || e.n(context)) {
            return;
        }
        NotificationBuilderManager.a(context, pushNotificationBuilder);
    }

    public static void setNoDisturbMode(Context context, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || e.n(context)) {
            return;
        }
        if (i < 0 || i > 23 || i3 < 0 || i3 > 23) {
            com.baidu.android.pushservice.f.a.a(TAG, "setNoDisturbMode hour parameters illegal!", context.getApplicationContext());
        } else if (i2 < 0 || i2 > 59 || i4 < 0 || i4 > 59) {
            com.baidu.android.pushservice.f.a.a(TAG, "setNoDisturbMode minute parameters illegal!", context.getApplicationContext());
        } else {
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.f.a.a(TAG, "PushManager setNoDisturbMode package name: " + packageName, context.getApplicationContext());
            com.baidu.android.pushservice.c.a.a(context, packageName, i, i2, i3, i4);
        }
    }

    public static void setNoDisturbOnline(Context context, int i, int i2, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), uploadDataListener}) == null) && e.a(context, uploadDataListener)) {
            if (i > 86400 || i2 > 86400 || i < 0 || i2 < 0) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("do_not_disturb", com.baidu.android.pushservice.frequency.b.a().a(i, i2));
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void setNotificationBuilder(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65563, null, context, i, pushNotificationBuilder) == null) || e.n(context)) {
            return;
        }
        if (i < 1 || i > 1000) {
            com.baidu.android.pushservice.f.a.b(TAG, "set notification builder error, id is illegal !", context.getApplicationContext());
        } else {
            NotificationBuilderManager.a(context, i, pushNotificationBuilder);
        }
    }

    public static void setPushBackStatus(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65564, null, context, z) == null) {
            com.baidu.android.pushservice.b.d.d = 1;
            if (e.n(context)) {
                return;
            }
            if (!z) {
                if (com.baidu.android.pushservice.b.d.d(context)) {
                    a.a(context, true);
                }
                reStartWork(context);
            } else if ((!com.baidu.android.pushservice.b.d.r(context) || com.baidu.android.pushservice.b.d.c(context)) && com.baidu.android.pushservice.b.d.d(context)) {
                a.a(context, false);
                m.d(context);
                com.baidu.android.pushservice.job.a.b(context);
                e.o(context);
            }
        }
    }

    public static void setPushFrequency(Context context, int i, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65565, null, context, i, uploadDataListener) == null) && e.a(context, uploadDataListener)) {
            if (i < 1 || i > 7) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PushConstants.EXTRA_PUSH_FREQ, Integer.valueOf(i));
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void setPushLaunchTaskLevel(int i, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65566, null, i, context) == null) || context == null || com.baidu.android.pushservice.i.i.b(context, "key_push_launch_task_level", 0) == i) {
            return;
        }
        com.baidu.android.pushservice.i.i.a(context, "key_push_launch_task_level", i);
        if (i != 1) {
            e.b(context, 1);
            resumeWork(context);
            return;
        }
        e.b(context, 2);
        com.baidu.android.pushservice.job.a.b(context);
        context.sendBroadcast(e.b(context));
    }

    public static void setTags(Context context, List<String> list) {
        Intent c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65567, null, context, list) == null) || list == null || list.size() == 0 || (c = e.c(context)) == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        String str = PreferencesUtil.LEFT_MOUNT;
        while (it.hasNext()) {
            str = ((str + "\"") + it.next()) + "\",";
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        c.putExtra("method", "method_set_tags");
        c.putExtra("tags", str + PreferencesUtil.RIGHT_MOUNT);
        com.baidu.android.pushservice.f.a.a(TAG, "a setTags intent send ", context.getApplicationContext());
        e.b(context, c);
    }

    public static void startWork(Context context, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65568, null, context, i, str) == null) || e.n(context)) {
            return;
        }
        e.a = i;
        e.b = str;
        e.a(0);
        g.b(context);
        String f = m.f(context, str);
        if (TextUtils.isEmpty(f)) {
            f = "unKnow error";
        }
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.CHECK_SDK", f);
        com.baidu.android.pushservice.f.a.a(TAG, "startWork from " + context.getPackageName() + " checkResult: " + f, context.getApplicationContext());
        if ((TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", f) || !PushSettings.e(context)) && i == 0) {
            e.a(context, i, e.b);
        } else {
            if (i != 0) {
                Log.e("BDPushSDK-PushManager", "Wrong LOGIN TYPE, Please use LOGIN_TYPE_API_KEY !");
            }
            e.c(context, 10101, f);
        }
        m.k(context);
    }

    public static void startWorkWithSource(Context context, int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{context, Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            if (j.a(context.getApplicationContext()).e()) {
                l.a(context.getApplicationContext(), (Intent) null, i2);
            } else {
                e.a(i2);
            }
            startWork(context, i, str);
        }
    }

    public static void stopWork(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65570, null, context) == null) || e.n(context)) {
            return;
        }
        com.baidu.android.pushservice.f.a.a(TAG, "stopWork from" + context.getPackageName(), context.getApplicationContext());
        e.g(context);
        a.a(context, false);
        m.a(context, true, false);
        m.d(context);
        com.baidu.android.pushservice.job.a.b(context);
        e.o(context);
    }

    public static void tokenBind(Context context, String str, int i, String str2, TokenBindListener tokenBindListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65571, null, new Object[]{context, str, Integer.valueOf(i), str2, tokenBindListener}) == null) || context == null || m.i(context) || TextUtils.isEmpty(str)) {
            return;
        }
        if (tokenBindListener != null) {
            tokenBindListener.onResult(0, "sdk_bind");
        }
        i.a(context).a(i, str2, tokenBindListener);
        e.b(context, 0, str);
    }

    public static void uploadBduss(Context context, int i, String str, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65572, null, context, i, str, uploadDataListener) == null) && e.a(context, uploadDataListener)) {
            if (i < 0 || i > 2 || TextUtils.isEmpty(str)) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PushConstants.EXTRA_BDUSS_ACTION, Integer.valueOf(i));
            hashMap.put("bduss", str);
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void uploadClickData(Context context, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65573, null, context, i, str, str2) == null) || context == null) {
            return;
        }
        com.baidu.android.pushservice.frequency.b.a().a(context.getApplicationContext(), true, i, str, str2);
    }

    public static void uploadData(Context context, HashMap<String, Object> hashMap, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65574, null, context, hashMap, uploadDataListener) == null) && e.a(context, uploadDataListener)) {
            if (hashMap == null || hashMap.size() == 0) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
            } else {
                com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
            }
        }
    }

    public static void uploadLocation(Context context, String str, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65575, null, context, str, uploadDataListener) == null) && e.a(context, uploadDataListener)) {
            if (TextUtils.isEmpty(str)) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("location", str);
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void uploadNotifyStatus(Context context, int i, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65576, null, context, i, uploadDataListener) == null) && e.a(context, uploadDataListener)) {
            if (i < 0 || i > 2) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PushConstants.EXTRA_APP_NOTIFY_STATUS, Integer.valueOf(i));
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }
}
