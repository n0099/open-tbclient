package com.baidu.swan.apps.storage;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.ak.c;
import com.baidu.swan.apps.storage.b.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.ae.c {
    private e aUB;
    public final String aUC;
    public final File aWT;
    private final c.a<Long> aWW;
    public final String name;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static int aWU = 1024;
    public static int INVALID_INDEX = -1;
    public static int aWV = 1;

    public c(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
        this.aWW = new c.a<Long>() { // from class: com.baidu.swan.apps.storage.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ak.c.a
            /* renamed from: NZ */
            public Long Oa() throws IllegalStateException {
                return Long.valueOf(c.this.NX());
            }
        };
        this.name = b.d(bVar);
        this.aUC = "aiapp_" + this.name;
        this.aWT = new File(getApplicationInfo().dataDir, "shared_prefs/" + this.aUC + ".xml");
        com.baidu.swan.apps.ak.e.bab.a(this.aWW);
    }

    public boolean NU() {
        return NX() < NY();
    }

    public e NV() {
        if (this.aUB == null) {
            this.aUB = new e(this.aUC);
        }
        return this.aUB;
    }

    public void ak(boolean z) {
        if (z) {
            NV().edit().clear().commit();
        } else {
            NV().edit().clear().apply();
        }
        com.baidu.swan.c.a.deleteFile(b.hG(com.baidu.swan.apps.ae.b.Ms()));
        com.baidu.swan.c.a.deleteFile(b.hC(com.baidu.swan.apps.ae.b.Ms()));
        com.baidu.swan.apps.ak.e.bab.update();
    }

    public int hK(@NonNull String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return 2001;
        }
        if (file.length() > Config.FULL_TRACE_LOG_LIMIT) {
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
        return str.substring(aWV + lastIndexOf, length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [228=5, 230=4, 231=4, 232=4, 236=4, 238=4, 239=4, 240=4] */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String hL(String str) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        r3 = null;
        FileInputStream fileInputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        fileOutputStream2 = null;
        String hC = b.hC(com.baidu.swan.apps.ae.b.Ms());
        try {
            if (TextUtils.isEmpty(hC)) {
                return "";
            }
            try {
                File aH = aH(hC, getFileName(str));
                fileInputStream = new FileInputStream(new File(str));
                try {
                    fileOutputStream = new FileOutputStream(aH);
                    try {
                        byte[] bArr = new byte[aWU];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            fileOutputStream.flush();
                        }
                        String absolutePath = aH.getAbsolutePath();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return absolutePath;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return absolutePath;
                            }
                        }
                        return absolutePath;
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        fileInputStream2 = fileInputStream;
                        try {
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return "";
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    return "";
                                }
                            }
                            return "";
                        } catch (Throwable th) {
                            fileInputStream = fileInputStream2;
                            fileOutputStream2 = fileOutputStream;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 == null) {
                                try {
                                    fileOutputStream2.close();
                                    return "";
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    return "";
                                }
                            }
                            return "";
                        }
                    } catch (IOException e8) {
                        e = e8;
                        fileOutputStream3 = fileOutputStream;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                                return "";
                            } catch (IOException e10) {
                                e10.printStackTrace();
                                return "";
                            }
                        }
                        return "";
                    } catch (Throwable th2) {
                        fileOutputStream2 = fileOutputStream;
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream2 == null) {
                        }
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    fileOutputStream = null;
                    fileInputStream2 = fileInputStream;
                } catch (IOException e12) {
                    e = e12;
                }
            } catch (FileNotFoundException e13) {
                e = e13;
                fileOutputStream = null;
            } catch (IOException e14) {
                e = e14;
                fileInputStream = null;
            } catch (Throwable th3) {
                fileInputStream = null;
            }
        } catch (Throwable th4) {
        }
    }

    private File aH(@NonNull String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str, str2);
    }

    public a hM(@NonNull String str) {
        File file = new File(str);
        if (file == null || !file.isFile()) {
            return null;
        }
        a aVar = new a();
        aVar.setSize(file.length());
        aVar.V(file.lastModified());
        return aVar;
    }

    public List<a> NW() {
        String hC = b.hC(com.baidu.swan.apps.ae.b.Ms());
        if (TextUtils.isEmpty(hC)) {
            return null;
        }
        return hN(hC);
    }

    public List<a> hN(@NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppStorage", "——> getSavedFileList:  dir " + str);
        }
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            return u(file);
        }
        return null;
    }

    public List<a> u(File file) {
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
            aVar.V(file.lastModified());
            arrayList.add(aVar);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file2 : listFiles) {
                List<a> u = u(file2);
                if (u != null) {
                    arrayList.addAll(arrayList.size(), u);
                }
            }
        }
        return arrayList;
    }

    public long NX() {
        if (this.aWT == null) {
            if (DEBUG) {
                Log.i("SwanAppStorage", this.name + " isNull");
            }
            return 0L;
        }
        if (DEBUG) {
            Log.i("SwanAppStorage", this.name + " exists = " + this.aWT.exists());
            Log.i("SwanAppStorage", this.name + " isFile = " + this.aWT.isFile());
            Log.i("SwanAppStorage", this.name + " path = " + this.aWT.getPath());
            Log.i("SwanAppStorage", this.name + " size = " + this.aWT.length());
        }
        return this.aWT.length();
    }

    public long NY() {
        return Config.FULL_TRACE_LOG_LIMIT;
    }
}
