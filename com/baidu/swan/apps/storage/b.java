package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.install.e;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bpU = "/aiapp";

    @Nullable
    public static String aL(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.startsWith("bdfile://usr/")) {
            return aM(str, str2);
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
                int indexOf = str3.indexOf(DefaultConfig.TOKEN_SEPARATOR);
                if (indexOf > 0) {
                    str3 = str3.substring(0, indexOf);
                }
                stringBuffer.append(ik(str2));
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                stringBuffer.append(ig(str2));
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
    private static String aM(@NonNull String str, @NonNull String str2) {
        String ih;
        String replace = str.replace("bdfile://usr/", "");
        if (replace.contains("..") || replace.contains(File.separator) || (ih = ih(str2)) == null) {
            return null;
        }
        return ih + File.separator + replace;
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m18if(String str) {
        PathType im = im(str);
        return im == PathType.BD_FILE || im == PathType.RELATIVE;
    }

    public static String b(String str, @NonNull com.baidu.swan.apps.ae.b bVar) {
        String a;
        switch (im(str)) {
            case BD_FILE:
                a = aL(str, bVar.id);
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
    public static String aN(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String ig = ig(str2);
        String ik = ik(str2);
        String ih = ih(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bdfile://");
        if (!TextUtils.isEmpty(ik) && str.startsWith(ik)) {
            replace = str.replace(ik, "");
            stringBuffer.append("tmp_");
        } else if (!TextUtils.isEmpty(ig) && str.startsWith(ig)) {
            replace = str.replace(ig, "");
            stringBuffer.append("store_");
        } else if (TextUtils.isEmpty(ih) || !str.startsWith(ih)) {
            return null;
        } else {
            return "bdfile://usr/" + str.replace(ih + File.separator, "");
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

    public static String ig(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + bpU + "/store" + File.separator + "aiapp_" + str;
        in(str2);
        return str2;
    }

    private static String ih(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String ij = ij(absolutePath);
        if (ij != null) {
            String str2 = absolutePath + bpU + "/usr" + File.separator + ij + File.separator + "aiapp_" + str;
            in(str2);
            return str2;
        }
        return null;
    }

    private static boolean ii(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    @Nullable
    private static String ij(@NonNull String str) {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ == null) {
            return null;
        }
        String str2 = "";
        if (QZ.Re() != null) {
            str2 = QZ.Re().AW();
        }
        if (!TextUtils.isEmpty(str2)) {
            String md5 = com.baidu.swan.c.b.toMd5(str2.getBytes(), false);
            if (ii(str + bpU + File.separator + md5)) {
                if (DEBUG) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                    return md5;
                }
                return md5;
            }
        }
        String bf = com.baidu.swan.apps.u.a.Jn().bf(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bf)) {
            bf = bf.replace("|", "");
        }
        return com.baidu.swan.c.b.toMd5(bf.getBytes(), false);
    }

    public static String ik(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + bpU + "/tmp" + File.separator + "aiapp_" + str;
        in(str2);
        return str2;
    }

    public static String A(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return ik(str) + File.separator + str2 + (DefaultConfig.TOKEN_SEPARATOR + str3);
        }
        return ik(str) + File.separator + str2;
    }

    public static String a(String str, com.baidu.swan.apps.ae.b bVar, String str2) {
        File am;
        if (bVar == null) {
            return null;
        }
        com.baidu.swan.apps.v.b.b AJ = bVar.AJ();
        boolean z = AJ != null && AJ.isDebug();
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            am = e.a.IZ();
        } else if (TextUtils.isEmpty(bVar.id) || TextUtils.isEmpty(str2) || im(str) != PathType.RELATIVE) {
            return null;
        } else {
            am = e.d.am(bVar.id, str2);
        }
        if (am.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return am.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return am.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String il(String str) {
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

    public static PathType im(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (str.startsWith("bdfile://")) {
            return PathType.BD_FILE;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return PathType.NETWORK;
        }
        return PathType.RELATIVE;
    }

    private static boolean in(String str) {
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
        com.baidu.swan.apps.v.b.b AJ = bVar.AJ();
        if (AJ != null && !TextUtils.isEmpty(AJ.getAppKey()) && AJ.getType() == 1) {
            return AJ.getAppKey() + "_dev";
        }
        return bVar.id;
    }
}
