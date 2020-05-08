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
    private static String cuO = "/aiapp";

    @Nullable
    public static String by(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.startsWith("bdfile://usr/")) {
            return bz(str, str2);
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
                String nk = nk(str2);
                if (TextUtils.isEmpty(nk)) {
                    return null;
                }
                stringBuffer.append(nk);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                String nf = nf(str2);
                if (TextUtils.isEmpty(nf)) {
                    return null;
                }
                stringBuffer.append(nf);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (com.baidu.swan.d.c.sv(str4)) {
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
    private static String bz(@NonNull String str, @NonNull String str2) {
        String nh;
        String replace = str.replace("bdfile://usr/", "");
        if (com.baidu.swan.d.c.sv(replace) || (nh = nh(str2)) == null) {
            return null;
        }
        return nh + File.separator + replace;
    }

    public static boolean ne(String str) {
        PathType nm = nm(str);
        return nm == PathType.BD_FILE || nm == PathType.RELATIVE;
    }

    public static String d(String str, @NonNull e eVar) {
        String a;
        switch (nm(str)) {
            case BD_FILE:
                a = by(str, eVar.id);
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
    public static String bA(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String nf = nf(str2);
        String nk = nk(str2);
        String nh = nh(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(nk) && str.startsWith(nk)) {
            replace = str.replace(nk, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(nf) && str.startsWith(nf)) {
            replace = str.replace(nf, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(nh) || !str.startsWith(nh)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(nh + File.separator, "");
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

    public static String ann() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + cuO;
        }
        return null;
    }

    public static String nf(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + cuO + "/store" + File.separator + "aiapp_" + str;
        nn(str2);
        return str2;
    }

    public static boolean ng(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://usr/");
    }

    public static String nh(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String nj = nj(absolutePath);
        if (nj != null) {
            String str2 = absolutePath + cuO + "/usr" + File.separator + nj + File.separator + "aiapp_" + str;
            nn(str2);
            return str2;
        }
        return null;
    }

    private static boolean ni(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String nj(@NonNull String str) {
        e akM = e.akM();
        if (akM == null) {
            return null;
        }
        String str2 = "";
        if (akM.akX() != null) {
            str2 = akM.akX().OL();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.d.d.toMd5(str2.getBytes(), false);
            if (ni(str + cuO + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String aS = com.baidu.swan.apps.w.a.abS().aS(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(aS)) {
            aS = aS.replace("|", "");
        }
        return com.baidu.swan.d.d.toMd5(aS.getBytes(), false);
    }

    public static String ano() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + cuO;
    }

    public static String nk(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + cuO + "/tmp" + File.separator + "aiapp_" + str;
        nn(str2);
        return str2;
    }

    public static String H(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return nk(str) + File.separator + str2 + ("." + str3);
        }
        return nk(str) + File.separator + str2;
    }

    public static String a(String str, e eVar, String str2) {
        File aT;
        if (eVar == null) {
            return null;
        }
        b.a Ov = eVar.Ov();
        boolean z = Ov != null && Ov.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            aT = e.a.Ts();
        } else if (TextUtils.isEmpty(eVar.id) || TextUtils.isEmpty(str2) || nm(str) != PathType.RELATIVE) {
            return null;
        } else {
            aT = e.d.aT(eVar.id, str2);
        }
        if (aT.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return aT.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return aT.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String nl(String str) {
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

    public static PathType nm(String str) {
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

    private static boolean nn(String str) {
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
        b.a Ov = eVar.Ov();
        if (Ov != null && !TextUtils.isEmpty(Ov.getAppKey()) && Ov.getType() == 1) {
            return Ov.getAppKey() + "_dev";
        }
        return eVar.id;
    }
}
