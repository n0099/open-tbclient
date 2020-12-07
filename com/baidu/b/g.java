package com.baidu.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes26.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private Context f1271a;
    private c aeO;

    public g(Context context, c cVar) {
        this.f1271a = context;
        this.aeO = cVar;
    }

    private f P(Context context) {
        String str;
        f fVar;
        f fVar2 = null;
        List<b> O = this.aeO.O(context);
        if (O != null) {
            File filesDir = context.getFilesDir();
            if (com.baidu.fsg.face.base.b.c.g.equals(filesDir.getName())) {
                str = com.baidu.fsg.face.base.b.c.g;
            } else {
                Log.e("CuidV266Manager", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                str = filesDir.getName();
            }
            for (b bVar : O) {
                if (!bVar.d) {
                    File file = new File(new File(bVar.adT.dataDir, str), "libcuid.so");
                    if (file.exists()) {
                        fVar = f.dd(com.baidu.b.f.c.a(file));
                        if (fVar != null) {
                            return fVar;
                        }
                    } else {
                        fVar = fVar2;
                    }
                    fVar2 = fVar;
                }
            }
            return fVar2;
        }
        return null;
    }

    private boolean b(String str) {
        return this.f1271a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private String c(String str) {
        try {
            return Settings.System.getString(this.f1271a.getContentResolver(), str);
        } catch (Exception e) {
            com.baidu.b.f.c.a(e);
            return null;
        }
    }

    private String d(String str) {
        return "0";
    }

    private f dg(String str) {
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
            byte[] a2 = com.baidu.b.c.a.g.a();
            String[] split = new String(com.baidu.b.c.a.c.a(a2, a2, com.baidu.b.d.a.a(sb.toString().getBytes()))).split("=");
            if (split != null && split.length == 2) {
                str3 = split[0];
                str2 = split[1];
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        } catch (Exception e3) {
        }
        return f.M(str2, str3);
    }

    private f sT() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            return f.dd(com.baidu.b.f.c.a(file));
        }
        return null;
    }

    private f sU() {
        return f.M(c("com.baidu.deviceid"), c("bd_setting_i"));
    }

    public f df(String str) {
        f P = 0 == 0 ? P(this.f1271a) : null;
        if (P == null) {
            P = f.dd(c("com.baidu.deviceid.v2"));
        }
        boolean b = b("android.permission.READ_EXTERNAL_STORAGE");
        f sT = (P == null && b) ? sT() : P;
        if (sT == null) {
            sT = sU();
        }
        boolean z = false;
        if (sT == null && b) {
            z = true;
            sT = dg(d(""));
        }
        if (!z) {
            d("");
        }
        if (sT != null) {
            sT.c();
        }
        return sT;
    }
}
