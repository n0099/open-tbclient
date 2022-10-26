package com.baidu.sofire.face.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.face.api.RequestInfo;
import com.baidu.sofire.utility.WbEncryptUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0084 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static RequestInfo a(Context context, String str, byte[] bArr, String str2) throws Throwable {
        InterceptResult invokeLLLL;
        byte[] bytes;
        ByteArrayInputStream byteArrayInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, context, str, bArr, str2)) == null) {
            char[] charArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            char[] cArr = new char[16];
            for (int i = 0; i < 16; i++) {
                cArr[i] = charArray[new Random().nextInt(62)];
            }
            byte[] bytes2 = new String(cArr).getBytes();
            if (!TextUtils.isEmpty(str)) {
                byte[] bytes3 = str.getBytes();
                ?? r1 = 0;
                GZIPOutputStream gZIPOutputStream = null;
                r1 = 0;
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bytes3);
                    try {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                                try {
                                    byte[] bArr2 = new byte[2048];
                                    while (true) {
                                        int read = byteArrayInputStream.read(bArr2, 0, 2048);
                                        if (read == -1) {
                                            break;
                                        }
                                        gZIPOutputStream2.write(bArr2, 0, read);
                                    }
                                    gZIPOutputStream2.flush();
                                    gZIPOutputStream2.finish();
                                    try {
                                        gZIPOutputStream2.close();
                                    } catch (IOException unused) {
                                    }
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    byteArrayOutputStream.flush();
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                    bytes = F.getInstance().ae(byteArray, bytes2);
                                } catch (Throwable th) {
                                    th = th;
                                    gZIPOutputStream = gZIPOutputStream2;
                                    if (gZIPOutputStream != null) {
                                        try {
                                            gZIPOutputStream.close();
                                        } catch (IOException unused4) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            r1 = bytes3;
                            if (r1 != 0) {
                                try {
                                    r1.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (byteArrayInputStream != null) {
                                try {
                                    byteArrayInputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (r1 != 0) {
                        }
                        if (byteArrayInputStream != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayInputStream = null;
                }
            } else {
                bytes = "".getBytes();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", Base64.encodeToString(bytes, 0).replace("\n", "").replace("\t", "").replace("\r", ""));
            jSONObject.put("app", "android");
            String encodeToString = Base64.encodeToString(F.getInstance().re(bytes2, c.a(F.getInstance().gzd(context)).getBytes()), 0);
            String a = c.a(F.getInstance().gzd(context));
            if (bArr != null && bArr.length != 0 && !TextUtils.isEmpty(str2)) {
                byte[] ae = F.getInstance().ae(WbEncryptUtil.wbEncrypt(context, bArr), bytes2);
                File file = new File(str2);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "tmp_v_" + System.currentTimeMillis());
                if (com.baidu.sofire.face.a.a.a(context, ae, file2)) {
                    return new RequestInfo(encodeToString, a, jSONObject, file2.getAbsolutePath());
                }
                throw new RuntimeException("Wirte File Error.");
            }
            return new RequestInfo(encodeToString, a, jSONObject);
        }
        return (RequestInfo) invokeLLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026 A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:5:0x0005, B:13:0x0026, B:15:0x002c, B:25:0x005f, B:27:0x0077, B:29:0x0082, B:31:0x008c, B:26:0x0071, B:21:0x004e, B:8:0x001c), top: B:43:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c A[Catch: all -> 0x0097, TRY_LEAVE, TryCatch #0 {all -> 0x0097, blocks: (B:5:0x0005, B:13:0x0026, B:15:0x002c, B:25:0x005f, B:27:0x0077, B:29:0x0082, B:31:0x008c, B:26:0x0071, B:21:0x004e, B:8:0x001c), top: B:43:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        URL url;
        int i;
        NetworkInfo activeNetworkInfo;
        boolean z;
        String str2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            HttpURLConnection httpURLConnection2 = null;
            try {
                url = new URL(str);
                i = 80;
                activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                z = true;
            } catch (Throwable unused) {
                if (httpURLConnection2 == null) {
                    return "";
                }
            }
            if (activeNetworkInfo != null && 1 == activeNetworkInfo.getType()) {
                if (z) {
                    if (Build.VERSION.SDK_INT >= 13) {
                        str2 = System.getProperties().getProperty("http.proxyHost");
                        String property = System.getProperties().getProperty("http.proxyPort");
                        if (!TextUtils.isEmpty(property)) {
                            try {
                                i = Integer.parseInt(property);
                            } catch (Throwable unused2) {
                                i = -1;
                            }
                        }
                        i = -1;
                    } else {
                        String host = Proxy.getHost(context);
                        i = Proxy.getPort(context);
                        str2 = host;
                    }
                } else {
                    str2 = null;
                }
                if (str2 == null && i > 0) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str2, i)));
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
                httpURLConnection2 = httpURLConnection;
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.connect();
                if ("https".equalsIgnoreCase(url.getProtocol())) {
                    String a = a((HttpsURLConnection) httpURLConnection2);
                    httpURLConnection2.disconnect();
                    return a;
                }
                httpURLConnection2.disconnect();
                return "";
            }
            z = false;
            if (z) {
            }
            if (str2 == null) {
            }
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection2 = httpURLConnection;
            httpURLConnection2.setConnectTimeout(10000);
            httpURLConnection2.connect();
            if ("https".equalsIgnoreCase(url.getProtocol())) {
            }
            httpURLConnection2.disconnect();
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return Base64.encodeToString((UUID.randomUUID() + "_" + System.currentTimeMillis() + "_" + str).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", "");
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(HttpsURLConnection httpsURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, httpsURLConnection)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                Certificate[] serverCertificates = httpsURLConnection.getServerCertificates();
                String str = "HttpCetificateUtil:certs.length=" + serverCertificates.length;
                int i = a.a;
                String str2 = "";
                for (Certificate certificate : serverCertificates) {
                    try {
                        X509Certificate x509Certificate = (X509Certificate) certificate;
                        sb.append(x509Certificate.toString());
                        sb.append(ParamableElem.DIVIDE_PARAM);
                        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                        if (encoded != null) {
                            String encodeToString = Base64.encodeToString(encoded, 0);
                            str2 = str2 + c.a(encodeToString.replace("\n", "").replace("\r", ""));
                        }
                        str2 = str2 + ParamableElem.DIVIDE_PARAM;
                    } catch (Throwable unused) {
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    return "";
                }
                String substring = str2.substring(0, str2.length() - 1);
                String str3 = "HttpCetificateUtil:pingurl==" + httpsURLConnection.getURL().toString() + ";pingkey==" + substring;
                return substring;
            } catch (Throwable unused2) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONArray a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                String string = d.a(context).a.getString("lt_sha", "");
                if (TextUtils.isEmpty(string)) {
                    int i = a.a;
                    return new JSONArray();
                }
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    String optString = jSONArray2.optString(i2);
                    String a = a(context, optString);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", optString);
                    jSONObject.put("mp", a);
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            } catch (Throwable unused) {
                return new JSONArray();
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027 A[Catch: all -> 0x007b, TRY_ENTER, TryCatch #1 {all -> 0x007b, blocks: (B:5:0x0005, B:15:0x0027, B:17:0x0037, B:18:0x003b, B:20:0x003e, B:23:0x004c, B:29:0x005c, B:33:0x006f, B:36:0x0076, B:24:0x004f, B:26:0x0055), top: B:47:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                String[] strArr = {"android.permission.ACCESS_NETWORK_STATE"};
                int i = 0;
                while (true) {
                    z = true;
                    if (i >= 1) {
                        break;
                    }
                    try {
                        if (context.checkPermission(strArr[i], Process.myPid(), Process.myUid()) == -1) {
                            break;
                        }
                        i++;
                    } catch (Throwable unused) {
                    }
                }
                if (z) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (Build.VERSION.SDK_INT > 20) {
                        for (Network network : connectivityManager.getAllNetworks()) {
                            if (connectivityManager.getNetworkCapabilities(network).hasTransport(4)) {
                                return 17;
                            }
                        }
                    } else {
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(17);
                        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                            return 17;
                        }
                    }
                    if (!TextUtils.isEmpty(System.getProperties().getProperty("http.proxyHost"))) {
                        return 16;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        return -1;
                    }
                    return activeNetworkInfo.getType();
                }
            } catch (Throwable unused2) {
            }
            return -1;
        }
        return invokeL.intValue;
        z = false;
        if (z) {
        }
        return -1;
    }

    public static void a(Context context, String str, int i, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, str, Integer.valueOf(i), Integer.valueOf(i2), jSONObject}) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("0", str);
                hashMap.put("1", Integer.valueOf(i));
                hashMap.put("2", Integer.valueOf(i2));
                F.getInstance().sser(context, "1090101", hashMap);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str, int i, Throwable th) {
        String stringWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65542, null, context, str, i, th) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("0", str);
                hashMap.put("1", Integer.valueOf(i));
                int i2 = a.a;
                for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                    if (th2 instanceof UnknownHostException) {
                        stringWriter = "";
                        break;
                    }
                }
                StringWriter stringWriter2 = null;
                try {
                    StringWriter stringWriter3 = new StringWriter();
                    try {
                        th.printStackTrace(new PrintWriter(stringWriter3));
                        stringWriter = stringWriter3.toString();
                        try {
                            stringWriter3.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        hashMap.put("2", Base64.encodeToString(stringWriter.getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                        F.getInstance().sse(context, "1090102", hashMap, true);
                    } catch (Throwable th3) {
                        th = th3;
                        stringWriter2 = stringWriter3;
                        if (stringWriter2 != null) {
                            try {
                                stringWriter2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable unused) {
            }
        }
    }
}
