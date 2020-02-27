package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.apps.x.b.b;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpHost;
/* loaded from: classes11.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bVD = "/aiapp";

    @Nullable
    public static String bp(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.startsWith("bdfile://usr/")) {
            return bq(str, str2);
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
                String lY = lY(str2);
                if (TextUtils.isEmpty(lY)) {
                    return null;
                }
                stringBuffer.append(lY);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                String lT = lT(str2);
                if (TextUtils.isEmpty(lT)) {
                    return null;
                }
                stringBuffer.append(lT);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.d.c.ri(str4)) {
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
    private static String bq(@NonNull String str, @NonNull String str2) {
        String lV;
        String replace = str.replace("bdfile://usr/", "");
        if (com.baidu.swan.d.c.ri(replace) || (lV = lV(str2)) == null) {
            return null;
        }
        return lV + File.separator + replace;
    }

    public static boolean lS(String str) {
        PathType ma = ma(str);
        return ma == PathType.BD_FILE || ma == PathType.RELATIVE;
    }

    public static String d(String str, @NonNull e eVar) {
        String a;
        switch (ma(str)) {
            case BD_FILE:
                a = bp(str, eVar.id);
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
    public static String br(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String lT = lT(str2);
        String lY = lY(str2);
        String lV = lV(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(lY) && str.startsWith(lY)) {
            replace = str.replace(lY, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(lT) && str.startsWith(lT)) {
            replace = str.replace(lT, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(lV) || !str.startsWith(lV)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(lV + File.separator, "");
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

    public static String afe() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + bVD;
        }
        return null;
    }

    public static String lT(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + bVD + "/store" + File.separator + "aiapp_" + str;
        mb(str2);
        return str2;
    }

    public static boolean lU(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://usr/");
    }

    public static String lV(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String lX = lX(absolutePath);
        if (lX != null) {
            String str2 = absolutePath + bVD + "/usr" + File.separator + lX + File.separator + "aiapp_" + str;
            mb(str2);
            return str2;
        }
        return null;
    }

    private static boolean lW(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String lX(@NonNull String str) {
        e acD = e.acD();
        if (acD == null) {
            return null;
        }
        String str2 = "";
        if (acD.acO() != null) {
            str2 = acD.acO().GS();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.d.d.toMd5(str2.getBytes(), false);
            if (lW(str + bVD + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String br = com.baidu.swan.apps.w.a.TZ().br(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(br)) {
            br = br.replace("|", "");
        }
        return com.baidu.swan.d.d.toMd5(br.getBytes(), false);
    }

    public static String aff() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + bVD;
    }

    public static String lY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + bVD + "/tmp" + File.separator + "aiapp_" + str;
        mb(str2);
        return str2;
    }

    public static String H(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return lY(str) + File.separator + str2 + ("." + str3);
        }
        return lY(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File aL;
        if (eVar == null) {
            return null;
        }
        b.a GC = eVar.GC();
        boolean z = GC != null && GC.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            aL = e.a.LA();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || ma(str) != PathType.RELATIVE) {
            return null;
        } else {
            aL = e.d.aL(eVar.id, str2);
        }
        if (aL.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return aL.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return aL.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String lZ(String str) {
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

    public static PathType ma(String str) {
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

    private static boolean mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    public static String c(com.baidu.swan.apps.runtime.e eVar) {
        b.a GC = eVar.GC();
        if (GC != null && !TextUtils.isEmpty(GC.getAppKey()) && GC.getType() == 1) {
            return GC.getAppKey() + "_dev";
        }
        return eVar.id;
    }
}
