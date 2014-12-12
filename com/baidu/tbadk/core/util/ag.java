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
    private static int Iv = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    protected final com.baidu.adp.lib.network.willdelete.a IB = new com.baidu.adp.lib.network.willdelete.a();
    private final com.baidu.tbadk.core.util.httpNet.c Iq;
    private Context mContext;

    public ag(com.baidu.tbadk.core.util.httpNet.c cVar) {
        oV();
        this.mContext = TbadkCoreApplication.m255getInst().getApp();
        this.Iq = cVar;
        com.baidu.adp.lib.network.willdelete.e.dX().setUserAgent("bdtb for Android " + TbConfig.getVersion());
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

    private void oV() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.v
    public boolean ou() {
        return this.IB.isCanceled();
    }

    @Override // com.baidu.tbadk.core.util.v
    public void dL() {
        this.IB.cancel();
        try {
            int cC = al.cC(this.Iq.pV().pY().mUrl);
            if (cC > 0) {
                al.pl().o(cC, 1);
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [406=12] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0151  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x040d -> B:87:0x040e). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ow() {
        com.baidu.adp.lib.network.willdelete.f fVar;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.willdelete.e.dX().setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            int cC = al.cC(this.Iq.pV().pY().mUrl);
            if (cC > 0) {
                al.pl().bQ(cC);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            try {
                if (this.Iq.pV().pY().Kv == null || this.Iq.pV().pY().Kv.size() <= 0 || this.Iq.pV().mIsFromCDN) {
                    str = this.Iq.pV().pY().mUrl;
                } else {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.Iq.pV().pY().mUrl);
                    if (this.Iq.pV().pY().mUrl.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.Iq.pV().pY().mUrl.endsWith("?") && !this.Iq.pV().pY().mUrl.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i = 0; i < this.Iq.pV().pY().Kv.size(); i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(this.Iq.pV().pY().Kv.get(i).getName());
                        sb.append("=");
                        sb.append(ba.aE(this.Iq.pV().pY().Kv.get(i).getValue()));
                    }
                    str = sb.toString();
                }
                TbConfig.getDebugSwitch();
                if ((!this.Iq.pV().pY().Kx || this.Iq.pV().pY().mIsBDImage) && !this.Iq.pV().mIsFromCDN) {
                    z = false;
                }
            } finally {
                al.cD(this.Iq.pV().pY().mUrl);
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
        if (this.IB.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        fVar = com.baidu.adp.lib.network.willdelete.e.dX().a(str, z, 5, 100, -1, new ah(this), this.IB, ph());
        if (fVar != null) {
            try {
                if (fVar.kX != null) {
                    this.Iq.pX().kX = fVar.kX;
                }
            } catch (BdHttpCancelException e8) {
                e = e8;
                this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX != null ? this.Iq.pX().kX.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iq.pW().Ki = -14;
                al.cD(this.Iq.pV().pY().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (BdHttpErrorException e9) {
                e = e9;
                this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX != null ? this.Iq.pX().kX.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iq.pW().Ki = e.getHttpResponseCode();
                TiebaStatic.net(this.Iq);
                al.cD(this.Iq.pV().pY().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX != null ? this.Iq.pX().kX.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iq.pW().Ki = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Iq);
                al.cD(this.Iq.pV().pY().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (OutOfMemoryError e11) {
                e = e11;
                this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.memoryerror);
                this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX == null ? -1 : this.Iq.pX().kX.retry) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iq.pW().Ki = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Iq);
                al.cD(this.Iq.pV().pY().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketException e12) {
                e = e12;
                this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX != null ? this.Iq.pX().kX.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iq.pW().Ki = -12;
                TiebaStatic.net(this.Iq);
                al.cD(this.Iq.pV().pY().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketTimeoutException e13) {
                e = e13;
                this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX != null ? this.Iq.pX().kX.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iq.pW().Ki = -13;
                TiebaStatic.net(this.Iq);
                al.cD(this.Iq.pV().pY().mUrl);
                if (fVar != null) {
                }
                return bArr;
            }
        }
        if (fVar == null) {
            al.cD(this.Iq.pV().pY().mUrl);
            return null;
        }
        this.Iq.pW().Ki = fVar.kV;
        if (this.Iq.pW().Ki != 200) {
            this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
            this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX == null ? -1 : this.Iq.pX().kX.retry);
            TiebaStatic.net(this.Iq);
            al.cD(this.Iq.pV().pY().mUrl);
            return null;
        }
        if (TbadkCoreApplication.m255getInst().isMainProcess(true) && (str2 = fVar.kW) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > Iv) {
                    this.Iq.pW().Ki = -11;
                    TiebaStatic.net(this.Iq);
                    al.cD(this.Iq.pV().pY().mUrl);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.e.vL().dq(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.Iq.pV().pY().mUrl + "], size:" + i2);
                            this.Iq.pW().Ki = -16;
                            TiebaStatic.net(this.Iq);
                            al.cD(this.Iq.pV().pY().mUrl);
                            al.cD(this.Iq.pV().pY().mUrl);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ap apVar = new ap();
        apVar.mMode = getMode(com.baidu.adp.lib.util.i.fl());
        apVar.mSize = this.Iq.pX().kX.km;
        apVar.mTime = new Date().getTime() - j;
        apVar.IV = this.Iq.pX().kX.retry;
        apVar.IU = 2;
        ao.a(apVar);
        ao.IT.set(this.Iq.pX().kX.retry);
        TiebaStatic.net(this.Iq);
        al.cD(this.Iq.pV().pY().mUrl);
        if (fVar != null) {
            this.Iq.pV().pY().Kz = fVar.charset;
            bArr = fVar.data;
        } else {
            bArr = null;
        }
        return bArr;
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
        OutOfMemoryError e;
        Exception e2;
        byte[] ow = ow();
        if (ow == null || this.Iq.pW().Ki != 200) {
            return null;
        }
        try {
            this.Iq.pV().pY().Kz = TextUtils.isEmpty(this.Iq.pV().pY().Kz) ? "UTF-8" : this.Iq.pV().pY().Kz;
            str = new String(ow, 0, ow.length, this.Iq.pV().pY().Kz);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            cB(str);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [633=12] */
    @Override // com.baidu.tbadk.core.util.v
    public String ov() {
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
            int cC = al.cC(this.Iq.pV().pY().mUrl);
            if (cC > 0) {
                al.pl().bQ(cC);
            }
        } catch (Exception e7) {
            BdLog.e(e7.getMessage());
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
        TbConfig.getDebugSwitch();
        try {
            try {
                if (this.IB.isCanceled()) {
                    al.cD(this.Iq.pV().pY().mUrl);
                    return null;
                }
                com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.dX().a(this.Iq.pV().pY().mUrl, sb3.getBytes(), this.Iq.pV().pY().Kx, 5, -1, (com.baidu.adp.lib.network.willdelete.d) null, this.IB, ph());
                if (a == null) {
                    throw new BdHttpCancelException();
                }
                if (a.kX != null) {
                    this.Iq.pX().kX = a.kX;
                }
                this.Iq.pW().Ki = a.kV;
                if (this.Iq.pW().Ki != 200) {
                    this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX == null ? -1 : this.Iq.pX().kX.retry);
                    TiebaStatic.net(this.Iq);
                    al.cD(this.Iq.pV().pY().mUrl);
                    return null;
                } else if (this.IB.isCanceled()) {
                    al.cD(this.Iq.pV().pY().mUrl);
                    return null;
                } else {
                    str = new String(a.data, "utf-8");
                    try {
                        if (this.Iq.pV().pY().mIsBaiduServer && this.Iq.pV().pY().Ky) {
                            cB(str);
                        }
                        ap apVar = new ap();
                        apVar.mMode = getMode(com.baidu.adp.lib.util.i.fl());
                        apVar.mSize = this.Iq.pX().kX.km;
                        apVar.mTime = this.Iq.pX().kX.kq;
                        apVar.IV = this.Iq.pX().kX.retry;
                        apVar.IU = 1;
                        ao.a(apVar);
                        ao.IT.set(this.Iq.pX().kX.retry);
                        TiebaStatic.net(this.Iq);
                        return str;
                    } catch (BdHttpCancelException e8) {
                        e6 = e8;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX != null ? this.Iq.pX().kX.retry : -1) + "|" + e6.getClass() + "|" + e6.getMessage();
                        this.Iq.pW().Ki = -14;
                        return str;
                    } catch (BdHttpErrorException e9) {
                        e5 = e9;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX == null ? -1 : this.Iq.pX().kX.retry) + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.Iq.pW().Ki = e5.getHttpResponseCode();
                        TiebaStatic.net(this.Iq);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e = e10;
                        this.Iq.pW().Ki = -15;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.Iq);
                        return str;
                    } catch (SocketException e11) {
                        e4 = e11;
                        this.Iq.pW().Ki = -12;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.Iq);
                        return str;
                    } catch (SocketTimeoutException e12) {
                        e3 = e12;
                        this.Iq.pW().Ki = -13;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.Iq);
                        return str;
                    } catch (Exception e13) {
                        e2 = e13;
                        this.Iq.pW().Ki = -10;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.Iq);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.Iq.pW().Ki = -10;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.Iq);
                        return str;
                    }
                }
            } finally {
                al.cD(this.Iq.pV().pY().mUrl);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [736=9] */
    @Override // com.baidu.tbadk.core.util.v
    public String oy() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        BdHttpErrorException e3;
        BdHttpCancelException e4;
        try {
            try {
                if (this.IB.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.willdelete.f b = com.baidu.adp.lib.network.willdelete.e.dX().b(this.Iq.pV().pY().mUrl, this.Iq.pV().pY().Kx, this.Iq.pV().pY().Kv, this.Iq.pV().pY().Kw, 5, -1, null, this.IB, null, ph());
                this.Iq.pW().Ki = b.kV;
                new Timer().schedule(new aj(this, null), 45000L);
                if (this.Iq.pW().Ki != 200) {
                    this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX == null ? -1 : this.Iq.pX().kX.retry);
                    TiebaStatic.net(this.Iq);
                    return null;
                } else if (this.IB.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(b.data, b.charset);
                    try {
                        cB(str);
                        TiebaStatic.net(this.Iq);
                        return str;
                    } catch (BdHttpCancelException e5) {
                        e4 = e5;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX != null ? this.Iq.pX().kX.retry : -1) + "|" + e4.getClass() + "|" + e4.getMessage();
                        this.Iq.pW().Ki = -14;
                        return str;
                    } catch (BdHttpErrorException e6) {
                        e3 = e6;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        this.Iq.pW().Kk = String.valueOf(String.valueOf(this.Iq.pW().Ki)) + "|retryCount:" + (this.Iq.pX().kX == null ? -1 : this.Iq.pX().kX.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.Iq.pW().Ki = e3.getHttpResponseCode();
                        TiebaStatic.net(this.Iq);
                        return str;
                    } catch (OutOfMemoryError e7) {
                        e = e7;
                        this.Iq.pW().Ki = -15;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.Iq);
                        return str;
                    } catch (SocketException e8) {
                        this.Iq.pW().Ki = -12;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        TiebaStatic.net(this.Iq);
                        return str;
                    } catch (SocketTimeoutException e9) {
                        this.Iq.pW().Ki = -13;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        TiebaStatic.net(this.Iq);
                        return str;
                    } catch (Exception e10) {
                        e2 = e10;
                        this.Iq.pW().Ki = -10;
                        this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.Iq);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [817=5] */
    @Override // com.baidu.tbadk.core.util.v
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.IB.isCanceled()) {
                return com.baidu.adp.lib.network.willdelete.e.dX().a(this.Iq.pV().pY().mUrl, (z ? new File(str) : s.cm(str)).getAbsolutePath(), false, i2, i3, -1, new ai(this, handler, i), this.IB, ph());
            }
            TiebaStatic.net(this.Iq);
            return false;
        } catch (Exception e) {
            this.Iq.pW().Ki = -10;
            this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.Iq.pW().Ki = -15;
            this.Iq.pW().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.Iq);
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

    private LinkedList<BasicNameValuePair> ph() {
        if (this.Iq != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.Iq.pV().pY().Kf)) {
                linkedList.add(new BasicNameValuePair("sid", this.Iq.pV().pY().Kf));
            }
            if (!TextUtils.isEmpty(this.Iq.pV().pY().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.Iq.pV().pY().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
