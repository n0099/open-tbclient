package com.baidu.android.util.devices;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.java.ReflectionUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
/* loaded from: classes.dex */
public final class StorageUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final int DIVIDER = 1024;
    public static final int ERROR = -1;
    public static final String TAG = "StorageUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class StorageInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mDisplayNumber;
        public final boolean mInternal;
        public final String mPath;
        public final boolean mReadonly;

        public StorageInfo(String str, boolean z, boolean z2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPath = str;
            this.mInternal = z;
            this.mReadonly = z2;
            this.mDisplayNumber = i;
        }

        public String getDisplayName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.mInternal) {
                    sb.append("Internal SD card");
                } else if (this.mDisplayNumber > 1) {
                    sb.append("SD card " + this.mDisplayNumber);
                } else {
                    sb.append("SD card" + this.mDisplayNumber);
                }
                if (this.mReadonly) {
                    sb.append(" (Read only)");
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-871744748, "Lcom/baidu/android/util/devices/StorageUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-871744748, "Lcom/baidu/android/util/devices/StorageUtils;");
        }
    }

    public StorageUtils() {
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

    public static boolean externalMemoryAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return Environment.getExternalStorageState().equals("mounted");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.d(TAG, e.getMessage());
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String formatSize(long j) {
        InterceptResult invokeJ;
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            double d2 = j;
            String str = "KB";
            if (d2 >= 1024.0d) {
                d = d2 / 1024.0d;
                if (d >= 1024.0d) {
                    d /= 1024.0d;
                    if (d >= 1024.0d) {
                        d /= 1024.0d;
                        str = "GB";
                    } else {
                        str = "MB";
                    }
                }
            } else {
                d = 0.0d;
            }
            return String.format(Locale.CHINESE, "%.2f%s", Double.valueOf(d), str);
        }
        return (String) invokeJ.objValue;
    }

    public static long getAvailableExternalMemorySize() {
        InterceptResult invokeV;
        long blockSize;
        long availableBlocks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (externalMemoryAvailable()) {
                try {
                    StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    if (Build.VERSION.SDK_INT >= 18) {
                        blockSize = statFs.getBlockSizeLong();
                        availableBlocks = statFs.getAvailableBlocksLong();
                    } else {
                        blockSize = statFs.getBlockSize();
                        availableBlocks = statFs.getAvailableBlocks();
                    }
                    return availableBlocks * blockSize;
                } catch (IllegalArgumentException e) {
                    if (DEBUG) {
                        Log.d(TAG, e.getMessage());
                    }
                }
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public static long getAvailableInternalMemorySize() {
        InterceptResult invokeV;
        long blockSize;
        long availableBlocks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    blockSize = statFs.getBlockSizeLong();
                    availableBlocks = statFs.getAvailableBlocksLong();
                } else {
                    blockSize = statFs.getBlockSize();
                    availableBlocks = statFs.getAvailableBlocks();
                }
                return availableBlocks * blockSize;
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    Log.d(TAG, e.getMessage());
                    return -1L;
                }
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public static long getAvailaleMemorySize(String str) {
        long blockSize;
        long availableBlocks;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                StatFs statFs = new StatFs(str);
                if (Build.VERSION.SDK_INT >= 18) {
                    blockSize = statFs.getBlockSizeLong();
                    availableBlocks = statFs.getAvailableBlocksLong();
                } else {
                    blockSize = statFs.getBlockSize();
                    availableBlocks = statFs.getAvailableBlocks();
                }
                return availableBlocks * blockSize;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:104:0x01bf */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:116:0x01be */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:117:0x003f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:121:0x003f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:131:0x0057 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:132:0x0057 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x01ba -> B:116:0x01be). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<StorageInfo> getStorageList() {
        InterceptResult invokeV;
        Throwable th;
        BufferedReader bufferedReader;
        HashSet hashSet;
        BufferedReader bufferedReader2;
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            String path = Environment.getExternalStorageDirectory().getPath();
            int i2 = 1;
            boolean z = !Environment.isExternalStorageRemovable();
            String externalStorageState = Environment.getExternalStorageState();
            String str2 = "mounted_ro";
            boolean z2 = false;
            boolean z3 = externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro");
            boolean equals = Environment.getExternalStorageState().equals("mounted_ro");
            try {
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    hashSet = new HashSet();
                    bufferedReader2 = new BufferedReader(new FileReader("/proc/mounts"));
                } catch (IOException e) {
                    e.printStackTrace();
                    str2 = str2;
                }
                try {
                    if (DEBUG) {
                        Log.d(TAG, "/proc/mounts");
                    }
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (DEBUG) {
                            Log.d(TAG, readLine);
                        }
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine, " ");
                        String nextToken = stringTokenizer.nextToken();
                        str2 = stringTokenizer.nextToken();
                        if (!hashSet.contains(str2)) {
                            stringTokenizer.nextToken();
                            boolean contains = Arrays.asList(stringTokenizer.nextToken().split(",")).contains("ro");
                            if (!readLine.contains("vfat") && !readLine.contains("/mnt")) {
                                boolean isFuseStorage = isFuseStorage(nextToken, str2);
                                str2 = str2;
                                if (isFuseStorage) {
                                    hashSet.add(str2);
                                    boolean isPathAccessable = isPathAccessable(str2);
                                    str2 = str2;
                                    if (isPathAccessable) {
                                        i = i2 + 1;
                                        arrayList.add(new StorageInfo(str2, z2, contains, i2));
                                        i2 = i;
                                        str2 = str2;
                                    }
                                }
                                z2 = false;
                            }
                            if (str2.equals(path)) {
                                hashSet.add(path);
                                str2 = -1;
                                hashMap.put(nextToken, new StorageInfo(path, z, contains, -1));
                            } else if (readLine.contains("/dev/block/vold")) {
                                str2 = str2;
                                if (!readLine.contains("/mnt/secure")) {
                                    str2 = str2;
                                    if (!readLine.contains("/mnt/asec")) {
                                        str2 = str2;
                                        if (!readLine.contains("/mnt/obb")) {
                                            str2 = str2;
                                            if (!readLine.contains("/dev/mapper")) {
                                                str2 = str2;
                                                if (!readLine.contains("tmpfs")) {
                                                    hashSet.add(str2);
                                                    str2 = str2;
                                                    if (!hashMap.containsKey(nextToken)) {
                                                        i = i2 + 1;
                                                        hashMap.put(nextToken, new StorageInfo(str2, z2, contains, i2));
                                                        i2 = i;
                                                        str2 = str2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                str2 = str2;
                                if (hashSet.contains(nextToken)) {
                                    Iterator it = hashMap.keySet().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            str = null;
                                            break;
                                        }
                                        str = (String) it.next();
                                        if (TextUtils.equals(((StorageInfo) hashMap.get(str)).mPath, nextToken)) {
                                            break;
                                        }
                                    }
                                    hashMap.remove(str);
                                    hashSet.add(str2);
                                    str2 = str2;
                                    if (!hashMap.containsKey(nextToken)) {
                                        hashMap.put(nextToken, new StorageInfo(str2, false, contains, i2));
                                        i2++;
                                        str2 = str2;
                                    }
                                }
                            }
                            z2 = false;
                        }
                    }
                    for (StorageInfo storageInfo : hashMap.values()) {
                        if (isPathAccessable(storageInfo.mPath)) {
                            arrayList.add(storageInfo);
                        }
                    }
                    if (!hashSet.contains(path) && z3) {
                        arrayList.add(0, new StorageInfo(path, z, equals, -1));
                    }
                    bufferedReader2.close();
                    str2 = str2;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    str2 = bufferedReader2;
                    e.printStackTrace();
                    if (str2 != null) {
                        str2.close();
                        str2 = str2;
                    }
                    return arrayList;
                } catch (IOException e3) {
                    e = e3;
                    str2 = bufferedReader2;
                    e.printStackTrace();
                    if (str2 != null) {
                        str2.close();
                        str2 = str2;
                    }
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                str2 = null;
            } catch (IOException e6) {
                e = e6;
                str2 = null;
            } catch (Throwable th4) {
                th = th4;
                str2 = 0;
                th = th;
                bufferedReader = str2;
                if (bufferedReader != null) {
                }
                throw th;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static long getTotalExternalMemorySize() {
        InterceptResult invokeV;
        long blockSize;
        long blockCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (externalMemoryAvailable()) {
                try {
                    StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    if (Build.VERSION.SDK_INT >= 18) {
                        blockSize = statFs.getBlockSizeLong();
                        blockCount = statFs.getBlockCountLong();
                    } else {
                        blockSize = statFs.getBlockSize();
                        blockCount = statFs.getBlockCount();
                    }
                    return blockCount * blockSize;
                } catch (IllegalArgumentException e) {
                    if (DEBUG) {
                        Log.d(TAG, e.getMessage());
                    }
                }
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public static long getTotalInternalMemorySize() {
        InterceptResult invokeV;
        long blockSize;
        long blockCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    blockSize = statFs.getBlockSizeLong();
                    blockCount = statFs.getBlockCountLong();
                } else {
                    blockSize = statFs.getBlockSize();
                    blockCount = statFs.getBlockCount();
                }
                return blockCount * blockSize;
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    Log.d(TAG, e.getMessage());
                    return -1L;
                }
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public static long getTotalMemorySize(String str) {
        InterceptResult invokeL;
        long blockSize;
        long blockCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            try {
                try {
                    StatFs statFs = new StatFs(str);
                    if (Build.VERSION.SDK_INT >= 18) {
                        blockSize = statFs.getBlockSizeLong();
                        blockCount = statFs.getBlockCountLong();
                    } else {
                        blockSize = statFs.getBlockSize();
                        blockCount = statFs.getBlockCount();
                    }
                    return blockCount * blockSize;
                } catch (IllegalArgumentException e) {
                    if (DEBUG) {
                        Log.d(TAG, e.getMessage());
                    }
                    return 0L;
                }
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    @Deprecated
    public static Object[] getVolumeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            Object invokeHideMethodForObject = ReflectionUtils.invokeHideMethodForObject((StorageManager) AppRuntime.getAppContext().getSystemService("storage"), "getVolumeList", null, null);
            if (invokeHideMethodForObject != null) {
                return (Object[]) invokeHideMethodForObject;
            }
            return null;
        }
        return (Object[]) invokeV.objValue;
    }

    @Deprecated
    public static String getVolumePath(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, obj)) == null) {
            Object invokeHideMethodForObject = ReflectionUtils.invokeHideMethodForObject(obj, "getPath", null, null);
            return invokeHideMethodForObject != null ? (String) invokeHideMethodForObject : "";
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String getVolumeState(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            Object invokeHideMethodForObject = ReflectionUtils.invokeHideMethodForObject((StorageManager) AppRuntime.getAppContext().getSystemService("storage"), "getVolumeState", new Class[]{String.class}, new Object[]{str});
            return invokeHideMethodForObject != null ? (String) invokeHideMethodForObject : "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean isEnoughSpace(File file, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65550, null, file, j)) == null) {
            try {
                StatFs statFs = new StatFs(file.getPath());
                long blockSize = statFs.getBlockSize();
                long availableBlocks = statFs.getAvailableBlocks();
                if (DEBUG) {
                    Log.d(TAG, "Available size:" + (blockSize * availableBlocks));
                }
                return blockSize * availableBlocks > j;
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    Log.d(TAG, e.getMessage());
                }
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    public static boolean isFuseStorage(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, str2)) == null) {
            if (str == null || !str.contains("/dev/fuse") || str2 == null || str2.startsWith("/storage/emulated/legacy") || str2.contains("/Android/obb")) {
                return false;
            }
            if (str2.startsWith("/storage/")) {
                return true;
            }
            return (Build.VERSION.SDK_INT < 19 || str2.startsWith("/mnt/") || str2.startsWith("/data/")) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isPathAccessable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).canRead();
        }
        return invokeL.booleanValue;
    }
}
