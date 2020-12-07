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
/* loaded from: classes25.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dFS = "/aiapp";

    @Nullable
    public static String cF(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (tS(str)) {
            return cG(str, str2);
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
                String tX = tX(str2);
                if (TextUtils.isEmpty(tX)) {
                    return null;
                }
                stringBuffer.append(tX);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String tR = tR(str2);
                if (TextUtils.isEmpty(tR)) {
                    return null;
                }
                stringBuffer.append(tR);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.c.d.zK(str4)) {
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
    private static String cG(@NonNull String str, @NonNull String str2) {
        String tU;
        String str3 = "";
        if (!TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH)) {
            str3 = str.replace("bdfile://usr/", "");
        }
        if (!com.baidu.swan.c.d.zK(str3) && (tU = tU(str2)) != null) {
            return tU + File.separator + str3;
        }
        return null;
    }

    public static boolean tQ(String str) {
        PathType tZ = tZ(str);
        return tZ == PathType.BD_FILE || tZ == PathType.RELATIVE;
    }

    public static String d(String str, @NonNull e eVar) {
        String a2;
        switch (tZ(str)) {
            case BD_FILE:
                a2 = cF(str, eVar.id);
                break;
            case RELATIVE:
                a2 = a(str, eVar, eVar.getVersion());
                break;
            default:
                a2 = str;
                break;
        }
        return a2 == null ? str : a2;
    }

    @Nullable
    public static String cH(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String tR = tR(str2);
        String tX = tX(str2);
        String tU = tU(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(tX) && str.startsWith(tX)) {
            replace = str.replace(tX, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(tR) && str.startsWith(tR)) {
            replace = str.replace(tR, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(tU) || !str.startsWith(tU)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(tU + File.separator, "");
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
    public static String cI(String str, String str2) {
        String cH = cH(str, str2);
        String zI = com.baidu.swan.c.d.zI(com.baidu.swan.c.d.getFileNameFromPath(str));
        if (cH != null && !cH.contains(".") && zI != null) {
            cH = cH + "." + zI;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + cH);
        }
        return cH;
    }

    public static String aMZ() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + dFS;
        }
        return null;
    }

    public static String tR(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + dFS + "/store" + File.separator + "aiapp_" + str;
        ua(str2);
        return str2;
    }

    public static boolean tS(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH));
    }

    public static boolean tT(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static String tU(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String tW = tW(absolutePath);
        if (tW != null) {
            String str2 = absolutePath + dFS + "/usr" + File.separator + tW + File.separator + "aiapp_" + str;
            ua(str2);
            return str2;
        }
        return null;
    }

    private static boolean tV(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String tW(@NonNull String str) {
        e aJU = e.aJU();
        if (aJU == null) {
            return null;
        }
        String str2 = "";
        if (aJU.aKh() != null) {
            str2 = aJU.aKh().aiC();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.c.e.toMd5(str2.getBytes(), false);
            if (tV(str + dFS + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String bW = com.baidu.swan.apps.t.a.azf().bW(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bW)) {
            bW = bW.replace("|", "");
        }
        return com.baidu.swan.c.e.toMd5(bW.getBytes(), false);
    }

    public static String aNa() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + dFS;
    }

    public static String tX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + dFS + "/tmp" + File.separator + "aiapp_" + str;
        ua(str2);
        return str2;
    }

    public static String Z(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return tX(str) + File.separator + str2 + ("." + str3);
        }
        return tX(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File bT;
        if (eVar == null) {
            return null;
        }
        b.a aio = eVar.aio();
        boolean z = aio != null && aio.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            bT = d.a.aog();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || tZ(str) != PathType.RELATIVE) {
            return null;
        } else {
            bT = d.C0474d.bT(eVar.id, str2);
        }
        if (bT.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return bT.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return bT.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String tY(String str) {
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

    public static PathType tZ(String str) {
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

    private static boolean ua(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    public static String f(e eVar) {
        b.a aio = eVar.aio();
        if (aio != null && !TextUtils.isEmpty(aio.getAppKey()) && aio.getType() == 1) {
            return aio.getAppKey() + "_dev";
        }
        return eVar.id;
    }

    public static String Y(String str, int i) {
        String str2 = "aiapp_setting_" + str;
        if (i == 1) {
            return str2 + "_dev";
        }
        return str2;
    }
}
