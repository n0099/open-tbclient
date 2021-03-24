package com.baidu.pano.platform.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f9430a;

    /* renamed from: b  reason: collision with root package name */
    public static String f9431b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9432c;

    /* renamed from: d  reason: collision with root package name */
    public static int f9433d;

    /* renamed from: e  reason: collision with root package name */
    public static int f9434e;

    /* renamed from: f  reason: collision with root package name */
    public static int f9435f;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f9436h;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9437g = false;

    public static b a() {
        if (f9436h == null) {
            synchronized (b.class) {
                if (f9436h == null) {
                    f9436h = new b();
                }
            }
        }
        return f9436h;
    }

    private boolean a(long j) {
        if (j < 0) {
            j = 0;
        }
        return j > 52428800;
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
                            f9430a = str;
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
                            f9430a = absolutePath;
                            return;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c(Context context) {
        Scanner scanner;
        String[] split;
        String[] split2;
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Scanner scanner2 = null;
        try {
            try {
                File file = new File("/proc/mounts");
                if (file.exists()) {
                    scanner = new Scanner(file);
                    while (scanner.hasNext()) {
                        try {
                            String nextLine = scanner.nextLine();
                            if (nextLine.startsWith("/dev/block/vold/") && (split2 = nextLine.replace('\t', ' ').split(" ")) != null && split2.length > 0) {
                                arrayList.add(split2[1]);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            scanner2 = scanner;
                            e.printStackTrace();
                            if (scanner2 != null) {
                                scanner2.close();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            scanner2 = scanner;
                            if (scanner2 != null) {
                                scanner2.close();
                            }
                            throw th;
                        }
                    }
                    scanner.close();
                }
                File file2 = new File("/system/etc/vold.fstab");
                if (file2.exists()) {
                    scanner = new Scanner(file2);
                    while (scanner.hasNext()) {
                        String nextLine2 = scanner.nextLine();
                        if (nextLine2.startsWith("dev_mount") && (split = nextLine2.replace('\t', ' ').split(" ")) != null && split.length > 0) {
                            String str = split[2];
                            if (str.contains(":")) {
                                str = str.substring(0, str.indexOf(":"));
                            }
                            arrayList2.add(str);
                        }
                    }
                    scanner.close();
                }
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                if (a(a(absolutePath))) {
                    f9430a = absolutePath;
                    return;
                }
                for (String str2 : arrayList) {
                    if (arrayList2.contains(str2) && !str2.equals(absolutePath)) {
                        File file3 = new File(str2);
                        if (file3.exists() && file3.isDirectory() && file3.canWrite() && a(a(absolutePath))) {
                            f9430a = absolutePath;
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void a(Context context) {
        if (this.f9437g) {
            return;
        }
        this.f9437g = true;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                b(context);
            } else {
                c(context);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String str = f9430a;
        if (str != null && !str.equals("")) {
            f9431b = f9430a + File.separator + "BaiduPanoSDK" + File.separator + SapiOptions.q;
            f9432c = context.getCacheDir().getAbsolutePath();
            f9433d = 20971520;
            f9434e = 52428800;
            f9435f = 5242880;
            return;
        }
        if (context.getCacheDir() != null) {
            f9431b = context.getCacheDir().getAbsolutePath();
        } else {
            f9431b = "";
        }
        f9432c = "";
        f9433d = 10485760;
        f9434e = 10485760;
        f9435f = 5242880;
    }

    public static String b() {
        return f9431b + File.separator + "cacheNet";
    }

    @SuppressLint({"NewApi"})
    public long a(String str) {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return statFs.getBlockSize() * statFs.getAvailableBlocks();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    private boolean b(String str) {
        boolean z = false;
        try {
            File file = new File(str + "/test.0");
            if (file.exists()) {
                file.delete();
            }
            z = file.createNewFile();
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return z;
    }
}
