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
/* loaded from: classes8.dex */
public class c extends f {
    private g dJO;
    public final String dJP;
    private final c.a<Long> dNt;
    public final String name;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean dNq = com.baidu.swan.apps.t.a.axc().ahl();
    public static final boolean dNr = com.baidu.swan.apps.t.a.axc().ahm();
    public static int dNs = 1024;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;

    public c(e eVar) {
        super(eVar);
        this.dNt = new c.a<Long>() { // from class: com.baidu.swan.apps.storage.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.al.c.a
            /* renamed from: aLY */
            public Long aLZ() throws IllegalStateException {
                return Long.valueOf(c.this.aLW());
            }
        };
        this.name = b.f(eVar);
        this.dJP = "aiapp_" + this.name;
        com.baidu.swan.apps.al.e.dPF.a(this.dNt);
    }

    public g aLU() {
        if (this.dJO == null) {
            this.dJO = new g(this.dJP, false);
        }
        return this.dJO;
    }

    public void au(boolean z) {
        if (z) {
            aLU().edit().clear().commit();
        } else {
            aLU().edit().clear().apply();
        }
        com.baidu.swan.c.d.deleteFile(b.tj(e.aIP()));
        com.baidu.swan.c.d.deleteFile(b.td(e.aIP()));
        com.baidu.swan.apps.al.e.dPF.update();
    }

    public int tn(@NonNull String str) {
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
    public String to(String str) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        String td = b.td(e.aIP());
        ?? isEmpty = TextUtils.isEmpty(td);
        try {
            if (isEmpty != 0) {
                return "";
            }
            try {
                File cB = cB(td, getFileName(str));
                fileInputStream = new FileInputStream(new File(str));
                try {
                    fileOutputStream = new FileOutputStream(cB);
                    try {
                        byte[] bArr = new byte[dNs];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                String absolutePath = cB.getAbsolutePath();
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

    private File cB(@NonNull String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str, str2);
    }

    public a tp(@NonNull String str) {
        File file = new File(str);
        if (file == null || !file.isFile()) {
            return null;
        }
        a aVar = new a();
        aVar.setSize(file.length());
        aVar.cV(file.lastModified());
        return aVar;
    }

    public List<a> aLV() {
        String td = b.td(e.aIP());
        if (TextUtils.isEmpty(td)) {
            return null;
        }
        return tq(td);
    }

    public List<a> tq(@NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppStorage", "——> getSavedFileList:  dir " + str);
        }
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            return H(file);
        }
        return null;
    }

    public List<a> H(File file) {
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
            aVar.cV(file.lastModified());
            arrayList.add(aVar);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file2 : listFiles) {
                List<a> H = H(file2);
                if (H != null) {
                    arrayList.addAll(arrayList.size(), H);
                }
            }
        }
        return arrayList;
    }

    public long aLW() {
        if (DEBUG) {
            File file = aLU().getFile();
            Log.i("SwanAppStorage", this.name + " exists = " + file.exists() + " isFile = " + file.isFile() + " path = " + file.getPath() + " size = " + file.length());
        }
        return aLU().getContentSize();
    }

    public long aLX() {
        return 10485760L;
    }

    public boolean cC(@NonNull String str, @NonNull String str2) {
        return ((long) str2.length()) + (aLW() - ((long) aLU().getString(str, "").length())) > aLX();
    }

    public static boolean tr(@NonNull String str) {
        return str.getBytes(StandardCharsets.UTF_8).length > 512;
    }

    public static boolean ts(@NonNull String str) {
        return str.getBytes(StandardCharsets.UTF_8).length > 3145728;
    }
}
