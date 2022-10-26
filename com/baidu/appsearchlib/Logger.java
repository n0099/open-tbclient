package com.baidu.appsearchlib;

import android.app.ActivityManager;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
/* loaded from: classes.dex */
public class Logger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_SERVER = "http://nsclick.baidu.com/v.gif";
    public static final HashSet LOG_TIMES;
    public static final long ONE_SECOND = 1000;
    public static ActivityManager activityManager;
    public static Runnable checkThread;
    public static long lastCallTime;
    public static long lastStartTime;
    public static boolean looperDisabled;
    public static String packageName;
    public static ExecutorService pool;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1523925914, "Lcom/baidu/appsearchlib/Logger;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1523925914, "Lcom/baidu/appsearchlib/Logger;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        LOG_TIMES = hashSet;
        hashSet.add(2);
        LOG_TIMES.add(6);
        LOG_TIMES.add(15);
        LOG_TIMES.add(30);
        LOG_TIMES.add(45);
        LOG_TIMES.add(60);
        pool = Executors.newFixedThreadPool(10);
        looperDisabled = false;
        lastCallTime = 0L;
        lastStartTime = 0L;
    }

    public Logger() {
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

    public static void onCallUp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            lastCallTime = Util.getTime();
        }
    }

    public static String encode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                return URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void onClientBoot(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, context) == null) && lastStartTime < 1) {
            lastStartTime = Util.getTime();
            recordCustomAction(context, "appstart");
            checkOnForeground(context.getApplicationContext());
        }
    }

    public static void reportWithUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            pool.execute(new Thread(str) { // from class: com.baidu.appsearchlib.Logger.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$url;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$url = str;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            new DefaultHttpClient().execute(new HttpGet(this.val$url));
                        } catch (ClientProtocolException e) {
                            e.printStackTrace();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static void checkOnForeground(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            activityManager = (ActivityManager) context.getSystemService("activity");
            packageName = context.getPackageName();
            if (checkThread != null) {
                return;
            }
            Thread thread = new Thread(context) { // from class: com.baidu.appsearchlib.Logger.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;

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
                    this.val$context = context;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int i = 0;
                        while (!Logger.looperDisabled) {
                            try {
                                Thread.sleep(1000L);
                                i++;
                                if (Logger.isAppOnForeground()) {
                                    if (Logger.LOG_TIMES.contains(Integer.valueOf(i))) {
                                        Logger.onAlive(this.val$context);
                                    }
                                } else {
                                    Logger.onClientExit(this.val$context);
                                    Logger.checkThread = null;
                                    return;
                                }
                            } catch (Exception e) {
                                Logger.checkThread = null;
                                e.printStackTrace();
                                return;
                            }
                        }
                    }
                }
            };
            checkThread = thread;
            pool.execute(thread);
        }
    }

    public static boolean isAppOnForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void onAlive(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            if (lastCallTime < 1) {
                recordClientAction(context, Info.kBaiduClient_Alive_On_Noraml, Long.valueOf(Util.getTime() - lastStartTime));
            } else {
                recordClientAction(context, Info.kBaiduClient_Alive_On_Call, Long.valueOf(Util.getTime() - lastStartTime), Long.valueOf(Util.getTime() - lastCallTime));
            }
        }
    }

    public static void onClientExit(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            if (lastCallTime < 1) {
                recordClientAction(context, Info.kBaiduClient_Exit_On_Noraml, Long.valueOf(Util.getTime() - lastStartTime));
            } else {
                recordClientAction(context, Info.kBaiduClient_Exit_On_Call, Long.valueOf(Util.getTime() - lastStartTime), Long.valueOf(Util.getTime() - lastCallTime));
            }
            lastCallTime = 0L;
            lastStartTime = 0L;
        }
    }

    public static void recordAction(Context context, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, context, str, objArr) == null) {
            reportWithString(context, String.format(str, objArr));
        }
    }

    public static void recordClientAction(Context context, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, str, objArr) == null) {
            recordAction(context, "&%s=%s&%s", Info.kBaiduActionType, Info.kBaiduClientActionKey, String.format(str, objArr));
        }
    }

    public static void recordServerAction(Context context, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, str, objArr) == null) {
            recordAction(context, "&%s=%s&%s", Info.kBaiduActionType, Info.kBaiduServerActionKey, String.format(str, objArr));
        }
    }

    public static void recordCustomAction(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            recordClientAction(context, "%s=%s", Info.kBaiduClientActionKey, str);
        }
    }

    public static void reportWithString(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, str) == null) {
            String timeStr = Util.getTimeStr();
            String encode = encode(Util.getDeviceId(context));
            StringBuilder sb = new StringBuilder(String.valueOf(String.format("%s?%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", LOG_SERVER, "pid", Info.kBaiduPIDValue, Info.kBaiduPJKey, Info.kBaiduPJValue, Info.kBaiduVersionKey, encode(Util.getCurrentVersion(context)), "t", timeStr, Info.kBaiduDevice, encode(Util.getPlatformCode()), Info.kBaiduOpenudid, encode, Info.kBaiduIOSVersion, encode(Util.getOSVersion()), Info.kBaiduModuleKey, Info.kBaiduBaseModule, Info.kBaiduAppIDKey, Info.APPID, Info.kBaiduSDKVersionKey, Info.SDK_VERSION, "vcode1", Md5Util.getMd5(String.valueOf(timeStr) + encode + Info.PASSWORD))));
            sb.append(str);
            StringBuilder sb2 = new StringBuilder(String.valueOf(String.valueOf(sb.toString()) + "&vcode2="));
            sb2.append(Md5Util.getMd5(String.valueOf(timeStr) + encode + Info.PASSWORD + str));
            reportWithUrl(sb2.toString());
        }
    }
}
