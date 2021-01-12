package com.baidu.android.pushservice.b;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
/* loaded from: classes14.dex */
public class a {
    public static String a() {
        return "i0MfXJjKeWCJi7BF+OceL4HlhxI3FfGGdtVtLf9ftQP7qAfPyD5CdFavdfiflKnsbDibTajJgCkne0k+9F0EkaGWMKBP4yHXcS1fWtuRMYLuSfASiaF/5UbBz1b14DubXpDRWkdEcrFeh54AFzyrNcMoPwfhCwgqVmr4k7ZiBpWqPZl1AmEuAaaF2NXa2Pf5qWSXGnaVLo2jZJeOZhxIY+0Dk3zsZ6SJpvHRG9rb8E/+J/oawysT7tO98A+kvAqr8hnD4UF3Cxu4aHH2ohLucGpY4oG7LTEAxpVt/2TjTaQjBA2Azw0s0Zw4JcZTjWKwxbJMGPb9H1flvURDUgd+sqo6qSSsViQ+gb8M4YGEkMSComugXi8nOhfc46MpooDQzavDOg1hb7r5Zm5gaR8AuoX3bLl7UwlVcJUbiN9GKYgAk6Z7fMh3/cdBV6HXb7tzL4R1vVG4WcL7Mdb6wCbss45I7Gb4VWHF3YLn1nOXOIGV6Nd3Lj19k8oChs25Cbp8GzreBZJuCDpSvusywV9lsUxRzRaAsJ3ALEsv7Km1G5GcDA1Hnh1xatbrVUpsjmW3+B5osZ8oGPuJzejNEregOITaUsvWWWUsbFYufEnq3+dr3i/ispWenD5S3kbbVnBp5658hXQwOOngMGQxWJ+xGNcTXJeNtAfMewFEkxJmNOdIQtJ2LzJ1aw0L+PPI8e62lYyaFOxE0yh6CPgl3pb+qYBxz3YpDPi+hjKCMTWTg+gT23tms+LFMxiAP+k7A6y9YL2M9qrM9lame+uH2Y7YQVS/aunzTRUsRYSc0S2VRcQ1nvMpIE7sqwVJ0aDUP4BqWlZvG13nb/ZKXQ8UFRG5c2yWOpxI7tOHMRyrx7RubfA4GYadekSXmt106wBp1Bwp241aS1gCZ/gJYOPaclWHUAWb5CK80B/v5YvPPSPDAEh3LS1nUCE9J7pTl7AMkvwEvbkAh9F/vSQaH0xiWOyFylmbeljcZ8kQw8JIArLRjiv9cETEm63uQY8GCg6QpkFM";
    }

    public static String a(Context context, String str) {
        InputStream b2 = b(context, str);
        if (b2 == null) {
            return a();
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(b2, "utf-8"));
                try {
                    try {
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            sb.append(readLine);
                        }
                        com.baidu.android.pushservice.e.b.a(context, bufferedReader);
                    } catch (IOException e) {
                        new b.c(context).a(Log.getStackTraceString(e)).a();
                        com.baidu.android.pushservice.e.b.a(context, bufferedReader);
                    }
                    com.baidu.android.pushservice.e.b.a(context, b2);
                } catch (Throwable th) {
                    com.baidu.android.pushservice.e.b.a(context, bufferedReader);
                    throw th;
                }
            } catch (Throwable th2) {
                com.baidu.android.pushservice.e.b.a(context, b2);
                throw th2;
            }
        } catch (UnsupportedEncodingException e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            com.baidu.android.pushservice.e.b.a(context, b2);
        }
        return sb.toString();
    }

    public static boolean a(Context context, String str, String str2) {
        BufferedWriter bufferedWriter;
        FileWriter fileWriter;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileWriter = new FileWriter(str, false);
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
                try {
                    try {
                        bufferedWriter.write(str2);
                        com.baidu.android.pushservice.e.b.a(context, bufferedWriter, fileWriter);
                        return true;
                    } catch (Exception e) {
                        e = e;
                        new b.c(context).a(Log.getStackTraceString(e)).a();
                        com.baidu.android.pushservice.e.b.a(context, bufferedWriter, fileWriter);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.android.pushservice.e.b.a(context, bufferedWriter, fileWriter);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = null;
                com.baidu.android.pushservice.e.b.a(context, bufferedWriter, fileWriter);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            fileWriter = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
            fileWriter = null;
        }
    }

    private static InputStream b(Context context, String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return new FileInputStream(file);
            }
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
        }
        return null;
    }
}
