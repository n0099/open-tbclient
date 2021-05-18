package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.baidu.crabsdk.c.e;
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
/* loaded from: classes.dex */
public final class i {
    public static synchronized List<String> a(Context context, String str, boolean z) {
        ArrayList arrayList;
        File[] listFiles;
        synchronized (i.class) {
            arrayList = new ArrayList();
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                for (File file : filesDir.listFiles()) {
                    if (file.getName().startsWith("native_") && file.getName().endsWith(str)) {
                        arrayList.add(z ? file.getAbsolutePath() + "@" + file.lastModified() : file.getAbsolutePath());
                    }
                }
            }
        }
        return arrayList;
    }

    public static synchronized void b(Context context, String str) {
        synchronized (i.class) {
            c(context, "crab_anr_" + System.currentTimeMillis(), str);
        }
    }

    public static synchronized void c(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        Deflater deflater;
        DeflaterOutputStream deflaterOutputStream;
        synchronized (i.class) {
            com.baidu.crabsdk.c.a.b("writeFile: " + str);
            h.v(str);
            if (com.baidu.crabsdk.a.G) {
                String h2 = com.baidu.crabsdk.c.d.h(com.baidu.crabsdk.a.f4636d, str);
                try {
                    str2 = com.baidu.crabsdk.c.d.j(str2, h2);
                } catch (Exception e2) {
                    com.baidu.crabsdk.c.a.a("crash content AES failed!", e2);
                }
                try {
                    h.m("key_" + str, e.a(h2));
                } catch (Exception e3) {
                    h.m("key_" + str, "NoEncrypt_" + h2);
                    e3.printStackTrace();
                }
            }
            DeflaterOutputStream deflaterOutputStream2 = null;
            try {
                fileOutputStream = context.openFileOutput(str, 0);
                try {
                    byte[] bytes = str2.getBytes("UTF-8");
                    if (com.baidu.crabsdk.a.H) {
                        deflater = new Deflater(9, true);
                        try {
                            try {
                                deflaterOutputStream = new DeflaterOutputStream(fileOutputStream, deflater);
                            } catch (Exception e4) {
                                e = e4;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            deflaterOutputStream.write(bytes);
                            deflaterOutputStream.close();
                            deflater.end();
                            deflaterOutputStream2 = deflaterOutputStream;
                        } catch (Exception e5) {
                            e = e5;
                            deflaterOutputStream2 = deflaterOutputStream;
                            e.printStackTrace();
                            if (deflaterOutputStream2 != null) {
                                try {
                                    deflaterOutputStream2.close();
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
                            if (deflater != null) {
                                try {
                                    deflater.end();
                                    return;
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            deflaterOutputStream2 = deflaterOutputStream;
                            if (deflaterOutputStream2 != null) {
                                try {
                                    deflaterOutputStream2.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                            }
                            if (deflater != null) {
                                try {
                                    deflater.end();
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        fileOutputStream.write(bytes);
                        fileOutputStream.close();
                        deflater = null;
                    }
                    if (deflaterOutputStream2 != null) {
                        try {
                            deflaterOutputStream2.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    if (deflater != null) {
                        try {
                            deflater.end();
                        } catch (Exception e14) {
                            e14.printStackTrace();
                        }
                    }
                } catch (Exception e15) {
                    e = e15;
                    deflater = null;
                } catch (Throwable th3) {
                    th = th3;
                    deflater = null;
                }
            } catch (Exception e16) {
                e = e16;
                fileOutputStream = null;
                deflater = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                deflater = null;
            }
        }
    }

    public static synchronized void d(Context context, String str, byte[] bArr) {
        synchronized (i.class) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = context.openFileOutput(str, 0);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }

    public static synchronized void e(Context context, String str) {
        synchronized (i.class) {
            c(context, "crab_catched_" + System.currentTimeMillis(), str);
        }
    }

    public static String f(Map<String, String> map) {
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

    public static synchronized void g(Context context, String str) {
        synchronized (i.class) {
            c(context, "crab_crash_" + System.currentTimeMillis(), str);
        }
    }

    public static String h(Map<String, Object> map) {
        Object obj;
        Object obj2;
        if (map == null) {
            return "";
        }
        if (map.containsKey("screenshot") && map.get("screenshot") != null && Build.VERSION.SDK_INT > 7) {
            map.put("screenshot", Base64.encodeToString((byte[]) map.get("screenshot"), 0));
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            try {
                obj = map.get(str);
            } catch (JSONException e2) {
                com.baidu.crabsdk.c.a.a("Could not create JSON object for key " + str, e2);
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
                com.baidu.crabsdk.c.a.e("mapRecord2JSON: unexpected key[" + str + "]'s value " + obj);
            }
            jSONObject.put(str, obj2);
        }
        return jSONObject.toString();
    }

    public static synchronized List<String> i(Context context, String str) {
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

    public static boolean j(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static synchronized List<String> k(Context context) {
        ArrayList arrayList;
        File[] listFiles;
        String absolutePath;
        synchronized (i.class) {
            arrayList = new ArrayList();
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                for (File file : filesDir.listFiles()) {
                    if (file.getName().contains("crab_crash_")) {
                        absolutePath = file.getAbsolutePath();
                    } else if (file.getName().contains("crab_anr_")) {
                        absolutePath = file.getAbsolutePath();
                    } else if (file.getName().contains("crab_catched_")) {
                        absolutePath = file.getAbsolutePath();
                    } else if (file.getName().contains("crab_block_")) {
                        absolutePath = file.getAbsolutePath();
                    } else if (file.getName().contains("native_count")) {
                        absolutePath = file.getAbsolutePath();
                    }
                    arrayList.add(absolutePath);
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x003b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0062 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0037 -> B:54:0x0061). Please submit an issue!!! */
    public static byte[] l(String str) {
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
                    com.baidu.crabsdk.c.a.a("Get filebytes error!", e);
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

    public static String m(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            com.baidu.crabsdk.c.a.b("So libs path is: " + str);
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file.getName().endsWith(".so")) {
                        com.baidu.crabsdk.c.a.c(file.getName());
                        if (!com.baidu.crabsdk.a.M.contains(file.getName())) {
                            com.baidu.crabsdk.a.M.add(file.getName());
                        }
                    }
                }
            }
            Iterator<String> it = com.baidu.crabsdk.a.M.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("$");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.baidu.crabsdk.c.a.b("All so libs: " + sb.toString());
        return sb.toString();
    }
}
