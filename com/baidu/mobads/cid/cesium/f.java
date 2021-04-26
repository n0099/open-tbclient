package com.baidu.mobads.cid.cesium;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Context f8482a;

    /* renamed from: b  reason: collision with root package name */
    public c f8483b;

    public f(Context context, c cVar) {
        this.f8482a = context;
        this.f8483b = cVar;
    }

    private e a() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            return e.b(com.baidu.mobads.cid.cesium.f.c.a(file));
        }
        return null;
    }

    private e a(Context context) {
        List<b> b2 = this.f8483b.b(context);
        e eVar = null;
        if (b2 != null) {
            String str = com.baidu.fsg.face.base.b.c.f5743g;
            File filesDir = context.getFilesDir();
            if (!com.baidu.fsg.face.base.b.c.f5743g.equals(filesDir.getName())) {
                Log.e("CuidV266Manager", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                str = filesDir.getName();
            }
            for (b bVar : b2) {
                if (!bVar.f8348d) {
                    File file = new File(new File(bVar.f8345a.dataDir, str), "libcuid.so");
                    if (file.exists() && (eVar = e.b(com.baidu.mobads.cid.cesium.f.c.a(file))) != null) {
                        break;
                    }
                }
            }
        }
        return eVar;
    }

    private e b() {
        return e.a(c("com.baidu.deviceid"), c("bd_setting_i"));
    }

    private boolean b(String str) {
        return this.f8482a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private String c(String str) {
        try {
            return Settings.System.getString(this.f8482a.getContentResolver(), str);
        } catch (Exception e2) {
            com.baidu.mobads.cid.cesium.f.c.a(e2);
            return null;
        }
    }

    private String d(String str) {
        return "0";
    }

    private e e(String str) {
        String str2;
        String[] split;
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
                sb.append(Part.CRLF);
            }
            bufferedReader.close();
            byte[] a2 = com.baidu.mobads.cid.cesium.c.a.g.a();
            split = new String(com.baidu.mobads.cid.cesium.c.a.c.a(a2, a2, com.baidu.mobads.cid.cesium.d.a.a(sb.toString().getBytes()))).split("=");
        } catch (FileNotFoundException | IOException | Exception unused) {
        }
        if (split != null && split.length == 2) {
            str2 = split[0];
            try {
                str3 = split[1];
            } catch (FileNotFoundException | IOException | Exception unused2) {
            }
            return e.a(str3, str2);
        }
        str2 = "";
        return e.a(str3, str2);
    }

    public e a(String str) {
        e a2 = a(this.f8482a);
        if (a2 == null) {
            a2 = e.b(c("com.baidu.deviceid.v2"));
        }
        boolean b2 = b("android.permission.READ_EXTERNAL_STORAGE");
        if (a2 == null && b2) {
            a2 = a();
        }
        if (a2 == null) {
            a2 = b();
        }
        boolean z = false;
        if (a2 == null && b2) {
            z = true;
            a2 = e(d(""));
        }
        if (!z) {
            d("");
        }
        if (a2 != null) {
            a2.c();
        }
        return a2;
    }
}
