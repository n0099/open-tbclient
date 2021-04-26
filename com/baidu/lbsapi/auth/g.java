package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.imsdk.IMConstants;
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
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f6552a;

    /* renamed from: b  reason: collision with root package name */
    public String f6553b = null;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f6554c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f6555d = null;

    public g(Context context) {
        this.f6552a = context;
    }

    private String a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                return (extraInfo == null || !(extraInfo.trim().toLowerCase().equals(ConectivityUtils.APN_CMWAP) || extraInfo.trim().toLowerCase().equals(ConectivityUtils.APN_UNIWAP) || extraInfo.trim().toLowerCase().equals(ConectivityUtils.APN_3GWAP) || extraInfo.trim().toLowerCase().equals(ConectivityUtils.APN_CTWAP))) ? "wifi" : extraInfo.trim().toLowerCase().equals(ConectivityUtils.APN_CTWAP) ? ConectivityUtils.APN_CTWAP : ConectivityUtils.APN_CMWAP;
            }
            return null;
        } catch (Exception e2) {
            if (a.f6542a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0192, code lost:
        if (com.baidu.lbsapi.auth.a.f6542a == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01c2, code lost:
        if (com.baidu.lbsapi.auth.a.f6542a == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0161, code lost:
        if (com.baidu.lbsapi.auth.a.f6542a == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0163, code lost:
        r14.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x016d A[Catch: all -> 0x0131, TryCatch #12 {all -> 0x0131, blocks: (B:7:0x002f, B:88:0x0136, B:90:0x013a, B:91:0x013d, B:101:0x0169, B:103:0x016d, B:104:0x0170, B:114:0x0197, B:116:0x019b, B:117:0x019e), top: B:148:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x019b A[Catch: all -> 0x0131, TryCatch #12 {all -> 0x0131, blocks: (B:7:0x002f, B:88:0x0136, B:90:0x013a, B:91:0x013d, B:101:0x0169, B:103:0x016d, B:104:0x0170, B:114:0x0197, B:116:0x019b, B:117:0x019e), top: B:148:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4 A[Catch: all -> 0x0109, TryCatch #5 {all -> 0x0109, blocks: (B:45:0x00b0, B:47:0x00b4, B:48:0x00cf), top: B:144:0x00b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f4 A[Catch: Exception -> 0x011a, IOException -> 0x011d, MalformedURLException -> 0x0120, all -> 0x0124, TRY_LEAVE, TryCatch #2 {all -> 0x0124, blocks: (B:8:0x0033, B:66:0x010e, B:68:0x0116, B:69:0x0119, B:51:0x00ec, B:53:0x00f4, B:31:0x0095, B:33:0x009d), top: B:143:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0116 A[Catch: Exception -> 0x011a, IOException -> 0x011d, MalformedURLException -> 0x0120, all -> 0x0124, TryCatch #2 {all -> 0x0124, blocks: (B:8:0x0033, B:66:0x010e, B:68:0x0116, B:69:0x0119, B:51:0x00ec, B:53:0x00f4, B:31:0x0095, B:33:0x009d), top: B:143:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013a A[Catch: all -> 0x0131, TryCatch #12 {all -> 0x0131, blocks: (B:7:0x002f, B:88:0x0136, B:90:0x013a, B:91:0x013d, B:101:0x0169, B:103:0x016d, B:104:0x0170, B:114:0x0197, B:116:0x019b, B:117:0x019e), top: B:148:0x002f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HttpsURLConnection httpsURLConnection) {
        int i2;
        OutputStream outputStream;
        BufferedReader bufferedReader;
        a.a("https Post start,url:" + this.f6553b);
        if (this.f6554c == null) {
            this.f6555d = ErrorMessage.a("httpsPost request paramters is null.");
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
                    bufferedWriter.write(b(this.f6554c));
                    a.a(b(this.f6554c));
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
                                        this.f6555d = stringBuffer.toString();
                                        bufferedReader2 = bufferedReader;
                                    } catch (IOException e5) {
                                        e = e5;
                                        inputStream = inputStream2;
                                        try {
                                            if (a.f6542a) {
                                            }
                                            this.f6555d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
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
                                            if (this.f6555d == null) {
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
                            if (a.f6542a) {
                                e.printStackTrace();
                                a.a("httpsPost parse failed;" + e.getMessage());
                            }
                            this.f6555d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
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
                            if (this.f6555d == null) {
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
                            if (a.f6542a) {
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
                            if (a.f6542a) {
                                e10.printStackTrace();
                            }
                        }
                    }
                    throw th;
                }
            } catch (MalformedURLException e11) {
                e = e11;
                outputStream4 = outputStream;
                if (a.f6542a) {
                    e.printStackTrace();
                }
                this.f6555d = ErrorMessage.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
                if (outputStream4 != null) {
                    try {
                        outputStream4.close();
                    } catch (IOException e12) {
                        e = e12;
                    }
                }
                if (z2) {
                }
                if (this.f6555d == null) {
                }
            } catch (IOException e13) {
                e = e13;
                outputStream5 = outputStream;
                if (a.f6542a) {
                    e.printStackTrace();
                }
                this.f6555d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                if (outputStream5 != null) {
                    try {
                        outputStream5.close();
                    } catch (IOException e14) {
                        e = e14;
                    }
                }
                if (z2) {
                }
                if (this.f6555d == null) {
                }
            } catch (Exception e15) {
                e = e15;
                outputStream2 = outputStream;
                if (a.f6542a) {
                    e.printStackTrace();
                }
                this.f6555d = ErrorMessage.a(-11, "httpsPost failed,Exception:" + e.getMessage());
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e16) {
                        e = e16;
                    }
                }
                if (z2) {
                }
                if (this.f6555d == null) {
                }
            }
        } catch (MalformedURLException e17) {
            e = e17;
            outputStream4 = outputStream;
            i2 = -1;
            if (a.f6542a) {
            }
            this.f6555d = ErrorMessage.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
            if (outputStream4 != null) {
            }
            if (z2) {
            }
            if (this.f6555d == null) {
            }
        } catch (IOException e18) {
            e = e18;
            outputStream5 = outputStream;
            i2 = -1;
            if (a.f6542a) {
            }
            this.f6555d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
            if (outputStream5 != null) {
            }
            if (z2) {
            }
            if (this.f6555d == null) {
            }
        } catch (Exception e19) {
            e = e19;
            outputStream2 = outputStream;
            i2 = -1;
            if (a.f6542a) {
            }
            this.f6555d = ErrorMessage.a(-11, "httpsPost failed,Exception:" + e.getMessage());
            if (outputStream2 != null) {
            }
            if (z2) {
            }
            if (this.f6555d == null) {
            }
        }
        if (z2 || 200 == i2) {
            if (this.f6555d == null) {
                a.a("httpsPost failed,mResult is null");
                this.f6555d = ErrorMessage.a(-1, "httpsPost failed,internal error");
                return;
            }
            a.a("httpsPost success end,parse result = " + this.f6555d);
            return;
        }
        a.a("httpsPost failed,statusCode:" + i2);
        this.f6555d = ErrorMessage.a(-11, "httpsPost failed,statusCode:" + i2);
    }

    public static String b(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
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

    private HttpsURLConnection b() {
        String str;
        try {
            URL url = new URL(this.f6553b);
            a.a("https URL: " + this.f6553b);
            String a2 = a(this.f6552a);
            if (a2 != null && !a2.equals("")) {
                a.a("checkNetwork = " + a2);
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) (a2.equals(ConectivityUtils.APN_CMWAP) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80))) : a2.equals(ConectivityUtils.APN_CTWAP) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection());
                httpsURLConnection.setHostnameVerifier(new h(this));
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setConnectTimeout(IMConstants.ERROR_BASE);
                httpsURLConnection.setReadTimeout(IMConstants.ERROR_BASE);
                return httpsURLConnection;
            }
            a.c("Current network is not available.");
            this.f6555d = ErrorMessage.a(-10, "Current network is not available.");
            return null;
        } catch (MalformedURLException e2) {
            if (a.f6542a) {
                e2.printStackTrace();
                a.a(e2.getMessage());
            }
            str = "Auth server could not be parsed as a URL.";
            this.f6555d = ErrorMessage.a(-11, str);
            return null;
        } catch (Exception e3) {
            if (a.f6542a) {
                e3.printStackTrace();
                a.a(e3.getMessage());
            }
            str = "Init httpsurlconnection failed.";
            this.f6555d = ErrorMessage.a(-11, str);
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

    public String a(HashMap<String, String> hashMap) {
        HashMap<String, String> c2 = c(hashMap);
        this.f6554c = c2;
        this.f6553b = c2.get("url");
        HttpsURLConnection b2 = b();
        if (b2 == null) {
            a.c("syncConnect failed,httpsURLConnection is null");
        } else {
            a(b2);
        }
        return this.f6555d;
    }

    public boolean a() {
        NetworkInfo activeNetworkInfo;
        a.a("checkNetwork start");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f6552a.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            if (activeNetworkInfo.isAvailable()) {
                a.a("checkNetwork end");
                return true;
            }
            return false;
        } catch (Exception e2) {
            if (a.f6542a) {
                e2.printStackTrace();
            }
            return false;
        }
    }
}
