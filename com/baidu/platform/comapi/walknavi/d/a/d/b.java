package com.baidu.platform.comapi.walknavi.d.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.npc.ArBridge;
import com.baidu.platform.comapi.walknavi.d.a.g.j;
import com.facebook.common.util.UriUtil;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f9969a;

    /* renamed from: b  reason: collision with root package name */
    public C0124b f9970b;

    /* renamed from: c  reason: collision with root package name */
    public a f9971c;

    /* renamed from: d  reason: collision with root package name */
    public g f9972d;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i);

        void a(boolean z, boolean z2);
    }

    public b(Context context) {
        this.f9969a = context;
        this.f9972d = new g(context);
    }

    private void d(String str) {
        b();
        C0124b c0124b = new C0124b(this.f9969a, str);
        this.f9970b = c0124b;
        c0124b.start();
    }

    public static String e(String str) {
        int lastIndexOf = str.lastIndexOf(47) + 1;
        int lastIndexOf2 = str.lastIndexOf(46);
        if (lastIndexOf2 != -1) {
            return str.substring(lastIndexOf, lastIndexOf2);
        }
        return str.substring(lastIndexOf);
    }

    public void b(String str) {
        if (com.baidu.platform.comapi.walknavi.d.a.d.a.a(this.f9971c)) {
            return;
        }
        if (c()) {
            a(true, false);
        } else if (!TextUtils.equals(this.f9972d.b(), com.baidu.platform.comapi.walknavi.d.a.g.b.b())) {
            d(str);
        } else {
            String a2 = this.f9972d.a();
            String e2 = e(str);
            if (!TextUtils.isEmpty(a2) && TextUtils.equals(a2, e2)) {
                File file = new File(b(this.f9969a), a2);
                if (file.exists()) {
                    File[] a3 = a(new File(file, UriUtil.LOCAL_RESOURCE_SCHEME));
                    if (a3 != null && a3.length > 0) {
                        a(a(a3), false);
                        return;
                    }
                    this.f9972d.a("");
                }
            }
            d(str);
        }
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.d.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0124b extends Thread {

        /* renamed from: b  reason: collision with root package name */
        public Context f9974b;

        /* renamed from: c  reason: collision with root package name */
        public String f9975c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f9976d = false;

        public C0124b(Context context, String str) {
            this.f9974b = context;
            this.f9975c = str;
        }

        private boolean a(String str, File file) {
            return com.baidu.platform.comapi.walknavi.d.a.d.a.b.a(str, file, new d(this));
        }

        public boolean b() {
            return this.f9976d;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            h hVar = new h();
            String str = this.f9975c;
            hVar.f9987b = str;
            hVar.f9986a = b.e(str);
            String str2 = hVar.f9987b;
            File file = new File(b.b(this.f9974b), hVar.f9986a);
            File file2 = new File(file, "res.zip");
            com.baidu.platform.comapi.walknavi.d.a.d.a.a.a(file2);
            boolean a2 = a(str2, file2);
            if (b()) {
                com.baidu.platform.comapi.walknavi.d.a.d.a.a.b(file);
            } else if (a2 && com.baidu.platform.comapi.walknavi.d.a.d.a.e.a(file2, file) && b.this.b(new File(file, UriUtil.LOCAL_RESOURCE_SCHEME))) {
                a(true, hVar);
            } else {
                a(false, (h) null);
            }
        }

        public void a() {
            this.f9976d = true;
        }

        private void a(boolean z, h hVar) {
            j.a(new f(this, z, hVar));
        }
    }

    private boolean c(File file) {
        try {
            if (file.exists()) {
                String absolutePath = file.getAbsolutePath();
                if (com.baidu.platform.comapi.walknavi.d.a.d.a.a(absolutePath)) {
                    System.load(absolutePath);
                    return true;
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("loadSoFile error: " + th.getMessage());
            return false;
        }
    }

    public void a(a aVar) {
        this.f9971c = aVar;
    }

    public static boolean c() {
        try {
            return ArBridge.libraryHasLoaded();
        } catch (Throwable th) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("hasLoad() error: " + th.getMessage());
            return false;
        }
    }

    public boolean a() {
        File[] a2;
        if (c()) {
            return true;
        }
        String a3 = this.f9972d.a();
        if (TextUtils.isEmpty(a3)) {
            return false;
        }
        File file = new File(b(this.f9969a), a3);
        if (!file.exists() || (a2 = a(new File(file, UriUtil.LOCAL_RESOURCE_SCHEME))) == null || a2.length <= 0) {
            return false;
        }
        return a(a2);
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str) || c()) {
            return false;
        }
        if (TextUtils.equals(this.f9972d.b(), com.baidu.platform.comapi.walknavi.d.a.g.b.b())) {
            String a2 = this.f9972d.a();
            return TextUtils.isEmpty(a2) || !TextUtils.equals(a2, e(str));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(File file) {
        return a(a(file));
    }

    public void b() {
        C0124b c0124b = this.f9970b;
        if (c0124b != null) {
            c0124b.a();
            this.f9970b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        a aVar = this.f9971c;
        if (aVar != null) {
            aVar.a(z, z2);
        }
    }

    public static File b(Context context) {
        File file = new File(context.getFilesDir(), "baiduarsolib");
        com.baidu.platform.comapi.walknavi.d.a.d.a.a.a(file);
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        a aVar = this.f9971c;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public static boolean b(File[] fileArr) {
        if (fileArr != null && fileArr.length == 1) {
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
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("SoDownloader, The number of files is not 1");
        return false;
    }

    private File[] a(File file) {
        return file.listFiles(new c(this));
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
}
