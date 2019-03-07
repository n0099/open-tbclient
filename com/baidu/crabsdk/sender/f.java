package com.baidu.crabsdk.sender;

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
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* loaded from: classes3.dex */
public final class f {
    public static synchronized List<String> W(Context context, String str) {
        ArrayList arrayList;
        synchronized (f.class) {
            arrayList = new ArrayList();
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                File[] listFiles = filesDir.listFiles();
                for (File file : listFiles) {
                    if (file.getName().contains("native_") && file.getName().endsWith(str)) {
                        arrayList.add(file.getAbsolutePath());
                    }
                }
            }
        }
        return arrayList;
    }

    public static synchronized void a(Context context, String str) {
        synchronized (f.class) {
            a(context, "crab_anr_" + System.currentTimeMillis(), str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void a(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        DeflaterOutputStream deflaterOutputStream;
        DeflaterOutputStream deflaterOutputStream2 = null;
        deflaterOutputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        synchronized (f.class) {
            com.baidu.crabsdk.c.a.cv("writeFile: " + str);
            e.i(str);
            if (com.baidu.crabsdk.a.G) {
                String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, str);
                try {
                    str2 = com.baidu.crabsdk.c.d.S(str2, c);
                } catch (Exception e) {
                    com.baidu.crabsdk.c.a.f("crash content AES failed!", e);
                }
                try {
                    e.b("key_" + str, com.baidu.crabsdk.c.e.cD(c));
                } catch (Exception e2) {
                    e.b("key_" + str, "NoEncrypt_" + c);
                    e2.printStackTrace();
                }
            }
            try {
                fileOutputStream = context.openFileOutput(str, 0);
                try {
                    byte[] bytes = str2.getBytes(HTTP.UTF_8);
                    if (com.baidu.crabsdk.a.H) {
                        deflaterOutputStream = new DeflaterOutputStream(fileOutputStream, new Deflater(9, true));
                        try {
                            deflaterOutputStream.write(bytes);
                            deflaterOutputStream.close();
                        } catch (Exception e3) {
                            e = e3;
                            fileOutputStream2 = fileOutputStream;
                            try {
                                e.printStackTrace();
                                if (deflaterOutputStream != null) {
                                    try {
                                        deflaterOutputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                deflaterOutputStream2 = deflaterOutputStream;
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
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            deflaterOutputStream2 = deflaterOutputStream;
                            if (deflaterOutputStream2 != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    } else {
                        fileOutputStream.write(bytes);
                        fileOutputStream.close();
                        deflaterOutputStream = null;
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
                    deflaterOutputStream = null;
                    fileOutputStream2 = fileOutputStream;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e11) {
                e = e11;
                deflaterOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        }
    }

    public static synchronized void b(Context context, String str) {
        synchronized (f.class) {
            a(context, "crab_catched_" + System.currentTimeMillis(), str);
        }
    }

    public static synchronized List<String> bc(Context context) {
        ArrayList arrayList;
        synchronized (f.class) {
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

    public static synchronized List<String> bd(Context context) {
        ArrayList arrayList;
        synchronized (f.class) {
            arrayList = new ArrayList();
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                File[] listFiles = filesDir.listFiles();
                for (File file : listFiles) {
                    if (file.getName().contains("native_") && !file.getName().contains(".crab") && !file.getName().contains(".logcat")) {
                        arrayList.add(file.getAbsolutePath() + "@" + file.lastModified());
                    }
                }
            }
        }
        return arrayList;
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
        synchronized (f.class) {
            a(context, "crab_crash_" + System.currentTimeMillis(), str);
        }
    }

    public static byte[] cH(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(str));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream2 = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            byteArrayOutputStream = null;
            fileInputStream = null;
            th = th3;
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
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return bArr;
            }
        } catch (Exception e7) {
            e = e7;
            byteArrayOutputStream2 = null;
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            throw th;
        }
        return bArr;
    }

    public static String cI(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            com.baidu.crabsdk.c.a.cw("开始遍历..." + str);
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    sb.append(file.getName()).append("$");
                }
                com.baidu.crabsdk.c.a.cw(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String j(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        if (map.containsKey("screenshot") && map.get("screenshot") != null && com.baidu.crabsdk.c.c.rW() > 7) {
            map.put("screenshot", Base64.encodeToString((byte[]) map.get("screenshot"), 0));
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
                    com.baidu.crabsdk.c.a.v("mapRecord2JSON: unexpected key[" + str + "]'s value " + obj);
                }
            } catch (JSONException e) {
                com.baidu.crabsdk.c.a.f("Could not create JSON object for key " + str, e);
            }
        }
        return jSONObject.toString();
    }
}
