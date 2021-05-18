package com.baidu.sofire.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.android.internal.http.multipart.Part;
import com.baidu.sofire.core.ApkInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f10321a = {"java.lang.UnsatisfiedLinkError"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f10322b = {"space left"};

    public static String a(Context context, String str, String str2) {
        char c2;
        ApkInfo d2;
        String[] split;
        try {
            if (str.contains(f10321a[0])) {
                c2 = 1;
            } else {
                c2 = str.contains(f10322b[0]) ? (char) 2 : (char) 0;
            }
            if (c2 != 1) {
                return c2 != 2 ? str : a(context, str);
            }
            String str3 = str + "\r\n{libpath=" + d2.libPath + "}";
            for (String str4 : com.baidu.sofire.core.f.a().d(str2).libPath.split(":")) {
                if (str4.startsWith("/data/data/")) {
                    File file = new File(str4);
                    if (!file.exists()) {
                        str3 = str3 + "\r\nsubLibPathFile " + str4 + " not exists";
                    } else if (file.isDirectory()) {
                        for (File file2 : file.listFiles()) {
                            str3 = str3 + "\r\n{" + file2.getAbsolutePath() + ":" + n.a(file2) + "}\r\n";
                        }
                    } else {
                        str3 = str3 + "\r\nsubLibPathFile " + str4 + " not a dir";
                    }
                }
            }
            return str3;
        } catch (Throwable unused) {
            d.a();
            return str;
        }
    }

    @SuppressLint({"NewApi"})
    public static String a(Context context, String str) {
        String str2;
        File[] listFiles;
        try {
            File filesDir = context.getFilesDir();
            if (Build.VERSION.SDK_INT >= 9) {
                long freeSpace = filesDir.getFreeSpace();
                str2 = ((str + "\r\nFreeSpace=" + freeSpace) + "  TotalSpace=" + filesDir.getTotalSpace()) + "  UsableSpace=" + filesDir.getUsableSpace();
            } else {
                str2 = str;
            }
            JSONArray jSONArray = new JSONArray();
            long j = 0;
            for (File file : filesDir.listFiles()) {
                if (file.isDirectory() && file.getName().startsWith(".")) {
                    j += a(file, jSONArray);
                }
            }
            return ((str2 + Part.CRLF) + jSONArray.toString()) + "\r\nAllFileSize=" + j;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static long a(File file, JSONArray jSONArray) throws JSONException {
        File[] listFiles;
        long length;
        long j = 0;
        if (file != null && jSONArray != null && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    length = a(file2, jSONArray);
                } else if (file2.exists()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("path", file2.getAbsolutePath());
                    jSONObject.put("size", file2.length());
                    jSONArray.put(jSONObject);
                    length = file2.length();
                }
                j += length;
            }
        }
        return j;
    }
}
