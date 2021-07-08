package com.baidu.android.pushservice.j;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.down.utils.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.callback.PushCallback;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"WorldReadableFiles"})
/* loaded from: classes.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f3490a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f3491b;

    /* renamed from: c  reason: collision with root package name */
    public static int f3492c = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676869867, "Lcom/baidu/android/pushservice/j/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-676869867, "Lcom/baidu/android/pushservice/j/m;");
                return;
            }
        }
        f3491b = new String[]{"android.permission.INTERNET", DefaultConnectivityMonitorFactory.NETWORK_PERMISSION};
    }

    public static boolean A(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f3492c == -1) {
                f3492c = !k(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) ? 1 : 0;
            }
            return f3492c == 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean B(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                String str = Build.DISPLAY;
                if (TextUtils.isEmpty(str) || !str.contains("VIBEUI_V3.1_1614_5.294.1_ST_K50-T5")) {
                    String str2 = Build.MODEL;
                    if (TextUtils.isEmpty(str2)) {
                        return false;
                    }
                    if (!str2.contains("Lenovo K50-t5") && !str2.contains("Lenovo_K50-t5") && !str2.contains("Lenovo X3c50")) {
                        if (!str2.contains("Lenovo_X3c50")) {
                            return false;
                        }
                    }
                    return true;
                }
                return true;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int a(Context context, Intent intent, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, intent, str, str2)) == null) {
            intent.setFlags(32);
            if (!TextUtils.isEmpty(str)) {
                intent.setAction(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            return new c(context, intent, str2).b().a();
        }
        return invokeLLLL.intValue;
    }

    public static PackageInfo a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getPackageInfo(str, 0);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (PackageInfo) invokeLL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            PackageInfo a2 = a(context, context.getPackageName());
            return a2 != null ? a2.versionName : "";
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, InputStream inputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, inputStream)) == null) {
            if (inputStream == null) {
                return null;
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (IOException unused) {
                    com.baidu.android.pushservice.e.c.a(context, inputStream, inputStreamReader, bufferedReader);
                } catch (Throwable th) {
                    com.baidu.android.pushservice.e.c.a(context, inputStream, inputStreamReader, bufferedReader);
                    throw th;
                }
            }
            com.baidu.android.pushservice.e.c.a(context, inputStream, inputStreamReader, bufferedReader);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, th)) == null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
            th.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            PushManager.getInstance().requestNotificationPermission();
        }
    }

    public static void a(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65545, null, context, j) == null) {
            Context applicationContext = context.getApplicationContext();
            Intent a2 = l.a(applicationContext);
            String packageName = applicationContext.getPackageName();
            String b2 = b(applicationContext, packageName, a2.getAction());
            if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(b2)) {
                a2.setClassName(packageName, b2);
            }
            a(applicationContext, a2, j);
        }
    }

    public static void a(Context context, Intent intent, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, intent, Long.valueOf(j)}) == null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, Label.FORWARD_REFERENCE_TYPE_SHORT);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            alarmManager.cancel(broadcast);
            alarmManager.set(3, SystemClock.elapsedRealtime() + j, broadcast);
        }
    }

    public static void a(Context context, Intent intent, String str) {
        String action;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, context, intent, str) == null) || context == null || intent == null || str == null || (action = intent.getAction()) == null || !action.startsWith("com.baidu.android.pushservice.action")) {
            return;
        }
        String b2 = b(context, str, action);
        if (context.getPackageName().equals(str) && !TextUtils.isEmpty(b2)) {
            a(context, str, b2, intent);
            return;
        }
        context.sendBroadcast(intent);
        if (action.equals("com.baidu.android.pushservice.action.notification.SHOW")) {
            String stringExtra = intent.getStringExtra("message_id");
            a(stringExtra + " sendBroadcast to recevier=" + b2, context);
        }
    }

    public static void a(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65548, null, context, str, i2) == null) || context == null) {
            return;
        }
        Intent a2 = l.a(context);
        a2.putExtra("method", "com.baidu.android.pushservice.action.SEND_ACK");
        a2.putExtra("bd.cross.request.RESULT_CODE", i2);
        a2.putExtra("message_id", str);
        a2.setPackage(context.getPackageName());
        String b2 = b(context, context.getPackageName(), "com.baidu.android.pushservice.action.METHOD");
        if (!TextUtils.isEmpty(b2)) {
            a2.setClassName(context.getPackageName(), b2);
        }
        context.sendBroadcast(a2);
    }

    public static void a(Context context, String str, String str2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, context, str, str2, intent) == null) {
            try {
                Class<?> cls = Class.forName(str2);
                Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                Method method = cls.getMethod("onReceive", Context.class, Intent.class);
                intent.setClassName(str, str2);
                method.invoke(newInstance, context.getApplicationContext(), intent);
                String action = intent.getAction();
                if (TextUtils.isEmpty(action) || !action.equals("com.baidu.android.pushservice.action.notification.SHOW")) {
                    return;
                }
                String stringExtra = intent.getStringExtra("message_id");
                a(stringExtra + " reflectrecevier=" + str2, context);
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public static void a(Context context, String str, String str2, PushCallback pushCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65550, null, context, str, str2, pushCallback) == null) || context == null) {
            return;
        }
        try {
            PushManager.getInstance().register(context.getApplicationContext(), str, str2, pushCallback);
        } catch (Exception unused) {
        }
    }

    public static synchronized void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLZ(65551, null, context, z) != null) {
            return;
        }
        synchronized (m.class) {
            try {
                f3490a = z ? 1 : 0;
                SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
                edit.putBoolean("bind_status", z);
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            com.baidu.android.pushservice.g.a.a("Utility", context.getPackageName() + ": updateServiceInfo isForce = " + z + ",isSend = " + z2, context.getApplicationContext());
            if (z) {
                com.baidu.android.pushservice.c.c.a(context, 0L);
                com.baidu.android.pushservice.c.c.b(context, com.baidu.android.pushservice.a.a());
            }
            if (z2) {
                new Handler(context.getMainLooper()).postDelayed(new Runnable(context) { // from class: com.baidu.android.pushservice.j.m.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f3493a;

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
                        this.f3493a = context;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            l.b(this.f3493a);
                        }
                    }
                }, com.baidu.android.pushservice.b.d.h() * 1000);
            }
        }
    }

    public static void a(Intent intent, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, intent, context) == null) {
            a(context, context.getPackageName(), b(context, context.getPackageName(), "com.baidu.android.pushservice.action.MESSAGE"), intent);
        }
    }

    public static synchronized void a(String str, Context context) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, str, context) == null) {
            synchronized (m.class) {
                if (A(context)) {
                    if (PushSettings.o(context)) {
                        FileWriter fileWriter = null;
                        try {
                            String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " " + str + "\n\r";
                            String absolutePath = context.getExternalFilesDir("").getAbsolutePath();
                            File file = new File(absolutePath, "baidu/pushservice/files");
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                            Date date = new Date();
                            File file2 = new File(absolutePath, "baidu/pushservice/files/msg" + simpleDateFormat.format(date) + ".log");
                            if (!file2.exists()) {
                                for (File file3 : file.listFiles()) {
                                    String name = file3.getName();
                                    if (name.startsWith("msg") && name.length() > 0 && ((int) Math.abs((simpleDateFormat.parse(name.substring(3, 11)).getTime() - date.getTime()) / 86400000)) >= 7) {
                                        file3.delete();
                                    }
                                }
                                file2.createNewFile();
                            }
                            if (file2.exists()) {
                                FileWriter fileWriter2 = new FileWriter(file2, true);
                                try {
                                    fileWriter2.write(str2);
                                    fileWriter = fileWriter2;
                                } catch (Throwable th) {
                                    th = th;
                                    fileWriter = fileWriter2;
                                    new b.c(context).a(Log.getStackTraceString(th)).a();
                                    com.baidu.android.pushservice.e.c.a(context, fileWriter);
                                }
                            }
                            com.baidu.android.pushservice.e.c.a(context, fileWriter);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }
        }
    }

    public static boolean a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65555, null, i2, i3, i4, i5)) == null) {
            int i6 = Calendar.getInstance(Locale.CHINA).get(11);
            int i7 = Calendar.getInstance(Locale.CHINA).get(12);
            if (i2 < i4) {
                if (i2 >= i6 || i6 >= i4) {
                    if (i6 != i2 || i7 < i3) {
                        return i6 == i4 && i7 <= i5;
                    }
                    return true;
                }
                return true;
            } else if (i2 <= i4) {
                return i2 == i6 && i7 >= i3 && i5 >= i7;
            } else if ((i6 <= i2 || i6 >= 24) && i6 >= i4) {
                if (i6 != i2 || i7 < i3) {
                    return i6 == i4 && i7 <= i5;
                }
                return true;
            } else {
                return true;
            }
        }
        return invokeIIII.booleanValue;
    }

    public static boolean a(Context context, PackageManager packageManager, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, context, packageManager, strArr)) == null) {
            if (b() && PushSettings.g(context)) {
                try {
                    String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
                    if (!a(str, strArr)) {
                        com.baidu.android.pushservice.g.a.b("Utility", "the permission [ " + str + " ] for xiaomi proxy need is not exist, please check!", context);
                        return true;
                    }
                    PermissionInfo[] permissionInfoArr = packageManager.getPackageInfo(context.getPackageName(), 4096).permissions;
                    if (permissionInfoArr != null && permissionInfoArr.length > 0) {
                        boolean z = false;
                        for (PermissionInfo permissionInfo : permissionInfoArr) {
                            if (permissionInfo.name.equals(str)) {
                                if (permissionInfo.protectionLevel == 2) {
                                    z = true;
                                } else {
                                    Log.e("BDPushSDK-Utility", "xiaomi proxy permission is not signature,  please check!");
                                }
                            }
                        }
                        if (!z) {
                            return true;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(Context context, PublicMsg publicMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, publicMsg)) == null) {
            return com.baidu.android.pushservice.c.c.a(context, new com.baidu.android.pushservice.c.f(publicMsg.mMsgId, f.a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), false), publicMsg.mAppId));
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65558, null, context, str, str2)) == null) {
            try {
                packageManager = context.getPackageManager();
            } catch (Exception unused) {
                applicationInfo = null;
            }
            if (packageManager == null) {
                return false;
            }
            applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(str2)) {
                return false;
            }
            return applicationInfo.metaData.getBoolean(str2);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{context, str, str2, str3, str4, str5})) == null) {
            String d2 = PushSettings.d(context);
            if (!TextUtils.isEmpty(d2)) {
                str2 = d2;
            }
            if (str == null) {
                str = "";
            }
            String str6 = str2 + str + str3 + str4 + str5;
            if (TextUtils.isEmpty(str6)) {
                return false;
            }
            String a2 = f.a(str6.getBytes(), false);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            String c2 = com.baidu.android.pushservice.c.c.c(context, context.getPackageName(), a2);
            return !TextUtils.isEmpty(c2) && c2.equals(a2);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(Context context, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{context, str, str2, Boolean.valueOf(z)})) == null) {
            Intent intent = new Intent(str);
            intent.setPackage(context.getPackageName());
            try {
                packageManager = context.getPackageManager();
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.a.b("Utility", "error  " + e2.getMessage(), context);
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
            if (packageManager == null) {
                return false;
            }
            if (z) {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
                if (queryBroadcastReceivers.size() < 1) {
                    Log.e("BDPushSDK-Utility", str2 + " is not exist or did not declared " + str);
                    return false;
                }
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (str2.equals(resolveInfo.activityInfo.name)) {
                        return true;
                    }
                }
            } else {
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
                if (queryIntentServices.size() < 1) {
                    Log.e("BDPushSDK-Utility", str2 + " is not exist or did not declared " + str);
                    return false;
                }
                for (ResolveInfo resolveInfo2 : queryIntentServices) {
                    if (str2.equals(resolveInfo2.serviceInfo.name)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(Context context, byte[] bArr, String str, String str2, byte[] bArr2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65561, null, context, bArr, str, str2, bArr2)) == null) {
            if (bArr != null && str != null && str2 != null && bArr2 != null) {
                try {
                    if (TextUtils.equals(f.a(a(a(str.getBytes(), str2.getBytes()), bArr2), false), new String(k.b(bArr, BaiduAppSSOJni.getPrivateKey(0))))) {
                        return true;
                    }
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                } catch (UnsatisfiedLinkError e3) {
                    new b.c(context).a(Log.getStackTraceString(e3)).a();
                    return true;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean a(Context context, byte[] bArr, String str, byte[] bArr2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65562, null, context, bArr, str, bArr2)) == null) {
            if (bArr == null || str == null || bArr2 == null) {
                return false;
            }
            String str2 = new String(bArr);
            return com.baidu.android.pushservice.f.a(context, str2, str + new String(bArr2));
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean a(Context context, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, context, strArr)) == null) {
            if ((e() || f() || g()) && PushSettings.i(context)) {
                try {
                    if (a("com.coloros.mcs.permission.RECIEVE_MCS_MESSAGE", strArr)) {
                        return !a("com.heytap.mcs.permission.RECIEVE_MCS_MESSAGE", strArr);
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            if (TextUtils.isEmpty(str) || str.contains(" ")) {
                Log.e("BDPushSDK-Utility", "api_key is  incorrect, please check ! ");
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, str, strArr)) == null) {
            for (String str2 : strArr) {
                if (str.equals(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, bArr, bArr2)) == null) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        List<ResolveInfo> list;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65567, null, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            try {
                packageManager = context.getPackageManager();
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                list = null;
            }
            if (packageManager == null) {
                return null;
            }
            list = packageManager.queryBroadcastReceivers(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
            if (list == null || list.size() <= 0) {
                return null;
            }
            return list.get(0).activityInfo.name;
        }
        return (String) invokeLLL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                byte[] decode = Base64.decode(str.getBytes(), 2);
                return new String(BaiduAppSSOJni.decryptAES(decode, decode.length, 0), "utf-8");
            } catch (Exception | UnsatisfiedLinkError unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void b(Context context, Intent intent, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65569, null, context, intent, str, str2) == null) {
            intent.setFlags(32);
            try {
                if (!TextUtils.isEmpty(str)) {
                    intent.setAction(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    intent.setPackage(str2);
                }
                a(context, intent, str2);
            } catch (Exception unused) {
            }
        }
    }

    public static void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65570, null, context, z) == null) || context == null) {
            return;
        }
        try {
            PushClient.getInstance(context).initialize();
            PushClient.getInstance(context).turnOnPush(new IPushActionListener(context, z) { // from class: com.baidu.android.pushservice.j.m.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f3494a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f3495b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f3494a = context;
                    this.f3495b = z;
                }

                @Override // com.vivo.push.IPushActionListener
                public void onStateChanged(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        if (i2 == 101) {
                            com.baidu.android.pushservice.f.b(this.f3494a, 0);
                            if (this.f3495b) {
                                return;
                            }
                            com.baidu.android.pushservice.a.a(this.f3494a, true);
                            i.a(this.f3494a, "vi_push_proxy_mode", 0);
                            com.baidu.android.pushservice.PushManager.enableVivoProxy(this.f3494a, false);
                            m.a(this.f3494a, true, true);
                            return;
                        }
                        if (i2 == 0 || i2 == 1) {
                            i.a(this.f3494a, "vi_push_proxy_mode", 1);
                            if (!this.f3495b && !com.baidu.android.pushservice.b.d.c(this.f3494a)) {
                                com.baidu.android.pushservice.a.a(this.f3494a, false);
                            }
                            String regId = PushClient.getInstance(this.f3494a).getRegId();
                            if (!TextUtils.isEmpty(regId)) {
                                com.baidu.android.pushservice.f.a(this.f3494a, regId);
                                return;
                            }
                        }
                        com.baidu.android.pushservice.f.k(this.f3494a);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            try {
                return Build.MANUFACTURER.toUpperCase().contains("XIAOMI");
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            String a2 = com.baidu.android.pushservice.a.a(context);
            if (SapiOptions.KEY_CACHE_ENABLED.equals(a2)) {
                return false;
            }
            if ("disabled".equals(a2)) {
                return true;
            }
            return a(context, context.getPackageName(), "DisableService");
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context, PublicMsg publicMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, context, publicMsg)) == null) {
            if (publicMsg != null) {
                String a2 = f.a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), false);
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                String b2 = com.baidu.android.pushservice.c.c.b(context, context.getPackageName(), publicMsg.mMsgId);
                return !TextUtils.isEmpty(b2) && b2.equals(a2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    context.getPackageManager().getApplicationInfo(str, 8192);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65575, null, context, str)) == null) {
            PackageInfo a2 = a(context, str);
            if (a2 != null) {
                return a2.versionCode;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) {
            try {
                return new String(Base64.encode(BaiduAppSSOJni.encryptAES(str, 0), 2), "utf-8");
            } catch (Exception | UnsatisfiedLinkError unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, context) == null) {
            a(context, 300000L);
        }
    }

    public static void c(Context context, Intent intent, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65578, null, context, intent, str, str2) == null) {
            try {
                Uri data = intent.getData();
                if (data != null) {
                    String r = r(context, data.toString());
                    Intent intent2 = new Intent();
                    String stringExtra = intent.getStringExtra("hwtitle");
                    String stringExtra2 = intent.getStringExtra("hwcontent");
                    if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                        intent2.putExtra("notification_title", stringExtra);
                        intent2.putExtra("notification_content", stringExtra2);
                    }
                    intent2.putExtra("extra_extra_custom_content", r);
                    intent2.putExtra("proxy_mode", 5);
                    intent2.putExtra("proxy_check_info", str);
                    intent2.putExtra("proxy_sign_info", str2);
                    com.baidu.android.pushservice.frequency.b.a().a(context, false, 1, r);
                    b(context, intent2, "com.baidu.android.pushservice.action.notification.CLICK", context.getPackageName());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void c(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65579, null, context, str, str2) == null) || context == null) {
            return;
        }
        try {
            MiPushClient.registerPush(context.getApplicationContext(), str, str2);
        } catch (Throwable unused) {
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            try {
                return Build.MANUFACTURER.toUpperCase().contains("MEIZU");
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, null, context) == null) {
            Intent a2 = l.a(context);
            a2.putExtra("method", "pushservice_quit");
            a2.setPackage(context.getPackageName());
            String b2 = b(context, context.getPackageName(), "com.baidu.android.pushservice.action.METHOD");
            if (!TextUtils.isEmpty(b2)) {
                a2.setClassName(context.getPackageName(), b2);
            }
            context.sendBroadcast(a2);
        }
    }

    public static void d(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65582, null, context, str, str2) == null) || context == null) {
            return;
        }
        try {
            com.meizu.cloud.pushsdk.PushManager.register(context.getApplicationContext(), str, str2);
        } catch (Exception unused) {
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            try {
                String upperCase = Build.MANUFACTURER.toUpperCase();
                if (upperCase.contains("HUAWEI") || upperCase.contains("HONOR")) {
                    return !i();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean d(Context context, String str) {
        InterceptResult invokeLL;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65584, null, context, str)) == null) {
            try {
                packageManager = context.getPackageManager();
            } catch (Exception unused) {
                applicationInfo = null;
            }
            if (packageManager == null) {
                return false;
            }
            applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.getBoolean("IsBaiduApp");
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65585, null, str)) == null) ? (str == null || str.isEmpty() || !str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$")) ? false : true : invokeL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            try {
                return Build.MANUFACTURER.toUpperCase().contains("OPPO");
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65587, null, context)) != null) {
            return invokeL.booleanValue;
        }
        try {
            Intent intent = new Intent("com.baidu.android.pushservice.action.notification.CLICK");
            intent.setPackage(context.getPackageName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
            if (queryBroadcastReceivers.size() < 1) {
                return false;
            }
            String str = queryBroadcastReceivers.get(0).activityInfo.name;
            boolean z2 = queryBroadcastReceivers.get(0).activityInfo.enabled;
            if (a(context, "com.baidu.android.pushservice.action.MESSAGE", str, true)) {
                try {
                    if (a(context, "com.baidu.android.pushservice.action.RECEIVE", str, true)) {
                        if (d() && PushSettings.k(context)) {
                            if (!a(context, "com.huawei.intent.action.PUSH", str, true)) {
                                Log.e("BDPushSDK-Utility", str + " did not declared com.huawei.intent.action.PUSH");
                                return false;
                            } else if (!a(context, "com.huawei.android.push.intent.RECEIVE", str, true)) {
                                Log.e("BDPushSDK-Utility", str + " did not declared com.huawei.android.push.intent.RECEIVE");
                                return false;
                            } else if (!a(context, "com.huawei.android.push.intent.REGISTRATION", str, true)) {
                                Log.e("BDPushSDK-Utility", str + " did not declared com.huawei.android.push.intent.REGISTRATION");
                                return false;
                            }
                        } else if (b() && PushSettings.g(context)) {
                            if (!a(context, "com.xiaomi.mipush.RECEIVE_MESSAGE", "com.baidu.android.pushservice.PushPatchMessageReceiver", true)) {
                                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushPatchMessageReceiver did not declared com.xiaomi.mipush.RECEIVE_MESSAGE");
                                return false;
                            } else if (!a(context, "com.xiaomi.mipush.MESSAGE_ARRIVED", "com.baidu.android.pushservice.PushPatchMessageReceiver", true)) {
                                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushPatchMessageReceiver did not declared com.xiaomi.mipush.MESSAGE_ARRIVED");
                                return false;
                            } else if (!a(context, "com.xiaomi.mipush.ERROR", "com.baidu.android.pushservice.PushPatchMessageReceiver", true)) {
                                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushPatchMessageReceiver did not declared com.xiaomi.mipush.ERROR");
                                return false;
                            }
                        } else if (c() && PushSettings.h(context)) {
                            if (!a(context, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true)) {
                                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver did not declared " + PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
                                return false;
                            } else if (!a(context, PushConstants.MZ_PUSH_ON_REGISTER_ACTION, "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true)) {
                                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver did not declared " + PushConstants.MZ_PUSH_ON_REGISTER_ACTION);
                                return false;
                            } else if (!a(context, PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION, "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true)) {
                                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver did not declared " + PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION);
                                return false;
                            } else if (!r(context)) {
                                Log.e("BDPushSDK-Utility", "com.meizu.cloud.pushsdk.SystemReceiver did not declared com.meizu.cloud.pushservice.action.PUSH_SERVICE_START");
                                return false;
                            }
                        } else if ((e() || f() || g()) && PushSettings.i(context)) {
                            if (!a(context, "com.coloros.mcs.action.RECEIVE_MCS_MESSAGE", "com.heytap.mcssdk.PushService", false)) {
                                Log.e("BDPushSDK-Utility", "com.heytap.mcssdk.PushService did not declared com.coloros.mcs.action.RECEIVE_MCS_MESSAGE");
                                return false;
                            } else if (!a(context, "com.heytap.mcs.action.RECEIVE_MCS_MESSAGE", "com.heytap.mcssdk.AppPushService", false)) {
                                Log.e("BDPushSDK-Utility", "com.heytap.mcssdk.AppPushService did not declared com.heytap.mcs.action.RECEIVE_MCS_MESSAGE");
                                return false;
                            }
                        } else if (h() && PushSettings.j(context) && !a(context, "com.vivo.pushclient.action.RECEIVE", "com.baidu.android.pushservice.viproxy.ViPushMessageReceiver", true)) {
                            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.viproxy.ViPushMessageReceiver did not declared com.vivo.pushclient.action.RECEIVE");
                            return false;
                        }
                        int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(context.getPackageName(), str));
                        boolean z3 = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z2);
                        if (z3) {
                            return z3;
                        }
                        try {
                            Log.e("BDPushSDK-Utility", str + " is disable, please check!");
                            return z3;
                        } catch (Exception e2) {
                            e = e2;
                            z = z3;
                            new b.c(context).a(Log.getStackTraceString(e)).a();
                            return z;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = false;
                    new b.c(context).a(Log.getStackTraceString(e)).a();
                    return z;
                }
            }
            Log.e("BDPushSDK-Utility", str + " did not declared com.baidu.android.pushservice.action.MESSAGE or com.baidu.android.pushservice.action.RECEIVE");
            return false;
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static boolean e(Context context, String str) {
        InterceptResult invokeLL;
        List<ResolveInfo> list;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65588, null, context, str)) == null) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            try {
                packageManager = context.getPackageManager();
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                list = null;
            }
            if (packageManager == null) {
                return false;
            }
            list = packageManager.queryIntentServices(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
            return list != null && list.size() > 0;
        }
        return invokeLL.booleanValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, context)) == null) {
            String q = q(context);
            if (TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", q)) {
                String t = t(context);
                if (TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", t)) {
                    String u = u(context);
                    return (TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", u) || B(context)) ? "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK" : u;
                }
                return t;
            }
            return q;
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65590, null, context, str)) == null) {
            if (PushSocket.a()) {
                String f2 = f(context);
                if (!TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", f2)) {
                    Log.e("BDPushSDK-Utility", f2);
                    return f2;
                } else if (a(str)) {
                    if (!e(context)) {
                        Log.e("BDPushSDK-Utility", "check SelfConfiged Receiver failed");
                    }
                    if (h()) {
                        return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
                    }
                    if (!s(context) && !B(context)) {
                        Log.e("BDPushSDK-Utility", "check CommandService Enable failed");
                        return "check CommandService Enable failed";
                    } else if (z(context)) {
                        return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
                    } else {
                        Log.e("BDPushSDK-Utility", "check CommandService Enable failed");
                        return "check CommandService Enable failed";
                    }
                } else {
                    str2 = "check Apikey failed";
                }
            } else {
                str2 = "check socket library failed";
            }
            Log.e("BDPushSDK-Utility", str2);
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) {
            try {
                return Build.MANUFACTURER.toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static int g(Context context, String str) {
        InterceptResult invokeLL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65592, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.equals(context.getPackageName())) {
                    a2 = com.baidu.android.pushservice.a.a();
                } else {
                    a2 = com.baidu.android.pushservice.c.d.a(context, str);
                    if (a2 == 0) {
                        return 50;
                    }
                }
                return a2;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) {
            try {
                return Build.MANUFACTURER.toUpperCase().contains("REALME");
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    boolean z = false;
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        if (serviceInfo.name.equals("com.baidu.android.pushservice.job.PushJobService")) {
                            z = true;
                        }
                    }
                    return !z;
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, context)) == null) {
            String deviceID = DeviceId.getDeviceID(context);
            if (o(context)) {
                return f.a(("com.baidu.pushservice.single_conn" + context.getPackageName() + "v3" + deviceID).getBytes(), false);
            }
            return f.a(("com.baidu.pushservice.single_conn" + context.getPackageName() + DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX + deviceID).getBytes(), false);
        }
        return (String) invokeL.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) {
            try {
                return Build.MANUFACTURER.toUpperCase().contains("VIVO");
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean h(Context context, String str) {
        InterceptResult invokeLL;
        int[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65597, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (b2 = com.baidu.android.pushservice.c.a.b(context, str)) == null || 4 != b2.length) {
                return false;
            }
            return a(b2[0], b2[1], b2[2], b2[3]);
        }
        return invokeLL.booleanValue;
    }

    public static int i(Context context, String str) {
        long parseLong;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65598, null, context, str)) == null) {
            try {
                parseLong = Long.parseLong(str);
            } catch (Exception e2) {
                try {
                    if (str.length() > 0) {
                        str = str.substring(1);
                    }
                    parseLong = Long.parseLong(str);
                } catch (Exception unused) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                    return 0;
                }
            }
            return (int) parseLong;
        }
        return invokeLL.intValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) {
            try {
                String upperCase = Build.MODEL.toUpperCase();
                if (TextUtils.isEmpty(upperCase)) {
                    return false;
                }
                return upperCase.contains("NEXUS");
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static synchronized boolean i(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, context)) == null) {
            synchronized (m.class) {
                if (f3490a == -1) {
                    try {
                        f3490a = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false) ? 1 : 0;
                    } catch (Exception unused) {
                    }
                }
                z = f3490a == 1;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void j(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65601, null, context) == null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("com.huawei.android.push.intent.REGISTER");
        intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, applicationContext.getPackageName());
        intent.putExtra("is_hms", true);
        intent.setFlags(32);
        applicationContext.sendBroadcast(intent);
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65602, null)) == null) {
            try {
                return Build.MANUFACTURER.toUpperCase().contains("SAMSUNG");
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean j(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65603, null, context, str)) == null) {
            String a2 = i.a(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED");
            if (!TextUtils.isEmpty(a2)) {
                if (a2.contains(str)) {
                    return true;
                }
                if (a2.length() > 1000) {
                    a2 = a2.substring(500);
                }
                str = a2 + ":" + str;
            }
            i.a(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED", str);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65604, null, context) == null) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.METHOD");
            intent.putExtra("method", "com.baidu.android.pushservice.action.SEND_APPSTAT");
            com.baidu.android.pushservice.i.a(context.getApplicationContext()).a(intent);
        }
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            try {
                return Build.MANUFACTURER.toUpperCase().contains(RomUtils.ROM_GIONEE);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean k(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65606, null, context, str)) == null) {
            try {
                return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65607, null, context)) == null) {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            if (upperCase.contains("XIAOMI")) {
                str = RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL;
            } else if (upperCase.contains("HUAWEI") || upperCase.contains("HONOR")) {
                str = "ro.build.version.emui";
            } else if (upperCase.contains("MEIZU")) {
                return Build.DISPLAY;
            } else {
                str = (upperCase.contains("OPPO") || upperCase.contains("REALME")) ? "ro.build.version.opporom" : upperCase.contains("VIVO") ? "ro.vivo.os.version" : upperCase.contains(RomTypeUtil.ROM_ONEPLUS) ? "ro.rom.version" : "";
            }
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    return SystemProperties.get(str);
                }
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            } catch (Throwable th) {
                new b.c(context).a(Log.getStackTraceString(th)).a();
                return (Build.VERSION.SDK_INT < 21 || !(upperCase.contains("HUAWEI") || upperCase.contains("HONOR"))) ? upperCase.contains("XIAOMI") ? "MIUI_notfound" : (upperCase.contains("OPPO") || upperCase.contains("REALME")) ? "ColorOS_notfound" : upperCase.contains("VIVO") ? "FuntouchOS_notfound" : "" : "EmotionUI_notfound";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) {
            try {
                return Build.MANUFACTURER.toUpperCase().contains(RomUtils.ROM_NUBIA);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean l(Context context, String str) {
        InterceptResult invokeLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65609, null, context, str)) != null) {
            return invokeLL.booleanValue;
        }
        try {
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        z = com.baidu.android.pushservice.c.a.a(context, str);
        try {
            z2 = j(context, str);
        } catch (Exception e3) {
            e = e3;
            new b.c(context).a(Log.getStackTraceString(e)).a();
            z2 = false;
            return z ? false : false;
        }
        if (z && z2) {
            return true;
        }
    }

    public static int m(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65610, null, context, str)) == null) {
            try {
                PackageInfo a2 = a(context, str);
                if (a2 != null) {
                    return a2.applicationInfo.targetSdkVersion;
                }
                return 0;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65611, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) ? l() : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e6, code lost:
        if (r0.find() != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String n(Context context) {
        InterceptResult invokeL;
        String str;
        String substring;
        Matcher matcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65613, null, context)) == null) {
            String str2 = "";
            if (n()) {
                String upperCase = Build.MANUFACTURER.toUpperCase();
                String str3 = upperCase.contains("XIAOMI") ? "ro.miui.ui.version.code" : (upperCase.contains("HUAWEI") || upperCase.contains("HONOR")) ? "ro.build.version.emui" : upperCase.contains("MEIZU") ? "ro.build.display.id" : (upperCase.contains("OPPO") || upperCase.contains("REALME")) ? "ro.build.version.opporom" : upperCase.contains("VIVO") ? "ro.vivo.os.version" : upperCase.contains(RomTypeUtil.ROM_ONEPLUS) ? "ro.rom.version" : "";
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        str = SystemProperties.get(str3);
                    } else {
                        Class<?> cls = Class.forName("android.os.SystemProperties");
                        str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str3);
                    }
                    str2 = str;
                    if ((upperCase.contains("HUAWEI") || upperCase.contains("HONOR")) && !TextUtils.isEmpty(str2)) {
                        substring = str2.substring(str2.indexOf("_") + 1, str2.length());
                        if (!substring.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21) {
                            return Constants.SDK_VER;
                        }
                    } else {
                        if (upperCase.contains("MEIZU")) {
                            if (TextUtils.isEmpty(str2)) {
                                str2 = Build.DISPLAY;
                            }
                            matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(str2);
                        } else if ((upperCase.contains("OPPO") || upperCase.contains("REALME")) && !TextUtils.isEmpty(str2)) {
                            Matcher matcher2 = Pattern.compile("^V(\\d+\\.?\\d*)").matcher(str2);
                            if (matcher2.find()) {
                                str2 = matcher2.group(1);
                            }
                        } else if (upperCase.contains("VIVO") && !TextUtils.isEmpty(str2)) {
                            matcher = Pattern.compile("^\\d+(\\.\\d+)?").matcher(str2);
                            if (matcher.find()) {
                            }
                        } else if (upperCase.contains(RomTypeUtil.ROM_ONEPLUS) && !TextUtils.isEmpty(str2)) {
                            Matcher matcher3 = Pattern.compile("\\d+(\\.\\d+)?").matcher(str2);
                            if (matcher3.find()) {
                                substring = matcher3.group();
                            }
                        }
                        str2 = matcher.group();
                    }
                    return substring;
                } catch (Throwable th) {
                    new b.c(context).a(Log.getStackTraceString(th)).a();
                    if (Build.VERSION.SDK_INT >= 21 && (upperCase.contains("HUAWEI") || upperCase.contains("HONOR"))) {
                        return Constants.SDK_VER;
                    }
                    if (upperCase.contains("HUAWEI") || upperCase.contains("HONOR")) {
                        return "1.0";
                    }
                    if (upperCase.contains("XIAOMI")) {
                        return "4.0";
                    }
                    if (upperCase.contains("MEIZU")) {
                        return "6.0";
                    }
                    if (upperCase.contains("OPPO") || upperCase.contains("REALME")) {
                        return "3.0";
                    }
                    if (upperCase.contains("VIVO")) {
                        return "3.2";
                    }
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String n(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65614, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            try {
                String e2 = com.baidu.android.pushservice.c.c.e(context);
                if (TextUtils.isEmpty(e2)) {
                    return null;
                }
                ArrayList<com.baidu.android.pushservice.a.e> c2 = com.baidu.android.pushservice.a.b.a(context).c(b(e2));
                if (c2 != null) {
                    Iterator<com.baidu.android.pushservice.a.e> it = c2.iterator();
                    while (it.hasNext()) {
                        com.baidu.android.pushservice.a.e next = it.next();
                        if (next.b().equals(str)) {
                            return next.a();
                        }
                    }
                    return null;
                }
                return null;
            } catch (Exception e3) {
                new b.c(context).a(Log.getStackTraceString(e3)).a();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65615, null)) == null) ? d() || e() || h() || b() || c() || f() || g() : invokeV.booleanValue;
    }

    public static int o(Context context, String str) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65616, null, context, str)) == null) {
            int i2 = 0;
            do {
                try {
                    indexOf = str.indexOf("#Intent;");
                    if (indexOf != -1) {
                        int i3 = indexOf + 8;
                        i2 += i3;
                        str = str.substring(i3);
                        continue;
                    }
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                    return i2;
                }
            } while (indexOf != -1);
            return i2 > 0 ? i2 - 8 : i2;
        }
        return invokeLL.intValue;
    }

    public static boolean o(Context context) {
        PackageInfo a2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65617, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 24 || (a2 = a(context, context.getPackageName())) == null) {
                    return false;
                }
                return a2.applicationInfo.targetSdkVersion >= 24;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int p(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65618, null, context, str)) == null) {
            try {
                String d2 = com.baidu.android.pushservice.c.c.d(context);
                if (TextUtils.isEmpty(d2)) {
                    return 0;
                }
                ArrayList<com.baidu.android.pushservice.a.e> c2 = com.baidu.android.pushservice.a.b.a(context).c(b(d2));
                if (c2 != null) {
                    Iterator<com.baidu.android.pushservice.a.e> it = c2.iterator();
                    while (it.hasNext()) {
                        com.baidu.android.pushservice.a.e next = it.next();
                        if (TextUtils.equals(next.b(), str)) {
                            return next.c();
                        }
                    }
                    return 0;
                }
                return 0;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static boolean p(Context context) {
        PackageInfo a2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65619, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 26 || (a2 = a(context, context.getPackageName())) == null) {
                    return false;
                }
                return a2.applicationInfo.targetSdkVersion >= 26;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static Bitmap q(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65620, null, context, str)) == null) {
            Bitmap bitmap = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(1000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                InputStream inputStream = httpURLConnection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                return bitmap;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return bitmap;
            }
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static String q(Context context) {
        String[] strArr;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65621, null, context)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return "pm is null";
                }
                String[] strArr2 = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr2 == null) {
                    Log.e("BDPushSDK-Utility", "Permissions Push-SDK need are not exist !");
                    return "Permissions Push-SDK need are not exist !";
                } else if (a(context, packageManager, strArr2)) {
                    Log.e("BDPushSDK-Utility", "permission Push-SDK for xiaomi proxy need is not exist !");
                    return "permission Push-SDK for xiaomi proxy need is not exist !";
                } else if (a(context, strArr2)) {
                    Log.e("BDPushSDK-Utility", "permission Push-SDK for oppo proxy need is not exist !");
                    return "permission Push-SDK for oppo proxy need is not exist !";
                } else {
                    for (String str : f3491b) {
                        if (!a(str, strArr2)) {
                            String str2 = str + " permission Push-SDK need is not exist !";
                            Log.e("BDPushSDK-Utility", str2);
                            return str2;
                        }
                    }
                    return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
                }
            } catch (Exception e2) {
                return "checkSDKPermissions exception " + e2.getMessage();
            }
        }
        return (String) invokeL.objValue;
    }

    public static String r(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65622, null, context, str)) == null) {
            String str2 = null;
            try {
                if (!TextUtils.isEmpty(str) && str.contains("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=")) {
                    if (str.contains("bdpush_hwsigninfo")) {
                        int o = o(context, str);
                        if (o > 0) {
                            str2 = str.substring(45, o);
                        }
                    } else {
                        str2 = str.substring(45, str.length());
                    }
                }
            } catch (Exception unused) {
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean r(Context context) {
        InterceptResult invokeL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65623, null, context)) == null) {
            Intent intent = new Intent("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(context.getPackageName());
            try {
                packageManager = context.getPackageManager();
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.a.b("Utility", "error  " + e2.getMessage(), context);
            }
            if (packageManager == null) {
                return false;
            }
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
            if (queryBroadcastReceivers.size() < 1) {
                return false;
            }
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if ("com.meizu.cloud.pushsdk.SystemReceiver".equals(resolveInfo.activityInfo.name)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65624, null, context)) == null) {
            try {
                ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.baidu.android.pushservice.CommandService"), 128);
                if (TextUtils.isEmpty(serviceInfo.name)) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.CommandService did not declared ");
                    return false;
                } else if (serviceInfo.exported) {
                    return true;
                } else {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.CommandService  exported declared wrong");
                    return true;
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String t(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65625, null, context)) == null) {
            if (!a(context, "com.baidu.android.pushservice.action.notification.SHOW", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
                str = "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared com.baidu.android.pushservice.action.notification.SHOW";
            } else if (a(context, "com.baidu.android.pushservice.action.METHOD", "com.baidu.android.pushservice.RegistrationReceiver", true)) {
                return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
            } else {
                str = "com.baidu.android.pushservice.RegistrationReceiver is not exist or did not declared com.baidu.android.pushservice.action.METHOD";
            }
            Log.e("BDPushSDK-Utility", str);
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String u(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65626, null, context)) == null) {
            if (v(context)) {
                str = "xiaomi service is not found or wrong  declared, please check!";
            } else if (x(context)) {
                str = "oppo service is not found or wrong  declared, please check!";
            } else if (w(context)) {
                str = "meizu service is not found or wrong  declared, please check!";
            } else if (!y(context)) {
                return a(context, "com.baidu.android.pushservice.action.PUSH_SERVICE", "com.baidu.android.pushservice.PushService", false) ? "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK" : "com.baidu.android.pushservice.PushService is not exist or did not declared com.baidu.android.pushservice.action.PUSH_SERVICE";
            } else {
                str = "vivo service is not found or wrong  declared, please check!";
            }
            Log.e("BDPushSDK-Utility", str);
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean v(Context context) {
        InterceptResult invokeL;
        ServiceInfo[] serviceInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65627, null, context)) == null) {
            try {
                if (b() && PushSettings.g(context)) {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                    if (packageInfo.services != null) {
                        boolean z = false;
                        boolean z2 = false;
                        for (ServiceInfo serviceInfo : packageInfo.services) {
                            if (serviceInfo.name.equals("com.xiaomi.mipush.sdk.PushMessageHandler")) {
                                z2 = true;
                            }
                            if (serviceInfo.name.equals("com.xiaomi.mipush.sdk.MessageHandleService")) {
                                z = true;
                            }
                        }
                        return (z && z2) ? false : true;
                    }
                    return false;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65628, null, context)) == null) {
            try {
                if (c() && PushSettings.h(context)) {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                    if (packageInfo.services != null) {
                        boolean z = false;
                        for (ServiceInfo serviceInfo : packageInfo.services) {
                            if (serviceInfo.name.equals("com.meizu.cloud.pushsdk.NotificationService")) {
                                z = true;
                            }
                        }
                        return !z;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean x(Context context) {
        InterceptResult invokeL;
        ServiceInfo[] serviceInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65629, null, context)) == null) {
            try {
                if ((e() || f() || g()) && PushSettings.i(context)) {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                    if (packageInfo.services != null) {
                        boolean z = false;
                        boolean z2 = false;
                        for (ServiceInfo serviceInfo : packageInfo.services) {
                            if (serviceInfo.name.equals("com.heytap.mcssdk.PushService")) {
                                z = true;
                            }
                            if (serviceInfo.name.equals("com.heytap.mcssdk.AppPushService")) {
                                z2 = true;
                            }
                        }
                        return (z && z2) ? false : true;
                    }
                    return false;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65630, null, context)) == null) {
            try {
                if (h() && PushSettings.j(context)) {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                    if (packageInfo.services != null) {
                        boolean z = false;
                        for (ServiceInfo serviceInfo : packageInfo.services) {
                            if (serviceInfo.name.equals("com.vivo.push.sdk.service.CommandClientService")) {
                                z = true;
                            }
                        }
                        return !z;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean z(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65631, null, context)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, "com.baidu.android.pushservice.PushInfoProvider");
                new ProviderInfo();
                ProviderInfo providerInfo = packageManager.getProviderInfo(componentName, 128);
                String str = providerInfo.name;
                String str2 = providerInfo.authority;
                com.baidu.android.pushservice.g.a.c("Utility", "provider name  = " + str + "  export  = " + providerInfo.exported + " provider authorities = " + str2, context.getApplicationContext());
                if (TextUtils.isEmpty(str)) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider did not declared, please check ! ");
                    return false;
                }
                if (!TextUtils.isEmpty(str2) && str2.endsWith("bdpush")) {
                    if (!providerInfo.exported) {
                        Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider exported declared wrong, please check ! ");
                    }
                    if (TextUtils.isEmpty(providerInfo.writePermission)) {
                        Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider writePermission did not decleared, please check !");
                        return true;
                    }
                    return true;
                }
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider bdpush authority is required, please check !");
                return false;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
