package com.baidu.android.pushservice.h;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes2.dex */
public class a {
    private final Properties a = new Properties();

    /* JADX WARN: Removed duplicated region for block: B:30:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a() throws IOException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                try {
                    this.a.load(fileInputStream);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                            com.baidu.android.pushservice.e.a.a("BuildProperties", e);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.android.pushservice.e.a.a("BuildProperties", e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                            com.baidu.android.pushservice.e.a.a("BuildProperties", e3);
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                        com.baidu.android.pushservice.e.a.a("BuildProperties", e4);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
    }

    public static a a() throws IOException {
        return new a();
    }

    public String a(String str, String str2) {
        return this.a.getProperty(str, str2);
    }
}
