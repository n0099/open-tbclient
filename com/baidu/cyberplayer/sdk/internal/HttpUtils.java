package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.loginshare.e;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpUtils {
    public static final String HEADER_NAME_CMWAP_ONLINE_HOST = "X-Online-Host";
    public static final String HEADER_NAME_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_NAME_CONTENT_LENGTH = "Content-Length";
    public static final String HEADER_NAME_CONTENT_MD5 = "Content-MD5";
    public static final String HEADER_NAME_COOKIE = "Cookie";
    public static final String HEADER_NAME_LOCATION = "Location";
    public static final String HEADER_NAME_REFERER = "Referer";
    public static final String HEADER_NAME_SET_COOKIE = "Set-Cookie";
    public static final String HEADER_NAME_USER_AGENT = "User-Agent";
    public static final String IP_CMWAP = "10.0.0.172";
    public static final String IP_CTWAP = "10.0.0.200";

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f732a = Uri.parse("content://telephony/carriers/preferapn");

    /* renamed from: a  reason: collision with other field name */
    private OnNetListener f9a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f12a;

    /* renamed from: b  reason: collision with other field name */
    private String f13b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f15b;

    /* renamed from: c  reason: collision with other field name */
    private String f16c;

    /* renamed from: a  reason: collision with other field name */
    private final String f10a = "HTTP";

    /* renamed from: a  reason: collision with other field name */
    private NetPostClient f8a = null;

    /* renamed from: a  reason: collision with other field name */
    private int f7a = -1;
    private int b = -1;

    /* renamed from: a  reason: collision with other field name */
    private Map f11a = new HashMap();

    /* renamed from: b  reason: collision with other field name */
    private Map f14b = new HashMap();
    private int c = 5;
    private int d = 0;

    /* renamed from: c  reason: collision with other field name */
    private boolean f17c = false;

    /* loaded from: classes.dex */
    public interface NetPostClient {
        int getDataLen();

        int getPostData(byte[] bArr);

        void onSendStart();
    }

    /* loaded from: classes.dex */
    public interface OnNetListener {
        boolean onConnShutdown();

        boolean onConnStart();

        boolean onReceivedData(byte[] bArr, int i, int i2);

        boolean onReceivedHeaders(Map map);

        boolean onResponseCode(int i);
    }

    public HttpUtils(Context context, String str, OnNetListener onNetListener) {
        this.f9a = null;
        this.f16c = str;
        this.f9a = onNetListener;
        a(context);
    }

    public boolean upload(NetPostClient netPostClient) {
        this.f8a = netPostClient;
        return operate(0);
    }

    public boolean download() {
        return operate(1);
    }

    public boolean operate(int i) {
        HttpURLConnection a2;
        boolean onConnShutdown;
        if (this.f16c == null) {
            return false;
        }
        boolean z = false;
        do {
            a();
            a2 = a(i);
            if (a2 == null) {
                LogUtils.d("HTTP", "Cannot create connection", new Object[0]);
            } else {
                z = a(a2);
                if (!z) {
                    LogUtils.d("HTTP", "Cannot connect", new Object[0]);
                } else if (i == 0 && !(z = b(a2))) {
                    LogUtils.d("HTTP", "Cannot post data", new Object[0]);
                } else {
                    try {
                        int responseCode = a2.getResponseCode();
                        z = m2a(responseCode);
                        if (!z && !isRedirectCode(responseCode)) {
                            LogUtils.d("HTTP", "Response code error", new Object[0]);
                        } else {
                            z = b(a2, responseCode);
                            if (!z) {
                                LogUtils.d("HTTP", "Response header error", new Object[0]);
                            } else {
                                z = a(a2, responseCode);
                                if (!z) {
                                    LogUtils.d("HTTP", "Fail to get data", new Object[0]);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        z = false;
                    }
                }
            }
        } while (this.f17c);
        if (a2 != null) {
            try {
                a2.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f9a != null && !(onConnShutdown = this.f9a.onConnShutdown())) {
            LogUtils.d("HTTP", "Error happens while shutting down connection", new Object[0]);
            z = onConnShutdown;
        }
        return z;
    }

    private void a() {
        this.f17c = false;
    }

    private HttpURLConnection a(int i) {
        HttpURLConnection httpURLConnection;
        if (this.f16c == null) {
            return null;
        }
        try {
            if (this.f12a && this.f13b != null) {
                if (this.f13b.startsWith(IP_CTWAP)) {
                    httpURLConnection = (HttpURLConnection) new URL(this.f16c).openConnection();
                } else {
                    URL url = new URL(this.f16c);
                    httpURLConnection = (HttpURLConnection) a(url).openConnection();
                    if (url.getPort() > 0) {
                        httpURLConnection.setRequestProperty(HEADER_NAME_CMWAP_ONLINE_HOST, url.getHost() + ":" + url.getPort());
                    } else {
                        httpURLConnection.setRequestProperty(HEADER_NAME_CMWAP_ONLINE_HOST, url.getHost());
                    }
                }
            } else {
                httpURLConnection = (HttpURLConnection) new URL(this.f16c).openConnection();
            }
            if (this.f7a > 0) {
                httpURLConnection.setConnectTimeout(this.f7a);
            }
            if (this.b > 0) {
                httpURLConnection.setReadTimeout(this.b);
            }
            httpURLConnection.setInstanceFollowRedirects(this.f15b);
            addHeaders(httpURLConnection);
            if (i == 0) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                if (this.f8a == null) {
                    throw new RuntimeException();
                }
                httpURLConnection.setRequestProperty(HEADER_NAME_CONTENT_LENGTH, "" + this.f8a.getDataLen());
                return httpURLConnection;
            }
            return httpURLConnection;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private URL a(URL url) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(e.f);
            stringBuffer.append("10.0.0.172:80");
            String file = url.getFile();
            if (!TextUtils.isEmpty(file)) {
                stringBuffer.append(file);
            }
            String ref = url.getRef();
            if (!TextUtils.isEmpty(ref)) {
                stringBuffer.append("#");
                stringBuffer.append(ref);
            }
            URL url2 = new URL(stringBuffer.toString());
            if (url2 == null) {
                try {
                    new URL("http://10.0.0.172");
                } catch (Exception e) {
                }
            }
            return url2;
        } catch (Exception e2) {
            if (0 != 0) {
                return null;
            }
            try {
                return new URL("http://10.0.0.172");
            } catch (Exception e3) {
                return url;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                try {
                    new URL("http://10.0.0.172");
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    private boolean a(HttpURLConnection httpURLConnection) {
        if (this.f9a == null || this.f9a.onConnStart()) {
            try {
                httpURLConnection.connect();
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private boolean b(HttpURLConnection httpURLConnection) {
        DataOutputStream dataOutputStream;
        boolean z = false;
        if (this.f8a != null) {
            try {
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            } catch (Throwable th) {
                th = th;
                dataOutputStream = null;
            }
            try {
                byte[] bArr = new byte[LVBuffer.LENGTH_ALLOC_PER_NEW];
                int dataLen = this.f8a.getDataLen();
                this.f8a.onSendStart();
                int i = 0;
                while (i < dataLen) {
                    int postData = this.f8a.getPostData(bArr);
                    if (postData <= 0) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, postData);
                    i += postData;
                }
                dataOutputStream.flush();
                z = true;
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    return z;
                } finally {
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                }
            }
        }
        return z;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [477=6, 478=4] */
    private boolean a(java.net.HttpURLConnection r10, int r11) {
        /*
            r9 = this;
            r2 = 0
            r1 = 1
            r0 = 0
            r3 = 200(0xc8, float:2.8E-43)
            if (r11 == r3) goto Lc
            r3 = 206(0xce, float:2.89E-43)
            if (r11 == r3) goto Lc
        Lb:
            return r0
        Lc:
            java.lang.String r3 = "Content-Encoding"
            java.lang.String r3 = r10.getHeaderField(r3)     // Catch: java.lang.Throwable -> L59
            if (r3 == 0) goto L9d
            java.lang.String r4 = "gzip"
            int r3 = r3.indexOf(r4)     // Catch: java.lang.Throwable -> L59
            if (r3 < 0) goto L9d
            r4 = r1
        L1d:
            java.io.InputStream r3 = r10.getInputStream()     // Catch: java.lang.Throwable -> L59
            if (r4 == 0) goto L52
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L91
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L91
            r2 = r4
        L29:
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L96
        L2d:
            int r6 = r4.read(r5)     // Catch: java.lang.Throwable -> L96
            r7 = -1
            if (r6 == r7) goto L9b
            com.baidu.cyberplayer.sdk.internal.HttpUtils$OnNetListener r7 = r9.f9a     // Catch: java.lang.Throwable -> L96
            if (r7 == 0) goto L2d
            com.baidu.cyberplayer.sdk.internal.HttpUtils$OnNetListener r1 = r9.f9a     // Catch: java.lang.Throwable -> L96
            r7 = 0
            boolean r1 = r1.onReceivedData(r5, r7, r6)     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L2d
            r0 = r1
        L42:
            if (r2 == 0) goto L47
            r2.close()     // Catch: java.lang.Throwable -> L54
        L47:
            if (r3 == 0) goto Lb
            r3.close()     // Catch: java.lang.Throwable -> L4d
            goto Lb
        L4d:
            r1 = move-exception
            r1.printStackTrace()
            goto Lb
        L52:
            r4 = r3
            goto L29
        L54:
            r1 = move-exception
            r1.printStackTrace()
            goto L47
        L59:
            r1 = move-exception
            r3 = r2
        L5b:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L8c
            if (r3 == 0) goto L63
            r3.close()     // Catch: java.lang.Throwable -> L6e
        L63:
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L69
            goto Lb
        L69:
            r1 = move-exception
            r1.printStackTrace()
            goto Lb
        L6e:
            r1 = move-exception
            r1.printStackTrace()
            goto L63
        L73:
            r0 = move-exception
            r3 = r2
        L75:
            if (r2 == 0) goto L7a
            r2.close()     // Catch: java.lang.Throwable -> L80
        L7a:
            if (r3 == 0) goto L7f
            r3.close()     // Catch: java.lang.Throwable -> L85
        L7f:
            throw r0
        L80:
            r1 = move-exception
            r1.printStackTrace()
            goto L7a
        L85:
            r1 = move-exception
            r1.printStackTrace()
            goto L7f
        L8a:
            r0 = move-exception
            goto L75
        L8c:
            r0 = move-exception
            r8 = r2
            r2 = r3
            r3 = r8
            goto L75
        L91:
            r1 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
            goto L5b
        L96:
            r1 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
            goto L5b
        L9b:
            r0 = r1
            goto L42
        L9d:
            r4 = r0
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.cyberplayer.sdk.internal.HttpUtils.a(java.net.HttpURLConnection, int):boolean");
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m2a(int i) {
        if (this.f9a == null) {
            return true;
        }
        return this.f9a.onResponseCode(i);
    }

    public static boolean isRedirectCode(int i) {
        return i == 301 || i == 302 || i == 303 || i == 307;
    }

    private boolean b(HttpURLConnection httpURLConnection, int i) {
        String headerField;
        boolean z = true;
        if (isRedirectCode(i) && this.d < this.c && (headerField = httpURLConnection.getHeaderField(HEADER_NAME_LOCATION)) != null) {
            String headerField2 = httpURLConnection.getHeaderField(HEADER_NAME_SET_COOKIE);
            if (headerField2 != null) {
                addCookies(headerField2);
            }
            try {
                this.f16c = new URI(this.f16c).resolve(new URI(headerField)).toString();
                this.f17c = true;
                z = false;
            } catch (URISyntaxException e) {
            }
            this.d++;
        }
        if (z && this.f9a != null) {
            return this.f9a.onReceivedHeaders(httpURLConnection.getHeaderFields());
        }
        return z;
    }

    public void addCookies(String str) {
        try {
            for (String str2 : str.split(";")) {
                String[] split = str2.split("=");
                if (split.length >= 2) {
                    this.f14b.put(split[0], split[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addHeaders(HttpURLConnection httpURLConnection) {
        if (this.f11a != null && this.f11a.size() > 0) {
            for (Map.Entry entry : this.f11a.entrySet()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (this.f14b != null && this.f14b.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry2 : this.f14b.entrySet()) {
                sb.append(((String) entry2.getKey()).trim());
                sb.append("=");
                sb.append(((String) entry2.getValue()).trim());
                sb.append(";");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                httpURLConnection.addRequestProperty(HEADER_NAME_COOKIE, sb.toString());
            }
        }
    }

    public static String[] getHostPath(String str) {
        String substring;
        String str2;
        int indexOf = str.indexOf(47, e.f.length());
        if (indexOf < 0) {
            indexOf = str.indexOf(63);
        }
        if (indexOf > 0) {
            String substring2 = str.substring(e.f.length(), indexOf);
            if (indexOf >= str.length() - 1) {
                str2 = "/";
                substring = substring2;
            } else {
                str2 = str.substring(indexOf);
                substring = substring2;
            }
        } else {
            substring = str.substring(e.f.length());
            str2 = "/";
        }
        return new String[]{substring, str2};
    }

    private void a(Context context) {
        NetworkInfo activeNetworkInfo;
        Cursor query;
        if (context != null && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.getExtraInfo() != null) {
            String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
            if (lowerCase != null) {
                if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                    this.f12a = true;
                    this.f13b = "10.0.0.172:80";
                    return;
                } else if (lowerCase.startsWith("ctwap")) {
                    this.f12a = true;
                    this.f13b = "10.0.0.200:80";
                } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                    this.f12a = false;
                    return;
                }
            }
            if (VersionUtils.getCurrentVersion() <= 16 && (query = context.getContentResolver().query(f732a, new String[]{"_id", "apn", "proxy", "user"}, null, null, null)) != null) {
                query.moveToFirst();
                query.getCount();
                if (!query.isAfterLast()) {
                    String string = query.getString(1);
                    String string2 = query.getString(2);
                    String string3 = query.getString(3);
                    if (string2 != null && string2.length() > 0) {
                        if ("10.0.0.172".equals(string2.trim())) {
                            this.f12a = true;
                            this.f13b = "10.0.0.172:80";
                        } else if (IP_CTWAP.equals(string2.trim())) {
                            this.f12a = true;
                            this.f13b = "10.0.0.200:80";
                        } else {
                            this.f12a = false;
                        }
                    } else if (string != null && string.length() > 0) {
                        String upperCase = string.toUpperCase();
                        if (upperCase.equals("CMWAP") || upperCase.equals("UNIWAP") || upperCase.equals("3GWAP")) {
                            this.f12a = true;
                            this.f13b = "10.0.0.172:80";
                        } else if (upperCase.equals("CTWAP")) {
                            this.f12a = true;
                            this.f13b = "10.0.0.200:80";
                        } else if (string3 != null) {
                            if (string3.toUpperCase().startsWith("CMWAP")) {
                                this.f12a = true;
                            } else {
                                this.f12a = false;
                            }
                        } else {
                            this.f12a = false;
                        }
                    } else {
                        this.f12a = false;
                    }
                }
                if (query != null) {
                    query.close();
                }
            }
        }
    }

    public void setConnTimeOut(int i) {
        this.f7a = i;
    }

    public void setReadTimeOut(int i) {
        this.b = i;
    }

    public void setHeaders(Map map) {
        this.f11a = map;
    }

    public void enableRedirect(boolean z) {
        this.f15b = z;
    }

    public void addHeader(String str, String str2) {
        if (this.f11a != null && str != null && str2 != null) {
            this.f11a.put(str, str2);
        }
    }

    public static boolean isHeaderEqueal(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.toUpperCase().equals(str2.toUpperCase());
    }
}
