package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private Context f1879a;
    private String b = null;
    private HashMap<String, String> c = null;
    private String d = null;

    public g(Context context) {
        this.f1879a = context;
    }

    private String a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            return (extraInfo == null || !(extraInfo.trim().toLowerCase().equals("cmwap") || extraInfo.trim().toLowerCase().equals("uniwap") || extraInfo.trim().toLowerCase().equals("3gwap") || extraInfo.trim().toLowerCase().equals("ctwap"))) ? "wifi" : extraInfo.trim().toLowerCase().equals("ctwap") ? "ctwap" : "cmwap";
        } catch (Exception e) {
            if (a.f1874a) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:127:0x0260 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0082 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012d A[Catch: all -> 0x023b, TryCatch #12 {all -> 0x023b, blocks: (B:43:0x0129, B:45:0x012d, B:46:0x0130), top: B:148:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0170 A[Catch: all -> 0x0239, TryCatch #9 {all -> 0x0239, blocks: (B:8:0x0033, B:37:0x011b, B:39:0x0123, B:25:0x00c9, B:59:0x016c, B:61:0x0170, B:62:0x0173, B:82:0x01be, B:84:0x01c2, B:85:0x01c5, B:27:0x00d1, B:54:0x015f, B:56:0x0167, B:57:0x016a), top: B:145:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c2 A[Catch: all -> 0x0239, TryCatch #9 {all -> 0x0239, blocks: (B:8:0x0033, B:37:0x011b, B:39:0x0123, B:25:0x00c9, B:59:0x016c, B:61:0x0170, B:62:0x0173, B:82:0x01be, B:84:0x01c2, B:85:0x01c5, B:27:0x00d1, B:54:0x015f, B:56:0x0167, B:57:0x016a), top: B:145:0x002f }] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HttpsURLConnection httpsURLConnection) {
        OutputStream outputStream;
        int i;
        OutputStream outputStream2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        OutputStream outputStream3 = null;
        StringBuilder append = new StringBuilder().append("https Post start,url:");
        ?? r1 = this.b;
        a.a(append.append((String) r1).toString());
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
                        try {
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream2, "UTF-8"));
                            bufferedWriter.write(b(this.c));
                            a.a(b(this.c));
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            httpsURLConnection.connect();
                            try {
                                r1 = httpsURLConnection.getInputStream();
                                try {
                                    i = httpsURLConnection.getResponseCode();
                                    if (200 == i) {
                                        try {
                                            bufferedReader2 = new BufferedReader(new InputStreamReader((InputStream) r1, "UTF-8"));
                                            try {
                                                StringBuffer stringBuffer = new StringBuffer();
                                                while (true) {
                                                    int read = bufferedReader2.read();
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    stringBuffer.append((char) read);
                                                }
                                                this.d = stringBuffer.toString();
                                            } catch (IOException e) {
                                                e = e;
                                                if (a.f1874a) {
                                                    e.printStackTrace();
                                                    a.a("httpsPost parse failed;" + e.getMessage());
                                                }
                                                this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                                                if (r1 != 0 && bufferedReader2 != null) {
                                                    bufferedReader2.close();
                                                    r1.close();
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
                                                if (this.d != null) {
                                                }
                                            }
                                        } catch (IOException e2) {
                                            e = e2;
                                            bufferedReader2 = null;
                                        } catch (Throwable th) {
                                            th = th;
                                            bufferedReader = null;
                                            if (r1 != 0 && bufferedReader != null) {
                                                bufferedReader.close();
                                                r1.close();
                                            }
                                            if (httpsURLConnection != null) {
                                                httpsURLConnection.disconnect();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        bufferedReader2 = null;
                                    }
                                    if (r1 != 0 && bufferedReader2 != null) {
                                        bufferedReader2.close();
                                        r1.close();
                                    }
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    bufferedReader2 = null;
                                    i = -1;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader = null;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                r1 = 0;
                                bufferedReader2 = null;
                                i = -1;
                            } catch (Throwable th3) {
                                th = th3;
                                r1 = 0;
                                bufferedReader = null;
                            }
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e5) {
                                    if (a.f1874a) {
                                        e5.printStackTrace();
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (MalformedURLException e6) {
                        e = e6;
                        i = -1;
                        outputStream3 = outputStream2;
                        try {
                            if (a.f1874a) {
                                e.printStackTrace();
                            }
                            this.d = ErrorMessage.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
                            if (outputStream3 != null) {
                                try {
                                    outputStream3.close();
                                    z = false;
                                } catch (IOException e7) {
                                    if (a.f1874a) {
                                        e7.printStackTrace();
                                    }
                                    z = false;
                                }
                                if (!z) {
                                }
                                if (this.d != null) {
                                }
                            }
                            z = false;
                            if (!z) {
                            }
                            if (this.d != null) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            outputStream = outputStream3;
                            if (outputStream != null) {
                            }
                            throw th;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        i = -1;
                        if (a.f1874a) {
                            e.printStackTrace();
                        }
                        this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                                z = false;
                            } catch (IOException e9) {
                                if (a.f1874a) {
                                    e9.printStackTrace();
                                }
                                z = false;
                            }
                            if (!z) {
                            }
                            if (this.d != null) {
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                        if (this.d != null) {
                        }
                    } catch (Exception e10) {
                        e = e10;
                        i = -1;
                        if (a.f1874a) {
                            e.printStackTrace();
                        }
                        this.d = ErrorMessage.a(-11, "httpsPost failed,Exception:" + e.getMessage());
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                                z = false;
                            } catch (IOException e11) {
                                if (a.f1874a) {
                                    e11.printStackTrace();
                                }
                                z = false;
                            }
                            if (!z) {
                            }
                            if (this.d != null) {
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                        if (this.d != null) {
                        }
                    }
                } catch (MalformedURLException e12) {
                    e = e12;
                    outputStream3 = outputStream2;
                    if (a.f1874a) {
                    }
                    this.d = ErrorMessage.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
                    if (outputStream3 != null) {
                    }
                    z = false;
                    if (!z) {
                    }
                    if (this.d != null) {
                    }
                } catch (IOException e13) {
                    e = e13;
                    if (a.f1874a) {
                    }
                    this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                    if (outputStream2 != null) {
                    }
                    z = false;
                    if (!z) {
                    }
                    if (this.d != null) {
                    }
                } catch (Exception e14) {
                    e = e14;
                    if (a.f1874a) {
                    }
                    this.d = ErrorMessage.a(-11, "httpsPost failed,Exception:" + e.getMessage());
                    if (outputStream2 != null) {
                    }
                    z = false;
                    if (!z) {
                    }
                    if (this.d != null) {
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e15) {
                        if (a.f1874a) {
                            e15.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        } catch (MalformedURLException e16) {
            e = e16;
            i = -1;
        } catch (IOException e17) {
            e = e17;
            i = -1;
            outputStream2 = null;
        } catch (Exception e18) {
            e = e18;
            i = -1;
            outputStream2 = null;
        } catch (Throwable th7) {
            th = th7;
            outputStream = null;
            if (outputStream != null) {
            }
            throw th;
        }
        if (!z && 200 != i) {
            a.a("httpsPost failed,statusCode:" + i);
            this.d = ErrorMessage.a(-11, "httpsPost failed,statusCode:" + i);
        } else if (this.d != null) {
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
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            z2 = z;
        }
        return sb.toString();
    }

    private HttpsURLConnection b() {
        try {
            URL url = new URL(this.b);
            a.a("https URL: " + this.b);
            String a2 = a(this.f1879a);
            if (a2 == null || a2.equals("")) {
                a.c("Current network is not available.");
                this.d = ErrorMessage.a(-10, "Current network is not available.");
                return null;
            }
            a.a("checkNetwork = " + a2);
            HttpsURLConnection httpsURLConnection = a2.equals("cmwap") ? (HttpsURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80))) : a2.equals("ctwap") ? (HttpsURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setHostnameVerifier(new h(this));
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setConnectTimeout(IMConstants.ERROR_BASE);
            httpsURLConnection.setReadTimeout(IMConstants.ERROR_BASE);
            return httpsURLConnection;
        } catch (MalformedURLException e) {
            if (a.f1874a) {
                e.printStackTrace();
                a.a(e.getMessage());
            }
            this.d = ErrorMessage.a(-11, "Auth server could not be parsed as a URL.");
            return null;
        } catch (Exception e2) {
            if (a.f1874a) {
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
        a.a("checkNetwork start");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f1879a.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    a.a("checkNetwork end");
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            if (a.f1874a) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
