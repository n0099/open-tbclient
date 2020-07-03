package com.baidu.cesium;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.util.DeviceId;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
/* loaded from: classes13.dex */
public class f {
    private c akW;
    private Context l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        static boolean a(String str, int i) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Os.chmod(str, i);
                } catch (Exception e) {
                    com.baidu.cesium.f.c.a(e);
                    return false;
                }
            }
            return true;
        }
    }

    public f(Context context, c cVar) {
        this.l = context;
        this.akW = cVar;
    }

    private e V(Context context) {
        String str;
        e eVar;
        e eVar2 = null;
        List<b> U = this.akW.U(context);
        if (U != null) {
            File filesDir = context.getFilesDir();
            if (com.baidu.fsg.face.base.b.c.g.equals(filesDir.getName())) {
                str = com.baidu.fsg.face.base.b.c.g;
            } else {
                Log.e("CuidV266Manager", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                str = filesDir.getName();
            }
            for (b bVar : U) {
                if (!bVar.d) {
                    File file = new File(new File(bVar.a.dataDir, str), "libcuid.so");
                    if (file.exists()) {
                        eVar = e.dc(com.baidu.cesium.f.c.a(file));
                        if (eVar != null) {
                            return eVar;
                        }
                    } else {
                        eVar = eVar2;
                    }
                    eVar2 = eVar;
                }
            }
            return eVar2;
        }
        return null;
    }

    private boolean a() {
        return c("android.permission.WRITE_SETTINGS");
    }

    private boolean a(String str, String str2) {
        try {
            return Settings.System.putString(this.l.getContentResolver(), str, str2);
        } catch (Exception e) {
            com.baidu.cesium.f.c.a(e);
            return false;
        }
    }

    private static void b(String str, String str2) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            byte[] a2 = com.baidu.cesium.c.a.g.a();
            fileWriter.write(com.baidu.cesium.d.a.a(com.baidu.cesium.c.a.c.a(a2, a2, (str + ETAG.EQUAL + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        } catch (Exception e2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream openFileOutput;
        FileOutputStream fileOutputStream2 = null;
        int i = DeviceId.sDataCuidInfoShable ? Build.VERSION.SDK_INT >= 24 ? 0 : 1 : 0;
        try {
            try {
                openFileOutput = this.l.openFileOutput("libcuid.so", i);
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e) {
                        com.baidu.cesium.f.c.a(e);
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        }
        try {
            openFileOutput.write(str.getBytes());
            openFileOutput.flush();
            if (openFileOutput != null) {
                try {
                    openFileOutput.close();
                } catch (Exception e3) {
                    com.baidu.cesium.f.c.a(e3);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (i == 0 && DeviceId.sDataCuidInfoShable) {
                    return a.a(new File(this.l.getFilesDir(), "libcuid.so").getAbsolutePath(), 436);
                }
                if (DeviceId.sDataCuidInfoShable) {
                    return true;
                }
                return a.a(new File(this.l.getFilesDir(), "libcuid.so").getAbsolutePath(), 432);
            }
            return true;
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = openFileOutput;
            try {
                com.baidu.cesium.f.c.a(e);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        com.baidu.cesium.f.c.a(e5);
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        }
    }

    private boolean c(String str) {
        return this.l.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private String d(String str) {
        try {
            return Settings.System.getString(this.l.getContentResolver(), str);
        } catch (Exception e) {
            com.baidu.cesium.f.c.a(e);
            return null;
        }
    }

    private e df(String str) {
        String str2 = "";
        String str3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\r\n");
            }
            bufferedReader.close();
            byte[] a2 = com.baidu.cesium.c.a.g.a();
            String[] split = new String(com.baidu.cesium.c.a.c.c(a2, a2, com.baidu.cesium.d.a.a(sb.toString().getBytes()))).split(ETAG.EQUAL);
            if (split != null && split.length == 2) {
                str3 = split[0];
                str2 = split[1];
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        } catch (Exception e3) {
        }
        return e.Q(str2, str3);
    }

    private static void e(String str) {
        File file;
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid2");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        } catch (Exception e2) {
        }
    }

    private String f(String str) {
        return "0";
    }

    private e sI() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            return e.dc(com.baidu.cesium.f.c.a(file));
        }
        return null;
    }

    private e sJ() {
        return e.Q(d("com.baidu.deviceid"), d("bd_setting_i"));
    }

    public void a(e eVar) {
        File file = new File(this.l.getFilesDir(), "libcuid.so");
        String c = eVar.c();
        if (file.exists()) {
            e dc = e.dc(com.baidu.cesium.f.c.a(file));
            if (dc != null) {
                if (dc.e()) {
                    b(dc.c());
                }
            } else if (dc == null) {
                b(c);
            }
        } else {
            b(c);
        }
        boolean a2 = a();
        if (a2) {
            String d = d("com.baidu.deviceid.v2");
            if (TextUtils.isEmpty(d)) {
                a("com.baidu.deviceid.v2", c);
            } else {
                e dc2 = e.dc(d);
                if (dc2 != null) {
                    if (dc2.e()) {
                        a("com.baidu.deviceid.v2", dc2.c());
                    }
                } else if (dc2 == null) {
                    a("com.baidu.deviceid.v2", c);
                }
            }
        }
        boolean c2 = c("android.permission.WRITE_EXTERNAL_STORAGE");
        if (c2) {
            if (new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2").exists()) {
                e sI = sI();
                if (sI != null) {
                    if (sI.e()) {
                        e(sI.c());
                    }
                } else if (sI == null) {
                    e(c);
                }
            } else {
                e(c);
            }
        }
        if (a2) {
            String d2 = d("bd_setting_i");
            if (e.a(TextUtils.isEmpty(d2) ? 0 : d2.length())) {
                a("bd_setting_i", "O");
            } else if (e.a(d2)) {
                a("bd_setting_i", "0");
            }
        }
        if (c2 && new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid").exists()) {
            e df = df(f(""));
            if (df == null) {
                if (df == null) {
                }
            } else if (df.e()) {
                b(df.e, df.d);
            }
        }
    }

    public e de(String str) {
        e V = 0 == 0 ? V(this.l) : null;
        if (V == null) {
            V = e.dc(d("com.baidu.deviceid.v2"));
        }
        boolean c = c("android.permission.READ_EXTERNAL_STORAGE");
        e sI = (V == null && c) ? sI() : V;
        if (sI == null) {
            sI = sJ();
        }
        boolean z = false;
        if (sI == null && c) {
            z = true;
            sI = df(f(""));
        }
        if (!z) {
            f("");
        }
        if (sI != null) {
            sI.e();
        }
        return sI;
    }
}
