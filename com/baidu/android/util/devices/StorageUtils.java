package com.baidu.android.util.devices;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.baidu.android.common.others.java.ReflectionUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes12.dex */
public final class StorageUtils {
    private static final boolean DEBUG = false;
    private static final int DIVIDER = 1024;
    private static final int ERROR = -1;
    private static final String TAG = "StorageUtils";

    private StorageUtils() {
    }

    /* loaded from: classes12.dex */
    public static class StorageInfo {
        public final int mDisplayNumber;
        public final boolean mInternal;
        public final String mPath;
        public final boolean mReadonly;

        StorageInfo(String str, boolean z, boolean z2, int i) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [219=5, 221=4, 222=4, 223=4] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<StorageInfo> getStorageList() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        String str;
        int i;
        boolean z = false;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        String path = Environment.getExternalStorageDirectory().getPath();
        boolean z2 = Build.VERSION.SDK_INT >= 9 ? !Environment.isExternalStorageRemovable() : false;
        String externalStorageState = Environment.getExternalStorageState();
        z = (externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) ? true : true;
        boolean equals = Environment.getExternalStorageState().equals("mounted_ro");
        try {
            try {
                HashSet hashSet = new HashSet();
                bufferedReader2 = new BufferedReader(new FileReader("/proc/mounts"));
                int i2 = 1;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine, HanziToPinyin.Token.SEPARATOR);
                        String nextToken = stringTokenizer.nextToken();
                        String nextToken2 = stringTokenizer.nextToken();
                        if (!hashSet.contains(nextToken2)) {
                            stringTokenizer.nextToken();
                            boolean contains = Arrays.asList(stringTokenizer.nextToken().split(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("ro");
                            if (readLine.contains("vfat") || readLine.contains("/mnt")) {
                                if (nextToken2.equals(path)) {
                                    hashSet.add(path);
                                    hashMap.put(nextToken, new StorageInfo(path, z2, contains, -1));
                                } else if (readLine.contains("/dev/block/vold")) {
                                    if (!readLine.contains("/mnt/secure") && !readLine.contains("/mnt/asec") && !readLine.contains("/mnt/obb") && !readLine.contains("/dev/mapper") && !readLine.contains("tmpfs")) {
                                        hashSet.add(nextToken2);
                                        if (!hashMap.containsKey(nextToken)) {
                                            hashMap.put(nextToken, new StorageInfo(nextToken2, false, contains, i2));
                                            i2++;
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
                                    if (hashMap.containsKey(nextToken)) {
                                        i = i2;
                                    } else {
                                        i = i2 + 1;
                                        hashMap.put(nextToken, new StorageInfo(nextToken2, false, contains, i2));
                                    }
                                    i2 = i;
                                }
                            } else if (isFuseStorage(nextToken, nextToken2)) {
                                hashSet.add(nextToken2);
                                if (isPathAccessable(nextToken2)) {
                                    arrayList.add(new StorageInfo(nextToken2, false, contains, i2));
                                    i2++;
                                }
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedReader3 = bufferedReader2;
                        try {
                            e.printStackTrace();
                            if (bufferedReader3 != null) {
                                try {
                                    bufferedReader3.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader3;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return arrayList;
                    }
                }
                for (StorageInfo storageInfo : hashMap.values()) {
                    if (isPathAccessable(storageInfo.mPath)) {
                        arrayList.add(storageInfo);
                    }
                }
                if (!hashSet.contains(path) && z) {
                    arrayList.add(0, new StorageInfo(path, z2, equals, -1));
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            bufferedReader3 = null;
        } catch (IOException e8) {
            e = e8;
            bufferedReader2 = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
        return arrayList;
    }

    private static boolean isPathAccessable(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).canRead();
    }

    private static boolean isFuseStorage(String str, String str2) {
        if (str != null && str.contains("/dev/fuse") && str2 != null && !str2.startsWith("/storage/emulated/legacy") && !str2.contains("/Android/obb")) {
            if (str2.startsWith("/storage/")) {
                return true;
            }
            if (Build.VERSION.SDK_INT >= 19 && !str2.startsWith("/mnt/") && !str2.startsWith("/data/")) {
                return true;
            }
        }
        return false;
    }

    public static boolean externalMemoryAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static long getAvailableInternalMemorySize() {
        long blockSize;
        long availableBlocks;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            blockSize = statFs.getBlockSizeLong();
            availableBlocks = statFs.getAvailableBlocksLong();
        } else {
            blockSize = statFs.getBlockSize();
            availableBlocks = statFs.getAvailableBlocks();
        }
        return availableBlocks * blockSize;
    }

    public static long getTotalInternalMemorySize() {
        long blockSize;
        long blockCount;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            blockSize = statFs.getBlockSizeLong();
            blockCount = statFs.getBlockCountLong();
        } else {
            blockSize = statFs.getBlockSize();
            blockCount = statFs.getBlockCount();
        }
        return blockCount * blockSize;
    }

    public static long getAvailableExternalMemorySize() {
        long blockSize;
        long availableBlocks;
        if (externalMemoryAvailable()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return availableBlocks * blockSize;
        }
        return -1L;
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
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long getTotalMemorySize(String str) {
        long blockSize;
        long blockCount;
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
            e.printStackTrace();
            return 0L;
        }
    }

    public static long getTotalExternalMemorySize() {
        long blockSize;
        long blockCount;
        if (externalMemoryAvailable()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockCount * blockSize;
        }
        return -1L;
    }

    public static String formatSize(long j) {
        double d;
        String str = "KB";
        double d2 = j;
        if (d2 >= 1024.0d) {
            str = "KB";
            d = d2 / 1024.0d;
            if (d >= 1024.0d) {
                str = "MB";
                d /= 1024.0d;
                if (d >= 1024.0d) {
                    str = "GB";
                    d /= 1024.0d;
                }
            }
        } else {
            d = 0.0d;
        }
        return String.format(Locale.CHINESE, "%.2f%s", Double.valueOf(d), str);
    }

    public static boolean isEnoughSpace(File file, long j) {
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
    }

    public static String getVolumePath(Object obj) {
        Object invokeHideMethodForObject = ReflectionUtils.invokeHideMethodForObject(obj, "getPath", null, null);
        if (invokeHideMethodForObject == null) {
            return "";
        }
        return (String) invokeHideMethodForObject;
    }

    public static Object[] getVolumeList() {
        Object invokeHideMethodForObject = ReflectionUtils.invokeHideMethodForObject((StorageManager) AppRuntime.getAppContext().getSystemService("storage"), "getVolumeList", null, null);
        if (invokeHideMethodForObject != null) {
            return (Object[]) invokeHideMethodForObject;
        }
        return null;
    }

    public static String getVolumeState(String str) {
        Object invokeHideMethodForObject = ReflectionUtils.invokeHideMethodForObject((StorageManager) AppRuntime.getAppContext().getSystemService("storage"), "getVolumeState", new Class[]{String.class}, new Object[]{str});
        if (invokeHideMethodForObject == null) {
            return "";
        }
        return (String) invokeHideMethodForObject;
    }
}
