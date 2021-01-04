package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.u.c.b;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpHost;
/* loaded from: classes9.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dOw = "/aiapp";

    @Nullable
    public static String cE(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (tP(str)) {
            return cF(str, str2);
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
                String tU = tU(str2);
                if (TextUtils.isEmpty(tU)) {
                    return null;
                }
                stringBuffer.append(tU);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String tO = tO(str2);
                if (TextUtils.isEmpty(tO)) {
                    return null;
                }
                stringBuffer.append(tO);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.c.d.zJ(str4)) {
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
    private static String cF(@NonNull String str, @NonNull String str2) {
        String tR;
        String str3 = "";
        if (!TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH)) {
            str3 = str.replace("bdfile://usr/", "");
        }
        if (!com.baidu.swan.c.d.zJ(str3) && (tR = tR(str2)) != null) {
            return tR + File.separator + str3;
        }
        return null;
    }

    public static boolean tN(String str) {
        PathType tW = tW(str);
        return tW == PathType.BD_FILE || tW == PathType.RELATIVE;
    }

    public static String c(String str, @NonNull e eVar) {
        String a2;
        switch (tW(str)) {
            case BD_FILE:
                a2 = cE(str, eVar.id);
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
    public static String cG(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String tO = tO(str2);
        String tU = tU(str2);
        String tR = tR(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(tU) && str.startsWith(tU)) {
            replace = str.replace(tU, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(tO) && str.startsWith(tO)) {
            replace = str.replace(tO, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(tR) || !str.startsWith(tR)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(tR + File.separator, "");
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
    public static String cH(String str, String str2) {
        String cG = cG(str, str2);
        String zH = com.baidu.swan.c.d.zH(com.baidu.swan.c.d.getFileNameFromPath(str));
        if (cG != null && !cG.contains(".") && zH != null) {
            cG = cG + "." + zH;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + cG);
        }
        return cG;
    }

    public static String aPp() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + dOw;
        }
        return null;
    }

    public static String tO(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + dOw + "/store" + File.separator + "aiapp_" + str;
        tX(str2);
        return str2;
    }

    public static boolean tP(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH));
    }

    public static boolean tQ(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static String tR(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String tT = tT(absolutePath);
        if (tT != null) {
            String str2 = absolutePath + dOw + "/usr" + File.separator + tT + File.separator + "aiapp_" + str;
            tX(str2);
            return str2;
        }
        return null;
    }

    private static boolean tS(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String tT(@NonNull String str) {
        e aMk = e.aMk();
        if (aMk == null) {
            return null;
        }
        String str2 = "";
        if (aMk.aMx() != null) {
            str2 = aMk.aMx().ajJ();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.c.e.toMd5(str2.getBytes(), false);
            if (tS(str + dOw + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String cd = com.baidu.swan.apps.t.a.aAw().cd(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(cd)) {
            cd = cd.replace("|", "");
        }
        return com.baidu.swan.c.e.toMd5(cd.getBytes(), false);
    }

    public static String aPq() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + dOw;
    }

    public static String tU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + dOw + "/tmp" + File.separator + "aiapp_" + str;
        tX(str2);
        return str2;
    }

    public static String ac(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return tU(str) + File.separator + str2 + ("." + str3);
        }
        return tU(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File bS;
        if (eVar == null) {
            return null;
        }
        b.a aju = eVar.aju();
        boolean z = aju != null && aju.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            bS = d.a.apt();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || tW(str) != PathType.RELATIVE) {
            return null;
        } else {
            bS = d.C0466d.bS(eVar.id, str2);
        }
        if (bS.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return bS.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return bS.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String tV(String str) {
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

    public static PathType tW(String str) {
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

    private static boolean tX(String str) {
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
        b.a aju = eVar.aju();
        if (aju != null && !TextUtils.isEmpty(aju.getAppKey()) && aju.getType() == 1) {
            return aju.getAppKey() + "_dev";
        }
        return eVar.id;
    }

    public static String aa(String str, int i) {
        String str2 = "aiapp_setting_" + str;
        if (i == 1) {
            return str2 + "_dev";
        }
        return str2;
    }
}
