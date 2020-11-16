package com.baidu.platform.comapi.walknavi.d.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.npc.ArBridge;
import com.baidu.platform.comapi.walknavi.d.a.g.j;
import java.io.File;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2975a;
    private C0287b b;
    private a c;
    private g d;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i);

        void a(boolean z, boolean z2);
    }

    public b(Context context) {
        this.f2975a = context;
        this.d = new g(context);
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public boolean a() {
        File[] a2;
        if (c()) {
            return true;
        }
        String a3 = this.d.a();
        if (!TextUtils.isEmpty(a3)) {
            File file = new File(b(this.f2975a), a3);
            if (file.exists() && (a2 = a(new File(file, "res"))) != null && a2.length > 0) {
                return a(a2);
            }
        }
        return false;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str) || c()) {
            return false;
        }
        if (TextUtils.equals(this.d.b(), com.baidu.platform.comapi.walknavi.d.a.g.b.b())) {
            String a2 = this.d.a();
            return TextUtils.isEmpty(a2) || !TextUtils.equals(a2, e(str));
        }
        return true;
    }

    public void b(String str) {
        if (!com.baidu.platform.comapi.walknavi.d.a.d.a.a(this.c)) {
            if (c()) {
                a(true, false);
            } else if (!TextUtils.equals(this.d.b(), com.baidu.platform.comapi.walknavi.d.a.g.b.b())) {
                d(str);
            } else {
                String a2 = this.d.a();
                String e = e(str);
                if (!TextUtils.isEmpty(a2) && TextUtils.equals(a2, e)) {
                    File file = new File(b(this.f2975a), a2);
                    if (file.exists()) {
                        File[] a3 = a(new File(file, "res"));
                        if (a3 != null && a3.length > 0) {
                            a(a(a3), false);
                            return;
                        }
                        this.d.a("");
                    }
                }
                d(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        if (this.c != null) {
            this.c.a(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
    }

    private void d(String str) {
        b();
        this.b = new C0287b(this.f2975a, str);
        this.b.start();
    }

    private File[] a(File file) {
        return file.listFiles(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(File file) {
        return a(a(file));
    }

    private boolean a(File[] fileArr) {
        if (b(fileArr)) {
            if (fileArr != null) {
                for (File file : fileArr) {
                    if (!c(file)) {
                        return false;
                    }
                }
            }
            return c();
        }
        return false;
    }

    private boolean c(File file) {
        try {
            if (file.exists()) {
                String absolutePath = file.getAbsolutePath();
                if (com.baidu.platform.comapi.walknavi.d.a.d.a.a(absolutePath)) {
                    System.load(absolutePath);
                }
                return true;
            }
        } catch (Throwable th) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("loadSoFile error: " + th.getMessage());
        }
        return false;
    }

    public void b() {
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str) {
        int lastIndexOf = str.lastIndexOf(47) + 1;
        int lastIndexOf2 = str.lastIndexOf(46);
        return lastIndexOf2 != -1 ? str.substring(lastIndexOf, lastIndexOf2) : str.substring(lastIndexOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.platform.comapi.walknavi.d.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0287b extends Thread {
        private Context b;
        private String c;
        private volatile boolean d = false;

        public C0287b(Context context, String str) {
            this.b = context;
            this.c = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            h hVar = new h();
            hVar.b = this.c;
            hVar.f2982a = b.e(this.c);
            String str = hVar.b;
            File file = new File(b.b(this.b), hVar.f2982a);
            File file2 = new File(file, "res.zip");
            com.baidu.platform.comapi.walknavi.d.a.d.a.a.a(file2);
            boolean a2 = a(str, file2);
            if (b()) {
                com.baidu.platform.comapi.walknavi.d.a.d.a.a.b(file);
            } else if (a2 && com.baidu.platform.comapi.walknavi.d.a.d.a.e.a(file2, file) && b.this.b(new File(file, "res"))) {
                a(true, hVar);
            } else {
                a(false, (h) null);
            }
        }

        private boolean a(String str, File file) {
            return com.baidu.platform.comapi.walknavi.d.a.d.a.b.a(str, file, new d(this));
        }

        public void a() {
            this.d = true;
        }

        public boolean b() {
            return this.d;
        }

        private void a(boolean z, h hVar) {
            j.a(new f(this, z, hVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File b(Context context) {
        File file = new File(context.getFilesDir(), "baiduarsolib");
        com.baidu.platform.comapi.walknavi.d.a.d.a.a.a(file);
        return file;
    }

    private static boolean b(File[] fileArr) {
        if (fileArr == null || fileArr.length != 1) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("SoDownloader, The number of files is not 1");
            return false;
        }
        boolean z = false;
        for (File file : fileArr) {
            if ("libbaiduar.so".equals(file.getName())) {
                z = true;
            }
        }
        if (z) {
            return true;
        }
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("SoDownloader, Can not found libbaiduar.so");
        return false;
    }

    private static boolean c() {
        try {
            return ArBridge.libraryHasLoaded();
        } catch (Throwable th) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("hasLoad() error: " + th.getMessage());
            return false;
        }
    }
}
