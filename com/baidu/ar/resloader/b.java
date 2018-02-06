package com.baidu.ar.resloader;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.ar.resloader.utils.FileUtils;
import com.baidu.ar.resloader.utils.HttpUtils;
import com.baidu.ar.resloader.utils.IoUtils;
import com.baidu.ar.resloader.utils.ZipUtils;
import com.baidu.ar.util.n;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.slamlibrary.ARAlgoJniClient;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes3.dex */
public class b {
    private final Context a;
    private C0046b b;
    private a c;
    private c d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ar.resloader.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0046b extends Thread {
        private Context b;
        private String c;
        private volatile boolean d = false;

        public C0046b(Context context, String str) {
            this.b = context;
            this.c = str;
        }

        private void a(final boolean z, final d dVar) {
            n.a(new Runnable() { // from class: com.baidu.ar.resloader.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        b.this.d.b(com.baidu.ar.util.c.b());
                        b.this.d.a(dVar.a);
                    }
                    if (C0046b.this.b()) {
                        return;
                    }
                    b.this.a(z);
                }
            });
        }

        private boolean a(String str, File file) {
            return HttpUtils.downloadFile(str, file, new IoUtils.Operation() { // from class: com.baidu.ar.resloader.b.b.1
                @Override // com.baidu.ar.resloader.utils.IoUtils.Cancelable
                public boolean isCancelled() {
                    return C0046b.this.b();
                }

                @Override // com.baidu.ar.resloader.utils.IoUtils.ProgressListener
                public void progress(long j, long j2) {
                }
            });
        }

        public void a() {
            this.d = true;
        }

        public boolean b() {
            return this.d;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            d dVar = new d();
            dVar.b = this.c;
            dVar.a = b.d(this.c);
            String str = dVar.b;
            File file = new File(b.b(this.b), dVar.a);
            File file2 = new File(file, "res.zip");
            FileUtils.ensureParent(file2);
            boolean a = a(str, file2);
            if (b()) {
                FileUtils.deleteDir(file);
            } else if (a && ZipUtils.unzip(file2, file) && b.this.b(new File(file, "res"))) {
                a(true, dVar);
            } else {
                a(false, (d) null);
            }
        }
    }

    public b(Context context) {
        this.a = context;
        this.d = new c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.c != null) {
            this.c.a(z);
        }
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
            return b();
        }
        return false;
    }

    private File[] a(File file) {
        return file.listFiles(new FileFilter() { // from class: com.baidu.ar.resloader.b.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.getName().endsWith(PluginInstallerService.APK_LIB_SUFFIX);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File b(Context context) {
        File file = new File(context.getFilesDir(), "baiduarsolib");
        FileUtils.ensureParent(file);
        return file;
    }

    private static boolean b() {
        return c() && d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(File file) {
        return a(a(file));
    }

    private static boolean b(File[] fileArr) {
        if (fileArr == null || fileArr.length != 2) {
            Log.e("SoDownloader", "The number of files is not 2");
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (File file : fileArr) {
            String name = file.getName();
            if ("libARClient.so".equals(name) || "libArTrackerClient.so".equals(name)) {
                z = true;
            } else if ("libbaiduar.so".equals(name)) {
                z2 = true;
            }
        }
        if (z && z2) {
            return true;
        }
        if (!z) {
            Log.e("SoDownloader", "Can not found libARClient.so");
        }
        if (!z2) {
            Log.e("SoDownloader", "Can not found libbaiduar.so");
        }
        return false;
    }

    private void c(String str) {
        a();
        this.b = new C0046b(this.a, str);
        this.b.start();
    }

    private static boolean c() {
        try {
            return ArBridge.libraryHasLoaded();
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean c(File file) {
        try {
            if (file.exists()) {
                String absolutePath = file.getAbsolutePath();
                if (com.baidu.ar.resloader.a.a(absolutePath)) {
                    System.load(absolutePath);
                }
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        int lastIndexOf = str.lastIndexOf(47) + 1;
        int lastIndexOf2 = str.lastIndexOf(46);
        return lastIndexOf2 != -1 ? str.substring(lastIndexOf, lastIndexOf2) : str.substring(lastIndexOf);
    }

    private static boolean d() {
        try {
            ARAlgoJniClient.getVersion();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public void a() {
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public void a(String str) {
        com.baidu.ar.util.b.a("bdar: url = " + str);
        if (com.baidu.ar.resloader.a.a(this.c)) {
            return;
        }
        if (b()) {
            a(true);
        } else if (TextUtils.isEmpty(str)) {
            com.baidu.ar.util.b.d("bdar: So URL is NULL!!!!");
            a(false);
        } else if (!TextUtils.equals(this.d.b(), com.baidu.ar.util.c.b())) {
            c(str);
        } else {
            String a2 = this.d.a();
            String d = d(str);
            if (!TextUtils.isEmpty(a2) && TextUtils.equals(a2, d)) {
                File file = new File(b(this.a), a2);
                if (file.exists()) {
                    File[] a3 = a(new File(file, "res"));
                    if (a3 != null && a3.length > 0) {
                        a(a(a3));
                        return;
                    }
                    this.d.a("");
                }
            }
            c(str);
        }
    }
}
