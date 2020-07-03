package com.baidu.swan.games.i;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes11.dex */
public class n {
    private static final ReadWriteLock cLB = new ReentrantReadWriteLock();
    private static String dcQ = "0123456789abcdef";
    private static String dcR = "/aigames/sandbox/";
    private static String dcS;
    private static String dcT;

    public static boolean rP(String str) {
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!((str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str)) || (str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()) || a.USER_DATA_PATH.equals(str)) || (str.startsWith(new StringBuilder().append("bdfile://code").append(File.separator).toString()) || "bdfile://code".equals(str))) || rR(str)) {
            z = false;
        }
        return z;
    }

    public static boolean rQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()) || a.USER_DATA_PATH.equals(str)) && !rR(str);
    }

    public static boolean rR(String str) {
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

    public static byte[] rS(String str) {
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

    public static String rT(String str) {
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
                    com.baidu.swan.e.d.closeSafely(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.e.d.closeSafely(fileInputStream);
                    return sb.toString();
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.e.d.closeSafely(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            com.baidu.swan.e.d.closeSafely(fileInputStream);
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
        if (obj instanceof com.baidu.swan.games.i.a.b) {
            com.baidu.swan.games.v.c.sz(((com.baidu.swan.games.i.a.b) obj).errMsg);
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

    public static void cq(String str, String str2) {
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

    public static Map<String, JsFunction> f(JsObject jsObject) {
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

    public static byte[] g(JsObject jsObject) {
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

    public static JSExceptionType iC(int i) {
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

    public static String rU(String str) {
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

    public static String rV(String str) {
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

    public static String aBh() {
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return "";
        }
        String dn = dn(appContext);
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM != null) {
            String apO = com.baidu.swan.apps.runtime.e.apO();
            String version = apM.getVersion();
            String str = "";
            if (apM.apZ() != null) {
                str = apM.apZ().Sd();
            }
            String bd = com.baidu.swan.apps.u.a.agc().bd(appContext);
            StringBuilder append = new StringBuilder().append(dn(appContext)).append(File.separator);
            if (TextUtils.isEmpty(str)) {
                str = bd;
            }
            return append.append(str).append("/aigames/swancache/").append(apO).append(File.separator).append(version).append(File.separator).append("code").toString();
        }
        return dn;
    }

    public static void aBi() {
        Context appContext = AppRuntime.getAppContext();
        if (appContext != null) {
            String dm = dm(appContext);
            String str = dm + File.separator + "swangame/anonymous/sandbox";
            if (!TextUtils.isEmpty(str)) {
                rW(str);
            }
            String str2 = dm + File.separator + dcT + dcR;
            if (!TextUtils.isEmpty(str2)) {
                rW(str2);
            }
        }
    }

    public static String getBasePath() {
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return "";
        }
        String dm = dm(appContext);
        if (com.baidu.swan.apps.runtime.e.apM() != null) {
            return dm + File.separator + "swangame/anonymous/sandbox" + File.separator + com.baidu.swan.apps.runtime.e.apO();
        }
        return dm;
    }

    public static void cr(String str, String str2) {
        File file;
        try {
            new File(str2).mkdirs();
            String[] list = new File(str).list();
            for (int i = 0; i < list.length; i++) {
                if (str.endsWith(File.separator)) {
                    file = new File(str + list[i]);
                } else {
                    file = new File(str + File.separator + list[i]);
                }
                if (file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2 + "/" + file.getName().toString());
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    com.baidu.swan.e.d.closeSafely(fileOutputStream);
                    com.baidu.swan.e.d.closeSafely(fileInputStream);
                }
                if (file.isDirectory()) {
                    cr(str + "/" + list[i], str2 + "/" + list[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean rW(String str) {
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
                    z = rW(listFiles[i].getAbsolutePath());
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

    public static String dm(Context context) {
        File externalFilesDir;
        if (context == null) {
            return "";
        }
        if (TextUtils.isEmpty(dcS) && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
            dcS = externalFilesDir.getAbsolutePath();
        }
        return dcS;
    }

    public static String dn(Context context) {
        return context == null ? "" : context.getCacheDir().getAbsolutePath();
    }

    public static List<String> ah(String str, boolean z) {
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

    public static String[] cs(String str, String str2) throws Exception {
        String str3;
        String[] strArr = new String[2];
        if (TextUtils.isEmpty(str)) {
            strArr[0] = "";
            strArr[1] = str2;
            return strArr;
        }
        if (TextUtils.equals(str2, "hex")) {
            byte[] rS = rS(str);
            str3 = rS == null ? "" : new String(rS, "utf-8");
            str2 = "";
        } else {
            str3 = str;
        }
        strArr[0] = str3;
        strArr[1] = str2;
        return strArr;
    }

    public static Map<String, Object> a(f fVar, JsObject jsObject, com.baidu.swan.games.i.a.b bVar, String str) {
        if (jsObject == null || fVar == null || bVar == null) {
            i(jsObject);
            return null;
        }
        Map<String, JsFunction> f = f(jsObject);
        if (f == null) {
            i(jsObject);
            return null;
        }
        Map<String, Object> h = h(jsObject);
        if (h == null) {
            i(jsObject);
            bVar.errMsg = str;
            a(f.get("fail"), f.get(com.baidu.mobads.openad.c.b.COMPLETE), bVar, f.get("success"));
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : f.keySet()) {
            hashMap.put(str2, f.get(str2));
        }
        for (String str3 : h.keySet()) {
            hashMap.put(str3, h.get(str3));
        }
        i(jsObject);
        return hashMap;
    }

    public static Map<String, Object> h(JsObject jsObject) {
        Object jsObject2;
        if (jsObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jsObject.length(); i++) {
            switch (jsObject.getPropertyType(i)) {
                case 1:
                    jsObject2 = Boolean.valueOf(jsObject.toBoolean(i));
                    break;
                case 2:
                    jsObject2 = Integer.valueOf(jsObject.toInteger(i));
                    break;
                case 3:
                    jsObject2 = Long.valueOf(jsObject.toLong(i));
                    break;
                case 4:
                case 6:
                default:
                    jsObject2 = null;
                    break;
                case 5:
                    jsObject2 = Double.valueOf(jsObject.toDouble(i));
                    break;
                case 7:
                    jsObject2 = jsObject.toString(i);
                    break;
            }
            if (jsObject2 != null) {
                hashMap.put(jsObject.getPropertyName(i), jsObject2);
            }
        }
        return hashMap;
    }

    public static JsFunction h(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof JsFunction) {
            return (JsFunction) obj;
        }
        return null;
    }

    public static String i(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return null;
        }
        Object obj = map.get(str);
        if (obj != null && (obj instanceof String)) {
            return (String) obj;
        }
        return null;
    }

    @NonNull
    public static <T> T a(String str, Map<String, Object> map, @NonNull T t) {
        T t2;
        return (TextUtils.isEmpty(str) || map == null || (t2 = (T) map.get(str)) == null) ? t : t2;
    }

    public static boolean a(b bVar, com.baidu.swan.games.i.a.b bVar2, Map<Integer, String> map, com.baidu.swan.games.f.a aVar) {
        String str;
        if (map != null) {
            for (Integer num : map.keySet()) {
                if (num.intValue() != 7) {
                    str = U(map.get(num), num.intValue());
                    break;
                }
            }
        }
        str = null;
        if (bVar2 == null || bVar == null) {
            return false;
        }
        Map<String, Object> map2 = bVar.dbH;
        if (bVar.dbH == null) {
            return false;
        }
        c cVar = bVar.dbF;
        JsFunction h = h("fail", map2);
        JsFunction h2 = h(com.baidu.mobads.openad.c.b.COMPLETE, map2);
        JsFunction h3 = h("success", map2);
        if (!TextUtils.isEmpty(str)) {
            bVar2.errMsg = bVar.dbG + str;
            a(aVar, bVar2.errMsg);
            a(h, h2, bVar2, h3);
            return false;
        } else if (cVar == null) {
            bVar2.errMsg = bVar.dbG + "unknown error";
            a(h, h2, bVar2, h3);
            return false;
        } else {
            bVar2.errMsg = bVar.dbG + cVar.errMsg;
            if (cVar.errCode != 0) {
                a(h, h2, bVar2, h3);
                return false;
            }
            return true;
        }
    }

    public static void b(Object obj, Map<String, Object> map) {
        b(h("success", map), h(com.baidu.mobads.openad.c.b.COMPLETE, map), obj, h("fail", map));
    }

    public static b a(c cVar, String str, Map<String, Object> map) {
        b bVar = new b();
        bVar.dbF = cVar;
        bVar.dbG = str;
        bVar.dbH = map;
        return bVar;
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
                com.baidu.swan.e.d.closeSafely(fileInputStream);
                return available;
            } catch (Exception e) {
                com.baidu.swan.e.d.closeSafely(fileInputStream);
                return 0L;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                com.baidu.swan.e.d.closeSafely(fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(f fVar, com.baidu.swan.games.f.a aVar, JsObject jsObject, String str) {
        if (fVar == null || aVar == null) {
            if (jsObject == null && !TextUtils.isEmpty(str)) {
                a(aVar, str + "Object;");
            }
            i(jsObject);
            return false;
        }
        return true;
    }

    public static void a(com.baidu.swan.games.f.a aVar, c cVar, JSExceptionType jSExceptionType, String str, String str2) {
        if (aVar != null) {
            if (cVar == null) {
                aVar.throwJSException(jSExceptionType, str2 + str);
            } else if (cVar.errCode != 0) {
                aVar.throwJSException(iC(cVar.errCode), str2 + cVar.errMsg);
            }
        }
    }

    public static void aq(List<String> list) {
        if (list != null && list.size() != 0) {
            for (String str : list) {
                File file = new File(str);
                if (file.exists()) {
                    com.baidu.swan.e.d.deleteFile(file);
                }
            }
        }
    }

    private static void i(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }

    private static void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }

    public static c P(String str, String str2, String str3) {
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

    public static int a(String str, JsObject jsObject) {
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

    private static String U(String str, int i) {
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

    public static String iD(int i) {
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

    public static String b(String str, String str2, String str3, String str4, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "fail";
        }
        String substring = str.endsWith(" ") ? str.substring(0, str.length() - 1) : str;
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

    public static String t(String str, String str2, String str3, String str4) {
        return b(str, str2, str3, str4, false);
    }

    public static String rX(String str) {
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

    public static void a(com.baidu.swan.games.f.a aVar, String str) {
        if (aVar != null && aVar.aAJ() != null && !TextUtils.isEmpty(str)) {
            aVar.aAJ().log(str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1291=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0056 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    public static byte[] rY(String str) {
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
                            com.baidu.swan.e.d.closeSafely(bufferedInputStream);
                            com.baidu.swan.e.d.closeSafely(byteArrayOutputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.baidu.swan.e.d.closeSafely(bufferedInputStream);
                    com.baidu.swan.e.d.closeSafely(byteArrayOutputStream);
                    return new byte[0];
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.e.d.closeSafely(length);
                com.baidu.swan.e.d.closeSafely(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            length = 0;
            com.baidu.swan.e.d.closeSafely(length);
            com.baidu.swan.e.d.closeSafely(byteArrayOutputStream);
            throw th;
        }
    }

    public static boolean i(File file, File file2) {
        if (file == null || file2 == null) {
            return true;
        }
        if (file.isDirectory() && file2.isFile()) {
            return false;
        }
        return (file.isFile() && file2.isDirectory()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1342=4] */
    public static boolean ct(String str, String str2) {
        ZipOutputStream zipOutputStream;
        try {
            try {
                File file = new File(str2);
                File file2 = new File(str);
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
                try {
                    if (file2.isFile()) {
                        zipFileOrDirectory(zipOutputStream, file2, "");
                    } else {
                        for (File file3 : file2.listFiles()) {
                            zipFileOrDirectory(zipOutputStream, file3, "");
                        }
                    }
                    com.baidu.swan.e.d.closeSafely(zipOutputStream);
                    return true;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.baidu.swan.e.d.closeSafely(zipOutputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.e.d.closeSafely(null);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            zipOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.e.d.closeSafely(null);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1380=4] */
    private static void zipFileOrDirectory(ZipOutputStream zipOutputStream, File file, String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        zipFileOrDirectory(zipOutputStream, file2, str + file.getName() + File.separator);
                    }
                    fileInputStream = null;
                } else {
                    byte[] bArr = new byte[4096];
                    fileInputStream = new FileInputStream(file);
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                        zipOutputStream.closeEntry();
                    } catch (Exception e) {
                        fileInputStream2 = fileInputStream;
                        e = e;
                        e.printStackTrace();
                        com.baidu.swan.e.d.closeSafely(fileInputStream2);
                        return;
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream;
                        th = th;
                        com.baidu.swan.e.d.closeSafely(fileInputStream2);
                        throw th;
                    }
                }
                com.baidu.swan.e.d.closeSafely(fileInputStream);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String rJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(a.USER_DATA_PATH)) {
            return rU(str);
        }
        if (str.startsWith("bdfile://tmp")) {
            return rV(str);
        }
        return "";
    }

    public static String pg(String str) {
        String str2;
        switch (com.baidu.swan.apps.storage.b.oY(str)) {
            case BD_FILE:
                str2 = rJ(str);
                break;
            case RELATIVE:
                str2 = com.baidu.swan.apps.w.f.ajb().aiI() + str;
                break;
            default:
                str2 = str;
                break;
        }
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    public static boolean rZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str);
    }

    public static void sa(String str) {
        Context appContext;
        String bc = com.baidu.swan.apps.u.a.agc().bc(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bc)) {
            rW(cu(bc, str));
            rW(cu(com.baidu.swan.e.e.toMd5(bc.getBytes(), false), str));
        }
        String bd = com.baidu.swan.apps.u.a.agc().bd(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(bd)) {
            rW(cu(bd, str));
            rW(cu(com.baidu.swan.e.e.toMd5(bd.replace("|", "").getBytes(), false), str));
        }
        if (AppRuntime.getAppContext() != null) {
            String str2 = dm(appContext) + File.separator + "swangame/anonymous/sandbox" + File.separator + str;
            if (!TextUtils.isEmpty(str2)) {
                rW(str2);
            }
        }
    }

    public static String cu(String str, String str2) {
        return dm(AppRuntime.getAppContext()) + File.separator + str + dcR + str2;
    }

    public static String sb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String basePath = getBasePath();
        if (TextUtils.isEmpty(basePath)) {
            return null;
        }
        String str2 = basePath + File.separator;
        if (!str.startsWith(str2) || str.length() <= str2.length()) {
            return null;
        }
        return "bdfile://" + str.substring(str2.length());
    }
}
