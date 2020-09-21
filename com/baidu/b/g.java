package com.baidu.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    private Context a;
    private c adw;

    public g(Context context, c cVar) {
        this.a = context;
        this.adw = cVar;
    }

    private f O(Context context) {
        String str;
        f fVar;
        f fVar2 = null;
        List<b> N = this.adw.N(context);
        if (N != null) {
            File filesDir = context.getFilesDir();
            if (com.baidu.fsg.face.base.b.c.g.equals(filesDir.getName())) {
                str = com.baidu.fsg.face.base.b.c.g;
            } else {
                Log.e("CuidV266Manager", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                str = filesDir.getName();
            }
            for (b bVar : N) {
                if (!bVar.d) {
                    File file = new File(new File(bVar.acB.dataDir, str), "libcuid.so");
                    if (file.exists()) {
                        fVar = f.cY(com.baidu.b.f.c.a(file));
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
        return this.a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private String c(String str) {
        try {
            return Settings.System.getString(this.a.getContentResolver(), str);
        } catch (Exception e) {
            com.baidu.b.f.c.a(e);
            return null;
        }
    }

    private String d(String str) {
        return "0";
    }

    private f db(String str) {
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
            byte[] a = com.baidu.b.c.a.g.a();
            String[] split = new String(com.baidu.b.c.a.c.a(a, a, com.baidu.b.d.a.a(sb.toString().getBytes()))).split(ETAG.EQUAL);
            if (split != null && split.length == 2) {
                str3 = split[0];
                str2 = split[1];
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        } catch (Exception e3) {
        }
        return f.N(str2, str3);
    }

    private f sQ() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            return f.cY(com.baidu.b.f.c.a(file));
        }
        return null;
    }

    private f sR() {
        return f.N(c("com.baidu.deviceid"), c("bd_setting_i"));
    }

    public f da(String str) {
        f O = 0 == 0 ? O(this.a) : null;
        if (O == null) {
            O = f.cY(c("com.baidu.deviceid.v2"));
        }
        boolean b = b("android.permission.READ_EXTERNAL_STORAGE");
        f sQ = (O == null && b) ? sQ() : O;
        if (sQ == null) {
            sQ = sR();
        }
        boolean z = false;
        if (sQ == null && b) {
            z = true;
            sQ = db(d(""));
        }
        if (!z) {
            d("");
        }
        if (sQ != null) {
            sQ.c();
        }
        return sQ;
    }
}
