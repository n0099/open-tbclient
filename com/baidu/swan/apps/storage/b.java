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
/* loaded from: classes10.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dmg = "/aiapp";

    @Nullable
    public static String cs(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (sJ(str)) {
            return ct(str, str2);
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
                String sO = sO(str2);
                if (TextUtils.isEmpty(sO)) {
                    return null;
                }
                stringBuffer.append(sO);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String sI = sI(str2);
                if (TextUtils.isEmpty(sI)) {
                    return null;
                }
                stringBuffer.append(sI);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.c.d.yB(str4)) {
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
    private static String ct(@NonNull String str, @NonNull String str2) {
        String sL;
        String str3 = "";
        if (!TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH)) {
            str3 = str.replace("bdfile://usr/", "");
        }
        if (!com.baidu.swan.c.d.yB(str3) && (sL = sL(str2)) != null) {
            return sL + File.separator + str3;
        }
        return null;
    }

    public static boolean sH(String str) {
        PathType sQ = sQ(str);
        return sQ == PathType.BD_FILE || sQ == PathType.RELATIVE;
    }

    public static String d(String str, @NonNull e eVar) {
        String a2;
        switch (sQ(str)) {
            case BD_FILE:
                a2 = cs(str, eVar.id);
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
    public static String cu(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String sI = sI(str2);
        String sO = sO(str2);
        String sL = sL(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(sO) && str.startsWith(sO)) {
            replace = str.replace(sO, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(sI) && str.startsWith(sI)) {
            replace = str.replace(sI, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(sL) || !str.startsWith(sL)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(sL + File.separator, "");
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
    public static String cv(String str, String str2) {
        String cu = cu(str, str2);
        String yz = com.baidu.swan.c.d.yz(com.baidu.swan.c.d.getFileNameFromPath(str));
        if (cu != null && !cu.contains(".") && yz != null) {
            cu = cu + "." + yz;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + cu);
        }
        return cu;
    }

    public static String aGg() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + dmg;
        }
        return null;
    }

    public static String sI(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + dmg + "/store" + File.separator + "aiapp_" + str;
        sR(str2);
        return str2;
    }

    public static boolean sJ(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH));
    }

    public static boolean sK(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static String sL(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String sN = sN(absolutePath);
        if (sN != null) {
            String str2 = absolutePath + dmg + "/usr" + File.separator + sN + File.separator + "aiapp_" + str;
            sR(str2);
            return str2;
        }
        return null;
    }

    private static boolean sM(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String sN(@NonNull String str) {
        e aDa = e.aDa();
        if (aDa == null) {
            return null;
        }
        String str2 = "";
        if (aDa.aDn() != null) {
            str2 = aDa.aDn().abI();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.c.e.toMd5(str2.getBytes(), false);
            if (sM(str + dmg + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String bq = com.baidu.swan.apps.t.a.ask().bq(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bq)) {
            bq = bq.replace("|", "");
        }
        return com.baidu.swan.c.e.toMd5(bq.getBytes(), false);
    }

    public static String aGh() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + dmg;
    }

    public static String sO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + dmg + "/tmp" + File.separator + "aiapp_" + str;
        sR(str2);
        return str2;
    }

    public static String P(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return sO(str) + File.separator + str2 + ("." + str3);
        }
        return sO(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File bG;
        if (eVar == null) {
            return null;
        }
        b.a abu = eVar.abu();
        boolean z = abu != null && abu.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            bG = d.a.ahm();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || sQ(str) != PathType.RELATIVE) {
            return null;
        } else {
            bG = d.C0438d.bG(eVar.id, str2);
        }
        if (bG.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return bG.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return bG.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String sP(String str) {
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

    public static PathType sQ(String str) {
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

    private static boolean sR(String str) {
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
        b.a abu = eVar.abu();
        if (abu != null && !TextUtils.isEmpty(abu.getAppKey()) && abu.getType() == 1) {
            return abu.getAppKey() + "_dev";
        }
        return eVar.id;
    }

    public static String V(String str, int i) {
        String str2 = "aiapp_setting_" + str;
        if (i == 1) {
            return str2 + "_dev";
        }
        return str2;
    }
}
