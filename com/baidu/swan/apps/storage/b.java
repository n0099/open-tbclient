package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.install.e;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String aVJ = "/aiapp";

    @Nullable
    public static String aE(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.startsWith("bdfile://usr/")) {
            return aF(str, str2);
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
                stringBuffer.append(hy(str2));
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                stringBuffer.append(hu(str2));
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (str4.contains("..")) {
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
    private static String aF(@NonNull String str, @NonNull String str2) {
        String hv;
        String replace = str.replace("bdfile://usr/", "");
        if (replace.contains("..") || replace.contains(File.separator) || (hv = hv(str2)) == null) {
            return null;
        }
        return hv + File.separator + replace;
    }

    public static boolean ht(String str) {
        PathType hA = hA(str);
        return hA == PathType.BD_FILE || hA == PathType.RELATIVE;
    }

    public static String b(String str, @NonNull com.baidu.swan.apps.ae.b bVar) {
        String a;
        switch (hA(str)) {
            case BD_FILE:
                a = aE(str, bVar.id);
                break;
            case RELATIVE:
                a = a(str, bVar, bVar.getVersion());
                break;
            default:
                a = str;
                break;
        }
        return a == null ? str : a;
    }

    @Nullable
    public static String aG(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String hu = hu(str2);
        String hy = hy(str2);
        String hv = hv(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(hy) && str.startsWith(hy)) {
            replace = str.replace(hy, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(hu) && str.startsWith(hu)) {
            replace = str.replace(hu, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(hv) || !str.startsWith(hv)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(hv + File.separator, "");
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

    public static String hu(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + aVJ + "/store" + File.separator + "aiapp_" + str;
        hB(str2);
        return str2;
    }

    private static String hv(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String hx = hx(absolutePath);
        if (hx != null) {
            String str2 = absolutePath + aVJ + "/usr" + File.separator + hx + File.separator + "aiapp_" + str;
            hB(str2);
            return str2;
        }
        return null;
    }

    private static boolean hw(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String hx(@NonNull String str) {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq == null) {
            return null;
        }
        String str2 = "";
        if (Lq.Lv() != null) {
            str2 = Lq.Lv().vx();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.c.b.toMd5(str2.getBytes(), false);
            if (hw(str + aVJ + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String bd = com.baidu.swan.apps.u.a.DG().bd(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bd)) {
            bd = bd.replace("|", "");
        }
        return com.baidu.swan.c.b.toMd5(bd.getBytes(), false);
    }

    public static String hy(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + aVJ + "/tmp" + File.separator + "aiapp_" + str;
        hB(str2);
        return str2;
    }

    public static String u(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return hy(str) + File.separator + str2 + ("." + str3);
        }
        return hy(str) + File.separator + str2;
    }

    public static String a(String str, com.baidu.swan.apps.ae.b bVar, String str2) {
        File ae;
        if (bVar == null) {
            return null;
        }
        com.baidu.swan.apps.v.b.b vk = bVar.vk();
        boolean z = vk != null && vk.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            ae = e.a.Ds();
        } else if (TextUtils.isEmpty(bVar.id) || TextUtils.isEmpty(str2) || hA(str) != PathType.RELATIVE) {
            return null;
        } else {
            ae = e.d.ae(bVar.id, str2);
        }
        if (ae.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return ae.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return ae.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String hz(String str) {
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

    public static PathType hA(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (str.startsWith("bdfile://")) {
            return PathType.BD_FILE;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return PathType.NETWORK;
        }
        return PathType.RELATIVE;
    }

    private static boolean hB(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    public static String d(com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.v.b.b vk = bVar.vk();
        if (vk != null && !TextUtils.isEmpty(vk.getAppKey()) && vk.getType() == 1) {
            return vk.getAppKey() + "_dev";
        }
        return bVar.id;
    }
}
