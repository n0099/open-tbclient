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
    private static int afU = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a afP;
    private com.baidu.adp.lib.network.a.a afV = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        uM();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.afP = aVar;
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

    private void uM() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void fs() {
        if (this.afV != null) {
            this.afV.fs();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void fo() {
        this.afV.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] uq() {
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
            if (this.afP.vK().vN().aiv != null && this.afP.vK().vN().aiv.size() > 0 && !this.afP.vK().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.afP.vK().vN().mUrl);
                if (this.afP.vK().vN().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.afP.vK().vN().mUrl.endsWith("?") && !this.afP.vK().vN().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.afP.vK().vN().aiv.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.afP.vK().vN().aiv.get(i).getName());
                    sb.append("=");
                    sb.append(am.aN(this.afP.vK().vN().aiv.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.afP.vK().vN().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.afP.vK().vN().aix || this.afP.vK().vN().mIsBDImage) && !this.afP.vK().mIsFromCDN) {
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
        if (this.afV.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.afV.a(str, z, 5, 100, -1, -1, uW());
        com.baidu.adp.lib.network.http.e fG = this.afV.fG();
        if (fG == null) {
            return null;
        }
        gVar = fG.fz();
        if (fG != null) {
            try {
                if (fG.fA() != null && (size = fG.fA().size()) > 0) {
                    this.afP.vM().aib = fG.fA().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.afP.vL().aia = String.valueOf(this.afP.vL().vp) + "|retryCount:" + (this.afP.vM().aib == null ? -1 : this.afP.vM().aib.uV) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.afP.vL().vp = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.afP.vL().aia = String.valueOf(this.afP.vL().vp) + "|retryCount:" + (this.afP.vM().aib != null ? this.afP.vM().aib.uV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afP.vL().vp = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.afP);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.afP.vL().aia = String.valueOf(this.afP.vL().vp) + "|retryCount:" + (this.afP.vM().aib != null ? this.afP.vM().aib.uV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afP.vL().vp = -12;
                TiebaStatic.net(this.afP);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.afP.vL().aia = String.valueOf(this.afP.vL().vp) + "|retryCount:" + (this.afP.vM().aib != null ? this.afP.vM().aib.uV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afP.vL().vp = -13;
                TiebaStatic.net(this.afP);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.afP.vL().aia = String.valueOf(this.afP.vL().vp) + "|retryCount:" + (this.afP.vM().aib != null ? this.afP.vM().aib.uV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afP.vL().vp = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.afP);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.afP.vL().vp = gVar.responseCode;
        if (this.afP.vL().vp != 200) {
            this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.afP.vM().aib != null && !TextUtils.isEmpty(this.afP.vM().aib.uY)) {
                this.afP.vL().aia = this.afP.vM().aib.uY;
            } else {
                this.afP.vL().aia = String.valueOf(this.afP.vL().vp) + "|retryCount:" + (this.afP.vM().aib == null ? -1 : this.afP.vM().aib.uV);
            }
            TiebaStatic.net(this.afP);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > afU) {
                    this.afP.vL().vp = -11;
                    TiebaStatic.net(this.afP);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Es().fh(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.afP.vK().vN().mUrl + "], size:" + i2);
                            this.afP.vL().vp = -16;
                            TiebaStatic.net(this.afP);
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
        aVar.agk = this.afP.vM().aib.uT;
        aVar.mTime = new Date().getTime() - j;
        aVar.agl = this.afP.vM().aib.uV;
        aVar.agj = 2;
        aa.a(aVar);
        aa.agi.set(this.afP.vM().aib.uV);
        TiebaStatic.net(this.afP);
        bArr = gVar == null ? gVar.vr : null;
        return bArr;
    }

    public void dJ(String str) {
        this.afP.vL().ahZ = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.afP.vL().ahZ = errorData.getError_code();
                if (this.afP.vL().ahZ == -1) {
                    this.afP.vL().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.afP.vL().ahZ != 0) {
                    this.afP.vL().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.afP.vL().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String ur() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uq = uq();
        if (uq == null || this.afP.vL().vp != 200) {
            return null;
        }
        try {
            this.afP.vK().vN().aiz = TextUtils.isEmpty(this.afP.vK().vN().aiz) ? "UTF-8" : this.afP.vK().vN().aiz;
            str = new String(uq, 0, uq.length, this.afP.vK().vN().aiz);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dJ(str);
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
    public String up() {
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
            if (this.afP.vK().vN().aiv == null || i2 >= this.afP.vK().vN().aiv.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.afP.vK().vN().aiv.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.afP.vK().vN().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.aS(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.afV.isCanceled()) {
                return null;
            }
            if (this.afV.a(this.afP.vK().vN().mUrl, this.afP.vK().vN().aiv, this.afP.vK().vN().aix, 5, -1, uW()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e fG = this.afV.fG();
            if (fG == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g fz = fG.fz();
            if (fG != null && fG.fA() != null && (size = fG.fA().size()) > 0) {
                this.afP.vM().aib = fG.fA().get(size - 1);
            }
            this.afP.vL().vp = fz.responseCode;
            this.afP.vL().mHeader = fz.vq;
            if (this.afP.vL().vp != 200) {
                if (this.afP.vM().aib != null && !TextUtils.isEmpty(this.afP.vM().aib.uY)) {
                    this.afP.vL().aia = this.afP.vM().aib.uY;
                } else {
                    this.afP.vL().aia = String.valueOf(this.afP.vL().vp) + "|retryCount:" + (this.afP.vM().aib == null ? -1 : this.afP.vM().aib.uV);
                }
                TiebaStatic.net(this.afP);
                return null;
            } else if (this.afV.isCanceled()) {
                return null;
            } else {
                str = new String(fz.vr, "utf-8");
                try {
                    if (this.afP.vK().vN().mIsBaiduServer && this.afP.vK().vN().aiy) {
                        dJ(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.hn());
                    aVar.agk = this.afP.vM().aib.uT;
                    aVar.mTime = this.afP.vM().aib.uW;
                    aVar.agl = this.afP.vM().aib.uV;
                    aVar.agj = 1;
                    aa.a(aVar);
                    aa.agi.set(this.afP.vM().aib.uV);
                    TiebaStatic.net(this.afP);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.afP.vL().aia = String.valueOf(this.afP.vL().vp) + "|retryCount:" + (this.afP.vM().aib == null ? -1 : this.afP.vM().aib.uV) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.afP.vL().vp = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.afP.vL().vp = -15;
                    this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.afP);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.afP.vL().vp = -12;
                    this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.afP);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.afP.vL().vp = -13;
                    this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.afP);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.afP.vL().vp = -10;
                    this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.afP);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.afP.vL().vp = -10;
                    this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.afP);
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
    public String us() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.afV.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.afV.a(this.afP.vK().vN().mUrl, this.afP.vK().vN().aix, this.afP.vK().vN().aiv, this.afP.vK().vN().aiw, 5, -1, uW());
            this.afP.vL().vp = a.responseCode;
            this.afP.vL().mHeader = a.vq;
            if (this.afP.vL().vp != 200) {
                com.baidu.adp.lib.network.http.e fG = this.afV.fG();
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
                    this.afP.vL().aia = str2;
                } else {
                    this.afP.vL().aia = String.valueOf(this.afP.vL().vp) + "|retryCount:" + (this.afP.vM().aib == null ? -1 : this.afP.vM().aib.uV);
                }
                TiebaStatic.net(this.afP);
                return null;
            } else if (this.afV.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.vr, "UTF-8");
                try {
                    dJ(str);
                    TiebaStatic.net(this.afP);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.afP.vL().aia = String.valueOf(this.afP.vL().vp) + "|retryCount:" + (this.afP.vM().aib == null ? -1 : this.afP.vM().aib.uV) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.afP.vL().vp = -14;
                    return str;
                } catch (SocketException e5) {
                    this.afP.vL().vp = -12;
                    this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.afP);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.afP.vL().vp = -13;
                    this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.afP);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.afP.vL().vp = -10;
                    this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.afP);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.afP.vL().vp = -15;
                    this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.afP);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [697=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.afV.isCanceled()) {
                return false;
            }
            return this.afV.a(this.afP.vK().vN().mUrl, (z ? new File(str) : k.dp(str)).getAbsolutePath(), false, i2, i3, -1, -1, uW(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int afW = 0;
                int afX = 0;
                int afY = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.afW = i5 / 50;
                    }
                    this.afX += i4 - this.afY;
                    this.afY = i4;
                    if (handler != null) {
                        if (this.afX > this.afW || i4 == i5) {
                            this.afX = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.afP.vL().vp = -10;
            this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.afP.vL().vp = -15;
            this.afP.vL().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.afP);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> uo() {
        return this.afP.vK().vN().aiv;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.afP.vK().vN().aiv != null) {
            this.afP.vK().vN().aiv.clear();
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
        if (this.afP.vK().vN().aiw == null) {
            this.afP.vK().vN().aiw = new HashMap<>();
        }
        this.afP.vK().vN().aiw.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.afP.vK().vN().aiv == null) {
                this.afP.vK().vN().aiv = new ArrayList<>();
            }
            int c = c(this.afP.vK().vN().aiv, basicNameValuePair.getName());
            int size = this.afP.vK().vN().aiv.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.afP.vK().vN().aiv.get(c).getName())) {
                    this.afP.vK().vN().aiv.set(c, basicNameValuePair);
                } else {
                    this.afP.vK().vN().aiv.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.afP.vK().vN().aiv.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> uW() {
        if (this.afP != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.afP.vK().vN().aiA)) {
                linkedList.add(new BasicNameValuePair("sid", this.afP.vK().vN().aiA));
            }
            if (!TextUtils.isEmpty(this.afP.vK().vN().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.afP.vK().vN().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
