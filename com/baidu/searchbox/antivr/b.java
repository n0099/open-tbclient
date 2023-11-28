package com.baidu.searchbox.antivr;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Pair;
import com.kuaishou.weapon.p0.t;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {
    public static final String a = "/data/data";
    public static final String b = "/data/user/0";
    public static final String c = "/data/user_de/0";
    public Application d;
    public String e;
    public RuntimeResult f;
    public HashSet<String> g;

    public b(Application application, String str) {
        this.d = application;
        this.e = str;
        b();
    }

    private Pair<String, String> a(String str) {
        String trim = str.trim();
        if (TextUtils.isEmpty(trim)) {
            return null;
        }
        String[] split = trim.split("\\s+");
        a.a("user = " + split[0] + ", pkg name = " + split[split.length - 1]);
        return new Pair<>(split[0], split[split.length - 1]);
    }

    private ArrayList<String> a(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.contains(str2)) {
                    arrayList.add(readLine);
                }
            }
        } catch (Exception e) {
            a.a("execCmdAndFilter, cmd = " + str + ", filter = " + str2, e);
        }
        return arrayList;
    }

    private void b() {
        HashSet<String> hashSet = new HashSet<>();
        this.g = hashSet;
        hashSet.add("ps");
        this.g.add("sh");
        this.g.add("cat");
        this.g.add("app_process");
        this.g.add("/system/bin/dex2oat");
        this.g.add("zygote");
        this.g.add("sync_sys");
        this.g.add("logcat");
        this.g.add("chmod");
        this.g.add("netstat");
        this.g.add("ping");
        this.g.add(t.w);
    }

    private void c() {
        try {
            Field declaredField = Class.forName("android.app.Application").getDeclaredField("mLoadedApk");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.d);
            Field declaredField2 = Class.forName("android.app.LoadedApk").getDeclaredField("mClassLoader");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            a.a("classLoader = " + obj2.getClass().getName());
        } catch (Exception e) {
            a.a("check package manager exception!", e);
        }
    }

    private void d() {
        Object obj;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mPackages");
            declaredField.setAccessible(true);
            WeakReference weakReference = (WeakReference) (Build.VERSION.SDK_INT >= 19 ? ((ArrayMap) declaredField.get(invoke)).get(this.e) : ((HashMap) declaredField.get(invoke)).get(this.e));
            if (weakReference == null || (obj = weakReference.get()) == null) {
                a.a("classLoader from ActivityThread loaded apk null ");
                return;
            }
            Field declaredField2 = Class.forName("android.app.LoadedApk").getDeclaredField("mClassLoader");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            a.a("classLoader from ActivityThread = " + obj2.getClass().getName());
        } catch (Exception e) {
            a.a("check classloader exception!", e);
        }
    }

    private void e() {
        String absolutePath = this.d.getFilesDir().getAbsolutePath();
        if (TextUtils.isEmpty(absolutePath)) {
            return;
        }
        String[] split = absolutePath.split("/");
        String replaceAll = absolutePath.startsWith(a) ? split[3] : (absolutePath.startsWith(b) || absolutePath.startsWith(c)) ? split[4] : absolutePath.replaceAll(this.e, "x");
        a.a("host pkg = " + replaceAll);
        if (TextUtils.equals(this.e, replaceAll)) {
            return;
        }
        this.f.a(true);
        this.f.a(replaceAll);
    }

    private void f() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("sPackageManager");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(invoke);
            if (obj instanceof Proxy) {
                String name = Proxy.getInvocationHandler(obj).getClass().getName();
                this.f.a(true);
                this.f.b(name);
            }
        } catch (Exception e) {
            a.a("check package manager exception!", e);
        }
    }

    private void g() {
        String h = h();
        ArrayList<String> a2 = a("ps " + h, h);
        a.a("pid = " + h + ", boxLines size = " + a2.size());
        if (a2.size() > 0) {
            String str = a2.get(0).split("\\s+")[0];
            if (TextUtils.isEmpty(str) || "root".equals(str)) {
                return;
            }
            ArrayList<String> a3 = a("ps", str);
            a.a("user = " + str + ", userProcessLines size = " + a3.size());
            if (a3.size() > 0) {
                HashSet hashSet = new HashSet(a3.size());
                Iterator<String> it = a3.iterator();
                while (it.hasNext()) {
                    Pair<String, String> a4 = a(it.next());
                    if (a4 != null) {
                        String str2 = (String) a4.second;
                        if (TextUtils.equals((String) a4.first, str) && !TextUtils.isEmpty(str2) && !str2.contains(this.e) && !str2.contains(":") && !str2.startsWith("Thread-") && !this.g.contains(str2) && str2.contains(".")) {
                            hashSet.add(str2);
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    this.f.a(true);
                    StringBuilder sb = new StringBuilder();
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        sb.append((String) it2.next());
                        sb.append("|");
                    }
                    a.a("uid = " + str + ", pkgs = " + sb.toString());
                    this.f.c(sb.toString());
                }
            }
        }
    }

    private String h() {
        ArrayList<String> a2 = a("cat /proc/self/status", "PPid");
        if (a2.size() > 0) {
            String trim = a2.get(0).substring(5).trim();
            a.a("pid from cat = " + trim + ", pid from api = " + Process.myPid());
            if (!TextUtils.isEmpty(trim)) {
                return trim;
            }
        }
        return String.valueOf(Process.myPid());
    }

    public RuntimeResult a() {
        RuntimeResult runtimeResult = this.f;
        if (runtimeResult != null) {
            runtimeResult.a();
        } else {
            this.f = new RuntimeResult();
        }
        try {
            f();
            g();
            e();
        } catch (Exception e) {
            a.a("check exception!", e);
        }
        return this.f;
    }
}
