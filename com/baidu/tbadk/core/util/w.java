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
import com.baidu.tbadk.core.util.z;
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
public class w implements q {
    private static int ZT = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.httpNet.a ZO;
    private com.baidu.adp.lib.network.a.a ZU = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public w(com.baidu.tbadk.core.util.httpNet.a aVar) {
        ud();
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
        this.ZO = aVar;
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
    public void gM() {
        this.ZU.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0593  */
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
            if (this.ZO.uV().uY().abZ != null && this.ZO.uV().uY().abZ.size() > 0 && !this.ZO.uV().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.ZO.uV().uY().mUrl);
                if (this.ZO.uV().uY().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.ZO.uV().uY().mUrl.endsWith("?") && !this.ZO.uV().uY().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.ZO.uV().uY().abZ.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.ZO.uV().uY().abZ.get(i).getName());
                    sb.append("=");
                    sb.append(aq.aR(this.ZO.uV().uY().abZ.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.ZO.uV().uY().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.ZO.uV().uY().acb || this.ZO.uV().uY().mIsBDImage) && !this.ZO.uV().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            gVar2 = null;
        } catch (Exception e2) {
            e = e2;
            gVar = null;
        } catch (OutOfMemoryError e3) {
            e = e3;
            gVar = null;
        } catch (SocketException e4) {
            e = e4;
            gVar = null;
        } catch (SocketTimeoutException e5) {
            e = e5;
            gVar = null;
        }
        if (this.ZU.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.ZU.a(str, z, 5, 100, -1, -1, ul());
        com.baidu.adp.lib.network.http.e gZ = this.ZU.gZ();
        if (gZ == null) {
            return null;
        }
        gVar = gZ.gT();
        if (gZ != null) {
            try {
                if (gZ.gU() != null && (size = gZ.gU().size()) > 0) {
                    this.ZO.uX().abK = gZ.gU().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                this.ZO.uW().abJ = String.valueOf(String.valueOf(this.ZO.uW().abH)) + "|retryCount:" + (this.ZO.uX().abK == null ? -1 : this.ZO.uX().abK.uQ) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.ZO.uW().abH = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                this.ZO.uW().abJ = String.valueOf(String.valueOf(this.ZO.uW().abH)) + "|retryCount:" + (this.ZO.uX().abK != null ? this.ZO.uX().abK.uQ : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZO.uW().abH = -12;
                TiebaStatic.net(this.ZO);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                this.ZO.uW().abJ = String.valueOf(String.valueOf(this.ZO.uW().abH)) + "|retryCount:" + (this.ZO.uX().abK != null ? this.ZO.uX().abK.uQ : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZO.uW().abH = -13;
                TiebaStatic.net(this.ZO);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                this.ZO.uW().abJ = String.valueOf(String.valueOf(this.ZO.uW().abH)) + "|retryCount:" + (this.ZO.uX().abK != null ? this.ZO.uX().abK.uQ : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZO.uW().abH = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ZO);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.memoryerror);
                this.ZO.uW().abJ = String.valueOf(String.valueOf(this.ZO.uW().abH)) + "|retryCount:" + (this.ZO.uX().abK != null ? this.ZO.uX().abK.uQ : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZO.uW().abH = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ZO);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.ZO.uW().abH = gVar.responseCode;
        if (this.ZO.uW().abH != 200) {
            this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
            if (this.ZO.uX().abK != null && !TextUtils.isEmpty(this.ZO.uX().abK.uT)) {
                this.ZO.uW().abJ = this.ZO.uX().abK.uT;
            } else {
                this.ZO.uW().abJ = String.valueOf(String.valueOf(this.ZO.uW().abH)) + "|retryCount:" + (this.ZO.uX().abK == null ? -1 : this.ZO.uX().abK.uQ);
            }
            TiebaStatic.net(this.ZO);
            return null;
        }
        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > ZT) {
                    this.ZO.uW().abH = -11;
                    TiebaStatic.net(this.ZO);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.Ce().ee(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.ZO.uV().uY().mUrl + "], size:" + i2);
                            this.ZO.uW().abH = -16;
                            TiebaStatic.net(this.ZO);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        z.a aVar = new z.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.iU());
        aVar.mSize = this.ZO.uX().abK.uN;
        aVar.mTime = new Date().getTime() - j;
        aVar.aaj = this.ZO.uX().abK.uQ;
        aVar.aai = 2;
        z.a(aVar);
        z.aah.set(this.ZO.uX().abK.uQ);
        TiebaStatic.net(this.ZO);
        bArr = gVar == null ? gVar.vg : null;
        return bArr;
    }

    public void cV(String str) {
        this.ZO.uW().abI = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.ZO.uW().abI = errorData.getError_code();
                if (this.ZO.uW().abI == -1) {
                    this.ZO.uW().mErrorString = this.mContext.getString(i.C0057i.error_unkown_try_again);
                } else if (this.ZO.uW().abI != 0) {
                    this.ZO.uW().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.ZO.uW().mErrorString = this.mContext.getString(i.C0057i.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String tF() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] tE = tE();
        if (tE == null || this.ZO.uW().abH != 200) {
            return null;
        }
        try {
            this.ZO.uV().uY().acd = TextUtils.isEmpty(this.ZO.uV().uY().acd) ? "UTF-8" : this.ZO.uV().uY().acd;
            str = new String(tE, 0, tE.length, this.ZO.uV().uY().acd);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            cV(str);
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
        Exception e;
        SocketTimeoutException e2;
        SocketException e3;
        OutOfMemoryError e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        int size;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.ZO.uV().uY().abZ == null || i2 >= this.ZO.uV().uY().abZ.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.ZO.uV().uY().abZ.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.ZO.uV().uY().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.ZU.isCanceled()) {
                return null;
            }
            if (this.ZU.a(this.ZO.uV().uY().mUrl, this.ZO.uV().uY().abZ, this.ZO.uV().uY().acb, 5, -1, ul()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e gZ = this.ZU.gZ();
            if (gZ == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g gT = gZ.gT();
            if (gZ != null && gZ.gU() != null && (size = gZ.gU().size()) > 0) {
                this.ZO.uX().abK = gZ.gU().get(size - 1);
            }
            this.ZO.uW().abH = gT.responseCode;
            this.ZO.uW().mHeader = gT.vf;
            if (this.ZO.uW().abH != 200) {
                if (this.ZO.uX().abK != null && !TextUtils.isEmpty(this.ZO.uX().abK.uT)) {
                    this.ZO.uW().abJ = this.ZO.uX().abK.uT;
                } else {
                    this.ZO.uW().abJ = String.valueOf(String.valueOf(this.ZO.uW().abH)) + "|retryCount:" + (this.ZO.uX().abK == null ? -1 : this.ZO.uX().abK.uQ);
                }
                TiebaStatic.net(this.ZO);
                return null;
            } else if (this.ZU.isCanceled()) {
                return null;
            } else {
                str = new String(gT.vg, "utf-8");
                try {
                    if (this.ZO.uV().uY().mIsBaiduServer && this.ZO.uV().uY().acc) {
                        cV(str);
                    }
                    z.a aVar = new z.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.iU());
                    aVar.mSize = this.ZO.uX().abK.uN;
                    aVar.mTime = this.ZO.uX().abK.uR;
                    aVar.aaj = this.ZO.uX().abK.uQ;
                    aVar.aai = 1;
                    z.a(aVar);
                    z.aah.set(this.ZO.uX().abK.uQ);
                    TiebaStatic.net(this.ZO);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                    this.ZO.uW().abJ = String.valueOf(String.valueOf(this.ZO.uW().abH)) + "|retryCount:" + (this.ZO.uX().abK == null ? -1 : this.ZO.uX().abK.uQ) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.ZO.uW().abH = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.ZO.uW().abH = -15;
                    this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.ZO);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.ZO.uW().abH = -12;
                    this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.ZO);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.ZO.uW().abH = -13;
                    this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.ZO);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.ZO.uW().abH = -10;
                    this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.ZO);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.ZO.uW().abH = -10;
                    this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.ZO);
                    return str;
                }
            }
        } catch (BdHttpCancelException e10) {
            bdHttpCancelException = e10;
            str2 = null;
        } catch (OutOfMemoryError e11) {
            e4 = e11;
            str = null;
        } catch (SocketException e12) {
            e3 = e12;
            str = null;
        } catch (SocketTimeoutException e13) {
            e2 = e13;
            str = null;
        } catch (Exception e14) {
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

        /* synthetic */ a(w wVar, a aVar) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                w.this.gM();
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
                if (this.ZU.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.http.g a2 = this.ZU.a(this.ZO.uV().uY().mUrl, this.ZO.uV().uY().acb, this.ZO.uV().uY().abZ, this.ZO.uV().uY().aca, 5, -1, ul());
                this.ZO.uW().abH = a2.responseCode;
                this.ZO.uW().mHeader = a2.vf;
                new Timer().schedule(new a(this, null), 45000L);
                if (this.ZO.uW().abH != 200) {
                    com.baidu.adp.lib.network.http.e gZ = this.ZU.gZ();
                    int i = 0;
                    if (gZ != null && gZ.gU() != null) {
                        i = gZ.gU().size();
                    }
                    String str2 = (i <= 0 || (dVar = gZ.gU().get(i + (-1))) == null) ? "" : dVar.uT;
                    if (TextUtils.isEmpty(str2)) {
                        this.ZO.uW().abJ = String.valueOf(String.valueOf(this.ZO.uW().abH)) + "|retryCount:" + (this.ZO.uX().abK == null ? -1 : this.ZO.uX().abK.uQ);
                    } else {
                        this.ZO.uW().abJ = str2;
                    }
                    TiebaStatic.net(this.ZO);
                    return null;
                } else if (this.ZU.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(a2.vg, "UTF-8");
                    try {
                        cV(str);
                        TiebaStatic.net(this.ZO);
                        return str;
                    } catch (BdHttpCancelException e4) {
                        e3 = e4;
                        this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                        this.ZO.uW().abJ = String.valueOf(String.valueOf(this.ZO.uW().abH)) + "|retryCount:" + (this.ZO.uX().abK == null ? -1 : this.ZO.uX().abK.uQ) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.ZO.uW().abH = -14;
                        return str;
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        this.ZO.uW().abH = -15;
                        this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.ZO);
                        return str;
                    } catch (SocketException e6) {
                        this.ZO.uW().abH = -12;
                        this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                        TiebaStatic.net(this.ZO);
                        return str;
                    } catch (SocketTimeoutException e7) {
                        this.ZO.uW().abH = -13;
                        this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                        TiebaStatic.net(this.ZO);
                        return str;
                    } catch (Exception e8) {
                        e2 = e8;
                        this.ZO.uW().abH = -10;
                        this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.ZO);
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
            if (!this.ZU.isCanceled()) {
                return this.ZU.a(this.ZO.uV().uY().mUrl, (z ? new File(str) : n.cF(str)).getAbsolutePath(), false, i2, i3, -1, -1, ul(), new x(this, handler, i), true);
            }
            TiebaStatic.net(this.ZO);
            return false;
        } catch (Exception e) {
            this.ZO.uW().abH = -10;
            this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.neterror);
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.ZO.uW().abH = -15;
            this.ZO.uW().mErrorString = this.mContext.getResources().getString(i.C0057i.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.ZO);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> tC() {
        return this.ZO.uV().uY().abZ;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void m(ArrayList<BasicNameValuePair> arrayList) {
        if (this.ZO.uV().uY().abZ != null) {
            this.ZO.uV().uY().abZ.clear();
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
        if (this.ZO.uV().uY().aca == null) {
            this.ZO.uV().uY().aca = new HashMap<>();
        }
        this.ZO.uV().uY().aca.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.ZO.uV().uY().abZ == null) {
                this.ZO.uV().uY().abZ = new ArrayList<>();
            }
            int b = b(this.ZO.uV().uY().abZ, basicNameValuePair.getName());
            int size = this.ZO.uV().uY().abZ.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.ZO.uV().uY().abZ.get(b).getName())) {
                    this.ZO.uV().uY().abZ.set(b, basicNameValuePair);
                } else {
                    this.ZO.uV().uY().abZ.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.ZO.uV().uY().abZ.add(b, basicNameValuePair);
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
        if (this.ZO != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.ZO.uV().uY().ace)) {
                linkedList.add(new BasicNameValuePair("sid", this.ZO.uV().uY().ace));
            }
            if (!TextUtils.isEmpty(this.ZO.uV().uY().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.ZO.uV().uY().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
