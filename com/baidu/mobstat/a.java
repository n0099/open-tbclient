package com.baidu.mobstat;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
class a implements Thread.UncaughtExceptionHandler {
    private static a a = new a();
    private Thread.UncaughtExceptionHandler b = null;
    private Context c = null;

    private a() {
    }

    public static a a() {
        return a;
    }

    private void a(long j, String str, String str2) {
        if (this.c == null || str == null || str.trim().equals("")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", j);
            jSONObject.put("c", str);
            jSONObject.put("y", str2);
            JSONArray b = b(this.c);
            if (b == null) {
                b = new JSONArray();
            }
            b.put(jSONObject);
            FileOutputStream openFileOutput = this.c.openFileOutput("__local_except_cache.json", 0);
            openFileOutput.write(b.toString().getBytes());
            openFileOutput.flush();
            openFileOutput.close();
            com.baidu.mobstat.a.e.a("SDKCrashHandler", "Save Exception String Successlly");
        } catch (Exception e) {
            com.baidu.mobstat.a.e.a("SDKCrashHandler", e);
        }
    }

    public void a(Context context) {
        if (this.b == null) {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
        if (this.c == null) {
            this.c = context.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONArray b(Context context) {
        JSONArray jSONArray = null;
        if (context != null) {
            File file = new File(context.getFilesDir(), "__local_except_cache.json");
            try {
            } catch (Exception e) {
                com.baidu.mobstat.a.e.a("SDKCrashHandler", e);
            }
            if (file.exists()) {
                FileInputStream openFileInput = context.openFileInput("__local_except_cache.json");
                StringBuffer stringBuffer = new StringBuffer();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = openFileInput.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    stringBuffer.append(new String(bArr, 0, read));
                }
                openFileInput.close();
                jSONArray = stringBuffer.length() != 0 ? new JSONArray(stringBuffer.toString()) : null;
                try {
                    file.delete();
                } catch (Exception e2) {
                    com.baidu.mobstat.a.e.a("SDKCrashHandler", e2);
                }
            }
        }
        return jSONArray;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String th2 = th.toString();
        String str = "";
        if (th2 != null && !th2.equals("")) {
            try {
                str = th2.length() > 1 ? th2.split(":")[0] : th2;
            } catch (Exception e) {
                com.baidu.mobstat.a.e.b(e);
                str = "";
            }
        }
        if (str != null && !str.equals("")) {
            th2 = str;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        String obj = stringWriter.toString();
        com.baidu.mobstat.a.e.a("SDKCrashHandler", obj);
        a(System.currentTimeMillis(), obj, th2);
        if (!this.b.equals(this)) {
            this.b.uncaughtException(thread, th);
        }
        throw new RuntimeException(th);
    }
}
