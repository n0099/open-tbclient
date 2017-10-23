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
import com.baidu.tieba.d;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class y implements q {
    private static int afz = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private com.baidu.adp.lib.network.a.a afA = new com.baidu.adp.lib.network.a.a();
    private final com.baidu.tbadk.core.util.a.a afu;
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        uF();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.afu = aVar;
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

    private void uF() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void fs() {
        if (this.afA != null) {
            this.afA.fs();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void fo() {
        this.afA.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] uj() {
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
            if (this.afu.vC().vF().ahY != null && this.afu.vC().vF().ahY.size() > 0 && !this.afu.vC().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.afu.vC().vF().mUrl);
                if (this.afu.vC().vF().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.afu.vC().vF().mUrl.endsWith("?") && !this.afu.vC().vF().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.afu.vC().vF().ahY.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.afu.vC().vF().ahY.get(i).getName());
                    sb.append("=");
                    sb.append(am.aN(this.afu.vC().vF().ahY.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.afu.vC().vF().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.afu.vC().vF().aia || this.afu.vC().vF().mIsBDImage) && !this.afu.vC().mIsFromCDN) {
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
        if (this.afA.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.afA.a(str, z, 5, 100, -1, -1, uP());
        com.baidu.adp.lib.network.http.e fG = this.afA.fG();
        if (fG == null) {
            return null;
        }
        gVar = fG.fz();
        if (fG != null) {
            try {
                if (fG.fA() != null && (size = fG.fA().size()) > 0) {
                    this.afu.vE().ahE = fG.fA().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.afu.vD().ahD = String.valueOf(this.afu.vD().vp) + "|retryCount:" + (this.afu.vE().ahE == null ? -1 : this.afu.vE().ahE.uV) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.afu.vD().vp = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                this.afu.vD().ahD = String.valueOf(this.afu.vD().vp) + "|retryCount:" + (this.afu.vE().ahE != null ? this.afu.vE().ahE.uV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afu.vD().vp = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.afu);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.afu.vD().ahD = String.valueOf(this.afu.vD().vp) + "|retryCount:" + (this.afu.vE().ahE != null ? this.afu.vE().ahE.uV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afu.vD().vp = -12;
                TiebaStatic.net(this.afu);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.afu.vD().ahD = String.valueOf(this.afu.vD().vp) + "|retryCount:" + (this.afu.vE().ahE != null ? this.afu.vE().ahE.uV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afu.vD().vp = -13;
                TiebaStatic.net(this.afu);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                this.afu.vD().ahD = String.valueOf(this.afu.vD().vp) + "|retryCount:" + (this.afu.vE().ahE != null ? this.afu.vE().ahE.uV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afu.vD().vp = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.afu);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.afu.vD().vp = gVar.responseCode;
        if (this.afu.vD().vp != 200) {
            this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror);
            if (this.afu.vE().ahE != null && !TextUtils.isEmpty(this.afu.vE().ahE.uY)) {
                this.afu.vD().ahD = this.afu.vE().ahE.uY;
            } else {
                this.afu.vD().ahD = String.valueOf(this.afu.vD().vp) + "|retryCount:" + (this.afu.vE().ahE == null ? -1 : this.afu.vE().ahE.uV);
            }
            TiebaStatic.net(this.afu);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > afz) {
                    this.afu.vD().vp = -11;
                    TiebaStatic.net(this.afu);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.DT().fh(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.afu.vC().vF().mUrl + "], size:" + i2);
                            this.afu.vD().vp = -16;
                            TiebaStatic.net(this.afu);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.hn());
        aVar.afO = this.afu.vE().ahE.uT;
        aVar.mTime = new Date().getTime() - j;
        aVar.afP = this.afu.vE().ahE.uV;
        aVar.afN = 2;
        aa.a(aVar);
        aa.afM.set(this.afu.vE().ahE.uV);
        TiebaStatic.net(this.afu);
        bArr = gVar == null ? gVar.vr : null;
        return bArr;
    }

    public void dD(String str) {
        this.afu.vD().ahC = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.afu.vD().ahC = errorData.getError_code();
                if (this.afu.vD().ahC == -1) {
                    this.afu.vD().mErrorString = this.mContext.getString(d.l.error_unkown_try_again);
                } else if (this.afu.vD().ahC != 0) {
                    this.afu.vD().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.afu.vD().mErrorString = this.mContext.getString(d.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String uk() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uj = uj();
        if (uj == null || this.afu.vD().vp != 200) {
            return null;
        }
        try {
            this.afu.vC().vF().aic = TextUtils.isEmpty(this.afu.vC().vF().aic) ? "UTF-8" : this.afu.vC().vF().aic;
            str = new String(uj, 0, uj.length, this.afu.vC().vF().aic);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dD(str);
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
    public String ui() {
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
            if (this.afu.vC().vF().ahY == null || i2 >= this.afu.vC().vF().ahY.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.afu.vC().vF().ahY.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.afu.vC().vF().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.aS(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.afA.isCanceled()) {
                return null;
            }
            if (this.afA.a(this.afu.vC().vF().mUrl, this.afu.vC().vF().ahY, this.afu.vC().vF().aia, 5, -1, uP()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e fG = this.afA.fG();
            if (fG == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g fz = fG.fz();
            if (fG != null && fG.fA() != null && (size = fG.fA().size()) > 0) {
                this.afu.vE().ahE = fG.fA().get(size - 1);
            }
            this.afu.vD().vp = fz.responseCode;
            this.afu.vD().mHeader = fz.vq;
            if (this.afu.vD().vp != 200) {
                if (this.afu.vE().ahE != null && !TextUtils.isEmpty(this.afu.vE().ahE.uY)) {
                    this.afu.vD().ahD = this.afu.vE().ahE.uY;
                } else {
                    this.afu.vD().ahD = String.valueOf(this.afu.vD().vp) + "|retryCount:" + (this.afu.vE().ahE == null ? -1 : this.afu.vE().ahE.uV);
                }
                TiebaStatic.net(this.afu);
                return null;
            } else if (this.afA.isCanceled()) {
                return null;
            } else {
                str = new String(fz.vr, "utf-8");
                try {
                    if (this.afu.vC().vF().mIsBaiduServer && this.afu.vC().vF().aib) {
                        dD(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.hn());
                    aVar.afO = this.afu.vE().ahE.uT;
                    aVar.mTime = this.afu.vE().ahE.uW;
                    aVar.afP = this.afu.vE().ahE.uV;
                    aVar.afN = 1;
                    aa.a(aVar);
                    aa.afM.set(this.afu.vE().ahE.uV);
                    TiebaStatic.net(this.afu);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    this.afu.vD().ahD = String.valueOf(this.afu.vD().vp) + "|retryCount:" + (this.afu.vE().ahE == null ? -1 : this.afu.vE().ahE.uV) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.afu.vD().vp = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.afu.vD().vp = -15;
                    this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.afu);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.afu.vD().vp = -12;
                    this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.afu);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.afu.vD().vp = -13;
                    this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.afu);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.afu.vD().vp = -10;
                    this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.afu);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.afu.vD().vp = -10;
                    this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.afu);
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

    @Override // com.baidu.tbadk.core.util.q
    public String ul() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.afA.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.afA.a(this.afu.vC().vF().mUrl, this.afu.vC().vF().aia, this.afu.vC().vF().ahY, this.afu.vC().vF().ahZ, 5, -1, uP());
            this.afu.vD().vp = a.responseCode;
            this.afu.vD().mHeader = a.vq;
            if (this.afu.vD().vp != 200) {
                com.baidu.adp.lib.network.http.e fG = this.afA.fG();
                int i = 0;
                if (fG != null && fG.fA() != null) {
                    i = fG.fA().size();
                }
                if (i <= 0 || (dVar = fG.fA().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.uY;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.afu.vD().ahD = str2;
                } else {
                    this.afu.vD().ahD = String.valueOf(this.afu.vD().vp) + "|retryCount:" + (this.afu.vE().ahE == null ? -1 : this.afu.vE().ahE.uV);
                }
                TiebaStatic.net(this.afu);
                return null;
            } else if (this.afA.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.vr, "UTF-8");
                try {
                    dD(str);
                    TiebaStatic.net(this.afu);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    this.afu.vD().ahD = String.valueOf(this.afu.vD().vp) + "|retryCount:" + (this.afu.vE().ahE == null ? -1 : this.afu.vE().ahE.uV) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.afu.vD().vp = -14;
                    return str;
                } catch (SocketException e5) {
                    this.afu.vD().vp = -12;
                    this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    TiebaStatic.net(this.afu);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.afu.vD().vp = -13;
                    this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    TiebaStatic.net(this.afu);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.afu.vD().vp = -10;
                    this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.afu);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.afu.vD().vp = -15;
                    this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.afu);
                    return str;
                }
            }
        } catch (BdHttpCancelException e9) {
            e3 = e9;
            str = null;
        } catch (OutOfMemoryError e10) {
            e2 = e10;
            str = null;
        } catch (SocketException e11) {
            str = null;
        } catch (SocketTimeoutException e12) {
            str = null;
        } catch (Exception e13) {
            e = e13;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [698=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.afA.isCanceled()) {
                return false;
            }
            return this.afA.a(this.afu.vC().vF().mUrl, (z ? new File(str) : k.di(str)).getAbsolutePath(), false, i2, i3, -1, -1, uP(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int afB = 0;
                int afC = 0;
                int afD = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.afB = i5 / 50;
                    }
                    this.afC += i4 - this.afD;
                    this.afD = i4;
                    if (handler != null) {
                        if (this.afC > this.afB || i4 == i5) {
                            this.afC = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.afu.vD().vp = -10;
            this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.afu.vD().vp = -15;
            this.afu.vD().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.afu);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> uh() {
        return this.afu.vC().vF().ahY;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.afu.vC().vF().ahY != null) {
            this.afu.vC().vF().ahY.clear();
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
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void d(String str, byte[] bArr) {
        if (this.afu.vC().vF().ahZ == null) {
            this.afu.vC().vF().ahZ = new HashMap<>();
        }
        this.afu.vC().vF().ahZ.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.afu.vC().vF().ahY == null) {
                this.afu.vC().vF().ahY = new ArrayList<>();
            }
            int c = c(this.afu.vC().vF().ahY, basicNameValuePair.getName());
            int size = this.afu.vC().vF().ahY.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.afu.vC().vF().ahY.get(c).getName())) {
                    this.afu.vC().vF().ahY.set(c, basicNameValuePair);
                } else {
                    this.afu.vC().vF().ahY.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.afu.vC().vF().ahY.add(c, basicNameValuePair);
            }
        }
    }

    private int c(ArrayList<BasicNameValuePair> arrayList, String str) {
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

    private LinkedList<BasicNameValuePair> uP() {
        if (this.afu != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.afu.vC().vF().aid)) {
                linkedList.add(new BasicNameValuePair("sid", this.afu.vC().vF().aid));
            }
            if (!TextUtils.isEmpty(this.afu.vC().vF().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.afu.vC().vF().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
