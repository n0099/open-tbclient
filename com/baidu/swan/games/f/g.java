package com.baidu.swan.games.f;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class g {
    private static String bzS = "0123456789abcdef";
    private static String bzT = "/aigames/sandbox/";
    private static String bzU;
    private static String bzV;

    public static boolean jQ(String str) {
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!((str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str)) || (str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()) || a.USER_DATA_PATH.equals(str)) || (str.startsWith(new StringBuilder().append("bdfile://code").append(File.separator).toString()) || "bdfile://code".equals(str))) || jS(str)) {
            z = false;
        }
        return z;
    }

    public static boolean jR(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()) || a.USER_DATA_PATH.equals(str)) && !jS(str);
    }

    public static boolean jS(String str) {
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf("../");
        if (indexOf != 0) {
            return indexOf > 0;
        }
        String substring = str.substring("../".length());
        if (TextUtils.isEmpty(substring) || !substring.contains("../")) {
            z = false;
        }
        return z;
    }

    public static boolean isPermissionGranted(Context context, String str) {
        return ActivityCompat.checkSelfPermission(context, str) == 0;
    }

    public static byte[] jT(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) ((Character.digit(charArray[i * 2], 16) << 4) | Character.digit(charArray[(i * 2) + 1], 16));
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String jU(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    for (byte b : bArr) {
                        String hexString = Integer.toHexString(b & 255);
                        if (hexString.length() < 2) {
                            sb.append(0);
                        }
                        sb.append(hexString);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    return sb.toString();
                }
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        if (com.baidu.swan.apps.b.DEBUG) {
                            e4.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
        return sb.toString();
    }

    public static void a(JsFunction jsFunction, JsFunction jsFunction2, Object obj, JsFunction jsFunction3) {
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        a(jsFunction3);
        if (obj instanceof com.baidu.swan.games.f.a.b) {
            com.baidu.swan.games.r.c.ky(((com.baidu.swan.games.f.a.b) obj).errMsg);
        }
    }

    public static void b(JsFunction jsFunction, JsFunction jsFunction2, Object obj, JsFunction jsFunction3) {
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        a(jsFunction3);
    }

    public static void bh(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str + "/tmp");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str + "/usr");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(str + File.separator + "record.pro");
            if (!file3.exists()) {
                try {
                    file3.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (TextUtils.isEmpty(str2)) {
            File file4 = new File(str2);
            if (!file4.exists()) {
                file4.mkdirs();
            }
        }
    }

    public static Map<String, JsFunction> d(JsObject jsObject) {
        if (jsObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jsObject.length(); i++) {
            if (jsObject.getPropertyType(i) == 8) {
                hashMap.put(jsObject.getPropertyName(i), jsObject.toJsFunction(i));
            }
        }
        return hashMap;
    }

    public static Map<String, String> e(JsObject jsObject) {
        if (jsObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jsObject.length(); i++) {
            if (jsObject.getPropertyType(i) == 7) {
                hashMap.put(jsObject.getPropertyName(i), jsObject.toString(i));
            }
        }
        return hashMap;
    }

    public static byte[] f(JsObject jsObject) {
        if (jsObject == null) {
            return null;
        }
        for (int i = 0; i < jsObject.length(); i++) {
            if (jsObject.getPropertyType(i) == 10) {
                JsArrayBuffer jsArrayBuffer = jsObject.toJsArrayBuffer(i);
                return jsArrayBuffer != null ? jsArrayBuffer.buffer() : null;
            }
        }
        return null;
    }

    public static JSExceptionType fS(int i) {
        switch (i) {
            case -5:
                return JSExceptionType.RangeError;
            case -4:
                return JSExceptionType.ReferenceError;
            case -3:
                return JSExceptionType.SyntaxError;
            case -2:
                return JSExceptionType.TypeError;
            case -1:
                return JSExceptionType.Error;
            default:
                return JSExceptionType.Error;
        }
    }

    public static String jV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(a.USER_DATA_PATH + File.separator) || a.USER_DATA_PATH.equals(str)) {
            String basePath = getBasePath();
            if (TextUtils.isEmpty(basePath)) {
                return null;
            }
            String substring = str.substring("bdfile://".length());
            if (substring.startsWith(File.separator)) {
                return basePath + substring;
            }
            return basePath + File.separator + substring;
        }
        return null;
    }

    public static String jW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("bdfile://tmp" + File.separator) || "bdfile://tmp".equals(str)) {
            String basePath = getBasePath();
            if (TextUtils.isEmpty(basePath)) {
                return null;
            }
            String substring = str.substring("bdfile://".length());
            if (substring.startsWith(File.separator)) {
                return basePath + substring;
            }
            return basePath + File.separator + substring;
        }
        return null;
    }

    public static String WN() {
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return "";
        }
        String bY = bY(appContext);
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            String Rm = com.baidu.swan.apps.ae.b.Rm();
            String version = Ra.getVersion();
            String str = "";
            if (Ra.Rg() != null) {
                str = Ra.Rg().AX();
            }
            String bf = com.baidu.swan.apps.u.a.Jo().bf(appContext);
            StringBuilder append = new StringBuilder().append(bY(appContext)).append(File.separator);
            if (TextUtils.isEmpty(str)) {
                str = bf;
            }
            return append.append(str).append("/aigames/swancache/").append(Rm).append(File.separator).append(version).append(File.separator).append("code").toString();
        }
        return bY;
    }

    public static String getBasePath() {
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return "";
        }
        String bX = bX(appContext);
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra == null) {
            return bX;
        }
        String Rm = com.baidu.swan.apps.ae.b.Rm();
        String str = "";
        if (Ra.Rg() != null) {
            str = Ra.Rg().AX();
        }
        bzV = str;
        if (!TextUtils.isEmpty(bzV)) {
            bzV = com.baidu.swan.c.b.toMd5(str.getBytes(), false);
            if (!jX(bX + File.separator + bzV)) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SwanGameFileSystemUtils", "the filesystem base path is under UID ");
                }
                return bX + File.separator + bzV + bzT + Rm;
            }
        }
        String bf = com.baidu.swan.apps.u.a.Jo().bf(appContext);
        if (!TextUtils.isEmpty(bf)) {
            bf = bf.replace("|", "");
        }
        String md5 = com.baidu.swan.c.b.toMd5(bf.getBytes(), false);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("SwanGameFileSystemUtils", "the filesystem base path is under CUID ");
        }
        return bX + File.separator + md5 + bzT + Rm;
    }

    private static boolean jX(String str) {
        File[] listFiles;
        return TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0;
    }

    private static boolean jY(String str) {
        File[] listFiles;
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            boolean z = true;
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    z = deleteFile(listFiles[i].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                } else {
                    z = jY(listFiles[i].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                }
            }
            if (z) {
                return file.delete();
            }
            return false;
        }
        return false;
    }

    private static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String bX(Context context) {
        File externalFilesDir;
        if (context == null) {
            return "";
        }
        if (TextUtils.isEmpty(bzU) && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
            bzU = externalFilesDir.getAbsolutePath();
        }
        return bzU;
    }

    public static String bY(Context context) {
        return context == null ? "" : context.getCacheDir().getAbsolutePath();
    }

    public static List<String> I(String str, boolean z) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                arrayList.add(file.getAbsolutePath());
                return arrayList;
            }
            LinkedList linkedList = new LinkedList();
            File[] listFiles2 = file.listFiles();
            for (int i = 0; i < listFiles2.length; i++) {
                if (listFiles2[i] != null) {
                    if (listFiles2[i].isDirectory()) {
                        linkedList.add(listFiles2[i]);
                    }
                    if (z || listFiles2[i].isFile()) {
                        arrayList.add(listFiles2[i].getAbsolutePath());
                    }
                }
            }
            while (!linkedList.isEmpty()) {
                File file2 = (File) linkedList.removeFirst();
                if (file2.isDirectory() && (listFiles = file2.listFiles()) != null) {
                    for (int i2 = 0; i2 < listFiles.length; i2++) {
                        if (listFiles[i2].isDirectory()) {
                            linkedList.add(listFiles[i2]);
                        }
                        if (z || listFiles[i2].isFile()) {
                            arrayList.add(listFiles[i2].getAbsolutePath());
                        }
                    }
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static String[] bi(String str, String str2) throws Exception {
        String str3;
        String[] strArr = new String[2];
        if (TextUtils.isEmpty(str)) {
            strArr[0] = "";
            strArr[1] = str2;
            return strArr;
        }
        char c = 65535;
        switch (str2.hashCode()) {
            case -1396204209:
                if (str2.equals("base64")) {
                    c = 0;
                    break;
                }
                break;
            case 103195:
                if (str2.equals("hex")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                str3 = new String(Base64.decode(str, 2), "utf-8");
                str2 = "";
                break;
            case 1:
                byte[] jT = jT(str);
                if (jT == null) {
                    str3 = null;
                } else {
                    str3 = new String(jT, "utf-8");
                }
                str2 = "";
                break;
            default:
                str3 = str;
                break;
        }
        strArr[0] = str3;
        strArr[1] = str2;
        return strArr;
    }

    public static Map<String, Object> a(e eVar, JsObject jsObject, com.baidu.swan.games.f.a.b bVar, String str) {
        if (jsObject == null || eVar == null || bVar == null) {
            g(jsObject);
            return null;
        }
        Map<String, JsFunction> d = d(jsObject);
        if (d == null) {
            g(jsObject);
            return null;
        }
        Map<String, String> e = e(jsObject);
        if (e == null) {
            g(jsObject);
            bVar.errMsg = str;
            a(d.get(LivenessStat.TYPE_FACE_MATCH_FAIL), d.get(com.baidu.mobads.openad.c.b.COMPLETE), bVar, d.get("success"));
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : d.keySet()) {
            hashMap.put(str2, d.get(str2));
        }
        for (String str3 : e.keySet()) {
            hashMap.put(str3, e.get(str3));
        }
        g(jsObject);
        return hashMap;
    }

    public static JsFunction d(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof JsFunction) {
            return (JsFunction) obj;
        }
        return null;
    }

    public static String e(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return null;
        }
        Object obj = map.get(str);
        if (obj != null && (obj instanceof String)) {
            return (String) obj;
        }
        return null;
    }

    public static boolean a(b bVar, com.baidu.swan.games.f.a.b bVar2, Map<Integer, String> map, com.baidu.swan.games.e.a aVar) {
        String str;
        if (map != null) {
            for (Integer num : map.keySet()) {
                if (num.intValue() != 7) {
                    str = F(map.get(num), num.intValue());
                    break;
                }
            }
        }
        str = null;
        if (bVar2 == null || bVar == null) {
            return false;
        }
        Map<String, Object> map2 = bVar.bze;
        if (bVar.bze == null) {
            return false;
        }
        c cVar = bVar.bzc;
        JsFunction d = d(LivenessStat.TYPE_FACE_MATCH_FAIL, map2);
        JsFunction d2 = d(com.baidu.mobads.openad.c.b.COMPLETE, map2);
        JsFunction d3 = d("success", map2);
        if (!TextUtils.isEmpty(str)) {
            bVar2.errMsg = bVar.bzd + str;
            a(aVar, bVar2.errMsg);
            a(d, d2, bVar2, d3);
            return false;
        } else if (cVar == null) {
            bVar2.errMsg = bVar.bzd + "unknown error";
            a(d, d2, bVar2, d3);
            return false;
        } else {
            bVar2.errMsg = bVar.bzd + cVar.errMsg;
            if (cVar.errCode != 0) {
                a(d, d2, bVar2, d3);
                return false;
            }
            return true;
        }
    }

    public static void c(Object obj, Map<String, Object> map) {
        b(d("success", map), d(com.baidu.mobads.openad.c.b.COMPLETE, map), obj, d(LivenessStat.TYPE_FACE_MATCH_FAIL, map));
    }

    public static b a(c cVar, String str, Map<String, Object> map) {
        b bVar = new b();
        bVar.bzc = cVar;
        bVar.bzd = str;
        bVar.bze = map;
        return bVar;
    }

    public static void av(long j) {
        File file = new File(getBasePath() + File.separator + "record.pro");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.c.a.b(String.valueOf(WO() + j).getBytes(), file);
        } catch (Exception e) {
        }
    }

    public static boolean aw(long j) {
        return WO() + j > Config.RAVEN_LOG_LIMIT;
    }

    private static long WO() {
        File file = new File(getBasePath() + File.separator + "record.pro");
        if (file.exists() && file.isFile()) {
            String l = com.baidu.swan.c.a.l(file);
            try {
                if (TextUtils.isEmpty(l) || !TextUtils.isDigitsOnly(l.trim())) {
                    return 0L;
                }
                return Long.valueOf(l.trim()).longValue();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                    return 0L;
                }
                return 0L;
            }
        }
        return 0L;
    }

    public static long getFileSize(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return 0L;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                long available = fileInputStream.available();
                com.baidu.swan.c.a.b(fileInputStream);
                return available;
            } catch (Exception e) {
                com.baidu.swan.c.a.b(fileInputStream);
                return 0L;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                com.baidu.swan.c.a.b(fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(e eVar, com.baidu.swan.games.e.a aVar, JsObject jsObject, String str) {
        if (eVar == null || aVar == null) {
            if (jsObject == null && !TextUtils.isEmpty(str)) {
                a(aVar, str + "Object;");
            }
            g(jsObject);
            return false;
        }
        return true;
    }

    public static void a(com.baidu.swan.games.e.a aVar, c cVar, JSExceptionType jSExceptionType, String str, String str2) {
        if (aVar != null) {
            if (cVar == null) {
                aVar.throwJSException(jSExceptionType, str2 + str);
            } else if (cVar.errCode != 0) {
                aVar.throwJSException(fS(cVar.errCode), str2 + cVar.errMsg);
            }
        }
    }

    public static void ad(List<String> list) {
        if (list != null && list.size() != 0) {
            for (String str : list) {
                File file = new File(str);
                if (file.exists()) {
                    com.baidu.swan.c.a.deleteFile(file);
                }
            }
        }
    }

    private static void g(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }

    private static void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }

    public static c C(String str, String str2, String str3) {
        c cVar = new c();
        if (str == null) {
            cVar.errMsg = str3;
            cVar.errCode = -2;
            return cVar;
        } else if ("".equals(str)) {
            cVar.errMsg = str2;
            cVar.errCode = -1;
            return cVar;
        } else {
            return null;
        }
    }

    public static int b(String str, JsObject jsObject) {
        if (jsObject == null || TextUtils.isEmpty(str)) {
            return 12;
        }
        for (int i = 0; i < jsObject.length(); i++) {
            if (str.equals(jsObject.getPropertyName(i))) {
                return jsObject.getPropertyType(i);
            }
        }
        return 12;
    }

    private static String F(String str, int i) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str = "path";
        }
        switch (i) {
            case 1:
                str2 = "Boolean;";
                break;
            case 2:
            case 3:
            case 5:
                str2 = "Number;";
                break;
            case 4:
            case 7:
            case 11:
            default:
                str2 = "NoSupport;";
                break;
            case 6:
                str2 = "Array;";
                break;
            case 8:
                str2 = "Function;";
                break;
            case 9:
                str2 = "Object;";
                break;
            case 10:
                str2 = "ArrayBuffer;";
                break;
            case 12:
                str2 = "Undefined;";
                break;
        }
        return "fail parameter error: parameter." + str + " should be String instead of " + str2;
    }

    public static String fT(int i) {
        switch (i) {
            case 1:
            case 9:
                return "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object";
            case 2:
            case 3:
            case 5:
                return "fail TypeError: data argument must not be a " + "Number;".toLowerCase();
            case 4:
            case 7:
            case 10:
            case 11:
            default:
                return "";
            case 6:
                return "fail TypeError: data argument must not be a " + "Array;".toLowerCase();
            case 8:
                return "fail TypeError: data argument must not be a " + "Function;".toLowerCase();
            case 12:
                return "fail TypeError: data argument must not be a " + "Undefined;".toLowerCase();
        }
    }

    public static String e(String str, String str2, String str3, String str4, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return LivenessStat.TYPE_FACE_MATCH_FAIL;
        }
        String substring = str.endsWith(HanziToPinyin.Token.SEPARATOR) ? str.substring(0, str.length() - 1) : str;
        if (str3 == null) {
            str3 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return String.format("%s \"%s\"", substring, str3);
        }
        if (substring.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            substring = substring.substring(0, substring.length() - 1);
        }
        if (!z && TextUtils.isEmpty(str4)) {
            return String.format("%s, %s \"%s\"", substring, str2, str3);
        }
        return String.format("%s, %s \"%s\" -> \"%s\"", substring, str2, str3, str4);
    }

    public static String o(String str, String str2, String str3, String str4) {
        return e(str, str2, str3, str4, false);
    }

    public static String jZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith("bdfile://")) {
            StringBuilder append = new StringBuilder().append("bdfile://code");
            if (!str.startsWith(File.separator)) {
                str = File.separator + str;
            }
            return append.append(str).toString();
        }
        return str;
    }

    public static void a(com.baidu.swan.games.e.a aVar, String str) {
        if (aVar != null && aVar.WB() != null && !TextUtils.isEmpty(str)) {
            aVar.WB().log(str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1347=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0056 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    public static byte[] ka(String str) {
        BufferedInputStream bufferedInputStream;
        File file = new File(str);
        if (!file.exists()) {
            return new byte[0];
        }
        ?? length = (int) file.length();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 1024);
                        if (-1 == read) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            com.baidu.swan.c.a.b(bufferedInputStream);
                            com.baidu.swan.c.a.b(byteArrayOutputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.baidu.swan.c.a.b(bufferedInputStream);
                    com.baidu.swan.c.a.b(byteArrayOutputStream);
                    return new byte[0];
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.a.b(length);
                com.baidu.swan.c.a.b(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            length = 0;
            com.baidu.swan.c.a.b(length);
            com.baidu.swan.c.a.b(byteArrayOutputStream);
            throw th;
        }
    }

    public static boolean d(File file, File file2) {
        if (file == null || file2 == null) {
            return true;
        }
        if (file.isDirectory() && file2.isFile()) {
            return false;
        }
        return (file.isFile() && file2.isDirectory()) ? false : true;
    }

    public static String jL(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(a.USER_DATA_PATH)) {
            return jV(str);
        }
        if (str.startsWith("bdfile://tmp")) {
            return jW(str);
        }
        return "";
    }

    public static String kb(String str) {
        String str2;
        switch (com.baidu.swan.apps.storage.b.im(str)) {
            case BD_FILE:
                str2 = jL(str);
                break;
            case RELATIVE:
                str2 = com.baidu.swan.apps.w.e.LE().Ln() + str;
                break;
            default:
                str2 = str;
                break;
        }
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    public static boolean kc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str);
    }

    public static void kd(String str) {
        String be = com.baidu.swan.apps.u.a.Jo().be(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(be)) {
            jY(bj(be, str));
            jY(bj(com.baidu.swan.c.b.toMd5(be.getBytes(), false), str));
        }
        String bf = com.baidu.swan.apps.u.a.Jo().bf(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bf)) {
            jY(bj(bf, str));
            jY(bj(com.baidu.swan.c.b.toMd5(bf.replace("|", "").getBytes(), false), str));
        }
    }

    public static String bj(String str, String str2) {
        return bX(AppRuntime.getAppContext()) + File.separator + str + bzT + str2;
    }
}
