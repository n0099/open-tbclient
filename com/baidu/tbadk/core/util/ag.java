package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.network.willdelete.BdHttpErrorException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ag implements v {
    private static int IB = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    protected final com.baidu.adp.lib.network.willdelete.a II = new com.baidu.adp.lib.network.willdelete.a();
    private final com.baidu.tbadk.core.util.httpNet.c Iw;
    private Context mContext;

    public ag(com.baidu.tbadk.core.util.httpNet.c cVar) {
        oR();
        this.mContext = TbadkCoreApplication.m255getInst().getApp();
        this.Iw = cVar;
        com.baidu.adp.lib.network.willdelete.e.dV().setUserAgent("bdtb for Android " + TbConfig.getVersion());
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

    private void oR() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.v
    public boolean oq() {
        return this.II.isCanceled();
    }

    @Override // com.baidu.tbadk.core.util.v
    public void dJ() {
        this.II.cancel();
        try {
            int cx = al.cx(this.Iw.pZ().qc().mUrl);
            if (cx > 0) {
                al.ph().o(cx, 1);
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [404=12] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0151  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x040d -> B:87:0x040e). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] os() {
        com.baidu.adp.lib.network.willdelete.f fVar;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.willdelete.e.dV().setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            int cx = al.cx(this.Iw.pZ().qc().mUrl);
            if (cx > 0) {
                al.ph().bV(cx);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            try {
                if (this.Iw.pZ().qc().KL == null || this.Iw.pZ().qc().KL.size() <= 0 || this.Iw.pZ().mIsFromCDN) {
                    str = this.Iw.pZ().qc().mUrl;
                } else {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.Iw.pZ().qc().mUrl);
                    if (this.Iw.pZ().qc().mUrl.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.Iw.pZ().qc().mUrl.endsWith("?") && !this.Iw.pZ().qc().mUrl.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i = 0; i < this.Iw.pZ().qc().KL.size(); i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(this.Iw.pZ().qc().KL.get(i).getName());
                        sb.append("=");
                        sb.append(bf.aE(this.Iw.pZ().qc().KL.get(i).getValue()));
                    }
                    str = sb.toString();
                }
                TbConfig.getDebugSwitch();
                if ((!this.Iw.pZ().qc().KN || this.Iw.pZ().qc().mIsBDImage) && !this.Iw.pZ().mIsFromCDN) {
                    z = false;
                }
            } finally {
                al.cy(this.Iw.pZ().qc().mUrl);
            }
        } catch (BdHttpCancelException e2) {
            e = e2;
            fVar = null;
        } catch (BdHttpErrorException e3) {
            e = e3;
            fVar = null;
        } catch (Exception e4) {
            e = e4;
            fVar = null;
        } catch (OutOfMemoryError e5) {
            e = e5;
            fVar = null;
        } catch (SocketException e6) {
            e = e6;
            fVar = null;
        } catch (SocketTimeoutException e7) {
            e = e7;
            fVar = null;
        }
        if (this.II.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        fVar = com.baidu.adp.lib.network.willdelete.e.dV().a(str, z, 5, 100, -1, new ah(this), this.II, pd());
        if (fVar != null) {
            try {
                if (fVar.la != null) {
                    this.Iw.qb().la = fVar.la;
                }
            } catch (BdHttpCancelException e8) {
                e = e8;
                this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la != null ? this.Iw.qb().la.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iw.qa().Ky = -14;
                al.cy(this.Iw.pZ().qc().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (BdHttpErrorException e9) {
                e = e9;
                this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la != null ? this.Iw.qb().la.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iw.qa().Ky = e.getHttpResponseCode();
                TiebaStatic.net(this.Iw);
                al.cy(this.Iw.pZ().qc().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la != null ? this.Iw.qb().la.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iw.qa().Ky = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Iw);
                al.cy(this.Iw.pZ().qc().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (OutOfMemoryError e11) {
                e = e11;
                this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.memoryerror);
                this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la == null ? -1 : this.Iw.qb().la.retry) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iw.qa().Ky = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Iw);
                al.cy(this.Iw.pZ().qc().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketException e12) {
                e = e12;
                this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la != null ? this.Iw.qb().la.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iw.qa().Ky = -12;
                TiebaStatic.net(this.Iw);
                al.cy(this.Iw.pZ().qc().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketTimeoutException e13) {
                e = e13;
                this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la != null ? this.Iw.qb().la.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iw.qa().Ky = -13;
                TiebaStatic.net(this.Iw);
                al.cy(this.Iw.pZ().qc().mUrl);
                if (fVar != null) {
                }
                return bArr;
            }
        }
        if (fVar == null) {
            al.cy(this.Iw.pZ().qc().mUrl);
            return null;
        }
        this.Iw.qa().Ky = fVar.kY;
        if (this.Iw.qa().Ky != 200) {
            this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
            this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la == null ? -1 : this.Iw.qb().la.retry);
            TiebaStatic.net(this.Iw);
            al.cy(this.Iw.pZ().qc().mUrl);
            return null;
        }
        if (TbadkCoreApplication.m255getInst().isMainProcess(true) && (str2 = fVar.kZ) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > IB) {
                    this.Iw.qa().Ky = -11;
                    TiebaStatic.net(this.Iw);
                    al.cy(this.Iw.pZ().qc().mUrl);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.e.vY().dx(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.Iw.pZ().qc().mUrl + "], size:" + i2);
                            this.Iw.qa().Ky = -16;
                            TiebaStatic.net(this.Iw);
                            al.cy(this.Iw.pZ().qc().mUrl);
                            al.cy(this.Iw.pZ().qc().mUrl);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ap apVar = new ap();
        apVar.mMode = getMode(com.baidu.adp.lib.util.i.fk());
        apVar.mSize = this.Iw.qb().la.kq;
        apVar.mTime = new Date().getTime() - j;
        apVar.Jc = this.Iw.qb().la.retry;
        apVar.Jb = 2;
        ao.a(apVar);
        ao.Ja.set(this.Iw.qb().la.retry);
        TiebaStatic.net(this.Iw);
        al.cy(this.Iw.pZ().qc().mUrl);
        if (fVar != null) {
            this.Iw.pZ().qc().KP = fVar.charset;
            bArr = fVar.data;
        } else {
            bArr = null;
        }
        return bArr;
    }

    public void cw(String str) {
        this.Iw.qa().Kz = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.Iw.qa().Kz = errorData.getError_code();
                if (this.Iw.qa().Kz == -1) {
                    this.Iw.qa().mErrorString = this.mContext.getString(com.baidu.tieba.z.error_unkown_try_again);
                } else if (this.Iw.qa().Kz != 0) {
                    this.Iw.qa().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.Iw.qa().mErrorString = this.mContext.getString(com.baidu.tieba.z.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.v
    public String ot() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] os = os();
        if (os == null || this.Iw.qa().Ky != 200) {
            return null;
        }
        try {
            this.Iw.pZ().qc().KP = TextUtils.isEmpty(this.Iw.pZ().qc().KP) ? "UTF-8" : this.Iw.pZ().qc().KP;
            str = new String(os, 0, os.length, this.Iw.pZ().qc().KP);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            cw(str);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [631=12] */
    @Override // com.baidu.tbadk.core.util.v
    public String or() {
        Throwable th;
        String str;
        OutOfMemoryError e;
        Exception e2;
        SocketTimeoutException e3;
        SocketException e4;
        BdHttpErrorException e5;
        BdHttpCancelException e6;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        try {
            int cx = al.cx(this.Iw.pZ().qc().mUrl);
            if (cx > 0) {
                al.ph().bV(cx);
            }
        } catch (Exception e7) {
            BdLog.e(e7.getMessage());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.Iw.pZ().qc().KL == null || i2 >= this.Iw.pZ().qc().KL.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.Iw.pZ().qc().KL.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(name) + "=");
                sb.append(bf.aE(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.Iw.pZ().qc().mIsBaiduServer) {
            sb2.append("tiebaclient!!!");
            String md5 = com.baidu.adp.lib.util.z.toMd5(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(md5);
        }
        String sb3 = sb.toString();
        TbConfig.getDebugSwitch();
        try {
            try {
                if (this.II.isCanceled()) {
                    al.cy(this.Iw.pZ().qc().mUrl);
                    return null;
                }
                com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.dV().a(this.Iw.pZ().qc().mUrl, sb3.getBytes(), this.Iw.pZ().qc().KN, 5, -1, (com.baidu.adp.lib.network.willdelete.d) null, this.II, pd());
                if (a == null) {
                    throw new BdHttpCancelException();
                }
                if (a.la != null) {
                    this.Iw.qb().la = a.la;
                }
                this.Iw.qa().Ky = a.kY;
                if (this.Iw.qa().Ky != 200) {
                    this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la == null ? -1 : this.Iw.qb().la.retry);
                    TiebaStatic.net(this.Iw);
                    al.cy(this.Iw.pZ().qc().mUrl);
                    return null;
                } else if (this.II.isCanceled()) {
                    al.cy(this.Iw.pZ().qc().mUrl);
                    return null;
                } else {
                    str = new String(a.data, "utf-8");
                    try {
                        if (this.Iw.pZ().qc().mIsBaiduServer && this.Iw.pZ().qc().KO) {
                            cw(str);
                        }
                        ap apVar = new ap();
                        apVar.mMode = getMode(com.baidu.adp.lib.util.i.fk());
                        apVar.mSize = this.Iw.qb().la.kq;
                        apVar.mTime = this.Iw.qb().la.kt;
                        apVar.Jc = this.Iw.qb().la.retry;
                        apVar.Jb = 1;
                        ao.a(apVar);
                        ao.Ja.set(this.Iw.qb().la.retry);
                        TiebaStatic.net(this.Iw);
                        return str;
                    } catch (BdHttpCancelException e8) {
                        e6 = e8;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la != null ? this.Iw.qb().la.retry : -1) + "|" + e6.getClass() + "|" + e6.getMessage();
                        this.Iw.qa().Ky = -14;
                        return str;
                    } catch (BdHttpErrorException e9) {
                        e5 = e9;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la == null ? -1 : this.Iw.qb().la.retry) + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.Iw.qa().Ky = e5.getHttpResponseCode();
                        TiebaStatic.net(this.Iw);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e = e10;
                        this.Iw.qa().Ky = -15;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.Iw);
                        return str;
                    } catch (SocketException e11) {
                        e4 = e11;
                        this.Iw.qa().Ky = -12;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.Iw);
                        return str;
                    } catch (SocketTimeoutException e12) {
                        e3 = e12;
                        this.Iw.qa().Ky = -13;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.Iw);
                        return str;
                    } catch (Exception e13) {
                        e2 = e13;
                        this.Iw.qa().Ky = -10;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.Iw);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.Iw.qa().Ky = -10;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.Iw);
                        return str;
                    }
                }
            } finally {
                al.cy(this.Iw.pZ().qc().mUrl);
            }
        } catch (BdHttpCancelException e14) {
            e6 = e14;
            str = null;
        } catch (BdHttpErrorException e15) {
            e5 = e15;
            str = null;
        } catch (SocketException e16) {
            e4 = e16;
            str = null;
        } catch (SocketTimeoutException e17) {
            e3 = e17;
            str = null;
        } catch (Exception e18) {
            e2 = e18;
            str = null;
        } catch (OutOfMemoryError e19) {
            e = e19;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [734=9] */
    @Override // com.baidu.tbadk.core.util.v
    public String ou() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        BdHttpErrorException e3;
        BdHttpCancelException e4;
        try {
            try {
                if (this.II.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.willdelete.f b = com.baidu.adp.lib.network.willdelete.e.dV().b(this.Iw.pZ().qc().mUrl, this.Iw.pZ().qc().KN, this.Iw.pZ().qc().KL, this.Iw.pZ().qc().KM, 5, -1, null, this.II, null, pd());
                this.Iw.qa().Ky = b.kY;
                new Timer().schedule(new aj(this, null), 45000L);
                if (this.Iw.qa().Ky != 200) {
                    this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la == null ? -1 : this.Iw.qb().la.retry);
                    TiebaStatic.net(this.Iw);
                    return null;
                } else if (this.II.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(b.data, b.charset);
                    try {
                        cw(str);
                        TiebaStatic.net(this.Iw);
                        return str;
                    } catch (BdHttpCancelException e5) {
                        e4 = e5;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la != null ? this.Iw.qb().la.retry : -1) + "|" + e4.getClass() + "|" + e4.getMessage();
                        this.Iw.qa().Ky = -14;
                        return str;
                    } catch (BdHttpErrorException e6) {
                        e3 = e6;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        this.Iw.qa().KA = String.valueOf(String.valueOf(this.Iw.qa().Ky)) + "|retryCount:" + (this.Iw.qb().la == null ? -1 : this.Iw.qb().la.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.Iw.qa().Ky = e3.getHttpResponseCode();
                        TiebaStatic.net(this.Iw);
                        return str;
                    } catch (OutOfMemoryError e7) {
                        e = e7;
                        this.Iw.qa().Ky = -15;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.Iw);
                        return str;
                    } catch (SocketException e8) {
                        this.Iw.qa().Ky = -12;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        TiebaStatic.net(this.Iw);
                        return str;
                    } catch (SocketTimeoutException e9) {
                        this.Iw.qa().Ky = -13;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        TiebaStatic.net(this.Iw);
                        return str;
                    } catch (Exception e10) {
                        e2 = e10;
                        this.Iw.qa().Ky = -10;
                        this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.Iw);
                        return str;
                    }
                }
            } finally {
                new Timer().schedule(new aj(this, null), 0L);
            }
        } catch (BdHttpCancelException e11) {
            e4 = e11;
            str = null;
        } catch (BdHttpErrorException e12) {
            e3 = e12;
            str = null;
        } catch (Exception e13) {
            e2 = e13;
            str = null;
        } catch (OutOfMemoryError e14) {
            e = e14;
            str = null;
        } catch (SocketException e15) {
            str = null;
        } catch (SocketTimeoutException e16) {
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [815=5] */
    @Override // com.baidu.tbadk.core.util.v
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.II.isCanceled()) {
                return com.baidu.adp.lib.network.willdelete.e.dV().a(this.Iw.pZ().qc().mUrl, (z ? new File(str) : s.ch(str)).getAbsolutePath(), false, i2, i3, -1, new ai(this, handler, i), this.II, pd());
            }
            TiebaStatic.net(this.Iw);
            return false;
        } catch (Exception e) {
            this.Iw.qa().Ky = -10;
            this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.Iw.qa().Ky = -15;
            this.Iw.qa().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.Iw);
        }
    }

    @Override // com.baidu.tbadk.core.util.v
    public ArrayList<BasicNameValuePair> op() {
        return this.Iw.pZ().qc().KL;
    }

    @Override // com.baidu.tbadk.core.util.v
    public void r(ArrayList<BasicNameValuePair> arrayList) {
        if (this.Iw.pZ().qc().KL != null) {
            this.Iw.pZ().qc().KL.clear();
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
        if (this.Iw.pZ().qc().KM == null) {
            this.Iw.pZ().qc().KM = new HashMap<>();
        }
        this.Iw.pZ().qc().KM.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.v
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.Iw.pZ().qc().KL == null) {
                this.Iw.pZ().qc().KL = new ArrayList<>();
            }
            int b = b(this.Iw.pZ().qc().KL, basicNameValuePair.getName());
            int size = this.Iw.pZ().qc().KL.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.Iw.pZ().qc().KL.get(b).getName())) {
                    this.Iw.pZ().qc().KL.set(b, basicNameValuePair);
                } else {
                    this.Iw.pZ().qc().KL.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.Iw.pZ().qc().KL.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> pd() {
        if (this.Iw != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.Iw.pZ().qc().Kv)) {
                linkedList.add(new BasicNameValuePair("sid", this.Iw.pZ().qc().Kv));
            }
            if (!TextUtils.isEmpty(this.Iw.pZ().qc().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.Iw.pZ().qc().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
