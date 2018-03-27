package com.baidu.location.h;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/* loaded from: classes.dex */
public final class h {
    private final List<g> b = new ArrayList();
    private Context d;
    private static volatile h aEs = null;
    public static String a = vq().b() + "/baidu/tempdata";

    private h(Context context) {
        this.d = context;
    }

    private boolean a(String str) {
        boolean z;
        Exception e;
        File file;
        try {
            file = new File(str, "test.0");
            if (file.exists()) {
                file.delete();
            }
            z = file.createNewFile();
        } catch (Exception e2) {
            z = false;
            e = e2;
        }
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return z;
        }
        return z;
    }

    private List<g> d() {
        boolean z;
        try {
            StorageManager storageManager = (StorageManager) this.d.getSystemService("storage");
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
                            this.b.add(new g(str, !z2, z2 ? "Internal Storage" : "External Storage"));
                        }
                    }
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    File[] externalFilesDirs = this.d.getExternalFilesDirs(null);
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.b);
                    for (int i = 0; i < externalFilesDirs.length && externalFilesDirs[i] != null; i++) {
                        String absolutePath = externalFilesDirs[i].getAbsolutePath();
                        Iterator<g> it = this.b.iterator();
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
                        if (!z && absolutePath.indexOf(this.d.getPackageName()) != -1) {
                            arrayList.add(new g(absolutePath, true, "External Storage"));
                        }
                    }
                    this.b.clear();
                    this.b.addAll(arrayList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<g> e() {
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
                            if (nextLine.startsWith("/dev/block/vold/") && (split2 = nextLine.replace('\t', ' ').split(" ")) != null && split2.length > 0) {
                                arrayList.add(split2[1]);
                            }
                        } catch (Throwable th) {
                            th = th;
                            scanner2 = scanner;
                            if (scanner2 != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        try {
                            e.printStackTrace();
                            if (scanner != null) {
                                scanner.close();
                            }
                            return this.b;
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
                        if (nextLine2.startsWith("dev_mount") && (split = nextLine2.replace('\t', ' ').split(" ")) != null && split.length > 0) {
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
                            scanner2.close();
                        }
                        throw th;
                    }
                }
                scanner.close();
            }
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            this.b.add(new g(absolutePath, false, "Auto"));
            for (String str2 : arrayList) {
                if (arrayList2.contains(str2) && !str2.equals(absolutePath)) {
                    File file3 = new File(str2);
                    if (file3.exists() && file3.isDirectory() && file3.canWrite()) {
                        this.b.add(new g(str2, false, "Auto"));
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
        return this.b;
    }

    public static h vq() {
        if (aEs == null) {
            synchronized (h.class) {
                if (aEs == null) {
                    aEs = new h(com.baidu.location.f.getServiceContext());
                }
            }
        }
        return aEs;
    }

    public String b() {
        List<g> c = c();
        if (c == null || c.size() == 0) {
            return null;
        }
        return c.get(0).a();
    }

    public List<g> c() {
        List<g> d = Build.VERSION.SDK_INT >= 14 ? d() : null;
        return (d == null || d.size() <= 0) ? e() : d;
    }
}
