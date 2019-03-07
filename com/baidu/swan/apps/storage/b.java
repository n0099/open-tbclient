package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.swan.apps.install.c;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public static String aSP = "/aiapp";

    @Nullable
    public static String aC(String str, String str2) {
        Uri parse;
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        String host = parse.getHost();
        if (DEBUG) {
            Log.d("StorageUtil", "——> getFileStorePathfromScheme: uri " + str + "  host " + host);
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
            stringBuffer.append(gX(str2));
        } else if (host.startsWith("store_")) {
            str3 = host.replace("store_", "");
            stringBuffer.append(gW(str2));
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

    public static boolean gV(String str) {
        PathType gY = gY(str);
        return gY == PathType.BD_FILE || gY == PathType.RELATIVE;
    }

    public static String b(String str, @NonNull com.baidu.swan.apps.ae.b bVar) {
        String a;
        switch (gY(str)) {
            case BD_FILE:
                a = aC(str, bVar.id);
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
    public static String aD(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
        }
        String gW = gW(str2);
        String gX = gX(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(WebGLImageLoader.BDFILE);
        if (!TextUtils.isEmpty(gX) && str.startsWith(gX)) {
            replace = str.replace(gX, "");
            stringBuffer.append("tmp_");
        } else if (TextUtils.isEmpty(gW) || !str.startsWith(gW)) {
            return null;
        } else {
            replace = str.replace(gW, "");
            stringBuffer.append("store_");
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

    public static String KC() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (DEBUG) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + aSP;
        }
        return null;
    }

    public static String gW(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + aSP + "/store" + File.separator + "aiapp_" + str;
        gZ(str2);
        return str2;
    }

    public static String KD() {
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + aSP;
    }

    public static String gX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (DEBUG) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + aSP + "/tmp" + File.separator + "aiapp_" + str;
        gZ(str2);
        return str2;
    }

    public static String u(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return gX(str) + File.separator + str2 + ("." + str3);
        }
        return gX(str) + File.separator + str2;
    }

    public static String a(String str, com.baidu.swan.apps.ae.b bVar, String str2) {
        File ah;
        if (bVar == null) {
            return null;
        }
        com.baidu.swan.apps.v.b.b uB = bVar.uB();
        boolean z = uB != null && uB.axR;
        if (DEBUG && z) {
            Log.d("StorageUtil", "relative path : " + str);
            ah = c.a.Cs();
        } else if (TextUtils.isEmpty(bVar.id) || TextUtils.isEmpty(str2) || gY(str) != PathType.RELATIVE) {
            return null;
        } else {
            ah = c.d.ah(bVar.id, str2);
        }
        if (ah.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return ah.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return ah.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    public static PathType gY(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (str.startsWith(WebGLImageLoader.BDFILE)) {
            return PathType.BD_FILE;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return PathType.NETWORK;
        }
        return PathType.RELATIVE;
    }

    private static boolean gZ(String str) {
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
        com.baidu.swan.apps.v.b.b uB = bVar.uB();
        if (uB != null && !TextUtils.isEmpty(uB.mAppKey) && uB.mType == 1) {
            return uB.mAppKey + "_dev";
        }
        return bVar.id;
    }
}
