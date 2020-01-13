package com.baidu.swan.apps.storage;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.runtime.f;
import com.baidu.swan.apps.storage.c.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends f {
    private g bOp;
    public final String bOq;
    private final c.a<Long> bRB;
    public final File bRz;
    public final String name;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static int bRA = 1024;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;

    public c(e eVar) {
        super(eVar);
        this.bRB = new c.a<Long>() { // from class: com.baidu.swan.apps.storage.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.c.a
            /* renamed from: acW */
            public Long acX() throws IllegalStateException {
                return Long.valueOf(c.this.acU());
            }
        };
        this.name = b.c(eVar);
        this.bOq = "aiapp_" + this.name;
        this.bRz = new File(getApplicationInfo().dataDir, "shared_prefs/" + this.bOq + ".xml");
        com.baidu.swan.apps.ap.e.bTL.a(this.bRB);
    }

    public boolean available() {
        return acU() < acV();
    }

    public g acS() {
        if (this.bOp == null) {
            this.bOp = new g(this.bOq);
        }
        return this.bOp;
    }

    public void Q(boolean z) {
        if (z) {
            acS().edit().clear().commit();
        } else {
            acS().edit().clear().apply();
        }
        com.baidu.swan.d.c.deleteFile(b.lJ(e.aar()));
        com.baidu.swan.d.c.deleteFile(b.lE(e.aar()));
        com.baidu.swan.apps.ap.e.bTL.update();
    }

    public int lN(@NonNull String str) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [228=5, 229=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public String lO(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String lE = b.lE(e.aar());
        try {
            if (TextUtils.isEmpty(lE)) {
                return "";
            }
            try {
                File bj = bj(lE, getFileName(str));
                fileInputStream = new FileInputStream(new File(str));
                try {
                    fileOutputStream = new FileOutputStream(bj);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream2 = null;
                    fileInputStream3 = fileInputStream;
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    byte[] bArr = new byte[bRA];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            String absolutePath = bj.getAbsolutePath();
                            com.baidu.swan.d.c.closeSafely(fileInputStream);
                            com.baidu.swan.d.c.closeSafely(fileOutputStream);
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
                        com.baidu.swan.d.c.closeSafely(fileInputStream3);
                        com.baidu.swan.d.c.closeSafely(fileInputStream2);
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream3;
                        fileInputStream3 = fileInputStream2;
                        com.baidu.swan.d.c.closeSafely(fileInputStream);
                        com.baidu.swan.d.c.closeSafely(fileInputStream3);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream3 = fileOutputStream;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.d.c.closeSafely(fileInputStream);
                    com.baidu.swan.d.c.closeSafely(fileInputStream3);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream3 = fileOutputStream;
                    com.baidu.swan.d.c.closeSafely(fileInputStream);
                    com.baidu.swan.d.c.closeSafely(fileInputStream3);
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

    private File bj(@NonNull String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str, str2);
    }

    public a lP(@NonNull String str) {
        File file = new File(str);
        if (file == null || !file.isFile()) {
            return null;
        }
        a aVar = new a();
        aVar.setSize(file.length());
        aVar.ay(file.lastModified());
        return aVar;
    }

    public List<a> acT() {
        String lE = b.lE(e.aar());
        if (TextUtils.isEmpty(lE)) {
            return null;
        }
        return lQ(lE);
    }

    public List<a> lQ(@NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppStorage", "——> getSavedFileList:  dir " + str);
        }
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            return x(file);
        }
        return null;
    }

    public List<a> x(File file) {
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
            aVar.ay(file.lastModified());
            arrayList.add(aVar);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file2 : listFiles) {
                List<a> x = x(file2);
                if (x != null) {
                    arrayList.addAll(arrayList.size(), x);
                }
            }
        }
        return arrayList;
    }

    public long acU() {
        if (this.bRz == null) {
            if (DEBUG) {
                Log.i("SwanAppStorage", this.name + " isNull");
            }
            return 0L;
        }
        if (DEBUG) {
            Log.i("SwanAppStorage", this.name + " exists = " + this.bRz.exists());
            Log.i("SwanAppStorage", this.name + " isFile = " + this.bRz.isFile());
            Log.i("SwanAppStorage", this.name + " path = " + this.bRz.getPath());
            Log.i("SwanAppStorage", this.name + " size = " + this.bRz.length());
        }
        return this.bRz.length();
    }

    public long acV() {
        return 10485760L;
    }
}
