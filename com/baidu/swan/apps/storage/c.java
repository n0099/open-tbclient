package com.baidu.swan.apps.storage;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.am.c;
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
/* loaded from: classes25.dex */
public class c extends f {
    private g dCr;
    public final String dCs;
    private final c.a<Long> dFW;
    public final String name;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean dFT = com.baidu.swan.apps.t.a.azd().ajv();
    public static final boolean dFU = com.baidu.swan.apps.t.a.azd().ajw();
    public static int dFV = 1024;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;

    public c(e eVar) {
        super(eVar);
        this.dFW = new c.a<Long>() { // from class: com.baidu.swan.apps.storage.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.am.c.a
            /* renamed from: aNf */
            public Long aNg() throws IllegalStateException {
                return Long.valueOf(c.this.aNd());
            }
        };
        this.name = b.f(eVar);
        this.dCs = "aiapp_" + this.name;
        com.baidu.swan.apps.am.e.dIh.a(this.dFW);
    }

    public g aNb() {
        if (this.dCr == null) {
            this.dCr = new g(this.dCs, false);
        }
        return this.dCr;
    }

    public void av(boolean z) {
        if (z) {
            aNb().edit().clear().commit();
        } else {
            aNb().edit().clear().apply();
        }
        com.baidu.swan.c.d.deleteFile(b.tX(e.aJW()));
        com.baidu.swan.c.d.deleteFile(b.tR(e.aJW()));
        com.baidu.swan.apps.am.e.dIh.update();
    }

    public int ub(@NonNull String str) {
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
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public String uc(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String tR = b.tR(e.aJW());
        try {
            if (TextUtils.isEmpty(tR)) {
                return "";
            }
            try {
                File cJ = cJ(tR, getFileName(str));
                fileInputStream = new FileInputStream(new File(str));
                try {
                    fileOutputStream = new FileOutputStream(cJ);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream2 = null;
                    fileInputStream3 = fileInputStream;
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    byte[] bArr = new byte[dFV];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            String absolutePath = cJ.getAbsolutePath();
                            com.baidu.swan.c.d.closeSafely(fileInputStream);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return absolutePath;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream3 = fileInputStream;
                    fileInputStream2 = fileOutputStream;
                    try {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.c.d.closeSafely(fileInputStream3);
                        com.baidu.swan.c.d.closeSafely(fileInputStream2);
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream3;
                        fileInputStream3 = fileInputStream2;
                        com.baidu.swan.c.d.closeSafely(fileInputStream);
                        com.baidu.swan.c.d.closeSafely(fileInputStream3);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream3 = fileOutputStream;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.c.d.closeSafely(fileInputStream);
                    com.baidu.swan.c.d.closeSafely(fileInputStream3);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream3 = fileOutputStream;
                    com.baidu.swan.c.d.closeSafely(fileInputStream);
                    com.baidu.swan.c.d.closeSafely(fileInputStream3);
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileInputStream2 = null;
            } catch (IOException e6) {
                e = e6;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private File cJ(@NonNull String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str, str2);
    }

    public a ud(@NonNull String str) {
        File file = new File(str);
        if (file == null || !file.isFile()) {
            return null;
        }
        a aVar = new a();
        aVar.setSize(file.length());
        aVar.cO(file.lastModified());
        return aVar;
    }

    public List<a> aNc() {
        String tR = b.tR(e.aJW());
        if (TextUtils.isEmpty(tR)) {
            return null;
        }
        return ue(tR);
    }

    public List<a> ue(@NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppStorage", "——> getSavedFileList:  dir " + str);
        }
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            return J(file);
        }
        return null;
    }

    public List<a> J(File file) {
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
            aVar.cO(file.lastModified());
            arrayList.add(aVar);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file2 : listFiles) {
                List<a> J = J(file2);
                if (J != null) {
                    arrayList.addAll(arrayList.size(), J);
                }
            }
        }
        return arrayList;
    }

    public long aNd() {
        if (DEBUG) {
            File file = aNb().getFile();
            Log.i("SwanAppStorage", this.name + " exists = " + file.exists() + " isFile = " + file.isFile() + " path = " + file.getPath() + " size = " + file.length());
        }
        return aNb().getContentSize();
    }

    public long aNe() {
        return 10485760L;
    }

    public boolean cK(@NonNull String str, @NonNull String str2) {
        return ((long) str2.length()) + (aNd() - ((long) aNb().getString(str, "").length())) > aNe();
    }

    public static boolean uf(@NonNull String str) {
        return str.getBytes(StandardCharsets.UTF_8).length > 512;
    }

    public static boolean ug(@NonNull String str) {
        return str.getBytes(StandardCharsets.UTF_8).length > 3145728;
    }
}
