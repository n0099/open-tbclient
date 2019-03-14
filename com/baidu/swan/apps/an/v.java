package com.baidu.swan.apps.an;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
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
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
public final class v {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes2.dex */
    public static class a {
        public final boolean aWp;
        public final boolean aWq;
        public final int aWr;
        public final String mPath;

        a(String str, boolean z, boolean z2, int i) {
            this.mPath = str;
            this.aWp = z;
            this.aWq = z2;
            this.aWr = i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=5, 205=4, 206=4, 207=4] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<a> Me() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        String str;
        int i;
        boolean z = false;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        String path = Environment.getExternalStorageDirectory().getPath();
        boolean z2 = com.baidu.swan.apps.an.a.hasGingerbread() ? !Environment.isExternalStorageRemovable() : false;
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
                            boolean contains = Arrays.asList(stringTokenizer.nextToken().split(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("ro");
                            if (readLine.contains("vfat") || readLine.contains("/mnt")) {
                                if (nextToken2.equals(path)) {
                                    hashSet.add(path);
                                    hashMap.put(nextToken, new a(path, z2, contains, -1));
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
                            } else if (aK(nextToken, nextToken2)) {
                                hashSet.add(nextToken2);
                                if (hD(nextToken2)) {
                                    arrayList.add(new a(nextToken2, false, contains, i2));
                                    i2++;
                                }
                            }
                        }
                    }
                    for (a aVar : hashMap.values()) {
                        if (hD(aVar.mPath)) {
                            arrayList.add(aVar);
                        }
                    }
                    if (!hashSet.contains(path) && z) {
                        arrayList.add(0, new a(path, z2, equals, -1));
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    bufferedReader3 = bufferedReader2;
                    try {
                        e.printStackTrace();
                        if (bufferedReader3 != null) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        if (bufferedReader != null) {
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
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
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

    private static boolean hD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).canRead();
    }

    private static boolean aK(String str, String str2) {
        if (str != null && str.contains("/dev/fuse") && str2 != null && !str2.startsWith("/storage/emulated/legacy") && !str2.contains("/Android/obb")) {
            if (str2.startsWith("/storage/")) {
                return true;
            }
            if (com.baidu.swan.apps.an.a.hasKitKat() && !str2.startsWith("/mnt/") && !str2.startsWith("/data/")) {
                return true;
            }
        }
        return false;
    }
}
