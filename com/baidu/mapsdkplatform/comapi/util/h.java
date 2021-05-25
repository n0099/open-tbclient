package com.baidu.mapsdkplatform.comapi.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f7913a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7914b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7915c = true;

    /* renamed from: d  reason: collision with root package name */
    public final List<g> f7916d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public g f7917e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f7918f;

    public static h a() {
        if (f7913a == null) {
            synchronized (h.class) {
                if (f7913a == null) {
                    f7913a = new h();
                }
            }
        }
        return f7913a;
    }

    private boolean a(String str) {
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

    @SuppressLint({"NewApi"})
    @TargetApi(14)
    private void c(Context context) {
        boolean z;
        Object[] objArr;
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            int i2 = 1;
            Method method2 = storageManager.getClass().getMethod("getVolumeState", String.class);
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Method method4 = cls.getMethod("getPath", new Class[0]);
            Object[] objArr2 = (Object[]) method.invoke(storageManager, new Object[0]);
            if (objArr2 != null) {
                int length = objArr2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    Object obj = objArr2[i3];
                    String str = (String) method4.invoke(obj, new Object[0]);
                    if (str == null || str.length() <= 0) {
                        objArr = objArr2;
                    } else {
                        objArr = objArr2;
                        Object[] objArr3 = new Object[i2];
                        objArr3[0] = str;
                        if ("mounted".equals(method2.invoke(storageManager, objArr3))) {
                            boolean z2 = !((Boolean) method3.invoke(obj, new Object[0])).booleanValue();
                            if (Build.VERSION.SDK_INT <= 19 && a(str)) {
                                this.f7916d.add(new g(str, !z2, z2 ? "内置存储卡" : "外置存储卡", context));
                            } else if (Build.VERSION.SDK_INT >= 19) {
                                if (new File(str + File.separator + "BaiduMapSDKNew").exists() && str.equals(context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", ""))) {
                                    this.f7918f = str + File.separator + "BaiduMapSDKNew";
                                }
                            }
                        }
                    }
                    i3++;
                    objArr2 = objArr;
                    i2 = 1;
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    File[] externalFilesDirs = context.getExternalFilesDirs(null);
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f7916d);
                    for (int i4 = 0; i4 < externalFilesDirs.length && externalFilesDirs[i4] != null; i4++) {
                        String absolutePath = externalFilesDirs[i4].getAbsolutePath();
                        Iterator<g> it = this.f7916d.iterator();
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
                            arrayList.add(new g(absolutePath, true, "外置存储卡", context));
                        }
                    }
                    this.f7916d.clear();
                    this.f7916d.addAll(arrayList);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d(Context context) {
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
                this.f7916d.add(new g(absolutePath, false, "Auto", context));
                for (String str2 : arrayList) {
                    if (arrayList2.contains(str2) && !str2.equals(absolutePath)) {
                        File file3 = new File(str2);
                        if (file3.exists() && file3.isDirectory() && file3.canWrite()) {
                            this.f7916d.add(new g(str2, false, "Auto", context));
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

    /* JADX WARN: Removed duplicated region for block: B:38:0x0082 A[Catch: Exception -> 0x008d, TRY_LEAVE, TryCatch #1 {Exception -> 0x008d, blocks: (B:14:0x001b, B:16:0x0023, B:17:0x002b, B:19:0x0031, B:21:0x0046, B:23:0x004c, B:25:0x0054, B:26:0x005a, B:28:0x0060, B:30:0x006c, B:36:0x007e, B:38:0x0082, B:32:0x0071, B:35:0x0078), top: B:61:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context) {
        if (this.f7914b) {
            return;
        }
        this.f7914b = true;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                c(context);
            } else {
                d(context);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (this.f7916d.size() > 0) {
            r2 = null;
            int i2 = 0;
            for (g gVar : this.f7916d) {
                if (new File(gVar.b()).exists()) {
                    i2++;
                    r2 = gVar;
                }
            }
            if (i2 == 0) {
                g b2 = b(context);
                this.f7917e = b2;
                if (b2 == null) {
                    for (g gVar2 : this.f7916d) {
                        if (a(context, gVar2)) {
                            this.f7917e = gVar2;
                            break;
                        }
                    }
                }
                if (this.f7917e == null) {
                    this.f7917e = this.f7916d.get(0);
                }
            } else {
                if (i2 != 1) {
                    this.f7917e = b(context);
                } else if (a(context, gVar2)) {
                    this.f7917e = gVar2;
                    break;
                }
                if (this.f7917e == null) {
                }
            }
            e3.printStackTrace();
        }
        try {
            if (this.f7917e == null || !a(this.f7917e.a())) {
                this.f7915c = false;
                this.f7917e = new g(context);
                this.f7916d.clear();
                this.f7916d.add(this.f7917e);
                return;
            }
            File file = new File(this.f7917e.b());
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(this.f7917e.c());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, ".nomedia");
            if (file3.exists()) {
                return;
            }
            file3.createNewFile();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public boolean a(Context context, g gVar) {
        String a2 = gVar.a();
        if (a(a2)) {
            SharedPreferences.Editor edit = context.getSharedPreferences("map_pref", 0).edit();
            edit.putString("PREFFERED_SD_CARD", a2);
            return edit.commit();
        }
        return false;
    }

    public g b() {
        return this.f7917e;
    }

    public g b(Context context) {
        String string = context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        for (g gVar : this.f7916d) {
            if (gVar.a().equals(string)) {
                return gVar;
            }
        }
        return null;
    }
}
