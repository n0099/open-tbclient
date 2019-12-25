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
/* loaded from: classes9.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bQO = "/aiapp";

    @Nullable
    public static String bf(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.startsWith("bdfile://usr/")) {
            return bg(str, str2);
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
                String lG = lG(str2);
                if (TextUtils.isEmpty(lG)) {
                    return null;
                }
                stringBuffer.append(lG);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                String lB = lB(str2);
                if (TextUtils.isEmpty(lB)) {
                    return null;
                }
                stringBuffer.append(lB);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.d.c.qQ(str4)) {
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
    private static String bg(@NonNull String str, @NonNull String str2) {
        String lD;
        String replace = str.replace("bdfile://usr/", "");
        if (com.baidu.swan.d.c.qQ(replace) || (lD = lD(str2)) == null) {
            return null;
        }
        return lD + File.separator + replace;
    }

    public static boolean lA(String str) {
        PathType lI = lI(str);
        return lI == PathType.BD_FILE || lI == PathType.RELATIVE;
    }

    public static String d(String str, @NonNull e eVar) {
        String a;
        switch (lI(str)) {
            case BD_FILE:
                a = bf(str, eVar.id);
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
    public static String bh(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String lB = lB(str2);
        String lG = lG(str2);
        String lD = lD(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(lG) && str.startsWith(lG)) {
            replace = str.replace(lG, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(lB) && str.startsWith(lB)) {
            replace = str.replace(lB, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(lD) || !str.startsWith(lD)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(lD + File.separator, "");
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

    public static String act() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + bQO;
        }
        return null;
    }

    public static String lB(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + bQO + "/store" + File.separator + "aiapp_" + str;
        lJ(str2);
        return str2;
    }

    public static boolean lC(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://usr/");
    }

    public static String lD(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String lF = lF(absolutePath);
        if (lF != null) {
            String str2 = absolutePath + bQO + "/usr" + File.separator + lF + File.separator + "aiapp_" + str;
            lJ(str2);
            return str2;
        }
        return null;
    }

    private static boolean lE(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String lF(@NonNull String str) {
        e ZS = e.ZS();
        if (ZS == null) {
            return null;
        }
        String str2 = "";
        if (ZS.aad() != null) {
            str2 = ZS.aad().Eh();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.d.d.toMd5(str2.getBytes(), false);
            if (lE(str + bQO + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String bn = com.baidu.swan.apps.w.a.Rp().bn(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bn)) {
            bn = bn.replace("|", "");
        }
        return com.baidu.swan.d.d.toMd5(bn.getBytes(), false);
    }

    public static String acu() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + bQO;
    }

    public static String lG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + bQO + "/tmp" + File.separator + "aiapp_" + str;
        lJ(str2);
        return str2;
    }

    public static String G(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return lG(str) + File.separator + str2 + ("." + str3);
        }
        return lG(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File aA;
        if (eVar == null) {
            return null;
        }
        b.a DR = eVar.DR();
        boolean z = DR != null && DR.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            aA = e.a.IP();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || lI(str) != PathType.RELATIVE) {
            return null;
        } else {
            aA = e.d.aA(eVar.id, str2);
        }
        if (aA.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return aA.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return aA.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String lH(String str) {
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

    public static PathType lI(String str) {
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

    private static boolean lJ(String str) {
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
        b.a DR = eVar.DR();
        if (DR != null && !TextUtils.isEmpty(DR.getAppKey()) && DR.getType() == 1) {
            return DR.getAppKey() + "_dev";
        }
        return eVar.id;
    }
}
