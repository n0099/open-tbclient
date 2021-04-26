package com.baidu.android.util.devices;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.java.ReflectionUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
    public static boolean DEBUG = false;
    public static final int DIVIDER = 1024;
    public static final int ERROR = -1;
    public static final String TAG = "StorageUtils";

    /* loaded from: classes.dex */
    public static class StorageInfo {
        public final int mDisplayNumber;
        public final boolean mInternal;
        public final String mPath;
        public final boolean mReadonly;

        public StorageInfo(String str, boolean z, boolean z2, int i2) {
            this.mPath = str;
            this.mInternal = z;
            this.mReadonly = z2;
            this.mDisplayNumber = i2;
        }

        public String getDisplayName() {
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
    }

    public static boolean externalMemoryAvailable() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d(TAG, e2.getMessage());
            }
            return false;
        }
    }

    public static String formatSize(long j) {
        double d2;
        double d3 = j;
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

    public static long getAvailableExternalMemorySize() {
        long blockSize;
        long availableBlocks;
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
                    Log.d(TAG, e2.getMessage());
                }
            }
        }
        return -1L;
    }

    public static long getAvailableInternalMemorySize() {
        long blockSize;
        long availableBlocks;
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
                Log.d(TAG, e2.getMessage());
                return -1L;
            }
            return -1L;
        }
    }

    public static long getAvailaleMemorySize(String str) {
        long blockSize;
        long availableBlocks;
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x01bb */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:110:0x01ba */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:111:0x003b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:115:0x003b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:125:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:126:0x0053 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x01b6 -> B:110:0x01ba). Please submit an issue!!! */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<StorageInfo> getStorageList() {
        Throwable th;
        BufferedReader bufferedReader;
        HashSet hashSet;
        BufferedReader bufferedReader2;
        String str;
        int i2;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        String path = Environment.getExternalStorageDirectory().getPath();
        int i3 = 1;
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
            } catch (IOException e2) {
                e2.printStackTrace();
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
                                    i2 = i3 + 1;
                                    arrayList.add(new StorageInfo(str2, z2, contains, i3));
                                    i3 = i2;
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
                                                    i2 = i3 + 1;
                                                    hashMap.put(nextToken, new StorageInfo(str2, z2, contains, i3));
                                                    i3 = i2;
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
                                    hashMap.put(nextToken, new StorageInfo(str2, false, contains, i3));
                                    i3++;
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
            } catch (FileNotFoundException e3) {
                e = e3;
                str2 = bufferedReader2;
                e.printStackTrace();
                if (str2 != null) {
                    str2.close();
                    str2 = str2;
                }
                return arrayList;
            } catch (IOException e4) {
                e = e4;
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
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            str2 = null;
        } catch (IOException e7) {
            e = e7;
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

    public static long getTotalExternalMemorySize() {
        long blockSize;
        long blockCount;
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
                    Log.d(TAG, e2.getMessage());
                }
            }
        }
        return -1L;
    }

    public static long getTotalInternalMemorySize() {
        long blockSize;
        long blockCount;
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
                Log.d(TAG, e2.getMessage());
                return -1L;
            }
            return -1L;
        }
    }

    public static long getTotalMemorySize(String str) {
        long blockSize;
        long blockCount;
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
                    Log.d(TAG, e2.getMessage());
                }
                return 0L;
            }
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 0L;
        }
    }

    @Deprecated
    public static Object[] getVolumeList() {
        Object invokeHideMethodForObject = ReflectionUtils.invokeHideMethodForObject((StorageManager) AppRuntime.getAppContext().getSystemService("storage"), "getVolumeList", null, null);
        if (invokeHideMethodForObject != null) {
            return (Object[]) invokeHideMethodForObject;
        }
        return null;
    }

    @Deprecated
    public static String getVolumePath(Object obj) {
        Object invokeHideMethodForObject = ReflectionUtils.invokeHideMethodForObject(obj, "getPath", null, null);
        return invokeHideMethodForObject != null ? (String) invokeHideMethodForObject : "";
    }

    @Deprecated
    public static String getVolumeState(String str) {
        Object invokeHideMethodForObject = ReflectionUtils.invokeHideMethodForObject((StorageManager) AppRuntime.getAppContext().getSystemService("storage"), "getVolumeState", new Class[]{String.class}, new Object[]{str});
        return invokeHideMethodForObject != null ? (String) invokeHideMethodForObject : "";
    }

    public static boolean isEnoughSpace(File file, long j) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            long blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            if (DEBUG) {
                Log.d(TAG, "Available size:" + (blockSize * availableBlocks));
            }
            return blockSize * availableBlocks > j;
        } catch (IllegalArgumentException e2) {
            if (DEBUG) {
                Log.d(TAG, e2.getMessage());
            }
            return false;
        }
    }

    public static boolean isFuseStorage(String str, String str2) {
        if (str == null || !str.contains("/dev/fuse") || str2 == null || str2.startsWith("/storage/emulated/legacy") || str2.contains("/Android/obb")) {
            return false;
        }
        if (str2.startsWith("/storage/")) {
            return true;
        }
        return (Build.VERSION.SDK_INT < 19 || str2.startsWith("/mnt/") || str2.startsWith("/data/")) ? false : true;
    }

    public static boolean isPathAccessable(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).canRead();
    }
}
