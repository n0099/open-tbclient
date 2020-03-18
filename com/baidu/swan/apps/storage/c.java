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
    private g bSH;
    public final String bSI;
    public final File bVR;
    private final c.a<Long> bVT;
    public final String name;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static int bVS = 1024;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;

    public c(e eVar) {
        super(eVar);
        this.bVT = new c.a<Long>() { // from class: com.baidu.swan.apps.storage.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.c.a
            /* renamed from: afp */
            public Long afq() throws IllegalStateException {
                return Long.valueOf(c.this.afn());
            }
        };
        this.name = b.c(eVar);
        this.bSI = "aiapp_" + this.name;
        this.bVR = new File(getApplicationInfo().dataDir, "shared_prefs/" + this.bSI + ".xml");
        com.baidu.swan.apps.ap.e.bYc.a(this.bVT);
    }

    public boolean available() {
        return afn() < afo();
    }

    public g afl() {
        if (this.bSH == null) {
            this.bSH = new g(this.bSI);
        }
        return this.bSH;
    }

    public void T(boolean z) {
        if (z) {
            afl().edit().clear().commit();
        } else {
            afl().edit().clear().apply();
        }
        com.baidu.swan.d.c.deleteFile(b.lX(e.acK()));
        com.baidu.swan.d.c.deleteFile(b.lS(e.acK()));
        com.baidu.swan.apps.ap.e.bYc.update();
    }

    public int mb(@NonNull String str) {
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
    public String mc(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String lS = b.lS(e.acK());
        try {
            if (TextUtils.isEmpty(lS)) {
                return "";
            }
            try {
                File br = br(lS, getFileName(str));
                fileInputStream = new FileInputStream(new File(str));
                try {
                    fileOutputStream = new FileOutputStream(br);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream2 = null;
                    fileInputStream3 = fileInputStream;
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    byte[] bArr = new byte[bVS];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            String absolutePath = br.getAbsolutePath();
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

    private File br(@NonNull String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str, str2);
    }

    public a md(@NonNull String str) {
        File file = new File(str);
        if (file == null || !file.isFile()) {
            return null;
        }
        a aVar = new a();
        aVar.setSize(file.length());
        aVar.aC(file.lastModified());
        return aVar;
    }

    public List<a> afm() {
        String lS = b.lS(e.acK());
        if (TextUtils.isEmpty(lS)) {
            return null;
        }
        return me(lS);
    }

    public List<a> me(@NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppStorage", "——> getSavedFileList:  dir " + str);
        }
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            return y(file);
        }
        return null;
    }

    public List<a> y(File file) {
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
            aVar.aC(file.lastModified());
            arrayList.add(aVar);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file2 : listFiles) {
                List<a> y = y(file2);
                if (y != null) {
                    arrayList.addAll(arrayList.size(), y);
                }
            }
        }
        return arrayList;
    }

    public long afn() {
        if (this.bVR == null) {
            if (DEBUG) {
                Log.i("SwanAppStorage", this.name + " isNull");
            }
            return 0L;
        }
        if (DEBUG) {
            Log.i("SwanAppStorage", this.name + " exists = " + this.bVR.exists());
            Log.i("SwanAppStorage", this.name + " isFile = " + this.bVR.isFile());
            Log.i("SwanAppStorage", this.name + " path = " + this.bVR.getPath());
            Log.i("SwanAppStorage", this.name + " size = " + this.bVR.length());
        }
        return this.bVR.length();
    }

    public long afo() {
        return 10485760L;
    }
}
