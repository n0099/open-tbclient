package com.baidu.crabsdk.lite.sender;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* loaded from: classes.dex */
public final class d {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x003b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0060 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0037 -> B:54:0x005f). Please submit an issue!!! */
    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr = null;
        try {
            try {
                try {
                    str = new FileInputStream(new File((String) str));
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
                str = 0;
                byteArrayOutputStream2 = null;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
                str = 0;
            }
            try {
                byteArrayOutputStream2 = new ByteArrayOutputStream(1000);
                try {
                    byte[] bArr2 = new byte[1000];
                    while (true) {
                        int read = str.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr2, 0, read);
                    }
                    str.close();
                    byteArrayOutputStream2.close();
                    bArr = byteArrayOutputStream2.toByteArray();
                    try {
                        str.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    byteArrayOutputStream2.close();
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    if (str != 0) {
                        try {
                            str.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    return bArr;
                }
            } catch (Exception e6) {
                e = e6;
                byteArrayOutputStream2 = null;
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                if (str != 0) {
                    try {
                        str.close();
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
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        return bArr;
    }

    @SuppressLint({"NewApi"})
    public static String b(String str, Map<String, Object> map) {
        Object obj;
        Object obj2;
        if (map == null) {
            return "";
        }
        if (map.containsKey("screenshot") && map.get("screenshot") != null && com.baidu.crabsdk.lite.b.c.g() > 7) {
            map.put("screenshot", Base64.encodeToString((byte[]) map.get("screenshot"), 0));
        }
        JSONObject jSONObject = new JSONObject();
        for (String str2 : map.keySet()) {
            try {
                obj = map.get(str2);
            } catch (JSONException e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "Could not create JSON object for key " + str2, e2);
            }
            if (obj instanceof String) {
                obj2 = (String) obj;
            } else if (obj instanceof Integer) {
                obj2 = (Integer) obj;
            } else if (obj instanceof Long) {
                obj2 = (Long) obj;
            } else if (obj instanceof Float) {
                obj2 = (Float) obj;
            } else {
                com.baidu.crabsdk.lite.b.a.g(str, "mapRecord2JSON: unexpected key[" + str2 + "]'s value " + obj);
            }
            jSONObject.put(str2, obj2);
        }
        return jSONObject.toString();
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
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static synchronized void d(String str, Context context, String str2, String str3) {
        synchronized (d.class) {
            com.baidu.crabsdk.lite.b.a.f(str, "writeFile: " + str2);
            c.i(str, str2);
            if (com.baidu.crabsdk.lite.a.f4647i) {
                try {
                    String b2 = com.baidu.crabsdk.lite.b.d.b(UUID.randomUUID().toString(), UUID.randomUUID().toString());
                    str3 = com.baidu.crabsdk.lite.b.d.d(str3, b2);
                    c.j(str, "key_" + str2, com.baidu.crabsdk.lite.b.e.a(b2));
                } catch (Exception e2) {
                    com.baidu.crabsdk.lite.b.a.d(str, "RSA failed: " + e2.getMessage());
                }
            }
            FileOutputStream fileOutputStream = null;
            DeflaterOutputStream deflaterOutputStream = null;
            try {
                try {
                    fileOutputStream = context.openFileOutput(str2, 0);
                    try {
                        byte[] bytes = str3.getBytes("UTF-8");
                        if (com.baidu.crabsdk.lite.a.j) {
                            DeflaterOutputStream deflaterOutputStream2 = new DeflaterOutputStream(fileOutputStream, new Deflater(9, true));
                            try {
                                deflaterOutputStream2.write(bytes);
                                deflaterOutputStream2.close();
                                deflaterOutputStream = deflaterOutputStream2;
                            } catch (Exception e3) {
                                e = e3;
                                deflaterOutputStream = deflaterOutputStream2;
                                e.printStackTrace();
                                if (deflaterOutputStream != null) {
                                    try {
                                        deflaterOutputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return;
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                        return;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                deflaterOutputStream = deflaterOutputStream2;
                                if (deflaterOutputStream != null) {
                                    try {
                                        deflaterOutputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } else {
                            fileOutputStream.write(bytes);
                            fileOutputStream.close();
                        }
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
                    } catch (Exception e10) {
                        e = e10;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e11) {
                e = e11;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }
    }

    public static synchronized void e(String str, Context context, String str2) {
        synchronized (d.class) {
            d(str, context, "lite_crash_" + str + "_" + System.currentTimeMillis(), str2);
        }
    }

    public static boolean f(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static synchronized List<String> g(String str, Context context) {
        ArrayList arrayList;
        File[] listFiles;
        String absolutePath;
        synchronized (d.class) {
            arrayList = new ArrayList();
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                for (File file : filesDir.listFiles()) {
                    if (file.getName().contains("lite_crash_" + str)) {
                        absolutePath = file.getAbsolutePath();
                    } else {
                        if (file.getName().contains("lite_catched_" + str)) {
                            absolutePath = file.getAbsolutePath();
                        }
                    }
                    arrayList.add(absolutePath);
                }
            }
        }
        return arrayList;
    }
}
