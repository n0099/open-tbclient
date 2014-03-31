package com.baidu.tbadk.core.log;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
final class e {
    final /* synthetic */ a a;
    private ak b;

    private e(a aVar) {
        this.a = aVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, byte b) {
        this(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [605=6, 615=7] */
    public final void a(String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        String name;
        String str3;
        ByteArrayOutputStream byteArrayOutputStream;
        String str4;
        String str5;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                File file = new File(str);
                name = file.getName();
                fileInputStream = new FileInputStream(file);
                try {
                    String[] split = name.split("-");
                    str3 = split.length > 1 ? split[0] : null;
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            com.baidu.tbadk.d.a.a(fileInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray == null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e3) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e3.getMessage());
                }
                try {
                    fileInputStream.close();
                    return;
                } catch (Exception e4) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e4.getMessage());
                    return;
                }
            }
            this.b = new ak(String.valueOf(n.a) + str2);
            this.b.a("cuid", TbadkApplication.y());
            this.b.a("uid", TbadkApplication.E());
            this.b.a("time", str3);
            this.b.a("errortype", "99");
            this.b.a("logfile", byteArray);
            this.b.j();
            byteArrayOutputStream.close();
            fileInputStream.close();
            if (this.b.a().b().b()) {
                str4 = a.d;
                w.l(str4);
                if (TextUtils.isEmpty(w.a("log", name, "logbak", name))) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", "file.move error");
                }
                a aVar = this.a;
                str5 = a.d;
                aVar.d(str5);
            }
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream2 = byteArrayOutputStream;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e.getMessage());
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception e6) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e6.getMessage());
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e7) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e7.getMessage());
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception e8) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e8.getMessage());
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e9) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e9.getMessage());
                }
            }
            throw th;
        }
    }

    public final void a() {
        if (this.b != null) {
            this.b.g();
        }
    }
}
