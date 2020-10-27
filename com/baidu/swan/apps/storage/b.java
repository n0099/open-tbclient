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
    private static String duI = "/aiapp";

    @Nullable
    public static String cz(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (tc(str)) {
            return cA(str, str2);
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
                String th = th(str2);
                if (TextUtils.isEmpty(th)) {
                    return null;
                }
                stringBuffer.append(th);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String tb = tb(str2);
                if (TextUtils.isEmpty(tb)) {
                    return null;
                }
                stringBuffer.append(tb);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.c.d.yU(str4)) {
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
    private static String cA(@NonNull String str, @NonNull String str2) {
        String te;
        String str3 = "";
        if (!TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH)) {
            str3 = str.replace("bdfile://usr/", "");
        }
        if (!com.baidu.swan.c.d.yU(str3) && (te = te(str2)) != null) {
            return te + File.separator + str3;
        }
        return null;
    }

    public static boolean ta(String str) {
        PathType tj = tj(str);
        return tj == PathType.BD_FILE || tj == PathType.RELATIVE;
    }

    public static String d(String str, @NonNull e eVar) {
        String a2;
        switch (tj(str)) {
            case BD_FILE:
                a2 = cz(str, eVar.id);
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
    public static String cB(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String tb = tb(str2);
        String th = th(str2);
        String te = te(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(th) && str.startsWith(th)) {
            replace = str.replace(th, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(tb) && str.startsWith(tb)) {
            replace = str.replace(tb, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(te) || !str.startsWith(te)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(te + File.separator, "");
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
    public static String cC(String str, String str2) {
        String cB = cB(str, str2);
        String yS = com.baidu.swan.c.d.yS(com.baidu.swan.c.d.getFileNameFromPath(str));
        if (cB != null && !cB.contains(".") && yS != null) {
            cB = cB + "." + yS;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + cB);
        }
        return cB;
    }

    public static String aIa() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + duI;
        }
        return null;
    }

    public static String tb(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + duI + "/store" + File.separator + "aiapp_" + str;
        tk(str2);
        return str2;
    }

    public static boolean tc(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH));
    }

    public static boolean td(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static String te(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String tg = tg(absolutePath);
        if (tg != null) {
            String str2 = absolutePath + duI + "/usr" + File.separator + tg + File.separator + "aiapp_" + str;
            tk(str2);
            return str2;
        }
        return null;
    }

    private static boolean tf(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String tg(@NonNull String str) {
        e aEU = e.aEU();
        if (aEU == null) {
            return null;
        }
        String str2 = "";
        if (aEU.aFh() != null) {
            str2 = aEU.aFh().adC();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.c.e.toMd5(str2.getBytes(), false);
            if (tf(str + duI + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String bq = com.baidu.swan.apps.t.a.auf().bq(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bq)) {
            bq = bq.replace("|", "");
        }
        return com.baidu.swan.c.e.toMd5(bq.getBytes(), false);
    }

    public static String aIb() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + duI;
    }

    public static String th(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + duI + "/tmp" + File.separator + "aiapp_" + str;
        tk(str2);
        return str2;
    }

    public static String W(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return th(str) + File.separator + str2 + ("." + str3);
        }
        return th(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File bN;
        if (eVar == null) {
            return null;
        }
        b.a ado = eVar.ado();
        boolean z = ado != null && ado.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            bN = d.a.ajg();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || tj(str) != PathType.RELATIVE) {
            return null;
        } else {
            bN = d.C0452d.bN(eVar.id, str2);
        }
        if (bN.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return bN.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return bN.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String ti(String str) {
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

    public static PathType tj(String str) {
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

    private static boolean tk(String str) {
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
        b.a ado = eVar.ado();
        if (ado != null && !TextUtils.isEmpty(ado.getAppKey()) && ado.getType() == 1) {
            return ado.getAppKey() + "_dev";
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
