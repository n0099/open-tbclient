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
    private static String dNp = "/aiapp";

    @Nullable
    public static String cx(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (te(str)) {
            return cy(str, str2);
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
                String tj = tj(str2);
                if (TextUtils.isEmpty(tj)) {
                    return null;
                }
                stringBuffer.append(tj);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String td = td(str2);
                if (TextUtils.isEmpty(td)) {
                    return null;
                }
                stringBuffer.append(td);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.c.d.yX(str4)) {
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
    private static String cy(@NonNull String str, @NonNull String str2) {
        String tg;
        String str3 = "";
        if (!TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH)) {
            str3 = str.replace("bdfile://usr/", "");
        }
        if (!com.baidu.swan.c.d.yX(str3) && (tg = tg(str2)) != null) {
            return tg + File.separator + str3;
        }
        return null;
    }

    public static boolean tc(String str) {
        PathType tl = tl(str);
        return tl == PathType.BD_FILE || tl == PathType.RELATIVE;
    }

    public static String c(String str, @NonNull e eVar) {
        String a2;
        switch (tl(str)) {
            case BD_FILE:
                a2 = cx(str, eVar.id);
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
    public static String cz(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String td = td(str2);
        String tj = tj(str2);
        String tg = tg(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(tj) && str.startsWith(tj)) {
            replace = str.replace(tj, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(td) && str.startsWith(td)) {
            replace = str.replace(td, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(tg) || !str.startsWith(tg)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(tg + File.separator, "");
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
    public static String cA(String str, String str2) {
        String cz = cz(str, str2);
        String fileExt = com.baidu.swan.c.d.getFileExt(com.baidu.swan.c.d.getFileNameFromPath(str));
        if (cz != null && !cz.contains(".") && fileExt != null) {
            cz = cz + "." + fileExt;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + cz);
        }
        return cz;
    }

    public static String aLS() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + dNp;
        }
        return null;
    }

    public static String td(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + dNp + "/store" + File.separator + "aiapp_" + str;
        tm(str2);
        return str2;
    }

    public static boolean te(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH));
    }

    public static boolean tf(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static String tg(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String ti = ti(absolutePath);
        if (ti != null) {
            String str2 = absolutePath + dNp + "/usr" + File.separator + ti + File.separator + "aiapp_" + str;
            tm(str2);
            return str2;
        }
        return null;
    }

    private static boolean th(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String ti(@NonNull String str) {
        e aIN = e.aIN();
        if (aIN == null) {
            return null;
        }
        String str2 = "";
        if (aIN.aJa() != null) {
            str2 = aIN.aJa().agr();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.c.e.toMd5(str2.getBytes(), false);
            if (th(str + dNp + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String ca = com.baidu.swan.apps.t.a.axe().ca(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(ca)) {
            ca = ca.replace("|", "");
        }
        return com.baidu.swan.c.e.toMd5(ca.getBytes(), false);
    }

    public static String aLT() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + dNp;
    }

    public static String tj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + dNp + "/tmp" + File.separator + "aiapp_" + str;
        tm(str2);
        return str2;
    }

    public static String ac(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return tj(str) + File.separator + str2 + ("." + str3);
        }
        return tj(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File bL;
        if (eVar == null) {
            return null;
        }
        b.a agc = eVar.agc();
        boolean z = agc != null && agc.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            bL = d.a.ama();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || tl(str) != PathType.RELATIVE) {
            return null;
        } else {
            bL = d.C0452d.bL(eVar.id, str2);
        }
        if (bL.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return bL.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return bL.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String tk(String str) {
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

    public static PathType tl(String str) {
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

    private static boolean tm(String str) {
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
        b.a agc = eVar.agc();
        if (agc != null && !TextUtils.isEmpty(agc.getAppKey()) && agc.getType() == 1) {
            return agc.getAppKey() + "_dev";
        }
        return eVar.id;
    }

    public static String ad(String str, int i) {
        String str2 = "aiapp_setting_" + str;
        if (i == 1) {
            return str2 + "_dev";
        }
        return str2;
    }
}
