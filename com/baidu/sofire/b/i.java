package com.baidu.sofire.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.sofire.core.ApkInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public static final String[] a = {"java.lang.UnsatisfiedLinkError"};
    public static final String[] b = {"space left"};

    public static String a(Context context, String str, String str2) {
        char c = 0;
        try {
            if (str.contains(a[0])) {
                c = 1;
            } else if (str.contains(b[0])) {
                c = 2;
            }
            switch (c) {
                case 1:
                    return b(context, str, str2);
                case 2:
                    return a(context, str);
                default:
                    return str;
            }
        } catch (Throwable th) {
            e.a(th);
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
            return ((str2 + SystemInfoUtil.LINE_END) + jSONArray.toString()) + "\r\nAllFileSize=" + j;
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
                    jSONObject.put(ChooseVideoAction.CB_KEY_SIZE, file2.length());
                    jSONArray.put(jSONObject);
                    j += file2.length();
                }
            }
        }
        return j;
    }

    @SuppressLint({"SdCardPath"})
    private static String b(Context context, String str, String str2) {
        ApkInfo d;
        String[] split;
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
                        str3 = str3 + "\r\n{" + file2.getAbsolutePath() + ":" + o.a(file2) + "}\r\n";
                    }
                }
            }
        }
        return str3;
    }
}
