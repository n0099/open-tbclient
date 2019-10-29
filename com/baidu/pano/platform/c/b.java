package com.baidu.pano.platform.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.mobstat.Config;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/* loaded from: classes5.dex */
public final class b {
    static String a;
    static String b;
    static String c;
    static int d;
    static int e;
    static int f;
    private static volatile b h = null;
    private boolean g = false;

    private b() {
    }

    public static b a() {
        if (h == null) {
            synchronized (b.class) {
                if (h == null) {
                    h = new b();
                }
            }
        }
        return h;
    }

    public void a(Context context) {
        if (!this.g) {
            this.g = true;
            try {
                if (Build.VERSION.SDK_INT >= 14) {
                    b(context);
                } else {
                    c(context);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (a != null && !a.equals("")) {
                b = a + File.separator + "BaiduPanoSDK" + File.separator + "cache";
                c = context.getCacheDir().getAbsolutePath();
                d = 20971520;
                e = 52428800;
                f = 5242880;
                return;
            }
            if (context.getCacheDir() != null) {
                b = context.getCacheDir().getAbsolutePath();
            } else {
                b = "";
            }
            c = "";
            d = 10485760;
            e = 10485760;
            f = 5242880;
        }
    }

    @SuppressLint({"NewApi"})
    @TargetApi(14)
    private void b(Context context) {
        boolean z;
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = storageManager.getClass().getMethod("getVolumeState", String.class);
            Method method3 = Class.forName("android.os.storage.StorageVolume").getMethod("getPath", new Class[0]);
            Object[] objArr = (Object[]) method.invoke(storageManager, new Object[0]);
            ArrayList arrayList = new ArrayList();
            if (objArr != null) {
                for (Object obj : objArr) {
                    String str = (String) method3.invoke(obj, new Object[0]);
                    if (str != null && str.length() > 0 && "mounted".equals(method2.invoke(storageManager, str)) && b(str)) {
                        arrayList.add(str);
                        if (a(a(str))) {
                            a = str;
                            return;
                        }
                    }
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    File[] externalFilesDirs = context.getExternalFilesDirs(null);
                    for (int i = 0; i < externalFilesDirs.length && externalFilesDirs[i] != null; i++) {
                        String absolutePath = externalFilesDirs[i].getAbsolutePath();
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (absolutePath.startsWith((String) it.next())) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (!z && b(absolutePath) && a(a(absolutePath))) {
                            a = absolutePath;
                            return;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [224=6, 225=5] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(Context context) {
        Scanner scanner;
        String[] split;
        String[] split2;
        Scanner scanner2 = null;
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            File file = new File("/proc/mounts");
            if (file.exists()) {
                scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    try {
                        try {
                            String nextLine = scanner.nextLine();
                            if (nextLine.startsWith("/dev/block/vold/") && (split2 = nextLine.replace('\t', ' ').split(HanziToPinyin.Token.SEPARATOR)) != null && split2.length > 0) {
                                arrayList.add(split2[1]);
                            }
                        } catch (Throwable th) {
                            th = th;
                            scanner2 = scanner;
                            if (scanner2 != null) {
                                scanner2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (scanner != null) {
                                scanner.close();
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            scanner2 = scanner;
                            if (scanner2 != null) {
                            }
                            throw th;
                        }
                    }
                }
                scanner.close();
            }
            File file2 = new File("/system/etc/vold.fstab");
            if (file2.exists()) {
                scanner = new Scanner(file2);
                while (scanner.hasNext()) {
                    try {
                        String nextLine2 = scanner.nextLine();
                        if (nextLine2.startsWith("dev_mount") && (split = nextLine2.replace('\t', ' ').split(HanziToPinyin.Token.SEPARATOR)) != null && split.length > 0) {
                            String str = split[2];
                            if (str.contains(":")) {
                                str = str.substring(0, str.indexOf(":"));
                            }
                            arrayList2.add(str);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        scanner2 = scanner;
                        if (scanner2 != null) {
                        }
                        throw th;
                    }
                }
                scanner.close();
            }
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            if (a(a(absolutePath))) {
                a = absolutePath;
                if (0 != 0) {
                    scanner2.close();
                    return;
                }
                return;
            }
            for (String str2 : arrayList) {
                if (arrayList2.contains(str2) && !str2.equals(absolutePath)) {
                    File file3 = new File(str2);
                    if (file3.exists() && file3.isDirectory() && file3.canWrite() && a(a(absolutePath))) {
                        a = absolutePath;
                        if (0 != 0) {
                            scanner2.close();
                            return;
                        }
                        return;
                    }
                }
            }
            if (0 != 0) {
                scanner2.close();
            }
        } catch (Exception e3) {
            e = e3;
            scanner = null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static String b() {
        return b + File.separator + "cacheNet";
    }

    @SuppressLint({"NewApi"})
    public long a(String str) {
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                availableBlocks = statFs.getAvailableBytes();
            } else {
                availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            return availableBlocks;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    private boolean a(long j) {
        if (j < 0) {
            j = 0;
        }
        return j > Config.RAVEN_LOG_LIMIT;
    }

    private boolean b(String str) {
        boolean z;
        Exception e2;
        try {
            File file = new File(str + "/test.0");
            if (file.exists()) {
                file.delete();
            }
            z = file.createNewFile();
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e3) {
                e2 = e3;
                e2.printStackTrace();
                return z;
            }
        } catch (Exception e4) {
            z = false;
            e2 = e4;
        }
        return z;
    }
}
