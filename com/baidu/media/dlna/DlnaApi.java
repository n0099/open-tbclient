package com.baidu.media.dlna;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
import com.baidu.media.duplayer.Keep;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class DlnaApi {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static DlnaProvider.DlnaSearchListener f8041a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f8042b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                try {
                    if (i2 == 1) {
                        Map<String, Object> map = (Map) message.obj;
                        synchronized (DlnaApi.class) {
                            if (DlnaApi.f8041a != null && map != null) {
                                DlnaApi.f8041a.onDeviceChangeNotification(map);
                            }
                        }
                    } else if (i2 == 2) {
                        synchronized (DlnaApi.class) {
                            if (DlnaApi.f8041a != null) {
                                DlnaApi.f8041a.onRefreshFinishNotification(message.arg1, message.arg2);
                            }
                        }
                    }
                } catch (NullPointerException e2) {
                    e2.printStackTrace();
                }
                super.handleMessage(message);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(830876407, "Lcom/baidu/media/dlna/DlnaApi;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(830876407, "Lcom/baidu/media/dlna/DlnaApi;");
                return;
            }
        }
        f8042b = new a(Looper.getMainLooper());
    }

    public DlnaApi() {
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

    public static CtrlPointProvider ctrlPoint(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return new CtrlPoint(nativeCtrlPoint(str), str);
            } catch (Error unused) {
                str2 = "CALL nativeCtrlPoint error";
                CyberLog.e("DLNA API", str2);
                return null;
            } catch (Exception unused2) {
                str2 = "CALL nativeCtrlPoint exception";
                CyberLog.e("DLNA API", str2);
                return null;
            }
        }
        return (CtrlPointProvider) invokeL.objValue;
    }

    public static String getExternalStorageCacheDirectory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            String str = null;
            try {
                if (hasExternalStoragePermission(context)) {
                    str = Environment.getExternalStorageDirectory().getAbsolutePath();
                } else if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                    str = context.getExternalCacheDir().getPath();
                }
            } catch (Exception unused) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static long getExternalStorageSpace() {
        InterceptResult invokeV;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState()) && (path = Environment.getExternalStorageDirectory().getPath()) != null && path.length() > 0) {
                    StatFs statFs = new StatFs(path);
                    return statFs.getBlockSize() * statFs.getAvailableBlocks();
                }
            } catch (Exception unused) {
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public static long getInternalStorageSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? CyberPlayerManager.getApplicationContext().getFilesDir().getUsableSpace() : invokeV.longValue;
    }

    public static boolean hasExternalStoragePermission(Context context) {
        InterceptResult invokeL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context != null && (packageManager = context.getPackageManager()) != null) {
                try {
                    if (packageManager.checkPermission("android.permission.READ_EXTERNAL_STORAGE", context.getPackageName()) == 0) {
                        return packageManager.checkPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION, context.getPackageName()) == 0;
                    }
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static native long nativeCtrlPoint(String str);

    public static native void nativeSearch();

    public static native void nativeStop();

    @Keep
    public static void onDeviceChanged(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("friendlyName", str);
            hashMap.put("uuid", str2);
            Message.obtain(f8042b, 1, hashMap).sendToTarget();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (getExternalStorageSpace() < com.baidu.mobstat.Config.FULL_TRACE_LOG_LIMIT) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
        if (getInternalStorageSpace() >= com.baidu.mobstat.Config.FULL_TRACE_LOG_LIMIT) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
        if (r5 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0089, code lost:
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008b, code lost:
        if (r2 != null) goto L21;
     */
    @Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String onFindFilePath(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) {
            Context applicationContext = CyberPlayerManager.getApplicationContext();
            if (applicationContext == null) {
                return null;
            }
            String str = applicationContext.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer";
            String externalStorageCacheDirectory = getExternalStorageCacheDirectory(applicationContext);
            if (externalStorageCacheDirectory != null) {
                externalStorageCacheDirectory = externalStorageCacheDirectory + File.separator + applicationContext.getPackageName() + File.separator + ".video_statistic" + File.separator + "duplayer";
            }
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            if (externalStorageCacheDirectory != null) {
                            }
                        }
                    } else if (str != null) {
                    }
                    str = null;
                }
            }
            if (str == null) {
                return null;
            }
            new File(str).mkdirs();
            return str;
        }
        return (String) invokeI.objValue;
    }

    @Keep
    public static void onRefreshFinished(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65549, null, i2, i3) == null) {
            Message obtain = Message.obtain(f8042b, 2);
            obtain.arg1 = i2;
            obtain.arg2 = i3;
            obtain.sendToTarget();
        }
    }

    public static void search(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, dlnaSearchListener) == null) {
            synchronized (DlnaApi.class) {
                f8041a = dlnaSearchListener;
            }
            try {
                nativeSearch();
            } catch (Error unused) {
                str = "DLNA API";
                str2 = "CALL nativeSearch error";
                CyberLog.e(str, str2);
            } catch (Exception unused2) {
                str = "DLNA API";
                str2 = "CALL nativeSearch exception";
                CyberLog.e(str, str2);
            }
        }
    }

    public static void stop() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            synchronized (DlnaApi.class) {
                f8041a = null;
            }
            try {
                nativeStop();
            } catch (Error unused) {
                str = "DLNA API";
                str2 = "CALL nativeStop error";
                CyberLog.e(str, str2);
            } catch (Exception unused2) {
                str = "DLNA API";
                str2 = "CALL nativeStop exception";
                CyberLog.e(str, str2);
            }
        }
    }
}
