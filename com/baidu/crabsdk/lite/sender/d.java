package com.baidu.crabsdk.lite.sender;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Base64;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
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
/* loaded from: classes3.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:62:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x003b -> B:57:0x0063). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            byte[] bArr = null;
            try {
                try {
                    fileInputStream = new FileInputStream(new File(str));
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream(1000);
                        try {
                            try {
                                byte[] bArr2 = new byte[1000];
                                while (true) {
                                    int read = fileInputStream.read(bArr2);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                }
                                fileInputStream.close();
                                byteArrayOutputStream.close();
                                bArr = byteArrayOutputStream.toByteArray();
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                byteArrayOutputStream.close();
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return bArr;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        byteArrayOutputStream = null;
                    } catch (Throwable th3) {
                        byteArrayOutputStream = null;
                        th = th3;
                        if (fileInputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            } catch (Exception e9) {
                e = e9;
                fileInputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                fileInputStream = null;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static String b(String str, Map<String, Object> map) {
        InterceptResult invokeLL;
        Object obj;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) {
            if (map == null) {
                return "";
            }
            if (map.containsKey(StatisticConstants.SCREENSHOT) && map.get(StatisticConstants.SCREENSHOT) != null && com.baidu.crabsdk.lite.b.c.g() > 7) {
                map.put(StatisticConstants.SCREENSHOT, Base64.encodeToString((byte[]) map.get(StatisticConstants.SCREENSHOT), 0));
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
        return (String) invokeLL.objValue;
    }

    public static String c(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static synchronized void d(String str, Context context, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, str, context, str2, str3) == null) {
            synchronized (d.class) {
                com.baidu.crabsdk.lite.b.a.f(str, "writeFile: " + str2);
                c.i(str, str2);
                if (com.baidu.crabsdk.lite.a.f4696i) {
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
    }

    public static synchronized void e(String str, Context context, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65540, null, str, context, str2) == null) {
            synchronized (d.class) {
                d(str, context, "lite_crash_" + str + "_" + System.currentTimeMillis(), str2);
            }
        }
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static synchronized List<String> g(String str, Context context) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        File[] listFiles;
        String absolutePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, context)) == null) {
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
        return (List) invokeLL.objValue;
    }
}
