package com.baidu.mapsdkplatform.comapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.baidu.adp.plugin.install.PluginInstallerService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes7.dex */
public class NativeLoader {
    private static Context b;
    private static NativeLoader e;

    /* renamed from: a  reason: collision with root package name */
    private static final String f2187a = NativeLoader.class.getSimpleName();
    private static final Set<String> c = new HashSet();
    private static final Set<String> d = new HashSet();
    private static a f = a.ARMEABI;
    private static boolean g = false;
    private static String h = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum a {
        ARMEABI("armeabi"),
        ARMV7("armeabi-v7a"),
        ARM64("arm64-v8a"),
        X86("x86"),
        X86_64("x86_64");
        
        private String f;

        a(String str) {
            this.f = str;
        }

        public String a() {
            return this.f;
        }
    }

    private NativeLoader() {
    }

    @TargetApi(8)
    private String a() {
        return 8 <= Build.VERSION.SDK_INT ? b.getPackageCodePath() : "";
    }

    private String a(a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(PluginInstallerService.APK_LIB_DIR_PREFIX).append(aVar.a()).append("/");
        return sb.toString();
    }

    private void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.e(f2187a, "Close InputStream error", e2);
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    Log.e(f2187a, "Close OutputStream error", e3);
                }
            }
        }
        fileOutputStream.flush();
    }

    private void a(Throwable th) {
        Log.e(f2187a, "loadException", th);
        Iterator<String> it = d.iterator();
        while (it.hasNext()) {
            Log.e(f2187a, it.next() + " Failed to load.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z, String str) {
        g = z;
        h = str;
    }

    private boolean a(String str) {
        try {
            synchronized (c) {
                if (!c.contains(str)) {
                    System.loadLibrary(str);
                    synchronized (c) {
                        c.add(str);
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            return b(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(String str, a aVar) {
        ZipFile zipFile;
        File file = new File(b(), str);
        if (file.exists() && file.length() > 0) {
            return true;
        }
        String str2 = a(aVar) + str;
        String a2 = !g ? a() : h;
        if (a2 == null || a2.isEmpty()) {
            return false;
        }
        try {
            zipFile = new ZipFile(a2);
            try {
                try {
                    ZipEntry entry = zipFile.getEntry(str2);
                    if (entry == null) {
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e2) {
                                Log.e(f2187a, "Release file failed", e2);
                            }
                        }
                        return false;
                    }
                    a(zipFile.getInputStream(entry), new FileOutputStream(new File(b(), str)));
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                            return true;
                        } catch (IOException e3) {
                            Log.e(f2187a, "Release file failed", e3);
                            return true;
                        }
                    }
                    return true;
                } catch (Exception e4) {
                    e = e4;
                    Log.e(f2187a, "Copy library file error", e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e5) {
                            Log.e(f2187a, "Release file failed", e5);
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e6) {
                        Log.e(f2187a, "Release file failed", e6);
                    }
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            zipFile = null;
        } catch (Throwable th2) {
            th = th2;
            zipFile = null;
            if (zipFile != null) {
            }
            throw th;
        }
    }

    private boolean a(String str, String str2) {
        return !a(str2, a.ARMV7) ? b(str, str2) : f(str2, str);
    }

    private String b() {
        File file = new File(b.getFilesDir(), "libs" + File.separator + f.a());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private boolean b(String str) {
        String mapLibraryName = System.mapLibraryName(str);
        boolean z = false;
        synchronized (c) {
            if (c.contains(str)) {
                z = true;
            } else {
                switch (f) {
                    case ARM64:
                        z = c(str, mapLibraryName);
                        break;
                    case ARMV7:
                        z = a(str, mapLibraryName);
                        break;
                    case ARMEABI:
                        z = b(str, mapLibraryName);
                        break;
                    case X86_64:
                        z = e(str, mapLibraryName);
                        break;
                    case X86:
                        z = d(str, mapLibraryName);
                        break;
                }
                synchronized (c) {
                    c.add(str);
                }
            }
        }
        return z;
    }

    private boolean b(String str, String str2) {
        if (a(str2, a.ARMEABI)) {
            return f(str2, str);
        }
        Log.e(f2187a, "found lib " + a.ARMEABI.a() + "/" + str + ".so error");
        return false;
    }

    @TargetApi(21)
    private static a c() {
        String str = Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0];
        if (str == null) {
            return a.ARMEABI;
        }
        if (str.contains("arm") && str.contains("v7")) {
            f = a.ARMV7;
        }
        if (str.contains("arm") && str.contains("64") && d()) {
            f = a.ARM64;
        }
        if (str.contains("x86")) {
            if (str.contains("64")) {
                f = a.X86_64;
            } else {
                f = a.X86;
            }
        }
        return f;
    }

    private boolean c(String str, String str2) {
        return !a(str2, a.ARM64) ? a(str, str2) : f(str2, str);
    }

    private static boolean d() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Process.is64Bit();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.CPU_ABI.equals(Build.SUPPORTED_64_BIT_ABIS[0]);
        }
        return false;
    }

    private boolean d(String str, String str2) {
        return !a(str2, a.X86) ? a(str, str2) : f(str2, str);
    }

    private boolean e(String str, String str2) {
        return !a(str2, a.X86_64) ? d(str, str2) : f(str2, str);
    }

    private boolean f(String str, String str2) {
        try {
            System.load(new File(b(), str).getAbsolutePath());
            synchronized (c) {
                c.add(str2);
            }
            g(str, str2);
            return true;
        } catch (Throwable th) {
            synchronized (d) {
                d.add(str2);
                a(th);
                return false;
            }
        }
    }

    private void g(String str, String str2) {
        if (str == null || str.isEmpty() || !str.contains("libBaiduMapSDK_")) {
            return;
        }
        try {
            String[] split = str.split("_v");
            if (split.length > 1) {
                File[] listFiles = new File(b()).listFiles(new d(this, split[1]));
                if (listFiles == null || listFiles.length == 0) {
                    return;
                }
                for (File file : listFiles) {
                    file.delete();
                }
            }
        } catch (Exception e2) {
        }
    }

    public static synchronized NativeLoader getInstance() {
        NativeLoader nativeLoader;
        synchronized (NativeLoader.class) {
            if (e == null) {
                e = new NativeLoader();
                f = c();
            }
            nativeLoader = e;
        }
        return nativeLoader;
    }

    public static void setContext(Context context) {
        b = context;
    }

    public synchronized boolean loadLibrary(String str) {
        boolean z;
        if (!g) {
            z = a(str);
        } else if (h == null || h.isEmpty()) {
            Log.e(f2187a, "Given custom so file path is null, please check!");
            z = false;
        } else {
            z = b(str);
        }
        return z;
    }
}
