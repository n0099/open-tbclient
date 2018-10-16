package com.baidu.d.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.sapi2.base.network.Apn;
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
/* loaded from: classes6.dex */
public class g {
    private Context a;
    private String b = null;
    private HashMap<String, String> c = null;
    private String d = null;

    public g(Context context) {
        this.a = context;
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
            return (extraInfo == null || !(extraInfo.trim().toLowerCase().equals(Apn.APN_CMWAP) || extraInfo.trim().toLowerCase().equals(Apn.APN_UNIWAP) || extraInfo.trim().toLowerCase().equals(Apn.APN_3GWAP) || extraInfo.trim().toLowerCase().equals(Apn.APN_CTWAP))) ? "wifi" : extraInfo.trim().toLowerCase().equals(Apn.APN_CTWAP) ? Apn.APN_CTWAP : Apn.APN_CMWAP;
        } catch (Exception e) {
            if (b.a) {
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
        b.a("https Post start,url:" + this.b);
        if (this.c == null) {
            this.d = d.a("httpsPost request paramters is null.");
            return;
        }
        boolean z = true;
        try {
            try {
                outputStream2 = httpsURLConnection.getOutputStream();
                try {
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream2, "UTF-8"));
                        bufferedWriter.write(j(this.c));
                        b.a(j(this.c));
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
                                            if (b.a) {
                                                e.printStackTrace();
                                                b.a("httpsPost parse failed;" + e.getMessage());
                                            }
                                            this.d = d.a(-11, "httpsPost failed,IOException:" + e.getMessage());
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
                                            if (b.a) {
                                                e.printStackTrace();
                                            }
                                            this.d = d.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
                                            if (outputStream3 != null) {
                                                try {
                                                    outputStream3.close();
                                                    z = false;
                                                } catch (IOException e4) {
                                                    if (b.a) {
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
                                        if (b.a) {
                                            e.printStackTrace();
                                        }
                                        this.d = d.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                                        if (outputStream2 != null) {
                                            try {
                                                outputStream2.close();
                                                z = false;
                                            } catch (IOException e6) {
                                                if (b.a) {
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
                                        if (b.a) {
                                            e.printStackTrace();
                                        }
                                        this.d = d.a(-11, "httpsPost failed,Exception:" + e.getMessage());
                                        if (outputStream2 != null) {
                                            try {
                                                outputStream2.close();
                                                z = false;
                                            } catch (IOException e8) {
                                                if (b.a) {
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
                                if (b.a) {
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
                        if (b.a) {
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
            b.a("httpsPost failed,statusCode:" + i);
            this.d = d.a(-11, "httpsPost failed,statusCode:" + i);
        } else if (this.d == null) {
            b.a("httpsPost success end,parse result = " + this.d);
        } else {
            b.a("httpsPost failed,mResult is null");
            this.d = d.a(-1, "httpsPost failed,internal error");
        }
    }

    private static String j(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
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

    private HashMap<String, String> o(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        for (String str : hashMap.keySet()) {
            String str2 = str.toString();
            hashMap2.put(str2, hashMap.get(str2));
        }
        return hashMap2;
    }

    private HttpsURLConnection tf() {
        try {
            URL url = new URL(this.b);
            b.a("https URL: " + this.b);
            String a = a(this.a);
            if (a == null || a.equals("")) {
                b.c("Current network is not available.");
                this.d = d.a(-10, "Current network is not available.");
                return null;
            }
            b.a("checkNetwork = " + a);
            HttpsURLConnection httpsURLConnection = a.equals(Apn.APN_CMWAP) ? (HttpsURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80))) : a.equals(Apn.APN_CTWAP) ? (HttpsURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setConnectTimeout(50000);
            httpsURLConnection.setReadTimeout(50000);
            return httpsURLConnection;
        } catch (MalformedURLException e) {
            if (b.a) {
                e.printStackTrace();
                b.a(e.getMessage());
            }
            this.d = d.a(-11, "Auth server could not be parsed as a URL.");
            return null;
        } catch (Exception e2) {
            if (b.a) {
                e2.printStackTrace();
                b.a(e2.getMessage());
            }
            this.d = d.a(-11, "Init httpsurlconnection failed.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(HashMap<String, String> hashMap) {
        this.c = o(hashMap);
        this.b = this.c.get("url");
        HttpsURLConnection tf = tf();
        if (tf == null) {
            b.c("syncConnect failed,httpsURLConnection is null");
            return this.d;
        }
        a(tf);
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        b.a("checkNetwork start");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    b.a("checkNetwork end");
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            if (b.a) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
