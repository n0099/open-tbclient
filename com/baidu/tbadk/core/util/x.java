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
public class x implements p {
    private static int agU = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a agP;
    private com.baidu.adp.lib.network.a.a agV = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public x(com.baidu.tbadk.core.util.a.a aVar) {
        vk();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.agP = aVar;
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

    private void vk() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void fD() {
        if (this.agV != null) {
            this.agV.fD();
        }
    }

    @Override // com.baidu.tbadk.core.util.p
    public void fA() {
        this.agV.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] uf() {
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
            if (this.agP.wh().wk().ajn != null && this.agP.wh().wk().ajn.size() > 0 && !this.agP.wh().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.agP.wh().wk().mUrl);
                if (this.agP.wh().wk().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.agP.wh().wk().mUrl.endsWith("?") && !this.agP.wh().wk().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.agP.wh().wk().ajn.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.agP.wh().wk().ajn.get(i).getName());
                    sb.append("=");
                    sb.append(al.aQ(this.agP.wh().wk().ajn.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.agP.wh().wk().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.agP.wh().wk().ajp || this.agP.wh().wk().mIsBDImage) && !this.agP.wh().mIsFromCDN) {
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
        if (this.agV.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.agV.a(str, z, 5, 100, -1, -1, vu());
        com.baidu.adp.lib.network.http.e fR = this.agV.fR();
        if (fR == null) {
            return null;
        }
        gVar = fR.fK();
        if (fR != null) {
            try {
                if (fR.fL() != null && (size = fR.fL().size()) > 0) {
                    this.agP.wj().aiT = fR.fL().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.agP.wi().aiS = String.valueOf(this.agP.wi().xt) + "|retryCount:" + (this.agP.wj().aiT == null ? -1 : this.agP.wj().aiT.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.agP.wi().xt = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                this.agP.wi().aiS = String.valueOf(this.agP.wi().xt) + "|retryCount:" + (this.agP.wj().aiT != null ? this.agP.wj().aiT.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agP.wi().xt = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.agP);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.agP.wi().aiS = String.valueOf(this.agP.wi().xt) + "|retryCount:" + (this.agP.wj().aiT != null ? this.agP.wj().aiT.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agP.wi().xt = -12;
                TiebaStatic.net(this.agP);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.agP.wi().aiS = String.valueOf(this.agP.wi().xt) + "|retryCount:" + (this.agP.wj().aiT != null ? this.agP.wj().aiT.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agP.wi().xt = -13;
                TiebaStatic.net(this.agP);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                this.agP.wi().aiS = String.valueOf(this.agP.wi().xt) + "|retryCount:" + (this.agP.wj().aiT != null ? this.agP.wj().aiT.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agP.wi().xt = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.agP);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.agP.wi().xt = gVar.responseCode;
        if (this.agP.wi().xt != 200) {
            this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror);
            if (this.agP.wj().aiT != null && !TextUtils.isEmpty(this.agP.wj().aiT.xc)) {
                this.agP.wi().aiS = this.agP.wj().aiT.xc;
            } else {
                this.agP.wi().aiS = String.valueOf(this.agP.wi().xt) + "|retryCount:" + (this.agP.wj().aiT == null ? -1 : this.agP.wj().aiT.retry);
            }
            TiebaStatic.net(this.agP);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > agU) {
                    this.agP.wi().xt = -11;
                    TiebaStatic.net(this.agP);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Ex().eX(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.agP.wh().wk().mUrl + "], size:" + i2);
                            this.agP.wi().xt = -16;
                            TiebaStatic.net(this.agP);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        z.a aVar = new z.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.hx());
        aVar.ahi = this.agP.wj().aiT.wY;
        aVar.mTime = new Date().getTime() - j;
        aVar.ahj = this.agP.wj().aiT.retry;
        aVar.mMethod = 2;
        z.a(aVar);
        z.ahh.set(this.agP.wj().aiT.retry);
        TiebaStatic.net(this.agP);
        bArr = gVar == null ? gVar.xv : null;
        return bArr;
    }

    public void dQ(String str) {
        this.agP.wi().aiR = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.agP.wi().aiR = errorData.getError_code();
                if (this.agP.wi().aiR == -1) {
                    this.agP.wi().mErrorString = this.mContext.getString(d.l.error_unkown_try_again);
                } else if (this.agP.wi().aiR != 0) {
                    this.agP.wi().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.agP.wi().mErrorString = this.mContext.getString(d.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.p
    public String uP() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uf = uf();
        if (uf == null || this.agP.wi().xt != 200) {
            return null;
        }
        try {
            this.agP.wh().wk().ajr = TextUtils.isEmpty(this.agP.wh().wk().ajr) ? "UTF-8" : this.agP.wh().wk().ajr;
            str = new String(uf, 0, uf.length, this.agP.wh().wk().ajr);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dQ(str);
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

    @Override // com.baidu.tbadk.core.util.p
    public String uO() {
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
            if (this.agP.wh().wk().ajn == null || i2 >= this.agP.wh().wk().ajn.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.agP.wh().wk().ajn.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.agP.wh().wk().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.r.aV(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.agV.isCanceled()) {
                return null;
            }
            if (this.agV.a(this.agP.wh().wk().mUrl, this.agP.wh().wk().ajn, this.agP.wh().wk().ajp, 5, -1, vu()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e fR = this.agV.fR();
            if (fR == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g fK = fR.fK();
            if (fR != null && fR.fL() != null && (size = fR.fL().size()) > 0) {
                this.agP.wj().aiT = fR.fL().get(size - 1);
            }
            this.agP.wi().xt = fK.responseCode;
            this.agP.wi().mHeader = fK.xu;
            if (this.agP.wi().xt != 200) {
                if (this.agP.wj().aiT != null && !TextUtils.isEmpty(this.agP.wj().aiT.xc)) {
                    this.agP.wi().aiS = this.agP.wj().aiT.xc;
                } else {
                    this.agP.wi().aiS = String.valueOf(this.agP.wi().xt) + "|retryCount:" + (this.agP.wj().aiT == null ? -1 : this.agP.wj().aiT.retry);
                }
                TiebaStatic.net(this.agP);
                return null;
            } else if (this.agV.isCanceled()) {
                return null;
            } else {
                str = new String(fK.xv, "utf-8");
                try {
                    if (this.agP.wh().wk().mIsBaiduServer && this.agP.wh().wk().ajq) {
                        dQ(str);
                    }
                    z.a aVar = new z.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.hx());
                    aVar.ahi = this.agP.wj().aiT.wY;
                    aVar.mTime = this.agP.wj().aiT.xa;
                    aVar.ahj = this.agP.wj().aiT.retry;
                    aVar.mMethod = 1;
                    z.a(aVar);
                    z.ahh.set(this.agP.wj().aiT.retry);
                    TiebaStatic.net(this.agP);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    this.agP.wi().aiS = String.valueOf(this.agP.wi().xt) + "|retryCount:" + (this.agP.wj().aiT == null ? -1 : this.agP.wj().aiT.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.agP.wi().xt = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.agP.wi().xt = -15;
                    this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.agP);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.agP.wi().xt = -12;
                    this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.agP);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.agP.wi().xt = -13;
                    this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.agP);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.agP.wi().xt = -10;
                    this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.agP);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.agP.wi().xt = -10;
                    this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.agP);
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

    @Override // com.baidu.tbadk.core.util.p
    public String uQ() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.agV.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.agV.a(this.agP.wh().wk().mUrl, this.agP.wh().wk().ajp, this.agP.wh().wk().ajn, this.agP.wh().wk().ajo, 5, -1, vu());
            this.agP.wi().xt = a.responseCode;
            this.agP.wi().mHeader = a.xu;
            if (this.agP.wi().xt != 200) {
                com.baidu.adp.lib.network.http.e fR = this.agV.fR();
                int i = 0;
                if (fR != null && fR.fL() != null) {
                    i = fR.fL().size();
                }
                if (i <= 0 || (dVar = fR.fL().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.xc;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.agP.wi().aiS = str2;
                } else {
                    this.agP.wi().aiS = String.valueOf(this.agP.wi().xt) + "|retryCount:" + (this.agP.wj().aiT == null ? -1 : this.agP.wj().aiT.retry);
                }
                TiebaStatic.net(this.agP);
                return null;
            } else if (this.agV.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.xv, "UTF-8");
                try {
                    dQ(str);
                    TiebaStatic.net(this.agP);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    this.agP.wi().aiS = String.valueOf(this.agP.wi().xt) + "|retryCount:" + (this.agP.wj().aiT == null ? -1 : this.agP.wj().aiT.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.agP.wi().xt = -14;
                    return str;
                } catch (SocketException e5) {
                    this.agP.wi().xt = -12;
                    this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    TiebaStatic.net(this.agP);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.agP.wi().xt = -13;
                    this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    TiebaStatic.net(this.agP);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.agP.wi().xt = -10;
                    this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.agP);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.agP.wi().xt = -15;
                    this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.agP);
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
    @Override // com.baidu.tbadk.core.util.p
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.agV.isCanceled()) {
                return false;
            }
            return this.agV.a(this.agP.wh().wk().mUrl, (z ? new File(str) : k.dA(str)).getAbsolutePath(), false, i2, i3, -1, -1, vu(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.x.1
                int agW = 0;
                int agX = 0;
                int agY = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void n(int i4, int i5) {
                    if (i5 > 0) {
                        this.agW = i5 / 50;
                    }
                    this.agX += i4 - this.agY;
                    this.agY = i4;
                    if (handler != null) {
                        if (this.agX > this.agW || i4 == i5) {
                            this.agX = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.agP.wi().xt = -10;
            this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.agP.wi().xt = -15;
            this.agP.wi().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.agP);
        }
    }

    @Override // com.baidu.tbadk.core.util.p
    public ArrayList<BasicNameValuePair> uN() {
        return this.agP.wh().wk().ajn;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.agP.wh().wk().ajn != null) {
            this.agP.wh().wk().ajn.clear();
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

    @Override // com.baidu.tbadk.core.util.p
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.p
    public void d(String str, byte[] bArr) {
        if (this.agP.wh().wk().ajo == null) {
            this.agP.wh().wk().ajo = new HashMap<>();
        }
        this.agP.wh().wk().ajo.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.p
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.agP.wh().wk().ajn == null) {
                this.agP.wh().wk().ajn = new ArrayList<>();
            }
            int c = c(this.agP.wh().wk().ajn, basicNameValuePair.getName());
            int size = this.agP.wh().wk().ajn.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.agP.wh().wk().ajn.get(c).getName())) {
                    this.agP.wh().wk().ajn.set(c, basicNameValuePair);
                } else {
                    this.agP.wh().wk().ajn.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.agP.wh().wk().ajn.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> vu() {
        if (this.agP != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.agP.wh().wk().ajs)) {
                linkedList.add(new BasicNameValuePair("sid", this.agP.wh().wk().ajs));
            }
            if (!TextUtils.isEmpty(this.agP.wh().wk().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.agP.wh().wk().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
