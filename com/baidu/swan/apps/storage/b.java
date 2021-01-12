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
/* loaded from: classes8.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dJK = "/aiapp";

    @Nullable
    public static String cD(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (sE(str)) {
            return cE(str, str2);
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
                String sJ = sJ(str2);
                if (TextUtils.isEmpty(sJ)) {
                    return null;
                }
                stringBuffer.append(sJ);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String sD = sD(str2);
                if (TextUtils.isEmpty(sD)) {
                    return null;
                }
                stringBuffer.append(sD);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.c.d.yy(str4)) {
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
    private static String cE(@NonNull String str, @NonNull String str2) {
        String sG;
        String str3 = "";
        if (!TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH)) {
            str3 = str.replace("bdfile://usr/", "");
        }
        if (!com.baidu.swan.c.d.yy(str3) && (sG = sG(str2)) != null) {
            return sG + File.separator + str3;
        }
        return null;
    }

    public static boolean sC(String str) {
        PathType sL = sL(str);
        return sL == PathType.BD_FILE || sL == PathType.RELATIVE;
    }

    public static String c(String str, @NonNull e eVar) {
        String a2;
        switch (sL(str)) {
            case BD_FILE:
                a2 = cD(str, eVar.id);
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
    public static String cF(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String sD = sD(str2);
        String sJ = sJ(str2);
        String sG = sG(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(sJ) && str.startsWith(sJ)) {
            replace = str.replace(sJ, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(sD) && str.startsWith(sD)) {
            replace = str.replace(sD, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(sG) || !str.startsWith(sG)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(sG + File.separator, "");
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
    public static String cG(String str, String str2) {
        String cF = cF(str, str2);
        String yw = com.baidu.swan.c.d.yw(com.baidu.swan.c.d.getFileNameFromPath(str));
        if (cF != null && !cF.contains(".") && yw != null) {
            cF = cF + "." + yw;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + cF);
        }
        return cF;
    }

    public static String aLw() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + dJK;
        }
        return null;
    }

    public static String sD(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + dJK + "/store" + File.separator + "aiapp_" + str;
        sM(str2);
        return str2;
    }

    public static boolean sE(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH));
    }

    public static boolean sF(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static String sG(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String sI = sI(absolutePath);
        if (sI != null) {
            String str2 = absolutePath + dJK + "/usr" + File.separator + sI + File.separator + "aiapp_" + str;
            sM(str2);
            return str2;
        }
        return null;
    }

    private static boolean sH(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String sI(@NonNull String str) {
        e aIr = e.aIr();
        if (aIr == null) {
            return null;
        }
        String str2 = "";
        if (aIr.aIE() != null) {
            str2 = aIr.aIE().afQ();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.c.e.toMd5(str2.getBytes(), false);
            if (sH(str + dJK + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String cc = com.baidu.swan.apps.t.a.awD().cc(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(cc)) {
            cc = cc.replace("|", "");
        }
        return com.baidu.swan.c.e.toMd5(cc.getBytes(), false);
    }

    public static String aLx() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + dJK;
    }

    public static String sJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + dJK + "/tmp" + File.separator + "aiapp_" + str;
        sM(str2);
        return str2;
    }

    public static String ab(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return sJ(str) + File.separator + str2 + ("." + str3);
        }
        return sJ(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File bR;
        if (eVar == null) {
            return null;
        }
        b.a afB = eVar.afB();
        boolean z = afB != null && afB.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            bR = d.a.alz();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || sL(str) != PathType.RELATIVE) {
            return null;
        } else {
            bR = d.C0449d.bR(eVar.id, str2);
        }
        if (bR.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return bR.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return bR.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String sK(String str) {
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

    public static PathType sL(String str) {
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

    private static boolean sM(String str) {
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
        b.a afB = eVar.afB();
        if (afB != null && !TextUtils.isEmpty(afB.getAppKey()) && afB.getType() == 1) {
            return afB.getAppKey() + "_dev";
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
