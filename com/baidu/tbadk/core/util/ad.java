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
public class ad implements s {
    private static int Uh = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.httpNet.a Uc;
    protected final com.baidu.adp.lib.network.willdelete.a Un = new com.baidu.adp.lib.network.willdelete.a();
    private Context mContext;

    public ad(com.baidu.tbadk.core.util.httpNet.a aVar) {
        so();
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
        this.Uc = aVar;
        com.baidu.adp.lib.network.willdelete.e.hu().setUserAgent("bdtb for Android " + TbConfig.getVersion());
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

    private void so() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.s
    public boolean rN() {
        return this.Un.isCanceled();
    }

    @Override // com.baidu.tbadk.core.util.s
    public void hh() {
        this.Un.cancel();
        try {
            int cG = ai.cG(this.Uc.tp().ts().mUrl);
            if (cG > 0) {
                ai.sE().m(cG, 1);
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [407=12] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0151  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x040d -> B:87:0x040e). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] rP() {
        com.baidu.adp.lib.network.willdelete.f fVar;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.willdelete.e.hu().setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            int cG = ai.cG(this.Uc.tp().ts().mUrl);
            if (cG > 0) {
                ai.sE().bW(cG);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            try {
                if (this.Uc.tp().ts().Wp == null || this.Uc.tp().ts().Wp.size() <= 0 || this.Uc.tp().mIsFromCDN) {
                    str = this.Uc.tp().ts().mUrl;
                } else {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.Uc.tp().ts().mUrl);
                    if (this.Uc.tp().ts().mUrl.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.Uc.tp().ts().mUrl.endsWith("?") && !this.Uc.tp().ts().mUrl.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i = 0; i < this.Uc.tp().ts().Wp.size(); i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(this.Uc.tp().ts().Wp.get(i).getName());
                        sb.append("=");
                        sb.append(bd.aM(this.Uc.tp().ts().Wp.get(i).getValue()));
                    }
                    str = sb.toString();
                }
                TbConfig.getDebugSwitch();
                if ((!this.Uc.tp().ts().Wr || this.Uc.tp().ts().mIsBDImage) && !this.Uc.tp().mIsFromCDN) {
                    z = false;
                }
            } finally {
                ai.cH(this.Uc.tp().ts().mUrl);
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
        if (this.Un.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        fVar = com.baidu.adp.lib.network.willdelete.e.hu().a(str, z, 5, 100, -1, new ae(this), this.Un, sA());
        if (fVar != null) {
            try {
                if (fVar.wo != null) {
                    this.Uc.tr().wo = fVar.wo;
                }
            } catch (BdHttpCancelException e8) {
                e = e8;
                this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo != null ? this.Uc.tr().wo.vI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Uc.tq().Wa = -14;
                ai.cH(this.Uc.tp().ts().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (BdHttpErrorException e9) {
                e = e9;
                this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo != null ? this.Uc.tr().wo.vI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Uc.tq().Wa = e.getHttpResponseCode();
                TiebaStatic.net(this.Uc);
                ai.cH(this.Uc.tp().ts().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo != null ? this.Uc.tr().wo.vI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Uc.tq().Wa = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Uc);
                ai.cH(this.Uc.tp().ts().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (OutOfMemoryError e11) {
                e = e11;
                this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.memoryerror);
                this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo == null ? -1 : this.Uc.tr().wo.vI) + "|" + e.getClass() + "|" + e.getMessage();
                this.Uc.tq().Wa = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Uc);
                ai.cH(this.Uc.tp().ts().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketException e12) {
                e = e12;
                this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo != null ? this.Uc.tr().wo.vI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Uc.tq().Wa = -12;
                TiebaStatic.net(this.Uc);
                ai.cH(this.Uc.tp().ts().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketTimeoutException e13) {
                e = e13;
                this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo != null ? this.Uc.tr().wo.vI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Uc.tq().Wa = -13;
                TiebaStatic.net(this.Uc);
                ai.cH(this.Uc.tp().ts().mUrl);
                if (fVar != null) {
                }
                return bArr;
            }
        }
        if (fVar == null) {
            ai.cH(this.Uc.tp().ts().mUrl);
            return null;
        }
        this.Uc.tq().Wa = fVar.wm;
        if (this.Uc.tq().Wa != 200) {
            this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
            this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo == null ? -1 : this.Uc.tr().wo.vI);
            TiebaStatic.net(this.Uc);
            ai.cH(this.Uc.tp().ts().mUrl);
            return null;
        }
        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (str2 = fVar.wn) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > Uh) {
                    this.Uc.tq().Wa = -11;
                    TiebaStatic.net(this.Uc);
                    ai.cH(this.Uc.tp().ts().mUrl);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.e.zy().dE(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.Uc.tp().ts().mUrl + "], size:" + i2);
                            this.Uc.tq().Wa = -16;
                            TiebaStatic.net(this.Uc);
                            ai.cH(this.Uc.tp().ts().mUrl);
                            ai.cH(this.Uc.tp().ts().mUrl);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        am amVar = new am();
        amVar.mMode = getMode(com.baidu.adp.lib.util.k.iM());
        amVar.mSize = this.Uc.tr().wo.vF;
        amVar.mTime = new Date().getTime() - j;
        amVar.UK = this.Uc.tr().wo.vI;
        amVar.UJ = 2;
        al.a(amVar);
        al.UI.set(this.Uc.tr().wo.vI);
        TiebaStatic.net(this.Uc);
        ai.cH(this.Uc.tp().ts().mUrl);
        if (fVar != null) {
            this.Uc.tp().ts().Wt = fVar.charset;
            bArr = fVar.data;
        } else {
            bArr = null;
        }
        return bArr;
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
        OutOfMemoryError e;
        Exception e2;
        byte[] rP = rP();
        if (rP == null || this.Uc.tq().Wa != 200) {
            return null;
        }
        try {
            this.Uc.tp().ts().Wt = TextUtils.isEmpty(this.Uc.tp().ts().Wt) ? "UTF-8" : this.Uc.tp().ts().Wt;
            str = new String(rP, 0, rP.length, this.Uc.tp().ts().Wt);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            cF(str);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [636=12] */
    @Override // com.baidu.tbadk.core.util.s
    public String rO() {
        Throwable th;
        String str;
        SocketTimeoutException e;
        SocketException e2;
        OutOfMemoryError e3;
        Exception e4;
        BdHttpErrorException e5;
        BdHttpCancelException e6;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        try {
            int cG = ai.cG(this.Uc.tp().ts().mUrl);
            if (cG > 0) {
                ai.sE().bW(cG);
            }
        } catch (Exception e7) {
            BdLog.e(e7.getMessage());
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
        TbConfig.getDebugSwitch();
        try {
            try {
                if (this.Un.isCanceled()) {
                    ai.cH(this.Uc.tp().ts().mUrl);
                    return null;
                }
                com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.hu().a(this.Uc.tp().ts().mUrl, sb3.getBytes(), this.Uc.tp().ts().Wr, 5, -1, (com.baidu.adp.lib.network.willdelete.d) null, this.Un, sA());
                if (a == null) {
                    throw new BdHttpCancelException();
                }
                if (a.wo != null) {
                    this.Uc.tr().wo = a.wo;
                }
                this.Uc.tq().Wa = a.wm;
                this.Uc.tq().mHeader = a.mHeader;
                if (this.Uc.tq().Wa != 200) {
                    this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo == null ? -1 : this.Uc.tr().wo.vI);
                    TiebaStatic.net(this.Uc);
                    ai.cH(this.Uc.tp().ts().mUrl);
                    return null;
                } else if (this.Un.isCanceled()) {
                    ai.cH(this.Uc.tp().ts().mUrl);
                    return null;
                } else {
                    str = new String(a.data, "utf-8");
                    try {
                        if (this.Uc.tp().ts().mIsBaiduServer && this.Uc.tp().ts().Ws) {
                            cF(str);
                        }
                        am amVar = new am();
                        amVar.mMode = getMode(com.baidu.adp.lib.util.k.iM());
                        amVar.mSize = this.Uc.tr().wo.vF;
                        amVar.mTime = this.Uc.tr().wo.vJ;
                        amVar.UK = this.Uc.tr().wo.vI;
                        amVar.UJ = 1;
                        al.a(amVar);
                        al.UI.set(this.Uc.tr().wo.vI);
                        TiebaStatic.net(this.Uc);
                        return str;
                    } catch (BdHttpCancelException e8) {
                        e6 = e8;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo != null ? this.Uc.tr().wo.vI : -1) + "|" + e6.getClass() + "|" + e6.getMessage();
                        this.Uc.tq().Wa = -14;
                        return str;
                    } catch (BdHttpErrorException e9) {
                        e5 = e9;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo == null ? -1 : this.Uc.tr().wo.vI) + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.Uc.tq().Wa = e5.getHttpResponseCode();
                        TiebaStatic.net(this.Uc);
                        return str;
                    } catch (Exception e10) {
                        e4 = e10;
                        this.Uc.tq().Wa = -10;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.Uc);
                        return str;
                    } catch (OutOfMemoryError e11) {
                        e3 = e11;
                        this.Uc.tq().Wa = -15;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.memoryerror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.Uc);
                        return str;
                    } catch (SocketException e12) {
                        e2 = e12;
                        this.Uc.tq().Wa = -12;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.Uc);
                        return str;
                    } catch (SocketTimeoutException e13) {
                        e = e13;
                        this.Uc.tq().Wa = -13;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.Uc);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.Uc.tq().Wa = -10;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.Uc);
                        return str;
                    }
                }
            } finally {
                ai.cH(this.Uc.tp().ts().mUrl);
            }
        } catch (BdHttpCancelException e14) {
            e6 = e14;
            str = null;
        } catch (BdHttpErrorException e15) {
            e5 = e15;
            str = null;
        } catch (Exception e16) {
            e4 = e16;
            str = null;
        } catch (OutOfMemoryError e17) {
            e3 = e17;
            str = null;
        } catch (SocketException e18) {
            e2 = e18;
            str = null;
        } catch (SocketTimeoutException e19) {
            e = e19;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [740=9] */
    @Override // com.baidu.tbadk.core.util.s
    public String rR() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        BdHttpErrorException e3;
        BdHttpCancelException e4;
        try {
            try {
                if (this.Un.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.willdelete.f b = com.baidu.adp.lib.network.willdelete.e.hu().b(this.Uc.tp().ts().mUrl, this.Uc.tp().ts().Wr, this.Uc.tp().ts().Wp, this.Uc.tp().ts().Wq, 5, -1, null, this.Un, null, sA());
                this.Uc.tq().Wa = b.wm;
                this.Uc.tq().mHeader = b.mHeader;
                new Timer().schedule(new ag(this, null), 45000L);
                if (this.Uc.tq().Wa != 200) {
                    this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo == null ? -1 : this.Uc.tr().wo.vI);
                    TiebaStatic.net(this.Uc);
                    return null;
                } else if (this.Un.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(b.data, b.charset);
                    try {
                        cF(str);
                        TiebaStatic.net(this.Uc);
                        return str;
                    } catch (BdHttpCancelException e5) {
                        e4 = e5;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo != null ? this.Uc.tr().wo.vI : -1) + "|" + e4.getClass() + "|" + e4.getMessage();
                        this.Uc.tq().Wa = -14;
                        return str;
                    } catch (BdHttpErrorException e6) {
                        e3 = e6;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        this.Uc.tq().Wc = String.valueOf(String.valueOf(this.Uc.tq().Wa)) + "|retryCount:" + (this.Uc.tr().wo == null ? -1 : this.Uc.tr().wo.vI) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.Uc.tq().Wa = e3.getHttpResponseCode();
                        TiebaStatic.net(this.Uc);
                        return str;
                    } catch (SocketException e7) {
                        this.Uc.tq().Wa = -12;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        TiebaStatic.net(this.Uc);
                        return str;
                    } catch (SocketTimeoutException e8) {
                        this.Uc.tq().Wa = -13;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        TiebaStatic.net(this.Uc);
                        return str;
                    } catch (Exception e9) {
                        e2 = e9;
                        this.Uc.tq().Wa = -10;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.Uc);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e = e10;
                        this.Uc.tq().Wa = -15;
                        this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.Uc);
                        return str;
                    }
                }
            } finally {
                new Timer().schedule(new ag(this, null), 0L);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [836=5] */
    @Override // com.baidu.tbadk.core.util.s
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (this.Un.isCanceled()) {
                TiebaStatic.net(this.Uc);
                return false;
            }
            File file = z ? new File(str) : o.cp(str);
            return com.baidu.adp.lib.network.willdelete.e.hu().a(this.Uc.tp().ts().mUrl, file.getAbsolutePath(), false, i2, i3, -1, new af(this, handler, i, file.length()), this.Un, sA());
        } catch (Exception e) {
            this.Uc.tq().Wa = -10;
            this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.Uc.tq().Wa = -15;
            this.Uc.tq().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.Uc);
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

    private LinkedList<BasicNameValuePair> sA() {
        if (this.Uc != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.Uc.tp().ts().VX)) {
                linkedList.add(new BasicNameValuePair("sid", this.Uc.tp().ts().VX));
            }
            if (!TextUtils.isEmpty(this.Uc.tp().ts().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.Uc.tp().ts().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
