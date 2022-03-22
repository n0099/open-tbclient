package com.baidu.sofire.core;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.BaiduLog;
import com.baidu.sofire.FileDeleteObserverUtils;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ReflectionUtils;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.mutiprocess.SubProcessManager;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.EncryptConnUtil;
import com.baidu.sofire.utility.LocalConstant;
import com.baidu.sofire.utility.MD5Util;
import com.baidu.sofire.utility.MutiPlatformAdapter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PluginloaderHub {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFULT_ABI = "armeabi";
    public static final String MIPS_ABI = "mips";
    public static Application sAppContext;
    public static PluginloaderHub sInstance;
    public static List<Integer> sMemRunning;
    public static Random sRandom;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isUpgrade;
    public Map<String, ApkInfo> mApkInfoMapPath;
    public Map<String, ApkInfo> mApkInfoMapPkgName;
    public Map<String, MyReceiver> mFilterKeyList;
    public String targetApkVersion;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1864893165, "Lcom/baidu/sofire/core/PluginloaderHub;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1864893165, "Lcom/baidu/sofire/core/PluginloaderHub;");
                return;
            }
        }
        sRandom = new Random();
        sMemRunning = new ArrayList();
    }

    public PluginloaderHub() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mApkInfoMapPath = new ConcurrentHashMap();
        this.mApkInfoMapPkgName = new ConcurrentHashMap();
        this.mFilterKeyList = new HashMap();
    }

    public static String buildIntentFilterKey(IntentFilter intentFilter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intentFilter)) == null) {
            if (intentFilter == null) {
                return "";
            }
            try {
                StringBuilder sb = new StringBuilder();
                int countActions = intentFilter.countActions();
                if (countActions > 0) {
                    ArrayList<String> arrayList = new ArrayList();
                    for (int i = 0; i < countActions; i++) {
                        String action = intentFilter.getAction(i);
                        if (!TextUtils.isEmpty(action)) {
                            arrayList.add(action);
                        }
                    }
                    if (arrayList.size() > 0) {
                        Collections.sort(arrayList);
                        for (String str : arrayList) {
                            sb.append(str);
                        }
                    } else {
                        sb.append("_");
                    }
                } else {
                    sb.append("_");
                }
                int countCategories = intentFilter.countCategories();
                if (countCategories > 0) {
                    ArrayList<String> arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < countCategories; i2++) {
                        String category = intentFilter.getCategory(i2);
                        if (!TextUtils.isEmpty(category)) {
                            arrayList2.add(category);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        Collections.sort(arrayList2);
                        for (String str2 : arrayList2) {
                            sb.append(str2);
                        }
                    } else {
                        sb.append("_");
                    }
                } else {
                    sb.append("_");
                }
                if (intentFilter.countDataTypes() > 0) {
                    ArrayList<String> arrayList3 = new ArrayList();
                    for (int i3 = 0; i3 < countCategories; i3++) {
                        String dataType = intentFilter.getDataType(i3);
                        if (!TextUtils.isEmpty(dataType)) {
                            arrayList3.add(dataType);
                        }
                    }
                    if (arrayList3.size() > 0) {
                        Collections.sort(arrayList3);
                        for (String str3 : arrayList3) {
                            sb.append(str3);
                        }
                    } else {
                        sb.append("_");
                    }
                } else {
                    sb.append("_");
                }
                int countDataSchemes = intentFilter.countDataSchemes();
                if (countDataSchemes > 0) {
                    ArrayList<String> arrayList4 = new ArrayList();
                    for (int i4 = 0; i4 < countDataSchemes; i4++) {
                        String dataScheme = intentFilter.getDataScheme(i4);
                        if (!TextUtils.isEmpty(dataScheme)) {
                            arrayList4.add(dataScheme);
                        }
                    }
                    if (arrayList4.size() > 0) {
                        Collections.sort(arrayList4);
                        for (String str4 : arrayList4) {
                            sb.append(str4);
                        }
                    } else {
                        sb.append("_");
                    }
                } else {
                    sb.append("_");
                }
                return sb.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private boolean checkAPKMD5(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            String str4 = i + str;
            Map<String, String> map = U.sRealtimeMd5Map;
            if (map != null) {
                String str5 = map.get(str4);
                if (!TextUtils.isEmpty(str5)) {
                    str2 = str5;
                }
            }
            Pair<Boolean, String> verifyAPKMD5 = verifyAPKMD5(str2, str3);
            if (((Boolean) verifyAPKMD5.first).booleanValue()) {
                return true;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("0", 3);
            hashMap.put("1", Integer.valueOf(i));
            hashMap.put("2", str);
            hashMap.put("3", Base64.encodeToString(((String) verifyAPKMD5.second).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
            CommonMethods.sendEventUDC(sAppContext.getApplicationContext(), "1003117", hashMap, false);
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static synchronized PluginloaderHub createSingleInstance(Context context) {
        InterceptResult invokeL;
        PluginloaderHub pluginloaderHub;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (PluginloaderHub.class) {
                if (sInstance == null) {
                    sAppContext = (Application) context.getApplicationContext();
                    sInstance = new PluginloaderHub();
                }
                pluginloaderHub = sInstance;
            }
            return pluginloaderHub;
        }
        return (PluginloaderHub) invokeL.objValue;
    }

    public static boolean ensureDirectory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            try {
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    file.delete();
                }
                if (file.exists()) {
                    return true;
                }
                file.mkdirs();
                return true;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:150:0x0292 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:151:0x029e */
    /* JADX DEBUG: Incorrect finally slice size: {[CONST, GOTO] complete}, expected: {[CONST] complete} */
    /* JADX WARN: Can't wrap try/catch for region: R(6:24|(1:73)(3:31|(2:33|(1:71)(3:35|(1:37)|38))(1:72)|51)|39|40|(4:45|46|47|(2:49|50)(2:52|(2:54|55)(1:56)))|51) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x015c, code lost:
        r11 = null;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0288 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0297 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v16 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String extractApkFile(ApkInfo apkInfo, String str, boolean z) throws Throwable {
        ?? r17;
        ?? r172;
        Throwable th;
        ZipFile zipFile;
        String str2;
        ZipFile zipFile2;
        ZipFile zipFile3;
        ZipFile zipFile4;
        Throwable th2;
        String str3;
        boolean z2;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r17 = 65542;
            r172 = 65542;
            InterceptResult invokeLLZ = interceptable.invokeLLZ(65542, this, apkInfo, str, z);
            if (invokeLLZ != null) {
                return (String) invokeLLZ.objValue;
            }
        }
        String str5 = "";
        if (apkInfo == null) {
            return "";
        }
        String replace = (!z || TextUtils.isEmpty(apkInfo.versionName)) ? "" : apkInfo.versionName.replace(".", "");
        try {
            try {
                try {
                    zipFile4 = new ZipFile(apkInfo.pkgPath);
                } catch (FileNotFoundException e2) {
                    String message = e2.getMessage();
                    File file = new File(apkInfo.hostContext.getFilesDir(), ".b");
                    try {
                        if (file.exists()) {
                            File file2 = new File(file, apkInfo.key + "-" + apkInfo.versionName);
                            if (file2.exists()) {
                                File file3 = new File(apkInfo.pkgPath);
                                CommonMethods.copyFile(file2, file3);
                                CommonMethods.ensureQuanxian(apkInfo.pkgPath, true);
                                FileDeleteObserverUtils.unRegisterObserver(file3);
                                FileDeleteObserverUtils.registerObserver(apkInfo.hostContext, apkInfo.key, file3, file2);
                                if (file3.exists()) {
                                    try {
                                        zipFile4 = new ZipFile(apkInfo.pkgPath);
                                    } catch (Throwable th3) {
                                        throw new FileNotFoundException(message + "--" + th3.getMessage());
                                    }
                                } else {
                                    throw new FileNotFoundException(message + "--file not exists after copy");
                                }
                            } else {
                                throw new FileNotFoundException(message + "--backupFile not exists");
                            }
                        } else {
                            throw new FileNotFoundException(message + "--backupDir not exists");
                        }
                    } catch (EOFException unused) {
                        str2 = r172;
                        zipFile3 = null;
                        if (zipFile3 != null) {
                        }
                        str3 = str2;
                        z2 = true;
                        if (z2) {
                        }
                    } catch (ZipException unused2) {
                        str2 = r17;
                        zipFile2 = null;
                        if (zipFile2 != null) {
                        }
                        str3 = str2;
                        z2 = true;
                        if (z2) {
                        }
                    }
                }
                ZipFile zipFile5 = zipFile4;
                try {
                    try {
                        HashMap hashMap = new HashMap();
                        Enumeration<? extends ZipEntry> entries = zipFile5.entries();
                        str3 = "";
                        while (entries.hasMoreElements()) {
                            try {
                                ZipEntry nextElement = entries.nextElement();
                                String name = nextElement.getName();
                                Enumeration<? extends ZipEntry> enumeration = entries;
                                if (name.contains(IStringUtil.TOP_PATH)) {
                                    try {
                                        zipFile5.close();
                                    } catch (Throwable th4) {
                                        CommonMethods.handleNuLException(th4);
                                    }
                                    return str5;
                                }
                                if (TextUtils.isEmpty(name) || !name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) || nextElement.isDirectory() || !z) {
                                    str4 = str5;
                                } else {
                                    String[] split = name.split("/");
                                    str4 = str5;
                                    if (split.length == 3) {
                                        String str6 = split[1];
                                        if (!TextUtils.isEmpty(str6)) {
                                            List list = (List) hashMap.get(str6);
                                            if (list == null) {
                                                list = new ArrayList();
                                                hashMap.put(str6, list);
                                            }
                                            list.add(nextElement);
                                        }
                                    }
                                    entries = enumeration;
                                    str5 = str4;
                                }
                                if (name.endsWith(".dex") && !nextElement.isDirectory() && !z) {
                                    String str7 = apkInfo.dataDir;
                                    ensureDirectory(str7);
                                    File file4 = new File(str7, apkInfo.key + "-" + apkInfo.versionName + ".dex");
                                    try {
                                        if (unZipEntry(zipFile5, nextElement, file4)) {
                                            str3 = file4.getAbsolutePath();
                                        } else if (file4.exists()) {
                                            file4.delete();
                                        }
                                    } catch (Throwable unused3) {
                                        if (file4 != null && file4.exists()) {
                                            file4.delete();
                                        }
                                        entries = enumeration;
                                        str5 = str4;
                                    }
                                }
                                entries = enumeration;
                                str5 = str4;
                            } catch (EOFException unused4) {
                            } catch (ZipException unused5) {
                            }
                        }
                        if (z && hashMap.size() > 0) {
                            String matchAbi = matchAbi(apkInfo.hostContext, hashMap.keySet());
                            if (!TextUtils.isEmpty(matchAbi)) {
                                File file5 = new File(str, matchAbi);
                                ensureDirectory(file5.getAbsolutePath());
                                List<ZipEntry> list2 = (List) hashMap.get(matchAbi);
                                if (list2 != null && list2.size() > 0) {
                                    for (ZipEntry zipEntry : list2) {
                                        String name2 = zipEntry.getName();
                                        try {
                                            String substring = name2.substring(name2.lastIndexOf("/") + 1);
                                            if (!unZipEntry(zipFile5, zipEntry, new File(file5, substring.replace(".so", replace + ".so")))) {
                                                throw new RuntimeException("UnZip so failed.Report space left.");
                                            }
                                        } catch (EOFException unused6) {
                                            zipFile3 = zipFile5;
                                            str2 = str3;
                                            if (zipFile3 != null) {
                                            }
                                            str3 = str2;
                                            z2 = true;
                                            if (z2) {
                                            }
                                        } catch (ZipException unused7) {
                                            zipFile2 = zipFile5;
                                            str2 = str3;
                                            if (zipFile2 != null) {
                                            }
                                            str3 = str2;
                                            z2 = true;
                                            if (z2) {
                                            }
                                        }
                                    }
                                }
                                str3 = file5.getAbsolutePath();
                            }
                        }
                        try {
                            zipFile5.close();
                        } catch (Throwable th5) {
                            CommonMethods.handleNuLException(th5);
                        }
                        z2 = false;
                    } catch (Throwable th6) {
                        th = th6;
                        zipFile = zipFile5;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Throwable th7) {
                                CommonMethods.handleNuLException(th7);
                            }
                        }
                        throw th;
                    }
                } catch (EOFException unused8) {
                    zipFile3 = zipFile5;
                    str2 = "";
                } catch (ZipException unused9) {
                    zipFile2 = zipFile5;
                    str2 = "";
                }
            } catch (Throwable th8) {
                th = th8;
                zipFile = null;
                if (zipFile != null) {
                }
                throw th;
            }
        } catch (EOFException unused10) {
            r172 = "";
            str2 = r172;
            zipFile3 = null;
            if (zipFile3 != null) {
                try {
                    zipFile3.close();
                } catch (Throwable th9) {
                    th2 = th9;
                    CommonMethods.handleNuLException(th2);
                    str3 = str2;
                    z2 = true;
                    if (z2) {
                    }
                }
            }
            str3 = str2;
            z2 = true;
            if (z2) {
            }
        } catch (ZipException unused11) {
            r17 = "";
            str2 = r17;
            zipFile2 = null;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (Throwable th10) {
                    th2 = th10;
                    CommonMethods.handleNuLException(th2);
                    str3 = str2;
                    z2 = true;
                    if (z2) {
                    }
                }
            }
            str3 = str2;
            z2 = true;
            if (z2) {
            }
        }
        return z2 ? handleZipWithStream(apkInfo, str, replace, z) : str3;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Can't wrap try/catch for region: R(9:14|(3:19|(3:57|58|59)(3:21|22|(3:54|55|56)(3:24|25|(1:27)))|51)|28|29|30|(4:35|36|37|(1:39)(2:40|(1:42)))|49|50|51) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String handleZipWithStream(ApkInfo apkInfo, String str, String str2, boolean z) throws Throwable {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{apkInfo, str, str2, Boolean.valueOf(z)})) != null) {
            return (String) invokeCommon.objValue;
        }
        if (apkInfo == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(apkInfo.pkgPath));
        String str3 = "";
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (name.contains(IStringUtil.TOP_PATH)) {
                        try {
                            zipInputStream.close();
                        } catch (Throwable th) {
                            CommonMethods.handleNuLException(th);
                        }
                        return "";
                    }
                    if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && !nextEntry.isDirectory() && z) {
                        String[] split = name.split("/");
                        if (split.length != 3) {
                            zipInputStream.closeEntry();
                        } else {
                            String str4 = split[1];
                            if (TextUtils.isEmpty(str4)) {
                                zipInputStream.closeEntry();
                            } else if (!arrayList.contains(str4)) {
                                arrayList.add(str4);
                            }
                        }
                    }
                    File file = null;
                    if (name.endsWith(".dex") && !nextEntry.isDirectory() && !z) {
                        String str5 = apkInfo.dataDir;
                        ensureDirectory(str5);
                        File file2 = new File(str5, apkInfo.key + "-" + apkInfo.versionName + ".dex");
                        try {
                            file2.delete();
                            file2.createNewFile();
                            if (unZipFileFromStream(file2, zipInputStream)) {
                                str3 = file2.getAbsolutePath();
                            } else if (file2.exists()) {
                                file2.delete();
                            }
                        } catch (Throwable unused) {
                            file = file2;
                            if (file != null && file.exists()) {
                                file.delete();
                            }
                            zipInputStream.closeEntry();
                        }
                    }
                    zipInputStream.closeEntry();
                } else {
                    try {
                        zipInputStream.close();
                    } catch (Throwable th2) {
                        CommonMethods.handleNuLException(th2);
                    }
                    if (z && arrayList.size() > 0) {
                        String matchAbi = matchAbi(apkInfo.hostContext, arrayList);
                        if (!TextUtils.isEmpty(matchAbi)) {
                            File file3 = new File(str, matchAbi);
                            ensureDirectory(file3.getAbsolutePath());
                            zipInputStream = new ZipInputStream(new FileInputStream(apkInfo.pkgPath));
                            while (true) {
                                try {
                                    ZipEntry nextEntry2 = zipInputStream.getNextEntry();
                                    if (nextEntry2 != null) {
                                        String name2 = nextEntry2.getName();
                                        if (name2.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && name2.endsWith(".so") && !nextEntry2.isDirectory()) {
                                            Object[] split2 = name2.split("/");
                                            if (split2.length != 3) {
                                                zipInputStream.closeEntry();
                                            } else if (matchAbi.equals(split2[1])) {
                                                String substring = name2.substring(name2.lastIndexOf("/") + 1);
                                                File file4 = new File(file3, substring.replace(".so", str2 + ".so"));
                                                file4.delete();
                                                file4.createNewFile();
                                                if (!unZipFileFromStream(file4, zipInputStream)) {
                                                    throw new RuntimeException("Stream UnZip so failed.Report space left.");
                                                }
                                                zipInputStream.closeEntry();
                                            }
                                        }
                                        zipInputStream.closeEntry();
                                    } else {
                                        str3 = file3.getAbsolutePath();
                                        try {
                                            zipInputStream.close();
                                            break;
                                        } catch (Throwable th3) {
                                            CommonMethods.handleNuLException(th3);
                                        }
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                    return str3;
                }
            } finally {
            }
        }
    }

    private boolean initalizeApplication(ApkInfo apkInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, apkInfo, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                Application application = (Application) apkInfo.classLoader.loadClass(str).newInstance();
                ReflectionUtils.copyAllFields(Application.class, sAppContext, application);
                resetBaseContext(application, sAppContext);
                application.onCreate();
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d6 A[Catch: all -> 0x00e9, TryCatch #4 {all -> 0x00e9, blocks: (B:36:0x00c7, B:38:0x00d6, B:41:0x00e1, B:42:0x00e6, B:31:0x009f, B:34:0x00bf, B:35:0x00c6), top: B:81:0x009f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void internalLoadClass(ApkInfo apkInfo, String str, String str2, boolean z) throws Throwable {
        String str3;
        String str4;
        String absolutePath;
        Class<?> loadClass;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65545, this, new Object[]{apkInfo, str, str2, Boolean.valueOf(z)}) != null) {
            return;
        }
        sAppContext.getFilesDir();
        String extractApkFile = extractApkFile(apkInfo, str, true);
        String str5 = (Build.VERSION.SDK_INT >= 25 || TextUtils.isEmpty(System.getProperty("java.library.path"))) ? "" : "";
        if (TextUtils.isEmpty(extractApkFile)) {
            extractApkFile = str5;
        } else if (!TextUtils.isEmpty(str5)) {
            extractApkFile = extractApkFile + ":" + str5;
        }
        apkInfo.libPath = extractApkFile;
        ClassLoader classLoader = PluginloaderHub.class.getClassLoader();
        try {
            File file = new File(str2, "apkDex");
            String absolutePath2 = file.getAbsolutePath();
            if (!MutiPlatformAdapter.geKeepDexOptSwitch()) {
                CommonMethods.deleteDir(absolutePath2);
            }
            ensureDirectory(absolutePath2);
            if (Build.VERSION.SDK_INT != 21) {
                if (Build.VERSION.SDK_INT == 22) {
                }
                PluginloaderDexClassLoader pluginloaderDexClassLoader = new PluginloaderDexClassLoader(apkInfo.pkgPath, absolutePath2, extractApkFile, classLoader);
                apkInfo.classLoader = pluginloaderDexClassLoader;
                loadClass = pluginloaderDexClassLoader.loadClass(LocalConstant.ENGINE_IMPL_CLASS_FULL_PATH);
                if (loadClass != null || TextUtils.isEmpty(loadClass.getName())) {
                    throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
                }
                return;
            }
            long freeSpace = file.getFreeSpace();
            File file2 = new File(apkInfo.pkgPath);
            if (file2.exists() && file2.isFile()) {
                long length = file2.length();
                str3 = "";
                try {
                    BaiduLog.logD("V5 freeSpace=" + freeSpace + ",fileSize=" + length);
                    if (freeSpace < length * 2) {
                        throw new Exception("Have no space to load plugin.");
                    }
                    PluginloaderDexClassLoader pluginloaderDexClassLoader2 = new PluginloaderDexClassLoader(apkInfo.pkgPath, absolutePath2, extractApkFile, classLoader);
                    apkInfo.classLoader = pluginloaderDexClassLoader2;
                    loadClass = pluginloaderDexClassLoader2.loadClass(LocalConstant.ENGINE_IMPL_CLASS_FULL_PATH);
                    if (loadClass != null) {
                    }
                    throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
                } catch (Throwable unused) {
                    try {
                        CommonMethods.deleteDir(new File(str2, "apkDex").getAbsolutePath());
                        absolutePath = new File(str2, "dexDex").getAbsolutePath();
                        CommonMethods.deleteDir(absolutePath);
                        ensureDirectory(absolutePath);
                        str4 = extractApkFile(apkInfo, str, false);
                    } catch (Throwable unused2) {
                        str4 = str3;
                    }
                    try {
                        PluginloaderDexClassLoader pluginloaderDexClassLoader3 = new PluginloaderDexClassLoader(str4, absolutePath, extractApkFile, classLoader);
                        apkInfo.classLoader = pluginloaderDexClassLoader3;
                        Class<?> loadClass2 = pluginloaderDexClassLoader3.loadClass(LocalConstant.ENGINE_IMPL_CLASS_FULL_PATH);
                        File file3 = new File(str4);
                        if (file3.exists()) {
                            file3.delete();
                        }
                        if (loadClass2 == null || TextUtils.isEmpty(loadClass2.getName())) {
                            throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
                        }
                        return;
                    } catch (Throwable unused3) {
                        if (apkInfo != null) {
                            try {
                                CommonMethods.deleteDir(apkInfo.dataDir);
                                if (sAppContext != null) {
                                    CommonMethods.deleteDir(sAppContext.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                                }
                            } catch (Throwable th) {
                                CommonMethods.handleNuLException(th);
                            }
                        }
                        if (apkInfo != null) {
                            throw new RuntimeException("can't load EngineImpl by both dexFile:" + str4 + " and ZipFile:" + apkInfo.pkgPath);
                        }
                        throw new RuntimeException("can't load EngineImpl by both dexFile:" + str4 + " and ZipFile:null");
                    }
                }
            }
            PluginloaderDexClassLoader pluginloaderDexClassLoader22 = new PluginloaderDexClassLoader(apkInfo.pkgPath, absolutePath2, extractApkFile, classLoader);
            apkInfo.classLoader = pluginloaderDexClassLoader22;
            loadClass = pluginloaderDexClassLoader22.loadClass(LocalConstant.ENGINE_IMPL_CLASS_FULL_PATH);
            if (loadClass != null) {
            }
            throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
        } catch (Throwable unused4) {
            str3 = "";
        }
    }

    private synchronized boolean intializeApkInfo(ApkInfo apkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, apkInfo)) == null) {
            synchronized (this) {
                if (apkInfo != null) {
                    if (!TextUtils.isEmpty(apkInfo.pkgPath)) {
                        ApkInfo apkInfo2 = this.mApkInfoMapPath.get(apkInfo.pkgPath);
                        if (apkInfo2 != null) {
                            if (apkInfo2.versionName.equals(apkInfo.versionName)) {
                                return true;
                            }
                            unloadApk(apkInfo.pkgPath);
                        }
                        if (!CommonMethods.isFileExist(new File(apkInfo.pkgPath))) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("0", 1);
                            hashMap.put("1", Integer.valueOf(apkInfo.key));
                            hashMap.put("2", apkInfo.versionName);
                            CommonMethods.sendEventUDC(sAppContext.getApplicationContext(), "1003117", hashMap, false);
                            return false;
                        }
                        apkInfo.hostContext = sAppContext;
                        if (apkInfo.apkParseSuc == 1) {
                            if (!TextUtils.isEmpty(apkInfo.packageName) && !TextUtils.isEmpty(apkInfo.pkgPath)) {
                                if (!checkAPKMD5(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, apkInfo.pkgPath)) {
                                    return false;
                                }
                                apkInfo.dataDir = sAppContext.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                                String str = apkInfo.dataDir + "/dex";
                                String str2 = (apkInfo.dataDir + "/lib/" + this.targetApkVersion) + "/" + sRandom.nextInt();
                                ensureDirectory(str);
                                CommonMethods.ensureQuanxian(str, false);
                                ensureDirectory(str2);
                                internalLoadClass(apkInfo, str2, str, false);
                                this.mApkInfoMapPath.put(apkInfo.pkgPath, apkInfo);
                                this.mApkInfoMapPkgName.put(apkInfo.packageName, apkInfo);
                                initalizeApplication(apkInfo, apkInfo.className);
                            } else {
                                throw new RuntimeException("packageName or pkgPath miss");
                            }
                        }
                        if (apkInfo.apkParseSuc != 1 || 0 != 0) {
                            PackageInfo packageInfo = apkInfo.cloudPkgInfo;
                            if ((packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) && (((packageInfo = sAppContext.getPackageManager().getPackageArchiveInfo(apkInfo.pkgPath, 1)) == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) && ((packageInfo = requestCloudPackageInfo(apkInfo.packageName, apkInfo.apkMD5)) == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)))) {
                                throw new Exception("requestCloudPackageInfo failed");
                            }
                            if (!TextUtils.isEmpty(packageInfo.packageName) && packageInfo.packageName.startsWith("com.baidu.sofire")) {
                                if (!checkAPKMD5(apkInfo.key, packageInfo.versionName, apkInfo.apkMD5, apkInfo.pkgPath)) {
                                    return false;
                                }
                                apkInfo.packageName = packageInfo.packageName;
                                apkInfo.className = packageInfo.applicationInfo.className;
                                apkInfo.versionName = packageInfo.versionName;
                                apkInfo.activities = packageInfo.activities;
                                apkInfo.applicationTheme = packageInfo.applicationInfo.theme;
                                apkInfo.dataDir = sAppContext.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                                String str3 = apkInfo.dataDir + "/dex";
                                String str4 = (apkInfo.dataDir + "/lib/" + this.targetApkVersion) + "/" + sRandom.nextInt();
                                ensureDirectory(str3);
                                CommonMethods.ensureQuanxian(str3, false);
                                ensureDirectory(str4);
                                internalLoadClass(apkInfo, str4, str3, true);
                                this.mApkInfoMapPath.put(apkInfo.pkgPath, apkInfo);
                                this.mApkInfoMapPkgName.put(apkInfo.packageName, apkInfo);
                                initalizeApplication(apkInfo, packageInfo.applicationInfo.className);
                            } else {
                                throw new Exception("package name check failed");
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private String matchAbi(Context context, Collection<String> collection) {
        InterceptResult invokeLL;
        String[] strArr;
        String[] strArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, context, collection)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                String currentAbi = CommonMethods.getCurrentAbi(context);
                if (TextUtils.isEmpty(currentAbi) || !collection.contains(currentAbi)) {
                    boolean is64BitProcess = CommonMethods.is64BitProcess();
                    if (is64BitProcess) {
                        strArr = Build.SUPPORTED_64_BIT_ABIS;
                    } else {
                        strArr = Build.SUPPORTED_32_BIT_ABIS;
                    }
                    if (strArr != null && strArr.length > 0) {
                        for (String str : strArr) {
                            if (collection.contains(str)) {
                                return str;
                            }
                        }
                    }
                    return (is64BitProcess || !collection.contains("armeabi") || (strArr2 = Build.SUPPORTED_ABIS) == null || strArr2.length <= 0 || "mips".equals(strArr2[0])) ? "" : "armeabi";
                }
                return currentAbi;
            } else if (collection.contains(Build.CPU_ABI)) {
                return Build.CPU_ABI;
            } else {
                if (collection.contains(Build.CPU_ABI2)) {
                    return Build.CPU_ABI2;
                }
                return (!collection.contains("armeabi") || "mips".equals(Build.CPU_ABI)) ? "" : "armeabi";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static Application peekApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? sAppContext : (Application) invokeV.objValue;
    }

    public static PluginloaderHub peekInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? sInstance : (PluginloaderHub) invokeV.objValue;
    }

    private PackageInfo requestCloudPackageInfo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, str, str2)) == null) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PushConstants.URI_PACKAGE_NAME, str);
                jSONObject.put("m", str2);
                jSONArray.put(jSONObject);
                JSONArray jSONArray2 = new JSONArray(EncryptConnUtil.encryptRequestPost(sAppContext, CommonMethods.getUrl(sAppContext) + "p/1/pdl", jSONArray.toString(), false, true));
                if (jSONArray2.length() <= 0) {
                    return null;
                }
                JSONObject optJSONObject = jSONArray2.optJSONObject(0);
                PackageInfo packageInfo = new PackageInfo();
                packageInfo.packageName = optJSONObject.optString("p");
                packageInfo.versionName = optJSONObject.optString("v");
                ApplicationInfo applicationInfo = new ApplicationInfo();
                String optString = optJSONObject.optString("n");
                applicationInfo.className = optString;
                if (!TextUtils.isEmpty(optString) && applicationInfo.className.startsWith(".")) {
                    applicationInfo.className = packageInfo.packageName + applicationInfo.className;
                }
                applicationInfo.theme = optJSONObject.optInt("t");
                packageInfo.applicationInfo = applicationInfo;
                JSONArray optJSONArray = optJSONObject.optJSONArray("a");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
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
                return packageInfo;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (PackageInfo) invokeLL.objValue;
    }

    private boolean unZipEntry(ZipFile zipFile, ZipEntry zipEntry, File file) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65551, this, zipFile, zipEntry, file)) != null) {
            return invokeLLL.booleanValue;
        }
        if (zipFile == null || zipEntry == null || file == null) {
            return false;
        }
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = zipFile.getInputStream(zipEntry);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    CommonMethods.ensureQuanxian(file.getAbsolutePath(), true);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable th) {
                            CommonMethods.handleNuLException(th);
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        CommonMethods.handleNuLException(th2);
                    }
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                    try {
                        CommonMethods.handleNuLException(th);
                        return false;
                    } finally {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th4) {
                                CommonMethods.handleNuLException(th4);
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th5) {
                                CommonMethods.handleNuLException(th5);
                            }
                        }
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
        }
    }

    private boolean unZipFileFromStream(File file, ZipInputStream zipInputStream) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, file, zipInputStream)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                CommonMethods.ensureQuanxian(file.getAbsolutePath(), true);
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    CommonMethods.handleNuLException(th2);
                }
                return true;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                try {
                    CommonMethods.handleNuLException(th);
                    return false;
                } finally {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th4) {
                            CommonMethods.handleNuLException(th4);
                        }
                    }
                }
            }
        }
        return invokeLL.booleanValue;
    }

    private Pair<Boolean, String> verifyAPKMD5(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str2);
                if (!CommonMethods.isFileExist(file)) {
                    return new Pair<>(Boolean.FALSE, "");
                }
                String md5 = MD5Util.getMD5(file);
                if (TextUtils.isEmpty(md5)) {
                    return new Pair<>(Boolean.FALSE, "");
                }
                if (!md5.equalsIgnoreCase(str)) {
                    return new Pair<>(Boolean.FALSE, md5);
                }
                return new Pair<>(Boolean.TRUE, "");
            }
            return new Pair<>(Boolean.FALSE, "");
        }
        return (Pair) invokeLL.objValue;
    }

    public synchronized void addOneRegisterReceiver(PluginloaderIntentFilter pluginloaderIntentFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pluginloaderIntentFilter) == null) {
            synchronized (this) {
                try {
                    if (pluginloaderIntentFilter.intentFilter == null) {
                        return;
                    }
                    ApkInfo apkInfo = this.mApkInfoMapPkgName.get(pluginloaderIntentFilter.fromPluginPkgName);
                    if (apkInfo != null) {
                        if (apkInfo.intentFilters == null) {
                            apkInfo.intentFilters = new ArrayList();
                        }
                        for (int i = 0; i < apkInfo.intentFilters.size(); i++) {
                            if (pluginloaderIntentFilter.isSameObj(apkInfo.intentFilters.get(i))) {
                                return;
                            }
                        }
                        apkInfo.intentFilters.add(pluginloaderIntentFilter);
                        String buildIntentFilterKey = buildIntentFilterKey(pluginloaderIntentFilter.intentFilter);
                        if (!TextUtils.isEmpty(buildIntentFilterKey) && !buildIntentFilterKey.equals("____")) {
                            if (!this.mFilterKeyList.keySet().contains(buildIntentFilterKey)) {
                                MyReceiver myReceiver = new MyReceiver();
                                if (!CommonMethods.registerReceiver(sAppContext, myReceiver, pluginloaderIntentFilter.intentFilter)) {
                                    try {
                                        Thread.sleep(3000L);
                                    } catch (InterruptedException e2) {
                                        CommonMethods.handleNuLException(e2);
                                    }
                                    CommonMethods.registerReceiver(sAppContext, myReceiver, pluginloaderIntentFilter.intentFilter);
                                }
                                this.mFilterKeyList.put(buildIntentFilterKey, myReceiver);
                            }
                        }
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }
    }

    public List<ApkInfo> getAllLoadedPlugins() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (String str : this.mApkInfoMapPkgName.keySet()) {
                    arrayList.add(this.mApkInfoMapPkgName.get(str));
                }
                return arrayList;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                try {
                    return new ArrayList();
                } catch (Throwable th2) {
                    CommonMethods.handleNuLException(th2);
                    return null;
                }
            }
        }
        return (List) invokeV.objValue;
    }

    public ApkInfo getApkInfoByPackageName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return this.mApkInfoMapPkgName.get(str);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (ApkInfo) invokeL.objValue;
    }

    public ApkInfo getApkInfoByPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return this.mApkInfoMapPath.get(str);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (ApkInfo) invokeL.objValue;
    }

    public Map<String, ApkInfo> getApkInfoMapPkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mApkInfoMapPkgName : (Map) invokeV.objValue;
    }

    public String getApkPathByPackageName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            ApkInfo apkInfo = this.mApkInfoMapPkgName.get(str);
            if (apkInfo == null) {
                return null;
            }
            return apkInfo.pkgPath;
        }
        return (String) invokeL.objValue;
    }

    public boolean isApkLoadedByPackageName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.mApkInfoMapPkgName.containsKey(str) : invokeL.booleanValue;
    }

    public void printMap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<String> it = this.mApkInfoMapPath.keySet().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public synchronized void removeOneRegisterReceiver(PluginloaderIntentFilter pluginloaderIntentFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pluginloaderIntentFilter) == null) {
            synchronized (this) {
                if (pluginloaderIntentFilter != null) {
                    try {
                        if (pluginloaderIntentFilter.intentFilter != null) {
                            ApkInfo apkInfo = this.mApkInfoMapPkgName.get(pluginloaderIntentFilter.fromPluginPkgName);
                            if (apkInfo != null && apkInfo.intentFilters != null) {
                                ArrayList<Integer> arrayList = new ArrayList();
                                for (int i = 0; i < apkInfo.intentFilters.size(); i++) {
                                    if (pluginloaderIntentFilter.isSameObj(apkInfo.intentFilters.get(i))) {
                                        arrayList.add(Integer.valueOf(i));
                                    }
                                }
                                for (Integer num : arrayList) {
                                    int intValue = num.intValue();
                                    if (apkInfo != null && apkInfo.intentFilters != null) {
                                        apkInfo.intentFilters.remove(intValue);
                                    }
                                }
                                if (apkInfo != null && apkInfo.intentFilters != null && apkInfo.intentFilters.size() == 0) {
                                    apkInfo.intentFilters = null;
                                }
                            }
                            String buildIntentFilterKey = buildIntentFilterKey(pluginloaderIntentFilter.intentFilter);
                            if (TextUtils.isEmpty(buildIntentFilterKey)) {
                                return;
                            }
                            for (ApkInfo apkInfo2 : getAllLoadedPlugins()) {
                                if (apkInfo2.intentFilters != null && apkInfo2.intentFilters.size() > 0) {
                                    for (PluginloaderIntentFilter pluginloaderIntentFilter2 : apkInfo2.intentFilters) {
                                        String buildIntentFilterKey2 = buildIntentFilterKey(pluginloaderIntentFilter2.intentFilter);
                                        if (!TextUtils.isEmpty(buildIntentFilterKey2) && buildIntentFilterKey2.equals(buildIntentFilterKey)) {
                                            return;
                                        }
                                    }
                                    continue;
                                }
                            }
                            sAppContext.unregisterReceiver(this.mFilterKeyList.get(buildIntentFilterKey));
                            this.mFilterKeyList.remove(buildIntentFilterKey);
                        }
                    } catch (Throwable th) {
                        CommonMethods.handleNuLException(th);
                    }
                }
            }
        }
    }

    public void resetBaseContext(Application application, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, application, context) == null) {
            Class<?> cls = context.getClass();
            for (Class<Application> cls2 = Application.class; cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    Field declaredField = cls2.getDeclaredField("mBase");
                    declaredField.setAccessible(true);
                    if (declaredField.getType().isAssignableFrom(cls)) {
                        declaredField.set(application, context);
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }
    }

    public boolean syncLoadApk(ApkInfo apkInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{apkInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            System.currentTimeMillis();
            this.isUpgrade = z2;
            this.targetApkVersion = apkInfo.versionName;
            return intializeApkInfo(apkInfo);
        }
        return invokeCommon.booleanValue;
    }

    public boolean unloadApk(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            ApkInfo apkInfo = this.mApkInfoMapPath.get(str);
            if (apkInfo != null) {
                this.mApkInfoMapPath.remove(str);
                this.mApkInfoMapPkgName.remove(apkInfo.packageName);
                SubProcessManager.mainProcessRequestUnloadPlugin(apkInfo.packageName);
                CommonMethods.deleteDir(apkInfo.dataDir);
                Application application = sAppContext;
                if (application != null) {
                    CommonMethods.deleteDir(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean unloadApkByPack(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            ApkInfo apkInfo = this.mApkInfoMapPkgName.get(str);
            if (apkInfo != null) {
                this.mApkInfoMapPath.remove(apkInfo.pkgPath);
                this.mApkInfoMapPkgName.remove(str);
                SubProcessManager.mainProcessRequestUnloadPlugin(str);
                CommonMethods.deleteDir(apkInfo.dataDir);
                Application application = sAppContext;
                if (application != null) {
                    CommonMethods.deleteDir(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean unloadApkSubProcess(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            try {
                ApkInfo apkInfo = this.mApkInfoMapPkgName.get(str);
                if (apkInfo != null) {
                    Class<?> loadClassWithoutParentClass = ((PluginloaderDexClassLoader) apkInfo.classLoader).loadClassWithoutParentClass(LocalConstant.ENGINE_IMPL_CLASS_FULL_PATH);
                    Object invoke = loadClassWithoutParentClass.getDeclaredMethod("getInstance", Context.class).invoke(loadClassWithoutParentClass, sAppContext);
                    if (invoke != null) {
                        CommonMethods.callMethodOfClass(invoke, "unload", null, new Object[0]);
                    }
                    this.mApkInfoMapPath.remove(apkInfo.pkgPath);
                    this.mApkInfoMapPkgName.remove(str);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
