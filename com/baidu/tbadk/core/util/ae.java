package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.http.message.BasicNameValuePair;
@Deprecated
/* loaded from: classes.dex */
public class ae implements v {
    private volatile boolean IA;
    private final com.baidu.tbadk.core.util.httpNet.c Iq;
    private int Iy;
    private boolean Iz;
    private HttpURLConnection kc;
    private Context mContext;
    private int mDataSize = 0;
    private static String kN = "\r\n";
    private static String kO = "--";
    private static String boundary = "--------7da3d81520810*";
    private static int Iv = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private static Handler mHandler = null;
    private static volatile String Iw = null;
    private static volatile boolean Ix = false;
    private static Pattern kg = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);

    public ae(com.baidu.tbadk.core.util.httpNet.c cVar) {
        oV();
        this.Iq = cVar;
        this.mContext = TbadkCoreApplication.m255getInst().getApp();
    }

    private int getMode(int i) {
        switch (i) {
            case 1:
            default:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
        }
    }

    private void oV() {
        this.kc = null;
        this.mContext = null;
        this.Iy = 0;
        this.IA = false;
        this.Iz = false;
        pd();
    }

    public static void pd() {
        synchronized (ae.class) {
            if (!Ix) {
                Ix = true;
                pe();
            }
        }
    }

    public static synchronized void pe() {
        synchronized (ae.class) {
            try {
                Cursor query = TbadkCoreApplication.m255getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    Iw = "Basic " + ba.base64Encode((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public static void pf() {
        System.setProperty("http.keepAlive", "false");
        mHandler = new af();
    }

    public String getUrl() {
        return this.Iq.pV().pY().mUrl;
    }

    @Override // com.baidu.tbadk.core.util.v
    public boolean ou() {
        return this.IA;
    }

    @Override // com.baidu.tbadk.core.util.v
    public void dL() {
        this.IA = true;
        try {
            if (this.kc != null) {
                this.kc.disconnect();
                try {
                    int cC = al.cC(getUrl());
                    if (cC > 0) {
                        al.pl().o(cC, 1);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        } catch (Exception e2) {
        }
    }

    private HttpURLConnection a(URL url) {
        String fp;
        HttpURLConnection httpURLConnection = null;
        this.Iz = false;
        if (com.baidu.adp.lib.util.i.fg()) {
            if (com.baidu.adp.lib.util.i.fh() && (fp = com.baidu.adp.lib.util.i.fp()) != null && fp.length() > 0) {
                if (cA(fp)) {
                    this.Iz = true;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("http://");
                    sb.append(fp);
                    String file = url.getFile();
                    if (file != null && file.startsWith("?")) {
                        sb.append("/");
                    }
                    sb.append(file);
                    httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                    httpURLConnection.setRequestProperty("X-Online-Host", url.getHost());
                    httpURLConnection.setRequestProperty("User-Agent", "bdtb for Android " + TbConfig.getVersion());
                    if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                        httpURLConnection.setRequestProperty("client_user_token", TbadkCoreApplication.getCurrentAccount());
                    }
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(fp, com.baidu.adp.lib.util.i.fq())));
                    if (Iw != null) {
                        httpURLConnection.setRequestProperty("Proxy-Authorization", Iw);
                    }
                    httpURLConnection.setRequestProperty("User-Agent", "bdtb for Android " + TbConfig.getVersion());
                    if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                        httpURLConnection.setRequestProperty("client_user_token", TbadkCoreApplication.getCurrentAccount());
                    }
                }
            }
            if (httpURLConnection == null) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            if (this.Iq != null) {
                if (!TextUtils.isEmpty(this.Iq.pV().pY().Kf)) {
                    httpURLConnection.setRequestProperty("sid", this.Iq.pV().pY().Kf);
                }
                if (!TextUtils.isEmpty(this.Iq.pV().pY().mNetType)) {
                    httpURLConnection.setRequestProperty("net", this.Iq.pV().pY().mNetType);
                }
            }
            com.baidu.tbadk.coreExtra.a.a.rr().g(httpURLConnection);
        }
        return httpURLConnection;
    }

    private boolean cA(String str) {
        if (kg.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [667=12, 668=12, 669=12, 674=12, 675=12] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:140:0x04f6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:177:0x05b6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:212:0x0753 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:221:0x07f6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:253:0x084b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:257:0x0851 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:323:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:343:0x0262 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x01c1 */
    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: com.baidu.tbadk.core.util.ae */
    /* JADX DEBUG: Multi-variable search result rejected for r4v14, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r9v3, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r9v4, resolved type: long */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02a2, code lost:
        if (r17.Iq.pV().mIsFromCDN != false) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:180:0x062d A[Catch: all -> 0x07f9, TRY_LEAVE, TryCatch #13 {all -> 0x07f9, blocks: (B:43:0x01a9, B:45:0x01b9, B:46:0x01c0, B:58:0x0266, B:60:0x0288, B:64:0x02a4, B:65:0x02af, B:76:0x02dd, B:78:0x0346, B:80:0x0394, B:90:0x03c3, B:92:0x03d3, B:94:0x03da, B:114:0x0448, B:116:0x0463, B:142:0x04f9, B:144:0x0510, B:147:0x0517, B:153:0x0548, B:155:0x054e, B:157:0x0560, B:175:0x05aa, B:158:0x056b, B:160:0x0571, B:162:0x0575, B:191:0x065d, B:164:0x057c, B:192:0x0663, B:194:0x069d, B:195:0x06a1, B:197:0x06a6, B:199:0x06ae, B:200:0x06c1, B:213:0x0754, B:178:0x05b7, B:180:0x062d, B:48:0x01c2, B:50:0x0238, B:210:0x072d, B:150:0x0529, B:152:0x0543, B:62:0x0298), top: B:296:0x01a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0647 A[Catch: Exception -> 0x082c, TRY_LEAVE, TryCatch #0 {Exception -> 0x082c, blocks: (B:181:0x0634, B:183:0x0647), top: B:270:0x0634 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0650 A[Catch: Exception -> 0x0659, TRY_LEAVE, TryCatch #11 {Exception -> 0x0659, blocks: (B:184:0x064a, B:186:0x0650), top: B:292:0x064a }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x07e4 A[Catch: Exception -> 0x0822, TRY_LEAVE, TryCatch #15 {Exception -> 0x0822, blocks: (B:214:0x07d1, B:216:0x07e4), top: B:297:0x07d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x07ed A[Catch: Exception -> 0x07f6, TRY_LEAVE, TryCatch #3 {Exception -> 0x07f6, blocks: (B:217:0x07e7, B:219:0x07ed), top: B:276:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0262 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0262 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0238 A[Catch: all -> 0x07f9, TRY_LEAVE, TryCatch #13 {all -> 0x07f9, blocks: (B:43:0x01a9, B:45:0x01b9, B:46:0x01c0, B:58:0x0266, B:60:0x0288, B:64:0x02a4, B:65:0x02af, B:76:0x02dd, B:78:0x0346, B:80:0x0394, B:90:0x03c3, B:92:0x03d3, B:94:0x03da, B:114:0x0448, B:116:0x0463, B:142:0x04f9, B:144:0x0510, B:147:0x0517, B:153:0x0548, B:155:0x054e, B:157:0x0560, B:175:0x05aa, B:158:0x056b, B:160:0x0571, B:162:0x0575, B:191:0x065d, B:164:0x057c, B:192:0x0663, B:194:0x069d, B:195:0x06a1, B:197:0x06a6, B:199:0x06ae, B:200:0x06c1, B:213:0x0754, B:178:0x05b7, B:180:0x062d, B:48:0x01c2, B:50:0x0238, B:210:0x072d, B:150:0x0529, B:152:0x0543, B:62:0x0298), top: B:296:0x01a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0252 A[Catch: Exception -> 0x083a, TRY_LEAVE, TryCatch #27 {Exception -> 0x083a, blocks: (B:51:0x023f, B:53:0x0252), top: B:313:0x023f }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x025b A[Catch: Exception -> 0x0837, TRY_LEAVE, TryCatch #2 {Exception -> 0x0837, blocks: (B:54:0x0255, B:56:0x025b), top: B:274:0x0255 }] */
    /* JADX WARN: Type inference failed for: r1v77, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r1v79, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v80, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v86, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v87 */
    /* JADX WARN: Type inference failed for: r1v88, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v89, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v14, types: [int] */
    /* JADX WARN: Type inference failed for: r7v21, types: [int] */
    /* JADX WARN: Type inference failed for: r7v22, types: [long] */
    /* JADX WARN: Type inference failed for: r7v23, types: [long] */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28, types: [long] */
    /* JADX WARN: Type inference failed for: r7v35, types: [int] */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v16, types: [long] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:170:0x059c -> B:25:0x00bb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x059e -> B:25:0x00bb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:173:0x05a7 -> B:25:0x00bb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:205:0x071f -> B:25:0x00bb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:206:0x0721 -> B:25:0x00bb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:208:0x072a -> B:25:0x00bb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:218:0x07eb -> B:25:0x00bb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:219:0x07ed -> B:25:0x00bb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:221:0x07f6 -> B:25:0x00bb). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ow() {
        String str;
        int i;
        ?? r6;
        InputStream inputStream;
        long j;
        ?? r7;
        Exception e;
        SocketTimeoutException e2;
        SocketException e3;
        int read;
        String headerField;
        StringBuilder sb;
        byte[] bArr = null;
        try {
            int cC = al.cC(this.Iq.pV().pY().mUrl);
            if (cC > 0) {
                al.pl().bQ(cC);
            }
        } catch (Exception e4) {
            BdLog.e(e4.getMessage());
        }
        try {
            if (this.Iq.pV().pY().Kv == null || this.Iq.pV().pY().Kv.size() <= 0 || this.Iq.pV().mIsFromCDN) {
                str = this.Iq.pV().pY().mUrl;
            } else {
                sb = new StringBuilder(30);
                sb.append(this.Iq.pV().pY().mUrl);
                if (this.Iq.pV().pY().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.Iq.pV().pY().mUrl.endsWith("?") && !this.Iq.pV().pY().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i2 = 0; i2 < this.Iq.pV().pY().Kv.size(); i2++) {
                    if (i2 != 0) {
                        sb.append("&");
                    }
                    sb.append(this.Iq.pV().pY().Kv.get(i2).getName());
                    sb.append("=");
                    sb.append(ba.aE(this.Iq.pV().pY().Kv.get(i2).getValue()));
                }
                str = sb.toString();
            }
            URL url = new URL(str);
            this.Iq.pX().kX.kl = str.length();
            TbConfig.getDebugSwitch();
            i = 0;
            inputStream = sb;
            r6 = url;
        } catch (Exception e5) {
            BdLog.e(e5.getMessage());
            this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + e5.getClass() + e5.getMessage();
            al.cD(this.Iq.pV().pY().mUrl);
        }
        while (true) {
            if (!this.IA && i < 5) {
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                try {
                    try {
                        this.kc = a((URL) r6);
                    } catch (Throwable th) {
                        try {
                            al.cD(this.Iq.pV().pY().mUrl);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e6) {
                        }
                        try {
                            if (this.kc != null) {
                                this.kc.disconnect();
                            }
                        } catch (Exception e7) {
                        }
                        throw th;
                    }
                } catch (SocketException e8) {
                    e3 = e8;
                    this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + i + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.Iq.pW().Ki = -12;
                    ao.IT.incrementAndGet();
                    com.baidu.tbadk.core.util.httpNet.e pW = this.Iq.pW();
                    Resources resources = this.mContext.getResources();
                    r7 = com.baidu.tieba.z.neterror;
                    pW.mErrorString = resources.getString(r7);
                    if (i == 0) {
                    }
                    try {
                        al.cD(this.Iq.pV().pY().mUrl);
                        if (inputStream != null) {
                        }
                    } catch (Exception e9) {
                    }
                    try {
                        if (this.kc == null) {
                        }
                    } catch (Exception e10) {
                    }
                    i++;
                    inputStream = inputStream;
                    r6 = r6;
                } catch (SocketTimeoutException e11) {
                    e2 = e11;
                    ao.IT.incrementAndGet();
                    this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + i + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.Iq.pW().Ki = -13;
                    com.baidu.tbadk.core.util.httpNet.e pW2 = this.Iq.pW();
                    Resources resources2 = this.mContext.getResources();
                    r7 = com.baidu.tieba.z.neterror;
                    pW2.mErrorString = resources2.getString(r7);
                    if (i == 0) {
                    }
                    try {
                        al.cD(this.Iq.pV().pY().mUrl);
                        if (inputStream != null) {
                        }
                    } catch (Exception e12) {
                    }
                    try {
                        if (this.kc == null) {
                        }
                    } catch (Exception e13) {
                    }
                    i++;
                    inputStream = inputStream;
                    r6 = r6;
                } catch (Exception e14) {
                    e = e14;
                    r7 = "|retryCount:";
                    this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + i + "|" + e.getClass() + "|" + e.getMessage();
                    this.Iq.pW().Ki = -10;
                    com.baidu.tbadk.core.util.httpNet.e pW3 = this.Iq.pW();
                    Resources resources3 = this.mContext.getResources();
                    r6 = com.baidu.tieba.z.neterror;
                    pW3.mErrorString = resources3.getString(r6);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.Iq);
                    try {
                        al.cD(this.Iq.pV().pY().mUrl);
                        if (inputStream != null) {
                        }
                    } catch (Exception e15) {
                    }
                    try {
                        if (this.kc != null) {
                        }
                    } catch (Exception e16) {
                    }
                    i = 0;
                    this.Iy = 0;
                    inputStream = inputStream;
                    r6 = r6;
                    r7 = r7;
                    j = j;
                    return bArr;
                }
                if (this.kc == null) {
                    throw new SocketException("network not available.");
                    break;
                }
                this.kc.setConnectTimeout(5000);
                this.kc.setReadTimeout(30000);
                if (!this.Iq.pV().pY().Kx || this.Iq.pV().pY().mIsBDImage) {
                    r7 = r7;
                }
                this.kc.setRequestProperty("Accept-Encoding", "gzip");
                r7 = "gzip";
                if (this.IA) {
                    try {
                        al.cD(this.Iq.pV().pY().mUrl);
                        if (0 != 0) {
                            inputStream.close();
                        }
                    } catch (Exception e17) {
                    }
                    try {
                        if (this.kc != null) {
                            this.kc.disconnect();
                        }
                    } catch (Exception e18) {
                    }
                } else {
                    r7 = new Date().getTime();
                    this.Iq.pX().kX.kr = new Date().getTime() - r7;
                    this.kc.connect();
                    com.baidu.adp.lib.network.http.d dVar = this.Iq.pX().kX;
                    j = (new Date().getTime() - r7) - this.Iq.pX().kX.kr;
                    dVar.ko = j;
                    this.Iq.pW().Ki = this.kc.getResponseCode();
                    if (this.Iq.pW().Ki != 200) {
                        this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + i;
                        ao.IT.incrementAndGet();
                        com.baidu.tbadk.core.util.httpNet.e pW4 = this.Iq.pW();
                        Resources resources4 = this.mContext.getResources();
                        r7 = com.baidu.tieba.z.neterror;
                        pW4.mErrorString = resources4.getString(r7);
                        if (i == 0) {
                            TiebaStatic.net(this.Iq);
                        }
                        try {
                            al.cD(this.Iq.pV().pY().mUrl);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e19) {
                        }
                        try {
                            if (this.kc != null) {
                                this.kc.disconnect();
                            }
                        } catch (Exception e20) {
                        }
                    } else if (!this.kc.getContentType().contains("text/vnd.wap.wml")) {
                        j = this.kc.getContentEncoding();
                        inputStream = this.kc.getInputStream();
                        if (TbadkCoreApplication.m255getInst().isMainProcess(true) && (headerField = this.kc.getHeaderField("Content-Length")) != null) {
                            try {
                                int parseInt = Integer.parseInt(headerField);
                                if (parseInt > Iv) {
                                    al.cD(this.Iq.pV().pY().mUrl);
                                    try {
                                        al.cD(this.Iq.pV().pY().mUrl);
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Exception e21) {
                                    }
                                    try {
                                        e = this.kc;
                                        if (e != 0) {
                                            e = this.kc;
                                            e.disconnect();
                                        }
                                    } catch (Exception e22) {
                                        e = e22;
                                    }
                                    bArr = null;
                                    i = e;
                                    inputStream = inputStream;
                                    r6 = r6;
                                    r7 = r7;
                                    j = j;
                                } else {
                                    int i3 = parseInt * 10;
                                    if (i3 > 0) {
                                        BdLog.isDebugMode();
                                        if (!com.baidu.tbadk.imageManager.e.vL().dq(i3)) {
                                            al.cD(this.Iq.pV().pY().mUrl);
                                            try {
                                                al.cD(this.Iq.pV().pY().mUrl);
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                            } catch (Exception e23) {
                                            }
                                            try {
                                                e = this.kc;
                                                if (e != 0) {
                                                    e = this.kc;
                                                    e.disconnect();
                                                }
                                            } catch (Exception e24) {
                                                e = e24;
                                            }
                                            bArr = null;
                                            i = e;
                                            inputStream = inputStream;
                                            r6 = r6;
                                            r7 = r7;
                                            j = j;
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                            }
                            return bArr;
                        }
                        byte[] bArr2 = new byte[1024];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        int i4 = 0;
                        String headerField2 = this.kc.getHeaderField("imgsrc");
                        boolean z = false;
                        if (headerField2 != null && headerField2.length() > 0) {
                            z = true;
                        }
                        if (this.Iq.pV().pY().mIsBDImage || z) {
                            byte[] bArr3 = new byte[23];
                            int read2 = inputStream.read(bArr3, 0, 23);
                            if (!new String(bArr3, 0, bArr3.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                                byteArrayOutputStream.write(bArr3, 0, read2);
                                i4 = 0 + read2;
                            }
                        }
                        if (this.kc != null) {
                            if ("image/gif".equalsIgnoreCase(this.kc.getHeaderField("Src-Content-Type"))) {
                                this.Iq.pW().gg = true;
                            } else {
                                this.Iq.pW().gg = false;
                            }
                        }
                        while (!this.IA && i4 < Iv && (read = inputStream.read(bArr2)) != -1) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                            i4 += read;
                        }
                        if (this.IA) {
                            try {
                                al.cD(this.Iq.pV().pY().mUrl);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Exception e25) {
                            }
                            try {
                                if (this.kc != null) {
                                    this.kc.disconnect();
                                }
                            } catch (Exception e26) {
                            }
                        } else {
                            this.mDataSize = i4;
                            r7 = new Date().getTime() - r7;
                            this.Iq.pX().kX.kp = (r7 - this.Iq.pX().kX.ko) - this.Iq.pX().kX.kr;
                            if (i4 < Iv) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                    if (j == 0 || !j.contains("gzip")) {
                                        bArr = byteArray;
                                        j = j;
                                    } else {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                        j = 1024;
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                        com.baidu.tbadk.util.d.b(byteArrayInputStream, byteArrayOutputStream2);
                                        bArr = byteArrayOutputStream2.toByteArray();
                                    }
                                } catch (SocketException e27) {
                                    bArr = byteArray;
                                    e3 = e27;
                                    this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + i + "|" + e3.getClass() + "|" + e3.getMessage();
                                    this.Iq.pW().Ki = -12;
                                    ao.IT.incrementAndGet();
                                    com.baidu.tbadk.core.util.httpNet.e pW5 = this.Iq.pW();
                                    Resources resources5 = this.mContext.getResources();
                                    r7 = com.baidu.tieba.z.neterror;
                                    pW5.mErrorString = resources5.getString(r7);
                                    if (i == 0) {
                                        TiebaStatic.net(this.Iq);
                                    }
                                    al.cD(this.Iq.pV().pY().mUrl);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (this.kc == null) {
                                        this.kc.disconnect();
                                    }
                                    i++;
                                    inputStream = inputStream;
                                    r6 = r6;
                                } catch (SocketTimeoutException e28) {
                                    bArr = byteArray;
                                    e2 = e28;
                                    ao.IT.incrementAndGet();
                                    this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + i + "|" + e2.getClass() + "|" + e2.getMessage();
                                    this.Iq.pW().Ki = -13;
                                    com.baidu.tbadk.core.util.httpNet.e pW22 = this.Iq.pW();
                                    Resources resources22 = this.mContext.getResources();
                                    r7 = com.baidu.tieba.z.neterror;
                                    pW22.mErrorString = resources22.getString(r7);
                                    if (i == 0) {
                                        TiebaStatic.net(this.Iq);
                                    }
                                    al.cD(this.Iq.pV().pY().mUrl);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (this.kc == null) {
                                        this.kc.disconnect();
                                    }
                                    i++;
                                    inputStream = inputStream;
                                    r6 = r6;
                                } catch (Exception e29) {
                                    bArr = byteArray;
                                    e = e29;
                                    r7 = "|retryCount:";
                                    this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + i + "|" + e.getClass() + "|" + e.getMessage();
                                    this.Iq.pW().Ki = -10;
                                    com.baidu.tbadk.core.util.httpNet.e pW32 = this.Iq.pW();
                                    Resources resources32 = this.mContext.getResources();
                                    r6 = com.baidu.tieba.z.neterror;
                                    pW32.mErrorString = resources32.getString(r6);
                                    BdLog.e(e.getMessage());
                                    TiebaStatic.net(this.Iq);
                                    al.cD(this.Iq.pV().pY().mUrl);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (this.kc != null) {
                                        this.kc.disconnect();
                                    }
                                    i = 0;
                                    this.Iy = 0;
                                    inputStream = inputStream;
                                    r6 = r6;
                                    r7 = r7;
                                    j = j;
                                    return bArr;
                                }
                            } else {
                                this.Iq.pW().Ki = -11;
                                com.baidu.tbadk.core.util.httpNet.e pW6 = this.Iq.pW();
                                Resources resources6 = this.mContext.getResources();
                                int i5 = com.baidu.tieba.z.data_too_big;
                                pW6.mErrorString = resources6.getString(i5);
                                j = i5;
                            }
                            this.Iq.pX().kX.retry = i + 1;
                            this.Iq.pX().kX.kq = r7;
                            ap apVar = new ap();
                            apVar.mMode = getMode(com.baidu.adp.lib.util.i.fl());
                            apVar.mSize = this.mDataSize;
                            apVar.mTime = r7;
                            apVar.IV = i + 1;
                            apVar.IU = 2;
                            ao.a(apVar);
                            TiebaStatic.net(this.Iq);
                            try {
                                al.cD(this.Iq.pV().pY().mUrl);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Exception e30) {
                            }
                            try {
                                if (this.kc != null) {
                                    this.kc.disconnect();
                                }
                            } catch (Exception e31) {
                            }
                        }
                    } else if (this.Iy < 1) {
                        this.kc.disconnect();
                        this.Iy++;
                        this.Iq.pW().Ki = 0;
                        i--;
                        try {
                            al.cD(this.Iq.pV().pY().mUrl);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e32) {
                        }
                        try {
                            if (this.kc != null) {
                                this.kc.disconnect();
                            }
                        } catch (Exception e33) {
                        }
                    } else {
                        try {
                            al.cD(this.Iq.pV().pY().mUrl);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e34) {
                        }
                        try {
                            if (this.kc != null) {
                                this.kc.disconnect();
                            }
                        } catch (Exception e35) {
                        }
                    }
                    i++;
                    inputStream = inputStream;
                    r6 = r6;
                }
            }
            i = 0;
            this.Iy = 0;
            inputStream = inputStream;
            r6 = r6;
            r7 = r7;
            j = j;
            return bArr;
        }
    }

    private String getCharset() {
        int indexOf;
        String str = null;
        if (this.kc != null) {
            str = this.kc.getContentType();
        }
        if (str == null || (indexOf = str.indexOf("charset")) == -1) {
            return "utf-8";
        }
        int indexOf2 = str.indexOf(32, indexOf);
        if (indexOf2 == -1) {
            return str.substring(indexOf + 8);
        }
        return str.substring(indexOf + 8, indexOf2);
    }

    public void cB(String str) {
        this.Iq.pW().Kj = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.Iq.pW().Kj = errorData.getError_code();
                if (this.Iq.pW().Kj == -1) {
                    this.Iq.pW().mErrorString = this.mContext.getString(com.baidu.tieba.z.error_unkown_try_again);
                } else if (this.Iq.pW().Kj != 0) {
                    this.Iq.pW().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.Iq.pW().mErrorString = this.mContext.getString(com.baidu.tieba.z.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.v
    public String ox() {
        String str;
        Exception e;
        byte[] ow = ow();
        if (this.Iq.pW().Ki != 200) {
            return null;
        }
        try {
            str = new String(ow, 0, ow.length, getCharset());
        } catch (Exception e2) {
            str = null;
            e = e2;
        }
        try {
            cB(str);
            return str;
        } catch (Exception e3) {
            e = e3;
            BdLog.e(e.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [986=12, 987=12, 988=12, 993=12, 994=12, 996=4] */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x039a, code lost:
        com.baidu.tbadk.core.util.al.cD(r14.Iq.pV().pY().mUrl);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x03a9, code lost:
        if (0 == 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x03ab, code lost:
        r3.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:219:0x061f A[Catch: Exception -> 0x062e, TRY_LEAVE, TryCatch #1 {Exception -> 0x062e, blocks: (B:217:0x060e, B:219:0x061f), top: B:272:0x060e }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0626 A[Catch: Exception -> 0x062c, TRY_LEAVE, TryCatch #3 {Exception -> 0x062c, blocks: (B:220:0x0622, B:222:0x0626), top: B:276:0x0622 }] */
    @Override // com.baidu.tbadk.core.util.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String ov() {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        SocketTimeoutException socketTimeoutException;
        InputStream inputStream3;
        SocketException socketException;
        URL url;
        byte[] bArr;
        int read;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        try {
            int cC = al.cC(this.Iq.pV().pY().mUrl);
            if (cC > 0) {
                al.pl().bQ(cC);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.Iq.pV().pY().Kv == null || i2 >= this.Iq.pV().pY().Kv.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.Iq.pV().pY().Kv.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(name) + "=");
                sb.append(ba.aE(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.Iq.pV().pY().mIsBaiduServer) {
            sb2.append("tiebaclient!!!");
            String md5 = com.baidu.adp.lib.util.z.toMd5(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(md5);
        }
        String sb3 = sb.toString();
        this.Iq.pX().kX.kl = sb3.length();
        TbConfig.getDebugSwitch();
        int i3 = 0;
        boolean z = true;
        String str = null;
        while (true) {
            if (this.IA || !z || i3 >= 5) {
                break;
            }
            InputStream inputStream4 = null;
            try {
                try {
                    url = new URL(this.Iq.pV().pY().mUrl);
                    this.kc = a(url);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        al.cD(this.Iq.pV().pY().mUrl);
                        if (inputStream4 != null) {
                        }
                    } catch (Exception e2) {
                    }
                    try {
                        if (this.kc != null) {
                        }
                    } catch (Exception e3) {
                    }
                    throw th;
                }
            } catch (SocketException e4) {
                inputStream3 = null;
                socketException = e4;
            } catch (SocketTimeoutException e5) {
                inputStream2 = null;
                socketTimeoutException = e5;
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
            }
            if (this.kc == null) {
                this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                try {
                    al.cD(this.Iq.pV().pY().mUrl);
                    if (0 != 0) {
                        inputStream4.close();
                    }
                } catch (Exception e6) {
                }
                try {
                    if (this.kc != null) {
                        this.kc.disconnect();
                    }
                } catch (Exception e7) {
                }
            } else {
                this.kc.setConnectTimeout(5000);
                this.kc.setReadTimeout(15000);
                this.kc.setDoOutput(true);
                this.kc.setDoInput(true);
                this.kc.setRequestMethod("POST");
                this.kc.setRequestProperty("Charset", "UTF-8");
                this.kc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                if (this.Iq.pV().pY().Kx) {
                    this.kc.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.IA) {
                    try {
                        al.cD(this.Iq.pV().pY().mUrl);
                        if (0 != 0) {
                            inputStream4.close();
                        }
                    } catch (Exception e8) {
                    }
                    try {
                        if (this.kc != null) {
                            this.kc.disconnect();
                        }
                    } catch (Exception e9) {
                    }
                } else {
                    long time = new Date().getTime();
                    b(url);
                    this.Iq.pX().kX.kr = new Date().getTime() - time;
                    this.kc.connect();
                    this.Iq.pX().kX.ko = (new Date().getTime() - time) - this.Iq.pX().kX.kr;
                    DataOutputStream dataOutputStream = new DataOutputStream(this.kc.getOutputStream());
                    if (!this.IA) {
                        dataOutputStream.writeBytes(sb3);
                    }
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (this.kc != null) {
                        if ("image/gif".equalsIgnoreCase(this.kc.getHeaderField("Src-Content-Type"))) {
                            this.Iq.pW().gg = true;
                        } else {
                            this.Iq.pW().gg = false;
                        }
                    }
                    this.Iq.pW().Ki = this.kc.getResponseCode();
                    if (this.Iq.pW().Ki != 200) {
                        if (this.Iq.pW().Ki != 202 && this.Iq.pW().Ki != 201 && this.Iq.pW().Ki != 205 && this.Iq.pW().Ki != 304 && this.Iq.pW().Ki != 305 && this.Iq.pW().Ki != 408) {
                            if (this.Iq.pW().Ki == 502 || this.Iq.pW().Ki == 503 || this.Iq.pW().Ki == 504) {
                                break;
                            }
                        } else {
                            this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + i3;
                            ao.IT.incrementAndGet();
                            z = true;
                            this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                            if (i3 == 0) {
                                TiebaStatic.net(this.Iq);
                            }
                            try {
                                al.cD(this.Iq.pV().pY().mUrl);
                                if (0 != 0) {
                                    inputStream4.close();
                                }
                            } catch (Exception e10) {
                            }
                            try {
                                if (this.kc != null) {
                                    this.kc.disconnect();
                                }
                            } catch (Exception e11) {
                            }
                            i3++;
                        }
                    }
                    if (!this.Iq.pV().pY().mIsBaiduServer || !this.kc.getContentType().contains("text/vnd.wap.wml")) {
                        String contentEncoding = this.kc.getContentEncoding();
                        InputStream inputStream5 = this.kc.getInputStream();
                        try {
                            byte[] bArr2 = new byte[1024];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                            int i4 = 0;
                            while (!this.IA && (read = inputStream5.read(bArr2)) != -1) {
                                byteArrayOutputStream.write(bArr2, 0, read);
                                i4 += read;
                            }
                            inputStream5.close();
                            this.kc.disconnect();
                            if (this.IA) {
                                try {
                                    al.cD(this.Iq.pV().pY().mUrl);
                                    if (inputStream5 != null) {
                                        inputStream5.close();
                                    }
                                } catch (Exception e12) {
                                }
                                try {
                                    if (this.kc != null) {
                                        this.kc.disconnect();
                                    }
                                } catch (Exception e13) {
                                }
                            } else {
                                this.mDataSize = i4;
                                long time2 = new Date().getTime() - time;
                                this.Iq.pX().kX.kp = (time2 - this.Iq.pX().kX.ko) - this.Iq.pX().kX.kr;
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                    bArr = byteArray;
                                } else {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                    com.baidu.tbadk.util.d.b(byteArrayInputStream, byteArrayOutputStream2);
                                    bArr = byteArrayOutputStream2.toByteArray();
                                }
                                String str2 = new String(bArr, 0, bArr.length, getCharset());
                                try {
                                    if (this.Iq.pV().pY().mIsBaiduServer && this.Iq.pV().pY().Ky) {
                                        cB(str2);
                                    }
                                    this.Iq.pX().kX.retry = i3 + 1;
                                    this.Iq.pX().kX.kq = time2;
                                    ap apVar = new ap();
                                    apVar.mMode = getMode(com.baidu.adp.lib.util.i.fl());
                                    apVar.mSize = this.mDataSize;
                                    apVar.mTime = time2;
                                    apVar.IV = i3 + 1;
                                    apVar.IU = 1;
                                    ao.a(apVar);
                                    TiebaStatic.net(this.Iq);
                                    try {
                                        al.cD(this.Iq.pV().pY().mUrl);
                                        if (inputStream5 != null) {
                                            inputStream5.close();
                                        }
                                    } catch (Exception e14) {
                                    }
                                    try {
                                        if (this.kc != null) {
                                            this.kc.disconnect();
                                            str = str2;
                                        } else {
                                            str = str2;
                                        }
                                    } catch (Exception e15) {
                                        str = str2;
                                    }
                                } catch (SocketException e16) {
                                    inputStream3 = inputStream5;
                                    socketException = e16;
                                    str = str2;
                                    ao.IT.incrementAndGet();
                                    this.Iq.pW().Ki = -12;
                                    z = true;
                                    this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                                    BdLog.e(socketException.getMessage());
                                    if (i3 == 0) {
                                        TiebaStatic.net(this.Iq);
                                    }
                                    try {
                                        al.cD(this.Iq.pV().pY().mUrl);
                                        if (inputStream3 != null) {
                                            inputStream3.close();
                                        }
                                    } catch (Exception e17) {
                                    }
                                    try {
                                        if (this.kc != null) {
                                            this.kc.disconnect();
                                        }
                                    } catch (Exception e18) {
                                    }
                                    i3++;
                                } catch (SocketTimeoutException e19) {
                                    inputStream2 = inputStream5;
                                    socketTimeoutException = e19;
                                    str = str2;
                                    try {
                                        ao.IT.incrementAndGet();
                                        this.Iq.pW().Ki = -13;
                                        z = true;
                                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                                        BdLog.e(socketTimeoutException.getMessage());
                                        if (i3 == 0) {
                                            TiebaStatic.net(this.Iq);
                                        }
                                        try {
                                            al.cD(this.Iq.pV().pY().mUrl);
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                        } catch (Exception e20) {
                                        }
                                        try {
                                            if (this.kc != null) {
                                                this.kc.disconnect();
                                            }
                                        } catch (Exception e21) {
                                        }
                                        i3++;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        inputStream4 = inputStream2;
                                        al.cD(this.Iq.pV().pY().mUrl);
                                        if (inputStream4 != null) {
                                            inputStream4.close();
                                        }
                                        if (this.kc != null) {
                                            this.kc.disconnect();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    inputStream = inputStream5;
                                    th = th5;
                                    str = str2;
                                    this.Iq.pW().Ki = -10;
                                    z = false;
                                    this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                                    BdLog.e(th.getMessage());
                                    TiebaStatic.net(this.Iq);
                                    try {
                                        al.cD(this.Iq.pV().pY().mUrl);
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Exception e22) {
                                    }
                                    try {
                                        if (this.kc != null) {
                                            this.kc.disconnect();
                                        }
                                    } catch (Exception e23) {
                                    }
                                    i3++;
                                }
                            }
                        } catch (SocketException e24) {
                            inputStream3 = inputStream5;
                            socketException = e24;
                        } catch (SocketTimeoutException e25) {
                            inputStream2 = inputStream5;
                            socketTimeoutException = e25;
                        } catch (Throwable th6) {
                            inputStream = inputStream5;
                            th = th6;
                        }
                    } else if (this.Iy < 1) {
                        this.kc.disconnect();
                        this.Iy++;
                        this.Iq.pW().Ki = 0;
                        i3--;
                        try {
                            al.cD(this.Iq.pV().pY().mUrl);
                            if (0 != 0) {
                                inputStream4.close();
                            }
                        } catch (Exception e26) {
                        }
                        try {
                            if (this.kc != null) {
                                this.kc.disconnect();
                            }
                        } catch (Exception e27) {
                        }
                        i3++;
                    } else {
                        try {
                            al.cD(this.Iq.pV().pY().mUrl);
                            if (0 != 0) {
                                inputStream4.close();
                            }
                        } catch (Exception e28) {
                        }
                        try {
                            if (this.kc != null) {
                                this.kc.disconnect();
                            }
                        } catch (Exception e29) {
                        }
                    }
                }
            }
        }
        this.Iy = 0;
        return str;
        try {
            if (this.kc != null) {
                this.kc.disconnect();
            }
        } catch (Exception e30) {
        }
        return null;
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1188=11, 1189=11, 1194=11, 1195=11, 1200=11, 1201=11, 1205=11, 1206=11] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x035c A[Catch: all -> 0x0555, TRY_LEAVE, TryCatch #14 {all -> 0x0555, blocks: (B:41:0x00f6, B:43:0x0104, B:45:0x0116, B:76:0x021a, B:78:0x022e, B:79:0x0233, B:47:0x011a, B:49:0x011e, B:51:0x012c, B:52:0x0140, B:97:0x02d5, B:100:0x02ed, B:54:0x0146, B:56:0x0174, B:57:0x0183, B:59:0x0195, B:60:0x019b, B:62:0x01a7, B:64:0x01ee, B:117:0x0380, B:119:0x038e, B:121:0x0393, B:123:0x03a0, B:186:0x04a7, B:104:0x033b, B:106:0x035c, B:144:0x03e9), top: B:322:0x00f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x036a A[Catch: Exception -> 0x0576, TRY_LEAVE, TryCatch #2 {Exception -> 0x0576, blocks: (B:109:0x0366, B:111:0x036a), top: B:308:0x0366 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04db A[Catch: Exception -> 0x055b, TRY_LEAVE, TryCatch #5 {Exception -> 0x055b, blocks: (B:189:0x04d7, B:191:0x04db), top: B:310:0x04d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x04fc A[Catch: Exception -> 0x054f, TRY_LEAVE, TryCatch #41 {Exception -> 0x054f, blocks: (B:201:0x04f8, B:203:0x04fc), top: B:360:0x04f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0503 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:364:0x04f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x04e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x02c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:370:0x02b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:374:0x04d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0371 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0363 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0213 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0213 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0213 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02b1 A[Catch: all -> 0x0551, TRY_LEAVE, TryCatch #13 {all -> 0x0551, blocks: (B:84:0x0291, B:86:0x02b1), top: B:320:0x0291 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02bf A[Catch: Exception -> 0x0590, TRY_LEAVE, TryCatch #8 {Exception -> 0x0590, blocks: (B:89:0x02bb, B:91:0x02bf), top: B:312:0x02bb }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02cd  */
    @Override // com.baidu.tbadk.core.util.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String oy() {
        DataOutputStream dataOutputStream;
        Throwable th;
        Exception e;
        int i;
        String str;
        DataOutputStream dataOutputStream2;
        InputStream inputStream;
        boolean z;
        byte[] bArr;
        int read;
        String str2 = null;
        boolean z2 = true;
        int i2 = 0;
        while (true) {
            if (this.IA || !z2 || i2 >= 5) {
                break;
            }
            InputStream inputStream2 = null;
            DataOutputStream dataOutputStream3 = null;
            try {
                this.kc = a(new URL(this.Iq.pV().pY().mUrl));
            } catch (SocketException e2) {
                dataOutputStream2 = null;
                i = i2;
                str = str2;
                inputStream = null;
            } catch (SocketTimeoutException e3) {
                dataOutputStream = null;
                i = i2;
                str = str2;
            } catch (Exception e4) {
                e = e4;
                dataOutputStream = null;
                i = i2;
                str = str2;
            } catch (Throwable th2) {
                dataOutputStream = null;
                th = th2;
            }
            if (this.kc == null) {
                this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                    }
                }
                try {
                    if (this.kc != null) {
                        this.kc.disconnect();
                    }
                } catch (Exception e6) {
                }
                if (0 != 0) {
                    try {
                        dataOutputStream3.close();
                    } catch (Exception e7) {
                    }
                }
                if (mHandler != null) {
                    mHandler.removeMessages(0, this);
                }
            } else {
                this.kc.setConnectTimeout(5000);
                this.kc.setReadTimeout(15000);
                this.kc.setDoOutput(true);
                this.kc.setDoInput(true);
                this.kc.setRequestMethod("POST");
                this.kc.setRequestProperty("Charset", "UTF-8");
                this.kc.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
                if (this.Iq.pV().pY().Kx) {
                    this.kc.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.IA) {
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e8) {
                        }
                    }
                    try {
                        if (this.kc != null) {
                            this.kc.disconnect();
                        }
                    } catch (Exception e9) {
                    }
                    if (0 != 0) {
                        try {
                            dataOutputStream3.close();
                        } catch (Exception e10) {
                        }
                    }
                    if (mHandler != null) {
                        mHandler.removeMessages(0, this);
                    }
                } else {
                    long time = new Date().getTime();
                    this.kc.connect();
                    dataOutputStream = new DataOutputStream(this.kc.getOutputStream());
                    for (int i3 = 0; this.Iq.pV().pY().Kv != null && i3 < this.Iq.pV().pY().Kv.size() && !this.IA; i3++) {
                        try {
                            try {
                                BasicNameValuePair basicNameValuePair = this.Iq.pV().pY().Kv.get(i3);
                                if (basicNameValuePair != null) {
                                    String name = basicNameValuePair.getName();
                                    String value = basicNameValuePair.getValue();
                                    dataOutputStream.writeBytes(String.valueOf(kO) + boundary + kN);
                                    byte[] bytes = value.getBytes("UTF-8");
                                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + kN);
                                    dataOutputStream.writeBytes(kN);
                                    dataOutputStream.write(bytes);
                                    dataOutputStream.writeBytes(kN);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (SocketException e11) {
                            dataOutputStream2 = dataOutputStream;
                            i = i2;
                            str = str2;
                            inputStream = null;
                        } catch (SocketTimeoutException e12) {
                            i = i2;
                            str = str2;
                        } catch (Exception e13) {
                            e = e13;
                            i = i2;
                            str = str2;
                        }
                    }
                    if (!this.IA && this.Iq.pV().pY().Kw != null) {
                        for (Map.Entry<String, byte[]> entry : this.Iq.pV().pY().Kw.entrySet()) {
                            String key = entry.getKey();
                            byte[] value2 = entry.getValue();
                            if (this.IA) {
                                break;
                            } else if (value2 != null) {
                                dataOutputStream.writeBytes(String.valueOf(kO) + boundary + kN);
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + kN);
                                dataOutputStream.writeBytes(kN);
                                dataOutputStream.write(value2);
                                dataOutputStream.writeBytes(kN);
                            }
                        }
                    }
                    dataOutputStream.writeBytes(String.valueOf(kO) + boundary + kO + kN);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (mHandler != null) {
                        mHandler.sendMessageDelayed(mHandler.obtainMessage(0, this), 45000L);
                    }
                    this.Iq.pW().Ki = this.kc.getResponseCode();
                    if (mHandler != null) {
                        mHandler.removeMessages(0, this);
                    }
                    if (this.Iq.pW().Ki != 200) {
                        this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + i2;
                        ao.IT.incrementAndGet();
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        if (i2 == 0) {
                            TiebaStatic.net(this.Iq);
                        }
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e14) {
                            }
                        }
                        try {
                            if (this.kc != null) {
                                this.kc.disconnect();
                            }
                        } catch (Exception e15) {
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e16) {
                            }
                        }
                        if (mHandler != null) {
                            mHandler.removeMessages(0, this);
                            z = true;
                            i = i2;
                            str = str2;
                        } else {
                            z = true;
                            i = i2;
                            str = str2;
                        }
                    } else if (!this.kc.getContentType().contains("text/vnd.wap.wml")) {
                        String contentEncoding = this.kc.getContentEncoding();
                        InputStream inputStream3 = this.kc.getInputStream();
                        try {
                            try {
                                byte[] bArr2 = new byte[1024];
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                while (!this.IA && (read = inputStream3.read(bArr2)) != -1) {
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                }
                                if (this.IA) {
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e17) {
                                        }
                                    }
                                    try {
                                        if (this.kc != null) {
                                            this.kc.disconnect();
                                        }
                                    } catch (Exception e18) {
                                    }
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (Exception e19) {
                                        }
                                    }
                                    if (mHandler != null) {
                                        mHandler.removeMessages(0, this);
                                    }
                                } else {
                                    inputStream3.close();
                                    this.kc.disconnect();
                                    long time2 = new Date().getTime() - time;
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                        bArr = byteArray;
                                    } else {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                        com.baidu.tbadk.util.d.b(byteArrayInputStream, byteArrayOutputStream2);
                                        bArr = byteArrayOutputStream2.toByteArray();
                                    }
                                    String str3 = new String(bArr, 0, bArr.length, getCharset());
                                    try {
                                        cB(str3);
                                        TiebaStatic.net(this.Iq);
                                        if (inputStream3 != null) {
                                            try {
                                                inputStream3.close();
                                            } catch (Exception e20) {
                                            }
                                        }
                                        try {
                                            if (this.kc != null) {
                                                this.kc.disconnect();
                                            }
                                        } catch (Exception e21) {
                                        }
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e22) {
                                            }
                                        }
                                        if (mHandler != null) {
                                            mHandler.removeMessages(0, this);
                                            str2 = str3;
                                        } else {
                                            str2 = str3;
                                        }
                                    } catch (SocketException e23) {
                                        dataOutputStream2 = dataOutputStream;
                                        inputStream = inputStream3;
                                        int i4 = i2;
                                        str = str3;
                                        i = i4;
                                        z = true;
                                        this.Iq.pW().Ki = -12;
                                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                                        if (i == 0) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (this.kc != null) {
                                        }
                                        if (dataOutputStream2 != null) {
                                        }
                                        if (mHandler == null) {
                                        }
                                        z2 = z;
                                        str2 = str;
                                        i2 = i + 1;
                                    } catch (SocketTimeoutException e24) {
                                        inputStream2 = inputStream3;
                                        int i5 = i2;
                                        str = str3;
                                        i = i5;
                                        this.Iq.pW().Ki = -13;
                                        z = true;
                                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                                        if (i == 0) {
                                        }
                                        if (inputStream2 != null) {
                                        }
                                        if (this.kc != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        if (mHandler == null) {
                                        }
                                        z2 = z;
                                        str2 = str;
                                        i2 = i + 1;
                                    } catch (Exception e25) {
                                        e = e25;
                                        inputStream2 = inputStream3;
                                        int i6 = i2;
                                        str = str3;
                                        i = i6;
                                        this.Iq.pW().Ki = -10;
                                        z = false;
                                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                                        BdLog.e(e.getMessage());
                                        TiebaStatic.net(this.Iq);
                                        if (inputStream2 != null) {
                                        }
                                        if (this.kc != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        if (mHandler == null) {
                                        }
                                        z2 = z;
                                        str2 = str;
                                        i2 = i + 1;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = inputStream3;
                                if (inputStream2 != null) {
                                }
                                if (this.kc != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                                if (mHandler != null) {
                                }
                                throw th;
                            }
                        } catch (SocketException e26) {
                            dataOutputStream2 = dataOutputStream;
                            i = i2;
                            str = str2;
                            inputStream = inputStream3;
                        } catch (SocketTimeoutException e27) {
                            inputStream2 = inputStream3;
                            i = i2;
                            str = str2;
                        } catch (Exception e28) {
                            e = e28;
                            inputStream2 = inputStream3;
                            i = i2;
                            str = str2;
                        }
                    } else if (this.Iy < 1) {
                        this.kc.disconnect();
                        this.Iy++;
                        i = i2 - 1;
                        try {
                            this.Iq.pW().Ki = 0;
                            if (0 != 0) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e29) {
                                }
                            }
                            try {
                                if (this.kc != null) {
                                    this.kc.disconnect();
                                }
                            } catch (Exception e30) {
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e31) {
                                }
                            }
                            if (mHandler != null) {
                                mHandler.removeMessages(0, this);
                                z = z2;
                                str = str2;
                            } else {
                                z = z2;
                                str = str2;
                            }
                        } catch (SocketException e32) {
                            dataOutputStream2 = dataOutputStream;
                            str = str2;
                            inputStream = null;
                            z = true;
                            try {
                                this.Iq.pW().Ki = -12;
                                this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                                if (i == 0) {
                                    TiebaStatic.net(this.Iq);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e33) {
                                    }
                                }
                                try {
                                    if (this.kc != null) {
                                        this.kc.disconnect();
                                    }
                                } catch (Exception e34) {
                                }
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (Exception e35) {
                                    }
                                }
                                if (mHandler == null) {
                                    mHandler.removeMessages(0, this);
                                }
                                z2 = z;
                                str2 = str;
                                i2 = i + 1;
                            } catch (Throwable th5) {
                                th = th5;
                                dataOutputStream = dataOutputStream2;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e36) {
                                    }
                                }
                                try {
                                    if (this.kc != null) {
                                        this.kc.disconnect();
                                    }
                                } catch (Exception e37) {
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (Exception e38) {
                                    }
                                }
                                if (mHandler != null) {
                                    mHandler.removeMessages(0, this);
                                }
                                throw th;
                            }
                        } catch (SocketTimeoutException e39) {
                            str = str2;
                            this.Iq.pW().Ki = -13;
                            z = true;
                            this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                            if (i == 0) {
                                TiebaStatic.net(this.Iq);
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e40) {
                                }
                            }
                            try {
                                if (this.kc != null) {
                                    this.kc.disconnect();
                                }
                            } catch (Exception e41) {
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e42) {
                                }
                            }
                            if (mHandler == null) {
                                mHandler.removeMessages(0, this);
                            }
                            z2 = z;
                            str2 = str;
                            i2 = i + 1;
                        } catch (Exception e43) {
                            e = e43;
                            str = str2;
                            this.Iq.pW().Ki = -10;
                            z = false;
                            this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                            BdLog.e(e.getMessage());
                            TiebaStatic.net(this.Iq);
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e44) {
                                }
                            }
                            try {
                                if (this.kc != null) {
                                    this.kc.disconnect();
                                }
                            } catch (Exception e45) {
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e46) {
                                }
                            }
                            if (mHandler == null) {
                                mHandler.removeMessages(0, this);
                            }
                            z2 = z;
                            str2 = str;
                            i2 = i + 1;
                        }
                    } else {
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e47) {
                            }
                        }
                        try {
                            if (this.kc != null) {
                                this.kc.disconnect();
                            }
                        } catch (Exception e48) {
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e49) {
                            }
                        }
                        if (mHandler != null) {
                            mHandler.removeMessages(0, this);
                        }
                    }
                    z2 = z;
                    str2 = str;
                    i2 = i + 1;
                }
            }
        }
        this.Iy = 0;
        return str2;
    }

    public boolean pg() {
        return this.Iq.pW().Ki == 200 || this.Iq.pW().Ki == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1360=8, 1362=8, 1363=8, 1368=8, 1369=8, 1374=8, 1375=8] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02df A[Catch: Exception -> 0x0312, TRY_LEAVE, TryCatch #23 {Exception -> 0x0312, blocks: (B:162:0x02db, B:164:0x02df), top: B:256:0x02db }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x02e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x02d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.util.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        FileOutputStream fileOutputStream;
        Exception e;
        InputStream inputStream;
        String headerField;
        int indexOf;
        InputStream inputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                this.kc = a(new URL(this.Iq.pV().pY().mUrl));
                if (this.kc == null) {
                    throw new SocketException();
                }
                this.kc.setConnectTimeout(5000);
                this.kc.setReadTimeout(30000);
                this.kc.setInstanceFollowRedirects(false);
                if (this.IA) {
                    this.Iy = 0;
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e2) {
                        }
                    }
                    try {
                        if (this.kc != null) {
                            this.kc.disconnect();
                        }
                    } catch (Exception e3) {
                    }
                    if (0 != 0) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e4) {
                        }
                    }
                    return false;
                }
                File file = z ? new File(str) : s.cm(str);
                if (file == null) {
                    throw new FileNotFoundException();
                }
                long length = file.length();
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    if (this.Iz) {
                        this.kc.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-" + String.valueOf(200000 + length));
                    } else {
                        this.kc.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                    }
                    this.kc.connect();
                    this.Iq.pW().Ki = this.kc.getResponseCode();
                    if (!pg()) {
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        TiebaStatic.net(this.Iq);
                        this.Iy = 0;
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e5) {
                            }
                        }
                        try {
                            if (this.kc != null) {
                                this.kc.disconnect();
                            }
                        } catch (Exception e6) {
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e7) {
                            }
                        }
                        return false;
                    } else if (this.kc.getContentType().contains("text/vnd.wap.wml") && this.Iy < 1) {
                        this.kc.disconnect();
                        this.Iy++;
                        this.Iq.pW().Ki = 0;
                        boolean a = a(str, handler, i, i2, i3, z);
                        this.Iy = 0;
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e8) {
                            }
                        }
                        try {
                            if (this.kc != null) {
                                this.kc.disconnect();
                            }
                        } catch (Exception e9) {
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return a;
                            } catch (Exception e10) {
                                return a;
                            }
                        }
                        return a;
                    } else {
                        this.Iy = 0;
                        int i4 = 0;
                        String headerField2 = this.kc.getHeaderField("Content-Range");
                        if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                            i4 = com.baidu.adp.lib.g.c.toInt(headerField2.substring(indexOf + 1), 0);
                        }
                        int i5 = (i4 == 0 && this.Iq.pW().Ki == 200 && (headerField = this.kc.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.c.toInt(headerField, 0) : i4;
                        if (length >= i5) {
                            this.Iy = 0;
                            if (0 != 0) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e11) {
                                }
                            }
                            try {
                                if (this.kc != null) {
                                    this.kc.disconnect();
                                }
                            } catch (Exception e12) {
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e13) {
                                }
                            }
                            return true;
                        }
                        InputStream inputStream3 = this.kc.getInputStream();
                        try {
                            try {
                                byte[] bArr = new byte[1024];
                                int i6 = 0;
                                int i7 = i5 > 0 ? i5 / 50 : 0;
                                int i8 = 0;
                                if (handler != null && length > 0) {
                                    handler.sendMessage(handler.obtainMessage(i, (int) length, i5));
                                }
                                while (!this.IA) {
                                    int read = inputStream3.read(bArr);
                                    if (read != -1) {
                                        try {
                                            fileOutputStream.write(bArr, 0, read);
                                            i6 += read;
                                            i8 += read;
                                            if (handler != null && (i8 > i7 || i6 == i5)) {
                                                i8 = 0;
                                                handler.sendMessage(handler.obtainMessage(i, (int) (i6 + length), i5));
                                            }
                                        } catch (Exception e14) {
                                            throw new FileNotFoundException();
                                        }
                                    }
                                }
                                try {
                                    fileOutputStream.flush();
                                    boolean z2 = ((long) i6) + length >= ((long) i5);
                                    this.Iy = 0;
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e15) {
                                        }
                                    }
                                    try {
                                        if (this.kc != null) {
                                            this.kc.disconnect();
                                        }
                                    } catch (Exception e16) {
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            return z2;
                                        } catch (Exception e17) {
                                            return z2;
                                        }
                                    }
                                    return z2;
                                } catch (Exception e18) {
                                    throw new FileNotFoundException();
                                }
                            } catch (Throwable th) {
                                th = th;
                                inputStream2 = inputStream3;
                                this.Iy = 0;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e19) {
                                    }
                                }
                                try {
                                    if (this.kc != null) {
                                        this.kc.disconnect();
                                    }
                                } catch (Exception e20) {
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e22) {
                            inputStream = inputStream3;
                            fileOutputStream2 = fileOutputStream;
                            try {
                                TiebaStatic.net(this.Iq);
                                this.Iq.pW().Ki = -100;
                                this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.FileWriteError);
                                this.Iy = 0;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e23) {
                                    }
                                }
                                try {
                                    if (this.kc != null) {
                                        this.kc.disconnect();
                                    }
                                } catch (Exception e24) {
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                        return false;
                                    } catch (Exception e25) {
                                        return false;
                                    }
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                fileOutputStream = fileOutputStream2;
                                this.Iy = 0;
                                if (inputStream2 != null) {
                                }
                                if (this.kc != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e26) {
                            inputStream2 = inputStream3;
                            e = e26;
                            TiebaStatic.net(this.Iq);
                            this.Iq.pW().Ki = -10;
                            this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                            BdLog.e(e.getMessage());
                            this.Iy = 0;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e27) {
                                }
                            }
                            try {
                                if (this.kc != null) {
                                    this.kc.disconnect();
                                }
                            } catch (Exception e28) {
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return false;
                                } catch (Exception e29) {
                                    return false;
                                }
                            }
                            return false;
                        }
                    }
                } catch (FileNotFoundException e30) {
                    fileOutputStream2 = fileOutputStream;
                    inputStream = null;
                } catch (Exception e31) {
                    e = e31;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e32) {
            inputStream = null;
        } catch (Exception e33) {
            fileOutputStream = null;
            e = e33;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    @Override // com.baidu.tbadk.core.util.v
    public ArrayList<BasicNameValuePair> ot() {
        return this.Iq.pV().pY().Kv;
    }

    @Override // com.baidu.tbadk.core.util.v
    public void q(ArrayList<BasicNameValuePair> arrayList) {
        if (this.Iq.pV().pY().Kv != null) {
            this.Iq.pV().pY().Kv.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                a(arrayList.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.v
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.v
    public void g(String str, byte[] bArr) {
        if (this.Iq.pV().pY().Kw == null) {
            this.Iq.pV().pY().Kw = new HashMap<>();
        }
        this.Iq.pV().pY().Kw.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.v
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.Iq.pV().pY().Kv == null) {
                this.Iq.pV().pY().Kv = new ArrayList<>();
            }
            int b = b(this.Iq.pV().pY().Kv, basicNameValuePair.getName());
            int size = this.Iq.pV().pY().Kv.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.Iq.pV().pY().Kv.get(b).getName())) {
                    this.Iq.pV().pY().Kv.set(b, basicNameValuePair);
                } else {
                    this.Iq.pV().pY().Kv.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.Iq.pV().pY().Kv.add(b, basicNameValuePair);
            }
        }
    }

    private int b(ArrayList<BasicNameValuePair> arrayList, String str) {
        int i = 0;
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            int compareTo = str.compareTo(arrayList.get(i).getName());
            if (compareTo < 0) {
                i2 = i;
                break;
            } else if (compareTo == 0) {
                return -1;
            } else {
                i2 = i;
                i++;
            }
        }
        return i >= size ? size : i2;
    }

    private void b(URL url) {
        try {
            InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }
}
