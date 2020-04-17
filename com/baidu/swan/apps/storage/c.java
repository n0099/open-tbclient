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
/* loaded from: classes11.dex */
public class c extends f {
    private g crw;
    public final String crx;
    public final File cuJ;
    private final c.a<Long> cuL;
    public final String name;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static int cuK = 1024;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;

    public c(e eVar) {
        super(eVar);
        this.cuL = new c.a<Long>() { // from class: com.baidu.swan.apps.storage.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.c.a
            /* renamed from: anu */
            public Long anv() throws IllegalStateException {
                return Long.valueOf(c.this.ans());
            }
        };
        this.name = b.c(eVar);
        this.crx = "aiapp_" + this.name;
        this.cuJ = new File(getApplicationInfo().dataDir, "shared_prefs/" + this.crx + ".xml");
        com.baidu.swan.apps.ap.e.cwU.a(this.cuL);
    }

    public boolean available() {
        return ans() < ant();
    }

    public g anq() {
        if (this.crw == null) {
            this.crw = new g(this.crx);
        }
        return this.crw;
    }

    public void as(boolean z) {
        if (z) {
            anq().edit().clear().commit();
        } else {
            anq().edit().clear().apply();
        }
        com.baidu.swan.d.c.deleteFile(b.nk(e.akP()));
        com.baidu.swan.d.c.deleteFile(b.nf(e.akP()));
        com.baidu.swan.apps.ap.e.cwU.update();
    }

    public int no(@NonNull String str) {
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
    public String np(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String nf = b.nf(e.akP());
        try {
            if (TextUtils.isEmpty(nf)) {
                return "";
            }
            try {
                File bB = bB(nf, getFileName(str));
                fileInputStream = new FileInputStream(new File(str));
                try {
                    fileOutputStream = new FileOutputStream(bB);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream2 = null;
                    fileInputStream3 = fileInputStream;
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    byte[] bArr = new byte[cuK];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            String absolutePath = bB.getAbsolutePath();
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

    private File bB(@NonNull String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str, str2);
    }

    public a nq(@NonNull String str) {
        File file = new File(str);
        if (file == null || !file.isFile()) {
            return null;
        }
        a aVar = new a();
        aVar.setSize(file.length());
        aVar.bh(file.lastModified());
        return aVar;
    }

    public List<a> anr() {
        String nf = b.nf(e.akP());
        if (TextUtils.isEmpty(nf)) {
            return null;
        }
        return nr(nf);
    }

    public List<a> nr(@NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppStorage", "——> getSavedFileList:  dir " + str);
        }
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            return z(file);
        }
        return null;
    }

    public List<a> z(File file) {
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
            aVar.bh(file.lastModified());
            arrayList.add(aVar);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file2 : listFiles) {
                List<a> z = z(file2);
                if (z != null) {
                    arrayList.addAll(arrayList.size(), z);
                }
            }
        }
        return arrayList;
    }

    public long ans() {
        if (this.cuJ == null) {
            if (DEBUG) {
                Log.i("SwanAppStorage", this.name + " isNull");
            }
            return 0L;
        }
        if (DEBUG) {
            Log.i("SwanAppStorage", this.name + " exists = " + this.cuJ.exists());
            Log.i("SwanAppStorage", this.name + " isFile = " + this.cuJ.isFile());
            Log.i("SwanAppStorage", this.name + " path = " + this.cuJ.getPath());
            Log.i("SwanAppStorage", this.name + " size = " + this.cuJ.length());
        }
        return this.cuJ.length();
    }

    public long ant() {
        return 10485760L;
    }
}
