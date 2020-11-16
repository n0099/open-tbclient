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
    private static String dyT = "/aiapp";

    @Nullable
    public static String cy(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (tl(str)) {
            return cz(str, str2);
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
                String tq = tq(str2);
                if (TextUtils.isEmpty(tq)) {
                    return null;
                }
                stringBuffer.append(tq);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String tk = tk(str2);
                if (TextUtils.isEmpty(tk)) {
                    return null;
                }
                stringBuffer.append(tk);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.c.d.zd(str4)) {
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
    private static String cz(@NonNull String str, @NonNull String str2) {
        String tn;
        String str3 = "";
        if (!TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH)) {
            str3 = str.replace("bdfile://usr/", "");
        }
        if (!com.baidu.swan.c.d.zd(str3) && (tn = tn(str2)) != null) {
            return tn + File.separator + str3;
        }
        return null;
    }

    public static boolean tj(String str) {
        PathType ts = ts(str);
        return ts == PathType.BD_FILE || ts == PathType.RELATIVE;
    }

    public static String d(String str, @NonNull e eVar) {
        String a2;
        switch (ts(str)) {
            case BD_FILE:
                a2 = cy(str, eVar.id);
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
    public static String cA(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String tk = tk(str2);
        String tq = tq(str2);
        String tn = tn(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(tq) && str.startsWith(tq)) {
            replace = str.replace(tq, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(tk) && str.startsWith(tk)) {
            replace = str.replace(tk, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(tn) || !str.startsWith(tn)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(tn + File.separator, "");
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
    public static String cB(String str, String str2) {
        String cA = cA(str, str2);
        String zb = com.baidu.swan.c.d.zb(com.baidu.swan.c.d.getFileNameFromPath(str));
        if (cA != null && !cA.contains(".") && zb != null) {
            cA = cA + "." + zb;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + cA);
        }
        return cA;
    }

    public static String aJS() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + dyT;
        }
        return null;
    }

    public static String tk(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + dyT + "/store" + File.separator + "aiapp_" + str;
        tt(str2);
        return str2;
    }

    public static boolean tl(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH));
    }

    public static boolean tm(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static String tn(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String tp = tp(absolutePath);
        if (tp != null) {
            String str2 = absolutePath + dyT + "/usr" + File.separator + tp + File.separator + "aiapp_" + str;
            tt(str2);
            return str2;
        }
        return null;
    }

    private static boolean to(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String tp(@NonNull String str) {
        e aGM = e.aGM();
        if (aGM == null) {
            return null;
        }
        String str2 = "";
        if (aGM.aGZ() != null) {
            str2 = aGM.aGZ().afu();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.c.e.toMd5(str2.getBytes(), false);
            if (to(str + dyT + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String bq = com.baidu.swan.apps.t.a.avX().bq(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bq)) {
            bq = bq.replace("|", "");
        }
        return com.baidu.swan.c.e.toMd5(bq.getBytes(), false);
    }

    public static String aJT() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + dyT;
    }

    public static String tq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + dyT + "/tmp" + File.separator + "aiapp_" + str;
        tt(str2);
        return str2;
    }

    public static String W(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return tq(str) + File.separator + str2 + ("." + str3);
        }
        return tq(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File bM;
        if (eVar == null) {
            return null;
        }
        b.a afg = eVar.afg();
        boolean z = afg != null && afg.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            bM = d.a.akY();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || ts(str) != PathType.RELATIVE) {
            return null;
        } else {
            bM = d.C0462d.bM(eVar.id, str2);
        }
        if (bM.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return bM.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return bM.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String tr(String str) {
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

    public static PathType ts(String str) {
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

    private static boolean tt(String str) {
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
        b.a afg = eVar.afg();
        if (afg != null && !TextUtils.isEmpty(afg.getAppKey()) && afg.getType() == 1) {
            return afg.getAppKey() + "_dev";
        }
        return eVar.id;
    }

    public static String X(String str, int i) {
        String str2 = "aiapp_setting_" + str;
        if (i == 1) {
            return str2 + "_dev";
        }
        return str2;
    }
}
