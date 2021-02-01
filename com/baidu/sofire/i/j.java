package com.baidu.sofire.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.sofire.core.ApkInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f5262a = {"java.lang.UnsatisfiedLinkError"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f5263b = {"space left"};

    public static String a(Context context, String str, String str2) {
        char c;
        ApkInfo d;
        String[] split;
        File[] listFiles;
        try {
            if (str.contains(f5262a[0])) {
                c = 1;
            } else {
                c = str.contains(f5263b[0]) ? (char) 2 : (char) 0;
            }
            switch (c) {
                case 1:
                    String str3 = str + "\r\n{libpath=" + d.libPath + "}";
                    for (String str4 : com.baidu.sofire.core.f.a().d(str2).libPath.split(":")) {
                        if (str4.startsWith("/data/data/")) {
                            File file = new File(str4);
                            if (!file.exists()) {
                                str3 = str3 + "\r\nsubLibPathFile " + str4 + " not exists";
                            } else if (!file.isDirectory()) {
                                str3 = str3 + "\r\nsubLibPathFile " + str4 + " not a dir";
                            } else {
                                for (File file2 : file.listFiles()) {
                                    str3 = str3 + "\r\n{" + file2.getAbsolutePath() + ":" + p.a(file2) + "}\r\n";
                                }
                            }
                        }
                    }
                    return str3;
                case 2:
                    return a(context, str);
                default:
                    return str;
            }
        } catch (Throwable th) {
            e.a();
            return str;
        }
    }

    @SuppressLint({"NewApi"})
    private static String a(Context context, String str) {
        String str2;
        File[] listFiles;
        try {
            File filesDir = context.getFilesDir();
            if (Build.VERSION.SDK_INT >= 9) {
                long freeSpace = filesDir.getFreeSpace();
                long totalSpace = filesDir.getTotalSpace();
                str2 = ((str + "\r\nFreeSpace=" + freeSpace) + "  TotalSpace=" + totalSpace) + "  UsableSpace=" + filesDir.getUsableSpace();
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
            return ((str2 + "\r\n") + jSONArray.toString()) + "\r\nAllFileSize=" + j;
        } catch (Throwable th) {
            return str;
        }
    }

    private static long a(File file, JSONArray jSONArray) throws JSONException {
        File[] listFiles;
        long j = 0;
        if (file != null && jSONArray != null && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    j += a(file2, jSONArray);
                } else if (file2.exists()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("path", file2.getAbsolutePath());
                    jSONObject.put(TiebaInitialize.LogFields.SIZE, file2.length());
                    jSONArray.put(jSONObject);
                    j += file2.length();
                }
            }
        }
        return j;
    }
}
