package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.ar.statistic.StatisticConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* loaded from: classes5.dex */
public final class i {
    public static synchronized List<String> A(Context context, String str) {
        ArrayList arrayList;
        File[] listFiles;
        synchronized (i.class) {
            arrayList = new ArrayList();
            File filesDir = context.getFilesDir();
            if (filesDir != null && (listFiles = filesDir.listFiles()) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file.getName().startsWith(str)) {
                        arrayList.add(file.getAbsolutePath());
                    }
                }
            }
        }
        return arrayList;
    }

    public static synchronized void a(Context context, String str) {
        synchronized (i.class) {
            a(context, "crab_anr_" + System.currentTimeMillis(), str);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x0111 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:85:0x011a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.String] */
    private static synchronized void a(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        DeflaterOutputStream deflaterOutputStream;
        DeflaterOutputStream deflaterOutputStream2;
        Deflater deflater;
        synchronized (i.class) {
            com.baidu.crabsdk.c.a.dw("writeFile: " + str);
            h.m(str);
            Deflater deflater2 = "writeFile: ";
            if (com.baidu.crabsdk.a.G) {
                String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, str);
                try {
                    str2 = com.baidu.crabsdk.c.d.e(str2, c);
                } catch (Exception e) {
                    com.baidu.crabsdk.c.a.a("crash content AES failed!", e);
                }
                try {
                    String str3 = "key_" + str;
                    h.b(str3, com.baidu.crabsdk.c.e.dD(c));
                    deflater2 = c;
                    deflaterOutputStream = str3;
                    fileOutputStream = "key_";
                } catch (Exception e2) {
                    String str4 = "key_" + str;
                    ?? sb = new StringBuilder("NoEncrypt_");
                    String sb2 = sb.append(c).toString();
                    h.b(str4, sb2);
                    e2.printStackTrace();
                    deflater2 = sb2;
                    deflaterOutputStream = str4;
                    fileOutputStream = sb;
                }
            }
            try {
                try {
                    fileOutputStream = context.openFileOutput(str, 0);
                    try {
                        byte[] bytes = str2.getBytes("UTF-8");
                        if (com.baidu.crabsdk.a.H) {
                            deflater2 = new Deflater(9, true);
                            try {
                                deflaterOutputStream2 = new DeflaterOutputStream(fileOutputStream, deflater2);
                                try {
                                    deflaterOutputStream2.write(bytes);
                                    deflaterOutputStream2.close();
                                    deflater2.end();
                                    deflater = deflater2;
                                } catch (Exception e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    if (deflaterOutputStream2 != null) {
                                        try {
                                            deflaterOutputStream2.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (deflater2 != null) {
                                        try {
                                            deflater2.end();
                                        } catch (Exception e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                }
                            } catch (Exception e7) {
                                e = e7;
                                deflaterOutputStream2 = null;
                            } catch (Throwable th) {
                                th = th;
                                deflaterOutputStream = null;
                                if (deflaterOutputStream != null) {
                                    try {
                                        deflaterOutputStream.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e9) {
                                        e9.printStackTrace();
                                    }
                                }
                                if (deflater2 != null) {
                                    try {
                                        deflater2.end();
                                    } catch (Exception e10) {
                                        e10.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } else {
                            fileOutputStream.write(bytes);
                            fileOutputStream.close();
                            deflater = null;
                            deflaterOutputStream2 = null;
                        }
                        if (deflaterOutputStream2 != null) {
                            try {
                                deflaterOutputStream2.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        if (deflater != null) {
                            try {
                                deflater.end();
                            } catch (Exception e13) {
                                e13.printStackTrace();
                            }
                        }
                    } catch (Exception e14) {
                        e = e14;
                        deflater2 = null;
                        deflaterOutputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        deflater2 = null;
                        deflaterOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e15) {
                e = e15;
                deflater2 = null;
                deflaterOutputStream2 = null;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                deflater2 = null;
                deflaterOutputStream = null;
                fileOutputStream = null;
            }
        }
    }

    public static synchronized void a(Context context, String str, byte[] bArr) {
        synchronized (i.class) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = context.openFileOutput(str, 0);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public static synchronized void b(Context context, String str) {
        synchronized (i.class) {
            a(context, "crab_catched_" + System.currentTimeMillis(), str);
        }
    }

    public static String c(Map<String, String> map) {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.object();
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                jSONStringer.key(str);
                jSONStringer.value(str2);
            }
            jSONStringer.endObject();
            return jSONStringer.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static synchronized void c(Context context, String str) {
        synchronized (i.class) {
            a(context, "crab_crash_" + System.currentTimeMillis(), str);
        }
    }

    public static synchronized List<String> d(Context context, String str, boolean z) {
        ArrayList arrayList;
        synchronized (i.class) {
            arrayList = new ArrayList();
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                File[] listFiles = filesDir.listFiles();
                for (File file : listFiles) {
                    if (file.getName().startsWith("native_") && file.getName().endsWith(str)) {
                        if (z) {
                            arrayList.add(file.getAbsolutePath() + "@" + file.lastModified());
                        } else {
                            arrayList.add(file.getAbsolutePath());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static String dJ(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            com.baidu.crabsdk.c.a.dw("So libs path is: " + str);
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file.getName().endsWith(PluginInstallerService.APK_LIB_SUFFIX)) {
                        com.baidu.crabsdk.c.a.v(file.getName());
                        if (!com.baidu.crabsdk.a.M.contains(file.getName())) {
                            com.baidu.crabsdk.a.M.add(file.getName());
                        }
                    }
                }
            }
            Iterator<String> it = com.baidu.crabsdk.a.M.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append("$");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.c.a.dw("All so libs: " + sb.toString());
        return sb.toString();
    }

    public static byte[] dY(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(str));
            } catch (Throwable th) {
                th = th;
            }
            try {
                byteArrayOutputStream2 = new ByteArrayOutputStream(1000);
                try {
                    byte[] bArr2 = new byte[1000];
                    while (true) {
                        int read = fileInputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr2, 0, read);
                    }
                    fileInputStream.close();
                    byteArrayOutputStream2.close();
                    bArr = byteArrayOutputStream2.toByteArray();
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.crabsdk.c.a.a("Get filebytes error!", e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return bArr;
                }
            } catch (Exception e6) {
                e = e6;
                byteArrayOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            byteArrayOutputStream2 = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
        return bArr;
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String e(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        if (map.containsKey(StatisticConstants.SCREENSHOT) && map.get(StatisticConstants.SCREENSHOT) != null && Build.VERSION.SDK_INT > 7) {
            map.put(StatisticConstants.SCREENSHOT, Base64.encodeToString((byte[]) map.get(StatisticConstants.SCREENSHOT), 0));
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            try {
                Object obj = map.get(str);
                if (obj instanceof String) {
                    jSONObject.put(str, (String) obj);
                } else if (obj instanceof Integer) {
                    jSONObject.put(str, (Integer) obj);
                } else if (obj instanceof Long) {
                    jSONObject.put(str, (Long) obj);
                } else if (obj instanceof Float) {
                    jSONObject.put(str, (Float) obj);
                } else {
                    com.baidu.crabsdk.c.a.dx("mapRecord2JSON: unexpected key[" + str + "]'s value " + obj);
                }
            } catch (JSONException e) {
                com.baidu.crabsdk.c.a.a("Could not create JSON object for key " + str, e);
            }
        }
        return jSONObject.toString();
    }

    public static synchronized List<String> i(Context context) {
        ArrayList arrayList;
        synchronized (i.class) {
            arrayList = new ArrayList();
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                File[] listFiles = filesDir.listFiles();
                for (File file : listFiles) {
                    if (file.getName().contains("crab_crash_")) {
                        arrayList.add(file.getAbsolutePath());
                    } else if (file.getName().contains("crab_anr_")) {
                        arrayList.add(file.getAbsolutePath());
                    } else if (file.getName().contains("crab_catched_")) {
                        arrayList.add(file.getAbsolutePath());
                    } else if (file.getName().contains("crab_block_")) {
                        arrayList.add(file.getAbsolutePath());
                    } else if (file.getName().contains("native_count")) {
                        arrayList.add(file.getAbsolutePath());
                    }
                }
            }
        }
        return arrayList;
    }
}
