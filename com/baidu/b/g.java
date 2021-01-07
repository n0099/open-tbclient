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
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private Context f1618a;
    private c aft;

    public g(Context context, c cVar) {
        this.f1618a = context;
        this.aft = cVar;
    }

    private f P(Context context) {
        String str;
        f fVar;
        f fVar2 = null;
        List<b> b2 = this.aft.b(context);
        if (b2 != null) {
            File filesDir = context.getFilesDir();
            if (com.baidu.fsg.face.base.b.c.g.equals(filesDir.getName())) {
                str = com.baidu.fsg.face.base.b.c.g;
            } else {
                Log.e("CuidV266Manager", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                str = filesDir.getName();
            }
            for (b bVar : b2) {
                if (!bVar.d) {
                    File file = new File(new File(bVar.aeJ.dataDir, str), "libcuid.so");
                    if (file.exists()) {
                        fVar = f.cW(com.baidu.b.f.c.a(file));
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
        return this.f1618a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private String c(String str) {
        try {
            return Settings.System.getString(this.f1618a.getContentResolver(), str);
        } catch (Exception e) {
            com.baidu.b.f.c.a(e);
            return null;
        }
    }

    private f cZ(String str) {
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

    private String d(String str) {
        return "0";
    }

    private f st() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            return f.cW(com.baidu.b.f.c.a(file));
        }
        return null;
    }

    private f su() {
        return f.M(c("com.baidu.deviceid"), c("bd_setting_i"));
    }

    public f cY(String str) {
        f P = 0 == 0 ? P(this.f1618a) : null;
        if (P == null) {
            P = f.cW(c("com.baidu.deviceid.v2"));
        }
        boolean b2 = b("android.permission.READ_EXTERNAL_STORAGE");
        f st = (P == null && b2) ? st() : P;
        if (st == null) {
            st = su();
        }
        boolean z = false;
        if (st == null && b2) {
            z = true;
            st = cZ(d(""));
        }
        if (!z) {
            d("");
        }
        if (st != null) {
            st.c();
        }
        return st;
    }
}
