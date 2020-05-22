package com.baidu.swan.apps.storage;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.c;
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
/* loaded from: classes11.dex */
public class c extends f {
    private g cDB;
    public final String cDC;
    private final c.a<Long> cGP;
    public final String name;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static int cGO = 1024;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;

    public c(e eVar) {
        super(eVar);
        this.cGP = new c.a<Long>() { // from class: com.baidu.swan.apps.storage.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: arC */
            public Long arD() throws IllegalStateException {
                return Long.valueOf(c.this.arA());
            }
        };
        this.name = b.e(eVar);
        this.cDC = "aiapp_" + this.name;
        com.baidu.swan.apps.an.e.cJd.a(this.cGP);
    }

    public boolean available() {
        return arA() < arB();
    }

    public g ary() {
        if (this.cDB == null) {
            this.cDB = new g(this.cDC, false);
        }
        return this.cDB;
    }

    public void au(boolean z) {
        if (z) {
            ary().edit().clear().commit();
        } else {
            ary().edit().clear().apply();
        }
        com.baidu.swan.e.d.deleteFile(b.oO(e.aoH()));
        com.baidu.swan.e.d.deleteFile(b.oI(e.aoH()));
        com.baidu.swan.apps.an.e.cJd.update();
    }

    public int oS(@NonNull String str) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [234=5, 235=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public String oT(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String oI = b.oI(e.aoH());
        try {
            if (TextUtils.isEmpty(oI)) {
                return "";
            }
            try {
                File bX = bX(oI, getFileName(str));
                fileInputStream = new FileInputStream(new File(str));
                try {
                    fileOutputStream = new FileOutputStream(bX);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream2 = null;
                    fileInputStream3 = fileInputStream;
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    byte[] bArr = new byte[cGO];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            String absolutePath = bX.getAbsolutePath();
                            com.baidu.swan.e.d.closeSafely(fileInputStream);
                            com.baidu.swan.e.d.closeSafely(fileOutputStream);
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
                        com.baidu.swan.e.d.closeSafely(fileInputStream3);
                        com.baidu.swan.e.d.closeSafely(fileInputStream2);
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream3;
                        fileInputStream3 = fileInputStream2;
                        com.baidu.swan.e.d.closeSafely(fileInputStream);
                        com.baidu.swan.e.d.closeSafely(fileInputStream3);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream3 = fileOutputStream;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.e.d.closeSafely(fileInputStream);
                    com.baidu.swan.e.d.closeSafely(fileInputStream3);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream3 = fileOutputStream;
                    com.baidu.swan.e.d.closeSafely(fileInputStream);
                    com.baidu.swan.e.d.closeSafely(fileInputStream3);
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

    private File bX(@NonNull String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str, str2);
    }

    public a oU(@NonNull String str) {
        File file = new File(str);
        if (file == null || !file.isFile()) {
            return null;
        }
        a aVar = new a();
        aVar.setSize(file.length());
        aVar.bq(file.lastModified());
        return aVar;
    }

    public List<a> arz() {
        String oI = b.oI(e.aoH());
        if (TextUtils.isEmpty(oI)) {
            return null;
        }
        return oV(oI);
    }

    public List<a> oV(@NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppStorage", "——> getSavedFileList:  dir " + str);
        }
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            return D(file);
        }
        return null;
    }

    public List<a> D(File file) {
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
            aVar.bq(file.lastModified());
            arrayList.add(aVar);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file2 : listFiles) {
                List<a> D = D(file2);
                if (D != null) {
                    arrayList.addAll(arrayList.size(), D);
                }
            }
        }
        return arrayList;
    }

    public long arA() {
        if (DEBUG) {
            File file = ary().getFile();
            Log.i("SwanAppStorage", this.name + " exists = " + file.exists() + " isFile = " + file.isFile() + " path = " + file.getPath() + " size = " + file.length());
        }
        return ary().getContentSize();
    }

    public long arB() {
        return 10485760L;
    }

    public static boolean oW(@NonNull String str) {
        return str.getBytes(StandardCharsets.UTF_8).length > 512;
    }

    public static boolean oX(@Nullable String str) {
        return str != null && str.getBytes(StandardCharsets.UTF_8).length > 3145728;
    }
}
