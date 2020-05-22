package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.v.b.b;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpHost;
/* loaded from: classes11.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cGN = "/aiapp";

    @Nullable
    public static String bT(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (oJ(str)) {
            return bU(str, str2);
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
                String oO = oO(str2);
                if (TextUtils.isEmpty(oO)) {
                    return null;
                }
                stringBuffer.append(oO);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String oI = oI(str2);
                if (TextUtils.isEmpty(oI)) {
                    return null;
                }
                stringBuffer.append(oI);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.e.d.tZ(str4)) {
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
    private static String bU(@NonNull String str, @NonNull String str2) {
        String oL;
        String str3 = "";
        if (!TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH)) {
            str3 = str.replace("bdfile://usr/", "");
        }
        if (!com.baidu.swan.e.d.tZ(str3) && (oL = oL(str2)) != null) {
            return oL + File.separator + str3;
        }
        return null;
    }

    public static boolean oH(String str) {
        PathType oQ = oQ(str);
        return oQ == PathType.BD_FILE || oQ == PathType.RELATIVE;
    }

    public static String d(String str, @NonNull e eVar) {
        String a;
        switch (oQ(str)) {
            case BD_FILE:
                a = bT(str, eVar.id);
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
    public static String bV(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String oI = oI(str2);
        String oO = oO(str2);
        String oL = oL(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(oO) && str.startsWith(oO)) {
            replace = str.replace(oO, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(oI) && str.startsWith(oI)) {
            replace = str.replace(oI, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(oL) || !str.startsWith(oL)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(oL + File.separator, "");
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
    public static String bW(String str, String str2) {
        String bV = bV(str, str2);
        String tX = com.baidu.swan.e.d.tX(com.baidu.swan.e.d.getFileNameFromPath(str));
        if (bV != null && !bV.contains(".") && tX != null) {
            bV = bV + "." + tX;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + bV);
        }
        return bV;
    }

    public static String arw() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + cGN;
        }
        return null;
    }

    public static String oI(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + cGN + "/store" + File.separator + "aiapp_" + str;
        oR(str2);
        return str2;
    }

    public static boolean oJ(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH));
    }

    public static boolean oK(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static String oL(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String oN = oN(absolutePath);
        if (oN != null) {
            String str2 = absolutePath + cGN + "/usr" + File.separator + oN + File.separator + "aiapp_" + str;
            oR(str2);
            return str2;
        }
        return null;
    }

    private static boolean oM(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String oN(@NonNull String str) {
        e aoF = e.aoF();
        if (aoF == null) {
            return null;
        }
        String str2 = "";
        if (aoF.aoS() != null) {
            str2 = aoF.aoS().QX();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.e.e.toMd5(str2.getBytes(), false);
            if (oM(str + cGN + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String bc = com.baidu.swan.apps.u.a.aeW().bc(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bc)) {
            bc = bc.replace("|", "");
        }
        return com.baidu.swan.e.e.toMd5(bc.getBytes(), false);
    }

    public static String arx() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + cGN;
    }

    public static String oO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + cGN + "/tmp" + File.separator + "aiapp_" + str;
        oR(str2);
        return str2;
    }

    public static String K(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return oO(str) + File.separator + str2 + ("." + str3);
        }
        return oO(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File bk;
        if (eVar == null) {
            return null;
        }
        b.a QJ = eVar.QJ();
        boolean z = QJ != null && QJ.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            bk = e.a.VZ();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || oQ(str) != PathType.RELATIVE) {
            return null;
        } else {
            bk = e.d.bk(eVar.id, str2);
        }
        if (bk.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return bk.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return bk.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String oP(String str) {
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

    public static PathType oQ(String str) {
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

    private static boolean oR(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    public static String e(com.baidu.swan.apps.runtime.e eVar) {
        b.a QJ = eVar.QJ();
        if (QJ != null && !TextUtils.isEmpty(QJ.getAppKey()) && QJ.getType() == 1) {
            return QJ.getAppKey() + "_dev";
        }
        return eVar.id;
    }
}
