package com.baidu.mapsdkplatform.comapi.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/* loaded from: classes8.dex */
public final class e {
    private static volatile e a = null;
    private boolean b = false;
    private boolean c = true;
    private final List<d> d = new ArrayList();
    private d e = null;
    private String f;

    private e() {
    }

    public static e a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    private boolean a(String str) {
        boolean z;
        Exception e;
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
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e3) {
            z = false;
            e = e3;
        }
        return z;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(14)
    private void c(Context context) {
        boolean z;
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = storageManager.getClass().getMethod("getVolumeState", String.class);
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Method method4 = cls.getMethod("getPath", new Class[0]);
            Object[] objArr = (Object[]) method.invoke(storageManager, new Object[0]);
            if (objArr != null) {
                for (Object obj : objArr) {
                    String str = (String) method4.invoke(obj, new Object[0]);
                    if (str != null && str.length() > 0 && "mounted".equals(method2.invoke(storageManager, str))) {
                        boolean z2 = !((Boolean) method3.invoke(obj, new Object[0])).booleanValue();
                        if (Build.VERSION.SDK_INT <= 19 && a(str)) {
                            this.d.add(new d(str, !z2, z2 ? "内置存储卡" : "外置存储卡", context));
                        } else if (Build.VERSION.SDK_INT >= 19 && new File(str + File.separator + "BaiduMapSDKNew").exists() && str.equals(context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", ""))) {
                            this.f = str + File.separator + "BaiduMapSDKNew";
                        }
                    }
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    File[] externalFilesDirs = context.getExternalFilesDirs(null);
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.d);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= externalFilesDirs.length || externalFilesDirs[i2] == null) {
                            break;
                        }
                        String absolutePath = externalFilesDirs[i2].getAbsolutePath();
                        Iterator<d> it = this.d.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (absolutePath.startsWith(it.next().a())) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                        if (str2 != null && !z && absolutePath.indexOf(str2) != -1) {
                            arrayList.add(new d(absolutePath, true, "外置存储卡", context));
                        }
                        i = i2 + 1;
                    }
                    this.d.clear();
                    this.d.addAll(arrayList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(Context context) {
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
                        } catch (Exception e) {
                            e = e;
                            try {
                                e.printStackTrace();
                                if (scanner != null) {
                                    scanner.close();
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
                    } catch (Throwable th2) {
                        th = th2;
                        scanner2 = scanner;
                        if (scanner2 != null) {
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
            this.d.add(new d(absolutePath, false, "Auto", context));
            for (String str2 : arrayList) {
                if (arrayList2.contains(str2) && !str2.equals(absolutePath)) {
                    File file3 = new File(str2);
                    if (file3.exists() && file3.isDirectory() && file3.canWrite()) {
                        this.d.add(new d(str2, false, "Auto", context));
                    }
                }
            }
            if (0 != 0) {
                scanner2.close();
            }
        } catch (Exception e2) {
            e = e2;
            scanner = null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0049 -> B:63:0x0012). Please submit an issue!!! */
    public void a(Context context) {
        int i;
        d dVar;
        int i2 = 0;
        if (this.b) {
            return;
        }
        this.b = true;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                c(context);
            } else {
                d(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.d.size() > 0) {
                d dVar2 = null;
                for (d dVar3 : this.d) {
                    if (new File(dVar3.b()).exists()) {
                        int i3 = i2 + 1;
                        dVar = dVar3;
                        i = i3;
                    } else {
                        i = i2;
                        dVar = dVar2;
                    }
                    dVar2 = dVar;
                    i2 = i;
                }
                if (i2 == 0) {
                    this.e = b(context);
                    if (this.e == null) {
                        Iterator<d> it = this.d.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            d next = it.next();
                            if (a(context, next)) {
                                this.e = next;
                                break;
                            }
                        }
                    }
                } else if (i2 != 1) {
                    this.e = b(context);
                } else if (a(context, dVar2)) {
                    this.e = dVar2;
                }
                if (this.e == null) {
                    this.e = this.d.get(0);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.e == null || !a(this.e.a())) {
                this.c = false;
                this.e = new d(context);
                this.d.clear();
                this.d.add(this.e);
                return;
            }
            File file = new File(this.e.b());
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(this.e.c());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, ".nomedia");
            if (file3.exists()) {
                return;
            }
            file3.createNewFile();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public boolean a(Context context, d dVar) {
        String a2 = dVar.a();
        if (a(a2)) {
            SharedPreferences.Editor edit = context.getSharedPreferences("map_pref", 0).edit();
            edit.putString("PREFFERED_SD_CARD", a2);
            return edit.commit();
        }
        return false;
    }

    public d b() {
        return this.e;
    }

    public d b(Context context) {
        String string = context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
        if (string != null && string.length() > 0) {
            for (d dVar : this.d) {
                if (dVar.a().equals(string)) {
                    return dVar;
                }
            }
        }
        return null;
    }
}
