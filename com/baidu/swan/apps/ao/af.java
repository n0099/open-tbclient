package com.baidu.swan.apps.ao;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
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
import java.util.StringTokenizer;
/* loaded from: classes8.dex */
public final class af {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes8.dex */
    public static class a {
        public final int mDisplayNumber;
        public final boolean mInternal;
        public final String mPath;
        public final boolean mReadonly;

        a(String str, boolean z, boolean z2, int i) {
            this.mPath = str;
            this.mInternal = z;
            this.mReadonly = z2;
            this.mDisplayNumber = i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4] */
    @SuppressLint({"NewApi"})
    public static List<a> getStorageList() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        String str;
        int i;
        boolean z = false;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        String aLw = com.baidu.swan.apps.storage.b.aLw();
        boolean z2 = c.hasGingerbread() ? !Environment.isExternalStorageRemovable() : false;
        String externalStorageState = Environment.getExternalStorageState();
        z = (externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) ? true : true;
        boolean equals = Environment.getExternalStorageState().equals("mounted_ro");
        try {
            try {
                HashSet hashSet = new HashSet();
                bufferedReader2 = new BufferedReader(new FileReader("/proc/mounts"));
                try {
                    if (DEBUG) {
                        Log.d("StorageUtils", "/proc/mounts");
                    }
                    int i2 = 1;
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (DEBUG) {
                            Log.d("StorageUtils", readLine);
                        }
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine, " ");
                        String nextToken = stringTokenizer.nextToken();
                        String nextToken2 = stringTokenizer.nextToken();
                        if (!hashSet.contains(nextToken2)) {
                            stringTokenizer.nextToken();
                            boolean contains = Arrays.asList(stringTokenizer.nextToken().split(",")).contains("ro");
                            if (readLine.contains("vfat") || readLine.contains("/mnt")) {
                                if (nextToken2.equals(aLw)) {
                                    hashSet.add(aLw);
                                    hashMap.put(nextToken, new a(aLw, z2, contains, -1));
                                } else if (readLine.contains("/dev/block/vold")) {
                                    if (!readLine.contains("/mnt/secure") && !readLine.contains("/mnt/asec") && !readLine.contains("/mnt/obb") && !readLine.contains("/dev/mapper") && !readLine.contains("tmpfs")) {
                                        hashSet.add(nextToken2);
                                        if (!hashMap.containsKey(nextToken)) {
                                            hashMap.put(nextToken, new a(nextToken2, false, contains, i2));
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
                                        if (TextUtils.equals(((a) hashMap.get(str)).mPath, nextToken)) {
                                            break;
                                        }
                                    }
                                    hashMap.remove(str);
                                    hashSet.add(nextToken2);
                                    if (hashMap.containsKey(nextToken)) {
                                        i = i2;
                                    } else {
                                        i = i2 + 1;
                                        hashMap.put(nextToken, new a(nextToken2, false, contains, i2));
                                    }
                                    i2 = i;
                                }
                            } else if (isFuseStorage(nextToken, nextToken2)) {
                                hashSet.add(nextToken2);
                                if (isPathAccessable(nextToken2)) {
                                    arrayList.add(new a(nextToken2, false, contains, i2));
                                    i2++;
                                }
                            }
                        }
                    }
                    for (a aVar : hashMap.values()) {
                        if (isPathAccessable(aVar.mPath)) {
                            arrayList.add(aVar);
                        }
                    }
                    if (!hashSet.contains(aLw) && z) {
                        arrayList.add(0, new a(aLw, z2, equals, -1));
                    }
                    com.baidu.swan.c.d.closeSafely(bufferedReader2);
                } catch (FileNotFoundException e) {
                    e = e;
                    bufferedReader3 = bufferedReader2;
                    try {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader3);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.c.d.closeSafely(bufferedReader2);
                    return arrayList;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.swan.c.d.closeSafely(bufferedReader);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            bufferedReader3 = null;
        } catch (IOException e4) {
            e = e4;
            bufferedReader2 = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            com.baidu.swan.c.d.closeSafely(bufferedReader);
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
        if (str == null || !str.contains("/dev/fuse") || str2 == null || str2.startsWith("/storage/emulated/legacy") || str2.contains("/Android/obb")) {
            return false;
        }
        if (str2.startsWith("/storage/")) {
            return true;
        }
        return (!c.hasKitKat() || str2.startsWith("/mnt/") || str2.startsWith("/data/")) ? false : true;
    }

    public static boolean externalMemoryAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static long getAvailableExternalMemorySize() {
        long blockSize;
        long availableBlocks;
        if (externalMemoryAvailable()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (c.hasJellyBeanMR2()) {
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
}
