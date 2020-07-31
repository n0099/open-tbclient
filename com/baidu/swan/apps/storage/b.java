package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.u.c.b;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpHost;
/* loaded from: classes7.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cOS = "/aiapp";

    @Nullable
    public static String bW(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (pC(str)) {
            return bX(str, str2);
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
                String pH = pH(str2);
                if (TextUtils.isEmpty(pH)) {
                    return null;
                }
                stringBuffer.append(pH);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String pB = pB(str2);
                if (TextUtils.isEmpty(pB)) {
                    return null;
                }
                stringBuffer.append(pB);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.d.d.vk(str4)) {
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
    private static String bX(@NonNull String str, @NonNull String str2) {
        String pE;
        String str3 = "";
        if (!TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH)) {
            str3 = str.replace("bdfile://usr/", "");
        }
        if (!com.baidu.swan.d.d.vk(str3) && (pE = pE(str2)) != null) {
            return pE + File.separator + str3;
        }
        return null;
    }

    public static boolean pA(String str) {
        PathType pJ = pJ(str);
        return pJ == PathType.BD_FILE || pJ == PathType.RELATIVE;
    }

    public static String d(String str, @NonNull e eVar) {
        String a;
        switch (pJ(str)) {
            case BD_FILE:
                a = bW(str, eVar.id);
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
    public static String bY(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String pB = pB(str2);
        String pH = pH(str2);
        String pE = pE(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(pH) && str.startsWith(pH)) {
            replace = str.replace(pH, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(pB) && str.startsWith(pB)) {
            replace = str.replace(pB, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(pE) || !str.startsWith(pE)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(pE + File.separator, "");
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

    @Nullable
    public static String bZ(String str, String str2) {
        String bY = bY(str, str2);
        String vi = com.baidu.swan.d.d.vi(com.baidu.swan.d.d.getFileNameFromPath(str));
        if (bY != null && !bY.contains(".") && vi != null) {
            bY = bY + "." + vi;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + bY);
        }
        return bY;
    }

    public static String auE() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + cOS;
        }
        return null;
    }

    public static String pB(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + cOS + "/store" + File.separator + "aiapp_" + str;
        pK(str2);
        return str2;
    }

    public static boolean pC(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH));
    }

    public static boolean pD(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static String pE(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String pG = pG(absolutePath);
        if (pG != null) {
            String str2 = absolutePath + cOS + "/usr" + File.separator + pG + File.separator + "aiapp_" + str;
            pK(str2);
            return str2;
        }
        return null;
    }

    private static boolean pF(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String pG(@NonNull String str) {
        e arv = e.arv();
        if (arv == null) {
            return null;
        }
        String str2 = "";
        if (arv.arI() != null) {
            str2 = arv.arI().Ss();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.d.e.toMd5(str2.getBytes(), false);
            if (pF(str + cOS + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String bf = com.baidu.swan.apps.t.a.aho().bf(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bf)) {
            bf = bf.replace("|", "");
        }
        return com.baidu.swan.d.e.toMd5(bf.getBytes(), false);
    }

    public static String auF() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + cOS;
    }

    public static String pH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + cOS + "/tmp" + File.separator + "aiapp_" + str;
        pK(str2);
        return str2;
    }

    public static String L(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return pH(str) + File.separator + str2 + ("." + str3);
        }
        return pH(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File bq;
        if (eVar == null) {
            return null;
        }
        b.a Se = eVar.Se();
        boolean z = Se != null && Se.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            bq = d.a.XL();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || pJ(str) != PathType.RELATIVE) {
            return null;
        } else {
            bq = d.C0380d.bq(eVar.id, str2);
        }
        if (bq.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return bq.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return bq.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String pI(String str) {
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

    public static PathType pJ(String str) {
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

    private static boolean pK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    public static String e(e eVar) {
        b.a Se = eVar.Se();
        if (Se != null && !TextUtils.isEmpty(Se.getAppKey()) && Se.getType() == 1) {
            return Se.getAppKey() + "_dev";
        }
        return eVar.id;
    }
}
