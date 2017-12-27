package com.baidu.android.pushservice.j;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes2.dex */
public class a {
    private final Properties a = new Properties();

    private a() throws IOException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
        } catch (Exception e) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.a.load(fileInputStream);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
            }
        } catch (Throwable th2) {
            fileInputStream2 = fileInputStream;
            th = th2;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e5) {
                }
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
