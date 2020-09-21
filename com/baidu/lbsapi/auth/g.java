package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.webkit.internal.ETAG;
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
/* loaded from: classes3.dex */
public class g {
    private Context a;
    private String b = null;
    private HashMap<String, String> c = null;
    private String d = null;

    public g(Context context) {
        this.a = context;
    }

    private String a(Context context) {
        String str = "wifi";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT < 29) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    return null;
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null && (extraInfo.trim().toLowerCase().equals("cmwap") || extraInfo.trim().toLowerCase().equals("uniwap") || extraInfo.trim().toLowerCase().equals("3gwap") || extraInfo.trim().toLowerCase().equals("ctwap"))) {
                    str = extraInfo.trim().toLowerCase().equals("ctwap") ? "ctwap" : "cmwap";
                }
                return str;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                boolean hasTransport = networkCapabilities.hasTransport(1);
                boolean hasTransport2 = networkCapabilities.hasTransport(0);
                boolean hasTransport3 = networkCapabilities.hasTransport(3);
                boolean hasTransport4 = networkCapabilities.hasTransport(6);
                boolean hasTransport5 = networkCapabilities.hasTransport(4);
                boolean hasTransport6 = networkCapabilities.hasTransport(5);
                if (hasTransport) {
                    return "WIFI";
                }
                if (hasTransport2) {
                    return "CELLULAR";
                }
                if (hasTransport3) {
                    return "ETHERNET";
                }
                if (hasTransport4) {
                    return "LoWPAN";
                }
                if (hasTransport5) {
                    return "VPN";
                }
                if (hasTransport6) {
                    return "WifiAware";
                }
            }
            return "wifi";
        } catch (Exception e) {
            if (a.a) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0201 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00de A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0139 A[Catch: MalformedURLException -> 0x013d, all -> 0x023e, Exception -> 0x024b, IOException -> 0x0256, TryCatch #17 {all -> 0x023e, blocks: (B:8:0x0033, B:38:0x011d, B:84:0x01c3, B:86:0x01c7, B:87:0x01ca, B:70:0x0186, B:72:0x018a, B:73:0x018d, B:40:0x0125, B:26:0x00cb, B:28:0x00d3, B:46:0x0131, B:48:0x0139, B:49:0x013c), top: B:161:0x002f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HttpsURLConnection httpsURLConnection) {
        OutputStream outputStream;
        int i;
        OutputStream outputStream2;
        InputStream inputStream;
        BufferedReader bufferedReader;
        OutputStream outputStream3 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        BufferedReader bufferedReader2 = null;
        a.a("https Post start,url:" + this.b);
        if (this.c == null) {
            this.d = ErrorMessage.a("httpsPost request paramters is null.");
            return;
        }
        boolean z = true;
        try {
            try {
                outputStream2 = httpsURLConnection.getOutputStream();
                try {
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream2, "UTF-8"));
                        bufferedWriter.write(b(this.c));
                        a.a(b(this.c));
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        httpsURLConnection.connect();
                        try {
                            inputStream = httpsURLConnection.getInputStream();
                            try {
                                int responseCode = httpsURLConnection.getResponseCode();
                                if (200 == responseCode) {
                                    try {
                                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                                    } catch (IOException e) {
                                        e = e;
                                        i = responseCode;
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                    try {
                                        StringBuffer stringBuffer = new StringBuffer();
                                        while (true) {
                                            int read = bufferedReader.read();
                                            if (read == -1) {
                                                break;
                                            }
                                            stringBuffer.append((char) read);
                                        }
                                        this.d = stringBuffer.toString();
                                    } catch (IOException e2) {
                                        e = e2;
                                        bufferedReader2 = bufferedReader;
                                        i = responseCode;
                                        try {
                                            if (a.a) {
                                                e.printStackTrace();
                                                a.a("httpsPost parse failed;" + e.getMessage());
                                            }
                                            this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                                            if (inputStream != null && bufferedReader2 != null) {
                                                bufferedReader2.close();
                                                inputStream.close();
                                            }
                                            if (httpsURLConnection != null) {
                                                httpsURLConnection.disconnect();
                                                z = false;
                                            } else {
                                                z = false;
                                            }
                                            if (outputStream2 != null) {
                                            }
                                            if (!z) {
                                            }
                                            if (this.d == null) {
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (inputStream != null && bufferedReader2 != null) {
                                                bufferedReader2.close();
                                                inputStream.close();
                                            }
                                            if (httpsURLConnection != null) {
                                                httpsURLConnection.disconnect();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        bufferedReader2 = bufferedReader;
                                        if (inputStream != null) {
                                            bufferedReader2.close();
                                            inputStream.close();
                                        }
                                        if (httpsURLConnection != null) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    bufferedReader = null;
                                }
                                if (inputStream != null && bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                        inputStream.close();
                                    } catch (MalformedURLException e3) {
                                        e = e3;
                                        i = responseCode;
                                        outputStream3 = outputStream2;
                                        try {
                                            if (a.a) {
                                                e.printStackTrace();
                                            }
                                            this.d = ErrorMessage.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
                                            if (outputStream3 != null) {
                                                try {
                                                    outputStream3.close();
                                                    z = false;
                                                } catch (IOException e4) {
                                                    if (a.a) {
                                                        e4.printStackTrace();
                                                    }
                                                    z = false;
                                                }
                                                if (!z) {
                                                }
                                                if (this.d == null) {
                                                }
                                            }
                                            z = false;
                                            if (!z) {
                                            }
                                            if (this.d == null) {
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            outputStream = outputStream3;
                                            if (outputStream != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (IOException e5) {
                                        e = e5;
                                        i = responseCode;
                                        if (a.a) {
                                            e.printStackTrace();
                                        }
                                        this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                                        if (outputStream2 != null) {
                                            try {
                                                outputStream2.close();
                                                z = false;
                                            } catch (IOException e6) {
                                                if (a.a) {
                                                    e6.printStackTrace();
                                                }
                                                z = false;
                                            }
                                            if (!z) {
                                            }
                                            if (this.d == null) {
                                            }
                                        }
                                        z = false;
                                        if (!z) {
                                        }
                                        if (this.d == null) {
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                        i = responseCode;
                                        if (a.a) {
                                            e.printStackTrace();
                                        }
                                        this.d = ErrorMessage.a(-11, "httpsPost failed,Exception:" + e.getMessage());
                                        if (outputStream2 != null) {
                                            try {
                                                outputStream2.close();
                                                z = false;
                                            } catch (IOException e8) {
                                                if (a.a) {
                                                    e8.printStackTrace();
                                                }
                                                z = false;
                                            }
                                            if (!z) {
                                            }
                                            if (this.d == null) {
                                            }
                                        }
                                        z = false;
                                        if (!z) {
                                        }
                                        if (this.d == null) {
                                        }
                                    }
                                }
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                    i = responseCode;
                                } else {
                                    i = responseCode;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                i = -1;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (IOException e10) {
                            e = e10;
                            inputStream = null;
                            i = -1;
                        } catch (Throwable th6) {
                            th = th6;
                            inputStream = null;
                        }
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e11) {
                                if (a.a) {
                                    e11.printStackTrace();
                                }
                            }
                        }
                    } catch (MalformedURLException e12) {
                        e = e12;
                        outputStream3 = outputStream2;
                    } catch (IOException e13) {
                        e = e13;
                    } catch (Exception e14) {
                        e = e14;
                    }
                } catch (MalformedURLException e15) {
                    e = e15;
                    i = -1;
                    outputStream3 = outputStream2;
                } catch (IOException e16) {
                    e = e16;
                    i = -1;
                } catch (Exception e17) {
                    e = e17;
                    i = -1;
                }
            } catch (Throwable th7) {
                th = th7;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e18) {
                        if (a.a) {
                            e18.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        } catch (MalformedURLException e19) {
            e = e19;
            i = -1;
        } catch (IOException e20) {
            e = e20;
            i = -1;
            outputStream2 = null;
        } catch (Exception e21) {
            e = e21;
            i = -1;
            outputStream2 = null;
        } catch (Throwable th8) {
            th = th8;
            outputStream = null;
            if (outputStream != null) {
            }
            throw th;
        }
        if (!z && 200 != i) {
            a.a("httpsPost failed,statusCode:" + i);
            this.d = ErrorMessage.a(-11, "httpsPost failed,statusCode:" + i);
        } else if (this.d == null) {
            a.a("httpsPost success end,parse result = " + this.d);
        } else {
            a.a("httpsPost failed,mResult is null");
            this.d = ErrorMessage.a(-1, "httpsPost failed,internal error");
        }
    }

    private static String b(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        boolean z;
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (z2) {
                z = false;
            } else {
                sb.append(ETAG.ITEM_SEPARATOR);
                z = z2;
            }
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            z2 = z;
        }
        return sb.toString();
    }

    private HttpsURLConnection b() {
        try {
            URL url = new URL(this.b);
            a.a("https URL: " + this.b);
            String a = a(this.a);
            if (a == null || a.equals("")) {
                a.c("Current network is not available.");
                this.d = ErrorMessage.a(-10, "Current network is not available.");
                return null;
            }
            a.a("checkNetwork = " + a);
            HttpsURLConnection httpsURLConnection = a.equals("cmwap") ? (HttpsURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80))) : a.equals("ctwap") ? (HttpsURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setHostnameVerifier(new h(this));
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setConnectTimeout(IMConstants.ERROR_BASE);
            httpsURLConnection.setReadTimeout(IMConstants.ERROR_BASE);
            return httpsURLConnection;
        } catch (MalformedURLException e) {
            if (a.a) {
                e.printStackTrace();
                a.a(e.getMessage());
            }
            this.d = ErrorMessage.a(-11, "Auth server could not be parsed as a URL.");
            return null;
        } catch (Exception e2) {
            if (a.a) {
                e2.printStackTrace();
                a.a(e2.getMessage());
            }
            this.d = ErrorMessage.a(-11, "Init httpsurlconnection failed.");
            return null;
        }
    }

    private HashMap<String, String> c(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        for (String str : hashMap.keySet()) {
            String str2 = str.toString();
            hashMap2.put(str2, hashMap.get(str2));
        }
        return hashMap2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(HashMap<String, String> hashMap) {
        this.c = c(hashMap);
        this.b = this.c.get("url");
        HttpsURLConnection b = b();
        if (b == null) {
            a.c("syncConnect failed,httpsURLConnection is null");
            return this.d;
        }
        a(b);
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        boolean z;
        a.a("checkNetwork start");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
            if (connectivityManager == null) {
                z = false;
            } else if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                z = networkCapabilities != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    z = false;
                } else {
                    a.a("checkNetwork end");
                    z = true;
                }
            }
            return z;
        } catch (Exception e) {
            if (a.a) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
