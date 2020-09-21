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
/* loaded from: classes3.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cZW = "/aiapp";

    @Nullable
    public static String cn(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (rW(str)) {
            return co(str, str2);
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
                String sb = sb(str2);
                if (TextUtils.isEmpty(sb)) {
                    return null;
                }
                stringBuffer.append(sb);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String rV = rV(str2);
                if (TextUtils.isEmpty(rV)) {
                    return null;
                }
                stringBuffer.append(rV);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.c.d.xP(str4)) {
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
    private static String co(@NonNull String str, @NonNull String str2) {
        String rY;
        String str3 = "";
        if (!TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH)) {
            str3 = str.replace("bdfile://usr/", "");
        }
        if (!com.baidu.swan.c.d.xP(str3) && (rY = rY(str2)) != null) {
            return rY + File.separator + str3;
        }
        return null;
    }

    public static boolean rU(String str) {
        PathType sd = sd(str);
        return sd == PathType.BD_FILE || sd == PathType.RELATIVE;
    }

    public static String d(String str, @NonNull e eVar) {
        String a;
        switch (sd(str)) {
            case BD_FILE:
                a = cn(str, eVar.id);
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
    public static String cp(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String rV = rV(str2);
        String sb = sb(str2);
        String rY = rY(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(sb) && str.startsWith(sb)) {
            replace = str.replace(sb, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(rV) && str.startsWith(rV)) {
            replace = str.replace(rV, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(rY) || !str.startsWith(rY)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(rY + File.separator, "");
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
    public static String cq(String str, String str2) {
        String cp = cp(str, str2);
        String xN = com.baidu.swan.c.d.xN(com.baidu.swan.c.d.getFileNameFromPath(str));
        if (cp != null && !cp.contains(".") && xN != null) {
            cp = cp + "." + xN;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + cp);
        }
        return cp;
    }

    public static String aDx() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + cZW;
        }
        return null;
    }

    public static String rV(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + cZW + "/store" + File.separator + "aiapp_" + str;
        se(str2);
        return str2;
    }

    public static boolean rW(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, com.baidu.swan.games.i.a.USER_DATA_PATH));
    }

    public static boolean rX(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static String rY(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String sa = sa(absolutePath);
        if (sa != null) {
            String str2 = absolutePath + cZW + "/usr" + File.separator + sa + File.separator + "aiapp_" + str;
            se(str2);
            return str2;
        }
        return null;
    }

    private static boolean rZ(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String sa(@NonNull String str) {
        e aAr = e.aAr();
        if (aAr == null) {
            return null;
        }
        String str2 = "";
        if (aAr.aAE() != null) {
            str2 = aAr.aAE().YW();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.c.e.toMd5(str2.getBytes(), false);
            if (rZ(str + cZW + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String bk = com.baidu.swan.apps.t.a.apz().bk(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bk)) {
            bk = bk.replace("|", "");
        }
        return com.baidu.swan.c.e.toMd5(bk.getBytes(), false);
    }

    public static String aDy() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + cZW;
    }

    public static String sb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + cZW + "/tmp" + File.separator + "aiapp_" + str;
        se(str2);
        return str2;
    }

    public static String O(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return sb(str) + File.separator + str2 + ("." + str3);
        }
        return sb(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File bB;
        if (eVar == null) {
            return null;
        }
        b.a YI = eVar.YI();
        boolean z = YI != null && YI.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            bB = d.a.aeB();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || sd(str) != PathType.RELATIVE) {
            return null;
        } else {
            bB = d.C0421d.bB(eVar.id, str2);
        }
        if (bB.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return bB.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return bB.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String sc(String str) {
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

    public static PathType sd(String str) {
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

    private static boolean se(String str) {
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
        b.a YI = eVar.YI();
        if (YI != null && !TextUtils.isEmpty(YI.getAppKey()) && YI.getType() == 1) {
            return YI.getAppKey() + "_dev";
        }
        return eVar.id;
    }

    public static String U(String str, int i) {
        String str2 = "aiapp_setting_" + str;
        if (i == 1) {
            return str2 + "_dev";
        }
        return str2;
    }
}
