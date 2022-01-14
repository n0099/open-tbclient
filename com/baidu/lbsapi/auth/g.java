package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes10.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f34609b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f34610c;

    /* renamed from: d  reason: collision with root package name */
    public String f34611d;

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34609b = null;
        this.f34610c = null;
        this.f34611d = null;
        this.a = context;
    }

    private String a(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    return (extraInfo == null || !(extraInfo.trim().toLowerCase().equals(ConectivityUtils.APN_CMWAP) || extraInfo.trim().toLowerCase().equals(ConectivityUtils.APN_UNIWAP) || extraInfo.trim().toLowerCase().equals(ConectivityUtils.APN_3GWAP) || extraInfo.trim().toLowerCase().equals(ConectivityUtils.APN_CTWAP))) ? "wifi" : extraInfo.trim().toLowerCase().equals(ConectivityUtils.APN_CTWAP) ? ConectivityUtils.APN_CTWAP : ConectivityUtils.APN_CMWAP;
                }
                return null;
            } catch (Exception e2) {
                if (a.a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0167, code lost:
        r14.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0196, code lost:
        if (com.baidu.lbsapi.auth.a.a == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01c6, code lost:
        if (com.baidu.lbsapi.auth.a.a == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0165, code lost:
        if (com.baidu.lbsapi.auth.a.a == false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0171 A[Catch: all -> 0x0135, TryCatch #19 {all -> 0x0135, blocks: (B:9:0x0033, B:90:0x013a, B:92:0x013e, B:93:0x0141, B:103:0x016d, B:105:0x0171, B:106:0x0174, B:116:0x019b, B:118:0x019f, B:119:0x01a2), top: B:155:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x019f A[Catch: all -> 0x0135, TryCatch #19 {all -> 0x0135, blocks: (B:9:0x0033, B:90:0x013a, B:92:0x013e, B:93:0x0141, B:103:0x016d, B:105:0x0171, B:106:0x0174, B:116:0x019b, B:118:0x019f, B:119:0x01a2), top: B:155:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01cb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b8 A[Catch: all -> 0x010d, TryCatch #11 {all -> 0x010d, blocks: (B:47:0x00b4, B:49:0x00b8, B:50:0x00d3), top: B:151:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8 A[Catch: Exception -> 0x011e, IOException -> 0x0121, MalformedURLException -> 0x0124, all -> 0x0128, TRY_LEAVE, TryCatch #7 {all -> 0x0128, blocks: (B:10:0x0037, B:68:0x0112, B:70:0x011a, B:71:0x011d, B:53:0x00f0, B:55:0x00f8, B:33:0x0099, B:35:0x00a1), top: B:150:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0110 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011a A[Catch: Exception -> 0x011e, IOException -> 0x0121, MalformedURLException -> 0x0124, all -> 0x0128, TryCatch #7 {all -> 0x0128, blocks: (B:10:0x0037, B:68:0x0112, B:70:0x011a, B:71:0x011d, B:53:0x00f0, B:55:0x00f8, B:33:0x0099, B:35:0x00a1), top: B:150:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x013e A[Catch: all -> 0x0135, TryCatch #19 {all -> 0x0135, blocks: (B:9:0x0033, B:90:0x013a, B:92:0x013e, B:93:0x0141, B:103:0x016d, B:105:0x0171, B:106:0x0174, B:116:0x019b, B:118:0x019f, B:119:0x01a2), top: B:155:0x0033 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HttpsURLConnection httpsURLConnection) {
        int i2;
        OutputStream outputStream;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, httpsURLConnection) == null) {
            a.a("https Post start,url:" + this.f34609b);
            if (this.f34610c == null) {
                this.f34611d = ErrorMessage.a("httpsPost request paramters is null.");
                return;
            }
            boolean z = true;
            OutputStream outputStream2 = null;
            BufferedReader bufferedReader2 = null;
            r5 = null;
            InputStream inputStream = null;
            OutputStream outputStream3 = null;
            OutputStream outputStream4 = null;
            OutputStream outputStream5 = null;
            boolean z2 = false;
            try {
                try {
                    outputStream = httpsURLConnection.getOutputStream();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (MalformedURLException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            }
            try {
                try {
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        bufferedWriter.write(b(this.f34610c));
                        a.a(b(this.f34610c));
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        httpsURLConnection.connect();
                        try {
                            InputStream inputStream2 = httpsURLConnection.getInputStream();
                            try {
                                i2 = httpsURLConnection.getResponseCode();
                                if (200 == i2) {
                                    try {
                                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, "UTF-8"));
                                        try {
                                            StringBuffer stringBuffer = new StringBuffer();
                                            while (true) {
                                                int read = bufferedReader.read();
                                                if (read == -1) {
                                                    break;
                                                }
                                                stringBuffer.append((char) read);
                                            }
                                            this.f34611d = stringBuffer.toString();
                                            bufferedReader2 = bufferedReader;
                                        } catch (IOException e5) {
                                            e = e5;
                                            inputStream = inputStream2;
                                            try {
                                                if (a.a) {
                                                }
                                                this.f34611d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                                                if (inputStream != null) {
                                                    bufferedReader.close();
                                                    inputStream.close();
                                                }
                                                if (httpsURLConnection != null) {
                                                }
                                                z = false;
                                                if (outputStream != null) {
                                                }
                                                z2 = z;
                                                if (z2) {
                                                }
                                                if (this.f34611d == null) {
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                if (inputStream != null && bufferedReader != null) {
                                                    bufferedReader.close();
                                                    inputStream.close();
                                                }
                                                if (httpsURLConnection != null) {
                                                    httpsURLConnection.disconnect();
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            inputStream = inputStream2;
                                            if (inputStream != null) {
                                            }
                                            if (httpsURLConnection != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (IOException e6) {
                                        e = e6;
                                        bufferedReader = null;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        bufferedReader = null;
                                    }
                                }
                                if (inputStream2 != null && bufferedReader2 != null) {
                                    bufferedReader2.close();
                                    inputStream2.close();
                                }
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                            } catch (IOException e7) {
                                e = e7;
                                bufferedReader = null;
                                inputStream = inputStream2;
                                i2 = -1;
                                if (a.a) {
                                    e.printStackTrace();
                                    a.a("httpsPost parse failed;" + e.getMessage());
                                }
                                this.f34611d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                                if (inputStream != null && bufferedReader != null) {
                                    bufferedReader.close();
                                    inputStream.close();
                                }
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                z = false;
                                if (outputStream != null) {
                                }
                                z2 = z;
                                if (z2) {
                                }
                                if (this.f34611d == null) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader = null;
                                inputStream = inputStream2;
                                if (inputStream != null) {
                                    bufferedReader.close();
                                    inputStream.close();
                                }
                                if (httpsURLConnection != null) {
                                }
                                throw th;
                            }
                        } catch (IOException e8) {
                            e = e8;
                            bufferedReader = null;
                        } catch (Throwable th6) {
                            th = th6;
                            bufferedReader = null;
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e9) {
                                if (a.a) {
                                    e9.printStackTrace();
                                }
                            }
                        }
                        z2 = z;
                    } catch (Throwable th7) {
                        th = th7;
                        outputStream3 = outputStream;
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (IOException e10) {
                                if (a.a) {
                                    e10.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                } catch (MalformedURLException e11) {
                    e = e11;
                    outputStream4 = outputStream;
                    if (a.a) {
                        e.printStackTrace();
                    }
                    this.f34611d = ErrorMessage.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
                    if (outputStream4 != null) {
                        try {
                            outputStream4.close();
                        } catch (IOException e12) {
                            e = e12;
                        }
                    }
                    if (z2) {
                    }
                    if (this.f34611d == null) {
                    }
                } catch (IOException e13) {
                    e = e13;
                    outputStream5 = outputStream;
                    if (a.a) {
                        e.printStackTrace();
                    }
                    this.f34611d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                    if (outputStream5 != null) {
                        try {
                            outputStream5.close();
                        } catch (IOException e14) {
                            e = e14;
                        }
                    }
                    if (z2) {
                    }
                    if (this.f34611d == null) {
                    }
                } catch (Exception e15) {
                    e = e15;
                    outputStream2 = outputStream;
                    if (a.a) {
                        e.printStackTrace();
                    }
                    this.f34611d = ErrorMessage.a(-11, "httpsPost failed,Exception:" + e.getMessage());
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e16) {
                            e = e16;
                        }
                    }
                    if (z2) {
                    }
                    if (this.f34611d == null) {
                    }
                }
            } catch (MalformedURLException e17) {
                e = e17;
                outputStream4 = outputStream;
                i2 = -1;
                if (a.a) {
                }
                this.f34611d = ErrorMessage.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
                if (outputStream4 != null) {
                }
                if (z2) {
                }
                if (this.f34611d == null) {
                }
            } catch (IOException e18) {
                e = e18;
                outputStream5 = outputStream;
                i2 = -1;
                if (a.a) {
                }
                this.f34611d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                if (outputStream5 != null) {
                }
                if (z2) {
                }
                if (this.f34611d == null) {
                }
            } catch (Exception e19) {
                e = e19;
                outputStream2 = outputStream;
                i2 = -1;
                if (a.a) {
                }
                this.f34611d = ErrorMessage.a(-11, "httpsPost failed,Exception:" + e.getMessage());
                if (outputStream2 != null) {
                }
                if (z2) {
                }
                if (this.f34611d == null) {
                }
            }
            if (z2 || 200 == i2) {
                if (this.f34611d == null) {
                    a.a("httpsPost failed,mResult is null");
                    this.f34611d = ErrorMessage.a(-1, "httpsPost failed,internal error");
                    return;
                }
                a.a("httpsPost success end,parse result = " + this.f34611d);
                return;
            }
            a.a("httpsPost failed,statusCode:" + i2);
            this.f34611d = ErrorMessage.a(-11, "httpsPost failed,statusCode:" + i2);
        }
    }

    public static String b(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hashMap)) == null) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private HttpsURLConnection b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                URL url = new URL(this.f34609b);
                a.a("https URL: " + this.f34609b);
                String a = a(this.a);
                if (a != null && !a.equals("")) {
                    a.a("checkNetwork = " + a);
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) (a.equals(ConectivityUtils.APN_CMWAP) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80))) : a.equals(ConectivityUtils.APN_CTWAP) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection());
                    httpsURLConnection.setHostnameVerifier(new h(this));
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setConnectTimeout(50000);
                    httpsURLConnection.setReadTimeout(50000);
                    return httpsURLConnection;
                }
                a.c("Current network is not available.");
                this.f34611d = ErrorMessage.a(-10, "Current network is not available.");
                return null;
            } catch (MalformedURLException e2) {
                if (a.a) {
                    e2.printStackTrace();
                    a.a(e2.getMessage());
                }
                str = "Auth server could not be parsed as a URL.";
                this.f34611d = ErrorMessage.a(-11, str);
                return null;
            } catch (Exception e3) {
                if (a.a) {
                    e3.printStackTrace();
                    a.a(e3.getMessage());
                }
                str = "Init httpsurlconnection failed.";
                this.f34611d = ErrorMessage.a(-11, str);
                return null;
            }
        }
        return (HttpsURLConnection) invokeV.objValue;
    }

    private HashMap<String, String> c(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, hashMap)) == null) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            for (String str : hashMap.keySet()) {
                String str2 = str.toString();
                hashMap2.put(str2, hashMap.get(str2));
            }
            return hashMap2;
        }
        return (HashMap) invokeL.objValue;
    }

    public String a(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hashMap)) == null) {
            HashMap<String, String> c2 = c(hashMap);
            this.f34610c = c2;
            this.f34609b = c2.get("url");
            HttpsURLConnection b2 = b();
            if (b2 == null) {
                a.c("syncConnect failed,httpsURLConnection is null");
            } else {
                a(b2);
            }
            return this.f34611d;
        }
        return (String) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a.a("checkNetwork start");
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return false;
                }
                if (activeNetworkInfo.isAvailable()) {
                    a.a("checkNetwork end");
                    return true;
                }
                return false;
            } catch (Exception e2) {
                if (a.a) {
                    e2.printStackTrace();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
