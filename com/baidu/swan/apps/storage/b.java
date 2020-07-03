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
    private static String cLx = "/aiapp";

    @Nullable
    public static String bV(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (oR(str)) {
            return bW(str, str2);
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
                String oW = oW(str2);
                if (TextUtils.isEmpty(oW)) {
                    return null;
                }
                stringBuffer.append(oW);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String oQ = oQ(str2);
                if (TextUtils.isEmpty(oQ)) {
                    return null;
                }
                stringBuffer.append(oQ);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.e.d.uh(str4)) {
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
    private static String bW(@NonNull String str, @NonNull String str2) {
        String oT;
        String str3 = "";
        if (!TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH)) {
            str3 = str.replace("bdfile://usr/", "");
        }
        if (!com.baidu.swan.e.d.uh(str3) && (oT = oT(str2)) != null) {
            return oT + File.separator + str3;
        }
        return null;
    }

    public static boolean oP(String str) {
        PathType oY = oY(str);
        return oY == PathType.BD_FILE || oY == PathType.RELATIVE;
    }

    public static String d(String str, @NonNull e eVar) {
        String a;
        switch (oY(str)) {
            case BD_FILE:
                a = bV(str, eVar.id);
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
    public static String bX(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String oQ = oQ(str2);
        String oW = oW(str2);
        String oT = oT(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(oW) && str.startsWith(oW)) {
            replace = str.replace(oW, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(oQ) && str.startsWith(oQ)) {
            replace = str.replace(oQ, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(oT) || !str.startsWith(oT)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(oT + File.separator, "");
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
    public static String bY(String str, String str2) {
        String bX = bX(str, str2);
        String uf = com.baidu.swan.e.d.uf(com.baidu.swan.e.d.getFileNameFromPath(str));
        if (bX != null && !bX.contains(".") && uf != null) {
            bX = bX + "." + uf;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + bX);
        }
        return bX;
    }

    public static String asD() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + cLx;
        }
        return null;
    }

    public static String oQ(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + cLx + "/store" + File.separator + "aiapp_" + str;
        oZ(str2);
        return str2;
    }

    public static boolean oR(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH));
    }

    public static boolean oS(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static String oT(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String oV = oV(absolutePath);
        if (oV != null) {
            String str2 = absolutePath + cLx + "/usr" + File.separator + oV + File.separator + "aiapp_" + str;
            oZ(str2);
            return str2;
        }
        return null;
    }

    private static boolean oU(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String oV(@NonNull String str) {
        e apM = e.apM();
        if (apM == null) {
            return null;
        }
        String str2 = "";
        if (apM.apZ() != null) {
            str2 = apM.apZ().Sd();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.e.e.toMd5(str2.getBytes(), false);
            if (oU(str + cLx + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String bd = com.baidu.swan.apps.u.a.agc().bd(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bd)) {
            bd = bd.replace("|", "");
        }
        return com.baidu.swan.e.e.toMd5(bd.getBytes(), false);
    }

    public static String asE() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + cLx;
    }

    public static String oW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + cLx + "/tmp" + File.separator + "aiapp_" + str;
        oZ(str2);
        return str2;
    }

    public static String L(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return oW(str) + File.separator + str2 + ("." + str3);
        }
        return oW(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File bm;
        if (eVar == null) {
            return null;
        }
        b.a RP = eVar.RP();
        boolean z = RP != null && RP.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            bm = e.a.Xf();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || oY(str) != PathType.RELATIVE) {
            return null;
        } else {
            bm = e.d.bm(eVar.id, str2);
        }
        if (bm.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return bm.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return bm.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String oX(String str) {
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

    public static PathType oY(String str) {
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

    private static boolean oZ(String str) {
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
        b.a RP = eVar.RP();
        if (RP != null && !TextUtils.isEmpty(RP.getAppKey()) && RP.getType() == 1) {
            return RP.getAppKey() + "_dev";
        }
        return eVar.id;
    }
}
