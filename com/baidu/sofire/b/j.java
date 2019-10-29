package com.baidu.sofire.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.sofire.core.ApkInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class j {
    public static final String[] a = {"java.lang.UnsatisfiedLinkError"};
    public static final String[] b = {"space left"};

    public static String a(Context context, String str, String str2) {
        char c;
        ApkInfo d;
        String[] split;
        try {
            if (str.contains(a[0])) {
                c = 1;
            } else {
                c = str.contains(b[0]) ? (char) 2 : (char) 0;
            }
            switch (c) {
                case 1:
                    String str3 = str + "\r\n{libpath=" + d.libPath + "}";
                    for (String str4 : com.baidu.sofire.core.g.a().d(str2).libPath.split(":")) {
                        if (str4.startsWith("/data/data/")) {
                            File file = new File(str4);
                            if (!file.exists()) {
                                str3 = str3 + "\r\nsubLibPathFile " + str4 + " not exists";
                            } else if (!file.isDirectory()) {
                                str3 = str3 + "\r\nsubLibPathFile " + str4 + " not a dir";
                            } else {
                                File[] listFiles = file.listFiles();
                                int length = listFiles.length;
                                int i = 0;
                                while (i < length) {
                                    File file2 = listFiles[i];
                                    i++;
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
                if (file.isDirectory() && file.getName().startsWith(DefaultConfig.TOKEN_SEPARATOR)) {
                    j += a(file, jSONArray);
                }
            }
            return ((str2 + "\r\n") + jSONArray.toString()) + "\r\nAllFileSize=" + j;
        } catch (Throwable th) {
            return str;
        }
    }

    private static long a(File file, JSONArray jSONArray) {
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
