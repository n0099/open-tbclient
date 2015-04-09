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
public class ab implements s {
    private final com.baidu.tbadk.core.util.httpNet.a Uc;
    private int Uk;
    private boolean Ul;
    private volatile boolean Um;
    private Context mContext;
    private int mDataSize = 0;
    private HttpURLConnection vv;
    private static String we = "\r\n";
    private static String wf = "--";
    private static String boundary = "--------7da3d81520810*";
    private static int Uh = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private static Handler mHandler = null;
    private static volatile String Ui = null;
    private static volatile boolean Uj = false;
    private static Pattern vz = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);

    public ab(com.baidu.tbadk.core.util.httpNet.a aVar) {
        so();
        this.Uc = aVar;
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
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

    private void so() {
        this.vv = null;
        this.mContext = null;
        this.Uk = 0;
        this.Um = false;
        this.Ul = false;
        sw();
    }

    public static void sw() {
        synchronized (ab.class) {
            if (!Uj) {
                Uj = true;
                sx();
            }
        }
    }

    public static synchronized void sx() {
        synchronized (ab.class) {
            try {
                Cursor query = TbadkCoreApplication.m411getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    Ui = "Basic " + com.baidu.adp.lib.util.c.m((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public static void sy() {
        System.setProperty("http.keepAlive", "false");
        mHandler = new ac();
    }

    public String getUrl() {
        return this.Uc.tp().ts().mUrl;
    }

    @Override // com.baidu.tbadk.core.util.s
    public boolean rN() {
        return this.Um;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void hh() {
        this.Um = true;
        try {
            if (this.vv != null) {
                this.vv.disconnect();
                try {
                    int cG = ai.cG(getUrl());
                    if (cG > 0) {
                        ai.sE().m(cG, 1);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        } catch (Exception e2) {
        }
    }

    private HttpURLConnection a(URL url) {
        String iQ;
        HttpURLConnection httpURLConnection = null;
        this.Ul = false;
        if (com.baidu.adp.lib.util.k.iH()) {
            if (com.baidu.adp.lib.util.k.iI() && (iQ = com.baidu.adp.lib.util.k.iQ()) != null && iQ.length() > 0) {
                if (cE(iQ) && com.baidu.adp.lib.util.k.iS()) {
                    this.Ul = true;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("http://");
                    sb.append(iQ);
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
                    httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(iQ, com.baidu.adp.lib.util.k.iR())));
                    if (Ui != null) {
                        httpURLConnection.setRequestProperty("Proxy-Authorization", Ui);
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
            if (this.Uc != null) {
                if (!TextUtils.isEmpty(this.Uc.tp().ts().VX)) {
                    httpURLConnection.setRequestProperty("sid", this.Uc.tp().ts().VX);
                }
                if (!TextUtils.isEmpty(this.Uc.tp().ts().mNetType)) {
                    httpURLConnection.setRequestProperty("net", this.Uc.tp().ts().mNetType);
                }
            }
            com.baidu.tbadk.coreExtra.a.a.uu().g(httpURLConnection);
        }
        return httpURLConnection;
    }

    private boolean cE(String str) {
        if (vz.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [675=12, 676=12, 677=12, 682=12, 683=12] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:143:0x04f9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:180:0x05b9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:215:0x0769 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:224:0x080c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:256:0x0861 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:260:0x0867 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:328:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:346:0x0265 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x01c4 */
    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: com.baidu.tbadk.core.util.ab */
    /* JADX DEBUG: Multi-variable search result rejected for r4v14, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r9v3, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r9v4, resolved type: long */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x02a5, code lost:
        if (r17.Uc.tp().mIsFromCDN != false) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0630 A[Catch: all -> 0x080f, TRY_LEAVE, TryCatch #22 {all -> 0x080f, blocks: (B:46:0x01ac, B:48:0x01bc, B:49:0x01c3, B:61:0x0269, B:63:0x028b, B:67:0x02a7, B:68:0x02b2, B:79:0x02e0, B:81:0x0349, B:83:0x0397, B:93:0x03c6, B:95:0x03d6, B:97:0x03dd, B:117:0x044b, B:119:0x0466, B:145:0x04fc, B:147:0x0513, B:150:0x051a, B:156:0x054b, B:158:0x0551, B:160:0x0563, B:178:0x05ad, B:161:0x056e, B:163:0x0574, B:165:0x0578, B:194:0x0660, B:167:0x057f, B:195:0x0666, B:197:0x06a0, B:198:0x06a4, B:200:0x06a9, B:202:0x06b1, B:203:0x06c4, B:216:0x076a, B:181:0x05ba, B:183:0x0630, B:51:0x01c5, B:53:0x023b, B:213:0x0743, B:153:0x052c, B:155:0x0546, B:65:0x029b), top: B:313:0x01ac }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x064a A[Catch: Exception -> 0x0842, TRY_LEAVE, TryCatch #30 {Exception -> 0x0842, blocks: (B:184:0x0637, B:186:0x064a), top: B:324:0x0637 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0653 A[Catch: Exception -> 0x065c, TRY_LEAVE, TryCatch #14 {Exception -> 0x065c, blocks: (B:187:0x064d, B:189:0x0653), top: B:297:0x064d }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x07fa A[Catch: Exception -> 0x0838, TRY_LEAVE, TryCatch #5 {Exception -> 0x0838, blocks: (B:217:0x07e7, B:219:0x07fa), top: B:281:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0803 A[Catch: Exception -> 0x080c, TRY_LEAVE, TryCatch #21 {Exception -> 0x080c, blocks: (B:220:0x07fd, B:222:0x0803), top: B:311:0x07fd }] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0265 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0265 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x023b A[Catch: all -> 0x080f, TRY_LEAVE, TryCatch #22 {all -> 0x080f, blocks: (B:46:0x01ac, B:48:0x01bc, B:49:0x01c3, B:61:0x0269, B:63:0x028b, B:67:0x02a7, B:68:0x02b2, B:79:0x02e0, B:81:0x0349, B:83:0x0397, B:93:0x03c6, B:95:0x03d6, B:97:0x03dd, B:117:0x044b, B:119:0x0466, B:145:0x04fc, B:147:0x0513, B:150:0x051a, B:156:0x054b, B:158:0x0551, B:160:0x0563, B:178:0x05ad, B:161:0x056e, B:163:0x0574, B:165:0x0578, B:194:0x0660, B:167:0x057f, B:195:0x0666, B:197:0x06a0, B:198:0x06a4, B:200:0x06a9, B:202:0x06b1, B:203:0x06c4, B:216:0x076a, B:181:0x05ba, B:183:0x0630, B:51:0x01c5, B:53:0x023b, B:213:0x0743, B:153:0x052c, B:155:0x0546, B:65:0x029b), top: B:313:0x01ac }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0255 A[Catch: Exception -> 0x0850, TRY_LEAVE, TryCatch #19 {Exception -> 0x0850, blocks: (B:54:0x0242, B:56:0x0255), top: B:307:0x0242 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x025e A[Catch: Exception -> 0x084d, TRY_LEAVE, TryCatch #20 {Exception -> 0x084d, blocks: (B:57:0x0258, B:59:0x025e), top: B:309:0x0258 }] */
    /* JADX WARN: Type inference failed for: r1v76, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v77 */
    /* JADX WARN: Type inference failed for: r1v78, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v79, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v85, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v86 */
    /* JADX WARN: Type inference failed for: r1v87, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v88, types: [java.net.HttpURLConnection] */
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
    /* JADX WARN: Type inference failed for: r7v24, types: [int] */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29, types: [long] */
    /* JADX WARN: Type inference failed for: r7v36, types: [int] */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v42 */
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:173:0x059f -> B:28:0x00be). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:174:0x05a1 -> B:28:0x00be). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:176:0x05aa -> B:28:0x00be). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:208:0x0735 -> B:28:0x00be). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:209:0x0737 -> B:28:0x00be). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:211:0x0740 -> B:28:0x00be). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:221:0x0801 -> B:28:0x00be). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:222:0x0803 -> B:28:0x00be). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:224:0x080c -> B:28:0x00be). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] rP() {
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
            int cG = ai.cG(this.Uc.tp().ts().mUrl);
            if (cG > 0) {
                ai.sE().bW(cG);
            }
        } catch (Exception e4) {
            BdLog.e(e4.getMessage());
        }
        try {
            if (this.Uc.tp().ts().Wp == null || this.Uc.tp().ts().Wp.size() <= 0 || this.Uc.tp().mIsFromCDN) {
                str = this.Uc.tp().ts().mUrl;
            } else {
                sb = new StringBuilder(30);
                sb.append(this.Uc.tp().ts().mUrl);
                if (this.Uc.tp().ts().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.Uc.tp().ts().mUrl.endsWith("?") && !this.Uc.tp().ts().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i2 = 0; i2 < this.Uc.tp().ts().Wp.size(); i2++) {
                    if (i2 != 0) {
                        sb.append("&");
                    }
                    sb.append(this.Uc.tp().ts().Wp.get(i2).getName());
                    sb.append("=");
                    sb.append(bd.aM(this.Uc.tp().ts().Wp.get(i2).getValue()));
                }
                str = sb.toString();
            }
            URL url = new URL(str);
            if (str != null) {
                this.Uc.tr().wo.vE = str.getBytes().length;
            }
            TbConfig.getDebugSwitch();
            i = 0;
            inputStream = sb;
            r6 = url;
        } catch (Exception e5) {
            BdLog.e(e5.getMessage());
            this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + e5.getClass() + e5.getMessage();
            ai.cH(this.Uc.tp().ts().mUrl);
        }
        while (true) {
            if (!this.Um && i < 5) {
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
                        this.vv = a((URL) r6);
                    } catch (Throwable th) {
                        try {
                            ai.cH(this.Uc.tp().ts().mUrl);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e6) {
                        }
                        try {
                            if (this.vv != null) {
                                this.vv.disconnect();
                            }
                        } catch (Exception e7) {
                        }
                        throw th;
                    }
                } catch (SocketException e8) {
                    e3 = e8;
                    this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + i + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.Uc.tq().Wa = -12;
                    al.UI.incrementAndGet();
                    com.baidu.tbadk.core.util.httpNet.c tq = this.Uc.tq();
                    Resources resources = this.mContext.getResources();
                    r7 = com.baidu.tieba.y.neterror;
                    tq.mErrorString = resources.getString(r7);
                    if (i == 0) {
                    }
                    try {
                        ai.cH(this.Uc.tp().ts().mUrl);
                        if (inputStream != null) {
                        }
                    } catch (Exception e9) {
                    }
                    try {
                        if (this.vv == null) {
                        }
                    } catch (Exception e10) {
                    }
                    i++;
                    inputStream = inputStream;
                    r6 = r6;
                } catch (SocketTimeoutException e11) {
                    e2 = e11;
                    al.UI.incrementAndGet();
                    this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + i + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.Uc.tq().Wa = -13;
                    com.baidu.tbadk.core.util.httpNet.c tq2 = this.Uc.tq();
                    Resources resources2 = this.mContext.getResources();
                    r7 = com.baidu.tieba.y.neterror;
                    tq2.mErrorString = resources2.getString(r7);
                    if (i == 0) {
                    }
                    try {
                        ai.cH(this.Uc.tp().ts().mUrl);
                        if (inputStream != null) {
                        }
                    } catch (Exception e12) {
                    }
                    try {
                        if (this.vv == null) {
                        }
                    } catch (Exception e13) {
                    }
                    i++;
                    inputStream = inputStream;
                    r6 = r6;
                } catch (Exception e14) {
                    e = e14;
                    r7 = "|retryCount:";
                    this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + i + "|" + e.getClass() + "|" + e.getMessage();
                    this.Uc.tq().Wa = -10;
                    com.baidu.tbadk.core.util.httpNet.c tq3 = this.Uc.tq();
                    Resources resources3 = this.mContext.getResources();
                    r6 = com.baidu.tieba.y.neterror;
                    tq3.mErrorString = resources3.getString(r6);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.Uc);
                    try {
                        ai.cH(this.Uc.tp().ts().mUrl);
                        if (inputStream != null) {
                        }
                    } catch (Exception e15) {
                    }
                    try {
                        if (this.vv != null) {
                        }
                    } catch (Exception e16) {
                    }
                    i = 0;
                    this.Uk = 0;
                    inputStream = inputStream;
                    r6 = r6;
                    r7 = r7;
                    j = j;
                    return bArr;
                }
                if (this.vv == null) {
                    throw new SocketException("network not available.");
                    break;
                }
                this.vv.setConnectTimeout(5000);
                this.vv.setReadTimeout(30000);
                if (!this.Uc.tp().ts().Wr || this.Uc.tp().ts().mIsBDImage) {
                    r7 = r7;
                }
                this.vv.setRequestProperty("Accept-Encoding", "gzip");
                r7 = "gzip";
                if (this.Um) {
                    try {
                        ai.cH(this.Uc.tp().ts().mUrl);
                        if (0 != 0) {
                            inputStream.close();
                        }
                    } catch (Exception e17) {
                    }
                    try {
                        if (this.vv != null) {
                            this.vv.disconnect();
                        }
                    } catch (Exception e18) {
                    }
                } else {
                    r7 = new Date().getTime();
                    this.Uc.tr().wo.vK = new Date().getTime() - r7;
                    this.vv.connect();
                    com.baidu.adp.lib.network.http.d dVar = this.Uc.tr().wo;
                    j = (new Date().getTime() - r7) - this.Uc.tr().wo.vK;
                    dVar.vG = j;
                    this.Uc.tq().Wa = this.vv.getResponseCode();
                    if (this.Uc.tq().Wa != 200) {
                        this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + i;
                        al.UI.incrementAndGet();
                        com.baidu.tbadk.core.util.httpNet.c tq4 = this.Uc.tq();
                        Resources resources4 = this.mContext.getResources();
                        r7 = com.baidu.tieba.y.neterror;
                        tq4.mErrorString = resources4.getString(r7);
                        if (i == 0) {
                            TiebaStatic.net(this.Uc);
                        }
                        try {
                            ai.cH(this.Uc.tp().ts().mUrl);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e19) {
                        }
                        try {
                            if (this.vv != null) {
                                this.vv.disconnect();
                            }
                        } catch (Exception e20) {
                        }
                    } else if (!this.vv.getContentType().contains("text/vnd.wap.wml")) {
                        j = this.vv.getContentEncoding();
                        inputStream = this.vv.getInputStream();
                        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (headerField = this.vv.getHeaderField("Content-Length")) != null) {
                            try {
                                int parseInt = Integer.parseInt(headerField);
                                if (parseInt > Uh) {
                                    ai.cH(this.Uc.tp().ts().mUrl);
                                    try {
                                        ai.cH(this.Uc.tp().ts().mUrl);
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Exception e21) {
                                    }
                                    try {
                                        e = this.vv;
                                        if (e != 0) {
                                            e = this.vv;
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
                                        if (!com.baidu.tbadk.imageManager.e.zy().dE(i3)) {
                                            ai.cH(this.Uc.tp().ts().mUrl);
                                            try {
                                                ai.cH(this.Uc.tp().ts().mUrl);
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                            } catch (Exception e23) {
                                            }
                                            try {
                                                e = this.vv;
                                                if (e != 0) {
                                                    e = this.vv;
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
                        String headerField2 = this.vv.getHeaderField("imgsrc");
                        boolean z = false;
                        if (headerField2 != null && headerField2.length() > 0) {
                            z = true;
                        }
                        if (this.Uc.tp().ts().mIsBDImage || z) {
                            byte[] bArr3 = new byte[23];
                            int read2 = inputStream.read(bArr3, 0, 23);
                            if (!new String(bArr3, 0, bArr3.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                                byteArrayOutputStream.write(bArr3, 0, read2);
                                i4 = 0 + read2;
                            }
                        }
                        if (this.vv != null) {
                            if ("image/gif".equalsIgnoreCase(this.vv.getHeaderField("Src-Content-Type"))) {
                                this.Uc.tq().rC = true;
                            } else {
                                this.Uc.tq().rC = false;
                            }
                        }
                        while (!this.Um && i4 < Uh && (read = inputStream.read(bArr2)) != -1) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                            i4 += read;
                        }
                        if (this.Um) {
                            try {
                                ai.cH(this.Uc.tp().ts().mUrl);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Exception e25) {
                            }
                            try {
                                if (this.vv != null) {
                                    this.vv.disconnect();
                                }
                            } catch (Exception e26) {
                            }
                        } else {
                            this.mDataSize = i4;
                            long time = new Date().getTime() - r7;
                            this.Uc.tr().wo.vH = (time - this.Uc.tr().wo.vG) - this.Uc.tr().wo.vK;
                            if (i4 < Uh) {
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
                                        com.baidu.adp.lib.util.g.b(byteArrayInputStream, byteArrayOutputStream2);
                                        bArr = byteArrayOutputStream2.toByteArray();
                                    }
                                } catch (SocketException e27) {
                                    bArr = byteArray;
                                    e3 = e27;
                                    this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + i + "|" + e3.getClass() + "|" + e3.getMessage();
                                    this.Uc.tq().Wa = -12;
                                    al.UI.incrementAndGet();
                                    com.baidu.tbadk.core.util.httpNet.c tq5 = this.Uc.tq();
                                    Resources resources5 = this.mContext.getResources();
                                    r7 = com.baidu.tieba.y.neterror;
                                    tq5.mErrorString = resources5.getString(r7);
                                    if (i == 0) {
                                        TiebaStatic.net(this.Uc);
                                    }
                                    ai.cH(this.Uc.tp().ts().mUrl);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (this.vv == null) {
                                        this.vv.disconnect();
                                    }
                                    i++;
                                    inputStream = inputStream;
                                    r6 = r6;
                                } catch (SocketTimeoutException e28) {
                                    bArr = byteArray;
                                    e2 = e28;
                                    al.UI.incrementAndGet();
                                    this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + i + "|" + e2.getClass() + "|" + e2.getMessage();
                                    this.Uc.tq().Wa = -13;
                                    com.baidu.tbadk.core.util.httpNet.c tq22 = this.Uc.tq();
                                    Resources resources22 = this.mContext.getResources();
                                    r7 = com.baidu.tieba.y.neterror;
                                    tq22.mErrorString = resources22.getString(r7);
                                    if (i == 0) {
                                        TiebaStatic.net(this.Uc);
                                    }
                                    ai.cH(this.Uc.tp().ts().mUrl);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (this.vv == null) {
                                        this.vv.disconnect();
                                    }
                                    i++;
                                    inputStream = inputStream;
                                    r6 = r6;
                                } catch (Exception e29) {
                                    bArr = byteArray;
                                    e = e29;
                                    r7 = "|retryCount:";
                                    this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + i + "|" + e.getClass() + "|" + e.getMessage();
                                    this.Uc.tq().Wa = -10;
                                    com.baidu.tbadk.core.util.httpNet.c tq32 = this.Uc.tq();
                                    Resources resources32 = this.mContext.getResources();
                                    r6 = com.baidu.tieba.y.neterror;
                                    tq32.mErrorString = resources32.getString(r6);
                                    BdLog.e(e.getMessage());
                                    TiebaStatic.net(this.Uc);
                                    ai.cH(this.Uc.tp().ts().mUrl);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (this.vv != null) {
                                        this.vv.disconnect();
                                    }
                                    i = 0;
                                    this.Uk = 0;
                                    inputStream = inputStream;
                                    r6 = r6;
                                    r7 = r7;
                                    j = j;
                                    return bArr;
                                }
                            } else {
                                this.Uc.tq().Wa = -11;
                                com.baidu.tbadk.core.util.httpNet.c tq6 = this.Uc.tq();
                                Resources resources6 = this.mContext.getResources();
                                int i5 = com.baidu.tieba.y.data_too_big;
                                tq6.mErrorString = resources6.getString(i5);
                                j = i5;
                            }
                            this.Uc.tr().wo.vI = i + 1;
                            this.Uc.tr().wo.vJ = time;
                            am amVar = new am();
                            amVar.mMode = getMode(com.baidu.adp.lib.util.k.iM());
                            amVar.mSize = this.mDataSize;
                            amVar.mTime = time;
                            amVar.UK = i + 1;
                            amVar.UJ = 2;
                            com.baidu.adp.lib.network.http.d dVar2 = this.Uc.tr().wo;
                            r7 = this.mDataSize;
                            dVar2.vF = r7;
                            al.a(amVar);
                            TiebaStatic.net(this.Uc);
                            sz();
                            try {
                                ai.cH(this.Uc.tp().ts().mUrl);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Exception e30) {
                            }
                            try {
                                if (this.vv != null) {
                                    this.vv.disconnect();
                                }
                            } catch (Exception e31) {
                            }
                        }
                    } else if (this.Uk < 1) {
                        this.vv.disconnect();
                        this.Uk++;
                        this.Uc.tq().Wa = 0;
                        i--;
                        try {
                            ai.cH(this.Uc.tp().ts().mUrl);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e32) {
                        }
                        try {
                            if (this.vv != null) {
                                this.vv.disconnect();
                            }
                        } catch (Exception e33) {
                        }
                    } else {
                        try {
                            ai.cH(this.Uc.tp().ts().mUrl);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e34) {
                        }
                        try {
                            if (this.vv != null) {
                                this.vv.disconnect();
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
            this.Uk = 0;
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
        if (this.vv != null) {
            str = this.vv.getContentType();
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

    public void cF(String str) {
        this.Uc.tq().Wb = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.Uc.tq().Wb = errorData.getError_code();
                if (this.Uc.tq().Wb == -1) {
                    this.Uc.tq().mErrorString = this.mContext.getString(com.baidu.tieba.y.error_unkown_try_again);
                } else if (this.Uc.tq().Wb != 0) {
                    this.Uc.tq().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.Uc.tq().mErrorString = this.mContext.getString(com.baidu.tieba.y.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String rQ() {
        String str;
        Exception e;
        byte[] rP = rP();
        if (this.Uc.tq().Wa != 200) {
            return null;
        }
        try {
            str = new String(rP, 0, rP.length, getCharset());
        } catch (Exception e2) {
            str = null;
            e = e2;
        }
        try {
            cF(str);
            return str;
        } catch (Exception e3) {
            e = e3;
            BdLog.e(e.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1000=12, 1001=12, 1002=12, 1007=12, 1008=12, 1010=4] */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x039d, code lost:
        com.baidu.tbadk.core.util.ai.cH(r14.Uc.tp().ts().mUrl);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x03ac, code lost:
        if (0 == 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x03ae, code lost:
        r3.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:222:0x063f A[Catch: Exception -> 0x064e, TRY_LEAVE, TryCatch #16 {Exception -> 0x064e, blocks: (B:220:0x062e, B:222:0x063f), top: B:292:0x062e }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0646 A[Catch: Exception -> 0x064c, TRY_LEAVE, TryCatch #18 {Exception -> 0x064c, blocks: (B:223:0x0642, B:225:0x0646), top: B:296:0x0642 }] */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String rO() {
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
            int cG = ai.cG(this.Uc.tp().ts().mUrl);
            if (cG > 0) {
                ai.sE().bW(cG);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.Uc.tp().ts().Wp == null || i2 >= this.Uc.tp().ts().Wp.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.Uc.tp().ts().Wp.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(name) + "=");
                sb.append(bd.aM(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.Uc.tp().ts().mIsBaiduServer) {
            sb2.append("tiebaclient!!!");
            String md5 = com.baidu.adp.lib.util.ab.toMd5(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(md5);
        }
        String sb3 = sb.toString();
        if (sb3 != null) {
            this.Uc.tr().wo.vE = sb3.getBytes().length;
        }
        TbConfig.getDebugSwitch();
        int i3 = 0;
        boolean z = true;
        String str = null;
        while (true) {
            if (this.Um || !z || i3 >= 5) {
                break;
            }
            InputStream inputStream4 = null;
            try {
                try {
                    url = new URL(this.Uc.tp().ts().mUrl);
                    this.vv = a(url);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ai.cH(this.Uc.tp().ts().mUrl);
                        if (inputStream4 != null) {
                            inputStream4.close();
                        }
                    } catch (Exception e2) {
                    }
                    try {
                        if (this.vv != null) {
                            this.vv.disconnect();
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
            if (this.vv == null) {
                this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                try {
                    ai.cH(this.Uc.tp().ts().mUrl);
                    if (0 != 0) {
                        inputStream4.close();
                    }
                } catch (Exception e6) {
                }
                try {
                    if (this.vv != null) {
                        this.vv.disconnect();
                    }
                } catch (Exception e7) {
                }
            } else {
                this.vv.setConnectTimeout(5000);
                this.vv.setReadTimeout(15000);
                this.vv.setDoOutput(true);
                this.vv.setDoInput(true);
                this.vv.setRequestMethod("POST");
                this.vv.setRequestProperty("Charset", "UTF-8");
                this.vv.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                if (this.Uc.tp().ts().Wr) {
                    this.vv.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.Um) {
                    try {
                        ai.cH(this.Uc.tp().ts().mUrl);
                        if (0 != 0) {
                            inputStream4.close();
                        }
                    } catch (Exception e8) {
                    }
                    try {
                        if (this.vv != null) {
                            this.vv.disconnect();
                        }
                    } catch (Exception e9) {
                    }
                } else {
                    long time = new Date().getTime();
                    b(url);
                    this.Uc.tr().wo.vK = new Date().getTime() - time;
                    this.vv.connect();
                    this.Uc.tr().wo.vG = (new Date().getTime() - time) - this.Uc.tr().wo.vK;
                    DataOutputStream dataOutputStream = new DataOutputStream(this.vv.getOutputStream());
                    if (!this.Um) {
                        dataOutputStream.writeBytes(sb3);
                    }
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (this.vv != null) {
                        if ("image/gif".equalsIgnoreCase(this.vv.getHeaderField("Src-Content-Type"))) {
                            this.Uc.tq().rC = true;
                        } else {
                            this.Uc.tq().rC = false;
                        }
                    }
                    this.Uc.tq().Wa = this.vv.getResponseCode();
                    if (this.Uc.tq().Wa != 200) {
                        if (this.Uc.tq().Wa != 202 && this.Uc.tq().Wa != 201 && this.Uc.tq().Wa != 205 && this.Uc.tq().Wa != 304 && this.Uc.tq().Wa != 305 && this.Uc.tq().Wa != 408) {
                            if (this.Uc.tq().Wa == 502 || this.Uc.tq().Wa == 503 || this.Uc.tq().Wa == 504) {
                                break;
                            }
                        } else {
                            this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + i3;
                            al.UI.incrementAndGet();
                            z = true;
                            this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                            if (i3 == 0) {
                                TiebaStatic.net(this.Uc);
                            }
                            try {
                                ai.cH(this.Uc.tp().ts().mUrl);
                                if (0 != 0) {
                                    inputStream4.close();
                                }
                            } catch (Exception e10) {
                            }
                            try {
                                if (this.vv != null) {
                                    this.vv.disconnect();
                                }
                            } catch (Exception e11) {
                            }
                            i3++;
                        }
                    }
                    if (!this.Uc.tp().ts().mIsBaiduServer || !this.vv.getContentType().contains("text/vnd.wap.wml")) {
                        String contentEncoding = this.vv.getContentEncoding();
                        InputStream inputStream5 = this.vv.getInputStream();
                        try {
                            byte[] bArr2 = new byte[1024];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                            int i4 = 0;
                            while (!this.Um && (read = inputStream5.read(bArr2)) != -1) {
                                byteArrayOutputStream.write(bArr2, 0, read);
                                i4 += read;
                            }
                            inputStream5.close();
                            this.vv.disconnect();
                            if (this.Um) {
                                try {
                                    ai.cH(this.Uc.tp().ts().mUrl);
                                    if (inputStream5 != null) {
                                        inputStream5.close();
                                    }
                                } catch (Exception e12) {
                                }
                                try {
                                    if (this.vv != null) {
                                        this.vv.disconnect();
                                    }
                                } catch (Exception e13) {
                                }
                            } else {
                                this.mDataSize = i4;
                                long time2 = new Date().getTime() - time;
                                this.Uc.tr().wo.vH = (time2 - this.Uc.tr().wo.vG) - this.Uc.tr().wo.vK;
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                this.Uc.tq().mHeader = this.vv.getHeaderFields();
                                if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                    bArr = byteArray;
                                } else {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                    com.baidu.adp.lib.util.g.b(byteArrayInputStream, byteArrayOutputStream2);
                                    bArr = byteArrayOutputStream2.toByteArray();
                                }
                                String str2 = new String(bArr, 0, bArr.length, getCharset());
                                try {
                                    if (this.Uc.tp().ts().mIsBaiduServer && this.Uc.tp().ts().Ws) {
                                        cF(str2);
                                    }
                                    this.Uc.tr().wo.vI = i3 + 1;
                                    this.Uc.tr().wo.vJ = time2;
                                    am amVar = new am();
                                    amVar.mMode = getMode(com.baidu.adp.lib.util.k.iM());
                                    amVar.mSize = this.mDataSize;
                                    amVar.mTime = time2;
                                    amVar.UK = i3 + 1;
                                    amVar.UJ = 1;
                                    al.a(amVar);
                                    this.Uc.tr().wo.vF = this.mDataSize;
                                    TiebaStatic.net(this.Uc);
                                    sz();
                                    try {
                                        ai.cH(this.Uc.tp().ts().mUrl);
                                        if (inputStream5 != null) {
                                            inputStream5.close();
                                        }
                                    } catch (Exception e14) {
                                    }
                                    try {
                                        if (this.vv != null) {
                                            this.vv.disconnect();
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
                                    al.UI.incrementAndGet();
                                    this.Uc.tq().Wa = -12;
                                    z = true;
                                    this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                                    BdLog.e(socketException.getMessage());
                                    if (i3 == 0) {
                                        TiebaStatic.net(this.Uc);
                                    }
                                    try {
                                        ai.cH(this.Uc.tp().ts().mUrl);
                                        if (inputStream3 != null) {
                                            inputStream3.close();
                                        }
                                    } catch (Exception e17) {
                                    }
                                    try {
                                        if (this.vv != null) {
                                            this.vv.disconnect();
                                        }
                                    } catch (Exception e18) {
                                    }
                                    i3++;
                                } catch (SocketTimeoutException e19) {
                                    inputStream2 = inputStream5;
                                    socketTimeoutException = e19;
                                    str = str2;
                                    try {
                                        al.UI.incrementAndGet();
                                        this.Uc.tq().Wa = -13;
                                        z = true;
                                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                                        BdLog.e(socketTimeoutException.getMessage());
                                        if (i3 == 0) {
                                            TiebaStatic.net(this.Uc);
                                        }
                                        try {
                                            ai.cH(this.Uc.tp().ts().mUrl);
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                        } catch (Exception e20) {
                                        }
                                        try {
                                            if (this.vv != null) {
                                                this.vv.disconnect();
                                            }
                                        } catch (Exception e21) {
                                        }
                                        i3++;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        inputStream4 = inputStream2;
                                        ai.cH(this.Uc.tp().ts().mUrl);
                                        if (inputStream4 != null) {
                                        }
                                        if (this.vv != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    inputStream = inputStream5;
                                    th = th5;
                                    str = str2;
                                    this.Uc.tq().Wa = -10;
                                    z = false;
                                    this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                                    BdLog.e(th.getMessage());
                                    TiebaStatic.net(this.Uc);
                                    try {
                                        ai.cH(this.Uc.tp().ts().mUrl);
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Exception e22) {
                                    }
                                    try {
                                        if (this.vv != null) {
                                            this.vv.disconnect();
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
                    } else if (this.Uk < 1) {
                        this.vv.disconnect();
                        this.Uk++;
                        this.Uc.tq().Wa = 0;
                        i3--;
                        try {
                            ai.cH(this.Uc.tp().ts().mUrl);
                            if (0 != 0) {
                                inputStream4.close();
                            }
                        } catch (Exception e26) {
                        }
                        try {
                            if (this.vv != null) {
                                this.vv.disconnect();
                            }
                        } catch (Exception e27) {
                        }
                        i3++;
                    } else {
                        try {
                            ai.cH(this.Uc.tp().ts().mUrl);
                            if (0 != 0) {
                                inputStream4.close();
                            }
                        } catch (Exception e28) {
                        }
                        try {
                            if (this.vv != null) {
                                this.vv.disconnect();
                            }
                        } catch (Exception e29) {
                        }
                    }
                }
            }
        }
        this.Uk = 0;
        return str;
        try {
            if (this.vv != null) {
                this.vv.disconnect();
            }
        } catch (Exception e30) {
        }
        return null;
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1209=11, 1210=11, 1215=11, 1216=11, 1221=11, 1222=11, 1226=11, 1227=11] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0378 A[Catch: all -> 0x057f, TRY_LEAVE, TryCatch #30 {all -> 0x057f, blocks: (B:41:0x0104, B:43:0x0112, B:45:0x0124, B:76:0x0236, B:78:0x024a, B:79:0x024f, B:47:0x0128, B:49:0x012c, B:51:0x013a, B:52:0x014e, B:97:0x02f1, B:100:0x0309, B:54:0x0154, B:56:0x0190, B:57:0x019f, B:59:0x01b1, B:60:0x01b7, B:62:0x01c3, B:64:0x020a, B:117:0x039c, B:119:0x03aa, B:121:0x03af, B:123:0x03bc, B:186:0x04d1, B:104:0x0357, B:106:0x0378, B:144:0x0405), top: B:348:0x0104 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0386 A[Catch: Exception -> 0x05a0, TRY_LEAVE, TryCatch #27 {Exception -> 0x05a0, blocks: (B:109:0x0382, B:111:0x0386), top: B:344:0x0382 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0505 A[Catch: Exception -> 0x0585, TRY_LEAVE, TryCatch #26 {Exception -> 0x0585, blocks: (B:189:0x0501, B:191:0x0505), top: B:342:0x0501 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0526 A[Catch: Exception -> 0x0579, TRY_LEAVE, TryCatch #23 {Exception -> 0x0579, blocks: (B:201:0x0522, B:203:0x0526), top: B:340:0x0522 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x038d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x037f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x052d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x051f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x050c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x04fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:330:0x02e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x02d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x022f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x022f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:400:0x022f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02cd A[Catch: all -> 0x057b, TRY_LEAVE, TryCatch #29 {all -> 0x057b, blocks: (B:84:0x02ad, B:86:0x02cd), top: B:346:0x02ad }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02db A[Catch: Exception -> 0x05ba, TRY_LEAVE, TryCatch #46 {Exception -> 0x05ba, blocks: (B:89:0x02d7, B:91:0x02db), top: B:370:0x02d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02e9  */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String rR() {
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
            if (this.Um || !z2 || i2 >= 5) {
                break;
            }
            InputStream inputStream2 = null;
            DataOutputStream dataOutputStream3 = null;
            try {
                this.vv = a(new URL(this.Uc.tp().ts().mUrl));
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
            if (this.vv == null) {
                this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                    }
                }
                try {
                    if (this.vv != null) {
                        this.vv.disconnect();
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
                this.vv.setConnectTimeout(5000);
                this.vv.setReadTimeout(15000);
                this.vv.setDoOutput(true);
                this.vv.setDoInput(true);
                this.vv.setRequestMethod("POST");
                this.vv.setRequestProperty("Charset", "UTF-8");
                this.vv.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
                this.Uc.tq().mHeader = this.vv.getHeaderFields();
                if (this.Uc.tp().ts().Wr) {
                    this.vv.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.Um) {
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e8) {
                        }
                    }
                    try {
                        if (this.vv != null) {
                            this.vv.disconnect();
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
                    this.vv.connect();
                    dataOutputStream = new DataOutputStream(this.vv.getOutputStream());
                    for (int i3 = 0; this.Uc.tp().ts().Wp != null && i3 < this.Uc.tp().ts().Wp.size() && !this.Um; i3++) {
                        try {
                            try {
                                BasicNameValuePair basicNameValuePair = this.Uc.tp().ts().Wp.get(i3);
                                if (basicNameValuePair != null) {
                                    String name = basicNameValuePair.getName();
                                    String value = basicNameValuePair.getValue();
                                    dataOutputStream.writeBytes(String.valueOf(wf) + boundary + we);
                                    byte[] bytes = value.getBytes("UTF-8");
                                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + we);
                                    dataOutputStream.writeBytes(we);
                                    dataOutputStream.write(bytes);
                                    dataOutputStream.writeBytes(we);
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
                    if (!this.Um && this.Uc.tp().ts().Wq != null) {
                        for (Map.Entry<String, byte[]> entry : this.Uc.tp().ts().Wq.entrySet()) {
                            String key = entry.getKey();
                            byte[] value2 = entry.getValue();
                            if (this.Um) {
                                break;
                            } else if (value2 != null) {
                                dataOutputStream.writeBytes(String.valueOf(wf) + boundary + we);
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + we);
                                dataOutputStream.writeBytes(we);
                                dataOutputStream.write(value2);
                                dataOutputStream.writeBytes(we);
                            }
                        }
                    }
                    dataOutputStream.writeBytes(String.valueOf(wf) + boundary + wf + we);
                    this.Uc.tr().wo.vE = dataOutputStream.size();
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (mHandler != null) {
                        mHandler.sendMessageDelayed(mHandler.obtainMessage(0, this), 45000L);
                    }
                    this.Uc.tq().Wa = this.vv.getResponseCode();
                    if (mHandler != null) {
                        mHandler.removeMessages(0, this);
                    }
                    if (this.Uc.tq().Wa != 200) {
                        this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + i2;
                        al.UI.incrementAndGet();
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        if (i2 == 0) {
                            TiebaStatic.net(this.Uc);
                        }
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e14) {
                            }
                        }
                        try {
                            if (this.vv != null) {
                                this.vv.disconnect();
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
                    } else if (!this.vv.getContentType().contains("text/vnd.wap.wml")) {
                        String contentEncoding = this.vv.getContentEncoding();
                        InputStream inputStream3 = this.vv.getInputStream();
                        try {
                            try {
                                byte[] bArr2 = new byte[1024];
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                while (!this.Um && (read = inputStream3.read(bArr2)) != -1) {
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                }
                                if (this.Um) {
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e17) {
                                        }
                                    }
                                    try {
                                        if (this.vv != null) {
                                            this.vv.disconnect();
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
                                    this.vv.disconnect();
                                    long time2 = new Date().getTime() - time;
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                        bArr = byteArray;
                                    } else {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                        com.baidu.adp.lib.util.g.b(byteArrayInputStream, byteArrayOutputStream2);
                                        bArr = byteArrayOutputStream2.toByteArray();
                                    }
                                    String str3 = new String(bArr, 0, bArr.length, getCharset());
                                    try {
                                        this.Uc.tr().wo.vF = bArr.length;
                                        cF(str3);
                                        TiebaStatic.net(this.Uc);
                                        sz();
                                        if (inputStream3 != null) {
                                            try {
                                                inputStream3.close();
                                            } catch (Exception e20) {
                                            }
                                        }
                                        try {
                                            if (this.vv != null) {
                                                this.vv.disconnect();
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
                                        this.Uc.tq().Wa = -12;
                                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                                        if (i == 0) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (this.vv != null) {
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
                                        this.Uc.tq().Wa = -13;
                                        z = true;
                                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                                        if (i == 0) {
                                        }
                                        if (inputStream2 != null) {
                                        }
                                        if (this.vv != null) {
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
                                        this.Uc.tq().Wa = -10;
                                        z = false;
                                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                                        BdLog.e(e.getMessage());
                                        TiebaStatic.net(this.Uc);
                                        if (inputStream2 != null) {
                                        }
                                        if (this.vv != null) {
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
                                if (this.vv != null) {
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
                    } else if (this.Uk < 1) {
                        this.vv.disconnect();
                        this.Uk++;
                        i = i2 - 1;
                        try {
                            this.Uc.tq().Wa = 0;
                            if (0 != 0) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e29) {
                                }
                            }
                            try {
                                if (this.vv != null) {
                                    this.vv.disconnect();
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
                                this.Uc.tq().Wa = -12;
                                this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                                if (i == 0) {
                                    TiebaStatic.net(this.Uc);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e33) {
                                    }
                                }
                                try {
                                    if (this.vv != null) {
                                        this.vv.disconnect();
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
                                    if (this.vv != null) {
                                        this.vv.disconnect();
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
                            this.Uc.tq().Wa = -13;
                            z = true;
                            this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                            if (i == 0) {
                                TiebaStatic.net(this.Uc);
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e40) {
                                }
                            }
                            try {
                                if (this.vv != null) {
                                    this.vv.disconnect();
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
                            this.Uc.tq().Wa = -10;
                            z = false;
                            this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                            BdLog.e(e.getMessage());
                            TiebaStatic.net(this.Uc);
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e44) {
                                }
                            }
                            try {
                                if (this.vv != null) {
                                    this.vv.disconnect();
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
                            if (this.vv != null) {
                                this.vv.disconnect();
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
        this.Uk = 0;
        return str2;
    }

    public boolean hi() {
        return this.Uc.tq().Wa == 200 || this.Uc.tq().Wa == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1377=4, 1388=8, 1390=8, 1391=8, 1396=8, 1397=8, 1402=8, 1403=8] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0324 A[Catch: Exception -> 0x0356, TRY_LEAVE, TryCatch #20 {Exception -> 0x0356, blocks: (B:165:0x0320, B:167:0x0324), top: B:257:0x0320 }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x032b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x031d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        boolean z2;
        FileOutputStream fileOutputStream2;
        InputStream inputStream;
        int i4;
        String headerField;
        int indexOf;
        InputStream inputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        try {
            this.vv = a(new URL(this.Uc.tp().ts().mUrl));
            if (this.Uc.tp().ts().mUrl != null) {
                this.Uc.tr().wo.vE = this.Uc.tp().ts().mUrl.getBytes().length;
            }
            if (this.vv == null) {
                throw new SocketException();
            }
            this.vv.setConnectTimeout(5000);
            this.vv.setReadTimeout(30000);
            this.vv.setInstanceFollowRedirects(false);
            if (this.Um) {
                this.Uk = 0;
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e) {
                    }
                }
                try {
                    if (this.vv != null) {
                        this.vv.disconnect();
                    }
                } catch (Exception e2) {
                }
                if (0 != 0) {
                    try {
                        fileOutputStream3.close();
                    } catch (Exception e3) {
                    }
                }
                return false;
            }
            File file = z ? new File(str) : o.cp(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            fileOutputStream = new FileOutputStream(file, true);
            try {
                try {
                    try {
                        if (this.Ul) {
                            this.vv.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-" + String.valueOf(200000 + length));
                        } else {
                            this.vv.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        }
                        this.vv.connect();
                        this.Uc.tq().mHeader = this.vv.getHeaderFields();
                        this.Uc.tq().Wa = this.vv.getResponseCode();
                        if (!hi()) {
                            this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                            TiebaStatic.net(this.Uc);
                            this.Uk = 0;
                            if (0 != 0) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e4) {
                                }
                            }
                            try {
                                if (this.vv != null) {
                                    this.vv.disconnect();
                                }
                            } catch (Exception e5) {
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e6) {
                                }
                            }
                            return false;
                        } else if (this.vv.getContentType().contains("text/vnd.wap.wml") && this.Uk < 1) {
                            this.vv.disconnect();
                            this.Uk++;
                            this.Uc.tq().Wa = 0;
                            boolean a = a(str, handler, i, i2, i3, z);
                            this.Uk = 0;
                            if (0 != 0) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e7) {
                                }
                            }
                            try {
                                if (this.vv != null) {
                                    this.vv.disconnect();
                                }
                            } catch (Exception e8) {
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return a;
                                } catch (Exception e9) {
                                    return a;
                                }
                            }
                            return a;
                        } else {
                            this.Uk = 0;
                            int i5 = 0;
                            String headerField2 = this.vv.getHeaderField("Content-Range");
                            if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                                i5 = com.baidu.adp.lib.g.c.toInt(headerField2.substring(indexOf + 1), 0);
                            }
                            int i6 = (i5 == 0 && this.Uc.tq().Wa == 200 && (headerField = this.vv.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.c.toInt(headerField, 0) : i5;
                            if (length >= i6) {
                                this.Uk = 0;
                                if (0 != 0) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e10) {
                                    }
                                }
                                try {
                                    if (this.vv != null) {
                                        this.vv.disconnect();
                                    }
                                } catch (Exception e11) {
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e12) {
                                    }
                                }
                                return true;
                            }
                            inputStream2 = this.vv.getInputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                i4 = 0;
                                int i7 = i6 > 0 ? i6 / 50 : 0;
                                int i8 = 0;
                                if (handler != null && length > 0) {
                                    handler.sendMessage(handler.obtainMessage(i, (int) length, i6));
                                }
                                while (!this.Um) {
                                    int read = inputStream2.read(bArr);
                                    if (read != -1) {
                                        try {
                                            fileOutputStream.write(bArr, 0, read);
                                            i4 += read;
                                            i8 += read;
                                            if (handler != null && (i8 > i7 || i4 == i6)) {
                                                i8 = 0;
                                                handler.sendMessage(handler.obtainMessage(i, (int) (i4 + length), i6));
                                            }
                                        } catch (Exception e13) {
                                            throw new FileNotFoundException();
                                        }
                                    }
                                }
                                try {
                                    fileOutputStream.flush();
                                    z2 = length + ((long) i4) >= ((long) i6);
                                } catch (Exception e14) {
                                    throw new FileNotFoundException();
                                }
                            } catch (FileNotFoundException e15) {
                                z2 = false;
                                inputStream = inputStream2;
                            }
                            try {
                                this.Uc.tr().wo.vF = i4;
                                sz();
                                this.Uk = 0;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e16) {
                                    }
                                }
                                try {
                                    if (this.vv != null) {
                                        this.vv.disconnect();
                                    }
                                } catch (Exception e17) {
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return z2;
                                    } catch (Exception e18) {
                                        return z2;
                                    }
                                }
                                return z2;
                            } catch (FileNotFoundException e19) {
                                inputStream = inputStream2;
                                try {
                                    TiebaStatic.net(this.Uc);
                                    this.Uc.tq().Wa = -100;
                                    this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.FileWriteError);
                                    this.Uk = 0;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e20) {
                                        }
                                    }
                                    try {
                                        if (this.vv != null) {
                                            this.vv.disconnect();
                                        }
                                    } catch (Exception e21) {
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            return z2;
                                        } catch (Exception e22) {
                                            return z2;
                                        }
                                    }
                                    return z2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream2 = inputStream;
                                    this.Uk = 0;
                                    if (inputStream2 != null) {
                                    }
                                    try {
                                        if (this.vv != null) {
                                        }
                                    } catch (Exception e23) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    throw th;
                                }
                            } catch (Exception e24) {
                                fileOutputStream2 = fileOutputStream;
                                e = e24;
                                try {
                                    TiebaStatic.net(this.Uc);
                                    this.Uc.tq().Wa = -10;
                                    this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                                    BdLog.e(e.getMessage());
                                    this.Uk = 0;
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e25) {
                                        }
                                    }
                                    try {
                                        if (this.vv != null) {
                                            this.vv.disconnect();
                                        }
                                    } catch (Exception e26) {
                                    }
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                            return z2;
                                        } catch (Exception e27) {
                                            return z2;
                                        }
                                    }
                                    return z2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = fileOutputStream2;
                                    this.Uk = 0;
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e28) {
                                        }
                                    }
                                    if (this.vv != null) {
                                        this.vv.disconnect();
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception e29) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    } catch (FileNotFoundException e30) {
                        z2 = false;
                        inputStream = null;
                    }
                } catch (Exception e31) {
                    z2 = false;
                    fileOutputStream2 = fileOutputStream;
                    e = e31;
                }
            } catch (Throwable th4) {
                th = th4;
                this.Uk = 0;
                if (inputStream2 != null) {
                }
                if (this.vv != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e32) {
            fileOutputStream = null;
            z2 = false;
            inputStream = null;
        } catch (Exception e33) {
            e = e33;
            z2 = false;
            fileOutputStream2 = null;
        } catch (Throwable th5) {
            fileOutputStream = null;
            th = th5;
        }
    }

    private void sz() {
        if (com.baidu.adp.b.a.lX() != null && this.Uc != null && this.Uc.tr() != null && this.Uc.tq() != null && this.Uc.tr().wo != null) {
            com.baidu.adp.b.a.lX().b(com.baidu.adp.lib.util.n.c(this.Uc.tq().mHeader, "Content-Type"), this.Uc.tr().wo.vE, this.Uc.tr().wo.vF);
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public ArrayList<BasicNameValuePair> rM() {
        return this.Uc.tp().ts().Wp;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void o(ArrayList<BasicNameValuePair> arrayList) {
        if (this.Uc.tp().ts().Wp != null) {
            this.Uc.tp().ts().Wp.clear();
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

    @Override // com.baidu.tbadk.core.util.s
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void g(String str, byte[] bArr) {
        if (this.Uc.tp().ts().Wq == null) {
            this.Uc.tp().ts().Wq = new HashMap<>();
        }
        this.Uc.tp().ts().Wq.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.Uc.tp().ts().Wp == null) {
                this.Uc.tp().ts().Wp = new ArrayList<>();
            }
            int a = a(this.Uc.tp().ts().Wp, basicNameValuePair.getName());
            int size = this.Uc.tp().ts().Wp.size();
            if (a >= 0 && a < size) {
                if (basicNameValuePair.getName().equals(this.Uc.tp().ts().Wp.get(a).getName())) {
                    this.Uc.tp().ts().Wp.set(a, basicNameValuePair);
                } else {
                    this.Uc.tp().ts().Wp.add(a, basicNameValuePair);
                }
            } else if (a == size) {
                this.Uc.tp().ts().Wp.add(a, basicNameValuePair);
            }
        }
    }

    private int a(ArrayList<BasicNameValuePair> arrayList, String str) {
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
