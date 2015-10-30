package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.i;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x implements q {
    private static int ZY = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a ZT;
    private com.baidu.adp.lib.network.a.a ZZ = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public x(com.baidu.tbadk.core.util.a.a aVar) {
        ud();
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
        this.ZT = aVar;
        com.baidu.adp.lib.network.a.a.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
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

    private void ud() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void gJ() {
        this.ZZ.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0391 -> B:91:0x0392). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] tE() {
        com.baidu.adp.lib.network.http.g gVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.adp.lib.network.http.g gVar2;
        byte[] bArr;
        String str;
        int size;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.a.a.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.ZT.uV().uY().acj != null && this.ZT.uV().uY().acj.size() > 0 && !this.ZT.uV().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.ZT.uV().uY().mUrl);
                if (this.ZT.uV().uY().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.ZT.uV().uY().mUrl.endsWith("?") && !this.ZT.uV().uY().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.ZT.uV().uY().acj.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.ZT.uV().uY().acj.get(i).getName());
                    sb.append("=");
                    sb.append(as.aR(this.ZT.uV().uY().acj.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.ZT.uV().uY().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.ZT.uV().uY().acl || this.ZT.uV().uY().mIsBDImage) && !this.ZT.uV().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            gVar2 = null;
        } catch (OutOfMemoryError e2) {
            e = e2;
            gVar = null;
        } catch (SocketException e3) {
            e = e3;
            gVar = null;
        } catch (SocketTimeoutException e4) {
            e = e4;
            gVar = null;
        } catch (Exception e5) {
            e = e5;
            gVar = null;
        }
        if (this.ZZ.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.ZZ.a(str, z, 5, 100, -1, -1, ul());
        com.baidu.adp.lib.network.http.e gX = this.ZZ.gX();
        if (gX == null) {
            return null;
        }
        gVar = gX.gQ();
        if (gX != null) {
            try {
                if (gX.gR() != null && (size = gX.gR().size()) > 0) {
                    this.ZT.uX().abU = gX.gR().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZT.uW().abT = String.valueOf(String.valueOf(this.ZT.uW().abR)) + "|retryCount:" + (this.ZT.uX().abU == null ? -1 : this.ZT.uX().abU.uO) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.ZT.uW().abR = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
                this.ZT.uW().abT = String.valueOf(String.valueOf(this.ZT.uW().abR)) + "|retryCount:" + (this.ZT.uX().abU != null ? this.ZT.uX().abU.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZT.uW().abR = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ZT);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZT.uW().abT = String.valueOf(String.valueOf(this.ZT.uW().abR)) + "|retryCount:" + (this.ZT.uX().abU != null ? this.ZT.uX().abU.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZT.uW().abR = -12;
                TiebaStatic.net(this.ZT);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZT.uW().abT = String.valueOf(String.valueOf(this.ZT.uW().abR)) + "|retryCount:" + (this.ZT.uX().abU != null ? this.ZT.uX().abU.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZT.uW().abR = -13;
                TiebaStatic.net(this.ZT);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.ZT.uW().mErrorString = String.valueOf(this.mContext.getResources().getString(i.h.neterror)) + " detailException:" + e.getMessage();
                this.ZT.uW().abT = String.valueOf(String.valueOf(this.ZT.uW().abR)) + "|retryCount:" + (this.ZT.uX().abU != null ? this.ZT.uX().abU.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZT.uW().abR = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ZT);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.ZT.uW().abR = gVar.responseCode;
        if (this.ZT.uW().abR != 200) {
            this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.neterror);
            if (this.ZT.uX().abU != null && !TextUtils.isEmpty(this.ZT.uX().abU.uR)) {
                this.ZT.uW().abT = this.ZT.uX().abU.uR;
            } else {
                this.ZT.uW().abT = String.valueOf(String.valueOf(this.ZT.uW().abR)) + "|retryCount:" + (this.ZT.uX().abU == null ? -1 : this.ZT.uX().abU.uO);
            }
            TiebaStatic.net(this.ZT);
            return null;
        }
        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > ZY) {
                    this.ZT.uW().abR = -11;
                    TiebaStatic.net(this.ZT);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.Cc().en(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.ZT.uV().uY().mUrl + "], size:" + i2);
                            this.ZT.uW().abR = -16;
                            TiebaStatic.net(this.ZT);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.iS());
        aVar.mSize = this.ZT.uX().abU.uL;
        aVar.mTime = new Date().getTime() - j;
        aVar.aao = this.ZT.uX().abU.uO;
        aVar.aan = 2;
        aa.a(aVar);
        aa.aam.set(this.ZT.uX().abU.uO);
        TiebaStatic.net(this.ZT);
        bArr = gVar == null ? gVar.vf : null;
        return bArr;
    }

    public void df(String str) {
        this.ZT.uW().abS = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.ZT.uW().abS = errorData.getError_code();
                if (this.ZT.uW().abS == -1) {
                    this.ZT.uW().mErrorString = this.mContext.getString(i.h.error_unkown_try_again);
                } else if (this.ZT.uW().abS != 0) {
                    this.ZT.uW().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.ZT.uW().mErrorString = this.mContext.getString(i.h.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String tF() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] tE = tE();
        if (tE == null || this.ZT.uW().abR != 200) {
            return null;
        }
        try {
            this.ZT.uV().uY().acn = TextUtils.isEmpty(this.ZT.uV().uY().acn) ? "UTF-8" : this.ZT.uV().uY().acn;
            str = new String(tE, 0, tE.length, this.ZT.uV().uY().acn);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            df(str);
            return str;
        } catch (Exception e5) {
            e2 = e5;
            BdLog.e(e2.getMessage());
            return str;
        } catch (OutOfMemoryError e6) {
            e = e6;
            BdLog.e(e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String tD() {
        Throwable th;
        String str;
        OutOfMemoryError e;
        Exception e2;
        SocketTimeoutException e3;
        SocketException e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        int size;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.ZT.uV().uY().acj == null || i2 >= this.ZT.uV().uY().acj.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.ZT.uV().uY().acj.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.ZT.uV().uY().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.ZZ.isCanceled()) {
                return null;
            }
            if (this.ZZ.a(this.ZT.uV().uY().mUrl, this.ZT.uV().uY().acj, this.ZT.uV().uY().acl, 5, -1, ul()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e gX = this.ZZ.gX();
            if (gX == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g gQ = gX.gQ();
            if (gX != null && gX.gR() != null && (size = gX.gR().size()) > 0) {
                this.ZT.uX().abU = gX.gR().get(size - 1);
            }
            this.ZT.uW().abR = gQ.responseCode;
            this.ZT.uW().mHeader = gQ.ve;
            if (this.ZT.uW().abR != 200) {
                if (this.ZT.uX().abU != null && !TextUtils.isEmpty(this.ZT.uX().abU.uR)) {
                    this.ZT.uW().abT = this.ZT.uX().abU.uR;
                } else {
                    this.ZT.uW().abT = String.valueOf(String.valueOf(this.ZT.uW().abR)) + "|retryCount:" + (this.ZT.uX().abU == null ? -1 : this.ZT.uX().abU.uO);
                }
                TiebaStatic.net(this.ZT);
                return null;
            } else if (this.ZZ.isCanceled()) {
                return null;
            } else {
                str = new String(gQ.vf, "utf-8");
                try {
                    if (this.ZT.uV().uY().mIsBaiduServer && this.ZT.uV().uY().acm) {
                        df(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.iS());
                    aVar.mSize = this.ZT.uX().abU.uL;
                    aVar.mTime = this.ZT.uX().abU.uP;
                    aVar.aao = this.ZT.uX().abU.uO;
                    aVar.aan = 1;
                    aa.a(aVar);
                    aa.aam.set(this.ZT.uX().abU.uO);
                    TiebaStatic.net(this.ZT);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    this.ZT.uW().abT = String.valueOf(String.valueOf(this.ZT.uW().abR)) + "|retryCount:" + (this.ZT.uX().abU == null ? -1 : this.ZT.uX().abU.uO) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.ZT.uW().abR = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.ZT.uW().abR = -15;
                    this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.ZT);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.ZT.uW().abR = -12;
                    this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.ZT);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.ZT.uW().abR = -13;
                    this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.ZT);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.ZT.uW().abR = -10;
                    this.ZT.uW().mErrorString = String.valueOf(this.mContext.getResources().getString(i.h.neterror)) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.ZT);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.ZT.uW().abR = -10;
                    this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.ZT);
                    return str;
                }
            }
        } catch (BdHttpCancelException e10) {
            bdHttpCancelException = e10;
            str2 = null;
        } catch (SocketException e11) {
            e4 = e11;
            str = null;
        } catch (SocketTimeoutException e12) {
            e3 = e12;
            str = null;
        } catch (Exception e13) {
            e2 = e13;
            str = null;
        } catch (OutOfMemoryError e14) {
            e = e14;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* loaded from: classes.dex */
    private class a extends TimerTask {
        private a() {
        }

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                x.this.gJ();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [635=8] */
    @Override // com.baidu.tbadk.core.util.q
    public String tG() {
        OutOfMemoryError e;
        String str;
        Exception e2;
        BdHttpCancelException e3;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            try {
                if (this.ZZ.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.http.g a2 = this.ZZ.a(this.ZT.uV().uY().mUrl, this.ZT.uV().uY().acl, this.ZT.uV().uY().acj, this.ZT.uV().uY().ack, 5, -1, ul());
                this.ZT.uW().abR = a2.responseCode;
                this.ZT.uW().mHeader = a2.ve;
                new Timer().schedule(new a(this, null), 45000L);
                if (this.ZT.uW().abR != 200) {
                    com.baidu.adp.lib.network.http.e gX = this.ZZ.gX();
                    int i = 0;
                    if (gX != null && gX.gR() != null) {
                        i = gX.gR().size();
                    }
                    String str2 = (i <= 0 || (dVar = gX.gR().get(i + (-1))) == null) ? "" : dVar.uR;
                    if (TextUtils.isEmpty(str2)) {
                        this.ZT.uW().abT = String.valueOf(String.valueOf(this.ZT.uW().abR)) + "|retryCount:" + (this.ZT.uX().abU == null ? -1 : this.ZT.uX().abU.uO);
                    } else {
                        this.ZT.uW().abT = str2;
                    }
                    TiebaStatic.net(this.ZT);
                    return null;
                } else if (this.ZZ.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(a2.vf, "UTF-8");
                    try {
                        df(str);
                        TiebaStatic.net(this.ZT);
                        return str;
                    } catch (BdHttpCancelException e4) {
                        e3 = e4;
                        this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        this.ZT.uW().abT = String.valueOf(String.valueOf(this.ZT.uW().abR)) + "|retryCount:" + (this.ZT.uX().abU == null ? -1 : this.ZT.uX().abU.uO) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.ZT.uW().abR = -14;
                        return str;
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        this.ZT.uW().abR = -15;
                        this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.ZT);
                        return str;
                    } catch (SocketException e6) {
                        this.ZT.uW().abR = -12;
                        this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        TiebaStatic.net(this.ZT);
                        return str;
                    } catch (SocketTimeoutException e7) {
                        this.ZT.uW().abR = -13;
                        this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        TiebaStatic.net(this.ZT);
                        return str;
                    } catch (Exception e8) {
                        e2 = e8;
                        this.ZT.uW().abR = -10;
                        this.ZT.uW().mErrorString = String.valueOf(this.mContext.getResources().getString(i.h.neterror)) + " detailException:" + e2.getMessage();
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.ZT);
                        return str;
                    }
                }
            } finally {
                new Timer().schedule(new a(this, null), 0L);
            }
        } catch (BdHttpCancelException e9) {
            e3 = e9;
            str = null;
        } catch (SocketException e10) {
            str = null;
        } catch (SocketTimeoutException e11) {
            str = null;
        } catch (Exception e12) {
            e2 = e12;
            str = null;
        } catch (OutOfMemoryError e13) {
            e = e13;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [695=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.ZZ.isCanceled()) {
                return this.ZZ.a(this.ZT.uV().uY().mUrl, (z ? new File(str) : n.cO(str)).getAbsolutePath(), false, i2, i3, -1, -1, ul(), new y(this, handler, i), true);
            }
            TiebaStatic.net(this.ZT);
            return false;
        } catch (Exception e) {
            this.ZT.uW().abR = -10;
            this.ZT.uW().mErrorString = String.valueOf(this.mContext.getResources().getString(i.h.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.ZT.uW().abR = -15;
            this.ZT.uW().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.ZT);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> tC() {
        return this.ZT.uV().uY().acj;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.ZT.uV().uY().acj != null) {
            this.ZT.uV().uY().acj.clear();
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

    @Override // com.baidu.tbadk.core.util.q
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void d(String str, byte[] bArr) {
        if (this.ZT.uV().uY().ack == null) {
            this.ZT.uV().uY().ack = new HashMap<>();
        }
        this.ZT.uV().uY().ack.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.ZT.uV().uY().acj == null) {
                this.ZT.uV().uY().acj = new ArrayList<>();
            }
            int b = b(this.ZT.uV().uY().acj, basicNameValuePair.getName());
            int size = this.ZT.uV().uY().acj.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.ZT.uV().uY().acj.get(b).getName())) {
                    this.ZT.uV().uY().acj.set(b, basicNameValuePair);
                } else {
                    this.ZT.uV().uY().acj.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.ZT.uV().uY().acj.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> ul() {
        if (this.ZT != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.ZT.uV().uY().aco)) {
                linkedList.add(new BasicNameValuePair("sid", this.ZT.uV().uY().aco));
            }
            if (!TextUtils.isEmpty(this.ZT.uV().uY().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.ZT.uV().uY().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
