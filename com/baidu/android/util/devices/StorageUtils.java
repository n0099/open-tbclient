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

        public StorageInfo(String str, boolean z, boolean z2, int i) {
            this.mPath = str;
            this.mInternal = z;
            this.mReadonly = z2;
            this.mDisplayNumber = i;
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
        return Environment.getExternalStorageState().equals("mounted");
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:106:0x01c3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:115:0x0043 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x01be -> B:105:0x01c2). Please submit an issue!!! */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<StorageInfo> getStorageList() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Throwable th;
        HashSet hashSet;
        BufferedReader bufferedReader3;
        String str;
        int i;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        String path = Environment.getExternalStorageDirectory().getPath();
        int i2 = 1;
        boolean z = false;
        boolean z2 = Build.VERSION.SDK_INT >= 9 ? !Environment.isExternalStorageRemovable() : false;
        String externalStorageState = Environment.getExternalStorageState();
        BufferedReader bufferedReader4 = "mounted_ro";
        boolean z3 = externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro");
        boolean equals = Environment.getExternalStorageState().equals("mounted_ro");
        try {
            try {
                try {
                    hashSet = new HashSet();
                    bufferedReader3 = new BufferedReader(new FileReader("/proc/mounts"));
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    if (bufferedReader4 != null) {
                        try {
                            bufferedReader4.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                bufferedReader2 = null;
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader4 = null;
                th = th;
                if (bufferedReader4 != null) {
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        try {
            if (DEBUG) {
                Log.d(TAG, "/proc/mounts");
            }
            while (true) {
                String readLine = bufferedReader3.readLine();
                if (readLine == null) {
                    break;
                }
                if (DEBUG) {
                    Log.d(TAG, readLine);
                }
                StringTokenizer stringTokenizer = new StringTokenizer(readLine, " ");
                String nextToken = stringTokenizer.nextToken();
                String nextToken2 = stringTokenizer.nextToken();
                if (!hashSet.contains(nextToken2)) {
                    stringTokenizer.nextToken();
                    boolean contains = Arrays.asList(stringTokenizer.nextToken().split(",")).contains("ro");
                    if (!readLine.contains("vfat") && !readLine.contains("/mnt")) {
                        if (isFuseStorage(nextToken, nextToken2)) {
                            hashSet.add(nextToken2);
                            if (isPathAccessable(nextToken2)) {
                                i = i2 + 1;
                                arrayList.add(new StorageInfo(nextToken2, z, contains, i2));
                                i2 = i;
                            }
                        }
                        z = false;
                    }
                    if (nextToken2.equals(path)) {
                        hashSet.add(path);
                        hashMap.put(nextToken, new StorageInfo(path, z2, contains, -1));
                    } else if (readLine.contains("/dev/block/vold")) {
                        if (!readLine.contains("/mnt/secure") && !readLine.contains("/mnt/asec") && !readLine.contains("/mnt/obb") && !readLine.contains("/dev/mapper") && !readLine.contains("tmpfs")) {
                            hashSet.add(nextToken2);
                            if (!hashMap.containsKey(nextToken)) {
                                i = i2 + 1;
                                hashMap.put(nextToken, new StorageInfo(nextToken2, z, contains, i2));
                                i2 = i;
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
                            hashMap.put(nextToken, new StorageInfo(nextToken2, false, contains, i2));
                            i2++;
                        }
                    }
                    z = false;
                }
            }
            for (StorageInfo storageInfo : hashMap.values()) {
                if (isPathAccessable(storageInfo.mPath)) {
                    arrayList.add(storageInfo);
                }
            }
            if (!hashSet.contains(path) && z3) {
                arrayList.add(0, new StorageInfo(path, z2, equals, -1));
            }
            bufferedReader3.close();
        } catch (FileNotFoundException e6) {
            e = e6;
            bufferedReader2 = bufferedReader3;
            e.printStackTrace();
            bufferedReader4 = bufferedReader2;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
                bufferedReader4 = bufferedReader2;
            }
            return arrayList;
        } catch (IOException e7) {
            e = e7;
            bufferedReader = bufferedReader3;
            e.printStackTrace();
            bufferedReader4 = bufferedReader;
            if (bufferedReader != null) {
                bufferedReader.close();
                bufferedReader4 = bufferedReader;
            }
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader4 = bufferedReader3;
            if (bufferedReader4 != null) {
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
