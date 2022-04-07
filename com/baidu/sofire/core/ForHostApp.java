package com.baidu.sofire.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.FileDeleteObserverUtils;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.d.D;
import com.baidu.sofire.rp.Report;
import com.baidu.sofire.rp.RpConstant;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.LocalConstant;
import com.baidu.sofire.utility.MD5Util;
import com.baidu.sofire.utility.MutiPlatformAdapter;
import com.baidu.sofire.utility.PrivacyOperationUtil;
import com.baidu.sofire.utility.ThreadPoolManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ForHostApp implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_NAME_LOCAL = "local";
    public static final int RESULT_11_PROVIDER_ERROR = 9;
    public static final int RESULT_CALL_ERROR_COMPONENT = 11;
    public static final int RESULT_CALL_ERROR_INIT_FAILD = 4;
    public static final int RESULT_CALL_ERROR_INNER = 3;
    public static final int RESULT_CALL_ERROR_INVALID_METHOD = 2;
    public static final int RESULT_CALL_ERROR_NULL_METHOD = 1;
    public static final int RESULT_CALL_ERROR_POLICY = 12;
    public static final int RESULT_CALL_ERROR_PROCESS_ERROR = 5;
    public static final int RESULT_CALL_SUCCESS = 0;
    public static final int RESULT_PARA_ERROR = 7;
    public static final int RESULT_PROVIDER_CALL_EXCEPTION = 10;
    public static final int RESULT_ZID_X0_NOTINIT = 8;
    public static Context hostContext;
    public static ForHostApp instance;
    public static boolean isOnline;
    public static int sInitStatus;
    public static List<Integer> sSkipList;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean initCalledByHost;
    public D loadedPluginDB;
    public SharedPreferenceManager mPreferences;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1651958890, "Lcom/baidu/sofire/core/ForHostApp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1651958890, "Lcom/baidu/sofire/core/ForHostApp;");
                return;
            }
        }
        sSkipList = new ArrayList();
    }

    public ForHostApp(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.initCalledByHost = false;
        Context applicationContext = context.getApplicationContext();
        hostContext = applicationContext;
        this.loadedPluginDB = D.getInstance(applicationContext);
        SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(hostContext);
        this.mPreferences = sharedPreferenceManager;
        SharedPreferences platformSharedSharedPreferences = sharedPreferenceManager.getPlatformSharedSharedPreferences();
        if (platformSharedSharedPreferences != null) {
            platformSharedSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
    }

    public static int getInitStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sInitStatus : invokeV.intValue;
    }

    public static synchronized ForHostApp getInstance(Context context) {
        InterceptResult invokeL;
        ForHostApp forHostApp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (ForHostApp.class) {
                if (instance == null) {
                    instance = new ForHostApp(context.getApplicationContext());
                }
                forHostApp = instance;
            }
            return forHostApp;
        }
        return (ForHostApp) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IF, IF, IF, NOP, INVOKE, IF, NOP] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0172, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initLocalForgPlugins(int i, String str, String str2, PackageInfo packageInfo) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), str, str2, packageInfo}) != null) {
            return;
        }
        try {
            ApkInfo pluginByID = this.loadedPluginDB.getPluginByID(i);
            if (pluginByID != null) {
                if (!CommonMethods.compareVersionNotEquals(str, pluginByID.versionName)) {
                    return;
                }
                deleteNotLoadedPlugin(i);
            }
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
        File file = null;
        InputStream inputStream2 = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                File file2 = new File(hostContext.getFilesDir(), ".tmp");
                if (!file2.exists()) {
                    file2.mkdir();
                }
                File file3 = new File(file2, i + "-" + str + ".zip");
                try {
                    fileOutputStream = new FileOutputStream(file3);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    fileOutputStream = null;
                }
                try {
                    inputStream2 = hostContext.getAssets().open(String.valueOf(i));
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        z = false;
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    CommonMethods.ensureQuanxian(file3.getAbsolutePath(), true);
                    String md5 = MD5Util.getMD5(file3);
                    if (md5 != null && md5.equalsIgnoreCase(str2)) {
                        ApkInfo apkInfo = new ApkInfo(i, str, file3.getAbsolutePath());
                        apkInfo.apkMD5 = md5;
                        apkInfo.priority = 1;
                        this.loadedPluginDB.insertOrUpdatePluginRecord(apkInfo);
                        if (this.loadedPluginDB.getPluginDeleteStatus(i) != 3) {
                            z = true;
                        }
                        if (this.mPreferences.isNeedBackupAPK() && z) {
                            File file4 = new File(hostContext.getFilesDir(), ".b");
                            if (!file4.exists()) {
                                file4.mkdir();
                            }
                            File file5 = new File(file4, i + "-" + str);
                            if (!CommonMethods.isFileExist(file5)) {
                                CommonMethods.copyFile(file3, file5);
                            }
                            FileDeleteObserverUtils.registerObserver(hostContext, i, file3, file5);
                        } else {
                            File file6 = new File(hostContext.getFilesDir(), ".b");
                            if (file6.exists()) {
                                File file7 = new File(file6, i + "-" + str);
                                if (CommonMethods.isFileExist(file7)) {
                                    FileDeleteObserverUtils.unRegisterObserver(file7);
                                    file7.delete();
                                }
                            }
                        }
                    }
                    file3.delete();
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (IOException unused2) {
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    file = file3;
                    try {
                        CommonMethods.handleNuLException(th);
                        if (file == null || !file.exists()) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return;
                                } catch (IOException unused3) {
                                    return;
                                }
                            }
                            return;
                        }
                        FileDeleteObserverUtils.unRegisterObserver(file);
                        this.loadedPluginDB.deletePluginById(i);
                        file.delete();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (IOException unused5) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                    }
                }
            }
            fileOutputStream = null;
            ApkInfo pluginByID2 = this.loadedPluginDB.getPluginByID(i);
            if (pluginByID2 != null && CommonMethods.isFileExist(pluginByID2.pkgPath)) {
                if (initPlugin(i, str, packageInfo)) {
                    sSkipList.add(Integer.valueOf(i));
                    this.mPreferences.setLocalLoadPluginVersion(i, str);
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused8) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (IOException unused9) {
                        return;
                    }
                }
                return;
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused10) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            fileOutputStream = null;
        }
    }

    public static ForHostApp peekInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? instance : (ForHostApp) invokeV.objValue;
    }

    public static void setInitStatus(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65544, null, i) == null) && sInitStatus == 0) {
            sInitStatus = i;
        }
    }

    public boolean checkSinglePlugin(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            try {
                PluginloaderHub createSingleInstance = PluginloaderHub.createSingleInstance(context);
                if (createSingleInstance == null) {
                    return false;
                }
                if (createSingleInstance.getApkInfoByPackageName(str) != null) {
                    return true;
                }
                if (this.loadedPluginDB == null) {
                    this.loadedPluginDB = D.getInstance(hostContext);
                }
                ApkInfo pluginByPkg = this.loadedPluginDB.getPluginByPkg(str);
                if (pluginByPkg != null) {
                    if (this.mPreferences.isNeedBackupAPK()) {
                        File file = new File(hostContext.getFilesDir(), ".b");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(pluginByPkg.pkgPath);
                        File file3 = new File(file, pluginByPkg.key + "-" + pluginByPkg.versionName);
                        if (!CommonMethods.isFileExist(file3)) {
                            CommonMethods.copyFile(file2, file3);
                        }
                        FileDeleteObserverUtils.registerObserver(hostContext, pluginByPkg.key, file2, file3);
                    }
                    if (initPlugin(pluginByPkg.key, pluginByPkg.versionName, null)) {
                        return true;
                    }
                }
                return createSingleInstance.getApkInfoByPackageName(str) != null;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void deleteNotLoadedPlugin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            try {
                ApkInfo pluginByID = this.loadedPluginDB.getPluginByID(i);
                if (pluginByID == null) {
                    return;
                }
                this.loadedPluginDB.deletePluginById(i);
                File file = new File(pluginByID.pkgPath);
                if (file.exists()) {
                    FileDeleteObserverUtils.unRegisterObserver(file);
                    file.delete();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void execEngineImpl(int i, String str, Class<?>[] clsArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), str, clsArr, objArr}) == null) {
            execEngineImpl(i, str, null, clsArr, objArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<Integer, Object> execEngineImplSync(int i, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), str, clsArr, objArr})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i));
            hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
            hashMap.put("2", "1");
            CommonMethods.sendEventUDC(hostContext, "1003136", hashMap, true);
            if (TextUtils.isEmpty(str)) {
                hashMap.put("3", "1");
                CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, true);
                return new Pair<>(1, null);
            }
            int i2 = 10;
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    if (this.loadedPluginDB.isPluinUpdating(i)) {
                                        Pair<Integer, Object> pair = new Pair<>(3, null);
                                        try {
                                            hashMap.put("3", Integer.toString(2));
                                            CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, true);
                                        } catch (Throwable unused) {
                                        }
                                        return pair;
                                    } else if (!this.initCalledByHost) {
                                        Pair<Integer, Object> pair2 = new Pair<>(3, null);
                                        try {
                                            hashMap.put("3", Integer.toString(3));
                                            CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, true);
                                        } catch (Throwable unused2) {
                                        }
                                        return pair2;
                                    } else {
                                        PluginloaderHub peekInstance = PluginloaderHub.peekInstance();
                                        if (peekInstance == null) {
                                            Pair<Integer, Object> pair3 = new Pair<>(3, null);
                                            try {
                                                hashMap.put("3", Integer.toString(4));
                                                CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, true);
                                            } catch (Throwable unused3) {
                                            }
                                            return pair3;
                                        }
                                        ApkInfo pluginByID = this.loadedPluginDB.getPluginByID(i);
                                        if (!((pluginByID == null || peekInstance.getApkInfoByPackageName(pluginByID.packageName) == null) ? false : true)) {
                                            Pair<Integer, Object> pair4 = new Pair<>(4, null);
                                            try {
                                                hashMap.put("3", Integer.toString(5));
                                                CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, true);
                                            } catch (Throwable unused4) {
                                            }
                                            return pair4;
                                        }
                                        Class<?> loadClassWithoutParentClass = ((PluginloaderDexClassLoader) peekInstance.getApkInfoByPackageName(pluginByID.packageName).classLoader).loadClassWithoutParentClass(LocalConstant.ENGINE_IMPL_CLASS_FULL_PATH);
                                        return new Pair<>(0, CommonMethods.callMethodOfClass(loadClassWithoutParentClass.getDeclaredMethod("getInstance", Context.class).invoke(loadClassWithoutParentClass, hostContext), str, clsArr, objArr));
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    i2 = 9;
                                    if (i2 != 0) {
                                        try {
                                            hashMap.put("3", Integer.toString(i2));
                                            CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, true);
                                        } catch (Throwable unused5) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (i2 != 0) {
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            i2 = 6;
                            if (i2 != 0) {
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        i2 = 7;
                        if (i2 != 0) {
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    i2 = 8;
                    if (i2 != 0) {
                    }
                    throw th;
                }
            } catch (IllegalAccessException unused6) {
                Pair<Integer, Object> pair5 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(8));
                    CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, true);
                } catch (Throwable unused7) {
                }
                return pair5;
            } catch (IllegalArgumentException unused8) {
                Pair<Integer, Object> pair6 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(9));
                    CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, true);
                } catch (Throwable unused9) {
                }
                return pair6;
            } catch (NoSuchMethodException unused10) {
                Pair<Integer, Object> pair7 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(6));
                    CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, true);
                } catch (Throwable unused11) {
                }
                return pair7;
            } catch (InvocationTargetException unused12) {
                Pair<Integer, Object> pair8 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(7));
                    CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, true);
                } catch (Throwable unused13) {
                }
                return pair8;
            } catch (Throwable unused14) {
                Pair<Integer, Object> pair9 = new Pair<>(3, null);
                try {
                    hashMap.put("3", Integer.toString(10));
                    CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, true);
                } catch (Throwable unused15) {
                }
                return pair9;
            }
        }
        return (Pair) invokeCommon.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? LocalConstant.V : (String) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            init(null);
        }
    }

    public synchronized boolean initPlugin(int i, String str, PackageInfo packageInfo) {
        InterceptResult invokeILL;
        boolean initPlugin;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, str, packageInfo)) == null) {
            synchronized (this) {
                initPlugin = initPlugin(i, str, null, false, packageInfo);
            }
            return initPlugin;
        }
        return invokeILL.booleanValue;
    }

    public boolean initSinglePlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.loadedPluginDB.deletePluginIfAPKNotExist();
            this.initCalledByHost = true;
            return checkSinglePlugin(hostContext, str);
        }
        return invokeL.booleanValue;
    }

    public void loadLocalPlugins(JSONObject jSONObject) {
        ApkInfo apkInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("6");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                int optInt = optJSONObject.optInt("errno");
                int optInt2 = optJSONObject.optInt("l");
                if (optInt == 1) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("detail");
                    PackageInfo packageInfo = new PackageInfo();
                    packageInfo.packageName = optJSONObject2.optString("p");
                    packageInfo.versionName = optJSONObject2.optString("v");
                    ApplicationInfo applicationInfo = new ApplicationInfo();
                    String optString = optJSONObject2.optString("n");
                    applicationInfo.className = optString;
                    if (!TextUtils.isEmpty(optString) && applicationInfo.className.startsWith(".")) {
                        applicationInfo.className = packageInfo.packageName + applicationInfo.className;
                    }
                    applicationInfo.theme = optJSONObject2.optInt("t");
                    packageInfo.applicationInfo = applicationInfo;
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("a");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                            if (jSONObject2 != null) {
                                ActivityInfo activityInfo = new ActivityInfo();
                                String optString2 = jSONObject2.optString("n");
                                activityInfo.name = optString2;
                                if (!TextUtils.isEmpty(optString2) && activityInfo.name.startsWith(".")) {
                                    activityInfo.name = packageInfo.packageName + activityInfo.name;
                                }
                                activityInfo.packageName = packageInfo.packageName;
                                activityInfo.theme = jSONObject2.optInt("t");
                                activityInfo.labelRes = jSONObject2.optInt("l");
                                if (!TextUtils.isEmpty(activityInfo.name)) {
                                    arrayList.add(activityInfo);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                        }
                    }
                    if (CommonMethods.sLocalCheckMap != null && (apkInfo = CommonMethods.sLocalCheckMap.get(Integer.valueOf(optInt2))) != null && packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName)) {
                        try {
                            initLocalForgPlugins(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, packageInfo);
                        } catch (Throwable th) {
                            th = th;
                            CommonMethods.handleNuLException(th);
                            return;
                        }
                    }
                }
            }
            if (CommonMethods.sLocalCheckMap != null) {
                CommonMethods.sLocalCheckMap.clear();
                CommonMethods.sLocalCheckMap = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void loadUsedPlugins() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                List<ApkInfo> allPlugins = this.loadedPluginDB.getAllPlugins();
                List<Integer> localSetPluginKeys = this.mPreferences.getLocalSetPluginKeys();
                List<Integer> hostCarePluginKeys = this.mPreferences.getHostCarePluginKeys();
                for (int i = 0; i < hostCarePluginKeys.size(); i++) {
                    if (!localSetPluginKeys.contains(hostCarePluginKeys.get(i))) {
                        localSetPluginKeys.add(hostCarePluginKeys.get(i));
                    }
                }
                Collections.sort(allPlugins, new Comparator<ApkInfo>(this, localSetPluginKeys) { // from class: com.baidu.sofire.core.ForHostApp.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ForHostApp this$0;
                    public final /* synthetic */ List val$localSetIds;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, localSetPluginKeys};
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
                        this.val$localSetIds = localSetPluginKeys;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(ApkInfo apkInfo, ApkInfo apkInfo2) {
                        InterceptResult invokeLL;
                        int i2;
                        int i3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, apkInfo, apkInfo2)) == null) {
                            if (apkInfo.priority != -1 || apkInfo2.priority == -1) {
                                if ((apkInfo.priority == -1 || apkInfo2.priority != -1) && (i2 = apkInfo.priority) >= (i3 = apkInfo2.priority)) {
                                    if (i2 > i3) {
                                        return 1;
                                    }
                                    List list = this.val$localSetIds;
                                    int indexOf = (list == null || !list.contains(Integer.valueOf(apkInfo.key))) ? -1 : this.val$localSetIds.indexOf(Integer.valueOf(apkInfo.key));
                                    List list2 = this.val$localSetIds;
                                    int indexOf2 = (list2 == null || !list2.contains(Integer.valueOf(apkInfo2.key))) ? -1 : this.val$localSetIds.indexOf(Integer.valueOf(apkInfo2.key));
                                    if (indexOf == -1 || indexOf2 != -1) {
                                        if ((indexOf != -1 || indexOf2 == -1) && indexOf <= indexOf2) {
                                            return indexOf < indexOf2 ? -1 : 0;
                                        }
                                        return 1;
                                    }
                                    return -1;
                                }
                                return -1;
                            }
                            return 1;
                        }
                        return invokeLL.intValue;
                    }
                });
                for (ApkInfo apkInfo : allPlugins) {
                    PluginloaderHub peekInstance = PluginloaderHub.peekInstance();
                    if ((peekInstance != null ? peekInstance.getApkInfoByPackageName(apkInfo.packageName) : null) == null) {
                        boolean z = this.loadedPluginDB.getPluginDeleteStatus(apkInfo.key) != 3;
                        if (this.mPreferences.isNeedBackupAPK() && z) {
                            File file = new File(hostContext.getFilesDir(), ".b");
                            if (!file.exists()) {
                                file.mkdir();
                            }
                            File file2 = new File(apkInfo.pkgPath);
                            File file3 = new File(file, apkInfo.key + "-" + apkInfo.versionName);
                            if (!CommonMethods.isFileExist(file3)) {
                                CommonMethods.copyFile(file2, file3);
                            }
                            FileDeleteObserverUtils.registerObserver(hostContext, apkInfo.key, file2, file3);
                        } else {
                            File file4 = new File(hostContext.getFilesDir(), ".b");
                            if (file4.exists()) {
                                File file5 = new File(file4, apkInfo.key + "-" + apkInfo.versionName);
                                if (CommonMethods.isFileExist(file5)) {
                                    FileDeleteObserverUtils.unRegisterObserver(file5);
                                    file5.delete();
                                }
                            }
                        }
                        initPlugin(apkInfo.key, apkInfo.versionName, null);
                    }
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:108:0x0388
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public boolean newCloudPluginCome(com.baidu.sofire.core.ApkInfo r24, java.lang.String r25, java.lang.String r26) {
        /*
            r23 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.sofire.core.ForHostApp.$ic
            if (r0 != 0) goto L424
        L4:
            r7 = r23
            r8 = r24
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r9 = "\r"
            java.lang.String r10 = "\t"
            java.lang.String r11 = "\n"
            java.lang.String r12 = "3"
            java.lang.String r13 = "1003106"
            java.lang.String r14 = "2"
            java.lang.String r15 = "1"
            java.lang.String r6 = "0"
            java.lang.String r5 = ""
            r4 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            if (r8 != 0) goto L24
            return r4
        L24:
            java.io.File r3 = new java.io.File
            java.lang.String r2 = r8.pkgPath
            r3.<init>(r2)
            boolean r2 = com.baidu.sofire.utility.CommonMethods.isFileExist(r3)     // Catch: java.lang.Throwable -> L3a6
            r4 = 1
            if (r2 != 0) goto Lcf
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> L3a6
            r0.<init>()     // Catch: java.lang.Throwable -> L3a6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L3a6
            r0.put(r6, r1)     // Catch: java.lang.Throwable -> L3a6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a6
            r1.<init>()     // Catch: java.lang.Throwable -> L3a6
            int r2 = r8.key     // Catch: java.lang.Throwable -> L3a6
            r1.append(r2)     // Catch: java.lang.Throwable -> L3a6
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L3a6
            r0.put(r15, r1)     // Catch: java.lang.Throwable -> L3a6
            java.lang.String r1 = r8.versionName     // Catch: java.lang.Throwable -> L3a6
            r0.put(r14, r1)     // Catch: java.lang.Throwable -> L3a6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a6
            java.lang.String r2 = "nowTime:"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3a6
            r17 = r14
            r18 = r15
            long r14 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L399
            r1.append(r14)     // Catch: java.lang.Throwable -> L399
            java.lang.String r2 = ", nowFileInfo: path="
            r1.append(r2)     // Catch: java.lang.Throwable -> L399
            java.lang.String r2 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L399
            r1.append(r2)     // Catch: java.lang.Throwable -> L399
            java.lang.String r2 = ", exists="
            r1.append(r2)     // Catch: java.lang.Throwable -> L399
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L399
            r1.append(r2)     // Catch: java.lang.Throwable -> L399
            java.lang.String r2 = ", canRead="
            r1.append(r2)     // Catch: java.lang.Throwable -> L399
            boolean r2 = r3.canRead()     // Catch: java.lang.Throwable -> L399
            r1.append(r2)     // Catch: java.lang.Throwable -> L399
            java.lang.String r2 = ", isFile="
            r1.append(r2)     // Catch: java.lang.Throwable -> L399
            boolean r2 = r3.isFile()     // Catch: java.lang.Throwable -> L399
            r1.append(r2)     // Catch: java.lang.Throwable -> L399
            java.lang.String r2 = ",length"
            r1.append(r2)     // Catch: java.lang.Throwable -> L399
            long r14 = r3.length()     // Catch: java.lang.Throwable -> L399
            r1.append(r14)     // Catch: java.lang.Throwable -> L399
            java.lang.String r2 = " - "
            r1.append(r2)     // Catch: java.lang.Throwable -> L399
            r2 = r25
            r1.append(r2)     // Catch: java.lang.Throwable -> L399
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L399
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> L399
            r2 = 0
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r2)     // Catch: java.lang.Throwable -> L399
            java.lang.String r1 = r1.replace(r11, r5)     // Catch: java.lang.Throwable -> L399
            java.lang.String r1 = r1.replace(r10, r5)     // Catch: java.lang.Throwable -> L399
            java.lang.String r1 = r1.replace(r9, r5)     // Catch: java.lang.Throwable -> L399
            r0.put(r12, r1)     // Catch: java.lang.Throwable -> L399
            android.content.Context r1 = com.baidu.sofire.core.ForHostApp.hostContext     // Catch: java.lang.Throwable -> L399
            r2 = 0
            com.baidu.sofire.utility.CommonMethods.sendEventUDC(r1, r13, r0, r2)     // Catch: java.lang.Throwable -> L399
            return r2
        Lcf:
            r17 = r14
            r18 = r15
            com.baidu.sofire.d.D r2 = r7.loadedPluginDB     // Catch: java.lang.Throwable -> L399
            int r14 = r8.key     // Catch: java.lang.Throwable -> L399
            boolean r2 = r2.isRecordExit(r14)     // Catch: java.lang.Throwable -> L399
            if (r2 != 0) goto Le2
            com.baidu.sofire.d.D r2 = r7.loadedPluginDB     // Catch: java.lang.Throwable -> L399
            r2.insertOrUpdatePluginRecord(r8)     // Catch: java.lang.Throwable -> L399
        Le2:
            android.content.Context r2 = com.baidu.sofire.core.ForHostApp.hostContext     // Catch: java.lang.Throwable -> L399
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Throwable -> L399
            com.baidu.sofire.core.PluginloaderHub r2 = com.baidu.sofire.core.PluginloaderHub.createSingleInstance(r2)     // Catch: java.lang.Throwable -> L399
            com.baidu.sofire.d.D r14 = r7.loadedPluginDB     // Catch: java.lang.Throwable -> L399
            int r15 = r8.key     // Catch: java.lang.Throwable -> L399
            r14.changePluginUpdatingStatus(r15, r4)     // Catch: java.lang.Throwable -> L399
            java.lang.String r14 = r8.packageName     // Catch: java.lang.Throwable -> L399
            r7.updatePlugin(r14)     // Catch: java.lang.Throwable -> L399
            boolean r14 = r2.syncLoadApk(r8, r4, r4)     // Catch: java.lang.Throwable -> L399
            r15 = 2
            if (r14 != 0) goto L173
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> L16b
            r0.<init>()     // Catch: java.lang.Throwable -> L16b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r15)     // Catch: java.lang.Throwable -> L16b
            r0.put(r6, r1)     // Catch: java.lang.Throwable -> L16b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L16b
            r1.<init>()     // Catch: java.lang.Throwable -> L16b
            int r2 = r8.key     // Catch: java.lang.Throwable -> L16b
            r1.append(r2)     // Catch: java.lang.Throwable -> L16b
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L16b
            r14 = r18
            r0.put(r14, r1)     // Catch: java.lang.Throwable -> L169
            java.lang.String r1 = r8.versionName     // Catch: java.lang.Throwable -> L169
            r15 = r17
            r0.put(r15, r1)     // Catch: java.lang.Throwable -> L161
            android.content.Context r1 = com.baidu.sofire.core.ForHostApp.hostContext     // Catch: java.lang.Throwable -> L161
            r4 = 0
            com.baidu.sofire.utility.CommonMethods.sendEventUDC(r1, r13, r0, r4)     // Catch: java.lang.Throwable -> L161
            com.baidu.sofire.FileDeleteObserverUtils.unRegisterObserver(r3)     // Catch: java.lang.Throwable -> L161
            r3.delete()     // Catch: java.lang.Throwable -> L161
            int r2 = r8.key     // Catch: java.lang.Throwable -> L161
            java.lang.String r0 = r8.versionName     // Catch: java.lang.Throwable -> L161
            r16 = 1
            r17 = 0
            r1 = r23
            r18 = r3
            r3 = r0
            r25 = r15
            r15 = 0
            r4 = r26
            r19 = r5
            r5 = r16
            r20 = r6
            r6 = r17
            r1.initPlugin(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L156
            com.baidu.sofire.d.D r0 = r7.loadedPluginDB     // Catch: java.lang.Throwable -> L156
            int r1 = r8.key     // Catch: java.lang.Throwable -> L156
            r0.changePluginUpdatingStatus(r1, r15)     // Catch: java.lang.Throwable -> L156
            return r15
        L156:
            r0 = move-exception
            r17 = r12
            r15 = r19
            r6 = r20
            r12 = r25
            goto L3ae
        L161:
            r0 = move-exception
            r18 = r3
            r17 = r12
            r12 = r15
            goto L3ad
        L169:
            r0 = move-exception
            goto L16e
        L16b:
            r0 = move-exception
            r14 = r18
        L16e:
            r18 = r3
            r15 = r5
            goto L39f
        L173:
            r19 = r5
            r20 = r6
            r6 = r17
            r14 = r18
            r15 = 0
            r18 = r3
            r3 = 2
            android.content.Context r5 = com.baidu.sofire.core.ForHostApp.hostContext     // Catch: java.lang.Throwable -> L390
            java.lang.String[] r5 = com.baidu.sofire.utility.CommonMethods.selectAppKeyAndSecurityKey(r5)     // Catch: java.lang.Throwable -> L390
            if (r5 == 0) goto L1a0
            int r4 = r5.length     // Catch: java.lang.Throwable -> L390
            if (r4 != r3) goto L1a0
            r4 = r5[r15]     // Catch: java.lang.Throwable -> L390
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L390
            if (r4 != 0) goto L1a0
            r4 = 1
            r16 = r5[r4]     // Catch: java.lang.Throwable -> L390
            boolean r16 = android.text.TextUtils.isEmpty(r16)     // Catch: java.lang.Throwable -> L390
            if (r16 != 0) goto L1a0
            r17 = r5[r15]     // Catch: java.lang.Throwable -> L390
            r5 = r5[r4]     // Catch: java.lang.Throwable -> L390
            goto L1a4
        L1a0:
            java.lang.String r17 = com.baidu.sofire.utility.CommonMethods.APPKEY_DEFULT     // Catch: java.lang.Throwable -> L390
            java.lang.String r5 = com.baidu.sofire.utility.CommonMethods.SECKEY_DEFULT     // Catch: java.lang.Throwable -> L390
        L1a4:
            java.lang.String r4 = r8.pkgPath     // Catch: java.lang.Throwable -> L390
            com.baidu.sofire.core.ApkInfo r8 = r2.getApkInfoByPath(r4)     // Catch: java.lang.Throwable -> L390
            if (r8 != 0) goto L1ad
            return r15
        L1ad:
            java.lang.ClassLoader r2 = r8.classLoader     // Catch: java.lang.Throwable -> L390
            com.baidu.sofire.core.PluginloaderDexClassLoader r2 = (com.baidu.sofire.core.PluginloaderDexClassLoader) r2     // Catch: java.lang.Throwable -> L390
            java.lang.String r4 = "com.baidu.sofire.engine.EngineImpl"
            java.lang.Class r4 = r2.loadClassWithoutParentClass(r4)     // Catch: java.lang.Throwable -> L390
            if (r4 != 0) goto L234
            java.lang.String r0 = "java.lang.String"
            java.lang.Class r0 = r2.loadClassWithoutParentClass(r0)     // Catch: java.lang.Throwable -> L390
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L390
            r1.<init>()     // Catch: java.lang.Throwable -> L390
            r3 = 6
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L390
            r4 = r20
            r1.put(r4, r3)     // Catch: java.lang.Throwable -> L22b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L22b
            r3.<init>()     // Catch: java.lang.Throwable -> L22b
            int r5 = r8.key     // Catch: java.lang.Throwable -> L22b
            r3.append(r5)     // Catch: java.lang.Throwable -> L22b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L22b
            r1.put(r14, r3)     // Catch: java.lang.Throwable -> L22b
            java.lang.String r3 = r8.versionName     // Catch: java.lang.Throwable -> L22b
            r1.put(r6, r3)     // Catch: java.lang.Throwable -> L22b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L22b
            java.lang.String r5 = "classloader="
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L22b
            r3.append(r2)     // Catch: java.lang.Throwable -> L22b
            java.lang.String r2 = ",StringClass="
            r3.append(r2)     // Catch: java.lang.Throwable -> L22b
            r3.append(r0)     // Catch: java.lang.Throwable -> L22b
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L22b
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L22b
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r15)     // Catch: java.lang.Throwable -> L22b
            r2 = r19
            java.lang.String r0 = r0.replace(r11, r2)     // Catch: java.lang.Throwable -> L226
            java.lang.String r0 = r0.replace(r10, r2)     // Catch: java.lang.Throwable -> L226
            java.lang.String r0 = r0.replace(r9, r2)     // Catch: java.lang.Throwable -> L226
            r1.put(r12, r0)     // Catch: java.lang.Throwable -> L226
            android.content.Context r0 = com.baidu.sofire.core.ForHostApp.hostContext     // Catch: java.lang.Throwable -> L226
            com.baidu.sofire.utility.CommonMethods.sendEventUDC(r0, r13, r1, r15)     // Catch: java.lang.Throwable -> L226
            com.baidu.sofire.FileDeleteObserverUtils.unRegisterObserver(r18)     // Catch: java.lang.Throwable -> L226
            r18.delete()     // Catch: java.lang.Throwable -> L226
            com.baidu.sofire.d.D r0 = r7.loadedPluginDB     // Catch: java.lang.Throwable -> L226
            int r1 = r8.key     // Catch: java.lang.Throwable -> L226
            r0.changePluginUpdatingStatus(r1, r15)     // Catch: java.lang.Throwable -> L226
            return r15
        L226:
            r0 = move-exception
            r15 = r2
            r17 = r12
            goto L230
        L22b:
            r0 = move-exception
            r17 = r12
            r15 = r19
        L230:
            r12 = r6
            r6 = r4
            goto L3ae
        L234:
            r2 = r19
            r21 = r20
            java.lang.String r3 = "getInstance"
            r24 = r2
            r15 = 1
            java.lang.Class[] r2 = new java.lang.Class[r15]     // Catch: java.lang.Throwable -> L384
            java.lang.Class<android.content.Context> r16 = android.content.Context.class
            r20 = 0
            r2[r20] = r16     // Catch: java.lang.Throwable -> L384
            java.lang.reflect.Method r2 = r4.getDeclaredMethod(r3, r2)     // Catch: java.lang.Throwable -> L384
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch: java.lang.Throwable -> L384
            android.content.Context r15 = com.baidu.sofire.core.ForHostApp.hostContext     // Catch: java.lang.Throwable -> L384
            r3[r20] = r15     // Catch: java.lang.Throwable -> L384
            java.lang.Object r2 = r2.invoke(r4, r3)     // Catch: java.lang.Throwable -> L384
            java.lang.String r3 = "setSecurityVerifyInfo"
            r4 = 2
            java.lang.Class[] r15 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> L268
            r15[r20] = r0     // Catch: java.lang.Throwable -> L268
            r16 = 1
            r15[r16] = r0     // Catch: java.lang.Throwable -> L268
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L268
            r0[r20] = r17     // Catch: java.lang.Throwable -> L268
            r0[r16] = r5     // Catch: java.lang.Throwable -> L268
            com.baidu.sofire.utility.CommonMethods.callMethodOfClass(r2, r3, r15, r0)     // Catch: java.lang.Throwable -> L268
            goto L26c
        L268:
            r0 = move-exception
            com.baidu.sofire.utility.CommonMethods.handleNuLException(r0)     // Catch: java.lang.Throwable -> L384
        L26c:
            java.lang.String r0 = "init"
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L384
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L384
            r15 = 0
            r4[r15] = r5     // Catch: java.lang.Throwable -> L384
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch: java.lang.Throwable -> L384
            r16 = 1
            r4[r16] = r5     // Catch: java.lang.Throwable -> L384
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L384
            r3[r15] = r1     // Catch: java.lang.Throwable -> L384
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L384
            r3[r16] = r5     // Catch: java.lang.Throwable -> L384
            java.lang.Object r0 = com.baidu.sofire.utility.CommonMethods.callMethodOfClass(r2, r0, r4, r3)     // Catch: java.lang.Throwable -> L384
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L384
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L384
            if (r0 != 0) goto L2e5
            com.baidu.sofire.FileDeleteObserverUtils.unRegisterObserver(r18)     // Catch: java.lang.Throwable -> L384
            java.lang.String r0 = r8.packageName     // Catch: java.lang.Throwable -> L384
            r7.updatePlugin(r0)     // Catch: java.lang.Throwable -> L384
            r18.delete()     // Catch: java.lang.Throwable -> L384
            int r2 = r8.key     // Catch: java.lang.Throwable -> L384
            java.lang.String r3 = r8.versionName     // Catch: java.lang.Throwable -> L384
            r5 = 1
            r0 = 0
            r1 = r23
            r15 = r24
            r4 = r26
            r17 = r12
            r12 = r6
            r6 = r0
            r1.initPlugin(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2e2
            com.baidu.sofire.d.D r0 = r7.loadedPluginDB     // Catch: java.lang.Throwable -> L2e2
            int r1 = r8.key     // Catch: java.lang.Throwable -> L2e2
            r2 = 0
            r0.changePluginUpdatingStatus(r1, r2)     // Catch: java.lang.Throwable -> L2e2
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> L2e2
            r0.<init>()     // Catch: java.lang.Throwable -> L2e2
            r1 = 4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L2e2
            r6 = r21
            r0.put(r6, r1)     // Catch: java.lang.Throwable -> L382
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L382
            r1.<init>()     // Catch: java.lang.Throwable -> L382
            int r2 = r8.key     // Catch: java.lang.Throwable -> L382
            r1.append(r2)     // Catch: java.lang.Throwable -> L382
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L382
            r0.put(r14, r1)     // Catch: java.lang.Throwable -> L382
            java.lang.String r1 = r8.versionName     // Catch: java.lang.Throwable -> L382
            r0.put(r12, r1)     // Catch: java.lang.Throwable -> L382
            android.content.Context r1 = com.baidu.sofire.core.ForHostApp.hostContext     // Catch: java.lang.Throwable -> L382
            r2 = 0
            com.baidu.sofire.utility.CommonMethods.sendEventUDC(r1, r13, r0, r2)     // Catch: java.lang.Throwable -> L382
            return r2
        L2e2:
            r0 = move-exception
            goto L38d
        L2e5:
            r15 = r24
            r17 = r12
            r12 = r6
            r6 = r21
            boolean r0 = r8.isMem     // Catch: java.lang.Throwable -> L382
            if (r0 == 0) goto L30a
            com.baidu.sofire.FileDeleteObserverUtils.unRegisterObserver(r18)     // Catch: java.lang.Throwable -> L382
            r18.delete()     // Catch: java.lang.Throwable -> L382
            java.lang.String r0 = r8.dataDir     // Catch: java.lang.Throwable -> L382
            com.baidu.sofire.utility.CommonMethods.deleteDir(r0)     // Catch: java.lang.Throwable -> L382
            java.util.List<java.lang.Integer> r0 = com.baidu.sofire.core.PluginloaderHub.sMemRunning     // Catch: java.lang.Throwable -> L382
            if (r0 == 0) goto L30a
            java.util.List<java.lang.Integer> r0 = com.baidu.sofire.core.PluginloaderHub.sMemRunning     // Catch: java.lang.Throwable -> L382
            int r2 = r8.key     // Catch: java.lang.Throwable -> L382
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L382
            r0.add(r2)     // Catch: java.lang.Throwable -> L382
        L30a:
            com.baidu.sofire.d.D r0 = r7.loadedPluginDB     // Catch: java.lang.Throwable -> L37c
            int r2 = r8.key     // Catch: java.lang.Throwable -> L37c
            com.baidu.sofire.core.ApkInfo r0 = r0.getPluginByID(r2)     // Catch: java.lang.Throwable -> L37c
            r2 = 0
            if (r0 == 0) goto L326
            java.lang.String r3 = r0.versionName     // Catch: java.lang.Throwable -> L37c
            java.lang.String r4 = r8.versionName     // Catch: java.lang.Throwable -> L37c
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L37c
            if (r3 != 0) goto L326
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L37c
            java.lang.String r0 = r0.pkgPath     // Catch: java.lang.Throwable -> L37c
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L37c
        L326:
            r3 = 1
            r8.initStatus = r3     // Catch: java.lang.Throwable -> L37c
            r8.apkParseSuc = r3     // Catch: java.lang.Throwable -> L37c
            com.baidu.sofire.d.D r0 = r7.loadedPluginDB     // Catch: java.lang.Throwable -> L37c
            long r3 = r0.insertOrUpdatePluginRecord(r8)     // Catch: java.lang.Throwable -> L37c
            r9 = 0
            int r0 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r0 <= 0) goto L345
            if (r2 == 0) goto L345
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L37c
            if (r0 == 0) goto L345
            com.baidu.sofire.FileDeleteObserverUtils.unRegisterObserver(r2)     // Catch: java.lang.Throwable -> L37c
            r2.delete()     // Catch: java.lang.Throwable -> L37c
        L345:
            com.baidu.sofire.d.D r0 = r7.loadedPluginDB     // Catch: java.lang.Throwable -> L37c
            int r2 = r8.key     // Catch: java.lang.Throwable -> L37c
            r3 = 0
            r0.changePluginUpdatingStatus(r2, r3)     // Catch: java.lang.Throwable -> L37c
            int r0 = r8.key     // Catch: java.lang.Throwable -> L37c
            com.baidu.sofire.utility.MutiPlatformAdapter.setTechainResouse(r7, r0)     // Catch: java.lang.Throwable -> L37c
            android.content.Context r0 = com.baidu.sofire.core.ForHostApp.hostContext     // Catch: java.lang.Throwable -> L37c
            com.baidu.sofire.utility.CommonMethods.setAliveData(r0)     // Catch: java.lang.Throwable -> L37c
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> L37c
            r0.<init>()     // Catch: java.lang.Throwable -> L37c
            r0.put(r6, r1)     // Catch: java.lang.Throwable -> L37c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L37c
            r1.<init>()     // Catch: java.lang.Throwable -> L37c
            int r2 = r8.key     // Catch: java.lang.Throwable -> L37c
            r1.append(r2)     // Catch: java.lang.Throwable -> L37c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L37c
            r0.put(r14, r1)     // Catch: java.lang.Throwable -> L37c
            java.lang.String r1 = r8.versionName     // Catch: java.lang.Throwable -> L37c
            r0.put(r12, r1)     // Catch: java.lang.Throwable -> L37c
            android.content.Context r1 = com.baidu.sofire.core.ForHostApp.hostContext     // Catch: java.lang.Throwable -> L37c
            r2 = 0
            com.baidu.sofire.utility.CommonMethods.sendEventUDC(r1, r13, r0, r2)     // Catch: java.lang.Throwable -> L37c
            goto L380
        L37c:
            r0 = move-exception
            com.baidu.sofire.utility.CommonMethods.handleNuLException(r0)
        L380:
            r1 = 1
            return r1
        L382:
            r0 = move-exception
            goto L3ae
        L384:
            r0 = move-exception
            r15 = r24
            goto L38a
        L388:
            r0 = move-exception
            r15 = r2
        L38a:
            r17 = r12
            r12 = r6
        L38d:
            r6 = r21
            goto L3ae
        L390:
            r0 = move-exception
            r17 = r12
            r15 = r19
            r12 = r6
            r6 = r20
            goto L3ae
        L399:
            r0 = move-exception
            r15 = r5
            r14 = r18
            r18 = r3
        L39f:
            r22 = r17
            r17 = r12
            r12 = r22
            goto L3ae
        L3a6:
            r0 = move-exception
            r18 = r3
            r17 = r12
            r12 = r14
            r14 = r15
        L3ad:
            r15 = r5
        L3ae:
            com.baidu.sofire.FileDeleteObserverUtils.unRegisterObserver(r18)     // Catch: java.lang.Throwable -> L41e
            java.lang.String r1 = r8.packageName     // Catch: java.lang.Throwable -> L41e
            r7.updatePlugin(r1)     // Catch: java.lang.Throwable -> L41e
            r18.delete()     // Catch: java.lang.Throwable -> L41e
            int r2 = r8.key     // Catch: java.lang.Throwable -> L41e
            java.lang.String r3 = r8.versionName     // Catch: java.lang.Throwable -> L41e
            r5 = 1
            r16 = 0
            r1 = r23
            r4 = r26
            r18 = r13
            r13 = r6
            r6 = r16
            r1.initPlugin(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L41e
            com.baidu.sofire.d.D r1 = r7.loadedPluginDB     // Catch: java.lang.Throwable -> L41e
            int r2 = r8.key     // Catch: java.lang.Throwable -> L41e
            r3 = 0
            r1.changePluginUpdatingStatus(r2, r3)     // Catch: java.lang.Throwable -> L41e
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L41e
            r1.<init>()     // Catch: java.lang.Throwable -> L41e
            r2 = 5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L41e
            r1.put(r13, r2)     // Catch: java.lang.Throwable -> L41e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41e
            r2.<init>()     // Catch: java.lang.Throwable -> L41e
            int r3 = r8.key     // Catch: java.lang.Throwable -> L41e
            r2.append(r3)     // Catch: java.lang.Throwable -> L41e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L41e
            r1.put(r14, r2)     // Catch: java.lang.Throwable -> L41e
            java.lang.String r2 = r8.versionName     // Catch: java.lang.Throwable -> L41e
            r1.put(r12, r2)     // Catch: java.lang.Throwable -> L41e
            java.lang.String r0 = com.baidu.sofire.BaiduLog.getStackTraceString(r0)     // Catch: java.lang.Throwable -> L41e
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L41e
            r2 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r2)     // Catch: java.lang.Throwable -> L41e
            java.lang.String r0 = r0.replace(r11, r15)     // Catch: java.lang.Throwable -> L41e
            java.lang.String r0 = r0.replace(r10, r15)     // Catch: java.lang.Throwable -> L41e
            java.lang.String r0 = r0.replace(r9, r15)     // Catch: java.lang.Throwable -> L41e
            r2 = r17
            r1.put(r2, r0)     // Catch: java.lang.Throwable -> L41e
            android.content.Context r0 = com.baidu.sofire.core.ForHostApp.hostContext     // Catch: java.lang.Throwable -> L41e
            r2 = r18
            r3 = 0
            com.baidu.sofire.utility.CommonMethods.sendEventUDC(r0, r2, r1, r3)     // Catch: java.lang.Throwable -> L41e
            goto L422
        L41e:
            r0 = move-exception
            com.baidu.sofire.utility.CommonMethods.handleNuLException(r0)
        L422:
            r1 = 0
            return r1
        L424:
            r21 = r0
            r22 = 1048591(0x10000f, float:1.469389E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r21.invokeLLL(r22, r23, r24, r25, r26)
            if (r0 == 0) goto L4
            boolean r1 = r0.booleanValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.core.ForHostApp.newCloudPluginCome(com.baidu.sofire.core.ApkInfo, java.lang.String, java.lang.String):boolean");
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, sharedPreferences, str) == null) || str == null) {
            return;
        }
        try {
            if (str.equals("xytk")) {
                MethodImpl.SGZ = this.mPreferences.getToken();
            }
            if (str.equals("xyus")) {
                this.mPreferences.getCUID();
            }
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public void setSecurityVerifyInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (CommonMethods.APPKEY_DEFULT.equals(str) && CommonMethods.SECKEY_DEFULT.equals(str2)) {
                        return;
                    }
                    CommonMethods.setSecurityVerifyInfo(str, str2);
                    this.mPreferences.setSecurityVerifyInfo(str, str2);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void setSecurityVerifyInfoMark(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (CommonMethods.APPKEY_DEFULT.equals(str) && CommonMethods.SECKEY_DEFULT.equals(str2)) {
                        return;
                    }
                    this.mPreferences.setSecurityVerifyInfoMark(str, str2);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void unloadPlugin(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            try {
                ThreadPoolManager.getInstance(hostContext).execute(new Runnable(this, str) { // from class: com.baidu.sofire.core.ForHostApp.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ForHostApp this$0;
                    public final /* synthetic */ String val$packageName;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$packageName = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        PluginloaderHub createSingleInstance;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (TextUtils.isEmpty(this.val$packageName) || (createSingleInstance = PluginloaderHub.createSingleInstance(ForHostApp.hostContext.getApplicationContext())) == null) {
                                    return;
                                }
                                File file = new File(ForHostApp.hostContext.getFilesDir(), ".b");
                                ApkInfo apkInfoByPackageName = createSingleInstance.getApkInfoByPackageName(this.val$packageName);
                                if (apkInfoByPackageName == null) {
                                    ApkInfo pluginByPkg = this.this$0.loadedPluginDB.getPluginByPkg(this.val$packageName);
                                    if (pluginByPkg == null) {
                                        return;
                                    }
                                    this.this$0.deleteNotLoadedPlugin(this.val$packageName, pluginByPkg.pkgPath);
                                    if (file.exists()) {
                                        File file2 = new File(file, pluginByPkg.key + "-" + pluginByPkg.versionName);
                                        if (CommonMethods.isFileExist(file2)) {
                                            file2.delete();
                                        }
                                    }
                                    if (pluginByPkg != null) {
                                        String canonicalPath = ForHostApp.hostContext.getFilesDir().getCanonicalPath();
                                        CommonMethods.deleteDir(canonicalPath + "/." + pluginByPkg.key);
                                        CommonMethods.deleteDir(ForHostApp.hostContext.getFileStreamPath(pluginByPkg.packageName).getAbsolutePath());
                                    }
                                    String sb = new StringBuilder(this.val$packageName).reverse().toString();
                                    ApkInfo pluginByPkg2 = this.this$0.loadedPluginDB.getPluginByPkg(sb);
                                    if (pluginByPkg2 != null) {
                                        this.this$0.deleteNotLoadedPlugin(sb, pluginByPkg2.pkgPath);
                                        return;
                                    }
                                    return;
                                }
                                Class<?> loadClassWithoutParentClass = ((PluginloaderDexClassLoader) apkInfoByPackageName.classLoader).loadClassWithoutParentClass(LocalConstant.ENGINE_IMPL_CLASS_FULL_PATH);
                                Object invoke = loadClassWithoutParentClass.getDeclaredMethod("getInstance", Context.class).invoke(loadClassWithoutParentClass, ForHostApp.hostContext);
                                if (invoke == null) {
                                    return;
                                }
                                new Timer().schedule(new TimerTask(this, createSingleInstance, apkInfoByPackageName, file) { // from class: com.baidu.sofire.core.ForHostApp.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass2 this$1;
                                    public final /* synthetic */ PluginloaderHub val$apkHub;
                                    public final /* synthetic */ ApkInfo val$apkInfo;
                                    public final /* synthetic */ File val$backupDir;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, createSingleInstance, apkInfoByPackageName, file};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$apkHub = createSingleInstance;
                                        this.val$apkInfo = apkInfoByPackageName;
                                        this.val$backupDir = file;
                                    }

                                    @Override // java.util.TimerTask, java.lang.Runnable
                                    public void run() {
                                        ApkInfo apkInfoByPackageName2;
                                        String str2;
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (apkInfoByPackageName2 = this.val$apkHub.getApkInfoByPackageName(this.this$1.val$packageName)) == null || (str2 = apkInfoByPackageName2.versionName) == null || !str2.equals(this.val$apkInfo.versionName)) {
                                            return;
                                        }
                                        this.val$apkHub.unloadApkByPack(this.this$1.val$packageName);
                                        this.this$1.this$0.loadedPluginDB.deleteLoadedPluginByPackage(this.this$1.val$packageName);
                                        CommonMethods.setAliveData(ForHostApp.hostContext);
                                        File file3 = new File(this.val$apkInfo.pkgPath);
                                        if (file3.exists()) {
                                            FileDeleteObserverUtils.unRegisterObserver(file3);
                                            file3.delete();
                                        }
                                        if (this.val$backupDir.exists()) {
                                            File file4 = this.val$backupDir;
                                            File file5 = new File(file4, this.val$apkInfo.key + "-" + this.val$apkInfo.versionName);
                                            if (CommonMethods.isFileExist(file5)) {
                                                file5.delete();
                                            }
                                        }
                                        String sb2 = new StringBuilder(this.this$1.val$packageName).reverse().toString();
                                        ApkInfo pluginByPkg3 = this.this$1.this$0.loadedPluginDB.getPluginByPkg(sb2);
                                        if (pluginByPkg3 != null) {
                                            this.this$1.this$0.deleteNotLoadedPlugin(sb2, pluginByPkg3.pkgPath);
                                        }
                                    }
                                }, 600000L);
                                CommonMethods.callMethodOfClass(invoke, "unload", null, new Object[0]);
                                createSingleInstance.unloadApkByPack(this.val$packageName);
                                this.this$0.loadedPluginDB.deleteLoadedPluginByPackage(this.val$packageName);
                                CommonMethods.setAliveData(ForHostApp.hostContext);
                                File file3 = new File(apkInfoByPackageName.pkgPath);
                                if (file3.exists()) {
                                    FileDeleteObserverUtils.unRegisterObserver(file3);
                                    file3.delete();
                                }
                                if (file.exists()) {
                                    File file4 = new File(file, apkInfoByPackageName.key + "-" + apkInfoByPackageName.versionName);
                                    if (CommonMethods.isFileExist(file4)) {
                                        file4.delete();
                                    }
                                }
                                String sb2 = new StringBuilder(this.val$packageName).reverse().toString();
                                ApkInfo pluginByPkg3 = this.this$0.loadedPluginDB.getPluginByPkg(sb2);
                                if (pluginByPkg3 != null) {
                                    this.this$0.deleteNotLoadedPlugin(sb2, pluginByPkg3.pkgPath);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void updatePlugin(String str) {
        PluginloaderHub peekInstance;
        ApkInfo apkInfoByPackageName;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str) || (peekInstance = PluginloaderHub.peekInstance()) == null || (apkInfoByPackageName = peekInstance.getApkInfoByPackageName(str)) == null) {
                    return;
                }
                Class<?> loadClassWithoutParentClass = ((PluginloaderDexClassLoader) apkInfoByPackageName.classLoader).loadClassWithoutParentClass(LocalConstant.ENGINE_IMPL_CLASS_FULL_PATH);
                Object invoke = loadClassWithoutParentClass.getDeclaredMethod("getInstance", Context.class).invoke(loadClassWithoutParentClass, hostContext);
                if (invoke == null) {
                    return;
                }
                CommonMethods.callMethodOfClass(invoke, "unload", null, new Object[0]);
                peekInstance.unloadApkByPack(str);
            } catch (Throwable unused) {
            }
        }
    }

    private synchronized boolean initPlugin(int i, String str, String str2, boolean z, PackageInfo packageInfo) {
        InterceptResult invokeCommon;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Integer.valueOf(i), str, str2, Boolean.valueOf(z), packageInfo})) == null) {
            synchronized (this) {
                if (z) {
                    try {
                        if (this.loadedPluginDB.getPluginInitStatusByPluginKey(i) != 1) {
                            return false;
                        }
                    } catch (Throwable th) {
                        CommonMethods.handleNuLException(th);
                        return false;
                    }
                }
                ApkInfo pluginByID = this.loadedPluginDB.getPluginByID(i);
                if (pluginByID == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", String.valueOf(i));
                    hashMap.put("2", str);
                    if (!z) {
                        CommonMethods.sendEventUDC(hostContext, "1003105", hashMap, false);
                    }
                    return false;
                } else if (!CommonMethods.isFileExist(new File(pluginByID.pkgPath))) {
                    this.loadedPluginDB.updatePluginInitStatus(i, -1);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("0", 3);
                    hashMap2.put("1", String.valueOf(i));
                    hashMap2.put("2", str);
                    if (!z) {
                        CommonMethods.sendEventUDC(hostContext, "1003105", hashMap2, false);
                    }
                    return false;
                } else {
                    if (packageInfo != null) {
                        pluginByID.cloudPkgInfo = packageInfo;
                    }
                    PluginloaderHub createSingleInstance = PluginloaderHub.createSingleInstance(hostContext.getApplicationContext());
                    if (!createSingleInstance.syncLoadApk(pluginByID, z, false)) {
                        this.loadedPluginDB.updatePluginInitStatus(i, -1);
                        createSingleInstance.unloadApk(pluginByID.pkgPath);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("0", 4);
                        hashMap3.put("1", String.valueOf(i));
                        hashMap3.put("2", str);
                        if (!z) {
                            CommonMethods.sendEventUDC(hostContext, "1003105", hashMap3, false);
                        }
                        return false;
                    }
                    String[] selectAppKeyAndSecurityKey = CommonMethods.selectAppKeyAndSecurityKey(hostContext);
                    if (selectAppKeyAndSecurityKey != null && selectAppKeyAndSecurityKey.length == 2 && !TextUtils.isEmpty(selectAppKeyAndSecurityKey[0]) && !TextUtils.isEmpty(selectAppKeyAndSecurityKey[1])) {
                        str3 = selectAppKeyAndSecurityKey[0];
                        str4 = selectAppKeyAndSecurityKey[1];
                    } else {
                        str3 = CommonMethods.APPKEY_DEFULT;
                        str4 = CommonMethods.SECKEY_DEFULT;
                    }
                    ApkInfo apkInfoByPath = createSingleInstance.getApkInfoByPath(pluginByID.pkgPath);
                    PluginloaderDexClassLoader pluginloaderDexClassLoader = (PluginloaderDexClassLoader) apkInfoByPath.classLoader;
                    Class<?> loadClassWithoutParentClass = pluginloaderDexClassLoader.loadClassWithoutParentClass(LocalConstant.ENGINE_IMPL_CLASS_FULL_PATH);
                    if (loadClassWithoutParentClass == null) {
                        Class<?> loadClassWithoutParentClass2 = pluginloaderDexClassLoader.loadClassWithoutParentClass("java.lang.String");
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("0", 9);
                        hashMap4.put("1", String.valueOf(i));
                        hashMap4.put("2", str);
                        hashMap4.put("3", Base64.encodeToString(("classloader=" + pluginloaderDexClassLoader + ",StringClass=" + loadClassWithoutParentClass2).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                        if (!z) {
                            CommonMethods.sendEventUDC(hostContext, "1003105", hashMap4, false);
                        }
                        this.loadedPluginDB.updatePluginInitStatus(i, -1);
                        return false;
                    }
                    Object invoke = loadClassWithoutParentClass.getDeclaredMethod("getInstance", Context.class).invoke(loadClassWithoutParentClass, hostContext);
                    CommonMethods.callMethodOfClass(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str3, str4);
                    if (!((Boolean) CommonMethods.callMethodOfClass(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.TRUE)).booleanValue()) {
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("0", 6);
                        hashMap5.put("1", String.valueOf(i));
                        hashMap5.put("2", str);
                        if (!z) {
                            CommonMethods.sendEventUDC(hostContext, "1003105", hashMap5, false);
                        }
                        this.loadedPluginDB.updatePluginInitStatus(i, -1);
                        createSingleInstance.unloadApk(apkInfoByPath.pkgPath);
                        return false;
                    }
                    apkInfoByPath.initStatus = 1;
                    apkInfoByPath.apkParseSuc = 1;
                    this.loadedPluginDB.insertOrUpdatePluginRecord(apkInfoByPath);
                    int pluginDeleteStatus = this.loadedPluginDB.getPluginDeleteStatus(apkInfoByPath.key);
                    if (pluginDeleteStatus < 3 && pluginDeleteStatus != -1) {
                        this.loadedPluginDB.updatePluginDeleteStatus(apkInfoByPath.key, pluginDeleteStatus + 1);
                    }
                    MutiPlatformAdapter.setTechainResouse(this, apkInfoByPath.key);
                    HashMap hashMap6 = new HashMap();
                    hashMap6.put("0", 0);
                    hashMap6.put("1", Integer.valueOf(i));
                    hashMap6.put("2", str);
                    if (!z) {
                        CommonMethods.sendEventUDC(hostContext, "1003105", hashMap6, false);
                    }
                    CommonMethods.setAliveData(hostContext);
                    return true;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execEngineImpl(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), str, callback, clsArr, objArr}) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("0", Integer.toString(i));
                hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
                hashMap.put("2", "0");
                CommonMethods.sendEventUDC(hostContext, "1003136", hashMap, false);
                if (TextUtils.isEmpty(str)) {
                    if (callback != null) {
                        callback.onError(1);
                    }
                    hashMap.put("3", "11");
                    CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, false);
                    return;
                }
                int i2 = 18;
                if (callback != null) {
                    try {
                        callback.onBegin(new Object[0]);
                    } catch (IllegalAccessException unused) {
                        if (callback != null) {
                            try {
                                callback.onError(2);
                            } catch (Throwable th) {
                                th = th;
                                i2 = 16;
                                if (i2 != 0) {
                                    try {
                                        hashMap.put("3", Integer.toString(i2));
                                        CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, false);
                                    } catch (Throwable unused2) {
                                    }
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(16));
                            CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, false);
                            return;
                        } catch (Throwable unused3) {
                            return;
                        }
                    } catch (IllegalArgumentException unused4) {
                        if (callback != null) {
                            try {
                                callback.onError(2);
                            } catch (Throwable th2) {
                                th = th2;
                                i2 = 17;
                                if (i2 != 0) {
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(17));
                            CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, false);
                            return;
                        } catch (Throwable unused5) {
                            return;
                        }
                    } catch (NoSuchMethodException unused6) {
                        if (callback != null) {
                            try {
                                callback.onError(2);
                            } catch (Throwable th3) {
                                th = th3;
                                i2 = 14;
                                if (i2 != 0) {
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(14));
                            CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, false);
                            return;
                        } catch (Throwable unused7) {
                            return;
                        }
                    } catch (InvocationTargetException unused8) {
                        if (callback != null) {
                            try {
                                callback.onError(2);
                            } catch (Throwable th4) {
                                th = th4;
                                i2 = 15;
                                if (i2 != 0) {
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(15));
                            CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, false);
                            return;
                        } catch (Throwable unused9) {
                            return;
                        }
                    } catch (Throwable unused10) {
                        if (callback != null) {
                            try {
                                callback.onError(3);
                            } catch (Throwable th5) {
                                th = th5;
                                if (i2 != 0) {
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(18));
                            CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, false);
                            return;
                        } catch (Throwable unused11) {
                            return;
                        }
                    }
                }
                if (this.loadedPluginDB.isPluinUpdating(i)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (this.loadedPluginDB.isPluinUpdating(i) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                        SystemClock.sleep(300L);
                    }
                }
                if (this.loadedPluginDB.isPluinUpdating(i)) {
                    if (callback != null) {
                        callback.onError(3);
                    }
                    try {
                        hashMap.put("3", Integer.toString(12));
                        CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, false);
                        return;
                    } catch (Throwable unused12) {
                        return;
                    }
                }
                if (!this.initCalledByHost) {
                    setInitStatus(3);
                    init();
                }
                PluginloaderHub createSingleInstance = PluginloaderHub.createSingleInstance(hostContext.getApplicationContext());
                ApkInfo apkInfo = null;
                long currentTimeMillis2 = System.currentTimeMillis();
                while (System.currentTimeMillis() - currentTimeMillis2 <= 15000) {
                    apkInfo = this.loadedPluginDB.getPluginByID(i);
                    if (apkInfo != null) {
                        if (createSingleInstance.getApkInfoByPackageName(apkInfo.packageName) == null) {
                            if (apkInfo.initStatus == -1) {
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    SystemClock.sleep(1000L);
                }
                z = false;
                if (!z) {
                    if (callback != null) {
                        callback.onError(4);
                    }
                    try {
                        hashMap.put("3", Integer.toString(13));
                        CommonMethods.sendEventUDC(hostContext, RpConstant.METHOD_CALL_ERROR_LOGID, hashMap, false);
                        return;
                    } catch (Throwable unused13) {
                        return;
                    }
                }
                Class<?> loadClassWithoutParentClass = ((PluginloaderDexClassLoader) createSingleInstance.getApkInfoByPackageName(apkInfo.packageName).classLoader).loadClassWithoutParentClass(LocalConstant.ENGINE_IMPL_CLASS_FULL_PATH);
                Object callMethodOfClass = CommonMethods.callMethodOfClass(loadClassWithoutParentClass.getDeclaredMethod("getInstance", Context.class).invoke(loadClassWithoutParentClass, hostContext), str, clsArr, objArr);
                if (callback != null) {
                    callback.onEnd(callMethodOfClass);
                }
            } catch (Throwable th6) {
                CommonMethods.handleNuLException(th6);
            }
        }
    }

    public synchronized void init(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, callback) == null) {
            synchronized (this) {
                try {
                    if (this.initCalledByHost) {
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                        }
                        return;
                    }
                    this.initCalledByHost = true;
                    PrivacyOperationUtil.loadPolicy(hostContext);
                    CommonMethods.registerDefultReceiver(hostContext);
                    this.mPreferences.setCanConn(true);
                    JSONObject requestWholeInfo = CommonMethods.requestWholeInfo(hostContext);
                    CommonMethods.sendInitUDC(hostContext);
                    this.mPreferences.setSelfVersion(LocalConstant.V);
                    Report.getInstance(hostContext).n();
                    for (ApkInfo apkInfo : this.loadedPluginDB.getAllPlugins()) {
                        String str = null;
                        try {
                            str = hostContext.getFilesDir().getCanonicalPath();
                        } catch (IOException e) {
                            CommonMethods.handleNuLException(e);
                        }
                        if (str != null) {
                            apkInfo.dataDir = str + "/." + apkInfo.key;
                            StringBuilder sb = new StringBuilder();
                            sb.append(apkInfo.dataDir);
                            sb.append("/lib");
                            CommonMethods.deleteDir(sb.toString());
                        }
                    }
                    this.loadedPluginDB.deletePluginIfAPKNotExist();
                    if (!this.mPreferences.isInitOnce()) {
                        this.mPreferences.setInitOnce(true);
                    } else {
                        this.loadedPluginDB.setLoadStatusFromFailToInit();
                    }
                    ThreadPoolManager.getInstance(hostContext).executeCore(new U(hostContext, 1, false, requestWholeInfo));
                    if (callback != null) {
                        callback.onEnd(new Object[0]);
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }
    }

    public void deleteNotLoadedPlugin(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            try {
                this.loadedPluginDB.deleteLoadedPluginByPackage(str);
                File file = new File(str2);
                if (file.exists()) {
                    FileDeleteObserverUtils.unRegisterObserver(file);
                    file.delete();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void execEngineImpl(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            execEngineImpl(i, str, null);
        }
    }

    public void execEngineImpl(int i, String str, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, str, callback) == null) {
            execEngineImpl(i, str, callback, null, new Object[0]);
        }
    }
}
