package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.apps.x.b.b;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpHost;
/* loaded from: classes10.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bRy = "/aiapp";

    @Nullable
    public static String bg(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.startsWith("bdfile://usr/")) {
            return bh(str, str2);
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            if (DEBUG) {
                Log.d("StorageUtil", "——> getFileStorePathFromScheme: uri " + str + "  host " + host);
            }
            if (TextUtils.isEmpty(host)) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (host.startsWith("tmp_")) {
                str3 = host.replace("tmp_", "");
                int indexOf = str3.indexOf(".");
                if (indexOf > 0) {
                    str3 = str3.substring(0, indexOf);
                }
                String lJ = lJ(str2);
                if (TextUtils.isEmpty(lJ)) {
                    return null;
                }
                stringBuffer.append(lJ);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                String lE = lE(str2);
                if (TextUtils.isEmpty(lE)) {
                    return null;
                }
                stringBuffer.append(lE);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.d.c.qT(str4)) {
                    return null;
                }
                stringBuffer.append(str4);
                if (DEBUG) {
                    Log.d("StorageUtil", "——> scheme2Path: encodePath " + str3);
                    Log.d("StorageUtil", "——> scheme2Path:  path " + stringBuffer.toString());
                }
                return stringBuffer.toString();
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    Log.d("StorageUtil", "——> scheme2Path: IllegalArgumentException " + e.getMessage());
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    @Nullable
    private static String bh(@NonNull String str, @NonNull String str2) {
        String lG;
        String replace = str.replace("bdfile://usr/", "");
        if (com.baidu.swan.d.c.qT(replace) || (lG = lG(str2)) == null) {
            return null;
        }
        return lG + File.separator + replace;
    }

    public static boolean lD(String str) {
        PathType lL = lL(str);
        return lL == PathType.BD_FILE || lL == PathType.RELATIVE;
    }

    public static String d(String str, @NonNull e eVar) {
        String a;
        switch (lL(str)) {
            case BD_FILE:
                a = bg(str, eVar.id);
                break;
            case RELATIVE:
                a = a(str, eVar, eVar.getVersion());
                break;
            default:
                a = str;
                break;
        }
        return a == null ? str : a;
    }

    @Nullable
    public static String bi(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String lE = lE(str2);
        String lJ = lJ(str2);
        String lG = lG(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(lJ) && str.startsWith(lJ)) {
            replace = str.replace(lJ, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(lE) && str.startsWith(lE)) {
            replace = str.replace(lE, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(lG) || !str.startsWith(lG)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(lG + File.separator, "");
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: relative path " + replace);
        }
        if (TextUtils.isEmpty(replace)) {
            return null;
        }
        stringBuffer.append(new String(Base64.encode(replace.getBytes(), 10)));
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: url " + ((Object) stringBuffer));
        }
        return stringBuffer.toString();
    }

    public static String acQ() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + bRy;
        }
        return null;
    }

    public static String lE(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + bRy + "/store" + File.separator + "aiapp_" + str;
        lM(str2);
        return str2;
    }

    public static boolean lF(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://usr/");
    }

    public static String lG(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String lI = lI(absolutePath);
        if (lI != null) {
            String str2 = absolutePath + bRy + "/usr" + File.separator + lI + File.separator + "aiapp_" + str;
            lM(str2);
            return str2;
        }
        return null;
    }

    private static boolean lH(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String lI(@NonNull String str) {
        e aap = e.aap();
        if (aap == null) {
            return null;
        }
        String str2 = "";
        if (aap.aaA() != null) {
            str2 = aap.aaA().ED();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.d.d.toMd5(str2.getBytes(), false);
            if (lH(str + bRy + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String bn = com.baidu.swan.apps.w.a.RL().bn(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bn)) {
            bn = bn.replace("|", "");
        }
        return com.baidu.swan.d.d.toMd5(bn.getBytes(), false);
    }

    public static String acR() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + bRy;
    }

    public static String lJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + bRy + "/tmp" + File.separator + "aiapp_" + str;
        lM(str2);
        return str2;
    }

    public static String G(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return lJ(str) + File.separator + str2 + ("." + str3);
        }
        return lJ(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File aB;
        if (eVar == null) {
            return null;
        }
        b.a En = eVar.En();
        boolean z = En != null && En.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            aB = e.a.Jl();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || lL(str) != PathType.RELATIVE) {
            return null;
        } else {
            aB = e.d.aB(eVar.id, str2);
        }
        if (aB.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return aB.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return aB.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String lK(String str) {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
        if (file.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return file.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return file.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    public static PathType lL(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        String str2 = null;
        try {
            str2 = new URI(str).getScheme();
        } catch (URISyntaxException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return PathType.RELATIVE;
        }
        if (TextUtils.equals(str2, "bdfile")) {
            return PathType.BD_FILE;
        }
        if (TextUtils.equals(str2, HttpHost.DEFAULT_SCHEME_NAME) || TextUtils.equals(str2, "https")) {
            return PathType.NETWORK;
        }
        if (TextUtils.equals(str2, "cloud")) {
            return PathType.CLOUD;
        }
        return PathType.ERROR;
    }

    private static boolean lM(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    public static String c(com.baidu.swan.apps.runtime.e eVar) {
        b.a En = eVar.En();
        if (En != null && !TextUtils.isEmpty(En.getAppKey()) && En.getType() == 1) {
            return En.getAppKey() + "_dev";
        }
        return eVar.id;
    }
}
