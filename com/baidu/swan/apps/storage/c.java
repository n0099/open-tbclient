package com.baidu.swan.apps.storage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.al.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.runtime.f;
import com.baidu.swan.apps.storage.c.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends f {
    private g dKV;
    public final String dKW;
    private final c.a<Long> dOA;
    public final String name;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean dOx = com.baidu.swan.apps.t.a.aAu().akD();
    public static final boolean dOy = com.baidu.swan.apps.t.a.aAu().akE();
    public static int dOz = 1024;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;

    public c(e eVar) {
        super(eVar);
        this.dOA = new c.a<Long>() { // from class: com.baidu.swan.apps.storage.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.al.c.a
            /* renamed from: aPv */
            public Long aPw() throws IllegalStateException {
                return Long.valueOf(c.this.aPt());
            }
        };
        this.name = b.f(eVar);
        this.dKW = "aiapp_" + this.name;
        com.baidu.swan.apps.al.e.dQM.a(this.dOA);
    }

    public g aPr() {
        if (this.dKV == null) {
            this.dKV = new g(this.dKW, false);
        }
        return this.dKV;
    }

    public void au(boolean z) {
        if (z) {
            aPr().edit().clear().commit();
        } else {
            aPr().edit().clear().apply();
        }
        com.baidu.swan.c.d.deleteFile(b.tU(e.aMm()));
        com.baidu.swan.c.d.deleteFile(b.tO(e.aMm()));
        com.baidu.swan.apps.al.e.dQM.update();
    }

    public int tY(@NonNull String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return 2001;
        }
        if (file.length() > 10485760) {
            return 2002;
        }
        return 2000;
    }

    public String getFileName(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith(File.separator)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        int length = str.length();
        if (lastIndexOf == INVALID_INDEX || length <= lastIndexOf) {
            return null;
        }
        return str.substring(ONE_INCREAMENT + lastIndexOf, length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [248=5, 249=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x007e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public String tZ(String str) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        String tO = b.tO(e.aMm());
        ?? isEmpty = TextUtils.isEmpty(tO);
        try {
            if (isEmpty != 0) {
                return "";
            }
            try {
                File cI = cI(tO, getFileName(str));
                fileInputStream = new FileInputStream(new File(str));
                try {
                    fileOutputStream = new FileOutputStream(cI);
                    try {
                        byte[] bArr = new byte[dOz];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                String absolutePath = cI.getAbsolutePath();
                                com.baidu.swan.c.d.closeSafely(fileInputStream);
                                com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                return absolutePath;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            fileOutputStream.flush();
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.c.d.closeSafely(fileInputStream);
                        com.baidu.swan.c.d.closeSafely(fileOutputStream);
                        return "";
                    } catch (IOException e2) {
                        e = e2;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.c.d.closeSafely(fileInputStream);
                        com.baidu.swan.c.d.closeSafely(fileOutputStream);
                        return "";
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (IOException e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    isEmpty = 0;
                    com.baidu.swan.c.d.closeSafely(fileInputStream);
                    com.baidu.swan.c.d.closeSafely(isEmpty);
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream = null;
                fileInputStream = null;
            } catch (IOException e6) {
                e = e6;
                fileOutputStream = null;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                isEmpty = 0;
                fileInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private File cI(@NonNull String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str, str2);
    }

    public a ua(@NonNull String str) {
        File file = new File(str);
        if (file == null || !file.isFile()) {
            return null;
        }
        a aVar = new a();
        aVar.setSize(file.length());
        aVar.cP(file.lastModified());
        return aVar;
    }

    public List<a> aPs() {
        String tO = b.tO(e.aMm());
        if (TextUtils.isEmpty(tO)) {
            return null;
        }
        return ub(tO);
    }

    public List<a> ub(@NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppStorage", "——> getSavedFileList:  dir " + str);
        }
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            return M(file);
        }
        return null;
    }

    public List<a> M(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (DEBUG) {
            Log.d("SwanAppStorage", "——> getSavedFileList: " + file.getAbsolutePath());
        }
        a aVar = new a();
        ArrayList arrayList = new ArrayList();
        if (file.isFile()) {
            aVar.setPath(file.getAbsolutePath());
            aVar.setSize(file.length());
            aVar.cP(file.lastModified());
            arrayList.add(aVar);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file2 : listFiles) {
                List<a> M = M(file2);
                if (M != null) {
                    arrayList.addAll(arrayList.size(), M);
                }
            }
        }
        return arrayList;
    }

    public long aPt() {
        if (DEBUG) {
            File file = aPr().getFile();
            Log.i("SwanAppStorage", this.name + " exists = " + file.exists() + " isFile = " + file.isFile() + " path = " + file.getPath() + " size = " + file.length());
        }
        return aPr().getContentSize();
    }

    public long aPu() {
        return 10485760L;
    }

    public boolean cJ(@NonNull String str, @NonNull String str2) {
        return ((long) str2.length()) + (aPt() - ((long) aPr().getString(str, "").length())) > aPu();
    }

    public static boolean uc(@NonNull String str) {
        return str.getBytes(StandardCharsets.UTF_8).length > 512;
    }

    public static boolean ud(@NonNull String str) {
        return str.getBytes(StandardCharsets.UTF_8).length > 3145728;
    }
}
