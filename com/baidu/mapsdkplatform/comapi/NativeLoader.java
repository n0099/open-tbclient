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
    public static final String f7489a = "NativeLoader";

    /* renamed from: b  reason: collision with root package name */
    public static Context f7490b;

    /* renamed from: e  reason: collision with root package name */
    public static NativeLoader f7493e;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f7491c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f7492d = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public static a f7494f = a.ARMEABI;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f7495g = false;

    /* renamed from: h  reason: collision with root package name */
    public static String f7496h = null;

    /* loaded from: classes2.dex */
    public enum a {
        ARMEABI("armeabi"),
        ARMV7("armeabi-v7a"),
        ARM64("arm64-v8a"),
        X86("x86"),
        X86_64("x86_64");
        

        /* renamed from: f  reason: collision with root package name */
        public String f7503f;

        a(String str) {
            this.f7503f = str;
        }

        public String a() {
            return this.f7503f;
        }
    }

    @TargetApi(8)
    private String a() {
        return 8 <= Build.VERSION.SDK_INT ? f7490b.getPackageCodePath() : "";
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
                    Log.e(f7489a, "Close InputStream error", e2);
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    Log.e(f7489a, "Close OutputStream error", e3);
                }
                throw th;
            }
        }
        fileOutputStream.flush();
        try {
            inputStream.close();
        } catch (IOException e4) {
            Log.e(f7489a, "Close InputStream error", e4);
        }
        try {
            fileOutputStream.close();
        } catch (IOException e5) {
            Log.e(f7489a, "Close OutputStream error", e5);
        }
    }

    private void a(Throwable th) {
        Log.e(f7489a, "loadException", th);
        Iterator<String> it = f7492d.iterator();
        while (it.hasNext()) {
            String str = f7489a;
            Log.e(str, it.next() + " Failed to load.");
        }
    }

    public static void a(boolean z, String str) {
        f7495g = z;
        f7496h = str;
    }

    private boolean a(String str) {
        try {
            synchronized (f7491c) {
                if (f7491c.contains(str)) {
                    return true;
                }
                System.loadLibrary(str);
                synchronized (f7491c) {
                    f7491c.add(str);
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
            String a2 = !f7495g ? a() : f7496h;
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
                                    Log.e(f7489a, "Release file failed", e3);
                                }
                                return false;
                            }
                            a(zipFile.getInputStream(entry), new FileOutputStream(new File(b(), str)));
                            try {
                                zipFile.close();
                            } catch (IOException e4) {
                                Log.e(f7489a, "Release file failed", e4);
                            }
                            return true;
                        } catch (Exception e5) {
                            e = e5;
                            zipFile2 = zipFile;
                            Log.e(f7489a, "Copy library file error", e);
                            if (zipFile2 != null) {
                                try {
                                    zipFile2.close();
                                } catch (IOException e6) {
                                    Log.e(f7489a, "Release file failed", e6);
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
                                    Log.e(f7489a, "Release file failed", e7);
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
        File file = new File(f7490b.getFilesDir(), "libs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private boolean b(String str) {
        String mapLibraryName = System.mapLibraryName(str);
        synchronized (f7491c) {
            if (f7491c.contains(str)) {
                return true;
            }
            int i = d.f7568a[f7494f.ordinal()];
            boolean d2 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? false : d(str, mapLibraryName) : e(str, mapLibraryName) : b(str, mapLibraryName) : a(str, mapLibraryName) : c(str, mapLibraryName);
            synchronized (f7491c) {
                f7491c.add(str);
            }
            return d2;
        }
    }

    private boolean b(String str, String str2) {
        if (a(str2, a.ARMEABI)) {
            return f(str2, str);
        }
        String str3 = f7489a;
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
            f7494f = a.ARMV7;
        }
        if (str.contains("arm") && str.contains(WebKitFactory.OS_64)) {
            f7494f = a.ARM64;
        }
        if (str.contains("x86")) {
            f7494f = str.contains(WebKitFactory.OS_64) ? a.X86_64 : a.X86;
        }
        return f7494f;
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
            synchronized (f7491c) {
                f7491c.add(str2);
            }
            return true;
        } catch (Throwable th) {
            synchronized (f7492d) {
                f7492d.add(str2);
                a(th);
                return false;
            }
        }
    }

    public static synchronized NativeLoader getInstance() {
        NativeLoader nativeLoader;
        synchronized (NativeLoader.class) {
            if (f7493e == null) {
                f7493e = new NativeLoader();
                f7494f = c();
            }
            nativeLoader = f7493e;
        }
        return nativeLoader;
    }

    public static void setContext(Context context) {
        f7490b = context;
    }

    public synchronized boolean loadLibrary(String str) {
        if (!f7495g) {
            return a(str);
        } else if (f7496h == null || f7496h.isEmpty()) {
            Log.e(f7489a, "Given custom so file path is null, please check!");
            return false;
        } else {
            return b(str);
        }
    }
}
