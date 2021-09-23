package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.pushservice.frequency.GetFrequencyListener;
import com.baidu.android.pushservice.frequency.GetNoDisturbListener;
import com.baidu.android.pushservice.frequency.UploadDataListener;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.m;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"WorldReadableFiles"})
/* loaded from: classes4.dex */
public class PushManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PushManager";
    public transient /* synthetic */ FieldHolder $fh;

    public PushManager() {
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

    public static void bindPush(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) || m.i(context)) {
            return;
        }
        f.a(context, 0, str, true);
    }

    public static void clearIconBadge(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            com.baidu.android.pushservice.f.c.a().a(context);
        }
    }

    public static void closeNoDisturb(Context context, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, context, uploadDataListener) == null) && f.a(context, uploadDataListener)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("do_not_disturb", com.baidu.android.pushservice.frequency.b.a().a(-1, -1));
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void createNotificationChannel(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2) == null) && m.p(context)) {
            com.baidu.android.pushservice.j.h.a(context, str, str2);
        }
    }

    public static void delTags(Context context, List<String> list) {
        Intent c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, list) == null) || list == null || list.size() == 0 || (c2 = f.c(context)) == null) {
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
        c2.putExtra("method", "method_del_tags");
        c2.putExtra(CommandMessage.TYPE_TAGS, str + PreferencesUtil.RIGHT_MOUNT);
        com.baidu.android.pushservice.g.a.a("PushManager", "a delTags intent send", context.getApplicationContext());
        f.b(context, c2);
    }

    public static void deleteNotificationChannel(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str) == null) && m.p(context)) {
            com.baidu.android.pushservice.j.h.a(context, str);
        }
    }

    public static void disableAlarm(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, context) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        context.sendBroadcast(f.b(context));
    }

    public static void enableHuaweiProxy(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, context, z) == null) {
            PushSettings.f36908c = z ? 1 : 0;
            com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", z ? 1 : 0);
        }
    }

    public static void enableMeizuProxy(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f.f37274e = str;
        com.baidu.android.pushservice.j.i.a(context, "BD_MEIZU_PROXY_APPID_KEY", str);
        f.f37275f = str2;
        com.baidu.android.pushservice.j.i.a(context, "BD_MEIZU_PROXY_APPKEY_KEY", str2);
        PushSettings.f36909d = z ? 1 : 0;
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", z ? 1 : 0);
    }

    public static void enableOppoProxy(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f.f37276g = str;
        com.baidu.android.pushservice.j.i.a(context, "BD_OPPO_PROXY_APPKEY_KEY", str);
        f.f37277h = str2;
        com.baidu.android.pushservice.j.i.a(context, "BD_OPPO_PROXY_APPSECRET_KEY", str2);
        PushSettings.f36910e = z ? 1 : 0;
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", z ? 1 : 0);
    }

    public static void enableVivoProxy(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, context, z) == null) {
            PushSettings.f36911f = z ? 1 : 0;
            com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushSettings.vi_proxy_mode", z ? 1 : 0);
        }
    }

    public static void enableXiaomiProxy(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) {
            if (!TextUtils.isEmpty(str)) {
                f.f37272c = str;
                com.baidu.android.pushservice.j.i.a(context, "BD_PROXY_APPID_KEY", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                f.f37273d = str2;
                com.baidu.android.pushservice.j.i.a(context, "BD_PROXY_APPKEY_KEY", str2);
            }
            PushSettings.f36907b = z ? 1 : 0;
            com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", z ? 1 : 0);
        }
    }

    public static int getBindType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (m.i(context)) {
                if (com.baidu.android.pushservice.b.d.l(context)) {
                    return 2;
                }
                if (com.baidu.android.pushservice.b.d.k(context)) {
                    return 3;
                }
                if (com.baidu.android.pushservice.b.d.j(context)) {
                    return 4;
                }
                if (com.baidu.android.pushservice.b.d.m(context)) {
                    return 5;
                }
                return com.baidu.android.pushservice.b.d.n(context) ? 6 : 1;
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
        if (!(interceptable == null || interceptable.invokeLLL(65552, null, context, str, str2) == null) || f.m(context) || str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.g.a.a("PushManager", "PassThroughMessageClick  : " + packageName, context.getApplicationContext());
            intent.putExtra("app_id", str2);
            intent.putExtra("msg_id", str);
            intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.CLICK");
            intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
            context.startService(intent);
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.b("PushManager", "error " + e2.getMessage(), context.getApplicationContext());
        }
    }

    public static boolean isPushEnabled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (f.m(context)) {
                return false;
            }
            return !m.b(context);
        }
        return invokeL.booleanValue;
    }

    public static void listTags(Context context) {
        Intent c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, context) == null) || (c2 = f.c(context)) == null) {
            return;
        }
        c2.putExtra("method", "method_listtags");
        com.baidu.android.pushservice.g.a.a("PushManager", "a listTags intent send", context.getApplicationContext());
        f.b(context, c2);
    }

    public static void reStartWork(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, null, context) == null) && m.i(context) && isPushEnabled(context)) {
            new Handler(context.getMainLooper()).postDelayed(new Runnable(context) { // from class: com.baidu.android.pushservice.PushManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f36863a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36863a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        l.a(this.f36863a, null);
                    }
                }
            }, com.baidu.android.pushservice.b.d.h() * 1000);
        }
    }

    public static void requestOppoNotification(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, context) == null) && m.e() && com.baidu.android.pushservice.b.d.p(context)) {
            m.a();
        }
    }

    public static void resumeWork(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, null, context) == null) || f.m(context)) {
            return;
        }
        a.a(context, true);
        m.a(context, true, true);
        f.b(context, 0);
        l.b(context);
    }

    public static void sendPushMsgAck(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65558, null, context, str, i2) == null) {
            m.a(context, str, i2);
        }
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65559, null, context, pushNotificationBuilder) == null) || f.m(context)) {
            return;
        }
        d.a(context, pushNotificationBuilder);
    }

    public static void setNoDisturbMode(Context context, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || f.m(context)) {
            return;
        }
        if (i2 < 0 || i2 > 23 || i4 < 0 || i4 > 23) {
            com.baidu.android.pushservice.g.a.a("PushManager", "setNoDisturbMode hour parameters illegal!", context.getApplicationContext());
        } else if (i3 < 0 || i3 > 59 || i5 < 0 || i5 > 59) {
            com.baidu.android.pushservice.g.a.a("PushManager", "setNoDisturbMode minute parameters illegal!", context.getApplicationContext());
        } else {
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.g.a.a("PushManager", "PushManager setNoDisturbMode package name: " + packageName, context.getApplicationContext());
            com.baidu.android.pushservice.c.a.a(context, packageName, i2, i3, i4, i5);
        }
    }

    public static void setNoDisturbOnline(Context context, int i2, int i3, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), uploadDataListener}) == null) && f.a(context, uploadDataListener)) {
            if (i2 > 86400 || i3 > 86400 || i2 < 0 || i3 < 0) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("do_not_disturb", com.baidu.android.pushservice.frequency.b.a().a(i2, i3));
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void setNotificationBuilder(Context context, int i2, PushNotificationBuilder pushNotificationBuilder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65562, null, context, i2, pushNotificationBuilder) == null) || f.m(context)) {
            return;
        }
        if (i2 < 1 || i2 > 1000) {
            com.baidu.android.pushservice.g.a.b("PushManager", "set notification builder error, id is illegal !", context.getApplicationContext());
        } else {
            d.a(context, i2, pushNotificationBuilder);
        }
    }

    public static void setPushBackStatus(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65563, null, context, z) == null) || f.m(context)) {
            return;
        }
        if (!z) {
            if (com.baidu.android.pushservice.b.d.d(context)) {
                a.a(context, true);
            }
            reStartWork(context);
        } else if ((!com.baidu.android.pushservice.b.d.q(context) || com.baidu.android.pushservice.b.d.c(context)) && com.baidu.android.pushservice.b.d.d(context)) {
            a.a(context, false);
            m.d(context);
            com.baidu.android.pushservice.job.a.b(context);
            f.n(context);
        }
    }

    public static void setPushFrequency(Context context, int i2, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65564, null, context, i2, uploadDataListener) == null) && f.a(context, uploadDataListener)) {
            if (i2 < 1 || i2 > 3) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PushConstants.EXTRA_PUSH_FREQ, Integer.valueOf(i2));
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void setTags(Context context, List<String> list) {
        Intent c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65565, null, context, list) == null) || list == null || list.size() == 0 || (c2 = f.c(context)) == null) {
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
        c2.putExtra("method", "method_set_tags");
        c2.putExtra(CommandMessage.TYPE_TAGS, str + PreferencesUtil.RIGHT_MOUNT);
        com.baidu.android.pushservice.g.a.a("PushManager", "a setTags intent send ", context.getApplicationContext());
        f.b(context, c2);
    }

    public static void startWork(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65566, null, context, i2, str) == null) || f.m(context)) {
            return;
        }
        f.f37270a = i2;
        f.f37271b = str;
        h.b(context);
        String f2 = m.f(context, str);
        if (TextUtils.isEmpty(f2)) {
            f2 = "unKnow error";
        }
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.CHECK_SDK", f2);
        com.baidu.android.pushservice.g.a.a("PushManager", "startWork from " + context.getPackageName() + " checkResult: " + f2, context.getApplicationContext());
        m.a("startWork from " + context.getPackageName() + " checkResult: " + f2, context);
        if ((TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", f2) || !PushSettings.e(context)) && i2 == 0) {
            f.a(context, i2, f.f37271b);
        } else {
            f.c(context, 10101, f2);
        }
        m.k(context);
    }

    public static void stopWork(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, null, context) == null) || f.m(context)) {
            return;
        }
        com.baidu.android.pushservice.g.a.a("PushManager", "stopWork from" + context.getPackageName(), context.getApplicationContext());
        m.a("stopWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        f.g(context);
        a.a(context, false);
        m.a(context, true, false);
        m.d(context);
        com.baidu.android.pushservice.job.a.b(context);
        f.n(context);
    }

    public static void tokenBind(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65568, null, context, str) == null) || context == null || m.i(context) || TextUtils.isEmpty(str)) {
            return;
        }
        f.b(context, 0, str);
    }

    public static void uploadBduss(Context context, int i2, String str, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65569, null, context, i2, str, uploadDataListener) == null) && f.a(context, uploadDataListener)) {
            if (i2 < 0 || i2 > 2 || TextUtils.isEmpty(str)) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PushConstants.EXTRA_BDUSS_ACTION, Integer.valueOf(i2));
            hashMap.put("bduss", str);
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void uploadClickData(Context context, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65570, null, context, i2, str, str2) == null) || context == null) {
            return;
        }
        com.baidu.android.pushservice.frequency.b.a().a(context.getApplicationContext(), true, i2, str, str2);
    }

    public static void uploadData(Context context, HashMap<String, Object> hashMap, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65571, null, context, hashMap, uploadDataListener) == null) && f.a(context, uploadDataListener)) {
            if (hashMap == null || hashMap.size() == 0) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
            } else {
                com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
            }
        }
    }

    public static void uploadLocation(Context context, String str, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65572, null, context, str, uploadDataListener) == null) && f.a(context, uploadDataListener)) {
            if (TextUtils.isEmpty(str)) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("location", str);
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void uploadNotifyStatus(Context context, int i2, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65573, null, context, i2, uploadDataListener) == null) && f.a(context, uploadDataListener)) {
            if (i2 < 0 || i2 > 2) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PushConstants.EXTRA_APP_NOTIFY_STATUS, Integer.valueOf(i2));
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }
}
