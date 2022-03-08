package com.baidu.android.util.devices;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.text.TextUtils;
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
/* loaded from: classes3.dex */
public final class StorageUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final int DIVIDER = 1024;
    public static final int ERROR = -1;
    public static final String TAG = "StorageUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class StorageInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mDisplayNumber;
        public final boolean mInternal;
        public final String mPath;
        public final boolean mReadonly;

        public StorageInfo(String str, boolean z, boolean z2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPath = str;
            this.mInternal = z;
            this.mReadonly = z2;
            this.mDisplayNumber = i2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.getMessage();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String formatSize(long j2) {
        InterceptResult invokeJ;
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j2)) == null) {
            double d3 = j2;
            String str = "KB";
            if (d3 >= 1024.0d) {
                d2 = d3 / 1024.0d;
                if (d2 >= 1024.0d) {
                    d2 /= 1024.0d;
                    if (d2 >= 1024.0d) {
                        d2 /= 1024.0d;
                        str = "GB";
                    } else {
                        str = "MB";
                    }
                }
            } else {
                d2 = 0.0d;
            }
            return String.format(Locale.CHINESE, "%.2f%s", Double.valueOf(d2), str);
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
                } catch (IllegalArgumentException e2) {
                    if (DEBUG) {
                        e2.getMessage();
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
            } catch (IllegalArgumentException e2) {
                if (DEBUG) {
                    e2.getMessage();
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
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:108:0x01a8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:109:0x003d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:113:0x003d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:138:0x0050 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:151:0x0050 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:156:0x0153 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:96:0x01a9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x01a4 -> B:108:0x01a8). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<StorageInfo> getStorageList() {
        InterceptResult invokeV;
        Throwable th;
        BufferedReader bufferedReader;
        HashSet hashSet;
        BufferedReader bufferedReader2;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            String path = Environment.getExternalStorageDirectory().getPath();
            int i3 = 1;
            boolean z = !Environment.isExternalStorageRemovable();
            String externalStorageState = Environment.getExternalStorageState();
            BufferedReader bufferedReader3 = "mounted_ro";
            boolean z2 = externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro");
            boolean equals = Environment.getExternalStorageState().equals("mounted_ro");
            try {
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    hashSet = new HashSet();
                    bufferedReader2 = new BufferedReader(new FileReader("/proc/mounts"));
                } catch (IOException e2) {
                    e2.printStackTrace();
                    bufferedReader3 = bufferedReader3;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                bufferedReader3 = null;
            } catch (IOException e4) {
                e = e4;
                bufferedReader3 = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader3 = 0;
                th = th;
                bufferedReader = bufferedReader3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            try {
                boolean z3 = DEBUG;
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    boolean z4 = DEBUG;
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine, " ");
                    String nextToken = stringTokenizer.nextToken();
                    String nextToken2 = stringTokenizer.nextToken();
                    if (!hashSet.contains(nextToken2)) {
                        stringTokenizer.nextToken();
                        bufferedReader3 = Arrays.asList(stringTokenizer.nextToken().split(",")).contains("ro");
                        if (!readLine.contains("vfat") && !readLine.contains("/mnt")) {
                            if (isFuseStorage(nextToken, nextToken2)) {
                                hashSet.add(nextToken2);
                                if (isPathAccessable(nextToken2)) {
                                    i2 = i3 + 1;
                                    arrayList.add(new StorageInfo(nextToken2, false, bufferedReader3, i3));
                                    i3 = i2;
                                }
                            }
                        }
                        if (nextToken2.equals(path)) {
                            hashSet.add(path);
                            hashMap.put(nextToken, new StorageInfo(path, z, bufferedReader3, -1));
                        } else if (readLine.contains("/dev/block/vold")) {
                            if (!readLine.contains("/mnt/secure") && !readLine.contains("/mnt/asec") && !readLine.contains("/mnt/obb") && !readLine.contains("/dev/mapper") && !readLine.contains("tmpfs")) {
                                hashSet.add(nextToken2);
                                if (!hashMap.containsKey(nextToken)) {
                                    i2 = i3 + 1;
                                    hashMap.put(nextToken, new StorageInfo(nextToken2, false, bufferedReader3, i3));
                                    i3 = i2;
                                }
                            }
                        } else if (hashSet.contains(nextToken)) {
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
                            hashSet.add(nextToken2);
                            if (!hashMap.containsKey(nextToken)) {
                                i2 = i3 + 1;
                                hashMap.put(nextToken, new StorageInfo(nextToken2, false, bufferedReader3, i3));
                                i3 = i2;
                            }
                        }
                    }
                }
                for (StorageInfo storageInfo : hashMap.values()) {
                    bufferedReader3 = isPathAccessable(storageInfo.mPath);
                    if (bufferedReader3 != 0) {
                        arrayList.add(storageInfo);
                    }
                }
                if (!hashSet.contains(path) && z2) {
                    arrayList.add(0, new StorageInfo(path, z, equals, -1));
                }
                bufferedReader2.close();
                bufferedReader3 = bufferedReader3;
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader3 = bufferedReader2;
                e.printStackTrace();
                if (bufferedReader3 != null) {
                    bufferedReader3.close();
                    bufferedReader3 = bufferedReader3;
                }
                return arrayList;
            } catch (IOException e7) {
                e = e7;
                bufferedReader3 = bufferedReader2;
                e.printStackTrace();
                if (bufferedReader3 != null) {
                    bufferedReader3.close();
                    bufferedReader3 = bufferedReader3;
                }
                return arrayList;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = bufferedReader2;
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
                } catch (IllegalArgumentException e2) {
                    if (DEBUG) {
                        e2.getMessage();
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
            } catch (IllegalArgumentException e2) {
                if (DEBUG) {
                    e2.getMessage();
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
                } catch (IllegalArgumentException e2) {
                    if (DEBUG) {
                        e2.getMessage();
                    }
                    return 0L;
                }
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
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

    public static boolean isEnoughSpace(File file, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65550, null, file, j2)) == null) {
            try {
                StatFs statFs = new StatFs(file.getPath());
                long blockSize = statFs.getBlockSize();
                long availableBlocks = statFs.getAvailableBlocks();
                if (DEBUG) {
                    String str = "Available size:" + (blockSize * availableBlocks);
                }
                return blockSize * availableBlocks > j2;
            } catch (IllegalArgumentException e2) {
                if (DEBUG) {
                    e2.getMessage();
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
