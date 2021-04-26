package com.baidu.mapsdkplatform.comapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes2.dex */
public class NativeLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7756a = "NativeLoader";

    /* renamed from: b  reason: collision with root package name */
    public static Context f7757b;

    /* renamed from: e  reason: collision with root package name */
    public static NativeLoader f7760e;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f7758c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f7759d = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public static a f7761f = a.ARMEABI;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f7762g = false;

    /* renamed from: h  reason: collision with root package name */
    public static String f7763h = null;

    /* loaded from: classes2.dex */
    public enum a {
        ARMEABI("armeabi"),
        ARMV7("armeabi-v7a"),
        ARM64("arm64-v8a"),
        X86("x86"),
        X86_64("x86_64");
        

        /* renamed from: f  reason: collision with root package name */
        public String f7770f;

        a(String str) {
            this.f7770f = str;
        }

        public String a() {
            return this.f7770f;
        }
    }

    @TargetApi(8)
    private String a() {
        return 8 <= Build.VERSION.SDK_INT ? f7757b.getPackageCodePath() : "";
    }

    private String a(a aVar) {
        return PluginInstallerService.APK_LIB_DIR_PREFIX + aVar.a() + "/";
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    private void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.e(f7756a, "Close InputStream error", e2);
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    Log.e(f7756a, "Close OutputStream error", e3);
                }
                throw th;
            }
        }
        fileOutputStream.flush();
        try {
            inputStream.close();
        } catch (IOException e4) {
            Log.e(f7756a, "Close InputStream error", e4);
        }
        try {
            fileOutputStream.close();
        } catch (IOException e5) {
            Log.e(f7756a, "Close OutputStream error", e5);
        }
    }

    private void a(Throwable th) {
        Log.e(f7756a, "loadException", th);
        Iterator<String> it = f7759d.iterator();
        while (it.hasNext()) {
            String str = f7756a;
            Log.e(str, it.next() + " Failed to load.");
        }
    }

    public static void a(boolean z, String str) {
        f7762g = z;
        f7763h = str;
    }

    private boolean a(String str) {
        try {
            synchronized (f7758c) {
                if (f7758c.contains(str)) {
                    return true;
                }
                System.loadLibrary(str);
                synchronized (f7758c) {
                    f7758c.add(str);
                }
                return true;
            }
        } catch (Throwable unused) {
            return b(str);
        }
    }

    private boolean a(String str, a aVar) {
        ZipFile zipFile;
        File file = new File(b(), str);
        if (!file.exists() || file.length() <= 0) {
            String str2 = a(aVar) + str;
            ZipFile zipFile2 = null;
            String a2 = !f7762g ? a() : f7763h;
            if (a2 != null) {
                try {
                    if (!a2.isEmpty()) {
                        try {
                            zipFile = new ZipFile(a2);
                        } catch (Exception e2) {
                            e = e2;
                        }
                        try {
                            ZipEntry entry = zipFile.getEntry(str2);
                            if (entry == null) {
                                try {
                                    zipFile.close();
                                } catch (IOException e3) {
                                    Log.e(f7756a, "Release file failed", e3);
                                }
                                return false;
                            }
                            a(zipFile.getInputStream(entry), new FileOutputStream(new File(b(), str)));
                            try {
                                zipFile.close();
                            } catch (IOException e4) {
                                Log.e(f7756a, "Release file failed", e4);
                            }
                            return true;
                        } catch (Exception e5) {
                            e = e5;
                            zipFile2 = zipFile;
                            Log.e(f7756a, "Copy library file error", e);
                            if (zipFile2 != null) {
                                try {
                                    zipFile2.close();
                                } catch (IOException e6) {
                                    Log.e(f7756a, "Release file failed", e6);
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            zipFile2 = zipFile;
                            if (zipFile2 != null) {
                                try {
                                    zipFile2.close();
                                } catch (IOException e7) {
                                    Log.e(f7756a, "Release file failed", e7);
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return false;
        }
        return true;
    }

    private boolean a(String str, String str2) {
        return !a(str2, a.ARMV7) ? b(str, str2) : f(str2, str);
    }

    private String b() {
        File file = new File(f7757b.getFilesDir(), "libs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private boolean b(String str) {
        String mapLibraryName = System.mapLibraryName(str);
        synchronized (f7758c) {
            if (f7758c.contains(str)) {
                return true;
            }
            int i2 = d.f7835a[f7761f.ordinal()];
            boolean d2 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? false : d(str, mapLibraryName) : e(str, mapLibraryName) : b(str, mapLibraryName) : a(str, mapLibraryName) : c(str, mapLibraryName);
            synchronized (f7758c) {
                f7758c.add(str);
            }
            return d2;
        }
    }

    private boolean b(String str, String str2) {
        if (a(str2, a.ARMEABI)) {
            return f(str2, str);
        }
        String str3 = f7756a;
        Log.e(str3, "found lib" + str + ".so error");
        return false;
    }

    @TargetApi(21)
    public static a c() {
        String str = Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0];
        if (str == null) {
            return a.ARMEABI;
        }
        if (str.contains("arm") && str.contains("v7")) {
            f7761f = a.ARMV7;
        }
        if (str.contains("arm") && str.contains(WebKitFactory.OS_64)) {
            f7761f = a.ARM64;
        }
        if (str.contains("x86")) {
            f7761f = str.contains(WebKitFactory.OS_64) ? a.X86_64 : a.X86;
        }
        return f7761f;
    }

    private boolean c(String str, String str2) {
        return !a(str2, a.ARM64) ? a(str, str2) : f(str2, str);
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
            synchronized (f7758c) {
                f7758c.add(str2);
            }
            return true;
        } catch (Throwable th) {
            synchronized (f7759d) {
                f7759d.add(str2);
                a(th);
                return false;
            }
        }
    }

    public static synchronized NativeLoader getInstance() {
        NativeLoader nativeLoader;
        synchronized (NativeLoader.class) {
            if (f7760e == null) {
                f7760e = new NativeLoader();
                f7761f = c();
            }
            nativeLoader = f7760e;
        }
        return nativeLoader;
    }

    public static void setContext(Context context) {
        f7757b = context;
    }

    public synchronized boolean loadLibrary(String str) {
        if (!f7762g) {
            return a(str);
        } else if (f7763h == null || f7763h.isEmpty()) {
            Log.e(f7756a, "Given custom so file path is null, please check!");
            return false;
        } else {
            return b(str);
        }
    }
}
