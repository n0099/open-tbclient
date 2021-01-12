package com.baidu.ar.plugin;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class PluginDirHelper {
    private static File sBaseDir = null;

    private static void init(Context context) {
        if (sBaseDir == null) {
            sBaseDir = new File(context.getCacheDir().getParentFile(), "Plugin");
            enforceDirExists(sBaseDir);
        }
    }

    private static String enforceDirExists(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public static String makePluginBaseDir(Context context, String str) {
        init(context);
        return enforceDirExists(new File(sBaseDir, str));
    }

    public static String getBaseDir(Context context) {
        init(context);
        return enforceDirExists(sBaseDir);
    }

    public static String getPluginDataDir(Context context, String str) {
        return enforceDirExists(new File(makePluginBaseDir(context, str), "data/" + str));
    }

    public static String getPluginSignatureDir(Context context, String str) {
        return enforceDirExists(new File(makePluginBaseDir(context, str), "Signature/"));
    }

    public static String getPluginSignatureFile(Context context, String str, int i) {
        return new File(getPluginSignatureDir(context, str), String.format("Signature_%s.key", Integer.valueOf(i))).getPath();
    }

    public static List<String> getPluginSignatureFiles(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(getPluginSignatureDir(context, str)).listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                arrayList.add(file.getPath());
            }
        }
        return arrayList;
    }

    public static String getPluginApkDir(Context context, String str) {
        return enforceDirExists(new File(makePluginBaseDir(context, str), "apk"));
    }

    public static String getPluginApkFile(Context context, String str) {
        return new File(getPluginApkDir(context, str), "base-1.apk").getPath();
    }

    public static String getPluginDalvikCacheDir(Context context, String str) {
        return enforceDirExists(new File(makePluginBaseDir(context, str), "dalvik-cache"));
    }

    public static String getPluginNativeLibraryDir(Context context, String str) {
        return enforceDirExists(new File(makePluginBaseDir(context, str), "lib"));
    }

    public static String getPluginDalvikCacheFile(Context context, String str) {
        String pluginDalvikCacheDir = getPluginDalvikCacheDir(context, str);
        String replace = new File(getPluginApkFile(context, str)).getName().replace(File.separator, "@");
        if (replace.startsWith("@")) {
            replace = replace.substring(1);
        }
        return new File(pluginDalvikCacheDir, replace + "@classes.dex").getPath();
    }

    public static String getContextDataDir(Context context) {
        return new File(new File(Environment.getDataDirectory(), "data/").getPath(), context.getPackageName()).getPath();
    }

    public static void cleanOptimizedDirectory(String str) {
        File[] listFiles;
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
            if (file.exists() && file.isFile()) {
                file.delete();
                file.mkdirs();
            }
        } catch (Throwable th) {
        }
    }
}
